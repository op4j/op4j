/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.op4j.operation;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.op4j.exceptions.OperationNotFoundException;
import org.op4j.exceptions.MultipleOperationImplementationsException;
import org.op4j.exceptions.OperationImplementationNotFoundException;
import org.op4j.exceptions.OperationImplementationRegistrationException;
import org.op4j.typescheme.TypeScheme;

/*
 * (non-javadoc)
 * 
 * This is the registry of operation implementations, a synchronized cache 
 * which ensures that only one object of each operation implementation 
 * exists in memory at a time.
 * 
 * This is not for saving CPU cycles (an aspect which would probably be more
 * efficient if new instances were created), but to avoid an excessive
 * memory usage under heavy processing load. 
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class OperationImplRegistry {
    
    private final Set<Class<? extends OperationImpl>> registeredOperationImplClasses =
        new HashSet<Class<? extends OperationImpl>>();
    
    private final Map<String,Set<OperationImpl>> operationImplsByOperationName =
        new HashMap<String,Set<OperationImpl>>();

    private final Map<String,OperationRegistryInfo> operationRegistryInfos =
        new HashMap<String,OperationRegistryInfo>();
    
    /*
     * Read/Write lock used for synchronization based on the fact that read
     * operations (getting operation implementations) are much more usual than
     * write (add operation implementation) ones.
     */
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = this.lock.readLock();
    private final Lock writeLock = this.lock.writeLock();
    
    
    private static final OperationImplRegistry instance = new OperationImplRegistry();
    
    
    static final OperationImplRegistry getInstance() {
        return instance;
    }

    
    private OperationImplRegistry() {
        super();
    }
    
    
    void addOperationImpl(final Class<? extends OperationImpl> operationImplClass) {
        
        this.writeLock.lock();
        
        try {
            
            // If the operation implementation class has already been registered, ignore the request
            if (this.registeredOperationImplClasses.contains(operationImplClass)) {
                return;
            }
            
            // Create the implementation instance
            final OperationImpl operationImpl = operationImplClass.newInstance();
            
            final String operationName = operationImpl.getOperationName();
            Set<OperationImpl> operationImpls = 
                this.operationImplsByOperationName.get(operationName);
            OperationRegistryInfo operationRegistryInfo = 
                this.operationRegistryInfos.get(operationName);
            
            if (operationImpls == null) {
                
                operationImpls = new HashSet<OperationImpl>();
                this.operationImplsByOperationName.put(operationName, operationImpls);
                
                operationRegistryInfo = 
                    new OperationRegistryInfo(operationName, 
                        operationImpl.getResultTypeScheme()); 
                this.operationRegistryInfos.put(operationName, operationRegistryInfo);
                
            }
            
            if (operationImpls.size() > 0) {
                // We check the first position to see if result typeschemes equal
                final OperationImpl checkedImpl = operationImpls.iterator().next();
                if (!checkedImpl.getResultTypeScheme().equals(
                        operationImpl.getResultTypeScheme())) {
                    throw new OperationImplementationRegistrationException(
                            "Operation implementation returns " + 
                            operationImpl.getResultTypeScheme() + ", " +
                            "but operation \"" + operationName + "\" is registered " +
                            "to return " + checkedImpl.getResultTypeScheme());
                }
            }
            
            // Add matched argument type schemes to operation info registry
            operationRegistryInfo.addMatchedArgumentTypeSchemes(
                    operationImpl.getClass().getName(),
                    operationImpl.getMatchedArgumentTypeSchemes());
            
            // Add the implementation to the registry of operation implementations
            operationImpls.add(operationImpl);
    
            // Add the class to the registry of operation implementation classes
            this.registeredOperationImplClasses.add(operationImplClass);
            
        } catch (InstantiationException e) {
            throw new OperationImplementationRegistrationException(e);
        } catch (IllegalAccessException e) {
            throw new OperationImplementationRegistrationException(e);
        } finally {
            this.writeLock.unlock();
        }
        
    }

    
    OperationImpl getOperationImpl(
            final String operationName, final Arguments arguments) {


        this.readLock.lock();
        
        try {
          
            
            final Set<OperationImpl> operationImpls = 
                    this.operationImplsByOperationName.get(operationName);
            if ((operationImpls == null) || (operationImpls.size() == 0)) {
                throw new OperationNotFoundException(operationName);
            }
            
            OperationImpl foundImpl = null;
            for (OperationImpl operationImpl : operationImpls) {
                final Set<ArgumentsTypeScheme> operationImplTypeSchemes = 
                    operationImpl.getMatchedArgumentTypeSchemes();
                for (ArgumentsTypeScheme operationImplTypeScheme : operationImplTypeSchemes) {
                    if (operationImplTypeScheme.matches(arguments)) {
                        if (foundImpl == null) {
                            foundImpl = operationImpl;
                        } else if (foundImpl != operationImpl) {
                            final OperationRegistryInfo operationRegistryInfo = 
                                this.operationRegistryInfos.get(operationName);
                            final OperationInfo operationInfo = new OperationInfo(operationRegistryInfo);
                            throw new MultipleOperationImplementationsException(operationInfo, arguments);
                        }
                    }
                }
            }

            if (foundImpl == null) {
                final OperationRegistryInfo operationRegistryInfo = 
                    this.operationRegistryInfos.get(operationName);
                final OperationInfo operationInfo = new OperationInfo(operationRegistryInfo);
                throw new OperationImplementationNotFoundException(operationInfo, arguments);
            }
            
            return foundImpl;

            
        } finally {
            this.readLock.unlock();
        }

    }
    
    
    
    TypeScheme getResultTypeScheme(final String operationName) {
        
        this.readLock.lock();
        
        try {
            
            final OperationRegistryInfo operationRegistryInfo = 
                this.operationRegistryInfos.get(operationName);

            if (operationRegistryInfo == null) {
                throw new OperationNotFoundException(operationName);
            }
            
            return operationRegistryInfo.getResultTypeScheme();
            
        } finally {
            this.readLock.unlock();
        }
        
    }

    
    OperationInfo getOperationInfo(final String operationName) {
        this.readLock.lock();
        try {
            final OperationRegistryInfo operationRegistryInfo = 
                this.operationRegistryInfos.get(operationName);
            if (operationRegistryInfo == null) {
                return null;
            }
            return new OperationInfo(operationRegistryInfo);
        } finally {
            this.readLock.unlock();
        }
    }
    
    
    Set<OperationInfo> getAllOperationsInfo() {
        this.readLock.lock();
        try {
            final Set<OperationInfo> operationsInfo = new HashSet<OperationInfo>();
            for (OperationRegistryInfo operationRegistryInfo : this.operationRegistryInfos.values()) {
                operationsInfo.add(new OperationInfo(operationRegistryInfo));
            }
            return Collections.unmodifiableSet(operationsInfo);
        } finally {
            this.readLock.unlock();
        }
    }
    
}

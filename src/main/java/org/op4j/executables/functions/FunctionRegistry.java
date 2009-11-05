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
package org.op4j.executables.functions;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.op4j.exceptions.FunctionImplementationRegistrationException;
import org.op4j.exceptions.MultipleOperationImplementationsException;
import org.op4j.exceptions.OperationImplementationNotFoundException;
import org.op4j.exceptions.OperationImplementationRegistrationException;
import org.op4j.exceptions.OperationNotFoundException;
import org.op4j.type.Type;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class FunctionRegistry {
    
    private final Map<String,Function<?,?>> functionsByName = new HashMap<String,Function<?,?>>();
    private final Set<Class<?>> functionImplementationClasses = new HashSet<Class<?>>();
    
    /*
     * Read/Write lock used for synchronization based on the fact that read
     * operations (getting operation implementations) are much more usual than
     * write (add operation implementation) ones.
     */
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = this.lock.readLock();
    private final Lock writeLock = this.lock.writeLock();
    
    
    private static final FunctionRegistry instance = new FunctionRegistry();
    
    
    static final FunctionRegistry getInstance() {
        return instance;
    }

    
    private FunctionRegistry() {
        super();
    }
    
    
    <X,T> void addFunctionImplementation(final Class<? extends FunctionImplementation<X,T>> functionImplementationClass) {
        
        this.writeLock.lock();
        
        try {
            
            // If the implementation class has already been registered, ignore the request
            if (this.functionImplementationClasses.contains(functionImplementationClass)) {
                return;
            }
            
            // Create the implementation instance
            final FunctionImplementation<X,T> functionImpl = functionImplementationClass.newInstance();
            
            final String functionName = functionImpl.getFunctionName();
            final Function<?,?> function = this.functionsByName.get(functionName);
            
            if (function == null) {
                this.functionsByName.put(functionName, new Function<X,T>(functionImpl));
            }
    
            // Add the class to the registry of implementation classes
            this.functionImplementationClasses.add(functionImplementationClass);
            
        } catch (InstantiationException e) {
            throw new FunctionImplementationRegistrationException(functionImplementationClass, 
                    "Class must be publicly instantiable and have a no-arg constructor", e);
        } catch (IllegalAccessException e) {
            throw new FunctionImplementationRegistrationException(functionImplementationClass, e);
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
    
    
    
    Type getResultType(final String operationName) {
        
        this.readLock.lock();
        
        try {
            
            final OperationRegistryInfo operationRegistryInfo = 
                this.operationRegistryInfos.get(operationName);

            if (operationRegistryInfo == null) {
                throw new OperationNotFoundException(operationName);
            }
            
            return operationRegistryInfo.getResultType();
            
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

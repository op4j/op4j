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
import org.op4j.exceptions.FunctionNotFoundException;

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
    
    
    @SuppressWarnings("unchecked")
    void addFunctionImplementation(final Class<? extends FunctionImplementation<?,?>> functionImplementationClass) {
        
        this.writeLock.lock();
        
        try {
            
            // If the implementation class has already been registered, ignore the request
            if (this.functionImplementationClasses.contains(functionImplementationClass)) {
                return;
            }
            
            // Create the implementation instance
            final FunctionImplementation<?,?> functionImpl = functionImplementationClass.newInstance();
            
            final String functionName = functionImpl.getFunctionName();
            final Function<?,?> function = this.functionsByName.get(functionName);
            
            if (function == null) {
                this.functionsByName.put(
                        functionName, 
                        new Function<Object,Object>((FunctionImplementation<Object, Object>) functionImpl));
            } else {
                function.addFunctionImplementation(functionImpl);
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

    
    Function<?,?> getFunction(final String functionName) {


        this.readLock.lock();
        
        try {
          
            final Function<?,?> function = 
                this.functionsByName.get(functionName);
            if (function == null) {
                throw new FunctionNotFoundException(functionName);
            }
            
            return function;
            
        } finally {
            this.readLock.unlock();
        }

    }
    
    
    Set<Function<?,?>> getAllFunctions() {
        this.readLock.lock();
        try {
            return Collections.unmodifiableSet(new HashSet<Function<?,?>>(this.functionsByName.values()));
        } finally {
            this.readLock.unlock();
        }
    }
    
}

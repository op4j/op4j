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
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.op4j.exceptions.FunctionImplementationRegistrationException;
import org.op4j.exceptions.OperationExecutionException;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Function<X,T>  {

    private final FunctionSignature<X,T> signature;
    private final Set<FunctionImplementation<X,T>> implementations;
    private final Set<Class<?>> implementationClasses;
    private final Map<FunctionArgumentScheme<? extends T>, FunctionImplementation<X,T>> implementationsByArgumentSchemes;
    
    
    protected Function(final FunctionImplementation<X,T> functionImplementation) {
        
        super();
        
        this.signature = functionImplementation.getFunctionSignature();
        this.implementations = new LinkedHashSet<FunctionImplementation<X,T>>();
        this.implementationClasses = new LinkedHashSet<Class<?>>();
        this.implementationsByArgumentSchemes = new LinkedHashMap<FunctionArgumentScheme<? extends T>, FunctionImplementation<X,T>>();
        
        addFunctionImplementation(functionImplementation);
    }
    
    
    public final String getFunctionName() {
        return this.signature.getFunctionName();
    }
    
    
    public final Type<X> getResultType() {
        return this.signature.getResultType();
    }
    
    public final Type<T> getTargetType() {
        return this.signature.getTargetType();
    }
    
    
    
    public final Set<FunctionArgumentScheme<? extends T>> getMatchedArgumentTypeSchemes() {
        return Collections.unmodifiableSet(this.implementationsByArgumentSchemes.keySet());
    }
    
    public final Set<FunctionImplementation<X,T>> getFunctionImplementations() {
        return Collections.unmodifiableSet(this.implementations);
    }
    
    public final Set<Class<?>> getFunctionImplementationClasses() {
        return Collections.unmodifiableSet(this.implementationClasses);
    }
    
    
    public final synchronized void addFunctionImplementation(final FunctionImplementation<X,T> functionImplementation) {
        
        Validate.notNull(functionImplementation, "Function implementation cannot be null");
        
        if (!functionImplementation.getFunctionSignature().equals(this.signature)) {
            throw new FunctionImplementationRegistrationException(
                    functionImplementation.getClass(), "Signature " +  this.signature + " was expected, but implementation returned " +
                    functionImplementation.getFunctionSignature());
        }
        
        if (this.implementationClasses.contains(functionImplementation.getClass())) {
            throw new FunctionImplementationRegistrationException(
                    functionImplementation.getClass(), "Class " +  functionImplementation.getClass() + " was already registered for " +
                    "function " + this.signature);
        }
        
        this.implementations.add(functionImplementation);
        this.implementationClasses.add(functionImplementation.getClass());
        
        for (final FunctionArgumentScheme<? extends T> argumentScheme : functionImplementation.getMatchedArgumentTypeSchemes()) {
            
            if (this.implementationsByArgumentSchemes.containsKey(argumentScheme)) {
                if (this.implementationClasses.contains(functionImplementation.getClass())) {
                    throw new FunctionImplementationRegistrationException(
                            functionImplementation.getClass(), "Class " +  functionImplementation.getClass() + " tried to register " +
                            "argument scheme " + argumentScheme + ", but that was already registered for function " + 
                            this.signature);
                }
            }
            
            this.implementationsByArgumentSchemes.put(argumentScheme, functionImplementation);
            
        }
    }
    
    


	public final X executeFunction(final FunctionArguments arguments) {
        
        Validate.notNull(arguments, "Operation arguments cannot be null");
        
        FunctionImplementation<X,T> functionImplementation = null;
        for (FunctionArgumentScheme<? extends T> matchingTypeScheme : this.implementationsByArgumentSchemes.keySet()) {
            if (matchingTypeScheme.match(arguments)) {
                if (functionImplementation != null) {
                    functionImplementation = this.implementationsByArgumentSchemes.get(matchingTypeScheme);
                } else {
                    throw new IllegalArgumentException(
                            "Invalid arguments. More than one function implementation matches arguments " + arguments);
                }
            }
        }
        if (functionImplementation == null) {
            throw new IllegalArgumentException(
                    "Invalid arguments. Valid schemes are: " +
                    this.implementationsByArgumentSchemes.keySet());
        }

        try {
            return functionImplementation.execute(arguments);
        } catch (OperationExecutionException e) {
            throw e;
        } catch (Exception e) {
            throw new OperationExecutionException(
                "Exception executing operation \"" + getFunctionName() +"\"", e);
        }
        
    }
    
        
}

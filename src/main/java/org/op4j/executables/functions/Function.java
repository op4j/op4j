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
import org.op4j.exceptions.FunctionExecutionException;
import org.op4j.exceptions.FunctionImplementationRegistrationException;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Function<X,T>  {

    private final String functionName;
    private final Type<? super X> resultType;
    private final Type<? super T> targetType;
    private final Set<FunctionImplementation<? super X,? super T>> implementations;
    private final Set<Class<?>> implementationClasses;
    private final Map<FunctionArgumentScheme, FunctionImplementation<X,T>> implementationsByArgumentSchemes;
    
    
    protected Function(final FunctionImplementation<X,T> functionImplementation) {
        
        super();
        
        this.functionName = functionImplementation.getFunctionName();
        this.resultType = functionImplementation.getResultType();
        this.targetType = functionImplementation.getTargetType();
        this.implementations = new LinkedHashSet<FunctionImplementation<? super X,? super T>>();
        this.implementationClasses = new LinkedHashSet<Class<?>>();
        this.implementationsByArgumentSchemes = new LinkedHashMap<FunctionArgumentScheme, FunctionImplementation<X,T>>();
        
        addFunctionImplementation(functionImplementation);
    }
    
    
    public final String getFunctionName() {
        return this.functionName;
    }
    
    
    public final Type<? super X> getResultType() {
        return this.resultType;
    }
    
    public final Type<? super T> getTargetType() {
        return this.targetType;
    }
    
    
    
    public final Set<FunctionArgumentScheme> getMatchedArgumentTypeSchemes() {
        return Collections.unmodifiableSet(this.implementationsByArgumentSchemes.keySet());
    }
    
    public final Set<FunctionImplementation<? super X,? super T>> getFunctionImplementations() {
        return Collections.unmodifiableSet(this.implementations);
    }
    
    public final Set<Class<?>> getFunctionImplementationClasses() {
        return Collections.unmodifiableSet(this.implementationClasses);
    }
    
    
    @SuppressWarnings("unchecked")
    public final synchronized void addFunctionImplementation(final FunctionImplementation<?,?> functionImplementation) {
        
        Validate.notNull(functionImplementation, "Function implementation cannot be null");
        
        if (!functionImplementation.getFunctionName().equals(this.functionName) ||
        		!functionImplementation.getResultType().equals(this.resultType)) {
            throw new FunctionImplementationRegistrationException(
                    functionImplementation.getClass(), "Not compatible implementation: " +
            		"Function name " +  this.functionName + " and a result type compatible with " +
            		this.resultType + " were expected, but implementation declares name " +
                    functionImplementation.getFunctionName() + " and result type " +
                    functionImplementation.getResultType());
        }
        
        if (this.implementationClasses.contains(functionImplementation.getClass())) {
            throw new FunctionImplementationRegistrationException(
                    functionImplementation.getClass(), "Class " +  functionImplementation.getClass() + " was already registered for " +
                    "function " + this.functionName);
        }
        
        final FunctionImplementation<X,T> newFunctionImplementation =
            (FunctionImplementation<X,T>) functionImplementation;
        
        this.implementations.add(newFunctionImplementation);
        this.implementationClasses.add(newFunctionImplementation.getClass());
        
        for (final FunctionArgumentScheme argumentScheme : newFunctionImplementation.getMatchedArgumentTypeSchemes()) {

            if (this.implementationsByArgumentSchemes.containsKey(argumentScheme)) {
                if (this.implementationClasses.contains(newFunctionImplementation.getClass())) {
                    throw new FunctionImplementationRegistrationException(
                            newFunctionImplementation.getClass(), "Class " +  newFunctionImplementation.getClass() + " tried to register " +
                            "argument scheme " + argumentScheme + ", but that was already registered for function " + 
                            this.functionName);
                }
            }
            
            this.implementationsByArgumentSchemes.put(argumentScheme, newFunctionImplementation);
            
        }
    }
    
    


	public final X executeFunction(final FunctionArguments arguments) {
        
        Validate.notNull(arguments, "Operation arguments cannot be null");
        
        FunctionImplementation<X,T> functionImplementation = null;
        for (FunctionArgumentScheme matchingTypeScheme : this.implementationsByArgumentSchemes.keySet()) {
            if (matchingTypeScheme.matches(arguments)) {
            	final FunctionImplementation<X,T> currentFunctionImplementation = 
            		this.implementationsByArgumentSchemes.get(matchingTypeScheme);
                if (functionImplementation == null) {
                    functionImplementation = currentFunctionImplementation;
                } else if (functionImplementation != currentFunctionImplementation){
                    throw new IllegalArgumentException(
                            "Invalid arguments. More than one function matching scheme matches arguments " + arguments);
                }
            }
        }
        if (functionImplementation == null) {
            throw new IllegalArgumentException(
                    "Invalid arguments (" + arguments.getStringRepresentation() +"). Valid schemes are: " +
                    this.implementationsByArgumentSchemes.keySet());
        }

        try {
            return functionImplementation.execute(arguments);
        } catch (FunctionExecutionException e) {
            throw e;
        } catch (Exception e) {
            throw new FunctionExecutionException(
                "Exception executing operation \"" + getFunctionName() +"\"", e);
        }
        
    }
    
        
}

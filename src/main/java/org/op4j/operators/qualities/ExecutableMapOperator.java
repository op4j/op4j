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
package org.op4j.operators.qualities;

import java.util.Map;

import org.op4j.functions.IFunction;




/**
 * <p>
 * This interface contains methods for executing functions on operators with
 * map target objects.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableMapOperator<K,V> {

    
    /**
     * <p>
     * Executes the specified function on the target object, creating a new operator
     * containing the result of the execution.
     * </p>
     * <p>
     * This function must be able to take as input an object of the current operator's
     * target type, and will return an object of a different type but same structure, 
     * which will be from then on the new operator's target type.
     * </p>
     * 
     * @param <X> the type of the resulting keys
     * @param <Y> the type of the resulting values
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X,Y> ExecutableMapOperator<X,Y> execAsMap(final IFunction<? extends Map<X,Y>, ? super Map<K,V>> function);
    
    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsMap(IFunction)} but only
     * on non-null elements, leaving null elements untouched.
     * </p>
     *
     * @param <X> the type of the resulting keys
     * @param <Y> the type of the resulting values
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X,Y> ExecutableMapOperator<X,Y> execIfNotNullAsMap(final IFunction<? extends Map<X,Y>,? super Map<K,V>> function);


    
    /**
     * <p>
     * Executes the specified function on the target object, creating a new operator
     * containing the result of the execution and setting the new operator type to the one
     * specified.
     * </p>
     * 
     * @param <X> the type of the result object
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X> Operator exec(final IFunction<X, ? super Map<K,V>> function);
    

    /**
     * <p>
     * Executes a function in a way equivalent to {@link #exec(IFunction)} but only
     * on non-null elements, leaving null elements untouched.
     * </p>
     *
     * @param <X> the type of the result object
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X> Operator execIfNotNull(final IFunction<X,? super Map<K,V>> function);
    
    
}

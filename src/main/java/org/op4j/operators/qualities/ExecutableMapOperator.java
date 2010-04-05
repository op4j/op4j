/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
     * Executes the specified function on the target map, creating a new map operator
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
    public <X,Y> ExecutableMapOperator<X,Y> execAsMap(final IFunction<? super Map<K,V>,? extends Map<X,Y>> function);


    
    /**
     * <p>
     * Executes the specified function on the target object, creating a new generic operator
     * containing the result of the execution and setting the new operator type to the one
     * specified.
     * </p>
     * 
     * @param <X> the type of the result object
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X> Operator exec(final IFunction<? super Map<K,V>,X> function);
    
    
    
    
    
    
    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsMap(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableMapOperator<K,V> execIfNotNullAsMap(final IFunction<? super Map<K,V>,? extends Map<? extends K,? extends V>> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsMap(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableMapOperator<K,V> execIfNullAsMap(final IFunction<? super Map<K,V>,? extends Map<? extends K,? extends V>> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsMap(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableMapOperator<K,V> execIfTrueAsMap(final IFunction<? super Map<K,V>, Boolean> eval, final IFunction<? super Map<K,V>,? extends Map<? extends K,? extends V>> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsMap(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableMapOperator<K,V> execIfFalseAsMap(final IFunction<? super Map<K,V>, Boolean> eval, final IFunction<? super Map<K,V>,? extends Map<? extends K,? extends V>> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsMap(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param <X> the new type of the keys returned by the functions
     * @param <Y> the new type of the values returned by the functions
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X,Y> ExecutableMapOperator<X,Y> execIfNotNullAsMap(final IFunction<? super Map<K,V>,? extends Map<X,Y>> function, final IFunction<? super Map<K,V>,? extends Map<X,Y>> elseFunction);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsMap(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param <X> the new type of the keys returned by the functions
     * @param <Y> the new type of the values returned by the functions
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X,Y> ExecutableMapOperator<X,Y> execIfNullAsMap(final IFunction<? super Map<K,V>,? extends Map<X,Y>> function, final IFunction<? super Map<K,V>,? extends Map<X,Y>> elseFunction);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsMap(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param <X> the new type of the keys returned by the functions
     * @param <Y> the new type of the values returned by the functions
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X,Y> ExecutableMapOperator<X,Y> execIfTrueAsMap(final IFunction<? super Map<K,V>, Boolean> eval, final IFunction<? super Map<K,V>,? extends Map<X,Y>> function, final IFunction<? super Map<K,V>,? extends Map<X,Y>> elseFunction);


    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsMap(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     * 
     * @param <X> the new type of the keys returned by the functions
     * @param <Y> the new type of the values returned by the functions
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X,Y> ExecutableMapOperator<X,Y> execIfFalseAsMap(final IFunction<? super Map<K,V>, Boolean> eval, final IFunction<? super Map<K,V>,? extends Map<X,Y>> function, final IFunction<? super Map<K,V>,? extends Map<X,Y>> elseFunction);


    
}

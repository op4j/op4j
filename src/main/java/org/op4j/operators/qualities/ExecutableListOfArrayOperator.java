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

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;




/**
 * <p>
 * This interface contains methods for executing functions on operators with
 * list of array target objects.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableListOfArrayOperator<T> {


    /**
     * <p>
     * Executes the specified function on the target object, creating a new operator
     * containing the result of the execution.
     * </p>
     * <p>
     * This function must be able to take as input an object of the current operator's
     * target type, and will return an object of same type and structure. 
     * </p>
     * 
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public ExecutableListOfArrayOperator<T> execAsListOfArray(final IFunction<? extends List<? extends T[]>, ? super List<T[]>> function);
    
    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsListOfArray(IFunction)} but only
     * on non-null elements, leaving null elements untouched.
     * </p>
     * 
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public ExecutableListOfArrayOperator<T> execIfNotNullAsListOfArray(final IFunction<? extends List<? extends T[]>,? super List<T[]>> function);



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
     * @param <X> the type of the result elements
     * @param type the new type for the operator
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X> ExecutableListOfArrayOperator<X> execAsListOfArrayOf(final Type<X> type, final IFunction<? extends List<X[]>, ? super List<T[]>> function);
    
    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsListOfArrayOf(Type, IFunction)} but only
     * on non-null elements, leaving null elements untouched.
     * </p>
     * 
     * @param <X> the type of the result elements
     * @param type the new type for the operator
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X> ExecutableListOfArrayOperator<X> execIfNotNullAsListOfArrayOf(final Type<X> type, final IFunction<? extends List<X[]>,? super List<T[]>> function);


    
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
    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super List<T[]>> function);
    
    
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
    public <X> Level0GenericUniqOperator<X> execIfNotNull(final IFunction<X,? super List<T[]>> function);

    
    
    
    /**
     * <p>
     * Executes the specified function on each of the elements of each of the element structures, 
     * creating a new operator containing the result of all the executions and setting the new 
     * operator type to the one specified.
     * </p>
     * <p>
     * This method is equivalent to <tt>forEach().forEach().exec(type, function).endFor().endFor()</tt>.
     * </p>
     * 
     * @param <X> the type of the result elements
     * @param type the new type for the operator
     * @param function the function to be executed
     * @return an operator on the results of function execution on each element
     */
    public <X> ExecutableListOfArrayOperator<X> mapMap(final Type<X> type, final IFunction<X,? super T> function);

    
    
    /**
     * <p>
     * Executes the specified function on each of the elements of each of the element structures, 
     * creating a new operator containing the result of all the executions but not changing the 
     * operator type. The specified function will have to return results compatible with the 
     * current operator type.
     * </p>
     * <p>
     * This method is equivalent to <tt>forEach().forEach().exec(function).endFor().endFor()</tt>.
     * </p>
     * 
     * @param function the function to be executed
     * @return an operator on the results of function execution on each element
     */
    public ExecutableListOfArrayOperator<T> mapMap(final IFunction<? extends T,? super T> function);
    
}

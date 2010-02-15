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

import org.op4j.functions.IFunction;




/**
 * <p>
 * This interface contains methods for executing functions on operators with
 * list of list target objects on which a selection ("if") has already been done.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableListOfListSelectedOperator<T> {

    
    /**
     * <p>
     * Executes the specified function on the target object, creating a new operator
     * containing the result of the execution.
     * </p>
     * <p>
     * This function does not allow the operator target type to change because a selection ("if") has 
     * already been done on the target objects, and this would render the operator inconsistent
     * (some objects would belong to a type and others to another type).
     * </p>
     * 
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public ExecutableListOfListSelectedOperator<T> execAsListOfList(final IFunction<? extends List<? extends List<? extends T>>, ? super List<List<T>>> function);
    
    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsListOfList(IFunction)} but only
     * on non-null elements, leaving null elements untouched.
     * </p>
     * 
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public ExecutableListOfListSelectedOperator<T> execIfNotNullAsListOfList(final IFunction<? extends List<? extends List<? extends T>>,? super List<List<T>>> function);

 
    
    
    /**
     * <p>
     * Executes the specified function on each of the elements, creating a new operator
     * containing the result of all the executions.
     * </p>
     * <p>
     * This function does not allow the operator target type to change because a selection ("if") has 
     * already been done on the target objects, and this would render the operator inconsistent
     * (some objects would belong to a type and others to another type).
     * </p>
     * <p>
     * This method is equivalent to <tt>forEach().forEach().exec(function).endFor().endFor()</tt>.
     * </p>
     * 
     * @param function the function to be executed
     * @return an operator on the results of function execution on each element
     */
    public ExecutableListOfListSelectedOperator<T> mapMap(final IFunction<? extends T,? super T> function);
    
    
}

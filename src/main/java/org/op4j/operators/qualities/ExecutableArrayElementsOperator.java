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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;




/**
 * <p>
 * This interface contains methods for executing functions.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableArrayElementsOperator<T> {

    
    /**
     * <p>
     * Executes the specified function on the target object, creating a new operator
     * containing the result of the execution as a new array.
     * </p>
     * <p>
     * This function must be able to take as input an object of type T (the current operator's
     * target type) and will return another object of type T.
     * </p>
     * 
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public ExecutableArrayElementsOperator<T> exec(final IFunction<? super T,? extends T> function);
    
    
    /**
     * <p>
     * Executes the specified function on the target object, creating a new array
     * containing the result of the execution.
     * </p>
     * <p>
     * This function must be able to take as input an object of type T (the current operator's
     * target type) and will return an object of type X, which will be from then on the new
     * operator's target type.
     * </p>
     * 
     * @param <X> the type of the result, and new type for the operator
     * @param type the type returned by the function
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayElementsOperator<X> exec(final Type<X> type, final IFunction<? super T,X> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #exec(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param indexes the iteration indexes that will be selected
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableArrayElementsOperator<T> execIfIndex(final int[] indexes, final IFunction<? super T,? extends T> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #exec(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param indexes the iteration indexes that will not be selected
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableArrayElementsOperator<T> execIfIndexNot(final int[] indexes, final IFunction<? super T,? extends T> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #exec(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableArrayElementsOperator<T> execIfNotNull(final IFunction<? super T,? extends T> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #exec(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableArrayElementsOperator<T> execIfNull(final IFunction<? super T,? extends T> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #exec(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableArrayElementsOperator<T> execIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T,? extends T> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #exec(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableArrayElementsOperator<T> execIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T,? extends T> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #exec(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param <X> the new type returned by the functions
     * @param type the new type returned by the functions
     * @param indexes the iteration indexes that will be selected
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayElementsOperator<X> execIfIndex(final Type<X> type, final int[] indexes, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #exec(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param <X> the new type returned by the functions
     * @param type the new type returned by the functions
     * @param indexes the iteration indexes that will not be selected
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayElementsOperator<X> execIfIndexNot(final Type<X> type, final int[] indexes, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #exec(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param <X> the new type returned by the functions
     * @param type the new type returned by the functions
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayElementsOperator<X> execIfNotNull(final Type<X> type, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #exec(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param <X> the new type returned by the functions
     * @param type the new type returned by the functions
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayElementsOperator<X> execIfNull(final Type<X> type, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #exec(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param <X> the new type returned by the functions
     * @param type the new type returned by the functions
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayElementsOperator<X> execIfTrue(final Type<X> type, final IFunction<? super T, Boolean> eval, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);


    /**
     * <p>
     * Executes a function in a way equivalent to {@link #exec(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     * 
     * @param <X> the new type returned by the functions
     * @param type the new type returned by the functions
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayElementsOperator<X> execIfFalse(final Type<X> type, final IFunction<? super T, Boolean> eval, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);

    
}

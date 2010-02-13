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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;




/**
 * <p>
 * This interface contains methods for executing functions on operators with
 * array target objects as their second-level structures.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableArrayOfArrayElementsOperator<T> {


    /**
     * <p>
     * Executes the specified function on the target object, creating a new operator
     * containing the result of the execution.
     * </p>
     * <p>
     * This function must be able to take as input an object of the current operator's
     * target type, and will return an object of the same type and same structure.
     * </p>
     * 
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public ExecutableArrayOfArrayElementsOperator<T> execAsArray(final IFunction<? extends T[], ? super T[]> function);
    
    
    /**
     * <p>
     * Specialisation of the {@link #execAsArray(IFunction)} method which executes a function
     * implementing the {@link IEvaluator} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #execAsArray(IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     * 
     * @param eval the evaluator to be executed
     * @return an operator on the results of evaluator execution
     */
    public ExecutableArrayOfArrayElementsOperator<T> evalAsArray(final IEvaluator<? extends T[],? super T[]> eval);
    
    
    /**
     * <p>
     * Specialisation of the {@link #execAsArray(IFunction)} method which executes a function
     * implementing the {@link IConverter} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #execAsArray(IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     * 
     * @param converter the converter to be executed
     * @return an operator on the results of converter execution
     */
    public ExecutableArrayOfArrayElementsOperator<T> convertAsArray(final IConverter<? extends T[],? super T[]> converter);



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
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayOfArrayElementsOperator<X> execAsArrayOf(final Type<X> type, final IFunction<X[], ? super T[]> function);
    
    
    /**
     * <p>
     * Specialisation of the {@link #execAsArrayOf(Type, IFunction)} method which executes a function
     * implementing the {@link IEvaluator} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #execAsArrayOf(Type, IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     * 
     * @param <X> the type of the result elements
     * @param eval the evaluator to be executed
     * @return an operator on the results of evaluator execution
     */
    public <X> ExecutableArrayOfArrayElementsOperator<X> evalAsArrayOf(final Type<X> type, final IEvaluator<X[],? super T[]> eval);
    
    
    /**
     * <p>
     * Specialisation of the {@link #execAsArrayOf(Type, IFunction)} method which executes a function
     * implementing the {@link IConverter} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #execAsArrayOf(Type, IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     * 
     * @param <X> the type of the result elements
     * @param converter the converter to be executed
     * @return an operator on the results of converter execution
     */
    public <X> ExecutableArrayOfArrayElementsOperator<X> convertAsArrayOf(final Type<X> type, final IConverter<X[],? super T[]> converter);
    
    
    /**
     * <p>
     * Executes the specified function on the target object, creating a new operator
     * containing the result of the execution and setting the new operator type to the one
     * specified.
     * </p>
     * 
     * @param <X> the type of the result object
     * @param resultType the new type for the operator
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X> Level1ArrayElementsOperator<X> exec(final Type<X> resultType, final IFunction<X, ? super T[]> function);
    
    
    /**
     * <p>
     * Specialisation of the {@link #exec(Type,IFunction)} method which executes a function
     * implementing the {@link IEvaluator} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #exec(Type,IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     *
     * @param <X> the type of the result object
     * @param resultType the new type for the operator
     * @param eval the evaluator to be executed
     * @return an operator on the results of evaluator execution
     */
    public <X> Level1ArrayElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<X,? super T[]> eval);
    
    
    /**
     * <p>
     * Specialisation of the {@link #exec(Type,IFunction)} method which executes a function
     * implementing the {@link IConverter} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #exec(Type,IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     *
     * @param <X> the type of the result object
     * @param resultType the new type for the operator
     * @param converter the converter to be executed
     * @return an operator on the results of converter execution
     */
    public <X> Level1ArrayElementsOperator<X> convert(final Type<X> resultType, final IConverter<X,? super T[]> converter);    

    
    
    /**
     * <p>
     * Executes the specified function on each of the elements, creating a new operator
     * containing the result of all the executions and setting the new operator type to the one
     * specified.
     * </p>
     * <p>
     * This method is equivalent to <tt>forEach().exec(type, function).endFor()</tt>.
     * </p>
     * 
     * @param <X> the type of the result elements
     * @param type the new type for the operator
     * @param function the function to be executed
     * @return an operator on the results of function execution on each element
     */
    public <X> ExecutableArrayOfArrayElementsOperator<X> map(final Type<X> type, final IFunction<X,? super T> function);

    

    /**
     * <p>
     * Executes the specified function on each of the elements, creating a new operator
     * containing the result of all the executions but not changing the operator type. The
     * specified function will have to return results compatible with the current operator type.
     * </p>
     * <p>
     * This method is equivalent to <tt>forEach().exec(function).endFor()</tt>.
     * </p>
     * 
     * @param function the function to be executed
     * @return an operator on the results of function execution on each element
     */
    public ExecutableArrayOfArrayElementsOperator<T> map(final IFunction<? extends T,? super T> function);
    
}

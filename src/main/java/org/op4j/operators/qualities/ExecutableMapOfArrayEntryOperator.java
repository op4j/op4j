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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;




/**
 * <p>
 * This interface contains methods for executing functions on operators with
 * map of array entry target objects.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableMapOfArrayEntryOperator<K,V> {

    
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
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public ExecutableMapOfArrayEntryOperator<K,V> execAsMapOfArrayEntry(final IFunction<? extends Map.Entry<? extends K,? extends V[]>, ? super Map.Entry<K,V[]>> function);
    
    
    /**
     * <p>
     * Specialisation of the {@link #execAsMapOfArrayEntry(IFunction)} method which executes a function
     * implementing the {@link IEvaluator} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #execAsMapOfArrayEntry(IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     *
     * @param eval the evaluator to be executed
     * @return an operator on the results of evaluator execution
     */
    public ExecutableMapOfArrayEntryOperator<K,V> evalAsMapOfArrayEntry(final IEvaluator<? extends Map.Entry<? extends K,? extends V[]>,? super Map.Entry<K,V[]>> eval);
    
    
    /**
     * <p>
     * Specialisation of the {@link #execAsMapOfArrayEntry(IFunction)} method which executes a function
     * implementing the {@link IConverter} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #execAsMapOfArrayEntry(IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     *
     * @param converter the converter to be executed
     * @return an operator on the results of converter execution
     */
    public ExecutableMapOfArrayEntryOperator<K,V> convertAsMapOfArrayEntry(final IConverter<? extends Map.Entry<? extends K,? extends V[]>,? super Map.Entry<K,V[]>> converter);

    
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
     * @param valueType the type of the new array values
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X,Y> ExecutableMapOfArrayEntryOperator<X,Y> execAsMapOfArrayEntryOf(final Type<Y> valueType, final IFunction<? extends Map.Entry<X,Y[]>, ? super Map.Entry<K,V[]>> function);
    
    
    /**
     * <p>
     * Specialisation of the {@link #execAsMapOfArrayEntryOf(Type,IFunction)} method which executes a function
     * implementing the {@link IEvaluator} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #execAsMapOfArrayEntryOf(Type,IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     *
     * @param <X> the type of the resulting keys
     * @param <Y> the type of the resulting values
     * @param valueType the type of the new array values
     * @param eval the evaluator to be executed
     * @return an operator on the results of evaluator execution
     */
    public <X,Y> ExecutableMapOfArrayEntryOperator<X,Y> evalAsMapOfArrayEntryOf(final Type<Y> valueType, final IEvaluator<? extends Map.Entry<X,Y[]>,? super Map.Entry<K,V[]>> eval);
    
    
    /**
     * <p>
     * Specialisation of the {@link #execAsMapOfArrayEntryOf(Type,IFunction)} method which executes a function
     * implementing the {@link IConverter} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #execAsMapOfArrayEntryOf(Type,IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     *
     * @param <X> the type of the resulting keys
     * @param <Y> the type of the resulting values
     * @param valueType the type of the new array values
     * @param converter the converter to be executed
     * @return an operator on the results of converter execution
     */
    public <X,Y> ExecutableMapOfArrayEntryOperator<X,Y> convertAsMapOfArrayEntryOf(final Type<Y> valueType, final IConverter<? extends Map.Entry<X,Y[]>,? super Map.Entry<K,V[]>> converter);

    
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
    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Map.Entry<K,V[]>> function);
    

    /**
     * <p>
     * Specialisation of the {@link #exec(IFunction)} method which executes a function
     * implementing the {@link IEvaluator} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #exec(IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     *
     * @param <X> the type of the result object
     * @param eval the evaluator to be executed
     * @return an operator on the results of evaluator execution
     */
    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X,? super Map.Entry<K,V[]>> eval);
    

    /**
     * <p>
     * Specialisation of the {@link #exec(IFunction)} method which executes a function
     * implementing the {@link IConverter} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #exec(IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     *
     * @param <X> the type of the result object
     * @param converter the converter to be executed
     * @return an operator on the results of converter execution
     */
    public <X> Level0GenericUniqOperator<X> convert(final IConverter<X,? super Map.Entry<K,V[]>> converter);    
    
}

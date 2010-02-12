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
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;




/**
 * <p>
 * This interface contains methods for executing functions on operators with
 * map of map entry target objects on which a selection ("if") has already been done.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableMapOfMapEntrySelectedOperator<K1,K2,V> {

    
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
    public ExecutableMapOfMapEntrySelectedOperator<K1,K2,V> execAsMapOfMapEntry(final IFunction<? extends Map.Entry<? extends K1,? extends Map<? extends K2,? extends V>>, ? super Map.Entry<K1,Map<K2,V>>> function);
    
    
    /**
     * <p>
     * Specialisation of the {@link #execAsMapOfMapEntry(IFunction)} method which executes a function
     * implementing the {@link IEvaluator} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #execAsMapOfMapEntry(IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     *
     * @param eval the evaluator to be executed
     * @return an operator on the results of evaluator execution
     */
    public ExecutableMapOfMapEntrySelectedOperator<K1,K2,V> evalAsMapOfMapEntry(final IEvaluator<? extends Map.Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map.Entry<K1,Map<K2,V>>> eval);
    
    
    /**
     * <p>
     * Specialisation of the {@link #execAsMapOfMapEntry(IFunction)} method which executes a function
     * implementing the {@link IConverter} interface.
     * </p>
     * <p>
     * This method is equivalent to {@link #execAsMapOfMapEntry(IFunction)}, and exists only for
     * semantical purposes.
     * </p>
     *
     * @param converter the converter to be executed
     * @return an operator on the results of converter execution
     */
    public ExecutableMapOfMapEntrySelectedOperator<K1,K2,V> convertAsMapOfMapEntry(final IConverter<? extends Map.Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map.Entry<K1,Map<K2,V>>> converter);
    
}

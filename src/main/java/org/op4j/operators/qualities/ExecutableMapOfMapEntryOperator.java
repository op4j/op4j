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
 * map of map entry target objects.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableMapOfMapEntryOperator<K1,K2,V> {

    
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
     * @param <X1> the type of the resulting first-level keys
     * @param <X2> the type of the resulting second-level keys
     * @param <Y> the type of the resulting second-level values
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X1,X2,Y> ExecutableMapOfMapEntryOperator<X1,X2,Y> execAsMapOfMapEntry(final IFunction<? extends Map.Entry<X1,? extends Map<X2,Y>>, ? super Map.Entry<K1,Map<K2,V>>> function);
    
    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsMapOfMapEntry(IFunction)} but only
     * on non-null elements, leaving null elements untouched.
     * </p>
     *
     * @param <X1> the type of the resulting first-level keys
     * @param <X2> the type of the resulting second-level keys
     * @param <Y> the type of the resulting second-level values
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X1,X2,Y> ExecutableMapOfMapEntryOperator<X1,X2,Y> execIfNotNullAsMapOfMapEntry(final IFunction<? extends Map.Entry<X1,? extends Map<X2,Y>>,? super Map.Entry<K1,Map<K2,V>>> function);


    
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
    public <X> Operator exec(final IFunction<X, ? super Map.Entry<K1,Map<K2,V>>> function);
    
    
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
    public <X> Operator execIfNotNull(final IFunction<X,? super Map.Entry<K1,Map<K2,V>>> function);
    
    
}

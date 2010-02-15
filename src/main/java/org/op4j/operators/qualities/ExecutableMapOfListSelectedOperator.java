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
import java.util.Map;

import org.op4j.functions.IFunction;




/**
 * <p>
 * This interface contains methods for executing functions on operators with
 * map of list target objects on which a selection ("if") has already been done.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableMapOfListSelectedOperator<K,V> {

    
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
    public ExecutableMapOfListSelectedOperator<K,V> execAsMapOfList(final IFunction<? extends Map<? extends K,? extends List<? extends V>>, ? super Map<K,List<V>>> function);
    
    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsMapOfList(IFunction)} but only
     * on non-null elements, leaving null elements untouched.
     * </p>
     *
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public ExecutableMapOfListSelectedOperator<K,V> execIfNotNullAsMapOfList(final IFunction<? extends Map<? extends K,? extends List<? extends V>>,? super Map<K,List<V>>> function);

    
}

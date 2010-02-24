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
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.operators.intf.map.Level0MapOperator;



/**
 * <p>
 * This interface defines methods for the building of structures from multioperators' targets.
 * This methods will populate the structures created from the target objects by
 * the "alternate elements" method: starting with 0, even elements will be taken as keys,
 * and odd elements as values.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface BuilderMultiOperator<T,I> {

    /**
     * <p>
     * Builds a map from the operator's targets. Starting with 0, even elements will
     * be taken as keys, and odd elements as values.
     * </p>
     * 
     * @return an operator on the resulting map.
     */
    public Level0MapOperator<T,T,I> buildMap();

    /**
     * <p>
     * Builds a map of list from the operator's targets. Starting with 0, even elements will
     * be taken as keys, and odd elements as values. Values will be grouped into lists,
     * relating each key with its list of values.
     * </p>
     * 
     * @return an operator on the resulting map of list
     */
    public Level0MapOperator<T,List<T>,I> buildMapOfList();

    /**
     * <p>
     * Builds a map of set from the operator's targets. Starting with 0, even elements will
     * be taken as keys, and odd elements as values. Values will be grouped into sets,
     * relating each key with its set of values.
     * </p>
     * 
     * @return an operator on the resulting map of set
     */
    public Level0MapOperator<T,Set<T>,I> buildMapOfSet();

    /**
     * <p>
     * Builds a map of array from the operator's targets. Starting with 0, even elements will
     * be taken as keys, and odd elements as values. Values will be grouped into arrays of
     * the specified type, relating each key with its array of values.
     * </p>
     * 
     * @param type the type of which the arrays will be instantiated
     * @return an operator on the resulting map of array
     */
    public Level0MapOperator<T,T[],I> buildMapOfArrayOf(final Type<T> type);
    
}

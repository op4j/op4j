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

import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;


/**
 * <p>
 * This interface contains methods for conversions to array of map.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ConvertibleToArrayOfMapOperator<T> {
    
    
    /**
     * <p>
     * Converts the current target into an array of map by using the second-level
     * structure even elements as keys and odd elements as values (starting with 0).
     * </p>
     * 
     * @return an operator holding the converted object as target.
     */
    public Level0ArrayOfMapOperator<T,T> toArrayOfMap();

    
    /**
     * <p>
     * Converts the current target into an array of map by using the second-level
     * structure elements as values, and the results of evaluating these values
     * with the provided keyEval as their corresponding keys.
     * </p>
     * 
     * @param <K> the type of the new map keys
     * @param keyEval the evaluator to be used for obtaining keys
     * @return an operator holding the converted object as target.
     */
    public <K> Level0ArrayOfMapOperator<K,T> toArrayOfMap(final IFunction<K,? super T> keyEval);
    
    
    /**
     * <p>
     * Converts the current target into an array of map by using the second-level
     * structure elements as input for a map builder which will create corresponding
     * keys and values for each of them.
     * </p>
     * 
     * @param <K> the type of the new keys being created
     * @param <V> the type of the new values being created
     * @param mapBuild the map builder
     * @return an operator holding the converted object as target
     */
    public <K,V> Level0ArrayOfMapOperator<K,V> toArrayOfMap(final IMapBuilder<K,V,? super T> mapBuild);

}

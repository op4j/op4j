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

import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;


/**
 * <p>
 * This interface contains methods for conversions to map of map from operators
 * currently holding a "* of map" structure.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ConvertibleToMapOfMapFromStructureOfMapOperator<K,V> {
    
    
    /**
     * <p>
     * Converts the target object (which has to be a "* of map" structure) to a map of map
     * by applying an evaluator to the second-level maps in order to obtain their corresponding
     * first-level map keys. 
     * </p>
     * 
     * @param <K1> the type of the generated first-level map keys
     * @param keyEval the evaluator used to obtain first-level map keys from second-level maps.
     * @return an operator holding the converted object as target.
     */
    public <K1> Level0MapOfMapOperator<K1,K,V> toMapOfMap(final IEvaluator<K1,? super Map<K, V>> keyEval);

    
    /**
     * <p>
     * Converts the target object (which has to be a "* of map" structure) to a map of map
     * by inputting the second-level map elements in the target object into a map builder which
     * will create both new first-level keys and new second-level keys (which have to be maps themselves). 
     * </p>
     * 
     * @param <K1> the type of the generated first-level map keys
     * @param <K2> the type of the generated second-level map keys
     * @param <V2> the type of the generated second-level map values
     * @param mapBuild the map builder
     * @return an operator holding the converted object as target.
     */
    public <K1,K2,V2> Level0MapOfMapOperator<K1,K2,V2> toMapOfMap(final IMapBuilder<K1, Map<K2,V2>, ? super Map<K,V>> mapBuild);
    
}

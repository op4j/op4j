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
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;


/**
 * <p>
 * This interface contains methods for conversions to map of map from operators
 * currently holding a "map of *" target and already being iterated by their first-level
 * map values.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ConvertibleToMapOfMapOperator<K,V> {
    
    
    /**
     * <p>
     * Converts the target object to a map of map by evaluating the values of an
     * existing map to obtain their corresponding second-level map keys.
     * </p>
     * 
     * @param <K2> the type of the generated second-level map keys 
     * @param keyEval the evaluator to obtain the second-level map keys
     * @return an operator holding the converted object as target.
     */
    public <K2> Level0MapOfMapOperator<K,K2,V> toMapOfMap(final IFunction<K2,? super V> keyEval);
    
    
    /**
     * <p>
     * Converts the target object to a map of map by inputting the values of an
     * existing map into a map builder that will create keys and values for the
     * second-level maps.
     * </p>
     * 
     * @param <K2> the type of the generated second-level map keys
     * @param <V2> the type of the generated second-level map values
     * @param mapBuild the map builder which will build keys and values for the second-level maps
     * @return an operator holding the converted object as target.
     */
    public <K2,V2> Level0MapOfMapOperator<K,K2,V2> toMapOfMap(final IMapBuilder<K2,V2,? super V> mapBuild);
    
}

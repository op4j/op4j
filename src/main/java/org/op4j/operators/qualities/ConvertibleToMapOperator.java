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


/**
 * <p>
 * This interface contains methods for conversions to map.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ConvertibleToMapOperator<T> {
    
    
    /**
     * <p>
     * Converts the target object to a map, by using the even elements 
     * (starting at 0) as keys, and the odd elements as values.
     * </p>
     * 
     * @return an operator holding the converted object as target.
     */
    public Operator toMap();
 
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as values and applying an evaluator (keyEval) to them
     * in order to obtain their corresponding keys.
     * </p>
     * <p>
     * Note that if more than one value get the same key, only the last one
     * will be in the resulting map (the other ones will be overwritten).
     * </p>
     * 
     * @param <K> the type of the keys that will be created
     * @param keyEval the evaluator used for obtaining the keys
     * @return an operator holding the converted object as target.
     */
    public <K> Operator toMap(final IFunction<? super T,K> keyEval);

    
    /**
     * <p>
     * Converts the target object to a map by inputting the original target's
     * elements into the specified map builder which will create the
     * resulting keys and values.
     * </p>
     * <p>
     * Note that if more than one value get the same key, only the last one
     * will be in the resulting map (the other ones will be overwritten).
     * </p>
     * 
     * @param <K> the type of the keys that will be created
     * @param <V> the type of the values that will be created
     * @param mapBuild the map builder to be used
     * @return an operator holding the converted object as target.
     */
    public <K,V> Operator toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
}

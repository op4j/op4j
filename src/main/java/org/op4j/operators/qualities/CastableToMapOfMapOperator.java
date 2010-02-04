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
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;


/**
 * <p>
 * This interface contains methods for casts to map of map (Map<K1,Map<K2,V>>).
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface CastableToMapOfMapOperator {
    
    
    /**
     * <p>
     * Casts the operator's target as a map of map of the specified types.
     * </p>
     * 
     * @param <K> the type for the first-level map's keys
     * @param <K2> the type for the seconds-level maps' (values of the first-level map) keys
     * @param <V> the type for the second-level maps' values
     * @param key1Type the type for the first-level map's keys
     * @param key2Type the type for the seconds-level maps' (values of the first-level map) keys
     * @param valueType the type for the second-level maps' values
     * @return the resulting map of map
     */
    public <K1,K2,V> Level0MapOfMapOperator<K1,K2,V> asMapOfMapOf(final Type<K1> key1Type, final Type<K2> key2Type, final Type<V> valueType);
    
    
    /**
     * <p>
     * Casts the operator's target as a map of map of unknown (first-level keys, second-level
     * keys and second-level values).
     * </p>
     * 
     * @return the resulting map of map
     */
    public Level0MapOfMapOperator<?,?,?> asMapOfMapOfUnknown();

    
}

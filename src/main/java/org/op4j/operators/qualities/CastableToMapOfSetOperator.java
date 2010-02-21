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
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;


/**
 * <p>
 * This interface contains methods for casts to map of set (Map<K,Set<V>>).
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface CastableToMapOfSetOperator {
    
    
    /**
     * <p>
     * Casts the operator's target as a map of set of the specified types.
     * </p>
     * 
     * @param <K> the type for the map's keys
     * @param <V> the type for the map's values (elements of the value sets)
     * @param keyType the type for the map's keys
     * @param valueType the type for the map's values (elements of the value sets)
     * @return the resulting map of set
     */
    public <K,V> Level0MapOfSetOperator<K,V> asMapOfSetOf(final Type<K> keyType, final Type<V> valueType);

    
}

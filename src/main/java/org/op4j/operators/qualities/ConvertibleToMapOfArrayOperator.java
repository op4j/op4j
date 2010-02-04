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
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;


/**
 * <p>
 * This interface contains methods for conversions to map of array.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ConvertibleToMapOfArrayOperator<K,V> {
    
    
    /**
     * <p>
     * Converts the current target into a map of array of the specified type.
     * </p>
     * 
     * @param type the type for the arrays contained in the map
     * @return an operator holding the converted object as target.
     */
    public Level0MapOfArrayOperator<K,V> toMapOfArrayOf(final Type<V> type);
    

    
}

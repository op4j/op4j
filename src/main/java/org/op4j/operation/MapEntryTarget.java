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
package org.op4j.operation;

import java.util.Map;

import org.op4j.type.Type;
import org.op4j.util.CastUtils;
import org.op4j.util.TypeAggregationUtils;

public class MapEntryTarget<K,V> extends Target<Map.Entry<K,V>> {

    private final Type keyType;
    private final Type valueType;
    
    
    public MapEntryTarget(final Type keyType, final Type valueType, final Map.Entry<K,V> object) {
        super(TypeAggregationUtils.createMapEntryOfType(keyType,valueType), object);
        this.keyType = keyType;
        this.valueType = valueType;
        if (object != null) {
            // Map.Entry is a special case which in fact involves a pair of 
            // objects: key and value. As such, what should be tested is this objects
            // and not only the Map entry itself (which will certainly implement Map.Entry)
            if (keyType != null) {
                CastUtils.unsafeCheckCastable(keyType, object.getKey());
            }
            if (valueType != null) {
                CastUtils.unsafeCheckCastable(valueType, object.getValue());
            }
        }
    }
    
    
    public Type getMapEntryKeyType() {
        return this.keyType;
    }
    
    
    public Type getMapEntryValueType() {
        return this.valueType;
    }
    
    
}

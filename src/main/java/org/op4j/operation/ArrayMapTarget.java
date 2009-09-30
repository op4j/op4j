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
import org.op4j.util.TypeAggregationUtils;

public class ArrayMapTarget<K,V> extends Target<Map<K,V[]>> {

    private final Type keyType;
    private final Type valueType;
    
    
    public ArrayMapTarget(final Type keyType, final Type valueType, final Map<K,V[]> object) {
        super(TypeAggregationUtils.createListMapOfType(keyType,valueType), object);
        this.keyType = keyType;
        this.valueType = valueType;
    }
    
    
    public Type getArrayMapKeyType() {
        return this.keyType;
    }
    
    
    public Type getArrayMapValueType() {
        return this.valueType;
    }
    
    
}

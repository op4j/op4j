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
package org.op4j.util;

import java.util.Map;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class MapEntry<K,V> implements Map.Entry<K,V> {
    
    private final K key;
    private final V value;
    
    
    public MapEntry(K key, V value) {
        super();
        this.key = key;
        this.value = value;
    }


    public K getKey() {
        return this.key;
    }


    public V getValue() {
        return this.value;
    }


    public V setValue(V value) {
        throw new IllegalStateException("MapEntry is read-only");
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getKey() == null) ? 0 : getKey().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        return result;
    }


    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MapEntry other = (MapEntry) obj;
        if (getKey() == null) {
            if (other.getKey() != null) {
                return false;
            }
        } else if (!getKey().equals(other.getKey())) {
            return false;
        }
        if (getValue() == null) {
            if (other.getValue() != null) {
                return false;
            }
        } else if (!getValue().equals(other.getValue())) {
            return false;
        }
        return true;
    }
    
    
    
}

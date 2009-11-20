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

package org.op4j.executables.functions.builtin;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.IEval;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.IFunc;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class MapFunc {

    
    
    
    private MapFunc() {
        super();
    }

    
    
    
    
    

    

    
    public static final class Put<K, V> implements IFunc<Map<K, V>,Map<K, V>> {

        private final K key;
        private final V value;
        
        public Put(final K key, final V value) {
            super();
            this.key = key;
            this.value = value;
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<K,V> execute(final Map<K, V> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>(object);
            result.put(this.key, this.value);
            return result;
        }
        
    }

    
    
    public static final class Insert<K, V> implements IFunc<Map<K, V>,Map<K, V>> {

        private final int position;
        private final K key;
        private final V value;
        
        public Insert(final int position, final K key, final V value) {
            super();
            this.position = position;
            this.key = key;
            this.value = value;
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<K,V> execute(final Map<K, V> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>(object);
            int index = 0;
            for (final Map.Entry<K, V> entry : object.entrySet()) {
                if (index == this.position) {
                    result.put(this.key, this.value);
                }
                if (!result.containsKey(entry.getKey())) {
                    result.put(entry.getKey(), entry.getValue());
                }
                index++;
            }
            return result;
        }
        
    }


    
    
    
    public static final class PutAll<K, V> implements IFunc<Map<K, V>,Map<K, V>> {

        private final Map<K, V> map;
        
        public PutAll(final Map<K, V> map) {
            super();
            this.map = new LinkedHashMap<K, V>(map);
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<K,V> execute(final Map<K, V> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>(object);
            result.putAll(this.map);
            return result;
        }
        
    }


    
    
    
    public static final class InsertAll<K, V> implements IFunc<Map<K, V>,Map<K, V>> {

        private final int position;
        private final Map<K, V> map;
        
        public InsertAll(final int position, final Map<K, V> map) {
            super();
            this.position = position;
            this.map = new LinkedHashMap<K, V>(map);
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<K,V> execute(final Map<K, V> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>(object);
            int index = 0;
            for (final Map.Entry<K, V> entry : object.entrySet()) {
                if (index == this.position) {
                    for (final Map.Entry<K, V> newEntry : this.map.entrySet()) {
                        result.put(newEntry.getKey(), newEntry.getValue());
                    }
                }
                if (!result.containsKey(entry.getKey())) {
                    result.put(entry.getKey(), entry.getValue());
                }
                index++;
            }
            return result;
        }
        
    }

    
    

    
    public static final class RemoveKeys<K,V> implements IFunc<Map<K, V>,Map<K, V>> {

        private final List<K> keys;
        
        public RemoveKeys(final K... keys) {
            super();
            this.keys = VarArgsUtil.asRequiredObjectList(keys);
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<K, V> execute(final Map<K, V> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>(object);
            for (final K key : this.keys) {
                result.remove(key);
            }
            return result;
        }
        
    }

    
    

    
    public static final class RemoveMatching<K, V> implements IFunc<Map<K, V>,Map<K, V>> {

        private final IEval<Boolean,? super Map.Entry<K, V>> eval;
        
        public RemoveMatching(final IEval<Boolean,? super Map.Entry<K, V>> eval) {
            super();
            this.eval = eval;
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<K, V> execute(final Map<K, V> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : object.entrySet()) {
                if (!this.eval.execute(entry).booleanValue()) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
            return result;
        }
        
    }

    
    

    
    public static final class RemoveSelected<K, V> implements IFunc<Map<K, V>,Map<K, V>> {

        private final ISelect<Map.Entry<K,V>> selector;
        
        public RemoveSelected(final ISelect<Map.Entry<K,V>> selector) {
            super();
            this.selector = selector;
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<K, V> execute(final Map<K, V> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : object.entrySet()) {
                if (!this.selector.eval(entry)) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
            return result;
        }
        
    }
    
    

    
    
    public static final class RemoveAllExceptKeys<K, V> implements IFunc<Map<K, V>,Map<K, V>> {

        private final List<K> keys;
        
        public RemoveAllExceptKeys(final K... keys) {
            super();
            this.keys = VarArgsUtil.asRequiredObjectList(keys);
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<K, V> execute(final Map<K, V> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : object.entrySet()) {
                if (this.keys.contains(entry.getKey())) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
            return result;
        }
        
    }
    
    
    
}

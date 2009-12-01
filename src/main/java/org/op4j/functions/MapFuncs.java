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

package org.op4j.functions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.select.ISelector;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class MapFuncs {

    
    
    
    private MapFuncs() {
        super();
    }

    
    
    
    
    
    public static class SortByKey<K extends Comparable<? super K>, V> extends AbstractNotNullFunc<Map<K, V>, Map<K, V>> {

        public SortByKey() {
            super();
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, V> notNullExecute(final Map<K, V> object) throws Exception {
            final List<K> keys = new ArrayList<K>(object.keySet());
            Collections.sort(keys);
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final K key : keys) {
                result.put(key, object.get(key));
            }
            return result;
        }
        
    }

    
    
    public static class SortEntries<K, V> extends AbstractNotNullFunc<Map<K, V>, Map<K, V>> {

        private final Comparator<? super Map.Entry<K, V>> comparator;

        public SortEntries(final Comparator<? super Map.Entry<K, V>> comparator) {
            super();
            this.comparator = comparator;
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, V> notNullExecute(final Map<K, V> object) throws Exception {
            final List<Map.Entry<K, V>> entries = new ArrayList<Entry<K,V>>(object.entrySet());
            Collections.sort(entries, this.comparator);
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : entries) {
                result.put(entry.getKey(), entry.getValue());
            }
            return result;
        }
        
    }
    

    

    
    public static final class Put<K, V> extends AbstractNotNullFunc<Map<K, V>,Map<K, V>> {

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

        @Override
        public Map<K,V> notNullExecute(final Map<K, V> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>(object);
            result.put(this.key, this.value);
            return result;
        }
        
    }

    
    
    public static final class Insert<K, V> extends AbstractNotNullFunc<Map<K, V>,Map<K, V>> {

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

        @Override
        public Map<K,V> notNullExecute(final Map<K, V> object) throws Exception {
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


    
    
    
    public static final class PutAll<K, V> extends AbstractNotNullFunc<Map<K, V>,Map<K, V>> {

        private final Map<K, V> map;
        
        public PutAll(final Map<K, V> map) {
            super();
            this.map = new LinkedHashMap<K, V>(map);
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K,V> notNullExecute(final Map<K, V> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>(object);
            result.putAll(this.map);
            return result;
        }
        
    }


    
    
    
    public static final class InsertAll<K, V> extends AbstractNotNullFunc<Map<K, V>,Map<K, V>> {

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

        @Override
        public Map<K,V> notNullExecute(final Map<K, V> object) throws Exception {
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

    
    

    
    public static final class RemoveKeys<K,V> extends AbstractNotNullFunc<Map<K, V>,Map<K, V>> {

        private final List<K> keys;
        
        public RemoveKeys(final K... keys) {
            super();
            this.keys = VarArgsUtil.asRequiredObjectList(keys);
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, V> notNullExecute(final Map<K, V> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>(object);
            for (final K key : this.keys) {
                result.remove(key);
            }
            return result;
        }
        
    }

    
    

    
    public static final class RemoveMatching<K, V> extends AbstractNotNullFunc<Map<K, V>,Map<K, V>> {

        private final IEvaluator<Boolean,? super Map.Entry<K, V>> eval;
        
        public RemoveMatching(final IEvaluator<Boolean,? super Map.Entry<K, V>> eval) {
            super();
            this.eval = eval;
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, V> notNullExecute(final Map<K, V> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : object.entrySet()) {
                if (!this.eval.execute(entry).booleanValue()) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
            return result;
        }
        
    }

    
    

    
    public static final class RemoveSelected<K, V> extends AbstractNotNullFunc<Map<K, V>,Map<K, V>> {

        private final ISelector<Map.Entry<K,V>> selector;
        
        public RemoveSelected(final ISelector<Map.Entry<K,V>> selector) {
            super();
            this.selector = selector;
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, V> notNullExecute(final Map<K, V> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : object.entrySet()) {
                if (!this.selector.eval(entry)) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
            return result;
        }
        
    }
    
    

    
    
    public static final class RemoveKeysNot<K, V> extends AbstractNotNullFunc<Map<K, V>,Map<K, V>> {

        private final List<K> keys;
        
        public RemoveKeysNot(final K... keys) {
            super();
            this.keys = VarArgsUtil.asRequiredObjectList(keys);
        }

        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, V> notNullExecute(final Map<K, V> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : object.entrySet()) {
                if (this.keys.contains(entry.getKey())) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
            return result;
        }
        
    }

    
    
    
    public static class ExtractKeys<K, V> extends AbstractNotNullFunc<Set<K>, Map<K, V>> {

        public ExtractKeys() {
            super();
        }

        public Type<? super Set<K>> getResultType() {
            return Types.SET_OF_UNKNOWN;
        }

        @Override
        public Set<K> notNullExecute(final Map<K, V> object) throws Exception {
            return new LinkedHashSet<K>(object.keySet());
        }
        
    }
    
    
    
    public static class ExtractValues<K, V> extends AbstractNotNullFunc<List<V>, Map<K, V>> {

        public ExtractValues() {
            super();
        }

        public Type<? super List<V>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        public List<V> notNullExecute(final Map<K, V> object) throws Exception {
            return new ArrayList<V>(object.values());
        }
        
    }
    
    
    
}

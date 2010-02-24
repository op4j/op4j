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

package org.op4j.functions.structures;

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
import org.op4j.functions.AbstractNotNullFunction;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.IFunction;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public final class FMap<K,V> {

    
    private static final FMap<Object,Object> OF_OBJECT_OBJECT = new FMap<Object,Object>(Types.OBJECT, Types.OBJECT);
    private static final FMap<String,String> OF_STRING_STRING = new FMap<String,String>(Types.STRING, Types.STRING);
    private static final FMap<Integer,String> OF_INTEGER_STRING = new FMap<Integer,String>(Types.INTEGER, Types.STRING);
    private static final FMap<String,Integer> OF_STRING_INTEGER = new FMap<String,Integer>(Types.STRING, Types.INTEGER);

    
    protected final Type<K> keyType;
    protected final Type<V> valueType;


    
    
    public static <K,V> FMap<K,V> of(final Type<K> keyType, final Type<V> valueType) {
        return new FMap<K,V>(keyType, valueType);
    }
    
    public static FMap<Object,Object> ofObjectObject() {
        return OF_OBJECT_OBJECT;
    }
    
    public static FMap<String,String> ofStringString() {
        return OF_STRING_STRING;
    }
    
    public static FMap<Integer,String> ofIntegerString() {
        return OF_INTEGER_STRING;
    }
    
    public static FMap<String,Integer> ofStringInteger() {
        return OF_STRING_INTEGER;
    }
    
    
    
    

    public final SortByKey<K,V> sortByKey() {
        return new SortByKey<K,V>();
    }

    public final SortEntries<K,V> sortByKey(final Comparator<? super Entry<K,V>> comparator) {
        return new SortEntries<K,V>(comparator);
    }
    
    public final Put<K,V> put(final K key, final V value) {
        return new Put<K,V>(key, value);
    }
    
    public final Insert<K,V> insert(final int position, final K key, final V value) {
        return new Insert<K,V>(position, key, value);
    }
    
    public final PutAll<K,V> putAll(final Map<K,V> map) {
        return new PutAll<K,V>(map);
    }
    
    public final InsertAll<K,V> insertAll(final int position, final Map<K,V> map) {
        return new InsertAll<K,V>(position, map);
    }
    
    public final RemoveAllKeys<K,V> removeAllKeys(final K... keys) {
        return new RemoveAllKeys<K,V>(keys);
    }
    
    public final RemoveAllTrue<K,V> removeAllTrue(final IFunction<? super Entry<K,V>,Boolean> eval) {
        return new RemoveAllTrue<K,V>(eval);
    }
    
    public final RemoveAllFalse<K,V> removeAllFalse(final IFunction<? super Entry<K,V>,Boolean> eval) {
        return new RemoveAllFalse<K,V>(eval);
    }
    
    public final RemoveAllKeysNot<K,V> removeAllKeysNot(final K... keys) {
        return new RemoveAllKeysNot<K,V>(keys);
    }
    
    public final ExtractKeys<K,V> extractKeys() {
        return new ExtractKeys<K,V>();
    }
    
    public final ExtractValues<K,V> extractValues() {
        return new ExtractValues<K,V>();
    }
    
    
    
    
    
    
    
    
    protected FMap(final Type<K> keyType, final Type<V> valueType) {
        super();
        this.keyType = keyType;
        this.valueType = valueType;
    }

    
    
    
    
    
    public static class SortByKey<K,V> extends AbstractStructureNotNullNonConvertingFunc<Map<K, V>> {

        public SortByKey() {
            super();
        }

        @Override
        public Map<K, V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            return doSort(object, ctx);
        }
        

        @SuppressWarnings("unchecked")
        public Map<K, V> doSort(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final List<?> keys = new ArrayList<Object>(object.keySet());
            Collections.sort((List<Comparable>)keys);
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final K key : (List<K>) keys) {
                result.put(key, object.get(key));
            }
            return result;
        }
        
    }

    
    
    public static class SortEntries<K, V> extends AbstractStructureNotNullNonConvertingFunc<Map<K, V>> {

        private final Comparator<? super Map.Entry<K, V>> comparator;

        public SortEntries(final Comparator<? super Map.Entry<K, V>> comparator) {
            super();
            this.comparator = comparator;
        }

        @Override
        public Map<K, V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final List<Map.Entry<K, V>> entries = new ArrayList<Entry<K,V>>(object.entrySet());
            Collections.sort(entries, this.comparator);
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : entries) {
                result.put(entry.getKey(), entry.getValue());
            }
            return result;
        }
        
    }
    

    

    
    public static final class Put<K, V> extends AbstractStructureNotNullNonConvertingFunc<Map<K, V>> {

        private final K key;
        private final V value;
        
        public Put(final K key, final V value) {
            super();
            this.key = key;
            this.value = value;
        }

        @Override
        public Map<K,V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>(object);
            result.put(this.key, this.value);
            return result;
        }
        
    }

    
    
    public static final class Insert<K, V> extends AbstractStructureNotNullNonConvertingFunc<Map<K, V>> {

        private final int position;
        private final K key;
        private final V value;
        
        public Insert(final int position, final K key, final V value) {
            super();
            this.position = position;
            this.key = key;
            this.value = value;
        }

        @Override
        public Map<K,V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
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


    
    
    
    public static final class PutAll<K, V> extends AbstractStructureNotNullNonConvertingFunc<Map<K, V>> {

        private final Map<K, V> map;
        
        public PutAll(final Map<K, V> map) {
            super();
            this.map = new LinkedHashMap<K, V>(map);
        }

        @Override
        public Map<K,V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>(object);
            result.putAll(this.map);
            return result;
        }
        
    }


    
    
    
    public static final class InsertAll<K, V> extends AbstractStructureNotNullNonConvertingFunc<Map<K, V>> {

        private final int position;
        private final Map<K, V> map;
        
        public InsertAll(final int position, final Map<K, V> map) {
            super();
            this.position = position;
            this.map = new LinkedHashMap<K, V>(map);
        }

        @Override
        public Map<K,V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
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

    
    

    
    public static final class RemoveAllKeys<K,V> extends AbstractStructureNotNullNonConvertingFunc<Map<K, V>> {

        private final List<K> keys;
        
        public RemoveAllKeys(final K... keys) {
            super();
            this.keys = VarArgsUtil.asRequiredObjectList(keys);
        }

        @Override
        public Map<K, V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>(object);
            for (final K key : this.keys) {
                result.remove(key);
            }
            return result;
        }
        
    }

    
    

    
    public static final class RemoveAllTrue<K, V> extends AbstractStructureNotNullNonConvertingFunc<Map<K, V>> {

        private final IFunction<? super Map.Entry<K, V>,Boolean> eval;
        
        public RemoveAllTrue(final IFunction<? super Map.Entry<K, V>,Boolean> eval) {
            super();
            this.eval = eval;
        }

        @Override
        public Map<K, V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : object.entrySet()) {
                if (!this.eval.execute(entry, ctx).booleanValue()) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
            return result;
        }
        
    }

    
    

    
    public static final class RemoveAllFalse<K, V> extends AbstractStructureNotNullNonConvertingFunc<Map<K, V>> {

        private final IFunction<? super Map.Entry<K, V>,Boolean> eval;
        
        public RemoveAllFalse(final IFunction<? super Map.Entry<K, V>,Boolean> eval) {
            super();
            this.eval = eval;
        }

        @Override
        public Map<K, V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : object.entrySet()) {
                if (this.eval.execute(entry, ctx).booleanValue()) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
            return result;
        }
        
    }
    
    

    
    
    public static final class RemoveAllKeysNot<K, V> extends AbstractStructureNotNullNonConvertingFunc<Map<K, V>> {

        private final List<K> keys;
        
        public RemoveAllKeysNot(final K... keys) {
            super();
            this.keys = VarArgsUtil.asRequiredObjectList(keys);
        }

        @Override
        public Map<K, V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : object.entrySet()) {
                if (this.keys.contains(entry.getKey())) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
            return result;
        }
        
    }

    
    
    
    public static class ExtractKeys<K, V> extends AbstractNotNullFunction<Map<K, V>,Set<K>> {

        public ExtractKeys() {
            super();
        }

        @Override
        public Set<K> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            return new LinkedHashSet<K>(object.keySet());
        }
        
    }
    
    
    
    public static class ExtractValues<K, V> extends AbstractNotNullFunction<Map<K, V>,List<V>> {

        public ExtractValues() {
            super();
        }

        @Override
        public List<V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            return new ArrayList<V>(object.values());
        }
        
    }
    
    
    
}

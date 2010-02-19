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

package org.op4j.functions.converters;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.op4j.functions.AbstractNullAsNullFunction;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class ToMapOfArray {

    
    private ToMapOfArray() {
        super();
    }
    

    
    
    @SuppressWarnings("unchecked")
	protected static final <K,V> Map<K, V[]> createFromMapOfList(final Type<V> type, final Map<K, List<V>> mapOfList) {
        final Map<K, V[]> result = new LinkedHashMap<K, V[]>();
        for (final Map.Entry<K, List<V>> listEntry : mapOfList.entrySet()) {
        	final K key = listEntry.getKey();
        	final List<V> listValue = listEntry.getValue();
            final V[] arrayValue = (V[]) Array.newInstance(type.getRawClass(), listValue.size());
            result.put(key, listValue.toArray(arrayValue));
        }
        return result;
    }
    
    
    
    
    public static final class FromArrayByKeyEval<K, T> extends AbstractNullAsNullFunction<Map<K, T[]>, T[]> {

        private final IFunction<K,? super T> eval;
        private final Type<T> type;
        
        public FromArrayByKeyEval(final Type<T> type, final IFunction<K,? super T> eval) {
            super();
			Validate.notNull(type, "A type representing the array elements must be specified");
			Validate.notNull(eval, "An evaluator must be specified");
            this.type = type;
            this.eval = eval;
        }

		@Override
        public Map<K, T[]> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
        	
            final Map<K, List<T>> result = new LinkedHashMap<K, List<T>>();
            for (final T element: object) {
                final K key = this.eval.execute(element, ctx);
                List<T> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<T>();
                    result.put(key, value);
                }
                value.add(element);
            }
            
            return ToMapOfArray.createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    public static final class FromArrayByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<Map<K, V[]>, T[]> {

        private final IMapBuilder<K, V, ? super T> mapBuilder;
        private final Type<V> type;
        
        public FromArrayByMapBuilder(final Type<V> type, final IMapBuilder<K, V, ? super T> mapBuilder) {
            super();
			Validate.notNull(type, "A type representing the array elements must be specified");
			Validate.notNull(mapBuilder, "A map builder must be specified");
            this.type = type;
            this.mapBuilder = mapBuilder;
        }

		@Override
        public Map<K, V[]> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
        	
            final Map<K, List<V>> result = new LinkedHashMap<K, List<V>>();
            for (final T element: object) {
                final K key = this.mapBuilder.buildKey(element);
                List<V> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<V>();
                    result.put(key, value);
                }
                value.add(this.mapBuilder.buildValue(element));
            }
            
            return ToMapOfArray.createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    public static final class FromArrayByAlternateElements<T> extends AbstractNullAsNullFunction<Map<T, T[]>, T[]> {

        private final Type<T> type;
    	
        public FromArrayByAlternateElements(final Type<T> type) {
            super();
			Validate.notNull(type, "A type representing the array elements must be specified");
            this.type = type;
        }

		@Override
        public Map<T, T[]> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
        	
            if (object.length % 2 != 0) {
                throw new IllegalArgumentException("Cannot create a map from objects: the number of objects must be even.");
            }
            
            final Map<T, List<T>> result = new LinkedHashMap<T, List<T>>();
            for (int i = 0, n = object.length - 1; i < n; i += 2) {
                final T key = object[i];
                List<T> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<T>();
                    result.put(key, value);
                }
                value.add(object[i + 1]);
            }
            
            return ToMapOfArray.createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    
    
    
    public static final class FromListByKeyEval<K, T> extends AbstractNullAsNullFunction<Map<K, T[]>, List<T>> {

        private final IFunction<K,? super T> eval;
        private final Type<T> type;
        
        public FromListByKeyEval(final Type<T> type, final IFunction<K,? super T> eval) {
            super();
			Validate.notNull(type, "A type representing the collection elements must be specified");
			Validate.notNull(eval, "An evaluator must be specified");
            this.type = type;
            this.eval = eval;
        }

		@Override
        public Map<K, T[]> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
        	
            final Map<K, List<T>> result = new LinkedHashMap<K, List<T>>();
            for (final T element: object) {
                final K key = this.eval.execute(element, ctx);
                List<T> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<T>();
                    result.put(key, value);
                }
                value.add(element);
            }
            
            return ToMapOfArray.createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    public static final class FromListByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<Map<K, V[]>, List<T>> {

        private final IMapBuilder<K, V, ? super T> mapBuilder;
        private final Type<V> type;
        
        public FromListByMapBuilder(final Type<V> type, final IMapBuilder<K, V, ? super T> mapBuilder) {
            super();
			Validate.notNull(type, "A type representing the collection elements must be specified");
			Validate.notNull(mapBuilder, "A map builder must be specified");
            this.type = type;
            this.mapBuilder = mapBuilder;
        }

		@Override
        public Map<K, V[]> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
        	
            final Map<K, List<V>> result = new LinkedHashMap<K, List<V>>();
            for (final T element: object) {
                final K key = this.mapBuilder.buildKey(element);
                List<V> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<V>();
                    result.put(key, value);
                }
                value.add(this.mapBuilder.buildValue(element));
            }
            
            return ToMapOfArray.createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    public static final class FromListByAlternateElements<T> extends AbstractNullAsNullFunction<Map<T, T[]>, List<T>> {

        private final Type<T> type;
    	
        public FromListByAlternateElements(final Type<T> type) {
            super();
			Validate.notNull(type, "A type representing the collection elements must be specified");
            this.type = type;
        }

		@Override
        public Map<T, T[]> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
        	
            if (object.size() % 2 != 0) {
                throw new IllegalArgumentException("Cannot create a map from objects: the number of objects must be even.");
            }
            
            final Map<T, List<T>> result = new LinkedHashMap<T,List<T>>();
            for (int i = 0, n = object.size() - 1; i < n; i += 2) {
                final T key = object.get(i);
                List<T> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<T>();
                    result.put(key, value);
                }
                value.add(object.get(i + 1));
            }
            
            return ToMapOfArray.createFromMapOfList(this.type, result);
            
        }
        
    }
    
    
    
    
    
    
    
    public static final class FromSetByKeyEval<K, T> extends AbstractNullAsNullFunction<Map<K, T[]>, Set<T>> {

        private final IFunction<K,? super T> eval;
        private final Type<T> type;
        
        public FromSetByKeyEval(final Type<T> type, final IFunction<K,? super T> eval) {
            super();
			Validate.notNull(type, "A type representing the collection elements must be specified");
			Validate.notNull(eval, "An evaluator must be specified");
            this.type = type;
            this.eval = eval;
        }

		@Override
        public Map<K, T[]> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
        	
            final Map<K, List<T>> result = new LinkedHashMap<K, List<T>>();
            for (final T element: object) {
                final K key = this.eval.execute(element, ctx);
                List<T> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<T>();
                    result.put(key, value);
                }
                value.add(element);
            }
            
            return ToMapOfArray.createFromMapOfList(this.type, result);

        }
        
    }

    
    
    
    
    public static final class FromSetByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<Map<K, V[]>, Set<T>> {

        private final IMapBuilder<K, V, ? super T> mapBuilder;
        private final Type<V> type;
        
        public FromSetByMapBuilder(final Type<V> type, final IMapBuilder<K, V, ? super T> mapBuilder) {
            super();
			Validate.notNull(type, "A type representing the collection elements must be specified");
			Validate.notNull(mapBuilder, "A map builder must be specified");
            this.type = type;
            this.mapBuilder = mapBuilder;
        }

		@Override
        public Map<K, V[]> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
        	
            final Map<K, List<V>> result = new LinkedHashMap<K, List<V>>();
            for (final T element: object) {
                final K key = this.mapBuilder.buildKey(element);
                List<V> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<V>();
                    result.put(key, value);
                }
                value.add(this.mapBuilder.buildValue(element));
            }
            
            return ToMapOfArray.createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    public static final class FromSetByAlternateElements<T> extends AbstractNullAsNullFunction<Map<T, T[]>, Set<T>> {

        private final Type<T> type;
    	
        public FromSetByAlternateElements(final Type<T> type) {
            super();
			Validate.notNull(type, "A type representing the collection elements must be specified");
            this.type = type;
        }

		@Override
        public Map<T, T[]> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
        	
            if (object.size() % 2 != 0) {
                throw new IllegalArgumentException("Cannot create a map from objects: the number of objects must be even.");
            }
            
            final List<T> objectAsList = new ArrayList<T>(object);
            final Map<T, List<T>> result = new LinkedHashMap<T, List<T>>();
            for (int i = 0, n = objectAsList.size() - 1; i < n; i += 2) {
                final T key = objectAsList.get(i);
                List<T> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<T>();
                    result.put(key, value);
                }
                value.add(objectAsList.get(i + 1));
            }
            
            return ToMapOfArray.createFromMapOfList(this.type, result);
            
        }
        
    }
    
    
}

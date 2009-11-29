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

package org.op4j.executables.functions.conversion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.FunctionExecutionException;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.functions.AbstractFunc;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class ToMapOfArray {

    
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
    
    
    
    
    public static final class FromArrayByKeyEval<K, T> extends AbstractFunc<Map<K, T[]>, T[]> {

        private final IEval<K,? super T> eval;
        private final Type<T> type;
        
        public FromArrayByKeyEval(final Type<T> type, final IEval<K,? super T> eval) {
            super();
            this.type = type;
            this.eval = eval;
        }
        
        public Type<? super Map<K, T[]>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

		@Override
        public Map<K, T[]> doExecute(final T[] object) throws Exception {
        	
            final Map<K, List<T>> result = new LinkedHashMap<K, List<T>>();
            for (final T element: object) {
                final K key = this.eval.execute(element);
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

    
    
    
    
    public static final class FromArrayByMapBuilder<K, V, T> extends AbstractFunc<Map<K, V[]>, T[]> {

        private final IMapBuild<K, V, ? super T> mapBuilder;
        private final Type<V> type;
        
        public FromArrayByMapBuilder(final Type<V> type, final IMapBuild<K, V, ? super T> mapBuilder) {
            super();
            this.type = type;
            this.mapBuilder = mapBuilder;
        }
        
        public Type<? super Map<K, V[]>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, V[]> doExecute(final T[] object) throws Exception {
        	
            final Map<K, List<V>> result = new LinkedHashMap<K, List<V>>();
            for (final T element: object) {
                final K key = this.mapBuilder.getKey(element);
                List<V> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<V>();
                    result.put(key, value);
                }
                value.add(this.mapBuilder.getValue(element));
            }
            
            return ToMapOfArray.createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    public static final class FromArrayByAlternateElements<T> extends AbstractFunc<Map<T, T[]>, T[]> {

        private final Type<T> type;
    	
        public FromArrayByAlternateElements(final Type<T> type) {
            super();
            this.type = type;
        }
        
        public Type<? super Map<T, T[]>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<T, T[]> doExecute(final T[] object) throws Exception {
        	
            if (object.length % 2 != 0) {
                throw new FunctionExecutionException("Cannot create a map from objects: the number of objects must be even.");
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

    
    
    
    
    
    
    
    public static final class FromListByKeyEval<K, T> extends AbstractFunc<Map<K, T[]>, List<T>> {

        private final IEval<K,? super T> eval;
        private final Type<T> type;
        
        public FromListByKeyEval(final Type<T> type, final IEval<K,? super T> eval) {
            super();
            this.type = type;
            this.eval = eval;
        }
        
        public Type<? super Map<K, T[]>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, T[]> doExecute(final List<T> object) throws Exception {
        	
            final Map<K, List<T>> result = new LinkedHashMap<K, List<T>>();
            for (final T element: object) {
                final K key = this.eval.execute(element);
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

    
    
    
    
    public static final class FromListByMapBuilder<K, V, T> extends AbstractFunc<Map<K, V[]>, List<T>> {

        private final IMapBuild<K, V, ? super T> mapBuilder;
        private final Type<V> type;
        
        public FromListByMapBuilder(final Type<V> type, final IMapBuild<K, V, ? super T> mapBuilder) {
            super();
            this.type = type;
            this.mapBuilder = mapBuilder;
        }
        
        public Type<? super Map<K, V[]>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, V[]> doExecute(final List<T> object) throws Exception {
        	
            final Map<K, List<V>> result = new LinkedHashMap<K, List<V>>();
            for (final T element: object) {
                final K key = this.mapBuilder.getKey(element);
                List<V> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<V>();
                    result.put(key, value);
                }
                value.add(this.mapBuilder.getValue(element));
            }
            
            return ToMapOfArray.createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    public static final class FromListByAlternateElements<T> extends AbstractFunc<Map<T, T[]>, List<T>> {

        private final Type<T> type;
    	
        public FromListByAlternateElements(final Type<T> type) {
            super();
            this.type = type;
        }
        
        public Type<? super Map<T, T[]>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<T, T[]> doExecute(final List<T> object) throws Exception {
        	
            if (object.size() % 2 != 0) {
                throw new FunctionExecutionException("Cannot create a map from objects: the number of objects must be even.");
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
    
    
    
    
    
    
    
    public static final class FromSetByKeyEval<K, T> extends AbstractFunc<Map<K, T[]>, Set<T>> {

        private final IEval<K,? super T> eval;
        private final Type<T> type;
        
        public FromSetByKeyEval(final Type<T> type, final IEval<K,? super T> eval) {
            super();
            this.type = type;
            this.eval = eval;
        }
        
        public Type<? super Map<K, T[]>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, T[]> doExecute(final Set<T> object) throws Exception {
        	
            final Map<K, List<T>> result = new LinkedHashMap<K, List<T>>();
            for (final T element: object) {
                final K key = this.eval.execute(element);
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

    
    
    
    
    public static final class FromSetByMapBuilder<K, V, T> extends AbstractFunc<Map<K, V[]>, Set<T>> {

        private final IMapBuild<K, V, ? super T> mapBuilder;
        private final Type<V> type;
        
        public FromSetByMapBuilder(final Type<V> type, final IMapBuild<K, V, ? super T> mapBuilder) {
            super();
            this.type = type;
            this.mapBuilder = mapBuilder;
        }
        
        public Type<? super Map<K, V[]>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, V[]> doExecute(final Set<T> object) throws Exception {
        	
            final Map<K, List<V>> result = new LinkedHashMap<K, List<V>>();
            for (final T element: object) {
                final K key = this.mapBuilder.getKey(element);
                List<V> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<V>();
                    result.put(key, value);
                }
                value.add(this.mapBuilder.getValue(element));
            }
            
            return ToMapOfArray.createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    public static final class FromSetByAlternateElements<T> extends AbstractFunc<Map<T, T[]>, Set<T>> {

        private final Type<T> type;
    	
        public FromSetByAlternateElements(final Type<T> type) {
            super();
            this.type = type;
        }
        
        public Type<? super Map<T, T[]>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<T, T[]> doExecute(final Set<T> object) throws Exception {
        	
            if (object.size() % 2 != 0) {
                throw new FunctionExecutionException("Cannot create a map from objects: the number of objects must be even.");
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

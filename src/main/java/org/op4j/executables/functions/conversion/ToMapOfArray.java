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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.FunctionExecutionException;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.functions.IFunc;

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
    

    
    
    
    
    public static final class FromArrayByKeyEval<K, T> implements IFunc<Map<K, Set<T>>, T[]> {

        private final IEval<K,? super T> eval;
        
        public FromArrayByKeyEval(final IEval<K,? super T> eval) {
            super();
            this.eval = eval;
        }
        
        public Type<? super Map<K, Set<T>>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<K, Set<T>> execute(final T[] object) throws Exception {
            final Map<K, Set<T>> result = new LinkedHashMap<K, Set<T>>();
            for (final T element: object) {
                final K key = this.eval.execute(element);
                Set<T> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<T>();
                    result.put(key, value);
                }
                value.add(element);
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromArrayByMapBuilder<K, V, T> implements IFunc<Map<K, Set<V>>, T[]> {

        private final IMapBuild<K, V, T> mapBuilder;
        
        public FromArrayByMapBuilder(final IMapBuild<K, V, T> mapBuilder) {
            super();
            this.mapBuilder = mapBuilder;
        }
        
        public Type<? super Map<K, Set<V>>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<K, Set<V>> execute(final T[] object) throws Exception {
            final Map<K, Set<V>> result = new LinkedHashMap<K, Set<V>>();
            for (final T element: object) {
                final K key = this.mapBuilder.getKey(element);
                Set<V> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<V>();
                    result.put(key, value);
                }
                value.add(this.mapBuilder.getValue(element));
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromArrayByAlternateElements<T> implements IFunc<Map<T, Set<T>>, T[]> {

        public FromArrayByAlternateElements() {
            super();
        }
        
        public Type<? super Map<T, Set<T>>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<T, Set<T>> execute(final T[] object) throws Exception {
            if (object.length % 2 != 0) {
                throw new FunctionExecutionException("Cannot create a map from objects: the number of objects must be even.");
            }
            final Map<T, Set<T>> result = new LinkedHashMap<T, Set<T>>();
            for (int i = 0, n = object.length - 1; i < n; i += 2) {
                final T key = object[i];
                Set<T> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<T>();
                    result.put(key, value);
                }
                value.add(object[i + 1]);
            }
            return result;
        }
        
    }

    
    
    
    
    
    
    
    public static final class FromListByKeyEval<K, T> implements IFunc<Map<K, Set<T>>, List<T>> {

        private final IEval<K,? super T> eval;
        
        public FromListByKeyEval(final IEval<K,? super T> eval) {
            super();
            this.eval = eval;
        }
        
        public Type<? super Map<K, Set<T>>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<K, Set<T>> execute(final List<T> object) throws Exception {
            final Map<K, Set<T>> result = new LinkedHashMap<K, Set<T>>();
            for (final T element: object) {
                final K key = this.eval.execute(element);
                Set<T> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<T>();
                    result.put(key, value);
                }
                value.add(element);
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromListByMapBuilder<K, V, T> implements IFunc<Map<K, Set<V>>, List<T>> {

        private final IMapBuild<K, V, T> mapBuilder;
        
        public FromListByMapBuilder(final IMapBuild<K, V, T> mapBuilder) {
            super();
            this.mapBuilder = mapBuilder;
        }
        
        public Type<? super Map<K, Set<V>>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<K, Set<V>> execute(final List<T> object) throws Exception {
            final Map<K, Set<V>> result = new LinkedHashMap<K, Set<V>>();
            for (final T element: object) {
                final K key = this.mapBuilder.getKey(element);
                Set<V> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<V>();
                    result.put(key, value);
                }
                value.add(this.mapBuilder.getValue(element));
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromListByAlternateElements<T> implements IFunc<Map<T, Set<T>>, List<T>> {

        public FromListByAlternateElements() {
            super();
        }
        
        public Type<? super Map<T, Set<T>>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<T, Set<T>> execute(final List<T> object) throws Exception {
            if (object.size() % 2 != 0) {
                throw new FunctionExecutionException("Cannot create a map from objects: the number of objects must be even.");
            }
            final Map<T, Set<T>> result = new LinkedHashMap<T, Set<T>>();
            for (int i = 0, n = object.size() - 1; i < n; i += 2) {
                final T key = object.get(i);
                Set<T> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<T>();
                    result.put(key, value);
                }
                value.add(object.get(i + 1));
            }
            return result;
        }
        
    }
    
    
    
    
    
    
    
    public static final class FromSetByKeyEval<K, T> implements IFunc<Map<K, Set<T>>, Set<T>> {

        private final IEval<K,? super T> eval;
        
        public FromSetByKeyEval(final IEval<K,? super T> eval) {
            super();
            this.eval = eval;
        }
        
        public Type<? super Map<K, Set<T>>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<K, Set<T>> execute(final Set<T> object) throws Exception {
            final Map<K, Set<T>> result = new LinkedHashMap<K, Set<T>>();
            for (final T element: object) {
                final K key = this.eval.execute(element);
                Set<T> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<T>();
                    result.put(key, value);
                }
                value.add(element);
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromSetByMapBuilder<K, V, T> implements IFunc<Map<K, Set<V>>, Set<T>> {

        private final IMapBuild<K, V, T> mapBuilder;
        
        public FromSetByMapBuilder(final IMapBuild<K, V, T> mapBuilder) {
            super();
            this.mapBuilder = mapBuilder;
        }
        
        public Type<? super Map<K, Set<V>>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<K, Set<V>> execute(final Set<T> object) throws Exception {
            final Map<K, Set<V>> result = new LinkedHashMap<K, Set<V>>();
            for (final T element: object) {
                final K key = this.mapBuilder.getKey(element);
                Set<V> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<V>();
                    result.put(key, value);
                }
                value.add(this.mapBuilder.getValue(element));
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromSetByAlternateElements<T> implements IFunc<Map<T, Set<T>>, Set<T>> {

        public FromSetByAlternateElements() {
            super();
        }
        
        public Type<? super Map<T, Set<T>>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        public Map<T, Set<T>> execute(final Set<T> object) throws Exception {
            if (object.size() % 2 != 0) {
                throw new FunctionExecutionException("Cannot create a map from objects: the number of objects must be even.");
            }
            final List<T> objectAsList = new ArrayList<T>(object);
            final Map<T, Set<T>> result = new LinkedHashMap<T, Set<T>>();
            for (int i = 0, n = objectAsList.size() - 1; i < n; i += 2) {
                final T key = objectAsList.get(i);
                Set<T> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<T>();
                    result.put(key, value);
                }
                value.add(objectAsList.get(i + 1));
            }
            return result;
        }
        
    }
    
    
}

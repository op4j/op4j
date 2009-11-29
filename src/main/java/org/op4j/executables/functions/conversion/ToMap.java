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
public class ToMap {

    
    private ToMap() {
        super();
    }
    

    
    
    
    
    public static final class FromArrayByKeyEval<K, T> extends AbstractFunc<Map<K, T>, T[]> {

        private final IEval<K,? super T> eval;
        
        public FromArrayByKeyEval(final IEval<K,? super T> eval) {
            super();
            this.eval = eval;
        }
        
        public Type<? super Map<K, T>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, T> doExecute(final T[] object) throws Exception {
            final Map<K, T> result = new LinkedHashMap<K, T>();
            for (final T element: object) {
                result.put(this.eval.execute(element), element);
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromArrayByMapBuilder<K, V, T> extends AbstractFunc<Map<K, V>, T[]> {

        private final IMapBuild<K, V, ? super T> mapBuilder;
        
        public FromArrayByMapBuilder(final IMapBuild<K, V, ? super T> mapBuilder) {
            super();
            this.mapBuilder = mapBuilder;
        }
        
        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, V> doExecute(final T[] object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final T element: object) {
                result.put(this.mapBuilder.getKey(element), this.mapBuilder.getValue(element));
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromArrayByAlternateElements<T> extends AbstractFunc<Map<T, T>, T[]> {

        public FromArrayByAlternateElements() {
            super();
        }
        
        public Type<? super Map<T, T>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<T, T> doExecute(final T[] object) throws Exception {
            if (object.length % 2 != 0) {
                throw new FunctionExecutionException("Cannot create a map from objects: the number of objects must be even.");
            }
            final Map<T, T> result = new LinkedHashMap<T, T>();
            for (int i = 0, n = object.length - 1; i < n; i += 2) {
                result.put(object[i], object[i + 1]);
            }
            return result;
        }
        
    }

    
    
    
    
    
    
    
    public static final class FromListByKeyEval<K, T> extends AbstractFunc<Map<K, T>, List<T>> {

        private final IEval<K,? super T> eval;
        
        public FromListByKeyEval(final IEval<K,? super T> eval) {
            super();
            this.eval = eval;
        }
        
        public Type<? super Map<K, T>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, T> doExecute(final List<T> object) throws Exception {
            final Map<K, T> result = new LinkedHashMap<K, T>();
            for (final T element: object) {
                result.put(this.eval.execute(element), element);
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromListByMapBuilder<K, V, T> extends AbstractFunc<Map<K, V>, List<T>> {

        private final IMapBuild<K, V, ? super T> mapBuilder;
        
        public FromListByMapBuilder(final IMapBuild<K, V, ? super T> mapBuilder) {
            super();
            this.mapBuilder = mapBuilder;
        }
        
        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, V> doExecute(final List<T> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final T element: object) {
                result.put(this.mapBuilder.getKey(element), this.mapBuilder.getValue(element));
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromListByAlternateElements<T> extends AbstractFunc<Map<T, T>, List<T>> {

        public FromListByAlternateElements() {
            super();
        }
        
        public Type<? super Map<T, T>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<T, T> doExecute(final List<T> object) throws Exception {
            if (object.size() % 2 != 0) {
                throw new FunctionExecutionException("Cannot create a map from objects: the number of objects must be even.");
            }
            final Map<T, T> result = new LinkedHashMap<T, T>();
            for (int i = 0, n = object.size() - 1; i < n; i += 2) {
                result.put(object.get(i), object.get(i + 1));
            }
            return result;
        }
        
    }
    
    
    
    
    
    
    
    public static final class FromSetByKeyEval<K, T> extends AbstractFunc<Map<K, T>, Set<T>> {

        private final IEval<K,? super T> eval;
        
        public FromSetByKeyEval(final IEval<K,? super T> eval) {
            super();
            this.eval = eval;
        }
        
        public Type<? super Map<K, T>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, T> doExecute(final Set<T> object) throws Exception {
            final Map<K, T> result = new LinkedHashMap<K, T>();
            for (final T element: object) {
                result.put(this.eval.execute(element), element);
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromSetByMapBuilder<K, V, T> extends AbstractFunc<Map<K, V>, Set<T>> {

        private final IMapBuild<K, V, ? super T> mapBuilder;
        
        public FromSetByMapBuilder(final IMapBuild<K, V, ? super T> mapBuilder) {
            super();
            this.mapBuilder = mapBuilder;
        }
        
        public Type<? super Map<K, V>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<K, V> doExecute(final Set<T> object) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final T element: object) {
                result.put(this.mapBuilder.getKey(element), this.mapBuilder.getValue(element));
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromSetByAlternateElements<T> extends AbstractFunc<Map<T, T>, Set<T>> {

        public FromSetByAlternateElements() {
            super();
        }
        
        public Type<? super Map<T, T>> getResultType() {
            return Types.MAP_OF_UNKNOWN_UNKNOWN;
        }

        @Override
        public Map<T, T> doExecute(final Set<T> object) throws Exception {
            if (object.size() % 2 != 0) {
                throw new FunctionExecutionException("Cannot create a map from objects: the number of objects must be even.");
            }
            final List<T> objectAsList = new ArrayList<T>(object);
            final Map<T, T> result = new LinkedHashMap<T, T>();
            for (int i = 0, n = objectAsList.size() - 1; i < n; i += 2) {
                result.put(objectAsList.get(i), objectAsList.get(i + 1));
            }
            return result;
        }
        
    }
    
    
}

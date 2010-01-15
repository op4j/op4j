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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.FunctionExecutionException;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;

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
    

    
    
    
    
    public static final class FromArrayByKeyEval<K, T> extends AbstractNullAsNullConverter<Map<K, T>, T[]> {

        private final IEvaluator<K,? super T> eval;
        
        public FromArrayByKeyEval(final IEvaluator<K,? super T> eval) {
            super();
			Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

		@SuppressWarnings("unchecked")
		public Type<? extends Map<K, T>> getResultType(final Type<? extends T[]> targetType) {
			final Type<T> typeT = Types.arrayComponentOf((Type<T[]>)targetType);
			return Types.mapOf((Type<K>)this.eval.getResultType(typeT), typeT);
		}

        @Override
        public Map<K, T> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final Map<K, T> result = new LinkedHashMap<K, T>();
            for (final T element: object) {
                result.put(this.eval.execute(element, ctx), element);
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromArrayByMapBuilder<K, V, T> extends AbstractNullAsNullConverter<Map<K, V>, T[]> {

        private final IMapBuilder<K, V, ? super T> mapBuilder;
        
        public FromArrayByMapBuilder(final IMapBuilder<K, V, ? super T> mapBuilder) {
            super();
			Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

		@SuppressWarnings("unchecked")
		public Type<? extends Map<K, V>> getResultType(final Type<? extends T[]> targetType) {
			final Type<T> typeT = Types.arrayComponentOf((Type<T[]>)targetType);
			return Types.mapOf((Type<K>)this.mapBuilder.getKeyType(typeT), (Type<V>)this.mapBuilder.getValueType(typeT));
		}

        @Override
        public Map<K, V> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final T element: object) {
                result.put(this.mapBuilder.buildKey(element), this.mapBuilder.buildValue(element));
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromArrayByAlternateElements<T> extends AbstractNullAsNullConverter<Map<T, T>, T[]> {

        public FromArrayByAlternateElements() {
            super();
        }

		@SuppressWarnings("unchecked")
		public Type<? extends Map<T, T>> getResultType(final Type<? extends T[]> targetType) {
			final Type<T> typeT = Types.arrayComponentOf((Type<T[]>)targetType);
			return Types.mapOf(typeT, typeT);
		}

        @Override
        public Map<T, T> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
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

    
    
    
    
    
    
    
    public static final class FromListByKeyEval<K, T> extends AbstractNullAsNullConverter<Map<K, T>, List<T>> {

        private final IEvaluator<K,? super T> eval;
        
        public FromListByKeyEval(final IEvaluator<K,? super T> eval) {
            super();
			Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

		@SuppressWarnings("unchecked")
		public Type<? extends Map<K, T>> getResultType(final Type<? extends List<T>> targetType) {
			final Type<T> typeT = Types.listComponentOf((Type<List<T>>)targetType);
			return Types.mapOf((Type<K>)this.eval.getResultType(typeT), typeT);
		}

        @Override
        public Map<K, T> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, T> result = new LinkedHashMap<K, T>();
            for (final T element: object) {
                result.put(this.eval.execute(element, ctx), element);
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromListByMapBuilder<K, V, T> extends AbstractNullAsNullConverter<Map<K, V>, List<T>> {

        private final IMapBuilder<K, V, ? super T> mapBuilder;
        
        public FromListByMapBuilder(final IMapBuilder<K, V, ? super T> mapBuilder) {
            super();
			Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

		@SuppressWarnings("unchecked")
		public Type<? extends Map<K, V>> getResultType(final Type<? extends List<T>> targetType) {
			final Type<T> typeT = Types.listComponentOf((Type<List<T>>)targetType);
			return Types.mapOf((Type<K>)this.mapBuilder.getKeyType(typeT), (Type<V>)this.mapBuilder.getValueType(typeT));
		}

        @Override
        public Map<K, V> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final T element: object) {
                result.put(this.mapBuilder.buildKey(element), this.mapBuilder.buildValue(element));
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromListByAlternateElements<T> extends AbstractNullAsNullConverter<Map<T, T>, List<T>> {

        public FromListByAlternateElements() {
            super();
        }

		@SuppressWarnings("unchecked")
		public Type<? extends Map<T, T>> getResultType(final Type<? extends List<T>> targetType) {
			final Type<T> typeT = Types.listComponentOf((Type<List<T>>)targetType);
			return Types.mapOf(typeT, typeT);
		}

        @Override
        public Map<T, T> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
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
    
    
    
    
    
    
    
    public static final class FromSetByKeyEval<K, T> extends AbstractNullAsNullConverter<Map<K, T>, Set<T>> {

        private final IEvaluator<K,? super T> eval;
        
        public FromSetByKeyEval(final IEvaluator<K,? super T> eval) {
            super();
			Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

		@SuppressWarnings("unchecked")
		public Type<? extends Map<K, T>> getResultType(final Type<? extends Set<T>> targetType) {
			final Type<T> typeT = Types.setComponentOf((Type<Set<T>>)targetType);
			return Types.mapOf((Type<K>)this.eval.getResultType(typeT), typeT);
		}

        @Override
        public Map<K, T> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, T> result = new LinkedHashMap<K, T>();
            for (final T element: object) {
                result.put(this.eval.execute(element, ctx), element);
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromSetByMapBuilder<K, V, T> extends AbstractNullAsNullConverter<Map<K, V>, Set<T>> {

        private final IMapBuilder<K, V, ? super T> mapBuilder;
        
        public FromSetByMapBuilder(final IMapBuilder<K, V, ? super T> mapBuilder) {
            super();
			Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

		@SuppressWarnings("unchecked")
		public Type<? extends Map<K, V>> getResultType(final Type<? extends Set<T>> targetType) {
			final Type<T> typeT = Types.setComponentOf((Type<Set<T>>)targetType);
			return Types.mapOf((Type<K>)this.mapBuilder.getKeyType(typeT), (Type<V>)this.mapBuilder.getValueType(typeT));
		}

        @Override
        public Map<K, V> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final T element: object) {
                result.put(this.mapBuilder.buildKey(element), this.mapBuilder.buildValue(element));
            }
            return result;
        }
        
    }

    
    
    
    
    public static final class FromSetByAlternateElements<T> extends AbstractNullAsNullConverter<Map<T, T>, Set<T>> {

        public FromSetByAlternateElements() {
            super();
        }

		@SuppressWarnings("unchecked")
		public Type<? extends Map<T, T>> getResultType(final Type<? extends Set<T>> targetType) {
			final Type<T> typeT = Types.setComponentOf((Type<Set<T>>)targetType);
			return Types.mapOf(typeT, typeT);
		}

        @Override
        public Map<T, T> nullAsNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
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

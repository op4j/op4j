/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.op4j.exceptions.ExecutionException;
import org.op4j.util.ExecCtxImpl;
import org.op4j.util.ValuePair;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class FnListOf<T> {

    
    protected final Type<T> type;

    


    public final IFunction<List<T>,List<T>> sort() {
        return new Sort<T>();
    }

    public final IFunction<List<T>,List<T>> sort(final Comparator<? super T> comparator) {
        return new SortByComparator<T>(comparator);
    }
        
    public final IFunction<List<T>,List<T>> distinct() {
        return new Distinct<T>();
    }
    
    public final IFunction<List<T>,List<T>> add(final T... newElements) {
        return new Add<T>(newElements);
    }
    
    public final IFunction<List<T>,List<T>> insert(final int position, final T... newElements) {
        return new Insert<T>(position, newElements);
    }
    
    public final IFunction<List<T>,List<T>> addAll(final Collection<T> collection) {
        return new AddAll<T>(collection);
    }
    
    public final IFunction<List<T>,List<T>> removeAllIndexes(final int... indexes) {
        return new RemoveAllIndexes<T>(indexes);
    }
    
    public final IFunction<List<T>,List<T>> removeAllEqual(final T... values) {
        return new RemoveAllEqual<T>(values);
    }
    
    public final IFunction<List<T>,List<T>> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllTrue<T>(eval);
    }
    
    public final IFunction<List<T>,List<T>> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllFalse<T>(eval);
    }
    
    public final IFunction<List<T>,List<T>> removeAllIndexesNot(final int... indexes) {
        return new RemoveAllIndexesNot<T>(indexes);
    }
    
    public final IFunction<List<T>,List<T>> removeAllNull() {
        return new RemoveAllNull<T>();
    }
    
    public final IFunction<List<T>,List<T>> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNotNullAndTrue<T>(eval);
    }
    
    public final IFunction<List<T>,List<T>> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNotNullAndFalse<T>(eval);
    }
    
    public final IFunction<List<T>,List<T>> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNullOrTrue<T>(eval);
    }
    
    public final IFunction<List<T>,List<T>> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNullOrFalse<T>(eval);
    }
    
    
    
    public final IFunction<List<T>,T[]> toArray() {
        return new ToArray<T>(this.type);
    }
    
    public final IFunction<List<T>,Set<T>> toSet() {
        return new ToSet<T>();
    }
    
    public final <K> IFunction<List<T>,Map<K,T>> toMapByKeyEval(final IFunction<? super T, K> eval) {
        return new ToMapByKeyEval<K,T>(eval);
    }
    
    public final <K,V> IFunction<List<T>,Map<K,V>> toMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new ToMapByMapBuilder<K,V,T>(mapBuilder);
    }
    
    public final IFunction<List<T>,Map<T,T>> toMapByAlternateElements() {
        return new ToMapByAlternateElements<T>();
    }
    
    public final <K> IFunction<List<T>,Map<K,T[]>> toMapOfArrayByKeyEval(final IFunction<? super T, K> eval) {
        return new ToMapOfArrayByKeyEval<K,T>(this.type, eval);
    }
    
    public final <K,V> IFunction<List<T>,Map<K,V[]>> toMapOfArrayOf(final Type<V> valueType, final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new ToMapOfArrayByMapBuilder<K,V,T>(valueType, mapBuilder);
    }
    
    public final IFunction<List<T>,Map<T,T[]>> toMapOfArrayByAlternateElements() {
        return new ToMapOfArrayByAlternateElements<T>(this.type);
    }
    
    public final <K> IFunction<List<T>,Map<K,List<T>>> toMapOfListByKeyEval(final IFunction<? super T, K> eval) {
        return new ToMapOfListByKeyEval<K,T>(eval);
    }
    
    public final <K,V> IFunction<List<T>,Map<K,List<V>>> toMapOfList(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new ToMapOfListByMapBuilder<K,V,T>(mapBuilder);
    }
    
    public final IFunction<List<T>,Map<T,List<T>>> toMapOfListByAlternateElements() {
        return new ToMapOfListByAlternateElements<T>();
    }
    
    public final <K> IFunction<List<T>,Map<K,Set<T>>> toMapOfSetByKeyEval(final IFunction<? super T, K> eval) {
        return new ToMapOfSetByKeyEval<K,T>(eval);
    }
    
    public final <K,V> IFunction<List<T>,Map<K,Set<V>>> toMapOfSet(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new ToMapOfSetByMapBuilder<K,V,T>(mapBuilder);
    }
    
    public final IFunction<List<T>,Map<T,Set<T>>> toMapOfSetByAlternateElements() {
        return new ToMapOfSetByAlternateElements<T>();
    }
    
    
    
    
    
    
    public final IFunction<T,List<T>> unfold(final IFunction<? super T,? extends T> function, final IFunction<? super T,Boolean> unless) {
        return new Unfold<T>(function, unless);
    }
    
    public final IFunction<T,List<T>> unfold(final IFunction<? super T,? extends T> function) {
        return new Unfold<T>(function, null);
    }
    

    
    public final IFunction<List<T>,T> reduce(final IFunction<ValuePair<T,T>,T> function) {
        return new Reduce<T>(function);
    }
    
    public final <I> IFunction<List<T>,I> reduce(final IFunction<ValuePair<I,T>,I> function, final I initialValue) {
        return new ReduceInitialValue<T,I>(function, initialValue);
    }

    
    
    
    
    
    
    protected FnListOf(final Type<T> type) {
        super();
        this.type = type;
    }

    
    
    
    static final class Sort<T> extends FnCollection.Sort<T, List<T>> {

        Sort() {
            super();
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }

    }


    
    
    static final class SortByComparator<T> extends FnCollection.SortByComparator<T, List<T>> {

        SortByComparator(final Comparator<? super T> comparator) {
            super(comparator);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }

    }
    
    
    
    
    static final class Distinct<T> extends AbstractNotNullNonConvertingFunc<List<T>> {

        Distinct() {
            super();
        }

        @Override
        protected List<T> notNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            return new ArrayList<T>(new LinkedHashSet<T>(object));
        }

    }

    
    
    
    
    static final class Add<T> extends FnCollection.Add<T, List<T>> {

        Add(final T... newElements) {
            super(newElements);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    
    static final class Insert<T> extends FnCollection.Insert<T, List<T>> {

        Insert(final int position, T... newElements) {
            super(position, newElements);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    
    
    static final class AddAll<T> extends FnCollection.AddAll<T, List<T>> {

        AddAll(final Collection<T> collection) {
            super(collection);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    static final class RemoveAllIndexes<T> extends FnCollection.RemoveAllIndexes<T, List<T>> {

        
        RemoveAllIndexes(final int... indexes) {
            super(indexes);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    static final class RemoveAllEqual<T> extends FnCollection.RemoveAllEqual<T, List<T>> {

        RemoveAllEqual(final T... values) {
            super(values);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    static final class RemoveAllTrue<T> extends FnCollection.RemoveAllTrue<T, List<T>> {

        RemoveAllTrue(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    static final class RemoveAllFalse<T> extends FnCollection.RemoveAllTrue<T, List<T>> {

        RemoveAllFalse(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    static final class RemoveAllIndexesNot<T> extends FnCollection.RemoveAllIndexesNot<T, List<T>> {

        RemoveAllIndexesNot(final int... indexes) {
            super(indexes);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    static final class RemoveAllNull<T> extends FnCollection.RemoveAllNull<T, List<T>> {

        RemoveAllNull() {
            super();
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    static final class RemoveAllNotNullAndTrue<T> extends FnCollection.RemoveAllNotNullAndTrue<T, List<T>> {

        RemoveAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    static final class RemoveAllNotNullAndFalse<T> extends FnCollection.RemoveAllNotNullAndTrue<T, List<T>> {

        RemoveAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    static final class RemoveAllNullOrTrue<T> extends FnCollection.RemoveAllNullOrTrue<T, List<T>> {

        RemoveAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    static final class RemoveAllNullOrFalse<T> extends FnCollection.RemoveAllNullOrTrue<T, List<T>> {

        RemoveAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    
    
    static final class ToArray<T> extends AbstractNullAsNullFunction<List<T>,T[]>  {

        private final Type<T> type;
        
        ToArray(final Type<T> type) {
            super();
            Validate.notNull(type, "A type representing the collection elements must be specified");
            this.type = type;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T[] nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            final T[] array = (T[]) Array.newInstance(this.type.getRawClass(), result.size());
            return result.toArray(array);
        }
        
    }
    

    
    
    
    
    static final class ToSet<T> extends AbstractNullAsNullFunction<List<T>,Set<T>> {

        ToSet() {
            super();
        }

        @Override
        protected Set<T> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            return new LinkedHashSet<T>(object);
        }
        
    }
    
    
    
    
    
    
    
    static final class ToMapByKeyEval<K, T> extends AbstractNullAsNullFunction<List<T>,Map<K, T>>  {

        private final IFunction<? super T,K>  eval;
        
        ToMapByKeyEval(final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<K, T> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, T> result = new LinkedHashMap<K, T>();
            for (final T element: object) {
                result.put(this.eval.execute(element, ctx), element);
            }
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<List<T>,Map<K, V>>  {

        private final IFunction<? super T,Map.Entry<K,V>> mapBuilder;
        
        ToMapByMapBuilder(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
            super();
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, V> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final T element: object) {
                final Map.Entry<K,V> entry = this.mapBuilder.execute(element, ctx);
                if (entry == null) {
                    throw new ExecutionException(
                            "Map builder returned null, but a map builder should never return null");
                }
                result.put(entry.getKey(), entry.getValue());
            }
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapByAlternateElements<T> extends AbstractNullAsNullFunction<List<T>,Map<T, T>>  {

        ToMapByAlternateElements() {
            super();
        }

        @Override
        protected Map<T, T> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            if (object.size() % 2 != 0) {
                throw new IllegalArgumentException("Cannot create a map from objects: the number of objects must be even.");
            }
            final Map<T, T> result = new LinkedHashMap<T, T>();
            for (int i = 0, n = object.size() - 1; i < n; i += 2) {
                result.put(object.get(i), object.get(i + 1));
            }
            return result;
        }
        
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
    
    
    
    
    static final class ToMapOfArrayByKeyEval<K, T> extends AbstractNullAsNullFunction<List<T>,Map<K, T[]>>  {

        private final IFunction<? super T,K>  eval;
        private final Type<T> type;
        
        ToMapOfArrayByKeyEval(final Type<T> type, final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(type, "A type representing the collection elements must be specified");
            Validate.notNull(eval, "An evaluator must be specified");
            this.type = type;
            this.eval = eval;
        }

        @Override
        protected Map<K, T[]> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            
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
            
            return createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    static final class ToMapOfArrayByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<List<T>,Map<K, V[]>>  {

        private final IFunction<? super T,Map.Entry<K,V>> mapBuilder;
        private final Type<V> type;
        
        ToMapOfArrayByMapBuilder(final Type<V> type, final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
            super();
            Validate.notNull(type, "A type representing the collection elements must be specified");
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.type = type;
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, V[]> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            
            final Map<K, List<V>> result = new LinkedHashMap<K, List<V>>();
            for (final T element: object) {
                final Map.Entry<K,V> entry = this.mapBuilder.execute(element, ctx);
                if (entry == null) {
                    throw new ExecutionException(
                            "Map builder returned null, but a map builder should never return null");
                }
                final K key = entry.getKey();
                List<V> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<V>();
                    result.put(key, value);
                }
                value.add(entry.getValue());
            }
            
            return createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    static final class ToMapOfArrayByAlternateElements<T> extends AbstractNullAsNullFunction<List<T>,Map<T, T[]>>  {

        private final Type<T> type;
        
        ToMapOfArrayByAlternateElements(final Type<T> type) {
            super();
            Validate.notNull(type, "A type representing the collection elements must be specified");
            this.type = type;
        }

        @Override
        protected Map<T, T[]> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            
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
            
            return createFromMapOfList(this.type, result);
            
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    static final class ToMapOfListByKeyEval<K, T> extends AbstractNullAsNullFunction<List<T>,Map<K, List<T>>>  {

        private final IFunction<? super T,K>  eval;
        
        ToMapOfListByKeyEval(final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<K, List<T>> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
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
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapOfListByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<List<T>,Map<K, List<V>>>  {

        private final IFunction<? super T,Map.Entry<K,V>> mapBuilder;
        
        ToMapOfListByMapBuilder(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
            super();
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, List<V>> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, List<V>> result = new LinkedHashMap<K, List<V>>();
            for (final T element: object) {
                final Map.Entry<K,V> entry = this.mapBuilder.execute(element, ctx);
                if (entry == null) {
                    throw new ExecutionException(
                            "Map builder returned null, but a map builder should never return null");
                }
                final K key = entry.getKey();
                List<V> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<V>();
                    result.put(key, value);
                }
                value.add(entry.getValue());
            }
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapOfListByAlternateElements<T> extends AbstractNullAsNullFunction<List<T>,Map<T, List<T>>>  {

        ToMapOfListByAlternateElements() {
            super();
        }

        @Override
        protected Map<T, List<T>> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            if (object.size() % 2 != 0) {
                throw new IllegalArgumentException("Cannot create a map from objects: the number of objects must be even.");
            }
            final Map<T, List<T>> result = new LinkedHashMap<T, List<T>>();
            for (int i = 0, n = object.size() - 1; i < n; i += 2) {
                final T key = object.get(i);
                List<T> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<T>();
                    result.put(key, value);
                }
                value.add(object.get(i + 1));
            }
            return result;
        }
        
    }
    
    
    
    
    
    
    
    
    
    static final class ToMapOfSetByKeyEval<K, T> extends AbstractNullAsNullFunction<List<T>,Map<K, Set<T>>>  {

        private final IFunction<? super T,K>  eval;
        
        ToMapOfSetByKeyEval(final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<K, Set<T>> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, Set<T>> result = new LinkedHashMap<K, Set<T>>();
            for (final T element: object) {
                final K key = this.eval.execute(element, ctx);
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

    
    
    
    
    static final class ToMapOfSetByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<List<T>,Map<K, Set<V>>>  {

        private final IFunction<? super T,Map.Entry<K,V>> mapBuilder;
        
        ToMapOfSetByMapBuilder(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
            super();
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, Set<V>> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, Set<V>> result = new LinkedHashMap<K, Set<V>>();
            for (final T element: object) {
                final Map.Entry<K,V> entry = this.mapBuilder.execute(element, ctx);
                if (entry == null) {
                    throw new ExecutionException(
                            "Map builder returned null, but a map builder should never return null");
                }
                final K key = entry.getKey();
                Set<V> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<V>();
                    result.put(key, value);
                }
                value.add(entry.getValue());
            }
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapOfSetByAlternateElements<T> extends AbstractNullAsNullFunction<List<T>,Map<T, Set<T>>>  {

        ToMapOfSetByAlternateElements() {
            super();
        }

        @Override
        protected Map<T, Set<T>> nullAsNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            if (object.size() % 2 != 0) {
                throw new IllegalArgumentException("Cannot create a map from objects: the number of objects must be even.");
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
    
    
    
    
    
    
    static final class Unfold<T> extends AbstractNotNullFunction<T,List<T>> {
        
        private final IFunction<? super T,? extends T> function;
        private final IFunction<? super T,Boolean> unless;

        
        public Unfold(final IFunction<? super T,? extends T> function, final IFunction<? super T,Boolean> unless) {
            super();
            Validate.notNull(function, "Unfold function cannot be null");
            this.function = function;
            this.unless = unless;
        }

        @Override
        public List<T> notNullExecute(final T input, final ExecCtx ctx) throws Exception {
            
            final List<T> resultList = new ArrayList<T>();
            int index = 0;
            
            T currentTarget = input;
            ExecCtx currentCtx = new ExecCtxImpl(Integer.valueOf(index));

            if (this.unless == null) {
                
                while (currentTarget != null) {
                    resultList.add(currentTarget);
                    index++;
                    currentCtx = new ExecCtxImpl(Integer.valueOf(index));
                    currentTarget = this.function.execute(currentTarget, currentCtx);
                }
                
            } else {
                
                Boolean unlessResult = null;
                resultList.add(currentTarget);
                do {
                    index++;
                    currentCtx = new ExecCtxImpl(Integer.valueOf(index));
                    currentTarget = this.function.execute(currentTarget, currentCtx);
                    resultList.add(currentTarget);
                    unlessResult = this.unless.execute(currentTarget, currentCtx);
                    if (unlessResult == null) {
                        throw new ExecutionException("Unless function returned null!");
                    }
                } while (!unlessResult.booleanValue());
                
            }
            
            return Collections.unmodifiableList(resultList);
            
        }
        
        
    }
    
    

    
    
    
    
    
    static final class Reduce<T> extends AbstractNotNullFunction<List<T>,T> {
        
        private final IFunction<ValuePair<T,T>,T> function;

        
        public Reduce(final IFunction<ValuePair<T,T>, T> function) {
            super();
            Validate.notNull(function, "Reduce function cannot be null");
            this.function = function;
        }

        
        @Override
        public T notNullExecute(final List<T> input, final ExecCtx ctx) throws Exception {
            if (input.size() == 0) {
                throw new ExecutionException("Cannot reduce: array contains no elements");
            }
            if (input.size() == 1) {
                return input.get(0);
            }
            T result = input.get(0);
            
            for (int i = 1, z = input.size(); i < z; i++) {
                final ValuePair<T,T> currentPair = new ValuePair<T,T>(result, input.get(i));
                final ExecCtx currentCtx = new ExecCtxImpl(Integer.valueOf(i - 1));
                result = this.function.execute(currentPair, currentCtx);
            }
            return result;
        }
        
    }
    
    
    
    static final class ReduceInitialValue<R,L> extends AbstractNotNullFunction<List<R>,L> {
        
        private final IFunction<ValuePair<L,R>,L> function;
        private final L initialValue;

        
        public ReduceInitialValue(final IFunction<ValuePair<L,R>, L> function, final L initialValue) {
            super();
            Validate.notNull(function, "Reduce function cannot be null");
            this.function = function;
            this.initialValue = initialValue;
        }

        
        @Override
        public L notNullExecute(final List<R> input, final ExecCtx ctx) throws Exception {
            if (input.size() == 0) {
                return this.initialValue;
            }
            L result = this.initialValue;
            
            for (int i = 0, z = input.size(); i < z; i++) {
                final ValuePair<L,R> currentPair = new ValuePair<L,R>(result, input.get(i));
                final ExecCtx currentCtx = new ExecCtxImpl(Integer.valueOf(i));
                result = this.function.execute(currentPair, currentCtx);
            }
            return result;
        }
        
    }
    
    
    
    
}

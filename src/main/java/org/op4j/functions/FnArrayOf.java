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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class FnArrayOf<T> {

    
    
    protected final Type<T> type;
    
    
    
    
    
    


    public final IFunction<T[],T[]> sort() {
        return new Sort<T>();
    }

    public final IFunction<T[],T[]> sort(final Comparator<? super T> comparator) {
        return new SortByComparator<T>(comparator);
    }
        
    public final IFunction<T[],T[]> distinct() {
        return new Distinct<T>();
    }
    
    public final IFunction<T[],T[]> add(final T... newElements) {
        return new Add<T>(newElements);
    }
    
    public final IFunction<T[],T[]> insert(final int position, final T... newElements) {
        return new Insert<T>(position, newElements);
    }
    
    public final IFunction<T[],T[]> addAll(final Collection<T> collection) {
        return new AddAll<T>(collection);
    }
    
    public final IFunction<T[],T[]> removeAllIndexes(final int... indexes) {
        return new RemoveAllIndexes<T>(indexes);
    }
    
    public final IFunction<T[],T[]> removeAllEqual(final T... values) {
        return new RemoveAllEqual<T>(values);
    }
    
    public final IFunction<T[],T[]> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllTrue<T>(eval);
    }
    
    public final IFunction<T[],T[]> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllFalse<T>(eval);
    }
    
    public final IFunction<T[],T[]> removeAllIndexesNot(final int... indexes) {
        return new RemoveAllIndexesNot<T>(indexes);
    }
    
    public final IFunction<T[],T[]> removeAllNull() {
        return new RemoveAllNull<T>();
    }
    
    public final IFunction<T[],T[]> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNotNullAndTrue<T>(eval);
    }
    
    public final IFunction<T[],T[]> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNotNullAndFalse<T>(eval);
    }
    
    public final IFunction<T[],T[]> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNullOrTrue<T>(eval);
    }
    
    public final IFunction<T[],T[]> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNullOrFalse<T>(eval);
    }

    
    
    public final IFunction<T[],List<T>> toList() {
        return new ToList<T>();
    }
    
    public final IFunction<T[],Set<T>> toSet() {
        return new ToSet<T>();
    }
    
    public final <K> IFunction<T[],Map<K,T>> toMapByKeyEval(final IFunction<? super T, K> eval) {
        return new ToMapByKeyEval<K,T>(eval);
    }
    
    public final <K,V> IFunction<T[],Map<K,V>> toMap(final IMapBuilder<? super T,K,V> mapBuilder) {
        return new ToMapByMapBuilder<K,V,T>(mapBuilder);
    }
    
    public final IFunction<T[],Map<T,T>> toMapByAlternateElements() {
        return new ToMapByAlternateElements<T>();
    }
    
    public final <K> IFunction<T[],Map<K,T[]>> toMapOfArrayByKeyEval(final IFunction<? super T, K> eval) {
        return new ToMapOfArrayByKeyEval<K,T>(this.type, eval);
    }
    
    public final <K,V> IFunction<T[],Map<K,V[]>> toMapOfArrayOf(final Type<V> valueType, final IMapBuilder<? super T,K,V> mapBuilder) {
        return new ToMapOfArrayByMapBuilder<K,V,T>(valueType, mapBuilder);
    }
    
    public final IFunction<T[],Map<T,T[]>> toMapOfArrayByAlternateElements() {
        return new ToMapOfArrayByAlternateElements<T>(this.type);
    }
    
    public final <K> IFunction<T[],Map<K,List<T>>> toMapOfListByKeyEval(final IFunction<? super T, K> eval) {
        return new ToMapOfListByKeyEval<K,T>(eval);
    }
    
    public final <K,V> IFunction<T[],Map<K,List<V>>> toMapOfList(final IMapBuilder<? super T,K,V> mapBuilder) {
        return new ToMapOfListByMapBuilder<K,V,T>(mapBuilder);
    }
    
    public final IFunction<T[],Map<T,List<T>>> toMapOfListByAlternateElements() {
        return new ToMapOfListByAlternateElements<T>();
    }
    
    public final <K> IFunction<T[],Map<K,Set<T>>> toMapOfSetByKeyEval(final IFunction<? super T, K> eval) {
        return new ToMapOfSetByKeyEval<K,T>(eval);
    }
    
    public final <K,V> IFunction<T[],Map<K,Set<V>>> toMapOfSet(final IMapBuilder<? super T,K,V> mapBuilder) {
        return new ToMapOfSetByMapBuilder<K,V,T>(mapBuilder);
    }
    
    public final IFunction<T[],Map<T,Set<T>>> toMapOfSetByAlternateElements() {
        return new ToMapOfSetByAlternateElements<T>();
    }
    
    
    
    
    
    protected FnArrayOf(final Type<T> type) {
        super();
        this.type = type;
    }

    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    protected static final <T> T[] fromList(final Class<?> arrayClass, final List<T> object) {
        final Class<?> componentClass = arrayClass.getComponentType();
        final T[] newArray = (T[]) Array.newInstance(componentClass, new int[] { object.size() });
        return object.toArray(newArray);
    }
    
    
    
    
    static final class Sort<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        Sort() {
            super();
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            return doSort(object, ctx);
        }

        @SuppressWarnings("unchecked")
        private T[] doSort(final T[] object, final ExecCtx ctx) throws Exception {

            final List<?> list = new ArrayList<Object>(Arrays.asList(object));
            Collections.sort((List<Comparable>)list);
            return FnArrayOf.fromList(object.getClass(), (List<T>)(List<?>)list);
            
        }

    }


    
    
    static final class SortByComparator<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private Comparator<? super T> comparator = null;

        SortByComparator(final Comparator<? super T> comparator) {
            super();
            Validate.notNull(comparator, "A comparator must be specified");
            this.comparator = comparator;
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {

            final List<T> list = new ArrayList<T>(Arrays.asList(object));
            Collections.sort(list, this.comparator);
            return FnArrayOf.fromList(object.getClass(), list);
            
        }

    }
    
    
    
    
    static final class Distinct<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        public Distinct() {
            super();
        }

        @Override
        @SuppressWarnings("unchecked")
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {

            Set<?> set = null;
            if (!object.getClass().getComponentType().isArray()) {
                set = new LinkedHashSet<T>(Arrays.asList(object));
            } else {
                set = new ArrayLinkedHashSet<Object>();
                ((ArrayLinkedHashSet<Object>) set).addAll(Arrays
                        .asList((Object[][]) object));
            }

            return FnArrayOf.fromList(object.getClass(), new ArrayList<T>((Set<T>)set));

        }

        private static final class ArrayLinkedHashSet<T> extends LinkedHashSet<T[]> {

            private static final long serialVersionUID = 4483418737509306962L;

            public ArrayLinkedHashSet() {
                super();
            }

            @Override
            public boolean add(T[] e) {
                if (contains(e)) {
                    return false;
                }
                return super.add(e);
            }

            @Override
            @SuppressWarnings("unchecked")
            public boolean contains(Object o) {
                final Iterator<T[]> it = iterator();
                while (it.hasNext()) {
                    if (Arrays.equals(it.next(), (T[]) o)) {
                        return true;
                    }
                }
                return false;
            }

        }

    }

    
    
    
    

    

    
    static final class Add<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final List<T> newElements;
        
        Add(final T... newElements) {
            super();
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.addAll(this.newElements);
            return FnArrayOf.fromList(object.getClass(), result);
        }
        
    }

    
    
    static final class Insert<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final int position;
        private final List<T> newElements;
        
        Insert(final int position, final T... newElements) {
            super();
            this.position = position;
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.addAll(this.position, this.newElements);
            return FnArrayOf.fromList(object.getClass(), result);
        }
        
    }


    
    
    
    static final class AddAll<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final List<T> newElements;
        
        AddAll(final Collection<T> collection) {
            super();
            Validate.notNull(collection, "A collection must be specified");
            this.newElements = new ArrayList<T>(collection);
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.addAll(this.newElements);
            return FnArrayOf.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    static final class RemoveAllIndexes<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final List<Integer> indexes;
        
        RemoveAllIndexes(final int... indexes) {
            super();
            this.indexes = VarArgsUtil.asRequiredIntegerList(indexes);
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            int i = 0;
            for (final T element : object) {
                if (!this.indexes.contains(Integer.valueOf(i))) {
                    result.add(element);
                }
                i++;
            }
            return FnArrayOf.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    static final class RemoveAllEqual<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final List<T> values;
        
        RemoveAllEqual(final T... values) {
            super();
            this.values = VarArgsUtil.asRequiredObjectList(values);
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.removeAll(this.values);
            return FnArrayOf.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    static final class RemoveAllTrue<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final IFunction<? super T,Boolean> eval;
        
        RemoveAllTrue(final IFunction<? super T,Boolean> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (!this.eval.execute(element, ctx).booleanValue()) {
                    result.add(element);
                }
            }
            return FnArrayOf.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    static final class RemoveAllFalse<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final IFunction<? super T,Boolean> eval;
        
        RemoveAllFalse(final IFunction<? super T,Boolean> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (this.eval.execute(element, ctx).booleanValue()) {
                    result.add(element);
                }
            }
            return FnArrayOf.fromList(object.getClass(), result);
        }
        
    }
    
    

    
    
    static final class RemoveAllIndexesNot<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final List<Integer> indexes;
        
        RemoveAllIndexesNot(final int... indexes) {
            super();
            this.indexes = VarArgsUtil.asRequiredIntegerList(indexes);
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            int i = 0;
            for (final T element : object) {
                if (this.indexes.contains(Integer.valueOf(i))) {
                    result.add(element);
                }
                i++;
            }
            return FnArrayOf.fromList(object.getClass(), result);
        }
        
    }

    

    
    
    static final class RemoveAllNull<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        RemoveAllNull() {
            super();
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    result.add(element);
                }
            }
            return FnArrayOf.fromList(object.getClass(), result);
        }
        
    }
    

    

    
    
    static final class RemoveAllNotNullAndTrue<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final IFunction<? super T,Boolean> eval;
        
        RemoveAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (!this.eval.execute(element, ctx).booleanValue()) {
                        result.add(element);
                    }
                } else {
                    result.add(null);
                }
            }
            return FnArrayOf.fromList(object.getClass(), result);
        }
        
    }
    


    
    

    
    
    static final class RemoveAllNotNullAndFalse<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final IFunction<? super T,Boolean> eval;
        
        RemoveAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (this.eval.execute(element, ctx).booleanValue()) {
                        result.add(element);
                    }
                } else {
                    result.add(null);
                }
            }
            return FnArrayOf.fromList(object.getClass(), result);
        }
        
    }
    
    

    
    
    static final class RemoveAllNullOrTrue<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final IFunction<? super T,Boolean> eval;
        
        RemoveAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (!this.eval.execute(element, ctx).booleanValue()) {
                        result.add(element);
                    }
                }
            }
            return FnArrayOf.fromList(object.getClass(), result);
        }
        
    }
    
    
    


    
    
    static final class RemoveAllNullOrFalse<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final IFunction<? super T,Boolean> eval;
        
        RemoveAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (this.eval.execute(element, ctx).booleanValue()) {
                        result.add(element);
                    }
                }
            }
            return FnArrayOf.fromList(object.getClass(), result);
        }
        
    }
    
    
    
    
    
    static final class ToList<T> extends AbstractNullAsNullFunction<T[],List<T>> {

        ToList() {
            super();
        }

        @Override
        protected List<T> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            return new ArrayList<T>(Arrays.asList(object));
        }
        
    }
    
    
    
    static final class ToSet<T> extends AbstractNullAsNullFunction<T[],Set<T>> {

        ToSet() {
            super();
        }

        @Override
        protected Set<T> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            return new LinkedHashSet<T>(Arrays.asList(object));
        }
        
    }

    
    
    
    
    
    
    static final class ToMapByKeyEval<K, T> extends AbstractNullAsNullFunction<T[],Map<K,T>> {

        private final IFunction<? super T,K>  eval;
        
        ToMapByKeyEval(final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<K, T> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final Map<K, T> result = new LinkedHashMap<K, T>();
            for (final T element: object) {
                result.put(this.eval.execute(element, ctx), element);
            }
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<T[],Map<K,V>> {

        private final IMapBuilder<? super T,K,V> mapBuilder;
        
        ToMapByMapBuilder(final IMapBuilder<? super T,K,V> mapBuilder) {
            super();
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, V> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final T element: object) {
                result.put(this.mapBuilder.buildKey(element), this.mapBuilder.buildValue(element));
            }
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapByAlternateElements<T> extends AbstractNullAsNullFunction<T[],Map<T,T>> {

        ToMapByAlternateElements() {
            super();
        }

        @Override
        protected Map<T, T> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            if (object.length % 2 != 0) {
                throw new IllegalArgumentException("Cannot create a map from objects: the number of objects must be even.");
            }
            final Map<T, T> result = new LinkedHashMap<T, T>();
            for (int i = 0, n = object.length - 1; i < n; i += 2) {
                result.put(object[i], object[i + 1]);
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
    
    
    
    
    
    static final class ToMapOfArrayByKeyEval<K, T> extends AbstractNullAsNullFunction<T[],Map<K,T[]>> {

        private final IFunction<? super T,K>  eval;
        private final Type<T> type;
        
        ToMapOfArrayByKeyEval(final Type<T> type, final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(type, "A type representing the array elements must be specified");
            Validate.notNull(eval, "An evaluator must be specified");
            this.type = type;
            this.eval = eval;
        }

        @Override
        protected Map<K, T[]> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            
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

    
    
    
    
    static final class ToMapOfArrayByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<T[],Map<K,V[]>> {

        private final IMapBuilder<? super T,K,V> mapBuilder;
        private final Type<V> type;
        
        ToMapOfArrayByMapBuilder(final Type<V> type, final IMapBuilder<? super T,K,V> mapBuilder) {
            super();
            Validate.notNull(type, "A type representing the array elements must be specified");
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.type = type;
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, V[]> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            
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
            
            return createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    static final class ToMapOfArrayByAlternateElements<T> extends AbstractNullAsNullFunction<T[],Map<T,T[]>> {

        private final Type<T> type;
        
        ToMapOfArrayByAlternateElements(final Type<T> type) {
            super();
            Validate.notNull(type, "A type representing the array elements must be specified");
            this.type = type;
        }

        @Override
        protected Map<T, T[]> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            
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
            
            return createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    
    static final class ToMapOfListByKeyEval<K, T> extends AbstractNullAsNullFunction<T[],Map<K,List<T>>> {

        private final IFunction<? super T,K>  eval;
        
        ToMapOfListByKeyEval(final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<K, List<T>> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
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

    
    
    
    
    static final class ToMapOfListByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<T[],Map<K,List<V>>> {

        private final IMapBuilder<? super T,K,V> mapBuilder;
        
        ToMapOfListByMapBuilder(final IMapBuilder<? super T,K,V> mapBuilder) {
            super();
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, List<V>> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
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
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapOfListByAlternateElements<T> extends AbstractNullAsNullFunction<T[],Map<T,List<T>>> {

        ToMapOfListByAlternateElements() {
            super();
        }

        @Override
        protected Map<T, List<T>> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
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
            return result;
        }
        
    }

    
    
    
    
    
    static final class ToMapOfSetByKeyEval<K, T> extends AbstractNullAsNullFunction<T[],Map<K,Set<T>>> {

        private final IFunction<? super T,K>  eval;
        
        ToMapOfSetByKeyEval(final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<K, Set<T>> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
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

    
    
    
    
    static final class ToMapOfSetByMapBuilder<K, V, T> extends AbstractNullAsNullFunction<T[],Map<K,Set<V>>> {

        private final IMapBuilder<? super T,K,V> mapBuilder;
        
        ToMapOfSetByMapBuilder(final IMapBuilder<? super T,K,V> mapBuilder) {
            super();
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, Set<V>> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final Map<K, Set<V>> result = new LinkedHashMap<K, Set<V>>();
            for (final T element: object) {
                final K key = this.mapBuilder.buildKey(element);
                Set<V> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<V>();
                    result.put(key, value);
                }
                value.add(this.mapBuilder.buildValue(element));
            }
            return result;
        }
        
    }

    
    
    
    
    static final class ToMapOfSetByAlternateElements<T> extends AbstractNullAsNullFunction<T[],Map<T,Set<T>>> {

        ToMapOfSetByAlternateElements() {
            super();
        }

        @Override
        protected Map<T, Set<T>> nullAsNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            if (object.length % 2 != 0) {
                throw new IllegalArgumentException("Cannot create a map from objects: the number of objects must be even.");
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

    
    
    
}

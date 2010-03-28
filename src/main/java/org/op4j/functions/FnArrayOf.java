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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.op4j.exceptions.ExecutionException;
import org.op4j.util.ExecCtxImpl;
import org.op4j.util.ValuePair;
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
    
    
    
    
    
    


    public final Function<T[],T[]> sort() {
        return new Sort<T>();
    }

    public final Function<T[],T[]> sort(final Comparator<? super T> comparator) {
        return new SortByComparator<T>(comparator);
    }
    
    public final Function<T[],T[]> sortBy(final IFunction<? super T, ?> by) {
        return new SortBy<T>(by);
    }
    
        
    public final Function<T[],T[]> distinct() {
        return new Distinct<T>();
    }
    
    public final Function<T[],T[]> add(final T... newElements) {
        return new Add<T>(newElements);
    }
    
    public final Function<T[],T[]> insert(final int position, final T... newElements) {
        return new Insert<T>(position, newElements);
    }
    
    public final Function<T[],T[]> addAll(final Collection<T> collection) {
        return new AddAll<T>(collection);
    }
    
    public final Function<T[],T[]> removeAllIndexes(final int... indexes) {
        return new RemoveAllIndexes<T>(indexes);
    }
    
    public final Function<T[],T[]> removeAllEqual(final T... values) {
        return new RemoveAllEqual<T>(values);
    }
    
    public final Function<T[],T[]> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllTrue<T>(eval);
    }
    
    public final Function<T[],T[]> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllFalse<T>(eval);
    }
    
    public final Function<T[],T[]> removeAllIndexesNot(final int... indexes) {
        return new RemoveAllIndexesNot<T>(indexes);
    }
    
    public final Function<T[],T[]> removeAllNull() {
        return new RemoveAllNull<T>();
    }
    
    public final Function<T[],T[]> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNotNullAndTrue<T>(eval);
    }
    
    public final Function<T[],T[]> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNotNullAndFalse<T>(eval);
    }
    
    public final Function<T[],T[]> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNullOrTrue<T>(eval);
    }
    
    public final Function<T[],T[]> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNullOrFalse<T>(eval);
    }

    
    
    public final Function<T[],List<T>> toList() {
        return new ToList<T>();
    }
    
    public final Function<T[],Set<T>> toSet() {
        return new ToSet<T>();
    }
    
    public final <K> Function<T[],Map<K,T>> zipKeysBy(final IFunction<? super T, K> eval) {
        return new ZipKeysBy<K,T>(eval);
    }
    
    public final <V> Function<T[],Map<T,V>> zipValuesBy(final IFunction<? super T, V> eval) {
        return new ZipValuesBy<T,V>(eval);
    }
    
    public final <K> Function<T[],Map<K,T>> zipKeys(final K... keys) {
        return new ZipKeys<K,T>(VarArgsUtil.asRequiredObjectList(keys));
    }
    
    public final <V> Function<T[],Map<T,V>> zipValues(final V... values) {
        return new ZipValues<T,V>(VarArgsUtil.asRequiredObjectList(values));
    }
    
    public final <K> Function<T[],Map<K,T>> zipKeysFrom(final Collection<K> keys) {
        return new ZipKeys<K,T>(keys);
    }
    
    public final <V> Function<T[],Map<T,V>> zipValuesFrom(final Collection<V> values) {
        return new ZipValues<T,V>(values);
    }
    
    public final <K> Function<T[],Map<K,T>> zipKeysFrom(final K[] keys) {
        return new ZipKeys<K,T>(keys);
    }
    
    public final <V> Function<T[],Map<T,V>> zipValuesFrom(final V[] values) {
        return new ZipValues<T,V>(values);
    }
    
    public final <K,V> Function<T[],Map<K,V>> toMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new ToMap<K,V,T>(mapBuilder);
    }
    
    public final <K,V> Function<T[],Map<K,V[]>> toGroupMapOf(final Type<V> valueType, final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new ToGroupMap<K,V,T>(valueType, mapBuilder);
    }
    
    public final Function<T[],Map<T,T>> couple() {
        return new Couple<T>();
    }
    
    public final <K> Function<T[],Map<K,T[]>> zipAndGroupKeysBy(final IFunction<? super T, K> eval) {
        return new ZipAndGroupKeysBy<K,T>(this.type, eval);
    }
    
    public final <V> Function<T[],Map<T,V[]>> zipAndGroupValuesBy(final Type<V> valueType, final IFunction<? super T, V> eval) {
        return new ZipAndGroupValuesBy<T,V>(valueType, eval);
    }
    
    public final <K> Function<T[],Map<K,T[]>> zipAndGroupKeys(final K... keys) {
        return new ZipAndGroupKeys<K,T>(this.type, VarArgsUtil.asRequiredObjectList(keys));
    }
    
    public final <V> Function<T[],Map<T,V[]>> zipAndGroupValues(final Type<V> valueType, final V... values) {
        return new ZipAndGroupValues<T,V>(valueType, VarArgsUtil.asRequiredObjectList(values));
    }
    
    public final <K> Function<T[],Map<K,T[]>> zipAndGroupKeysFrom(final Collection<K> keys) {
        return new ZipAndGroupKeys<K,T>(this.type, keys);
    }
    
    public final <V> Function<T[],Map<T,V[]>> zipAndGroupValuesFrom(final Type<V> valueType, final Collection<V> values) {
        return new ZipAndGroupValues<T,V>(valueType, values);
    }
    
    public final <K> Function<T[],Map<K,T[]>> zipAndGroupKeysFrom(final K[] keys) {
        return new ZipAndGroupKeys<K,T>(this.type, keys);
    }
    
    public final <V> Function<T[],Map<T,V[]>> zipAndGroupValuesFrom(final Type<V> valueType, final V[] values) {
        return new ZipAndGroupValues<T,V>(valueType, values);
    }
    

    
    
    public final Function<T[],Map<T,T[]>> coupleAndGroup() {
        return new CoupleAndGroup<T>(this.type);
    }
    
    
    
    
    public final Function<T,T[]> unfold(final IFunction<? super T,? extends T> function, final IFunction<? super T,Boolean> whileCondition) {
        return new Unfold<T>(function, whileCondition, this.type);
    }
    
    public final Function<T,T[]> unfold(final IFunction<? super T,? extends T> function) {
        return new Unfold<T>(function, null, this.type);
    }
    

    
    public final Function<T[],T> reduce(final IFunction<? extends ValuePair<? super T,? super T>, ? extends T> function) {
        return new Reduce<T>(function);
    }

    
    public final <R> Function<T[],R> reduce(final IFunction<? extends ValuePair<? super R,? super T>,R> function, final R initialValue) {
        return new ReduceInitialValue<T,R>(function, initialValue);
    }


    
    
    public final Function<T[],Boolean> all(final IFunction<? super T,Boolean> eval) {
        return new All<T>(eval);
    }
    
    public final Function<T[],Boolean> any(final IFunction<? super T,Boolean> eval) {
        return new Any<T>(eval);
    }
    
    
    
    
    public final Function<Object[],Integer> count() {
        return FnArray.count();
    }

    
    
    
    public final Function<T[],Boolean> contains(final T object) {
        return new Contains<T>(object);
    }
    
    public final Function<T[],Boolean> notContains(final T object) {
        return Fn.not(contains(object));
    }
    
    public final Function<T[],Boolean> containsAll(final T... objects) {
        return new ContainsAll<T>(VarArgsUtil.asRequiredObjectList(objects));
    }
    
    public final Function<T[],Boolean> containsAny(final T... objects) {
        return new ContainsAny<T>(VarArgsUtil.asRequiredObjectList(objects));
    }
    
    public final Function<T[],Boolean> containsNone(final T... objects) {
        return new ContainsNone<T>(VarArgsUtil.asRequiredObjectList(objects));
    }


    
    
    public final Function<T[],T[]> reverse() {
        return new Reverse<T>();
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
    
    
    
    
    static final class SortBy<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final IFunction<? super T, ?> by;
        
        SortBy(final IFunction<? super T, ?> by) {
            super();
            this.by = by;
        }

        @Override
        protected T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {

            final List<OrderableElement<T>> ordList = new ArrayList<OrderableElement<T>>();
            int index = 0;
            for (final T element : object) {
                ordList.add(
                    new OrderableElement<T>(
                        element, 
                        (Comparable<?>) this.by.execute(element, new ExecCtxImpl(Integer.valueOf(index)))));
            }
            Collections.sort(ordList);
            final List<T> resultList = new ArrayList<T>();
            for (final OrderableElement<T> element : ordList) {
                resultList.add(element.getElement());
            }
            return FnArrayOf.fromList(object.getClass(), resultList);
            
        }
        
        private static class OrderableElement<T> implements Comparable<OrderableElement<T>> {

            private final T element;
            private final Comparable<?> comparator;
            
            public OrderableElement(final T element, final Comparable<?> comparator) {
                super();
                this.element = element;
                this.comparator = comparator;
                if (this.comparator == null) {
                    throw new NullPointerException("Cannot sort null elements");
                }
            }
            
            public T getElement() {
                return this.element;
            }

            public Comparable<?> getComparator() {
                return this.comparator;
            }

            @SuppressWarnings("unchecked")
            public int compareTo(OrderableElement<T> o) {
                if (this.comparator == null) {
                    throw new NullPointerException("Cannot sort null elements");
                }
                return ((Comparable)this.comparator).compareTo(o.getComparator());
            }

            @Override
            public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result
                        + ((this.comparator == null) ? 0 : this.comparator.hashCode());
                return result;
            }

            @Override
            @SuppressWarnings("unchecked")
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null) {
                    return false;
                }
                if (getClass() != obj.getClass()) {
                    return false;
                }
                final OrderableElement<T> other = (OrderableElement<T>) obj;
                return this.comparator.equals(other.comparator);
            }
            
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
    
    
    
    
    
    static final class ToList<T> extends AbstractNotNullFunction<T[],List<T>> {

        ToList() {
            super();
        }

        @Override
        protected List<T> notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            return new ArrayList<T>(Arrays.asList(object));
        }
        
    }
    
    
    
    static final class ToSet<T> extends AbstractNotNullFunction<T[],Set<T>> {

        ToSet() {
            super();
        }

        @Override
        protected Set<T> notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            return new LinkedHashSet<T>(Arrays.asList(object));
        }
        
    }

    
    
    
    
    
    
    static final class ZipKeysBy<K, T> extends AbstractNotNullFunction<T[],Map<K,T>> {

        private final IFunction<? super T,K>  eval;
        
        ZipKeysBy(final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<K, T> notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final Map<K, T> result = new LinkedHashMap<K, T>();
            for (final T element: object) {
                result.put(this.eval.execute(element, ctx), element);
            }
            return result;
        }
        
    }
    
    
    
    static final class ZipValuesBy<T, V> extends AbstractNotNullFunction<T[],Map<T, V>> {

        private final IFunction<? super T,V>  eval;
        
        ZipValuesBy(final IFunction<? super T,V>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<T, V> notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final Map<T, V> result = new LinkedHashMap<T, V>();
            for (final T element: object) {
                result.put(element, this.eval.execute(element, ctx));
            }
            return result;
        }
        
    }
    
    
    


    
    
    static final class ZipKeys<K, T> extends AbstractNotNullFunction<T[],Map<K, T>>  {

        private final List<K> keys;
        
        ZipKeys(final Collection<K> keys) {
            super();
            Validate.notNull(keys, "Keys must be specified");
            this.keys = new ArrayList<K>(keys);
        }
        
        ZipKeys(final K[] keys) {
            super();
            Validate.notNull(keys, "Keys must be specified");
            this.keys = Arrays.asList(keys);
        }

        @Override
        protected Map<K, T> notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            if (object.length != this.keys.size()) {
                throw new IllegalArgumentException(
                        "Incorrect number of keys specified: should be " + object.length + 
                        " but are " + this.keys.size());
            }
            final Map<K, T> result = new LinkedHashMap<K, T>();
            int index = 0;
            for (final T element: object) {
                result.put(this.keys.get(index), element);
                index++;
            }
            return result;
        }
        
    }
    
    static final class ZipValues<T, V> extends AbstractNotNullFunction<T[],Map<T, V>>  {

        private final List<V> values;
        
        ZipValues(final Collection<V> values) {
            super();
            Validate.notNull(values, "Values must be specified");
            this.values = new ArrayList<V>(values);
        }
        
        ZipValues(final V[] values) {
            super();
            Validate.notNull(values, "Values must be specified");
            this.values = Arrays.asList(values);
        }

        @Override
        protected Map<T, V> notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            if (object.length != this.values.size()) {
                throw new IllegalArgumentException(
                        "Incorrect number of values specified: should be " + object.length + 
                        " but are " + this.values.size());
            }
            final Map<T, V> result = new LinkedHashMap<T, V>();
            int index = 0;
            for (final T element: object) {
                result.put(element, this.values.get(index));
                index++;
            }
            return result;
        }
        
    }
    
    

    

    
    
    
    
    
    
    
    
    
    static final class ZipAndGroupKeys<K, T> extends AbstractNotNullFunction<T[],Map<K, T[]>>  {

        private final List<K> keys;
        private final Type<T> type;
        
        ZipAndGroupKeys(final Type<T> type, final Collection<K> keys) {
            super();
            Validate.notNull(keys, "Keys must be specified");
            this.keys = new ArrayList<K>(keys);
            this.type = type;
        }
        
        ZipAndGroupKeys(final Type<T> type, final K[] keys) {
            super();
            Validate.notNull(keys, "Keys must be specified");
            this.keys = Arrays.asList(keys);
            this.type = type;
        }

        @Override
        protected Map<K, T[]> notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            
            if (object.length != this.keys.size()) {
                throw new IllegalArgumentException(
                        "Incorrect number of keys specified: should be " + object.length + 
                        " but are " + this.keys.size());
            }
            final Map<K, List<T>> result = new LinkedHashMap<K, List<T>>();
            int index = 0;
            for (final T element: object) {
                final K key = this.keys.get(index);
                List<T> value = result.get(key);
                if (value == null) {
                    value = new ArrayList<T>();
                    result.put(key, value);
                }
                value.add(element);
                index++;
            }
            return createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    static final class ZipAndGroupValues<T, V> extends AbstractNotNullFunction<T[],Map<T,V[]>> {

        private final List<V> values;
        private final Type<V> type;
        
        ZipAndGroupValues(final Type<V> type, final Collection<V> values) {
            super();
            Validate.notNull(values, "Values must be specified");
            this.values = new ArrayList<V>(values);
            this.type = type;
        }
        
        ZipAndGroupValues(final Type<V> type, final V[] values) {
            super();
            Validate.notNull(values, "Values must be specified");
            this.values = Arrays.asList(values);
            this.type = type;
        }

        @Override
        protected Map<T,V[]> notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            
            if (object.length != this.values.size()) {
                throw new IllegalArgumentException(
                        "Incorrect number of values specified: should be " + object.length + 
                        " but are " + this.values.size());
            }
            final Map<T, List<V>> result = new LinkedHashMap<T, List<V>>();
            int index = 0;
            for (final T element: object) {
                final V valueElement = this.values.get(index);
                List<V> value = result.get(element);
                if (value == null) {
                    value = new ArrayList<V>();
                    result.put(element, value);
                }
                value.add(valueElement);
                index++;
            }
            
            return createFromMapOfList(this.type, result);
            
        }
        
    }

    
    
    
    
    
    
    
    
    
    static final class ToMap<K, V, T> extends AbstractNotNullFunction<T[],Map<K,V>> {

        private final IFunction<? super T,Map.Entry<K,V>> mapBuilder;
        
        ToMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
            super();
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, V> notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
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

    
    
    
    
    static final class Couple<T> extends AbstractNotNullFunction<T[],Map<T,T>> {

        Couple() {
            super();
        }

        @Override
        protected Map<T, T> notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
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
    
    
    
    
    
    static final class ZipAndGroupKeysBy<K, T> extends AbstractNotNullFunction<T[],Map<K,T[]>> {

        private final IFunction<? super T,K>  eval;
        private final Type<T> type;
        
        ZipAndGroupKeysBy(final Type<T> type, final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(type, "A type representing the array elements must be specified");
            Validate.notNull(eval, "An evaluator must be specified");
            this.type = type;
            this.eval = eval;
        }

        @Override
        protected Map<K, T[]> notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            
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

    
    
    static final class ZipAndGroupValuesBy<T, V> extends AbstractNotNullFunction<T[],Map<T,V[]>> {

        private final IFunction<? super T,V>  eval;
        private final Type<V> type;
        
        ZipAndGroupValuesBy(final Type<V> type, final IFunction<? super T,V>  eval) {
            super();
            Validate.notNull(type, "A type representing the array elements must be specified");
            Validate.notNull(eval, "An evaluator must be specified");
            this.type = type;
            this.eval = eval;
        }

        @Override
        protected Map<T, V[]> notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            
            final Map<T, List<V>> result = new LinkedHashMap<T, List<V>>();
            for (final T element: object) {
                final V valueElement = this.eval.execute(element, ctx);
                List<V> value = result.get(element);
                if (value == null) {
                    value = new ArrayList<V>();
                    result.put(element, value);
                }
                value.add(valueElement);
            }
            
            return createFromMapOfList(this.type, result);
            
        }
        
    }
    
    
    
    
    static final class ToGroupMap<K, V, T> extends AbstractNotNullFunction<T[],Map<K,V[]>> {

        private final IFunction<? super T,Map.Entry<K,V>> mapBuilder;
        private final Type<V> type;
        
        ToGroupMap(final Type<V> type, final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
            super();
            Validate.notNull(type, "A type representing the array elements must be specified");
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.type = type;
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, V[]> notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            
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

    
    
    
    
    static final class CoupleAndGroup<T> extends AbstractNotNullFunction<T[],Map<T,T[]>> {

        private final Type<T> type;
        
        CoupleAndGroup(final Type<T> type) {
            super();
            Validate.notNull(type, "A type representing the array elements must be specified");
            this.type = type;
        }

        @Override
        protected Map<T, T[]> notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            
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

    
    
    
    static final class Unfold<T> extends AbstractNotNullFunction<T,T[]> {
        
        private final IFunction<? super T,? extends T> function;
        private final IFunction<? super T,Boolean> whileCondition;
        private final Type<T> type;

        
        public Unfold(final IFunction<? super T,? extends T> function, final IFunction<? super T,Boolean> whileCondition, final Type<T> type) {
            super();
            Validate.notNull(function, "Unfold function cannot be null");
            this.function = function;
            this.whileCondition = whileCondition;
            this.type = type;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T[] notNullExecute(final T input, final ExecCtx ctx) throws Exception {
            
            final List<T> resultList = new ArrayList<T>();
            int index = 0;
            
            T currentTarget = input;
            ExecCtx currentCtx = new ExecCtxImpl(Integer.valueOf(index));

            if (this.whileCondition == null) {
                
                while (currentTarget != null) {
                    resultList.add(currentTarget);
                    index++;
                    currentCtx = new ExecCtxImpl(Integer.valueOf(index));
                    currentTarget = this.function.execute(currentTarget, currentCtx);
                }
                
            } else {
                
                Boolean whileResult = this.whileCondition.execute(currentTarget, currentCtx);
                if (whileResult == null) {
                    throw new ExecutionException("Unless function returned null!");
                }

                while (whileResult.booleanValue()) {
                    resultList.add(currentTarget);
                    index++;
                    currentCtx = new ExecCtxImpl(Integer.valueOf(index));
                    currentTarget = this.function.execute(currentTarget, currentCtx);
                    whileResult = this.whileCondition.execute(currentTarget, currentCtx);
                    if (whileResult == null) {
                        throw new ExecutionException("Unless function returned null!");
                    }
                }
                
            }
            
            return resultList.toArray((T[])Array.newInstance(this.type.getRawClass(), resultList.size()));
            
        }
        
        
    }
    
    

    
    
    
    static final class Reduce<T> extends AbstractNotNullFunction<T[],T> {
        
        /*
         * Result has to be "? extends T" instead of "X extends T" because this function 
         * cannot change the operator's type. This is because, if the original structure only
         * has one element, that element has to be returned (and it is of type T, not X).
         */
        private final IFunction<? extends ValuePair<? super T,? super T>, ? extends T> function;

        
        public Reduce(final IFunction<? extends ValuePair<? super T,? super T>, ? extends T> function) {
            super();
            Validate.notNull(function, "Reduce function cannot be null");
            this.function = function;
        }

        
        @Override
        @SuppressWarnings("unchecked")
        public T notNullExecute(final T[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                throw new ExecutionException("Cannot reduce: array contains no elements");
            }
            if (input.length == 1) {
                return input[0];
            }
            T result = input[0];
            
            for (int i = 1, z = input.length; i < z; i++) {
                final ValuePair<T,T> currentPair = new ValuePair<T,T>(result, input[i]);
                final ExecCtx currentCtx = new ExecCtxImpl(Integer.valueOf(i - 1));
                result = (T) ((IFunction)this.function).execute(currentPair, currentCtx);
            }
            return result;
        }
        
    }
    
    
    
    static final class ReduceInitialValue<T,R> extends AbstractNotNullFunction<T[],R> {
        
        private final IFunction<? extends ValuePair<? super R,? super T>,R> function;
        private final R initialValue;

        
        public ReduceInitialValue(final IFunction<? extends ValuePair<? super R,? super T>,R> function, final R initialValue) {
            super();
            Validate.notNull(function, "Reduce function cannot be null");
            this.function = function;
            this.initialValue = initialValue;
        }

        
        @Override
        @SuppressWarnings("unchecked")
        public R notNullExecute(final T[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return this.initialValue;
            }
            R result = this.initialValue;
            
            for (int i = 0, z = input.length; i < z; i++) {
                final ValuePair<R,T> currentPair = new ValuePair<R,T>(result, input[i]);
                final ExecCtx currentCtx = new ExecCtxImpl(Integer.valueOf(i));
                result = (R) ((IFunction)this.function).execute(currentPair, currentCtx);
            }
            return result;
        }
        
    }
    
    
    
    
    static final class Any<T> extends AbstractNotNullFunction<T[],Boolean> {

        private final IFunction<? super T, Boolean> function;
        
        
        public Any(IFunction<? super T, Boolean> function) {
            super();
            this.function = function;
        }
        
        
        @Override
        protected Boolean notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            int index = 0;
            for (final T element : object) {
                final Boolean elementResult = 
                    this.function.execute(element, new ExecCtxImpl(Integer.valueOf(index)));
                if (elementResult == null) {
                    throw new ExecutionException("Evaluation function returned null, which is " +
                    		"not allowed executing \"any\"");
                }
                if (elementResult.booleanValue()) {
                    return Boolean.TRUE;
                }
                index++;
            }
            return Boolean.FALSE;
        }
        
    }

    
    
    static final class All<T> extends AbstractNotNullFunction<T[],Boolean> {

        private final IFunction<? super T, Boolean> function;
        
        
        public All(IFunction<? super T, Boolean> function) {
            super();
            this.function = function;
        }
        
        
        @Override
        protected Boolean notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            int index = 0;
            for (final T element : object) {
                final Boolean elementResult = 
                    this.function.execute(element, new ExecCtxImpl(Integer.valueOf(index)));
                if (elementResult == null) {
                    throw new ExecutionException("Evaluation function returned null, which is " +
                            "not allowed executing \"all\"");
                }
                if (!elementResult.booleanValue()) {
                    return Boolean.FALSE;
                }
                index++;
            }
            return Boolean.TRUE;
        }
        
    }
    
    
    
    
    
    static final class Contains<T> extends AbstractNotNullFunction<T[],Boolean> {
        
        private final T object;
        
        public Contains(final T object) {
            super();
            this.object = object;
        }

        @Override
        protected Boolean notNullExecute(final T[] input, final ExecCtx ctx) throws Exception {
            for (final T element : input) {
                if (element == null) {
                    if (this.object == null) {
                        return Boolean.TRUE;
                    }
                } else if (element.equals(this.object)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
        
    }
    
    
    static final class ContainsAll<T> extends AbstractNotNullFunction<T[],Boolean> {
        
        private final List<T> objects;
        
        public ContainsAll(final List<T> objects) {
            super();
            this.objects = objects;
        }

        @Override
        protected Boolean notNullExecute(final T[] input, final ExecCtx ctx) throws Exception {
            final Set<T> notContained = new HashSet<T>(this.objects);
            for (final T element : input) {
                for (final T comparedElement : this.objects) {
                    if (element == null) {
                        if (comparedElement == null) {
                            notContained.remove(null);
                        }
                    } else if (element.equals(comparedElement)) {
                        notContained.remove(comparedElement);
                    }
                }
            }
            return (notContained.isEmpty()? Boolean.TRUE : Boolean.FALSE);
        }
        
    }
    
    
    
    static final class ContainsAny<T> extends AbstractNotNullFunction<T[],Boolean> {
        
        private final List<T> objects;
        
        public ContainsAny(final List<T> objects) {
            super();
            this.objects = objects;
        }

        @Override
        protected Boolean notNullExecute(final T[] input, final ExecCtx ctx) throws Exception {
            for (final T element : input) {
                for (final T comparedElement : this.objects) {
                    if (element == null) {
                        if (comparedElement == null) {
                            return Boolean.TRUE;
                        }
                    } else if (element.equals(comparedElement)) {
                        return Boolean.TRUE;
                    }
                }
            }
            return Boolean.FALSE;
        }
        
    }
    
    
    
    static final class ContainsNone<T> extends AbstractNotNullFunction<T[],Boolean> {
        
        private final List<T> objects;
        
        public ContainsNone(final List<T> objects) {
            super();
            this.objects = objects;
        }

        @Override
        protected Boolean notNullExecute(final T[] input, final ExecCtx ctx) throws Exception {
            for (final T element : input) {
                for (final T comparedElement : this.objects) {
                    if (element == null) {
                        if (comparedElement == null) {
                            return Boolean.FALSE;
                        }
                    } else if (element.equals(comparedElement)) {
                        return Boolean.FALSE;
                    }
                }
            }
            return Boolean.TRUE;
        }
        
    }
    

    
    
    
    static final class Reverse<T> extends AbstractNotNullNonConvertingFunc<T[]> {
        
        public Reverse() {
            super();
        }

        @Override
        @SuppressWarnings("unchecked")
        protected T[] notNullExecute(final T[] input, final ExecCtx ctx) throws Exception {
            
            final T[] revertArray = (T[]) ArrayUtils.clone(input); 
            if (revertArray.length < 2) {
                return revertArray;
            }
            int size = revertArray.length;
            T aux = null;
            for (int i = 0, z = size / 2; i < z; i++) {
                aux = revertArray[i];
                revertArray[i] = revertArray[size - (i + 1)];
                revertArray[size - (i + 1)] = aux;
            }
            return revertArray;
        }
        
    }
    
    
}

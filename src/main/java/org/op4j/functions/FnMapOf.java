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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.exceptions.ExecutionException;
import org.op4j.util.ExecCtxImpl;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public final class FnMapOf<K,V> {


    
    protected final Type<K> keyType;
    protected final Type<V> valueType;

    
    private static final Count COUNT = new Count();

    
    
    
    
    public final Function<Map<K,V>,Map<K,V>> sortByKey() {
        return new SortByKey<K,V>();
    }

    public final Function<Map<K,V>,Map<K,V>> sortEntries(final Comparator<? super Entry<K,V>> comparator) {
        return new SortEntries<K,V>(comparator);
    }

    
    public final Function<Map<K,V>,Map<K,V>> sortBy(final IFunction<? super Map.Entry<K,V>, ?> by) {
        return new SortBy<K,V>(by);
    }

    
    public final Function<Map<K,V>,Map<K,V>> put(final K key, final V value) {
        return new Put<K,V>(key, value);
    }
    
    public final Function<Map<K,V>,Map<K,V>> insert(final int position, final K key, final V value) {
        return new Insert<K,V>(position, key, value);
    }
    
    public final Function<Map<K,V>,Map<K,V>> putAll(final Map<K,V> map) {
        return new PutAll<K,V>(map);
    }
    
    public final Function<Map<K,V>,Map<K,V>> insertAll(final int position, final Map<K,V> map) {
        return new InsertAll<K,V>(position, map);
    }
    
    public final Function<Map<K,V>,Map<K,V>> removeAllKeys(final K... keys) {
        return new RemoveAllKeys<K,V>(keys);
    }
    
    public final Function<Map<K,V>,Map<K,V>> removeAllTrue(final IFunction<? super Entry<K,V>,Boolean> eval) {
        return new RemoveAllTrue<K,V>(eval);
    }
    
    public final Function<Map<K,V>,Map<K,V>> removeAllFalse(final IFunction<? super Entry<K,V>,Boolean> eval) {
        return new RemoveAllFalse<K,V>(eval);
    }
    
    public final Function<Map<K,V>,Map<K,V>> removeAllKeysNot(final K... keys) {
        return new RemoveAllKeysNot<K,V>(keys);
    }
    
    public final Function<Map<K,V>,Set<K>> extractKeys() {
        return new ExtractKeys<K,V>();
    }
    
    public final Function<Map<K,V>,List<V>> extractValues() {
        return new ExtractValues<K,V>();
    }
    

    
    

    public final Function<Map<K,V>,Boolean> all(final IFunction<? super Map.Entry<K,V>,Boolean> eval) {
        return new All<K,V>(eval);
    }
    
    public final Function<Map<K,V>,Boolean> any(final IFunction<? super Map.Entry<K,V>,Boolean> eval) {
        return new Any<K,V>(eval);
    }
    
    
    
    
    
    
    
    public final Function<Map<?,?>,Integer> count() {
        return COUNT;
    }
    
    
    
    
    
    
    public final Function<Map<K,V>,Boolean> containsKey(final K key) {
        return new ContainsKey<K,V>(key);
    }
    
    public final Function<Map<K,V>,Boolean> notContainsKey(final K key) {
        return FnBoolean.not(containsKey(key));
    }
    
    public final Function<Map<K,V>,Boolean> containsAllKeys(final K... keys) {
        return new ContainsAllKeys<K,V>(VarArgsUtil.asRequiredObjectList(keys));
    }
    
    public final Function<Map<K,V>,Boolean> containsAnyKeys(final K... keys) {
        return new ContainsAnyKeys<K,V>(VarArgsUtil.asRequiredObjectList(keys));
    }
    
    public final Function<Map<K,V>,Boolean> containsNoneKeys(final K... keys) {
        return new ContainsNoneKeys<K,V>(VarArgsUtil.asRequiredObjectList(keys));
    }
    
    
    
    
    
    public final Function<Map<K,V>,Map<K,V>> reverse() {
        return new Reverse<K,V>();
    }
    
    
    
    
    
    
    
    protected FnMapOf(final Type<K> keyType, final Type<V> valueType) {
        super();
        this.keyType = keyType;
        this.valueType = valueType;
    }

    
    
    
    
    
    static final class SortByKey<K,V> extends AbstractNotNullNonConvertingFunc<Map<K, V>> {

        SortByKey() {
            super();
        }

        @Override
        protected Map<K, V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            return doSort(object, ctx);
        }
        

        @SuppressWarnings({ "unchecked" })
        private Map<K, V> doSort(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final List<?> keys = new ArrayList<Object>(object.keySet());
            Collections.sort((List<Comparable>)keys);
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final K key : (List<K>) keys) {
                result.put(key, object.get(key));
            }
            return result;
        }
        
    }

    
    
    static final class SortEntries<K, V> extends AbstractNotNullNonConvertingFunc<Map<K, V>> {

        private final Comparator<? super Map.Entry<K, V>> comparator;

        SortEntries(final Comparator<? super Map.Entry<K, V>> comparator) {
            super();
            this.comparator = comparator;
        }

        @Override
        protected Map<K, V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final List<Map.Entry<K, V>> entries = new ArrayList<Entry<K,V>>(object.entrySet());
            Collections.sort(entries, this.comparator);
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : entries) {
                result.put(entry.getKey(), entry.getValue());
            }
            return result;
        }
        
    }
    

    

    
    
    
    
    static final class SortBy<K,V> extends AbstractNotNullNonConvertingFunc<Map<K,V>> {

        private final IFunction<? super Map.Entry<K,V>, ?> by;
        
        SortBy(final IFunction<? super Map.Entry<K,V>, ?> by) {
            super();
            this.by = by;
        }

        @Override
        protected Map<K,V> notNullExecute(final Map<K,V> object, final ExecCtx ctx) throws Exception {

            final List<OrderableElement<Map.Entry<K,V>>> ordList = new ArrayList<OrderableElement<Map.Entry<K,V>>>();
            int index = 0;
            for (final Map.Entry<K,V> element : object.entrySet()) {
                ordList.add(
                    new OrderableElement<Map.Entry<K,V>>(
                        element, 
                        (Comparable<?>) this.by.execute(element, new ExecCtxImpl(Integer.valueOf(index)))));
            }
            Collections.sort(ordList);
            final Map<K,V> resultMap = new LinkedHashMap<K,V>();
            for (final OrderableElement<Map.Entry<K,V>> element : ordList) {
                resultMap.put(element.getElement().getKey(), element.getElement().getValue());
            }
            return resultMap;
            
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

            @SuppressWarnings({ "unchecked" })
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    static final class Put<K, V> extends AbstractNotNullNonConvertingFunc<Map<K, V>> {

        private final K key;
        private final V value;
        
        Put(final K key, final V value) {
            super();
            this.key = key;
            this.value = value;
        }

        @Override
        protected Map<K,V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>(object);
            result.put(this.key, this.value);
            return result;
        }
        
    }

    
    
    static final class Insert<K, V> extends AbstractNotNullNonConvertingFunc<Map<K, V>> {

        private final int position;
        private final K key;
        private final V value;
        
        Insert(final int position, final K key, final V value) {
            super();
            this.position = position;
            this.key = key;
            this.value = value;
        }

        @Override
        protected Map<K,V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
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


    
    
    
    static final class PutAll<K, V> extends AbstractNotNullNonConvertingFunc<Map<K, V>> {

        private final Map<K, V> map;
        
        PutAll(final Map<K, V> map) {
            super();
            this.map = new LinkedHashMap<K, V>(map);
        }

        @Override
        protected Map<K,V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>(object);
            result.putAll(this.map);
            return result;
        }
        
    }


    
    
    
    static final class InsertAll<K, V> extends AbstractNotNullNonConvertingFunc<Map<K, V>> {

        private final int position;
        private final Map<K, V> map;
        
        InsertAll(final int position, final Map<K, V> map) {
            super();
            this.position = position;
            this.map = new LinkedHashMap<K, V>(map);
        }

        @Override
        protected Map<K,V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
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

    
    

    
    static final class RemoveAllKeys<K,V> extends AbstractNotNullNonConvertingFunc<Map<K, V>> {

        private final List<K> keys;
        
        RemoveAllKeys(final K... keys) {
            super();
            this.keys = VarArgsUtil.asRequiredObjectList(keys);
        }

        @Override
        protected Map<K, V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>(object);
            for (final K key : this.keys) {
                result.remove(key);
            }
            return result;
        }
        
    }

    
    

    
    static final class RemoveAllTrue<K, V> extends AbstractNotNullNonConvertingFunc<Map<K, V>> {

        private final IFunction<? super Map.Entry<K, V>,Boolean> eval;
        
        RemoveAllTrue(final IFunction<? super Map.Entry<K, V>,Boolean> eval) {
            super();
            this.eval = eval;
        }

        @Override
        protected Map<K, V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : object.entrySet()) {
                if (!this.eval.execute(entry, ctx).booleanValue()) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
            return result;
        }
        
    }

    
    

    
    static final class RemoveAllFalse<K, V> extends AbstractNotNullNonConvertingFunc<Map<K, V>> {

        private final IFunction<? super Map.Entry<K, V>,Boolean> eval;
        
        RemoveAllFalse(final IFunction<? super Map.Entry<K, V>,Boolean> eval) {
            super();
            this.eval = eval;
        }

        @Override
        protected Map<K, V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : object.entrySet()) {
                if (this.eval.execute(entry, ctx).booleanValue()) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
            return result;
        }
        
    }
    
    

    
    
    static final class RemoveAllKeysNot<K, V> extends AbstractNotNullNonConvertingFunc<Map<K, V>> {

        private final List<K> keys;
        
        RemoveAllKeysNot(final K... keys) {
            super();
            this.keys = VarArgsUtil.asRequiredObjectList(keys);
        }

        @Override
        protected Map<K, V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final Map.Entry<K, V> entry : object.entrySet()) {
                if (this.keys.contains(entry.getKey())) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
            return result;
        }
        
    }

    
    
    
    static final class ExtractKeys<K, V> extends AbstractNotNullFunction<Map<K, V>,Set<K>> {

        ExtractKeys() {
            super();
        }

        @Override
        protected Set<K> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            return new LinkedHashSet<K>(object.keySet());
        }
        
    }
    
    
    
    static final class ExtractValues<K, V> extends AbstractNotNullFunction<Map<K, V>,List<V>> {

        ExtractValues() {
            super();
        }

        @Override
        protected List<V> notNullExecute(final Map<K, V> object, final ExecCtx ctx) throws Exception {
            return new ArrayList<V>(object.values());
        }
        
    }
    
    
    
    
    
    
    
    
    static final class Any<K,V> extends AbstractNotNullFunction<Map<K,V>,Boolean> {

        private final IFunction<? super Map.Entry<K,V>, Boolean> function;
        
        
        public Any(IFunction<? super Map.Entry<K,V>, Boolean> function) {
            super();
            this.function = function;
        }
        
        
        @Override
        protected Boolean notNullExecute(final Map<K,V> object, final ExecCtx ctx) throws Exception {
            int index = 0;
            for (final Map.Entry<K,V> element : object.entrySet()) {
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

    
    
    static final class All<K,V> extends AbstractNotNullFunction<Map<K,V>,Boolean> {

        private final IFunction<? super Map.Entry<K,V>, Boolean> function;
        
        
        public All(IFunction<? super Map.Entry<K,V>, Boolean> function) {
            super();
            this.function = function;
        }
        
        
        @Override
        protected Boolean notNullExecute(final Map<K,V> object, final ExecCtx ctx) throws Exception {
            int index = 0;
            for (final Map.Entry<K,V> element : object.entrySet()) {
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    static final class ContainsKey<K,V> extends AbstractNotNullFunction<Map<K,V>,Boolean> {
        
        private final K key;
        
        public ContainsKey(final K key) {
            super();
            this.key = key;
        }

        @Override
        protected Boolean notNullExecute(final Map<K,V> input, final ExecCtx ctx) throws Exception {
            for (final K element : input.keySet()) {
                if (element == null) {
                    if (this.key == null) {
                        return Boolean.TRUE;
                    }
                } else if (element.equals(this.key)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
        
    }
    
    
    static final class ContainsAllKeys<K,V> extends AbstractNotNullFunction<Map<K,V>,Boolean> {
        
        private final List<K> keys;
        
        public ContainsAllKeys(final List<K> keys) {
            super();
            this.keys = keys;
        }

        @Override
        protected Boolean notNullExecute(final Map<K,V> input, final ExecCtx ctx) throws Exception {
            final Set<K> notContained = new HashSet<K>(this.keys);
            for (final K element : input.keySet()) {
                for (final K comparedElement : this.keys) {
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
    
    
    
    static final class ContainsAnyKeys<K,V> extends AbstractNotNullFunction<Map<K,V>,Boolean> {
        
        private final List<K> keys;
        
        public ContainsAnyKeys(final List<K> keys) {
            super();
            this.keys = keys;
        }

        @Override
        protected Boolean notNullExecute(final Map<K,V> input, final ExecCtx ctx) throws Exception {
            for (final K element : input.keySet()) {
                for (final K comparedElement : this.keys) {
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
    
    
    
    static final class ContainsNoneKeys<K,V> extends AbstractNotNullFunction<Map<K,V>,Boolean> {
        
        private final List<K> keys;
        
        public ContainsNoneKeys(final List<K> keys) {
            super();
            this.keys = keys;
        }

        @Override
        protected Boolean notNullExecute(final Map<K,V> input, final ExecCtx ctx) throws Exception {
            for (final K element : input.keySet()) {
                for (final K comparedElement : this.keys) {
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
    
    
    
    
    static final class Reverse<K,V> extends AbstractNotNullNonConvertingFunc<Map<K,V>> {
        
        public Reverse() {
            super();
        }

        @Override
        @SuppressWarnings("unchecked")
        protected Map<K,V> notNullExecute(final Map<K,V> input, final ExecCtx ctx) throws Exception {
            
            final Object[] revertArray = input.entrySet().toArray(new Object[input.size()]); 
            if (revertArray.length < 2) {
                return new LinkedHashMap<K,V>(input);
            }
            int size = revertArray.length;
            Object aux = null;
            for (int i = 0, z = size / 2; i < z; i++) {
                aux = revertArray[i];
                revertArray[i] = revertArray[size - (i + 1)];
                revertArray[size - (i + 1)] = aux;
            }
            final Map<K,V> result = new LinkedHashMap<K,V>();
            for (final Object element : revertArray) {
                final Map.Entry<K,V> entry = (Map.Entry<K,V>) element;
                result.put(entry.getKey(), entry.getValue());
            }
            return result;
        }
        
    }
    
    static final class Count extends AbstractNotNullFunction<Map<?,?>,Integer> {
        
        public Count() {
            super();
        }
        
        @Override
        protected Integer notNullExecute(final Map<?,?> object, final ExecCtx ctx) throws Exception {
            return Integer.valueOf(object.size());
        }
        
    }
    
}

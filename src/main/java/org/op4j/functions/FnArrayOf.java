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

package org.op4j.functions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
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

        private static class ArrayLinkedHashSet<T> extends LinkedHashSet<T[]> {

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
    
    
}

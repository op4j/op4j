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
import org.javaruntype.type.Types;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class ArrayFuncs {

    
    
    
    private ArrayFuncs() {
        super();
    }

    
    
    
    @SuppressWarnings("unchecked")
    protected static final <T> T[] fromList(final Class<?> arrayClass, final List<T> object) {
        final Class<?> componentClass = arrayClass.getComponentType();
        final T[] newArray = (T[]) Array.newInstance(componentClass, new int[] { object.size() });
        return object.toArray(newArray);
    }
    
    
    
    
    public static final class Sort<T extends Comparable<? super T>> extends AbstractNotNullNonConvertingFunc<T[]> {

        public Sort() {
            super();
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {

            final List<T> list = new ArrayList<T>(Arrays.asList(object));
            Collections.sort(list);
            return ArrayFuncs.fromList(object.getClass(), list);
            
        }

    }


    
    
    public static final class SortByComparator<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private Comparator<? super T> comparator = null;

        public SortByComparator(final Comparator<? super T> comparator) {
            super();
            Validate.notNull(comparator, "A comparator must be specified");
            this.comparator = comparator;
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {

            final List<T> list = new ArrayList<T>(Arrays.asList(object));
            Collections.sort(list, this.comparator);
            return ArrayFuncs.fromList(object.getClass(), list);
            
        }

    }
    
    
    
    
    public static final class Distinct<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        public Distinct() {
            super();
        }

        @Override
        @SuppressWarnings("unchecked")
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {

            Set<?> set = null;
            if (!object.getClass().getComponentType().isArray()) {
                set = new LinkedHashSet<T>(Arrays.asList(object));
            } else {
                set = new ArrayLinkedHashSet<Object>();
                ((ArrayLinkedHashSet<Object>) set).addAll(Arrays
                        .asList((Object[][]) object));
            }

            return ArrayFuncs.fromList(object.getClass(), new ArrayList<T>((Set<T>)set));

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

    
    
    
    

    

    
    public static final class Add<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final List<T> newElements;
        
        public Add(final T... newElements) {
            super();
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.addAll(this.newElements);
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }

    
    
    public static final class Insert<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final int position;
        private final List<T> newElements;
        
        public Insert(final int position, final T... newElements) {
            super();
            this.position = position;
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.addAll(this.position, this.newElements);
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }


    
    
    
    public static final class AddAll<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final List<T> newElements;
        
        public AddAll(final Collection<T> collection) {
            super();
            Validate.notNull(collection, "A collection must be specified");
            this.newElements = new ArrayList<T>(collection);
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.addAll(this.newElements);
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveAllIndexes<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final List<Integer> indexes;
        
        public RemoveAllIndexes(final int... indexes) {
            super();
            this.indexes = VarArgsUtil.asRequiredIntegerList(indexes);
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            int i = 0;
            for (final T element : object) {
                if (!this.indexes.contains(Integer.valueOf(i))) {
                    result.add(element);
                }
                i++;
            }
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveAllEqual<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final List<T> values;
        
        public RemoveAllEqual(final T... values) {
            super();
            this.values = VarArgsUtil.asRequiredObjectList(values);
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.removeAll(this.values);
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveAllTrue<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final IEvaluator<Boolean,? super T> eval;
        
        public RemoveAllTrue(final IEvaluator<Boolean,? super T> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (!this.eval.execute(element, ctx).booleanValue()) {
                    result.add(element);
                }
            }
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveAllFalse<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final IEvaluator<Boolean,? super T> eval;
        
        public RemoveAllFalse(final IEvaluator<Boolean,? super T> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (this.eval.execute(element, ctx).booleanValue()) {
                    result.add(element);
                }
            }
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }
    
    

    
    
    public static final class RemoveAllIndexesNot<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final List<Integer> indexes;
        
        public RemoveAllIndexesNot(final int... indexes) {
            super();
            this.indexes = VarArgsUtil.asRequiredIntegerList(indexes);
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            int i = 0;
            for (final T element : object) {
                if (this.indexes.contains(Integer.valueOf(i))) {
                    result.add(element);
                }
                i++;
            }
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }

    

    
    
    public static final class RemoveAllNull<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        public RemoveAllNull() {
            super();
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    result.add(element);
                }
            }
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }
    

    

    
    
    public static final class RemoveAllNotNullAndTrue<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final IEvaluator<Boolean,? super T> eval;
        
        public RemoveAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
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
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }
    


    
    

    
    
    public static final class RemoveAllNotNullAndFalse<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final IEvaluator<Boolean,? super T> eval;
        
        public RemoveAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
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
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }
    
    

    
    
    public static final class RemoveAllNullOrTrue<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final IEvaluator<Boolean,? super T> eval;
        
        public RemoveAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (!this.eval.execute(element, ctx).booleanValue()) {
                        result.add(element);
                    }
                }
            }
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }
    
    
    


    
    
    public static final class RemoveAllNullOrFalse<T> extends AbstractNotNullNonConvertingFunc<T[]> {

        private final IEvaluator<Boolean,? super T> eval;
        
        public RemoveAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (this.eval.execute(element, ctx).booleanValue()) {
                        result.add(element);
                    }
                }
            }
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }
    
    
    
    
    
    
    public static final class FlattenArrayOfArrays<T> extends AbstractNotNullFunc<T[], T[][]> {

        private final Type<? super T> type; 
        
        public FlattenArrayOfArrays(final Type<? super T> type) {
            super();
            Validate.notNull(type, "A type representing the array elements must be specified");
            this.type = type;
        }

        @SuppressWarnings("unchecked")
        public Type<? extends T[]> getResultType(final Type<? extends T[][]> targetType) {
            return Types.arrayComponentOf((Type<T[][]>)targetType);
        }

        @Override
        @SuppressWarnings("unchecked")
        public T[] notNullExecute(final T[][] object, final ExecCtx ctx) throws Exception {
            
            final List<T> result = new ArrayList<T>();
            for (final T[] element : object) {
                result.addAll(Arrays.asList(element));
            }
            final T[] array = (T[]) Array.newInstance(this.type.getRawClass(), result.size());
            return result.toArray(array);
            
        }

    }
    

    
    public static final class FlattenArrayOfLists<T> extends AbstractNotNullFunc<T[], List<T>[]> {

        private final Type<? super T> type; 

        public FlattenArrayOfLists(final Type<? super T> type) {
            super();
            Validate.notNull(type, "A type representing the collection elements must be specified");
            this.type = type;
        }

        @SuppressWarnings("unchecked")
        public Type<? extends T[]> getResultType(final Type<? extends List<T>[]> targetType) {
            return Types.arrayOf(Types.listComponentOf(Types.arrayComponentOf((Type<List<T>[]>)targetType)));
        }

        @Override
        @SuppressWarnings("unchecked")
        public T[] notNullExecute(final List<T>[] object, final ExecCtx ctx) throws Exception {
            
            final List<T> result = new ArrayList<T>();
            for (final List<T> element : object) {
                result.addAll(element);
            }
            final T[] array = (T[]) Array.newInstance(this.type.getRawClass(), result.size());
            return result.toArray(array);
            
        }

    }

    

    
    public static final class FlattenArrayOfSets<T> extends AbstractNotNullFunc<T[], Set<T>[]> {

        private final Type<? super T> type; 

        public FlattenArrayOfSets(final Type<? super T> type) {
            super();
            Validate.notNull(type, "A type representing the collection elements must be specified");
            this.type = type;
        }

        @SuppressWarnings("unchecked")
        public Type<? extends T[]> getResultType(final Type<? extends Set<T>[]> targetType) {
            return Types.arrayOf(Types.setComponentOf(Types.arrayComponentOf((Type<Set<T>[]>)targetType)));
        }

        @Override
        @SuppressWarnings("unchecked")
        public T[] notNullExecute(final Set<T>[] object, final ExecCtx ctx) throws Exception {
            
            final List<T> result = new ArrayList<T>();
            for (final Set<T> element : object) {
                result.addAll(element);
            }
            final T[] array = (T[]) Array.newInstance(this.type.getRawClass(), result.size());
            return result.toArray(array);
            
        }

    }
    
    
    
    
}

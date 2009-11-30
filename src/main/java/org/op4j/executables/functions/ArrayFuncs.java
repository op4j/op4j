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

package org.op4j.executables.functions;

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
import org.op4j.executables.IEval;
import org.op4j.executables.ISelector;
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
    
    
    
    
    public static final class Sort<T extends Comparable<? super T>> extends AbstractNotNullFunc<T[], T[]> {

        public Sort() {
            super();
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        public T[] notNullExecute(final T[] object) throws Exception {

            final List<T> list = new ArrayList<T>(Arrays.asList(object));
            Collections.sort(list);
            return ArrayFuncs.fromList(object.getClass(), list);
            
        }

    }


    
    
    public static final class SortByComparator<T> extends AbstractNotNullFunc<T[], T[]> {

        private Comparator<? super T> comparator = null;

        public SortByComparator(final Comparator<? super T> comparator) {
            super();
            Validate.notNull(comparator, "A comparator must be specified");
            this.comparator = comparator;
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        public T[] notNullExecute(final T[] object) throws Exception {

            final List<T> list = new ArrayList<T>(Arrays.asList(object));
            Collections.sort(list, this.comparator);
            return ArrayFuncs.fromList(object.getClass(), list);
            
        }

    }
    
    
    
    
    public static final class Distinct<T> extends AbstractNotNullFunc<T[], T[]> {

        public Distinct() {
            super();
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T[] notNullExecute(final T[] object) throws Exception {

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

    
    
    
    

    

    
    public static final class Add<T> extends AbstractNotNullFunc<T[],T[]> {

        private final List<T> newElements;
        
        public Add(final T... newElements) {
            super();
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        public T[] notNullExecute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.addAll(this.newElements);
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }

    
    
    public static final class Insert<T> extends AbstractNotNullFunc<T[],T[]> {

        private final int position;
        private final List<T> newElements;
        
        public Insert(final int position, final T... newElements) {
            super();
            this.position = position;
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        public T[] notNullExecute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.addAll(this.position, this.newElements);
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }


    
    
    
    public static final class AddAll<T> extends AbstractNotNullFunc<T[],T[]> {

        private final List<T> newElements;
        
        public AddAll(final Collection<T> collection) {
            super();
            Validate.notNull(collection, "A collection must be specified");
            this.newElements = new ArrayList<T>(collection);
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        public T[] notNullExecute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.addAll(this.newElements);
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveIndexes<T> extends AbstractNotNullFunc<T[],T[]> {

        private final List<Integer> indices;
        
        public RemoveIndexes(final int... indices) {
            super();
            this.indices = VarArgsUtil.asRequiredIntegerList(indices);
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        public T[] notNullExecute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>();
            int i = 0;
            for (final T element : object) {
                if (!this.indices.contains(Integer.valueOf(i))) {
                    result.add(element);
                }
                i++;
            }
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveEquals<T> extends AbstractNotNullFunc<T[],T[]> {

        private final List<T> values;
        
        public RemoveEquals(final T... values) {
            super();
            this.values = VarArgsUtil.asRequiredObjectList(values);
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        public T[] notNullExecute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.removeAll(this.values);
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveMatching<T> extends AbstractNotNullFunc<T[],T[]> {

        private final IEval<Boolean,? super T> eval;
        
        public RemoveMatching(final IEval<Boolean,? super T> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        public T[] notNullExecute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (!this.eval.execute(element).booleanValue()) {
                    result.add(element);
                }
            }
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveSelected<T> extends AbstractNotNullFunc<T[],T[]> {

        private final ISelector<T> selector;
        
        public RemoveSelected(final ISelector<T> selector) {
            super();
            Validate.notNull(selector, "A selector must be specified");
            this.selector = selector;
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        public T[] notNullExecute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (!this.selector.eval(element)) {
                    result.add(element);
                }
            }
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }
    
    

    
    
    public static final class RemoveIndexesNot<T> extends AbstractNotNullFunc<T[],T[]> {

        private final List<Integer> indices;
        
        public RemoveIndexesNot(final int... indices) {
            super();
            this.indices = VarArgsUtil.asRequiredIntegerList(indices);
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        public T[] notNullExecute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>();
            int i = 0;
            for (final T element : object) {
                if (this.indices.contains(Integer.valueOf(i))) {
                    result.add(element);
                }
                i++;
            }
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }

    

    
    
    public static final class RemoveNulls<T> extends AbstractNotNullFunc<T[],T[]> {

        public RemoveNulls() {
            super();
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        public T[] notNullExecute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    result.add(element);
                }
            }
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }
    

    

    
    
    public static final class RemoveNotNullMatching<T> extends AbstractNotNullFunc<T[],T[]> {

        private final IEval<Boolean,? super T> eval;
        
        public RemoveNotNullMatching(final IEval<Boolean,? super T> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        public T[] notNullExecute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (!this.eval.execute(element).booleanValue()) {
                        result.add(element);
                    }
                } else {
                    result.add(element);
                }
            }
            return ArrayFuncs.fromList(object.getClass(), result);
        }
        
    }
    

    

    
    
    public static final class RemoveNullOrMatching<T> extends AbstractNotNullFunc<T[],T[]> {

        private final IEval<Boolean,? super T> eval;
        
        public RemoveNullOrMatching(final IEval<Boolean,? super T> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        public T[] notNullExecute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (!this.eval.execute(element).booleanValue()) {
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

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T[] notNullExecute(final T[][] object) throws Exception {
            
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

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T[] notNullExecute(final List<T>[] object) throws Exception {
            
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

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T[] notNullExecute(final Set<T>[] object) throws Exception {
            
            final List<T> result = new ArrayList<T>();
            for (final Set<T> element : object) {
                result.addAll(element);
            }
            final T[] array = (T[]) Array.newInstance(this.type.getRawClass(), result.size());
            return result.toArray(array);
            
        }

    }
    
    
    
    
}

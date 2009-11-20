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

package org.op4j.executables.functions.builtin;

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

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.IEval;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.IFunc;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class ArrayFunc {

    
    
    
    private ArrayFunc() {
        super();
    }

    
    
    
    @SuppressWarnings("unchecked")
    protected static final <T> T[] fromList(final Class<?> arrayClass, final List<T> object) {
        final Class<?> componentClass = arrayClass.getComponentType();
        final T[] newArray = (T[]) Array.newInstance(componentClass, new int[] { object.size() });
        return object.toArray(newArray);
    }
    
    
    
    
    public static final class Sort<T extends Comparable<? super T>> implements IFunc<T[], T[]> {

        private Comparator<T> comparator = null;

        public Sort() {
            super();
        }

        public Sort(final Comparator<T> comparator) {
            super();
            this.comparator = comparator;
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        public T[] execute(final T[] object) throws Exception {

            final List<T> list = new ArrayList<T>(Arrays.asList(object));
            if (this.comparator == null) {
                Collections.sort(list);
            } else {
                Collections.sort(list, this.comparator);
            }

            return ArrayFunc.fromList(object.getClass(), list);
        }

    }

    
    
    
    public static final class Distinct<T> implements IFunc<T[], T[]> {

        public Distinct() {
            super();
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        @SuppressWarnings("unchecked")
        public T[] execute(final T[] object) throws Exception {

            Set<?> set = null;
            if (!object.getClass().getComponentType().isArray()) {
                set = new LinkedHashSet<T>(Arrays.asList(object));
            } else {
                set = new ArrayLinkedHashSet<Object>();
                ((ArrayLinkedHashSet<Object>) set).addAll(Arrays
                        .asList((Object[][]) object));
            }

            return ArrayFunc.fromList(object.getClass(), new ArrayList<T>((Set<T>)set));

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

    
    
    
    

    

    
    public static final class Add<T> implements IFunc<T[],T[]> {

        private final List<T> newElements;
        
        public Add(final T... newElements) {
            super();
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        public T[] execute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.addAll(this.newElements);
            return ArrayFunc.fromList(object.getClass(), result);
        }
        
    }

    
    
    public static final class Insert<T> implements IFunc<T[],T[]> {

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

        public T[] execute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.addAll(this.position, this.newElements);
            return ArrayFunc.fromList(object.getClass(), result);
        }
        
    }


    
    
    
    public static final class AddAll<T> implements IFunc<T[],T[]> {

        private final List<T> newElements;
        
        public AddAll(final Collection<T> collection) {
            super();
            this.newElements = new ArrayList<T>(collection);
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        public T[] execute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.addAll(this.newElements);
            return ArrayFunc.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemovePositions<T> implements IFunc<T[],T[]> {

        private final List<Integer> positions;
        
        public RemovePositions(final int... positions) {
            super();
            this.positions = VarArgsUtil.asRequiredIntegerList(positions);
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        public T[] execute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>();
            int i = 0;
            for (final T element : object) {
                if (!this.positions.contains(Integer.valueOf(i))) {
                    result.add(element);
                }
                i++;
            }
            return ArrayFunc.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveValues<T> implements IFunc<T[],T[]> {

        private final List<T> values;
        
        public RemoveValues(final T... values) {
            super();
            this.values = VarArgsUtil.asRequiredObjectList(values);
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        public T[] execute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.removeAll(this.values);
            return ArrayFunc.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveMatching<T> implements IFunc<T[],T[]> {

        private final IEval<Boolean,? super T> eval;
        
        public RemoveMatching(final IEval<Boolean,? super T> eval) {
            super();
            this.eval = eval;
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        public T[] execute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (!this.eval.execute(element).booleanValue()) {
                    result.add(element);
                }
            }
            return ArrayFunc.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveSelected<T> implements IFunc<T[],T[]> {

        private final ISelect<T> selector;
        
        public RemoveSelected(final ISelect<T> selector) {
            super();
            this.selector = selector;
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        public T[] execute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (!this.selector.eval(element)) {
                    result.add(element);
                }
            }
            return ArrayFunc.fromList(object.getClass(), result);
        }
        
    }
    
    

    
    
    public static final class RemoveAllExceptPositions<T> implements IFunc<T[],T[]> {

        private final List<Integer> positions;
        
        public RemoveAllExceptPositions(final int... positions) {
            super();
            this.positions = VarArgsUtil.asRequiredIntegerList(positions);
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        public T[] execute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>();
            int i = 0;
            for (final T element : object) {
                if (this.positions.contains(Integer.valueOf(i))) {
                    result.add(element);
                }
                i++;
            }
            return ArrayFunc.fromList(object.getClass(), result);
        }
        
    }

    

    
    
    public static final class RemoveNulls<T> implements IFunc<T[],T[]> {

        public RemoveNulls() {
            super();
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        public T[] execute(final T[] object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    result.add(element);
                }
            }
            return ArrayFunc.fromList(object.getClass(), result);
        }
        
    }
    

    

    
    
    public static final class RemoveNotNullsMatching<T> implements IFunc<T[],T[]> {

        private final IEval<Boolean,? super T> eval;
        
        public RemoveNotNullsMatching(final IEval<Boolean,? super T> eval) {
            super();
            this.eval = eval;
        }

        public Type<? super T[]> getResultType() {
            return Types.ARRAY_OF_OBJECT;
        }

        public T[] execute(final T[] object) throws Exception {
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
            return ArrayFunc.fromList(object.getClass(), result);
        }
        
    }
    
    
    
}

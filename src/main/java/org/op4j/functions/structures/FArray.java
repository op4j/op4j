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

package org.op4j.functions.structures;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.IFunction;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class FArray<T> {

    
    private static final FArray<Object> OF_OBJECT = new FArray<Object>(Types.OBJECT);
    private static final FArray<BigInteger> OF_BIG_INTEGER = new FArray<BigInteger>(Types.BIG_INTEGER);
    private static final FArray<BigDecimal> OF_BIG_DECIMAL = new FArray<BigDecimal>(Types.BIG_DECIMAL);
    private static final FArray<Boolean> OF_BOOLEAN = new FArray<Boolean>(Types.BOOLEAN); 
    private static final FArray<Byte> OF_BYTE = new FArray<Byte>(Types.BYTE); 
    private static final FArray<Character> OF_CHARACTER = new FArray<Character>(Types.CHARACTER); 
    private static final FArray<Calendar> OF_CALENDAR = new FArray<Calendar>(Types.CALENDAR); 
    private static final FArray<Date> OF_DATE = new FArray<Date>(Types.DATE); 
    private static final FArray<Double> OF_DOUBLE = new FArray<Double>(Types.DOUBLE); 
    private static final FArray<Float> OF_FLOAT = new FArray<Float>(Types.FLOAT); 
    private static final FArray<Integer> OF_INTEGER = new FArray<Integer>(Types.INTEGER); 
    private static final FArray<Long> OF_LONG = new FArray<Long>(Types.LONG); 
    private static final FArray<Short> OF_SHORT = new FArray<Short>(Types.SHORT); 
    private static final FArray<String> OF_STRING = new FArray<String>(Types.STRING); 

    
    protected final Type<T> type;
    
    
    
    
    public static <T> FArray<T> of(final Type<T> type) {
        return new FArray<T>(type);
    }
    
    public static <T> FArrayOfArray<T> ofArrayOf(final Type<T> type) {
        return new FArrayOfArray<T>(type);
    }
    
    public static <T> FArrayOfList<T> ofListOf(final Type<T> type) {
        return new FArrayOfList<T>(type);
    }
    
    public static <T> FArrayOfSet<T> ofSetOf(final Type<T> type) {
        return new FArrayOfSet<T>(type);
    }
    
    public static FArray<Object> ofObject() {
        return OF_OBJECT;
    }
    
    public static FArray<BigInteger> ofBigInteger() {
        return OF_BIG_INTEGER;
    }
    
    public static FArray<BigDecimal> ofBigDecimal() {
        return OF_BIG_DECIMAL;
    }
    
    public static FArray<Boolean> ofBoolean() {
        return OF_BOOLEAN;
    }
    
    public static FArray<Byte> ofByte() {
        return OF_BYTE;
    }
    
    public static FArray<Character> ofCharacter() {
        return OF_CHARACTER;
    }
    
    public static FArray<Calendar> ofCalendar() {
        return OF_CALENDAR;
    }
    
    public static FArray<Date> ofDate() {
        return OF_DATE;
    }
    
    public static FArray<Double> ofDouble() {
        return OF_DOUBLE;
    }
    
    public static FArray<Float> ofFloat() {
        return OF_FLOAT;
    }
    
    public static FArray<Integer> ofInteger() {
        return OF_INTEGER;
    }
    
    public static FArray<Long> ofLong() {
        return OF_LONG;
    }
    
    public static FArray<Short> ofShort() {
        return OF_SHORT;
    }
    
    public static FArray<String> ofString() {
        return OF_STRING;
    }
    
    
    
    


    public final Sort<T> sort() {
        return new Sort<T>();
    }

    public final SortByComparator<T> sort(final Comparator<? super T> comparator) {
        return new SortByComparator<T>(comparator);
    }
        
    public final Distinct<T> distinct() {
        return new Distinct<T>();
    }
    
    public final Add<T> add(final T... newElements) {
        return new Add<T>(newElements);
    }
    
    public final Insert<T> insert(final int position, final T... newElements) {
        return new Insert<T>(position, newElements);
    }
    
    public final AddAll<T> addAll(final Collection<T> collection) {
        return new AddAll<T>(collection);
    }
    
    public final RemoveAllIndexes<T> removeAllIndexes(final int... indexes) {
        return new RemoveAllIndexes<T>(indexes);
    }
    
    public final RemoveAllEqual<T> removeAllEqual(final T... values) {
        return new RemoveAllEqual<T>(values);
    }
    
    public final RemoveAllTrue<T> removeAllTrue(final IFunction<Boolean,? super T> eval) {
        return new RemoveAllTrue<T>(eval);
    }
    
    public final RemoveAllFalse<T> removeAllFalse(final IFunction<Boolean,? super T> eval) {
        return new RemoveAllFalse<T>(eval);
    }
    
    public final RemoveAllIndexesNot<T> removeAllIndexesNot(final int... indexes) {
        return new RemoveAllIndexesNot<T>(indexes);
    }
    
    public final RemoveAllNull<T> removeAllNull() {
        return new RemoveAllNull<T>();
    }
    
    public final RemoveAllNotNullAndTrue<T> removeAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
        return new RemoveAllNotNullAndTrue<T>(eval);
    }
    
    public final RemoveAllNotNullAndFalse<T> removeAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
        return new RemoveAllNotNullAndFalse<T>(eval);
    }
    
    public final RemoveAllNullOrTrue<T> removeAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
        return new RemoveAllNullOrTrue<T>(eval);
    }
    
    public final RemoveAllNullOrFalse<T> removeAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
        return new RemoveAllNullOrFalse<T>(eval);
    }

    
    
    
    
    protected FArray(final Type<T> type) {
        super();
        this.type = type;
    }

    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    protected static final <T> T[] fromList(final Class<?> arrayClass, final List<T> object) {
        final Class<?> componentClass = arrayClass.getComponentType();
        final T[] newArray = (T[]) Array.newInstance(componentClass, new int[] { object.size() });
        return object.toArray(newArray);
    }
    
    
    
    
    public static final class Sort<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

        public Sort() {
            super();
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            return doSort(object, ctx);
        }

        @SuppressWarnings("unchecked")
        public <X extends Comparable<? super X>> T[] doSort(final T[] object, final ExecCtx ctx) throws Exception {

            final List<X> list = (List<X>) new ArrayList<Object>(Arrays.asList(object));
            Collections.sort(list);
            return FArray.fromList(object.getClass(), (List<T>)(List<?>)list);
            
        }

    }


    
    
    public static final class SortByComparator<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

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
            return FArray.fromList(object.getClass(), list);
            
        }

    }
    
    
    
    
    public static final class Distinct<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

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

            return FArray.fromList(object.getClass(), new ArrayList<T>((Set<T>)set));

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

    
    
    
    

    

    
    public static final class Add<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

        private final List<T> newElements;
        
        public Add(final T... newElements) {
            super();
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.addAll(this.newElements);
            return FArray.fromList(object.getClass(), result);
        }
        
    }

    
    
    public static final class Insert<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

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
            return FArray.fromList(object.getClass(), result);
        }
        
    }


    
    
    
    public static final class AddAll<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

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
            return FArray.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveAllIndexes<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

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
            return FArray.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveAllEqual<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

        private final List<T> values;
        
        public RemoveAllEqual(final T... values) {
            super();
            this.values = VarArgsUtil.asRequiredObjectList(values);
        }

        @Override
        public T[] notNullExecute(final T[] object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(Arrays.asList(object));
            result.removeAll(this.values);
            return FArray.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveAllTrue<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

        private final IFunction<Boolean,? super T> eval;
        
        public RemoveAllTrue(final IFunction<Boolean,? super T> eval) {
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
            return FArray.fromList(object.getClass(), result);
        }
        
    }

    
    

    
    public static final class RemoveAllFalse<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

        private final IFunction<Boolean,? super T> eval;
        
        public RemoveAllFalse(final IFunction<Boolean,? super T> eval) {
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
            return FArray.fromList(object.getClass(), result);
        }
        
    }
    
    

    
    
    public static final class RemoveAllIndexesNot<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

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
            return FArray.fromList(object.getClass(), result);
        }
        
    }

    

    
    
    public static final class RemoveAllNull<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

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
            return FArray.fromList(object.getClass(), result);
        }
        
    }
    

    

    
    
    public static final class RemoveAllNotNullAndTrue<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

        private final IFunction<Boolean,? super T> eval;
        
        public RemoveAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
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
            return FArray.fromList(object.getClass(), result);
        }
        
    }
    


    
    

    
    
    public static final class RemoveAllNotNullAndFalse<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

        private final IFunction<Boolean,? super T> eval;
        
        public RemoveAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
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
            return FArray.fromList(object.getClass(), result);
        }
        
    }
    
    

    
    
    public static final class RemoveAllNullOrTrue<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

        private final IFunction<Boolean,? super T> eval;
        
        public RemoveAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
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
            return FArray.fromList(object.getClass(), result);
        }
        
    }
    
    
    


    
    
    public static final class RemoveAllNullOrFalse<T> extends AbstractStructureNotNullNonConvertingFunc<T[]> {

        private final IFunction<Boolean,? super T> eval;
        
        public RemoveAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
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
            return FArray.fromList(object.getClass(), result);
        }
        
    }
    
    
}

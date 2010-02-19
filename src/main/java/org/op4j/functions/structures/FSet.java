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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class FSet<T> {

    
    private static final FSet<Object> OF_OBJECT = new FSet<Object>(Types.OBJECT);
    private static final FSet<BigInteger> OF_BIG_INTEGER = new FSet<BigInteger>(Types.BIG_INTEGER);
    private static final FSet<BigDecimal> OF_BIG_DECIMAL = new FSet<BigDecimal>(Types.BIG_DECIMAL);
    private static final FSet<Boolean> OF_BOOLEAN = new FSet<Boolean>(Types.BOOLEAN); 
    private static final FSet<Byte> OF_BYTE = new FSet<Byte>(Types.BYTE); 
    private static final FSet<Character> OF_CHARACTER = new FSet<Character>(Types.CHARACTER); 
    private static final FSet<Calendar> OF_CALENDAR = new FSet<Calendar>(Types.CALENDAR); 
    private static final FSet<Date> OF_DATE = new FSet<Date>(Types.DATE); 
    private static final FSet<Double> OF_DOUBLE = new FSet<Double>(Types.DOUBLE); 
    private static final FSet<Float> OF_FLOAT = new FSet<Float>(Types.FLOAT); 
    private static final FSet<Integer> OF_INTEGER = new FSet<Integer>(Types.INTEGER); 
    private static final FSet<Long> OF_LONG = new FSet<Long>(Types.LONG); 
    private static final FSet<Short> OF_SHORT = new FSet<Short>(Types.SHORT); 
    private static final FSet<String> OF_STRING = new FSet<String>(Types.STRING); 

    
    protected final Type<T> type;
    
    
    
    
    public static <T> FSet<T> of(final Type<T> type) {
        return new FSet<T>(type);
    }
    
    public static <T> FSetOfArray<T> ofArrayOf(final Type<T> type) {
        return new FSetOfArray<T>(type);
    }
    
    public static <T> FSetOfList<T> ofListOf(final Type<T> type) {
        return new FSetOfList<T>(type);
    }
    
    public static <T> FSetOfSet<T> ofSetOf(final Type<T> type) {
        return new FSetOfSet<T>(type);
    }
    
    public static FSet<Object> ofObject() {
        return OF_OBJECT;
    }
    
    public static FSet<BigInteger> ofBigInteger() {
        return OF_BIG_INTEGER;
    }
    
    public static FSet<BigDecimal> ofBigDecimal() {
        return OF_BIG_DECIMAL;
    }
    
    public static FSet<Boolean> ofBoolean() {
        return OF_BOOLEAN;
    }
    
    public static FSet<Byte> ofByte() {
        return OF_BYTE;
    }
    
    public static FSet<Character> ofCharacter() {
        return OF_CHARACTER;
    }
    
    public static FSet<Calendar> ofCalendar() {
        return OF_CALENDAR;
    }
    
    public static FSet<Date> ofDate() {
        return OF_DATE;
    }
    
    public static FSet<Double> ofDouble() {
        return OF_DOUBLE;
    }
    
    public static FSet<Float> ofFloat() {
        return OF_FLOAT;
    }
    
    public static FSet<Integer> ofInteger() {
        return OF_INTEGER;
    }
    
    public static FSet<Long> ofLong() {
        return OF_LONG;
    }
    
    public static FSet<Short> ofShort() {
        return OF_SHORT;
    }
    
    public static FSet<String> ofString() {
        return OF_STRING;
    }
    




    public final Sort<T> sort() {
        return new Sort<T>();
    }

    public final SortByComparator<T> sort(final Comparator<? super T> comparator) {
        return new SortByComparator<T>(comparator);
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

    

    
    
    protected FSet(final Type<T> type) {
        super();
        this.type = type;
    }

    
    
    
    public static final class Sort<T> extends FCollection.Sort<T, Set<T>> {

        public Sort() {
            super();
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }

    }


    
    
    
    public static final class SortByComparator<T> extends FCollection.SortByComparator<T, Set<T>> {

        public SortByComparator(final Comparator<? super T> comparator) {
            super(comparator);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }

    }
    
    
    
    
    public static final class Add<T> extends FCollection.Add<T, Set<T>> {

        public Add(final T... newElements) {
            super(newElements);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    
    public static final class Insert<T> extends FCollection.Insert<T, Set<T>> {

        public Insert(final int position, T... newElements) {
            super(position, newElements);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    
    
    
    
    
    public static final class AddAll<T> extends FCollection.AddAll<T, Set<T>> {

        public AddAll(final Collection<T> collection) {
            super(collection);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllIndexes<T> extends FCollection.RemoveAllIndexes<T, Set<T>> {

        
        public RemoveAllIndexes(final int... indexes) {
            super(indexes);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllEqual<T> extends FCollection.RemoveAllEqual<T, Set<T>> {

        public RemoveAllEqual(final T... values) {
            super(values);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllTrue<T> extends FCollection.RemoveAllTrue<T, Set<T>> {

        public RemoveAllTrue(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllFalse<T> extends FCollection.RemoveAllTrue<T, Set<T>> {

        public RemoveAllFalse(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllIndexesNot<T> extends FCollection.RemoveAllIndexesNot<T, Set<T>> {

        public RemoveAllIndexesNot(final int... indexes) {
            super(indexes);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllNull<T> extends FCollection.RemoveAllNull<T, Set<T>> {

        public RemoveAllNull() {
            super();
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllNotNullAndTrue<T> extends FCollection.RemoveAllNotNullAndTrue<T, Set<T>> {

        public RemoveAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllNotNullAndFalse<T> extends FCollection.RemoveAllNotNullAndTrue<T, Set<T>> {

        public RemoveAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }


    
    
    public static final class RemoveAllNullOrTrue<T> extends FCollection.RemoveAllNullOrTrue<T, Set<T>> {

        public RemoveAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }


    
    
    public static final class RemoveAllNullOrFalse<T> extends FCollection.RemoveAllNullOrTrue<T, Set<T>> {

        public RemoveAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    
    
    
    
    
    
    
    
    
}

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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.IFunction;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class FList<T> {

    
    private static final FList<Object> OF_OBJECT = new FList<Object>(Types.OBJECT);
    private static final FList<BigInteger> OF_BIG_INTEGER = new FList<BigInteger>(Types.BIG_INTEGER);
    private static final FList<BigDecimal> OF_BIG_DECIMAL = new FList<BigDecimal>(Types.BIG_DECIMAL);
    private static final FList<Boolean> OF_BOOLEAN = new FList<Boolean>(Types.BOOLEAN); 
    private static final FList<Byte> OF_BYTE = new FList<Byte>(Types.BYTE); 
    private static final FList<Character> OF_CHARACTER = new FList<Character>(Types.CHARACTER); 
    private static final FList<Calendar> OF_CALENDAR = new FList<Calendar>(Types.CALENDAR); 
    private static final FList<Date> OF_DATE = new FList<Date>(Types.DATE); 
    private static final FList<Double> OF_DOUBLE = new FList<Double>(Types.DOUBLE); 
    private static final FList<Float> OF_FLOAT = new FList<Float>(Types.FLOAT); 
    private static final FList<Integer> OF_INTEGER = new FList<Integer>(Types.INTEGER); 
    private static final FList<Long> OF_LONG = new FList<Long>(Types.LONG); 
    private static final FList<Short> OF_SHORT = new FList<Short>(Types.SHORT); 
    private static final FList<String> OF_STRING = new FList<String>(Types.STRING); 

    
    protected final Type<T> type;
    
    
    
    
    public static <T> FList<T> of(final Type<T> type) {
        return new FList<T>(type);
    }
    
    public static <T> FListOfArray<T> ofArrayOf(final Type<T> type) {
        return new FListOfArray<T>(type);
    }
    
    public static <T> FListOfList<T> ofListOf(final Type<T> type) {
        return new FListOfList<T>(type);
    }
    
    public static <T> FListOfSet<T> ofSetOf(final Type<T> type) {
        return new FListOfSet<T>(type);
    }
    
    public static FList<Object> ofObject() {
        return OF_OBJECT;
    }
    
    public static FList<BigInteger> ofBigInteger() {
        return OF_BIG_INTEGER;
    }
    
    public static FList<BigDecimal> ofBigDecimal() {
        return OF_BIG_DECIMAL;
    }
    
    public static FList<Boolean> ofBoolean() {
        return OF_BOOLEAN;
    }
    
    public static FList<Byte> ofByte() {
        return OF_BYTE;
    }
    
    public static FList<Character> ofCharacter() {
        return OF_CHARACTER;
    }
    
    public static FList<Calendar> ofCalendar() {
        return OF_CALENDAR;
    }
    
    public static FList<Date> ofDate() {
        return OF_DATE;
    }
    
    public static FList<Double> ofDouble() {
        return OF_DOUBLE;
    }
    
    public static FList<Float> ofFloat() {
        return OF_FLOAT;
    }
    
    public static FList<Integer> ofInteger() {
        return OF_INTEGER;
    }
    
    public static FList<Long> ofLong() {
        return OF_LONG;
    }
    
    public static FList<Short> ofShort() {
        return OF_SHORT;
    }
    
    public static FList<String> ofString() {
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
    
    
    
    
    protected FList(final Type<T> type) {
        super();
        this.type = type;
    }

    
    
    
    public static final class Sort<T> extends FCollection.Sort<T, List<T>> {

        public Sort() {
            super();
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }

    }


    
    
    public static final class SortByComparator<T> extends FCollection.SortByComparator<T, List<T>> {

        public SortByComparator(final Comparator<? super T> comparator) {
            super(comparator);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }

    }
    
    
    
    
    public static final class Distinct<T> extends AbstractStructureNotNullNonConvertingFunc<List<T>> {

        public Distinct() {
            super();
        }

        @Override
        public List<T> notNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            return new ArrayList<T>(new LinkedHashSet<T>(object));
        }

    }

    
    
    
    
    public static final class Add<T> extends FCollection.Add<T, List<T>> {

        public Add(final T... newElements) {
            super(newElements);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    
    public static final class Insert<T> extends FCollection.Insert<T, List<T>> {

        public Insert(final int position, T... newElements) {
            super(position, newElements);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    
    
    public static final class AddAll<T> extends FCollection.AddAll<T, List<T>> {

        public AddAll(final Collection<T> collection) {
            super(collection);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllIndexes<T> extends FCollection.RemoveAllIndexes<T, List<T>> {

        
        public RemoveAllIndexes(final int... indexes) {
            super(indexes);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllEqual<T> extends FCollection.RemoveAllEqual<T, List<T>> {

        public RemoveAllEqual(final T... values) {
            super(values);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllTrue<T> extends FCollection.RemoveAllTrue<T, List<T>> {

        public RemoveAllTrue(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllFalse<T> extends FCollection.RemoveAllTrue<T, List<T>> {

        public RemoveAllFalse(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllIndexesNot<T> extends FCollection.RemoveAllIndexesNot<T, List<T>> {

        public RemoveAllIndexesNot(final int... indexes) {
            super(indexes);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllNull<T> extends FCollection.RemoveAllNull<T, List<T>> {

        public RemoveAllNull() {
            super();
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllNotNullAndTrue<T> extends FCollection.RemoveAllNotNullAndTrue<T, List<T>> {

        public RemoveAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllNotNullAndFalse<T> extends FCollection.RemoveAllNotNullAndTrue<T, List<T>> {

        public RemoveAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    public static final class RemoveAllNullOrTrue<T> extends FCollection.RemoveAllNullOrTrue<T, List<T>> {

        public RemoveAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    public static final class RemoveAllNullOrFalse<T> extends FCollection.RemoveAllNullOrTrue<T, List<T>> {

        public RemoveAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    
    

    
    
    
    
}

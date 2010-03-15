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
package org.op4j;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.TypeParameters;
import org.javaruntype.type.Types;
import org.op4j.operators.impl.fn.array.Level0ArrayOperator;
import org.op4j.operators.impl.fn.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.fn.list.Level0ListOperator;
import org.op4j.operators.impl.fn.map.Level0MapOperator;
import org.op4j.operators.impl.fn.set.Level0SetOperator;
import org.op4j.target.ExecutionTarget;
import org.op4j.target.Target.Normalisation;
import org.op4j.util.ValuePair;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Fn {
    

    
    
    
    private Fn() {
        super();
    }

    
    
    
    
    
    
    
    public static <T> Level0GenericUniqOperator<T,T> on(final Type<T> type) {
        return new Level0GenericUniqOperator<T,T>(ExecutionTarget.forFn(Normalisation.NONE));
    }
    
    public static Level0GenericUniqOperator<Object,Object> onObject() {
        return on(Types.OBJECT);
    }

    public static Level0ArrayOperator<Object[],Object> onArrayOfObject() {
        return on(Types.ARRAY_OF_OBJECT);
    }

    public static Level0ListOperator<List<Object>,Object> onListOfObject() {
        return on(Types.LIST_OF_OBJECT);
    }

    public static Level0SetOperator<Set<Object>,Object> onSetOfObject() {
        return on(Types.SET_OF_OBJECT);
    }

    
    public static Level0GenericUniqOperator<BigInteger,BigInteger> onBigInteger() {
        return on(Types.BIG_INTEGER);
    }

    public static Level0ArrayOperator<BigInteger[],BigInteger> onArrayOfBigInteger() {
        return on(Types.ARRAY_OF_BIG_INTEGER);
    }

    public static Level0ListOperator<List<BigInteger>,BigInteger> onListOfBigInteger() {
        return on(Types.LIST_OF_BIG_INTEGER);
    }

    public static Level0SetOperator<Set<BigInteger>,BigInteger> onSetOfBigInteger() {
        return on(Types.SET_OF_BIG_INTEGER);
    }

    
    public static Level0GenericUniqOperator<BigDecimal,BigDecimal> onBigDecimal() {
        return on(Types.BIG_DECIMAL);
    }

    public static Level0ArrayOperator<BigDecimal[],BigDecimal> onArrayOfBigDecimal() {
        return on(Types.ARRAY_OF_BIG_DECIMAL);
    }

    public static Level0ListOperator<List<BigDecimal>,BigDecimal> onListOfBigDecimal() {
        return on(Types.LIST_OF_BIG_DECIMAL);
    }

    public static Level0SetOperator<Set<BigDecimal>,BigDecimal> onSetOfBigDecimal() {
        return on(Types.SET_OF_BIG_DECIMAL);
    }

    
    public static Level0GenericUniqOperator<Boolean,Boolean> onBoolean() {
        return on(Types.BOOLEAN);
    }

    public static Level0ArrayOperator<Boolean[],Boolean> onArrayOfBoolean() {
        return on(Types.ARRAY_OF_BOOLEAN);
    }

    public static Level0ListOperator<List<Boolean>,Boolean> onListOfBoolean() {
        return on(Types.LIST_OF_BOOLEAN);
    }

    public static Level0SetOperator<Set<Boolean>,Boolean> onSetOfBoolean() {
        return on(Types.SET_OF_BOOLEAN);
    }

    
    public static Level0GenericUniqOperator<Byte,Byte> onByte() {
        return on(Types.BYTE);
    }

    public static Level0ArrayOperator<Byte[],Byte> onArrayOfByte() {
        return on(Types.ARRAY_OF_BYTE);
    }

    public static Level0ListOperator<List<Byte>,Byte> onListOfByte() {
        return on(Types.LIST_OF_BYTE);
    }

    public static Level0SetOperator<Set<Byte>,Byte> onSetOfByte() {
        return on(Types.SET_OF_BYTE);
    }

    
    public static Level0GenericUniqOperator<Character,Character> onCharacter() {
        return on(Types.CHARACTER);
    }

    public static Level0ArrayOperator<Character[],Character> onArrayOfCharacter() {
        return on(Types.ARRAY_OF_CHARACTER);
    }

    public static Level0ListOperator<List<Character>,Character> onListOfCharacter() {
        return on(Types.LIST_OF_CHARACTER);
    }

    public static Level0SetOperator<Set<Character>,Character> onSetOfCharacter() {
        return on(Types.SET_OF_CHARACTER);
    }

    
    public static Level0GenericUniqOperator<Calendar,Calendar> onCalendar() {
        return on(Types.CALENDAR);
    }

    public static Level0ArrayOperator<Calendar[],Calendar> onArrayOfCalendar() {
        return on(Types.ARRAY_OF_CALENDAR);
    }

    public static Level0ListOperator<List<Calendar>,Calendar> onListOfCalendar() {
        return on(Types.LIST_OF_CALENDAR);
    }

    public static Level0SetOperator<Set<Calendar>,Calendar> onSetOfCalendar() {
        return on(Types.SET_OF_CALENDAR);
    }

    
    public static Level0GenericUniqOperator<Date,Date> onDate() {
        return on(Types.DATE);
    }

    public static Level0ArrayOperator<Date[],Date> onArrayOfDate() {
        return on(Types.ARRAY_OF_DATE);
    }

    public static Level0ListOperator<List<Date>,Date> onListOfDate() {
        return on(Types.LIST_OF_DATE);
    }

    public static Level0SetOperator<Set<Date>,Date> onSetOfDate() {
        return on(Types.SET_OF_DATE);
    }

    
    public static Level0GenericUniqOperator<Double,Double> onDouble() {
        return on(Types.DOUBLE);
    }

    public static Level0ArrayOperator<Double[],Double> onArrayOfDouble() {
        return on(Types.ARRAY_OF_DOUBLE);
    }

    public static Level0ListOperator<List<Double>,Double> onListOfDouble() {
        return on(Types.LIST_OF_DOUBLE);
    }

    public static Level0SetOperator<Set<Double>,Double> onSetOfDouble() {
        return on(Types.SET_OF_DOUBLE);
    }

    
    public static Level0GenericUniqOperator<Float,Float> onFloat() {
        return on(Types.FLOAT);
    }

    public static Level0ArrayOperator<Float[],Float> onArrayOfFloat() {
        return on(Types.ARRAY_OF_FLOAT);
    }

    public static Level0ListOperator<List<Float>,Float> onListOfFloat() {
        return on(Types.LIST_OF_FLOAT);
    }

    public static Level0SetOperator<Set<Float>,Float> onSetOfFloat() {
        return on(Types.SET_OF_FLOAT);
    }

    
    public static Level0GenericUniqOperator<Integer,Integer> onInteger() {
        return on(Types.INTEGER);
    }

    public static Level0ArrayOperator<Integer[],Integer> onArrayOfInteger() {
        return on(Types.ARRAY_OF_INTEGER);
    }

    public static Level0ListOperator<List<Integer>,Integer> onListOfInteger() {
        return on(Types.LIST_OF_INTEGER);
    }

    public static Level0SetOperator<Set<Integer>,Integer> onSetOfInteger() {
        return on(Types.SET_OF_INTEGER);
    }

    
    public static Level0GenericUniqOperator<Long,Long> onLong() {
        return on(Types.LONG);
    }

    public static Level0ArrayOperator<Long[],Long> onArrayOfLong() {
        return on(Types.ARRAY_OF_LONG);
    }

    public static Level0ListOperator<List<Long>,Long> onListOfLong() {
        return on(Types.LIST_OF_LONG);
    }

    public static Level0SetOperator<Set<Long>,Long> onSetOfLong() {
        return on(Types.SET_OF_LONG);
    }

    
    public static Level0GenericUniqOperator<Short,Short> onShort() {
        return on(Types.SHORT);
    }

    public static Level0ArrayOperator<Short[],Short> onArrayOfShort() {
        return on(Types.ARRAY_OF_SHORT);
    }

    public static Level0ListOperator<List<Short>,Short> onListOfShort() {
        return on(Types.LIST_OF_SHORT);
    }

    public static Level0SetOperator<Set<Short>,Short> onSetOfShort() {
        return on(Types.SET_OF_SHORT);
    }

    
    public static Level0GenericUniqOperator<String,String> onString() {
        return on(Types.STRING);
    }

    public static Level0ArrayOperator<String[],String> onArrayOfString() {
        return on(Types.ARRAY_OF_STRING);
    }

    public static Level0ListOperator<List<String>,String> onListOfString() {
        return on(Types.LIST_OF_STRING);
    }

    public static Level0SetOperator<Set<String>,String> onSetOfString() {
        return on(Types.SET_OF_STRING);
    }

    
    
    
    @SuppressWarnings("unchecked")
    public static <L,R> Level0GenericUniqOperator<ValuePair<L,R>,ValuePair<L,R>> onValuePairOf(final Type<L> leftType, final Type<R> rightType) {
        return on((Type<ValuePair<L,R>>)(Type<?>)Types.forClass(ValuePair.class, TypeParameters.forType(leftType), TypeParameters.forType(rightType)));
    }
    
    
    
    
    
    
    
    
    
    
    public static <T> Level0ArrayOperator<T[],T> on(final Type<T[]> type) {
        return onArrayOf(Types.arrayComponentOf(type));
    }
    
    public static <T> Level0ListOperator<List<T>,T> on(final Type<List<T>> type) {
        return onListOf(Types.listComponentOf(type));
    }

    
    public static <K,V> Level0MapOperator<Map<K,V>,K,V> on(final Type<Map<K,V>> type) {
        return onMapOf(Types.mapKeyComponentOf(type), Types.mapValueComponentOf(type));
    }

    
    public static <T> Level0SetOperator<Set<T>,T> on(final Type<Set<T>> type) {
        return onSetOf(Types.setComponentOf(type));
    }
    
    
    
    
    
    
    
    
    
    public static <T> Level0ArrayOperator<T[],T> onArrayOf(final Type<T> type) {
        return new Level0ArrayOperator<T[],T>(type, ExecutionTarget.forFn(Normalisation.ARRAY(type.getRawClass())));
    }

    
    public static <T> Level0ListOperator<List<T>,T> onListOf(final Type<T> type) {
        return new Level0ListOperator<List<T>,T>(ExecutionTarget.forFn(Normalisation.LIST));
    }

    
    public static <K,V> Level0MapOperator<Map<K,V>,K,V> onMapOf(final Type<K> keyType, Type<V> valueType) {
        return new Level0MapOperator<Map<K,V>,K,V>(ExecutionTarget.forFn(Normalisation.MAP));
    }

    
    public static <T> Level0SetOperator<Set<T>,T> onSetOf(final Type<T> type) {
        return new Level0SetOperator<Set<T>,T>(ExecutionTarget.forFn(Normalisation.SET));
    }
    
    

}

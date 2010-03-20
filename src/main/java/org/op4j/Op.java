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
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.operators.impl.op.array.Level0ArrayOperator;
import org.op4j.operators.impl.op.array.Level0IndefiniteArrayOperator;
import org.op4j.operators.impl.op.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.op.list.Level0ListOperator;
import org.op4j.operators.impl.op.map.Level0BuildingMapOperator;
import org.op4j.operators.impl.op.map.Level0MapOperator;
import org.op4j.operators.impl.op.set.Level0SetOperator;
import org.op4j.target.ExecutionTarget;
import org.op4j.target.Target.Normalisation;
import org.op4j.util.VarArgsUtil;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Op {
    

    
    
    
    private Op() {
        super();
    }

    
    
    
    
    
    
    
    public static <T> Level0GenericUniqOperator<T,T> on(final T target) {
        return new Level0GenericUniqOperator<T,T>(ExecutionTarget.forOp(target, Normalisation.NONE));
    }
    
    public static <T> Level0GenericUniqOperator<T,T> on(final Type<T> type, final T target) {
        return new Level0GenericUniqOperator<T,T>(ExecutionTarget.forOp(target, Normalisation.NONE));
    }
    
    
    
    
    public static <T> Level0IndefiniteArrayOperator<T[],T> on(final T[] target) {
        return onArray(target);
    }
    
    public static <T> Level0ArrayOperator<T[],T> on(final Type<T[]> type, final T[] target) {
        return onArrayOf(Types.arrayComponentOf(type), target);
    }

    
    public static <T> Level0ArrayOperator<Byte[],Byte> on(final byte[] target) {
        return onArrayOf(Types.BYTE, ArrayUtils.toObject(target));
    }

    public static <T> Level0ArrayOperator<Short[],Short> on(final short[] target) {
        return onArrayOf(Types.SHORT, ArrayUtils.toObject(target));
    }

    public static <T> Level0ArrayOperator<Integer[],Integer> on(final int[] target) {
        return onArrayOf(Types.INTEGER, ArrayUtils.toObject(target));
    }

    public static <T> Level0ArrayOperator<Long[],Long> on(final long[] target) {
        return onArrayOf(Types.LONG, ArrayUtils.toObject(target));
    }

    public static <T> Level0ArrayOperator<Float[],Float> on(final float[] target) {
        return onArrayOf(Types.FLOAT, ArrayUtils.toObject(target));
    }

    public static <T> Level0ArrayOperator<Double[],Double> on(final double[] target) {
        return onArrayOf(Types.DOUBLE, ArrayUtils.toObject(target));
    }

    public static <T> Level0ArrayOperator<Character[],Character> on(final char[] target) {
        return onArrayOf(Types.CHARACTER, ArrayUtils.toObject(target));
    }

    public static <T> Level0ArrayOperator<Boolean[],Boolean> on(final boolean[] target) {
        return onArrayOf(Types.BOOLEAN, ArrayUtils.toObject(target));
    }
    
    public static <T> Level0ArrayOperator<Byte[],Byte> on(final Byte[] target) {
        return onArrayOf(Types.BYTE, target);
    }

    public static <T> Level0ArrayOperator<Short[],Short> on(final Short[] target) {
        return onArrayOf(Types.SHORT, target);
    }

    public static <T> Level0ArrayOperator<Integer[],Integer> on(final Integer[] target) {
        return onArrayOf(Types.INTEGER, target);
    }

    public static <T> Level0ArrayOperator<Long[],Long> on(final Long[] target) {
        return onArrayOf(Types.LONG, target);
    }

    public static <T> Level0ArrayOperator<Float[],Float> on(final Float[] target) {
        return onArrayOf(Types.FLOAT, target);
    }

    public static <T> Level0ArrayOperator<Double[],Double> on(final Double[] target) {
        return onArrayOf(Types.DOUBLE, target);
    }

    public static <T> Level0ArrayOperator<Character[],Character> on(final Character[] target) {
        return onArrayOf(Types.CHARACTER, target);
    }

    public static <T> Level0ArrayOperator<Boolean[],Boolean> on(final Boolean[] target) {
        return onArrayOf(Types.BOOLEAN, target);
    }

    public static <T> Level0ArrayOperator<String[],String> on(final String[] target) {
        return onArrayOf(Types.STRING, target);
    }

    public static <T> Level0ArrayOperator<BigInteger[],BigInteger> on(final BigInteger[] target) {
        return onArrayOf(Types.BIG_INTEGER, target);
    }

    public static <T> Level0ArrayOperator<BigDecimal[],BigDecimal> on(final BigDecimal[] target) {
        return onArrayOf(Types.BIG_DECIMAL, target);
    }

    public static <T> Level0ArrayOperator<Calendar[],Calendar> on(final Calendar[] target) {
        return onArrayOf(Types.CALENDAR, target);
    }

    public static <T> Level0ArrayOperator<Date[],Date> on(final Date[] target) {
        return onArrayOf(Types.DATE, target);
    }

    public static <T> Level0ArrayOperator<java.sql.Date[],java.sql.Date> on(final java.sql.Date[] target) {
        return onArrayOf(Types.forClass(java.sql.Date.class), target);
    }

    public static <T> Level0ArrayOperator<Timestamp[],Timestamp> on(final Timestamp[] target) {
        return onArrayOf(Types.forClass(Timestamp.class), target);
    }
    
    
    
    
    public static <T> Level0ListOperator<List<T>,T> on(final List<T> target) {
        return onList(target);
    }
    
    public static <T> Level0ListOperator<List<T>,T> on(final Type<List<T>> type, final List<? extends T> target) {
        return onListOf(Types.listComponentOf(type),target);
    }

    
    
    public static <K,V> Level0MapOperator<Map<K,V>,K,V> on(final Map<K,V> target) {
        return onMap(target);
    }
    
    public static <K,V> Level0MapOperator<Map<K,V>,K,V> on(final Type<K> keyType, final Type<V> valueType, final Map<K,V> target) {
        return onMapOf(keyType, valueType, target);
    }

    
    
    public static <T> Level0SetOperator<Set<T>,T> on(final Set<T> target) {
        return onSet(target);
    }
    
    public static <T> Level0SetOperator<Set<T>,T> on(final Type<Set<T>> type, final Set<? extends T> target) {
        return onSetOf(Types.setComponentOf(type),target);
    }
    
    
    
    
    
    
    public static <T> Level0IndefiniteArrayOperator<T[],T> onArray(final T[] target) {
        return new Level0IndefiniteArrayOperator<T[],T>(ExecutionTarget.forOp(target, Normalisation.NONE));
    }
    
    public static <T> Level0ArrayOperator<T[],T> onArrayOf(final Type<T> type, final T[] target) {
        return new Level0ArrayOperator<T[],T>(type, ExecutionTarget.forOp(target, Normalisation.ARRAY(type.getRawClass())));
    }
    
    public static <T> Level0ArrayOperator<Byte[],Byte> onArray(final byte[] target) {
        return onArrayOf(Types.BYTE, ArrayUtils.toObject(target));
    }

    public static <T> Level0ArrayOperator<Short[],Short> onArray(final short[] target) {
        return onArrayOf(Types.SHORT, ArrayUtils.toObject(target));
    }

    public static <T> Level0ArrayOperator<Integer[],Integer> onArray(final int[] target) {
        return onArrayOf(Types.INTEGER, ArrayUtils.toObject(target));
    }

    public static <T> Level0ArrayOperator<Long[],Long> onArray(final long[] target) {
        return onArrayOf(Types.LONG, ArrayUtils.toObject(target));
    }

    public static <T> Level0ArrayOperator<Float[],Float> onArray(final float[] target) {
        return onArrayOf(Types.FLOAT, ArrayUtils.toObject(target));
    }

    public static <T> Level0ArrayOperator<Double[],Double> onArray(final double[] target) {
        return onArrayOf(Types.DOUBLE, ArrayUtils.toObject(target));
    }

    public static <T> Level0ArrayOperator<Character[],Character> onArray(final char[] target) {
        return onArrayOf(Types.CHARACTER, ArrayUtils.toObject(target));
    }

    public static <T> Level0ArrayOperator<Boolean[],Boolean> onArray(final boolean[] target) {
        return onArrayOf(Types.BOOLEAN, ArrayUtils.toObject(target));
    }
    
    public static <T> Level0ArrayOperator<Byte[],Byte> onArray(final Byte[] target) {
        return onArrayOf(Types.BYTE, target);
    }

    public static <T> Level0ArrayOperator<Short[],Short> onArray(final Short[] target) {
        return onArrayOf(Types.SHORT, target);
    }

    public static <T> Level0ArrayOperator<Integer[],Integer> onArray(final Integer[] target) {
        return onArrayOf(Types.INTEGER, target);
    }

    public static <T> Level0ArrayOperator<Long[],Long> onArray(final Long[] target) {
        return onArrayOf(Types.LONG, target);
    }

    public static <T> Level0ArrayOperator<Float[],Float> onArray(final Float[] target) {
        return onArrayOf(Types.FLOAT, target);
    }

    public static <T> Level0ArrayOperator<Double[],Double> onArray(final Double[] target) {
        return onArrayOf(Types.DOUBLE, target);
    }

    public static <T> Level0ArrayOperator<Character[],Character> onArray(final Character[] target) {
        return onArrayOf(Types.CHARACTER, target);
    }

    public static <T> Level0ArrayOperator<Boolean[],Boolean> onArray(final Boolean[] target) {
        return onArrayOf(Types.BOOLEAN, target);
    }

    public static <T> Level0ArrayOperator<String[],String> onArray(final String[] target) {
        return onArrayOf(Types.STRING, target);
    }

    public static <T> Level0ArrayOperator<BigInteger[],BigInteger> onArray(final BigInteger[] target) {
        return onArrayOf(Types.BIG_INTEGER, target);
    }

    public static <T> Level0ArrayOperator<BigDecimal[],BigDecimal> onArray(final BigDecimal[] target) {
        return onArrayOf(Types.BIG_DECIMAL, target);
    }

    public static <T> Level0ArrayOperator<Calendar[],Calendar> onArray(final Calendar[] target) {
        return onArrayOf(Types.CALENDAR, target);
    }

    public static <T> Level0ArrayOperator<Date[],Date> onArray(final Date[] target) {
        return onArrayOf(Types.DATE, target);
    }

    public static <T> Level0ArrayOperator<java.sql.Date[],java.sql.Date> onArray(final java.sql.Date[] target) {
        return onArrayOf(Types.forClass(java.sql.Date.class), target);
    }

    public static <T> Level0ArrayOperator<Timestamp[],Timestamp> onArray(final Timestamp[] target) {
        return onArrayOf(Types.forClass(Timestamp.class), target);
    }
    

    
    /*
     * No "onArrayFor" methods can be added here for primitives, as vararg parameters
     * cannot be used with primitives without causing "ambiguous method" problems.
     */
    
    public static <T> Level0IndefiniteArrayOperator<T[],T> onArrayFor(final T... elements) {
        return new Level0IndefiniteArrayOperator<T[],T>(ExecutionTarget.forOp(VarArgsUtil.asRequiredObjectArray(elements), Normalisation.NONE));
    }
    
    public static <T> Level0ArrayOperator<Byte[],Byte> onArrayFor(final Byte... elements) {
        return onArrayOf(Types.BYTE, VarArgsUtil.asRequiredObjectArray(elements));
    }

    public static <T> Level0ArrayOperator<Short[],Short> onArrayFor(final Short... elements) {
        return onArrayOf(Types.SHORT, VarArgsUtil.asRequiredObjectArray(elements));
    }

    public static <T> Level0ArrayOperator<Integer[],Integer> onArrayFor(final Integer... elements) {
        return onArrayOf(Types.INTEGER, VarArgsUtil.asRequiredObjectArray(elements));
    }

    public static <T> Level0ArrayOperator<Long[],Long> onArrayFor(final Long... elements) {
        return onArrayOf(Types.LONG, VarArgsUtil.asRequiredObjectArray(elements));
    }

    public static <T> Level0ArrayOperator<Float[],Float> onArrayFor(final Float... elements) {
        return onArrayOf(Types.FLOAT, VarArgsUtil.asRequiredObjectArray(elements));
    }

    public static <T> Level0ArrayOperator<Double[],Double> onArrayFor(final Double... elements) {
        return onArrayOf(Types.DOUBLE, VarArgsUtil.asRequiredObjectArray(elements));
    }

    public static <T> Level0ArrayOperator<Character[],Character> onArrayFor(final Character... elements) {
        return onArrayOf(Types.CHARACTER, VarArgsUtil.asRequiredObjectArray(elements));
    }

    public static <T> Level0ArrayOperator<Boolean[],Boolean> onArrayFor(final Boolean... elements) {
        return onArrayOf(Types.BOOLEAN, VarArgsUtil.asRequiredObjectArray(elements));
    }

    public static <T> Level0ArrayOperator<String[],String> onArrayFor(final String... elements) {
        return onArrayOf(Types.STRING, VarArgsUtil.asRequiredObjectArray(elements));
    }

    public static <T> Level0ArrayOperator<BigInteger[],BigInteger> onArrayFor(final BigInteger... elements) {
        return onArrayOf(Types.BIG_INTEGER, VarArgsUtil.asRequiredObjectArray(elements));
    }

    public static <T> Level0ArrayOperator<BigDecimal[],BigDecimal> onArrayFor(final BigDecimal... elements) {
        return onArrayOf(Types.BIG_DECIMAL, VarArgsUtil.asRequiredObjectArray(elements));
    }

    public static <T> Level0ArrayOperator<Calendar[],Calendar> onArrayFor(final Calendar... elements) {
        return onArrayOf(Types.CALENDAR, VarArgsUtil.asRequiredObjectArray(elements));
    }

    public static <T> Level0ArrayOperator<Date[],Date> onArrayFor(final Date... elements) {
        return onArrayOf(Types.DATE, VarArgsUtil.asRequiredObjectArray(elements));
    }

    public static <T> Level0ArrayOperator<java.sql.Date[],java.sql.Date> onArrayFor(final java.sql.Date... elements) {
        return onArrayOf(Types.forClass(java.sql.Date.class), VarArgsUtil.asRequiredObjectArray(elements));
    }

    public static <T> Level0ArrayOperator<Timestamp[],Timestamp> onArrayFor(final Timestamp... elements) {
        return onArrayOf(Types.forClass(Timestamp.class), VarArgsUtil.asRequiredObjectArray(elements));
    }

    
    
    
    
    
    
    
    
    
    
    
    
    public static <T> Level0ListOperator<List<T>,T> onList(final List<T> target) {
        return new Level0ListOperator<List<T>,T>(ExecutionTarget.forOp(target, Normalisation.LIST));
    }
    
    public static <T> Level0ListOperator<List<T>,T> onListOf(final Type<T> type, final List<? extends T> target) {
        return new Level0ListOperator<List<T>,T>(ExecutionTarget.forOp(target, Normalisation.LIST));
    }
    
    public static <T> Level0ListOperator<List<T>,T> onListFor(final T... elements) {
        return new Level0ListOperator<List<T>,T>(ExecutionTarget.forOp(VarArgsUtil.asRequiredObjectList(elements), Normalisation.LIST));
    }


    
    
    
    public static <K,V> Level0MapOperator<Map<K,V>,K,V> onMap(final Map<K,V> target) {
        return new Level0MapOperator<Map<K,V>,K,V>(ExecutionTarget.forOp(target, Normalisation.MAP));
    }
    
    public static <K,V> Level0MapOperator<Map<K,V>,K,V> onMapOf(final Type<K> keyType, final Type<V> valueType, final Map<? extends K,? extends V> target) {
        return new Level0MapOperator<Map<K,V>,K,V>(ExecutionTarget.forOp(target, Normalisation.MAP));
    }


    public static <K,V> Level0BuildingMapOperator<Map<K,V>,K,V> onMapFor(final K key, final V value) {
        final Map<K,V> newTarget = new LinkedHashMap<K, V>();
        newTarget.put(key, value);
        return new Level0BuildingMapOperator<Map<K,V>,K,V>(ExecutionTarget.forOp(newTarget, Normalisation.MAP));
    }

    
    
    
    public static <T> Level0SetOperator<Set<T>,T> onSet(final Set<T> target) {
        return new Level0SetOperator<Set<T>,T>(ExecutionTarget.forOp(target, Normalisation.SET));
    }
    
    public static <T> Level0SetOperator<Set<T>,T> onSetOf(final Type<T> type, final Set<? extends T> target) {
        return new Level0SetOperator<Set<T>,T>(ExecutionTarget.forOp(target, Normalisation.SET));
    }
    
    public static <T> Level0SetOperator<Set<T>,T> onSetFor(final T... elements) {
        return new Level0SetOperator<Set<T>,T>(ExecutionTarget.forOp(VarArgsUtil.asRequiredObjectSet(elements), Normalisation.SET));
    }
    
    

}

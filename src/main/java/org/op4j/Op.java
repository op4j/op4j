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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.operators.impl.op.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.op.array.Level0IndefiniteArrayOperatorImpl;
import org.op4j.operators.impl.op.generic.Level0GenericMultiOperatorImpl;
import org.op4j.operators.impl.op.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.op.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.op.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.op.set.Level0SetOperatorImpl;
import org.op4j.target.ExecutionTarget;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
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

    
    
    
    
    
    
    
    public static <T> Level0GenericUniqOperatorImpl<T,T> on(final T target) {
        return new Level0GenericUniqOperatorImpl<T,T>(ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    
    
    public static <T> Level0GenericMultiOperatorImpl<T,T> onAll(final T... targets) {
        return new Level0GenericMultiOperatorImpl<T,T>(ExecutionTarget.forOp(VarArgsUtil.asTargetList(targets), Normalisation.NONE).iterate(Structure.LIST, true));
    }

    
    
    
    
    public static <T> Level0IndefiniteArrayOperatorImpl<T[],T> on(final T[] target) {
        return new Level0IndefiniteArrayOperatorImpl<T[],T>(ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    
    public static <T> Level0ArrayOperatorImpl<Byte[],Byte> on(final byte[] target) {
        return new Level0ArrayOperatorImpl<Byte[],Byte>(Types.BYTE, ExecutionTarget.forOp(ArrayUtils.toObject(target), Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Short[],Short> on(final short[] target) {
        return new Level0ArrayOperatorImpl<Short[],Short>(Types.SHORT, ExecutionTarget.forOp(ArrayUtils.toObject(target), Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Integer[],Integer> on(final int[] target) {
        return new Level0ArrayOperatorImpl<Integer[],Integer>(Types.INTEGER, ExecutionTarget.forOp(ArrayUtils.toObject(target), Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Long[],Long> on(final long[] target) {
        return new Level0ArrayOperatorImpl<Long[],Long>(Types.LONG, ExecutionTarget.forOp(ArrayUtils.toObject(target), Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Float[],Float> on(final float[] target) {
        return new Level0ArrayOperatorImpl<Float[],Float>(Types.FLOAT, ExecutionTarget.forOp(ArrayUtils.toObject(target), Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Double[],Double> on(final double[] target) {
        return new Level0ArrayOperatorImpl<Double[],Double>(Types.DOUBLE, ExecutionTarget.forOp(ArrayUtils.toObject(target), Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Character[],Character> on(final char[] target) {
        return new Level0ArrayOperatorImpl<Character[],Character>(Types.CHARACTER, ExecutionTarget.forOp(ArrayUtils.toObject(target), Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Boolean[],Boolean> on(final boolean[] target) {
        return new Level0ArrayOperatorImpl<Boolean[],Boolean>(Types.BOOLEAN, ExecutionTarget.forOp(ArrayUtils.toObject(target), Normalisation.NONE));
    }
    
    public static <T> Level0ArrayOperatorImpl<Byte[],Byte> on(final Byte[] target) {
        return new Level0ArrayOperatorImpl<Byte[],Byte>(Types.BYTE, ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Short[],Short> on(final Short[] target) {
        return new Level0ArrayOperatorImpl<Short[],Short>(Types.SHORT, ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Integer[],Integer> on(final Integer[] target) {
        return new Level0ArrayOperatorImpl<Integer[],Integer>(Types.INTEGER, ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Long[],Long> on(final Long[] target) {
        return new Level0ArrayOperatorImpl<Long[],Long>(Types.LONG, ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Float[],Float> on(final Float[] target) {
        return new Level0ArrayOperatorImpl<Float[],Float>(Types.FLOAT, ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Double[],Double> on(final Double[] target) {
        return new Level0ArrayOperatorImpl<Double[],Double>(Types.DOUBLE, ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Character[],Character> on(final Character[] target) {
        return new Level0ArrayOperatorImpl<Character[],Character>(Types.CHARACTER, ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Boolean[],Boolean> on(final Boolean[] target) {
        return new Level0ArrayOperatorImpl<Boolean[],Boolean>(Types.BOOLEAN, ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<String[],String> on(final String[] target) {
        return new Level0ArrayOperatorImpl<String[],String>(Types.STRING, ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<BigInteger[],BigInteger> on(final BigInteger[] target) {
        return new Level0ArrayOperatorImpl<BigInteger[],BigInteger>(Types.BIG_INTEGER, ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<BigDecimal[],BigDecimal> on(final BigDecimal[] target) {
        return new Level0ArrayOperatorImpl<BigDecimal[],BigDecimal>(Types.BIG_DECIMAL, ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Calendar[],Calendar> on(final Calendar[] target) {
        return new Level0ArrayOperatorImpl<Calendar[],Calendar>(Types.CALENDAR, ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Date[],Date> on(final Date[] target) {
        return new Level0ArrayOperatorImpl<Date[],Date>(Types.DATE, ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<java.sql.Date[],java.sql.Date> on(final java.sql.Date[] target) {
        return new Level0ArrayOperatorImpl<java.sql.Date[],java.sql.Date>(Types.forClass(java.sql.Date.class), ExecutionTarget.forOp(target, Normalisation.NONE));
    }

    public static <T> Level0ArrayOperatorImpl<Timestamp[],Timestamp> on(final Timestamp[] target) {
        return new Level0ArrayOperatorImpl<Timestamp[],Timestamp>(Types.forClass(Timestamp.class), ExecutionTarget.forOp(target, Normalisation.NONE));
    }
    
    
    
    public static <T> Level0ListOperatorImpl<List<T>,T> on(final List<T> target) {
        return onList(target);
    }

    
    public static <K,V> Level0MapOperatorImpl<Map<K,V>,K,V> on(final Map<K,V> target) {
        return onMap(target);
    }

    
    public static <T> Level0SetOperatorImpl<Set<T>,T> on(final Set<T> target) {
        return onSet(target);
    }
    
    
    
    
    
    public static <T> Level0ArrayOperatorImpl<T[],T> onArrayOf(final Type<T> type, final T[] target) {
        return new Level0ArrayOperatorImpl<T[],T>(type, ExecutionTarget.forOp(target, Normalisation.ARRAY(type.getRawClass())));
    }

    
    public static <T> Level0ListOperatorImpl<List<T>,T> onList(final List<T> target) {
        return new Level0ListOperatorImpl<List<T>,T>(ExecutionTarget.forOp(target, Normalisation.LIST));
    }

    
    public static <K,V> Level0MapOperatorImpl<Map<K,V>,K,V> onMap(final Map<K,V> target) {
        return new Level0MapOperatorImpl<Map<K,V>,K,V>(ExecutionTarget.forOp(target, Normalisation.MAP));
    }

    
    public static <T> Level0SetOperatorImpl<Set<T>,T> onSet(final Set<T> target) {
        return new Level0SetOperatorImpl<Set<T>,T>(ExecutionTarget.forOp(target, Normalisation.SET));
    }
    
    

}

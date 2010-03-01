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

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
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
    
    public static <T> Level0GenericUniqOperatorImpl<Byte,Byte> on(final byte target) {
        return new Level0GenericUniqOperatorImpl<Byte,Byte>(ExecutionTarget.forOp(Byte.valueOf(target), Normalisation.NONE));
    }
    
    public static <T> Level0GenericUniqOperatorImpl<Short,Short> on(final short target) {
        return new Level0GenericUniqOperatorImpl<Short,Short>(ExecutionTarget.forOp(Short.valueOf(target), Normalisation.NONE));
    }
    
    public static <T> Level0GenericUniqOperatorImpl<Integer,Integer> on(final int target) {
        return new Level0GenericUniqOperatorImpl<Integer,Integer>(ExecutionTarget.forOp(Integer.valueOf(target), Normalisation.NONE));
    }
    
    public static <T> Level0GenericUniqOperatorImpl<Long,Long> on(final long target) {
        return new Level0GenericUniqOperatorImpl<Long,Long>(ExecutionTarget.forOp(Long.valueOf(target), Normalisation.NONE));
    }
    
    public static <T> Level0GenericUniqOperatorImpl<Float,Float> on(final float target) {
        return new Level0GenericUniqOperatorImpl<Float,Float>(ExecutionTarget.forOp(Float.valueOf(target), Normalisation.NONE));
    }
    
    public static <T> Level0GenericUniqOperatorImpl<Double,Double> on(final double target) {
        return new Level0GenericUniqOperatorImpl<Double,Double>(ExecutionTarget.forOp(Double.valueOf(target), Normalisation.NONE));
    }
    
    public static <T> Level0GenericUniqOperatorImpl<Boolean,Boolean> on(final boolean target) {
        return new Level0GenericUniqOperatorImpl<Boolean,Boolean>(ExecutionTarget.forOp(Boolean.valueOf(target), Normalisation.NONE));
    }
    
    public static <T> Level0GenericUniqOperatorImpl<Character,Character> on(final char target) {
        return new Level0GenericUniqOperatorImpl<Character,Character>(ExecutionTarget.forOp(Character.valueOf(target), Normalisation.NONE));
    }

    
    
    public static <T> Level0GenericMultiOperatorImpl<T,T> onAll(final T... targets) {
        return new Level0GenericMultiOperatorImpl<T,T>(ExecutionTarget.forOp(VarArgsUtil.asTargetList(targets), Normalisation.NONE).iterate(Structure.LIST, true));
    }
    
//    public static <T> Level0GenericMultiOperatorImpl<Byte,Byte> onAll(final byte... targets) {
//        return new Level0GenericMultiOperatorImpl<Byte,Byte>(ExecutionTarget.forOp(VarArgsUtil.asByteTargetList(targets), Normalisation.NONE).iterate(Structure.LIST, true));
//    }
//    
//    public static <T> Level0GenericMultiOperatorImpl<Short,Short> onAll(final short... targets) {
//        return new Level0GenericMultiOperatorImpl<Short,Short>(ExecutionTarget.forOp(VarArgsUtil.asShortTargetList(targets), Normalisation.NONE).iterate(Structure.LIST, true));
//    }
    
    public static <T> Level0GenericMultiOperatorImpl<Integer,Integer> onAll(final int... targets) {
        return new Level0GenericMultiOperatorImpl<Integer,Integer>(ExecutionTarget.forOp(VarArgsUtil.asIntegerTargetList(targets), Normalisation.NONE).iterate(Structure.LIST, true));
    }
    
    public static <T> Level0GenericMultiOperatorImpl<Long,Long> onAll(final long... targets) {
        return new Level0GenericMultiOperatorImpl<Long,Long>(ExecutionTarget.forOp(VarArgsUtil.asLongTargetList(targets), Normalisation.NONE).iterate(Structure.LIST, true));
    }
//    
//    public static <T> Level0GenericMultiOperatorImpl<Float,Float> onAll(final float... targets) {
//        return new Level0GenericMultiOperatorImpl<Float,Float>(ExecutionTarget.forOp(VarArgsUtil.asFloatTargetList(targets), Normalisation.NONE).iterate(Structure.LIST, true));
//    }
//    
//    public static <T> Level0GenericMultiOperatorImpl<Double,Double> onAll(final double... targets) {
//        return new Level0GenericMultiOperatorImpl<Double,Double>(ExecutionTarget.forOp(VarArgsUtil.asDoubleTargetList(targets), Normalisation.NONE).iterate(Structure.LIST, true));
//    }
//    
//    public static <T> Level0GenericMultiOperatorImpl<Boolean,Boolean> onAll(final boolean... targets) {
//        return new Level0GenericMultiOperatorImpl<Boolean,Boolean>(ExecutionTarget.forOp(VarArgsUtil.asBooleanTargetList(targets), Normalisation.NONE).iterate(Structure.LIST, true));
//    }
//    
//    public static <T> Level0GenericMultiOperatorImpl<Character,Character> onAll(final char... targets) {
//        return new Level0GenericMultiOperatorImpl<Character,Character>(ExecutionTarget.forOp(VarArgsUtil.asCharacterTargetList(targets), Normalisation.NONE).iterate(Structure.LIST, true));
//    }

    
    
    
    
    public static <T> Level0IndefiniteArrayOperatorImpl<T[],T> on(final T[] target) {
        return new Level0IndefiniteArrayOperatorImpl<T[],T>(ExecutionTarget.forOp(target, Normalisation.NONE));
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

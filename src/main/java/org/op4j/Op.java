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
package org.op4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.operators.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericMultiOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.mapofarray.Level0MapOfArrayOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level0MapOfListOperatorImpl;
import org.op4j.operators.impl.mapofset.Level0MapOfSetOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.generic.Level0GenericMultiOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
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

    
    
    
    
    
    
    
    public static <T> Level0GenericUniqOperator<T> on(final T target) {
        return new Level0GenericUniqOperatorImpl<T>(ExecutionTarget.forObject(target, Normalisation.NONE));
    }

    
    public static <T> Level0GenericMultiOperator<T> onAll(final T... targets) {
        return new Level0GenericMultiOperatorImpl<T>(ExecutionTarget.forObject(VarArgsUtil.asRequiredObjectList(targets), Normalisation.NONE).iterate(Structure.LIST, true));
    }

    
    
    
    
    public static <T> Level0ListOperator<T>on(final List<T> target) {
        return onList(target);
    }

    
    public static <K,V> Level0MapOperator<K,V> on(final Map<K,V> target) {
        return onMap(target);
    }

    
    public static <T> Level0SetOperator<T> on(final Set<T> target) {
        return onSet(target);
    }
    
    
    
    
    
    public static <T> Level0ArrayOperator<T> onArrayOf(final Type<T> type, final T[] target) {
        return new Level0ArrayOperatorImpl<T>(type, ExecutionTarget.forObject(target, Normalisation.ARRAY(type.getRawClass())));
    }

    
    public static <T> Level0ListOperator<T>onList(final List<T> target) {
        return new Level0ListOperatorImpl<T>(ExecutionTarget.forObject(target, Normalisation.LIST));
    }

    
    public static <K,V> Level0MapOperator<K,V> onMap(final Map<K,V> target) {
        return new Level0MapOperatorImpl<K,V>(ExecutionTarget.forObject(target, Normalisation.MAP));
    }

    
    public static <K,V> Level0MapOfArrayOperator<K,V> onMapOfArrayOf(final Type<V> valueType, final Map<K,V[]> target) {
        return new Level0MapOfArrayOperatorImpl<K,V>(valueType, ExecutionTarget.forObject(target, Normalisation.MAP_OF_ARRAY(valueType.getRawClass())));
    }

    
    public static <K,V> Level0MapOfListOperator<K,V> onMapOfList(final Map<K,? extends List<V>> target) {
        return new Level0MapOfListOperatorImpl<K,V>(ExecutionTarget.forObject(target, Normalisation.MAP_OF_LIST));
    }

    
    public static <K,V> Level0MapOfSetOperator<K,V> onMapOfSet(final Map<K,? extends Set<V>> target) {
        return new Level0MapOfSetOperatorImpl<K,V>(ExecutionTarget.forObject(target, Normalisation.MAP_OF_SET));
    }

    
    public static <T> Level0SetOperator<T> onSet(final Set<T> target) {
        return new Level0SetOperatorImpl<T>(ExecutionTarget.forObject(target, Normalisation.SET));
    }
    
    
    

}

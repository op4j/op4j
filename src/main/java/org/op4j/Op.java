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

import org.op4j.operators.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.arrayofarray.Level0ArrayOfArrayOperatorImpl;
import org.op4j.operators.impl.arrayoflist.Level0ArrayOfListOperatorImpl;
import org.op4j.operators.impl.arrayofmap.Level0ArrayOfMapOperatorImpl;
import org.op4j.operators.impl.arrayofset.Level0ArrayOfSetOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericMultiOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.listofarray.Level0ListOfArrayOperatorImpl;
import org.op4j.operators.impl.listoflist.Level0ListOfListOperatorImpl;
import org.op4j.operators.impl.listofmap.Level0ListOfMapOperatorImpl;
import org.op4j.operators.impl.listofset.Level0ListOfSetOperatorImpl;
import org.op4j.operators.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.mapofarray.Level0MapOfArrayOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level0MapOfListOperatorImpl;
import org.op4j.operators.impl.mapofmap.Level0MapOfMapOperatorImpl;
import org.op4j.operators.impl.mapofset.Level0MapOfSetOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.impl.setofarray.Level0SetOfArrayOperatorImpl;
import org.op4j.operators.impl.setoflist.Level0SetOfListOperatorImpl;
import org.op4j.operators.impl.setofmap.Level0SetOfMapOperatorImpl;
import org.op4j.operators.impl.setofset.Level0SetOfSetOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericMultiOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.target.NewExecutionTarget;
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

    
    
    
    
    
    
    
    public static <T> Level0GenericUniqOperator<T> on(final T target) {
        return new Level0GenericUniqOperatorImpl<T>(NewExecutionTarget.forObject(target, Normalisation.NONE));
    }

    
    public static <T> Level0GenericMultiOperator<T> onAll(final T... targets) {
        return new Level0GenericMultiOperatorImpl<T>(NewExecutionTarget.forObject(VarArgsUtil.asRequiredObjectList(targets), Normalisation.NONE));
    }

    
    public static <T> Level0ArrayOperator<T> onArray(final T[] target) {
        return new Level0ArrayOperatorImpl<T>(NewExecutionTarget.forObject(target, Normalisation.ARRAY));
    }

    
    public static <T> Level0ArrayOfArrayOperator<T> onArrayOfArray(final T[][] target) {
        return new Level0ArrayOfArrayOperatorImpl<T>(NewExecutionTarget.forObject(target, Normalisation.ARRAY_OF_ARRAY));
    }

    
    public static <T> Level0ArrayOfListOperator<T> onArrayOfList(final List<T>[] target) {
        return new Level0ArrayOfListOperatorImpl<T>(NewExecutionTarget.forObject(target, Normalisation.ARRAY_OF_LIST));
    }

    
    public static <K,V> Level0ArrayOfMapOperator<K,V> onArrayOfMap(final Map<K,V>[] target) {
        return new Level0ArrayOfMapOperatorImpl<K,V>(NewExecutionTarget.forObject(target, Normalisation.ARRAY_OF_MAP));
    }

    
    public static <T> Level0ArrayOfSetOperator<T> onArrayOfSet(final Set<T>[] target) {
        return new Level0ArrayOfSetOperatorImpl<T>(NewExecutionTarget.forObject(target, Normalisation.ARRAY_OF_SET));
    }

    
    public static <T> Level0ListOperator<T>onList(final List<T> target) {
        return new Level0ListOperatorImpl<T>(NewExecutionTarget.forObject(target, Normalisation.LIST));
    }

    
    public static <T> Level0ListOfArrayOperator<T>onListOfArray(final List<T[]> target) {
        return new Level0ListOfArrayOperatorImpl<T>(NewExecutionTarget.forObject(target, Normalisation.LIST_OF_ARRAY));
    }

    
    public static <T> Level0ListOfListOperator<T> onListOfList(final List<? extends List<T>> target) {
        return new Level0ListOfListOperatorImpl<T>(NewExecutionTarget.forObject(target, Normalisation.LIST_OF_LIST));
    }

    
    public static <K,V> Level0ListOfMapOperator<K,V> onListOfMap(final List<? extends Map<K,V>> target) {
        return new Level0ListOfMapOperatorImpl<K,V>(NewExecutionTarget.forObject(target, Normalisation.LIST_OF_MAP));
    }

    
    public static <T> Level0ListOfSetOperator<T> onListOfSet(final List<? extends Set<T>> target) {
        return new Level0ListOfSetOperatorImpl<T>(NewExecutionTarget.forObject(target, Normalisation.LIST_OF_SET));
    }

    
    public static <K,V> Level0MapOperator<K,V> onMap(final Map<K,V> target) {
        return new Level0MapOperatorImpl<K,V>(NewExecutionTarget.forObject(target, Normalisation.MAP));
    }

    
    public static <K,V> Level0MapOfArrayOperator<K,V> onMapOfArray(final Map<K,V[]> target) {
        return new Level0MapOfArrayOperatorImpl<K,V>(NewExecutionTarget.forObject(target, Normalisation.MAP_OF_ARRAY));
    }

    
    public static <K,V> Level0MapOfListOperator<K,V> onMapOfList(final Map<K,? extends List<V>> target) {
        return new Level0MapOfListOperatorImpl<K,V>(NewExecutionTarget.forObject(target, Normalisation.MAP_OF_LIST));
    }

    
    public static <K1,K2,V> Level0MapOfMapOperator<K1,K2,V> onMapOfMap(final Map<K1,? extends Map<K2,V>> target) {
        return new Level0MapOfMapOperatorImpl<K1,K2,V>(NewExecutionTarget.forObject(target, Normalisation.MAP_OF_MAP));
    }

    
    public static <K,V> Level0MapOfSetOperator<K,V> onMapOfSet(final Map<K,? extends Set<V>> target) {
        return new Level0MapOfSetOperatorImpl<K,V>(NewExecutionTarget.forObject(target, Normalisation.MAP_OF_SET));
    }

    
    public static <T> Level0SetOperator<T> onSet(final Set<T> target) {
        return new Level0SetOperatorImpl<T>(NewExecutionTarget.forObject(target, Normalisation.SET));
    }

    
    public static <T> Level0SetOfArrayOperator<T> onSetOfArray(final Set<T[]> target) {
        return new Level0SetOfArrayOperatorImpl<T>(NewExecutionTarget.forObject(target, Normalisation.SET_OF_ARRAY));
    }

    
    public static <T> Level0SetOfListOperator<T> onSetOfList(final Set<? extends List<T>> target) {
        return new Level0SetOfListOperatorImpl<T>(NewExecutionTarget.forObject(target, Normalisation.SET_OF_LIST));
    }

    
    public static <K,V> Level0SetOfMapOperator<K,V> onSetOfMap(final Set<? extends Map<K,V>> target) {
        return new Level0SetOfMapOperatorImpl<K,V>(NewExecutionTarget.forObject(target, Normalisation.SET_OF_MAP));
    }

    
    public static <T> Level0SetOfSetOperator<T> onSetOfSet(final Set<? extends Set<T>> target) {
        return new Level0SetOfSetOperatorImpl<T>(NewExecutionTarget.forObject(target, Normalisation.SET_OF_SET));
    }
    
    
//    @SuppressWarnings("unchecked")
//    public static <T> Level0ArrayOperator<T> buildArray(final Type<T> of) {
//        return onArray((T[]) Array.newInstance(of.getRawClass(), 0));
//    }
//    
//    
//    @SuppressWarnings("unchecked")
//    public static <T> Level0ArrayOfArrayOperator<T> buildArrayOfArray(final Type<T> of) {
//        return onArrayOfArray((T[][]) Array.newInstance(Types.arrayOf(of).getRawClass(), 0));
//    }
//    
//    @SuppressWarnings("unchecked")
//    public static <T> Level0ArrayOfListOperator<T> buildArrayOfList(final Type<T> of) {
//        return onArrayOfList((List<T>[]) Array.newInstance(Types.listOf(of).getRawClass(), 0));
//    }
//    
//    @SuppressWarnings("unchecked")
//    public static <K,V> Level0ArrayOfMapOperator<K,V> buildArrayOfMap(final Type<K> keyOf, final Type<V> valueOf) {
//        return onArrayOfMap((Map<K,V>[]) Array.newInstance(Types.mapOf(keyOf,valueOf).getRawClass(), 0));
//    }
//    
//    @SuppressWarnings("unchecked")
//    public static <T> Level0ArrayOfSetOperator<T> buildArrayOfSet(final Type<T> of) {
//        return onArrayOfSet((Set<T>[]) Array.newInstance(Types.setOf(of).getRawClass(), 0));
//    }
//
//    
//    public static <T> Level0ListOperator<T> buildList(final Type<T> of) {
//        return onList(new ArrayList<T>());
//    }
//    
//    
//    public static <T> Level0ListOfArrayOperator<T> buildListOfArray(final Type<T> of) {
//        return onListOfArray(new ArrayList<T[]>());
//    }
//    
//    public static <T> Level0ListOfListOperator<T> buildListOfList(final Type<T> of) {
//        return onListOfList(new ArrayList<List<T>>());
//    }
//    
//    public static <K,V> Level0ListOfMapOperator<K,V> buildListOfMap(final Type<K> keyOf, final Type<V> valueOf) {
//        return onListOfMap(new ArrayList<Map<K,V>>());
//    }
//    
//    public static <T> Level0ListOfSetOperator<T> buildListOfSet(final Type<T> of) {
//        return onListOfSet(new ArrayList<Set<T>>());
//    }
//    
//    
//    public static <T> Level0SetOperator<T> buildSet(final Type<T> of) {
//        return onSet(new LinkedHashSet<T>());
//    }
//    
//    
//    public static <T> Level0SetOfArrayOperator<T> buildSetOfArray(final Type<T> of) {
//        return onSetOfArray(new LinkedHashSet<T[]>());
//    }
//    
//    public static <T> Level0SetOfListOperator<T> buildSetOfList(final Type<T> of) {
//        return onSetOfList(new LinkedHashSet<List<T>>());
//    }
//    
//    public static <K,V> Level0SetOfMapOperator<K,V> buildSetOfMap(final Type<K> keyOf, final Type<V> valueOf) {
//        return onSetOfMap(new LinkedHashSet<Map<K,V>>());
//    }
//    
//    public static <T> Level0SetOfSetOperator<T> buildSetOfSet(final Type<T> of) {
//        return onSetOfSet(new LinkedHashSet<Set<T>>());
//    }
//    
//    
//    public static <K,V> Level0MapOperator<K,V> buildMap(final Type<K> keyOf, final Type<V> valueOf) {
//        return onMap(new LinkedHashMap<K,V>());
//    }
//    
//    
//    public static <K,V> Level0MapOfArrayOperator<K,V> buildMapOfArray(final Type<K> keyOf, final Type<V> valueOf) {
//        return onMapOfArray(new LinkedHashMap<K,V[]>());
//    }
//    
//    
//    public static <K,V> Level0MapOfListOperator<K,V> buildMapOfList(final Type<K> keyOf, final Type<V> valueOf) {
//        return onMapOfList(new LinkedHashMap<K,List<V>>());
//    }
//    
//    
//    public static <K1,K2,V> Level0MapOfMapOperator<K1,K2,V> buildMapOfMap(final Type<K1> key1Of, final Type<K2> key2Of, final Type<V> valueOf) {
//        return onMapOfMap(new LinkedHashMap<K1,Map<K2,V>>());
//    }
//    
//    
//    public static <K,V> Level0MapOfSetOperator<K,V> buildMapOfSet(final Type<K> keyOf, final Type<V> valueOf) {
//        return onMapOfSet(new LinkedHashMap<K,Set<V>>());
//    }
    
    
    
    
    

}

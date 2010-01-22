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

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.time.StopWatch;
import org.javaruntype.type.Types;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.StringFuncs;
import org.op4j.functions.converters.DecimalPoint;
import org.op4j.functions.converters.ToBigDecimal;
import org.op4j.functions.converters.ToBigInteger;
import org.op4j.functions.converters.ToCalendar;
import org.op4j.functions.converters.ToDouble;
import org.op4j.functions.converters.ToInteger;
import org.op4j.functions.converters.ToLong;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToMapOfArray;
import org.op4j.functions.converters.ToString;
import org.op4j.functions.evaluators.AbstractBooleanEvaluator;
import org.op4j.functions.evaluators.MethodCall;
import org.op4j.functions.evaluators.Ognl;
import org.op4j.operations.Operation;
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
import org.op4j.target.OperationChainingTarget;
import org.op4j.util.NormalizationUtils;
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
        return new Level0GenericUniqOperatorImpl<T,T>(OperationChainingTarget.forObject(target));
    }

    
    public static <T> Level0GenericMultiOperator<T,T> onAll(final T... targets) {
        return new Level0GenericMultiOperatorImpl<T,T>(OperationChainingTarget.forObject(VarArgsUtil.asRequiredObjectList(targets)));
    }

    
    public static <T> Level0ArrayOperator<T,T[]> onArray(final T[] target) {
        return new Level0ArrayOperatorImpl<T,T[]>(OperationChainingTarget.forObject(NormalizationUtils.normalizeArray(target)));
    }

    
    public static <T> Level0ArrayOfArrayOperator<T,T[][]> onArrayOfArray(final T[][] target) {
        return new Level0ArrayOfArrayOperatorImpl<T,T[][]>(OperationChainingTarget.forObject(NormalizationUtils.normalizeArrayOfArray(target)));
    }

    
    public static <T> Level0ArrayOfListOperator<T,List<T>[]> onArrayOfList(final List<T>[] target) {
        return new Level0ArrayOfListOperatorImpl<T,List<T>[]>(OperationChainingTarget.forObject(NormalizationUtils.normalizeArrayOfList(target)));
    }

    
    public static <K,V> Level0ArrayOfMapOperator<K,V,Map<K,V>[]> onArrayOfMap(final Map<K,V>[] target) {
        return new Level0ArrayOfMapOperatorImpl<K,V,Map<K,V>[]>(OperationChainingTarget.forObject(NormalizationUtils.normalizeArrayOfMap(target)));
    }

    
    public static <T> Level0ArrayOfSetOperator<T,Set<T>[]> onArrayOfSet(final Set<T>[] target) {
        return new Level0ArrayOfSetOperatorImpl<T,Set<T>[]>(OperationChainingTarget.forObject(NormalizationUtils.normalizeArrayOfSet(target)));
    }

    
    public static <T> Level0ListOperator<T,List<T>> onList(final List<T> target) {
        return new Level0ListOperatorImpl<T,List<T>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeList(target)));
    }

    
    public static <T> Level0ListOfArrayOperator<T,List<T[]>> onListOfArray(final List<T[]> target) {
        return new Level0ListOfArrayOperatorImpl<T,List<T[]>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeListOfArray(target)));
    }

    
    public static <T> Level0ListOfListOperator<T,List<? extends List<T>>> onListOfList(final List<? extends List<T>> target) {
        return new Level0ListOfListOperatorImpl<T,List<? extends List<T>>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeListOfList(target)));
    }

    
    public static <K,V> Level0ListOfMapOperator<K,V,List<? extends Map<K,V>>> onListOfMap(final List<? extends Map<K,V>> target) {
        return new Level0ListOfMapOperatorImpl<K,V,List<? extends Map<K,V>>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeListOfMap(target)));
    }

    
    public static <T> Level0ListOfSetOperator<T,List<? extends Set<T>>> onListOfSet(final List<? extends Set<T>> target) {
        return new Level0ListOfSetOperatorImpl<T,List<? extends Set<T>>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeListOfSet(target)));
    }

    
    public static <K,V> Level0MapOperator<K,V,Map<K,V>> onMap(final Map<K,V> target) {
        return new Level0MapOperatorImpl<K,V,Map<K,V>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeMap(target)));
    }

    
    public static <K,V> Level0MapOfArrayOperator<K,V,Map<K,V[]>> onMapOfArray(final Map<K,V[]> target) {
        return new Level0MapOfArrayOperatorImpl<K,V,Map<K,V[]>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeMapOfArray(target)));
    }

    
    public static <K,V> Level0MapOfListOperator<K,V,Map<K,? extends List<V>>> onMapOfList(final Map<K,? extends List<V>> target) {
        return new Level0MapOfListOperatorImpl<K,V,Map<K,? extends List<V>>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeMapOfList(target)));
    }

    
    public static <K1,K2,V> Level0MapOfMapOperator<K1,K2,V,Map<K1,? extends Map<K2,V>>> onMapOfMap(final Map<K1,? extends Map<K2,V>> target) {
        return new Level0MapOfMapOperatorImpl<K1,K2,V,Map<K1,? extends Map<K2,V>>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeMapOfMap(target)));
    }

    
    public static <K,V> Level0MapOfSetOperator<K,V,Map<K,? extends Set<V>>> onMapOfSet(final Map<K,? extends Set<V>> target) {
        return new Level0MapOfSetOperatorImpl<K,V,Map<K,? extends Set<V>>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeMapOfSet(target)));
    }

    
    public static <T> Level0SetOperator<T,Set<T>> onSet(final Set<T> target) {
        return new Level0SetOperatorImpl<T,Set<T>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeSet(target)));
    }

    
    public static <T> Level0SetOfArrayOperator<T,Set<T[]>> onSetOfArray(final Set<T[]> target) {
        return new Level0SetOfArrayOperatorImpl<T,Set<T[]>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeSetOfArray(target)));
    }

    
    public static <T> Level0SetOfListOperator<T,Set<? extends List<T>>> onSetOfList(final Set<? extends List<T>> target) {
        return new Level0SetOfListOperatorImpl<T,Set<? extends List<T>>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeSetOfList(target)));
    }

    
    public static <K,V> Level0SetOfMapOperator<K,V,Set<? extends Map<K,V>>> onSetOfMap(final Set<? extends Map<K,V>> target) {
        return new Level0SetOfMapOperatorImpl<K,V,Set<? extends Map<K,V>>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeSetOfMap(target)));
    }

    
    public static <T> Level0SetOfSetOperator<T,Set<? extends Set<T>>> onSetOfSet(final Set<? extends Set<T>> target) {
        return new Level0SetOfSetOperatorImpl<T,Set<? extends Set<T>>>(OperationChainingTarget.forObject(NormalizationUtils.normalizeSetOfSet(target)));
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    public static void main(String[] args) {
        
        
final StopWatch watch = new StopWatch();
watch.start();
        


        final String[] stringsArr1 = new String[] {"Hello", "Goodbye", null};
        final List<String> stringsList1 = Arrays.asList(stringsArr1);
        
        final String[][] stringsStrings1 = new String[][] { new String[] {"Hello!","Goodbye!"}, new String[]{"¡Hola!","¡Adiós!"}};
        final List<String>[] stringsListStrings1 = (List<String>[]) new List<?>[] { Arrays.asList(new String[] {"Hello!","Goodbye!"}), Arrays.asList(new String[]{"¡Hola!","¡Adiós!"})};
        final List<List<String>> stringsListStringsList1 = Arrays.asList(stringsListStrings1);
        
        final Map<String,String> map1 = new LinkedHashMap<String,String>();
        map1.put("es", "¡Hola!");
        map1.put("en", "Hello!");
        map1.put("gl", "Ola!");
        map1.put("ca", "Hola!");
        
        final Map<String,String> map2 = new LinkedHashMap<String,String>();
        map2.put("es", "¡Adiós!");
        map2.put("en", "Goodbye!");
        map2.put("gl", "Adéus!");
        map2.put("ca", "Adéu!");
        map2.put("fr", "Adieu!");
        
        final Map<String,String>[] maps1 = (Map<String, String>[]) new Map<?,?>[] { map1, map2 };

        
        System.out.println(printArray(Op.onArrayOfArray(stringsStrings1).forEach(Types.ARRAY_OF_STRING).forEach(Types.STRING).ifIndex(0).eval(Ognl.forString("#target + ' Mundo'")).get()));
        
        
        
        System.out.println(Op.onList(stringsList1).get());
        System.out.println(Op.onList(stringsList1).forEach().get());
        System.out.println(Op.onList(stringsList1).forEach().ifNotNull().eval(Ognl.forString("toUpperCase()")).get());
        
        
        System.out.println(Op.onArrayOfArray(stringsStrings1).forEach(Types.ARRAY_OF_STRING).forEach(Types.STRING).eval(Ognl.forInteger("length()")).get());
        
        System.out.println(printArray(Op.onArrayOfList(stringsListStrings1).forEach().forEach().eval(Ognl.forString("toUpperCase()")).get()));

        System.out.println(printArray(Op.onArrayOfMap(maps1).forEach().ifTrue(Ognl.forBoolean("size() > 6")).forEachEntry().onValue().eval(Ognl.forString("toUpperCase()")).get()));
        
        System.out.println(Op.onListOfList(stringsListStringsList1).forEach().forEach().get());
        
        System.out.println(Op.onListOfList(stringsListStringsList1).forEach().forEach().eval(MethodCall.forInteger("length")).get());
        
        
        final BigDecimal bd = new BigDecimal("3455234.6325");
        final Float f = Float.valueOf(3455234.6325f);
        final Double d = Double.valueOf(3455234.6325);
        
        System.out.println(bd.doubleValue());
        System.out.println(f);
        System.out.println(d);
        
        System.out.println(Op.onList(Arrays.asList(new Integer[] {2,3,4,1,2,2,4,5,2,3,5,6,87,45,2,3,34,1})).get());
        System.out.println(Op.onList(Arrays.asList(new Integer[] {2,3,4,1,2,2,4,5,2,3,5,6,87,45,2,3,34,1})).distinct().get());
        
        final List<List<String>> listOfListOfString1 = 
        	Arrays.asList((List<String>[]) new List<?>[] { Arrays.asList(new String[] {"a", "b", "a"}), Arrays.asList(new String[] {"a", "b", "a"})});
        
        final Set<Set<String>> setOfsetOfString1 = 
            new LinkedHashSet<Set<String>>(Arrays.asList((Set<String>[]) new Set<?>[] { new LinkedHashSet<String>(Arrays.asList(new String[] {"a", "b", "a"})), new LinkedHashSet<String>(Arrays.asList(new String[] {"a", "b", "a"}))}));
        
        final String[][] arrayOfArrayOfString1 = 
        	new String[][] { new String[] {"a", "b", "a"}, new String[] {"a", "b", "a"}};
        
        System.out.println(Op.onListOfList(listOfListOfString1).get());
        System.out.println(Op.onListOfList(listOfListOfString1).distinct().get());
        System.out.println(Op.onListOfList(listOfListOfString1).forEach().distinct().get());
        
        System.out.println(printArray(Op.onArrayOfArray(arrayOfArrayOfString1).get()));
        System.out.println(printArray(Op.onArrayOfArray(arrayOfArrayOfString1).distinct().get()));
        System.out.println(printArray(Op.onArrayOfArray(arrayOfArrayOfString1).forEach(Types.ARRAY_OF_STRING).distinct().get()));
     
        System.out.println(Op.onList(stringsList1).addAll("World!", "Mars!").get());
        System.out.println(Op.onList(stringsList1).insertAll(1, "World!", "Mars!").get());
        System.out.println(Op.onList(stringsList1).addAll(stringsList1).get());
        System.out.println(Op.onList(stringsList1).get());
        System.out.println(Op.onList(stringsList1).removeAllIndexes(0,2).get());
        System.out.println(Op.onList(stringsList1).removeAllIndexesNot(0).get());
        System.out.println(Op.onList(stringsList1).removeAllIndexesNot(0,2).get());
        System.out.println(Op.onList(stringsList1).removeAllTrue(Ognl.forBoolean("#target eq 'Hello'")).get());
        System.out.println(Op.onList(stringsList1).removeAllTrue(new AbstractBooleanEvaluator<String>() {

			public Boolean execute(String target, final ExecCtx ctx) {
				return Boolean.valueOf(target == null);
			}
        	
        }).get());
        System.out.println(Op.onList(stringsList1).removeAllNull().get());
        System.out.println(Op.onList(stringsList1).removeAllNotNullAndTrue(Ognl.forBoolean("length() > 5")).get());
            
        System.out.println("================");
        
        
        final Set<String> stringSet1 = new LinkedHashSet<String>(stringsList1);
        System.out.println(Op.onSet(stringSet1).addAll("World!", "Mars!").get());
        System.out.println(Op.onSet(stringSet1).insertAll(1, "World!", "Mars!").get());
        System.out.println(Op.onSet(stringSet1).addAll(stringsList1).get());
        System.out.println("---");
        System.out.println(Op.onSet(stringSet1).get());
        System.out.println(Op.onSet(stringSet1).removeAllIndexes(0,2).get());
        System.out.println(Op.onSet(stringSet1).removeAllIndexesNot(0).get());
        System.out.println(Op.onSet(stringSet1).removeAllIndexesNot(0,2).get());
        System.out.println(Op.onSet(stringSet1).removeAllTrue(Ognl.forBoolean("#target eq 'Hello'")).get());
        System.out.println(Op.onSet(stringSet1).removeAllNull().get());
        System.out.println(Op.onSet(stringSet1).removeAllNotNullAndTrue(Ognl.forBoolean("length() > 5")).get());
            
        System.out.println(printArray(Op.onArray(stringsArr1).insertAll(2,"lalero","lururu").get()));
     
        
        System.out.println(Op.onMap(map1).put("fr", "Allô!").get());
        System.out.println(Op.onMap(map1).insert(0,"fr", "Allô!").get());
        System.out.println(Op.onMap(map1).insert(2,"fr", "Allô!").get());
        System.out.println(Op.onMap(map2).get());
        System.out.println(Op.onMap(map2).putAll(Op.onMap(map1).insert(0,"gl", "Meuuuu!").get()).get());
        System.out.println(Op.onMap(map2).putAll(Op.onMap(map1).insert(0,"gl", "Meuuuu!").get()).removeAllTrue(Ognl.forBoolean("!#target.key.startsWith('e')")).get());
        
        System.out.println(printArray(Op.onArrayOfMap(maps1).get()));
        
        System.out.println(Op.onAll(234,12,231));
        System.out.println(Op.on(234).addAll(10));
        System.out.println(Op.on(234).insert(0,10));
        System.out.println(Op.on(234).addAll(10).insert(1,3));
        System.out.println(Op.on(234).addAll(10).insert(1,3).addAll((Integer)null));
        System.out.println(Op.on(234).addAll(10).insert(1,3).addAll((Integer)null).removeAllNull());
        System.out.println(Op.on(234).addAll(10).insert(1,3).removeAllIndexesNot(1));
        System.out.println(Op.on(234).addAll(10).insert(1,3).removeAllTrue(Ognl.forBoolean("#target > 100")));
        System.out.println(printArray(Op.on(234).addAll(10).insert(1,3).removeAllTrue(Ognl.forBoolean("#target > 100")).buildArray(Types.INTEGER).get()));
        System.out.println(printArray(Op.on(234).buildArray(Types.INTEGER).addAll(8).get()));
        System.out.println(Op.on(null).addAll(123));
        System.out.println(Op.on(null).buildList().get());
        System.out.println(Op.on(null).buildSet().get());
        System.out.println(printArray(Op.on((String)null).buildArray(Types.STRING).addAll("a").removeAllNull().removeAllIndexes(0).get()));
        
//        System.out.println(printArray(Op.buildArrayOfArray(Types.STRING).addAll(Op.buildArray(Types.STRING).addAll("a","b").get()).addAll(Op.buildArray(Types.STRING).addAll("1","2","3").get()).get()));
//        System.out.println(Op.buildMap(Types.INTEGER,Types.STRING).put(12,"hello!").get());
        System.out.println(Op.onAll("a",1,"b",3).buildMap().get());
        System.out.println(Op.onAll("hello", "goodbye").buildMap(Ognl.forInteger("length()")).get());
        
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildMapOfSet(Ognl.forInteger("length()")).get());
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildMapOfList(Ognl.forInteger("length()")).get());
        
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildMapOfArray(Types.STRING, Ognl.forInteger("length()")).get());
        
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildList().sort().get());
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildSet().sort(new Comparator<String>() {

			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) {
					return -1;
				} else if (o1.length() == o2.length()) {
					return 0;
				}
				return 1;
			}
        	
        }).get());
        
        System.out.println(printArray(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildArray(Types.STRING).sort().get()));
        System.out.println(printArray(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildArray(Types.STRING).sort(new Comparator<String>() {

			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) {
					return -1;
				} else if (o1.length() == o2.length()) {
					return 0;
				}
				return 1;
			}
        	
        }).get()));
        
        
        System.out.println(Op.on("12314123.4123").exec(new ToInteger.FromString(RoundingMode.CEILING, DecimalPoint.IS_POINT)).get());
        System.out.println(Op.on("12314123.4123").exec(ToInteger.fromString(RoundingMode.CEILING, DecimalPoint.IS_POINT)).get());
        System.out.println(Op.on("12314123").exec(ToInteger.fromString()).get());
        System.out.println(Op.on("12314123").exec(ToLong.fromString()).get());
        System.out.println(Op.on("12314123").exec(ToBigInteger.fromString()).get());
        System.out.println(Op.on("12314123.4123").exec(ToDouble.fromString()).get());
        System.out.println(Op.on("12314123.4123").exec(ToDouble.fromString(3, RoundingMode.CEILING)).get());
        System.out.println(Op.on("12314123.4123").exec(ToBigDecimal.fromString(3, RoundingMode.CEILING)).get());
        
        final SimpleDateFormat dateFormat = new SimpleDateFormat();
        System.out.println(dateFormat.format(Op.on(Calendar.getInstance()).exec(new ToCalendar.FromCalendar(Calendar.DATE)).get().getTime()));
        
        System.out.println(dateFormat.format(Op.on("25/nov/1979").exec(ToCalendar.fromString("dd/MMM/yyyy", "es")).get().getTime()));
        
//        System.out.println(dateFormat.format(Op.onAll(1979, 11, 25, 12, 30).buildList().exec(ToCalendar.fromString("dd/MMM/yyyy", "es")).get().getTime()));
        System.out.println(dateFormat.format(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildList().get()).exec(ToCalendar.fromIntegerFieldList()).get().getTime()));
        System.out.println(dateFormat.format(Op.on(Op.onAll("1979", "11", "25", "12", "30").buildArray(Types.STRING).get()).exec(ToCalendar.fromStringFieldArray()).get().getTime()));
        
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildList().get()).exec(new ListFuncs.Sort<Integer>()).get());
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildSet().get()).exec(new SetFuncs.Sort<Integer>()).get());
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildList().get()).exec(new ListFuncs.Distinct<Integer>()).get());
        
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildArray(Types.INTEGER).get()).exec(new ArrayFuncs.Sort<Integer>()).get()));
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildArray(Types.INTEGER).get()).exec(new ArrayFuncs.Distinct<Integer>()).get()));
        
        
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildList().get()).exec(new ListFuncs.Insert<Integer>(2, 1492)).get());
        
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildList().get()).exec(new ListFuncs.Insert<Integer>(2, 1492)).exec(new ListFuncs.RemoveAllTrue<Integer>(Ognl.forBoolean("#target < 1000"))).exec(new ListFuncs.Sort<Integer>()).get());
        
        
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildArray(Types.INTEGER).get()).exec(new ArrayFuncs.Insert<Integer>(2, 1492)).get()));
        
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildArray(Types.INTEGER).get()).exec(new ArrayFuncs.Insert<Integer>(2, 1492)).exec(new ArrayFuncs.RemoveAllTrue<Integer>(Ognl.forBoolean("#target < 1000"))).exec(new ArrayFuncs.Sort<Integer>()).get()));
        
        System.out.println(Op.on(Op.onAll("hello", "hola", "ciao", "ola", "olá", "hallô", "hallo", "hej").buildArray(Types.STRING).get()).exec(new ToMap.FromArrayByKeyEval<Integer,String>(Ognl.forInteger("length()"))).get());

        final Map<Integer,String[]> greetingsByLength = 
        	Op.on(Op.onAll("hello", "hola", "ciao", "ola", "olá", "hallô", "hallo", "hej").buildArray(Types.STRING).get()).exec(new ToMapOfArray.FromArrayByKeyEval<Integer, String>(Types.STRING, Ognl.forInteger("length()"))).get();
        System.out.println("*** MAP: ");
        for (Map.Entry<Integer,String[]> entry : greetingsByLength.entrySet()) {
        	System.out.println(entry.getKey() + " : " + Arrays.asList(entry.getValue()));
        }
        System.out.println("***");


        System.out.println(Op.on("hello").addAll("goodbye"));
        System.out.println(Op.on("hello").buildList().get());
        System.out.println(printArray(Op.on("hello").buildArray(Types.STRING).get()));
        System.out.println(Op.on("hello").buildMap(Ognl.forInteger("length()")).get());
        System.out.println(Op.on("hello").buildMapOfList(Ognl.forInteger("length()")).get());
        System.out.println(Op.onAll(12, "hello", 14, "goodbye").buildMapOfList().get());
        
        
//        System.out.println(Op.buildList(Types.CALENDAR)
//            	.addAll(Calendar.getInstance(), Calendar.getInstance())
//            	.forEach().exec(ToString.fromCalendar(DateStyle.FULL, TimeStyle.NONE, Locale.UK)).get());
//        
//        System.out.println(Op.buildList(Types.CALENDAR)
//            	.addAll(Calendar.getInstance(), Calendar.getInstance())
//            	.forEach().exec(ToString.fromCalendar(DateStyle.FULL, TimeStyle.SHORT, Locale.UK)).get());
//        
//        System.out.println(Op.buildList(Types.CALENDAR)
//            	.addAll(Calendar.getInstance(), Calendar.getInstance())
//            	.forEach().exec(ToString.fromCalendar("dd-MMM-yyyy", Locale.UK)).get());
//            
//        System.out.println(Op.buildList(Types.CALENDAR)
//            	.addAll(Calendar.getInstance(), Calendar.getInstance())
//            	.forEach().exec(ToString.fromCalendar("dd-MMMM-yyyy")).get());
//        
//        System.out.println(Op.buildList(Types.DATE)
//            	.addAll(new java.sql.Date(Calendar.getInstance().getTimeInMillis()))
//            	.forEach().exec(ToString.fromDate("dd-MMM-yyyy", Locale.UK)).get());
//        
//        
//        System.out.println(Op.buildList(Types.STRING)
//            	.addAll("  Company ", " day ")
//            	.forEach().exec(StringFuncs.trim()).get());
//        System.out.println(Op.buildList(Types.STRING)
//            	.addAll("  Company ", " day ")
//            	.forEach().exec(StringFuncs.trim()).exec(StringFuncs.toUpperCase()).get());
        
        System.out.println(Op.on("Dublin")
            	.exec(StringFuncs.toHexadecimal(Charset.forName("ISO-8859-1")))
            	.exec(StringFuncs.fromHexadecimal(Charset.forName("ISO-8859-1"))).get());
        
//        System.out.println(Op.buildList(Types.NUMBER)
//                .addAll(45.9, new BigDecimal(34.456))
//                .forEach().exec(ToString.fromCurrency(Locale.getDefault(), 
//                        1, 2, 10, true)).get());
//        System.out.println(Op.buildList(Types.NUMBER)
//                .addAll(45.9, 45, new BigDecimal(34.456))
//                .forEach().exec(ToString.fromCurrency(Locale.getDefault(), 
//                        1, 0, 0, true)).get());
//        
//        System.out.println(Op.buildList(Types.NUMBER)
//                .addAll(45.9, 45, new BigDecimal(34.456), 0, 0.5, 0.211)
//                .forEach().exec(ToString.fromPercent(Locale.getDefault(), 
//                        1, 0, 10, ',', '\'', false)).get());
     
        
        System.out.println(Op.onArray(stringsArr1).toSet().get());
        System.out.println(printArray(Op.onArrayOfList(stringsListStrings1).forEach().toSet().get()));
        System.out.println(printArray(Op.onArrayOfList(stringsListStrings1).toArrayOfArray(Types.STRING).get()));
        
        final List<String[]> listOfStringArray1 = new ArrayList<String[]>();
        listOfStringArray1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildArray(Types.STRING).get());
        listOfStringArray1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Adéus").buildArray(Types.STRING).get());
        
        final List<Set<String>> listOfStringSet1 = new ArrayList<Set<String>>();
        listOfStringSet1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildSet().get());
        listOfStringSet1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Adéus").buildSet().get());
        
        final Set<String[]> setOfStringArray1 = new LinkedHashSet<String[]>();
        setOfStringArray1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildArray(Types.STRING).get());
        setOfStringArray1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Adéus").buildArray(Types.STRING).get());
        
        final Set<List<String>> setOfStringList1 = new LinkedHashSet<List<String>>();
        setOfStringList1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildList().get());
        setOfStringList1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Adéus").buildList().get());
        
        final Set<Set<String>> setOfStringSet1 = new LinkedHashSet<Set<String>>();
        setOfStringSet1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildSet().get());
        setOfStringSet1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Adéus").buildSet().get());
        
        System.out.println(printArray(Op.onListOfArray(listOfStringArray1).toArrayOfArray(Types.STRING).get()));
        System.out.println(printArray(Op.onListOfList(listOfListOfString1).toArrayOfArray(Types.STRING).get()));
        System.out.println(printArray(Op.onListOfSet(listOfStringSet1).toArrayOfArray(Types.STRING).get()));
        
        System.out.println(printArray(Op.onSetOfArray(setOfStringArray1).toArrayOfArray(Types.STRING).get()));
        System.out.println(printArray(Op.onSetOfList(setOfStringList1).toArrayOfArray(Types.STRING).get()));
        System.out.println(printArray(Op.onSetOfSet(setOfStringSet1).toArrayOfArray(Types.STRING).get()));

        
        System.out.println(printArray(Op.onArrayOfArray(arrayOfArrayOfString1).toArrayOfList().get()));
        System.out.println(printArray(Op.onListOfArray(listOfStringArray1).toArrayOfList().get()));
        System.out.println(printArray(Op.onListOfList(listOfListOfString1).toArrayOfList().get()));
        
        System.out.println(Op.on("http://www.google.es/search?q=op4j&unusedParam=unusedValue '' 2^2 ")
            	.exec(StringFuncs.escapeJavaScript()).get());
        System.out.println(Op.on("Body tag is written like \"<body>content here</body>\"")
            	.exec(StringFuncs.escapeHTML()).get());
        
        System.out.println(Op.onArray(stringsArr1).removeAllNull().toMap(Ognl.forInteger("length()")).get());

        System.out.println(Op.onList(stringsList1).removeAllNullOrTrue(Ognl.forBoolean("length() < 6")).get());

        System.out.println(printArray(Op.onArrayOfMap(maps1).forEach().extractKeys().get()));
        System.out.println(printArray(Op.onArrayOfMap(maps1).forEach().extractValues().get()));

        System.out.println("***___****___****");
        System.out.println(Op.onList(stringsList1).forEach().ifNotNull().exec(StringFuncs.toUpperCase()).get());
        System.out.println("***___****___****");
        
        System.out.println(Op.onAll("hello", "goodbye").eval(Ognl.forString("#target + ' world!'")).getAsList());
        
        System.out.println(Op.onList(listOfListOfString1).get());
        System.out.println(Op.onList(listOfListOfString1).forEach().asListOf(Types.STRING).forEach().get());
        
        
        System.out.println(Op.onListOfList(stringsListStringsList1).forEach().forEach().eval(MethodCall.forInteger("length")).get());
        System.out.println(Op.onListOfList(stringsListStringsList1).forEach().ifIndex(0).add("").removeAllTrue(MethodCall.forBoolean("isEmpty")).get());
        System.out.println(Op.onListOfList(stringsListStringsList1).forEach().removeAllTrue(MethodCall.forBoolean("isEmpty")).get());
        
//        System.out.println(Op.onMap(map1).forEachEntry().eval(Ognl.forString("'in ' + #target.key + ' you say ' + #target.value")).get());
        
        
        System.out.println(printArray(Op.onArrayOfArray(arrayOfArrayOfString1).forEach(Types.ARRAY_OF_STRING).toMap(Ognl.forInteger("length()")).forEachEntry().onKey().asType(Types.forClass(Serializable.class)).endOn().onValue().asType(Types.SERIALIZABLE).get()));
        
        
        System.out.println(Op.onList(stringsList1).removeAllNull().sort().get());
        System.out.println(Op.onList(stringsList1).removeAllNull().forEach().eval(Ognl.forInteger("length()")).get());
        
        System.out.println(Op.on(maps1).eval(Ognl.forInteger("length")).get());
        System.out.println(printArray(Op.onArray(maps1).forEach(Types.MAP_OF_STRING_STRING).eval(Ognl.forInteger("size()")).get()));
        System.out.println(printArray(Op.onArrayOfMap(maps1).forEach().forEachEntry().onValue().eval(Ognl.forObject("length()")).endOn().endFor().extractValues().get()));
        
        final Map<Integer,Map<String,String>> mapOfMapOfIntegerStringString = Op.onArray(maps1).toMap(Ognl.forInteger("size()")).asMapOfMapOf(Types.INTEGER, Types.STRING, Types.STRING).get();
        
        System.out.println(Op.onMapOfMap(mapOfMapOfIntegerStringString).forEachEntry().onValue().forEachEntry().onValue().eval(Ognl.forObject("length()")).get());
        
        System.out.println(Op.onListOfList(listOfListOfString1).forEach().forEach().eval(Ognl.forString("#target + '' + #index + '-' + #indexes[1] + '/' + #iterationLevel")).get());
        
        
        System.out.println(Op.onMapOfMap(mapOfMapOfIntegerStringString).forEachEntry().onKey().convert(ToString.fromNumber()).eval(Ognl.forString("#target + '...'")).get());
        System.out.println(Op.onMapOfMap(mapOfMapOfIntegerStringString).forEachEntry().onKey().convert(ToString.fromNumber()).eval(Ognl.forString("'onekey'")).get());

//        final List<Map<String,String>> listOfMapOfStringString1 = 
//        	Op.buildList(Types.MAP_OF_STRING_STRING).add(map1).add(map2).get();
//        
//        System.out.println(printArray(Op.onListOfMap(listOfMapOfStringString1).toArrayOfMap().get()));
    
        System.out.println(Op.onMap(map1).forEachEntry().eval(Types.STRING, Ognl.forString("'<<KEY: ' + #target.key + ' | VALUE: ' + #target.value + '>>'")).get());
        
        System.out.println(Op.onMapOfMap(mapOfMapOfIntegerStringString).forEachEntry().eval(Types.STRING, Ognl.forString("'<<KEY: ' + #target.key + ' | VALUE: ' + #target.value + '>>'")).get());
        System.out.println(Op.onMapOfMap(mapOfMapOfIntegerStringString).forEachEntry().onValue().forEachEntry().eval(Types.STRING, Ognl.forString("'<<KEY: ' + #target.key + ' | VALUE: ' + #target.value + '>>'")).get());
        
        System.out.println(Types.LIST_ITERATOR_OF_BOOLEAN.getSimpleName());
        
        
        System.out.println(Op.onList(stringsList1).get());
        System.out.println(Op.onList(stringsList1).forEach().replaceWith("op4j is great!").get());
        System.out.println(Op.onList(stringsList1).forEach().replaceIfNullWith("op4j is great!").get());
        System.out.println(printArray(Op.onArray(stringsArr1).forEach(Types.STRING).replaceIfNullWith("op4j is great!").get()));
        System.out.println(printArray(Op.onArray(stringsArr1).replaceWith(new String[] {"alpha", "beta"}).forEach(Types.STRING).exec(StringFuncs.toUpperCase()).get()));
        
        
//        System.out.println(Op.buildListOfList(Types.STRING).add(stringsList1).add(stringsList1).get());
//        System.out.println(Op.buildListOfList(Types.STRING).addAll(stringsList1, stringsList1).get());


        System.out.println("--------------------------------------");

        final List<String> stringsList2 = Op.onAll("Portugal", "Spain", "France", "Italy", "Switzerland").getAsList();
        
        Operation<String[],List<String>> op1 =
            Op.onList(stringsList1).toArray(Types.STRING).forEach(Types.STRING).ifNotNull().exec(StringFuncs.toUpperCase()).createOperation();
        
        System.out.println(printArray(op1.execute(stringsList1)));
        System.out.println(printArray(op1.execute(stringsList2)));
        
        watch.stop();
        
        System.out.println("TIME: " + watch.toString());
        
    }
    
    
    
    private static String printArray(Object[] array) {
        if (array == null) {
            return null;
        }
    	final List<Object> components = new ArrayList<Object>();
    	for (final Object component : array) {
    		if (component instanceof Object[]) {
    			components.add(printArray((Object[])component));
    		} else {
    			components.add(component);
    		}
    	}
    	return components.toString();
    }
    
}

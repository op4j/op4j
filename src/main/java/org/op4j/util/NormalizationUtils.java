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

package org.op4j.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.TargetCastException;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class NormalizationUtils {


    
    
    
    public static void checkIsArray(final Type<?> of, final Object targetObject) {
        if (targetObject != null) {
            final Class<?> newTargetClass = Types.arrayOf(of).getRawClass();
            if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
                throw new TargetCastException(targetObject.getClass(), newTargetClass.getSimpleName());
            }
            for (final Object element : (Object[])targetObject) {
                checkIs(of, element);
            }
        }
    }
    
    public static void checkIsArrayOfArray(final Type<?> of, final Object targetObject) {
        checkIsArray(Types.arrayOf(of), targetObject);
        if (targetObject != null) {
            for (final Object element : (Object[])targetObject) {
                checkIsArray(of, element);
            }
        }
    }
    
    public static void checkIsArrayOfList(final Type<?> of, final Object targetObject) {
        checkIsArray(Types.listOf(of), targetObject);
        if (targetObject != null) {
            for (final Object element : (Object[])targetObject) {
                checkIsList(of, element);
            }
        }
    }
    
    public static void checkIsArrayOfMap(final Type<?> keyOf, final Type<?> valueOf, final Object targetObject) {
        checkIsArray(Types.mapOf(keyOf, valueOf), targetObject);
        if (targetObject != null) {
            for (final Object element : (Object[])targetObject) {
                checkIsMap(keyOf, valueOf, element);
            }
        }
    }
    
    public static void checkIsArrayOfMapOfKey(final Type<?> keyOf, final Object targetObject) {
        checkIsArray(Types.mapOf(keyOf, Types.OBJECT), targetObject);
        if (targetObject != null) {
            for (final Object element : (Object[])targetObject) {
                checkIsMapOfKey(keyOf, element);
            }
        }
    }
    
    public static void checkIsArrayOfMapOfValue(final Type<?> valueOf, final Object targetObject) {
        checkIsArray(Types.mapOf(Types.OBJECT, valueOf), targetObject);
        if (targetObject != null) {
            for (final Object element : (Object[])targetObject) {
                checkIsMapOfValue(valueOf, element);
            }
        }
    }
    
    public static void checkIsArrayOfSet(final Type<?> of, final Object targetObject) {
        checkIsArray(Types.setOf(of), targetObject);
        if (targetObject != null) {
            for (final Object element : (Object[])targetObject) {
                checkIsSet(of, element);
            }
        }
    }
    
    public static void checkIsList(final Type<?> of, final Object targetObject) {
        if (targetObject != null) {
            final Class<?> newTargetClass = List.class;
            if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
                throw new TargetCastException(targetObject.getClass(), newTargetClass.getSimpleName());
            }
            for (final Object element : (List<?>)targetObject) {
                checkIs(of, element);
            }
        }
    }
    
    public static void checkIsListOfArray(final Type<?> of, final Object targetObject) {
        checkIsList(Types.arrayOf(of), targetObject);
        if (targetObject != null) {
            for (final Object element : (List<?>)targetObject) {
                checkIsArray(of, element);
            }
        }
    }
    
    public static void checkIsListOfList(final Type<?> of, final Object targetObject) {
        checkIsList(Types.listOf(of), targetObject);
        if (targetObject != null) {
            for (final Object element : (List<?>)targetObject) {
                checkIsList(of, element);
            }
        }
    }
    
    public static void checkIsListOfMap(final Type<?> keyOf, final Type<?> valueOf, final Object targetObject) {
        checkIsList(Types.mapOf(keyOf, valueOf), targetObject);
        if (targetObject != null) {
            for (final Object element : (List<?>)targetObject) {
                checkIsMap(keyOf, valueOf, element);
            }
        }
    }
    
    public static void checkIsListOfMapOfKey(final Type<?> keyOf, final Object targetObject) {
        checkIsList(Types.mapOf(keyOf, Types.OBJECT), targetObject);
        if (targetObject != null) {
            for (final Object element : (List<?>)targetObject) {
                checkIsMapOfKey(keyOf, element);
            }
        }
    }
    
    public static void checkIsListOfMapOfValue(final Type<?> valueOf, final Object targetObject) {
        checkIsList(Types.mapOf(Types.OBJECT, valueOf), targetObject);
        if (targetObject != null) {
            for (final Object element : (List<?>)targetObject) {
                checkIsMapOfValue(valueOf, element);
            }
        }
    }
    
    public static void checkIsListOfSet(final Type<?> of, final Object targetObject) {
        checkIsList(Types.setOf(of), targetObject);
        if (targetObject != null) {
            for (final Object element : (List<?>)targetObject) {
                checkIsSet(of, element);
            }
        }
    }
    
    public static void checkIsMap(final Type<?> keyOf, final Type<?> valueOf, final Object targetObject) {
        if (targetObject != null) {
            final Class<?> newTargetClass = Map.class;
            if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
                throw new TargetCastException(targetObject.getClass(), newTargetClass.getSimpleName());
            }
            for (final Map.Entry<?,?> element : ((Map<?,?>)targetObject).entrySet()) {
                checkIs(keyOf, element.getKey());
                checkIs(valueOf, element.getValue());
            }
        }
    }
    
    public static void checkIsMapOfKey(final Type<?> keyOf, final Object targetObject) {
        if (targetObject != null) {
            final Class<?> newTargetClass = Map.class;
            if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
                throw new TargetCastException(targetObject.getClass(), newTargetClass.getSimpleName());
            }
            for (final Map.Entry<?,?> element : ((Map<?,?>)targetObject).entrySet()) {
                checkIs(keyOf, element.getKey());
            }
        }
    }
    
    public static void checkIsMapOfValue(final Type<?> valueOf, final Object targetObject) {
        if (targetObject != null) {
            final Class<?> newTargetClass = Map.class;
            if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
                throw new TargetCastException(targetObject.getClass(), newTargetClass.getSimpleName());
            }
            for (final Map.Entry<?,?> element : ((Map<?,?>)targetObject).entrySet()) {
                checkIs(valueOf, element.getValue());
            }
        }
    }
    
    public static void checkIsMapOfArray(final Type<?> keyOf, final Type<?> valueOf, final Object targetObject) {
        checkIsMap(keyOf, Types.arrayOf(valueOf), targetObject);
        if (targetObject != null) {
            for (final Map.Entry<?,?> element : ((Map<?,?>)targetObject).entrySet()) {
                checkIs(keyOf, element.getKey());
                checkIsArray(valueOf, element.getValue());
            }
        }
    }
    
    public static void checkIsMapOfArrayOfValue(final Type<?> valueOf, final Object targetObject) {
        checkIsMapOfValue(Types.arrayOf(valueOf), targetObject);
        if (targetObject != null) {
            for (final Map.Entry<?,?> element : ((Map<?,?>)targetObject).entrySet()) {
                checkIsArray(valueOf, element.getValue());
            }
        }
    }
    
    public static void checkIsMapOfList(final Type<?> keyOf, final Type<?> valueOf, final Object targetObject) {
        checkIsMap(keyOf, Types.listOf(valueOf), targetObject);
        if (targetObject != null) {
            for (final Map.Entry<?,?> element : ((Map<?,?>)targetObject).entrySet()) {
                checkIs(keyOf, element.getKey());
                checkIsList(valueOf, element.getValue());
            }
        }
    }
    
    public static void checkIsMapOfListOfValue(final Type<?> valueOf, final Object targetObject) {
        checkIsMapOfValue(Types.listOf(valueOf), targetObject);
        if (targetObject != null) {
            for (final Map.Entry<?,?> element : ((Map<?,?>)targetObject).entrySet()) {
                checkIsList(valueOf, element.getValue());
            }
        }
    }
    
    public static void checkIsMapOfMap(final Type<?> key1Of, final Type<?> key2Of, final Type<?> valueOf, final Object targetObject) {
        checkIsMap(key1Of, Types.mapOf(key2Of, valueOf), targetObject);
        if (targetObject != null) {
            for (final Map.Entry<?,?> element : ((Map<?,?>)targetObject).entrySet()) {
                checkIs(key1Of, element.getKey());
                checkIsMap(key2Of, valueOf, element.getValue());
            }
        }
    }
    
    public static void checkIsMapOfMapOfValue(final Type<?> key2Of, final Type<?> valueOf, final Object targetObject) {
        checkIsMapOfValue(Types.mapOf(key2Of, valueOf), targetObject);
        if (targetObject != null) {
            for (final Map.Entry<?,?> element : ((Map<?,?>)targetObject).entrySet()) {
                checkIsMap(key2Of, valueOf, element.getValue());
            }
        }
    }
    
    public static void checkIsMapOfMapOfValueOfKey(final Type<?> key2Of, final Object targetObject) {
        checkIsMapOfValue(Types.mapOf(key2Of, Types.OBJECT), targetObject);
        if (targetObject != null) {
            for (final Map.Entry<?,?> element : ((Map<?,?>)targetObject).entrySet()) {
                checkIsMapOfKey(key2Of, element.getValue());
            }
        }
    }
    
    public static void checkIsMapOfMapOfValueOfValue(final Type<?> valueOf, final Object targetObject) {
        checkIsMapOfValue(Types.mapOf(Types.OBJECT, valueOf), targetObject);
        if (targetObject != null) {
            for (final Map.Entry<?,?> element : ((Map<?,?>)targetObject).entrySet()) {
                checkIsMapOfValue(valueOf, element.getValue());
            }
        }
    }
    
    public static void checkIsMapOfSet(final Type<?> keyOf, final Type<?> valueOf, final Object targetObject) {
        checkIsMap(keyOf, Types.setOf(valueOf), targetObject);
        if (targetObject != null) {
            for (final Map.Entry<?,?> element : ((Map<?,?>)targetObject).entrySet()) {
                checkIs(keyOf, element.getKey());
                checkIsSet(valueOf, element.getValue());
            }
        }
    }
    
    public static void checkIsMapOfSetOfValue(final Type<?> valueOf, final Object targetObject) {
        checkIsMapOfValue(Types.setOf(valueOf), targetObject);
        if (targetObject != null) {
            for (final Map.Entry<?,?> element : ((Map<?,?>)targetObject).entrySet()) {
                checkIsSet(valueOf, element.getValue());
            }
        }
    }
    
    public static void checkIsSet(final Type<?> of, final Object targetObject) {
        if (targetObject != null) {
            final Class<?> newTargetClass = Set.class;
            if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
                throw new TargetCastException(targetObject.getClass(), newTargetClass.getSimpleName());
            }
            for (final Object element : (Set<?>)targetObject) {
                checkIs(of, element);
            }
        }
    }
    
    public static void checkIsSetOfArray(final Type<?> of, final Object targetObject) {
        checkIsSet(Types.arrayOf(of), targetObject);
        if (targetObject != null) {
            for (final Object element : (Set<?>)targetObject) {
                checkIsArray(of, element);
            }
        }
    }
    
    public static void checkIsSetOfList(final Type<?> of, final Object targetObject) {
        checkIsSet(Types.listOf(of), targetObject);
        if (targetObject != null) {
            for (final Object element : (Set<?>)targetObject) {
                checkIsList(of, element);
            }
        }
    }
    
    public static void checkIsSetOfMap(final Type<?> keyOf, final Type<?> valueOf, final Object targetObject) {
        checkIsSet(Types.mapOf(keyOf, valueOf), targetObject);
        if (targetObject != null) {
            for (final Object element : (Set<?>)targetObject) {
                checkIsMap(keyOf, valueOf, element);
            }
        }
    }
    
    public static void checkIsSetOfMapOfKey(final Type<?> keyOf, final Object targetObject) {
        checkIsSet(Types.mapOf(keyOf, Types.OBJECT), targetObject);
        if (targetObject != null) {
            for (final Object element : (Set<?>)targetObject) {
                checkIsMapOfKey(keyOf, element);
            }
        }
    }
    
    public static void checkIsSetOfMapOfValue(final Type<?> valueOf, final Object targetObject) {
        checkIsSet(Types.mapOf(Types.OBJECT, valueOf), targetObject);
        if (targetObject != null) {
            for (final Object element : (Set<?>)targetObject) {
                checkIsMapOfValue(valueOf, element);
            }
        }
    }
    
    public static void checkIsSetOfSet(final Type<?> of, final Object targetObject) {
        checkIsSet(Types.setOf(of), targetObject);
        if (targetObject != null) {
            for (final Object element : (Set<?>)targetObject) {
                checkIsSet(of, element);
            }
        }
    }
    
    public static void checkIs(final Type<?> type, final Object targetObject) {
        if (targetObject != null) {
            final Class<?> newTargetClass = type.getRawClass();
            if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
                throw new TargetCastException(targetObject.getClass(), newTargetClass.getSimpleName());
            }
        }
    }
    
    

    
    @SuppressWarnings("unchecked")
    public static <T> T[] normalizeArray(final T[] array) {
        if (array == null) {
            return null;
        }
        return (T[]) ArrayUtils.clone(array);
    }

    
    @SuppressWarnings("unchecked")
    public static <T> T[][] normalizeArrayOfArray(final T[][] arrayOfArray) {
        if (arrayOfArray == null) {
            return null;
        }
        final T[][] result = (T[][]) ArrayUtils.clone(arrayOfArray);
        for (int i = 0; i < result.length; i++) {
            result[i] = normalizeArray(result[i]);
        }
        return result;
    }

    
    @SuppressWarnings("unchecked")
    public static <T> List<T>[] normalizeArrayOfList(final List<T>[] arrayOfList) {
        if (arrayOfList == null) {
            return null;
        }
        final List<T>[] result = (List<T>[]) ArrayUtils.clone(arrayOfList);
        for (int i = 0; i < result.length; i++) {
            result[i] = normalizeList(result[i]);
        }
        return result;
    }

    
    @SuppressWarnings("unchecked")
    public static <K,V> Map<K,V>[] normalizeArrayOfMap(final Map<K,V>[] arrayOfMap) {
        if (arrayOfMap == null) {
            return null;
        }
        final Map<K,V>[] result = (Map<K,V>[]) ArrayUtils.clone(arrayOfMap);
        for (int i = 0; i < result.length; i++) {
            result[i] = normalizeMap(result[i]);
        }
        return result;
    }

    
    @SuppressWarnings("unchecked")
    public static <T> Set<T>[] normalizeArrayOfSet(final Set<T>[] arrayOfSet) {
        if (arrayOfSet == null) {
            return null;
        }
        final Set<T>[] result = (Set<T>[]) ArrayUtils.clone(arrayOfSet);
        for (int i = 0; i < result.length; i++) {
            result[i] = normalizeSet(result[i]);
        }
        return result;
    }
    
    
    public static <T> List<T> normalizeList(final List<T> list) {
        if (list == null) {
            return null;
        }
        return new ArrayList<T>(list);
    }

    
    public static <T> List<T[]> normalizeListOfArray(final List<? extends T[]> listOfArray) {
        if (listOfArray == null) {
            return null;
        }
        final List<T[]> result = new ArrayList<T[]>();
        for (final T[] element : listOfArray) {
            result.add(normalizeArray(element));
        }
        return result;
    }

    
    public static <T> List<List<T>> normalizeListOfList(final List<? extends List<T>> listOfList) {
        if (listOfList == null) {
            return null;
        }
        final List<List<T>> result = new ArrayList<List<T>>();
        for (final List<T> element : listOfList) {
            result.add(normalizeList(element));
        }
        return result;
    }

    
    public static <K, V> List<Map<K, V>> normalizeListOfMap(final List<? extends Map<K, V>> listOfMap) {
        if (listOfMap == null) {
            return null;
        }
        final List<Map<K, V>> result = new ArrayList<Map<K, V>>();
        for (final Map<K, V> element : listOfMap) {
            result.add(normalizeMap(element));
        }
        return result;
    }

    
    public static <T> List<Set<T>> normalizeListOfSet(final List<? extends Set<T>> listOfSet) {
        if (listOfSet == null) {
            return null;
        }
        final List<Set<T>> result = new ArrayList<Set<T>>();
        for (final Set<T> element : listOfSet) {
            result.add(normalizeSet(element));
        }
        return result;
    }
    
    
    public static <K, V> Map<K, V> normalizeMap(final Map<K,V> map) {
        if (map == null) {
            return null;
        }
        return new LinkedHashMap<K, V>(map);
    }

    
    public static <K, V> Map<K, V[]> normalizeMapOfArray(final Map<K, V[]> mapOfArray) {
        if (mapOfArray == null) {
            return null;
        }
        final Map<K, V[]> result = new LinkedHashMap<K, V[]>();
        for (final Map.Entry<K, V[]> element : mapOfArray.entrySet()) {
            result.put(element.getKey(), normalizeArray(element.getValue()));
        }
        return result;
    }

    
    public static <K, V> Map<K, List<V>> normalizeMapOfList(final Map<K, ? extends List<V>> mapOfList) {
        if (mapOfList == null) {
            return null;
        }
        final Map<K, List<V>> result = new LinkedHashMap<K, List<V>>();
        for (final Map.Entry<K, ? extends List<V>> element : mapOfList.entrySet()) {
            result.put(element.getKey(), normalizeList(element.getValue()));
        }
        return result;
    }

    
    public static <K1, K2, V> Map<K1, Map<K2, V>> normalizeMapOfMap(final Map<K1, ? extends Map<K2, V>> mapOfMap) {
        if (mapOfMap == null) {
            return null;
        }
        final Map<K1, Map<K2, V>> result = new LinkedHashMap<K1, Map<K2, V>>();
        for (final Map.Entry<K1, ? extends Map<K2, V>> element : mapOfMap.entrySet()) {
            result.put(element.getKey(), normalizeMap(element.getValue()));
        }
        return result;
    }

    
    public static <K, V> Map<K, Set<V>> normalizeMapOfSet(final Map<K, ? extends Set<V>> mapOfSet) {
        if (mapOfSet == null) {
            return null;
        }
        final Map<K, Set<V>> result = new LinkedHashMap<K, Set<V>>();
        for (final Map.Entry<K, ? extends Set<V>> element : mapOfSet.entrySet()) {
            result.put(element.getKey(), normalizeSet(element.getValue()));
        }
        return result;
    }
    
    
    public static <T> Set<T> normalizeSet(final Set<T> set) {
        if (set == null) {
            return null;
        }
        return new LinkedHashSet<T>(set);
    }

    
    public static <T> Set<T[]> normalizeSetOfArray(final Set<? extends T[]> setOfArray) {
        if (setOfArray == null) {
            return null;
        }
        final Set<T[]> result = new LinkedHashSet<T[]>();
        for (final T[] element : setOfArray) {
            result.add(normalizeArray(element));
        }
        return result;
    }

    
    public static <T> Set<List<T>> normalizeSetOfList(final Set<? extends List<T>> setOfList) {
        if (setOfList == null) {
            return null;
        }
        final Set<List<T>> result = new LinkedHashSet<List<T>>();
        for (final List<T> element : setOfList) {
            result.add(normalizeList(element));
        }
        return result;
    }

    
    public static <K, V> Set<Map<K, V>> normalizeSetOfMap(final Set<? extends Map<K, V>> setOfMap) {
        if (setOfMap == null) {
            return null;
        }
        final Set<Map<K, V>> result = new LinkedHashSet<Map<K, V>>();
        for (final Map<K, V> element : setOfMap) {
            result.add(normalizeMap(element));
        }
        return result;
    }

    
    public static <T> Set<Set<T>> normalizeSetOfSet(final Set<? extends Set<T>> setOfSet) {
        if (setOfSet == null) {
            return null;
        }
        final Set<Set<T>> result = new LinkedHashSet<Set<T>>();
        for (final Set<T> element : setOfSet) {
            result.add(normalizeSet(element));
        }
        return result;
    }
    

    
    
    

    public static <T> Type<T[]> buildArrayExecutionTargetType(final Type<T> arrayOf) {
        return null;
    }

    public static <T> Type<T[][]> buildArrayOfArrayExecutionTargetType(final Type<T> arrayOf) {
        return null;
    }

    public static <T> Type<List<T[]>> buildListOfArrayExecutionTargetType(final Type<T> arrayOf) {
        return null;
    }

    public static <T> Type<Set<T[]>> buildSetOfArrayExecutionTargetType(final Type<T> arrayOf) {
        return null;
    }

    public static <T> Type<Map<?,T[]>> buildMapOfArrayExecutionTargetType(final Type<T> arrayOf) {
        return null;
    }



    public static <T> Type<T> extractArrayOfFromElementExecutionTargetType(final Type<? extends T> type) {
        return null;
    }

    public static <T> Type<T[]> extractArrayFromArrayExecutionTargetType(final Type<? extends T[]> type) {
        return null;
    }

    public static <T> Type<T> extractArrayOfFromArrayExecutionTargetType(final Type<? extends T[]> type) {
        return null;
    }

    public static <T> Type<T> extractArrayOfFromArrayOfArrayExecutionTargetType(final Type<? extends T[][]> type) {
        return null;
    }

    public static <T> Type<T> extractArrayOfFromListOfArrayExecutionTargetType(final Type<? extends List<T[]>> type) {
        return null;
    }

    public static <T> Type<T> extractArrayOfFromMapOfArrayExecutionTargetType(final Type<? extends Map<?, T[]>> type) {
        return null;
    }

    public static <T> Type<T> extractArrayOfFromSetOfArrayExecutionTargetType(final Type<? extends Set<T[]>> type) {
        return null;
    }
    
    
    
    
    
    
    private NormalizationUtils() {
        super();
    }
    
}

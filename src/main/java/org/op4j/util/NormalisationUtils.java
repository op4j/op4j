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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.ExecutionException;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class NormalisationUtils {


    
    
    
    public static void checkIsArray(final Type<?> of, final Object targetObject) {
        if (targetObject != null) {
            final Class<?> newTargetClass = Types.arrayOf(of).getRawClass();
            if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
                throw createCastException(targetObject.getClass(), newTargetClass.getSimpleName());
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
                throw createCastException(targetObject.getClass(), newTargetClass.getSimpleName());
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
                throw createCastException(targetObject.getClass(), newTargetClass.getSimpleName());
            }
            for (final Map.Entry<?,?> element : ((Map<?,?>)targetObject).entrySet()) {
                checkIs(keyOf, element.getKey());
                checkIs(valueOf, element.getValue());
            }
        }
    }
    
    public static void checkIsMapEntry(final Type<?> keyOf, final Type<?> valueOf, final Object targetObject) {
        if (targetObject != null) {
            final Class<?> newTargetClass = Map.Entry.class;
            if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
                throw createCastException(targetObject.getClass(), newTargetClass.getSimpleName());
            }
            final Map.Entry<?,?> element = (Map.Entry<?,?>)targetObject;
            checkIs(keyOf, element.getKey());
            checkIs(valueOf, element.getValue());
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
    
    public static void checkIsMapEntryOfArray(final Type<?> keyOf, final Type<?> valueOf, final Object targetObject) {
        checkIsMapEntry(keyOf, Types.arrayOf(valueOf), targetObject);
        if (targetObject != null) {
            final Map.Entry<?,?> element = (Map.Entry<?,?>)targetObject;
            checkIs(keyOf, element.getKey());
            checkIsArray(valueOf, element.getValue());
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
    
    public static void checkIsMapEntryOfList(final Type<?> keyOf, final Type<?> valueOf, final Object targetObject) {
        checkIsMapEntry(keyOf, Types.listOf(valueOf), targetObject);
        if (targetObject != null) {
            final Map.Entry<?,?> element = (Map.Entry<?,?>)targetObject;
            checkIs(keyOf, element.getKey());
            checkIsList(valueOf, element.getValue());
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
    
    public static void checkIsMapEntryOfMap(final Type<?> key1Of, final Type<?> key2Of, final Type<?> valueOf, final Object targetObject) {
        checkIsMapEntry(key1Of, Types.mapOf(key2Of, valueOf), targetObject);
        if (targetObject != null) {
            final Map.Entry<?,?> element = (Map.Entry<?,?>)targetObject;
            checkIs(key1Of, element.getKey());
            checkIsMap(key2Of, valueOf, element.getValue());
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
    
    public static void checkIsMapEntryOfSet(final Type<?> keyOf, final Type<?> valueOf, final Object targetObject) {
        checkIsMapEntry(keyOf, Types.setOf(valueOf), targetObject);
        if (targetObject != null) {
            final Map.Entry<?,?> element = (Map.Entry<?,?>)targetObject;
            checkIs(keyOf, element.getKey());
            checkIsSet(valueOf, element.getValue());
        }
    }
    
    public static void checkIsSet(final Type<?> of, final Object targetObject) {
        if (targetObject != null) {
            final Class<?> newTargetClass = Set.class;
            if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
                throw createCastException(targetObject.getClass(), newTargetClass.getSimpleName());
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
                throw createCastException(targetObject.getClass(), newTargetClass.getSimpleName());
            }
        }
    }
    
    

    
    @SuppressWarnings("unchecked")
    public static <T> T[] normaliseArray(final T[] array, final Class<?> arrayComponentClass) {
        if (array == null) {
            return null;
        }
        final Object[] result = (Object[]) Array.newInstance(arrayComponentClass, array.length);
        for (int i = 0, z = result.length; i < z; i++) {
            result[i] = array[i];
        }
        return (T[]) result;
    }

    
    @SuppressWarnings("unchecked")
    public static <T> T[][] normaliseArrayOfArray(final T[][] arrayOfArray, final Class<?> arrayComponentClass) {
        if (arrayOfArray == null) {
            return null;
        }
        final T[][] result = (T[][]) Array.newInstance((Array.newInstance(arrayComponentClass, 0)).getClass(), arrayOfArray.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = normaliseArray(arrayOfArray[i], arrayComponentClass);
        }
        return result;
    }

    
    @SuppressWarnings("unchecked")
    public static <T> List<T>[] normaliseArrayOfList(final List<T>[] arrayOfList) {
        if (arrayOfList == null) {
            return null;
        }
        final List<T>[] result = (List<T>[]) ArrayUtils.clone(arrayOfList);
        for (int i = 0; i < result.length; i++) {
            result[i] = normaliseList(result[i]);
        }
        return result;
    }

    
    @SuppressWarnings("unchecked")
    public static <K,V> Map<K,V>[] normaliseArrayOfMap(final Map<K,V>[] arrayOfMap) {
        if (arrayOfMap == null) {
            return null;
        }
        final Map<K,V>[] result = (Map<K,V>[]) ArrayUtils.clone(arrayOfMap);
        for (int i = 0; i < result.length; i++) {
            result[i] = normaliseMap(result[i]);
        }
        return result;
    }

    
    @SuppressWarnings("unchecked")
    public static <T> Set<T>[] normaliseArrayOfSet(final Set<T>[] arrayOfSet) {
        if (arrayOfSet == null) {
            return null;
        }
        final Set<T>[] result = (Set<T>[]) ArrayUtils.clone(arrayOfSet);
        for (int i = 0; i < result.length; i++) {
            result[i] = normaliseSet(result[i]);
        }
        return result;
    }
    
    
    public static <T> List<T> normaliseList(final List<T> list) {
        if (list == null) {
            return null;
        }
        return new ArrayList<T>(list);
    }

    
    public static <T> List<T[]> normaliseListOfArray(final List<? extends T[]> listOfArray, final Class<?> arrayComponentClass) {
        if (listOfArray == null) {
            return null;
        }
        final List<T[]> result = new ArrayList<T[]>();
        for (final T[] element : listOfArray) {
            result.add(normaliseArray(element, arrayComponentClass));
        }
        return result;
    }

    
    public static <T> List<List<T>> normaliseListOfList(final List<? extends List<T>> listOfList) {
        if (listOfList == null) {
            return null;
        }
        final List<List<T>> result = new ArrayList<List<T>>();
        for (final List<T> element : listOfList) {
            result.add(normaliseList(element));
        }
        return result;
    }

    
    public static <K, V> List<Map<K, V>> normaliseListOfMap(final List<? extends Map<K, V>> listOfMap) {
        if (listOfMap == null) {
            return null;
        }
        final List<Map<K, V>> result = new ArrayList<Map<K, V>>();
        for (final Map<K, V> element : listOfMap) {
            result.add(normaliseMap(element));
        }
        return result;
    }

    
    public static <T> List<Set<T>> normaliseListOfSet(final List<? extends Set<T>> listOfSet) {
        if (listOfSet == null) {
            return null;
        }
        final List<Set<T>> result = new ArrayList<Set<T>>();
        for (final Set<T> element : listOfSet) {
            result.add(normaliseSet(element));
        }
        return result;
    }
    
    
    public static <K, V> Map<K, V> normaliseMap(final Map<K,V> map) {
        if (map == null) {
            return null;
        }
        return new LinkedHashMap<K, V>(map);
    }

    
    public static <K, V> Map.Entry<K, V> normaliseMapEntry(final Map.Entry<K,V> mapEntry) {
        if (mapEntry == null) {
            return null;
        }
        return new MapEntry<K,V>(mapEntry.getKey(), mapEntry.getValue());
    }

    
    public static <K, V> Map<K, V[]> normaliseMapOfArray(final Map<K, V[]> mapOfArray, final Class<?> arrayComponentClass) {
        if (mapOfArray == null) {
            return null;
        }
        final Map<K, V[]> result = new LinkedHashMap<K, V[]>();
        for (final Map.Entry<K, V[]> element : mapOfArray.entrySet()) {
            result.put(element.getKey(), normaliseArray(element.getValue(), arrayComponentClass));
        }
        return result;
    }

    
    public static <K, V> Map.Entry<K, V[]> normaliseMapEntryOfArray(final Map.Entry<K, V[]> mapEntryOfArray, final Class<?> arrayComponentClass) {
        if (mapEntryOfArray == null) {
            return null;
        }
        return new MapEntry<K, V[]>(mapEntryOfArray.getKey(), normaliseArray(mapEntryOfArray.getValue(), arrayComponentClass));
    }

    
    public static <K, V> Map<K, List<V>> normaliseMapOfList(final Map<K, ? extends List<V>> mapOfList) {
        if (mapOfList == null) {
            return null;
        }
        final Map<K, List<V>> result = new LinkedHashMap<K, List<V>>();
        for (final Map.Entry<K, ? extends List<V>> element : mapOfList.entrySet()) {
            result.put(element.getKey(), normaliseList(element.getValue()));
        }
        return result;
    }

    
    public static <K, V> Map.Entry<K, List<V>> normaliseMapEntryOfList(final Map.Entry<K, ? extends List<V>> mapEntryOfList) {
        if (mapEntryOfList == null) {
            return null;
        }
        return new MapEntry<K, List<V>>(mapEntryOfList.getKey(), normaliseList(mapEntryOfList.getValue()));
    }

    
    public static <K1, K2, V> Map<K1, Map<K2, V>> normaliseMapOfMap(final Map<K1, ? extends Map<K2, V>> mapOfMap) {
        if (mapOfMap == null) {
            return null;
        }
        final Map<K1, Map<K2, V>> result = new LinkedHashMap<K1, Map<K2, V>>();
        for (final Map.Entry<K1, ? extends Map<K2, V>> element : mapOfMap.entrySet()) {
            result.put(element.getKey(), normaliseMap(element.getValue()));
        }
        return result;
    }

    
    public static <K1, K2, V> Map.Entry<K1, Map<K2, V>> normaliseMapEntryOfMap(final Map.Entry<K1, ? extends Map<K2, V>> mapEntryOfMap) {
        if (mapEntryOfMap == null) {
            return null;
        }
        return new MapEntry<K1, Map<K2, V>>(mapEntryOfMap.getKey(), normaliseMap(mapEntryOfMap.getValue()));
    }

    
    public static <K, V> Map<K, Set<V>> normaliseMapOfSet(final Map<K, ? extends Set<V>> mapOfSet) {
        if (mapOfSet == null) {
            return null;
        }
        final Map<K, Set<V>> result = new LinkedHashMap<K, Set<V>>();
        for (final Map.Entry<K, ? extends Set<V>> element : mapOfSet.entrySet()) {
            result.put(element.getKey(), normaliseSet(element.getValue()));
        }
        return result;
    }

    
    public static <K, V> Map.Entry<K, Set<V>> normaliseMapEntryOfSet(final Map.Entry<K, ? extends Set<V>> mapEntryOfSet) {
        if (mapEntryOfSet == null) {
            return null;
        }
        return new MapEntry<K, Set<V>>(mapEntryOfSet.getKey(), normaliseSet(mapEntryOfSet.getValue()));
    }
    
    
    public static <T> Set<T> normaliseSet(final Set<T> set) {
        if (set == null) {
            return null;
        }
        return new LinkedHashSet<T>(set);
    }

    
    public static <T> Set<T[]> normaliseSetOfArray(final Set<? extends T[]> setOfArray, final Class<?> arrayComponentClass) {
        if (setOfArray == null) {
            return null;
        }
        final Set<T[]> result = new LinkedHashSet<T[]>();
        for (final T[] element : setOfArray) {
            result.add(normaliseArray(element, arrayComponentClass));
        }
        return result;
    }

    
    public static <T> Set<List<T>> normaliseSetOfList(final Set<? extends List<T>> setOfList) {
        if (setOfList == null) {
            return null;
        }
        final Set<List<T>> result = new LinkedHashSet<List<T>>();
        for (final List<T> element : setOfList) {
            result.add(normaliseList(element));
        }
        return result;
    }

    
    public static <K, V> Set<Map<K, V>> normaliseSetOfMap(final Set<? extends Map<K, V>> setOfMap) {
        if (setOfMap == null) {
            return null;
        }
        final Set<Map<K, V>> result = new LinkedHashSet<Map<K, V>>();
        for (final Map<K, V> element : setOfMap) {
            result.add(normaliseMap(element));
        }
        return result;
    }

    
    public static <T> Set<Set<T>> normaliseSetOfSet(final Set<? extends Set<T>> setOfSet) {
        if (setOfSet == null) {
            return null;
        }
        final Set<Set<T>> result = new LinkedHashSet<Set<T>>();
        for (final Set<T> element : setOfSet) {
            result.add(normaliseSet(element));
        }
        return result;
    }
    

    
    @SuppressWarnings("unchecked")
    public static <T> T[][] normaliseArrays(final T[][] input, final Class<?> arrayComponentClass) {
        if (input == null) {
            return null;
        }
        final T[][] result = (T[][]) Array.newInstance((Array.newInstance(arrayComponentClass, 0)).getClass(), input.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = normaliseArray(input[i], arrayComponentClass);
        }
        return result;
    }

    
    @SuppressWarnings("unchecked")
    public static <T> List<T>[] normaliseLists(final List<T>[] input) {
        if (input == null) {
            return null;
        }
        final List<T>[] result = (List<T>[]) ArrayUtils.clone(input);
        for (int i = 0; i < result.length; i++) {
            result[i] = normaliseList(result[i]);
        }
        return result;
    }

    
    @SuppressWarnings("unchecked")
    public static <K,V> Map<K,V>[] normaliseMaps(final Map<K,V>[] input) {
        if (input == null) {
            return null;
        }
        final Map<K,V>[] result = (Map<K,V>[]) ArrayUtils.clone(input);
        for (int i = 0; i < result.length; i++) {
            result[i] = normaliseMap(result[i]);
        }
        return result;
    }

    
    @SuppressWarnings("unchecked")
    public static <T> Set<T>[] normaliseSets(final Set<T>[] input) {
        if (input == null) {
            return null;
        }
        final Set<T>[] result = (Set<T>[]) ArrayUtils.clone(input);
        for (int i = 0; i < result.length; i++) {
            result[i] = normaliseSet(result[i]);
        }
        return result;
    }
    
    
    

    
    public static <T> Collection<T[]> normaliseArrays(final Collection<T[]> input, final Class<?> arrayComponentClass) {
        if (input == null) {
            return null;
        }
        final Collection<T[]> result = new ArrayList<T[]>();
        for (final T[] inputElement : input) {
            result.add(normaliseArray(inputElement, arrayComponentClass));
        }
        return result;
    }

    
    public static <T> Collection<List<T>> normaliseLists(final Collection<List<T>> input) {
        if (input == null) {
            return null;
        }
        final Collection<List<T>> result = new ArrayList<List<T>>();
        for (final List<T> inputElement : input) {
            result.add(normaliseList(inputElement));
        }
        return result;
    }

    
    public static <K,V> Collection<Map<K,V>> normaliseMaps(final Collection<Map<K,V>> input) {
        if (input == null) {
            return null;
        }
        final Collection<Map<K,V>> result = new ArrayList<Map<K,V>>();
        for (final Map<K,V> inputElement : input) {
            result.add(normaliseMap(inputElement));
        }
        return result;
    }

    
    public static <T> Collection<Set<T>> normaliseSets(final Collection<Set<T>> input) {
        if (input == null) {
            return null;
        }
        final Collection<Set<T>> result = new ArrayList<Set<T>>();
        for (final Set<T> inputElement : input) {
            result.add(normaliseSet(inputElement));
        }
        return result;
    }
    
    
    
    public static ExecutionException createCastException(final Class<?> targetClass, final String cast) {
        return new ExecutionException("Target of class " + targetClass.getSimpleName() + " cannot be casted as: " + cast);
    }
    
    
    
    
    private NormalisationUtils() {
        super();
    }
    
}

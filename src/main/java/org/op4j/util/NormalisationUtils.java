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
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    
    
    public static <T> List<T> normaliseList(final List<T> list) {
        if (list == null) {
            return null;
        }
        return new ArrayList<T>(list);
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
    
    
    
    public static ExecutionException createCastException(final Class<?> targetClass, final String cast) {
        return new ExecutionException("Target of class " + targetClass.getSimpleName() + " cannot be casted as: " + cast);
    }
    
    
    
    
    private NormalisationUtils() {
        super();
    }
    
}

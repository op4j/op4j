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

import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class TargetUtils {


    
    
    
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
    
    
    
    private TargetUtils() {
        super();
    }
    
}

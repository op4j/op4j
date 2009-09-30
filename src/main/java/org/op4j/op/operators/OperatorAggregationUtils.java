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
package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.op4j.exceptions.ArrayInstantiationException;
import org.op4j.exceptions.DuplicateMapKeyException;
import org.op4j.exceptions.InvalidExpressionResultClassException;
import org.op4j.exceptions.InvalidOperatorCastException;
import org.op4j.exceptions.NullTargetException;
import org.op4j.op.interfaces.MapBuilder;
import org.op4j.operations.conversion.exceptions.ConversionException;
import org.op4j.type.Type;
import org.op4j.type.Types;
import org.op4j.util.OgnlUtils;
import org.op4j.util.TypeAggregationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class OperatorAggregationUtils {

    
    static <T> List<T> buildListAggregatedTarget(final List<T> objects) {
        return new ArrayList<T>(objects);
    }

    
    static <T> Set<T> buildSetAggregatedTarget(final List<T> objects) {
        return new LinkedHashSet<T>(objects);
    }

    
    @SuppressWarnings("unchecked")
    static <T> T[] buildArrayAggregatedTarget(final Type operatorType, final List<T> objects) {
        
        /*
         * Arrays are special because they are instantiated on a specific class,
         * and as such, the type to be used must be computed BEFORE creating the
         * array itself with the converter.
         */
        
        Type arrayType = null;
        
        if (operatorType == null || operatorType.equals(Types.OBJECT)) {
            
            /*
             * If operatorType is NULL or OBJECT it means that we are at a 
             * either a <?> or an <Object> operator, and this means that 
             * the array type which will be instanced will have to
             * be computed from the types of the target objects
             */

            arrayType = 
                TypeAggregationUtils.computeMostSpecificCommonClassType(objects).increaseArrayDimensions();
            
        } else {
            
            /*
             * If operatorType is not OBJECT it means that we are at a <T> 
             * operator, and this means that the array type which will be instanced 
             * will be T[]. 
             */
            
            arrayType = operatorType.increaseArrayDimensions();
            
        }

        try {
            return objects.toArray((T[])arrayType.newInstance());
        } catch (Exception e) {
            // This should never happen
            throw new ArrayInstantiationException(arrayType, e); 
        }
        
    }

    
    @SuppressWarnings("unchecked")
    static <K,T> Map<K,T> buildMapAggregatedTarget(
            final List<T> objects, final Class<K> keyClass, 
            final String keyExpression, final List<Object> expParams) {

        /*
         * Create the new map
         */
        final Map<Object,Object> newMap = new LinkedHashMap<Object,Object>();
        for (T object : objects) {
            final Object key = OgnlUtils.getValueByOgnlExpression(object, keyExpression, expParams);
            final Object value = object; 
            addNewMapEntry(newMap, key, value); // Will throw an exception if invalid
        }
        
        /*
         * Check the keys are assignable from the specified class
         */
        
        for (Object key : newMap.keySet()) {
            if (key != null && keyClass != null) {
                if (!keyClass.isAssignableFrom(key.getClass())) {
                    throw new InvalidExpressionResultClassException(key.getClass(), keyClass);
                }
            }
        }
        
        return (Map<K,T>) newMap;
        
    }

    
    @SuppressWarnings("unchecked")
    static <K,V,T> Map<K,V> buildMapAggregatedTarget(
            final List<T> objects, final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final List<Object> expParams) {

        /*
         * Create the new map
         */
        
        final Map<Object,Object> newMap = new LinkedHashMap<Object,Object>();
        for (Object object : objects) {
            final Object key = OgnlUtils.getValueByOgnlExpression(object, keyExpression, expParams);
            final Object value = OgnlUtils.getValueByOgnlExpression(object, valueExpression, expParams);
            addNewMapEntry(newMap, key, value); // Will throw an exception if invalid
        }
        
        /*
         * Check the keys and values are assignable from the specified class
         */
        
        for (Map.Entry<?,?> entry : newMap.entrySet()) {
            if (entry.getKey() != null && keyClass != null) {
                if (!keyClass.isAssignableFrom(entry.getKey().getClass())) {
                    throw new InvalidExpressionResultClassException(entry.getKey().getClass(), keyClass);
                }
            }
            if (entry.getValue() != null && valueClass != null) {
                if (!valueClass.isAssignableFrom(entry.getValue().getClass())) {
                    throw new InvalidExpressionResultClassException(entry.getValue().getClass(), valueClass);
                }
            }
        }
        
        return (Map<K,V>) newMap;
        
    }

    
    static <K,V,T> Map<K,V> buildMapAggregatedTarget(
            final List<T> objects, 
            final MapBuilder<T,K,V> mapBuilder) {
        
        final Map<K,V> newMap = new LinkedHashMap<K,V>();
        for (T object : objects) {
            final K key = mapBuilder.getKey(object);
            final V value = mapBuilder.getValue(object); 
            addNewMapEntry(newMap, key, value); // Will throw an exception if invalid
        }
        
        return newMap;
        
    }

    
    @SuppressWarnings("unchecked")
    static <T,K,V> Map<K,V> buildMapAggregatedTarget(
            final List<T> objects, final Class<K> keyClass, final Class<V> valueClass) {

        /*
         * Create the map. Will throw an exception if not possible (e.g. odd number of targets)
         */
        
        final Map<Object,Object> newMap = new LinkedHashMap<Object,Object>();
        final Iterator<T> objectsIter = objects.iterator();
        while (objectsIter.hasNext()) {
            final Object key = objectsIter.next();
            if (!objectsIter.hasNext()) {
                throw new ConversionException(
                        "Targets must be in a number divisible by two for a map to " +
                        "be created from them");
            }
            final Object value = objectsIter.next();
            addNewMapEntry(newMap, key, value); // Will throw an exception if invalid
        }
        
        /*
         * Check the keys and values are assignable from the specified class
         */
        
        for (Map.Entry<?,?> entry : newMap.entrySet()) {
            if (entry.getKey() != null && keyClass != null) {
                if (!keyClass.isAssignableFrom(entry.getKey().getClass())) {
                    throw new InvalidOperatorCastException(entry.getKey().getClass(), keyClass);
                }
            }
            if (entry.getValue() != null && valueClass != null) {
                if (!valueClass.isAssignableFrom(entry.getValue().getClass())) {
                    throw new InvalidOperatorCastException(entry.getValue().getClass(), valueClass);
                }
            }
        }
        
        return (Map<K,V>) newMap;
        
    }

    
    @SuppressWarnings("unchecked")
    static <K,T> Map<K,List<T>> buildListMapAggregatedTarget(
            final List<T> objects, final Class<K> keyClass, 
            final String keyExpression, final List<Object> expParams) {

        /*
         * Create the new map
         */
        
    	// intentionally raw
        final Map newMap = new LinkedHashMap();
        for (Object object : objects) {
            final Object key = OgnlUtils.getValueByOgnlExpression(object, keyExpression, expParams);
            final Object value = object; 
            addNewListMapEntry(newMap,key,value);
        }
        
        /*
         * Check the keys are assignable from the specified class
         */
        
        for (Object key : newMap.keySet()) {
            if (key != null && keyClass != null) {
                if (!keyClass.isAssignableFrom(key.getClass())) {
                    throw new InvalidExpressionResultClassException(key.getClass(), keyClass);
                }
            }
        }
        
        return newMap;
        
    }

    
    @SuppressWarnings("unchecked")
    static <K,T> Map<K,Set<T>> buildSetMapAggregatedTarget(
            final List<T> objects, final Class<K> keyClass, 
            final String keyExpression, final List<Object> expParams) {

        /*
         * Create the new map
         */
        
    	// intentionally raw
        final Map newMap = new LinkedHashMap();
        for (Object object : objects) {
            final Object key = OgnlUtils.getValueByOgnlExpression(object, keyExpression, expParams);
            final Object value = object; 
            addNewSetMapEntry(newMap,key,value);
        }
        
        /*
         * Check the keys are assignable from the specified class
         */
        
        for (Object key : newMap.keySet()) {
            if (key != null && keyClass != null) {
                if (!keyClass.isAssignableFrom(key.getClass())) {
                    throw new InvalidExpressionResultClassException(key.getClass(), keyClass);
                }
            }
        }
        
        return newMap;
        
    }

    
    @SuppressWarnings("unchecked")
    static <K,T> Map<K,T[]> buildArrayMapAggregatedTarget(
    		final Type valueType,
            final List<T> objects, final Class<K> keyClass, 
            final String keyExpression, final List<Object> expParams) {

        /*
         * Create the new map
         */
        
    	// intentionally raw
        final Map newMap = new LinkedHashMap();
        for (Object object : objects) {
            final Object key = OgnlUtils.getValueByOgnlExpression(object, keyExpression, expParams);
            final Object value = object; 
            addNewArrayMapEntry(newMap,valueType,key,value);
        }
        
        /*
         * Check the keys are assignable from the specified class
         */
        
        for (Object key : newMap.keySet()) {
            if (key != null && keyClass != null) {
                if (!keyClass.isAssignableFrom(key.getClass())) {
                    throw new InvalidExpressionResultClassException(key.getClass(), keyClass);
                }
            }
        }
        
        return newMap;
        
    }

    
    @SuppressWarnings("unchecked")
    static <K,V,T> Map<K,List<V>> buildListMapAggregatedTarget(
            final List<T> objects, final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final List<Object> expParams) {

        /*
         * Create the new map
         */
        
    	// intentionally raw
        final Map newMap = new LinkedHashMap();
        for (Object object : objects) {
            final Object key = OgnlUtils.getValueByOgnlExpression(object, keyExpression, expParams);
            final Object value = OgnlUtils.getValueByOgnlExpression(object, valueExpression, expParams);
            addNewListMapEntry(newMap,key,value);
        }
        
        /*
         * Check the keys and values are assignable from the specified class
         */
        
        for (Map.Entry<?,?> entry : ((Set<Map.Entry<?,?>>)newMap.entrySet())) {
            if (entry.getKey() != null && keyClass != null) {
                if (!keyClass.isAssignableFrom(entry.getKey().getClass())) {
                    throw new InvalidExpressionResultClassException(entry.getKey().getClass(), keyClass);
                }
            }
            if (entry.getValue() != null) {
                for (Object valueComponent : (List<Object>) entry.getValue()) {
                    if (valueComponent != null && valueClass != null) {
                        if (!valueClass.isAssignableFrom(valueComponent.getClass())) {
                            throw new InvalidExpressionResultClassException(entry.getValue().getClass(), valueClass);
                        }
                    }
                }
            }
        }
        
        return newMap;
        
    }

    
    @SuppressWarnings("unchecked")
    static <K,V,T> Map<K,Set<V>> buildSetMapAggregatedTarget(
            final List<T> objects, final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final List<Object> expParams) {

        /*
         * Create the new map
         */
        
        final Map newMap = new LinkedHashMap();
        for (Object object : objects) {
            final Object key = OgnlUtils.getValueByOgnlExpression(object, keyExpression, expParams);
            final Object value = OgnlUtils.getValueByOgnlExpression(object, valueExpression, expParams);
            addNewSetMapEntry(newMap,key,value);
        }
        
        /*
         * Check the keys and values are assignable from the specified class
         */
        
        for (Map.Entry<?,?> entry : ((Set<Map.Entry<?,?>>)newMap.entrySet())) {
            if (entry.getKey() != null && keyClass != null) {
                if (!keyClass.isAssignableFrom(entry.getKey().getClass())) {
                    throw new InvalidExpressionResultClassException(entry.getKey().getClass(), keyClass);
                }
            }
            if (entry.getValue() != null) {
                for (Object valueComponent : (Set<Object>) entry.getValue()) {
                    if (valueComponent != null && valueClass != null) {
                        if (!valueClass.isAssignableFrom(valueComponent.getClass())) {
                            throw new InvalidExpressionResultClassException(entry.getValue().getClass(), valueClass);
                        }
                    }
                }
            }
        }
        
        return newMap;
        
    }

    
    @SuppressWarnings("unchecked")
    static <K,V,T> Map<K,V[]> buildArrayMapAggregatedTarget(
            final List<T> objects, final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final List<Object> expParams) {

    	final Type newValueType =
    		(valueClass != null? Types.getRawTypeForClass(valueClass) : Types.OBJECT);
    	
        /*
         * Create the new map
         */
        
        final Map newMap = new LinkedHashMap();
        for (Object object : objects) {
            final Object key = OgnlUtils.getValueByOgnlExpression(object, keyExpression, expParams);
            final Object value = OgnlUtils.getValueByOgnlExpression(object, valueExpression, expParams);
            addNewArrayMapEntry(newMap,newValueType,key,value);
        }
        
        /*
         * Check the keys and values are assignable from the specified class
         */
        
        for (Map.Entry<?,?> entry : ((Set<Map.Entry<?,?>>)newMap.entrySet())) {
            if (entry.getKey() != null && keyClass != null) {
                if (!keyClass.isAssignableFrom(entry.getKey().getClass())) {
                    throw new InvalidExpressionResultClassException(entry.getKey().getClass(), keyClass);
                }
            }
            if (entry.getValue() != null) {
                for (Object valueComponent : (Set<Object>) entry.getValue()) {
                    if (valueComponent != null && valueClass != null) {
                        if (!valueClass.isAssignableFrom(valueComponent.getClass())) {
                            throw new InvalidExpressionResultClassException(entry.getValue().getClass(), valueClass);
                        }
                    }
                }
            }
        }
        
        return newMap;
        
    }

    
    static <K,V,T> Map<K,List<V>> buildListMapAggregatedTarget(
            final List<T> objects, 
            final MapBuilder<T,K,V> mapBuilder) {
        
        final Map<K,List<V>> newMap = new LinkedHashMap<K,List<V>>();
        for (T object : objects) {
            final K key = mapBuilder.getKey(object);
            final V value = mapBuilder.getValue(object); 
            addNewListMapEntry(newMap,key,value);
        }
        
        return newMap;
        
    }

    
    static <K,V,T> Map<K,Set<V>> buildSetMapAggregatedTarget(
            final List<T> objects, 
            final MapBuilder<T,K,V> mapBuilder) {
        
        final Map<K,Set<V>> newMap = new LinkedHashMap<K,Set<V>>();
        for (T object : objects) {
            final K key = mapBuilder.getKey(object);
            final V value = mapBuilder.getValue(object); 
            addNewSetMapEntry(newMap,key,value);
        }
        
        return newMap;
        
    }

    
    static <K,V,T> Map<K,V[]> buildArrayMapAggregatedTarget(
            final Class<V> valueClass, final List<T> objects, 
            final MapBuilder<T,K,V> mapBuilder) {

    	final Type newValueType =
    		(valueClass != null? Types.getRawTypeForClass(valueClass) : Types.OBJECT);
        
        final Map<K,V[]> newMap = new LinkedHashMap<K,V[]>();
        for (T object : objects) {
            final K key = mapBuilder.getKey(object);
            final V value = mapBuilder.getValue(object);
            addNewArrayMapEntry(newMap,newValueType, key, value);
        }
        
        return newMap;
        
    }

    
    @SuppressWarnings("unchecked")
    static <T,K,V> Map<K,List<V>> buildListMapAggregatedTarget(
            final List<T> objects, final Class<K> keyClass, final Class<V> valueClass) {

        /*
         * Create the map. Will throw an exception if not possible (e.g. odd number of targets)
         */
        
        // intentionally raw
        final Map newMap = new LinkedHashMap();
        final Iterator<T> objectsIter = objects.iterator();
        while (objectsIter.hasNext()) {
            final Object key = objectsIter.next();
            if (!objectsIter.hasNext()) {
                throw new ConversionException(
                        "Targets must be in a number divisible by two for a map to " +
                        "be created from them");
            }
            final Object value = objectsIter.next();
            addNewListMapEntry(newMap,key,value);
        }
        
        /*
         * Check the keys and values are assignable from the specified class
         */
        
        for (Map.Entry<?,?> entry : ((Set<Map.Entry<?,?>>)newMap.entrySet())) {
            if (entry.getKey() != null && keyClass != null) {
                if (!keyClass.isAssignableFrom(entry.getKey().getClass())) {
                    throw new InvalidOperatorCastException(entry.getKey().getClass(), keyClass);
                }
            }
            if (entry.getValue() != null) {
                for (Object valueComponent : (List<Object>) entry.getValue()) {
                    if (valueComponent != null && valueClass != null) {
                        if (!valueClass.isAssignableFrom(valueComponent.getClass())) {
                            throw new InvalidOperatorCastException(entry.getValue().getClass(), valueClass);
                        }
                    }
                }
            }
        }
        
        return newMap;
        
    }

    
    @SuppressWarnings("unchecked")
    static <T,K,V> Map<K,Set<V>> buildSetMapAggregatedTarget(
            final List<T> objects, final Class<K> keyClass, final Class<V> valueClass) {

        /*
         * Create the map. Will throw an exception if not possible (e.g. odd number of targets)
         */
        
    	// intentionally raw
        final Map newMap = new LinkedHashMap();
        final Iterator<T> objectsIter = objects.iterator();
        while (objectsIter.hasNext()) {
            final Object key = objectsIter.next();
            if (!objectsIter.hasNext()) {
                throw new ConversionException(
                        "Targets must be in a number divisible by two for a map to " +
                        "be created from them");
            }
            final Object value = objectsIter.next();
            addNewSetMapEntry(newMap,key,value);
        }
        
        /*
         * Check the keys and values are assignable from the specified class
         */
        
        for (Map.Entry<?,?> entry : ((Set<Map.Entry<?,?>>)newMap.entrySet())) {
            if (entry.getKey() != null && keyClass != null) {
                if (!keyClass.isAssignableFrom(entry.getKey().getClass())) {
                    throw new InvalidOperatorCastException(entry.getKey().getClass(), keyClass);
                }
            }
            if (entry.getValue() != null) {
                for (Object valueComponent : (Set<Object>) entry.getValue()) {
                    if (valueComponent != null && valueClass != null) {
                        if (!valueClass.isAssignableFrom(valueComponent.getClass())) {
                            throw new InvalidOperatorCastException(entry.getValue().getClass(), valueClass);
                        }
                    }
                }
            }
        }
        
        return newMap;
        
    }

    
    @SuppressWarnings("unchecked")
    static <T,K,V> Map<K,V[]> buildArrayMapAggregatedTarget(
            final List<T> objects, final Class<K> keyClass, final Class<V> valueClass) {

    	final Type newValueType =
    		(valueClass != null? Types.getRawTypeForClass(valueClass) : Types.OBJECT);
    	
        /*
         * Create the map. Will throw an exception if not possible (e.g. odd number of targets)
         */
        
    	// intentionally raw
        final Map newMap = new LinkedHashMap();
        final Iterator<T> objectsIter = objects.iterator();
        while (objectsIter.hasNext()) {
            final Object key = objectsIter.next();
            if (!objectsIter.hasNext()) {
                throw new ConversionException(
                        "Targets must be in a number divisible by two for a map to " +
                        "be created from them");
            }
            final Object value = objectsIter.next();
            addNewArrayMapEntry(newMap,newValueType,key,value);
        }
        
        /*
         * Check the keys and values are assignable from the specified class
         */
        
        for (Map.Entry<?,?> entry : ((Set<Map.Entry<?,?>>)newMap.entrySet())) {
            if (entry.getKey() != null && keyClass != null) {
                if (!keyClass.isAssignableFrom(entry.getKey().getClass())) {
                    throw new InvalidOperatorCastException(entry.getKey().getClass(), keyClass);
                }
            }
            if (entry.getValue() != null) {
                for (Object valueComponent : (Set<Object>) entry.getValue()) {
                    if (valueComponent != null && valueClass != null) {
                        if (!valueClass.isAssignableFrom(valueComponent.getClass())) {
                            throw new InvalidOperatorCastException(entry.getValue().getClass(), valueClass);
                        }
                    }
                }
            }
        }
        
        return newMap;
        
    }

    
    static <K,V> Map<K,V> buildMapFromMapEntryTargets(
            final List<Map.Entry<K,V>> objects) {
        
        final Map<K,V> newMap = new LinkedHashMap<K,V>();
        for (Map.Entry<K,V> object : objects) {
            if (object == null) {
                throw new NullTargetException("uneachMap");
            }
            addNewMapEntry(newMap, object.getKey(), object.getValue());
        }
        return newMap;
        
    }

    
    static <K,V> Map<K,List<V>> buildListMapFromMapEntryTargets(
            final List<Map.Entry<K,V>> objects) {
        
        final Map<K,List<V>> newMap = new LinkedHashMap<K,List<V>>();
        for (Map.Entry<K,V> object : objects) {
            if (object == null) {
                throw new NullTargetException("uneachListMap");
            }
            addNewListMapEntry(newMap, object.getKey(), object.getValue());
        }
        return newMap;
        
    }

    
    static <K,V> Map<K,Set<V>> buildSetMapFromMapEntryTargets(
            final List<Map.Entry<K,V>> objects) {
        
        final Map<K,Set<V>> newMap = new LinkedHashMap<K,Set<V>>();
        for (Map.Entry<K,V> object : objects) {
            if (object == null) {
                throw new NullTargetException("uneachSetMap");
            }
            addNewSetMapEntry(newMap, object.getKey(), object.getValue());
        }
        return newMap;
        
    }

    
    static <K,V> Map<K,V[]> buildArrayMapFromMapEntryTargets(
            final Type valueType, final List<Map.Entry<K,V>> objects) {
        
        final Map<K,V[]> newMap = new LinkedHashMap<K,V[]>();
        for (Map.Entry<K,V> object : objects) {
            if (object == null) {
                throw new NullTargetException("uneachSetMap");
            }
            addNewArrayMapEntry(newMap, valueType, object.getKey(), object.getValue());
        }
        return newMap;
        
    }
    
    
    
    private static <K,V> void addNewMapEntry(final Map<K,V> newMap, 
            final K key, final V value) {
        if ((newMap.containsKey(key)) &&
                !(
                   (newMap.get(key) == null && value == null) ||
                   (newMap.get(key) != null && newMap.get(key).equals(value))
                 )) {
                throw new DuplicateMapKeyException();
        }
        newMap.put(key, value);
    }
    
    
    @SuppressWarnings("unchecked")
    private static <K,V> void addNewListMapEntry(final Map<K,? extends List<V>> newMap, 
            final K key, final V value) {
        List<V> valuesForKey = newMap.get(key);
        if (valuesForKey == null) {
            valuesForKey = new ArrayList<V>();
            ((Map) newMap).put(key, valuesForKey);
        }
        valuesForKey.add(value);
    }
    
    
    @SuppressWarnings("unchecked")
    private static <K,V> void addNewSetMapEntry(final Map<K,? extends Set<V>> newMap, 
            final K key, final V value) {
        Set<V> valuesForKey = newMap.get(key);
        if (valuesForKey == null) {
            valuesForKey = new LinkedHashSet<V>();
            ((Map) newMap).put(key, valuesForKey);
        }
        valuesForKey.add(value);
    }
    
    
    @SuppressWarnings("unchecked")
    private static <K,V> void addNewArrayMapEntry(final Map<K,V[]> newMap, 
            final Type valueType, final K key, final V value) {
    	
    	/*
    	 * First, compute the list of new values for this key
    	 */
    	
        V[] valuesForKey = newMap.get(key);
        final List<V> newValuesForKeyList = new ArrayList<V>(); 
        if (valuesForKey != null) {
        	newValuesForKeyList.addAll(Arrays.asList(valuesForKey));
        }
        newValuesForKeyList.add(value);

        /*
         * Arrays are special because they are instantiated on a specific class,
         * and as such, the type to be used must be computed BEFORE creating the
         * array itself with the converter.
         */
        
        Type arrayType = null;
        if (valueType == null || valueType.equals(Types.OBJECT)) {
            /*
             * If operatorType is NULL or OBJECT it means that we are at a 
             * either a <?> or an <Object> operator, and this means that 
             * the array type which will be instanced will have to
             * be computed from the types of the target objects
             */
        	arrayType = 
                TypeAggregationUtils.computeMostSpecificCommonClassType(newValuesForKeyList).increaseArrayDimensions();
        } else {
            /*
             * If operatorType is not OBJECT it means that we are at a <T> 
             * operator, and this means that the array type which will be instanced 
             * will be T[]. 
             */
        	arrayType = valueType.increaseArrayDimensions();
        }
        
        V[] valueZeroArray = null;
		try {
			valueZeroArray = (V[]) arrayType.newInstance();
		} catch (InstantiationException e) {
			// this should never happen
			throw new ArrayInstantiationException(arrayType, e);
		} catch (IllegalAccessException e) {
			// this should never happen
			throw new ArrayInstantiationException(arrayType, e);
		}
        final V[] newValuesForKey = newValuesForKeyList.toArray(valueZeroArray); 
        
        newMap.put(key, newValuesForKey);
        
    }
    
    
    
    
    private OperatorAggregationUtils() {
        super();
    }
    
}

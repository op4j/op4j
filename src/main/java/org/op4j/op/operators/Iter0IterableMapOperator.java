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
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.op4j.exceptions.InvalidOperatorCastException;
import org.op4j.exceptions.NullTargetException;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.IterableMapOperator;
import org.op4j.operation.MapTarget;
import org.op4j.operation.Target;
import org.op4j.type.Type;
import org.op4j.type.Types;
import org.op4j.util.TypeAggregationUtils;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Iter0IterableMapOperator<K,V> 
        extends Iter0AbstractOperator<Map<K,V>>
        implements IterableMapOperator<K,V> {

    
    private final Type operatorKeyType;
    private final Type operatorValueType;
    
    

    /*
     *  Targets are created for each object computing intended type as Map<keyType,valueType>.
     *  
     *  Creating the intended type as rawtype (as in generic or array) is not 
     *  appliable here because we cannot guarantee that the real type that
     *  the user intended for the object ListMap is the one we could compute from
     *  its values (Integer extends Number and Integer[] extends Number[], but 
     *  Map<Integer,Integer> does not extend Map<Number,Number>).  
     */
    @SuppressWarnings("unchecked")
    private static MapTarget<?,?> prepareTargets(
            final Type keyType, final Type valueType, 
            final Map<?,?> object) {
        
        return new MapTarget(keyType, valueType, object);
        
    }
    
    
    Iter0IterableMapOperator(final Class<K> operatorKeyClass, final Class<V> operatorValueClass, final Map<?,?> object) {
        this((operatorKeyClass != null? Types.getRawTypeForClass(operatorKeyClass) : null), (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), object);
    }
    
    
    Iter0IterableMapOperator(final Class<K> operatorKeyClass, final Type operatorValueType, final Map<?,?> object) {
        this((operatorKeyClass != null? Types.getRawTypeForClass(operatorKeyClass) : null), operatorValueType, object);
    }
    
    
    Iter0IterableMapOperator(final Type operatorKeyType, final Class<V> operatorValueClass, final Map<?,?> object) {
        this(operatorKeyType, (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), object);
    }
    
    
    @SuppressWarnings("unchecked")
    Iter0IterableMapOperator(
            final Type operatorKeyType, final Type operatorValueType, 
            final Map<?,?> object) {
        
        super((MapTarget) prepareTargets(operatorKeyType, operatorValueType, object));
        this.operatorKeyType = operatorKeyType;
        this.operatorValueType = operatorValueType;
        /*
         * Check that the intended type is always compatible with the operator type.
         */
        checkOperatorType(this.operatorKeyType, this.operatorValueType, getTargets().get(0).getIntendedType());
        
    }

    
    @SuppressWarnings("unchecked")
    Iter0IterableMapOperator(
            final Type operatorKeyType, final Type operatorValueType, 
            final Type keyType, final Type valueType, 
            final Map<?,?> object) {
        
        super((MapTarget) prepareTargets(keyType, valueType, object));
        this.operatorKeyType = operatorKeyType;
        this.operatorValueType = operatorValueType;
        /*
         * Check that the intended type is always compatible with the operator type.
         */
        checkOperatorType(this.operatorKeyType, this.operatorValueType, getTargets().get(0).getIntendedType());
        
    }
    
    
    private static void checkOperatorType(final Type operatorKeyType, final Type operatorValueType, final Type intendedType) {
        final Type operatorType = 
            TypeAggregationUtils.createMapOfType(operatorKeyType, operatorValueType);
        if (!operatorType.isAssignableFrom(intendedType)) {
            throw new InvalidOperatorCastException(operatorType, intendedType);
        }
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<MapTarget<K,V>> getTargets() {
        return (List<MapTarget<K,V>>) getAbstractTargets();
    }
    
    
    final Type getOperatorKeyType() {
        return this.operatorKeyType;
    }
    
    
    final Type getOperatorValueType() {
        return this.operatorValueType;
    }
    
    
    final Iter0IterableMapOperator<?,?> unsafeRaw() {
        return new Iter0IterableMapOperator<Object,Object>(
                (Type) null, (Type) null, getTargetObjects().get(0));
    }
    
    
    public final Iter0IterableMapOperator<?,?> raw() {
        return unsafeRaw();
    }
    
    
    final <X> Iter0IterableMapOperator<K,X> unsafeEachExecUniqValue(
            final Class<X> resultClass, final String operationName, final List<Object> parameters) {
        return unsafeEachEntry().unsafeExecUniqOnValue(resultClass, operationName, parameters).unsafeUneachMap();
    }
    
    
    public final Iter0IterableMapOperator<K,?> eachExecUniqValue(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExecUniqValue(null, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter0IterableMapOperator<K,X> eachExecUniqValue(
            final Class<X> resultClass, final String operationName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExecUniqValue(resultClass, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    

    final <X> Iter0IterableMapOperator<K,X> unsafeEachToValue(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        return unsafeEachEntry().unsafeToOnValue(resultClass, resultType, parameters).unsafeUneachMap();
    }
    

    public final Iter0IterableMapOperator<K,?> eachToValue(
            final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeEachToValue(null, resultType, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final Iter0IterableMapOperator<K,?> eachToValue(
            final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeEachToValue(null, Types.forName(resultTypeName), OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter0IterableMapOperator<K,X> eachToValue(
            final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeEachToValue(resultClass, Types.getRawTypeForClass(resultClass), OperatorUtils.safeEvaluationParameters(parameters));
    }


    final Iter0IterableMapOperator<K,V> unsafeSortKeys() {
        return unsafeSortKeys(null);
    }


    public final Iter0IterableMapOperator<K,V> sortKeys() {
        return unsafeSortKeys();
    }


    final Iter0IterableMapOperator<K,V> unsafeSortKeys(final Comparator<? super K> comparator) {
        
        final MapTarget<K,V> target = getTargets().get(0);
        
        if (areAllTargetsNull()) {
            throw new NullTargetException("sortKeys");
        }
        
        /*
         * This collection is intentionally type-unsafe as we cannot know
         * whether K is Comparable or not until runtime.
         */
        final Map<K,V> targetObject = target.getObject(); 
        final List<K> keyObjectList = new ArrayList<K>(targetObject.keySet());
        Collections.sort(keyObjectList, comparator);
        final Map<K,V> newTargetObject = new LinkedHashMap<K,V>();
        for (K key : keyObjectList) {
            // List is already ordered, so we use its order to order the new map
            newTargetObject.put(key,targetObject.get(key));
        }
        

        return new Iter0IterableMapOperator<K,V>(
                getOperatorKeyType(), getOperatorValueType(),
                target.getMapKeyType(), target.getMapValueType(), 
                newTargetObject);
        
    }


    public final Iter0IterableMapOperator<K,V> sortKeys(final Comparator<? super K> comparator) {
        // Comparator can be null. This is to adhere to the Collections.sort(...) API.
        return unsafeSortKeys(comparator);
    }


    final Iter0IterableMapOperator<K,V> unsafeSortValues() {
        return unsafeSortValues(null);
    }


    public final Iter0IterableMapOperator<K,V> sortValues() {
        return unsafeSortValues();
    }


    final Iter0IterableMapOperator<K,V> unsafeSortValues(final Comparator<? super V> comparator) {
        
        final MapTarget<K,V> target = getTargets().get(0);
        
        if (areAllTargetsNull()) {
            throw new NullTargetException("sortValues");
        }
        
        /*
         * This collection is intentionally type-unsafe as we cannot know
         * whether V is Comparable or not until runtime.
         */
        final Map<K,V> targetObject = target.getObject(); 
        final List<V> valueObjectList = new ArrayList<V>(targetObject.values());
        Collections.sort(valueObjectList, comparator);
        final Map<K,V> newTargetObject = new LinkedHashMap<K,V>();
        for (Object value : valueObjectList) {
            for (Map.Entry<K,V> entry : targetObject.entrySet()) {
                // Object identity must be used here, not equality
                if (entry.getValue() == value) {
                    newTargetObject.put(entry.getKey(), entry.getValue());
                }
            }
        }
        

        return new Iter0IterableMapOperator<K,V>(
                getOperatorKeyType(), getOperatorValueType(),
                target.getMapKeyType(), target.getMapValueType(), 
                newTargetObject);
        
    }


    public final Iter0IterableMapOperator<K,V> sortValues(final Comparator<? super V> comparator) {
        // Comparator can be null. This is to adhere to the Collections.sort(...) API.
        return unsafeSortValues(comparator);
    }
    
    
    final Iter1GenericUniqTargetOperator<V> unsafeEachValue() {
        final Map<K,V> targetObject = getTargetObjects().get(0);
        final List<Iter0GenericUniqTargetOperator<V>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<V>>();
        for (V componentObj : targetObject.values()) {
            components.add(new Iter0GenericUniqTargetOperator<V>(getOperatorValueType(), componentObj));
        }
        return new Iter1GenericUniqTargetOperator<V>(getOperatorValueType(), components);
    }
    
    
    public final Iter1GenericUniqTargetOperator<V> eachValue() {
        return unsafeEachValue();
    }
    
    
    final Iter1GenericUniqTargetOperator<K> unsafeEachKey() {
        final Map<K,V> targetObject = getTargetObjects().get(0);
        final List<Iter0GenericUniqTargetOperator<K>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<K>>();
        for (K componentObj : targetObject.keySet()) {
            components.add(new Iter0GenericUniqTargetOperator<K>(getOperatorKeyType(), componentObj));
        }
        return new Iter1GenericUniqTargetOperator<K>(getOperatorKeyType(), components);
    }
    
    
    public final Iter1GenericUniqTargetOperator<K> eachKey() {
        return unsafeEachKey();
    }
    
    
    final Iter1MapEntryOperator<K,V> unsafeEachEntry() {
        final Map<K,V> targetObject = getTargetObjects().get(0);
        final List<Iter0MapEntryOperator<K,V>> components = 
            new ArrayList<Iter0MapEntryOperator<K,V>>();
        for (Map.Entry<K,V> componentObj : targetObject.entrySet()) {
            components.add(new Iter0MapEntryOperator<K,V>(
                    getOperatorKeyType(), getOperatorValueType(), componentObj));
        }
        return new Iter1MapEntryOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }
    
    
    public final Iter1MapEntryOperator<K,V> eachEntry() {
        return unsafeEachEntry();
    }


    final <X,Y> Iter0IterableListMapOperator<X,Y> unsafeAsListMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        // Note that "as" operations make casts dissapear
        return unsafeGeneric().asListMap(keyClass, valueClass);
    }


    public final <X,Y> Iter0IterableListMapOperator<X,Y> asListMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsListMap(keyClass,valueClass);
    }


    final <X,Y> Iter0IterableSetMapOperator<X,Y> unsafeAsSetMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        // Note that "as" operations make casts dissapear
        return unsafeGeneric().asSetMap(keyClass, valueClass);
    }


    public final <X,Y> Iter0IterableSetMapOperator<X,Y> asSetMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsSetMap(keyClass,valueClass);
    }


    final <X,Y> Iter0IterableMapOperator<X,Y> unsafeAsMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        // Note that "as" operations make casts dissapear
        return unsafeGeneric().asMap(keyClass, valueClass);
    }


    public final <X,Y> Iter0IterableMapOperator<X,Y> asMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsMap(keyClass,valueClass);
    }


    @SuppressWarnings("unchecked")
    final Iter0GenericUniqTargetOperator<Map<K,V>> unsafeGeneric() {
        final Target<? extends Map<?,?>> target = getTargets().get(0);
        return new Iter0GenericUniqTargetOperator(
                TypeAggregationUtils.createMapOfType(getOperatorKeyType(), getOperatorValueType()),
                target.getIntendedType(),
                target.getObject());
    }

    
    public final Iter0GenericUniqTargetOperator<Map<K,V>> generic() {
        return unsafeGeneric();
    }


    final Iter0IterableMapOperator<K,V> unsafeEachFilterEntry(
            final String expression, final List<Object> parameters) {
        if (areAllTargetsNull()) {
            throw new NullTargetException("eachFilterEntry");
        }
        return unsafeEachEntry().unsafeFilter(expression, parameters).unsafeUneachMap();
    }

    
    final Iter0IterableMapOperator<K,V> unsafeEachFilterEntry(final Filter<Map.Entry<K,V>> filter) {
        if (areAllTargetsNull()) {
            throw new NullTargetException("eachFilterEntry");
        }
        return unsafeEachEntry().unsafeFilter(filter).unsafeUneachMap();
    }


    public final Iter0IterableMapOperator<K,V> eachFilterEntry(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeEachFilterEntry(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

        
    public final Iter0IterableMapOperator<K,V> eachFilterEntry(final Filter<Map.Entry<K,V>> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeEachFilterEntry(filter);
    }


    final Iter0IterableSetOperator<K> unsafeKeySet() {
        
        final MapTarget<K,V> oldTarget = getTargets().get(0);
        if (areAllTargetsNull()) {
            throw new NullTargetException("keys");
        }
        final Set<K> newObject = new LinkedHashSet<K>(oldTarget.getObject().keySet());
        
        return new Iter0IterableSetOperator<K>(
                getOperatorKeyType(),
                oldTarget.getMapKeyType(),
                newObject);
        
    }


    public final Iter0IterableSetOperator<K> keySet() {
        return unsafeKeySet();
    }


    final Iter0IterableListOperator<V> unsafeValues() {
        
        final MapTarget<K,V> oldTarget = getTargets().get(0);
        if (areAllTargetsNull()) {
            throw new NullTargetException("values");
        }
        final List<V> newObject = new ArrayList<V>(oldTarget.getObject().values());
        
        return new Iter0IterableListOperator<V>(
                getOperatorValueType(),
                oldTarget.getMapValueType(),
                newObject);
        
    }


    public final Iter0IterableListOperator<V> values() {
        return unsafeValues();
    }

    
    final <X> Iter0IterableMapOperator<K,X> unsafeEachEvalValue(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        return unsafeEachEntry().unsafeEvalOnValue(resultClass, expression, parameters).unsafeUneachMap();
    }

    
    final <X> Iter0IterableMapOperator<K,X> unsafeEachEvalValue(
            final Class<X> resultClass, final Evaluator<V,X> evaluator) {
        return unsafeEachEntry().unsafeEvalOnValue(resultClass, evaluator).unsafeUneachMap();
    }

    
    public final Iter0IterableMapOperator<K,?> eachEvalValue(
            final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEvalValue(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter0IterableMapOperator<K,X> eachEvalValue(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Return class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEvalValue(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter0IterableMapOperator<K,X> eachEvalValue(
            final Class<X> resultClass, final Evaluator<V,X> evaluator) {
        Validate.notNull(resultClass, "Class cannot be null");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEvalValue(resultClass, evaluator);
    }

    
    public final Iter0IterableMapOperator<K,?> eachEvalValue(
            final Evaluator<V,Object> evaluator) {
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEvalValue(null, evaluator);
    }
    

    final <X> Iter0IterableMapOperator<K,X> unsafeEachCallValue(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        if (areAllTargetsNull()) {
            throw new NullTargetException("eachCall");
        }
        return unsafeEachEntry().unsafeCallOnValue(resultClass, methodName, arguments).unsafeUneachMap();
    }
    

    public final Iter0IterableMapOperator<K,?> eachCallValue(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCallValue(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter0IterableMapOperator<K,X> eachCallValue(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Return class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCallValue(resultClass, methodName,OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final Map<K,V> get() {
        return getTargetObjects().get(0);
    }
    

    public final <X,Y> Map<X,Y> get(Class<X> keyClass, Class<Y> valueClass) {
        return unsafeAsMap(keyClass,valueClass).getTargetObjects().get(0);
    }
    
    
}

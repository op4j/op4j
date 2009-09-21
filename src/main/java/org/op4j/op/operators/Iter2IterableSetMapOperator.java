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
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.IterableSetMapIteratingOperator;
import org.op4j.op.interfaces.MapBuilder;
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
public final class Iter2IterableSetMapOperator<K,V> 
        extends Iter2AbstractOperator<Map<K,Set<V>>>
        implements IterableSetMapIteratingOperator<K,V> {

    
    private final Type operatorKeyType;
    private final Type operatorValueType;
    

    Iter2IterableSetMapOperator(
            final Type operatorKeyType, final Type operatorValueType, final List<Iter1IterableSetMapOperator<K,V>> iterationComponents) {
        super(iterationComponents);
        this.operatorKeyType = operatorKeyType;
        this.operatorValueType = operatorValueType;
    }
    
    
    Iter2IterableSetMapOperator(final Class<K> operatorKeyClass, final Class<V> operatorValueClass, final List<Iter1IterableSetMapOperator<K,V>> iterationComponents) {
        this((operatorKeyClass != null? Types.getRawTypeForClass(operatorKeyClass) : null), (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), iterationComponents);
    }
    
    
    Iter2IterableSetMapOperator(final Class<K> operatorKeyClass, final Type operatorValueType, final List<Iter1IterableSetMapOperator<K,V>> iterationComponents) {
        this((operatorKeyClass != null? Types.getRawTypeForClass(operatorKeyClass) : null), operatorValueType, iterationComponents);
    }
    
    
    Iter2IterableSetMapOperator(final Type operatorKeyType, final Class<V> operatorValueClass, final List<Iter1IterableSetMapOperator<K,V>> iterationComponents) {
        this(operatorKeyType, (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), iterationComponents);
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<Iter1IterableSetMapOperator<K,V>> getTargets() {
        return (List<Iter1IterableSetMapOperator<K,V>>) getAbstractTargets();
    }
    
    
    final Type getOperatorKeyType() {
        return this.operatorKeyType;
    }
    
    
    final Type getOperatorValueType() {
        return this.operatorValueType;
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter2IterableSetMapOperator<?,?> unsafeRaw() {
        final List<Iter1IterableSetMapOperator<?,?>> components = 
            new ArrayList<Iter1IterableSetMapOperator<?,?>>();
        for (Iter1IterableSetMapOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeRaw());
        }
        return new Iter2IterableSetMapOperator((Type) null, (Type) null, components);
    }
    
    
    public final Iter2IterableSetMapOperator<?,?> raw() {
        return unsafeRaw();
    }
    

    final <X> Iter2IterableSetMapOperator<K,X> unsafeEachExecUniqValue(
            final Class<X> resultClass, final String operationName, final List<Object> parameters) {
        final List<Iter1IterableSetMapOperator<K,X>> components = 
            new ArrayList<Iter1IterableSetMapOperator<K,X>>();
        for (Iter1IterableSetMapOperator<K,V> target : getTargets()) {
            components.add(target.unsafeEachExecUniqValue(resultClass, operationName, parameters));
        }
        return new Iter2IterableSetMapOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }
    

    public final Iter2IterableSetMapOperator<K,?> eachExecUniqValue(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExecUniqValue(null, operationName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter2IterableSetMapOperator<K,X> eachExecUniqValue(
            final Class<X> resultClass, final String operationName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExecUniqValue(resultClass, operationName, OperatorUtils.safeEvaluationParameters(parameters));
    }


    final Iter2IterableSetMapOperator<K,V> unsafeSortKeys() {
        return unsafeSortKeys(null);
    }


    public final Iter2IterableSetMapOperator<K,V> sortKeys() {
        return unsafeSortKeys();
    }


    final Iter2IterableSetMapOperator<K,V> unsafeSortKeys(final Comparator<? super K> comparator) {
        final List<Iter1IterableSetMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableSetMapOperator<K,V>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeSortKeys(comparator));
        }
        return new Iter2IterableSetMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }


    public final Iter2IterableSetMapOperator<K,V> sortKeys(final Comparator<? super K> comparator) {
        // Comparator can be null. This is to adhere to the Collections.sort(...) API.
        return unsafeSortKeys(comparator);
    }


    final Iter2IterableSetMapOperator<K,V> unsafeSortValueSets() {
        return unsafeSortValueSets(null);
    }


    public final Iter2IterableSetMapOperator<K,V> sortValueSets() {
        return unsafeSortValueSets();
    }


    final Iter2IterableSetMapOperator<K,V> unsafeSortValueSets(final Comparator<? super V> comparator) {
        final List<Iter1IterableSetMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableSetMapOperator<K,V>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeSortValueSets(comparator));
        }
        return new Iter2IterableSetMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }


    public final Iter2IterableSetMapOperator<K,V> sortValueSets(final Comparator<? super V> comparator) {
        // Comparator can be null. This is to adhere to the Collections.sort(...) API.
        return unsafeSortValueSets(comparator);
    }
    
    
    final Iter3GenericUniqTargetOperator<V> unsafeEachValue() {
        final List<Iter2GenericUniqTargetOperator<V>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<V>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachValue());
        }
        return new Iter3GenericUniqTargetOperator<V>(getOperatorValueType(), components);
    }
    
    
    public final Iter3GenericUniqTargetOperator<V> eachValue() {
        return unsafeEachValue();
    }
    
    
    final Iter3GenericUniqTargetOperator<K> unsafeEachKey() {
        final List<Iter2GenericUniqTargetOperator<K>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<K>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachKey());
        }
        return new Iter3GenericUniqTargetOperator<K>(getOperatorKeyType(), components);
    }
    
    
    public final Iter3GenericUniqTargetOperator<K> eachKey() {
        return unsafeEachKey();
    }
    
    
    final Iter3MapEntryOperator<K,V> unsafeEachEntry() {
        final List<Iter2MapEntryOperator<K,V>> components = 
            new ArrayList<Iter2MapEntryOperator<K,V>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachEntry());
        }
        return new Iter3MapEntryOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }
    
    
    public final Iter3MapEntryOperator<K,V> eachEntry() {
        return unsafeEachEntry();
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter3GenericUniqTargetOperator<Set<V>> unsafeEachSetValue() {
        final List<Iter2GenericUniqTargetOperator<Set<V>>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<Set<V>>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachSetValue());
        }
        return new Iter3GenericUniqTargetOperator(TypeAggregationUtils.createListOfType(getOperatorValueType()), components);
    }
    
    
    public final Iter3GenericUniqTargetOperator<Set<V>> eachSetValue() {
        return unsafeEachSetValue();
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter3MapEntryOperator<K,Set<V>> unsafeEachSetEntry() {
        final List<Iter2MapEntryOperator<K,Set<V>>> components = 
            new ArrayList<Iter2MapEntryOperator<K,Set<V>>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachSetEntry());
        }
        return new Iter3MapEntryOperator(getOperatorKeyType(), TypeAggregationUtils.createListOfType(getOperatorValueType()), components);
    }
    
    
    public final Iter3MapEntryOperator<K,Set<V>> eachSetEntry() {
        return unsafeEachSetEntry();
    }


    final <X,Y> Iter2IterableSetMapOperator<X,Y> unsafeAsSetMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        final List<Iter1IterableSetMapOperator<X,Y>> components = 
            new ArrayList<Iter1IterableSetMapOperator<X,Y>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeAsSetMap(keyClass,valueClass));
        }
        return new Iter2IterableSetMapOperator<X,Y>(keyClass, valueClass, components);
    }


    public final <X,Y> Iter2IterableSetMapOperator<X,Y> asSetMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsSetMap(keyClass,valueClass);
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter2GenericUniqTargetOperator<Map<K,Set<V>>> unsafeGeneric() {
        final List<Iter1GenericUniqTargetOperator<Map<K,Set<V>>>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<Map<K,Set<V>>>>();
        for (Iter1IterableSetMapOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeGeneric());
        }
        return new Iter2GenericUniqTargetOperator(TypeAggregationUtils.createListMapOfType(getOperatorKeyType(), getOperatorValueType()), components);
    }
    
    
    public final Iter2GenericUniqTargetOperator<Map<K,Set<V>>> generic() {
        return unsafeGeneric();
    }


    public final Iter1IterableArrayOperator<Map<K,Set<V>>> uneachArray() {
        return unsafeGeneric().unsafeUneachArray();
    }


    public final Iter1IterableListOperator<Map<K,Set<V>>> uneachList() {
        return unsafeGeneric().unsafeUneachList();
    }


    public final Iter1IterableSetOperator<Map<K,Set<V>>> uneachSet() {
        return unsafeGeneric().unsafeUneachSet();
    }
    
    
    public final Iter1IterableMapOperator<?,Map<K,Set<V>>> uneachMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X> Iter1IterableMapOperator<X,Map<K,Set<V>>> uneachMap(
            final Class<X> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final Iter1IterableMapOperator<?,?> uneachMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X,Y> Iter1IterableMapOperator<X,Y> uneachMap(
            final Class<X> keyClass, final Class<Y> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final <X,Y> Iter1IterableMapOperator<X,Y> uneachMap(
            final Class<X> keyClass, final Class<Y> valueClass, final MapBuilder<Map<K,Set<V>>,X,Y> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter1IterableMapOperator<?,?> uneachMap(
            final MapBuilder<Map<K,Set<V>>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachMap(null, null, mapBuilder);
    }
    
    
    public final Iter1IterableListMapOperator<?,Map<K,Set<V>>> uneachListMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachListMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X> Iter1IterableListMapOperator<X,Map<K,Set<V>>> uneachListMap(
            final Class<X> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachListMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final Iter1IterableListMapOperator<?,?> uneachListMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachListMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X,Y> Iter1IterableListMapOperator<X,Y> uneachListMap(
            final Class<X> keyClass, final Class<Y> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachListMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final <X,Y> Iter1IterableListMapOperator<X,Y> uneachListMap(
            final Class<X> keyClass, final Class<Y> valueClass, final MapBuilder<Map<K,Set<V>>,X,Y> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachListMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter1IterableListMapOperator<?,?> uneachListMap(
            final MapBuilder<Map<K,Set<V>>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachListMap(null, null, mapBuilder);
    }


    public final Iter1IterableSetMapOperator<?,Map<K,Set<V>>> uneachSetMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X> Iter1IterableSetMapOperator<X,Map<K,Set<V>>> uneachSetMap(
            final Class<X> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final Iter1IterableSetMapOperator<?,?> uneachSetMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X,Y> Iter1IterableSetMapOperator<X,Y> uneachSetMap(
            final Class<X> keyClass, final Class<Y> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final <X,Y> Iter1IterableSetMapOperator<X,Y> uneachSetMap(
            final Class<X> keyClass, final Class<Y> valueClass, final MapBuilder<Map<K,Set<V>>,X,Y> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter1IterableSetMapOperator<?,?> uneachSetMap(
            final MapBuilder<Map<K,Set<V>>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(null, null, mapBuilder);
    }
    

    final Iter2IterableSetMapOperator<K,V> unsafeEachFilterEntry(
            final String expression, final List<Object> parameters) {
        final List<Iter1IterableSetMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableSetMapOperator<K,V>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachFilterEntry(expression, parameters));
        }
        return new Iter2IterableSetMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }

    
    final Iter2IterableSetMapOperator<K,V> unsafeEachFilterEntry(final Filter<Map.Entry<K,V>> filter) {
        final List<Iter1IterableSetMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableSetMapOperator<K,V>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachFilterEntry(filter));
        }
        return new Iter2IterableSetMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }


    public final Iter2IterableSetMapOperator<K,V> eachFilterEntry(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeEachFilterEntry(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

        
    public final Iter2IterableSetMapOperator<K,V> eachFilterEntry(final Filter<Map.Entry<K,V>> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeEachFilterEntry(filter);
    }

    
    final Iter2IterableSetOperator<K> unsafeKeySet() {
        final List<Iter1IterableSetOperator<K>> components = 
            new ArrayList<Iter1IterableSetOperator<K>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeKeySet());
        }
        return new Iter2IterableSetOperator<K>(getOperatorKeyType(), components);
    }


    public final Iter2IterableSetOperator<K> keySet() {
        return unsafeKeySet();
    }


    final Iter2IterableListOperator<Set<V>> unsafeValues() {
        final List<Iter1IterableListOperator<Set<V>>> components = 
            new ArrayList<Iter1IterableListOperator<Set<V>>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeValues());
        }
        return new Iter2IterableListOperator<Set<V>>(TypeAggregationUtils.createListOfType(getOperatorValueType()), components);
    }


    public final Iter2IterableListOperator<Set<V>> values() {
        return unsafeValues();
    }


    final Iter2IterableSetOperator<V> unsafeValuesForKey(final K key) {
        final List<Iter1IterableSetOperator<V>> components = 
            new ArrayList<Iter1IterableSetOperator<V>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeValuesForKey(key));
        }
        return new Iter2IterableSetOperator<V>(getOperatorValueType(), components);
    }


    public final Iter2IterableSetOperator<V> valuesForKey(final K key) {
        // We should not check nullity of key as some implementations might allow it 
        return unsafeValuesForKey(key);
    }


    final Iter2IterableSetOperator<V> unsafeValuesForAllKeys() {
        final List<Iter1IterableSetOperator<V>> components = 
            new ArrayList<Iter1IterableSetOperator<V>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeValuesForAllKeys());
        }
        return new Iter2IterableSetOperator<V>(getOperatorValueType(), components);
    }


    public final Iter2IterableSetOperator<V> valuesForAllKeys() {
        return unsafeValuesForAllKeys();
    }


    final <X> Iter2IterableMapOperator<K,X> unsafeMergeValues(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        final List<Iter1IterableMapOperator<K,X>> components = 
            new ArrayList<Iter1IterableMapOperator<K,X>>();
        for (Iter1IterableSetMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeMergeValues(resultClass, expression, parameters));
        }
        return new Iter2IterableMapOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }


    public final Iter2IterableMapOperator<K,?> mergeValues(final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeMergeValues(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter2IterableMapOperator<K,X> mergeValues(final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Class cannot be null");
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeMergeValues(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <X> Iter2IterableSetMapOperator<K,X> unsafeEachEvalValue(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        final List<Iter1IterableSetMapOperator<K,X>> components = 
            new ArrayList<Iter1IterableSetMapOperator<K,X>>();
        for (Iter1IterableSetMapOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEachEvalValue(resultClass, expression, parameters));
        }
        return new Iter2IterableSetMapOperator<K,X>(
                getOperatorKeyType(), resultClass, components);
    }

    
    final <X> Iter2IterableSetMapOperator<K,X> unsafeEachEvalValue(
            final Class<X> resultClass, final Evaluator<V,X> evaluator) {
        final List<Iter1IterableSetMapOperator<K,X>> components = 
            new ArrayList<Iter1IterableSetMapOperator<K,X>>();
        for (Iter1IterableSetMapOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEachEvalValue(resultClass, evaluator));
        }
        return new Iter2IterableSetMapOperator<K,X>(
                getOperatorKeyType(), resultClass, components);
    }

    
    public final Iter2IterableSetMapOperator<K,?> eachEvalValue(final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEvalValue(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter2IterableSetMapOperator<K,X> eachEvalValue(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEvalValue(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter2IterableSetMapOperator<K,X> eachEvalValue(
            Class<X> resultClass, final Evaluator<V,X> evaluator) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEvalValue(resultClass, evaluator);
    }

    
    public final Iter2IterableSetMapOperator<K,?> eachEvalValue(
            final Evaluator<V,Object> evaluator) {
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEvalValue(null, evaluator);
    }
    

    final <X> Iter2IterableSetMapOperator<K,X> unsafeEachCallValue(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        final List<Iter1IterableSetMapOperator<K,X>> components = 
            new ArrayList<Iter1IterableSetMapOperator<K,X>>();
        for (Iter1IterableSetMapOperator<K,V> target : getTargets()) {
            components.add(target.unsafeEachCallValue(resultClass, methodName, arguments));
        }
        return new Iter2IterableSetMapOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }
    

    public final Iter2IterableSetMapOperator<K,?> eachCallValue(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCallValue(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter2IterableSetMapOperator<K,X> eachCallValue(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Return class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCallValue(resultClass, methodName,OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    final <X> Iter2IterableSetMapOperator<K,X> unsafeEachToValue(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        final List<Iter1IterableSetMapOperator<K,X>> components = 
            new ArrayList<Iter1IterableSetMapOperator<K,X>>();
        for (Iter1IterableSetMapOperator<K,V> target : getTargets()) {
            components.add(target.unsafeEachToValue(resultClass, resultType, parameters));
        }
        return new Iter2IterableSetMapOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }
    

    public final Iter2IterableSetMapOperator<K,?> eachToValue(
            final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeEachToValue(null, resultType, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final Iter2IterableSetMapOperator<K,?> eachToValue(
            final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeEachToValue(null, Types.forName(resultTypeName), OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter2IterableSetMapOperator<K,X> eachToValue(
            final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeEachToValue(resultClass, Types.getRawTypeForClass(resultClass), OperatorUtils.safeEvaluationParameters(parameters));
    }

    
}

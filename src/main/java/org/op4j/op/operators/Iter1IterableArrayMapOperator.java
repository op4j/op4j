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

import org.apache.commons.lang.Validate;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.IterableArrayMapIteratingOperator;
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
public final class Iter1IterableArrayMapOperator<K,V> 
        extends Iter1AbstractOperator<Map<K,V[]>>
        implements IterableArrayMapIteratingOperator<K,V> {

    
    private final Type operatorKeyType;
    private final Type operatorValueType;
    

    Iter1IterableArrayMapOperator(
            final Type operatorKeyType, final Type operatorValueType, final List<Iter0IterableArrayMapOperator<K,V>> iterationComponents) {
        super(iterationComponents);
        this.operatorKeyType = operatorKeyType;
        this.operatorValueType = operatorValueType;
    }
    
    
    Iter1IterableArrayMapOperator(final Class<K> operatorKeyClass, final Class<V> operatorValueClass, final List<Iter0IterableArrayMapOperator<K,V>> iterationComponents) {
        this((operatorKeyClass != null? Types.getRawTypeForClass(operatorKeyClass) : null), (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), iterationComponents);
    }
    
    
    Iter1IterableArrayMapOperator(final Class<K> operatorKeyClass, final Type operatorValueType, final List<Iter0IterableArrayMapOperator<K,V>> iterationComponents) {
        this((operatorKeyClass != null? Types.getRawTypeForClass(operatorKeyClass) : null), operatorValueType, iterationComponents);
    }
    
    
    Iter1IterableArrayMapOperator(final Type operatorKeyType, final Class<V> operatorValueClass, final List<Iter0IterableArrayMapOperator<K,V>> iterationComponents) {
        this(operatorKeyType, (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), iterationComponents);
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<Iter0IterableArrayMapOperator<K,V>> getTargets() {
        return (List<Iter0IterableArrayMapOperator<K,V>>) getAbstractTargets();
    }
    
    
    final Type getOperatorKeyType() {
        return this.operatorKeyType;
    }
    
    
    final Type getOperatorValueType() {
        return this.operatorValueType;
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter1IterableArrayMapOperator<?,?> unsafeRaw() {
        final List<Iter0IterableArrayMapOperator<?,?>> components = 
            new ArrayList<Iter0IterableArrayMapOperator<?,?>>();
        for (Iter0IterableArrayMapOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeRaw());
        }
        return new Iter1IterableArrayMapOperator((Type) null, (Type) null, components);
    }
    
    
    public final Iter1IterableArrayMapOperator<?,?> raw() {
        return unsafeRaw();
    }
    

    final <X> Iter1IterableArrayMapOperator<K,X> unsafeEachValueExec(
            final Class<X> resultClass, final String operationName, final List<Object> parameters) {
        final List<Iter0IterableArrayMapOperator<K,X>> components = 
            new ArrayList<Iter0IterableArrayMapOperator<K,X>>();
        for (Iter0IterableArrayMapOperator<K,V> target : getTargets()) {
            components.add(target.unsafeEachValueExec(resultClass, operationName, parameters));
        }
        return new Iter1IterableArrayMapOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }
    

    public final Iter1IterableArrayMapOperator<K,?> eachValueExec(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachValueExec(null, operationName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter1IterableArrayMapOperator<K,X> eachValueExec(
            final Class<X> resultClass, final String operationName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachValueExec(resultClass, operationName, OperatorUtils.safeEvaluationParameters(parameters));
    }


    final Iter1IterableArrayMapOperator<K,V> unsafeSortKeys() {
        return unsafeSortKeys(null);
    }


    public final Iter1IterableArrayMapOperator<K,V> sortKeys() {
        return unsafeSortKeys();
    }


    final Iter1IterableArrayMapOperator<K,V> unsafeSortKeys(final Comparator<? super K> comparator) {
        final List<Iter0IterableArrayMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableArrayMapOperator<K,V>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeSortKeys(comparator));
        }
        return new Iter1IterableArrayMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }


    public final Iter1IterableArrayMapOperator<K,V> sortKeys(final Comparator<? super K> comparator) {
        // Comparator can be null. This is to adhere to the Collections.sort(...) API.
        return unsafeSortKeys(comparator);
    }


    final Iter1IterableArrayMapOperator<K,V> unsafeSortValueArrays() {
        return unsafeSortValueArrays(null);
    }


    public final Iter1IterableArrayMapOperator<K,V> sortValueArrays() {
        return unsafeSortValueArrays();
    }


    final Iter1IterableArrayMapOperator<K,V> unsafeSortValueArrays(final Comparator<? super V> comparator) {
        final List<Iter0IterableArrayMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableArrayMapOperator<K,V>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeSortValueArrays(comparator));
        }
        return new Iter1IterableArrayMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }


    public final Iter1IterableArrayMapOperator<K,V> sortValueArrays(final Comparator<? super V> comparator) {
        // Comparator can be null. This is to adhere to the Collections.sort(...) API.
        return unsafeSortValueArrays(comparator);
    }
    
    
    final Iter2GenericUniqTargetOperator<V> unsafeEachValue() {
        final List<Iter1GenericUniqTargetOperator<V>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<V>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachValue());
        }
        return new Iter2GenericUniqTargetOperator<V>(getOperatorValueType(), components);
    }
    
    
    public final Iter2GenericUniqTargetOperator<V> eachValue() {
        return unsafeEachValue();
    }
    
    
    final Iter2GenericUniqTargetOperator<K> unsafeEachKey() {
        final List<Iter1GenericUniqTargetOperator<K>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<K>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachKey());
        }
        return new Iter2GenericUniqTargetOperator<K>(getOperatorKeyType(), components);
    }
    
    
    public final Iter2GenericUniqTargetOperator<K> eachKey() {
        return unsafeEachKey();
    }
    
    
    final Iter2MapEntryOperator<K,V> unsafeEachEntry() {
        final List<Iter1MapEntryOperator<K,V>> components = 
            new ArrayList<Iter1MapEntryOperator<K,V>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachEntry());
        }
        return new Iter2MapEntryOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }
    
    
    public final Iter2MapEntryOperator<K,V> eachEntry() {
        return unsafeEachEntry();
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter2GenericUniqTargetOperator<V[]> unsafeEachArrayValue() {
        final List<Iter1GenericUniqTargetOperator<V[]>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<V[]>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachArrayValue());
        }
        return new Iter2GenericUniqTargetOperator(TypeAggregationUtils.createArrayOfType(getOperatorValueType()), components);
    }
    
    
    public final Iter2GenericUniqTargetOperator<V[]> eachArrayValue() {
        return unsafeEachArrayValue();
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter2MapEntryOperator<K,V[]> unsafeEachArrayEntry() {
        final List<Iter1MapEntryOperator<K,V[]>> components = 
            new ArrayList<Iter1MapEntryOperator<K,V[]>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachArrayEntry());
        }
        return new Iter2MapEntryOperator(getOperatorKeyType(), TypeAggregationUtils.createArrayOfType(getOperatorValueType()), components);
    }
    
    
    public final Iter2MapEntryOperator<K,V[]> eachArrayEntry() {
        return unsafeEachArrayEntry();
    }


    final <X,Y> Iter1IterableArrayMapOperator<X,Y> unsafeAsArrayMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        final List<Iter0IterableArrayMapOperator<X,Y>> components = 
            new ArrayList<Iter0IterableArrayMapOperator<X,Y>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeAsArrayMap(keyClass,valueClass));
        }
        return new Iter1IterableArrayMapOperator<X,Y>(keyClass, valueClass, components);
    }


    public final <X,Y> Iter1IterableArrayMapOperator<X,Y> asArrayMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsArrayMap(keyClass,valueClass);
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter1GenericUniqTargetOperator<Map<K,V[]>> unsafeGeneric() {
        final List<Iter0GenericUniqTargetOperator<Map<K,V[]>>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<Map<K,V[]>>>();
        for (Iter0IterableArrayMapOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeGeneric());
        }
        return new Iter1GenericUniqTargetOperator(TypeAggregationUtils.createSetMapOfType(getOperatorKeyType(), getOperatorValueType()), components);
    }
    
    
    public final Iter1GenericUniqTargetOperator<Map<K,V[]>> generic() {
        return unsafeGeneric();
    }


    public final Iter0IterableArrayOperator<Map<K,V[]>> uneachArray() {
        return unsafeGeneric().unsafeUneachArray();
    }


    public final Iter0IterableListOperator<Map<K,V[]>> uneachList() {
        return unsafeGeneric().unsafeUneachList();
    }


    public final Iter0IterableSetOperator<Map<K,V[]>> uneachSet() {
        return unsafeGeneric().unsafeUneachSet();
    }
    
    
    public final Iter0IterableMapOperator<?,Map<K,V[]>> uneachMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X> Iter0IterableMapOperator<X,Map<K,V[]>> uneachMap(
            final Class<X> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final Iter0IterableMapOperator<?,?> uneachMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X,Y> Iter0IterableMapOperator<X,Y> uneachMap(
            final Class<X> keyClass, final Class<Y> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final <X,Y> Iter0IterableMapOperator<X,Y> uneachMap(
            final Class<X> keyClass, final Class<Y> valueClass, final MapBuilder<Map<K,V[]>,X,Y> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter0IterableMapOperator<?,?> uneachMap(
            final MapBuilder<Map<K,V[]>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachMap(null, null, mapBuilder);
    }
    
    
    public final Iter0IterableListMapOperator<?,Map<K,V[]>> uneachListMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachListMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X> Iter0IterableListMapOperator<X,Map<K,V[]>> uneachListMap(
            final Class<X> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachListMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final Iter0IterableListMapOperator<?,?> uneachListMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachListMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X,Y> Iter0IterableListMapOperator<X,Y> uneachListMap(
            final Class<X> keyClass, final Class<Y> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachListMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final <X,Y> Iter0IterableListMapOperator<X,Y> uneachListMap(
            final Class<X> keyClass, final Class<Y> valueClass, final MapBuilder<Map<K,V[]>,X,Y> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachListMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter0IterableListMapOperator<?,?> uneachListMap(
            final MapBuilder<Map<K,V[]>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachListMap(null, null, mapBuilder);
    }
    
    
    public final Iter0IterableSetMapOperator<?,Map<K,V[]>> uneachSetMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X> Iter0IterableSetMapOperator<X,Map<K,V[]>> uneachSetMap(
            final Class<X> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final Iter0IterableSetMapOperator<?,?> uneachSetMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X,Y> Iter0IterableSetMapOperator<X,Y> uneachSetMap(
            final Class<X> keyClass, final Class<Y> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final <X,Y> Iter0IterableSetMapOperator<X,Y> uneachSetMap(
            final Class<X> keyClass, final Class<Y> valueClass, final MapBuilder<Map<K,V[]>,X,Y> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter0IterableSetMapOperator<?,?> uneachSetMap(
            final MapBuilder<Map<K,V[]>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(null, null, mapBuilder);
    }
    
    
    public final Iter0IterableArrayMapOperator<?,Map<K,V[]>> uneachArrayMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachArrayMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X> Iter0IterableArrayMapOperator<X,Map<K,V[]>> uneachArrayMap(
            final Class<X> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachArrayMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final Iter0IterableArrayMapOperator<?,?> uneachArrayMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachArrayMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X,Y> Iter0IterableArrayMapOperator<X,Y> uneachArrayMap(
            final Class<X> keyClass, final Class<Y> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachArrayMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final <X,Y> Iter0IterableArrayMapOperator<X,Y> uneachArrayMap(
            final Class<X> keyClass, final Class<Y> valueClass, final MapBuilder<Map<K,V[]>,X,Y> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachArrayMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter0IterableArrayMapOperator<?,?> uneachArrayMap(
            final MapBuilder<Map<K,V[]>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachArrayMap(null, null, mapBuilder);
    }
    
    

    final Iter1IterableArrayMapOperator<K,V> unsafeEachFilterEntry(
            final String expression, final List<Object> parameters) {
        final List<Iter0IterableArrayMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableArrayMapOperator<K,V>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachFilterEntry(expression, parameters));
        }
        return new Iter1IterableArrayMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }

    
    final Iter1IterableArrayMapOperator<K,V> unsafeEachFilterEntry(final Filter<Map.Entry<K,V>> filter) {
        final List<Iter0IterableArrayMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableArrayMapOperator<K,V>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachFilterEntry(filter));
        }
        return new Iter1IterableArrayMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }


    public final Iter1IterableArrayMapOperator<K,V> eachFilterEntry(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeEachFilterEntry(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

        
    public final Iter1IterableArrayMapOperator<K,V> eachFilterEntry(final Filter<Map.Entry<K,V>> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeEachFilterEntry(filter);
    }

    
    final Iter1IterableArrayMapOperator<K,V> unsafeDistinct() {
        final List<Iter0IterableArrayMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableArrayMapOperator<K,V>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeDistinct());
        }
        return new Iter1IterableArrayMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }


    public final Iter1IterableArrayMapOperator<K,V> distinct() {
        return unsafeDistinct();
    }


    final Iter1IterableSetOperator<K> unsafeKeySet() {
        final List<Iter0IterableSetOperator<K>> components = 
            new ArrayList<Iter0IterableSetOperator<K>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeKeySet());
        }
        return new Iter1IterableSetOperator<K>(getOperatorKeyType(), components);
    }


    public final Iter1IterableSetOperator<K> keySet() {
        return unsafeKeySet();
    }


    final Iter1IterableListOperator<V[]> unsafeValues() {
        final List<Iter0IterableListOperator<V[]>> components = 
            new ArrayList<Iter0IterableListOperator<V[]>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeValues());
        }
        return new Iter1IterableListOperator<V[]>(TypeAggregationUtils.createArrayOfType(getOperatorValueType()), components);
    }


    public final Iter1IterableListOperator<V[]> values() {
        return unsafeValues();
    }


    final Iter1IterableArrayOperator<V> unsafeValuesForKey(final K key) {
        final List<Iter0IterableArrayOperator<V>> components = 
            new ArrayList<Iter0IterableArrayOperator<V>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeValuesForKey(key));
        }
        return new Iter1IterableArrayOperator<V>(getOperatorValueType(), components);
    }


    public final Iter1IterableArrayOperator<V> valuesForKey(final K key) {
        // We should not check nullity of key as some implementations might allow it 
        return unsafeValuesForKey(key);
    }


    final Iter1IterableArrayOperator<V> unsafeValuesForAllKeys() {
        final List<Iter0IterableArrayOperator<V>> components = 
            new ArrayList<Iter0IterableArrayOperator<V>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeValuesForAllKeys());
        }
        return new Iter1IterableArrayOperator<V>(getOperatorValueType(), components);
    }


    public final Iter1IterableArrayOperator<V> valuesForAllKeys() {
        return unsafeValuesForAllKeys();
    }


    final <X> Iter1IterableMapOperator<K,X> unsafeMergeValues(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        final List<Iter0IterableMapOperator<K,X>> components = 
            new ArrayList<Iter0IterableMapOperator<K,X>>();
        for (Iter0IterableArrayMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeMergeValues(resultClass, expression, parameters));
        }
        return new Iter1IterableMapOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }


    public final Iter1IterableMapOperator<K,?> mergeValues(final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeMergeValues(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter1IterableMapOperator<K,X> mergeValues(final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Class cannot be null");
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeMergeValues(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <X> Iter1IterableArrayMapOperator<K,X> unsafeEachValueEval(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        final List<Iter0IterableArrayMapOperator<K,X>> components = 
            new ArrayList<Iter0IterableArrayMapOperator<K,X>>();
        for (Iter0IterableArrayMapOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEachValueEval(resultClass, expression, parameters));
        }
        return new Iter1IterableArrayMapOperator<K,X>(
                getOperatorKeyType(), resultClass, components);
    }

    
    final <X> Iter1IterableArrayMapOperator<K,X> unsafeEachValueEval(
            final Class<X> resultClass, final Evaluator<V,X> evaluator) {
        final List<Iter0IterableArrayMapOperator<K,X>> components = 
            new ArrayList<Iter0IterableArrayMapOperator<K,X>>();
        for (Iter0IterableArrayMapOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEachValueEval(resultClass, evaluator));
        }
        return new Iter1IterableArrayMapOperator<K,X>(
                getOperatorKeyType(), resultClass, components);
    }

    
    public final Iter1IterableArrayMapOperator<K,?> eachValueEval(final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachValueEval(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter1IterableArrayMapOperator<K,X> eachValueEval(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachValueEval(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter1IterableArrayMapOperator<K,X> eachValueEval(
            Class<X> resultClass, final Evaluator<V,X> evaluator) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachValueEval(resultClass, evaluator);
    }

    
    public final Iter1IterableArrayMapOperator<K,?> eachValueEval(
            final Evaluator<V,Object> evaluator) {
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachValueEval(null, evaluator);
    }
    

    final <X> Iter1IterableArrayMapOperator<K,X> unsafeEachValueCall(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        final List<Iter0IterableArrayMapOperator<K,X>> components = 
            new ArrayList<Iter0IterableArrayMapOperator<K,X>>();
        for (Iter0IterableArrayMapOperator<K,V> target : getTargets()) {
            components.add(target.unsafeEachValueCall(resultClass, methodName, arguments));
        }
        return new Iter1IterableArrayMapOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }
    

    public final Iter1IterableArrayMapOperator<K,?> eachValueCall(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachValueCall(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter1IterableArrayMapOperator<K,X> eachValueCall(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Return class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachValueCall(resultClass, methodName,OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    final <X> Iter1IterableArrayMapOperator<K,X> unsafeEachValueTo(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        final List<Iter0IterableArrayMapOperator<K,X>> components = 
            new ArrayList<Iter0IterableArrayMapOperator<K,X>>();
        for (Iter0IterableArrayMapOperator<K,V> target : getTargets()) {
            components.add(target.unsafeEachValueTo(resultClass, resultType, parameters));
        }
        return new Iter1IterableArrayMapOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }
    

    public final Iter1IterableArrayMapOperator<K,?> eachValueTo(
            final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeEachValueTo(null, resultType, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final Iter1IterableArrayMapOperator<K,?> eachValueTo(
            final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeEachValueTo(null, Types.forName(resultTypeName), OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter1IterableArrayMapOperator<K,X> eachValueTo(
            final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeEachValueTo(resultClass, Types.getRawTypeForClass(resultClass), OperatorUtils.safeEvaluationParameters(parameters));
    }
    
    
}

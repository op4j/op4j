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
import org.op4j.op.interfaces.IterableMapIteratingOperator;
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
public final class Iter2IterableMapOperator<K,V> 
        extends Iter2AbstractOperator<Map<K,V>>
        implements IterableMapIteratingOperator<K,V> {

    
    private final Type operatorKeyType;
    private final Type operatorValueType;
    

    Iter2IterableMapOperator(
            final Type operatorKeyType, final Type operatorValueType, final List<Iter1IterableMapOperator<K,V>> iterationComponents) {
        super(iterationComponents);
        this.operatorKeyType = operatorKeyType;
        this.operatorValueType = operatorValueType;
    }
    
    
    Iter2IterableMapOperator(final Class<K> operatorKeyClass, final Class<V> operatorValueClass, final List<Iter1IterableMapOperator<K,V>> iterationComponents) {
        this((operatorKeyClass != null? Types.getRawTypeForClass(operatorKeyClass) : null), (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), iterationComponents);
    }
    
    
    Iter2IterableMapOperator(final Class<K> operatorKeyClass, final Type operatorValueType, final List<Iter1IterableMapOperator<K,V>> iterationComponents) {
        this((operatorKeyClass != null? Types.getRawTypeForClass(operatorKeyClass) : null), operatorValueType, iterationComponents);
    }
    
    
    Iter2IterableMapOperator(final Type operatorKeyType, final Class<V> operatorValueClass, final List<Iter1IterableMapOperator<K,V>> iterationComponents) {
        this(operatorKeyType, (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), iterationComponents);
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<Iter1IterableMapOperator<K,V>> getTargets() {
        return (List<Iter1IterableMapOperator<K,V>>) getAbstractTargets();
    }
    
    
    final Type getOperatorKeyType() {
        return this.operatorKeyType;
    }
    
    
    final Type getOperatorValueType() {
        return this.operatorValueType;
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter2IterableMapOperator<?,?> unsafeRaw() {
        final List<Iter1IterableMapOperator<?,?>> components = 
            new ArrayList<Iter1IterableMapOperator<?,?>>();
        for (Iter1IterableMapOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeRaw());
        }
        return new Iter2IterableMapOperator((Type) null, (Type) null, components);
    }
    
    
    public final Iter2IterableMapOperator<?,?> raw() {
        return unsafeRaw();
    }
    

    final <X> Iter2IterableMapOperator<K,X> unsafeEachExecUniqValue(
            final Class<X> resultClass, final String operationName, final List<Object> parameters) {
        final List<Iter1IterableMapOperator<K,X>> components = 
            new ArrayList<Iter1IterableMapOperator<K,X>>();
        for (Iter1IterableMapOperator<K,V> target : getTargets()) {
            components.add(target.unsafeEachExecUniqValue(resultClass, operationName, parameters));
        }
        return new Iter2IterableMapOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }
    

    public final Iter2IterableMapOperator<K,?> eachExecUniqValue(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExecUniqValue(null, operationName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter2IterableMapOperator<K,X> eachExecUniqValue(
            final Class<X> resultClass, final String operationName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExecUniqValue(resultClass, operationName, OperatorUtils.safeEvaluationParameters(parameters));
    }


    final Iter2IterableMapOperator<K,V> unsafeSortKeys() {
        return unsafeSortKeys(null);
    }


    public final Iter2IterableMapOperator<K,V> sortKeys() {
        return unsafeSortKeys();
    }


    final Iter2IterableMapOperator<K,V> unsafeSortKeys(final Comparator<? super K> comparator) {
        final List<Iter1IterableMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableMapOperator<K,V>>();
        for (Iter1IterableMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeSortKeys(comparator));
        }
        return new Iter2IterableMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }


    public final Iter2IterableMapOperator<K,V> sortKeys(final Comparator<? super K> comparator) {
        // Comparator can be null. This is to adhere to the Collections.sort(...) API.
        return unsafeSortKeys(comparator);
    }


    final Iter2IterableMapOperator<K,V> unsafeSortValues() {
        return unsafeSortValues(null);
    }


    public final Iter2IterableMapOperator<K,V> sortValues() {
        return unsafeSortValues();
    }


    final Iter2IterableMapOperator<K,V> unsafeSortValues(final Comparator<? super V> comparator) {
        final List<Iter1IterableMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableMapOperator<K,V>>();
        for (Iter1IterableMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeSortValues(comparator));
        }
        return new Iter2IterableMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }


    public final Iter2IterableMapOperator<K,V> sortValues(final Comparator<? super V> comparator) {
        // Comparator can be null. This is to adhere to the Collections.sort(...) API.
        return unsafeSortValues(comparator);
    }
    
    
    final Iter3GenericUniqTargetOperator<V> unsafeEachValue() {
        final List<Iter2GenericUniqTargetOperator<V>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<V>>();
        for (Iter1IterableMapOperator<K,V> target : this.getTargets()) {
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
        for (Iter1IterableMapOperator<K,V> target : this.getTargets()) {
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
        for (Iter1IterableMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachEntry());
        }
        return new Iter3MapEntryOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }
    
    
    public final Iter3MapEntryOperator<K,V> eachEntry() {
        return unsafeEachEntry();
    }


    final <X,Y> Iter2IterableListMapOperator<X,Y> unsafeAsListMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        final List<Iter1IterableListMapOperator<X,Y>> components = 
            new ArrayList<Iter1IterableListMapOperator<X,Y>>();
        for (Iter1IterableMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeAsListMap(keyClass,valueClass));
        }
        return new Iter2IterableListMapOperator<X,Y>(keyClass, valueClass, components);
    }


    public final <X,Y> Iter2IterableListMapOperator<X,Y> asListMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsListMap(keyClass,valueClass);
    }


    final <X,Y> Iter2IterableSetMapOperator<X,Y> unsafeAsSetMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        final List<Iter1IterableSetMapOperator<X,Y>> components = 
            new ArrayList<Iter1IterableSetMapOperator<X,Y>>();
        for (Iter1IterableMapOperator<K,V> target : this.getTargets()) {
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


    final <X,Y> Iter2IterableMapOperator<X,Y> unsafeAsMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        final List<Iter1IterableMapOperator<X,Y>> components = 
            new ArrayList<Iter1IterableMapOperator<X,Y>>();
        for (Iter1IterableMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeAsMap(keyClass,valueClass));
        }
        return new Iter2IterableMapOperator<X,Y>(keyClass, valueClass, components);
    }


    public final <X,Y> Iter2IterableMapOperator<X,Y> asMap(
            final Class<X> keyClass, final Class<Y> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsMap(keyClass,valueClass);
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter2GenericUniqTargetOperator<Map<K,V>> unsafeGeneric() {
        final List<Iter1GenericUniqTargetOperator<Map<K,V>>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<Map<K,V>>>();
        for (Iter1IterableMapOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeGeneric());
        }
        return new Iter2GenericUniqTargetOperator(TypeAggregationUtils.createMapEntryOfType(getOperatorKeyType(), getOperatorValueType()), components);
    }
    
    
    public final Iter2GenericUniqTargetOperator<Map<K,V>> generic() {
        return unsafeGeneric();
    }


    public final Iter1IterableArrayOperator<Map<K,V>> uneachArray() {
        return unsafeGeneric().unsafeUneachArray();
    }


    public final Iter1IterableListOperator<Map<K,V>> uneachList() {
        return unsafeGeneric().unsafeUneachList();
    }


    public final Iter1IterableSetOperator<Map<K,V>> uneachSet() {
        return unsafeGeneric().unsafeUneachSet();
    }
    
    
    public final Iter1IterableMapOperator<?,Map<K,V>> uneachMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X> Iter1IterableMapOperator<X,Map<K,V>> uneachMap(
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
            final Class<X> keyClass, final Class<Y> valueClass, final MapBuilder<Map<K,V>,X,Y> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter1IterableMapOperator<?,?> uneachMap(
            final MapBuilder<Map<K,V>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachMap(null, null, mapBuilder);
    }
    
    
    public final Iter1IterableListMapOperator<?,Map<K,V>> uneachListMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachListMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X> Iter1IterableListMapOperator<X,Map<K,V>> uneachListMap(
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
            final Class<X> keyClass, final Class<Y> valueClass, final MapBuilder<Map<K,V>,X,Y> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachListMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter1IterableListMapOperator<?,?> uneachListMap(
            final MapBuilder<Map<K,V>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachListMap(null, null, mapBuilder);
    }
    
    
    public final Iter1IterableSetMapOperator<?,Map<K,V>> uneachSetMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <X> Iter1IterableSetMapOperator<X,Map<K,V>> uneachSetMap(
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
            final Class<X> keyClass, final Class<Y> valueClass, final MapBuilder<Map<K,V>,X,Y> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter1IterableSetMapOperator<?,?> uneachSetMap(
            final MapBuilder<Map<K,V>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(null, null, mapBuilder);
    }
    

    final Iter2IterableMapOperator<K,V> unsafeEachFilterEntry(
            final String expression, final List<Object> parameters) {
        final List<Iter1IterableMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableMapOperator<K,V>>();
        for (Iter1IterableMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachFilterEntry(expression, parameters));
        }
        return new Iter2IterableMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }

    
    final Iter2IterableMapOperator<K,V> unsafeEachFilterEntry(final Filter<Map.Entry<K,V>> filter) {
        final List<Iter1IterableMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableMapOperator<K,V>>();
        for (Iter1IterableMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeEachFilterEntry(filter));
        }
        return new Iter2IterableMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }


    public final Iter2IterableMapOperator<K,V> eachFilterEntry(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeEachFilterEntry(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

    
    public final Iter2IterableMapOperator<K,V> eachFilterEntry(final Filter<Map.Entry<K,V>> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeEachFilterEntry(filter);
    }


    final Iter2IterableSetOperator<K> unsafeKeySet() {
        final List<Iter1IterableSetOperator<K>> components = 
            new ArrayList<Iter1IterableSetOperator<K>>();
        for (Iter1IterableMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeKeySet());
        }
        return new Iter2IterableSetOperator<K>(getOperatorKeyType(), components);
    }


    public final Iter2IterableSetOperator<K> keySet() {
        return unsafeKeySet();
    }


    final Iter2IterableListOperator<V> unsafeValues() {
        final List<Iter1IterableListOperator<V>> components = 
            new ArrayList<Iter1IterableListOperator<V>>();
        for (Iter1IterableMapOperator<K,V> target : this.getTargets()) {
            components.add(target.unsafeValues());
        }
        return new Iter2IterableListOperator<V>(getOperatorValueType(), components);
    }


    public final Iter2IterableListOperator<V> values() {
        return unsafeValues();
    }

    
    final <X> Iter2IterableMapOperator<K,X> unsafeEachEvalValue(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        final List<Iter1IterableMapOperator<K,X>> components = 
            new ArrayList<Iter1IterableMapOperator<K,X>>();
        for (Iter1IterableMapOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEachEvalValue(resultClass, expression, parameters));
        }
        return new Iter2IterableMapOperator<K,X>(
                getOperatorKeyType(), resultClass, components);
    }

    
    final <X> Iter2IterableMapOperator<K,X> unsafeEachEvalValue(
            final Class<X> resultClass, final Evaluator<V,X> evaluator) {
        final List<Iter1IterableMapOperator<K,X>> components = 
            new ArrayList<Iter1IterableMapOperator<K,X>>();
        for (Iter1IterableMapOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEachEvalValue(resultClass, evaluator));
        }
        return new Iter2IterableMapOperator<K,X>(
                getOperatorKeyType(), resultClass, components);
    }

    
    public final Iter2IterableMapOperator<K,?> eachEvalValue(final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEvalValue(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter2IterableMapOperator<K,X> eachEvalValue(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEvalValue(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter2IterableMapOperator<K,X> eachEvalValue(
            Class<X> resultClass, final Evaluator<V,X> evaluator) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEvalValue(resultClass, evaluator);
    }

    
    public final Iter2IterableMapOperator<K,?> eachEvalValue(
            final Evaluator<V,Object> evaluator) {
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEvalValue(null, evaluator);
    }
    

    final <X> Iter2IterableMapOperator<K,X> unsafeEachCallValue(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        final List<Iter1IterableMapOperator<K,X>> components = 
            new ArrayList<Iter1IterableMapOperator<K,X>>();
        for (Iter1IterableMapOperator<K,V> target : getTargets()) {
            components.add(target.unsafeEachCallValue(resultClass, methodName, arguments));
        }
        return new Iter2IterableMapOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }
    

    public final Iter2IterableMapOperator<K,?> eachCallValue(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCallValue(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter2IterableMapOperator<K,X> eachCallValue(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Return class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCallValue(resultClass, methodName,OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    final <X> Iter2IterableMapOperator<K,X> unsafeEachToValue(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        final List<Iter1IterableMapOperator<K,X>> components = 
            new ArrayList<Iter1IterableMapOperator<K,X>>();
        for (Iter1IterableMapOperator<K,V> target : getTargets()) {
            components.add(target.unsafeEachToValue(resultClass, resultType, parameters));
        }
        return new Iter2IterableMapOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }
    

    public final Iter2IterableMapOperator<K,?> eachToValue(
            final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeEachToValue(null, resultType, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final Iter2IterableMapOperator<K,?> eachToValue(
            final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeEachToValue(null, Types.forName(resultTypeName), OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter2IterableMapOperator<K,X> eachToValue(
            final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeEachToValue(resultClass, Types.getRawTypeForClass(resultClass), OperatorUtils.safeEvaluationParameters(parameters));
    }

    
}

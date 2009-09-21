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

import org.apache.commons.lang.Validate;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.IterableListIteratingOperator;
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
public final class Iter2IterableListOperator<T> 
        extends Iter2AbstractOperator<List<T>>
        implements IterableListIteratingOperator<T> {

    
    private final Type operatorComponentType;
    

    Iter2IterableListOperator(
            final Type operatorComponentType, final List<Iter1IterableListOperator<T>> iterationComponents) {
        super(iterationComponents);
        this.operatorComponentType = operatorComponentType;
    }
    
    
    Iter2IterableListOperator(final Class<T> operatorComponentClass, final List<Iter1IterableListOperator<T>> iterationComponents) {
        this((operatorComponentClass != null? Types.getRawTypeForClass(operatorComponentClass) : null), iterationComponents);
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<Iter1IterableListOperator<T>> getTargets() {
        return (List<Iter1IterableListOperator<T>>) getAbstractTargets();
    }
    
    
    final Type getOperatorComponentType() {
        return this.operatorComponentType;
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter2IterableListOperator<?> unsafeRaw() {
        final List<Iter1IterableListOperator<?>> components = 
            new ArrayList<Iter1IterableListOperator<?>>();
        for (Iter1IterableListOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeRaw());
        }
        return new Iter2IterableListOperator((Type) null, components);
    }
    
    
    public final Iter2IterableListOperator<?> raw() {
        return unsafeRaw();
    }
    

    final <X> Iter2IterableListOperator<X> unsafeEachExecUniq(
            final Class<X> resultClass, final String operationName, final List<Object> parameters) {
        final List<Iter1IterableListOperator<X>> components = 
            new ArrayList<Iter1IterableListOperator<X>>();
        for (Iter1IterableListOperator<T> target : getTargets()) {
            components.add(target.unsafeEachExecUniq(resultClass, operationName, parameters));
        }
        return new Iter2IterableListOperator<X>(resultClass, components);
    }
    

    public final Iter2IterableListOperator<?> eachExecUniq(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExecUniq(null, operationName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter2IterableListOperator<X> eachExecUniq(
            final Class<X> resultClass, final String operationName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExecUniq(resultClass, operationName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter2GenericUniqTargetOperator<List<T>> unsafeGeneric() {
        final List<Iter1GenericUniqTargetOperator<List<T>>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<List<T>>>();
        for (Iter1IterableListOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeGeneric());
        }
        return new Iter2GenericUniqTargetOperator(TypeAggregationUtils.createListOfType(getOperatorComponentType()), components);
    }
    
    
    public final Iter2GenericUniqTargetOperator<List<T>> generic() {
        return unsafeGeneric();
    }


    final Iter2IterableListOperator<T> unsafeDistinct() {
        final List<Iter1IterableListOperator<T>> components = 
            new ArrayList<Iter1IterableListOperator<T>>();
        for (Iter1IterableListOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeDistinct());
        }
        return new Iter2IterableListOperator<T>(getOperatorComponentType(), components);
    }


    public final Iter2IterableListOperator<T> distinct() {
        return unsafeDistinct();
    }

    
    final Iter2GenericMultiTargetOperator<T> unsafeFlat() {
        final List<Iter1GenericMultiTargetOperator<T>> components = 
            new ArrayList<Iter1GenericMultiTargetOperator<T>>();
        for (Iter1IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeFlat());
        }
        return new Iter2GenericMultiTargetOperator<T>(getOperatorComponentType(), components);
    }

    
    public final Iter2GenericMultiTargetOperator<T> flat() {
        return unsafeFlat();
    }

    
    final <X> Iter2IterableListOperator<X> unsafeAsList(final Class<X> ofClass) {
        final List<Iter1IterableListOperator<X>> components = 
            new ArrayList<Iter1IterableListOperator<X>>();
        for (Iter1IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeAsList(ofClass));
        }
        return new Iter2IterableListOperator<X>(ofClass, components);
    }

    
    public final <X> Iter2IterableListOperator<X> asList(final Class<X> ofClass) {
        return unsafeAsList(ofClass);
    }


    final Iter2IterableListOperator<T> unsafeSort() {
        return unsafeSort(null);
    }


    public final Iter2IterableListOperator<T> sort() {
        return unsafeSort();
    }


    final Iter2IterableListOperator<T> unsafeSort(final Comparator<? super T> comparator) {
        final List<Iter1IterableListOperator<T>> components = 
            new ArrayList<Iter1IterableListOperator<T>>();
        for (Iter1IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeSort(comparator));
        }
        return new Iter2IterableListOperator<T>(getOperatorComponentType(), components);
    }


    public final Iter2IterableListOperator<T> sort(final Comparator<? super T> comparator) {
        // Comparator can be null. This is to adhere to the Collections.sort(...) API.
        return unsafeSort(comparator);
    }
    
    
    final Iter3GenericUniqTargetOperator<T> unsafeEach() {
        final List<Iter2GenericUniqTargetOperator<T>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<T>>();
        for (Iter1IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeEach());
        }
        return new Iter3GenericUniqTargetOperator<T>(getOperatorComponentType(), components);
    }
    
    
    public final Iter3GenericUniqTargetOperator<T> each() {
        return unsafeEach();
    }


    public final Iter1IterableArrayOperator<List<T>> uneachArray() {
        return unsafeGeneric().unsafeUneachArray();
    }


    public final Iter1IterableListOperator<List<T>> uneachList() {
        return unsafeGeneric().unsafeUneachList();
    }


    public final Iter1IterableSetOperator<List<T>> uneachSet() {
        return unsafeGeneric().unsafeUneachSet();
    }
    
    
    public final Iter1IterableMapOperator<?,List<T>> uneachMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter1IterableMapOperator<K,List<T>> uneachMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
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
    
    
    public final <K,V> Iter1IterableMapOperator<K,V> uneachMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final <K,V> Iter1IterableMapOperator<K,V> uneachMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<List<T>,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter1IterableMapOperator<?,?> uneachMap(
            final MapBuilder<List<T>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachMap(null, null, mapBuilder);
    }
    
    
    public final Iter1IterableListMapOperator<?,List<T>> uneachListMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachListMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter1IterableListMapOperator<K,List<T>> uneachListMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
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
    
    
    public final <K,V> Iter1IterableListMapOperator<K,V> uneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachListMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final <K,V> Iter1IterableListMapOperator<K,V> uneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<List<T>,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachListMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter1IterableListMapOperator<?,?> uneachListMap(
            final MapBuilder<List<T>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachListMap(null, null, mapBuilder);
    }

    
    public final Iter1IterableSetMapOperator<?,List<T>> uneachSetMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter1IterableSetMapOperator<K,List<T>> uneachSetMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
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
    
    
    public final <K,V> Iter1IterableSetMapOperator<K,V> uneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final <K,V> Iter1IterableSetMapOperator<K,V> uneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<List<T>,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter1IterableSetMapOperator<?,?> uneachSetMap(
            final MapBuilder<List<T>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(null, null, mapBuilder);
    }
    

    final Iter2IterableListOperator<T> unsafeEachFilter(
            final String expression, final List<Object> parameters) {
        final List<Iter1IterableListOperator<T>> components = 
            new ArrayList<Iter1IterableListOperator<T>>();
        for (Iter1IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeEachFilter(expression, parameters));
        }
        return new Iter2IterableListOperator<T>(getOperatorComponentType(), components);
    }

    
    final Iter2IterableListOperator<T> unsafeEachFilter(final Filter<T> filter) {
        final List<Iter1IterableListOperator<T>> components = 
            new ArrayList<Iter1IterableListOperator<T>>();
        for (Iter1IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeEachFilter(filter));
        }
        return new Iter2IterableListOperator<T>(getOperatorComponentType(), components);
    }


    public final Iter2IterableListOperator<T> eachFilter(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeEachFilter(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

        
    public final Iter2IterableListOperator<T> eachFilter(final Filter<T> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeEachFilter(filter);
    }


    final Iter2IterableArrayOperator<T> unsafeToArray() {
        final List<Iter1IterableArrayOperator<T>> components = 
            new ArrayList<Iter1IterableArrayOperator<T>>();
        for (Iter1IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeToArray());
        }
        return new Iter2IterableArrayOperator<T>(getOperatorComponentType(), components);
    }

        
    public final Iter2IterableArrayOperator<T> toArray() {
        return unsafeToArray();
    }


    final Iter2IterableSetOperator<T> unsafeToSet() {
        final List<Iter1IterableSetOperator<T>> components = 
            new ArrayList<Iter1IterableSetOperator<T>>();
        for (Iter1IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeToSet());
        }
        return new Iter2IterableSetOperator<T>(getOperatorComponentType(), components);
    }

        
    public final Iter2IterableSetOperator<T> toSet() {
        return unsafeToSet();
    }
    
    
    public final Iter2IterableMapOperator<?,T> toMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter2IterableMapOperator<K,T> toMap(
            final Class<K> keyClass, final String keyExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final Iter2IterableMapOperator<?,?> toMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter2IterableMapOperator<K,V> toMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter2IterableMapOperator<K,V> toMap(final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter2IterableMapOperator<?,?> toMap(final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildMap(null, null, mapBuilder);
    }

    
    public final Iter2IterableListMapOperator<?,T> toListMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildListMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter2IterableListMapOperator<K,T> toListMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildListMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final Iter2IterableListMapOperator<?,?> toListMap(
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildListMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter2IterableListMapOperator<K,V> toListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildListMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter2IterableListMapOperator<K,V> toListMap(
            final Class<K> keyClass, final Class<V> valueClass,
            final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildListMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter2IterableListMapOperator<?,?> toListMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildListMap(null, null, mapBuilder);
    }

    
    public final Iter2IterableSetMapOperator<?,T> toSetMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildSetMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter2IterableSetMapOperator<K,T> toSetMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildSetMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final Iter2IterableSetMapOperator<?,?> toSetMap(
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildSetMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter2IterableSetMapOperator<K,V> toSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildSetMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter2IterableSetMapOperator<K,V> toSetMap(
            final Class<K> keyClass, final Class<V> valueClass,
            final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildSetMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter2IterableSetMapOperator<?,?> toSetMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildSetMap(null, null, mapBuilder);
    }
    
    
    final <X> Iter2IterableListOperator<X> unsafeEachEval(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        final List<Iter1IterableListOperator<X>> components = 
            new ArrayList<Iter1IterableListOperator<X>>();
        for (Iter1IterableListOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEachEval(resultClass, expression, parameters));
        }
        return new Iter2IterableListOperator<X>(resultClass, components);
    }

    
    final <X> Iter2IterableListOperator<X> unsafeEachEval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator) {
        final List<Iter1IterableListOperator<X>> components = 
            new ArrayList<Iter1IterableListOperator<X>>();
        for (Iter1IterableListOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEachEval(resultClass, evaluator));
        }
        return new Iter2IterableListOperator<X>(resultClass, components);
    }

    
    public final Iter2IterableListOperator<?> eachEval(final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEval(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter2IterableListOperator<X> eachEval(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEval(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter2IterableListOperator<X> eachEval(
            Class<X> resultClass, final Evaluator<T,X> evaluator) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEval(resultClass, evaluator);
    }

    
    public final Iter2IterableListOperator<?> eachEval(
            final Evaluator<T,Object> evaluator) {
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEval(null, evaluator);
    }
    

    final <X> Iter2IterableListOperator<X> unsafeEachCall(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        final List<Iter1IterableListOperator<X>> components = 
            new ArrayList<Iter1IterableListOperator<X>>();
        for (Iter1IterableListOperator<T> target : getTargets()) {
            components.add(target.unsafeEachCall(resultClass, methodName, arguments));
        }
        return new Iter2IterableListOperator<X>(resultClass, components);
    }
    

    public final Iter2IterableListOperator<?> eachCall(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCall(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter2IterableListOperator<X> eachCall(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Return class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCall(resultClass, methodName,OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    final <X> Iter2IterableListOperator<X> unsafeEachTo(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        final List<Iter1IterableListOperator<X>> components = 
            new ArrayList<Iter1IterableListOperator<X>>();
        for (Iter1IterableListOperator<T> target : getTargets()) {
            components.add(target.unsafeEachTo(resultClass, resultType, parameters));
        }
        return new Iter2IterableListOperator<X>(resultClass, components);
    }
    

    public final Iter2IterableListOperator<?> eachTo(
            final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeEachTo(null, resultType, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final Iter2IterableListOperator<?> eachTo(
            final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeEachTo(null, Types.forName(resultTypeName), OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter2IterableListOperator<X> eachTo(
            final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeEachTo(resultClass, Types.getRawTypeForClass(resultClass), OperatorUtils.safeEvaluationParameters(parameters));
    }

    
}

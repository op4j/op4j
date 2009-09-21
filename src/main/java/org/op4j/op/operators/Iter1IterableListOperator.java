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
public final class Iter1IterableListOperator<T> 
        extends Iter1AbstractOperator<List<T>>
        implements IterableListIteratingOperator<T> {

    
    private final Type operatorComponentType;
    

    Iter1IterableListOperator(
            final Type operatorComponentType, final List<Iter0IterableListOperator<T>> iterationComponents) {
        super(iterationComponents);
        this.operatorComponentType = operatorComponentType;
    }
    
    
    Iter1IterableListOperator(final Class<T> operatorComponentClass, final List<Iter0IterableListOperator<T>> iterationComponents) {
        this((operatorComponentClass != null? Types.getRawTypeForClass(operatorComponentClass) : null), iterationComponents);
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<Iter0IterableListOperator<T>> getTargets() {
        return (List<Iter0IterableListOperator<T>>) getAbstractTargets();
    }
    
    
    final Type getOperatorComponentType() {
        return this.operatorComponentType;
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter1IterableListOperator<?> unsafeRaw() {
        final List<Iter0IterableListOperator<?>> components = 
            new ArrayList<Iter0IterableListOperator<?>>();
        for (Iter0IterableListOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeRaw());
        }
        return new Iter1IterableListOperator((Type) null, components);
    }
    
    
    public final Iter1IterableListOperator<?> raw() {
        return unsafeRaw();
    }
    

    final <X> Iter1IterableListOperator<X> unsafeEachExecUniq(
            final Class<X> resultClass, final String operationName, final List<Object> parameters) {
        final List<Iter0IterableListOperator<X>> components = 
            new ArrayList<Iter0IterableListOperator<X>>();
        for (Iter0IterableListOperator<T> target : getTargets()) {
            components.add(target.unsafeEachExecUniq(resultClass, operationName, parameters));
        }
        return new Iter1IterableListOperator<X>(resultClass, components);
    }
    

    public final Iter1IterableListOperator<?> eachExecUniq(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExecUniq(null, operationName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter1IterableListOperator<X> eachExecUniq(
            final Class<X> resultClass, final String operationName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExecUniq(resultClass, operationName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter1GenericUniqTargetOperator<List<T>> unsafeGeneric() {
        final List<Iter0GenericUniqTargetOperator<List<T>>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<List<T>>>();
        for (Iter0IterableListOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeGeneric());
        }
        return new Iter1GenericUniqTargetOperator(TypeAggregationUtils.createListOfType(getOperatorComponentType()), components);
    }
    
    
    public final Iter1GenericUniqTargetOperator<List<T>> generic() {
        return unsafeGeneric();
    }


    final Iter1IterableListOperator<T> unsafeDistinct() {
        final List<Iter0IterableListOperator<T>> components = 
            new ArrayList<Iter0IterableListOperator<T>>();
        for (Iter0IterableListOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeDistinct());
        }
        return new Iter1IterableListOperator<T>(getOperatorComponentType(), components);
    }


    public final Iter1IterableListOperator<T> distinct() {
        return unsafeDistinct();
    }

    
    final Iter1GenericMultiTargetOperator<T> unsafeFlat() {
        final List<Iter0GenericMultiTargetOperator<T>> components = 
            new ArrayList<Iter0GenericMultiTargetOperator<T>>();
        for (Iter0IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeFlat());
        }
        return new Iter1GenericMultiTargetOperator<T>(getOperatorComponentType(), components);
    }

    
    public final Iter1GenericMultiTargetOperator<T> flat() {
        return unsafeFlat();
    }

    
    final <X> Iter1IterableListOperator<X> unsafeAsList(final Class<X> ofClass) {
        final List<Iter0IterableListOperator<X>> components = 
            new ArrayList<Iter0IterableListOperator<X>>();
        for (Iter0IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeAsList(ofClass));
        }
        return new Iter1IterableListOperator<X>(ofClass, components);
    }

    
    public final <X> Iter1IterableListOperator<X> asList(final Class<X> ofClass) {
        return unsafeAsList(ofClass);
    }


    final Iter1IterableListOperator<T> unsafeSort() {
        return unsafeSort(null);
    }


    public final Iter1IterableListOperator<T> sort() {
        return unsafeSort();
    }


    final Iter1IterableListOperator<T> unsafeSort(final Comparator<? super T> comparator) {
        final List<Iter0IterableListOperator<T>> components = 
            new ArrayList<Iter0IterableListOperator<T>>();
        for (Iter0IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeSort(comparator));
        }
        return new Iter1IterableListOperator<T>(getOperatorComponentType(), components);
    }


    public final Iter1IterableListOperator<T> sort(final Comparator<? super T> comparator) {
        // Comparator can be null. This is to adhere to the Collections.sort(...) API.
        return unsafeSort(comparator);
    }
    
    
    final Iter2GenericUniqTargetOperator<T> unsafeEach() {
        final List<Iter1GenericUniqTargetOperator<T>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<T>>();
        for (Iter0IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeEach());
        }
        return new Iter2GenericUniqTargetOperator<T>(getOperatorComponentType(), components);
    }
    
    
    public final Iter2GenericUniqTargetOperator<T> each() {
        return unsafeEach();
    }


    public final Iter0IterableArrayOperator<List<T>> uneachArray() {
        return unsafeGeneric().unsafeUneachArray();
    }


    public final Iter0IterableListOperator<List<T>> uneachList() {
        return unsafeGeneric().unsafeUneachList();
    }


    public final Iter0IterableSetOperator<List<T>> uneachSet() {
        return unsafeGeneric().unsafeUneachSet();
    }
    
    
    public final Iter0IterableMapOperator<?,List<T>> uneachMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter0IterableMapOperator<K,List<T>> uneachMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
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
    
    
    public final <K,V> Iter0IterableMapOperator<K,V> uneachMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final <K,V> Iter0IterableMapOperator<K,V> uneachMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<List<T>,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter0IterableMapOperator<?,?> uneachMap(
            final MapBuilder<List<T>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachMap(null, null, mapBuilder);
    }
    
    
    public final Iter0IterableListMapOperator<?,List<T>> uneachListMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachListMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter0IterableListMapOperator<K,List<T>> uneachListMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
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
    
    
    public final <K,V> Iter0IterableListMapOperator<K,V> uneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachListMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final <K,V> Iter0IterableListMapOperator<K,V> uneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<List<T>,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachListMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter0IterableListMapOperator<?,?> uneachListMap(
            final MapBuilder<List<T>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachListMap(null, null, mapBuilder);
    }

    
    public final Iter0IterableSetMapOperator<?,List<T>> uneachSetMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter0IterableSetMapOperator<K,List<T>> uneachSetMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
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
    
    
    public final <K,V> Iter0IterableSetMapOperator<K,V> uneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    public final <K,V> Iter0IterableSetMapOperator<K,V> uneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<List<T>,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value expression cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter0IterableSetMapOperator<?,?> uneachSetMap(
            final MapBuilder<List<T>,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeGeneric().unsafeUneachSetMap(null, null, mapBuilder);
    }
    

    final Iter1IterableListOperator<T> unsafeEachFilter(
            final String expression, final List<Object> parameters) {
        final List<Iter0IterableListOperator<T>> components = 
            new ArrayList<Iter0IterableListOperator<T>>();
        for (Iter0IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeEachFilter(expression, parameters));
        }
        return new Iter1IterableListOperator<T>(getOperatorComponentType(), components);
    }

    
    final Iter1IterableListOperator<T> unsafeEachFilter(final Filter<T> filter) {
        final List<Iter0IterableListOperator<T>> components = 
            new ArrayList<Iter0IterableListOperator<T>>();
        for (Iter0IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeEachFilter(filter));
        }
        return new Iter1IterableListOperator<T>(getOperatorComponentType(), components);
    }


    public final Iter1IterableListOperator<T> eachFilter(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeEachFilter(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

        
    public final Iter1IterableListOperator<T> eachFilter(final Filter<T> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeEachFilter(filter);
    }


    final Iter1IterableArrayOperator<T> unsafeToArray() {
        final List<Iter0IterableArrayOperator<T>> components = 
            new ArrayList<Iter0IterableArrayOperator<T>>();
        for (Iter0IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeToArray());
        }
        return new Iter1IterableArrayOperator<T>(getOperatorComponentType(), components);
    }

        
    public final Iter1IterableArrayOperator<T> toArray() {
        return unsafeToArray();
    }


    final Iter1IterableSetOperator<T> unsafeToSet() {
        final List<Iter0IterableSetOperator<T>> components = 
            new ArrayList<Iter0IterableSetOperator<T>>();
        for (Iter0IterableListOperator<T> target : this.getTargets()) {
            components.add(target.unsafeToSet());
        }
        return new Iter1IterableSetOperator<T>(getOperatorComponentType(), components);
    }

        
    public final Iter1IterableSetOperator<T> toSet() {
        return unsafeToSet();
    }
    
    
    public final Iter1IterableMapOperator<?,T> toMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter1IterableMapOperator<K,T> toMap(
            final Class<K> keyClass, final String keyExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final Iter1IterableMapOperator<?,?> toMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter1IterableMapOperator<K,V> toMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter1IterableMapOperator<K,V> toMap(final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter1IterableMapOperator<?,?> toMap(final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildMap(null, null, mapBuilder);
    }

    
    public final Iter1IterableListMapOperator<?,T> toListMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildListMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter1IterableListMapOperator<K,T> toListMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildListMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final Iter1IterableListMapOperator<?,?> toListMap(
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildListMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter1IterableListMapOperator<K,V> toListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildListMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter1IterableListMapOperator<K,V> toListMap(
            final Class<K> keyClass, final Class<V> valueClass,
            final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildListMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter1IterableListMapOperator<?,?> toListMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildListMap(null, null, mapBuilder);
    }

    
    public final Iter1IterableSetMapOperator<?,T> toSetMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildSetMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter1IterableSetMapOperator<K,T> toSetMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildSetMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final Iter1IterableSetMapOperator<?,?> toSetMap(
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildSetMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter1IterableSetMapOperator<K,V> toSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildSetMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter1IterableSetMapOperator<K,V> toSetMap(
            final Class<K> keyClass, final Class<V> valueClass,
            final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildSetMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter1IterableSetMapOperator<?,?> toSetMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildSetMap(null, null, mapBuilder);
    }
    
    
    final <X> Iter1IterableListOperator<X> unsafeEachEval(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        final List<Iter0IterableListOperator<X>> components = 
            new ArrayList<Iter0IterableListOperator<X>>();
        for (Iter0IterableListOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEachEval(resultClass, expression, parameters));
        }
        return new Iter1IterableListOperator<X>(resultClass, components);
    }

    
    final <X> Iter1IterableListOperator<X> unsafeEachEval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator) {
        final List<Iter0IterableListOperator<X>> components = 
            new ArrayList<Iter0IterableListOperator<X>>();
        for (Iter0IterableListOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEachEval(resultClass, evaluator));
        }
        return new Iter1IterableListOperator<X>(resultClass, components);
    }

    
    public final Iter1IterableListOperator<?> eachEval(final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEval(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter1IterableListOperator<X> eachEval(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEval(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter1IterableListOperator<X> eachEval(
            Class<X> resultClass, final Evaluator<T,X> evaluator) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEval(resultClass, evaluator);
    }

    
    public final Iter1IterableListOperator<?> eachEval(
            final Evaluator<T,Object> evaluator) {
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEval(null, evaluator);
    }
    

    final <X> Iter1IterableListOperator<X> unsafeEachCall(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        final List<Iter0IterableListOperator<X>> components = 
            new ArrayList<Iter0IterableListOperator<X>>();
        for (Iter0IterableListOperator<T> target : getTargets()) {
            components.add(target.unsafeEachCall(resultClass, methodName, arguments));
        }
        return new Iter1IterableListOperator<X>(resultClass, components);
    }
    

    public final Iter1IterableListOperator<?> eachCall(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCall(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter1IterableListOperator<X> eachCall(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Return class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCall(resultClass, methodName,OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    final <X> Iter1IterableListOperator<X> unsafeEachTo(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        final List<Iter0IterableListOperator<X>> components = 
            new ArrayList<Iter0IterableListOperator<X>>();
        for (Iter0IterableListOperator<T> target : getTargets()) {
            components.add(target.unsafeEachTo(resultClass, resultType, parameters));
        }
        return new Iter1IterableListOperator<X>(resultClass, components);
    }
    

    public final Iter1IterableListOperator<?> eachTo(
            final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeEachTo(null, resultType, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final Iter1IterableListOperator<?> eachTo(
            final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeEachTo(null, Types.forName(resultTypeName), OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter1IterableListOperator<X> eachTo(
            final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeEachTo(resultClass, Types.getRawTypeForClass(resultClass), OperatorUtils.safeEvaluationParameters(parameters));
    }
    
    
}

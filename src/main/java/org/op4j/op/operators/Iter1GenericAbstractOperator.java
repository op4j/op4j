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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.MapBuilder;
import org.op4j.type.Type;
import org.op4j.type.Types;
import org.op4j.util.ConverterUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
abstract class Iter1GenericAbstractOperator<T> 
        extends Iter1AbstractOperator<T> {

    
    private final Type operatorType;
    
 
    Iter1GenericAbstractOperator(final Type operatorType, final List<? extends Iter0GenericAbstractOperator<T>> targetOps) {
        super(targetOps);
        this.operatorType = operatorType;
    }
    

    @Override
    @SuppressWarnings("unchecked")
    List<? extends Iter0GenericAbstractOperator<T>> getTargets() {
        return (List<Iter0GenericAbstractOperator<T>>) getAbstractTargets();
    }
    
    
    final Type getOperatorType() {
        return this.operatorType;
    }
    
    
    public final Iter1GenericMultiTargetOperator<T> add(final T newTarget) {
        return ins(Integer.MAX_VALUE, newTarget);
    }

    
    public final Iter1GenericMultiTargetOperator<T> addAll(final T... newTargets) {
        return insAll(Integer.MAX_VALUE, newTargets);
    }
    
    
    public final Iter1GenericMultiTargetOperator<?> addObj(final Object newTarget) {
        return insObj(Integer.MAX_VALUE, newTarget);
    }

    
    public final Iter1GenericMultiTargetOperator<?> addAllObjs(final Object... newTargets) {
        return insAllObjs(Integer.MAX_VALUE, newTargets);
    }
    
    
    public final Iter1GenericMultiTargetOperator<T> ins(final int pos, final T newTarget) {
        return new Iter1GenericMultiTargetOperator<T>(this, pos, Collections.singletonList(newTarget));
    }


    @SuppressWarnings("unchecked")
    public final Iter1GenericMultiTargetOperator<T> insAll(final int pos, final T... newTargets) {
        Validate.isTrue(newTargets == null || newTargets.length > 0, 
                "Targets must at least contain one object");
        return new Iter1GenericMultiTargetOperator(this, pos, OperatorUtils.safeNewTargetObjects(newTargets));
    }
    
    
    @SuppressWarnings("unchecked")
    public final Iter1GenericMultiTargetOperator<?> insObj(final int pos, final Object newTarget) {
        return new Iter1GenericMultiTargetOperator(this.unsafeRaw(), pos, Collections.singletonList(newTarget));
    }


    @SuppressWarnings("unchecked")
    public final Iter1GenericMultiTargetOperator<?> insAllObjs(final int pos, final Object... newTargets) {
        Validate.isTrue(newTargets == null || newTargets.length > 0, 
                "Targets must at least contain one object");
        return new Iter1GenericMultiTargetOperator(this.unsafeRaw(), pos, OperatorUtils.safeNewTargetObjects(newTargets));
    }

    
    abstract Iter1GenericAbstractOperator<?> unsafeRaw();
    
    
    
    final <X> Iter1GenericUniqTargetOperator<X> unsafeExec(
            final Class<X> resultClass, final String operationName, final List<Object> parameters) {
        final List<Iter0GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<X>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeExec(resultClass, operationName,parameters));
        }
        return new Iter1GenericUniqTargetOperator<X>(resultClass, components);
    }
    
    
    public final Iter1GenericUniqTargetOperator<?> exec(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeExec(null, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter1GenericUniqTargetOperator<X> exec(
            final Class<X> resultClass, final String operationName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeExec(resultClass, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    abstract <X> Iter1GenericAbstractOperator<X> unsafeAs(final Class<X> newOperatorClass);
 
    
    final <X> Iter1GenericUniqTargetOperator<X> unsafeTo(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        return unsafeExec(
                resultClass,
                ConverterUtils.unsafeGetOperationNameForResultType(resultType), 
                parameters);
    }
 
    
    final <X> Iter1GenericUniqTargetOperator<X> unsafeTo(
            final Class<X> resultClass, final List<Object> parameters) {
        return unsafeTo(resultClass, Types.getRawTypeForClass(resultClass), parameters);
    }
    

    public final Iter1GenericUniqTargetOperator<?> to(final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeTo(null, resultType, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final Iter1GenericUniqTargetOperator<?> to(final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeTo(null, Types.forName(resultTypeName), OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter1GenericUniqTargetOperator<X> to(final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeTo(resultClass, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final Iter1GenericUniqTargetOperator<Byte> toByte(final Object... parameters) {
        return unsafeTo(Byte.class, OperatorUtils.safeOperationParameters(parameters));
    }

    
    public final Iter1GenericUniqTargetOperator<Short> toShort(final Object... parameters) {
        return unsafeTo(Short.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1GenericUniqTargetOperator<Integer> toInteger(final Object... parameters) {
        return unsafeTo(Integer.class, OperatorUtils.safeOperationParameters(parameters));
    }

    
    public final Iter1GenericUniqTargetOperator<Long> toLong(final Object... parameters) {
        return unsafeTo(Long.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1GenericUniqTargetOperator<Float> toFloat(final Object... parameters) {
        return unsafeTo(Float.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1GenericUniqTargetOperator<Double> toDouble(final Object... parameters) {
        return unsafeTo(Double.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1GenericUniqTargetOperator<BigInteger> toBigInteger(final Object... parameters) {
        return unsafeTo(BigInteger.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1GenericUniqTargetOperator<BigDecimal> toBigDecimal(final Object... parameters) {
        return unsafeTo(BigDecimal.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1GenericUniqTargetOperator<Boolean> toBoolean(final Object... parameters) {
        return unsafeTo(Boolean.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1GenericUniqTargetOperator<Calendar> toCalendar(final Object... parameters) {
        return unsafeTo(Calendar.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1GenericUniqTargetOperator<String> toStr(final Object... parameters) {
        return unsafeTo(String.class, OperatorUtils.safeOperationParameters(parameters));
    }

    
    final <X> Iter1GenericUniqTargetOperator<X> unsafeEval(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        final List<Iter0GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<X>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEval(resultClass, expression, parameters));
        }
        return new Iter1GenericUniqTargetOperator<X>(resultClass, components);
    }

    
    final <X> Iter1GenericUniqTargetOperator<X> unsafeEval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator) {
        final List<Iter0GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<X>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEval(resultClass, evaluator));
        }
        return new Iter1GenericUniqTargetOperator<X>(resultClass, components);
    }

    
    public final Iter1GenericUniqTargetOperator<?> eval(final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEval(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter1GenericUniqTargetOperator<X> eval(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEval(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter1GenericUniqTargetOperator<X> eval(
            Class<X> resultClass, final Evaluator<T,X> evaluator) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEval(resultClass, evaluator);
    }

    
    public final Iter1GenericUniqTargetOperator<?> eval(
            final Evaluator<T,Object> evaluator) {
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEval(null, evaluator);
    }

    
    final Iter1IterableListOperator<T> unsafeBuildList() {
        final List<Iter0IterableListOperator<T>> components = 
            new ArrayList<Iter0IterableListOperator<T>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildList());
        }
        return new Iter1IterableListOperator<T>(getOperatorType(), components);
    }

    
    public final Iter1IterableListOperator<T> buildList() {
        return unsafeBuildList();
    }

    
    final <X> Iter1IterableListOperator<X> unsafeBuildList(final Class<X> ofClass) {
        return unsafeAs(ofClass).unsafeBuildList();
    }

    
    public final <X> Iter1IterableListOperator<X> buildList(final Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeBuildList(ofClass);
    }

    
    final Iter1IterableSetOperator<T> unsafeBuildSet() {
        final List<Iter0IterableSetOperator<T>> components = 
            new ArrayList<Iter0IterableSetOperator<T>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildSet());
        }
        return new Iter1IterableSetOperator<T>(getOperatorType(), components);
    }

    
    public final Iter1IterableSetOperator<T> buildSet() {
        return unsafeBuildSet();
    }

    
    final <X> Iter1IterableSetOperator<X> unsafeBuildSet(final Class<X> ofClass) {
        return unsafeAs(ofClass).unsafeBuildSet();
    }

    
    public final <X> Iter1IterableSetOperator<X> buildSet(final Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeBuildSet(ofClass);
    }

    
    final Iter1IterableArrayOperator<T> unsafeBuildArray() {
        final List<Iter0IterableArrayOperator<T>> components = 
            new ArrayList<Iter0IterableArrayOperator<T>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildArray());
        }
        return new Iter1IterableArrayOperator<T>(getOperatorType(), components);
    }

    
    public final Iter1IterableArrayOperator<T> buildArray() {
        return unsafeBuildArray();
    }

    
    final <X> Iter1IterableArrayOperator<X> unsafeBuildArray(final Class<X> ofClass) {
        return unsafeAs(ofClass).unsafeBuildArray();
    }

    
    public final <X> Iter1IterableArrayOperator<X> buildArray(final Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeBuildArray(ofClass);
    }

    
    final <K> Iter1IterableMapOperator<K,T> unsafeBuildMap(
            final Class<K> keyClass, final String keyExpression, 
            final List<Object> expParams) {
        final List<Iter0IterableMapOperator<K,T>> components = 
            new ArrayList<Iter0IterableMapOperator<K,T>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildMap(keyClass,keyExpression,expParams));
        }
        return new Iter1IterableMapOperator<K,T>(keyClass, getOperatorType(), components);
    }
    
    
    public final Iter1IterableMapOperator<?,T> buildMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeBuildMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter1IterableMapOperator<K,T> buildMap(
            final Class<K> keyClass, final String keyExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeBuildMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <K,V> Iter1IterableMapOperator<K,V> unsafeBuildMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        final List<Iter0IterableMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableMapOperator<K,V>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildMap(keyClass,valueClass,keyExpression,valueExpression,expParams));
        }
        return new Iter1IterableMapOperator<K,V>(keyClass, valueClass, components);
    }

    
    public final Iter1IterableMapOperator<?,?> buildMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeBuildMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter1IterableMapOperator<K,V> buildMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeBuildMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <K,V> Iter1IterableMapOperator<K,V> unsafeBuildMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        final List<Iter0IterableMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableMapOperator<K,V>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildMap(keyClass, valueClass, mapBuilder));
        }
        return new Iter1IterableMapOperator<K,V>(keyClass, valueClass, components);
    }

    
    public final <K,V> Iter1IterableMapOperator<K,V> buildMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeBuildMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter1IterableMapOperator<?,?> buildMap(final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeBuildMap(null, null, mapBuilder);
    }

    
    final <K> Iter1IterableListMapOperator<K,T> unsafeBuildListMap(
            final Class<K> keyClass, final String keyExpression, 
            final List<Object> expParams) {
        final List<Iter0IterableListMapOperator<K,T>> components = 
            new ArrayList<Iter0IterableListMapOperator<K,T>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildListMap(keyClass,keyExpression,expParams));
        }
        return new Iter1IterableListMapOperator<K,T>(keyClass, getOperatorType(), components);
    }
    
    
    public final Iter1IterableListMapOperator<?,T> buildListMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeBuildListMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter1IterableListMapOperator<K,T> buildListMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeBuildListMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <K,V> Iter1IterableListMapOperator<K,V> unsafeBuildListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        final List<Iter0IterableListMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableListMapOperator<K,V>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildListMap(keyClass,valueClass,keyExpression,valueExpression,expParams));
        }
        return new Iter1IterableListMapOperator<K,V>(keyClass, valueClass, components);
    }

    
    public final Iter1IterableListMapOperator<?,?> buildListMap(
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeBuildListMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter1IterableListMapOperator<K,V> buildListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeBuildListMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <K,V> Iter1IterableListMapOperator<K,V> unsafeBuildListMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        final List<Iter0IterableListMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableListMapOperator<K,V>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildListMap(keyClass, valueClass, mapBuilder));
        }
        return new Iter1IterableListMapOperator<K,V>(keyClass, valueClass, components);
    }

    
    public final <K,V> Iter1IterableListMapOperator<K,V> buildListMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeBuildListMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter1IterableListMapOperator<?,?> buildListMap(final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeBuildListMap(null, null, mapBuilder);
    }

    
    final <K> Iter1IterableSetMapOperator<K,T> unsafeBuildSetMap(
            final Class<K> keyClass, final String keyExpression, 
            final List<Object> expParams) {
        final List<Iter0IterableSetMapOperator<K,T>> components = 
            new ArrayList<Iter0IterableSetMapOperator<K,T>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildSetMap(keyClass,keyExpression,expParams));
        }
        return new Iter1IterableSetMapOperator<K,T>(keyClass, getOperatorType(), components);
    }
    
    
    public final Iter1IterableSetMapOperator<?,T> buildSetMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeBuildSetMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter1IterableSetMapOperator<K,T> buildSetMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeBuildSetMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <K,V> Iter1IterableSetMapOperator<K,V> unsafeBuildSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        final List<Iter0IterableSetMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableSetMapOperator<K,V>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildSetMap(keyClass,valueClass,keyExpression,valueExpression,expParams));
        }
        return new Iter1IterableSetMapOperator<K,V>(keyClass, valueClass, components);
    }

    
    public final Iter1IterableSetMapOperator<?,?> buildSetMap(
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeBuildSetMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter1IterableSetMapOperator<K,V> buildSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeBuildSetMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <K,V> Iter1IterableSetMapOperator<K,V> unsafeBuildSetMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        final List<Iter0IterableSetMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableSetMapOperator<K,V>>();
        for (Iter0GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildSetMap(keyClass, valueClass, mapBuilder));
        }
        return new Iter1IterableSetMapOperator<K,V>(keyClass, valueClass, components);
    }

    
    public final <K,V> Iter1IterableSetMapOperator<K,V> buildSetMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeBuildSetMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter1IterableSetMapOperator<?,?> buildSetMap(final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeBuildSetMap(null, null, mapBuilder);
    }
    
    
}

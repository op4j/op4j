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
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.op4j.exceptions.InvalidExpressionResultClassException;
import org.op4j.exceptions.InvalidOperatorCastException;
import org.op4j.exceptions.InvalidTypeSchemeException;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.MapBuilder;
import org.op4j.operation.GenericTarget;
import org.op4j.operation.Operations;
import org.op4j.operation.Result;
import org.op4j.type.Type;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeScheme;
import org.op4j.util.ConverterUtils;
import org.op4j.util.OgnlUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
abstract class Iter0GenericAbstractOperator<T>
        extends Iter0AbstractOperator<T> {

    
    private final Type operatorType;
    

    /*
     * This method will create targets for each object computing intended type as 
     * "operatorType" if it is not null (or if it is and object is null), 
     * or "rawtype(obj)" otherwise.
     *        
     */
    private static List<GenericTarget<?>> prepareTargets(
            final Type operatorType, final List<?> objects) {
        
        final List<GenericTarget<?>> targets = new ArrayList<GenericTarget<?>>();
        for (Object obj : objects) {
            targets.add(
                    new GenericTarget<Object>(
                            (operatorType != null? 
                                    operatorType :
                                    (obj != null?
                                            Types.getRawTypeForObject(obj) :
                                            Types.OBJECT)), 
                            obj));
        }
        return targets;
        
    }
    
    
    /*
     *  Targets are created for each object computing intended type as typescheme(i).
     *  
     */
    private static List<GenericTarget<?>> prepareTargets(
            final TypeScheme typeScheme, final List<?> objects) {
        
        if (typeScheme.hasLiterals()) {
            throw new InvalidTypeSchemeException(typeScheme, "cannot contain literals");
        }
        
        if (typeScheme.getComponentCount() != objects.size()) {
            throw new InvalidTypeSchemeException(typeScheme, 
            		"should be of size " + 
                    objects.size() + " and is of size " +
                    typeScheme.getComponentCount());
        }
        
        final List<GenericTarget<?>> targets = new ArrayList<GenericTarget<?>>();
        int i = 0;
        for (Object obj : objects) {
            targets.add(new GenericTarget<Object>(typeScheme.getType(i), obj));
            i++;
        }
        return targets;
        
    }

    
    
    @SuppressWarnings("unchecked")
    Iter0GenericAbstractOperator(final Type operatorType, final List<?> objects) {
        
        super((List) prepareTargets(operatorType, objects));
        this.operatorType = operatorType;
        
        /*
         * Check that the intended type is always compatible with the operator type.
         */
        checkOperatorType(this.operatorType, getTargetTypeScheme());
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    Iter0GenericAbstractOperator(final Type operatorType, final TypeScheme typeScheme, final List<?> objects) {
        
        super((List) prepareTargets(typeScheme, objects));
        this.operatorType = operatorType;
        
        /*
         * Check that the intended type is always compatible with the operator type.
         */
        checkOperatorType(this.operatorType, getTargetTypeScheme());
        
    }
    
    
    @SuppressWarnings("unchecked")
    Iter0GenericAbstractOperator(final Type operatorType, final Result result) {
        
        super((List) prepareTargets(result.getType(), Arrays.asList(result.getResultObject())));
        this.operatorType = operatorType;
        
        /*
         * Check that the intended type is always compatible with the operator type.
         */
        checkOperatorType(this.operatorType, getTargetTypeScheme());
        
    }
    
    
    private static void checkOperatorType(final Type operatorType, final TypeScheme targetTypeScheme) {
        final Type checkableOperatorType = 
            (operatorType != null? operatorType : Types.OBJECT);
        for (int i = 0; i < targetTypeScheme.getComponentCount(); i++) {
            if (!checkableOperatorType.isAssignableFrom(targetTypeScheme.getType(i))) {
                throw new InvalidOperatorCastException(checkableOperatorType, targetTypeScheme.getType(i));
            }
        }
    }

    
    protected abstract boolean isUniqTarget();
    
    
    Type getOperatorType() {
        return this.operatorType;
    }
    

    @Override
    @SuppressWarnings("unchecked")
    List<GenericTarget<T>> getTargets() {
        return (List<GenericTarget<T>>) getAbstractTargets();
    }


    public final Iter0GenericMultiTargetOperator<T> add(final T newTarget) {
        return ins(Integer.MAX_VALUE, newTarget);
    }
    
    public final Iter0GenericMultiTargetOperator<T> addAll(final T... newTargets) {
        return insAll(Integer.MAX_VALUE, newTargets);
    }
    

    public final Iter0GenericMultiTargetOperator<?> addObj(final Object newTarget) {
        return insObj(Integer.MAX_VALUE, newTarget);
    }
    
    
    public final Iter0GenericMultiTargetOperator<?> addAllObjs(final Object... newTargets) {
        return insAllObjs(Integer.MAX_VALUE, newTargets);
    }

    
    public final Iter0GenericMultiTargetOperator<T> ins(final int pos, final T newTarget) {
        return new Iter0GenericMultiTargetOperator<T>(this, pos, Collections.singletonList(newTarget));
    }

    
    @SuppressWarnings("unchecked")
    public final Iter0GenericMultiTargetOperator<T> insAll(final int pos, final T... newTargets) {
        Validate.isTrue(newTargets == null || newTargets.length > 0, 
                "Targets must at least contain one object");
        return new Iter0GenericMultiTargetOperator(this, pos, OperatorUtils.safeNewTargetObjects(newTargets));
    }

    
    @SuppressWarnings("unchecked")
    public final Iter0GenericMultiTargetOperator<?> insObj(final int pos, final Object newTarget) {
        return new Iter0GenericMultiTargetOperator(this.unsafeRaw(), pos, Collections.singletonList(newTarget));
    }

    
    @SuppressWarnings("unchecked")
    public final Iter0GenericMultiTargetOperator<?> insAllObjs(final int pos, final Object... newTargets) {
        Validate.isTrue(newTargets == null || newTargets.length > 0, 
                "Targets must at least contain one object");
        return new Iter0GenericMultiTargetOperator(this.unsafeRaw(), pos, OperatorUtils.safeNewTargetObjects(newTargets));
    }

    
    abstract Iter0GenericAbstractOperator<?> unsafeRaw();
    
    
    final <X> Iter0GenericUniqTargetOperator<X> unsafeExec(
            final Class<X> resultClass, final String operationName, final List<Object> parameters) {
        // This operation has to return a unique result. If not, an exception will be thrown
        return new Iter0GenericUniqTargetOperator<X>(
                (resultClass != null?
                        Types.getRawTypeForClass(resultClass) :
                        null),
                Operations.executeOperation(
                        operationName, getTargets(), parameters));
    }

    
    public final Iter0GenericUniqTargetOperator<?> exec(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeExec(null, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter0GenericUniqTargetOperator<X> exec(
            final Class<X> resultClass, final String operationName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeExec(resultClass, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    abstract <X> Iter0GenericAbstractOperator<X> unsafeAs(final Class<X> newOperatorClass);


    final <X> Iter0GenericUniqTargetOperator<X> unsafeTo(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        return unsafeExec(
                resultClass,
                ConverterUtils.unsafeGetOperationNameForResultType(resultType),
                parameters);
    }

    final <X> Iter0GenericUniqTargetOperator<X> unsafeTo(
            final Class<X> resultClass, final List<Object> parameters) {
        return unsafeTo(resultClass, Types.getRawTypeForClass(resultClass), parameters);
    }


    public final Iter0GenericUniqTargetOperator<?> to(
            final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeTo(null, resultType, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final Iter0GenericUniqTargetOperator<?> to(
            final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeTo(null, Types.forName(resultTypeName), OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter0GenericUniqTargetOperator<X> to(
            final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeTo(resultClass, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final Iter0GenericUniqTargetOperator<Byte> toByte(final Object... parameters) {
        return unsafeTo(Byte.class, OperatorUtils.safeOperationParameters(parameters));
    }

    
    public final Iter0GenericUniqTargetOperator<Short> toShort(final Object... parameters) {
        return unsafeTo(Short.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0GenericUniqTargetOperator<Integer> toInteger(final Object... parameters) {
        return unsafeTo(Integer.class, OperatorUtils.safeOperationParameters(parameters));
    }

    
    public final Iter0GenericUniqTargetOperator<Long> toLong(final Object... parameters) {
        return unsafeTo(Long.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0GenericUniqTargetOperator<Float> toFloat(final Object... parameters) {
        return unsafeTo(Float.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0GenericUniqTargetOperator<Double> toDouble(final Object... parameters) {
        return unsafeTo(Double.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0GenericUniqTargetOperator<BigInteger> toBigInteger(final Object... parameters) {
        return unsafeTo(BigInteger.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0GenericUniqTargetOperator<BigDecimal> toBigDecimal(final Object... parameters) {
        return unsafeTo(BigDecimal.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0GenericUniqTargetOperator<Boolean> toBoolean(final Object... parameters) {
        return unsafeTo(Boolean.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0GenericUniqTargetOperator<Calendar> toCalendar(final Object... parameters) {
        return unsafeTo(Calendar.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0GenericUniqTargetOperator<String> toStr(final Object... parameters) {
        return unsafeTo(String.class, OperatorUtils.safeOperationParameters(parameters));
    }

    
    final <X> Iter0GenericUniqTargetOperator<X> unsafeEval(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        
        Object result = null;
        if (isUniqTarget()) {
            result = 
                OgnlUtils.getValueByOgnlExpression(
                        getTargetObjects().get(0), expression, parameters);
        } else {
            result = 
                OgnlUtils.getValueByOgnlExpression(
                        getTargetObjects(), expression, parameters);
        }
        
        if (result != null && resultClass != null) {
	        if (!resultClass.isAssignableFrom(result.getClass())) {
	            throw new InvalidExpressionResultClassException(result.getClass(), resultClass);
	        }
        }
        
        return new Iter0GenericUniqTargetOperator<X>(
                resultClass, 
                result);
        
    }

    
    final <X> Iter0GenericUniqTargetOperator<X> unsafeEval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator) {
        
        final EvalContextImpl<T> ctx = 
            new EvalContextImpl<T>(getTargetObjects());
        final Object result = evaluator.evaluate(ctx);
        
        if (result != null && resultClass != null) {
	        if (!resultClass.isAssignableFrom(result.getClass())) {
	            throw new InvalidExpressionResultClassException(result.getClass(), resultClass);
	        }
        }
        
        return new Iter0GenericUniqTargetOperator<X>(
                resultClass, 
                result);
        
    }

    
    public final Iter0GenericUniqTargetOperator<?> eval(
            final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEval(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter0GenericUniqTargetOperator<X> eval(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Return class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEval(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter0GenericUniqTargetOperator<X> eval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator) {
        Validate.notNull(resultClass, "Class cannot be null");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEval(resultClass, evaluator);
    }

    
    public final Iter0GenericUniqTargetOperator<?> eval(
            final Evaluator<T,Object> evaluator) {
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEval(null, evaluator);
    }

    
    final Iter0IterableListOperator<T> unsafeBuildList() {
        final List<T> newTargetObject = 
            OperatorAggregationUtils.buildListAggregatedTarget(getTargetObjects());
        return new Iter0IterableListOperator<T>(getOperatorType(), newTargetObject);
    }

    
    public final Iter0IterableListOperator<T> buildList() {
        return unsafeBuildList();
    }

    
    final <X> Iter0IterableListOperator<X> unsafeBuildList(final Class<X> ofClass) {
        return unsafeAs(ofClass).unsafeBuildList();
    }

    
    public final <X> Iter0IterableListOperator<X> buildList(final Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeBuildList(ofClass);
    }

    
    final Iter0IterableSetOperator<T> unsafeBuildSet() {
        final Set<T> newTargetObject =
            OperatorAggregationUtils.buildSetAggregatedTarget(getTargetObjects());
        return new Iter0IterableSetOperator<T>(getOperatorType(), newTargetObject);
    }

    
    public final Iter0IterableSetOperator<T> buildSet() {
        return unsafeBuildSet();
    }

    
    final <X> Iter0IterableSetOperator<X> unsafeBuildSet(final Class<X> ofClass) {
        return unsafeAs(ofClass).unsafeBuildSet();
    }

    
    public final <X> Iter0IterableSetOperator<X> buildSet(final Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeBuildSet(ofClass);
    }

    
    final Iter0IterableArrayOperator<T> unsafeBuildArray() {
        final T[] newTargetObject = 
            OperatorAggregationUtils.buildArrayAggregatedTarget(getOperatorType(), getTargetObjects());
        return new Iter0IterableArrayOperator<T>(getOperatorType(), newTargetObject);
    }

    
    public final Iter0IterableArrayOperator<T> buildArray() {
        return unsafeBuildArray();
    }

    
    final <X> Iter0IterableArrayOperator<X> unsafeBuildArray(final Class<X> ofClass) {
        return unsafeAs(ofClass).unsafeBuildArray();
    }

    
    public final <X> Iter0IterableArrayOperator<X> buildArray(final Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeBuildArray(ofClass);
    }

    
    final <K> Iter0IterableMapOperator<K,T> unsafeBuildMap(
            final Class<K> keyClass, final String keyExpression, 
            final List<Object> expParams) {
        final Map<K,T> newTargetObject = 
            OperatorAggregationUtils.buildMapAggregatedTarget(
                    getTargetObjects(), keyClass, keyExpression, expParams);
        return new Iter0IterableMapOperator<K,T>(
                    keyClass, 
                    getOperatorType(),                    // value type
                    newTargetObject);
    }
    
    
    public final Iter0IterableMapOperator<?,T> buildMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeBuildMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter0IterableMapOperator<K,T> buildMap(
            final Class<K> keyClass, final String keyExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeBuildMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <K,V> Iter0IterableMapOperator<K,V> unsafeBuildMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        final Map<K,V> newTargetObject = 
            OperatorAggregationUtils.buildMapAggregatedTarget(
                    getTargetObjects(), keyClass, valueClass, keyExpression, valueExpression, expParams);
        return new Iter0IterableMapOperator<K,V>(
                    keyClass, 
                    valueClass, 
                    newTargetObject);
    }

    
    public final Iter0IterableMapOperator<?,?> buildMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeBuildMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter0IterableMapOperator<K,V> buildMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeBuildMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <K,V> Iter0IterableMapOperator<K,V> unsafeBuildMap(final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        final Map<K,V> newTargetObject = 
            OperatorAggregationUtils.buildMapAggregatedTarget(
                    getTargetObjects(), mapBuilder);
        return new Iter0IterableMapOperator<K,V>(
                    keyClass, 
                    valueClass, 
                    newTargetObject);
    }

    
    public final <K,V> Iter0IterableMapOperator<K,V> buildMap(final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeBuildMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter0IterableMapOperator<?,?> buildMap(final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeBuildMap(null, null, mapBuilder);
    }

    
    final <K> Iter0IterableListMapOperator<K,T> unsafeBuildListMap(
            final Class<K> keyClass, final String keyExpression, 
            final List<Object> expParams) {
        final Map<K,List<T>> newTargetObject = 
            OperatorAggregationUtils.buildListMapAggregatedTarget(
                    getTargetObjects(), keyClass, keyExpression, expParams);
        return new Iter0IterableListMapOperator<K,T>(
                    keyClass, 
                    getOperatorType(),                      // value type
                    newTargetObject);
    }
    
    
    public final Iter0IterableListMapOperator<?,T> buildListMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeBuildListMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter0IterableListMapOperator<K,T> buildListMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeBuildListMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <K,V> Iter0IterableListMapOperator<K,V> unsafeBuildListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        final Map<K,List<V>> newTargetObject = 
            OperatorAggregationUtils.buildListMapAggregatedTarget(
                    getTargetObjects(), keyClass, valueClass, keyExpression, valueExpression, expParams);
        return new Iter0IterableListMapOperator<K,V>(
                    keyClass, 
                    valueClass, 
                    newTargetObject);
    }

    
    public final Iter0IterableListMapOperator<?,?> buildListMap(
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeBuildListMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter0IterableListMapOperator<K,V> buildListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeBuildListMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <K,V> Iter0IterableListMapOperator<K,V> unsafeBuildListMap(
            final Class<K> keyClass, final Class<V> valueClass,
            final MapBuilder<T,K,V> mapBuilder) {
        final Map<K,List<V>> newTargetObject = 
            OperatorAggregationUtils.buildListMapAggregatedTarget(
                    getTargetObjects(), mapBuilder);
        return new Iter0IterableListMapOperator<K,V>(
                    keyClass, 
                    valueClass, 
                    newTargetObject);
    }

    
    public final <K,V> Iter0IterableListMapOperator<K,V> buildListMap(
            final Class<K> keyClass, final Class<V> valueClass,
            final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeBuildListMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter0IterableListMapOperator<?,?> buildListMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeBuildListMap(null, null, mapBuilder);
    }

    
    final <K> Iter0IterableSetMapOperator<K,T> unsafeBuildSetMap(
            final Class<K> keyClass, final String keyExpression, 
            final List<Object> expParams) {
        final Map<K,Set<T>> newTargetObject = 
            OperatorAggregationUtils.buildSetMapAggregatedTarget(
                    getTargetObjects(), keyClass, keyExpression, expParams);
        return new Iter0IterableSetMapOperator<K,T>(
                    keyClass, 
                    getOperatorType(),                      // value type
                    newTargetObject);
    }
    
    
    public final Iter0IterableSetMapOperator<?,T> buildSetMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeBuildSetMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter0IterableSetMapOperator<K,T> buildSetMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeBuildSetMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <K,V> Iter0IterableSetMapOperator<K,V> unsafeBuildSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        final Map<K,Set<V>> newTargetObject = 
            OperatorAggregationUtils.buildSetMapAggregatedTarget(
                    getTargetObjects(), keyClass, valueClass, keyExpression, valueExpression, expParams);
        return new Iter0IterableSetMapOperator<K,V>(
                    keyClass, 
                    valueClass, 
                    newTargetObject);
    }

    
    public final Iter0IterableSetMapOperator<?,?> buildSetMap(
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeBuildSetMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter0IterableSetMapOperator<K,V> buildSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeBuildSetMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <K,V> Iter0IterableSetMapOperator<K,V> unsafeBuildSetMap(
            final Class<K> keyClass, final Class<V> valueClass,
            final MapBuilder<T,K,V> mapBuilder) {
        final Map<K,Set<V>> newTargetObject = 
            OperatorAggregationUtils.buildSetMapAggregatedTarget(
                    getTargetObjects(), mapBuilder);
        return new Iter0IterableSetMapOperator<K,V>(
                    keyClass, 
                    valueClass, 
                    newTargetObject);
    }

    
    public final <K,V> Iter0IterableSetMapOperator<K,V> buildSetMap(
            final Class<K> keyClass, final Class<V> valueClass,
            final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeBuildSetMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter0IterableSetMapOperator<?,?> buildSetMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeBuildSetMap(null, null, mapBuilder);
    }

    
    
    final <K> Iter0IterableArrayMapOperator<K,T> unsafeBuildArrayMap(
            final Class<K> keyClass, final String keyExpression, 
            final List<Object> expParams) {
        final Map<K,T[]> newTargetObject = 
            OperatorAggregationUtils.buildArrayMapAggregatedTarget(
                    getOperatorType(), getTargetObjects(), keyClass, keyExpression, expParams);
        return new Iter0IterableArrayMapOperator<K,T>(
                    keyClass, 
                    getOperatorType(),                      // value type
                    newTargetObject);
    }
    
    
    public final Iter0IterableArrayMapOperator<?,T> buildArrayMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeBuildArrayMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter0IterableArrayMapOperator<K,T> buildArrayMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeBuildArrayMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <K,V> Iter0IterableArrayMapOperator<K,V> unsafeBuildArrayMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        final Map<K,V[]> newTargetObject = 
            OperatorAggregationUtils.buildArrayMapAggregatedTarget(
                    getTargetObjects(), keyClass, valueClass, keyExpression, valueExpression, expParams);
        return new Iter0IterableArrayMapOperator<K,V>(
                    keyClass, 
                    valueClass, 
                    newTargetObject);
    }

    
    public final Iter0IterableArrayMapOperator<?,?> buildArrayMap(
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeBuildArrayMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter0IterableArrayMapOperator<K,V> buildArrayMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeBuildArrayMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    final <K,V> Iter0IterableArrayMapOperator<K,V> unsafeBuildArrayMap(
            final Class<K> keyClass, final Class<V> valueClass,
            final MapBuilder<T,K,V> mapBuilder) {
        final Map<K,V[]> newTargetObject = 
            OperatorAggregationUtils.buildArrayMapAggregatedTarget(
                    valueClass, getTargetObjects(), mapBuilder);
        return new Iter0IterableArrayMapOperator<K,V>(
                    keyClass, 
                    valueClass, 
                    newTargetObject);
    }

    
    public final <K,V> Iter0IterableArrayMapOperator<K,V> buildArrayMap(
            final Class<K> keyClass, final Class<V> valueClass,
            final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeBuildArrayMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter0IterableArrayMapOperator<?,?> buildArrayMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeBuildArrayMap(null, null, mapBuilder);
    }

    
}

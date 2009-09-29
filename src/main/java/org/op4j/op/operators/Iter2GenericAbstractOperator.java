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
abstract class Iter2GenericAbstractOperator<T> 
        extends Iter2AbstractOperator<T> {

    
    private final Type operatorType;
    
    
    Iter2GenericAbstractOperator(final Type operatorType, final List<? extends Iter1AbstractOperator<T>> targetOps) {
        super(targetOps);
        this.operatorType = operatorType;
    }
    

    @Override
    @SuppressWarnings("unchecked")
    List<? extends Iter1GenericAbstractOperator<T>> getTargets() {
        return (List<Iter1GenericAbstractOperator<T>>) getAbstractTargets();
    }
    
    
    final Type getOperatorType() {
        return this.operatorType;
    }
    
    
    public final Iter2GenericMultiTargetOperator<T> add(final T newTarget) {
        return ins(Integer.MAX_VALUE, newTarget);
    }

    
    public final Iter2GenericMultiTargetOperator<T> addAll(final T... newTargets) {
        return insAll(Integer.MAX_VALUE, newTargets);
    }
    
    
    public final Iter2GenericMultiTargetOperator<?> addObj(final Object newTarget) {
        return insObj(Integer.MAX_VALUE, newTarget);
    }

    
    public final Iter2GenericMultiTargetOperator<?> addAllObjs(final Object... newTargets) {
        return insAllObjs(Integer.MAX_VALUE, newTargets);
    }


    public final Iter2GenericMultiTargetOperator<T> ins(final int pos, final T newTarget) {
        return new Iter2GenericMultiTargetOperator<T>(this, pos, Collections.singletonList(newTarget));
    }


    @SuppressWarnings("unchecked")
    public final Iter2GenericMultiTargetOperator<T> insAll(final int pos, final T... newTargets) {
        Validate.isTrue(newTargets == null || newTargets.length > 0, 
                "Targets must at least contain one object");
        return new Iter2GenericMultiTargetOperator(this, pos, OperatorUtils.safeNewTargetObjects(newTargets));
    }


    @SuppressWarnings("unchecked")
    public final Iter2GenericMultiTargetOperator<?> insObj(final int pos, final Object newTarget) {
        return new Iter2GenericMultiTargetOperator(this.unsafeRaw(), pos, Collections.singletonList(newTarget));
    }


    @SuppressWarnings("unchecked")
    public final Iter2GenericMultiTargetOperator<?> insAllObjs(final int pos, final Object... newTargets) {
        Validate.isTrue(newTargets == null || newTargets.length > 0, 
                "Targets must at least contain one object");
        return new Iter2GenericMultiTargetOperator(this.unsafeRaw(), pos, OperatorUtils.safeNewTargetObjects(newTargets));
    }

    
    abstract Iter2GenericAbstractOperator<?> unsafeRaw();
    
    
    final <X> Iter2GenericUniqTargetOperator<X> unsafeExec(
            final Class<X> resultClass, final String operationName, final List<Object> parameters) {
        final List<Iter1GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<X>>();
        for (Iter1GenericAbstractOperator<T> target : this.getTargets()) {
            components.add(target.unsafeExec(resultClass, operationName, parameters));
        }
        return new Iter2GenericUniqTargetOperator<X>(resultClass, components);
    }
    

    public final Iter2GenericUniqTargetOperator<?> exec(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeExec(null, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter2GenericUniqTargetOperator<X> exec(
            final Class<X> resultClass, final String operationName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeExec(resultClass, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    abstract <X> Iter2GenericAbstractOperator<X> unsafeAs(final Class<X> newOperatorClass);
 
    
    final <X> Iter2GenericUniqTargetOperator<X> unsafeTo(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        return unsafeExec(
                resultClass,
                ConverterUtils.unsafeGetOperationNameForResultType(resultType), 
                parameters);
    }
 
    
    final <X> Iter2GenericUniqTargetOperator<X> unsafeTo(
            final Class<X> resultClass, final List<Object> parameters) {
        return unsafeTo(resultClass, Types.getRawTypeForClass(resultClass), parameters);
    }
    

    public final Iter2GenericUniqTargetOperator<?> to(final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeTo(null, resultType, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final Iter2GenericUniqTargetOperator<?> to(final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeTo(null, Types.forName(resultTypeName), OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter2GenericUniqTargetOperator<X> to(final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeTo(resultClass, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final Iter2GenericUniqTargetOperator<Byte> toByte(final Object... parameters) {
        return unsafeTo(Byte.class, OperatorUtils.safeOperationParameters(parameters));
    }

    
    public final Iter2GenericUniqTargetOperator<Short> toShort(final Object... parameters) {
        return unsafeTo(Short.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter2GenericUniqTargetOperator<Integer> toInteger(final Object... parameters) {
        return unsafeTo(Integer.class, OperatorUtils.safeOperationParameters(parameters));
    }

    
    public final Iter2GenericUniqTargetOperator<Long> toLong(final Object... parameters) {
        return unsafeTo(Long.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter2GenericUniqTargetOperator<Float> toFloat(final Object... parameters) {
        return unsafeTo(Float.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter2GenericUniqTargetOperator<Double> toDouble(final Object... parameters) {
        return unsafeTo(Double.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter2GenericUniqTargetOperator<BigInteger> toBigInteger(final Object... parameters) {
        return unsafeTo(BigInteger.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter2GenericUniqTargetOperator<BigDecimal> toBigDecimal(final Object... parameters) {
        return unsafeTo(BigDecimal.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter2GenericUniqTargetOperator<Boolean> toBoolean(final Object... parameters) {
        return unsafeTo(Boolean.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter2GenericUniqTargetOperator<Calendar> toCalendar(final Object... parameters) {
        return unsafeTo(Calendar.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter2GenericUniqTargetOperator<String> toStr(final Object... parameters) {
        return unsafeTo(String.class, OperatorUtils.safeOperationParameters(parameters));
    }

    
    final <X> Iter2GenericUniqTargetOperator<X> unsafeEval(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        final List<Iter1GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<X>>();
        for (Iter1GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEval(resultClass, expression, parameters));
        }
        return new Iter2GenericUniqTargetOperator<X>(resultClass, components);
    }

    
    final <X> Iter2GenericUniqTargetOperator<X> unsafeEval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator) {
        final List<Iter1GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<X>>();
        for (Iter1GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEval(resultClass, evaluator));
        }
        return new Iter2GenericUniqTargetOperator<X>(resultClass, components);
    }

    
    public final Iter2GenericUniqTargetOperator<?> eval(final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEval(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter2GenericUniqTargetOperator<X> eval(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEval(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter2GenericUniqTargetOperator<X> eval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEval(resultClass, evaluator);
    }

    
    public final Iter2GenericUniqTargetOperator<?> eval(final Evaluator<T,Object> evaluator) {
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEval(null, evaluator);
    }
    
    
}

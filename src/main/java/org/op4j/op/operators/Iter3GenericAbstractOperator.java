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
import org.op4j.util.UniqResultConverterUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
abstract class Iter3GenericAbstractOperator<T> 
        extends Iter3AbstractOperator<T> {

    
    private final Type operatorType;
    
    
    Iter3GenericAbstractOperator(final Type operatorType, final List<? extends Iter2AbstractOperator<T>> targetOps) {
        super(targetOps);
        this.operatorType = operatorType;
    }
    

    @Override
    @SuppressWarnings("unchecked")
    List<? extends Iter2GenericAbstractOperator<T>> getTargets() {
        return (List<Iter2GenericAbstractOperator<T>>) getAbstractTargets();
    }
    
    
    final Type getOperatorType() {
        return this.operatorType;
    }
    
    
    public final Iter3GenericMultiTargetOperator<T> add(final T newTarget) {
        return ins(Integer.MAX_VALUE, newTarget);
    }

    
    public final Iter3GenericMultiTargetOperator<T> addAll(final T... newTargets) {
        return insAll(Integer.MAX_VALUE, newTargets);
    }
    
    
    public final Iter3GenericMultiTargetOperator<?> addObj(final Object newTarget) {
        return insObj(Integer.MAX_VALUE, newTarget);
    }

    
    public final Iter3GenericMultiTargetOperator<?> addAllObjs(final Object... newTargets) {
        return insAllObjs(Integer.MAX_VALUE, newTargets);
    }


    public final Iter3GenericMultiTargetOperator<T> ins(final int pos, final T newTarget) {
        return new Iter3GenericMultiTargetOperator<T>(this, pos, Collections.singletonList(newTarget));
    }


    @SuppressWarnings("unchecked")
    public final Iter3GenericMultiTargetOperator<T> insAll(final int pos, final T... newTargets) {
        Validate.isTrue(newTargets == null || newTargets.length > 0, 
                "Targets must at least contain one object");
        return new Iter3GenericMultiTargetOperator(this, pos, OperatorUtils.safeNewTargetObjects(newTargets));
    }


    @SuppressWarnings("unchecked")
    public final Iter3GenericMultiTargetOperator<?> insObj(final int pos, final Object newTarget) {
        return new Iter3GenericMultiTargetOperator(this.unsafeRaw(), pos, Collections.singletonList(newTarget));
    }


    @SuppressWarnings("unchecked")
    public final Iter3GenericMultiTargetOperator<?> insAllObjs(final int pos, final Object... newTargets) {
        Validate.isTrue(newTargets == null || newTargets.length > 0, 
                "Targets must at least contain one object");
        return new Iter3GenericMultiTargetOperator(this.unsafeRaw(), pos, OperatorUtils.safeNewTargetObjects(newTargets));
    }

    
    abstract Iter3GenericAbstractOperator<?> unsafeRaw();
    
    
    final <X> Iter3GenericUniqTargetOperator<X> unsafeExecUniq(
            final Class<X> resultClass, final String operationName, final List<Object> parameters) {
        final List<Iter2GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<X>>();
        for (Iter2GenericAbstractOperator<T> target : this.getTargets()) {
            components.add(target.unsafeExecUniq(resultClass, operationName, parameters));
        }
        return new Iter3GenericUniqTargetOperator<X>(resultClass, components);
    }

    
    final <X> Iter3GenericMultiTargetOperator<X> unsafeExec(
            final Class<X> resultClass, final String operationName, final List<Object> parameters) {
        final List<Iter2GenericMultiTargetOperator<X>> components = 
            new ArrayList<Iter2GenericMultiTargetOperator<X>>();
        for (Iter2GenericAbstractOperator<T> target : this.getTargets()) {
            components.add(target.unsafeExec(resultClass, operationName, parameters));
        }
        return new Iter3GenericMultiTargetOperator<X>(resultClass, components);
    }

    
    public final Iter3GenericMultiTargetOperator<?> exec(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeExec(null, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3GenericUniqTargetOperator<?> execUniq(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeExecUniq(null, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter3GenericUniqTargetOperator<X> execUniq(
            final Class<X> resultClass, final String operationName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeExecUniq(resultClass, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    abstract <X> Iter3GenericAbstractOperator<X> unsafeAs(final Class<X> newOperatorClass);
 
    
    final <X> Iter3GenericUniqTargetOperator<X> unsafeTo(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        return unsafeExecUniq(
                resultClass,
                UniqResultConverterUtils.unsafeGetOperationNameForResultType(resultType), 
                parameters);
    }
 
    
    final <X> Iter3GenericUniqTargetOperator<X> unsafeTo(
            final Class<X> resultClass, final List<Object> parameters) {
        return unsafeTo(resultClass, Types.getRawTypeForClass(resultClass), parameters);
    }
    

    public final Iter3GenericUniqTargetOperator<?> to(final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeTo(null, resultType, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final Iter3GenericUniqTargetOperator<?> to(final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeTo(null, Types.forName(resultTypeName), OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter3GenericUniqTargetOperator<X> to(final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeTo(resultClass, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final Iter3GenericUniqTargetOperator<Byte> toByte(final Object... parameters) {
        return unsafeTo(Byte.class, OperatorUtils.safeOperationParameters(parameters));
    }

    
    public final Iter3GenericUniqTargetOperator<Short> toShort(final Object... parameters) {
        return unsafeTo(Short.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3GenericUniqTargetOperator<Integer> toInteger(final Object... parameters) {
        return unsafeTo(Integer.class, OperatorUtils.safeOperationParameters(parameters));
    }

    
    public final Iter3GenericUniqTargetOperator<Long> toLong(final Object... parameters) {
        return unsafeTo(Long.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3GenericUniqTargetOperator<Float> toFloat(final Object... parameters) {
        return unsafeTo(Float.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3GenericUniqTargetOperator<Double> toDouble(final Object... parameters) {
        return unsafeTo(Double.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3GenericUniqTargetOperator<BigInteger> toBigInteger(final Object... parameters) {
        return unsafeTo(BigInteger.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3GenericUniqTargetOperator<BigDecimal> toBigDecimal(final Object... parameters) {
        return unsafeTo(BigDecimal.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3GenericUniqTargetOperator<Boolean> toBoolean(final Object... parameters) {
        return unsafeTo(Boolean.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3GenericUniqTargetOperator<Calendar> toCalendar(final Object... parameters) {
        return unsafeTo(Calendar.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3GenericUniqTargetOperator<String> toStr(final Object... parameters) {
        return unsafeTo(String.class, OperatorUtils.safeOperationParameters(parameters));
    }

    
    final <X> Iter3GenericUniqTargetOperator<X> unsafeEval(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        final List<Iter2GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<X>>();
        for (Iter2GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEval(resultClass, expression, parameters));
        }
        return new Iter3GenericUniqTargetOperator<X>(resultClass, components);
    }

    
    final <X> Iter3GenericUniqTargetOperator<X> unsafeEval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator) {
        final List<Iter2GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<X>>();
        for (Iter2GenericAbstractOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEval(resultClass, evaluator));
        }
        return new Iter3GenericUniqTargetOperator<X>(resultClass, components);
    }

    
    public final Iter3GenericUniqTargetOperator<?> eval(final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEval(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter3GenericUniqTargetOperator<X> eval(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEval(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter3GenericUniqTargetOperator<X> eval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator) {
        Validate.notNull(resultClass, "Result class cannot be null nor empty");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEval(resultClass, evaluator);
    }

    
    public final Iter3GenericUniqTargetOperator<?> eval(final Evaluator<T,Object> evaluator) {
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEval(null, evaluator);
    }
    
    
}

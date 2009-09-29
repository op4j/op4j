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
package org.op4j.op.interfaces;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

import org.op4j.type.Type;
import org.op4j.typescheme.TypeScheme;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface GenericOperator<T>
        extends Operator<T> {

    
    public GenericMultiTargetOperator<T> add(final T newTarget);
    public GenericMultiTargetOperator<T> addAll(final T... newTargets);

    public GenericMultiTargetOperator<?> addObj(final Object newTarget);
    public GenericMultiTargetOperator<?> addAllObjs(final Object... newTargets);
    
    public GenericMultiTargetOperator<T> ins(final int pos, final T newTarget);
    public GenericMultiTargetOperator<T> insAll(final int pos, final T... newTargets);

    public GenericMultiTargetOperator<?> insObj(final int pos, final Object newTarget);
    public GenericMultiTargetOperator<?> insAllObjs(final int pos, final Object... newTargets);
    
    public GenericUniqTargetOperator<?> to(
            final Type resultType, final Object... parameters);
    public GenericUniqTargetOperator<?> to(
            final String resultTypeName, final Object... parameters);
    public <X> GenericUniqTargetOperator<X> to(
            final Class<X> resultClass, final Object... parameters);
    
    public GenericUniqTargetOperator<Byte> toByte(final Object... parameters);
    public GenericUniqTargetOperator<Short> toShort(final Object... parameters);
    public GenericUniqTargetOperator<Integer> toInteger(final Object... parameters);
    public GenericUniqTargetOperator<Long> toLong(final Object... parameters);
    public GenericUniqTargetOperator<Float> toFloat(final Object... parameters);
    public GenericUniqTargetOperator<Double> toDouble(final Object... parameters);
    public GenericUniqTargetOperator<BigInteger> toBigInteger(final Object... parameters);
    public GenericUniqTargetOperator<BigDecimal> toBigDecimal(final Object... parameters);
    public GenericUniqTargetOperator<Boolean> toBoolean(final Object... parameters);
    public GenericUniqTargetOperator<Calendar> toCalendar(final Object... parameters);
    public GenericUniqTargetOperator<String> toStr(final Object... parameters);
    
    public GenericUniqTargetOperator<?> eval(
            final String expression, final Object... optionalExpParams);
    public <X> GenericUniqTargetOperator<X> eval(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams);
    public GenericUniqTargetOperator<?> eval(
            final Evaluator<T,Object> evaluator);
    public <X> GenericUniqTargetOperator<X> eval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator);

    public GenericUniqTargetOperator<?> exec(
            final String operationName, final Object... parameters);
    public <X> GenericUniqTargetOperator<X> exec(
            final Class<X> resultClass, final String operationName, final Object... parameters);
    
    public <X> GenericOperator<X> as(final Class<X> newOperatorClass);
    
    public GenericOperator<T> cast(final TypeScheme typeScheme);
    public GenericOperator<T> cast(final String typeSchemeName);
    
    
}

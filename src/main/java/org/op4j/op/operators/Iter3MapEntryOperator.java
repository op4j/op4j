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
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.MapEntryIteratingOperator;
import org.op4j.type.Type;
import org.op4j.type.Types;
import org.op4j.util.TypeAggregationUtils;
import org.op4j.util.UniqResultConverterUtils;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Iter3MapEntryOperator<K,V> 
        extends Iter3AbstractOperator<Map.Entry<K,V>>
        implements MapEntryIteratingOperator<K,V> {

    
    private final Type operatorKeyType;
    private final Type operatorValueType;
    

    Iter3MapEntryOperator(
            final Type operatorKeyType, final Type operatorValueType, final List<Iter2MapEntryOperator<K,V>> iterationComponents) {
        super(iterationComponents);
        this.operatorKeyType = operatorKeyType;
        this.operatorValueType = operatorValueType;
    }
    
    
    Iter3MapEntryOperator(final Class<K> operatorKeyClass, final Class<V> operatorValueClass, final List<Iter2MapEntryOperator<K,V>> iterationComponents) {
        this((operatorKeyClass != null? Types.getRawTypeForClass(operatorKeyClass) : null), (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), iterationComponents);
    }
    
    
    Iter3MapEntryOperator(final Type operatorKeyType, final Class<V> operatorValueClass, final List<Iter2MapEntryOperator<K,V>> iterationComponents) {
        this(operatorKeyType, (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), iterationComponents);
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<Iter2MapEntryOperator<K,V>> getTargets() {
        return (List<Iter2MapEntryOperator<K,V>>) getAbstractTargets();
    }
    
    
    final Type getOperatorKeyType() {
        return this.operatorKeyType;
    }
    
    
    final Type getOperatorValueType() {
        return this.operatorValueType;
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter3MapEntryOperator<?,?> unsafeRaw() {
        final List<Iter2MapEntryOperator<?,?>> components = 
            new ArrayList<Iter2MapEntryOperator<?,?>>();
        for (Iter2MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeRaw());
        }
        return new Iter3MapEntryOperator((Type) null, (Type) null, components);
    }
    
    
    public final Iter3MapEntryOperator<?,?> raw() {
        return unsafeRaw();
    }

    
    @SuppressWarnings("unchecked")
    final Iter3GenericUniqTargetOperator<Map.Entry<K,V>> unsafeGeneric() {
        final List<Iter2GenericUniqTargetOperator<Map.Entry<K,V>>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<Map.Entry<K,V>>>();
        for (Iter2MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeGeneric());
        }
        return new Iter3GenericUniqTargetOperator(
                TypeAggregationUtils.createMapEntryOfType(getOperatorKeyType(), getOperatorValueType()),
                components);
    }

    
    public final Iter3GenericUniqTargetOperator<Map.Entry<K,V>> generic() {
        return unsafeGeneric();
    }
    

    final <X> Iter3MapEntryOperator<K,X> unsafeExecUniqOnValue(
            final Class<X> resultClass, 
            final String operationName, final List<Object> parameters) {
        final List<Iter2MapEntryOperator<K,X>> components = 
            new ArrayList<Iter2MapEntryOperator<K,X>>();
        for (Iter2MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeExecUniqOnValue(resultClass, operationName, parameters));
        }
        return new Iter3MapEntryOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }
    

    public final Iter3MapEntryOperator<K,?> execUniqOnValue(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeExecUniqOnValue(null, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final <X> Iter3MapEntryOperator<K,X> execUniqOnValue(
            final Class<X> resultClass, final String operationName, 
            final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeExecUniqOnValue(resultClass, operationName, OperatorUtils.safeOperationParameters(parameters));
    }


    final <X> Iter3MapEntryOperator<K,X> unsafeToOnValue(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        return unsafeExecUniqOnValue(
                resultClass,
                UniqResultConverterUtils.unsafeGetOperationNameForResultType(resultType),
                parameters);
    }

    
    final <X> Iter3MapEntryOperator<K,X> unsafeToOnValue(
            final Class<X> resultClass, final List<Object> parameters) {
        return unsafeToOnValue(resultClass, Types.getRawTypeForClass(resultClass),parameters).unsafeAsMapEntry(resultClass);
    }

    
    public final Iter3MapEntryOperator<K,?> toOnValue(
            final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeToOnValue(null, resultType, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final Iter3MapEntryOperator<K,?> toOnValue(
            final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeToOnValue(null, Types.forName(resultTypeName), OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter3MapEntryOperator<K,X> toOnValue(
            final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeToOnValue(resultClass, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final Iter3MapEntryOperator<K,Byte> toByteOnValue(final Object... parameters) {
        return unsafeToOnValue(Byte.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3MapEntryOperator<K,Short> toShortOnValue(final Object... parameters) {
        return unsafeToOnValue(Short.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3MapEntryOperator<K,Integer> toIntegerOnValue(final Object... parameters) {
        return unsafeToOnValue(Integer.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3MapEntryOperator<K,Long> toLongOnValue(final Object... parameters) {
        return unsafeToOnValue(Long.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3MapEntryOperator<K,Float> toFloatOnValue(final Object... parameters) {
        return unsafeToOnValue(Float.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3MapEntryOperator<K,Double> toDoubleOnValue(final Object... parameters) {
        return unsafeToOnValue(Double.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3MapEntryOperator<K,BigInteger> toBigIntegerOnValue(final Object... parameters) {
        return unsafeToOnValue(BigInteger.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3MapEntryOperator<K,BigDecimal> toBigDecimalOnValue(final Object... parameters) {
        return unsafeToOnValue(BigDecimal.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3MapEntryOperator<K,Boolean> toBooleanOnValue(final Object... parameters) {
        return unsafeToOnValue(Boolean.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3MapEntryOperator<K,Calendar> toCalendarOnValue(final Object... parameters) {
        return unsafeToOnValue(Calendar.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter3MapEntryOperator<K,String> toStrOnValue(final Object... parameters) {
        return unsafeToOnValue(String.class, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    final Iter3MapEntryOperator<K,V> unsafeCastMapEntry(final Type keyType, final Type valueType) {
        final List<Iter2MapEntryOperator<K,V>> components = 
            new ArrayList<Iter2MapEntryOperator<K,V>>();
        for (Iter2MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeCastMapEntry(keyType, valueType));
        }
        return new Iter3MapEntryOperator<K,V>(
                getOperatorKeyType(), getOperatorValueType(),
                components);
    }

    
    public final Iter3MapEntryOperator<K,V> castMapEntry(final String keyTypeName, final String valueTypeName) {
        Validate.notNull(keyTypeName, "Key type name cannot be null");
        Validate.notNull(valueTypeName, "Value type name cannot be null");
        return unsafeCastMapEntry(Types.forName(keyTypeName), Types.forName(valueTypeName));
    }
    
    
    public final Iter3MapEntryOperator<K,V> castMapEntry(final Type keyType, final Type valueType) {
        Validate.notNull(keyType, "Key type cannot be null");
        Validate.notNull(valueType, "Value type cannot be null");
        return unsafeCastMapEntry(keyType, valueType);
    }
    
    
    final <X,Y> Iter3MapEntryOperator<X,Y> unsafeAsMapEntry(final Class<X> keyClass, final Class<Y> valueClass) {
        // Note that "as" operations make casts dissapear
        final List<Iter2MapEntryOperator<X,Y>> components = 
            new ArrayList<Iter2MapEntryOperator<X,Y>>();
        for (Iter2MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeAsMapEntry(keyClass, valueClass));
        }
        return new Iter3MapEntryOperator<X,Y>(keyClass, valueClass, components);
    }
    
    
    final <Y> Iter3MapEntryOperator<K,Y> unsafeAsMapEntry(final Class<Y> valueClass) {
        // Note that "as" operations make casts dissapear
        final List<Iter2MapEntryOperator<K,Y>> components = 
            new ArrayList<Iter2MapEntryOperator<K,Y>>();
        for (Iter2MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeAsMapEntry(valueClass));
        }
        return new Iter3MapEntryOperator<K,Y>(getOperatorKeyType(), valueClass, components);
    }


    public final <X,Y> Iter3MapEntryOperator<X,Y> asMapEntry(final Class<X> keyClass, final Class<Y> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsMapEntry(keyClass, valueClass);
    }

    
    final <X> Iter3MapEntryOperator<K,X> unsafeEvalOnValue(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        final List<Iter2MapEntryOperator<K,X>> components = 
            new ArrayList<Iter2MapEntryOperator<K,X>>();
        for (Iter2MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEvalOnValue(resultClass, expression, parameters));
        }
        return new Iter3MapEntryOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }

    
    final <X> Iter3MapEntryOperator<K,X> unsafeEvalOnValue(
            final Class<X> resultClass, final Evaluator<V,X> evaluator) {
        final List<Iter2MapEntryOperator<K,X>> components = 
            new ArrayList<Iter2MapEntryOperator<K,X>>();
        for (Iter2MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEvalOnValue(resultClass, evaluator));
        }
        return new Iter3MapEntryOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }

    
    public final Iter3MapEntryOperator<K,?> evalOnValue(
            final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEvalOnValue(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter3MapEntryOperator<K,X> evalOnValue(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Return class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEvalOnValue(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter3MapEntryOperator<K,X> evalOnValue(final Class<X> resultClass, final Evaluator<V,X> evaluator) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEvalOnValue(resultClass, evaluator);
    }

    
    public final Iter3MapEntryOperator<K,?> evalOnValue(final Evaluator<V,Object> evaluator) {
        return unsafeEvalOnValue(null, evaluator);
    }
    

    final <X> Iter3MapEntryOperator<K,X> unsafeCallOnValue(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        final List<Iter2MapEntryOperator<K,X>> components = 
            new ArrayList<Iter2MapEntryOperator<K,X>>();
        for (Iter2MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeCallOnValue(resultClass, methodName, arguments));
        }
        return new Iter3MapEntryOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }
    

    public final Iter3MapEntryOperator<K,?> callOnValue(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeCallOnValue(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter3MapEntryOperator<K,X> callOnValue(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeCallOnValue(resultClass, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }


    final Iter3MapEntryOperator<K,V> unsafeFilter(
            final String expression, final List<Object> parameters) {
        final List<Iter2MapEntryOperator<K,V>> components = 
            new ArrayList<Iter2MapEntryOperator<K,V>>();
        for (Iter2MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeFilter(expression, parameters));
        }
        return new Iter3MapEntryOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }

    
    final Iter3MapEntryOperator<K,V> unsafeFilter(final Filter<Map.Entry<K,V>> filter) {
        final List<Iter2MapEntryOperator<K,V>> components = 
            new ArrayList<Iter2MapEntryOperator<K,V>>();
        for (Iter2MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeFilter(filter));
        }
        return new Iter3MapEntryOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }


    public final Iter3MapEntryOperator<K,V> filter(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeFilter(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

    
    public final Iter3MapEntryOperator<K,V> filter(final Filter<Map.Entry<K,V>> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeFilter(filter);
    }


    final Iter2IterableMapOperator<K,V> unsafeUneachMap() {
        final List<Iter1IterableMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableMapOperator<K,V>>();
        for (Iter2MapEntryOperator<K,V> target : getTargets()) {
            components.add(target.unsafeUneachMap());
        }
        return new Iter2IterableMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }


    final Iter2IterableListMapOperator<K,V> unsafeUneachListMap() {
        final List<Iter1IterableListMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableListMapOperator<K,V>>();
        for (Iter2MapEntryOperator<K,V> target : getTargets()) {
            components.add(target.unsafeUneachListMap());
        }
        return new Iter2IterableListMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }


    final Iter2IterableSetMapOperator<K,V> unsafeUneachSetMap() {
        final List<Iter1IterableSetMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableSetMapOperator<K,V>>();
        for (Iter2MapEntryOperator<K,V> target : getTargets()) {
            components.add(target.unsafeUneachSetMap());
        }
        return new Iter2IterableSetMapOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
    }


    public final Iter2IterableMapOperator<K,V> uneachMap() {
        return unsafeUneachMap();
    }


    public final Iter2IterableListMapOperator<K,V> uneachListMap() {
        return unsafeUneachListMap();
    }


    public final Iter2IterableSetMapOperator<K,V> uneachSetMap() {
        return unsafeUneachSetMap();
    }
    
    
}

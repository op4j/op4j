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
import org.op4j.exceptions.InvalidExpressionException;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.FilterContext;
import org.op4j.op.interfaces.MapEntryIteratingOperator;
import org.op4j.operation.MapEntryTarget;
import org.op4j.type.Type;
import org.op4j.type.Types;
import org.op4j.util.OgnlUtils;
import org.op4j.util.TypeAggregationUtils;
import org.op4j.util.ConverterUtils;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Iter1MapEntryOperator<K,V> 
        extends Iter1AbstractOperator<Map.Entry<K,V>>
        implements MapEntryIteratingOperator<K,V> {

    
    private final Type operatorKeyType;
    private final Type operatorValueType;
    

    Iter1MapEntryOperator(
            final Type operatorKeyType, final Type operatorValueType, final List<Iter0MapEntryOperator<K,V>> iterationComponents) {
        super(iterationComponents);
        this.operatorKeyType = operatorKeyType;
        this.operatorValueType = operatorValueType;
    }
    
    
    Iter1MapEntryOperator(final Class<K> operatorKeyClass, final Class<V> operatorValueClass, final List<Iter0MapEntryOperator<K,V>> iterationComponents) {
        this((operatorKeyClass != null? Types.getRawTypeForClass(operatorKeyClass) : null), (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), iterationComponents);
    }
    
    
    Iter1MapEntryOperator(final Type operatorKeyType, final Class<V> operatorValueClass, final List<Iter0MapEntryOperator<K,V>> iterationComponents) {
        this(operatorKeyType, (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), iterationComponents);
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<Iter0MapEntryOperator<K,V>> getTargets() {
        return (List<Iter0MapEntryOperator<K,V>>) getAbstractTargets();
    }
    
    
    final Type getOperatorKeyType() {
        return this.operatorKeyType;
    }
    
    
    final Type getOperatorValueType() {
        return this.operatorValueType;
    }
    
    
    @SuppressWarnings("unchecked")
    final Iter1MapEntryOperator<?,?> unsafeRaw() {
        final List<Iter0MapEntryOperator<?,?>> components = 
            new ArrayList<Iter0MapEntryOperator<?,?>>();
        for (Iter0MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeRaw());
        }
        return new Iter1MapEntryOperator((Type) null, (Type) null, components);
    }
    
    
    public final Iter1MapEntryOperator<?,?> raw() {
        return unsafeRaw();
    }

    
    @SuppressWarnings("unchecked")
    final Iter1GenericUniqTargetOperator<Map.Entry<K,V>> unsafeGeneric() {
        final List<Iter0GenericUniqTargetOperator<Map.Entry<K,V>>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<Map.Entry<K,V>>>();
        for (Iter0MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeGeneric());
        }
        return new Iter1GenericUniqTargetOperator(
                TypeAggregationUtils.createMapEntryOfType(getOperatorKeyType(), getOperatorValueType()),
                components);
    }

    
    public final Iter1GenericUniqTargetOperator<Map.Entry<K,V>> generic() {
        return unsafeGeneric();
    }
    

    final <X> Iter1MapEntryOperator<K,X> unsafeExecOnValue(
            final Class<X> resultClass, 
            final String operationName, final List<Object> parameters) {
        final List<Iter0MapEntryOperator<K,X>> components = 
            new ArrayList<Iter0MapEntryOperator<K,X>>();
        for (Iter0MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeExecOnValue(resultClass, operationName, parameters));
        }
        return new Iter1MapEntryOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }
    

    public final Iter1MapEntryOperator<K,?> execOnValue(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeExecOnValue(null, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final <X> Iter1MapEntryOperator<K,X> execOnValue(
            final Class<X> resultClass, final String operationName, 
            final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeExecOnValue(resultClass, operationName, OperatorUtils.safeOperationParameters(parameters));
    }


    final <X> Iter1MapEntryOperator<K,X> unsafeToOnValue(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        return unsafeExecOnValue(
                resultClass,
                ConverterUtils.unsafeGetOperationNameForResultType(resultType),
                parameters);
    }

    
    final <X> Iter1MapEntryOperator<K,X> unsafeToOnValue(
            final Class<X> resultClass, final List<Object> parameters) {
        return unsafeToOnValue(resultClass, Types.getRawTypeForClass(resultClass),parameters).unsafeAsMapEntry(resultClass);
    }

    
    public final Iter1MapEntryOperator<K,?> toOnValue(
            final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeToOnValue(null, resultType, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final Iter1MapEntryOperator<K,?> toOnValue(
            final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeToOnValue(null, Types.forName(resultTypeName), OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter1MapEntryOperator<K,X> toOnValue(
            final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeToOnValue(resultClass, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final Iter1MapEntryOperator<K,Byte> toByteOnValue(final Object... parameters) {
        return unsafeToOnValue(Byte.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1MapEntryOperator<K,Short> toShortOnValue(final Object... parameters) {
        return unsafeToOnValue(Short.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1MapEntryOperator<K,Integer> toIntegerOnValue(final Object... parameters) {
        return unsafeToOnValue(Integer.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1MapEntryOperator<K,Long> toLongOnValue(final Object... parameters) {
        return unsafeToOnValue(Long.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1MapEntryOperator<K,Float> toFloatOnValue(final Object... parameters) {
        return unsafeToOnValue(Float.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1MapEntryOperator<K,Double> toDoubleOnValue(final Object... parameters) {
        return unsafeToOnValue(Double.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1MapEntryOperator<K,BigInteger> toBigIntegerOnValue(final Object... parameters) {
        return unsafeToOnValue(BigInteger.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1MapEntryOperator<K,BigDecimal> toBigDecimalOnValue(final Object... parameters) {
        return unsafeToOnValue(BigDecimal.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1MapEntryOperator<K,Boolean> toBooleanOnValue(final Object... parameters) {
        return unsafeToOnValue(Boolean.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1MapEntryOperator<K,Calendar> toCalendarOnValue(final Object... parameters) {
        return unsafeToOnValue(Calendar.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter1MapEntryOperator<K,String> toStrOnValue(final Object... parameters) {
        return unsafeToOnValue(String.class, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    final Iter1MapEntryOperator<K,V> unsafeCastMapEntry(final Type keyType, final Type valueType) {
        final List<Iter0MapEntryOperator<K,V>> components = 
            new ArrayList<Iter0MapEntryOperator<K,V>>();
        for (Iter0MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeCastMapEntry(keyType, valueType));
        }
        return new Iter1MapEntryOperator<K,V>(
                getOperatorKeyType(), getOperatorValueType(),
                components);
    }

    
    public final Iter1MapEntryOperator<K,V> castMapEntry(final String keyTypeName, final String valueTypeName) {
        Validate.notNull(keyTypeName, "Key type name cannot be null");
        Validate.notNull(valueTypeName, "Value type name cannot be null");
        return unsafeCastMapEntry(Types.forName(keyTypeName), Types.forName(valueTypeName));
    }
    
    
    public final Iter1MapEntryOperator<K,V> castMapEntry(final Type keyType, final Type valueType) {
        Validate.notNull(keyType, "Key type cannot be null");
        Validate.notNull(valueType, "Value type cannot be null");
        return unsafeCastMapEntry(keyType, valueType);
    }
    
    
    final <Y> Iter1MapEntryOperator<K,Y> unsafeAsMapEntry(final Class<Y> valueClass) {
        // Note that "as" operations make casts dissapear
        final List<Iter0MapEntryOperator<K,Y>> components = 
            new ArrayList<Iter0MapEntryOperator<K,Y>>();
        for (Iter0MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeAsMapEntry(valueClass));
        }
        return new Iter1MapEntryOperator<K,Y>(getOperatorKeyType(), valueClass, components);
    }
    
    
    final <X,Y> Iter1MapEntryOperator<X,Y> unsafeAsMapEntry(final Class<X> keyClass, final Class<Y> valueClass) {
        // Note that "as" operations make casts dissapear
        final List<Iter0MapEntryOperator<X,Y>> components = 
            new ArrayList<Iter0MapEntryOperator<X,Y>>();
        for (Iter0MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeAsMapEntry(keyClass, valueClass));
        }
        return new Iter1MapEntryOperator<X,Y>(keyClass, valueClass, components);
    }


    public final <X,Y> Iter1MapEntryOperator<X,Y> asMapEntry(final Class<X> keyClass, final Class<Y> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsMapEntry(keyClass, valueClass);
    }

    
    final <X> Iter1MapEntryOperator<K,X> unsafeEvalOnValue(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        final List<Iter0MapEntryOperator<K,X>> components = 
            new ArrayList<Iter0MapEntryOperator<K,X>>();
        for (Iter0MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEvalOnValue(resultClass, expression, parameters));
        }
        return new Iter1MapEntryOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }

    
    final <X> Iter1MapEntryOperator<K,X> unsafeEvalOnValue(
            final Class<X> resultClass, final Evaluator<V,X> evaluator) {
        final List<Iter0MapEntryOperator<K,X>> components = 
            new ArrayList<Iter0MapEntryOperator<K,X>>();
        for (Iter0MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeEvalOnValue(resultClass, evaluator));
        }
        return new Iter1MapEntryOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }

    
    public final Iter1MapEntryOperator<K,?> evalOnValue(
            final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEvalOnValue(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter1MapEntryOperator<K,X> evalOnValue(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Return class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEvalOnValue(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter1MapEntryOperator<K,X> evalOnValue(final Class<X> resultClass, final Evaluator<V,X> evaluator) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEvalOnValue(resultClass, evaluator);
    }

    
    public final Iter1MapEntryOperator<K,?> evalOnValue(final Evaluator<V,Object> evaluator) {
        return unsafeEvalOnValue(null, evaluator);
    }
    

    final <X> Iter1MapEntryOperator<K,X> unsafeCallOnValue(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        final List<Iter0MapEntryOperator<K,X>> components = 
            new ArrayList<Iter0MapEntryOperator<K,X>>();
        for (Iter0MapEntryOperator<K,V> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeCallOnValue(resultClass, methodName, arguments));
        }
        return new Iter1MapEntryOperator<K,X>(getOperatorKeyType(), resultClass, components);
    }
    

    public final Iter1MapEntryOperator<K,?> callOnValue(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeCallOnValue(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter1MapEntryOperator<K,X> callOnValue(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeCallOnValue(resultClass, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }


    final Iter1MapEntryOperator<K,V> unsafeFilter(
            final String expression, final List<Object> parameters) {

        final List<Iter0MapEntryOperator<K,V>> components = 
            new ArrayList<Iter0MapEntryOperator<K,V>>();
        for (Iter0MapEntryOperator<K,V> targetOp : this.getTargets()) {
            
            final MapEntryTarget<K,V> target = targetOp.getTargets().get(0);
            
            final Object targetOpResult =
                OgnlUtils.getValueByOgnlExpression(target.getObject(), expression, parameters);
            if (!(targetOpResult instanceof Boolean)) {
                throw new InvalidExpressionException("Expression \"" + expression + 
                        "\" did not evaluate to boolean result");
            }
            if (!((Boolean)targetOpResult).booleanValue()) {
                components.add(targetOp);
            }
            
        }
        return new Iter1MapEntryOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
        
    }

    
    final Iter1MapEntryOperator<K,V> unsafeFilter(final Filter<Map.Entry<K,V>> filter) {

        final List<Iter0MapEntryOperator<K,V>> components = 
            new ArrayList<Iter0MapEntryOperator<K,V>>();
        for (Iter0MapEntryOperator<K,V> targetOp : this.getTargets()) {
            
            final MapEntryTarget<K,V> target = targetOp.getTargets().get(0);
            
            final FilterContext<Map.Entry<K,V>> filterContext =
                new FilterContextImpl<Map.Entry<K,V>>(target.getObject());
            if (!filter.eval(filterContext)) {
                components.add(targetOp);
            }
            
        }
        return new Iter1MapEntryOperator<K,V>(getOperatorKeyType(), getOperatorValueType(), components);
        
    }


    public final Iter1MapEntryOperator<K,V> filter(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeFilter(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

    
    public final Iter1MapEntryOperator<K,V> filter(final Filter<Map.Entry<K,V>> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeFilter(filter);
    }


    final Iter0IterableMapOperator<K,V> unsafeUneachMap() {
        return new Iter0IterableMapOperator<K,V>(
                getOperatorKeyType(), getOperatorValueType(),
                OperatorAggregationUtils.buildMapFromMapEntryTargets(getInnerUniqTargetObjects()));
    }


    final Iter0IterableListMapOperator<K,V> unsafeUneachListMap() {
        return new Iter0IterableListMapOperator<K,V>(
                getOperatorKeyType(), getOperatorValueType(),
                OperatorAggregationUtils.buildListMapFromMapEntryTargets(getInnerUniqTargetObjects()));
    }


    final Iter0IterableSetMapOperator<K,V> unsafeUneachSetMap() {
        return new Iter0IterableSetMapOperator<K,V>(
                getOperatorKeyType(), getOperatorValueType(),
                OperatorAggregationUtils.buildSetMapFromMapEntryTargets(getInnerUniqTargetObjects()));
    }


    final Iter0IterableArrayMapOperator<K,V> unsafeUneachArrayMap() {
        return new Iter0IterableArrayMapOperator<K,V>(
                getOperatorKeyType(), getOperatorValueType(),
                OperatorAggregationUtils.buildArrayMapFromMapEntryTargets(getOperatorValueType(), getInnerUniqTargetObjects()));
    }


    public final Iter0IterableMapOperator<K,V> uneachMap() {
        return unsafeUneachMap();
    }


    public final Iter0IterableListMapOperator<K,V> uneachListMap() {
        return unsafeUneachListMap();
    }


    public final Iter0IterableSetMapOperator<K,V> uneachSetMap() {
        return unsafeUneachSetMap();
    }


    public final Iter0IterableArrayMapOperator<K,V> uneachArrayMap() {
        return unsafeUneachArrayMap();
    }

    
}

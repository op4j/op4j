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

import java.beans.Expression;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.op4j.exceptions.InvalidExpressionResultClassException;
import org.op4j.exceptions.InvalidOperatorCastException;
import org.op4j.exceptions.MethodInvocationException;
import org.op4j.exceptions.NullTargetException;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.MapEntryOperator;
import org.op4j.operation.MapEntryTarget;
import org.op4j.operation.Target;
import org.op4j.type.Type;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;
import org.op4j.util.MapEntry;
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
public final class Iter0MapEntryOperator<K,V> 
        extends Iter0AbstractOperator<Map.Entry<K,V>>
        implements MapEntryOperator<K,V> {

    
    private final Type operatorKeyType;
    private final Type operatorValueType;
    
    

    /*
     *  Targets are created for each object computing intended type as:
     *    
     *    (for both key and value types)
     *  
     *    - If operator*Type is not null -> operator*Type
     *    - Else:
     *        - If object is not null -> component(rawtype(object))
     *        - Else: Object
     *
     *  Map.Entry objects are treated like Generics instead of like Lists 
     *  or Sets because execution operations (like "call" or "exec" are
     *  only executed on the entry's value, and not on the whole object.
     *  If we didn't use the rawtype when operatorType == null, we would
     *  be losing too much information
     *   
     */
    @SuppressWarnings("unchecked")
    private static MapEntryTarget<?,?> prepareTargets(
            final Type operatorKeyType, final Type operatorValueClass, 
            final Map.Entry<?,?> object) {
        
        return new MapEntryTarget(
                (operatorKeyType != null? 
                        operatorKeyType :
                        ((object != null && object.getKey() != null)?
                                Types.getRawTypeForObject(object.getKey()) :
                                Types.OBJECT)), 
                (operatorValueClass != null? 
                        operatorValueClass :
                        ((object != null && object.getValue() != null)?
                                Types.getRawTypeForObject(object.getValue()) :
                                Types.OBJECT)), 
                object);
        
    }
    

    /*
     *  Targets are created for each object computing intended type as Map.Entry<keyType,valueType>.
     *  
     */
    @SuppressWarnings("unchecked")
    private static MapEntryTarget<?,?> prepareCastedTargets(
            final Type keyType, final Type valueType, 
            final Map.Entry<?,?> object) {
        
        return new MapEntryTarget(keyType, valueType, object);
        
    }
    
    
    Iter0MapEntryOperator(final Class<K> operatorKeyClass, final Class<V> operatorValueClass, final Map.Entry<?,?> object) {
        this((operatorKeyClass != null? Types.getRawTypeForClass(operatorKeyClass) : null), (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), object);
    }
    
    
    Iter0MapEntryOperator(final Type operatorKeyType, final Class<V> operatorValueClass, final Map.Entry<?,?> object) {
        this(operatorKeyType, (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), object);
    }
    
    
    @SuppressWarnings("unchecked")
    Iter0MapEntryOperator(
            final Type operatorKeyType, final Type operatorValueType, 
            final Map.Entry<?,?> object) {
        
        super((MapEntryTarget) prepareTargets(operatorKeyType, operatorValueType, object));
        this.operatorKeyType = operatorKeyType;
        this.operatorValueType = operatorValueType;
        /*
         * Check that the intended type is always compatible with the operator type.
         */
        checkOperatorType(this.operatorKeyType, this.operatorValueType, getTargets().get(0).getIntendedType());
        
    }
    
    
    Iter0MapEntryOperator(final Type operatorKeyType, final Class<V> operatorValueClass, final Type keyType, final Class<V> valueClass, final Map.Entry<?,?> object) {
        this(operatorKeyType, (operatorValueClass != null? Types.getRawTypeForClass(operatorValueClass) : null), keyType, (valueClass != null? Types.getRawTypeForClass(valueClass) : null), object);
    }
    

    @SuppressWarnings("unchecked")
    Iter0MapEntryOperator(
            final Type operatorKeyType, final Type operatorValueType, 
            final Type keyType, final Type valueType, 
            final Map.Entry<?,?> object) {
        
        super((MapEntryTarget) prepareCastedTargets(keyType, valueType, object));
        this.operatorKeyType = operatorKeyType;
        this.operatorValueType = operatorValueType;
        /*
         * Check that the intended type is always compatible with the operator type.
         */
        checkOperatorType(this.operatorKeyType, this.operatorValueType, getTargets().get(0).getIntendedType());
        
    }
    
    
    private static void checkOperatorType(final Type operatorKeyType, final Type operatorValueType, final Type intendedType) {
        final Type operatorType = 
            TypeAggregationUtils.createMapEntryOfType(operatorKeyType, operatorValueType);
        if (!operatorType.isAssignableFrom(intendedType)) {
            throw new InvalidOperatorCastException(operatorType, intendedType);
        }
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<MapEntryTarget<K,V>> getTargets() {
        return (List<MapEntryTarget<K,V>>) getAbstractTargets();
    }
    
    
    final Type getOperatorKeyType() {
        return this.operatorKeyType;
    }
    
    
    final Type getOperatorValueType() {
        return this.operatorValueType;
    }
    
    
    final Iter0MapEntryOperator<?,?> unsafeRaw() {
        return new Iter0MapEntryOperator<Object,Object>(
                (Type) null, (Type) null, getTargetObjects().get(0));
    }
    
    
    public final Iter0MapEntryOperator<?,?> raw() {
        return unsafeRaw();
    }


    @SuppressWarnings("unchecked")
    final Iter0GenericUniqTargetOperator<Map.Entry<K,V>> unsafeGeneric() {
        final Target<? extends Map.Entry<?,?>> target = getTargets().get(0);
        return new Iter0GenericUniqTargetOperator(
                TypeAggregationUtils.createMapEntryOfType(getOperatorKeyType(), getOperatorValueType()),
                target.getIntendedType(),
                target.getObject());
    }

    
    public final Iter0GenericUniqTargetOperator<Map.Entry<K,V>> generic() {
        return unsafeGeneric();
    }
    

    final <X> Iter0MapEntryOperator<K,X> unsafeExecUniqOnValue(
            final Class<X> resultClass, 
            final String operationName, final List<Object> parameters) {
        
        final MapEntryTarget<K,V> oldTarget = getTargets().get(0);
        
        // oldTarget.getObject().getValue() IS allowed to be null,
        // but oldTarget.getObject() should never be.
        if (areAllTargetsNull()) {
            throw new NullTargetException("execUniq");
        }
        
        final X newValue =
            OperatorUtils.createOn(oldTarget.getObject().getValue()).
                unsafeCast(TypeSchemes.forTypes(oldTarget.getMapEntryValueType())).
                unsafeExecUniq(resultClass, operationName, parameters).get();
        
        return new Iter0MapEntryOperator<K,X>(
                getOperatorKeyType(), 
                resultClass,
                oldTarget.getMapEntryKeyType(),
                resultClass,
                new MapEntry<K,X>(oldTarget.getObject().getKey(), newValue));
        
    }
    

    public final Iter0MapEntryOperator<K,?> execUniqOnValue(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeExecUniqOnValue(null, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final <X> Iter0MapEntryOperator<K,X> execUniqOnValue(
            final Class<X> resultClass, final String operationName, 
            final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeExecUniqOnValue(resultClass, operationName, OperatorUtils.safeOperationParameters(parameters));
    }


    final <X> Iter0MapEntryOperator<K,X> unsafeToOnValue(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        return unsafeExecUniqOnValue(
                resultClass,
                ConverterUtils.unsafeGetOperationNameForResultType(resultType),
                parameters);
    }


    final <X> Iter0MapEntryOperator<K,X> unsafeToOnValue(
            final Class<X> resultClass, final List<Object> parameters) {
        return unsafeToOnValue(resultClass, Types.getRawTypeForClass(resultClass), parameters);
    }


    public final Iter0MapEntryOperator<K,?> toOnValue(
            final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeToOnValue(null, resultType, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final Iter0MapEntryOperator<K,?> toOnValue(
            final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeToOnValue(null, Types.forName(resultTypeName), OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter0MapEntryOperator<K,X> toOnValue(
            final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeToOnValue(resultClass, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final Iter0MapEntryOperator<K,Byte> toByteOnValue(final Object... parameters) {
        return unsafeToOnValue(Byte.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0MapEntryOperator<K,Short> toShortOnValue(final Object... parameters) {
        return unsafeToOnValue(Short.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0MapEntryOperator<K,Integer> toIntegerOnValue(final Object... parameters) {
        return unsafeToOnValue(Integer.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0MapEntryOperator<K,Long> toLongOnValue(final Object... parameters) {
        return unsafeToOnValue(Long.class, OperatorUtils.safeOperationParameters(parameters));
    }

    
    public final Iter0MapEntryOperator<K,Float> toFloatOnValue(final Object... parameters) {
        return unsafeToOnValue(Float.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0MapEntryOperator<K,Double> toDoubleOnValue(final Object... parameters) {
        return unsafeToOnValue(Double.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0MapEntryOperator<K,BigInteger> toBigIntegerOnValue(final Object... parameters) {
        return unsafeToOnValue(BigInteger.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0MapEntryOperator<K,BigDecimal> toBigDecimalOnValue(final Object... parameters) {
        return unsafeToOnValue(BigDecimal.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0MapEntryOperator<K,Boolean> toBooleanOnValue(final Object... parameters) {
        return unsafeToOnValue(Boolean.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0MapEntryOperator<K,Calendar> toCalendarOnValue(final Object... parameters) {
        return unsafeToOnValue(Calendar.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    public final Iter0MapEntryOperator<K,String> toStrOnValue(final Object... parameters) {
        return unsafeToOnValue(String.class, OperatorUtils.safeOperationParameters(parameters));
    }
    

    final <Y> Iter0MapEntryOperator<K,Y> unsafeAsMapEntry(final Class<Y> valueClass) {
        // Note that "as" operations make casts dissapear, but this one only operates on values
        final MapEntryTarget<K,V> target = getTargets().get(0);
        return new Iter0MapEntryOperator<K,Y>(
                getOperatorKeyType(), 
                valueClass,
                target.getMapEntryKeyType(), 
                valueClass,
                target.getObject());
    }
    

    final <X,Y> Iter0MapEntryOperator<X,Y> unsafeAsMapEntry(final Class<X> keyClass, final Class<Y> valueClass) {
        // Note that "as" operations make casts dissapear
        final MapEntryTarget<K,V> target = getTargets().get(0);
        return new Iter0MapEntryOperator<X,Y>(
                keyClass,
                valueClass,
                target.getObject());
    }
    

    public final <X,Y> Iter0MapEntryOperator<X,Y> asMapEntry(final Class<X> keyClass, final Class<Y> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsMapEntry(keyClass, valueClass);
    }
    
    
    final Iter0MapEntryOperator<K,V> unsafeCastMapEntry(final Type keyType, final Type valueType) {
        final MapEntryTarget<K,V> target = getTargets().get(0);
        return new Iter0MapEntryOperator<K,V>(
                getOperatorKeyType(), getOperatorValueType(),
                keyType, valueType,
                target.getObject());
    }

    
    public final Iter0MapEntryOperator<K,V> castMapEntry(final String keyTypeName, final String valueTypeName) {
        Validate.notNull(keyTypeName, "Key type name cannot be null");
        Validate.notNull(valueTypeName, "Value type name cannot be null");
        return unsafeCastMapEntry(Types.forName(keyTypeName), Types.forName(valueTypeName));
    }
    
    
    public final Iter0MapEntryOperator<K,V> castMapEntry(final Type keyType, final Type valueType) {
        Validate.notNull(keyType, "Key type cannot be null");
        Validate.notNull(valueType, "Value type cannot be null");
        return unsafeCastMapEntry(keyType, valueType);
    }

    
    @SuppressWarnings("unchecked")
    final <X> Iter0MapEntryOperator<K,X> unsafeEvalOnValue(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {

        final MapEntryTarget<K,V> oldTarget = getTargets().get(0);
        
        // oldTarget.getObject().getValue() IS allowed to be null,
        // but oldTarget.getObject() should never be.
        if (areAllTargetsNull()) {
            throw new NullTargetException("eval");
        }
        
        final Object result =
                OgnlUtils.getValueByOgnlExpression(
                        oldTarget.getObject().getValue(), 
                        expression, parameters);
        
        if (result != null && resultClass != null) {
	        if (!resultClass.isAssignableFrom(result.getClass())) {
	            throw new InvalidExpressionResultClassException(result.getClass(), resultClass);
	        }
        }
        
        return new Iter0MapEntryOperator<K,X>(
                    getOperatorKeyType(), 
                    resultClass,
                    oldTarget.getMapEntryKeyType(),
                    resultClass,
                    new MapEntry(oldTarget.getObject().getKey(), result));
        
    }

    
    final <X> Iter0MapEntryOperator<K,X> unsafeEvalOnValue(
            final Class<X> resultClass, final Evaluator<V,X> evaluator) {

        final MapEntryTarget<K,V> oldTarget = getTargets().get(0);
        
        // oldTarget.getObject().getValue() IS allowed to be null,
        // but oldTarget.getObject() should never be.
        if (areAllTargetsNull()) {
            throw new NullTargetException("eval");
        }
        
        final EvalContextImpl<V> ctx = 
            new EvalContextImpl<V>(oldTarget.getObject().getValue());
        final X result = evaluator.evaluate(ctx);
        
        if (result != null && resultClass != null) {
	        if (!resultClass.isAssignableFrom(result.getClass())) {
	            throw new InvalidExpressionResultClassException(result.getClass(), resultClass);
	        }
        }
        
        return new Iter0MapEntryOperator<K,X>(
                getOperatorKeyType(), 
                resultClass,
                oldTarget.getMapEntryKeyType(), 
                resultClass,
                new MapEntry<K,X>(oldTarget.getObject().getKey(), result));
        
    }

    
    public final Iter0MapEntryOperator<K,?> evalOnValue(
            final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEvalOnValue(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter0MapEntryOperator<K,X> evalOnValue(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEvalOnValue(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter0MapEntryOperator<K,X> evalOnValue(final Class<X> resultClass, final Evaluator<V,X> evaluator) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEvalOnValue(resultClass, evaluator);
    }

    
    public final Iter0MapEntryOperator<K,?> evalOnValue(final Evaluator<V,Object> evaluator) {
        return unsafeEvalOnValue(null, evaluator);
    }
    

    @SuppressWarnings("unchecked")
    final <X> Iter0MapEntryOperator<K,X> unsafeCallOnValue(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {

        final MapEntryTarget<K,V> oldTarget = getTargets().get(0);
        
        // Neither oldTarget.getObject() nor oldTarget.getObject().getValue() 
        // are allowed to be null.
        if (areAllTargetsNull() || oldTarget.getObject().getValue() == null) {
            throw new NullTargetException("call");
        }
        
        final V targetValueObject = oldTarget.getObject().getValue();
        final Expression expression = 
            new Expression(targetValueObject, methodName, arguments.toArray(new Object[arguments.size()]));
        
        try {
            
            final Object resultValueObject = expression.getValue();
            return new Iter0MapEntryOperator(
                    getOperatorKeyType(), 
                    resultClass,
                    oldTarget.getMapEntryKeyType(), 
                    resultClass,
                    new MapEntry(oldTarget.getObject().getKey(), resultValueObject));
            
        } catch (Exception e) {
            throw new MethodInvocationException(methodName, targetValueObject.getClass(), e);
        }
        
    }
    

    public final Iter0MapEntryOperator<K,?> callOnValue(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeCallOnValue(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter0MapEntryOperator<K,X> callOnValue(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeCallOnValue(resultClass, methodName,OperatorUtils.safeEvaluationParameters(parameters));
    }


    public final Map.Entry<K,V> get() {
        return getTargetObjects().get(0);
    }
    
    
    
}

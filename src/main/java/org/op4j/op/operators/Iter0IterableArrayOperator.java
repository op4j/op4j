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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.op4j.exceptions.ArrayInstantiationException;
import org.op4j.exceptions.InvalidOperatorCastException;
import org.op4j.exceptions.NullTargetException;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.IterableArrayOperator;
import org.op4j.op.interfaces.MapBuilder;
import org.op4j.operation.ArrayTarget;
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
public final class Iter0IterableArrayOperator<T> 
        extends Iter0AbstractOperator<T[]>
        implements IterableArrayOperator<T> {

            
    private final Type operatorComponentType;

    
    /*
     *  Targets are created for each object computing intended type as:
     *  
     *    - If operatorComponentType is not null -> operatorComponentType
     *    - Else:
     *        - If object is not null -> component(rawtype(object))
     *        - Else: Object
     *
     *  Arrays are treated like Generics instead of like Lists or Sets because
     *  the raw type for X[] and Y[] is different, while the raw type for List<X>
     *  and List<Y> is the same. Thus, if we used Object[] for all arrays having
     *  operatorComponentType == null, we would be losing too much information.
     *  
     */
    private static ArrayTarget<?> prepareTargets(
            final Type operatorComponentType, final Object[] object) {
        
        return new ArrayTarget<Object>(
                (operatorComponentType != null? 
                        operatorComponentType :
                        (object != null?
                                Types.getRawTypeForObject(object).decreaseArrayDimensions() :
                                Types.OBJECT)), 
                object);
        
    }

    
    /*
     *  Targets are created for each object computing intended type as componentType[]
     *  
     */
    private static ArrayTarget<?> prepareCastedTargets(
            final Type componentType, final Object[] object) {
        
        return new ArrayTarget<Object>(componentType, object);
        
    }
    
    
    Iter0IterableArrayOperator(final Class<T> operatorComponentClass, final Object[] object) {
        this((operatorComponentClass != null? Types.getRawTypeForClass(operatorComponentClass) : null), object);
    }
    
    
    @SuppressWarnings("unchecked")
    Iter0IterableArrayOperator(final Type operatorComponentType, final Object[] object) {
        
        super((ArrayTarget) prepareTargets(operatorComponentType, object));
        this.operatorComponentType = operatorComponentType;
        /*
         * Check that the intended type is always compatible with the operator type.
         */
        checkOperatorType(this.operatorComponentType, getTargets().get(0).getIntendedType());
        
    }
    
    @SuppressWarnings("unchecked")
    Iter0IterableArrayOperator(final Type operatorComponentType, final Type componentType, final Object[] object) {
        
        super((ArrayTarget) prepareCastedTargets(componentType, object));
        this.operatorComponentType = operatorComponentType;
        /*
         * Check that the intended type is always compatible with the operator type.
         */
        checkOperatorType(this.operatorComponentType, getTargets().get(0).getIntendedType());
        
    }
    
    
    private static void checkOperatorType(final Type operatorComponentType, final Type intendedType) {
        final Type operatorType = TypeAggregationUtils.createArrayOfType(operatorComponentType);
        if (!operatorType.isAssignableFrom(intendedType)) {
            throw new InvalidOperatorCastException(operatorType, intendedType);
        }
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<ArrayTarget<T>> getTargets() {
        return (List<ArrayTarget<T>>) getAbstractTargets();
    }
    
    
    final Type getOperatorComponentType() {
        return this.operatorComponentType;
    }
    
    
    final Iter0IterableArrayOperator<?> unsafeRaw() {
        return new Iter0IterableArrayOperator<Object>(
                (Type) null, getTargetObjects().get(0));
    }
    
    
    public final Iter0IterableArrayOperator<?> raw() {
        return unsafeRaw();
    }
    
    
    final <X> Iter0IterableArrayOperator<X> unsafeEachExec(
            final Class<X> resultClass, final String operationName, final List<Object> parameters) {
        return unsafeEach().unsafeExec(resultClass, operationName, parameters).unsafeUneachArray();
    }
    
    
    public final Iter0IterableArrayOperator<?> eachExec(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExec(null, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter0IterableArrayOperator<X> eachExec(
            final Class<X> resultClass, final String operationName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExec(resultClass, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    final Iter1GenericUniqTargetOperator<T> unsafeEach() {
        final T[] targetObject = getTargetObjects().get(0);
        final List<Iter0GenericUniqTargetOperator<T>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<T>>();
        for (T componentObj : targetObject) {
            components.add(new Iter0GenericUniqTargetOperator<T>(getOperatorComponentType(), componentObj));
        }
        return new Iter1GenericUniqTargetOperator<T>(getOperatorComponentType(), components);
    }
    
    
    public final Iter1GenericUniqTargetOperator<T> each() {
        return unsafeEach();
    }



    final Iter0GenericUniqTargetOperator<T[]> unsafeGeneric() {
        final ArrayTarget<T> target = getTargets().get(0);
        return new Iter0GenericUniqTargetOperator<T[]>(
                TypeAggregationUtils.createArrayOfType(getOperatorComponentType()),
                target.getIntendedType(),
                target.getObject());
    }

    
    public final Iter0GenericUniqTargetOperator<T[]> generic() {
        return unsafeGeneric();
    }


    @SuppressWarnings("unchecked")
    final Iter0IterableArrayOperator<T> unsafeDistinct() {
        
        final ArrayTarget<T> target = this.getTargets().get(0);
        
        if (areAllTargetsNull()) {
            throw new NullTargetException("distinct");
        }
        
        final T[] targetObject = target.getObject();
        final List<T> newTargetObjectList = new ArrayList<T>();
        final Set<T> existingObjects = new HashSet<T>();
        for (T element : targetObject) {
            if (!existingObjects.contains(element)) {
                newTargetObjectList.add(element);
                existingObjects.add(element);
            }
        }
        final Type originalArrayType = Types.getRawTypeForObject(targetObject);
        try {
            
            final T[] newTargetObject = 
                newTargetObjectList.toArray((T[])originalArrayType.newInstance());
            return new Iter0IterableArrayOperator<T>(
                    getOperatorComponentType(), target.getArrayComponentType(), newTargetObject);
            
        } catch (Exception e) {
            // This should never happen
            throw new ArrayInstantiationException(originalArrayType, e); 
        }
        
    }


    public final Iter0IterableArrayOperator<T> distinct() {
        return unsafeDistinct();
    }

    
    final Iter0GenericMultiTargetOperator<T> unsafeFlat() {
        return new Iter0GenericMultiTargetOperator<T>(
                getOperatorComponentType(), Arrays.asList(getTargetObjects().get(0)));
    }

    
    public final Iter0GenericMultiTargetOperator<T> flat() {
        return unsafeFlat();
    }


    final <X> Iter0IterableArrayOperator<X> unsafeAsArray(final Class<X> ofClass) {
        // Note that "as" operations make casts dissapear
        return unsafeGeneric().unsafeAsArray(ofClass);
    }


    public final <X> Iter0IterableArrayOperator<X> asArray(final Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeAsArray(ofClass);
    }


    final Iter0IterableArrayOperator<T> unsafeSort() {
        return unsafeSort(null); // comparator == null
    }


    public final Iter0IterableArrayOperator<T> sort() {
        return unsafeSort();
    }


    @SuppressWarnings("unchecked")
    final Iter0IterableArrayOperator<T> unsafeSort(final Comparator<? super T> comparator) {
        
        final ArrayTarget<T> target = getTargets().get(0);
        
        if (areAllTargetsNull()) {
            throw new NullTargetException("sort");
        }
        
        // The array raw type will be needed to create an instance for the new array
        final Type arrayRawType = Types.getRawTypeForObject(target.getObject());
        /*
         * This collection is intentionally type-unsafe as we cannot know
         * whether T is Comparable or not until runtime.
         */
        final List newTargetListObject = 
            new ArrayList(Arrays.asList(target.getObject()));
        Collections.sort(newTargetListObject, comparator);
        Object[] newTargetObject = null;
        try {
            newTargetObject = 
                newTargetListObject.toArray((Object[])arrayRawType.newInstance());
        } catch (Exception e) {
            // This should never happen
            throw new ArrayInstantiationException(arrayRawType, e); 
        }
        
        return new Iter0IterableArrayOperator<T>(
                getOperatorComponentType(),
                target.getArrayComponentType(),
                newTargetObject);
    }


    public final Iter0IterableArrayOperator<T> sort(final Comparator<? super T> comparator) {
        // Comparator can be null. This is to adhere to the Collections.sort(...) API.
        return unsafeSort(comparator);
    }


    final Iter0IterableArrayOperator<T> unsafeEachFilter(
            final String expression, final List<Object> parameters) {
        if (areAllTargetsNull()) {
            throw new NullTargetException("eachFilter");
        }
        return unsafeEach().unsafeFilter(expression, parameters).uneachArray(); 
    }

    
    final Iter0IterableArrayOperator<T> unsafeEachFilter(final Filter<T> filter) {
        if (areAllTargetsNull()) {
            throw new NullTargetException("eachFilter");
        }
        return unsafeEach().unsafeFilter(filter).uneachArray(); 
    }


    public final Iter0IterableArrayOperator<T> eachFilter(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeEachFilter(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

        
    public final Iter0IterableArrayOperator<T> eachFilter(final Filter<T> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeEachFilter(filter);
    }


    final Iter0IterableListOperator<T> unsafeToList() {
        return new Iter0IterableListOperator<T>(getOperatorComponentType(), Arrays.asList(getTargetObjects().get(0)));
    }


    public final Iter0IterableListOperator<T> toList() {
        return unsafeToList();
    }


    final Iter0IterableSetOperator<T> unsafeToSet() {
        return new Iter0IterableSetOperator<T>(getOperatorComponentType(), new LinkedHashSet<T>(Arrays.asList(getTargetObjects().get(0))));
    }


    public final Iter0IterableSetOperator<T> toSet() {
        return unsafeToSet();
    }
    
    
    public final Iter0IterableMapOperator<?,T> toMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter0IterableMapOperator<K,T> toMap(
            final Class<K> keyClass, final String keyExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final Iter0IterableMapOperator<?,?> toMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter0IterableMapOperator<K,V> toMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter0IterableMapOperator<K,V> toMap(final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter0IterableMapOperator<?,?> toMap(final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildMap(null, null, mapBuilder);
    }

    
    public final Iter0IterableListMapOperator<?,T> toListMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildListMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter0IterableListMapOperator<K,T> toListMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildListMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final Iter0IterableListMapOperator<?,?> toListMap(
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildListMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter0IterableListMapOperator<K,V> toListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildListMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter0IterableListMapOperator<K,V> toListMap(
            final Class<K> keyClass, final Class<V> valueClass,
            final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildListMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter0IterableListMapOperator<?,?> toListMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildListMap(null, null, mapBuilder);
    }

    
    public final Iter0IterableSetMapOperator<?,T> toSetMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildSetMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter0IterableSetMapOperator<K,T> toSetMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildSetMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final Iter0IterableSetMapOperator<?,?> toSetMap(
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildSetMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter0IterableSetMapOperator<K,V> toSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildSetMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter0IterableSetMapOperator<K,V> toSetMap(
            final Class<K> keyClass, final Class<V> valueClass,
            final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildSetMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter0IterableSetMapOperator<?,?> toSetMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildSetMap(null, null, mapBuilder);
    }
    
    
    final <X> Iter0IterableArrayOperator<X> unsafeEachEval(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        return unsafeEach().unsafeEval(resultClass, expression, parameters).unsafeUneachArray();
    }

    
    final <X> Iter0IterableArrayOperator<X> unsafeEachEval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator) {
        return unsafeEach().unsafeEval(resultClass, evaluator).unsafeUneachArray();
    }

    
    public final Iter0IterableArrayOperator<?> eachEval(
            final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEval(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter0IterableArrayOperator<X> eachEval(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Return class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEval(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter0IterableArrayOperator<X> eachEval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator) {
        Validate.notNull(resultClass, "Class cannot be null");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEval(resultClass, evaluator);
    }

    
    public final Iter0IterableArrayOperator<?> eachEval(
            final Evaluator<T,Object> evaluator) {
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEval(null, evaluator);
    }
    

    final <X> Iter0IterableArrayOperator<X> unsafeEachCall(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        if (areAllTargetsNull()) {
            throw new NullTargetException("eachCall");
        }
        return unsafeEach().unsafeCall(resultClass, methodName, arguments).unsafeUneachArray();
    }
    

    public final Iter0IterableArrayOperator<?> eachCall(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCall(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter0IterableArrayOperator<X> eachCall(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Return class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCall(resultClass, methodName,OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    final <X> Iter0IterableArrayOperator<X> unsafeEachTo(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        return unsafeEach().unsafeTo(resultClass, resultType, parameters).unsafeUneachArray();
    }
    

    public final Iter0IterableArrayOperator<?> eachTo(
            final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeEachTo(null, resultType, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final Iter0IterableArrayOperator<?> eachTo(
            final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeEachTo(null, Types.forName(resultTypeName), OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter0IterableArrayOperator<X> eachTo(
            final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeEachTo(resultClass, Types.getRawTypeForClass(resultClass), OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final T[] get() {
        return getTargetObjects().get(0);
    }
    

    public final <X> X[] get(Class<X> componentClass) {
        return unsafeAsArray(componentClass).getTargetObjects().get(0);
    }
    
    
}

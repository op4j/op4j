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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.op4j.exceptions.InvalidOperatorCastException;
import org.op4j.exceptions.NullTargetException;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.IterableListOperator;
import org.op4j.op.interfaces.MapBuilder;
import org.op4j.operation.ListTarget;
import org.op4j.operation.Target;
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
public final class Iter0IterableListOperator<T> 
        extends Iter0AbstractOperator<List<T>>
        implements IterableListOperator<T> {

    
    private final Type operatorComponentType;
    

    
    /*
     *  Targets are created for each object computing intended type as 
     *  List<componentType>.
     *  
     *  Creating the intended type as rawtype (as in generic or array) is not 
     *  appliable here because we cannot guarantee that the real type that
     *  the user intended for the object List is the one we could compute from
     *  its values (Integer extends Number and Integer[] extends Number[], but 
     *  List<Integer> does not extend List<Number>).  
     *  
     */
    @SuppressWarnings("unchecked")
    private static ListTarget<?> prepareTargets(
            final Type componentType, final List<?> object) {
        
        return new ListTarget(componentType, object);
        
    }
    
    
    Iter0IterableListOperator(final Class<T> operatorComponentClass, final List<?> object) {
        this((operatorComponentClass != null? Types.getRawTypeForClass(operatorComponentClass) : null), object);
    }
    
    
    @SuppressWarnings("unchecked")
    Iter0IterableListOperator(final Type operatorComponentType, final List<?> object) {
        
        super((ListTarget) prepareTargets(operatorComponentType, object));
        this.operatorComponentType = operatorComponentType;
        /*
         * Check that the intended type is always compatible with the operator type.
         */
        checkOperatorType(this.operatorComponentType, getTargets().get(0).getIntendedType());
        
    }
    
    @SuppressWarnings("unchecked")
    Iter0IterableListOperator(final Type operatorComponentType, final Type componentType, final List<?> object) {
        
        super((ListTarget) prepareTargets(componentType, object));
        this.operatorComponentType = operatorComponentType;
        /*
         * Check that the intended type is always compatible with the operator type.
         */
        checkOperatorType(this.operatorComponentType, getTargets().get(0).getIntendedType());
        
    }
    
    
    private static void checkOperatorType(final Type operatorComponentType, final Type intendedType) {
        final Type operatorType = 
            TypeAggregationUtils.createListOfType(operatorComponentType);
        if (!operatorType.isAssignableFrom(intendedType)) {
            throw new InvalidOperatorCastException(operatorType, intendedType);
        }
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<ListTarget<T>> getTargets() {
        return (List<ListTarget<T>>) getAbstractTargets();
    }

    
    final Type getOperatorComponentType() {
        return this.operatorComponentType;
    }
    
    
    final Iter0IterableListOperator<?> unsafeRaw() {
        return new Iter0IterableListOperator<Object>(
                (Type) null, getTargetObjects().get(0));
    }
    
    
    public final Iter0IterableListOperator<?> raw() {
        return unsafeRaw();
    }
    
    
    final <X> Iter0IterableListOperator<X> unsafeEachExec(
            final Class<X> resultClass, final String operationName, final List<Object> parameters) {
        return unsafeEach().unsafeExec(resultClass, operationName, parameters).unsafeUneachList();
    }
    
    
    public final Iter0IterableListOperator<?> eachExec(
            final String operationName, final Object... parameters) {
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExec(null, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    public final <X> Iter0IterableListOperator<X> eachExec(
            final Class<X> resultClass, final String operationName, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        Validate.notNull(operationName, "Operation name cannot be null");
        return unsafeEachExec(resultClass, operationName, OperatorUtils.safeOperationParameters(parameters));
    }
    
    
    final Iter1GenericUniqTargetOperator<T> unsafeEach() {
        final List<T> targetObject = getTargetObjects().get(0);
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


    @SuppressWarnings("unchecked")
    final Iter0GenericUniqTargetOperator<List<T>> unsafeGeneric() {
        final Target<? extends List<T>> target = getTargets().get(0);
        return new Iter0GenericUniqTargetOperator(
                TypeAggregationUtils.createListOfType(getOperatorComponentType()),
                target.getIntendedType(),
                target.getObject());
    }

    
    public final Iter0GenericUniqTargetOperator<List<T>> generic() {
        return unsafeGeneric();
    }


    final Iter0IterableListOperator<T> unsafeDistinct() {
        
        final ListTarget<T> target = this.getTargets().get(0);
        
        if (areAllTargetsNull()) {
            throw new NullTargetException("distinct");
        }
        
        final List<T> targetObject = target.getObject();
        final List<T> newTargetObject = new ArrayList<T>();
        final Set<T> existingObjects = new HashSet<T>();
        for (T element : targetObject) {
            if (!existingObjects.contains(element)) {
                newTargetObject.add(element);
                existingObjects.add(element);
            }
        }
        
        return new Iter0IterableListOperator<T>(
                getOperatorComponentType(),
                target.getListComponentType(),
                newTargetObject);
        
    }


    public final Iter0IterableListOperator<T> distinct() {
        return unsafeDistinct();
    }

    
    final Iter0GenericMultiTargetOperator<T> unsafeFlat() {
        return new Iter0GenericMultiTargetOperator<T>(
                getOperatorComponentType(), getTargetObjects().get(0));
    }

    
    public final Iter0GenericMultiTargetOperator<T> flat() {
        return unsafeFlat();
    }


    final <X> Iter0IterableListOperator<X> unsafeAsList(final Class<X> ofClass) {
        // Note that "as" operations make casts dissapear
        return unsafeGeneric().unsafeAsList(ofClass);
    }


    public final <X> Iter0IterableListOperator<X> asList(final Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeAsList(ofClass);
    }


    final Iter0IterableListOperator<T> unsafeSort() {
        return unsafeSort(null);
    }


    public final Iter0IterableListOperator<T> sort() {
        return unsafeSort();
    }


    final Iter0IterableListOperator<T> unsafeSort(final Comparator<? super T> comparator) {
        
        final ListTarget<T> target = getTargets().get(0);
        
        if (areAllTargetsNull()) {
            throw new NullTargetException("sort");
        }
        
        /*
         * This collection is intentionally type-unsafe as we cannot know
         * whether T is Comparable or not until runtime.
         */
        final List<T> newTargetObject = new ArrayList<T>(target.getObject());
        Collections.sort(newTargetObject, comparator);
        
        
        return new Iter0IterableListOperator<T>(
                getOperatorComponentType(),
                target.getListComponentType(),
                newTargetObject);
        
    }


    public final Iter0IterableListOperator<T> sort(final Comparator<? super T> comparator) {
        // Comparator can be null. This is to adhere to the Collections.sort(...) API.
        return unsafeSort(comparator);
    }


    final Iter0IterableListOperator<T> unsafeEachFilter(
            final String expression, final List<Object> parameters) {
        if (areAllTargetsNull()) {
            throw new NullTargetException("eachFilter");
        }
        return unsafeEach().unsafeFilter(expression, parameters).uneachList(); 
    }

    
    final Iter0IterableListOperator<T> unsafeEachFilter(final Filter<T> filter) {
        if (areAllTargetsNull()) {
            throw new NullTargetException("eachFilter");
        }
        return unsafeEach().unsafeFilter(filter).uneachList(); 
    }


    public final Iter0IterableListOperator<T> eachFilter(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null");
        return unsafeEachFilter(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

        
    public final Iter0IterableListOperator<T> eachFilter(final Filter<T> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeEachFilter(filter);
    }


    final Iter0IterableArrayOperator<T> unsafeToArray() {
        return unsafeFlat().buildArray();
    }


    public final Iter0IterableArrayOperator<T> toArray() {
        return unsafeToArray();
    }


    final Iter0IterableSetOperator<T> unsafeToSet() {
        return new Iter0IterableSetOperator<T>(getOperatorComponentType(), new LinkedHashSet<T>(getTargetObjects().get(0)));
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


    
    public final Iter0IterableArrayMapOperator<?,T> toArrayMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildArrayMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K> Iter0IterableArrayMapOperator<K,T> toArrayMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeFlat().unsafeBuildArrayMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final Iter0IterableArrayMapOperator<?,?> toArrayMap(
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildArrayMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter0IterableArrayMapOperator<K,V> toArrayMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeFlat().unsafeBuildArrayMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <K,V> Iter0IterableArrayMapOperator<K,V> toArrayMap(
            final Class<K> keyClass, final Class<V> valueClass,
            final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildArrayMap(keyClass, valueClass, mapBuilder);
    }

    
    public final Iter0IterableArrayMapOperator<?,?> toArrayMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeFlat().unsafeBuildArrayMap(null, null, mapBuilder);
    }
    
    
    
    
    final <X> Iter0IterableListOperator<X> unsafeEachEval(
            final Class<X> resultClass, final String expression, final List<Object> parameters) {
        return unsafeEach().unsafeEval(resultClass, expression, parameters).unsafeUneachList();
    }

    
    final <X> Iter0IterableListOperator<X> unsafeEachEval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator) {
        return unsafeEach().unsafeEval(resultClass, evaluator).unsafeUneachList();
    }

    
    public final Iter0IterableListOperator<?> eachEval(
            final String expression, final Object... optionalExpParams) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEval(null, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter0IterableListOperator<X> eachEval(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams) {
        Validate.notNull(resultClass, "Return class cannot be null nor empty");
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeEachEval(resultClass, expression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }

    
    public final <X> Iter0IterableListOperator<X> eachEval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator) {
        Validate.notNull(resultClass, "Class cannot be null");
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEval(resultClass, evaluator);
    }

    
    public final Iter0IterableListOperator<?> eachEval(
            final Evaluator<T,Object> evaluator) {
        Validate.notNull(evaluator, "Evaluator cannot be null");
        return unsafeEachEval(null, evaluator);
    }
    

    final <X> Iter0IterableListOperator<X> unsafeEachCall(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        if (areAllTargetsNull()) {
            throw new NullTargetException("eachCall");
        }
        return unsafeEach().unsafeCall(resultClass, methodName, arguments).unsafeUneachList();
    }
    

    public final Iter0IterableListOperator<?> eachCall(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCall(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter0IterableListOperator<X> eachCall(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Return class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeEachCall(resultClass, methodName,OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    final <X> Iter0IterableListOperator<X> unsafeEachTo(
            final Class<X> resultClass, final Type resultType, final List<Object> parameters) {
        return unsafeEach().unsafeTo(resultClass, resultType, parameters).unsafeUneachList();
    }
    

    public final Iter0IterableListOperator<?> eachTo(
            final Type resultType, final Object... parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        return unsafeEachTo(null, resultType, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final Iter0IterableListOperator<?> eachTo(
            final String resultTypeName, final Object... parameters) {
        Validate.notNull(resultTypeName, "Result type name cannot be null");
        return unsafeEachTo(null, Types.forName(resultTypeName), OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter0IterableListOperator<X> eachTo(
            final Class<X> resultClass, final Object... parameters) {
        Validate.notNull(resultClass, "Result class cannot be null");
        return unsafeEachTo(resultClass, Types.getRawTypeForClass(resultClass), OperatorUtils.safeEvaluationParameters(parameters));
    }


    public final List<T> get() {
        return getTargetObjects().get(0);
    }
    

    public final <X> List<X> get(Class<X> componentClass) {
        return unsafeAsList(componentClass).getTargetObjects().get(0);
    }
    
    
    
}

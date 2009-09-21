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
import java.util.List;

import org.apache.commons.lang.Validate;
import org.op4j.exceptions.InvalidExpressionException;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.FilterContext;
import org.op4j.op.interfaces.GenericUniqTargetIteratingShapeableAsIterableOperator;
import org.op4j.op.interfaces.MapBuilder;
import org.op4j.type.Type;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeScheme;
import org.op4j.typescheme.TypeSchemes;
import org.op4j.util.OgnlUtils;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Iter1GenericUniqTargetOperator<T> 
        extends Iter1GenericAbstractOperator<T>
        implements GenericUniqTargetIteratingShapeableAsIterableOperator<T> {

    
    Iter1GenericUniqTargetOperator(final Class<T> operatorClass, final List<? extends Iter0GenericUniqTargetOperator<T>> targetOps) {
        this((operatorClass != null? Types.getRawTypeForClass(operatorClass) : null), targetOps);
    }
    
    
    Iter1GenericUniqTargetOperator(final Type operatorType, final List<? extends Iter0GenericUniqTargetOperator<T>> targetOps) {
        super(operatorType,targetOps);
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<Iter0GenericUniqTargetOperator<T>> getTargets() {
        return (List<Iter0GenericUniqTargetOperator<T>>) getAbstractTargets();
    }
    
    
    @Override
    @SuppressWarnings("unchecked")
    final Iter1GenericUniqTargetOperator<?> unsafeRaw() {
        List<Iter0GenericUniqTargetOperator<?>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<?>>();
        for (Iter0GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeRaw());
        }
        return new Iter1GenericUniqTargetOperator((Type)null, components);
    }
    
    
    public final Iter1GenericUniqTargetOperator<?> raw() {
        return unsafeRaw();
    }
    
    
    final Iter1GenericUniqTargetOperator<T> unsafeCast(final TypeScheme typeScheme) {
        final List<Iter0GenericUniqTargetOperator<T>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<T>>();
        for (Iter0GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeCast(typeScheme));
        }
        return new Iter1GenericUniqTargetOperator<T>(getOperatorType(), components);
    }

    
    public final Iter1GenericUniqTargetOperator<T> cast(final String typeSchemeName) {
        Validate.notNull(typeSchemeName, "Type scheme name cannot be null");
        return unsafeCast(TypeSchemes.forName(typeSchemeName));
    }
    
    
    public final Iter1GenericUniqTargetOperator<T> cast(final TypeScheme typeScheme) {
        Validate.notNull(typeScheme, "Type scheme cannot be null");
        Validate.isTrue(!typeScheme.hasLiterals(), 
                "Cast type scheme " + typeScheme + " cannot contain literals");
        Validate.isTrue(typeScheme.getComponentCount() == size(), 
                "Cast type scheme " + typeScheme + " should have exactly " + size() +" member/s");
        return unsafeCast(typeScheme);
    }
    
    
    @Override
    final <X> Iter1GenericUniqTargetOperator<X> unsafeAs(final Class<X> newOperatorClass) {
        final List<Iter0GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<X>>();
        for (Iter0GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeAs(newOperatorClass));
        }
        return new Iter1GenericUniqTargetOperator<X>(newOperatorClass, components);
    }
    

    public final <X> Iter1GenericUniqTargetOperator<X> as(final Class<X> newOperatorClass) {
        Validate.notNull(newOperatorClass, "Class cannot be null");
        return unsafeAs(newOperatorClass);
    }
    

    final <X> Iter1GenericUniqTargetOperator<X> unsafeCall(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        final List<Iter0GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<X>>();
        for (Iter0GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeCall(resultClass, methodName, arguments));
        }
        return new Iter1GenericUniqTargetOperator<X>(resultClass, components);
    }
    

    public final Iter1GenericUniqTargetOperator<?> call(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeCall(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter1GenericUniqTargetOperator<X> call(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Return class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeCall(resultClass, methodName,OperatorUtils.safeEvaluationParameters(parameters));
    }


    final <X> Iter1IterableArrayOperator<X> unsafeAsArray(final Class<X> ofClass) {
        final List<Iter0IterableArrayOperator<X>> components = 
            new ArrayList<Iter0IterableArrayOperator<X>>();
        for (Iter0GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeAsArray(ofClass));
        }
        return new Iter1IterableArrayOperator<X>(ofClass, components);
    }


    public final Iter1IterableArrayOperator<?> asArray() {
        return unsafeAsArray(null);
    }


    public final <X> Iter1IterableArrayOperator<X> asArray(final Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeAsArray(ofClass);
    }


    final <X> Iter1IterableListOperator<X> unsafeAsList(final Class<X> ofClass) {
        final List<Iter0IterableListOperator<X>> components = 
            new ArrayList<Iter0IterableListOperator<X>>();
        for (Iter0GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeAsList(ofClass));
        }
        return new Iter1IterableListOperator<X>(ofClass, components);
    }


    public final Iter1IterableListOperator<?> asList() {
        return unsafeAsList(null);
    }


    public final <X> Iter1IterableListOperator<X> asList(final Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeAsList(ofClass);
    }


    final <X> Iter1IterableSetOperator<X> unsafeAsSet(final Class<X> ofClass) {
        final List<Iter0IterableSetOperator<X>> components = 
            new ArrayList<Iter0IterableSetOperator<X>>();
        for (Iter0GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeAsSet(ofClass));
        }
        return new Iter1IterableSetOperator<X>(ofClass, components);
    }


    public final Iter1IterableSetOperator<?> asSet() {
        return unsafeAsSet(null);
    }


    public final <X> Iter1IterableSetOperator<X> asSet(final Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeAsSet(ofClass);
    }


    final <K,V> Iter1IterableMapOperator<K, V> unsafeAsMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        final List<Iter0IterableMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableMapOperator<K,V>>();
        for (Iter0GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeAsMap(keyClass, valueClass));
        }
        return new Iter1IterableMapOperator<K,V>(keyClass, valueClass, components);
    }


    public final Iter1IterableMapOperator<?,?> asMap() {
        return unsafeAsMap(null, null);
    }


    public final <K,V> Iter1IterableMapOperator<K, V> asMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsMap(keyClass, valueClass);
    }


    final <K,V> Iter1IterableListMapOperator<K,V> unsafeAsListMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        final List<Iter0IterableListMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableListMapOperator<K,V>>();
        for (Iter0GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeAsListMap(keyClass, valueClass));
        }
        return new Iter1IterableListMapOperator<K,V>(keyClass, valueClass, components);
    }


    public final Iter1IterableListMapOperator<?,?> asListMap() {
        return unsafeAsListMap(null, null);
    }


    public final <K, V> Iter1IterableListMapOperator<K,V> asListMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsListMap(keyClass, valueClass);
    }


    final <K,V> Iter1IterableSetMapOperator<K,V> unsafeAsSetMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        final List<Iter0IterableSetMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableSetMapOperator<K,V>>();
        for (Iter0GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeAsSetMap(keyClass, valueClass));
        }
        return new Iter1IterableSetMapOperator<K,V>(keyClass, valueClass, components);
    }


    public final Iter1IterableSetMapOperator<?,?> asSetMap() {
        return unsafeAsSetMap(null, null);
    }


    public final <K, V> Iter1IterableSetMapOperator<K,V> asSetMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsSetMap(keyClass, valueClass);
    }


    final <K,V> Iter1MapEntryOperator<K,V> unsafeAsMapEntry(
            final Class<K> keyClass, final Class<V> valueClass) {
        final List<Iter0MapEntryOperator<K,V>> components = 
            new ArrayList<Iter0MapEntryOperator<K,V>>();
        for (Iter0GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeAsMapEntry(keyClass, valueClass));
        }
        return new Iter1MapEntryOperator<K,V>(keyClass, valueClass, components);
    }


    public final Iter1MapEntryOperator<?,?> asMapEntry() {
        return unsafeAsMapEntry(null, null);
    }


    public final <K,V> Iter1MapEntryOperator<K,V> asMapEntry(
            final Class<K> keyClass, final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsMapEntry(keyClass, valueClass);
    }


    final Iter1GenericUniqTargetOperator<T> unsafeFilter(
            final String expression, final List<Object> parameters) {

        final List<Iter0GenericUniqTargetOperator<T>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<T>>();
        for (Iter0GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            final Object targetOpResult =
                OgnlUtils.getValueByOgnlExpression(
                        targetOp.getTargetObjects().get(0), expression, parameters);
            if (!(targetOpResult instanceof Boolean)) {
                throw new InvalidExpressionException("Expression \"" + expression + 
                        "\" did not evaluate to boolean result");
            }
            if (!((Boolean)targetOpResult).booleanValue()) {
                components.add(targetOp);
            }
        }
        return new Iter1GenericUniqTargetOperator<T>(getOperatorType(), components);
        
    }

    
    final Iter1GenericUniqTargetOperator<T> unsafeFilter(final Filter<T> filter) {

        final List<Iter0GenericUniqTargetOperator<T>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<T>>();
        for (Iter0GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            final FilterContext<T> filterContext =
                new FilterContextImpl<T>(targetOp.getTargetObjects());
            if (!filter.eval(filterContext)) {
                components.add(targetOp);
            }
        }
        return new Iter1GenericUniqTargetOperator<T>(getOperatorType(), components);
        
    }


    public final Iter1GenericUniqTargetOperator<T> filter(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeFilter(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

    
    public final Iter1GenericUniqTargetOperator<T> filter(final Filter<T> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeFilter(filter);
    }
    
    
    final Iter0IterableSetOperator<T> unsafeUneachSet() {
        return new Iter0IterableSetOperator<T>(
                getOperatorType(),
                OperatorAggregationUtils.buildSetAggregatedTarget(getInnerUniqTargetObjects())); 
    }
    
    
    public final Iter0IterableSetOperator<T> uneachSet() {
        return unsafeUneachSet();
    }
    
    
    final <X> Iter0IterableSetOperator<X> unsafeUneachSet(Class<X> ofClass) {
        return as(ofClass).unsafeUneachSet(); 
    }
    
    
    public final <X> Iter0IterableSetOperator<X> uneachSet(Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeUneachSet(ofClass);
    }
    
    
    final Iter0IterableListOperator<T> unsafeUneachList() {
        return new Iter0IterableListOperator<T>(
                getOperatorType(),
                OperatorAggregationUtils.buildListAggregatedTarget(getInnerUniqTargetObjects())); 
    }
    
    
    public final Iter0IterableListOperator<T> uneachList() {
        return unsafeUneachList();
    }
    
    
    final <X> Iter0IterableListOperator<X> unsafeUneachList(Class<X> ofClass) {
        return as(ofClass).unsafeUneachList(); 
    }
    
    
    public final <X> Iter0IterableListOperator<X> uneachList(Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeUneachList(ofClass);
    }
    
    
    final Iter0IterableArrayOperator<T> unsafeUneachArray() {
        return new Iter0IterableArrayOperator<T>(
                getOperatorType(),
                OperatorAggregationUtils.buildArrayAggregatedTarget(getOperatorType(), getInnerUniqTargetObjects())); 
    }
    
    
    public final Iter0IterableArrayOperator<T> uneachArray() {
        return unsafeUneachArray();
    }
    
    
    final <X> Iter0IterableArrayOperator<X> unsafeUneachArray(Class<X> ofClass) {
        return as(ofClass).unsafeUneachArray(); 
    }
    
    
    public final <X> Iter0IterableArrayOperator<X> uneachArray(Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeUneachArray(ofClass);
    }
    
    
    final <K> Iter0IterableMapOperator<K,T> unsafeUneachMap(
            final Class<K> keyClass, final String keyExpression, 
            final List<Object> expParams) {
        return new Iter0IterableMapOperator<K,T>(
                keyClass, getOperatorType(),
                OperatorAggregationUtils.buildMapAggregatedTarget(
                        getInnerUniqTargetObjects(),
                        keyClass, keyExpression, expParams)); 
    }
    
    
    public final Iter0IterableMapOperator<?,T> uneachMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter0IterableMapOperator<K,T> uneachMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter0IterableMapOperator<K,V> unsafeUneachMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        return new Iter0IterableMapOperator<K,V>(
                keyClass, valueClass,
                OperatorAggregationUtils.buildMapAggregatedTarget(
                        getInnerUniqTargetObjects(),
                        keyClass, valueClass, keyExpression, valueExpression, expParams)); 
    }
    
    
    public final Iter0IterableMapOperator<?,?> uneachMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K,V> Iter0IterableMapOperator<K,V> uneachMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter0IterableMapOperator<K,V> unsafeUneachMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        return new Iter0IterableMapOperator<K,V>(
                keyClass, valueClass,
                OperatorAggregationUtils.buildMapAggregatedTarget(
                        getInnerUniqTargetObjects(),
                        mapBuilder)); 
    }
    
    
    public final <K,V> Iter0IterableMapOperator<K,V> uneachMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter0IterableMapOperator<?,?> uneachMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachMap(null, null, mapBuilder);
    }
    
    
    final <K> Iter0IterableListMapOperator<K,T> unsafeUneachListMap(
            final Class<K> keyClass, final String keyExpression, final List<Object> expParams) {
        return new Iter0IterableListMapOperator<K,T>(
                keyClass, getOperatorType(),
                OperatorAggregationUtils.buildListMapAggregatedTarget(
                        getInnerUniqTargetObjects(),
                        keyClass, keyExpression, expParams)); 
    }
    
    
    public final Iter0IterableListMapOperator<?,T> uneachListMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachListMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter0IterableListMapOperator<K,T> uneachListMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachListMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter0IterableListMapOperator<K,V> unsafeUneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        return new Iter0IterableListMapOperator<K,V>(
                keyClass, valueClass,
                OperatorAggregationUtils.buildListMapAggregatedTarget(
                        getInnerUniqTargetObjects(),
                        keyClass, valueClass, keyExpression, valueExpression, expParams)); 
    }
    
    
    public final Iter0IterableListMapOperator<?,?> uneachListMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachListMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K,V> Iter0IterableListMapOperator<K,V> uneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachListMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter0IterableListMapOperator<K,V> unsafeUneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        return new Iter0IterableListMapOperator<K,V>(
                keyClass, valueClass,
                OperatorAggregationUtils.buildListMapAggregatedTarget(
                        getInnerUniqTargetObjects(),
                        mapBuilder)); 
    }
    
    
    public final <K,V> Iter0IterableListMapOperator<K,V> uneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachListMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter0IterableListMapOperator<?,?> uneachListMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachListMap(null, null, mapBuilder);
    }

    
    
    
    
    
    
    
    
    final <K> Iter0IterableSetMapOperator<K,T> unsafeUneachSetMap(
            final Class<K> keyClass, final String keyExpression, final List<Object> expParams) {
        return new Iter0IterableSetMapOperator<K,T>(
                keyClass, getOperatorType(),
                OperatorAggregationUtils.buildSetMapAggregatedTarget(
                        getInnerUniqTargetObjects(),
                        keyClass, keyExpression, expParams)); 
    }
    
    
    public final Iter0IterableSetMapOperator<?,T> uneachSetMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachSetMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter0IterableSetMapOperator<K,T> uneachSetMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachSetMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter0IterableSetMapOperator<K,V> unsafeUneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        return new Iter0IterableSetMapOperator<K,V>(
                keyClass, valueClass,
                OperatorAggregationUtils.buildSetMapAggregatedTarget(
                        getInnerUniqTargetObjects(),
                        keyClass, valueClass, keyExpression, valueExpression, expParams)); 
    }
    
    
    public final Iter0IterableSetMapOperator<?,?> uneachSetMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachSetMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K,V> Iter0IterableSetMapOperator<K,V> uneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachSetMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter0IterableSetMapOperator<K,V> unsafeUneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        return new Iter0IterableSetMapOperator<K,V>(
                keyClass, valueClass,
                OperatorAggregationUtils.buildSetMapAggregatedTarget(
                        getInnerUniqTargetObjects(),
                        mapBuilder)); 
    }
    
    
    public final <K,V> Iter0IterableSetMapOperator<K,V> uneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachSetMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter0IterableSetMapOperator<?,?> uneachSetMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachSetMap(null, null, mapBuilder);
    }
    
    
}

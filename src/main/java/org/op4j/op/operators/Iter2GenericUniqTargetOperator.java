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
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.GenericUniqTargetIteratingOperator;
import org.op4j.op.interfaces.MapBuilder;
import org.op4j.type.Type;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeScheme;
import org.op4j.typescheme.TypeSchemes;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Iter2GenericUniqTargetOperator<T> 
        extends Iter2GenericAbstractOperator<T>
        implements GenericUniqTargetIteratingOperator<T> {

    
    Iter2GenericUniqTargetOperator(final Class<T> operatorClass, final List<? extends Iter1GenericUniqTargetOperator<T>> targetOps) {
        this((operatorClass != null? Types.getRawTypeForClass(operatorClass) : null), targetOps);
    }
    
    
    Iter2GenericUniqTargetOperator(final Type operatorType, final List<? extends Iter1GenericUniqTargetOperator<T>> targetOps) {
        super(operatorType,targetOps);
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<Iter1GenericUniqTargetOperator<T>> getTargets() {
        return (List<Iter1GenericUniqTargetOperator<T>>) getAbstractTargets();
    }
    
    
    @Override
    @SuppressWarnings("unchecked")
    final Iter2GenericUniqTargetOperator<?> unsafeRaw() {
        List<Iter1GenericUniqTargetOperator<?>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<?>>();
        for (Iter1GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeRaw());
        }
        return new Iter2GenericUniqTargetOperator((Type)null, components);
    }
    
    
    public final Iter2GenericUniqTargetOperator<?> raw() {
        return unsafeRaw();
    }
    
    
    final Iter2GenericUniqTargetOperator<T> unsafeCast(final TypeScheme typeScheme) {
        final List<Iter1GenericUniqTargetOperator<T>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<T>>();
        for (Iter1GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeCast(typeScheme));
        }
        return new Iter2GenericUniqTargetOperator<T>(getOperatorType(), components);
    }

    
    public final Iter2GenericUniqTargetOperator<T> cast(final String typeSchemeName) {
        Validate.notNull(typeSchemeName, "Type scheme name cannot be null");
        return unsafeCast(TypeSchemes.forName(typeSchemeName));
    }
    
    
    public final Iter2GenericUniqTargetOperator<T> cast(final TypeScheme typeScheme) {
        Validate.notNull(typeScheme, "Type scheme cannot be null");
        Validate.isTrue(!typeScheme.hasLiterals(), 
                "Cast type scheme " + typeScheme + " cannot contain literals");
        Validate.isTrue(typeScheme.getComponentCount() == size(), 
                "Cast type scheme " + typeScheme + " should have exactly " + size() +" member/s");
        return unsafeCast(typeScheme);
    }
    
    
    @Override
    final <X> Iter2GenericUniqTargetOperator<X> unsafeAs(final Class<X> newOperatorClass) {
        final List<Iter1GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<X>>();
        for (Iter1GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeAs(newOperatorClass));
        }
        return new Iter2GenericUniqTargetOperator<X>(newOperatorClass, components);
    }
    

    public final <X> Iter2GenericUniqTargetOperator<X> as(final Class<X> newOperatorClass) {
        Validate.notNull(newOperatorClass, "Class cannot be null");
        return unsafeAs(newOperatorClass);
    }
    

    final <X> Iter2GenericUniqTargetOperator<X> unsafeCall(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        final List<Iter1GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<X>>();
        for (Iter1GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeCall(resultClass, methodName, arguments));
        }
        return new Iter2GenericUniqTargetOperator<X>(resultClass, components);
    }
    

    public final Iter2GenericUniqTargetOperator<?> call(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeCall(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter2GenericUniqTargetOperator<X> call(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Return class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeCall(resultClass, methodName,OperatorUtils.safeEvaluationParameters(parameters));
    }


    final <K,V> Iter2MapEntryOperator<K,V> unsafeAsMapEntry(
            final Class<K> keyClass, final Class<V> valueClass) {
        final List<Iter1MapEntryOperator<K,V>> components = 
            new ArrayList<Iter1MapEntryOperator<K,V>>();
        for (Iter1GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeAsMapEntry(keyClass, valueClass));
        }
        return new Iter2MapEntryOperator<K,V>(keyClass, valueClass, components);
    }


    public final Iter2MapEntryOperator<?,?> asMapEntry() {
        return unsafeAsMapEntry(null, null);
    }


    public final <K,V> Iter2MapEntryOperator<K,V> asMapEntry(
            final Class<K> keyClass, final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsMapEntry(keyClass, valueClass);
    }


    final Iter2GenericUniqTargetOperator<T> unsafeFilter(
            final String expression, final List<Object> parameters) {
        final List<Iter1GenericUniqTargetOperator<T>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<T>>();
        for (Iter1GenericUniqTargetOperator<T> targetOp : getTargets()) {
            components.add(targetOp.unsafeFilter(expression, parameters));
        }
        return new Iter2GenericUniqTargetOperator<T>(getOperatorType(), components);
    }

    
    final Iter2GenericUniqTargetOperator<T> unsafeFilter(final Filter<T> filter) {
        final List<Iter1GenericUniqTargetOperator<T>> components = 
            new ArrayList<Iter1GenericUniqTargetOperator<T>>();
        for (Iter1GenericUniqTargetOperator<T> targetOp : getTargets()) {
            components.add(targetOp.unsafeFilter(filter));
        }
        return new Iter2GenericUniqTargetOperator<T>(getOperatorType(), components);
    }


    public final Iter2GenericUniqTargetOperator<T> filter(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeFilter(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

    
    public final Iter2GenericUniqTargetOperator<T> filter(final Filter<T> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeFilter(filter);
    }
    
    
    final Iter1IterableSetOperator<T> unsafeUneachSet() {
        final List<Iter0IterableSetOperator<T>> components = 
            new ArrayList<Iter0IterableSetOperator<T>>();
        for (Iter1GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachSet());
        }
        return new Iter1IterableSetOperator<T>(getOperatorType(), components);
    }
    
    
    public final Iter1IterableSetOperator<T> uneachSet() {
        return unsafeUneachSet();
    }
    
    
    final <X> Iter1IterableSetOperator<X> unsafeUneachSet(Class<X> ofClass) {
        return as(ofClass).unsafeUneachSet(); 
    }
    
    
    public final <X> Iter1IterableSetOperator<X> uneachSet(Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeUneachSet(ofClass);
    }
    
    
    final Iter1IterableListOperator<T> unsafeUneachList() {
        final List<Iter0IterableListOperator<T>> components = 
            new ArrayList<Iter0IterableListOperator<T>>();
        for (Iter1GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachList());
        }
        return new Iter1IterableListOperator<T>(getOperatorType(), components);
    }
    
    
    public final Iter1IterableListOperator<T> uneachList() {
        return unsafeUneachList();
    }
    
    
    final <X> Iter1IterableListOperator<X> unsafeUneachList(Class<X> ofClass) {
        return as(ofClass).unsafeUneachList(); 
    }
    
    
    public final <X> Iter1IterableListOperator<X> uneachList(Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeUneachList(ofClass);
    }
    
    
    final Iter1IterableArrayOperator<T> unsafeUneachArray() {
        final List<Iter0IterableArrayOperator<T>> components = 
            new ArrayList<Iter0IterableArrayOperator<T>>();
        for (Iter1GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachArray());
        }
        return new Iter1IterableArrayOperator<T>(getOperatorType(), components);
    }
    
    
    public final Iter1IterableArrayOperator<T> uneachArray() {
        return unsafeUneachArray();
    }
    
    
    final <X> Iter1IterableArrayOperator<X> unsafeUneachArray(Class<X> ofClass) {
        return as(ofClass).unsafeUneachArray(); 
    }
    
    
    public final <X> Iter1IterableArrayOperator<X> uneachArray(Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeUneachArray(ofClass);
    }
    
    
    final <K> Iter1IterableMapOperator<K,T> unsafeUneachMap(
            final Class<K> keyClass, final String keyExpression, 
            final List<Object> expParams) {
        final List<Iter0IterableMapOperator<K,T>> components = 
            new ArrayList<Iter0IterableMapOperator<K,T>>();
        for (Iter1GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachMap(keyClass,keyExpression,expParams));
        }
        return new Iter1IterableMapOperator<K,T>(keyClass, getOperatorType(), components);
    }
    
    
    public final Iter1IterableMapOperator<?,T> uneachMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter1IterableMapOperator<K,T> uneachMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter1IterableMapOperator<K,V> unsafeUneachMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        final List<Iter0IterableMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableMapOperator<K,V>>();
        for (Iter1GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachMap(keyClass,valueClass,keyExpression,valueExpression,expParams));
        }
        return new Iter1IterableMapOperator<K,V>(keyClass, valueClass, components);
    }
    
    
    public final Iter1IterableMapOperator<?,?> uneachMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K,V> Iter1IterableMapOperator<K,V> uneachMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter1IterableMapOperator<K,V> unsafeUneachMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        final List<Iter0IterableMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableMapOperator<K,V>>();
        for (Iter1GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachMap(keyClass, valueClass, mapBuilder));
        }
        return new Iter1IterableMapOperator<K,V>(keyClass, valueClass, components);
    }
    
    
    public final <K,V> Iter1IterableMapOperator<K,V> uneachMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter1IterableMapOperator<?,?> uneachMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachMap(null, null, mapBuilder);
    }
    
    
    final <K> Iter1IterableListMapOperator<K,T> unsafeUneachListMap(
            final Class<K> keyClass, final String keyExpression, final List<Object> expParams) {
        final List<Iter0IterableListMapOperator<K,T>> components = 
            new ArrayList<Iter0IterableListMapOperator<K,T>>();
        for (Iter1GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachListMap(keyClass,keyExpression,expParams));
        }
        return new Iter1IterableListMapOperator<K,T>(keyClass, getOperatorType(), components);
    }
    
    
    public final Iter1IterableListMapOperator<?,T> uneachListMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachListMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter1IterableListMapOperator<K,T> uneachListMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachListMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter1IterableListMapOperator<K,V> unsafeUneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        final List<Iter0IterableListMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableListMapOperator<K,V>>();
        for (Iter1GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachListMap(keyClass,valueClass,keyExpression,valueExpression,expParams));
        }
        return new Iter1IterableListMapOperator<K,V>(keyClass, valueClass, components);
    }
    
    
    public final Iter1IterableListMapOperator<?,?> uneachListMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachListMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K,V> Iter1IterableListMapOperator<K,V> uneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachListMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter1IterableListMapOperator<K,V> unsafeUneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        final List<Iter0IterableListMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableListMapOperator<K,V>>();
        for (Iter1GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachListMap(keyClass, valueClass, mapBuilder));
        }
        return new Iter1IterableListMapOperator<K,V>(keyClass, valueClass, components);
    }
    
    
    public final <K,V> Iter1IterableListMapOperator<K,V> uneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachListMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter1IterableListMapOperator<?,?> uneachListMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachListMap(null, null, mapBuilder);
    }

    
    final <K> Iter1IterableSetMapOperator<K,T> unsafeUneachSetMap(
            final Class<K> keyClass, final String keyExpression, final List<Object> expParams) {
        final List<Iter0IterableSetMapOperator<K,T>> components = 
            new ArrayList<Iter0IterableSetMapOperator<K,T>>();
        for (Iter1GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachSetMap(keyClass,keyExpression,expParams));
        }
        return new Iter1IterableSetMapOperator<K,T>(keyClass, getOperatorType(), components);
    }
    
    
    public final Iter1IterableSetMapOperator<?,T> uneachSetMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachSetMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter1IterableSetMapOperator<K,T> uneachSetMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachSetMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter1IterableSetMapOperator<K,V> unsafeUneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        final List<Iter0IterableSetMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableSetMapOperator<K,V>>();
        for (Iter1GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachSetMap(keyClass,valueClass,keyExpression,valueExpression,expParams));
        }
        return new Iter1IterableSetMapOperator<K,V>(keyClass, valueClass, components);
    }
    
    
    public final Iter1IterableSetMapOperator<?,?> uneachSetMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachSetMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K,V> Iter1IterableSetMapOperator<K,V> uneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachSetMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter1IterableSetMapOperator<K,V> unsafeUneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        final List<Iter0IterableSetMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableSetMapOperator<K,V>>();
        for (Iter1GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachSetMap(keyClass, valueClass, mapBuilder));
        }
        return new Iter1IterableSetMapOperator<K,V>(keyClass, valueClass, components);
    }
    
    
    public final <K,V> Iter1IterableSetMapOperator<K,V> uneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachSetMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter1IterableSetMapOperator<?,?> uneachSetMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachSetMap(null, null, mapBuilder);
    }
    
    
}

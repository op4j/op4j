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
public final class Iter3GenericUniqTargetOperator<T> 
        extends Iter3GenericAbstractOperator<T>
        implements GenericUniqTargetIteratingOperator<T> {

    
    Iter3GenericUniqTargetOperator(final Class<T> operatorClass, final List<? extends Iter2GenericUniqTargetOperator<T>> targetOps) {
        this((operatorClass != null? Types.getRawTypeForClass(operatorClass) : null), targetOps);
    }
    
    
    Iter3GenericUniqTargetOperator(final Type operatorType, final List<? extends Iter2GenericUniqTargetOperator<T>> targetOps) {
        super(operatorType,targetOps);
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<Iter2GenericUniqTargetOperator<T>> getTargets() {
        return (List<Iter2GenericUniqTargetOperator<T>>) getAbstractTargets();
    }
    
    
    @Override
    @SuppressWarnings("unchecked")
    final Iter3GenericUniqTargetOperator<?> unsafeRaw() {
        List<Iter2GenericUniqTargetOperator<?>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<?>>();
        for (Iter2GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeRaw());
        }
        return new Iter3GenericUniqTargetOperator((Type)null, components);
    }
    
    
    public final Iter3GenericUniqTargetOperator<?> raw() {
        return unsafeRaw();
    }
    
    
    final Iter3GenericUniqTargetOperator<T> unsafeCast(final TypeScheme typeScheme) {
        final List<Iter2GenericUniqTargetOperator<T>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<T>>();
        for (Iter2GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeCast(typeScheme));
        }
        return new Iter3GenericUniqTargetOperator<T>(getOperatorType(), components);
    }

    
    public final Iter3GenericUniqTargetOperator<T> cast(final String typeSchemeName) {
        Validate.notNull(typeSchemeName, "Type scheme name cannot be null");
        return unsafeCast(TypeSchemes.forName(typeSchemeName));
    }
    
    
    public final Iter3GenericUniqTargetOperator<T> cast(final TypeScheme typeScheme) {
        Validate.notNull(typeScheme, "Type scheme cannot be null");
        Validate.isTrue(!typeScheme.hasLiterals(), 
                "Cast type scheme " + typeScheme + " cannot contain literals");
        Validate.isTrue(typeScheme.getComponentCount() == size(), 
                "Cast type scheme " + typeScheme + " should have exactly " + size() +" member/s");
        return unsafeCast(typeScheme);
    }
    
    
    @Override
    final <X> Iter3GenericUniqTargetOperator<X> unsafeAs(final Class<X> newOperatorClass) {
        final List<Iter2GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<X>>();
        for (Iter2GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeAs(newOperatorClass));
        }
        return new Iter3GenericUniqTargetOperator<X>(newOperatorClass, components);
    }
    

    public final <X> Iter3GenericUniqTargetOperator<X> as(final Class<X> newOperatorClass) {
        Validate.notNull(newOperatorClass, "Class cannot be null");
        return unsafeAs(newOperatorClass);
    }
    

    final <X> Iter3GenericUniqTargetOperator<X> unsafeCall(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        final List<Iter2GenericUniqTargetOperator<X>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<X>>();
        for (Iter2GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeCall(resultClass, methodName, arguments));
        }
        return new Iter3GenericUniqTargetOperator<X>(resultClass, components);
    }
    

    public final Iter3GenericUniqTargetOperator<?> call(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeCall(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter3GenericUniqTargetOperator<X> call(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Return class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeCall(resultClass, methodName,OperatorUtils.safeEvaluationParameters(parameters));
    }


    final <K,V> Iter3MapEntryOperator<K,V> unsafeAsMapEntry(
            final Class<K> keyClass, final Class<V> valueClass) {
        final List<Iter2MapEntryOperator<K,V>> components = 
            new ArrayList<Iter2MapEntryOperator<K,V>>();
        for (Iter2GenericUniqTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeAsMapEntry(keyClass, valueClass));
        }
        return new Iter3MapEntryOperator<K,V>(keyClass, valueClass, components);
    }


    public final Iter3MapEntryOperator<?,?> asMapEntry() {
        return unsafeAsMapEntry(null, null);
    }


    public final <K,V> Iter3MapEntryOperator<K,V> asMapEntry(
            final Class<K> keyClass, final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsMapEntry(keyClass, valueClass);
    }


    final Iter3GenericUniqTargetOperator<T> unsafeFilter(
            final String expression, final List<Object> parameters) {
        final List<Iter2GenericUniqTargetOperator<T>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<T>>();
        for (Iter2GenericUniqTargetOperator<T> targetOp : getTargets()) {
            components.add(targetOp.unsafeFilter(expression, parameters));
        }
        return new Iter3GenericUniqTargetOperator<T>(getOperatorType(), components);
    }

    
    final Iter3GenericUniqTargetOperator<T> unsafeFilter(final Filter<T> filter) {
        final List<Iter2GenericUniqTargetOperator<T>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<T>>();
        for (Iter2GenericUniqTargetOperator<T> targetOp : getTargets()) {
            components.add(targetOp.unsafeFilter(filter));
        }
        return new Iter3GenericUniqTargetOperator<T>(getOperatorType(), components);
    }


    public final Iter3GenericUniqTargetOperator<T> filter(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeFilter(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

    
    public final Iter3GenericUniqTargetOperator<T> filter(final Filter<T> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeFilter(filter);
    }
    
    
    final Iter2IterableSetOperator<T> unsafeUneachSet() {
        final List<Iter1IterableSetOperator<T>> components = 
            new ArrayList<Iter1IterableSetOperator<T>>();
        for (Iter2GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachSet());
        }
        return new Iter2IterableSetOperator<T>(getOperatorType(), components);
    }
    
    
    public final Iter2IterableSetOperator<T> uneachSet() {
        return unsafeUneachSet();
    }
    
    
    final <X> Iter2IterableSetOperator<X> unsafeUneachSet(Class<X> ofClass) {
        return as(ofClass).unsafeUneachSet(); 
    }
    
    
    public final <X> Iter2IterableSetOperator<X> uneachSet(Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeUneachSet(ofClass);
    }
    
    
    final Iter2IterableListOperator<T> unsafeUneachList() {
        final List<Iter1IterableListOperator<T>> components = 
            new ArrayList<Iter1IterableListOperator<T>>();
        for (Iter2GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachList());
        }
        return new Iter2IterableListOperator<T>(getOperatorType(), components);
    }
    
    
    public final Iter2IterableListOperator<T> uneachList() {
        return unsafeUneachList();
    }
    
    
    final <X> Iter2IterableListOperator<X> unsafeUneachList(Class<X> ofClass) {
        return as(ofClass).unsafeUneachList(); 
    }
    
    
    public final <X> Iter2IterableListOperator<X> uneachList(Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeUneachList(ofClass);
    }
    
    
    final Iter2IterableArrayOperator<T> unsafeUneachArray() {
        final List<Iter1IterableArrayOperator<T>> components = 
            new ArrayList<Iter1IterableArrayOperator<T>>();
        for (Iter2GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachArray());
        }
        return new Iter2IterableArrayOperator<T>(getOperatorType(), components);
    }
    
    
    public final Iter2IterableArrayOperator<T> uneachArray() {
        return unsafeUneachArray();
    }
    
    
    final <X> Iter2IterableArrayOperator<X> unsafeUneachArray(Class<X> ofClass) {
        return as(ofClass).unsafeUneachArray(); 
    }
    
    
    public final <X> Iter2IterableArrayOperator<X> uneachArray(Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeUneachArray(ofClass);
    }
    
    
    final <K> Iter2IterableMapOperator<K,T> unsafeUneachMap(
            final Class<K> keyClass, final String keyExpression, 
            final List<Object> expParams) {
        final List<Iter1IterableMapOperator<K,T>> components = 
            new ArrayList<Iter1IterableMapOperator<K,T>>();
        for (Iter2GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachMap(keyClass,keyExpression,expParams));
        }
        return new Iter2IterableMapOperator<K,T>(keyClass, getOperatorType(), components);
    }
    
    
    public final Iter2IterableMapOperator<?,T> uneachMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter2IterableMapOperator<K,T> uneachMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter2IterableMapOperator<K,V> unsafeUneachMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        final List<Iter1IterableMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableMapOperator<K,V>>();
        for (Iter2GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachMap(keyClass,valueClass,keyExpression,valueExpression,expParams));
        }
        return new Iter2IterableMapOperator<K,V>(keyClass, valueClass, components);
    }
    
    
    public final Iter2IterableMapOperator<?,?> uneachMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K,V> Iter2IterableMapOperator<K,V> uneachMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter2IterableMapOperator<K,V> unsafeUneachMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        final List<Iter1IterableMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableMapOperator<K,V>>();
        for (Iter2GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachMap(keyClass, valueClass, mapBuilder));
        }
        return new Iter2IterableMapOperator<K,V>(keyClass, valueClass, components);
    }
    
    
    public final <K,V> Iter2IterableMapOperator<K,V> uneachMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter2IterableMapOperator<?,?> uneachMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachMap(null, null, mapBuilder);
    }
    
    
    final <K> Iter2IterableListMapOperator<K,T> unsafeUneachListMap(
            final Class<K> keyClass, final String keyExpression, final List<Object> expParams) {
        final List<Iter1IterableListMapOperator<K,T>> components = 
            new ArrayList<Iter1IterableListMapOperator<K,T>>();
        for (Iter2GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachListMap(keyClass,keyExpression,expParams));
        }
        return new Iter2IterableListMapOperator<K,T>(keyClass, getOperatorType(), components);
    }
    
    
    public final Iter2IterableListMapOperator<?,T> uneachListMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachListMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter2IterableListMapOperator<K,T> uneachListMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachListMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter2IterableListMapOperator<K,V> unsafeUneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        final List<Iter1IterableListMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableListMapOperator<K,V>>();
        for (Iter2GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachListMap(keyClass,valueClass,keyExpression,valueExpression,expParams));
        }
        return new Iter2IterableListMapOperator<K,V>(keyClass, valueClass, components);
    }
    
    
    public final Iter2IterableListMapOperator<?,?> uneachListMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachListMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K,V> Iter2IterableListMapOperator<K,V> uneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachListMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter2IterableListMapOperator<K,V> unsafeUneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        final List<Iter1IterableListMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableListMapOperator<K,V>>();
        for (Iter2GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachListMap(keyClass, valueClass, mapBuilder));
        }
        return new Iter2IterableListMapOperator<K,V>(keyClass, valueClass, components);
    }
    
    
    public final <K,V> Iter2IterableListMapOperator<K,V> uneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachListMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter2IterableListMapOperator<?,?> uneachListMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachListMap(null, null, mapBuilder);
    }

    
    final <K> Iter2IterableSetMapOperator<K,T> unsafeUneachSetMap(
            final Class<K> keyClass, final String keyExpression, final List<Object> expParams) {
        final List<Iter1IterableSetMapOperator<K,T>> components = 
            new ArrayList<Iter1IterableSetMapOperator<K,T>>();
        for (Iter2GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachSetMap(keyClass,keyExpression,expParams));
        }
        return new Iter2IterableSetMapOperator<K,T>(keyClass, getOperatorType(), components);
    }
    
    
    public final Iter2IterableSetMapOperator<?,T> uneachSetMap(
            final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachSetMap(null, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K> Iter2IterableSetMapOperator<K,T> uneachSetMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        return unsafeUneachSetMap(keyClass, keyExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter2IterableSetMapOperator<K,V> unsafeUneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, 
            final List<Object> expParams) {
        final List<Iter1IterableSetMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableSetMapOperator<K,V>>();
        for (Iter2GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachSetMap(keyClass,valueClass,keyExpression,valueExpression,expParams));
        }
        return new Iter2IterableSetMapOperator<K,V>(keyClass, valueClass, components);
    }
    
    
    public final Iter2IterableSetMapOperator<?,?> uneachSetMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachSetMap(null, null, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams)); 
    }
    
    
    public final <K,V> Iter2IterableSetMapOperator<K,V> uneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        Validate.notNull(keyExpression, "Key expression cannot be null");
        Validate.notNull(valueExpression, "Value expression cannot be null");
        return unsafeUneachSetMap(keyClass, valueClass, keyExpression, valueExpression, OperatorUtils.safeEvaluationParameters(optionalExpParams));
    }
    
    
    final <K,V> Iter2IterableSetMapOperator<K,V> unsafeUneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        final List<Iter1IterableSetMapOperator<K,V>> components = 
            new ArrayList<Iter1IterableSetMapOperator<K,V>>();
        for (Iter2GenericUniqTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeUneachSetMap(keyClass, valueClass, mapBuilder));
        }
        return new Iter2IterableSetMapOperator<K,V>(keyClass, valueClass, components);
    }
    
    
    public final <K,V> Iter2IterableSetMapOperator<K,V> uneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachSetMap(keyClass, valueClass, mapBuilder);
    }
    
    
    public final Iter2IterableSetMapOperator<?,?> uneachSetMap(
            final MapBuilder<T,Object,Object> mapBuilder) {
        Validate.notNull(mapBuilder, "Map builder cannot be null");
        return unsafeUneachSetMap(null, null, mapBuilder);
    }
    
    
}

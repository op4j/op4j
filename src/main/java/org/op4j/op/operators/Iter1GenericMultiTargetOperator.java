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
import org.op4j.exceptions.NonUniqueTargetException;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.FilterContext;
import org.op4j.op.interfaces.GenericMultiTargetIteratingShapeableAsIterableOperator;
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
public class Iter1GenericMultiTargetOperator<T> 
        extends Iter1GenericAbstractOperator<T>
        implements GenericMultiTargetIteratingShapeableAsIterableOperator<T> {
    

    
    private static <T> List<Iter0GenericMultiTargetOperator<T>> createTargets(
            final Iter1GenericAbstractOperator<T> oldOp, final int pos, final List<?> newObjects) {
        final List<Iter0GenericMultiTargetOperator<T>> newTargets = 
            new ArrayList<Iter0GenericMultiTargetOperator<T>>();
        for (Iter0GenericAbstractOperator<T> oldOpTarget : oldOp.getTargets()) {
            newTargets.add(new Iter0GenericMultiTargetOperator<T>(oldOpTarget, pos, newObjects));
        }
        return newTargets;
    }
    
    
    Iter1GenericMultiTargetOperator(final Iter1GenericAbstractOperator<T> oldOp, final int pos, final List<?> newObjects) {
        super(oldOp.getOperatorType(),createTargets(oldOp, pos, newObjects));
    }

    
    Iter1GenericMultiTargetOperator(final Class<T> operatorClass, final List<? extends Iter0GenericMultiTargetOperator<T>> targetOps) {
        this((operatorClass != null? Types.getRawTypeForClass(operatorClass) : null), targetOps);
    }
    
    
    Iter1GenericMultiTargetOperator(final Type operatorType, final List<? extends Iter0GenericMultiTargetOperator<T>> targetOps) {
        super(operatorType,targetOps);
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<Iter0GenericMultiTargetOperator<T>> getTargets() {
        return (List<Iter0GenericMultiTargetOperator<T>>) getAbstractTargets();
    }
    
    
    @Override
    @SuppressWarnings("unchecked")
    final Iter1GenericMultiTargetOperator<?> unsafeRaw() {
        List<Iter0GenericMultiTargetOperator<?>> components = 
            new ArrayList<Iter0GenericMultiTargetOperator<?>>();
        for (Iter0GenericMultiTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeRaw());
        }
        return new Iter1GenericMultiTargetOperator((Type)null, components);
    }
    
    
    public final Iter1GenericMultiTargetOperator<?> raw() {
        return unsafeRaw();
    }
    
    
    final Iter1GenericMultiTargetOperator<T> unsafeCast(final TypeScheme typeScheme) {
        List<Iter0GenericMultiTargetOperator<T>> components = 
            new ArrayList<Iter0GenericMultiTargetOperator<T>>();
        for (Iter0GenericMultiTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeCast(typeScheme));
        }
        return new Iter1GenericMultiTargetOperator<T>(getOperatorType(), components);
    }

    
    public final Iter1GenericMultiTargetOperator<T> cast(final String typeSchemeName) {
        Validate.notNull(typeSchemeName, "Type scheme name cannot be null");
        return unsafeCast(TypeSchemes.forName(typeSchemeName));
    }
    
    
    public final Iter1GenericMultiTargetOperator<T> cast(final TypeScheme typeScheme) {
        Validate.notNull(typeScheme, "Type scheme cannot be null");
        Validate.isTrue(!typeScheme.hasLiterals(), 
                "Cast type scheme " + typeScheme + " cannot contain literals");
        Validate.isTrue(typeScheme.getComponentCount() == size(), 
                "Cast type scheme " + typeScheme + " should have exactly " + size() +" member/s");
        return unsafeCast(typeScheme);
    }
    
    
    @Override
    final <X> Iter1GenericMultiTargetOperator<X> unsafeAs(final Class<X> newOperatorClass) {
        List<Iter0GenericMultiTargetOperator<X>> components = 
            new ArrayList<Iter0GenericMultiTargetOperator<X>>();
        for (Iter0GenericMultiTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeAs(newOperatorClass));
        }
        return new Iter1GenericMultiTargetOperator<X>(newOperatorClass, components);
    }
    

    public final <X> Iter1GenericMultiTargetOperator<X> as(final Class<X> newOperatorClass) {
        Validate.notNull(newOperatorClass, "Class cannot be null");
        return unsafeAs(newOperatorClass);
    }

    
    final Iter1GenericUniqTargetOperator<T> unsafeChoose(final int targetIndex) {
        final List<Iter0GenericUniqTargetOperator<T>> components = 
            new ArrayList<Iter0GenericUniqTargetOperator<T>>();
        for (Iter0GenericMultiTargetOperator<T> targetOp : getTargets()) {
            components.add(targetOp.unsafeChoose(targetIndex));
        }
        return new Iter1GenericUniqTargetOperator<T>(getOperatorType(), components);
    }

    
    final Iter1GenericMultiTargetOperator<T> unsafeChooseSome(final int... targetIndices) {
        final List<Iter0GenericMultiTargetOperator<T>> components = 
            new ArrayList<Iter0GenericMultiTargetOperator<T>>();
        for (Iter0GenericMultiTargetOperator<T> targetOp : getTargets()) {
            components.add(targetOp.unsafeChooseSome(targetIndices));
        }
        return new Iter1GenericMultiTargetOperator<T>(getOperatorType(), components);
    }

    
    public final Iter1GenericUniqTargetOperator<T> choose(final int targetIndex) {
        Validate.isTrue(targetIndex < size(), 
                "Cannot select target " + targetIndex + ", size is " + size());
        return unsafeChoose(targetIndex);
    }

    
    public final Iter1GenericMultiTargetOperator<T> chooseSome(final int... targetIndices) {
        Validate.isTrue(
                (targetIndices != null && targetIndices.length > 0), "Target indices cannot be empty");
        return unsafeChooseSome(targetIndices);
    }

    
    public final Iter1GenericUniqTargetOperator<T> uniq() {
        if (size() > 1) {
            throw new NonUniqueTargetException();
        }
        return unsafeChoose(0);
    }

    
    final Iter1IterableMapOperator<T,T> unsafeBuildMap() {
        final List<Iter0IterableMapOperator<T,T>> components = 
            new ArrayList<Iter0IterableMapOperator<T,T>>();
        for (Iter0GenericMultiTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildMap());
        }
        return new Iter1IterableMapOperator<T,T>(getOperatorType(), getOperatorType(), components);
    }

    
    public final Iter1IterableMapOperator<T,T> buildMap() {
        return unsafeBuildMap();
    }

    
    final <K,V> Iter1IterableMapOperator<K,V> unsafeBuildMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        final List<Iter0IterableMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableMapOperator<K,V>>();
        for (Iter0GenericMultiTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildMap(keyClass,valueClass));
        }
        return new Iter1IterableMapOperator<K,V>(keyClass, valueClass, components);
    }

    
    public final <K,V> Iter1IterableMapOperator<K,V> buildMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeBuildMap(keyClass, valueClass);
    }

    
    final Iter1IterableListMapOperator<T,T> unsafeBuildListMap() {
        final List<Iter0IterableListMapOperator<T,T>> components = 
            new ArrayList<Iter0IterableListMapOperator<T,T>>();
        for (Iter0GenericMultiTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildListMap());
        }
        return new Iter1IterableListMapOperator<T,T>(getOperatorType(), getOperatorType(), components);
    }

    
    public final Iter1IterableListMapOperator<T,T> buildListMap() {
        return unsafeBuildListMap();
    }

    
    final <K,V> Iter1IterableListMapOperator<K,V> unsafeBuildListMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        final List<Iter0IterableListMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableListMapOperator<K,V>>();
        for (Iter0GenericMultiTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildListMap(keyClass,valueClass));
        }
        return new Iter1IterableListMapOperator<K,V>(keyClass, valueClass, components);
    }

    
    public final <K,V> Iter1IterableListMapOperator<K,V> buildListMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeBuildListMap(keyClass, valueClass);
    }

    
    final Iter1IterableSetMapOperator<T,T> unsafeBuildSetMap() {
        final List<Iter0IterableSetMapOperator<T,T>> components = 
            new ArrayList<Iter0IterableSetMapOperator<T,T>>();
        for (Iter0GenericMultiTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildSetMap());
        }
        return new Iter1IterableSetMapOperator<T,T>(getOperatorType(), getOperatorType(), components);
    }

    
    public final Iter1IterableSetMapOperator<T,T> buildSetMap() {
        return unsafeBuildSetMap();
    }

    
    final <K,V> Iter1IterableSetMapOperator<K,V> unsafeBuildSetMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        final List<Iter0IterableSetMapOperator<K,V>> components = 
            new ArrayList<Iter0IterableSetMapOperator<K,V>>();
        for (Iter0GenericMultiTargetOperator<T> targetOp : this.getTargets()) {
            components.add(targetOp.unsafeBuildSetMap(keyClass,valueClass));
        }
        return new Iter1IterableSetMapOperator<K,V>(keyClass, valueClass, components);
    }

    
    public final <K,V> Iter1IterableSetMapOperator<K,V> buildSetMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeBuildSetMap(keyClass, valueClass);
    }


    final Iter1GenericMultiTargetOperator<T> unsafeFilter(
            final String expression, final List<Object> parameters) {

        final List<Iter0GenericMultiTargetOperator<T>> components = 
            new ArrayList<Iter0GenericMultiTargetOperator<T>>();
        for (Iter0GenericMultiTargetOperator<T> targetOp : this.getTargets()) {
            final Object targetOpResult =
                OgnlUtils.getValueByOgnlExpression(
                        targetOp.getTargetObjects(), expression, parameters);
            if (!(targetOpResult instanceof Boolean)) {
                throw new InvalidExpressionException("Expression \"" + expression + 
                        "\" did not evaluate to boolean result");
            }
            if (!((Boolean)targetOpResult).booleanValue()) {
                components.add(targetOp);
            }
        }
        return new Iter1GenericMultiTargetOperator<T>(getOperatorType(), components);
        
    }

    
    final Iter1GenericMultiTargetOperator<T> unsafeFilter(final Filter<T> filter) {

        final List<Iter0GenericMultiTargetOperator<T>> components = 
            new ArrayList<Iter0GenericMultiTargetOperator<T>>();
        for (Iter0GenericMultiTargetOperator<T> targetOp : this.getTargets()) {
            final FilterContext<T> filterContext =
                new FilterContextImpl<T>(targetOp.getTargetObjects());
            if (!filter.eval(filterContext)) {
                components.add(targetOp);
            }
        }
        return new Iter1GenericMultiTargetOperator<T>(getOperatorType(), components);
        
    }


    public final Iter1GenericMultiTargetOperator<T> filter(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeFilter(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

    
    public final Iter1GenericMultiTargetOperator<T> filter(final Filter<T> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeFilter(filter);
    }

    
}

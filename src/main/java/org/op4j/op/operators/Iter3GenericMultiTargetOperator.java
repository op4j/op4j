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
import org.op4j.exceptions.NonUniqueTargetException;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.GenericMultiTargetIteratingOperator;
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
public final class Iter3GenericMultiTargetOperator<T> 
        extends Iter3GenericAbstractOperator<T>
        implements GenericMultiTargetIteratingOperator<T> {
    

    
    private static <T> List<Iter2GenericMultiTargetOperator<T>> createTargets(
            final Iter3GenericAbstractOperator<T> oldOp, final int pos, final List<?> newObjects) {
        final List<Iter2GenericMultiTargetOperator<T>> newTargets = 
            new ArrayList<Iter2GenericMultiTargetOperator<T>>();
        for (Iter2GenericAbstractOperator<T> oldOpTarget : oldOp.getTargets()) {
            newTargets.add(new Iter2GenericMultiTargetOperator<T>(oldOpTarget, pos, newObjects));
        }
        return newTargets;
    }
    
    
    Iter3GenericMultiTargetOperator(final Iter3GenericAbstractOperator<T> oldOp, final int pos, final List<?> newObjects) {
        super(oldOp.getOperatorType(),createTargets(oldOp, pos, newObjects));
    }

    
    Iter3GenericMultiTargetOperator(final Class<T> operatorClass, final List<? extends Iter2GenericMultiTargetOperator<T>> targetOps) {
        this((operatorClass != null? Types.getRawTypeForClass(operatorClass) : null), targetOps);
    }
    
    
    Iter3GenericMultiTargetOperator(final Type operatorType, final List<? extends Iter2GenericMultiTargetOperator<T>> targetOps) {
        super(operatorType,targetOps);
    }
    

    @Override
    @SuppressWarnings("unchecked")
    final List<Iter2GenericMultiTargetOperator<T>> getTargets() {
        return (List<Iter2GenericMultiTargetOperator<T>>) getAbstractTargets();
    }
    
    
    @Override
    @SuppressWarnings("unchecked")
    final Iter3GenericMultiTargetOperator<?> unsafeRaw() {
        List<Iter2GenericMultiTargetOperator<?>> components = 
            new ArrayList<Iter2GenericMultiTargetOperator<?>>();
        for (Iter2GenericMultiTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeRaw());
        }
        return new Iter3GenericMultiTargetOperator((Type)null, components);
    }
    
    
    public final Iter3GenericMultiTargetOperator<?> raw() {
        return unsafeRaw();
    }
    
    
    final Iter3GenericMultiTargetOperator<T> unsafeCast(final TypeScheme typeScheme) {
        List<Iter2GenericMultiTargetOperator<T>> components = 
            new ArrayList<Iter2GenericMultiTargetOperator<T>>();
        for (Iter2GenericMultiTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeCast(typeScheme));
        }
        return new Iter3GenericMultiTargetOperator<T>(getOperatorType(), components);
    }

    
    public final Iter3GenericMultiTargetOperator<T> cast(final String typeSchemeName) {
        Validate.notNull(typeSchemeName, "Type scheme name cannot be null");
        return unsafeCast(TypeSchemes.forName(typeSchemeName));
    }
    
    
    public final Iter3GenericMultiTargetOperator<T> cast(final TypeScheme typeScheme) {
        Validate.notNull(typeScheme, "Type scheme cannot be null");
        Validate.isTrue(!typeScheme.hasLiterals(), 
                "Cast type scheme " + typeScheme + " cannot contain literals");
        Validate.isTrue(typeScheme.getComponentCount() == size(), 
                "Cast type scheme " + typeScheme + " should have exactly " + size() +" member/s");
        return unsafeCast(typeScheme);
    }
    
    
    @Override
    final <X> Iter3GenericMultiTargetOperator<X> unsafeAs(final Class<X> newOperatorClass) {
        List<Iter2GenericMultiTargetOperator<X>> components = 
            new ArrayList<Iter2GenericMultiTargetOperator<X>>();
        for (Iter2GenericMultiTargetOperator<T> target : getTargets()) {
            components.add(target.unsafeAs(newOperatorClass));
        }
        return new Iter3GenericMultiTargetOperator<X>(newOperatorClass, components);
    }
    

    public final <X> Iter3GenericMultiTargetOperator<X> as(final Class<X> newOperatorClass) {
        Validate.notNull(newOperatorClass, "Class cannot be null");
        return unsafeAs(newOperatorClass);
    }

    
    final Iter3GenericUniqTargetOperator<T> unsafeChoose(final int targetIndex) {
        final List<Iter2GenericUniqTargetOperator<T>> components = 
            new ArrayList<Iter2GenericUniqTargetOperator<T>>();
        for (Iter2GenericMultiTargetOperator<T> targetOp : getTargets()) {
            components.add(targetOp.unsafeChoose(targetIndex));
        }
        return new Iter3GenericUniqTargetOperator<T>(getOperatorType(), components);
    }

    
    final Iter3GenericMultiTargetOperator<T> unsafeChooseSome(final int... targetIndices) {
        final List<Iter2GenericMultiTargetOperator<T>> components = 
            new ArrayList<Iter2GenericMultiTargetOperator<T>>();
        for (Iter2GenericMultiTargetOperator<T> targetOp : getTargets()) {
            components.add(targetOp.unsafeChooseSome(targetIndices));
        }
        return new Iter3GenericMultiTargetOperator<T>(getOperatorType(), components);
    }

    
    public final Iter3GenericUniqTargetOperator<T> choose(final int targetIndex) {
        Validate.isTrue(targetIndex < size(), 
                "Cannot select target " + targetIndex + ", size is " + size());
        return unsafeChoose(targetIndex);
    }

    
    public final Iter3GenericMultiTargetOperator<T> chooseSome(final int... targetIndices) {
        Validate.isTrue(
                (targetIndices != null && targetIndices.length > 0), "Target indices cannot be empty");
        return unsafeChooseSome(targetIndices);
    }

    
    public final Iter3GenericUniqTargetOperator<T> uniq() {
        if (size() > 1) {
            throw new NonUniqueTargetException();
        }
        return unsafeChoose(0);
    }


    final Iter3GenericMultiTargetOperator<T> unsafeFilter(
            final String expression, final List<Object> parameters) {
        final List<Iter2GenericMultiTargetOperator<T>> components = 
            new ArrayList<Iter2GenericMultiTargetOperator<T>>();
        for (Iter2GenericMultiTargetOperator<T> targetOp : getTargets()) {
            components.add(targetOp.unsafeFilter(expression, parameters));
        }
        return new Iter3GenericMultiTargetOperator<T>(getOperatorType(), components);
    }

    
    final Iter3GenericMultiTargetOperator<T> unsafeFilter(final Filter<T> filter) {
        final List<Iter2GenericMultiTargetOperator<T>> components = 
            new ArrayList<Iter2GenericMultiTargetOperator<T>>();
        for (Iter2GenericMultiTargetOperator<T> targetOp : getTargets()) {
            components.add(targetOp.unsafeFilter(filter));
        }
        return new Iter3GenericMultiTargetOperator<T>(getOperatorType(), components);
    }


    public final Iter3GenericMultiTargetOperator<T> filter(
            final String expression, final Object... parameters) {
        Validate.notNull(expression, "Expression cannot be null nor empty");
        return unsafeFilter(expression, OperatorUtils.safeEvaluationParameters(parameters));
    }

    
    public final Iter3GenericMultiTargetOperator<T> filter(final Filter<T> filter) {
        Validate.notNull(filter, "Filter cannot be null");
        return unsafeFilter(filter);
    }

    
}

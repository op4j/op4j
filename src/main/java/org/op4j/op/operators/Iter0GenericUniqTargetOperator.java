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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.op4j.exceptions.InvalidOperatorCastException;
import org.op4j.exceptions.MethodInvocationException;
import org.op4j.exceptions.NullTargetException;
import org.op4j.op.interfaces.GenericUniqTargetShapeableAsIterableOperator;
import org.op4j.operation.Result;
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
public final class Iter0GenericUniqTargetOperator<T> 
        extends Iter0GenericAbstractOperator<T>
        implements GenericUniqTargetShapeableAsIterableOperator<T> {
    
    
    
    Iter0GenericUniqTargetOperator(final Type operatorType, final Result result) {
        super(operatorType, result);
    }

    
    Iter0GenericUniqTargetOperator(final Class<T> operatorClass, final Object object) {
        this((operatorClass != null? Types.getRawTypeForClass(operatorClass) : null), object);
    }

    
    Iter0GenericUniqTargetOperator(final Type operatorType, final Object object) {
        super(operatorType, Collections.singletonList(object));
    }

    
    Iter0GenericUniqTargetOperator(final Type operatorType, final Type objectType, final Object object) {
        super(operatorType, TypeSchemes.forSingleType(objectType), Collections.singletonList(object));
    }
    

    
    @Override
    protected final boolean isUniqTarget() {
        return true;
    }
    
    
    @Override
    final Iter0GenericUniqTargetOperator<?> unsafeRaw() {
        return new Iter0GenericUniqTargetOperator<Object>(
                (Type) null, getTargetObjects().get(0));
    }
    
    
    public final Iter0GenericUniqTargetOperator<?> raw() {
        return unsafeRaw();
    }
    
    
    final Iter0GenericUniqTargetOperator<T> unsafeCast(final TypeScheme typeScheme) {
        return new Iter0GenericUniqTargetOperator<T>(
                getOperatorType(), 
                typeScheme.getType(0),
                getTargetObjects().get(0));
    }

    
    public final Iter0GenericUniqTargetOperator<T> cast(final String typeSchemeName) {
        Validate.notNull(typeSchemeName, "Type scheme name cannot be null");
        return unsafeCast(TypeSchemes.forName(typeSchemeName));
    }
    
    
    public final Iter0GenericUniqTargetOperator<T> cast(final TypeScheme typeScheme) {
        Validate.notNull(typeScheme, "Type scheme cannot be null");
        Validate.isTrue(!typeScheme.hasLiterals(), 
                "Cast type scheme " + typeScheme + " cannot contain literals");
        Validate.isTrue(typeScheme.getComponentCount() == size(), 
                "Cast type scheme " + typeScheme + " should have exactly " + size() +" member/s");
        return unsafeCast(typeScheme);
    }
    
    
    @Override
    final <X> Iter0GenericUniqTargetOperator<X> unsafeAs(final Class<X> newOperatorClass) {
        // Note that "as" operations make casts dissapear
        return new Iter0GenericUniqTargetOperator<X>(
                newOperatorClass,
                getTargetObjects().get(0));
    }
    

    public final <X> Iter0GenericUniqTargetOperator<X> as(final Class<X> newOperatorClass) {
        Validate.notNull(newOperatorClass, "Class cannot be null");
        return unsafeAs(newOperatorClass);
    }

    

    final <X> Iter0GenericUniqTargetOperator<X> unsafeCall(
            final Class<X> resultClass, final String methodName, final List<Object> arguments) {
        
        if (areAllTargetsNull()) {
            throw new NullTargetException("call");
        }
        
        final Object targetObject = getTargetObjects().get(0);
        final Expression expression = 
            new Expression(targetObject, methodName, arguments.toArray(new Object[arguments.size()]));
        
        try {
            final Object resultObject = expression.getValue();
            return new Iter0GenericUniqTargetOperator<X>(resultClass, resultObject);
        } catch (Exception e) {
            throw new MethodInvocationException(methodName, targetObject.getClass(), e);
        }
        
    }
    

    public final Iter0GenericUniqTargetOperator<?> call(
            final String methodName, final Object... parameters) {
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeCall(null, methodName, OperatorUtils.safeEvaluationParameters(parameters));
    }
    

    public final <X> Iter0GenericUniqTargetOperator<X> call(
            final Class<X> resultClass, final String methodName, final Object... parameters) {
        Validate.notNull(resultClass, "Return class cannot be null");
        Validate.notEmpty(methodName, "Method name cannot be null nor empty");
        return unsafeCall(resultClass, methodName,OperatorUtils.safeEvaluationParameters(parameters));
    }


    final <X> Iter0IterableArrayOperator<X> unsafeAsArray(final Class<X> ofClass) {

        // Note that "as" operations make casts dissapear
        
        final T targetObject = getTargetObjects().get(0);

        if (targetObject != null) {
            if (!Object[].class.isAssignableFrom(targetObject.getClass())) {
                throw new InvalidOperatorCastException(targetObject.getClass(),Object[].class);
            }
        }

        return new Iter0IterableArrayOperator<X>(
                    ofClass,
                    (Object[]) getTargetObjects().get(0));
        
    }


    public final Iter0IterableArrayOperator<?> asArray() {
        return unsafeAsArray(null);
    }


    public final <X> Iter0IterableArrayOperator<X> asArray(final Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeAsArray(ofClass);
    }


    final <X> Iter0IterableListOperator<X> unsafeAsList(final Class<X> ofClass) {
        
        // Note that "as" operations make casts dissapear

        final T targetObject = getTargetObjects().get(0);

        if (targetObject != null) {
            if (!List.class.isAssignableFrom(targetObject.getClass())) {
                throw new InvalidOperatorCastException(targetObject.getClass(),List.class);
            }
        }

        return new Iter0IterableListOperator<X>(
                    ofClass,
                    (List<?>) getTargetObjects().get(0));
        
    }


    public final Iter0IterableListOperator<?> asList() {
        return unsafeAsList(null);
    }


    public final <X> Iter0IterableListOperator<X> asList(final Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeAsList(ofClass);
    }


    final <X> Iter0IterableSetOperator<X> unsafeAsSet(final Class<X> ofClass) {
        
        // Note that "as" operations make casts dissapear

        final T targetObject = getTargetObjects().get(0);

        if (targetObject != null) {
            if (!Set.class.isAssignableFrom(targetObject.getClass())) {
                throw new InvalidOperatorCastException(targetObject.getClass(),Set.class);

            }
        }

        return new Iter0IterableSetOperator<X>(
                    ofClass,
                    (Set<?>) getTargetObjects().get(0));
        
    }


    public final Iter0IterableSetOperator<?> asSet() {
        return unsafeAsSet(null);
    }


    public final <X> Iter0IterableSetOperator<X> asSet(final Class<X> ofClass) {
        Validate.notNull(ofClass, "Class cannot be null");
        return unsafeAsSet(ofClass);
    }


    final <K,V> Iter0IterableMapOperator<K, V> unsafeAsMap(final Class<K> keyClass,
            final Class<V> valueClass) {
        
        // Note that "as" operations make casts dissapear

        final T targetObject = getTargetObjects().get(0);

        if (targetObject != null) {
            if (!Map.class.isAssignableFrom(targetObject.getClass())) {
                throw new InvalidOperatorCastException(targetObject.getClass(),Map.class);
            }
        }

        return new Iter0IterableMapOperator<K,V>(
                    keyClass,
                    valueClass,
                    (Map<?,?>) getTargetObjects().get(0));
        
    }


    public final Iter0IterableMapOperator<?,?> asMap() {
        return unsafeAsMap(null, null);
    }


    public final <K,V> Iter0IterableMapOperator<K, V> asMap(final Class<K> keyClass,
            final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsMap(keyClass, valueClass);
    }


    @SuppressWarnings("unchecked")
    final <K,V> Iter0IterableListMapOperator<K,V> unsafeAsListMap(final Class<K> keyClass,
            final Class<V> valueClass) {
        
        // Note that "as" operations make casts dissapear

        final T targetObject = getTargetObjects().get(0);

        if (targetObject != null) {
            if (!Map.class.isAssignableFrom(targetObject.getClass())) {
                throw new InvalidOperatorCastException(targetObject.getClass(),Map.class);
            }
        }

        return new Iter0IterableListMapOperator<K,V>(
                    keyClass,
                    valueClass,
                    (Map<?,List<?>>) getTargetObjects().get(0));
        
    }


    public final Iter0IterableListMapOperator<?,?> asListMap() {
        return unsafeAsListMap(null, null);
    }


    public final <K, V> Iter0IterableListMapOperator<K,V> asListMap(final Class<K> keyClass,
            final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsListMap(keyClass, valueClass);
    }


    @SuppressWarnings("unchecked")
    final <K,V> Iter0IterableSetMapOperator<K,V> unsafeAsSetMap(final Class<K> keyClass,
            final Class<V> valueClass) {
        
        // Note that "as" operations make casts dissapear

        final T targetObject = getTargetObjects().get(0);

        if (targetObject != null) {
            if (!Map.class.isAssignableFrom(targetObject.getClass())) {
                throw new InvalidOperatorCastException(targetObject.getClass(),Map.class);
            }
        }

        return new Iter0IterableSetMapOperator<K,V>(
                    keyClass,
                    valueClass,
                    (Map<?,Set<?>>) getTargetObjects().get(0));
        
    }


    public final Iter0IterableSetMapOperator<?,?> asSetMap() {
        return unsafeAsSetMap(null, null);
    }


    public final <K, V> Iter0IterableSetMapOperator<K,V> asSetMap(final Class<K> keyClass,
            final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsSetMap(keyClass, valueClass);
    }


    final <K,V> Iter0MapEntryOperator<K,V> unsafeAsMapEntry(
            final Class<K> keyClass, final Class<V> valueClass) {
        
        // Note that "as" operations make casts dissapear

        final T targetObject = getTargetObjects().get(0);

        if (targetObject != null) {
            if (!Map.Entry.class.isAssignableFrom(targetObject.getClass())) {
                throw new InvalidOperatorCastException(targetObject.getClass(),Map.Entry.class);
            }
        }

        return new Iter0MapEntryOperator<K,V>(
                    keyClass,
                    valueClass,
                    (Map.Entry<?,?>) getTargetObjects().get(0));
        
    }


    public final Iter0MapEntryOperator<?,?> asMapEntry() {
        return unsafeAsMapEntry(null, null);
    }


    public final <K,V> Iter0MapEntryOperator<K,V> asMapEntry(
            final Class<K> keyClass, final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeAsMapEntry(keyClass, valueClass);
    }


    public final T get() {
        return getTargetObjects().get(0);
    }
    
    
}

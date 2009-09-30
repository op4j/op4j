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
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.op4j.exceptions.NonUniqueTargetException;
import org.op4j.op.interfaces.GenericMultiTargetShapeableAsIterableOperator;
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
public final class Iter0GenericMultiTargetOperator<T> 
        extends Iter0GenericAbstractOperator<T>
        implements GenericMultiTargetShapeableAsIterableOperator<T> {
    
    
    
    private static <T> List<?> prepareObjects(
            final Iter0GenericAbstractOperator<T> oldOp, final int pos, final List<?> newObjects) {
        
        final List<Object> objects = new ArrayList<Object>(oldOp.getTargetObjects());
        if (pos == Integer.MAX_VALUE) {
            // add objects
            objects.addAll(newObjects);
        } else {
            // insert objects
            objects.addAll(pos, newObjects);
        }
        return objects;
        
    }

    
    private static <T> TypeScheme prepareTypeScheme(
            final Iter0GenericAbstractOperator<T> oldOp, final int pos, 
            final List<?> newObjects) {
        
        final TypeScheme oldTargetTypeScheme = oldOp.getTargetTypeScheme();
        
        final List<Type> types = new ArrayList<Type>();
        for (int i = 0; i < oldTargetTypeScheme.getComponentCount(); i++) {
            types.add(oldTargetTypeScheme.getType(i));
        }
        
        final List<Type> newObjectsTypes = new ArrayList<Type>();
        for (int i = 0; i < newObjects.size(); i++) {
            newObjectsTypes.add(
                    (oldOp.getOperatorType() != null?
                            oldOp.getOperatorType() :
                            Types.OBJECT));
        }
        
        if (pos == Integer.MAX_VALUE) {
            // add types
            types.addAll(newObjectsTypes);
        } else {
            // insert types
            types.addAll(pos, newObjectsTypes);
        }
        
        return TypeSchemes.forTypeList(types);
        
    }
    
    
    Iter0GenericMultiTargetOperator(
            final Iter0GenericAbstractOperator<T> oldOp, final int pos, final List<?> newObjects) {
        super(
                oldOp.getOperatorType(),
                prepareTypeScheme(oldOp, pos, newObjects),
                prepareObjects(oldOp, pos, newObjects));
    }

    
    Iter0GenericMultiTargetOperator(final Class<T> operatorClass, final List<?> objects) {
        this((operatorClass != null? Types.getRawTypeForClass(operatorClass) : null), objects);
    }

    
    Iter0GenericMultiTargetOperator(final Type operatorType, final List<?> objects) {
        super(operatorType, objects);
    }
    
    
    Iter0GenericMultiTargetOperator(final Type operatorType, final TypeScheme typeScheme, final List<?> objects) {
        super(operatorType, typeScheme, objects);
    }
    
    
    Iter0GenericMultiTargetOperator(final Type operatorType, final Result result) {
        super(operatorType, result);
    }
    
    
    
    @Override
    protected final boolean isUniqTarget() {
        return false;
    }
    
    
    @Override
    final Iter0GenericMultiTargetOperator<?> unsafeRaw() {
        return new Iter0GenericMultiTargetOperator<Object>(
                (Type) null, getTargetObjects());
    }
    
    
    public final Iter0GenericMultiTargetOperator<?> raw() {
        return unsafeRaw();
    }
    
    
    final Iter0GenericMultiTargetOperator<T> unsafeCast(final TypeScheme typeScheme) {
        return new Iter0GenericMultiTargetOperator<T>(
                getOperatorType(), typeScheme, getTargetObjects());
    }

    
    public final Iter0GenericMultiTargetOperator<T> cast(final String typeSchemeName) {
        Validate.notNull(typeSchemeName, "Type scheme name cannot be null");
        return unsafeCast(TypeSchemes.forName(typeSchemeName));
    }
    
    
    public final Iter0GenericMultiTargetOperator<T> cast(final TypeScheme typeScheme) {
        Validate.notNull(typeScheme, "Type scheme cannot be null");
        Validate.isTrue(!typeScheme.hasLiterals(), 
                "Cast type scheme " + typeScheme + " cannot contain literals");
        Validate.isTrue(typeScheme.getComponentCount() == size(), 
                "Cast type scheme " + typeScheme + " should have exactly " + size() +" member/s");
        return unsafeCast(typeScheme);
    }
    
    
    @Override
    final <X> Iter0GenericMultiTargetOperator<X> unsafeAs(final Class<X> newOperatorClass) {
        // Note that "as" operations make casts dissapear
        return new Iter0GenericMultiTargetOperator<X>(
                newOperatorClass,
                getTargetObjects());
    }

    
    public final <X> Iter0GenericMultiTargetOperator<X> as(final Class<X> newOperatorClass) {
        Validate.notNull(newOperatorClass, "Class cannot be null");
        return unsafeAs(newOperatorClass);
    }

    
    final Iter0GenericUniqTargetOperator<T> unsafeChoose(final int targetIndex) {
        return new Iter0GenericUniqTargetOperator<T>(
                getOperatorType(), 
                getTargetTypeScheme().getType(targetIndex), 
                getTargetObjects().get(targetIndex));
    }

    
    final Iter0GenericMultiTargetOperator<T> unsafeChooseSome(final int... targetIndices) {
        
        final List<Type> newTypes = new ArrayList<Type>();
        final List<Object> newObjects = new ArrayList<Object>();
        
        for (int i = 0; i < targetIndices.length; i++) {
            newTypes.add(getTargetTypeScheme().getType(targetIndices[i]));
            newObjects.add(getTargetObjects().get(targetIndices[i]));
        }
        return new Iter0GenericMultiTargetOperator<T>(
                getOperatorType(),
                TypeSchemes.forTypeList(newTypes),
                newObjects);
    }

    
    public final Iter0GenericUniqTargetOperator<T> choose(final int targetIndex) {
        Validate.isTrue(targetIndex < size(), 
                "Cannot select target " + targetIndex + ", size is " + size());
        return unsafeChoose(targetIndex);
    }

    
    public final Iter0GenericMultiTargetOperator<T> chooseSome(final int... targetIndices) {
        Validate.notNull(targetIndices, "Target indices cannot be null");
        Validate.isTrue(targetIndices.length > 0, "Target indices cannot be empty");
        return unsafeChooseSome(targetIndices);
    }

    
    public final Iter0GenericUniqTargetOperator<T> uniq() {
        if (size() > 1) {
            throw new NonUniqueTargetException();
        }
        return unsafeChoose(0);
    }

    
    @SuppressWarnings("unchecked")
    final Iter0IterableMapOperator<T,T> unsafeBuildMap() {
        final Map<T,T> newTargetObject = 
            OperatorAggregationUtils.buildMapAggregatedTarget(
                    getTargetObjects(),
                    (getOperatorType() != null?
                        (Class<T>)getOperatorType().getRawClass() : null),
                    (getOperatorType() != null?
                        (Class<T>)getOperatorType().getRawClass() : null));
        return new Iter0IterableMapOperator<T,T>(
                    getOperatorType(),
                    getOperatorType(),
                    newTargetObject);
    }

    
    public final Iter0IterableMapOperator<T,T> buildMap() {
        return unsafeBuildMap();
    }

    
    final <K,V> Iter0IterableMapOperator<K,V> unsafeBuildMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        final Map<K,V> newTargetObject = 
            OperatorAggregationUtils.buildMapAggregatedTarget(
                    getTargetObjects(), keyClass, valueClass);
        return new Iter0IterableMapOperator<K,V>(
                    Types.getRawTypeForClass(keyClass),
                    Types.getRawTypeForClass(valueClass),
                    newTargetObject);
    }

    
    public final <K,V> Iter0IterableMapOperator<K,V> buildMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeBuildMap(keyClass, valueClass);
    }

    
    @SuppressWarnings("unchecked")
    final Iter0IterableListMapOperator<T,T> unsafeBuildListMap() {
        final Map<T,List<T>> newTargetObject = 
            OperatorAggregationUtils.buildListMapAggregatedTarget(
                    getTargetObjects(), 
                    (getOperatorType() != null?
                            (Class<T>)getOperatorType().getRawClass() : null),
                    (getOperatorType() != null?
                            (Class<T>)getOperatorType().getRawClass() : null));
        return new Iter0IterableListMapOperator<T,T>(
                    getOperatorType(),
                    getOperatorType(),
                    newTargetObject);
    }

    
    public final Iter0IterableListMapOperator<T,T> buildListMap() {
        return unsafeBuildListMap();
    }

    
    final <K,V> Iter0IterableListMapOperator<K,V> unsafeBuildListMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        final Map<K,List<V>> newTargetObject = 
            OperatorAggregationUtils.buildListMapAggregatedTarget(
                    getTargetObjects(), keyClass, valueClass);
        return new Iter0IterableListMapOperator<K,V>(
                    Types.getRawTypeForClass(keyClass),
                    Types.getRawTypeForClass(valueClass),
                    newTargetObject);
    }

    
    public final <K,V> Iter0IterableListMapOperator<K,V> buildListMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeBuildListMap(keyClass, valueClass);
    }

    
    @SuppressWarnings("unchecked")
    final Iter0IterableSetMapOperator<T,T> unsafeBuildSetMap() {
        final Map<T,Set<T>> newTargetObject = 
            OperatorAggregationUtils.buildSetMapAggregatedTarget(
                    getTargetObjects(), 
                    (getOperatorType() != null?
                            (Class<T>)getOperatorType().getRawClass() : null),
                    (getOperatorType() != null?
                            (Class<T>)getOperatorType().getRawClass() : null));
        return new Iter0IterableSetMapOperator<T,T>(
                    getOperatorType(),
                    getOperatorType(),
                    newTargetObject);
    }

    
    public final Iter0IterableSetMapOperator<T,T> buildSetMap() {
        return unsafeBuildSetMap();
    }

    
    final <K,V> Iter0IterableSetMapOperator<K,V> unsafeBuildSetMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        final Map<K,Set<V>> newTargetObject = 
            OperatorAggregationUtils.buildSetMapAggregatedTarget(
                    getTargetObjects(), keyClass, valueClass);
        return new Iter0IterableSetMapOperator<K,V>(
                    Types.getRawTypeForClass(keyClass),
                    Types.getRawTypeForClass(valueClass),
                    newTargetObject);
    }

    
    public final <K,V> Iter0IterableSetMapOperator<K,V> buildSetMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeBuildSetMap(keyClass, valueClass);
    }

    
    @SuppressWarnings("unchecked")
    final Iter0IterableArrayMapOperator<T,T> unsafeBuildArrayMap() {
        final Map<T,T[]> newTargetObject = 
            OperatorAggregationUtils.buildArrayMapAggregatedTarget(
                    getTargetObjects(), 
                    (getOperatorType() != null?
                            (Class<T>)getOperatorType().getRawClass() : null),
                    (getOperatorType() != null?
                            (Class<T>)getOperatorType().getRawClass() : null));
        return new Iter0IterableArrayMapOperator<T,T>(
                    getOperatorType(),
                    getOperatorType(),
                    newTargetObject);
    }

    
    public final Iter0IterableArrayMapOperator<T,T> buildArrayMap() {
        return unsafeBuildArrayMap();
    }

    
    final <K,V> Iter0IterableArrayMapOperator<K,V> unsafeBuildArrayMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        final Map<K,V[]> newTargetObject = 
            OperatorAggregationUtils.buildArrayMapAggregatedTarget(
                    getTargetObjects(), keyClass, valueClass);
        return new Iter0IterableArrayMapOperator<K,V>(
                    Types.getRawTypeForClass(keyClass),
                    Types.getRawTypeForClass(valueClass),
                    newTargetObject);
    }

    
    public final <K,V> Iter0IterableArrayMapOperator<K,V> buildArrayMap(
            final Class<K> keyClass, final Class<V> valueClass) {
        Validate.notNull(keyClass, "Key class cannot be null");
        Validate.notNull(valueClass, "Value class cannot be null");
        return unsafeBuildArrayMap(keyClass, valueClass);
    }
    
    
}

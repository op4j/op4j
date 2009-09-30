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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.op4j.operation.Target;
import org.op4j.type.Type;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class OperatorUtils {


    
    @SuppressWarnings("unchecked")
    public static Iter0GenericUniqTargetOperator<?> createOn(final Object target) {
        return new Iter0GenericUniqTargetOperator((Type)null, target);
    }

    
    public static <T> Iter0GenericUniqTargetOperator<T> createOn(final Class<T> ofClass, final T target) {
        return new Iter0GenericUniqTargetOperator<T>(ofClass, target);
    }

    
    @SuppressWarnings("unchecked")
    public static Iter0IterableListOperator<?> createOnList(final List<?> target) {
        return new Iter0IterableListOperator((Type) null, target);
    }

    
    public static <T> Iter0IterableListOperator<T> createOnList(final Class<T> ofClass, final List<T> target) {
        return new Iter0IterableListOperator<T>(ofClass, target);
    }

    
    @SuppressWarnings("unchecked")
    public static Iter0IterableSetOperator<?> createOnSet(final Set<?> target) {
        return new Iter0IterableSetOperator((Type) null, target);
    }

    
    public static <T> Iter0IterableSetOperator<T> createOnSet(final Class<T> ofClass, final Set<T> target) {
        return new Iter0IterableSetOperator<T>(ofClass, target);
    }

    
    @SuppressWarnings("unchecked")
    public static Iter0IterableArrayOperator<?> createOnArray(final Object[] target) {
        return new Iter0IterableArrayOperator((Type) null, target);
    }

    
    public static <T> Iter0IterableArrayOperator<T> createOnArray(final Class<T> ofClass, final T[] target) {
        return new Iter0IterableArrayOperator<T>(ofClass, target);
    }

    
    @SuppressWarnings("unchecked")
    public static Iter0IterableMapOperator<?,?> createOnMap(final Map<?,?> target) {
        return new Iter0IterableMapOperator((Type) null, (Type) null, target);
    }

    
    public static <K,V> Iter0IterableMapOperator<K,V> createOnMap(final Class<K> keyClass, final Class<V> valueClass, final Map<K,V> target) {
        return new Iter0IterableMapOperator<K,V>(keyClass, valueClass, target);
    }

    
    @SuppressWarnings("unchecked")
    public static Iter0IterableListMapOperator<?,?> createOnListMap(final Map<?,? extends List<?>> target) {
        return new Iter0IterableListMapOperator((Type) null, (Type) null, target);
    }

    
    public static <K,V> Iter0IterableListMapOperator<K,V> createOnListMap(final Class<K> keyClass, final Class<V> valueClass, final Map<K,? extends List<V>> target) {
        return new Iter0IterableListMapOperator<K,V>(keyClass, valueClass, target);
    }

    
    @SuppressWarnings("unchecked")
    public static Iter0IterableSetMapOperator<?,?> createOnSetMap(final Map<?,? extends Set<?>> target) {
        return new Iter0IterableSetMapOperator((Type) null, (Type) null, target);
    }

    
    public static <K,V> Iter0IterableSetMapOperator<K,V> createOnSetMap(final Class<K> keyClass, final Class<V> valueClass, final Map<K,? extends Set<V>> target) {
        return new Iter0IterableSetMapOperator<K,V>(keyClass, valueClass, target);
    }

    
    @SuppressWarnings("unchecked")
    public static Iter0IterableArrayMapOperator<?,?> createOnArrayMap(final Map<?,? extends Object[]> target) {
        return new Iter0IterableArrayMapOperator((Type) null, (Type) null, target);
    }

    
    public static <K,V> Iter0IterableArrayMapOperator<K,V> createOnArrayMap(final Class<K> keyClass, final Class<V> valueClass, final Map<K,? extends Object[]> target) {
        return new Iter0IterableArrayMapOperator<K,V>(keyClass, valueClass, target);
    }

    
    @SuppressWarnings("unchecked")
    public static Iter0MapEntryOperator<?,?> createOnMapEntry(final Map.Entry<?,?> target) {
        return new Iter0MapEntryOperator((Type) null, (Type) null, target);
    }

    
    public static <K,V> Iter0MapEntryOperator<K,V> createOnMapEntry(final Class<K> keyClass, final Class<V> valueClass, final Map.Entry<K,V> target) {
        return new Iter0MapEntryOperator<K,V>(keyClass, valueClass, target);
    }

    
    @SuppressWarnings("unchecked")
    public static Iter0GenericMultiTargetOperator<?> createOnAll(final Object... targets) {
        Validate.isTrue(targets == null || targets.length > 0, 
            "Targets must at least contain one object");
        return new Iter0GenericMultiTargetOperator((Type)null, OperatorUtils.safeNewTargetObjects(targets));
    }

    
    public static <T> Iter0GenericMultiTargetOperator<T> createOnAll(final Class<T> ofClass, final T... targets) {
        Validate.isTrue(targets == null || targets.length > 0, 
            "Targets must at least contain one object");
        return new Iter0GenericMultiTargetOperator<T>(ofClass, OperatorUtils.safeNewTargetObjects(targets));
    }
    
    
    
    
        
    static List<Object> safeNewTargetObjects(Object... newTargetObjects) {
        final List<Object> result = new ArrayList<Object>();
        if (newTargetObjects != null) {
            for (Object newTargetObject : newTargetObjects) {
                result.add(newTargetObject);
            }
        } else {
            result.add(null);
        }
        return Collections.unmodifiableList(result);
    }
    
    
    static List<Object> safeEvaluationParameters(Object... arguments) {
        final List<Object> result = new ArrayList<Object>();
        if (arguments != null) {
            for (Object argument : arguments) {
                result.add(argument);
            }
        } else {
            result.add(null);
        }
        return Collections.unmodifiableList(result);
    }
    
    
    static List<Object> safeOperationParameters(Object... parameters) {
        final List<Object> result = new ArrayList<Object>();
        if (parameters != null) {
            for (Object parameter : parameters) {
                if (parameter == null) {
                    throw new IllegalArgumentException("No parameter can be null");
                }
                result.add(parameter);
            }
        } else {
            throw new IllegalArgumentException("No parameter can be null");
        }
        return Collections.unmodifiableList(result);
    }
    

    static <T> List<Target<T>> getTargetsFromIteratedOps(
            final List<? extends Iter0AbstractOperator<T>> targetOps) {
        final List<Target<T>> targets = new ArrayList<Target<T>>();
        for (Iter0AbstractOperator<T> targetOp : targetOps) {
            targets.add(targetOp.getTargets().get(0));
        }
        return targets;
    }

    
    
    private OperatorUtils() {
        super();
    }
    
}

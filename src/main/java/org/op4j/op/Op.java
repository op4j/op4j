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
package org.op4j.op;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.op4j.op.operators.Iter0GenericMultiTargetOperator;
import org.op4j.op.operators.Iter0GenericUniqTargetOperator;
import org.op4j.op.operators.Iter0IterableArrayOperator;
import org.op4j.op.operators.Iter0IterableListMapOperator;
import org.op4j.op.operators.Iter0IterableListOperator;
import org.op4j.op.operators.Iter0IterableMapOperator;
import org.op4j.op.operators.Iter0IterableSetMapOperator;
import org.op4j.op.operators.Iter0IterableSetOperator;
import org.op4j.op.operators.Iter0MapEntryOperator;
import org.op4j.op.operators.OperatorUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Op {

    private static final String OP4J_INITIALIZATION_CLASS_NAME =
        "org.op4j.operations.OperationsInitialization";

    private static final String OP4J_CONTRIB_INITIALIZATION_CLASS_NAME =
        "org.op4j.contrib.operations.OperationsInitialization";

    private static final String INITIALIZATION_METHOD_NAME = "declareAndInitializeOperations";
    
    
    static {
        
        /*
         * Initialize basic op4j operators. This is done this way instead of
         * accessing the class directly to allow OperationsInitialization to
         * be non-public (and non-visible) and still be in the correct package. 
         */
        try {
            
            Class<?> clazz =
                Thread.currentThread().getContextClassLoader().loadClass(
                    OP4J_INITIALIZATION_CLASS_NAME);
            Method initializerMethod =
                clazz.getDeclaredMethod(INITIALIZATION_METHOD_NAME);
            initializerMethod.setAccessible(true);
            initializerMethod.invoke(null);
            initializerMethod.setAccessible(false);
            
        } catch (Exception impossible) {
            throw new RuntimeException(
                    "Broken library: could not initialize op4j", impossible);
        }
        
        
        /*
         * Try to initialize the "contrib" package, if it is present
         * in the classpath.
         */
        try {
            
            Class<?> clazz =
                Thread.currentThread().getContextClassLoader().loadClass(
                    OP4J_CONTRIB_INITIALIZATION_CLASS_NAME);
            Method initializerMethod =
                clazz.getDeclaredMethod(INITIALIZATION_METHOD_NAME);
            initializerMethod.setAccessible(true);
            initializerMethod.invoke(null);
            initializerMethod.setAccessible(false);
            
        } catch (Exception ignored) {
            // it wasn't
        }
        
    }
    
    
    private Op() {
        super();
    }

    
    public static Iter0GenericUniqTargetOperator<?> on(final Object target) {
        return OperatorUtils.createOn(target);
    }

    
    public static <T> Iter0GenericUniqTargetOperator<T> on(final Class<T> ofClass, final T target) {
        return OperatorUtils.createOn(ofClass, target);
    }

    
    public static Iter0IterableListOperator<?> onList(final List<?> target) {
        return OperatorUtils.createOnList(target);
    }

    
    public static <T> Iter0IterableListOperator<T> onList(final Class<T> ofClass, final List<T> target) {
        return OperatorUtils.createOnList(ofClass, target);
    }

    
    public static Iter0IterableSetOperator<?> onSet(final Set<?> target) {
        return OperatorUtils.createOnSet(target);
    }

    
    public static <T> Iter0IterableSetOperator<T> onSet(final Class<T> ofClass, final Set<T> target) {
        return OperatorUtils.createOnSet(ofClass, target);
    }

    
    public static Iter0IterableArrayOperator<?> onArray(final Object[] target) {
        return OperatorUtils.createOnArray(target);
    }

    
    public static <T> Iter0IterableArrayOperator<T> onArray(final Class<T> ofClass, final T[] target) {
        return OperatorUtils.createOnArray(ofClass, target);
    }

    
    public static Iter0IterableMapOperator<?,?> onMap(final Map<?,?> target) {
        return OperatorUtils.createOnMap(target);
    }

    
    public static <K,V> Iter0IterableMapOperator<K,V> onMap(final Class<K> keyClass, final Class<V> valueClass, final Map<K,V> target) {
        return OperatorUtils.createOnMap(keyClass, valueClass, target);
    }

    
    public static Iter0IterableListMapOperator<?,?> onListMap(final Map<?,? extends List<?>> target) {
        return OperatorUtils.createOnListMap(target);
    }

    
    public static <K,V> Iter0IterableListMapOperator<K,V> onListMap(final Class<K> keyClass, final Class<V> valueClass, final Map<K,? extends List<V>> target) {
        return OperatorUtils.createOnListMap(keyClass, valueClass, target);
    }

    
    public static Iter0IterableSetMapOperator<?,?> onSetMap(final Map<?,? extends Set<?>> target) {
        return OperatorUtils.createOnSetMap(target);
    }

    
    public static <K,V> Iter0IterableSetMapOperator<K,V> onSetMap(final Class<K> keyClass, final Class<V> valueClass, final Map<K,? extends Set<V>> target) {
        return OperatorUtils.createOnSetMap(keyClass, valueClass, target);
    }

    
    public static Iter0MapEntryOperator<?,?> onMapEntry(final Map.Entry<?,?> target) {
        return OperatorUtils.createOnMapEntry(target);
    }

    
    public static <K,V> Iter0MapEntryOperator<K,V> onMapEntry(final Class<K> keyClass, final Class<V> valueClass, final Map.Entry<K,V> target) {
        return OperatorUtils.createOnMapEntry(keyClass, valueClass, target);
    }

    
    public static Iter0GenericMultiTargetOperator<?> onAll(final Object... targets) {
        return OperatorUtils.createOnAll(targets);
    }

    
    public static <T> Iter0GenericMultiTargetOperator<T> onAll(final Class<T> ofClass, final T... targets) {
        return OperatorUtils.createOnAll(ofClass, targets);
    }
    
        
}

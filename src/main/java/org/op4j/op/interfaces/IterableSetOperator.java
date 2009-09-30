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
package org.op4j.op.interfaces;

import java.util.Comparator;
import java.util.Set;

import org.op4j.type.Type;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IterableSetOperator<T> 
        extends IterableOperator<Set<T>>, ShapeableAsGenericOperator<Set<T>> {
    
    public IterableSetOperator<?> raw();

    public GenericUniqTargetIteratingOperator<T> each();
    
    public IterableSetOperator<T> sort();
    public IterableSetOperator<T> sort(final Comparator<? super T> comparator);

    public GenericMultiTargetOperator<T> flat();
    
    public <X> IterableSetOperator<X> asSet(final Class<X> ofClass);

    public IterableSetOperator<T> eachFilter(final String expression, final Object... optionalExpParams);
    public IterableSetOperator<T> eachFilter(final Filter<T> filter);

    public IterableSetOperator<?> eachEval(
            final String expression, final Object... optionalExpParams);
    public <X> IterableSetOperator<X> eachEval(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams);
    public IterableSetOperator<?> eachEval(
            final Evaluator<T,Object> evaluator);
    public <X> IterableSetOperator<X> eachEval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator);
    
    public IterableSetOperator<?> eachCall(final String methodName, final Object... parameters);
    public <X> IterableSetOperator<X> eachCall(final Class<X> returnClass, final String methodName, final Object... parameters);

    public IterableSetOperator<?> eachExec(
            final String operationName, final Object... parameters);
    public <X> IterableSetOperator<X> eachExec(
            final Class<X> resultClass, final String operationName, final Object... parameters);
    
    public IterableSetOperator<?> eachTo(
            final Type resultType, final Object... parameters);
    public IterableSetOperator<?> eachTo(
            final String resultTypeName, final Object... parameters);
    public <X> IterableSetOperator<X> eachTo(
            final Class<X> resultClass, final Object... parameters);
    
    public IterableArrayOperator<T> toArray();
    public IterableListOperator<T> toList();

    
    public IterableMapOperator<?,T> toMap(
            final String keyExpression, final Object... optionalExpParams);
    public <K> IterableMapOperator<K,T> toMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableMapOperator<?,?> toMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableMapOperator<K,V> toMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public IterableMapOperator<?,?> toMap(final MapBuilder<T,Object,Object> mapBuilder);
    public <K,V> IterableMapOperator<K,V> toMap(final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder);
    
    
    public IterableListMapOperator<?,T> toListMap(
            final String keyExpression, final Object... optionalExpParams);
    public <K> IterableListMapOperator<K,T> toListMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableListMapOperator<?,?> toListMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableListMapOperator<K,V> toListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public IterableListMapOperator<?,?> toListMap(final MapBuilder<T,Object,Object> mapBuilder);
    public <K,V> IterableListMapOperator<K,V> toListMap(final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder);
    
    
    public IterableSetMapOperator<?,T> toSetMap(
            final String keyExpression, final Object... optionalExpParams);
    public <K> IterableSetMapOperator<K,T> toSetMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableSetMapOperator<?,?> toSetMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableSetMapOperator<K,V> toSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public IterableSetMapOperator<?,?> toSetMap(final MapBuilder<T,Object,Object> mapBuilder);
    public <K,V> IterableSetMapOperator<K,V> toSetMap(final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder);
    
    
    public IterableArrayMapOperator<?,T> toArrayMap(
            final String keyExpression, final Object... optionalExpParams);
    public <K> IterableArrayMapOperator<K,T> toArrayMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableArrayMapOperator<?,?> toArrayMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableArrayMapOperator<K,V> toArrayMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public IterableArrayMapOperator<?,?> toArrayMap(final MapBuilder<T,Object,Object> mapBuilder);
    public <K,V> IterableArrayMapOperator<K,V> toArrayMap(final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder);

}

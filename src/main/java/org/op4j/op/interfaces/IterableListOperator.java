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
import java.util.List;

import org.op4j.type.Type;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IterableListOperator<T> 
        extends IterableOperator<List<T>>, ShapeableAsGenericOperator<List<T>> {

    
    public IterableListOperator<?> raw();

    public GenericUniqTargetIteratingOperator<T> each();
    
    public IterableListOperator<T> sort();
    public IterableListOperator<T> sort(final Comparator<? super T> comparator);

    public GenericMultiTargetOperator<T> flat();

    public IterableListOperator<T> distinct();
    
    public <X> IterableListOperator<X> asList(final Class<X> ofClass);

    public IterableListOperator<T> eachFilter(final String expression, final Object... optionalExpParams);
    public IterableListOperator<T> eachFilter(final Filter<T> filter);

    public IterableListOperator<?> eachEval(
            final String expression, final Object... optionalExpParams);
    public <X> IterableListOperator<X> eachEval(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams);
    public IterableListOperator<?> eachEval(
            final Evaluator<T,Object> evaluator);
    public <X> IterableListOperator<X> eachEval(
            final Class<X> resultClass, final Evaluator<T,X> evaluator);
    
    public IterableListOperator<?> eachCall(final String methodName, final Object... parameters);
    public <X> IterableListOperator<X> eachCall(final Class<X> returnClass, final String methodName, final Object... parameters);

    public IterableListOperator<?> eachExecUniq(
            final String operationName, final Object... parameters);
    public <X> IterableListOperator<X> eachExecUniq(
            final Class<X> resultClass, final String operationName, final Object... parameters);
    
    public IterableListOperator<?> eachTo(
            final Type resultType, final Object... parameters);
    public IterableListOperator<?> eachTo(
            final String resultTypeName, final Object... parameters);
    public <X> IterableListOperator<X> eachTo(
            final Class<X> resultClass, final Object... parameters);
    
    public IterableArrayOperator<T> toArray();
    public IterableSetOperator<T> toSet();

    
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

    
}

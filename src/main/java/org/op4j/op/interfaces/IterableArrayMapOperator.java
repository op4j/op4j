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
import java.util.Map;

import org.op4j.type.Type;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IterableArrayMapOperator<K,V> 
        extends IterableOperator<Map<K,V[]>> {

    
    public IterableArrayMapOperator<?,?> raw();
    
    public IterableArrayMapOperator<K,V> sortKeys();
    public IterableArrayMapOperator<K,V> sortKeys(final Comparator<? super K> comparator);
    
    public IterableArrayMapOperator<K,V> sortValueArrays();
    public IterableArrayMapOperator<K,V> sortValueArrays(final Comparator<? super V> comparator);
    
    public GenericUniqTargetIteratingOperator<V> eachValue();
    
    public GenericUniqTargetIteratingOperator<K> eachKey();
    
    public MapEntryIteratingOperator<K,V> eachEntry();

    public GenericUniqTargetIteratingOperator<V[]> eachArrayValue();
    
    public MapEntryIteratingOperator<K,V[]> eachArrayEntry();
    
    public <X,Y> IterableArrayMapOperator<X,Y> asArrayMap(final Class<X> keyClass, Class<Y> valueClass);

    public IterableArrayMapOperator<K,V> eachFilterEntry(final String expression, final Object... optionalExpParams);
    public IterableArrayMapOperator<K,V> eachFilterEntry(final Filter<Map.Entry<K,V>> filter);

    public IterableArrayMapOperator<K,?> eachValueEval(
            final String expression, final Object... optionalExpParams);
    public <X> IterableArrayMapOperator<K,X> eachValueEval(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams);
    public IterableArrayMapOperator<K,?> eachValueEval(
            final Evaluator<V,Object> evaluator);
    public <X> IterableArrayMapOperator<K,X> eachValueEval(
            final Class<X> resultClass, final Evaluator<V,X> evaluator);
    
    public IterableArrayMapOperator<K,?> eachValueCall(final String methodName, final Object... parameters);
    public <X> IterableArrayMapOperator<K,X> eachValueCall(final Class<X> returnClass, final String methodName, final Object... parameters);

    public IterableArrayMapOperator<K,V> distinct();

    public IterableSetOperator<K> keySet();
    
    public IterableListOperator<V[]> values();
    
    public IterableArrayOperator<V> valuesForKey(final K key);
    
    public IterableArrayOperator<V> valuesForAllKeys();
    
    public IterableMapOperator<K,?> mergeValues(final String expression, final Object... optionalExpParams);
    public <X> IterableMapOperator<K,X> mergeValues(Class<X> resultClass, final String expression, final Object... optionalExpParams);

    public IterableArrayMapOperator<K,?> eachValueExec(
            final String operationName, final Object... parameters);
    public <X> IterableArrayMapOperator<K,X> eachValueExec(
            final Class<X> resultClass, final String operationName, final Object... parameters);
    
    public IterableArrayMapOperator<K,?> eachValueTo(
            final Type resultType, final Object... parameters);
    public IterableArrayMapOperator<K,?> eachValueTo(
            final String resultTypeName, final Object... parameters);
    public <X> IterableArrayMapOperator<K,X> eachValueTo(
            final Class<X> resultClass, final Object... parameters);

    
}

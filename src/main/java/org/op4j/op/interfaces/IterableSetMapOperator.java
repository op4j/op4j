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
import java.util.Set;

import org.op4j.type.Type;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IterableSetMapOperator<K,V> 
        extends IterableOperator<Map<K,Set<V>>> {

    
    public IterableSetMapOperator<?,?> raw();
    
    public IterableSetMapOperator<K,V> sortKeys();
    public IterableSetMapOperator<K,V> sortKeys(final Comparator<? super K> comparator);
    
    public IterableSetMapOperator<K,V> sortValueSets();
    public IterableSetMapOperator<K,V> sortValueSets(final Comparator<? super V> comparator);
    
    public GenericUniqTargetIteratingOperator<V> eachValue();
    
    public GenericUniqTargetIteratingOperator<K> eachKey();
    
    public MapEntryIteratingOperator<K,V> eachEntry();

    public GenericUniqTargetIteratingOperator<Set<V>> eachSetValue();
    
    public MapEntryIteratingOperator<K,Set<V>> eachSetEntry();
    
    public <X,Y> IterableSetMapOperator<X,Y> asSetMap(final Class<X> keyClass, Class<Y> valueClass);

    public IterableSetMapOperator<K,V> eachFilterEntry(final String expression, final Object... optionalExpParams);
    public IterableSetMapOperator<K,V> eachFilterEntry(final Filter<Map.Entry<K,V>> filter);

    public IterableSetMapOperator<K,?> eachEvalValue(
            final String expression, final Object... optionalExpParams);
    public <X> IterableSetMapOperator<K,X> eachEvalValue(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams);
    public IterableSetMapOperator<K,?> eachEvalValue(
            final Evaluator<V,Object> evaluator);
    public <X> IterableSetMapOperator<K,X> eachEvalValue(
            final Class<X> resultClass, final Evaluator<V,X> evaluator);
    
    public IterableSetMapOperator<K,?> eachCallValue(final String methodName, final Object... parameters);
    public <X> IterableSetMapOperator<K,X> eachCallValue(final Class<X> returnClass, final String methodName, final Object... parameters);

    public IterableSetOperator<K> keySet();
    
    public IterableListOperator<Set<V>> values();
    
    public IterableSetOperator<V> valuesForKey(final K key);
    
    public IterableSetOperator<V> valuesForAllKeys();
    
    public IterableMapOperator<K,?> mergeValues(final String expression, final Object... optionalExpParams);
    public <X> IterableMapOperator<K,X> mergeValues(Class<X> resultClass, final String expression, final Object... optionalExpParams);

    public IterableSetMapOperator<K,?> eachExecUniqValue(
            final String operationName, final Object... parameters);
    public <X> IterableSetMapOperator<K,X> eachExecUniqValue(
            final Class<X> resultClass, final String operationName, final Object... parameters);
    
    public IterableSetMapOperator<K,?> eachToValue(
            final Type resultType, final Object... parameters);
    public IterableSetMapOperator<K,?> eachToValue(
            final String resultTypeName, final Object... parameters);
    public <X> IterableSetMapOperator<K,X> eachToValue(
            final Class<X> resultClass, final Object... parameters);

    
}

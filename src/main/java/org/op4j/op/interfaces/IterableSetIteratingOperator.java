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

import java.util.Set;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IterableSetIteratingOperator<T> 
        extends IterableSetOperator<T>, IteratingOperator<Set<T>> {
    
    public IterableListOperator<Set<T>> uneachList();
    
    public IterableSetOperator<Set<T>> uneachSet();
    
    public IterableArrayOperator<Set<T>> uneachArray();
    
    public IterableMapOperator<?,Set<T>> uneachMap(
            final String keyExpression, final Object... optionalExpParams);
    public <K> IterableMapOperator<K,Set<T>> uneachMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableMapOperator<?,?> uneachMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableMapOperator<K,V> uneachMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableMapOperator<K,V> uneachMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<Set<T>,K,V> mapBuilder);
    public IterableMapOperator<?,?> uneachMap(
            final MapBuilder<Set<T>,Object,Object> mapBuilder);
    
    public IterableListMapOperator<?,Set<T>> uneachListMap(
            final String keyExpression, final Object... optionalExpParams);
    public <K> IterableListMapOperator<K,Set<T>> uneachListMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableListMapOperator<?,?> uneachListMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableListMapOperator<K,V> uneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableListMapOperator<K,V> uneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<Set<T>,K,V> mapBuilder);
    public IterableListMapOperator<?,?> uneachListMap(
            final MapBuilder<Set<T>,Object,Object> mapBuilder);
    
    public IterableSetMapOperator<?,Set<T>> uneachSetMap(
            final String keyExpression, final Object... optionalExpParams);
    public <K> IterableSetMapOperator<K,Set<T>> uneachSetMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableSetMapOperator<?,?> uneachSetMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableSetMapOperator<K,V> uneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableSetMapOperator<K,V> uneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<Set<T>,K,V> mapBuilder);
    public IterableSetMapOperator<?,?> uneachSetMap(
            final MapBuilder<Set<T>,Object,Object> mapBuilder);
    
}

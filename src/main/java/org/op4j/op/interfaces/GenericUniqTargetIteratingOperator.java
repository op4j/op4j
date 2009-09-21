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




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface GenericUniqTargetIteratingOperator<T> 
        extends GenericUniqTargetOperator<T>, GenericIteratingOperator<T> {
    
    public IterableListOperator<T> uneachList();
    public <X> IterableListOperator<X> uneachList(Class<X> ofClass);
    
    public IterableSetOperator<T> uneachSet();
    public <X> IterableSetOperator<X> uneachSet(Class<X> ofClass);
    
    public IterableArrayOperator<T> uneachArray();
    public <X> IterableArrayOperator<X> uneachArray(Class<X> ofClass);
    
    public IterableMapOperator<?,T> uneachMap(
            final String keyExpression, final Object... optionalExpParams);
    public <K> IterableMapOperator<K,T> uneachMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableMapOperator<?,?> uneachMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableMapOperator<K,V> uneachMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableMapOperator<K,V> uneachMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder);
    public IterableMapOperator<?,?> uneachMap(final MapBuilder<T,Object,Object> mapBuilder);
    
    public IterableListMapOperator<?,T> uneachListMap(
            final String keyExpression, final Object... optionalExpParams);
    public <K> IterableListMapOperator<K,T> uneachListMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableListMapOperator<?,?> uneachListMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableListMapOperator<K,V> uneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableListMapOperator<K,V> uneachListMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder);
    public IterableListMapOperator<?,?> uneachListMap(final MapBuilder<T,Object,Object> mapBuilder);
    
    public IterableSetMapOperator<?,T> uneachSetMap(
            final String keyExpression, final Object... optionalExpParams);
    public <K> IterableSetMapOperator<K,T> uneachSetMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableSetMapOperator<?,?> uneachSetMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableSetMapOperator<K,V> uneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableSetMapOperator<K,V> uneachSetMap(
            final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder);
    public IterableSetMapOperator<?,?> uneachSetMap(final MapBuilder<T,Object,Object> mapBuilder);
    
}

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
public interface GenericShapeableAsIterableOperator<T>
        extends Operator<T> {
    
    
    public IterableListOperator<T> buildList();
    public <X> IterableListOperator<X> buildList(final Class<X> ofClass);
    
    
    public IterableSetOperator<T> buildSet();
    public <X> IterableSetOperator<X> buildSet(final Class<X> ofClass);
    
    
    public IterableArrayOperator<T> buildArray();
    public <X> IterableArrayOperator<X> buildArray(final Class<X> ofClass);
    
    
    public IterableMapOperator<?,T> buildMap(
            final String keyExpression, final Object... optionalExpParams);
    public <K> IterableMapOperator<K,T> buildMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableMapOperator<?,?> buildMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableMapOperator<K,V> buildMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public IterableMapOperator<?,?> buildMap(final MapBuilder<T,Object,Object> mapBuilder);
    public <K,V> IterableMapOperator<K,V> buildMap(final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder);
    
    
    public IterableListMapOperator<?,T> buildListMap(
            final String keyExpression, final Object... optionalExpParams);
    public <K> IterableListMapOperator<K,T> buildListMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableListMapOperator<?,?> buildListMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableListMapOperator<K,V> buildListMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public IterableListMapOperator<?,?> buildListMap(final MapBuilder<T,Object,Object> mapBuilder);
    public <K,V> IterableListMapOperator<K,V> buildListMap(final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder);
    
    
    public IterableSetMapOperator<?,T> buildSetMap(
            final String keyExpression, final Object... optionalExpParams);
    public <K> IterableSetMapOperator<K,T> buildSetMap(
            final Class<K> keyClass, final String keyExpression, final Object... optionalExpParams);
    public IterableSetMapOperator<?,?> buildSetMap(
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public <K,V> IterableSetMapOperator<K,V> buildSetMap(
            final Class<K> keyClass, final Class<V> valueClass, 
            final String keyExpression, final String valueExpression, final Object... optionalExpParams);
    public IterableSetMapOperator<?,?> buildSetMap(final MapBuilder<T,Object,Object> mapBuilder);
    public <K,V> IterableSetMapOperator<K,V> buildSetMap(final Class<K> keyClass, final Class<V> valueClass, final MapBuilder<T,K,V> mapBuilder);
    
}

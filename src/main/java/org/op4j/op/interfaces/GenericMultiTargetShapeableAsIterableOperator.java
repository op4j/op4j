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
public interface GenericMultiTargetShapeableAsIterableOperator<T>
        extends GenericMultiTargetOperator<T>, GenericShapeableAsIterableOperator<T> {

    
    // These methods are here instead of being in GenericShapeableAsIterableOperator
    // because they need at least two targets to be executed
    
    public IterableMapOperator<T,T> buildMap();
    public <K,V> IterableMapOperator<K,V> buildMap(final Class<K> keyClass, final Class<V> valueClass);
    
    public IterableListMapOperator<T,T> buildListMap();
    public <K,V> IterableListMapOperator<K,V> buildListMap(final Class<K> keyClass, final Class<V> valueClass);
    
    public IterableSetMapOperator<T,T> buildSetMap();
    public <K,V> IterableSetMapOperator<K,V> buildSetMap(final Class<K> keyClass, final Class<V> valueClass);
    
}

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

import java.util.Map;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface MapEntryIteratingOperator<K,V> 
        extends MapEntryOperator<K,V> {

    public MapEntryIteratingOperator<K,V> filter(final String expression, final Object... optionalExpParams);
    public MapEntryIteratingOperator<K,V> filter(final Filter<Map.Entry<K,V>> filter);
    
    public IterableMapOperator<K,V> uneachMap();
    
    public IterableListMapOperator<K,V> uneachListMap();

    public IterableSetMapOperator<K,V> uneachSetMap();
    
}

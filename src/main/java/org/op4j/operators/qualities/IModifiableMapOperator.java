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
package org.op4j.operators.qualities;

import java.util.Map;

import org.op4j.executables.ISelect;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IModifiableMapOperator<K,V> {
    
    public IModifiableMapOperator<K,V> put(final K newKey, final V newValue);
    public IModifiableMapOperator<K,V> put(final int position, final K newKey, final V newValue);
    public IModifiableMapOperator<K,V> putAll(final Map<K,V> map);
    public IModifiableMapOperator<K,V> putAll(final int position, final Map<K,V> map);
    public IModifiableMapOperator<K,V> remove(final K key);
    public IModifiableMapOperator<K,V> removeAllWithKeys(final K... keys);
    public IModifiableMapOperator<K,V> removeAll(final String expression, final Object... optionalExpParams);
    public IModifiableMapOperator<K,V> removeAll(final ISelect<Map.Entry<K,V>> selector);
    public IModifiableMapOperator<K,V> removeAllWithKeysNot(final K... keys);
    
}

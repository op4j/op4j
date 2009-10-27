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

import org.op4j.commands.ISelect;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IExtractableMapOperator<K,V> {
    
    public IOperator extract(final K key);
    public IOperator extractAll(final K... keys);
    public IOperator extractAll(final String expression, final Object... optionalExpParams);
    public IOperator extractAll(final ISelect<Map.Entry<K,V>> selector);
    public IOperator extractAllBut(final K... keys);
    public IOperator extractAllBut(final String expression, final Object... optionalExpParams);
    public IOperator extractAllBut(final ISelect<Map.Entry<K,V>> selector);
    
    public IOperator extractKeys();
    public IOperator extractValues();
    
}
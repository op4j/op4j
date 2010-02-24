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
package org.op4j.operators.op.intf.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.ExecutableMapEntrySelectedOperator;
import org.op4j.operators.qualities.NavigableMapEntryOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectedMapEntryOperator;
import org.op4j.operators.qualities.UniqOpOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1MapEntriesSelectedOperator<K,V,I>
		extends UniqOpOperator<Map<K,V>>,
		        NavigableMapEntryOperator,
                ExecutableMapEntrySelectedOperator<K,V>,
                ReplaceableOperator<Map.Entry<K,V>>,
                SelectedMapEntryOperator<K, V> {


    public Level1MapEntriesOperator<K,V,I> endIf();
    

    public Level2MapEntriesSelectedKeyOperator<K,V,I> onKey();
    public Level2MapEntriesSelectedValueOperator<K,V,I> onValue();
    
    public Level1MapEntriesSelectedOperator<K,V,I> replaceWith(final Map.Entry<K,V> replacement);

    public Level1MapEntriesSelectedOperator<K,V,I> execAsMapEntry(final IFunction<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> function);
    
    public Level1MapEntriesSelectedOperator<K,V,I> execIfNotNullAsMapEntry(final IFunction<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> function);
    
    }
/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
package org.op4j.operators.intf.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.ExecutableMapEntrySelectedOperator;
import org.op4j.operators.qualities.NavigableMapEntryOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectedMapEntryOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel1MapEntriesSelectedOperator<I,K,V>
		extends UniqOperator<Map<K,V>>,
		        NavigableMapEntryOperator,
                ExecutableMapEntrySelectedOperator<K,V>,
                ReplaceableOperator<Map.Entry<K,V>>,
                SelectedMapEntryOperator<K, V> {


    public ILevel1MapEntriesOperator<I,K,V> endIf();
    

    public ILevel2MapEntriesSelectedKeyOperator<I,K,V> onKey();
    public ILevel2MapEntriesSelectedValueOperator<I,K,V> onValue();
    
    public ILevel1MapEntriesSelectedOperator<I,K,V> replaceWith(final Map.Entry<K,V> replacement);

    public ILevel1MapEntriesSelectedOperator<I,K,V> execAsMapEntry(final IFunction<? super Map.Entry<K,V>,? extends Map.Entry<? extends K,? extends V>> function);
   
}

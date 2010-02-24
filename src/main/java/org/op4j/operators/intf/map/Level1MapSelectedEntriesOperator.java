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
package org.op4j.operators.intf.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.ExecutableMapEntrySelectedOperator;
import org.op4j.operators.qualities.NavigableMapEntryOperator;
import org.op4j.operators.qualities.NavigatingMapOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableMapEntryOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1MapSelectedEntriesOperator<I,K,V>
		extends UniqOperator<Map<K,V>>,
		        NavigableMapEntryOperator,
                NavigatingMapOperator<K,V>,
                ExecutableMapEntrySelectedOperator<K,V>,
                ReplaceableOperator<Map.Entry<K,V>>,
                SelectableMapEntryOperator<K, V> {


    public Level1MapSelectedEntriesSelectedOperator<I,K,V> ifIndex(final int... indexes);
    public Level1MapSelectedEntriesSelectedOperator<I,K,V> ifTrue(final IFunction<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1MapSelectedEntriesSelectedOperator<I,K,V> ifFalse(final IFunction<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1MapSelectedEntriesSelectedOperator<I,K,V> ifIndexNot(final int... indexes);
    public Level1MapSelectedEntriesSelectedOperator<I,K,V> ifKeyEquals(final K... keys);
    public Level1MapSelectedEntriesSelectedOperator<I,K,V> ifKeyNotEquals(final K... keys);
    

    public Level2MapSelectedEntriesKeyOperator<I,K,V> onKey();
    public Level2MapSelectedEntriesValueOperator<I,K,V> onValue();
    
    public Level0MapSelectedOperator<I,K,V> endFor();
    
    public Level1MapSelectedEntriesOperator<I,K,V> replaceWith(final Map.Entry<K,V> replacement);

    public Level1MapSelectedEntriesOperator<I,K,V> execAsMapEntry(final IFunction<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> function);
    
    public Level1MapSelectedEntriesOperator<I,K,V> execIfNotNullAsMapEntry(final IFunction<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> function);
    
    }

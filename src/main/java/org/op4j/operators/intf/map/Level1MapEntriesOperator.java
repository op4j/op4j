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
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.qualities.ExecutableMapEntryOperator;
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
public interface Level1MapEntriesOperator<K,V,I>
		extends UniqOperator<Map<K,V>>,
		        NavigableMapEntryOperator,
                NavigatingMapOperator<K,V>,
                ExecutableMapEntryOperator<K,V>,
                ReplaceableOperator<Map.Entry<K,V>>,
                SelectableMapEntryOperator<K, V> {


    public Level1MapEntriesSelectedOperator<K,V,I> ifIndex(final int... indexes);
    public Level1MapEntriesSelectedOperator<K,V,I> ifTrue(final IFunction<Boolean, ? super Map.Entry<K, V>> eval);
    public Level1MapEntriesSelectedOperator<K,V,I> ifFalse(final IFunction<Boolean, ? super Map.Entry<K, V>> eval);
    public Level1MapEntriesSelectedOperator<K,V,I> ifIndexNot(final int... indexes);
    public Level1MapEntriesSelectedOperator<K,V,I> ifKeyEquals(final K... keys);
    public Level1MapEntriesSelectedOperator<K,V,I> ifKeyNotEquals(final K... keys);
    

    public Level2MapEntriesKeyOperator<K,V,I> onKey();
    public Level2MapEntriesValueOperator<K,V,I> onValue();
    
    public Level0MapOperator<K,V,I> endFor();
    
    public <X,Y> Level1MapEntriesOperator<X,Y,I> execAsMapEntry(final IFunction<? extends Map.Entry<X,Y>, ? super Map.Entry<K,V>> function);
    
    public Level1MapEntriesOperator<K,V,I> replaceWith(final Map.Entry<K,V> replacement);


    public <X> Level1ListElementsOperator<X,I> exec(final IFunction<X, ? super Map.Entry<K,V>> function);
    
    }

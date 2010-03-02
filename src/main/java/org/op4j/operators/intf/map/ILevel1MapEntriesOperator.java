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
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
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
public interface ILevel1MapEntriesOperator<I,K,V>
		extends UniqOperator<Map<K,V>>,
		        NavigableMapEntryOperator,
                NavigatingMapOperator<K,V>,
                ExecutableMapEntryOperator<K,V>,
                ReplaceableOperator<Map.Entry<K,V>>,
                SelectableMapEntryOperator<K, V> {


    public ILevel1MapEntriesSelectedOperator<I,K,V> ifIndex(final int... indexes);
    public ILevel1MapEntriesSelectedOperator<I,K,V> ifTrue(final IFunction<? super Map.Entry<K, V>,Boolean> eval);
    public ILevel1MapEntriesSelectedOperator<I,K,V> ifFalse(final IFunction<? super Map.Entry<K, V>,Boolean> eval);
    public ILevel1MapEntriesSelectedOperator<I,K,V> ifIndexNot(final int... indexes);
    public ILevel1MapEntriesSelectedOperator<I,K,V> ifKeyEquals(final K... keys);
    public ILevel1MapEntriesSelectedOperator<I,K,V> ifKeyNotEquals(final K... keys);
    

    public ILevel2MapEntriesKeyOperator<I,K,V> onKey();
    public ILevel2MapEntriesValueOperator<I,K,V> onValue();
    
    public ILevel0MapOperator<I,K,V> endFor();
    
    public <X,Y> ILevel1MapEntriesOperator<I,X,Y> execAsMapEntry(final IFunction<? super Map.Entry<K,V>,? extends Map.Entry<X,Y>> function);
    
    public ILevel1MapEntriesOperator<I,K,V> replaceWith(final Map.Entry<K,V> replacement);


    public <X> ILevel1ListElementsOperator<I,X> exec(final IFunction<? super Map.Entry<K,V>,X> function);
    
    }

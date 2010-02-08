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
package org.op4j.operators.intf.mapofarray;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableMapOfArrayEntrySelectedOperator;
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
public interface Level1MapOfArraySelectedEntriesOperator<K,V>
		extends UniqOperator<Map<K,V[]>>,
		        NavigableMapEntryOperator,
		        NavigatingMapOperator<K,V[]>,
                ExecutableMapOfArrayEntrySelectedOperator<K,V>,
                ReplaceableOperator<Map.Entry<K,V[]>>,
                SelectableMapEntryOperator<K, V[]> {


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifIndex(final int... indexes);
    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Map.Entry<K,V[]>> eval);
    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Map.Entry<K,V[]>> eval);
    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys);
    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys);
    
    
    public Level2MapOfArraySelectedEntriesKeyOperator<K,V> onKey();
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> onValue();
    
    public Level0MapOfArraySelectedOperator<K,V> endFor();
    
    public Level1MapOfArraySelectedEntriesOperator<K,V> replaceWith(final Map.Entry<K,V[]> replacement);

    public Level1MapOfArraySelectedEntriesOperator<K,V> execAsMapOfArrayEntry(final IFunction<? extends Map.Entry<? extends K,? extends V[]>, ? super Map.Entry<K,V[]>> function);
    
    public Level1MapOfArraySelectedEntriesOperator<K,V> evalAsMapOfArrayEntry(final IEvaluator<? extends Map.Entry<? extends K,? extends V[]>, ? super Map.Entry<K,V[]>> eval);
    
    public Level1MapOfArraySelectedEntriesOperator<K,V> convertAsMapOfArrayEntry(final IConverter<? extends Map.Entry<? extends K,? extends V[]>, ? super Map.Entry<K,V[]>> converter);
                                    
}

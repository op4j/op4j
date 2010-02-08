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
package org.op4j.operators.intf.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableMapOfSetEntrySelectedOperator;
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
public interface Level1MapOfSetSelectedEntriesOperator<K,V>
		extends UniqOperator<Map<K,Set<V>>>,
		        NavigableMapEntryOperator,
		        NavigatingMapOperator<K,Set<V>>,
                ExecutableMapOfSetEntrySelectedOperator<K,V>,
                ReplaceableOperator<Map.Entry<K,Set<V>>>,
                SelectableMapEntryOperator<K, Set<V>> {


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indexes);
    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Map.Entry<K,Set<V>>> eval);
    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Map.Entry<K,Set<V>>> eval);
    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys);
    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys);
    
    
    public Level2MapOfSetSelectedEntriesKeyOperator<K,V> onKey();
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> onValue();
    
    public Level0MapOfSetSelectedOperator<K,V> endFor();
    
    public Level1MapOfSetSelectedEntriesOperator<K,V> replaceWith(final Map.Entry<K,Set<V>> replacement);

    public Level1MapOfSetSelectedEntriesOperator<K,V> exec(final IFunction<? extends Map.Entry<? extends K,? extends Set<? extends V>>, ? super Map.Entry<K,Set<V>>> function);
    
    public Level1MapOfSetSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Map.Entry<? extends K,? extends Set<? extends V>>, ? super Map.Entry<K,Set<V>>> eval);
    
    public Level1MapOfSetSelectedEntriesOperator<K,V> convert(final IConverter<? extends Map.Entry<? extends K,? extends Set<? extends V>>, ? super Map.Entry<K,Set<V>>> converter);
                                    
}

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
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableMapEntrySelectedOperator;
import org.op4j.operators.qualities.NavigableMapEntryOperator;
import org.op4j.operators.qualities.NavigatingMapOperator;
import org.op4j.operators.qualities.SelectableMapEntryOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1MapSelectedEntriesOperator<K,V>
		extends UniqOperator<Map<K,V>>,
		        NavigableMapEntryOperator,
                NavigatingMapOperator<K,V>,
                ExecutableMapEntrySelectedOperator<K,V>,
                SelectableMapEntryOperator<K, V> {


    public Level1MapSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices);
    public Level1MapSelectedEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1MapSelectedEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1MapSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level1MapSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys);
    public Level1MapSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys);
    

    public Level2MapSelectedEntriesKeyOperator<K,V> onKey();
    public Level2MapSelectedEntriesValueOperator<K,V> onValue();
    
    public Level0MapSelectedOperator<K,V> endFor();
    
    public Level1MapSelectedEntriesOperator<K,V> exec(final IFunction<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> function);
    
    public Level1MapSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> eval);
    
    public Level1MapSelectedEntriesOperator<K,V> convert(final IConverter<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> converter);

    
}

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
public interface Level1MapOfSetEntriesSelectedOperator<K,V>
		extends UniqOperator<Map<K,Set<V>>>,
		        NavigableMapEntryOperator,
                ExecutableMapOfSetEntrySelectedOperator<K,V>,
                ReplaceableOperator<Map.Entry<K,Set<V>>>,
                SelectedMapEntryOperator<K, Set<V>> {


    public Level1MapOfSetEntriesOperator<K,V> endIf();
    
    
    public Level2MapOfSetEntriesSelectedKeyOperator<K,V> onKey();
    public Level2MapOfSetEntriesSelectedValueOperator<K,V> onValue();
    
    public Level1MapOfSetEntriesSelectedOperator<K,V> replaceWith(final Map.Entry<K,Set<V>> replacement);

    public Level1MapOfSetEntriesSelectedOperator<K,V> exec(final IFunction<? extends Map.Entry<? extends K,? extends Set<? extends V>>, ? super Map.Entry<K,Set<V>>> function);
    
    public Level1MapOfSetEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Map.Entry<? extends K,? extends Set<? extends V>>, ? super Map.Entry<K,Set<V>>> eval);
    
    public Level1MapOfSetEntriesSelectedOperator<K,V> convert(final IConverter<? extends Map.Entry<? extends K,? extends Set<? extends V>>, ? super Map.Entry<K,Set<V>>> converter);
                                    
}

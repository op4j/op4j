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
package org.op4j.operators.intf.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableMapOfListEntrySelectedOperator;
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
public interface Level1MapOfListSelectedEntriesOperator<K,V>
		extends UniqOperator<Map<K,List<V>>>,
		        NavigableMapEntryOperator,
		        NavigatingMapOperator<K,List<V>>,
                ExecutableMapOfListEntrySelectedOperator<K,V>,
                ReplaceableOperator<Map.Entry<K,List<V>>>,
                SelectableMapEntryOperator<K, List<V>> {


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Map.Entry<K,List<V>>> eval);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Map.Entry<K,List<V>>> eval);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys);
    
    
    public Level2MapOfListSelectedEntriesKeyOperator<K,V> onKey();
    public Level2MapOfListSelectedEntriesValueOperator<K,V> onValue();
    
    public Level0MapOfListSelectedOperator<K,V> endFor();
    
    public Level1MapOfListSelectedEntriesOperator<K,V> replaceBy(final Map.Entry<K,List<V>> replacement);

    public Level1MapOfListSelectedEntriesOperator<K,V> exec(final IFunction<? extends Map.Entry<? extends K,? extends List<? extends V>>, ? super Map.Entry<K,List<V>>> function);
    
    public Level1MapOfListSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Map.Entry<? extends K,? extends List<? extends V>>, ? super Map.Entry<K,List<V>>> eval);
    
    public Level1MapOfListSelectedEntriesOperator<K,V> convert(final IConverter<? extends Map.Entry<? extends K,? extends List<? extends V>>, ? super Map.Entry<K,List<V>>> converter);
                                    
}

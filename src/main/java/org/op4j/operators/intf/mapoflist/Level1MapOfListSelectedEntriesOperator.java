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

import java.util.Map;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ConvertibleSelectedOperator;
import org.op4j.operators.qualities.EvaluableSelectedOperator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
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
public interface Level1MapOfListSelectedEntriesOperator<K,V>
		extends UniqOperator<Map<K,List<V>>>,
		        NavigableMapEntryOperator,
		        NavigatingMapOperator<K,List<V>>,
                ExecutableSelectedOperator<Map.Entry<K,List<V>>>,
                EvaluableSelectedOperator<Map.Entry<K,List<V>>>,
                SelectableMapEntryOperator<K, List<V>>,
                ConvertibleSelectedOperator<Map.Entry<K,List<V>>> {


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Map.Entry<K,List<V>>> eval);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K,List<V>>> eval);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys);
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys);
    
    
    public Level2MapOfListSelectedEntriesKeyOperator<K,V> onKey();
    public Level2MapOfListSelectedEntriesValueOperator<K,V> onValue();
    
    public Level0MapOfListSelectedOperator<K,V> endFor();
    
    public Level1MapOfListSelectedEntriesOperator<K,V> exec(final IFunction<? extends Map.Entry<K,List<V>>, ? super Map.Entry<K,List<V>>> function);
    
    public Level1MapOfListSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Map.Entry<K,List<V>>, ? super Map.Entry<K,List<V>>> eval);
    
    public Level1MapOfListSelectedEntriesOperator<K,V> convert(final IConverter<? extends Map.Entry<K,List<V>>, ? super Map.Entry<K,List<V>>> converter);
                                    
}

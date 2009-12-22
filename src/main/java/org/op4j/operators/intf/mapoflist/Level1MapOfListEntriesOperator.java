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
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.qualities.ConvertibleOperator;
import org.op4j.operators.qualities.EvaluableOperator;
import org.op4j.operators.qualities.ExecutableOperator;
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
public interface Level1MapOfListEntriesOperator<K,V>
		extends UniqOperator<Map<K,List<V>>>,
		        NavigableMapEntryOperator,
                ExecutableOperator<Map.Entry<K,List<V>>>,
                EvaluableOperator<Map.Entry<K,List<V>>>,
                ConvertibleOperator<Map.Entry<K,List<V>>>,
                SelectableMapEntryOperator<K, List<V>>,
		        NavigatingMapOperator<K,List<V>> {


    public Level1MapOfListEntriesSelectedOperator<K,V> ifIndex(final int... indices);
    public Level1MapOfListEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Map.Entry<K, List<V>>> eval);
    public Level1MapOfListEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K, List<V>>> eval);
    public Level1MapOfListEntriesSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level1MapOfListEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys);
    public Level1MapOfListEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys);
    
    
    public Level2MapOfListEntriesKeyOperator<K,V> onKey();
    public Level2MapOfListEntriesValueOperator<K,V> onValue();
    
    public Level0MapOfListOperator<K,V> endFor();
    
    public <X> Level1ListElementsOperator<X> exec(final IFunction<X, ? super Map.Entry<K,List<V>>> function);
    
    public <X> Level1ListElementsOperator<X> eval(final IEvaluator<X,? super Map.Entry<K,List<V>>> eval);
    
    public <X> Level1ListElementsOperator<X> convert(final IConverter<X,? super Map.Entry<K,List<V>>> converter);
                                    
}

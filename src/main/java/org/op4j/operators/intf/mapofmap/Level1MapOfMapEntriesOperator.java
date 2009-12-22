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
package org.op4j.operators.intf.mapofmap;

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
public interface Level1MapOfMapEntriesOperator<K1,K2,V>
		extends UniqOperator<Map<K1,Map<K2,V>>>,
		        NavigableMapEntryOperator,
                ExecutableOperator<Map.Entry<K1,Map<K2,V>>>,
                EvaluableOperator<Map.Entry<K1,Map<K2,V>>>,
                ConvertibleOperator<Map.Entry<K1,Map<K2,V>>>,
                SelectableMapEntryOperator<K1, Map<K2,V>>,
		        NavigatingMapOperator<K1,Map<K2,V>> {


    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V> ifIndex(final int... indices);
    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super Map.Entry<K1, Map<K2, V>>> eval);
    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K1, Map<K2, V>>> eval);
    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V> ifIndexNot(final int... indices);
    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V> ifKeyEquals(final K1... keys);
    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V> ifKeyNotEquals(final K1... keys);
    
    
    public Level2MapOfMapEntriesKeyOperator<K1,K2,V> onKey();
    public Level2MapOfMapEntriesValueOperator<K1,K2,V> onValue();
    
    public Level0MapOfMapOperator<K1,K2,V> endFor();
        
    public <X> Level1ListElementsOperator<X> exec(final IFunction<X, ? super Map.Entry<K1,Map<K2,V>>> function);
    
    public <X> Level1ListElementsOperator<X> eval(final IEvaluator<X,? super Map.Entry<K1,Map<K2,V>>> eval);
    
    public <X> Level1ListElementsOperator<X> convert(final IConverter<X,? super Map.Entry<K1,Map<K2,V>>> converter);
                                    
}

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
import org.op4j.operators.qualities.ExecutableMapOfMapEntrySelectedOperator;
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
public interface Level1MapOfMapSelectedEntriesOperator<K1,K2,V>
		extends UniqOperator<Map<K1,Map<K2,V>>>,
		        NavigableMapEntryOperator,
                ExecutableMapOfMapEntrySelectedOperator<K1,K2,V>,
                SelectableMapEntryOperator<K1, Map<K2,V>>,
		        NavigatingMapOperator<K1,Map<K2,V>> {


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifIndex(final int... indices);
    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifTrue(final IEvaluator<Boolean, ? super Map.Entry<K1, Map<K2, V>>> eval);
    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifFalse(final IEvaluator<Boolean, ? super Map.Entry<K1, Map<K2, V>>> eval);
    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifIndexNot(final int... indices);
    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifKeyEquals(final K1... keys);
    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifKeyNotEquals(final K1... keys);
    
    
    public Level2MapOfMapSelectedEntriesKeyOperator<K1,K2,V> onKey();
    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> onValue();
    
    public Level0MapOfMapSelectedOperator<K1,K2,V> endFor();
        
    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V> exec(final IFunction<? extends Map.Entry<? extends K1,? extends Map<? extends K2,? extends V>>, ? super Map.Entry<K1,Map<K2,V>>> function);
    
    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V> eval(final IEvaluator<? extends Map.Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map.Entry<K1,Map<K2,V>>> eval);
    
    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V> convert(final IConverter<? extends Map.Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map.Entry<K1,Map<K2,V>>> converter);
                                    
}

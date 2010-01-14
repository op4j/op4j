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
import org.op4j.operators.qualities.ExecutableMapOfArrayEntryOperator;
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
public interface Level1MapOfArrayEntriesOperator<K,V>
		extends UniqOperator<Map<K,V[]>>,
		        NavigableMapEntryOperator,
		        NavigatingMapOperator<K,V[]>,
                ExecutableMapOfArrayEntryOperator<K,V>,
                SelectableMapEntryOperator<K, V[]> {


    public Level1MapOfArrayEntriesSelectedOperator<K,V> ifIndex(final int... indices);
    public Level1MapOfArrayEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Map.Entry<K, V[]>> eval);
    public Level1MapOfArrayEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K, V[]>> eval);
    public Level1MapOfArrayEntriesSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level1MapOfArrayEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys);
    public Level1MapOfArrayEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys);
    
    
    public Level2MapOfArrayEntriesKeyOperator<K,V> onKey();
    public Level2MapOfArrayEntriesValueOperator<K,V> onValue();
    
    public Level0MapOfArrayOperator<K,V> endFor();
    
    public <X,Y> Level1MapOfArrayEntriesOperator<X,Y> exec(final IFunction<? extends Map.Entry<X,Y[]>, ? super Map.Entry<K,V[]>> function);
    
    public <X,Y> Level1MapOfArrayEntriesOperator<X,Y> eval(final IEvaluator<? extends Map.Entry<X,Y[]>,? super Map.Entry<K,V[]>> eval);
    
    public <X,Y> Level1MapOfArrayEntriesOperator<X,Y> convert(final IConverter<? extends Map.Entry<X,Y[]>,? super Map.Entry<K,V[]>> converter);
                                    
}

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
package org.op4j.operators.intf.arrayofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsElementsOperator;
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
public interface Level2ArrayOfMapElementsEntriesOperator<K,V> 
		extends UniqOperator<Map<K,V>[]>,
		        NavigableMapEntryOperator,
                ExecutableOperator<Map.Entry<K,V>>,
                EvaluableOperator<Map.Entry<K,V>>,
                ConvertibleOperator<Map.Entry<K,V>>,
                SelectableMapEntryOperator<K, V>,
                NavigatingMapOperator<K,V> {


    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> ifIndex(final int... indices);
    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Map.Entry<K, V>> eval);
    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K, V>> eval);
    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys);
    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys);
		    
    
    public Level3ArrayOfMapElementsEntriesKeyOperator<K,V> onKey();
    public Level3ArrayOfMapElementsEntriesValueOperator<K,V> onValue();
    
    public Level1ArrayOfMapElementsOperator<K,V> endFor();
    
    public <X> Level2ArrayOfListElementsElementsOperator<X> exec(final IFunction<X, ? super Map.Entry<K,V>> function);
    
    public <X> Level2ArrayOfListElementsElementsOperator<X> eval(final IEvaluator<X,? super Map.Entry<K,V>> eval);
    
    public <X> Level2ArrayOfListElementsElementsOperator<X> convert(final IConverter<X,? super Map.Entry<K,V>> converter);
                                    
}

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
import org.op4j.operators.qualities.ExecutableMapEntrySelectedOperator;
import org.op4j.operators.qualities.NavigableMapEntryOperator;
import org.op4j.operators.qualities.NavigatingMapOperator;
import org.op4j.operators.qualities.SelectableMapEntryOperator;
import org.op4j.operators.qualities.UniqOperator;
import org.op4j.operators.qualities.ReplaceableOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2ArrayOfMapElementsSelectedEntriesOperator<K,V,I> 
		extends UniqOperator<Map<K,V>[],I>,
		        NavigableMapEntryOperator<I>,
                ExecutableMapEntrySelectedOperator<K,V,I>,
                ReplaceableOperator<Map.Entry<K,V>,I>,
                SelectableMapEntryOperator<K, V,I>,
                NavigatingMapOperator<K,V,I> {


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Map.Entry<K, V>> eval);
    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Map.Entry<K, V>> eval);
    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V,I> ifKeyEquals(final K... keys);
    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V,I> ifKeyNotEquals(final K... keys);
		    
    
    public Level3ArrayOfMapElementsSelectedEntriesKeyOperator<K,V,I> onKey();
    public Level3ArrayOfMapElementsSelectedEntriesValueOperator<K,V,I> onValue();
    
    public Level1ArrayOfMapElementsSelectedOperator<K,V,I> endFor();
    
    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V,I> replaceWith(final Map.Entry<K,V> replacement);

    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V,I> exec(final IFunction<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> function);
    
    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V,I> eval(final IEvaluator<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> eval);
    
    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V,I> convert(final IConverter<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> converter);
                                    
}

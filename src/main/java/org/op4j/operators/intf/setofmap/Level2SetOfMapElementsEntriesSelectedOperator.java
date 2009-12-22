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
package org.op4j.operators.intf.setofmap;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ConvertibleSelectedOperator;
import org.op4j.operators.qualities.EvaluableSelectedOperator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.NavigableMapEntryOperator;
import org.op4j.operators.qualities.SelectedMapEntryOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2SetOfMapElementsEntriesSelectedOperator<K,V> 
		extends UniqOperator<Set<Map<K,V>>>,
		        NavigableMapEntryOperator,
                ExecutableSelectedOperator<Map.Entry<K,V>>,
                EvaluableSelectedOperator<Map.Entry<K,V>>,
                ConvertibleSelectedOperator<Map.Entry<K,V>>,
                SelectedMapEntryOperator<K, V> {


    public Level2SetOfMapElementsEntriesOperator<K,V> endIf();
		    
    
    public Level3SetOfMapElementsEntriesSelectedKeyOperator<K,V> onKey();
    public Level3SetOfMapElementsEntriesSelectedValueOperator<K,V> onValue();
    
    public Level2SetOfMapElementsEntriesSelectedOperator<K,V> exec(final IFunction<? extends Map.Entry<K,V>, ? super Map.Entry<K,V>> function);
    
    public Level2SetOfMapElementsEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Map.Entry<K,V>, ? super Map.Entry<K,V>> eval);
    
    public Level2SetOfMapElementsEntriesSelectedOperator<K,V> convert(final IConverter<? extends Map.Entry<K,V>, ? super Map.Entry<K,V>> converter);
                                    
}

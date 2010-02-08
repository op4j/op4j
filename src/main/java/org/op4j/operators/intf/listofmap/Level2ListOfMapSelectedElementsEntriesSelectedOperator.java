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
package org.op4j.operators.intf.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableMapEntrySelectedOperator;
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
public interface Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> 
		extends UniqOperator<List<Map<K,V>>>,
		        NavigableMapEntryOperator,
                ExecutableMapEntrySelectedOperator<K,V>,
                ReplaceableOperator<Map.Entry<K,V>>,
                SelectedMapEntryOperator<K, V> {


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> endIf();
    	    
    
    public Level3ListOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> onKey();
    public Level3ListOfMapSelectedElementsEntriesSelectedValueOperator<K,V> onValue();
    
    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> replaceWith(final Map.Entry<K,V> replacement);

    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> execAsMapEntry(final IFunction<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> function);
    
    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> evalAsMapEntry(final IEvaluator<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> eval);
    
    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> convertAsMapEntry(final IConverter<? extends Map.Entry<? extends K,? extends V>, ? super Map.Entry<K,V>> converter);
                                    
}

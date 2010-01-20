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
public interface Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V>
		extends UniqOperator<Map<K1,Map<K2,V>>>,
		        NavigableMapEntryOperator,
                ExecutableMapEntrySelectedOperator<K2,V>,
                ReplaceableOperator<Map.Entry<K2,V>>,
                SelectedMapEntryOperator<K2, V> {


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator<K1,K2,V> endIf();
    
    
    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeyOperator<K1,K2,V> onKey();
    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedValueOperator<K1,K2,V> onValue();
    
    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> replaceWith(final Map.Entry<K2,V> replacement);


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> exec(final IFunction<? extends Map.Entry<? extends K2,? extends V>, ? super Map.Entry<K2,V>> function);
    
    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends Map.Entry<? extends K2,? extends V>,? super Map.Entry<K2,V>> eval);
    
    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> convert(final IConverter<? extends Map.Entry<? extends K2,? extends V>,? super Map.Entry<K2,V>> converter);
                                            
}

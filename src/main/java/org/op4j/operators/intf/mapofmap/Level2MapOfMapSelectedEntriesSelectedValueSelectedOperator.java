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

import java.util.Comparator;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ConvertibleSelectedOperator;
import org.op4j.operators.qualities.EvaluableSelectedOperator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.ModifiableMapOperator;
import org.op4j.operators.qualities.NavigableMapOperator;
import org.op4j.operators.qualities.SelectedOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V>
        extends UniqOperator<Map<K1,Map<K2,V>>>,
                NavigableMapOperator<K2,V>,
		        SortableOperator<Map.Entry<K2,V>>,
                ExecutableSelectedOperator<Map<K2,V>>,
                ConvertibleSelectedOperator<Map<K2,V>>,
                EvaluableSelectedOperator<Map<K2,V>>,
                ModifiableMapOperator<K2,V>,
                SelectedOperator<Map<K2,V>> {



    public Level2MapOfMapSelectedEntriesSelectedValueOperator<K1,K2,V> endIf();

    
    public Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesOperator<K1,K2,V> forEachEntry();
    
    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> sort();
    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> sort(final Comparator<? super Map.Entry<K2,V>> comparator);
    
    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> put(final K2 newKey, final V newValue);
    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> insert(final int position, final K2 newKey, final V newValue);
    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> putAll(final Map<K2,V> map);
    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> insertAll(final int position, final Map<K2,V> map);
    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> removeKeys(final K2... keys);
    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K2,V>> eval);
    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> removeNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K2,V>> eval);
    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> removeKeysNot(final K2... keys);
    
    
    
    
    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> convert(final IConverter<? extends Map<K2,V>,? super Map<K2,V>> converter);
    
    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends Map<K2,V>,? super Map<K2,V>> eval);

    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> exec(final IFunction<? extends Map<K2,V>, ? super Map<K2,V>> function);
    
    
}
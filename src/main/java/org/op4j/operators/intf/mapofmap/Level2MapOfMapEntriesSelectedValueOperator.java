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
import org.op4j.operators.qualities.ExecutableMapSelectedOperator;
import org.op4j.operators.qualities.ModifiableMapOperator;
import org.op4j.operators.qualities.NavigableMapOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V>
        extends UniqOperator<Map<K1,Map<K2,V>>>,
                NavigableMapOperator<K2,V>,
		        NavigatingMapEntryOperator,
		        SortableOperator<Map.Entry<K2,V>>,
                ExecutableMapSelectedOperator<K2,V>,
                ModifiableMapOperator<K2,V>,
                SelectableOperator<Map<K2,V>> {



    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifIndex(final int... indices);
    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifNull();
    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifNullOrMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifIndexNot(final int... indices);
    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNull();
    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNullMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval);

    
    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V> forEachEntry();
    
    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V> endOn();
    
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> sort();
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> sort(final Comparator<? super Map.Entry<K2,V>> comparator);
    
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> put(final K2 newKey, final V newValue);
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> insert(final int position, final K2 newKey, final V newValue);
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> putAll(final Map<K2,V> map);
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> insertAll(final int position, final Map<K2,V> map);
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> removeKeys(final K2... keys);
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K2,V>> eval);
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> removeNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K2,V>> eval);
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> removeKeysNot(final K2... keys);
    
    
    
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> convert(final IConverter<? extends Map<? extends K2,? extends V>,? super Map<K2,V>> converter);
    
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> eval(final IEvaluator<? extends Map<? extends K2,? extends V>,? super Map<K2,V>> eval);

    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> exec(final IFunction<? extends Map<? extends K2,? extends V>, ? super Map<K2,V>> function);
    
    
    
}

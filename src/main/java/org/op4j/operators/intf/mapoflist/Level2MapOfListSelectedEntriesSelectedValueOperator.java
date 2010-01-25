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
package org.op4j.operators.intf.mapoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
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
public interface Level2MapOfListSelectedEntriesSelectedValueOperator<K,V>
        extends UniqOperator<Map<K,List<V>>>,
                NavigableCollectionOperator<V>,
	        	NavigatingMapEntryOperator,
		        DistinguishableOperator,
		        SortableOperator<V>,
                ExecutableListSelectedOperator<V>,
                ReplaceableOperator<List<V>>,
                ModifiableCollectionOperator<V>,
                SelectableOperator<List<V>> {



    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices);
    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super List<V>> eval);
    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super List<V>> eval);
    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super List<V>> eval);
    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<V>> eval);
    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifNull();
    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super List<V>> eval);
    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNull();
    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<V>> eval);

    
    public Level3MapOfListSelectedEntriesSelectedValueElementsOperator<K,V> forEach();
    
    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> endOn();

    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> distinct();
    
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> sort();
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> add(final V newElement);
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> addAll(final V... newElements);
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> insert(final int position, final V newElement);
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> insertAll(final int position, final V... newElements);
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeAllIndexes(final int... indices);
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeAllEqual(final V... values);
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeAllTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeAllFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeAllIndexesNot(final int... indices);
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeAllNull();

    
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends List<? extends V>, ? super List<V>> converter);
    
    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends List<? extends V>, ? super List<V>> eval);

    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> replaceWith(final List<V> replacement);

    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends List<? extends V>, ? super List<V>> function);
    
    
    
}

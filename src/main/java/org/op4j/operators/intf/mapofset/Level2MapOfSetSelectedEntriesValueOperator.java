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
package org.op4j.operators.intf.mapofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSetSelectedOperator;
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
public interface Level2MapOfSetSelectedEntriesValueOperator<K,V>
        extends UniqOperator<Map<K,Set<V>>>,
                NavigableCollectionOperator<V>,
	        	NavigatingMapEntryOperator,
		        SortableOperator<V>,
                ExecutableSetSelectedOperator<V>,
                ReplaceableOperator<Set<V>>,
                ModifiableCollectionOperator<V>,
                SelectableOperator<Set<V>> {



    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifIndex(final int... indices);
    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNull();
    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNotNull();
    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<V>> eval);

    
    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V> forEach();
    
    public Level1MapOfSetSelectedEntriesOperator<K,V> endOn();

    public Level2MapOfSetSelectedEntriesValueOperator<K,V> sort();
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> add(final V newElement);
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> addAll(final V... newElements);
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> insert(final int position, final V newElement);
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> insertAll(final int position, final V... newElements);
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllIndexes(final int... indices);
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllEqual(final V... values);
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllIndexesNot(final int... indices);
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllNull();

    
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> convert(final IConverter<? extends Set<? extends V>, ? super Set<V>> converter);
    
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> eval(final IEvaluator<? extends Set<? extends V>, ? super Set<V>> eval);

    public Level2MapOfSetSelectedEntriesValueOperator<K,V> replaceWith(final Set<V> replacement);

    public Level2MapOfSetSelectedEntriesValueOperator<K,V> exec(final IFunction<? extends Set<? extends V>, ? super Set<V>> function);
    
    
    
}

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
public interface Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V>
        extends UniqOperator<Map<K,Set<V>>>,
                NavigableCollectionOperator<V>,
	        	NavigatingMapEntryOperator,
		        SortableOperator<V>,
                ExecutableSetSelectedOperator<V>,
                ReplaceableOperator<Set<V>>,
                ModifiableCollectionOperator<V>,
                SelectableOperator<Set<V>> {



    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indexes);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> ifNull();
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNull();
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super Set<V>> eval);

    
    public Level3MapOfSetSelectedEntriesSelectedValueElementsOperator<K,V> forEach();
    
    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> endOn();

    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> sort();
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> add(final V newElement);
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> addAll(final V... newElements);
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> insert(final int position, final V newElement);
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> insertAll(final int position, final V... newElements);
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> removeAllIndexes(final int... indexes);
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> removeAllEqual(final V... values);
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> removeAllTrue(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> removeAllFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> removeAllNullOrFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> removeAllNotNullAndFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> removeAllNotNullAndTrue(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> removeAllNullOrTrue(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> removeAllIndexesNot(final int... indexes);
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> removeAllNull();

    
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> execIfNotNullAsSet(final IFunction<? extends Set<? extends V>, ? super Set<V>> function);

    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> replaceWith(final Set<V> replacement);

    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> execAsSet(final IFunction<? extends Set<? extends V>, ? super Set<V>> function);
    
    
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> map(final IFunction<? extends V, ? super V> function);
    
    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> mapIfNotNull(final IFunction<? extends V, ? super V> function);
    
}

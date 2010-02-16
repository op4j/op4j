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
package org.op4j.operators.intf.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArraySelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
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
public interface Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V>
        extends UniqOperator<Map<K,V[]>>,
                NavigableCollectionOperator<V>,
		        DistinguishableOperator,
		        SortableOperator<V>,
                ExecutableArraySelectedOperator<V>,
                ReplaceableOperator<V[]>,
                ModifiableCollectionOperator<V>,
                SelectedOperator<V[]> {



    public Level2MapOfArraySelectedEntriesValueOperator<K,V> endIf();

    
    public Level3MapOfArraySelectedEntriesValueSelectedElementsOperator<K,V> forEach();

    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> distinct();
    
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> sort();
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> add(final V newElement);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> addAll(final V... newElements);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> insert(final int position, final V newElement);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> insertAll(final int position, final V... newElements);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllIndexes(final int... indexes);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllEqual(final V... values);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllTrue(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllNullOrFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllNotNullAndFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllNotNullAndTrue(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllNullOrTrue(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllIndexesNot(final int... indexes);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllNull();

    
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> execIfNotNullAsArray(final IFunction<? extends V[], ? super V[]> function);

    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> replaceWith(final V[] replacement);

    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> execAsArray(final IFunction<? extends V[], ? super V[]> function);
    
    
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> map(final IFunction<? extends V, ? super V> function);
    
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> mapIfNotNull(final IFunction<? extends V, ? super V> function);
    
    
}

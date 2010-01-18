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
public interface Level2MapOfSetEntriesValueSelectedOperator<K,V>
        extends UniqOperator<Map<K,Set<V>>>,
                NavigableCollectionOperator<V>,
		        SortableOperator<V>,
                ExecutableSetSelectedOperator<V>,
                ModifiableCollectionOperator<V>,
                SelectedOperator<Set<V>> {



    public Level2MapOfSetEntriesValueOperator<K,V> endIf();

    
    public Level3MapOfSetEntriesValueSelectedElementsOperator<K,V> forEach();

    public Level2MapOfSetEntriesValueSelectedOperator<K,V> sort();
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> add(final V... newElements);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> insert(final int position, final V... newElements);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllIndexes(final int... indices);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllEqual(final V... values);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllIndexesNot(final int... indices);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllNull();

    
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends Set<? extends V>, ? super Set<V>> converter);
    
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends Set<? extends V>, ? super Set<V>> eval);

    public Level2MapOfSetEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends Set<? extends V>, ? super Set<V>> function);
    
    
    
}

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
import java.util.Map;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.SelectedOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2MapOfListEntriesValueSelectedOperator<K,V,I>
        extends UniqOperator<Map<K,List<V>>,I>,
                NavigableCollectionOperator<V,I>,
		        DistinguishableOperator<I>,
		        SortableOperator<V,I>,
                ExecutableListSelectedOperator<V,I>,
                ReplaceableOperator<List<V>,I>,
                ModifiableCollectionOperator<V,I>,
                SelectedOperator<List<V>,I> {



    public Level2MapOfListEntriesValueOperator<K,V,I> endIf();

    
    public Level3MapOfListEntriesValueSelectedElementsOperator<K,V,I> forEach();

    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> distinct();
    
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> sort();
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> add(final V newElement);
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> addAll(final V... newElements);
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> insert(final int position, final V newElement);
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> insertAll(final int position, final V... newElements);
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> addAll(final Collection<V> collection);
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> removeAllIndexes(final int... indices);
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> removeAllEqual(final V... values);
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> removeAllIndexesNot(final int... indices);
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> removeAllNull();

    
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> convert(final IConverter<? extends List<? extends V>, ? super List<V>> converter);
    
    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> eval(final IEvaluator<? extends List<? extends V>, ? super List<V>> eval);

    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> replaceWith(final List<V> replacement);

    public Level2MapOfListEntriesValueSelectedOperator<K,V,I> exec(final IFunction<? extends List<? extends V>, ? super List<V>> function);
    
    
    
}

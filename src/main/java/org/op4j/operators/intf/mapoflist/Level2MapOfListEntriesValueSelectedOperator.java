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
import org.op4j.operators.qualities.ConvertibleSelectedOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.EvaluableSelectedOperator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
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
public interface Level2MapOfListEntriesValueSelectedOperator<K,V>
        extends UniqOperator<Map<K,List<V>>>,
                NavigableCollectionOperator<V>,
		        DistinguishableOperator,
		        SortableOperator<V>,
                ExecutableSelectedOperator<List<V>>,
                ConvertibleSelectedOperator<List<V>>,
                EvaluableSelectedOperator<List<V>>,
                ModifiableCollectionOperator<V>,
                SelectedOperator<List<V>> {



    public Level2MapOfListEntriesValueOperator<K,V> endIf();

    
    public Level3MapOfListEntriesValueElementsOperator<K,V> forEach();

    public Level2MapOfListEntriesValueSelectedOperator<K,V> distinct();
    
    public Level2MapOfListEntriesValueSelectedOperator<K,V> sort();
    public Level2MapOfListEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfListEntriesValueSelectedOperator<K,V> add(final V... newElements);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> insert(final int position, final V... newElements);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeIndexes(final int... indices);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeEquals(final V... values);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeIndexesNot(final int... indices);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> removeNulls();

    
    public Level2MapOfListEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends List<V>, ? super List<V>> converter);
    
    public Level2MapOfListEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends List<V>, ? super List<V>> eval);

    public Level2MapOfListEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends List<V>, ? super List<V>> function);
    
    
    
}

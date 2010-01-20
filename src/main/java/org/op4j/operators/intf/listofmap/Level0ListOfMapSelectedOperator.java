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
package org.op4j.operators.intf.listofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListOfMapSelectedOperator;
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
public interface Level0ListOfMapSelectedOperator<K,V>
        extends UniqOperator<List<Map<K,V>>>,
                NavigableCollectionOperator<Map<K,V>>,
		        DistinguishableOperator,
		        SortableOperator<Map<K,V>>,
                ExecutableListOfMapSelectedOperator<K,V>,
                ReplaceableOperator<List<Map<K,V>>>,
                SelectedOperator<List<Map<K,V>>>,
                ModifiableCollectionOperator<Map<K,V>> {



    public Level0ListOfMapOperator<K,V> endIf();



    public Level1ListOfMapSelectedElementsOperator<K,V> forEach();

    public Level0ListOfMapSelectedOperator<K,V> distinct();
    
    public Level0ListOfMapSelectedOperator<K,V> sort();
    public Level0ListOfMapSelectedOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator);
    
    public Level0ListOfMapSelectedOperator<K,V> add(final Map<K,V> newElement);
    public Level0ListOfMapSelectedOperator<K,V> addAll(final Map<K,V>... newElements);
    public Level0ListOfMapSelectedOperator<K,V> insert(final int position, final Map<K,V> newElement);
    public Level0ListOfMapSelectedOperator<K,V> insertAll(final int position, final Map<K,V>... newElements);
    public Level0ListOfMapSelectedOperator<K,V> addAll(final Collection<Map<K,V>> collection);
    public Level0ListOfMapSelectedOperator<K,V> removeAllIndexes(final int... indices);
    public Level0ListOfMapSelectedOperator<K,V> removeAllEqual(final Map<K,V>... values);
    public Level0ListOfMapSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapSelectedOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapSelectedOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapSelectedOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapSelectedOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapSelectedOperator<K,V> removeAllIndexesNot(final int... indices);
    public Level0ListOfMapSelectedOperator<K,V> removeAllNull();

    
    
    
    public Level0ListOfMapSelectedOperator<K,V> convert(final IConverter<? extends List<? extends Map<? extends K,? extends V>>, ? super List<Map<K,V>>> converter);
    
    public Level0ListOfMapSelectedOperator<K,V> eval(final IEvaluator<? extends List<? extends Map<? extends K,? extends V>>, ? super List<Map<K,V>>> eval);

    public Level0ListOfMapSelectedOperator<K,V> replaceWith(final List<Map<K,V>> replacement);

    public Level0ListOfMapSelectedOperator<K,V> exec(final IFunction<? extends List<? extends Map<? extends K,? extends V>>, ? super List<Map<K,V>>> function);
    
}

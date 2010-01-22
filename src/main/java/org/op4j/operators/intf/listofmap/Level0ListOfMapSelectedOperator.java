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
import java.util.Map;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListOfMapSelectedOperator;
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
public interface Level0ListOfMapSelectedOperator<K,V,I>
        extends UniqOperator<List<Map<K,V>>,I>,
                NavigableCollectionOperator<Map<K,V>,I>,
		        DistinguishableOperator<I>,
		        SortableOperator<Map<K,V>,I>,
                ExecutableListOfMapSelectedOperator<K,V,I>,
                ReplaceableOperator<List<Map<K,V>>,I>,
                SelectedOperator<List<Map<K,V>>,I>,
                ModifiableCollectionOperator<Map<K,V>,I> {



    public Level0ListOfMapOperator<K,V,I> endIf();



    public Level1ListOfMapSelectedElementsOperator<K,V,I> forEach();

    public Level0ListOfMapSelectedOperator<K,V,I> distinct();
    
    public Level0ListOfMapSelectedOperator<K,V,I> sort();
    public Level0ListOfMapSelectedOperator<K,V,I> sort(final Comparator<? super Map<K,V>> comparator);
    
    public Level0ListOfMapSelectedOperator<K,V,I> add(final Map<K,V> newElement);
    public Level0ListOfMapSelectedOperator<K,V,I> addAll(final Map<K,V>... newElements);
    public Level0ListOfMapSelectedOperator<K,V,I> insert(final int position, final Map<K,V> newElement);
    public Level0ListOfMapSelectedOperator<K,V,I> insertAll(final int position, final Map<K,V>... newElements);
    public Level0ListOfMapSelectedOperator<K,V,I> addAll(final Collection<Map<K,V>> collection);
    public Level0ListOfMapSelectedOperator<K,V,I> removeAllIndexes(final int... indices);
    public Level0ListOfMapSelectedOperator<K,V,I> removeAllEqual(final Map<K,V>... values);
    public Level0ListOfMapSelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapSelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapSelectedOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapSelectedOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapSelectedOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapSelectedOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapSelectedOperator<K,V,I> removeAllIndexesNot(final int... indices);
    public Level0ListOfMapSelectedOperator<K,V,I> removeAllNull();

    
    
    
    public Level0ListOfMapSelectedOperator<K,V,I> convert(final IConverter<? extends List<? extends Map<? extends K,? extends V>>, ? super List<Map<K,V>>> converter);
    
    public Level0ListOfMapSelectedOperator<K,V,I> eval(final IEvaluator<? extends List<? extends Map<? extends K,? extends V>>, ? super List<Map<K,V>>> eval);

    public Level0ListOfMapSelectedOperator<K,V,I> replaceWith(final List<Map<K,V>> replacement);

    public Level0ListOfMapSelectedOperator<K,V,I> exec(final IFunction<? extends List<? extends Map<? extends K,? extends V>>, ? super List<Map<K,V>>> function);
    
}

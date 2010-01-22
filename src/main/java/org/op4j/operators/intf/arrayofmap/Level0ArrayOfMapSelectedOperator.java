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
package org.op4j.operators.intf.arrayofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;


import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOfMapSelectedOperator;
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
public interface Level0ArrayOfMapSelectedOperator<K,V,I>
        extends UniqOperator<Map<K,V>[],I>,
                NavigableCollectionOperator<Map<K,V>,I>,
		        DistinguishableOperator<I>,
		        SortableOperator<Map<K,V>,I>,
                ExecutableArrayOfMapSelectedOperator<K,V,I>,
                ReplaceableOperator<Map<K,V>[],I>,
                SelectedOperator<Map<K,V>[],I>,
                ModifiableCollectionOperator<Map<K,V>,I> {



    public Level0ArrayOfMapOperator<K,V,I> endIf();



    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> forEach();

    public Level0ArrayOfMapSelectedOperator<K,V,I> distinct();
    
    public Level0ArrayOfMapSelectedOperator<K,V,I> sort();
    public Level0ArrayOfMapSelectedOperator<K,V,I> sort(final Comparator<? super Map<K,V>> comparator);
    
    public Level0ArrayOfMapSelectedOperator<K,V,I> add(final Map<K,V> newElement);
    public Level0ArrayOfMapSelectedOperator<K,V,I> addAll(final Map<K,V>... newElements);
    public Level0ArrayOfMapSelectedOperator<K,V,I> insert(final int position, final Map<K,V> newElement);
    public Level0ArrayOfMapSelectedOperator<K,V,I> insertAll(final int position, final Map<K,V>... newElements);
    public Level0ArrayOfMapSelectedOperator<K,V,I> addAll(final Collection<Map<K,V>> collection);
    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllIndexes(final int... indices);
    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllEqual(final Map<K,V>... values);
    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllIndexesNot(final int... indices);
    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllNull();

    
    
    
    public Level0ArrayOfMapSelectedOperator<K,V,I> convert(final IConverter<? extends Map<? extends K,? extends V>[], ? super Map<K,V>[]> converter);
    
    public Level0ArrayOfMapSelectedOperator<K,V,I> eval(final IEvaluator<? extends Map<? extends K,? extends V>[], ? super Map<K,V>[]> eval);

    public Level0ArrayOfMapSelectedOperator<K,V,I> replaceWith(final Map<K,V>[] replacement);

    public Level0ArrayOfMapSelectedOperator<K,V,I> exec(final IFunction<? extends Map<? extends K,? extends V>[], ? super Map<K,V>[]> function);
    
}

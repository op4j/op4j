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
package org.op4j.operators.intf.setofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSetOfMapSelectedOperator;
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
public interface Level0SetOfMapSelectedOperator<K,V>
        extends UniqOperator<Set<Map<K,V>>>,
                NavigableCollectionOperator<Map<K,V>>,
		        SortableOperator<Map<K,V>>,
                ExecutableSetOfMapSelectedOperator<K,V>,
                ReplaceableOperator<Set<Map<K,V>>>,
                SelectedOperator<Set<Map<K,V>>>,
                ModifiableCollectionOperator<Map<K,V>> {



    public Level0SetOfMapOperator<K,V> endIf();



    public Level1SetOfMapSelectedElementsOperator<K,V> forEach();

    public Level0SetOfMapSelectedOperator<K,V> sort();
    public Level0SetOfMapSelectedOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator);
    
    public Level0SetOfMapSelectedOperator<K,V> add(final Map<K,V> newElement);
    public Level0SetOfMapSelectedOperator<K,V> addAll(final Map<K,V>... newElements);
    public Level0SetOfMapSelectedOperator<K,V> insert(final int position, final Map<K,V> newElement);
    public Level0SetOfMapSelectedOperator<K,V> insertAll(final int position, final Map<K,V>... newElements);
    public Level0SetOfMapSelectedOperator<K,V> addAll(final Collection<Map<K,V>> collection);
    public Level0SetOfMapSelectedOperator<K,V> removeAllIndexes(final int... indexes);
    public Level0SetOfMapSelectedOperator<K,V> removeAllEqual(final Map<K,V>... values);
    public Level0SetOfMapSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapSelectedOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapSelectedOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapSelectedOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapSelectedOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapSelectedOperator<K,V> removeAllIndexesNot(final int... indexes);
    public Level0SetOfMapSelectedOperator<K,V> removeAllNull();

    
    
    
    public Level0SetOfMapSelectedOperator<K,V> convertAsSetOfMap(final IConverter<? extends Set<? extends Map<? extends K,? extends V>>, ? super Set<Map<K,V>>> converter);
    
    public Level0SetOfMapSelectedOperator<K,V> evalAsSetOfMap(final IEvaluator<? extends Set<? extends Map<? extends K,? extends V>>, ? super Set<Map<K,V>>> eval);

    public Level0SetOfMapSelectedOperator<K,V> replaceWith(final Set<Map<K,V>> replacement);

    public Level0SetOfMapSelectedOperator<K,V> execAsSetOfMap(final IFunction<? extends Set<? extends Map<? extends K,? extends V>>, ? super Set<Map<K,V>>> function);
    
}

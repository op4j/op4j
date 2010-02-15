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
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOfMapSelectedOperator;
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
public interface Level0ArrayOfMapSelectedOperator<K,V>
        extends UniqOperator<Map<K,V>[]>,
                NavigableCollectionOperator<Map<K,V>>,
		        DistinguishableOperator,
		        SortableOperator<Map<K,V>>,
                ExecutableArrayOfMapSelectedOperator<K,V>,
                ReplaceableOperator<Map<K,V>[]>,
                SelectedOperator<Map<K,V>[]>,
                ModifiableCollectionOperator<Map<K,V>> {



    public Level0ArrayOfMapOperator<K,V> endIf();



    public Level1ArrayOfMapSelectedElementsOperator<K,V> forEach();

    public Level0ArrayOfMapSelectedOperator<K,V> distinct();
    
    public Level0ArrayOfMapSelectedOperator<K,V> sort();
    public Level0ArrayOfMapSelectedOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator);
    
    public Level0ArrayOfMapSelectedOperator<K,V> add(final Map<K,V> newElement);
    public Level0ArrayOfMapSelectedOperator<K,V> addAll(final Map<K,V>... newElements);
    public Level0ArrayOfMapSelectedOperator<K,V> insert(final int position, final Map<K,V> newElement);
    public Level0ArrayOfMapSelectedOperator<K,V> insertAll(final int position, final Map<K,V>... newElements);
    public Level0ArrayOfMapSelectedOperator<K,V> addAll(final Collection<Map<K,V>> collection);
    public Level0ArrayOfMapSelectedOperator<K,V> removeAllIndexes(final int... indexes);
    public Level0ArrayOfMapSelectedOperator<K,V> removeAllEqual(final Map<K,V>... values);
    public Level0ArrayOfMapSelectedOperator<K,V> removeAllTrue(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapSelectedOperator<K,V> removeAllFalse(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapSelectedOperator<K,V> removeAllNullOrFalse(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapSelectedOperator<K,V> removeAllNotNullAndFalse(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapSelectedOperator<K,V> removeAllNotNullAndTrue(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapSelectedOperator<K,V> removeAllNullOrTrue(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapSelectedOperator<K,V> removeAllIndexesNot(final int... indexes);
    public Level0ArrayOfMapSelectedOperator<K,V> removeAllNull();

    
    
    
    public Level0ArrayOfMapSelectedOperator<K,V> execIfNotNullAsArrayOfMap(final IFunction<? extends Map<? extends K,? extends V>[], ? super Map<K,V>[]> function);

    public Level0ArrayOfMapSelectedOperator<K,V> replaceWith(final Map<K,V>[] replacement);

    public Level0ArrayOfMapSelectedOperator<K,V> execAsArrayOfMap(final IFunction<? extends Map<? extends K,? extends V>[], ? super Map<K,V>[]> function);
    
}

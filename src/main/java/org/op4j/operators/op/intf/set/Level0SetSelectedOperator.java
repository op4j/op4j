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
package org.op4j.operators.op.intf.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.ExecutableSetSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectedOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOpOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level0SetSelectedOperator<T,I>
        extends UniqOpOperator<Set<T>>,
                NavigableCollectionOperator<T>,
                SortableOperator<T>,
                ModifiableCollectionOperator<T>,
                SelectedOperator<Set<T>>,
                ExecutableSetSelectedOperator<T>,
                ReplaceableOperator<Set<T>> {



    public Level0SetOperator<T,I> endIf();



    public Level1SetSelectedElementsOperator<T,I> forEach();

    public Level0SetSelectedOperator<T,I> sort();
    public Level0SetSelectedOperator<T,I> sort(final Comparator<? super T> comparator);
        
    public Level0SetSelectedOperator<T,I> add(final T newElement);
    public Level0SetSelectedOperator<T,I> addAll(final T... newElements);
    public Level0SetSelectedOperator<T,I> insert(final int position, final T newElement);
    public Level0SetSelectedOperator<T,I> insertAll(final int position, final T... newElements);
    public Level0SetSelectedOperator<T,I> addAll(final Collection<T> collection);
    public Level0SetSelectedOperator<T,I> removeAllIndexes(final int... indexes);
    public Level0SetSelectedOperator<T,I> removeAllEqual(final T... values);
    public Level0SetSelectedOperator<T,I> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level0SetSelectedOperator<T,I> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level0SetSelectedOperator<T,I> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level0SetSelectedOperator<T,I> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level0SetSelectedOperator<T,I> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level0SetSelectedOperator<T,I> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level0SetSelectedOperator<T,I> removeAllIndexesNot(final int... indexes);
    public Level0SetSelectedOperator<T,I> removeAllNull();
    
    
    public Level0SetSelectedOperator<T,I> execIfNotNullAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function);

    public Level0SetSelectedOperator<T,I> replaceWith(final Set<T> replacement);

    public Level0SetSelectedOperator<T,I> execAsSet(final IFunction<? extends Set<? extends T>, ? super Set<T>> function);


    public Level0SetSelectedOperator<T,I> map(final IFunction<? extends T, ? super T> function);

    public Level0SetSelectedOperator<T,I> mapIfNotNull(final IFunction<? extends T, ? super T> function);
    
    
}

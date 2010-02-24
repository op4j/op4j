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
package org.op4j.operators.intf.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListSelectedOperator;
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
public interface Level0ListSelectedOperator<T,I>
        extends UniqOperator<List<T>>,
                NavigableCollectionOperator<T>,
                DistinguishableOperator,
                SortableOperator<T>,
                ModifiableCollectionOperator<T>,
                SelectedOperator<List<T>>,
                ExecutableListSelectedOperator<T>,
                ReplaceableOperator<List<T>> {



    public Level0ListOperator<T,I> endIf();



    public Level1ListSelectedElementsOperator<T,I> forEach();

    public Level0ListSelectedOperator<T,I> distinct();
    
    public Level0ListSelectedOperator<T,I> sort();
    public Level0ListSelectedOperator<T,I> sort(final Comparator<? super T> comparator);
        
    public Level0ListSelectedOperator<T,I> add(final T newElement);
    public Level0ListSelectedOperator<T,I> addAll(final T... newElements);
    public Level0ListSelectedOperator<T,I> insert(final int position, final T newElement);
    public Level0ListSelectedOperator<T,I> insertAll(final int position, final T... newElements);
    public Level0ListSelectedOperator<T,I> addAll(final Collection<T> collection);
    public Level0ListSelectedOperator<T,I> removeAllIndexes(final int... indexes);
    public Level0ListSelectedOperator<T,I> removeAllEqual(final T... values);
    public Level0ListSelectedOperator<T,I> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ListSelectedOperator<T,I> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ListSelectedOperator<T,I> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ListSelectedOperator<T,I> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ListSelectedOperator<T,I> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ListSelectedOperator<T,I> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ListSelectedOperator<T,I> removeAllIndexesNot(final int... indexes);
    public Level0ListSelectedOperator<T,I> removeAllNull();
    
    
    public Level0ListSelectedOperator<T,I> execIfNotNullAsList(final IFunction<? extends List<? extends T>,? super List<T>> function);

    public Level0ListSelectedOperator<T,I> replaceWith(final List<T> replacement);

    public Level0ListSelectedOperator<T,I> execAsList(final IFunction<? extends List<? extends T>, ? super List<T>> function);


    public Level0ListSelectedOperator<T,I> map(final IFunction<? extends T, ? super T> function);

    public Level0ListSelectedOperator<T,I> mapIfNotNull(final IFunction<? extends T, ? super T> function);
    
    
}

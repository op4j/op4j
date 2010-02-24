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
public interface Level0ListSelectedOperator<I,T>
        extends UniqOperator<List<T>>,
                NavigableCollectionOperator<T>,
                DistinguishableOperator,
                SortableOperator<T>,
                ModifiableCollectionOperator<T>,
                SelectedOperator<List<T>>,
                ExecutableListSelectedOperator<T>,
                ReplaceableOperator<List<T>> {



    public Level0ListOperator<I,T> endIf();



    public Level1ListSelectedElementsOperator<I,T> forEach();

    public Level0ListSelectedOperator<I,T> distinct();
    
    public Level0ListSelectedOperator<I,T> sort();
    public Level0ListSelectedOperator<I,T> sort(final Comparator<? super T> comparator);
        
    public Level0ListSelectedOperator<I,T> add(final T newElement);
    public Level0ListSelectedOperator<I,T> addAll(final T... newElements);
    public Level0ListSelectedOperator<I,T> insert(final int position, final T newElement);
    public Level0ListSelectedOperator<I,T> insertAll(final int position, final T... newElements);
    public Level0ListSelectedOperator<I,T> addAll(final Collection<T> collection);
    public Level0ListSelectedOperator<I,T> removeAllIndexes(final int... indexes);
    public Level0ListSelectedOperator<I,T> removeAllEqual(final T... values);
    public Level0ListSelectedOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval);
    public Level0ListSelectedOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval);
    public Level0ListSelectedOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval);
    public Level0ListSelectedOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public Level0ListSelectedOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval);
    public Level0ListSelectedOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval);
    public Level0ListSelectedOperator<I,T> removeAllIndexesNot(final int... indexes);
    public Level0ListSelectedOperator<I,T> removeAllNull();
    
    
    public Level0ListSelectedOperator<I,T> execIfNotNullAsList(final IFunction<? super List<T>,? extends List<? extends T>> function);

    public Level0ListSelectedOperator<I,T> replaceWith(final List<T> replacement);

    public Level0ListSelectedOperator<I,T> execAsList(final IFunction<? super List<T>,? extends List<? extends T>> function);


    public Level0ListSelectedOperator<I,T> map(final IFunction<? super T,? extends T> function);

    public Level0ListSelectedOperator<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function);
    
    
}

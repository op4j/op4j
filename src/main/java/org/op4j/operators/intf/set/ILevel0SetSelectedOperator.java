/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
package org.op4j.operators.intf.set;

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
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0SetSelectedOperator<I,T>
        extends UniqOperator<Set<T>>,
                NavigableCollectionOperator<T>,
                SortableOperator<T>,
                ModifiableCollectionOperator<T>,
                SelectedOperator<Set<T>>,
                ExecutableSetSelectedOperator<T>,
                ReplaceableOperator<Set<T>> {



    public ILevel0SetOperator<I,T> endIf();



    public ILevel1SetSelectedElementsOperator<I,T> forEach();

    public ILevel0SetSelectedOperator<I,T> sort();
    public ILevel0SetSelectedOperator<I,T> sort(final Comparator<? super T> comparator);
    public ILevel0SetSelectedOperator<I,T> sortBy(final IFunction<? super T,?> by);
        
    public ILevel0SetSelectedOperator<I,T> add(final T newElement);
    public ILevel0SetSelectedOperator<I,T> addAll(final T... newElements);
    public ILevel0SetSelectedOperator<I,T> insert(final int position, final T newElement);
    public ILevel0SetSelectedOperator<I,T> insertAll(final int position, final T... newElements);
    public ILevel0SetSelectedOperator<I,T> addAll(final Collection<T> collection);
    public ILevel0SetSelectedOperator<I,T> removeAllIndexes(final int... indexes);
    public ILevel0SetSelectedOperator<I,T> removeAllEqual(final T... values);
    public ILevel0SetSelectedOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0SetSelectedOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0SetSelectedOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0SetSelectedOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0SetSelectedOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0SetSelectedOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0SetSelectedOperator<I,T> removeAllIndexesNot(final int... indexes);
    public ILevel0SetSelectedOperator<I,T> removeAllNull();
    

    public ILevel0SetSelectedOperator<I,T> replaceWith(final Set<T> replacement);

    public ILevel0SetSelectedOperator<I,T> execAsSet(final IFunction<? super Set<T>,? extends Set<? extends T>> function);


    public ILevel0SetSelectedOperator<I,T> map(final IFunction<? super T,? extends T> function);
    
    
}

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
package org.op4j.operators.intf.arrayofset;

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
public interface Level1ArrayOfSetSelectedElementsSelectedOperator<T>
        extends UniqOperator<Set<T>[]>,
                NavigableCollectionOperator<T>,
    	        SortableOperator<T>,
                ExecutableSetSelectedOperator<T>,
                ReplaceableOperator<Set<T>>,
                SelectedOperator<Set<T>>,
                ModifiableCollectionOperator<T> {



    public Level1ArrayOfSetSelectedElementsOperator<T> endIf();


            
    public Level2ArrayOfSetSelectedElementsSelectedElementsOperator<T> forEach();

    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> sort();
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> add(final T newElement);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> addAll(final T... newElements);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> insert(final int position, final T newElement);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> insertAll(final int position, final T... newElements);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllIndexes(final int... indexes);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllEqual(final T... values);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllIndexesNot(final int... indexes);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNull();
    
    
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> execIfNotNullAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function);

    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> replaceWith(final Set<T> replacement);

    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> execAsSet(final IFunction<? extends Set<? extends T>, ? super Set<T>> function);
    


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> map(final IFunction<? extends T, ? super T> function);

		            
}

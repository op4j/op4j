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
package org.op4j.operators.intf.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.ExecutableSetSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1ListOfSetSelectedElementsOperator<T>
        extends UniqOperator<List<Set<T>>>,
                NavigableCollectionOperator<T>,
    	        SortableOperator<T>,
                ExecutableSetSelectedOperator<T>,
                ReplaceableOperator<Set<T>>,
                NavigatingCollectionOperator<Set<T>>,
                ModifiableCollectionOperator<T>,
                SelectableOperator<Set<T>> {



    public Level0ListOfSetSelectedOperator<T> endFor();


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNull();
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNotNull();
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super Set<T>> eval);


            
    public Level2ListOfSetSelectedElementsElementsOperator<T> forEach();

    public Level1ListOfSetSelectedElementsOperator<T> sort();
    public Level1ListOfSetSelectedElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ListOfSetSelectedElementsOperator<T> add(final T newElement);
    public Level1ListOfSetSelectedElementsOperator<T> addAll(final T... newElements);
    public Level1ListOfSetSelectedElementsOperator<T> insert(final int position, final T newElement);
    public Level1ListOfSetSelectedElementsOperator<T> insertAll(final int position, final T... newElements);
    public Level1ListOfSetSelectedElementsOperator<T> addAll(final Collection<T> collection);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllIndexes(final int... indexes);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllEqual(final T... values);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllIndexesNot(final int... indexes);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllNull();
    
    
    public Level1ListOfSetSelectedElementsOperator<T> execIfNotNullAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function);

    public Level1ListOfSetSelectedElementsOperator<T> replaceWith(final Set<T> replacement);

    public Level1ListOfSetSelectedElementsOperator<T> execAsSet(final IFunction<? extends Set<? extends T>, ? super Set<T>> function);


    
    public Level1ListOfSetSelectedElementsOperator<T> map(final IFunction<? extends T, ? super T> function);
		            
}

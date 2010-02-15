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
package org.op4j.operators.intf.listoflist;

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
public interface Level1ListOfListSelectedElementsSelectedOperator<T>
        extends UniqOperator<List<List<T>>>,
                NavigableCollectionOperator<T>,
    	        DistinguishableOperator,
		        SortableOperator<T>,
                ExecutableListSelectedOperator<T>,
                ReplaceableOperator<List<T>>,
                SelectedOperator<List<T>>,
                ModifiableCollectionOperator<T> {



    public Level1ListOfListSelectedElementsOperator<T> endIf();


            
    public Level2ListOfListSelectedElementsSelectedElementsOperator<T> forEach();

    public Level1ListOfListSelectedElementsSelectedOperator<T> distinct();
    
    public Level1ListOfListSelectedElementsSelectedOperator<T> sort();
    public Level1ListOfListSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ListOfListSelectedElementsSelectedOperator<T> add(final T newElement);
    public Level1ListOfListSelectedElementsSelectedOperator<T> addAll(final T... newElements);
    public Level1ListOfListSelectedElementsSelectedOperator<T> insert(final int position, final T newElement);
    public Level1ListOfListSelectedElementsSelectedOperator<T> insertAll(final int position, final T... newElements);
    public Level1ListOfListSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection);
    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllIndexes(final int... indexes);
    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllEqual(final T... values);
    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllIndexesNot(final int... indexes);
    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllNull();
    
    
    public Level1ListOfListSelectedElementsSelectedOperator<T> execIfNotNullAsList(final IFunction<? extends List<? extends T>,? super List<T>> function);

    public Level1ListOfListSelectedElementsSelectedOperator<T> replaceWith(final List<T> replacement);

    public Level1ListOfListSelectedElementsSelectedOperator<T> execAsList(final IFunction<? extends List<? extends T>, ? super List<T>> function);
    


    public Level1ListOfListSelectedElementsSelectedOperator<T> map(final IFunction<? extends T, ? super T> function);

		            
}

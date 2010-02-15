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
import org.op4j.operators.qualities.ExecutableListOfListSelectedOperator;
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
public interface Level0ListOfListSelectedOperator<T>
        extends UniqOperator<List<List<T>>>,
                NavigableCollectionOperator<List<T>>,
                DistinguishableOperator,
                SortableOperator<List<T>>,
                ModifiableCollectionOperator<List<T>>,
                ExecutableListOfListSelectedOperator<T>,
                ReplaceableOperator<List<List<T>>>,
                SelectedOperator<List<List<T>>> {



    public Level0ListOfListOperator<T> endIf();



    public Level1ListOfListSelectedElementsOperator<T> forEach();

    public Level0ListOfListSelectedOperator<T> distinct();
    
    public Level0ListOfListSelectedOperator<T> sort();
    public Level0ListOfListSelectedOperator<T> sort(final Comparator<? super List<T>> comparator);


    public Level0ListOfListSelectedOperator<T> add(final List<T> newElement);
    public Level0ListOfListSelectedOperator<T> addAll(final List<T>... newElements);
    public Level0ListOfListSelectedOperator<T> insert(final int position, final List<T> newElement);
    public Level0ListOfListSelectedOperator<T> insertAll(final int position, final List<T>... newElements);
    public Level0ListOfListSelectedOperator<T> addAll(final Collection<List<T>> collection);
    public Level0ListOfListSelectedOperator<T> removeAllIndexes(final int... indexes);
    public Level0ListOfListSelectedOperator<T> removeAllEqual(final List<T>... values);
    public Level0ListOfListSelectedOperator<T> removeAllTrue(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T> removeAllFalse(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T> removeAllIndexesNot(final int... indexes);
    public Level0ListOfListSelectedOperator<T> removeAllNull();



    
    public Level0ListOfListSelectedOperator<T> execIfNotNullAsListOfList(final IFunction<? extends List<? extends List<? extends T>>,? super List<List<T>>> function);

    public Level0ListOfListSelectedOperator<T> replaceWith(final List<List<T>> replacement);

    public Level0ListOfListSelectedOperator<T> execAsListOfList(final IFunction<? extends List<? extends List<? extends T>>, ? super List<List<T>>> function);



    public Level0ListOfListSelectedOperator<T> mapMap(final IFunction<? extends T, ? super T> function);

    
}

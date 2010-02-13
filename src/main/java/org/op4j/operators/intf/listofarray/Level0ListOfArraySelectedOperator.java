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
package org.op4j.operators.intf.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListOfArraySelectedOperator;
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
public interface Level0ListOfArraySelectedOperator<T>
        extends UniqOperator<List<T[]>>,
                NavigableCollectionOperator<T[]>,
                DistinguishableOperator,
                SortableOperator<T[]>,
                ModifiableCollectionOperator<T[]>,
                ExecutableListOfArraySelectedOperator<T>,
                ReplaceableOperator<List<T[]>>,
                SelectedOperator<List<T[]>> {



    public Level0ListOfArrayOperator<T> endIf();



    public Level1ListOfArraySelectedElementsOperator<T> forEach();

    public Level0ListOfArraySelectedOperator<T> distinct();
    
    public Level0ListOfArraySelectedOperator<T> sort();
    public Level0ListOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator);


    public Level0ListOfArraySelectedOperator<T> add(final T[] newElement);
    public Level0ListOfArraySelectedOperator<T> addAll(final T[]... newElements);
    public Level0ListOfArraySelectedOperator<T> insert(final int position, final T[] newElement);
    public Level0ListOfArraySelectedOperator<T> insertAll(final int position, final T[]... newElements);
    public Level0ListOfArraySelectedOperator<T> addAll(final Collection<T[]> collection);
    public Level0ListOfArraySelectedOperator<T> removeAllIndexes(final int... indexes);
    public Level0ListOfArraySelectedOperator<T> removeAllEqual(final T[]... values);
    public Level0ListOfArraySelectedOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T> removeAllIndexesNot(final int... indexes);
    public Level0ListOfArraySelectedOperator<T> removeAllNull();



    
    public Level0ListOfArraySelectedOperator<T> convertAsListOfArray(final IConverter<? extends List<? extends T[]>,? super List<T[]>> converter);
    
    public Level0ListOfArraySelectedOperator<T> evalAsListOfArray(final IEvaluator<? extends List<? extends T[]>,? super List<T[]>> eval);

    public Level0ListOfArraySelectedOperator<T> replaceWith(final List<T[]> replacement);

    public Level0ListOfArraySelectedOperator<T> execAsListOfArray(final IFunction<? extends List<? extends T[]>, ? super List<T[]>> function);



    public Level0ListOfArraySelectedOperator<T> mapMap(final IFunction<? extends T, ? super T> function);

    
}

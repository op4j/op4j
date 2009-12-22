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
import org.op4j.operators.qualities.ConvertibleSelectedOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.EvaluableSelectedOperator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
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
                ExecutableSelectedOperator<List<T[]>>,
                ConvertibleSelectedOperator<List<T[]>>,
                SelectedOperator<List<T[]>>,
                EvaluableSelectedOperator<List<T[]>> {



    public Level0ListOfArrayOperator<T> endIf();



    public Level1ListOfArraySelectedElementsOperator<T> forEach();

    public Level0ListOfArraySelectedOperator<T> distinct();
    
    public Level0ListOfArraySelectedOperator<T> sort();
    public Level0ListOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator);


    public Level0ListOfArraySelectedOperator<T> add(final T[]... newElements);
    public Level0ListOfArraySelectedOperator<T> insert(final int position, final T[]... newElements);
    public Level0ListOfArraySelectedOperator<T> addAll(final Collection<T[]> collection);
    public Level0ListOfArraySelectedOperator<T> removeIndexes(final int... indices);
    public Level0ListOfArraySelectedOperator<T> removeEquals(final T[]... values);
    public Level0ListOfArraySelectedOperator<T> removeMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArraySelectedOperator<T> removeIndexesNot(final int... indices);
    public Level0ListOfArraySelectedOperator<T> removeNulls();



    
    public Level0ListOfArraySelectedOperator<T> convert(final IConverter<? extends List<T[]>,? super List<T[]>> converter);
    
    public Level0ListOfArraySelectedOperator<T> eval(final IEvaluator<? extends List<T[]>,? super List<T[]>> eval);

    public Level0ListOfArraySelectedOperator<T> exec(final IFunction<? extends List<T[]>, ? super List<T[]>> function);

    
}

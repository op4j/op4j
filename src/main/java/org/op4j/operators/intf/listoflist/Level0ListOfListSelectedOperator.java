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
public interface Level0ListOfListSelectedOperator<T>
        extends UniqOperator<List<List<T>>>,
                NavigableCollectionOperator<List<T>>,
                DistinguishableOperator,
                SortableOperator<List<T>>,
                ModifiableCollectionOperator<List<T>>,
                ExecutableSelectedOperator<List<List<T>>>,
                ConvertibleSelectedOperator<List<List<T>>>,
                SelectedOperator<List<List<T>>>,
                EvaluableSelectedOperator<List<List<T>>> {



    public Level0ListOfListOperator<T> endIf();



    public Level1ListOfListSelectedElementsOperator<T> forEach();

    public Level0ListOfListSelectedOperator<T> distinct();
    
    public Level0ListOfListSelectedOperator<T> sort();
    public Level0ListOfListSelectedOperator<T> sort(final Comparator<? super List<T>> comparator);


    public Level0ListOfListSelectedOperator<T> add(final List<T>... newElements);
    public Level0ListOfListSelectedOperator<T> insert(final int position, final List<T>... newElements);
    public Level0ListOfListSelectedOperator<T> addAll(final Collection<List<T>> collection);
    public Level0ListOfListSelectedOperator<T> removeIndexes(final int... indices);
    public Level0ListOfListSelectedOperator<T> removeEquals(final List<T>... values);
    public Level0ListOfListSelectedOperator<T> removeMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T> removeIndexesNot(final int... indices);
    public Level0ListOfListSelectedOperator<T> removeNulls();



    
    public Level0ListOfListSelectedOperator<T> convert(final IConverter<? extends List<List<T>>,? super List<List<T>>> converter);
    
    public Level0ListOfListSelectedOperator<T> eval(final IEvaluator<? extends List<List<T>>,? super List<List<T>>> eval);

    public Level0ListOfListSelectedOperator<T> exec(final IFunction<? extends List<List<T>>, ? super List<List<T>>> function);

    
}

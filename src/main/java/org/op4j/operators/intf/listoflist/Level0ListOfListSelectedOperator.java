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
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListOfListSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.SelectedOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level0ListOfListSelectedOperator<T,I>
        extends UniqOperator<List<List<T>>,I>,
                NavigableCollectionOperator<List<T>,I>,
                DistinguishableOperator<I>,
                SortableOperator<List<T>,I>,
                ModifiableCollectionOperator<List<T>,I>,
                ExecutableListOfListSelectedOperator<T,I>,
                ReplaceableOperator<List<List<T>>,I>,
                SelectedOperator<List<List<T>>,I> {



    public Level0ListOfListOperator<T,I> endIf();



    public Level1ListOfListSelectedElementsOperator<T,I> forEach();

    public Level0ListOfListSelectedOperator<T,I> distinct();
    
    public Level0ListOfListSelectedOperator<T,I> sort();
    public Level0ListOfListSelectedOperator<T,I> sort(final Comparator<? super List<T>> comparator);


    public Level0ListOfListSelectedOperator<T,I> add(final List<T> newElement);
    public Level0ListOfListSelectedOperator<T,I> addAll(final List<T>... newElements);
    public Level0ListOfListSelectedOperator<T,I> insert(final int position, final List<T> newElement);
    public Level0ListOfListSelectedOperator<T,I> insertAll(final int position, final List<T>... newElements);
    public Level0ListOfListSelectedOperator<T,I> addAll(final Collection<List<T>> collection);
    public Level0ListOfListSelectedOperator<T,I> removeAllIndexes(final int... indices);
    public Level0ListOfListSelectedOperator<T,I> removeAllEqual(final List<T>... values);
    public Level0ListOfListSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListSelectedOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level0ListOfListSelectedOperator<T,I> removeAllNull();



    
    public Level0ListOfListSelectedOperator<T,I> convert(final IConverter<? extends List<? extends List<? extends T>>,? super List<List<T>>> converter);
    
    public Level0ListOfListSelectedOperator<T,I> eval(final IEvaluator<? extends List<? extends List<? extends T>>,? super List<List<T>>> eval);

    public Level0ListOfListSelectedOperator<T,I> replaceWith(final List<List<T>> replacement);

    public Level0ListOfListSelectedOperator<T,I> exec(final IFunction<? extends List<? extends List<? extends T>>, ? super List<List<T>>> function);

    
}

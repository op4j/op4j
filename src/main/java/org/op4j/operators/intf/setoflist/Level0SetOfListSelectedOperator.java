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
package org.op4j.operators.intf.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSetOfListSelectedOperator;
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
public interface Level0SetOfListSelectedOperator<T,I>
        extends UniqOperator<Set<List<T>>,I>,
                NavigableCollectionOperator<List<T>,I>,
                SortableOperator<List<T>,I>,
                ModifiableCollectionOperator<List<T>,I>,
                ExecutableSetOfListSelectedOperator<T,I>,
                ReplaceableOperator<Set<List<T>>,I>,
                SelectedOperator<Set<List<T>>,I> {



    public Level0SetOfListOperator<T,I> endIf();



    public Level1SetOfListSelectedElementsOperator<T,I> forEach();

    public Level0SetOfListSelectedOperator<T,I> sort();
    public Level0SetOfListSelectedOperator<T,I> sort(final Comparator<? super List<T>> comparator);


    public Level0SetOfListSelectedOperator<T,I> add(final List<T> newElement);
    public Level0SetOfListSelectedOperator<T,I> addAll(final List<T>... newElements);
    public Level0SetOfListSelectedOperator<T,I> insert(final int position, final List<T> newElement);
    public Level0SetOfListSelectedOperator<T,I> insertAll(final int position, final List<T>... newElements);
    public Level0SetOfListSelectedOperator<T,I> addAll(final Collection<List<T>> collection);
    public Level0SetOfListSelectedOperator<T,I> removeAllIndexes(final int... indices);
    public Level0SetOfListSelectedOperator<T,I> removeAllEqual(final List<T>... values);
    public Level0SetOfListSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level0SetOfListSelectedOperator<T,I> removeAllNull();



    
    public Level0SetOfListSelectedOperator<T,I> convert(final IConverter<? extends Set<? extends List<? extends T>>,? super Set<List<T>>> converter);
    
    public Level0SetOfListSelectedOperator<T,I> eval(final IEvaluator<? extends Set<? extends List<? extends T>>,? super Set<List<T>>> eval);

    public Level0SetOfListSelectedOperator<T,I> replaceWith(final Set<List<T>> replacement);

    public Level0SetOfListSelectedOperator<T,I> exec(final IFunction<? extends Set<? extends List<? extends T>>, ? super Set<List<T>>> function);

    
}

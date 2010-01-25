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
public interface Level0SetOfListSelectedOperator<T>
        extends UniqOperator<Set<List<T>>>,
                NavigableCollectionOperator<List<T>>,
                SortableOperator<List<T>>,
                ModifiableCollectionOperator<List<T>>,
                ExecutableSetOfListSelectedOperator<T>,
                ReplaceableOperator<Set<List<T>>>,
                SelectedOperator<Set<List<T>>> {



    public Level0SetOfListOperator<T> endIf();



    public Level1SetOfListSelectedElementsOperator<T> forEach();

    public Level0SetOfListSelectedOperator<T> sort();
    public Level0SetOfListSelectedOperator<T> sort(final Comparator<? super List<T>> comparator);


    public Level0SetOfListSelectedOperator<T> add(final List<T> newElement);
    public Level0SetOfListSelectedOperator<T> addAll(final List<T>... newElements);
    public Level0SetOfListSelectedOperator<T> insert(final int position, final List<T> newElement);
    public Level0SetOfListSelectedOperator<T> insertAll(final int position, final List<T>... newElements);
    public Level0SetOfListSelectedOperator<T> addAll(final Collection<List<T>> collection);
    public Level0SetOfListSelectedOperator<T> removeAllIndexes(final int... indices);
    public Level0SetOfListSelectedOperator<T> removeAllEqual(final List<T>... values);
    public Level0SetOfListSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T> removeAllIndexesNot(final int... indices);
    public Level0SetOfListSelectedOperator<T> removeAllNull();



    
    public Level0SetOfListSelectedOperator<T> convert(final IConverter<? extends Set<? extends List<? extends T>>,? super Set<List<T>>> converter);
    
    public Level0SetOfListSelectedOperator<T> eval(final IEvaluator<? extends Set<? extends List<? extends T>>,? super Set<List<T>>> eval);

    public Level0SetOfListSelectedOperator<T> replaceWith(final Set<List<T>> replacement);

    public Level0SetOfListSelectedOperator<T> exec(final IFunction<? extends Set<? extends List<? extends T>>, ? super Set<List<T>>> function);

    
}

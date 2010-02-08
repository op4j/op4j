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
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListOfSetSelectedOperator;
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
public interface Level0ListOfSetSelectedOperator<T>
        extends UniqOperator<List<Set<T>>>,
                NavigableCollectionOperator<Set<T>>,
                DistinguishableOperator,
                SortableOperator<Set<T>>,
                ModifiableCollectionOperator<Set<T>>,
                ExecutableListOfSetSelectedOperator<T>,
                ReplaceableOperator<List<Set<T>>>,
                SelectedOperator<List<Set<T>>> {



    public Level0ListOfSetOperator<T> endIf();



    public Level1ListOfSetSelectedElementsOperator<T> forEach();

    public Level0ListOfSetSelectedOperator<T> distinct();
    
    public Level0ListOfSetSelectedOperator<T> sort();
    public Level0ListOfSetSelectedOperator<T> sort(final Comparator<? super Set<T>> comparator);


    public Level0ListOfSetSelectedOperator<T> add(final Set<T> newElement);
    public Level0ListOfSetSelectedOperator<T> addAll(final Set<T>... newElements);
    public Level0ListOfSetSelectedOperator<T> insert(final int position, final Set<T> newElement);
    public Level0ListOfSetSelectedOperator<T> insertAll(final int position, final Set<T>... newElements);
    public Level0ListOfSetSelectedOperator<T> addAll(final Collection<Set<T>> collection);
    public Level0ListOfSetSelectedOperator<T> removeAllIndexes(final int... indexes);
    public Level0ListOfSetSelectedOperator<T> removeAllEqual(final Set<T>... values);
    public Level0ListOfSetSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetSelectedOperator<T> removeAllIndexesNot(final int... indexes);
    public Level0ListOfSetSelectedOperator<T> removeAllNull();



    
    public Level0ListOfSetSelectedOperator<T> convertAsListOfSet(final IConverter<? extends List<? extends Set<? extends T>>,? super List<Set<T>>> converter);
    
    public Level0ListOfSetSelectedOperator<T> evalAsListOfSet(final IEvaluator<? extends List<? extends Set<? extends T>>,? super List<Set<T>>> eval);

    public Level0ListOfSetSelectedOperator<T> replaceWith(final List<Set<T>> replacement);

    public Level0ListOfSetSelectedOperator<T> execAsListOfSet(final IFunction<? extends List<? extends Set<? extends T>>, ? super List<Set<T>>> function);

    
}

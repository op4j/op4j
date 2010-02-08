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
package org.op4j.operators.intf.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSetOfSetSelectedOperator;
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
public interface Level0SetOfSetSelectedOperator<T>
        extends UniqOperator<Set<Set<T>>>,
                NavigableCollectionOperator<Set<T>>,
                SortableOperator<Set<T>>,
                ModifiableCollectionOperator<Set<T>>,
                ExecutableSetOfSetSelectedOperator<T>,
                ReplaceableOperator<Set<Set<T>>>,
                SelectedOperator<Set<Set<T>>> {



    public Level0SetOfSetOperator<T> endIf();



    public Level1SetOfSetSelectedElementsOperator<T> forEach();

    public Level0SetOfSetSelectedOperator<T> sort();
    public Level0SetOfSetSelectedOperator<T> sort(final Comparator<? super Set<T>> comparator);


    public Level0SetOfSetSelectedOperator<T> add(final Set<T> newElement);
    public Level0SetOfSetSelectedOperator<T> addAll(final Set<T>... newElements);
    public Level0SetOfSetSelectedOperator<T> insert(final int position, final Set<T> newElement);
    public Level0SetOfSetSelectedOperator<T> insertAll(final int position, final Set<T>... newElements);
    public Level0SetOfSetSelectedOperator<T> addAll(final Collection<Set<T>> collection);
    public Level0SetOfSetSelectedOperator<T> removeAllIndexes(final int... indexes);
    public Level0SetOfSetSelectedOperator<T> removeAllEqual(final Set<T>... values);
    public Level0SetOfSetSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetOfSetSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetOfSetSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetOfSetSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetOfSetSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetOfSetSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetOfSetSelectedOperator<T> removeAllIndexesNot(final int... indexes);
    public Level0SetOfSetSelectedOperator<T> removeAllNull();



    
    public Level0SetOfSetSelectedOperator<T> convert(final IConverter<? extends Set<? extends Set<? extends T>>,? super Set<Set<T>>> converter);
    
    public Level0SetOfSetSelectedOperator<T> eval(final IEvaluator<? extends Set<? extends Set<? extends T>>,? super Set<Set<T>>> eval);

    public Level0SetOfSetSelectedOperator<T> replaceWith(final Set<Set<T>> replacement);

    public Level0SetOfSetSelectedOperator<T> exec(final IFunction<? extends Set<? extends Set<? extends T>>, ? super Set<Set<T>>> function);

    
}

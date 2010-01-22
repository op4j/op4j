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
package org.op4j.operators.intf.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOfSetSelectedOperator;
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
public interface Level0ArrayOfSetSelectedOperator<T,I>
        extends UniqOperator<Set<T>[],I>,
                NavigableCollectionOperator<Set<T>,I>,
                DistinguishableOperator<I>,
                SortableOperator<Set<T>,I>,
                ModifiableCollectionOperator<Set<T>,I>,
                ExecutableArrayOfSetSelectedOperator<T,I>,
                ReplaceableOperator<Set<T>[],I>,
                SelectedOperator<Set<T>[],I> {



    public Level0ArrayOfSetOperator<T,I> endIf();



    public Level1ArrayOfSetSelectedElementsOperator<T,I> forEach();

    public Level0ArrayOfSetSelectedOperator<T,I> distinct();
    
    public Level0ArrayOfSetSelectedOperator<T,I> sort();
    public Level0ArrayOfSetSelectedOperator<T,I> sort(final Comparator<? super Set<T>> comparator);


    public Level0ArrayOfSetSelectedOperator<T,I> add(final Set<T> newElement);
    public Level0ArrayOfSetSelectedOperator<T,I> addAll(final Set<T>... newElements);
    public Level0ArrayOfSetSelectedOperator<T,I> insert(final int position, final Set<T> newElement);
    public Level0ArrayOfSetSelectedOperator<T,I> insertAll(final int position, final Set<T>... newElements);
    public Level0ArrayOfSetSelectedOperator<T,I> addAll(final Collection<Set<T>> collection);
    public Level0ArrayOfSetSelectedOperator<T,I> removeAllIndexes(final int... indices);
    public Level0ArrayOfSetSelectedOperator<T,I> removeAllEqual(final Set<T>... values);
    public Level0ArrayOfSetSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level0ArrayOfSetSelectedOperator<T,I> removeAllNull();



    
    public Level0ArrayOfSetSelectedOperator<T,I> convert(final IConverter<? extends Set<? extends T>[],? super Set<T>[]> converter);
    
    public Level0ArrayOfSetSelectedOperator<T,I> eval(final IEvaluator<? extends Set<? extends T>[],? super Set<T>[]> eval);

    public Level0ArrayOfSetSelectedOperator<T,I> replaceWith(final Set<T>[] replacement);

    public Level0ArrayOfSetSelectedOperator<T,I> exec(final IFunction<? extends Set<? extends T>[], ? super Set<T>[]> function);

    
}

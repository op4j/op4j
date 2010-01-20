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
public interface Level0ArrayOfSetSelectedOperator<T>
        extends UniqOperator<Set<T>[]>,
                NavigableCollectionOperator<Set<T>>,
                DistinguishableOperator,
                SortableOperator<Set<T>>,
                ModifiableCollectionOperator<Set<T>>,
                ExecutableArrayOfSetSelectedOperator<T>,
                ReplaceableOperator<Set<T>[]>,
                SelectedOperator<Set<T>[]> {



    public Level0ArrayOfSetOperator<T> endIf();



    public Level1ArrayOfSetSelectedElementsOperator<T> forEach();

    public Level0ArrayOfSetSelectedOperator<T> distinct();
    
    public Level0ArrayOfSetSelectedOperator<T> sort();
    public Level0ArrayOfSetSelectedOperator<T> sort(final Comparator<? super Set<T>> comparator);


    public Level0ArrayOfSetSelectedOperator<T> add(final Set<T> newElement);
    public Level0ArrayOfSetSelectedOperator<T> addAll(final Set<T>... newElements);
    public Level0ArrayOfSetSelectedOperator<T> insert(final int position, final Set<T> newElement);
    public Level0ArrayOfSetSelectedOperator<T> insertAll(final int position, final Set<T>... newElements);
    public Level0ArrayOfSetSelectedOperator<T> addAll(final Collection<Set<T>> collection);
    public Level0ArrayOfSetSelectedOperator<T> removeAllIndexes(final int... indices);
    public Level0ArrayOfSetSelectedOperator<T> removeAllEqual(final Set<T>... values);
    public Level0ArrayOfSetSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetSelectedOperator<T> removeAllIndexesNot(final int... indices);
    public Level0ArrayOfSetSelectedOperator<T> removeAllNull();



    
    public Level0ArrayOfSetSelectedOperator<T> convert(final IConverter<? extends Set<? extends T>[],? super Set<T>[]> converter);
    
    public Level0ArrayOfSetSelectedOperator<T> eval(final IEvaluator<? extends Set<? extends T>[],? super Set<T>[]> eval);

    public Level0ArrayOfSetSelectedOperator<T> replaceWith(final Set<T>[] replacement);

    public Level0ArrayOfSetSelectedOperator<T> exec(final IFunction<? extends Set<? extends T>[], ? super Set<T>[]> function);

    
}

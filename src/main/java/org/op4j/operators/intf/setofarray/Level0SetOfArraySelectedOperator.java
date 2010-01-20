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
package org.op4j.operators.intf.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSetOfArraySelectedOperator;
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
public interface Level0SetOfArraySelectedOperator<T>
        extends UniqOperator<Set<T[]>>,
                NavigableCollectionOperator<T[]>,
                SortableOperator<T[]>,
                ModifiableCollectionOperator<T[]>,
                ExecutableSetOfArraySelectedOperator<T>,
                ReplaceableOperator<Set<T[]>>,
                SelectedOperator<Set<T[]>> {



    public Level0SetOfArrayOperator<T> endIf();



    public Level1SetOfArraySelectedElementsOperator<T> forEach();

    public Level0SetOfArraySelectedOperator<T> sort();
    public Level0SetOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator);


    public Level0SetOfArraySelectedOperator<T> add(final T[] newElement);
    public Level0SetOfArraySelectedOperator<T> addAll(final T[]... newElements);
    public Level0SetOfArraySelectedOperator<T> insert(final int position, final T[] newElement);
    public Level0SetOfArraySelectedOperator<T> insertAll(final int position, final T[]... newElements);
    public Level0SetOfArraySelectedOperator<T> addAll(final Collection<T[]> collection);
    public Level0SetOfArraySelectedOperator<T> removeAllIndexes(final int... indices);
    public Level0SetOfArraySelectedOperator<T> removeAllEqual(final T[]... values);
    public Level0SetOfArraySelectedOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0SetOfArraySelectedOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0SetOfArraySelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0SetOfArraySelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0SetOfArraySelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0SetOfArraySelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0SetOfArraySelectedOperator<T> removeAllIndexesNot(final int... indices);
    public Level0SetOfArraySelectedOperator<T> removeAllNull();



    
    public Level0SetOfArraySelectedOperator<T> convert(final IConverter<? extends Set<? extends T[]>,? super Set<T[]>> converter);
    
    public Level0SetOfArraySelectedOperator<T> eval(final IEvaluator<? extends Set<? extends T[]>,? super Set<T[]>> eval);

    public Level0SetOfArraySelectedOperator<T> replaceWith(final Set<T[]> replacement);

    public Level0SetOfArraySelectedOperator<T> exec(final IFunction<? extends Set<? extends T[]>, ? super Set<T[]>> function);

    
}

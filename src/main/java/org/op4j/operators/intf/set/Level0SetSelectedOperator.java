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
package org.op4j.operators.intf.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSetSelectedOperator;
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
public interface Level0SetSelectedOperator<T>
        extends UniqOperator<Set<T>>,
                NavigableCollectionOperator<T>,
                SortableOperator<T>,
                ModifiableCollectionOperator<T>,
                SelectedOperator<Set<T>>,
                ExecutableSetSelectedOperator<T>,
                ReplaceableOperator<Set<T>> {



    public Level0SetOperator<T> endIf();



    public Level1SetSelectedElementsOperator<T> forEach();

    public Level0SetSelectedOperator<T> sort();
    public Level0SetSelectedOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level0SetSelectedOperator<T> add(final T newElement);
    public Level0SetSelectedOperator<T> addAll(final T... newElements);
    public Level0SetSelectedOperator<T> insert(final int position, final T newElement);
    public Level0SetSelectedOperator<T> insertAll(final int position, final T... newElements);
    public Level0SetSelectedOperator<T> addAll(final Collection<T> collection);
    public Level0SetSelectedOperator<T> removeAllIndexes(final int... indexes);
    public Level0SetSelectedOperator<T> removeAllEqual(final T... values);
    public Level0SetSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetSelectedOperator<T> removeAllIndexesNot(final int... indexes);
    public Level0SetSelectedOperator<T> removeAllNull();
    
    
    public Level0SetSelectedOperator<T> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter);
    
    public Level0SetSelectedOperator<T> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval);

    public Level0SetSelectedOperator<T> replaceWith(final Set<T> replacement);

    public Level0SetSelectedOperator<T> exec(final IFunction<? extends Set<? extends T>, ? super Set<T>> function);

    
}

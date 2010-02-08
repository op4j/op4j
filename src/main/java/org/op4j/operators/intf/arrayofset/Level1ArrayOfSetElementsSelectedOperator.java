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
public interface Level1ArrayOfSetElementsSelectedOperator<T>
        extends UniqOperator<Set<T>[]>,
                NavigableCollectionOperator<T>,
    	        SortableOperator<T>,
                ExecutableSetSelectedOperator<T>,
                ReplaceableOperator<Set<T>>,
                SelectedOperator<Set<T>>,
                ModifiableCollectionOperator<T> {



    public Level1ArrayOfSetElementsOperator<T> endIf();


            
    public Level2ArrayOfSetElementsSelectedElementsOperator<T> forEach();

    public Level1ArrayOfSetElementsSelectedOperator<T> sort();
    public Level1ArrayOfSetElementsSelectedOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ArrayOfSetElementsSelectedOperator<T> add(final T newElement);
    public Level1ArrayOfSetElementsSelectedOperator<T> addAll(final T... newElements);
    public Level1ArrayOfSetElementsSelectedOperator<T> insert(final int position, final T newElement);
    public Level1ArrayOfSetElementsSelectedOperator<T> insertAll(final int position, final T... newElements);
    public Level1ArrayOfSetElementsSelectedOperator<T> addAll(final Collection<T> collection);
    public Level1ArrayOfSetElementsSelectedOperator<T> removeAllIndexes(final int... indexes);
    public Level1ArrayOfSetElementsSelectedOperator<T> removeAllEqual(final T... values);
    public Level1ArrayOfSetElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> removeAllIndexesNot(final int... indexes);
    public Level1ArrayOfSetElementsSelectedOperator<T> removeAllNull();
    
    
    public Level1ArrayOfSetElementsSelectedOperator<T> convertAsSet(final IConverter<? extends Set<? extends T>,? super Set<T>> converter);
    
    public Level1ArrayOfSetElementsSelectedOperator<T> evalAsSet(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval);

    public Level1ArrayOfSetElementsSelectedOperator<T> replaceWith(final Set<T> replacement);

    public Level1ArrayOfSetElementsSelectedOperator<T> execAsSet(final IFunction<? extends Set<? extends T>, ? super Set<T>> function);
    
		            
}

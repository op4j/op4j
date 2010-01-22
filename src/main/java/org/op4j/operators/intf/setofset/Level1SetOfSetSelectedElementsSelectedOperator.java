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
import org.op4j.operators.qualities.ExecutableSetSelectedOperator;
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
public interface Level1SetOfSetSelectedElementsSelectedOperator<T,I>
        extends UniqOperator<Set<Set<T>>,I>,
                NavigableCollectionOperator<T,I>,
    	        SortableOperator<T,I>,
                ExecutableSetSelectedOperator<T,I>,
                ReplaceableOperator<Set<T>,I>,
                SelectedOperator<Set<T>,I>,
                ModifiableCollectionOperator<T,I> {



    public Level1SetOfSetSelectedElementsOperator<T,I> endIf();


            
    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T,I> forEach();

    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> sort();
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> sort(final Comparator<? super T> comparator);
    
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> add(final T newElement);
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> addAll(final T... newElements);
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> insert(final int position, final T newElement);
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> insertAll(final int position, final T... newElements);
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> addAll(final Collection<T> collection);
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllIndexes(final int... indices);
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllEqual(final T... values);
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllNull();
    
    
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter);
    
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval);

    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> replaceWith(final Set<T> replacement);

    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends Set<? extends T>, ? super Set<T>> function);
    
		            
}

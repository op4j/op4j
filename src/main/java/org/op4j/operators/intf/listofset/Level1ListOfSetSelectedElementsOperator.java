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
import org.op4j.operators.qualities.ExecutableSetSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.SelectableOperator;
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
public interface Level1ListOfSetSelectedElementsOperator<T,I>
        extends UniqOperator<List<Set<T>>,I>,
                NavigableCollectionOperator<T,I>,
    	        SortableOperator<T,I>,
                ExecutableSetSelectedOperator<T,I>,
                ReplaceableOperator<Set<T>,I>,
                NavigatingCollectionOperator<Set<T>,I>,
                ModifiableCollectionOperator<T,I>,
                SelectableOperator<Set<T>,I> {



    public Level0ListOfSetSelectedOperator<T,I> endFor();


    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices);
    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifNull();
    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifNotNull();
    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval);


            
    public Level2ListOfSetSelectedElementsElementsOperator<T,I> forEach();

    public Level1ListOfSetSelectedElementsOperator<T,I> sort();
    public Level1ListOfSetSelectedElementsOperator<T,I> sort(final Comparator<? super T> comparator);
    
    public Level1ListOfSetSelectedElementsOperator<T,I> add(final T newElement);
    public Level1ListOfSetSelectedElementsOperator<T,I> addAll(final T... newElements);
    public Level1ListOfSetSelectedElementsOperator<T,I> insert(final int position, final T newElement);
    public Level1ListOfSetSelectedElementsOperator<T,I> insertAll(final int position, final T... newElements);
    public Level1ListOfSetSelectedElementsOperator<T,I> addAll(final Collection<T> collection);
    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllIndexes(final int... indices);
    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllEqual(final T... values);
    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllNull();
    
    
    public Level1ListOfSetSelectedElementsOperator<T,I> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter);
    
    public Level1ListOfSetSelectedElementsOperator<T,I> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval);

    public Level1ListOfSetSelectedElementsOperator<T,I> replaceWith(final Set<T> replacement);

    public Level1ListOfSetSelectedElementsOperator<T,I> exec(final IFunction<? extends Set<? extends T>, ? super Set<T>> function);
    
		            
}

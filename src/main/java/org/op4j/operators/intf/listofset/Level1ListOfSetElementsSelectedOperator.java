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
public interface Level1ListOfSetElementsSelectedOperator<T,I>
        extends UniqOperator<List<Set<T>>,I>,
                NavigableCollectionOperator<T,I>,
    	        SortableOperator<T,I>,
                ExecutableSetSelectedOperator<T,I>,
                ReplaceableOperator<Set<T>,I>,
                SelectedOperator<Set<T>,I>,
                ModifiableCollectionOperator<T,I> {



    public Level1ListOfSetElementsOperator<T,I> endIf();


            
    public Level2ListOfSetElementsSelectedElementsOperator<T,I> forEach();

    public Level1ListOfSetElementsSelectedOperator<T,I> sort();
    public Level1ListOfSetElementsSelectedOperator<T,I> sort(final Comparator<? super T> comparator);
    
    public Level1ListOfSetElementsSelectedOperator<T,I> add(final T newElement);
    public Level1ListOfSetElementsSelectedOperator<T,I> addAll(final T... newElements);
    public Level1ListOfSetElementsSelectedOperator<T,I> insert(final int position, final T newElement);
    public Level1ListOfSetElementsSelectedOperator<T,I> insertAll(final int position, final T... newElements);
    public Level1ListOfSetElementsSelectedOperator<T,I> addAll(final Collection<T> collection);
    public Level1ListOfSetElementsSelectedOperator<T,I> removeAllIndexes(final int... indices);
    public Level1ListOfSetElementsSelectedOperator<T,I> removeAllEqual(final T... values);
    public Level1ListOfSetElementsSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsSelectedOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level1ListOfSetElementsSelectedOperator<T,I> removeAllNull();
    
    
    public Level1ListOfSetElementsSelectedOperator<T,I> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter);
    
    public Level1ListOfSetElementsSelectedOperator<T,I> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval);

    public Level1ListOfSetElementsSelectedOperator<T,I> replaceWith(final Set<T> replacement);

    public Level1ListOfSetElementsSelectedOperator<T,I> exec(final IFunction<? extends Set<? extends T>, ? super Set<T>> function);
    
		            
}

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
package org.op4j.operators.intf.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListSelectedOperator;
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
public interface Level1ArrayOfListSelectedElementsOperator<T,I>
        extends UniqOperator<List<T>[],I>,
                NavigableCollectionOperator<T,I>,
    	        DistinguishableOperator<I>,
		        SortableOperator<T,I>,
                ExecutableListSelectedOperator<T,I>,
                ReplaceableOperator<List<T>,I>,
                NavigatingCollectionOperator<List<T>,I>,
                ModifiableCollectionOperator<T,I>,
                SelectableOperator<List<T>,I> {



    public Level0ArrayOfListSelectedOperator<T,I> endFor();


    public Level1ArrayOfListSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices);
    public Level1ArrayOfListSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListSelectedElementsSelectedOperator<T,I> ifNull();
    public Level1ArrayOfListSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level1ArrayOfListSelectedElementsSelectedOperator<T,I> ifNotNull();
    public Level1ArrayOfListSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval);


            
    public Level2ArrayOfListSelectedElementsElementsOperator<T,I> forEach();

    public Level1ArrayOfListSelectedElementsOperator<T,I> distinct();
    
    public Level1ArrayOfListSelectedElementsOperator<T,I> sort();
    public Level1ArrayOfListSelectedElementsOperator<T,I> sort(final Comparator<? super T> comparator);
    
    public Level1ArrayOfListSelectedElementsOperator<T,I> add(final T newElement);
    public Level1ArrayOfListSelectedElementsOperator<T,I> addAll(final T... newElements);
    public Level1ArrayOfListSelectedElementsOperator<T,I> insert(final int position, final T newElement);
    public Level1ArrayOfListSelectedElementsOperator<T,I> insertAll(final int position, final T... newElements);
    public Level1ArrayOfListSelectedElementsOperator<T,I> addAll(final Collection<T> collection);
    public Level1ArrayOfListSelectedElementsOperator<T,I> removeAllIndexes(final int... indices);
    public Level1ArrayOfListSelectedElementsOperator<T,I> removeAllEqual(final T... values);
    public Level1ArrayOfListSelectedElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListSelectedElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListSelectedElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListSelectedElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListSelectedElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListSelectedElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListSelectedElementsOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level1ArrayOfListSelectedElementsOperator<T,I> removeAllNull();
    
    
    public Level1ArrayOfListSelectedElementsOperator<T,I> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter);
    
    public Level1ArrayOfListSelectedElementsOperator<T,I> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval);

    public Level1ArrayOfListSelectedElementsOperator<T,I> replaceWith(final List<T> replacement);

    public Level1ArrayOfListSelectedElementsOperator<T,I> exec(final IFunction<? extends List<? extends T>, ? super List<T>> function);
    
		            
}

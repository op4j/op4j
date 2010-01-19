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
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1ArrayOfListSelectedElementsOperator<T>
        extends UniqOperator<List<T>[]>,
                NavigableCollectionOperator<T>,
    	        DistinguishableOperator,
		        SortableOperator<T>,
                ExecutableListSelectedOperator<T>,
                ReplaceableOperator<List<T>>,
                NavigatingCollectionOperator<List<T>>,
                ModifiableCollectionOperator<T>,
                SelectableOperator<List<T>> {



    public Level0ArrayOfListSelectedOperator<T> endFor();


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNull();
    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNotNull();
    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval);


            
    public Level2ArrayOfListSelectedElementsElementsOperator<T> forEach();

    public Level1ArrayOfListSelectedElementsOperator<T> distinct();
    
    public Level1ArrayOfListSelectedElementsOperator<T> sort();
    public Level1ArrayOfListSelectedElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ArrayOfListSelectedElementsOperator<T> add(final T... newElements);
    public Level1ArrayOfListSelectedElementsOperator<T> insert(final int position, final T... newElements);
    public Level1ArrayOfListSelectedElementsOperator<T> addAll(final Collection<T> collection);
    public Level1ArrayOfListSelectedElementsOperator<T> removeAllIndexes(final int... indices);
    public Level1ArrayOfListSelectedElementsOperator<T> removeAllEqual(final T... values);
    public Level1ArrayOfListSelectedElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListSelectedElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListSelectedElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListSelectedElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListSelectedElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListSelectedElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListSelectedElementsOperator<T> removeAllIndexesNot(final int... indices);
    public Level1ArrayOfListSelectedElementsOperator<T> removeAllNull();
    
    
    public Level1ArrayOfListSelectedElementsOperator<T> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter);
    
    public Level1ArrayOfListSelectedElementsOperator<T> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval);

    public Level1ArrayOfListSelectedElementsOperator<T> replaceBy(final List<T> replacement);

    public Level1ArrayOfListSelectedElementsOperator<T> exec(final IFunction<? extends List<? extends T>, ? super List<T>> function);
    
		            
}

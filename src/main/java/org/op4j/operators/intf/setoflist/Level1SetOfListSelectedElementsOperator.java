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
package org.op4j.operators.intf.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
public interface Level1SetOfListSelectedElementsOperator<T>
        extends UniqOperator<Set<List<T>>>,
                NavigableCollectionOperator<T>,
    	        DistinguishableOperator,
		        SortableOperator<T>,
                ExecutableListSelectedOperator<T>,
                ReplaceableOperator<List<T>>,
                NavigatingCollectionOperator<List<T>>,
                ModifiableCollectionOperator<T>,
                SelectableOperator<List<T>> {



    public Level0SetOfListSelectedOperator<T> endFor();


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level1SetOfListSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNull();
    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNotNull();
    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval);


            
    public Level2SetOfListSelectedElementsElementsOperator<T> forEach();

    public Level1SetOfListSelectedElementsOperator<T> distinct();
    
    public Level1SetOfListSelectedElementsOperator<T> sort();
    public Level1SetOfListSelectedElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1SetOfListSelectedElementsOperator<T> add(final T newElement);
    public Level1SetOfListSelectedElementsOperator<T> addAll(final T... newElements);
    public Level1SetOfListSelectedElementsOperator<T> insert(final int position, final T newElement);
    public Level1SetOfListSelectedElementsOperator<T> insertAll(final int position, final T... newElements);
    public Level1SetOfListSelectedElementsOperator<T> addAll(final Collection<T> collection);
    public Level1SetOfListSelectedElementsOperator<T> removeAllIndexes(final int... indexes);
    public Level1SetOfListSelectedElementsOperator<T> removeAllEqual(final T... values);
    public Level1SetOfListSelectedElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListSelectedElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListSelectedElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListSelectedElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListSelectedElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListSelectedElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListSelectedElementsOperator<T> removeAllIndexesNot(final int... indexes);
    public Level1SetOfListSelectedElementsOperator<T> removeAllNull();
    
    
    public Level1SetOfListSelectedElementsOperator<T> convertAsList(final IConverter<? extends List<? extends T>,? super List<T>> converter);
    
    public Level1SetOfListSelectedElementsOperator<T> evalAsList(final IEvaluator<? extends List<? extends T>,? super List<T>> eval);

    public Level1SetOfListSelectedElementsOperator<T> replaceWith(final List<T> replacement);

    public Level1SetOfListSelectedElementsOperator<T> execAsList(final IFunction<? extends List<? extends T>, ? super List<T>> function);


    
    public Level1SetOfListSelectedElementsOperator<T> map(final IFunction<? extends T, ? super T> function);
		            
}

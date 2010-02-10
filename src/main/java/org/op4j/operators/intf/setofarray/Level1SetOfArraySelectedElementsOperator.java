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
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArraySelectedOperator;
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
public interface Level1SetOfArraySelectedElementsOperator<T>
        extends UniqOperator<Set<T[]>>,
                NavigableCollectionOperator<T>,
    	        DistinguishableOperator,
		        SortableOperator<T>,
                ExecutableArraySelectedOperator<T>,
                ReplaceableOperator<T[]>,
                NavigatingCollectionOperator<T[]>,
                ModifiableCollectionOperator<T>,
                SelectableOperator<T[]> {



    public Level0SetOfArraySelectedOperator<T> endFor();


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNull();
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNull();
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval);


            
    public Level2SetOfArraySelectedElementsElementsOperator<T> forEach();

    public Level1SetOfArraySelectedElementsOperator<T> distinct();
    
    public Level1SetOfArraySelectedElementsOperator<T> sort();
    public Level1SetOfArraySelectedElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1SetOfArraySelectedElementsOperator<T> add(final T newElement);
    public Level1SetOfArraySelectedElementsOperator<T> addAll(final T... newElements);
    public Level1SetOfArraySelectedElementsOperator<T> insert(final int position, final T newElement);
    public Level1SetOfArraySelectedElementsOperator<T> insertAll(final int position, final T... newElements);
    public Level1SetOfArraySelectedElementsOperator<T> addAll(final Collection<T> collection);
    public Level1SetOfArraySelectedElementsOperator<T> removeAllIndexes(final int... indexes);
    public Level1SetOfArraySelectedElementsOperator<T> removeAllEqual(final T... values);
    public Level1SetOfArraySelectedElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsOperator<T> removeAllIndexesNot(final int... indexes);
    public Level1SetOfArraySelectedElementsOperator<T> removeAllNull();
    
    
    public Level1SetOfArraySelectedElementsOperator<T> convertAsArray(final IConverter<? extends T[],? super T[]> converter);
    
    public Level1SetOfArraySelectedElementsOperator<T> evalAsArray(final IEvaluator<? extends T[],? super T[]> eval);

    public Level1SetOfArraySelectedElementsOperator<T> replaceWith(final T[] replacement);

    public Level1SetOfArraySelectedElementsOperator<T> execAsArray(final IFunction<? extends T[], ? super T[]> function);
    
		            
}

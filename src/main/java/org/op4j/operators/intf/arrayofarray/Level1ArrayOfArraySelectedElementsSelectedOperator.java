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
package org.op4j.operators.intf.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArraySelectedOperator;
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
public interface Level1ArrayOfArraySelectedElementsSelectedOperator<T>
        extends UniqOperator<T[][]>,
                NavigableCollectionOperator<T>,
    	        DistinguishableOperator,
		        SortableOperator<T>,
                ExecutableArraySelectedOperator<T>,
                ReplaceableOperator<T[]>,
                SelectedOperator<T[]>,
                ModifiableCollectionOperator<T> {



    public Level1ArrayOfArraySelectedElementsOperator<T> endIf();


            
    public Level2ArrayOfArraySelectedElementsSelectedElementsOperator<T> forEach();

    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> distinct();
    
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> sort();
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> add(final T newElement);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> addAll(final T... newElements);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> insert(final int position, final T newElement);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> insertAll(final int position, final T... newElements);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> addAll(final Collection<T> collection);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeAllIndexes(final int... indexes);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeAllEqual(final T... values);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeAllIndexesNot(final int... indexes);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeAllNull();
    
    
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> convertAsArray(final IConverter<? extends T[],? super T[]> converter);
    
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> evalAsArray(final IEvaluator<? extends T[],? super T[]> eval);

    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> replaceWith(final T[] replacement);

    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> execAsArray(final IFunction<? extends T[], ? super T[]> function);
    


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> map(final IFunction<? extends T, ? super T> function);

		            
}

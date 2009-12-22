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
import org.op4j.operators.qualities.ConvertibleSelectedOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.EvaluableSelectedOperator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
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
public interface Level1ArrayOfArraySelectedElementsOperator<T>
        extends UniqOperator<T[][]>,
                NavigableCollectionOperator<T>,
    	        DistinguishableOperator,
		        SortableOperator<T>,
                ExecutableSelectedOperator<T[]>,
                ConvertibleSelectedOperator<T[]>,
                EvaluableSelectedOperator<T[]>,
                NavigatingCollectionOperator<T[]>,
                ModifiableCollectionOperator<T>,
                SelectableOperator<T[]> {



    public Level0ArrayOfArraySelectedOperator<T> endFor();


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNull();
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNotNull();
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval);


            
    public Level2ArrayOfArraySelectedElementsElementsOperator<T> forEach();

    public Level1ArrayOfArraySelectedElementsOperator<T> distinct();
    
    public Level1ArrayOfArraySelectedElementsOperator<T> sort();
    public Level1ArrayOfArraySelectedElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ArrayOfArraySelectedElementsOperator<T> add(final T... newElements);
    public Level1ArrayOfArraySelectedElementsOperator<T> insert(final int position, final T... newElements);
    public Level1ArrayOfArraySelectedElementsOperator<T> addAll(final Collection<T> collection);
    public Level1ArrayOfArraySelectedElementsOperator<T> removeIndexes(final int... indices);
    public Level1ArrayOfArraySelectedElementsOperator<T> removeEquals(final T... values);
    public Level1ArrayOfArraySelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArraySelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArraySelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArraySelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArraySelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArraySelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArraySelectedElementsOperator<T> removeIndexesNot(final int... indices);
    public Level1ArrayOfArraySelectedElementsOperator<T> removeNulls();
    
    
    public Level1ArrayOfArraySelectedElementsOperator<T> convert(final IConverter<? extends T[],? super T[]> converter);
    
    public Level1ArrayOfArraySelectedElementsOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval);

    public Level1ArrayOfArraySelectedElementsOperator<T> exec(final IFunction<? extends T[], ? super T[]> function);
    
		            
}

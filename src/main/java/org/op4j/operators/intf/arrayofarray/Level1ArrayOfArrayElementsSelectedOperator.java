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
public interface Level1ArrayOfArrayElementsSelectedOperator<T>
        extends UniqOperator<T[][]>,
                NavigableCollectionOperator<T>,
    	        DistinguishableOperator,
		        SortableOperator<T>,
                ExecutableSelectedOperator<T[]>,
                ConvertibleSelectedOperator<T[]>,
                EvaluableSelectedOperator<T[]>,
                SelectedOperator<T[]>,
                ModifiableCollectionOperator<T> {



    public Level1ArrayOfArrayElementsOperator<T> endIf();


            
    public Level2ArrayOfArrayElementsSelectedElementsOperator<T> forEach();

    public Level1ArrayOfArrayElementsSelectedOperator<T> distinct();
    
    public Level1ArrayOfArrayElementsSelectedOperator<T> sort();
    public Level1ArrayOfArrayElementsSelectedOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ArrayOfArrayElementsSelectedOperator<T> add(final T... newElements);
    public Level1ArrayOfArrayElementsSelectedOperator<T> insert(final int position, final T... newElements);
    public Level1ArrayOfArrayElementsSelectedOperator<T> addAll(final Collection<T> collection);
    public Level1ArrayOfArrayElementsSelectedOperator<T> removeIndexes(final int... indices);
    public Level1ArrayOfArrayElementsSelectedOperator<T> removeEquals(final T... values);
    public Level1ArrayOfArrayElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArrayElementsSelectedOperator<T> removeIndexesNot(final int... indices);
    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNulls();
    
    
    public Level1ArrayOfArrayElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter);
    
    public Level1ArrayOfArrayElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval);

    public Level1ArrayOfArrayElementsSelectedOperator<T> exec(final IFunction<? extends T[], ? super T[]> function);
    
		            
}

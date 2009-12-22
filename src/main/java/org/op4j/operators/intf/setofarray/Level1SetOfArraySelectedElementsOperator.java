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
public interface Level1SetOfArraySelectedElementsOperator<T>
        extends UniqOperator<Set<T[]>>,
                NavigableCollectionOperator<T>,
    	        DistinguishableOperator,
		        SortableOperator<T>,
                ExecutableSelectedOperator<T[]>,
                ConvertibleSelectedOperator<T[]>,
                EvaluableSelectedOperator<T[]>,
                NavigatingCollectionOperator<T[]>,
                ModifiableCollectionOperator<T>,
                SelectableOperator<T[]> {



    public Level0SetOfArraySelectedOperator<T> endFor();


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNull();
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNull();
    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval);


            
    public Level2SetOfArraySelectedElementsElementsOperator<T> forEach();

    public Level1SetOfArraySelectedElementsOperator<T> distinct();
    
    public Level1SetOfArraySelectedElementsOperator<T> sort();
    public Level1SetOfArraySelectedElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1SetOfArraySelectedElementsOperator<T> add(final T... newElements);
    public Level1SetOfArraySelectedElementsOperator<T> insert(final int position, final T... newElements);
    public Level1SetOfArraySelectedElementsOperator<T> addAll(final Collection<T> collection);
    public Level1SetOfArraySelectedElementsOperator<T> removeIndexes(final int... indices);
    public Level1SetOfArraySelectedElementsOperator<T> removeEquals(final T... values);
    public Level1SetOfArraySelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsOperator<T> removeIndexesNot(final int... indices);
    public Level1SetOfArraySelectedElementsOperator<T> removeNulls();
    
    
    public Level1SetOfArraySelectedElementsOperator<T> convert(final IConverter<? extends T[],? super T[]> converter);
    
    public Level1SetOfArraySelectedElementsOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval);

    public Level1SetOfArraySelectedElementsOperator<T> exec(final IFunction<? extends T[], ? super T[]> function);
    
		            
}

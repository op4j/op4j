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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArraySelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableArrayOperator;
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
public interface Level1SetOfArraySelectedElementsSelectedOperator<T>
        extends UniqOperator<Set<T[]>>,
                NavigableArrayOperator<T>,
    	        DistinguishableOperator,
		        SortableOperator<T>,
                ExecutableArraySelectedOperator<T>,
                ReplaceableOperator<T[]>,
                SelectedOperator<T[]>,
                ModifiableCollectionOperator<T> {



    public Level1SetOfArraySelectedElementsOperator<T> endIf();


            
    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T> forEach(final Type<T> elementType);

    public Level1SetOfArraySelectedElementsSelectedOperator<T> distinct();
    
    public Level1SetOfArraySelectedElementsSelectedOperator<T> sort();
    public Level1SetOfArraySelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1SetOfArraySelectedElementsSelectedOperator<T> add(final T newElement);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> addAll(final T... newElements);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> insert(final int position, final T newElement);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> insertAll(final int position, final T... newElements);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> addAll(final Collection<T> collection);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllIndexes(final int... indices);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllEqual(final T... values);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllIndexesNot(final int... indices);
    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllNull();
    
    
    public Level1SetOfArraySelectedElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter);
    
    public Level1SetOfArraySelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval);

    public Level1SetOfArraySelectedElementsSelectedOperator<T> replaceWith(final T[] replacement);

    public Level1SetOfArraySelectedElementsSelectedOperator<T> exec(final IFunction<? extends T[], ? super T[]> function);
    
		            
}

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
package org.op4j.operators.intf.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;import org.javaruntype.type.Type;


import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArraySelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableArrayOperator;
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
public interface Level1ListOfArrayElementsSelectedOperator<T,I>
        extends UniqOperator<List<T[]>,I>,
                NavigableArrayOperator<T,I>,
    	        DistinguishableOperator<I>,
		        SortableOperator<T,I>,
                ExecutableArraySelectedOperator<T,I>,
                ReplaceableOperator<T[],I>,
                SelectedOperator<T[],I>,
                ModifiableCollectionOperator<T,I> {



    public Level1ListOfArrayElementsOperator<T,I> endIf();


            
    public Level2ListOfArrayElementsSelectedElementsOperator<T,I> forEach(final Type<T> elementType);

    public Level1ListOfArrayElementsSelectedOperator<T,I> distinct();
    
    public Level1ListOfArrayElementsSelectedOperator<T,I> sort();
    public Level1ListOfArrayElementsSelectedOperator<T,I> sort(final Comparator<? super T> comparator);
    
    public Level1ListOfArrayElementsSelectedOperator<T,I> add(final T newElement);
    public Level1ListOfArrayElementsSelectedOperator<T,I> addAll(final T... newElements);
    public Level1ListOfArrayElementsSelectedOperator<T,I> insert(final int position, final T newElement);
    public Level1ListOfArrayElementsSelectedOperator<T,I> insertAll(final int position, final T... newElements);
    public Level1ListOfArrayElementsSelectedOperator<T,I> addAll(final Collection<T> collection);
    public Level1ListOfArrayElementsSelectedOperator<T,I> removeAllIndexes(final int... indices);
    public Level1ListOfArrayElementsSelectedOperator<T,I> removeAllEqual(final T... values);
    public Level1ListOfArrayElementsSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsSelectedOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level1ListOfArrayElementsSelectedOperator<T,I> removeAllNull();
    
    
    public Level1ListOfArrayElementsSelectedOperator<T,I> convert(final IConverter<? extends T[],? super T[]> converter);
    
    public Level1ListOfArrayElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T[],? super T[]> eval);

    public Level1ListOfArrayElementsSelectedOperator<T,I> replaceWith(final T[] replacement);

    public Level1ListOfArrayElementsSelectedOperator<T,I> exec(final IFunction<? extends T[], ? super T[]> function);
    
		            
}

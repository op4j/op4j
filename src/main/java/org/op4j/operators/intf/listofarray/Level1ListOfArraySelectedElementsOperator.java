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
public interface Level1ListOfArraySelectedElementsOperator<T,I>
        extends UniqOperator<List<T[]>,I>,
                NavigableArrayOperator<T,I>,
    	        DistinguishableOperator<I>,
		        SortableOperator<T,I>,
                ExecutableArraySelectedOperator<T,I>,
                ReplaceableOperator<T[],I>,
                NavigatingCollectionOperator<T[],I>,
                ModifiableCollectionOperator<T,I>,
                SelectableOperator<T[],I> {



    public Level0ListOfArraySelectedOperator<T,I> endFor();


    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifIndex(final int... indices);
    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifNull();
    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifNotNull();
    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval);


            
    public Level2ListOfArraySelectedElementsElementsOperator<T,I> forEach(final Type<T> elementType);

    public Level1ListOfArraySelectedElementsOperator<T,I> distinct();
    
    public Level1ListOfArraySelectedElementsOperator<T,I> sort();
    public Level1ListOfArraySelectedElementsOperator<T,I> sort(final Comparator<? super T> comparator);
    
    public Level1ListOfArraySelectedElementsOperator<T,I> add(final T newElement);
    public Level1ListOfArraySelectedElementsOperator<T,I> addAll(final T... newElements);
    public Level1ListOfArraySelectedElementsOperator<T,I> insert(final int position, final T newElement);
    public Level1ListOfArraySelectedElementsOperator<T,I> insertAll(final int position, final T... newElements);
    public Level1ListOfArraySelectedElementsOperator<T,I> addAll(final Collection<T> collection);
    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllIndexes(final int... indices);
    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllEqual(final T... values);
    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllNull();
    
    
    public Level1ListOfArraySelectedElementsOperator<T,I> convert(final IConverter<? extends T[],? super T[]> converter);
    
    public Level1ListOfArraySelectedElementsOperator<T,I> eval(final IEvaluator<? extends T[],? super T[]> eval);

    public Level1ListOfArraySelectedElementsOperator<T,I> replaceWith(final T[] replacement);

    public Level1ListOfArraySelectedElementsOperator<T,I> exec(final IFunction<? extends T[], ? super T[]> function);
    
		            
}

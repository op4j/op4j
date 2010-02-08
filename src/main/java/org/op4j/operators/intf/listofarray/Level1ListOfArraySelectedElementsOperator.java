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
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArraySelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableArrayOperator;
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
public interface Level1ListOfArraySelectedElementsOperator<T>
        extends UniqOperator<List<T[]>>,
                NavigableArrayOperator<T>,
    	        DistinguishableOperator,
		        SortableOperator<T>,
                ExecutableArraySelectedOperator<T>,
                ReplaceableOperator<T[]>,
                NavigatingCollectionOperator<T[]>,
                ModifiableCollectionOperator<T>,
                SelectableOperator<T[]> {



    public Level0ListOfArraySelectedOperator<T> endFor();


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNull();
    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNotNull();
    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval);


            
    public Level2ListOfArraySelectedElementsElementsOperator<T> forEach(final Type<T> elementType);

    public Level1ListOfArraySelectedElementsOperator<T> distinct();
    
    public Level1ListOfArraySelectedElementsOperator<T> sort();
    public Level1ListOfArraySelectedElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ListOfArraySelectedElementsOperator<T> add(final T newElement);
    public Level1ListOfArraySelectedElementsOperator<T> addAll(final T... newElements);
    public Level1ListOfArraySelectedElementsOperator<T> insert(final int position, final T newElement);
    public Level1ListOfArraySelectedElementsOperator<T> insertAll(final int position, final T... newElements);
    public Level1ListOfArraySelectedElementsOperator<T> addAll(final Collection<T> collection);
    public Level1ListOfArraySelectedElementsOperator<T> removeAllIndexes(final int... indexes);
    public Level1ListOfArraySelectedElementsOperator<T> removeAllEqual(final T... values);
    public Level1ListOfArraySelectedElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArraySelectedElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArraySelectedElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArraySelectedElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArraySelectedElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArraySelectedElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArraySelectedElementsOperator<T> removeAllIndexesNot(final int... indexes);
    public Level1ListOfArraySelectedElementsOperator<T> removeAllNull();
    
    
    public Level1ListOfArraySelectedElementsOperator<T> convert(final IConverter<? extends T[],? super T[]> converter);
    
    public Level1ListOfArraySelectedElementsOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval);

    public Level1ListOfArraySelectedElementsOperator<T> replaceWith(final T[] replacement);

    public Level1ListOfArraySelectedElementsOperator<T> exec(final IFunction<? extends T[], ? super T[]> function);
    
		            
}

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
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1ListOfArrayElementsSelectedOperator<T>
        extends UniqOperator<List<T[]>>,
                NavigableArrayOperator<T>,
    	        DistinguishableOperator,
		        SortableOperator<T>,
                ExecutableArraySelectedOperator<T>,
                SelectedOperator<T[]>,
                ModifiableCollectionOperator<T> {



    public Level1ListOfArrayElementsOperator<T> endIf();


            
    public Level2ListOfArrayElementsSelectedElementsOperator<T> forEach(final Type<T> elementType);

    public Level1ListOfArrayElementsSelectedOperator<T> distinct();
    
    public Level1ListOfArrayElementsSelectedOperator<T> sort();
    public Level1ListOfArrayElementsSelectedOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ListOfArrayElementsSelectedOperator<T> add(final T... newElements);
    public Level1ListOfArrayElementsSelectedOperator<T> insert(final int position, final T... newElements);
    public Level1ListOfArrayElementsSelectedOperator<T> addAll(final Collection<T> collection);
    public Level1ListOfArrayElementsSelectedOperator<T> removeIndexes(final int... indices);
    public Level1ListOfArrayElementsSelectedOperator<T> removeEquals(final T... values);
    public Level1ListOfArrayElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsSelectedOperator<T> removeIndexesNot(final int... indices);
    public Level1ListOfArrayElementsSelectedOperator<T> removeNulls();
    
    
    public Level1ListOfArrayElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter);
    
    public Level1ListOfArrayElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval);

    public Level1ListOfArrayElementsSelectedOperator<T> exec(final IFunction<? extends T[], ? super T[]> function);
    
		            
}

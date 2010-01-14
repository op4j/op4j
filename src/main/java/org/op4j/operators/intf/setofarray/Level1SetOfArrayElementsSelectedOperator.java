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
import java.util.Set;import org.javaruntype.type.Type;


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
public interface Level1SetOfArrayElementsSelectedOperator<T>
        extends UniqOperator<Set<T[]>>,
                NavigableArrayOperator<T>,
    	        DistinguishableOperator,
		        SortableOperator<T>,
                ExecutableArraySelectedOperator<T>,
                SelectedOperator<T[]>,
                ModifiableCollectionOperator<T> {



    public Level1SetOfArrayElementsOperator<T> endIf();


            
    public Level2SetOfArrayElementsSelectedElementsOperator<T> forEach(final Type<T> elementType);

    public Level1SetOfArrayElementsSelectedOperator<T> distinct();
    
    public Level1SetOfArrayElementsSelectedOperator<T> sort();
    public Level1SetOfArrayElementsSelectedOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1SetOfArrayElementsSelectedOperator<T> add(final T... newElements);
    public Level1SetOfArrayElementsSelectedOperator<T> insert(final int position, final T... newElements);
    public Level1SetOfArrayElementsSelectedOperator<T> addAll(final Collection<T> collection);
    public Level1SetOfArrayElementsSelectedOperator<T> removeIndexes(final int... indices);
    public Level1SetOfArrayElementsSelectedOperator<T> removeEquals(final T... values);
    public Level1SetOfArrayElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> removeIndexesNot(final int... indices);
    public Level1SetOfArrayElementsSelectedOperator<T> removeNulls();
    
    
    public Level1SetOfArrayElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter);
    
    public Level1SetOfArrayElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval);

    public Level1SetOfArrayElementsSelectedOperator<T> exec(final IFunction<? extends T[], ? super T[]> function);
    
		            
}

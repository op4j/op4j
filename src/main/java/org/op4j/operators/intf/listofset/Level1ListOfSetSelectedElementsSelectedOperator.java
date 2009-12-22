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
package org.op4j.operators.intf.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
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
public interface Level1ListOfSetSelectedElementsSelectedOperator<T>
        extends UniqOperator<List<Set<T>>>,
                NavigableCollectionOperator<T>,
    	        DistinguishableOperator,
		        SortableOperator<T>,
                ExecutableSelectedOperator<Set<T>>,
                ConvertibleSelectedOperator<Set<T>>,
                EvaluableSelectedOperator<Set<T>>,
                SelectedOperator<Set<T>>,
                ModifiableCollectionOperator<T> {



    public Level1ListOfSetSelectedElementsOperator<T> endIf();


            
    public Level2ListOfSetSelectedElementsSelectedElementsOperator<T> forEach();

    public Level1ListOfSetSelectedElementsSelectedOperator<T> distinct();
    
    public Level1ListOfSetSelectedElementsSelectedOperator<T> sort();
    public Level1ListOfSetSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ListOfSetSelectedElementsSelectedOperator<T> add(final T... newElements);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> insert(final int position, final T... newElements);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeIndexes(final int... indices);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeEquals(final T... values);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeNulls();
    
    
    public Level1ListOfSetSelectedElementsSelectedOperator<T> convert(final IConverter<? extends Set<T>,? super Set<T>> converter);
    
    public Level1ListOfSetSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends Set<T>,? super Set<T>> eval);

    public Level1ListOfSetSelectedElementsSelectedOperator<T> exec(final IFunction<? extends Set<T>, ? super Set<T>> function);
    
		            
}

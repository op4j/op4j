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
package org.op4j.operators.intf.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ConvertibleSelectedOperator;
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
public interface Level1ArrayOfSetSelectedElementsOperator<T>
        extends UniqOperator<Set<T>[]>,
                NavigableCollectionOperator<T>,
    	        SortableOperator<T>,
                ExecutableSelectedOperator<Set<T>>,
                ConvertibleSelectedOperator<Set<T>>,
                EvaluableSelectedOperator<Set<T>>,
                NavigatingCollectionOperator<Set<T>>,
                ModifiableCollectionOperator<T>,
                SelectableOperator<Set<T>> {



    public Level0ArrayOfSetSelectedOperator<T> endFor();


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNull();
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotNull();
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval);


            
    public Level2ArrayOfSetSelectedElementsElementsOperator<T> forEach();

    public Level1ArrayOfSetSelectedElementsOperator<T> sort();
    public Level1ArrayOfSetSelectedElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ArrayOfSetSelectedElementsOperator<T> add(final T... newElements);
    public Level1ArrayOfSetSelectedElementsOperator<T> insert(final int position, final T... newElements);
    public Level1ArrayOfSetSelectedElementsOperator<T> addAll(final Collection<T> collection);
    public Level1ArrayOfSetSelectedElementsOperator<T> removeIndexes(final int... indices);
    public Level1ArrayOfSetSelectedElementsOperator<T> removeEquals(final T... values);
    public Level1ArrayOfSetSelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsOperator<T> removeIndexesNot(final int... indices);
    public Level1ArrayOfSetSelectedElementsOperator<T> removeNulls();
    
    
    public Level1ArrayOfSetSelectedElementsOperator<T> convert(final IConverter<? extends Set<T>,? super Set<T>> converter);
    
    public Level1ArrayOfSetSelectedElementsOperator<T> eval(final IEvaluator<? extends Set<T>,? super Set<T>> eval);

    public Level1ArrayOfSetSelectedElementsOperator<T> exec(final IFunction<? extends Set<T>, ? super Set<T>> function);
    
		            
}

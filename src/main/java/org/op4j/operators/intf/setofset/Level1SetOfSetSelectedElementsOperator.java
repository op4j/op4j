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
package org.op4j.operators.intf.setofset;

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
public interface Level1SetOfSetSelectedElementsOperator<T>
        extends UniqOperator<Set<Set<T>>>,
                NavigableCollectionOperator<T>,
    	        SortableOperator<T>,
                ExecutableSelectedOperator<Set<T>>,
                ConvertibleSelectedOperator<Set<T>>,
                EvaluableSelectedOperator<Set<T>>,
                NavigatingCollectionOperator<Set<T>>,
                ModifiableCollectionOperator<T>,
                SelectableOperator<Set<T>> {



    public Level0SetOfSetSelectedOperator<T> endFor();


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNull();
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNull();
    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval);


            
    public Level2SetOfSetSelectedElementsElementsOperator<T> forEach();

    public Level1SetOfSetSelectedElementsOperator<T> sort();
    public Level1SetOfSetSelectedElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1SetOfSetSelectedElementsOperator<T> add(final T... newElements);
    public Level1SetOfSetSelectedElementsOperator<T> insert(final int position, final T... newElements);
    public Level1SetOfSetSelectedElementsOperator<T> addAll(final Collection<T> collection);
    public Level1SetOfSetSelectedElementsOperator<T> removeIndexes(final int... indices);
    public Level1SetOfSetSelectedElementsOperator<T> removeEquals(final T... values);
    public Level1SetOfSetSelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetSelectedElementsOperator<T> removeIndexesNot(final int... indices);
    public Level1SetOfSetSelectedElementsOperator<T> removeNulls();
    
    
    public Level1SetOfSetSelectedElementsOperator<T> convert(final IConverter<? extends Set<T>,? super Set<T>> converter);
    
    public Level1SetOfSetSelectedElementsOperator<T> eval(final IEvaluator<? extends Set<T>,? super Set<T>> eval);

    public Level1SetOfSetSelectedElementsOperator<T> exec(final IFunction<? extends Set<T>, ? super Set<T>> function);
    
		            
}

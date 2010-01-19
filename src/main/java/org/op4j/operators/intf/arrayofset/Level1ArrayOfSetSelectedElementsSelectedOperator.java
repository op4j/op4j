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
import org.op4j.operators.qualities.ExecutableSetSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
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
public interface Level1ArrayOfSetSelectedElementsSelectedOperator<T>
        extends UniqOperator<Set<T>[]>,
                NavigableCollectionOperator<T>,
    	        SortableOperator<T>,
                ExecutableSetSelectedOperator<T>,
                ReplaceableOperator<Set<T>>,
                SelectedOperator<Set<T>>,
                ModifiableCollectionOperator<T> {



    public Level1ArrayOfSetSelectedElementsOperator<T> endIf();


            
    public Level2ArrayOfSetSelectedElementsSelectedElementsOperator<T> forEach();

    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> sort();
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> add(final T... newElements);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> insert(final int position, final T... newElements);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllIndexes(final int... indices);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllEqual(final T... values);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllIndexesNot(final int... indices);
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNull();
    
    
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter);
    
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval);

    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> replaceBy(final Set<T> replacement);

    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> exec(final IFunction<? extends Set<? extends T>, ? super Set<T>> function);
    
		            
}

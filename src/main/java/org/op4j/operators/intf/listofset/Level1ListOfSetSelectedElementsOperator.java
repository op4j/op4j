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
import org.op4j.operators.qualities.ExecutableSetSelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
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
public interface Level1ListOfSetSelectedElementsOperator<T>
        extends UniqOperator<List<Set<T>>>,
                NavigableCollectionOperator<T>,
    	        SortableOperator<T>,
                ExecutableSetSelectedOperator<T>,
                ReplaceableOperator<Set<T>>,
                NavigatingCollectionOperator<Set<T>>,
                ModifiableCollectionOperator<T>,
                SelectableOperator<Set<T>> {



    public Level0ListOfSetSelectedOperator<T> endFor();


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNull();
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNotNull();
    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval);


            
    public Level2ListOfSetSelectedElementsElementsOperator<T> forEach();

    public Level1ListOfSetSelectedElementsOperator<T> sort();
    public Level1ListOfSetSelectedElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ListOfSetSelectedElementsOperator<T> add(final T... newElements);
    public Level1ListOfSetSelectedElementsOperator<T> insert(final int position, final T... newElements);
    public Level1ListOfSetSelectedElementsOperator<T> addAll(final Collection<T> collection);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllIndexes(final int... indices);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllEqual(final T... values);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllIndexesNot(final int... indices);
    public Level1ListOfSetSelectedElementsOperator<T> removeAllNull();
    
    
    public Level1ListOfSetSelectedElementsOperator<T> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter);
    
    public Level1ListOfSetSelectedElementsOperator<T> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval);

    public Level1ListOfSetSelectedElementsOperator<T> replaceBy(final Set<T> replacement);

    public Level1ListOfSetSelectedElementsOperator<T> exec(final IFunction<? extends Set<? extends T>, ? super Set<T>> function);
    
		            
}

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
package org.op4j.operators.intf.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListSelectedOperator;
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
public interface Level1SetOfListSelectedElementsSelectedOperator<T>
        extends UniqOperator<Set<List<T>>>,
                NavigableCollectionOperator<T>,
    	        DistinguishableOperator,
		        SortableOperator<T>,
                ExecutableListSelectedOperator<T>,
                SelectedOperator<List<T>>,
                ModifiableCollectionOperator<T> {



    public Level1SetOfListSelectedElementsOperator<T> endIf();


            
    public Level2SetOfListSelectedElementsSelectedElementsOperator<T> forEach();

    public Level1SetOfListSelectedElementsSelectedOperator<T> distinct();
    
    public Level1SetOfListSelectedElementsSelectedOperator<T> sort();
    public Level1SetOfListSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1SetOfListSelectedElementsSelectedOperator<T> add(final T... newElements);
    public Level1SetOfListSelectedElementsSelectedOperator<T> insert(final int position, final T... newElements);
    public Level1SetOfListSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection);
    public Level1SetOfListSelectedElementsSelectedOperator<T> removeAllIndexes(final int... indices);
    public Level1SetOfListSelectedElementsSelectedOperator<T> removeAllEqual(final T... values);
    public Level1SetOfListSelectedElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListSelectedElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListSelectedElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListSelectedElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListSelectedElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListSelectedElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListSelectedElementsSelectedOperator<T> removeAllIndexesNot(final int... indices);
    public Level1SetOfListSelectedElementsSelectedOperator<T> removeAllNull();
    
    
    public Level1SetOfListSelectedElementsSelectedOperator<T> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter);
    
    public Level1SetOfListSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval);

    public Level1SetOfListSelectedElementsSelectedOperator<T> exec(final IFunction<? extends List<? extends T>, ? super List<T>> function);
    
		            
}

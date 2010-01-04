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
import org.op4j.operators.qualities.ConvertibleSelectedOperator;
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
public interface Level0SetOfListSelectedOperator<T>
        extends UniqOperator<Set<List<T>>>,
                NavigableCollectionOperator<List<T>>,
                SortableOperator<List<T>>,
                ModifiableCollectionOperator<List<T>>,
                ExecutableSelectedOperator<Set<List<T>>>,
                ConvertibleSelectedOperator<Set<List<T>>>,
                SelectedOperator<Set<List<T>>>,
                EvaluableSelectedOperator<Set<List<T>>> {



    public Level0SetOfListOperator<T> endIf();



    public Level1SetOfListSelectedElementsOperator<T> forEach();

    public Level0SetOfListSelectedOperator<T> sort();
    public Level0SetOfListSelectedOperator<T> sort(final Comparator<? super List<T>> comparator);


    public Level0SetOfListSelectedOperator<T> add(final List<T>... newElements);
    public Level0SetOfListSelectedOperator<T> insert(final int position, final List<T>... newElements);
    public Level0SetOfListSelectedOperator<T> addAll(final Collection<List<T>> collection);
    public Level0SetOfListSelectedOperator<T> removeIndexes(final int... indices);
    public Level0SetOfListSelectedOperator<T> removeEquals(final List<T>... values);
    public Level0SetOfListSelectedOperator<T> removeMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListSelectedOperator<T> removeIndexesNot(final int... indices);
    public Level0SetOfListSelectedOperator<T> removeNulls();



    
    public Level0SetOfListSelectedOperator<T> convert(final IConverter<? extends Set<List<T>>,? super Set<List<T>>> converter);
    
    public Level0SetOfListSelectedOperator<T> eval(final IEvaluator<? extends Set<List<T>>,? super Set<List<T>>> eval);

    public Level0SetOfListSelectedOperator<T> exec(final IFunction<? extends Set<List<T>>, ? super Set<List<T>>> function);

    
}

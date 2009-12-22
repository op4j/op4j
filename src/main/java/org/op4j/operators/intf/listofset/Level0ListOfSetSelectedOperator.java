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
public interface Level0ListOfSetSelectedOperator<T>
        extends UniqOperator<List<Set<T>>>,
                NavigableCollectionOperator<Set<T>>,
                DistinguishableOperator,
                SortableOperator<Set<T>>,
                ModifiableCollectionOperator<Set<T>>,
                ExecutableSelectedOperator<List<Set<T>>>,
                ConvertibleSelectedOperator<List<Set<T>>>,
                SelectedOperator<List<Set<T>>>,
                EvaluableSelectedOperator<List<Set<T>>> {



    public Level0ListOfSetOperator<T> endIf();



    public Level1ListOfSetSelectedElementsOperator<T> forEach();

    public Level0ListOfSetSelectedOperator<T> distinct();
    
    public Level0ListOfSetSelectedOperator<T> sort();
    public Level0ListOfSetSelectedOperator<T> sort(final Comparator<? super Set<T>> comparator);


    public Level0ListOfSetSelectedOperator<T> add(final Set<T>... newElements);
    public Level0ListOfSetSelectedOperator<T> insert(final int position, final Set<T>... newElements);
    public Level0ListOfSetSelectedOperator<T> addAll(final Collection<Set<T>> collection);
    public Level0ListOfSetSelectedOperator<T> removeIndexes(final int... indices);
    public Level0ListOfSetSelectedOperator<T> removeEquals(final Set<T>... values);
    public Level0ListOfSetSelectedOperator<T> removeMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetSelectedOperator<T> removeIndexesNot(final int... indices);
    public Level0ListOfSetSelectedOperator<T> removeNulls();



    
    public Level0ListOfSetSelectedOperator<T> convert(final IConverter<? extends List<Set<T>>,? super List<Set<T>>> converter);
    
    public Level0ListOfSetSelectedOperator<T> eval(final IEvaluator<? extends List<Set<T>>,? super List<Set<T>>> eval);

    public Level0ListOfSetSelectedOperator<T> exec(final IFunction<? extends List<Set<T>>, ? super List<Set<T>>> function);

    
}

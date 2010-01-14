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
package org.op4j.operators.intf.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOfListSelectedOperator;
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
public interface Level0ArrayOfListSelectedOperator<T>
        extends UniqOperator<List<T>[]>,
                NavigableCollectionOperator<List<T>>,
                DistinguishableOperator,
                SortableOperator<List<T>>,
                ModifiableCollectionOperator<List<T>>,
                ExecutableArrayOfListSelectedOperator<T>,
                SelectedOperator<List<T>[]> {



    public Level0ArrayOfListOperator<T> endIf();



    public Level1ArrayOfListSelectedElementsOperator<T> forEach();

    public Level0ArrayOfListSelectedOperator<T> distinct();
    
    public Level0ArrayOfListSelectedOperator<T> sort();
    public Level0ArrayOfListSelectedOperator<T> sort(final Comparator<? super List<T>> comparator);


    public Level0ArrayOfListSelectedOperator<T> add(final List<T>... newElements);
    public Level0ArrayOfListSelectedOperator<T> insert(final int position, final List<T>... newElements);
    public Level0ArrayOfListSelectedOperator<T> addAll(final Collection<List<T>> collection);
    public Level0ArrayOfListSelectedOperator<T> removeIndexes(final int... indices);
    public Level0ArrayOfListSelectedOperator<T> removeEquals(final List<T>... values);
    public Level0ArrayOfListSelectedOperator<T> removeMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ArrayOfListSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ArrayOfListSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ArrayOfListSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ArrayOfListSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ArrayOfListSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ArrayOfListSelectedOperator<T> removeIndexesNot(final int... indices);
    public Level0ArrayOfListSelectedOperator<T> removeNulls();



    
    public Level0ArrayOfListSelectedOperator<T> convert(final IConverter<? extends List<? extends T>[],? super List<T>[]> converter);
    
    public Level0ArrayOfListSelectedOperator<T> eval(final IEvaluator<? extends List<? extends T>[],? super List<T>[]> eval);

    public Level0ArrayOfListSelectedOperator<T> exec(final IFunction<? extends List<? extends T>[], ? super List<T>[]> function);

    
}

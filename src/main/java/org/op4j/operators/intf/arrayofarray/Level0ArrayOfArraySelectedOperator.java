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
package org.op4j.operators.intf.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOfArraySelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableArrayOperator;
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
public interface Level0ArrayOfArraySelectedOperator<T>
        extends UniqOperator<T[][]>,
                NavigableArrayOperator<T[]>,
                DistinguishableOperator,
                SortableOperator<T[]>,
                ModifiableCollectionOperator<T[]>,
                ExecutableArrayOfArraySelectedOperator<T>,
                ReplaceableOperator<T[][]>,
                SelectedOperator<T[][]> {



    public Level0ArrayOfArrayOperator<T> endIf();



    public Level1ArrayOfArraySelectedElementsOperator<T> forEach(final Type<T[]> elementType);

    public Level0ArrayOfArraySelectedOperator<T> distinct();
    
    public Level0ArrayOfArraySelectedOperator<T> sort();
    public Level0ArrayOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator);


    public Level0ArrayOfArraySelectedOperator<T> add(final T[] newElement);
    public Level0ArrayOfArraySelectedOperator<T> addAll(final T[]... newElements);
    public Level0ArrayOfArraySelectedOperator<T> insert(final int position, final T[] newElement);
    public Level0ArrayOfArraySelectedOperator<T> insertAll(final int position, final T[]... newElements);
    public Level0ArrayOfArraySelectedOperator<T> addAll(final Collection<T[]> collection);
    public Level0ArrayOfArraySelectedOperator<T> removeAllIndexes(final int... indices);
    public Level0ArrayOfArraySelectedOperator<T> removeAllEqual(final T[]... values);
    public Level0ArrayOfArraySelectedOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArraySelectedOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArraySelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArraySelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArraySelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArraySelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArraySelectedOperator<T> removeAllIndexesNot(final int... indices);
    public Level0ArrayOfArraySelectedOperator<T> removeAllNull();



    
    public Level0ArrayOfArraySelectedOperator<T> convert(final IConverter<? extends T[][],? super T[][]> converter);
    
    public Level0ArrayOfArraySelectedOperator<T> eval(final IEvaluator<? extends T[][],? super T[][]> eval);

    public Level0ArrayOfArraySelectedOperator<T> replaceWith(final T[][] replacement);

    public Level0ArrayOfArraySelectedOperator<T> exec(final IFunction<? extends T[][], ? super T[][]> function);

    
}

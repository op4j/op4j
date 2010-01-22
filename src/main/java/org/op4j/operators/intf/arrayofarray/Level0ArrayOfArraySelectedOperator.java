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
import org.op4j.operators.qualities.SelectedOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level0ArrayOfArraySelectedOperator<T,I>
        extends UniqOperator<T[][],I>,
                NavigableArrayOperator<T[],I>,
                DistinguishableOperator<I>,
                SortableOperator<T[],I>,
                ModifiableCollectionOperator<T[],I>,
                ExecutableArrayOfArraySelectedOperator<T,I>,
                ReplaceableOperator<T[][],I>,
                SelectedOperator<T[][],I> {



    public Level0ArrayOfArrayOperator<T,I> endIf();



    public Level1ArrayOfArraySelectedElementsOperator<T,I> forEach(final Type<T[]> elementType);

    public Level0ArrayOfArraySelectedOperator<T,I> distinct();
    
    public Level0ArrayOfArraySelectedOperator<T,I> sort();
    public Level0ArrayOfArraySelectedOperator<T,I> sort(final Comparator<? super T[]> comparator);


    public Level0ArrayOfArraySelectedOperator<T,I> add(final T[] newElement);
    public Level0ArrayOfArraySelectedOperator<T,I> addAll(final T[]... newElements);
    public Level0ArrayOfArraySelectedOperator<T,I> insert(final int position, final T[] newElement);
    public Level0ArrayOfArraySelectedOperator<T,I> insertAll(final int position, final T[]... newElements);
    public Level0ArrayOfArraySelectedOperator<T,I> addAll(final Collection<T[]> collection);
    public Level0ArrayOfArraySelectedOperator<T,I> removeAllIndexes(final int... indices);
    public Level0ArrayOfArraySelectedOperator<T,I> removeAllEqual(final T[]... values);
    public Level0ArrayOfArraySelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArraySelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArraySelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArraySelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArraySelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArraySelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArraySelectedOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level0ArrayOfArraySelectedOperator<T,I> removeAllNull();



    
    public Level0ArrayOfArraySelectedOperator<T,I> convert(final IConverter<? extends T[][],? super T[][]> converter);
    
    public Level0ArrayOfArraySelectedOperator<T,I> eval(final IEvaluator<? extends T[][],? super T[][]> eval);

    public Level0ArrayOfArraySelectedOperator<T,I> replaceWith(final T[][] replacement);

    public Level0ArrayOfArraySelectedOperator<T,I> exec(final IFunction<? extends T[][], ? super T[][]> function);

    
}

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
package org.op4j.operators.intf.array;

import java.util.Collection;
import java.util.Comparator;

import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArraySelectedOperator;
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
public interface Level0ArraySelectedOperator<T>
        extends UniqOperator<T[]>,
                NavigableCollectionOperator<T>,
                DistinguishableOperator,
                SortableOperator<T>,
                ModifiableCollectionOperator<T>,
                SelectedOperator<T[]>,
                ExecutableArraySelectedOperator<T>,
                ReplaceableOperator<T[]> {



    public Level0ArrayOperator<T> endIf();



    public Level1ArraySelectedElementsOperator<T> forEach();

    public Level0ArraySelectedOperator<T> distinct();
    
    public Level0ArraySelectedOperator<T> sort();
    public Level0ArraySelectedOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level0ArraySelectedOperator<T> add(final T newElement);
    public Level0ArraySelectedOperator<T> addAll(final T... newElements);
    public Level0ArraySelectedOperator<T> insert(final int position, final T newElement);
    public Level0ArraySelectedOperator<T> insertAll(final int position, final T... newElements);
    public Level0ArraySelectedOperator<T> addAll(final Collection<T> collection);
    public Level0ArraySelectedOperator<T> removeAllIndexes(final int... indexes);
    public Level0ArraySelectedOperator<T> removeAllEqual(final T... values);
    public Level0ArraySelectedOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ArraySelectedOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ArraySelectedOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ArraySelectedOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ArraySelectedOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ArraySelectedOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ArraySelectedOperator<T> removeAllIndexesNot(final int... indexes);
    public Level0ArraySelectedOperator<T> removeAllNull();
    
    
    public Level0ArraySelectedOperator<T> execIfNotNullAsArray(final IFunction<? extends T[],? super T[]> function);

    public Level0ArraySelectedOperator<T> replaceWith(final T[] replacement);

    public Level0ArraySelectedOperator<T> execAsArray(final IFunction<? extends T[], ? super T[]> function);


    public Level0ArraySelectedOperator<T> map(final IFunction<? extends T, ? super T> function);

    public Level0ArraySelectedOperator<T> mapIfNotNull(final IFunction<? extends T, ? super T> function);
    
    
}

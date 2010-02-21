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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOperator;
import org.op4j.operators.qualities.GenerizableOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
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
public interface Level0ArrayOperator<T>
        extends UniqOperator<T[]>,
                NavigableCollectionOperator<T>,
		        DistinguishableOperator,
		        SortableOperator<T>,
		        CastableToArrayOperator,
		        ModifiableCollectionOperator<T>,
		        SelectableOperator<T[]>,
                ReplaceableOperator<T[]>,
                ReplaceableIfNullOperator<T[]>,
                GenerizableOperator<T[]>,
		        ExecutableArrayOperator<T>,
		        ConvertibleToListOperator,
		        ConvertibleToSetOperator,
		        ConvertibleToMapOperator<T> {



    public Level0ArraySelectedOperator<T> ifIndex(final int... indexes);
    public Level0ArraySelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T> ifNull();
    public Level0ArraySelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T> ifIndexNot(final int... indexes);
    public Level0ArraySelectedOperator<T> ifNotNull();
    public Level0ArraySelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T[]> eval);



    public Level1ArrayElementsOperator<T> forEach();

    public Level0ArrayOperator<T> distinct();
    
    public Level0ArrayOperator<T> sort();
    public Level0ArrayOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level0ArrayOperator<T> add(final T newElement);
    public Level0ArrayOperator<T> addAll(final T... newElements);
    public Level0ArrayOperator<T> insert(final int position, final T newElement);
    public Level0ArrayOperator<T> insertAll(final int position, final T... newElements);
    public Level0ArrayOperator<T> addAll(final Collection<T> collection);
    public Level0ArrayOperator<T> removeAllIndexes(final int... indexes);
    public Level0ArrayOperator<T> removeAllEqual(final T... values);
    public Level0ArrayOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ArrayOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ArrayOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ArrayOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ArrayOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ArrayOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ArrayOperator<T> removeAllIndexesNot(final int... indexes);
    public Level0ArrayOperator<T> removeAllNull();
    public Level0ListOperator<T> toList();
    
    public Level0SetOperator<T> toSet();
    
    public Level0MapOperator<T,T> toMap();
    public <K> Level0MapOperator<K,T> toMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public Level0GenericUniqOperator<T[]> generic();

    
    
    public Level0ArrayOperator<T> replaceWith(final T[] replacement);
    public Level0ArrayOperator<T> replaceIfNullWith(final T[] replacement);


    public Level0ArrayOperator<T> execIfNotNullAsArray(final IFunction<? extends T[],? super T[]> function);

    public Level0ArrayOperator<T> execAsArray(final IFunction<? extends T[], ? super T[]> function);

    public <X> Level0ArrayOperator<X> execAsArrayOf(final Type<X> type, final IFunction<X[], ? super T[]> function);

    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super T[]> function);
    
    public <X> Level0ArrayOperator<X> map(final Type<X> type, final IFunction<X,? super T> function);
    
    public Level0ArrayOperator<T> map(final IFunction<? extends T,? super T> function);
    
    public Level0ArrayOperator<T> mapIfNotNull(final IFunction<? extends T,? super T> function);
    

    
    public <X> Level0ArrayOperator<X> asArrayOf(final Type<X> type);
    public Level0ArrayOperator<?> asArrayOfUnknown();
    

    
}

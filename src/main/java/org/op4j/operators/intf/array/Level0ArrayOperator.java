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
public interface Level0ArrayOperator<T,I>
        extends UniqOperator<T[]>,
                NavigableCollectionOperator<T>,
		        DistinguishableOperator,
		        SortableOperator<T>,
		        CastableToArrayOperator,
		        ModifiableCollectionOperator<T>,
		        SelectableOperator<T[]>,
                ReplaceableOperator<T[]>,
                ReplaceableIfNullOperator<T[]>,
                GenerizableOperator<T[],I>,
		        ExecutableArrayOperator<T>,
		        ConvertibleToListOperator,
		        ConvertibleToSetOperator,
		        ConvertibleToMapOperator<T> {



    public Level0ArraySelectedOperator<T,I> ifIndex(final int... indexes);
    public Level0ArraySelectedOperator<T,I> ifTrue(final IFunction<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T,I> ifFalse(final IFunction<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T,I> ifNull();
    public Level0ArraySelectedOperator<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T,I> ifIndexNot(final int... indexes);
    public Level0ArraySelectedOperator<T,I> ifNotNull();
    public Level0ArraySelectedOperator<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T[]> eval);



    public Level1ArrayElementsOperator<T,I> forEach();

    public Level0ArrayOperator<T,I> distinct();
    
    public Level0ArrayOperator<T,I> sort();
    public Level0ArrayOperator<T,I> sort(final Comparator<? super T> comparator);
        
    public Level0ArrayOperator<T,I> add(final T newElement);
    public Level0ArrayOperator<T,I> addAll(final T... newElements);
    public Level0ArrayOperator<T,I> insert(final int position, final T newElement);
    public Level0ArrayOperator<T,I> insertAll(final int position, final T... newElements);
    public Level0ArrayOperator<T,I> addAll(final Collection<T> collection);
    public Level0ArrayOperator<T,I> removeAllIndexes(final int... indexes);
    public Level0ArrayOperator<T,I> removeAllEqual(final T... values);
    public Level0ArrayOperator<T,I> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ArrayOperator<T,I> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ArrayOperator<T,I> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ArrayOperator<T,I> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ArrayOperator<T,I> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ArrayOperator<T,I> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ArrayOperator<T,I> removeAllIndexesNot(final int... indexes);
    public Level0ArrayOperator<T,I> removeAllNull();
    public Level0ListOperator<T,I> toList();
    
    public Level0SetOperator<T,I> toSet();
    
    public Level0MapOperator<T,T,I> toMap();
    public <K> Level0MapOperator<K,T,I> toMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V,I> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public Level0GenericUniqOperator<T[],I> generic();

    
    
    public Level0ArrayOperator<T,I> replaceWith(final T[] replacement);
    public Level0ArrayOperator<T,I> replaceIfNullWith(final T[] replacement);


    public Level0ArrayOperator<T,I> execIfNotNullAsArray(final IFunction<? extends T[],? super T[]> function);

    public Level0ArrayOperator<T,I> execAsArray(final IFunction<? extends T[], ? super T[]> function);

    public <X> Level0ArrayOperator<X,I> execAsArrayOf(final Type<X> type, final IFunction<X[], ? super T[]> function);

    public <X> Level0GenericUniqOperator<X,I> exec(final IFunction<X, ? super T[]> function);
    
    public <X> Level0ArrayOperator<X,I> map(final Type<X> type, final IFunction<X,? super T> function);
    
    public Level0ArrayOperator<T,I> map(final IFunction<? extends T,? super T> function);
    
    public Level0ArrayOperator<T,I> mapIfNotNull(final IFunction<? extends T,? super T> function);
    

    
    public <X> Level0ArrayOperator<X,I> asArrayOf(final Type<X> type);
    }

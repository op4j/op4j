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
public interface Level0ArrayOperator<I,T>
        extends UniqOperator<T[]>,
                NavigableCollectionOperator<T>,
		        DistinguishableOperator,
		        SortableOperator<T>,
		        CastableToArrayOperator,
		        ModifiableCollectionOperator<T>,
		        SelectableOperator<T[]>,
                ReplaceableOperator<T[]>,
                ReplaceableIfNullOperator<T[]>,
                GenerizableOperator<I,T[]>,
		        ExecutableArrayOperator<T>,
		        ConvertibleToListOperator,
		        ConvertibleToSetOperator,
		        ConvertibleToMapOperator<T> {



    public Level0ArraySelectedOperator<I,T> ifIndex(final int... indexes);
    public Level0ArraySelectedOperator<I,T> ifTrue(final IFunction<? super T[],Boolean> eval);
    public Level0ArraySelectedOperator<I,T> ifFalse(final IFunction<? super T[],Boolean> eval);
    public Level0ArraySelectedOperator<I,T> ifNullOrFalse(final IFunction<? super T[],Boolean> eval);
    public Level0ArraySelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super T[],Boolean> eval);
    public Level0ArraySelectedOperator<I,T> ifNull();
    public Level0ArraySelectedOperator<I,T> ifNullOrTrue(final IFunction<? super T[],Boolean> eval);
    public Level0ArraySelectedOperator<I,T> ifIndexNot(final int... indexes);
    public Level0ArraySelectedOperator<I,T> ifNotNull();
    public Level0ArraySelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super T[],Boolean> eval);



    public Level1ArrayElementsOperator<I,T> forEach();

    public Level0ArrayOperator<I,T> distinct();
    
    public Level0ArrayOperator<I,T> sort();
    public Level0ArrayOperator<I,T> sort(final Comparator<? super T> comparator);
        
    public Level0ArrayOperator<I,T> add(final T newElement);
    public Level0ArrayOperator<I,T> addAll(final T... newElements);
    public Level0ArrayOperator<I,T> insert(final int position, final T newElement);
    public Level0ArrayOperator<I,T> insertAll(final int position, final T... newElements);
    public Level0ArrayOperator<I,T> addAll(final Collection<T> collection);
    public Level0ArrayOperator<I,T> removeAllIndexes(final int... indexes);
    public Level0ArrayOperator<I,T> removeAllEqual(final T... values);
    public Level0ArrayOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval);
    public Level0ArrayOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval);
    public Level0ArrayOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval);
    public Level0ArrayOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public Level0ArrayOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval);
    public Level0ArrayOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval);
    public Level0ArrayOperator<I,T> removeAllIndexesNot(final int... indexes);
    public Level0ArrayOperator<I,T> removeAllNull();
    public Level0ListOperator<I,T> toList();
    
    public Level0SetOperator<I,T> toSet();
    
    public Level0MapOperator<I,T,T> toMapByAlternateElements();
    public <K> Level0MapOperator<I,K,T> toMapByKeyEval(final IFunction<? super T,K> keyEval);
    public <K,V> Level0MapOperator<I,K,V> toMap(final IMapBuilder<? super T,K,V> mapBuilder);
    
    
    public Level0GenericUniqOperator<I,T[]> generic();

    
    
    public Level0ArrayOperator<I,T> replaceWith(final T[] replacement);
    public Level0ArrayOperator<I,T> replaceIfNullWith(final T[] replacement);


    public Level0ArrayOperator<I,T> execIfNotNullAsArray(final IFunction<? super T[],? extends T[]> function);

    public Level0ArrayOperator<I,T> execAsArray(final IFunction<? super T[],? extends T[]> function);

    public <X> Level0ArrayOperator<I,X> execAsArrayOf(final Type<X> type, final IFunction<? super T[],X[]> function);

    public <X> Level0GenericUniqOperator<I,X> exec(final IFunction<? super T[],X> function);
    
    public <X> Level0ArrayOperator<I,X> map(final Type<X> type, final IFunction<? super T,X> function);
    
    public Level0ArrayOperator<I,T> map(final IFunction<? super T,? extends T> function);
    
    public Level0ArrayOperator<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function);
    

    
    public <X> Level0ArrayOperator<I,X> asArrayOf(final Type<X> type);
    }

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
package org.op4j.operators.f.intf.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.op.intf.array.Level0ArrayOperator;
import org.op4j.operators.op.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.op.intf.map.Level0MapOperator;
import org.op4j.operators.op.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListOperator;
import org.op4j.operators.qualities.GenerizableOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOpOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level0ListOperator<T,I>
        extends UniqOpOperator<List<T>>,
                NavigableCollectionOperator<T>,
		        DistinguishableOperator,
		        SortableOperator<T>,
                CastableToListOperator,
		        ModifiableCollectionOperator<T>,
		        GenerizableOperator<List<T>,I>,
                ExecutableListOperator<T>,
                SelectableOperator<List<T>>,
                ReplaceableOperator<List<T>>,
                ReplaceableIfNullOperator<List<T>>,
                ConvertibleToArrayOperator<T>,
		        ConvertibleToSetOperator,
                ConvertibleToMapOperator<T> {



    public Level0ListSelectedOperator<T,I> ifIndex(final int... indexes);
    public Level0ListSelectedOperator<T,I> ifTrue(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T,I> ifFalse(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T,I> ifNullOrFalse(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T,I> ifNull();
    public Level0ListSelectedOperator<T,I> ifNullOrTrue(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T,I> ifIndexNot(final int... indexes);
    public Level0ListSelectedOperator<T,I> ifNotNull();
    public Level0ListSelectedOperator<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super List<T>> eval);



    public Level1ListElementsOperator<T,I> forEach();

    public Level0ListOperator<T,I> distinct();
    
    public Level0ListOperator<T,I> sort();
    public Level0ListOperator<T,I> sort(final Comparator<? super T> comparator);
        
    public Level0ListOperator<T,I> add(final T newElement);
    public Level0ListOperator<T,I> addAll(final T... newElements);
    public Level0ListOperator<T,I> insert(final int position, final T newElement);
    public Level0ListOperator<T,I> insertAll(final int position, final T... newElements);
    public Level0ListOperator<T,I> addAll(final Collection<T> collection);
    public Level0ListOperator<T,I> removeAllIndexes(final int... indexes);
    public Level0ListOperator<T,I> removeAllEqual(final T... values);
    public Level0ListOperator<T,I> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ListOperator<T,I> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ListOperator<T,I> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ListOperator<T,I> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ListOperator<T,I> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ListOperator<T,I> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ListOperator<T,I> removeAllIndexesNot(final int... indexes);
    public Level0ListOperator<T,I> removeAllNull();
    public Level0ArrayOperator<T,I> toArrayOf(final Type<T> type);
    
    
    public Level0SetOperator<T,I> toSet();
    
    public Level0MapOperator<T,T,I> toMap();
    public <K> Level0MapOperator<K,T,I> toMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V,I> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level0GenericUniqOperator<List<T>,I> generic();
    
    
    
    
    public Level0ListOperator<T,I> replaceWith(final List<T> replacement);
    public Level0ListOperator<T,I> replaceIfNullWith(final List<T> replacement);


    public Level0ListOperator<T,I> execIfNotNullAsList(final IFunction<? extends List<? extends T>,? super List<T>> function);

    public <X> Level0ListOperator<X,I> execAsList(final IFunction<? extends List<X>, ? super List<T>> function);

    public <X> Level0GenericUniqOperator<X,I> exec(final IFunction<X, ? super List<T>> function);
    
    public <X> Level0ListOperator<X,I> map(final IFunction<X,? super T> function);
    
    public Level0ListOperator<T,I> mapIfNotNull(final IFunction<? extends T,? super T> function);
    

    
    public <X> Level0ListOperator<X,I> asListOf(final Type<X> type);
    }

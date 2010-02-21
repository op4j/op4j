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
package org.op4j.operators.intf.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
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
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level0ListOperator<T>
        extends UniqOperator<List<T>>,
                NavigableCollectionOperator<T>,
		        DistinguishableOperator,
		        SortableOperator<T>,
                CastableToListOperator,
		        ModifiableCollectionOperator<T>,
		        GenerizableOperator<List<T>>,
                ExecutableListOperator<T>,
                SelectableOperator<List<T>>,
                ReplaceableOperator<List<T>>,
                ReplaceableIfNullOperator<List<T>>,
                ConvertibleToArrayOperator<T>,
		        ConvertibleToSetOperator,
                ConvertibleToMapOperator<T> {



    public Level0ListSelectedOperator<T> ifIndex(final int... indexes);
    public Level0ListSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T> ifNull();
    public Level0ListSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level0ListSelectedOperator<T> ifNotNull();
    public Level0ListSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super List<T>> eval);



    public Level1ListElementsOperator<T> forEach();

    public Level0ListOperator<T> distinct();
    
    public Level0ListOperator<T> sort();
    public Level0ListOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level0ListOperator<T> add(final T newElement);
    public Level0ListOperator<T> addAll(final T... newElements);
    public Level0ListOperator<T> insert(final int position, final T newElement);
    public Level0ListOperator<T> insertAll(final int position, final T... newElements);
    public Level0ListOperator<T> addAll(final Collection<T> collection);
    public Level0ListOperator<T> removeAllIndexes(final int... indexes);
    public Level0ListOperator<T> removeAllEqual(final T... values);
    public Level0ListOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ListOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ListOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ListOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level0ListOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ListOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level0ListOperator<T> removeAllIndexesNot(final int... indexes);
    public Level0ListOperator<T> removeAllNull();
    public Level0ArrayOperator<T> toArrayOf(final Type<T> type);
    
    
    public Level0SetOperator<T> toSet();
    
    public Level0MapOperator<T,T> toMap();
    public <K> Level0MapOperator<K,T> toMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level0GenericUniqOperator<List<T>> generic();
    
    
    
    
    public Level0ListOperator<T> replaceWith(final List<T> replacement);
    public Level0ListOperator<T> replaceIfNullWith(final List<T> replacement);


    public Level0ListOperator<T> execIfNotNullAsList(final IFunction<? extends List<? extends T>,? super List<T>> function);

    public <X> Level0ListOperator<X> execAsList(final IFunction<? extends List<X>, ? super List<T>> function);

    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super List<T>> function);
    
    public <X> Level0ListOperator<X> map(final IFunction<X,? super T> function);
    
    public Level0ListOperator<T> mapIfNotNull(final IFunction<? extends T,? super T> function);
    

    
    public <X> Level0ListOperator<X> asListOf(final Type<X> type);
    }

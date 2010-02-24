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
package org.op4j.operators.op.intf.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.op.intf.array.Level0ArrayOperator;
import org.op4j.operators.op.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.op.intf.list.Level0ListOperator;
import org.op4j.operators.op.intf.map.Level0MapOperator;
import org.op4j.operators.qualities.CastableToSetOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ExecutableSetOperator;
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
public interface Level0SetOperator<T,I>
        extends UniqOpOperator<Set<T>>,
                NavigableCollectionOperator<T>,
		        SortableOperator<T>,
                CastableToSetOperator,
		        ModifiableCollectionOperator<T>,
		        GenerizableOperator<Set<T>,I>,
                ExecutableSetOperator<T>,
                SelectableOperator<Set<T>>,
                ReplaceableOperator<Set<T>>,
                ReplaceableIfNullOperator<Set<T>>,
                ConvertibleToArrayOperator<T>,
		        ConvertibleToListOperator,
                ConvertibleToMapOperator<T> {



    public Level0SetSelectedOperator<T,I> ifIndex(final int... indexes);
    public Level0SetSelectedOperator<T,I> ifTrue(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T,I> ifFalse(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T,I> ifNullOrFalse(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T,I> ifNull();
    public Level0SetSelectedOperator<T,I> ifNullOrTrue(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T,I> ifIndexNot(final int... indexes);
    public Level0SetSelectedOperator<T,I> ifNotNull();
    public Level0SetSelectedOperator<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super Set<T>> eval);


    
    public Level1SetElementsOperator<T,I> forEach();
    
    public Level0SetOperator<T,I> sort();
    public Level0SetOperator<T,I> sort(final Comparator<? super T> comparator);
        
    public Level0SetOperator<T,I> add(final T newElement);
    public Level0SetOperator<T,I> addAll(final T... newElements);
    public Level0SetOperator<T,I> insert(final int position, final T newElement);
    public Level0SetOperator<T,I> insertAll(final int position, final T... newElements);
    public Level0SetOperator<T,I> addAll(final Collection<T> collection);
    public Level0SetOperator<T,I> removeAllIndexes(final int... indexes);
    public Level0SetOperator<T,I> removeAllEqual(final T... values);
    public Level0SetOperator<T,I> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level0SetOperator<T,I> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level0SetOperator<T,I> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level0SetOperator<T,I> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level0SetOperator<T,I> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level0SetOperator<T,I> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level0SetOperator<T,I> removeAllIndexesNot(final int... indexes);
    public Level0SetOperator<T,I> removeAllNull();
    public Level0ArrayOperator<T,I> toArrayOf(final Type<T> type);
    
    
    public Level0ListOperator<T,I> toList();
    
    public Level0MapOperator<T,T,I> toMap();
    public <K> Level0MapOperator<K,T,I> toMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V,I> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public Level0GenericUniqOperator<Set<T>,I> generic();
    
    
    public Level0SetOperator<T,I> replaceWith(final Set<T> replacement);
    public Level0SetOperator<T,I> replaceIfNullWith(final Set<T> replacement);


    public Level0SetOperator<T,I> execIfNotNullAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function);

    public <X> Level0SetOperator<X,I> execAsSet(final IFunction<? extends Set<X>,? super Set<T>> function);

    public <X> Level0GenericUniqOperator<X,I> exec(final IFunction<X, ? super Set<T>> function);
    
    public <X> Level0SetOperator<X,I> map(final IFunction<X,? super T> function);
    
    public Level0SetOperator<T,I> mapIfNotNull(final IFunction<? extends T,? super T> function);
    

    
    public <X> Level0SetOperator<X,I> asSetOf(final Type<X> type);
    }

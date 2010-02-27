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
package org.op4j.operators.intf.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
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
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level0SetOperator<I,T>
        extends UniqOperator<Set<T>>,
                NavigableCollectionOperator<T>,
		        SortableOperator<T>,
                CastableToSetOperator,
		        ModifiableCollectionOperator<T>,
		        GenerizableOperator<I,Set<T>>,
                ExecutableSetOperator<T>,
                SelectableOperator<Set<T>>,
                ReplaceableOperator<Set<T>>,
                ReplaceableIfNullOperator<Set<T>>,
                ConvertibleToArrayOperator<T>,
		        ConvertibleToListOperator,
                ConvertibleToMapOperator<T> {



    public Level0SetSelectedOperator<I,T> ifTrue(final IFunction<? super Set<T>,Boolean> eval);
    public Level0SetSelectedOperator<I,T> ifFalse(final IFunction<? super Set<T>,Boolean> eval);
    public Level0SetSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super Set<T>,Boolean> eval);
    public Level0SetSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super Set<T>,Boolean> eval);
    public Level0SetSelectedOperator<I,T> ifNull();
    public Level0SetSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super Set<T>,Boolean> eval);
    public Level0SetSelectedOperator<I,T> ifNotNull();
    public Level0SetSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super Set<T>,Boolean> eval);


    
    public Level1SetElementsOperator<I,T> forEach();
    
    public Level0SetOperator<I,T> sort();
    public Level0SetOperator<I,T> sort(final Comparator<? super T> comparator);
        
    public Level0SetOperator<I,T> add(final T newElement);
    public Level0SetOperator<I,T> addAll(final T... newElements);
    public Level0SetOperator<I,T> insert(final int position, final T newElement);
    public Level0SetOperator<I,T> insertAll(final int position, final T... newElements);
    public Level0SetOperator<I,T> addAll(final Collection<T> collection);
    public Level0SetOperator<I,T> removeAllIndexes(final int... indexes);
    public Level0SetOperator<I,T> removeAllEqual(final T... values);
    public Level0SetOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval);
    public Level0SetOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval);
    public Level0SetOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval);
    public Level0SetOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public Level0SetOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval);
    public Level0SetOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval);
    public Level0SetOperator<I,T> removeAllIndexesNot(final int... indexes);
    public Level0SetOperator<I,T> removeAllNull();
    public Level0ArrayOperator<I,T> toArrayOf(final Type<T> type);
    
    
    public Level0ListOperator<I,T> toList();
    
    public Level0MapOperator<I,T,T> toMapByAlternateElements();
    public <K> Level0MapOperator<I,K,T> toMapByKeyEval(final IFunction<? super T,K> keyEval);
    public <K,V> Level0MapOperator<I,K,V> toMap(final IMapBuilder<? super T,K,V> mapBuilder);
    
    
    public Level0GenericUniqOperator<I,Set<T>> generic();
    
    
    public Level0SetOperator<I,T> replaceWith(final Set<T> replacement);
    public Level0SetOperator<I,T> replaceIfNullWith(final Set<T> replacement);


    public Level0SetOperator<I,T> execIfNotNullAsSet(final IFunction<? super Set<T>,? extends Set<? extends T>> function);

    public <X> Level0SetOperator<I,X> execAsSet(final IFunction<? super Set<T>,? extends Set<X>> function);

    public <X> Level0GenericUniqOperator<I,X> exec(final IFunction<? super Set<T>,X> function);
    
    public <X> Level0SetOperator<I,X> map(final IFunction<? super T,X> function);
    
    public Level0SetOperator<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function);
    

    
    public <X> Level0SetOperator<I,X> asSetOf(final Type<X> type);
    }

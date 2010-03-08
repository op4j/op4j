/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
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
public interface ILevel0ListOperator<I,T>
        extends UniqOperator<List<T>>,
                NavigableCollectionOperator<T>,
		        DistinguishableOperator,
		        SortableOperator<T>,
                CastableToListOperator,
		        ModifiableCollectionOperator<T>,
		        GenerizableOperator<I,List<T>>,
                ExecutableListOperator<T>,
                SelectableOperator<List<T>>,
                ReplaceableOperator<List<T>>,
                ReplaceableIfNullOperator<List<T>>,
                ConvertibleToArrayOperator<T>,
		        ConvertibleToSetOperator,
                ConvertibleToMapOperator<T> {



    public ILevel0ListSelectedOperator<I,T> ifTrue(final IFunction<? super List<T>,Boolean> eval);
    public ILevel0ListSelectedOperator<I,T> ifFalse(final IFunction<? super List<T>,Boolean> eval);
    public ILevel0ListSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super List<T>,Boolean> eval);
    public ILevel0ListSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super List<T>,Boolean> eval);
    public ILevel0ListSelectedOperator<I,T> ifNull();
    public ILevel0ListSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super List<T>,Boolean> eval);
    public ILevel0ListSelectedOperator<I,T> ifNotNull();
    public ILevel0ListSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super List<T>,Boolean> eval);



    public ILevel1ListElementsOperator<I,T> forEach();

    public ILevel0ListOperator<I,T> distinct();
    
    public ILevel0ListOperator<I,T> sort();
    public ILevel0ListOperator<I,T> sort(final Comparator<? super T> comparator);
        
    public ILevel0ListOperator<I,T> add(final T newElement);
    public ILevel0ListOperator<I,T> addAll(final T... newElements);
    public ILevel0ListOperator<I,T> insert(final int position, final T newElement);
    public ILevel0ListOperator<I,T> insertAll(final int position, final T... newElements);
    public ILevel0ListOperator<I,T> addAll(final Collection<T> collection);
    public ILevel0ListOperator<I,T> removeAllIndexes(final int... indexes);
    public ILevel0ListOperator<I,T> removeAllEqual(final T... values);
    public ILevel0ListOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0ListOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0ListOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0ListOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0ListOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0ListOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0ListOperator<I,T> removeAllIndexesNot(final int... indexes);
    public ILevel0ListOperator<I,T> removeAllNull();
    public ILevel0ArrayOperator<I,T> toArrayOf(final Type<T> type);
    
    
    public ILevel0SetOperator<I,T> toSet();
    
    public ILevel0MapOperator<I,T,T> toMapByAlternateElements();
    public <K> ILevel0MapOperator<I,K,T> toMapByKeyEval(final IFunction<? super T,K> keyEval);
    public <K,V> ILevel0MapOperator<I,K,V> toMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder);

    
    public ILevel0GenericUniqOperator<I,List<T>> generic();
    
    
    
    
    public ILevel0ListOperator<I,T> replaceWith(final List<T> replacement);
    public ILevel0ListOperator<I,T> replaceIfNullWith(final List<T> replacement);


    public ILevel0ListOperator<I,T> execIfNotNullAsList(final IFunction<? super List<T>,? extends List<? extends T>> function);

    public <X> ILevel0ListOperator<I,X> execAsList(final IFunction<? super List<T>,? extends List<X>> function);

    public <X> ILevel0GenericUniqOperator<I,X> exec(final IFunction<? super List<T>,X> function);
    
    public <X> ILevel0ListOperator<I,X> map(final IFunction<? super T,X> function);
    
    public ILevel0ListOperator<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function);
    

    
    public <X> ILevel0ListOperator<I,X> asListOf(final Type<X> type);
    }

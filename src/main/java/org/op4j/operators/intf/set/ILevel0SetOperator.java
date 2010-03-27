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
package org.op4j.operators.intf.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.qualities.CastableToSetOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ExecutableSetOperator;
import org.op4j.operators.qualities.GenerizableOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.ReducibleOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.TotalizableOperator;
import org.op4j.operators.qualities.UniqOperator;
import org.op4j.util.ValuePair;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0SetOperator<I,T>
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
                ConvertibleToMapOperator<T>,
                ConvertibleToMapOfSetOperator<T>,
                ReducibleOperator<I,T>,
                TotalizableOperator<I,T> {



    public ILevel0SetSelectedOperator<I,T> ifTrue(final IFunction<? super Set<T>,Boolean> eval);
    public ILevel0SetSelectedOperator<I,T> ifFalse(final IFunction<? super Set<T>,Boolean> eval);
    public ILevel0SetSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super Set<T>,Boolean> eval);
    public ILevel0SetSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super Set<T>,Boolean> eval);
    public ILevel0SetSelectedOperator<I,T> ifNull();
    public ILevel0SetSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super Set<T>,Boolean> eval);
    public ILevel0SetSelectedOperator<I,T> ifNotNull();
    public ILevel0SetSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super Set<T>,Boolean> eval);


    
    public ILevel1SetElementsOperator<I,T> forEach();
    
    public ILevel0SetOperator<I,T> sort();
    public ILevel0SetOperator<I,T> sort(final Comparator<? super T> comparator);
    public ILevel0SetOperator<I,T> sortBy(final IFunction<? super T,?> by);
        
    public ILevel0SetOperator<I,T> add(final T newElement);
    public ILevel0SetOperator<I,T> addAll(final T... newElements);
    public ILevel0SetOperator<I,T> insert(final int position, final T newElement);
    public ILevel0SetOperator<I,T> insertAll(final int position, final T... newElements);
    public ILevel0SetOperator<I,T> addAll(final Collection<T> collection);
    public ILevel0SetOperator<I,T> removeAllIndexes(final int... indexes);
    public ILevel0SetOperator<I,T> removeAllEqual(final T... values);
    public ILevel0SetOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0SetOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0SetOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0SetOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0SetOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0SetOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0SetOperator<I,T> removeAllIndexesNot(final int... indexes);
    public ILevel0SetOperator<I,T> removeAllNull();
    
    public ILevel0ArrayOperator<I,T> toArrayOf(final Type<T> type);
    public ILevel0ListOperator<I,T> toList();
    
    public <K,V> ILevel0MapOperator<I,K,V> toMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder);
    public <K,V> ILevel0MapOperator<I,K,Set<V>> toGroupMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder);
    
    public ILevel0MapOperator<I,T,T> couple();
    public ILevel0MapOperator<I,T,Set<T>> coupleAndGroup();
    
    public <K> ILevel0MapOperator<I,K,T> zipKeys(final K... keys);
    public <V> ILevel0MapOperator<I,T,V> zipValues(final V... values);
    public <K> ILevel0MapOperator<I,K,T> zipKeysFrom(final Collection<K> keys);
    public <V> ILevel0MapOperator<I,T,V> zipValuesFrom(final Collection<V> values);
    public <K> ILevel0MapOperator<I,K,T> zipKeysFrom(final K[] keys);
    public <V> ILevel0MapOperator<I,T,V> zipValuesFrom(final V[] values);
    public <K> ILevel0MapOperator<I,K,T> zipKeysBy(final IFunction<? super T,K> keyEval);
    public <V> ILevel0MapOperator<I,T,V> zipValuesBy(final IFunction<? super T,V> valueEval);

    public <K> ILevel0MapOperator<I,K,Set<T>> zipAndGroupKeys(final K... keys);
    public <V> ILevel0MapOperator<I,T,Set<V>> zipAndGroupValues(final V... values);
    public <K> ILevel0MapOperator<I,K,Set<T>> zipAndGroupKeysFrom(final Collection<K> keys);
    public <V> ILevel0MapOperator<I,T,Set<V>> zipAndGroupValuesFrom(final Collection<V> values);
    public <K> ILevel0MapOperator<I,K,Set<T>> zipAndGroupKeysFrom(final K[] keys);
    public <V> ILevel0MapOperator<I,T,Set<V>> zipAndGroupValuesFrom(final V[] values);
    public <K> ILevel0MapOperator<I,K,Set<T>> zipAndGroupKeysBy(final IFunction<? super T,K> keyEval);
    public <V> ILevel0MapOperator<I,T,Set<V>> zipAndGroupValuesBy(final IFunction<? super T,V> valueEval);
    
    
    public ILevel0GenericUniqOperator<I,Set<T>> generic();
    
    
    public ILevel0SetOperator<I,T> replaceWith(final Set<T> replacement);
    public ILevel0SetOperator<I,T> replaceIfNullWith(final Set<T> replacement);


    public ILevel0SetOperator<I,T> execIfNotNullAsSet(final IFunction<? super Set<T>,? extends Set<? extends T>> function);

    public <X> ILevel0SetOperator<I,X> execAsSet(final IFunction<? super Set<T>,? extends Set<X>> function);

    public <X> ILevel0GenericUniqOperator<I,X> exec(final IFunction<? super Set<T>,X> function);
    
    public <X> ILevel0SetOperator<I,X> map(final IFunction<? super T,X> function);
    
    public ILevel0SetOperator<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function);
    

    
    public <X> ILevel0SetOperator<I,X> of(final Type<X> type);
    public <X> ILevel0SetOperator<I,X> castToSetOf(final Type<X> type);
    
    
    public ILevel0GenericUniqOperator<I,T> reduce(final IFunction<? extends ValuePair<? super T,? super T>, ? extends T> reductor);
    public <X> ILevel0GenericUniqOperator<I,X> reduce(final IFunction<? extends ValuePair<? super X,? super T>,X> reductor, final X initialValue);
    
    public ILevel0GenericUniqOperator<I,Boolean> any(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericUniqOperator<I,Boolean> all(final IFunction<? super T,Boolean> eval);
    
}

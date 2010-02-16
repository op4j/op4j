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
public interface Level0SetOperator<T>
        extends UniqOperator<Set<T>>,
                NavigableCollectionOperator<T>,
		        SortableOperator<T>,
                CastableToSetOperator,
		        ModifiableCollectionOperator<T>,
		        GenerizableOperator<Set<T>>,
                ExecutableSetOperator<T>,
                SelectableOperator<Set<T>>,
                ReplaceableOperator<Set<T>>,
                ReplaceableIfNullOperator<Set<T>>,
                ConvertibleToArrayOperator<T>,
		        ConvertibleToListOperator,
                ConvertibleToMapOperator<T> {



    public Level0SetSelectedOperator<T> ifIndex(final int... indexes);
    public Level0SetSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T> ifNull();
    public Level0SetSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level0SetSelectedOperator<T> ifNotNull();
    public Level0SetSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super Set<T>> eval);


    
    public Level1SetElementsOperator<T> forEach();
    
    public Level0SetOperator<T> sort();
    public Level0SetOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level0SetOperator<T> add(final T newElement);
    public Level0SetOperator<T> addAll(final T... newElements);
    public Level0SetOperator<T> insert(final int position, final T newElement);
    public Level0SetOperator<T> insertAll(final int position, final T... newElements);
    public Level0SetOperator<T> addAll(final Collection<T> collection);
    public Level0SetOperator<T> removeAllIndexes(final int... indexes);
    public Level0SetOperator<T> removeAllEqual(final T... values);
    public Level0SetOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level0SetOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level0SetOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level0SetOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level0SetOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level0SetOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level0SetOperator<T> removeAllIndexesNot(final int... indexes);
    public Level0SetOperator<T> removeAllNull();
    public Level0ArrayOperator<T> toArrayOf(final Type<T> type);
    
    
    public Level0ListOperator<T> toList();
    
    public Level0MapOperator<T,T> toMap();
    public <K> Level0MapOperator<K,T> toMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public Level0GenericUniqOperator<Set<T>> generic();
    
    
    public Level0SetOperator<T> replaceWith(final Set<T> replacement);
    public Level0SetOperator<T> replaceIfNullWith(final Set<T> replacement);


    public <X> Level0SetOperator<X> execIfNotNullAsSet(final IFunction<? extends Set<X>,? super Set<T>> function);

    public <X> Level0SetOperator<X> execAsSet(final IFunction<? extends Set<X>,? super Set<T>> function);

    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<T>> function);
    
    public <X> Level0GenericUniqOperator<X> execIfNotNull(final IFunction<X,? super Set<T>> function);
    
    public <X> Level0SetOperator<X> map(final IFunction<X,? super T> function);
    
    public <X> Level0SetOperator<X> mapIfNotNull(final IFunction<X,? super T> function);
    

    
    public <X> Level0SetOperator<X> asSetOf(final Type<X> type);
    public Level0SetOperator<?> asSetOfUnknown();
    
    
}

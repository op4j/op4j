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
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.qualities.CastableToSetOfArrayOperator;
import org.op4j.operators.qualities.CastableToSetOfListOperator;
import org.op4j.operators.qualities.CastableToSetOfMapOperator;
import org.op4j.operators.qualities.CastableToSetOfSetOperator;
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
public interface Level0SetOperator<T,I>
        extends UniqOperator<Set<T>,I>,
                NavigableCollectionOperator<T,I>,
		        SortableOperator<T,I>,
                CastableToSetOperator<I>,
                CastableToSetOfArrayOperator<I>,
                CastableToSetOfListOperator<I>,
                CastableToSetOfMapOperator<I>,
                CastableToSetOfSetOperator<I>,
		        ModifiableCollectionOperator<T,I>,
		        GenerizableOperator<Set<T>,I>,
                ExecutableSetOperator<T,I>,
                SelectableOperator<Set<T>,I>,
                ReplaceableOperator<Set<T>,I>,
                ReplaceableIfNullOperator<Set<T>,I>,
                ConvertibleToArrayOperator<T,I>,
		        ConvertibleToListOperator<I>,
                ConvertibleToMapOperator<T,I> {



    public Level0SetSelectedOperator<T,I> ifIndex(final int... indices);
    public Level0SetSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T,I> ifNull();
    public Level0SetSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level0SetSelectedOperator<T,I> ifNotNull();
    public Level0SetSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval);


    
    public Level1SetElementsOperator<T,I> forEach();
    
    public Level0SetOperator<T,I> sort();
    public Level0SetOperator<T,I> sort(final Comparator<? super T> comparator);
        
    public Level0SetOperator<T,I> add(final T newElement);
    public Level0SetOperator<T,I> addAll(final T... newElements);
    public Level0SetOperator<T,I> insert(final int position, final T newElement);
    public Level0SetOperator<T,I> insertAll(final int position, final T... newElements);
    public Level0SetOperator<T,I> addAll(final Collection<T> collection);
    public Level0SetOperator<T,I> removeAllIndexes(final int... indices);
    public Level0SetOperator<T,I> removeAllEqual(final T... values);
    public Level0SetOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level0SetOperator<T,I> removeAllNull();
    public Level0ArrayOperator<T,I> toArray(final Type<T> of);
    
    
    public Level0ListOperator<T,I> toList();
    
    public Level0MapOperator<T,T,I> toMap();
    public <K> Level0MapOperator<K,T,I> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V,I> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public Level0GenericUniqOperator<Set<T>,I> generic();
    
    
    public Level0SetOperator<T,I> replaceWith(final Set<T> replacement);
    public Level0SetOperator<T,I> replaceIfNullWith(final Set<T> replacement);


    public <X> Level0SetOperator<X,I> convert(final IConverter<? extends Set<X>,? super Set<T>> converter);
    
    public <X> Level0SetOperator<X,I> eval(final IEvaluator<? extends Set<X>,? super Set<T>> eval);

    public <X> Level0SetOperator<X,I> exec(final IFunction<? extends Set<X>,? super Set<T>> function);

    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T>> function);
    
    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Set<T>> eval);
    
    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super Set<T>> converter);    
    
    
    public <X> Level0SetOfArrayOperator<X,I> asSetOfArrayOf(final Type<X> type);
    public Level0SetOfArrayOperator<?,I> asSetOfArrayOfUnknown();

    
    public <X> Level0SetOfListOperator<X,I> asSetOfListOf(final Type<X> type);
    public Level0SetOfListOperator<?,I> asSetOfListOfUnknown();

    
    public <K,V> Level0SetOfMapOperator<K,V,I> asSetOfMapOf(final Type<K> keyType, final Type<V> valueType);
    public Level0SetOfMapOperator<?,?,I> asSetOfMapOfUnknown();

    
    public <X> Level0SetOfSetOperator<X,I> asSetOfSetOf(final Type<X> type);
    public Level0SetOfSetOperator<?,I> asSetOfSetOfUnknown();

    
    public <X> Level0SetOperator<X,I> asSetOf(final Type<X> type);
    public Level0SetOperator<?,I> asSetOfUnknown();
    
    
}

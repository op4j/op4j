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
import org.op4j.operators.qualities.ConvertibleOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.EvaluableOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.GenerizableOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
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
                CastableToSetOfArrayOperator,
                CastableToSetOfListOperator,
                CastableToSetOfMapOperator,
                CastableToSetOfSetOperator,
		        ModifiableCollectionOperator<T>,
		        GenerizableOperator<Set<T>>,
                ExecutableOperator<Set<T>>,
                ConvertibleOperator<Set<T>>,
                EvaluableOperator<Set<T>>,
                SelectableOperator<Set<T>>,
                ConvertibleToArrayOperator<T>,
		        ConvertibleToListOperator,
                ConvertibleToMapOperator<T> {



    public Level0SetSelectedOperator<T> ifIndex(final int... indices);
    public Level0SetSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T> ifNull();
    public Level0SetSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0SetSelectedOperator<T> ifIndexNot(final int... indices);
    public Level0SetSelectedOperator<T> ifNotNull();
    public Level0SetSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval);


    
    public Level1SetElementsOperator<T> forEach();
    
    public Level0SetOperator<T> sort();
    public Level0SetOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level0SetOperator<T> add(final T... newElements);
    public Level0SetOperator<T> insert(final int position, final T... newElements);
    public Level0SetOperator<T> addAll(final Collection<T> collection);
    public Level0SetOperator<T> removeIndexes(final int... indices);
    public Level0SetOperator<T> removeEquals(final T... values);
    public Level0SetOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level0SetOperator<T> removeIndexesNot(final int... indices);
    public Level0SetOperator<T> removeNulls();
    public Level0ArrayOperator<T> toArray(final Type<T> of);
    
    
    public Level0ListOperator<T> toList();
    
    public Level0MapOperator<T,T> toMap();
    public <K> Level0MapOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public Level0GenericUniqOperator<Set<T>> generic();
    
    
    public <X> Level0GenericUniqOperator<X> convert(final IConverter<X,? super Set<T>> converter);
    
    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X,? super Set<T>> eval);

    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<T>> function);
    
    
    public <X> Level0SetOfArrayOperator<X> asSetOfArrayOf(final Type<X> type);
    public Level0SetOfArrayOperator<?> asSetOfArrayOfUnknown();

    
    public <X> Level0SetOfListOperator<X> asSetOfListOf(final Type<X> type);
    public Level0SetOfListOperator<?> asSetOfListOfUnknown();

    
    public <K,V> Level0SetOfMapOperator<K,V> asSetOfMapOf(final Type<K> keyType, final Type<V> valueType);
    public Level0SetOfMapOperator<?,?> asSetOfMapOfUnknown();

    
    public <X> Level0SetOfSetOperator<X> asSetOfSetOf(final Type<X> type);
    public Level0SetOfSetOperator<?> asSetOfSetOfUnknown();

    
    public <X> Level0SetOperator<X> asSetOf(final Type<X> type);
    public Level0SetOperator<?> asSetOfUnknown();
    
    
}

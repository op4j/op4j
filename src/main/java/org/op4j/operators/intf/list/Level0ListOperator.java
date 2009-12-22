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
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.CastableToListOfArrayOperator;
import org.op4j.operators.qualities.CastableToListOfListOperator;
import org.op4j.operators.qualities.CastableToListOfMapOperator;
import org.op4j.operators.qualities.CastableToListOfSetOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.ConvertibleOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
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
public interface Level0ListOperator<T>
        extends UniqOperator<List<T>>,
                NavigableCollectionOperator<T>,
		        DistinguishableOperator,
		        SortableOperator<T>,
                CastableToListOperator,
                CastableToListOfArrayOperator,
                CastableToListOfListOperator,
                CastableToListOfMapOperator,
                CastableToListOfSetOperator,
		        ModifiableCollectionOperator<T>,
		        GenerizableOperator<List<T>>,
                ExecutableOperator<List<T>>,
                ConvertibleOperator<List<T>>,
                EvaluableOperator<List<T>>,
                SelectableOperator<List<T>>,
                ConvertibleToArrayOperator<T>,
		        ConvertibleToSetOperator,
                ConvertibleToMapOperator<T> {



    public Level0ListSelectedOperator<T> ifIndex(final int... indices);
    public Level0ListSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T> ifNull();
    public Level0ListSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T> ifIndexNot(final int... indices);
    public Level0ListSelectedOperator<T> ifNotNull();
    public Level0ListSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval);



    public Level1ListElementsOperator<T> forEach();

    public Level0ListOperator<T> distinct();
    
    public Level0ListOperator<T> sort();
    public Level0ListOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level0ListOperator<T> add(final T... newElements);
    public Level0ListOperator<T> insert(final int position, final T... newElements);
    public Level0ListOperator<T> addAll(final Collection<T> collection);
    public Level0ListOperator<T> removeIndexes(final int... indices);
    public Level0ListOperator<T> removeEquals(final T... values);
    public Level0ListOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level0ListOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level0ListOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level0ListOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level0ListOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level0ListOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level0ListOperator<T> removeIndexesNot(final int... indices);
    public Level0ListOperator<T> removeNulls();
    public Level0ArrayOperator<T> toArray(final Type<T> of);
    
    
    public Level0SetOperator<T> toSet();
    
    public Level0MapOperator<T,T> toMap();
    public <K> Level0MapOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level0GenericUniqOperator<List<T>> generic();
    
    
    
    
    public <X> Level0GenericUniqOperator<X> convert(final IConverter<X,? super List<T>> converter);
    
    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X,? super List<T>> eval);

    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super List<T>> function);
    
    
    public <X> Level0ListOfArrayOperator<X> asListOfArrayOf(final Type<X> type);
    public Level0ListOfArrayOperator<?> asListOfArrayOfUnknown();
    
    public <X> Level0ListOfListOperator<X> asListOfListOf(final Type<X> type);
    public Level0ListOfListOperator<?> asListOfListOfUnknown();
    
    public <K,V> Level0ListOfMapOperator<K,V> asListOfMapOf(final Type<K> keyType, final Type<V> valueType);
    public Level0ListOfMapOperator<?,?> asListOfMapOfUnknown();
    
    public <X> Level0ListOfSetOperator<X> asListOfSetOf(final Type<X> type);
    public Level0ListOfSetOperator<?> asListOfSetOfUnknown();

    
    public <X> Level0ListOperator<X> asListOf(final Type<X> type);
    public Level0ListOperator<?> asListOfUnknown();
    



    
}

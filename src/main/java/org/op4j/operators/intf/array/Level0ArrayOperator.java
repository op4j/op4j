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
package org.op4j.operators.intf.array;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.CastableToArrayOfArrayOperator;
import org.op4j.operators.qualities.CastableToArrayOfListOperator;
import org.op4j.operators.qualities.CastableToArrayOfMapOperator;
import org.op4j.operators.qualities.CastableToArrayOfSetOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOperator;
import org.op4j.operators.qualities.GenerizableOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableArrayOperator;
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
public interface Level0ArrayOperator<T>
        extends UniqOperator<T[]>,
                NavigableArrayOperator<T>,
		        DistinguishableOperator,
		        SortableOperator<T>,
		        CastableToArrayOperator,
		        CastableToArrayOfArrayOperator,
                CastableToArrayOfListOperator,
                CastableToArrayOfMapOperator,
                CastableToArrayOfSetOperator,
		        ModifiableCollectionOperator<T>,
		        SelectableOperator<T[]>,
                ReplaceableOperator<T[]>,
                ReplaceableIfNullOperator<T[]>,
                GenerizableOperator<T[]>,
		        ExecutableArrayOperator<T>,
		        ConvertibleToListOperator,
		        ConvertibleToSetOperator,
		        ConvertibleToMapOperator<T> {



    public Level0ArraySelectedOperator<T> ifIndex(final int... indexes);
    public Level0ArraySelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T> ifNull();
    public Level0ArraySelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T> ifIndexNot(final int... indexes);
    public Level0ArraySelectedOperator<T> ifNotNull();
    public Level0ArraySelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval);



    public Level1ArrayElementsOperator<T> forEach(final Type<T> elementType);

    public Level0ArrayOperator<T> distinct();
    
    public Level0ArrayOperator<T> sort();
    public Level0ArrayOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level0ArrayOperator<T> add(final T newElement);
    public Level0ArrayOperator<T> addAll(final T... newElements);
    public Level0ArrayOperator<T> insert(final int position, final T newElement);
    public Level0ArrayOperator<T> insertAll(final int position, final T... newElements);
    public Level0ArrayOperator<T> addAll(final Collection<T> collection);
    public Level0ArrayOperator<T> removeAllIndexes(final int... indexes);
    public Level0ArrayOperator<T> removeAllEqual(final T... values);
    public Level0ArrayOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0ArrayOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0ArrayOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0ArrayOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0ArrayOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0ArrayOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0ArrayOperator<T> removeAllIndexesNot(final int... indexes);
    public Level0ArrayOperator<T> removeAllNull();
    public Level0ListOperator<T> toList();
    
    public Level0SetOperator<T> toSet();
    
    public Level0MapOperator<T,T> toMap();
    public <K> Level0MapOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public Level0GenericUniqOperator<T[]> generic();

    
    
    public Level0ArrayOperator<T> replaceWith(final T[] replacement);
    public Level0ArrayOperator<T> replaceIfNullWith(final T[] replacement);


    public <X> Level0ArrayOperator<X> convertAsArray(final IConverter<X[],? super T[]> converter);
    
    public <X> Level0ArrayOperator<X> evalAsArray(final IEvaluator<X[],? super T[]> eval);

    public <X> Level0ArrayOperator<X> execAsArray(final IFunction<X[], ? super T[]> function);

    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super T[]> function);
    
    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super T[]> eval);
    
    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super T[]> converter);    
    
    
    
    public <X> Level0ArrayOfArrayOperator<X> asArrayOfArrayOf(final Type<X> type);
    public Level0ArrayOfArrayOperator<?> asArrayOfArrayOfUnknown();

    
    public <X> Level0ArrayOfListOperator<X> asArrayOfListOf(final Type<X> type);
    public Level0ArrayOfListOperator<?> asArrayOfListOfUnknown();

    
    public <K,V> Level0ArrayOfMapOperator<K,V> asArrayOfMapOf(final Type<K> keyType, final Type<V> valueType);
    public Level0ArrayOfMapOperator<?,?> asArrayOfMapOfUnknown();

    
    public <X> Level0ArrayOfSetOperator<X> asArrayOfSetOf(final Type<X> type);
    public Level0ArrayOfSetOperator<?> asArrayOfSetOfUnknown();

    
    public <X> Level0ArrayOperator<X> asArrayOf(final Type<X> type);
    public Level0ArrayOperator<?> asArrayOfUnknown();
    

    
}

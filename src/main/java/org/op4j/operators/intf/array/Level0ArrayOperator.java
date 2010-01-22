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
public interface Level0ArrayOperator<T,I>
        extends UniqOperator<T[],I>,
                NavigableArrayOperator<T,I>,
		        DistinguishableOperator<I>,
		        SortableOperator<T,I>,
		        CastableToArrayOperator<I>,
		        CastableToArrayOfArrayOperator<I>,
                CastableToArrayOfListOperator<I>,
                CastableToArrayOfMapOperator<I>,
                CastableToArrayOfSetOperator<I>,
		        ModifiableCollectionOperator<T,I>,
		        SelectableOperator<T[],I>,
                ReplaceableOperator<T[],I>,
                ReplaceableIfNullOperator<T[],I>,
                GenerizableOperator<T[],I>,
		        ExecutableArrayOperator<T,I>,
		        ConvertibleToListOperator<I>,
		        ConvertibleToSetOperator<I>,
		        ConvertibleToMapOperator<T,I> {



    public Level0ArraySelectedOperator<T,I> ifIndex(final int... indices);
    public Level0ArraySelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T,I> ifNull();
    public Level0ArraySelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArraySelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level0ArraySelectedOperator<T,I> ifNotNull();
    public Level0ArraySelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval);



    public Level1ArrayElementsOperator<T,I> forEach(final Type<T> elementType);

    public Level0ArrayOperator<T,I> distinct();
    
    public Level0ArrayOperator<T,I> sort();
    public Level0ArrayOperator<T,I> sort(final Comparator<? super T> comparator);
        
    public Level0ArrayOperator<T,I> add(final T newElement);
    public Level0ArrayOperator<T,I> addAll(final T... newElements);
    public Level0ArrayOperator<T,I> insert(final int position, final T newElement);
    public Level0ArrayOperator<T,I> insertAll(final int position, final T... newElements);
    public Level0ArrayOperator<T,I> addAll(final Collection<T> collection);
    public Level0ArrayOperator<T,I> removeAllIndexes(final int... indices);
    public Level0ArrayOperator<T,I> removeAllEqual(final T... values);
    public Level0ArrayOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0ArrayOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0ArrayOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0ArrayOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0ArrayOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0ArrayOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0ArrayOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level0ArrayOperator<T,I> removeAllNull();
    public Level0ListOperator<T,I> toList();
    
    public Level0SetOperator<T,I> toSet();
    
    public Level0MapOperator<T,T,I> toMap();
    public <K> Level0MapOperator<K,T,I> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V,I> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public Level0GenericUniqOperator<T[],I> generic();

    
    
    public Level0ArrayOperator<T,I> replaceWith(final T[] replacement);
    public Level0ArrayOperator<T,I> replaceIfNullWith(final T[] replacement);


    public <X> Level0ArrayOperator<X,I> convert(final IConverter<X[],? super T[]> converter);
    
    public <X> Level0ArrayOperator<X,I> eval(final IEvaluator<X[],? super T[]> eval);

    public <X> Level0ArrayOperator<X,I> exec(final IFunction<X[], ? super T[]> function);

    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super T[]> function);
    
    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super T[]> eval);
    
    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super T[]> converter);    
    
    
    
    public <X> Level0ArrayOfArrayOperator<X,I> asArrayOfArrayOf(final Type<X> type);
    public Level0ArrayOfArrayOperator<?,I> asArrayOfArrayOfUnknown();

    
    public <X> Level0ArrayOfListOperator<X,I> asArrayOfListOf(final Type<X> type);
    public Level0ArrayOfListOperator<?,I> asArrayOfListOfUnknown();

    
    public <K,V> Level0ArrayOfMapOperator<K,V,I> asArrayOfMapOf(final Type<K> keyType, final Type<V> valueType);
    public Level0ArrayOfMapOperator<?,?,I> asArrayOfMapOfUnknown();

    
    public <X> Level0ArrayOfSetOperator<X,I> asArrayOfSetOf(final Type<X> type);
    public Level0ArrayOfSetOperator<?,I> asArrayOfSetOfUnknown();

    
    public <X> Level0ArrayOperator<X,I> asArrayOf(final Type<X> type);
    public Level0ArrayOperator<?,I> asArrayOfUnknown();
    

    
}

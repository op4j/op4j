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
public interface Level0ListOperator<T,I>
        extends UniqOperator<List<T>,I>,
                NavigableCollectionOperator<T,I>,
		        DistinguishableOperator<I>,
		        SortableOperator<T,I>,
                CastableToListOperator<I>,
                CastableToListOfArrayOperator<I>,
                CastableToListOfListOperator<I>,
                CastableToListOfMapOperator<I>,
                CastableToListOfSetOperator<I>,
		        ModifiableCollectionOperator<T,I>,
		        GenerizableOperator<List<T>,I>,
                ExecutableListOperator<T,I>,
                SelectableOperator<List<T>,I>,
                ReplaceableOperator<List<T>,I>,
                ReplaceableIfNullOperator<List<T>,I>,
                ConvertibleToArrayOperator<T,I>,
		        ConvertibleToSetOperator<I>,
                ConvertibleToMapOperator<T,I> {



    public Level0ListSelectedOperator<T,I> ifIndex(final int... indices);
    public Level0ListSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T,I> ifNull();
    public Level0ListSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level0ListSelectedOperator<T,I> ifNotNull();
    public Level0ListSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval);



    public Level1ListElementsOperator<T,I> forEach();

    public Level0ListOperator<T,I> distinct();
    
    public Level0ListOperator<T,I> sort();
    public Level0ListOperator<T,I> sort(final Comparator<? super T> comparator);
        
    public Level0ListOperator<T,I> add(final T newElement);
    public Level0ListOperator<T,I> addAll(final T... newElements);
    public Level0ListOperator<T,I> insert(final int position, final T newElement);
    public Level0ListOperator<T,I> insertAll(final int position, final T... newElements);
    public Level0ListOperator<T,I> addAll(final Collection<T> collection);
    public Level0ListOperator<T,I> removeAllIndexes(final int... indices);
    public Level0ListOperator<T,I> removeAllEqual(final T... values);
    public Level0ListOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0ListOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0ListOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0ListOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0ListOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0ListOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0ListOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level0ListOperator<T,I> removeAllNull();
    public Level0ArrayOperator<T,I> toArray(final Type<T> of);
    
    
    public Level0SetOperator<T,I> toSet();
    
    public Level0MapOperator<T,T,I> toMap();
    public <K> Level0MapOperator<K,T,I> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V,I> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level0GenericUniqOperator<List<T>,I> generic();
    
    
    
    
    public Level0ListOperator<T,I> replaceWith(final List<T> replacement);
    public Level0ListOperator<T,I> replaceIfNullWith(final List<T> replacement);


    public <X> Level0ListOperator<X,I> convert(final IConverter<? extends List<X>,? super List<T>> converter);
    
    public <X> Level0ListOperator<X,I> eval(final IEvaluator<? extends List<X>,? super List<T>> eval);

    public <X> Level0ListOperator<X,I> exec(final IFunction<? extends List<X>, ? super List<T>> function);

    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<T>> function);
    
    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super List<T>> eval);
    
    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super List<T>> converter);    
    
    
    public <X> Level0ListOfArrayOperator<X,I> asListOfArrayOf(final Type<X> type);
    public Level0ListOfArrayOperator<?,I> asListOfArrayOfUnknown();
    
    public <X> Level0ListOfListOperator<X,I> asListOfListOf(final Type<X> type);
    public Level0ListOfListOperator<?,I> asListOfListOfUnknown();
    
    public <K,V> Level0ListOfMapOperator<K,V,I> asListOfMapOf(final Type<K> keyType, final Type<V> valueType);
    public Level0ListOfMapOperator<?,?,I> asListOfMapOfUnknown();
    
    public <X> Level0ListOfSetOperator<X,I> asListOfSetOf(final Type<X> type);
    public Level0ListOfSetOperator<?,I> asListOfSetOfUnknown();

    
    public <X> Level0ListOperator<X,I> asListOf(final Type<X> type);
    public Level0ListOperator<?,I> asListOfUnknown();
    



    
}

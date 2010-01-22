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
package org.op4j.operators.intf.generic;

import java.util.Collection;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.qualities.BuilderOperator;
import org.op4j.operators.qualities.CastableToArrayOfArrayOperator;
import org.op4j.operators.qualities.CastableToArrayOfListOperator;
import org.op4j.operators.qualities.CastableToArrayOfMapOperator;
import org.op4j.operators.qualities.CastableToArrayOfSetOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.CastableToListOfArrayOperator;
import org.op4j.operators.qualities.CastableToListOfListOperator;
import org.op4j.operators.qualities.CastableToListOfMapOperator;
import org.op4j.operators.qualities.CastableToListOfSetOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.CastableToMapOfArrayOperator;
import org.op4j.operators.qualities.CastableToMapOfListOperator;
import org.op4j.operators.qualities.CastableToMapOfMapOperator;
import org.op4j.operators.qualities.CastableToMapOfSetOperator;
import org.op4j.operators.qualities.CastableToMapOperator;
import org.op4j.operators.qualities.CastableToSetOfArrayOperator;
import org.op4j.operators.qualities.CastableToSetOfListOperator;
import org.op4j.operators.qualities.CastableToSetOfMapOperator;
import org.op4j.operators.qualities.CastableToSetOfSetOperator;
import org.op4j.operators.qualities.CastableToSetOperator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.ModifiableGrowableOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOperator;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level0GenericUniqOperator<T,I>
        extends UniqOperator<T,I>,
                CastableToArrayOperator<I>,
                CastableToListOperator<I>,
                CastableToMapOperator<I>,
                CastableToSetOperator<I>,
                CastableToArrayOfArrayOperator<I>,
                CastableToArrayOfListOperator<I>,
                CastableToArrayOfMapOperator<I>,
                CastableToArrayOfSetOperator<I>,
                CastableToListOfArrayOperator<I>,
                CastableToListOfListOperator<I>,
                CastableToListOfMapOperator<I>,
                CastableToListOfSetOperator<I>,
                CastableToMapOfArrayOperator<I>,
                CastableToMapOfListOperator<I>,
                CastableToMapOfMapOperator<I>,
                CastableToMapOfSetOperator<I>,
                CastableToSetOfArrayOperator<I>,
                CastableToSetOfListOperator<I>,
                CastableToSetOfMapOperator<I>,
                CastableToSetOfSetOperator<I>,
        		BuilderOperator<T,I>,
        		ExecutableOperator<T,I>,
                CastableToTypeOperator<T,I>,
                SelectableOperator<T,I>,
                ReplaceableOperator<T,I>,
                ReplaceableIfNullOperator<T,I>,
                ModifiableGrowableOperator<T,I> {



    public Level0GenericUniqSelectedOperator<T,I> ifIndex(final int... indices);
    public Level0GenericUniqSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T,I> ifNull();
    public Level0GenericUniqSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level0GenericUniqSelectedOperator<T,I> ifNotNull();
    public Level0GenericUniqSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);

    
    public Level0GenericUniqOperator<T,I> replaceWith(final T replacement);
    public Level0GenericUniqOperator<T,I> replaceIfNullWith(final T replacement);


    public <X> Level0GenericUniqOperator<X,I> convert(final IConverter<X,? super T> converter);
    
    public <X> Level0GenericUniqOperator<X,I> eval(final IEvaluator<X,? super T> eval);

    public <X> Level0GenericUniqOperator<X,I> exec(final IFunction<X, ? super T> function);
    
    public <X> Level0GenericUniqOperator<X,I> asType(final Type<X> type);
    public Level0GenericUniqOperator<?,I> asUnknown();
        
    public Level0GenericMultiOperator<T,I> add(final T newElement);
    public Level0GenericMultiOperator<T,I> addAll(final T... newElements);
    public Level0GenericMultiOperator<T,I> insert(final int position, final T newElement);
    public Level0GenericMultiOperator<T,I> insertAll(final int position, final T... newElements);
    public Level0GenericMultiOperator<T,I> addAll(final Collection<T> collection);

    
    public Level0ListOperator<T,I> buildList();
    
    
    public Level0SetOperator<T,I> buildSet();
    
    
    public Level0ArrayOperator<T,I> buildArray(final Type<T> of);
    
    
    public <K> Level0MapOperator<K,T,I> buildMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V,I> buildMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfListOperator<K,T,I> buildMapOfList(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOfListOperator<K,V,I> buildMapOfList(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfSetOperator<K,T,I> buildMapOfSet(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOfSetOperator<K,V,I> buildMapOfSet(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfArrayOperator<K,T,I> buildMapOfArray(final Type<T> valueArrayOf, final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOfArrayOperator<K,V,I> buildMapOfArray(final Type<V> valueArrayOf, final IMapBuilder<K,V,? super T> mapBuild);

    
    
    public <X> Level0ArrayOperator<X,I> asArrayOf(final Type<X> type);
    public <X> Level0ListOperator<X,I> asListOf(final Type<X> type);
    public <K,V> Level0MapOperator<K,V,I> asMapOf(final Type<K> keyType, final Type<V> valueType);
    public <X> Level0SetOperator<X,I> asSetOf(final Type<X> type);
    public Level0ArrayOperator<?,I> asArrayOfUnknown();
    public Level0ListOperator<?,I> asListOfUnknown();
    public Level0MapOperator<?,?,I> asMapOfUnknown();
    public Level0SetOperator<?,I> asSetOfUnknown();
    
    
    
    public <X> Level0ArrayOfArrayOperator<X,I> asArrayOfArrayOf(final Type<X> type);
    public <X> Level0ArrayOfListOperator<X,I> asArrayOfListOf(final Type<X> type);
    public <K,V> Level0ArrayOfMapOperator<K,V,I> asArrayOfMapOf(final Type<K> keyType,final Type<V> valueType);
    public <X> Level0ArrayOfSetOperator<X,I> asArrayOfSetOf(final Type<X> type);
    public <X> Level0ListOfArrayOperator<X,I> asListOfArrayOf(final Type<X> type);
    public <X> Level0ListOfListOperator<X,I> asListOfListOf(final Type<X> type);
    public <K,V> Level0ListOfMapOperator<K,V,I> asListOfMapOf(final Type<K> keyType,final Type<V> valueType);
    public <X> Level0ListOfSetOperator<X,I> asListOfSetOf(final Type<X> type);
    public <K,V> Level0MapOfArrayOperator<K,V,I> asMapOfArrayOf(final Type<K> keyType, final Type<V> valueType);
    public <K,V> Level0MapOfListOperator<K,V,I> asMapOfListOf(final Type<K> keyType, final Type<V> valueType);
    public <K1,K2,V> Level0MapOfMapOperator<K1,K2,V,I> asMapOfMapOf(final Type<K1> key1Type, final Type<K2> key2Type, final Type<V> valueType);
    public <K,V> Level0MapOfSetOperator<K,V,I> asMapOfSetOf(final Type<K> keyType, final Type<V> valueType);
    public <X> Level0SetOfArrayOperator<X,I> asSetOfArrayOf(final Type<X> type);
    public <X> Level0SetOfListOperator<X,I> asSetOfListOf(final Type<X> type);
    public <K,V> Level0SetOfMapOperator<K,V,I> asSetOfMapOf(final Type<K> keyType,final Type<V> valueType);
    public <X> Level0SetOfSetOperator<X,I> asSetOfSetOf(final Type<X> type);
    public Level0ArrayOfArrayOperator<?,I> asArrayOfArrayOfUnknown();
    public Level0ArrayOfListOperator<?,I> asArrayOfListOfUnknown();
    public Level0ArrayOfMapOperator<?,?,I> asArrayOfMapOfUnknown();
    public Level0ArrayOfSetOperator<?,I> asArrayOfSetOfUnknown();
    public Level0ListOfArrayOperator<?,I> asListOfArrayOfUnknown();
    public Level0ListOfListOperator<?,I> asListOfListOfUnknown();
    public Level0ListOfMapOperator<?,?,I> asListOfMapOfUnknown();
    public Level0ListOfSetOperator<?,I> asListOfSetOfUnknown();
    public Level0MapOfArrayOperator<?,?,I> asMapOfArrayOfUnknown();
    public Level0MapOfListOperator<?,?,I> asMapOfListOfUnknown();
    public Level0MapOfMapOperator<?,?,?,I> asMapOfMapOfUnknown();
    public Level0MapOfSetOperator<?,?,I> asMapOfSetOfUnknown();
    public Level0SetOfArrayOperator<?,I> asSetOfArrayOfUnknown();
    public Level0SetOfListOperator<?,I> asSetOfListOfUnknown();
    public Level0SetOfMapOperator<?,?,I> asSetOfMapOfUnknown();
    public Level0SetOfSetOperator<?,I> asSetOfSetOfUnknown();
    
    
    
}

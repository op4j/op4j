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
public interface Level0GenericUniqOperator<T>
        extends UniqOperator<T>,
                CastableToArrayOperator,
                CastableToListOperator,
                CastableToMapOperator,
                CastableToSetOperator,
                CastableToArrayOfArrayOperator,
                CastableToArrayOfListOperator,
                CastableToArrayOfMapOperator,
                CastableToArrayOfSetOperator,
                CastableToListOfArrayOperator,
                CastableToListOfListOperator,
                CastableToListOfMapOperator,
                CastableToListOfSetOperator,
                CastableToMapOfArrayOperator,
                CastableToMapOfListOperator,
                CastableToMapOfMapOperator,
                CastableToMapOfSetOperator,
                CastableToSetOfArrayOperator,
                CastableToSetOfListOperator,
                CastableToSetOfMapOperator,
                CastableToSetOfSetOperator,
        		BuilderOperator<T>,
        		ExecutableOperator<T>,
                CastableToTypeOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                ModifiableGrowableOperator<T> {



    public Level0GenericUniqSelectedOperator<T> ifIndex(final int... indices);
    public Level0GenericUniqSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T> ifNull();
    public Level0GenericUniqSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T> ifIndexNot(final int... indices);
    public Level0GenericUniqSelectedOperator<T> ifNotNull();
    public Level0GenericUniqSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);

    
    public Level0GenericUniqOperator<T> replaceWith(final T replacement);
    public Level0GenericUniqOperator<T> replaceIfNullWith(final T replacement);


    public <X> Level0GenericUniqOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X,? super T> eval);

    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> Level0GenericUniqOperator<X> asType(final Type<X> type);
    public Level0GenericUniqOperator<?> asUnknown();
        
    public Level0GenericMultiOperator<T> add(final T newElement);
    public Level0GenericMultiOperator<T> addAll(final T... newElements);
    public Level0GenericMultiOperator<T> insert(final int position, final T newElement);
    public Level0GenericMultiOperator<T> insertAll(final int position, final T... newElements);
    public Level0GenericMultiOperator<T> addAll(final Collection<T> collection);

    
    public Level0ListOperator<T> buildList();
    
    
    public Level0SetOperator<T> buildSet();
    
    
    public Level0ArrayOperator<T> buildArray(final Type<T> of);
    
    
    public <K> Level0MapOperator<K,T> buildMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V> buildMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfListOperator<K,T> buildMapOfList(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOfListOperator<K,V> buildMapOfList(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfSetOperator<K,T> buildMapOfSet(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOfSetOperator<K,V> buildMapOfSet(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfArrayOperator<K,T> buildMapOfArray(final Type<T> valueArrayOf, final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOfArrayOperator<K,V> buildMapOfArray(final Type<V> valueArrayOf, final IMapBuilder<K,V,? super T> mapBuild);

    
    
    public <X> Level0ArrayOperator<X> asArrayOf(final Type<X> type);
    public <X> Level0ListOperator<X> asListOf(final Type<X> type);
    public <K,V> Level0MapOperator<K,V> asMapOf(final Type<K> keyType, final Type<V> valueType);
    public <X> Level0SetOperator<X> asSetOf(final Type<X> type);
    public Level0ArrayOperator<?> asArrayOfUnknown();
    public Level0ListOperator<?> asListOfUnknown();
    public Level0MapOperator<?,?> asMapOfUnknown();
    public Level0SetOperator<?> asSetOfUnknown();
    
    
    
    public <X> Level0ArrayOfArrayOperator<X> asArrayOfArrayOf(final Type<X> type);
    public <X> Level0ArrayOfListOperator<X> asArrayOfListOf(final Type<X> type);
    public <K,V> Level0ArrayOfMapOperator<K,V> asArrayOfMapOf(final Type<K> keyType,final Type<V> valueType);
    public <X> Level0ArrayOfSetOperator<X> asArrayOfSetOf(final Type<X> type);
    public <X> Level0ListOfArrayOperator<X> asListOfArrayOf(final Type<X> type);
    public <X> Level0ListOfListOperator<X> asListOfListOf(final Type<X> type);
    public <K,V> Level0ListOfMapOperator<K,V> asListOfMapOf(final Type<K> keyType,final Type<V> valueType);
    public <X> Level0ListOfSetOperator<X> asListOfSetOf(final Type<X> type);
    public <K,V> Level0MapOfArrayOperator<K,V> asMapOfArrayOf(final Type<K> keyType, final Type<V> valueType);
    public <K,V> Level0MapOfListOperator<K,V> asMapOfListOf(final Type<K> keyType, final Type<V> valueType);
    public <K1,K2,V> Level0MapOfMapOperator<K1,K2,V> asMapOfMapOf(final Type<K1> key1Type, final Type<K2> key2Type, final Type<V> valueType);
    public <K,V> Level0MapOfSetOperator<K,V> asMapOfSetOf(final Type<K> keyType, final Type<V> valueType);
    public <X> Level0SetOfArrayOperator<X> asSetOfArrayOf(final Type<X> type);
    public <X> Level0SetOfListOperator<X> asSetOfListOf(final Type<X> type);
    public <K,V> Level0SetOfMapOperator<K,V> asSetOfMapOf(final Type<K> keyType,final Type<V> valueType);
    public <X> Level0SetOfSetOperator<X> asSetOfSetOf(final Type<X> type);
    public Level0ArrayOfArrayOperator<?> asArrayOfArrayOfUnknown();
    public Level0ArrayOfListOperator<?> asArrayOfListOfUnknown();
    public Level0ArrayOfMapOperator<?,?> asArrayOfMapOfUnknown();
    public Level0ArrayOfSetOperator<?> asArrayOfSetOfUnknown();
    public Level0ListOfArrayOperator<?> asListOfArrayOfUnknown();
    public Level0ListOfListOperator<?> asListOfListOfUnknown();
    public Level0ListOfMapOperator<?,?> asListOfMapOfUnknown();
    public Level0ListOfSetOperator<?> asListOfSetOfUnknown();
    public Level0MapOfArrayOperator<?,?> asMapOfArrayOfUnknown();
    public Level0MapOfListOperator<?,?> asMapOfListOfUnknown();
    public Level0MapOfMapOperator<?,?,?> asMapOfMapOfUnknown();
    public Level0MapOfSetOperator<?,?> asMapOfSetOfUnknown();
    public Level0SetOfArrayOperator<?> asSetOfArrayOfUnknown();
    public Level0SetOfListOperator<?> asSetOfListOfUnknown();
    public Level0SetOfMapOperator<?,?> asSetOfMapOfUnknown();
    public Level0SetOfSetOperator<?> asSetOfSetOfUnknown();
    
    
    
}

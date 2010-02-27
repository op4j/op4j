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
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.BuilderOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.CastableToMapOperator;
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
public interface Level0GenericUniqOperator<I,T>
        extends UniqOperator<T>,
                CastableToArrayOperator,
                CastableToListOperator,
                CastableToMapOperator,
                CastableToSetOperator,
        		BuilderOperator<I,T>,
        		ExecutableOperator<T>,
                CastableToTypeOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                ModifiableGrowableOperator<T> {



    public Level0GenericUniqSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval);
    public Level0GenericUniqSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval);
    public Level0GenericUniqSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval);
    public Level0GenericUniqSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public Level0GenericUniqSelectedOperator<I,T> ifNull();
    public Level0GenericUniqSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval);
    public Level0GenericUniqSelectedOperator<I,T> ifNotNull();
    public Level0GenericUniqSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval);

    
    public Level0GenericUniqOperator<I,T> replaceWith(final T replacement);
    public Level0GenericUniqOperator<I,T> replaceIfNullWith(final T replacement);


    public <X> Level0GenericUniqOperator<I,X> execIfNotNull(final IFunction<? super T,X> function);

    public <X> Level0GenericUniqOperator<I,X> exec(final IFunction<? super T,X> function);
    
    public <X> Level0GenericUniqOperator<I,X> asType(final Type<X> type);
    public Level0GenericUniqOperator<I,?> asUnknown();
        
    public Level0GenericMultiOperator<I,T> add(final T newElement);
    public Level0GenericMultiOperator<I,T> addAll(final T... newElements);
    public Level0GenericMultiOperator<I,T> insert(final int position, final T newElement);
    public Level0GenericMultiOperator<I,T> insertAll(final int position, final T... newElements);
    public Level0GenericMultiOperator<I,T> addAll(final Collection<T> collection);

    
    public Level0ListOperator<I,T> buildList();
    
    
    public Level0SetOperator<I,T> buildSet();
    
    
    public Level0ArrayOperator<I,T> buildArrayOf(final Type<T> type);
    
    
    public <K> Level0MapOperator<I,K,T> buildMapByKeyEval(final IFunction<? super T,K> keyEval);
    public <K,V> Level0MapOperator<I,K,V> buildMap(final IMapBuilder<? super T,K,V> mapBuilder);
    
    
    public <K> Level0MapOperator<I,K,List<T>> buildMapOfListByKeyEval(final IFunction<? super T,K> keyEval);
    public <K,V> Level0MapOperator<I,K,List<V>> buildMapOfList(final IMapBuilder<? super T,K,V> mapBuilder);
    
    
    public <K> Level0MapOperator<I,K,Set<T>> buildMapOfSetByKeyEval(final IFunction<? super T,K> keyEval);
    public <K,V> Level0MapOperator<I,K,Set<V>> buildMapOfSet(final IMapBuilder<? super T,K,V> mapBuilder);
    
    
    public <K> Level0MapOperator<I,K,T[]> buildMapOfArrayByKeyEvalOf(final Type<T> valueType, final IFunction<? super T,K> keyEval);
    public <K,V> Level0MapOperator<I,K,V[]> buildMapOfArrayOf(final Type<V> valueType, final IMapBuilder<? super T,K,V> mapBuilder);

    
    
    public <X> Level0ArrayOperator<I,X> asArrayOf(final Type<X> type);
    public <X> Level0ListOperator<I,X> asListOf(final Type<X> type);
    public <K,V> Level0MapOperator<I,K,V> asMapOf(final Type<K> keyType, final Type<V> valueType);
    public <X> Level0SetOperator<I,X> asSetOf(final Type<X> type);
    }

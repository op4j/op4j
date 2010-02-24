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
package org.op4j.operators.op.intf.generic;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.op.intf.array.Level0ArrayOperator;
import org.op4j.operators.op.intf.list.Level0ListOperator;
import org.op4j.operators.op.intf.map.Level0MapOperator;
import org.op4j.operators.op.intf.set.Level0SetOperator;
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
import org.op4j.operators.qualities.UniqOpOperator;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level0GenericUniqOperator<T,I>
        extends UniqOpOperator<T>,
                CastableToArrayOperator,
                CastableToListOperator,
                CastableToMapOperator,
                CastableToSetOperator,
        		BuilderOperator<T,I>,
        		ExecutableOperator<T>,
                CastableToTypeOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                ModifiableGrowableOperator<T> {



    public Level0GenericUniqSelectedOperator<T,I> ifIndex(final int... indexes);
    public Level0GenericUniqSelectedOperator<T,I> ifTrue(final IFunction<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T,I> ifFalse(final IFunction<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T,I> ifNull();
    public Level0GenericUniqSelectedOperator<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T,I> ifIndexNot(final int... indexes);
    public Level0GenericUniqSelectedOperator<T,I> ifNotNull();
    public Level0GenericUniqSelectedOperator<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval);

    
    public Level0GenericUniqOperator<T,I> replaceWith(final T replacement);
    public Level0GenericUniqOperator<T,I> replaceIfNullWith(final T replacement);


    public <X> Level0GenericUniqOperator<X,I> execIfNotNull(final IFunction<X,? super T> function);

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
    
    
    public Level0ArrayOperator<T,I> buildArrayOf(final Type<T> type);
    
    
    public <K> Level0MapOperator<K,T,I> buildMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V,I> buildMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOperator<K,List<T>,I> buildMapOfList(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,List<V>,I> buildMapOfList(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOperator<K,Set<T>,I> buildMapOfSet(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,Set<V>,I> buildMapOfSet(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOperator<K,T[],I> buildMapOfArrayOf(final Type<T> valueType, final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V[],I> buildMapOfArrayOf(final Type<V> valueType, final IMapBuilder<K,V,? super T> mapBuild);

    
    
    public <X> Level0ArrayOperator<X,I> asArrayOf(final Type<X> type);
    public <X> Level0ListOperator<X,I> asListOf(final Type<X> type);
    public <K,V> Level0MapOperator<K,V,I> asMapOf(final Type<K> keyType, final Type<V> valueType);
    public <X> Level0SetOperator<X,I> asSetOf(final Type<X> type);
    }

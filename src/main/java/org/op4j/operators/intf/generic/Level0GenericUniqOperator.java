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
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.BuilderOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.CastableToMapOfArrayOperator;
import org.op4j.operators.qualities.CastableToMapOfListOperator;
import org.op4j.operators.qualities.CastableToMapOfSetOperator;
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
public interface Level0GenericUniqOperator<T>
        extends UniqOperator<T>,
                CastableToArrayOperator,
                CastableToListOperator,
                CastableToMapOperator,
                CastableToSetOperator,
                CastableToMapOfArrayOperator,
                CastableToMapOfListOperator,
                CastableToMapOfSetOperator,
        		BuilderOperator<T>,
        		ExecutableOperator<T>,
                CastableToTypeOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                ModifiableGrowableOperator<T> {



    public Level0GenericUniqSelectedOperator<T> ifIndex(final int... indexes);
    public Level0GenericUniqSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T> ifNull();
    public Level0GenericUniqSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level0GenericUniqSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level0GenericUniqSelectedOperator<T> ifNotNull();
    public Level0GenericUniqSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval);

    
    public Level0GenericUniqOperator<T> replaceWith(final T replacement);
    public Level0GenericUniqOperator<T> replaceIfNullWith(final T replacement);


    public <X> Level0GenericUniqOperator<X> execIfNotNull(final IFunction<X,? super T> function);

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
    
    
    public Level0ArrayOperator<T> buildArrayOf(final Type<T> type);
    
    
    public <K> Level0MapOperator<K,T> buildMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V> buildMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfListOperator<K,T> buildMapOfList(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOfListOperator<K,V> buildMapOfList(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfSetOperator<K,T> buildMapOfSet(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOfSetOperator<K,V> buildMapOfSet(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfArrayOperator<K,T> buildMapOfArrayOf(final Type<T> valueType, final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOfArrayOperator<K,V> buildMapOfArrayOf(final Type<V> valueType, final IMapBuilder<K,V,? super T> mapBuild);

    
    
    public <X> Level0ArrayOperator<X> asArrayOf(final Type<X> type);
    public <X> Level0ListOperator<X> asListOf(final Type<X> type);
    public <K,V> Level0MapOperator<K,V> asMapOf(final Type<K> keyType, final Type<V> valueType);
    public <X> Level0SetOperator<X> asSetOf(final Type<X> type);
    public <K,V> Level0MapOfArrayOperator<K,V> asMapOfArrayOf(final Type<K> keyType, final Type<V> valueType);
    public <K,V> Level0MapOfListOperator<K,V> asMapOfListOf(final Type<K> keyType, final Type<V> valueType);
    public <K,V> Level0MapOfSetOperator<K,V> asMapOfSetOf(final Type<K> keyType, final Type<V> valueType);
    }

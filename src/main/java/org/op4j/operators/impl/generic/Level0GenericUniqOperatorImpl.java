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
package org.op4j.operators.impl.generic;

import java.util.Collection;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToMapOfArray;
import org.op4j.functions.converters.ToMapOfList;
import org.op4j.functions.converters.ToMapOfSet;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.structures.FList;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.mapofarray.Level0MapOfArrayOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level0MapOfListOperatorImpl;
import org.op4j.operators.impl.mapofset.Level0MapOfSetOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.generic.Level0GenericMultiOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqSelectedOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.CastType;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level0GenericUniqOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0GenericUniqOperator<T>  {

    
    public Level0GenericUniqOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<T> add(final T newElement) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.Add<T>(newElement)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperator<T> addAll(final T... newElements) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.Add<T>(newElements)).iterate(Structure.LIST, true));
    }

    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<T> insert(final int position, final T newElement) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.Insert<T>(position, newElement)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperator<T> insertAll(final int position, final T... newElements) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.Insert<T>(position, newElements)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperator<T> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.AddAll<T>(collection)).iterate(Structure.LIST, true));
    }


    public Level0ArrayOperator<T> buildArrayOf(final Type<T> type) {
        return new Level0ArrayOperatorImpl<T>(type, getTarget().execute(new ToArray.FromObject<T>(type)));
    }


    public Level0ListOperator<T> buildList() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ToList.FromObject<T>()));
    }


    public <K> Level0MapOperator<K, T> buildMap(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, V> buildMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public <K> Level0MapOfArrayOperator<K, T> buildMapOfArrayOf(final Type<T> valueType, final IFunction<K, ? super T> keyEval) {
        return new Level0MapOfArrayOperatorImpl<K, T>(valueType, getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfArray.FromListByKeyEval<K, T>(valueType, keyEval)));
    }


    public <K, V> Level0MapOfArrayOperator<K, V> buildMapOfArrayOf(final Type<V> valueType, final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfArrayOperatorImpl<K, V>(valueType, getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfArray.FromListByMapBuilder<K, V, T>(valueType, mapBuild)));
    }


    public <K> Level0MapOfListOperator<K, T> buildMapOfList(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOfListOperatorImpl<K, T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfList.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOfListOperator<K, V> buildMapOfList(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfListOperatorImpl<K, V>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfList.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public <K> Level0MapOfSetOperator<K, T> buildMapOfSet(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOfSetOperatorImpl<K, T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfSet.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOfSetOperator<K, V> buildMapOfSet(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfSet.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0SetOperator<T> buildSet() {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new ToSet.FromObject<T>()));
    }


    public <X> Level0ArrayOperator<X> asArrayOf(final Type<X> type) {
        return new Level0ArrayOperatorImpl<X>(type, getTarget().cast(CastType.ARRAY, type));
    }


    public <X> Level0ListOperator<X> asListOf(final Type<X> type) {
        return new Level0ListOperatorImpl<X>(getTarget().cast(CastType.LIST, type));
    }


    public <K,V> Level0MapOperator<K,V> asMapOf(final Type<K> keyType, final Type<V> valueType) {
        return new Level0MapOperatorImpl<K,V>(getTarget().cast(CastType.MAP, keyType, valueType));
    }


    public <X> Level0SetOperator<X> asSetOf(final Type<X> type) {
        return new Level0SetOperatorImpl<X>(getTarget().cast(CastType.SET, type));
    }


    public <K, V> Level0MapOfArrayOperator<K, V> asMapOfArrayOf(final Type<K> keyType, final Type<V> valueType) {
        return new Level0MapOfArrayOperatorImpl<K,V>(valueType, getTarget().cast(CastType.MAP_OF_ARRAY, keyType, valueType));
    }


    public <K, V> Level0MapOfListOperator<K, V> asMapOfListOf(final Type<K> keyType, final Type<V> valueType) {
        return new Level0MapOfListOperatorImpl<K,V>(getTarget().cast(CastType.MAP_OF_LIST, keyType, valueType));
    }


    public <K, V> Level0MapOfSetOperator<K, V> asMapOfSetOf(final Type<K> keyType, final Type<V> valueType) {
        return new Level0MapOfSetOperatorImpl<K,V>(getTarget().cast(CastType.MAP_OF_SET, keyType, valueType));
    }


    public <X> Level0GenericUniqOperator<X> asType(final Type<X> type) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().cast(CastType.OBJECT, type));
    }

    public Level0GenericUniqOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    


    


    


    


    


    


    

    
    







    @SuppressWarnings("unchecked")
    public T get() {
        return (T) getTarget().get();
    }


    public Level0GenericUniqSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level0GenericUniqSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level0GenericUniqSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T> ifNotNull() {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0GenericUniqSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T> ifNull() {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0GenericUniqSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0GenericUniqOperator<X> execIfNotNull(final IFunction<X, ? super T> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<T> replaceWith(final T replacement) {
        return new Level0GenericUniqOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
    
    
    
}

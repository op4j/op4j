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
package org.op4j.operators.impl.fn.generic;

import java.util.Collection;
import java.util.List;
import java.util.Set;

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
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.impl.fn.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.fn.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.fn.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.fn.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.qualities.UniqFnOperator;
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
public final class Level0GenericUniqOperatorImpl<I,T> extends AbstractOperatorImpl
        implements UniqFnOperator<I,T>, Level0GenericUniqOperator<I,T>  {

    
    public Level0GenericUniqOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperatorImpl<I,T> add(final T newElement) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.Add<T>(newElement)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperatorImpl<I,T> addAll(final T... newElements) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.Add<T>(newElements)).iterate(Structure.LIST, true));
    }

    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperatorImpl<I,T> insert(final int position, final T newElement) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.Insert<T>(position, newElement)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperatorImpl<I,T> insertAll(final int position, final T... newElements) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.Insert<T>(position, newElements)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperatorImpl<I,T> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.AddAll<T>(collection)).iterate(Structure.LIST, true));
    }


    public Level0ArrayOperatorImpl<I,T> buildArrayOf(final Type<T> type) {
        return new Level0ArrayOperatorImpl<I,T>(type, getTarget().execute(new ToArray.FromObject<T>(type)));
    }


    public Level0ListOperatorImpl<I,T> buildList() {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(new ToList.FromObject<T>()));
    }


    public <K> Level0MapOperatorImpl<I,K, T> buildMap(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<I,K, T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperatorImpl<I,K, V> buildMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public <K> Level0MapOperatorImpl<I,K, T[]> buildMapOfArrayOf(final Type<T> valueType, final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<I,K, T[]>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfArray.FromListByKeyEval<K, T>(valueType, keyEval)));
    }


    public <K, V> Level0MapOperatorImpl<I,K, V[]> buildMapOfArrayOf(final Type<V> valueType, final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<I,K, V[]>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfArray.FromListByMapBuilder<K, V, T>(valueType, mapBuild)));
    }


    public <K> Level0MapOperatorImpl<I,K, List<T>> buildMapOfList(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<I,K, List<T>>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfList.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperatorImpl<I,K, List<V>> buildMapOfList(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<I,K, List<V>>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfList.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public <K> Level0MapOperatorImpl<I,K, Set<T>> buildMapOfSet(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<I,K, Set<T>>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfSet.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperatorImpl<I,K, Set<V>> buildMapOfSet(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<I,K, Set<V>>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfSet.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0SetOperatorImpl<I,T> buildSet() {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(new ToSet.FromObject<T>()));
    }


    public <X> Level0ArrayOperatorImpl<I,X> asArrayOf(final Type<X> type) {
        return new Level0ArrayOperatorImpl<I,X>(type, getTarget().cast(CastType.ARRAY, type));
    }


    public <X> Level0ListOperatorImpl<I,X> asListOf(final Type<X> type) {
        return new Level0ListOperatorImpl<I,X>(getTarget().cast(CastType.LIST, type));
    }


    public <K,V> Level0MapOperatorImpl<I,K,V> asMapOf(final Type<K> keyType, final Type<V> valueType) {
        return new Level0MapOperatorImpl<I,K,V>(getTarget().cast(CastType.MAP, keyType, valueType));
    }


    public <X> Level0SetOperatorImpl<I,X> asSetOf(final Type<X> type) {
        return new Level0SetOperatorImpl<I,X>(getTarget().cast(CastType.SET, type));
    }


    public <X> Level0GenericUniqOperatorImpl<I,X> asType(final Type<X> type) {
        return new Level0GenericUniqOperatorImpl<I,X>(getTarget().cast(CastType.OBJECT, type));
    }

    public Level0GenericUniqOperatorImpl<I,?> asUnknown() {
        return asType(Types.OBJECT);
    }


    


    


    


    


    


    


    

    
    







    @SuppressWarnings("unchecked")
    public T get() {
        return (T) getTarget().get();
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifIndex(final int... indexes) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectIndex(indexes));
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifIndexNot(final int... indexes) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectMatching(eval));
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifNotNull() {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectNotNull());
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifNull() {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectNull());
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0GenericUniqOperatorImpl<I,X> execIfNotNull(final IFunction<X, ? super T> function) {
        return new Level0GenericUniqOperatorImpl<I,X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperatorImpl<I,X> exec(final IFunction<X, ? super T> function) {
        return new Level0GenericUniqOperatorImpl<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericUniqOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level0GenericUniqOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level0GenericUniqOperatorImpl<I,T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
    
    
    
}

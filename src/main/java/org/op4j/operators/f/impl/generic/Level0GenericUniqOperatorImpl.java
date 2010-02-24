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
package org.op4j.operators.f.impl.generic;

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
import org.op4j.operators.f.impl.AbstractOperatorImpl;
import org.op4j.operators.f.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.f.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.f.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.f.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.op.intf.array.Level0ArrayOperator;
import org.op4j.operators.op.intf.generic.Level0GenericMultiOperator;
import org.op4j.operators.op.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.op.intf.generic.Level0GenericUniqSelectedOperator;
import org.op4j.operators.op.intf.list.Level0ListOperator;
import org.op4j.operators.op.intf.map.Level0MapOperator;
import org.op4j.operators.op.intf.set.Level0SetOperator;
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
public final class Level0GenericUniqOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level0GenericUniqOperator<T,I>  {

    
    public Level0GenericUniqOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<T,I> add(final T newElement) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.Add<T>(newElement)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperator<T,I> addAll(final T... newElements) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.Add<T>(newElements)).iterate(Structure.LIST, true));
    }

    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<T,I> insert(final int position, final T newElement) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.Insert<T>(position, newElement)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.Insert<T>(position, newElements)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperator<T,I> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new FList.AddAll<T>(collection)).iterate(Structure.LIST, true));
    }


    public Level0ArrayOperator<T,I> buildArrayOf(final Type<T> type) {
        return new Level0ArrayOperatorImpl<T,I>(type, getTarget().execute(new ToArray.FromObject<T>(type)));
    }


    public Level0ListOperator<T,I> buildList() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ToList.FromObject<T>()));
    }


    public <K> Level0MapOperator<K, T,I> buildMap(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, V,I> buildMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public <K> Level0MapOperator<K, T[],I> buildMapOfArrayOf(final Type<T> valueType, final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T[],I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfArray.FromListByKeyEval<K, T>(valueType, keyEval)));
    }


    public <K, V> Level0MapOperator<K, V[],I> buildMapOfArrayOf(final Type<V> valueType, final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V[],I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfArray.FromListByMapBuilder<K, V, T>(valueType, mapBuild)));
    }


    public <K> Level0MapOperator<K, List<T>,I> buildMapOfList(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, List<T>,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfList.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, List<V>,I> buildMapOfList(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, List<V>,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfList.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public <K> Level0MapOperator<K, Set<T>,I> buildMapOfSet(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, Set<T>,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfSet.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, Set<V>,I> buildMapOfSet(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, Set<V>,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfSet.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0SetOperator<T,I> buildSet() {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new ToSet.FromObject<T>()));
    }


    public <X> Level0ArrayOperator<X,I> asArrayOf(final Type<X> type) {
        return new Level0ArrayOperatorImpl<X,I>(type, getTarget().cast(CastType.ARRAY, type));
    }


    public <X> Level0ListOperator<X,I> asListOf(final Type<X> type) {
        return new Level0ListOperatorImpl<X,I>(getTarget().cast(CastType.LIST, type));
    }


    public <K,V> Level0MapOperator<K,V,I> asMapOf(final Type<K> keyType, final Type<V> valueType) {
        return new Level0MapOperatorImpl<K,V,I>(getTarget().cast(CastType.MAP, keyType, valueType));
    }


    public <X> Level0SetOperator<X,I> asSetOf(final Type<X> type) {
        return new Level0SetOperatorImpl<X,I>(getTarget().cast(CastType.SET, type));
    }


    public <X> Level0GenericUniqOperator<X,I> asType(final Type<X> type) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().cast(CastType.OBJECT, type));
    }

    public Level0GenericUniqOperator<?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    


    


    


    


    


    


    

    
    







    @SuppressWarnings("unchecked")
    public T get() {
        return (T) getTarget().get();
    }


    public Level0GenericUniqSelectedOperator<T,I> ifIndex(final int... indexes) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectIndex(indexes));
    }


    public Level0GenericUniqSelectedOperator<T,I> ifIndexNot(final int... indexes) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indexes));
    }


    public Level0GenericUniqSelectedOperator<T,I> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T,I> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T,I> ifNotNull() {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level0GenericUniqSelectedOperator<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T,I> ifNull() {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level0GenericUniqSelectedOperator<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0GenericUniqOperator<X,I> execIfNotNull(final IFunction<X, ? super T> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final IFunction<X, ? super T> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<T,I> replaceWith(final T replacement) {
        return new Level0GenericUniqOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<T,I> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
    
    
    
}

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
import org.op4j.functions.FnList;
import org.op4j.functions.FnObject;
import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
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


    public Level0GenericMultiOperatorImpl<I,T> add(final T newElement) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().add(newElement)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperatorImpl<I,T> addAll(final T... newElements) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().add(newElements)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperatorImpl<I,T> insert(final int position, final T newElement) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().insert(position, newElement)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperatorImpl<I,T> insertAll(final int position, final T... newElements) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().insert(position, newElements)).iterate(Structure.LIST, true));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperatorImpl<I,T> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().addAll((Collection)collection)).iterate(Structure.LIST, true));
    }


    public Level0ArrayOperatorImpl<I,T> buildArrayOf(final Type<T> type) {
        return new Level0ArrayOperatorImpl<I,T>(type, getTarget().execute(FnObject.toSingletonArrayOf(type)));
    }


    public Level0ListOperatorImpl<I,T> buildList() {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperatorImpl<I,K, T> buildMapByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperatorImpl<I,K, T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMapByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperatorImpl<I,K, V> buildMap(final IMapBuilder<? super T,K,V> mapBuilder) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMap((IMapBuilder)mapBuilder)));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperatorImpl<I,K, T[]> buildMapOfArrayByKeyEvalOf(final Type<T> valueType, final IFunction<? super T,K> keyEval) {
        return new Level0MapOperatorImpl<I,K, T[]>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.of(valueType).toMapOfArrayByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperatorImpl<I,K, V[]> buildMapOfArrayOf(final Type<V> valueType, final IMapBuilder<? super T,K,V> mapBuilder) {
        return new Level0MapOperatorImpl<I,K, V[]>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMapOfArrayOf(valueType, (IMapBuilder)mapBuilder)));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperatorImpl<I,K, List<T>> buildMapOfListByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperatorImpl<I,K, List<T>>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMapOfListByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperatorImpl<I,K, List<V>> buildMapOfList(final IMapBuilder<? super T,K,V> mapBuilder) {
        return new Level0MapOperatorImpl<I,K, List<V>>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMapOfList((IMapBuilder)mapBuilder)));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperatorImpl<I,K, Set<T>> buildMapOfSetByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperatorImpl<I,K, Set<T>>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMapOfSetByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperatorImpl<I,K, Set<V>> buildMapOfSet(final IMapBuilder<? super T,K,V> mapBuilder) {
        return new Level0MapOperatorImpl<I,K, Set<V>>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMapOfSet((IMapBuilder)mapBuilder)));
    }


    public Level0SetOperatorImpl<I,T> buildSet() {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnObject.toSingletonSetOf(Types.OBJECT)));
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

    


    


    


    


    


    


    


    

    
    







    public Function<I,T> get() {
        return new Function<I,T>(getTarget());
    }




    public Level0GenericUniqSelectedOperatorImpl<I,T> ifTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectMatching(eval));
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifNotNull() {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectNotNull());
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifNull() {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectNull());
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0GenericUniqSelectedOperatorImpl<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<I,T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0GenericUniqOperatorImpl<I,X> execIfNotNull(final IFunction<? super T,X> function) {
        return new Level0GenericUniqOperatorImpl<I,X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperatorImpl<I,X> exec(final IFunction<? super T,X> function) {
        return new Level0GenericUniqOperatorImpl<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericUniqOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level0GenericUniqOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level0GenericUniqOperatorImpl<I,T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
    
    
    
}

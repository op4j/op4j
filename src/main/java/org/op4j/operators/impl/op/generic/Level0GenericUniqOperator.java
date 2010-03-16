/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
package org.op4j.operators.impl.op.generic;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.FnArray;
import org.op4j.functions.FnList;
import org.op4j.functions.FnObject;
import org.op4j.functions.FnSet;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.impl.op.array.Level0ArrayOperator;
import org.op4j.operators.impl.op.list.Level0ListOperator;
import org.op4j.operators.impl.op.map.Level0MapOperator;
import org.op4j.operators.impl.op.set.Level0SetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.CastType;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.ValuePair;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level0GenericUniqOperator<I,T> extends AbstractOperator
        implements UniqOpOperator<I,T>, ILevel0GenericUniqOperator<I,T>  {

    
    public Level0GenericUniqOperator(final Target target) {
        super(target);
    }


    public Level0GenericMultiOperator<I,T> add(final T newElement) {
        return new Level0GenericMultiOperator<I,T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().add(newElement)).iterate(Structure.LIST));
    }

    public Level0GenericMultiOperator<I,T> addAll(final T... newElements) {
        return new Level0GenericMultiOperator<I,T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().add(newElements)).iterate(Structure.LIST));
    }

    public Level0GenericMultiOperator<I,T> insert(final int position, final T newElement) {
        return new Level0GenericMultiOperator<I,T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().insert(position, newElement)).iterate(Structure.LIST));
    }

    public Level0GenericMultiOperator<I,T> insertAll(final int position, final T... newElements) {
        return new Level0GenericMultiOperator<I,T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().insert(position, newElements)).iterate(Structure.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<I,T> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperator<I,T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().addAll((Collection)collection)).iterate(Structure.LIST));
    }


    public Level0ArrayOperator<I,T> buildArrayOf(final Type<T> type) {
        return new Level0ArrayOperator<I,T>(type, getTarget().execute(FnObject.toSingletonArrayOf(type)));
    }


    public Level0ListOperator<I,T> buildList() {
        return new Level0ListOperator<I,T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K, T> buildMapByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K, T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMapByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K, V> buildMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMap((IFunction)mapBuilder)));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K, T[]> buildMapOfArrayByKeyEvalOf(final Type<T> valueType, final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K, T[]>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.of(valueType).toMapOfArrayByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K, V[]> buildMapOfArrayOf(final Type<V> valueType, final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K, V[]>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMapOfArrayOf(valueType, (IFunction)mapBuilder)));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K, List<T>> buildMapOfListByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K, List<T>>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMapOfListByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K, List<V>> buildMapOfList(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K, List<V>>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMapOfList((IFunction)mapBuilder)));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K, Set<T>> buildMapOfSetByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K, Set<T>>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMapOfSetByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K, Set<V>> buildMapOfSet(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K, Set<V>>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMapOfSet((IFunction)mapBuilder)));
    }


    public Level0SetOperator<I,T> buildSet() {
        return new Level0SetOperator<I,T>(getTarget().execute(FnObject.toSingletonSetOf(Types.OBJECT)));
    }


    public <X> Level0ArrayOperator<I,X> asArrayOf(final Type<X> type) {
        return new Level0ArrayOperator<I,X>(type, getTarget().cast(CastType.ARRAY, type));
    }


    public <X> Level0ListOperator<I,X> asListOf(final Type<X> type) {
        return new Level0ListOperator<I,X>(getTarget().cast(CastType.LIST, type));
    }


    public <K,V> Level0MapOperator<I,K,V> asMapOf(final Type<K> keyType, final Type<V> valueType) {
        return new Level0MapOperator<I,K,V>(getTarget().cast(CastType.MAP, keyType, valueType));
    }


    public <X> Level0SetOperator<I,X> asSetOf(final Type<X> type) {
        return new Level0SetOperator<I,X>(getTarget().cast(CastType.SET, type));
    }


    public <X> Level0GenericUniqOperator<I,X> asType(final Type<X> type) {
        return new Level0GenericUniqOperator<I,X>(getTarget().cast(CastType.OBJECT, type));
    }

    


    


    


    


    


    


    


    

    
    







    @SuppressWarnings("unchecked")
    public T get() {
        return (T) getTarget().get();
    }




    public Level0GenericUniqSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericUniqSelectedOperator<I,T>(getTarget().selectMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericUniqSelectedOperator<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<I,T> ifNotNull() {
        return new Level0GenericUniqSelectedOperator<I,T>(getTarget().selectNotNull());
    }


    public Level0GenericUniqSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericUniqSelectedOperator<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericUniqSelectedOperator<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<I,T> ifNull() {
        return new Level0GenericUniqSelectedOperator<I,T>(getTarget().selectNull());
    }


    public Level0GenericUniqSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericUniqSelectedOperator<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericUniqSelectedOperator<I,T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0GenericUniqOperator<I,X> execIfNotNull(final IFunction<? super T,X> function) {
        return new Level0GenericUniqOperator<I,X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<I,X> exec(final IFunction<? super T,X> function) {
        return new Level0GenericUniqOperator<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<I,T> replaceWith(final T replacement) {
        return new Level0GenericUniqOperator<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<I,T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    @SuppressWarnings("unchecked")
    public Level0GenericUniqOperator<I, T> reduce(final IFunction<? extends ValuePair<? super T,? super T>, ? extends T> reductor) {
        return new Level0GenericUniqOperator<I, T>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.of((Type<T>)Types.OBJECT).reduce(reductor)));
    }



    @SuppressWarnings("unchecked")
    public <X> Level0GenericUniqOperator<I, X> reduce(final IFunction<? extends ValuePair<? super X,? super T>,X> reductor, final X initialValue) {
        return new Level0GenericUniqOperator<I, X>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.of((Type<T>)Types.OBJECT).reduce(reductor, initialValue)));
    }

    
    

    
    public Level0ArrayOperator<I, T> unfoldArrayOf(final Type<T> type, final IFunction<? super T, ? extends T> function) {
        return new Level0ArrayOperator<I, T>(type, getTarget().execute(FnArray.of(type).unfold(function)));
    }

    public Level0ArrayOperator<I, T> unfoldArrayOf(final Type<T> type, final IFunction<? super T, ? extends T> function, final IFunction<? super T, Boolean> whileCondition) {
        return new Level0ArrayOperator<I, T>(type, getTarget().execute(FnArray.of(type).unfold(function, whileCondition)));
    }

    @SuppressWarnings("unchecked")
    public Level0ListOperator<I, T> unfoldList(final IFunction<? super T, ? extends T> function) {
        return new Level0ListOperator<I, T>(getTarget().execute(FnList.of((Type<T>)Types.OBJECT).unfold(function)));
    }

    @SuppressWarnings("unchecked")
    public Level0ListOperator<I, T> unfoldList(final IFunction<? super T, ? extends T> function, final IFunction<? super T, Boolean> whileCondition) {
        return new Level0ListOperator<I, T>(getTarget().execute(FnList.of((Type<T>)Types.OBJECT).unfold(function, whileCondition)));
    }

    @SuppressWarnings("unchecked")
    public Level0SetOperator<I, T> unfoldSet(final IFunction<? super T, ? extends T> function) {
        return new Level0SetOperator<I, T>(getTarget().execute(FnSet.of((Type<T>)Types.OBJECT).unfold(function)));
    }

    @SuppressWarnings("unchecked")
    public Level0SetOperator<I, T> unfoldSet(final IFunction<? super T, ? extends T> function, final IFunction<? super T, Boolean> whileCondition) {
        return new Level0SetOperator<I, T>(getTarget().execute(FnSet.of((Type<T>)Types.OBJECT).unfold(function, whileCondition)));
    }
    
    
    
    
    
    
    

    @SuppressWarnings("unchecked")
    public Level0GenericUniqOperator<I, Boolean> all(final IFunction<? super T, Boolean> eval) {
        return new Level0GenericUniqOperator<I, Boolean>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.of((Type<T>)Types.OBJECT).all(eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericUniqOperator<I, Boolean> any(final IFunction<? super T, Boolean> eval) {
        return new Level0GenericUniqOperator<I, Boolean>(getTarget().execute(FnObject.toSingletonListOf(Types.OBJECT)).execute(FnList.of((Type<T>)Types.OBJECT).any(eval)));
    }
    
    
    
}

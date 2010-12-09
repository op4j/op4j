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
package org.op4j.operators.impl.fn.generic;

import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.ExpressionFunction;
import org.op4j.functions.FnList;
import org.op4j.functions.FnObject;
import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.impl.fn.array.Level0ArrayOperator;
import org.op4j.operators.impl.fn.list.Level0ListOperator;
import org.op4j.operators.impl.fn.map.Level0MapOperator;
import org.op4j.operators.impl.fn.set.Level0SetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.CastType;
import org.op4j.target.Target.Normalisation;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level0GenericUniqOperator<I,T> extends AbstractOperator
        implements UniqFnOperator<I,T>, ILevel0GenericUniqOperator<I,T>  {

    
    public Level0GenericUniqOperator(final Target target) {
        super(target);
    }


    public Level0ArrayOperator<I,T> intoSingletonArrayOf(final Type<T> type) {
        return new Level0ArrayOperator<I,T>(type, getTarget().execute(FnObject.intoSingletonArrayOf(type)));
    }


    public Level0ListOperator<I,T> intoSingletonList() {
        return new Level0ListOperator<I,T>(getTarget().execute(FnObject.intoSingletonListOf(Types.OBJECT)));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K, T> zipKeyBy(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K, T>(getTarget().execute(FnObject.intoSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().zipKeysBy((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <V> Level0MapOperator<I,T, V> zipValueBy(final IFunction<? super T,V> valueEval) {
        return new Level0MapOperator<I,T, V>(getTarget().execute(FnObject.intoSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().zipValuesBy((IFunction)valueEval)));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K, T> zipKey(final K key) {
        return new Level0MapOperator<I,K, T>(getTarget().execute(FnObject.intoSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().zipKeys(key)));
    }


    @SuppressWarnings("unchecked")
    public <V> Level0MapOperator<I,T, V> zipValue(final V value) {
        return new Level0MapOperator<I,T, V>(getTarget().execute(FnObject.intoSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().zipValues(value)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K, V> intoSingletonMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnObject.intoSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMap((IFunction)mapBuilder)));
    }


    public Level0SetOperator<I,T> intoSingletonSet() {
        return new Level0SetOperator<I,T>(getTarget().execute(FnObject.intoSingletonSetOf(Types.OBJECT)));
    }


    public <X> Level0ArrayOperator<I,X> castToArrayOf(final Type<X> type) {
        return new Level0ArrayOperator<I,X>(type, getTarget().cast(CastType.ARRAY, type));
    }


    public <X> Level0ListOperator<I,X> castToListOf(final Type<X> type) {
        return new Level0ListOperator<I,X>(getTarget().cast(CastType.LIST, type));
    }


    public <K,V> Level0MapOperator<I,K,V> castToMapOf(final Type<K> keyType, final Type<V> valueType) {
        return new Level0MapOperator<I,K,V>(getTarget().cast(CastType.MAP, keyType, valueType));
    }


    public <X> Level0SetOperator<I,X> castToSetOf(final Type<X> type) {
        return new Level0SetOperator<I,X>(getTarget().cast(CastType.SET, type));
    }


    public <X> Level0GenericUniqOperator<I,X> castTo(final Type<X> type) {
        return new Level0GenericUniqOperator<I,X>(getTarget().cast(CastType.OBJECT, type));
    }

    


    


    


    


    


    


    


    

    
    







    public Function<I,T> get() {
        return new ExpressionFunction<I,T>(getTarget());
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


    


    


    public Level0GenericUniqSelectedOperator<I,T> ifNull() {
        return new Level0GenericUniqSelectedOperator<I,T>(getTarget().selectNull());
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


    
    


    
    
    
    
    
    
    public Level0GenericUniqOperator<I, T> execIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T, ? extends T> function) {
        return new Level0GenericUniqOperator<I, T>(getTarget().executeIfFalse(eval, function, null, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<I, X> execIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level0GenericUniqOperator<I, X>(getTarget().executeIfFalse(eval, function, elseFunction, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<I, T> execIfNotNull(final IFunction<? super T, ? extends T> function) {
        return new Level0GenericUniqOperator<I, T>(getTarget().executeIfNotNull(function, null, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<I, X> execIfNotNull(final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level0GenericUniqOperator<I, X>(getTarget().executeIfNotNull(function, elseFunction, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<I, T> execIfNull(final IFunction<? super T, ? extends T> function) {
        return new Level0GenericUniqOperator<I, T>(getTarget().executeIfNull(function, null, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<I, X> execIfNull(final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level0GenericUniqOperator<I, X>(getTarget().executeIfNull(function, elseFunction, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<I, T> execIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T, ? extends T> function) {
        return new Level0GenericUniqOperator<I, T>(getTarget().executeIfTrue(eval, function, null, Normalisation.NONE));
    }

    
    public <X> Level0GenericUniqOperator<I, X> execIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level0GenericUniqOperator<I, X>(getTarget().executeIfTrue(eval, function, elseFunction, Normalisation.NONE));
    }
    
    
    
    
}

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
package org.op4j.operators.impl.fn.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.ExpressionFunction;
import org.op4j.functions.FnList;
import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.impl.fn.array.Level0ArrayOperator;
import org.op4j.operators.impl.fn.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.fn.map.Level0MapOperator;
import org.op4j.operators.impl.fn.set.Level0SetOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level0ListOperator<I,T> extends AbstractOperator
        implements UniqFnOperator<I,List<T>>, ILevel0ListOperator<I,T>  {

    
    public Level0ListOperator(final Target target) {
        super(target);
    }


    public Level0ListOperator<I,T> add(final T newElement) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().add(newElement)));
    }

    public Level0ListOperator<I,T> addAll(final T... newElements) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().add(newElements)));
    }


    public Level0ListOperator<I,T> insert(final int position, final T newElement) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().insert(position, newElement)));
    }

    public Level0ListOperator<I,T> insertAll(final int position, final T... newElements) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().insert(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperator<I,T> addAll(final Collection<T> collection) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().addAll((Collection)collection)));
    }


    public Level0ListOperator<I,T> distinct() {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().distinct()));
    }


    public Level1ListElementsOperator<I,T> forEach() {
        return new Level1ListElementsOperator<I,T>(getTarget().iterate(Structure.LIST));
    }


    public Level0ListOperator<I,T> removeAllIndexes(final int... indexes) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllIndexes(indexes)));
    }


    public Level0ListOperator<I,T> removeAllEqual(final T... values) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllEqual(values)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllTrue((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0ListOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllFalse((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0ListOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllNullOrFalse((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0ListOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllNotNullAndFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllNullOrTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllNotNullAndTrue((IFunction)eval)));
    }


    public Level0ListOperator<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllIndexesNot(indexes)));
    }


    public Level0ListOperator<I,T> removeAllNull() {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllNull()));
    }

    


    public Level0ListOperator<I,T> sort() {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().sort()));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperator<I,T> sort(final Comparator<? super T> comparator) {
        return new Level0ListOperator<I,T>(getTarget().execute(FnList.ofObject().sort((Comparator)comparator)));
    }


    public Level0ArrayOperator<I,T> toArrayOf(final Type<T> type) {
        return new Level0ArrayOperator<I,T>(type, getTarget().execute(FnList.of(type).toArray()));
    }


    public Level0MapOperator<I,T, T> couple() {
        return new Level0MapOperator<I,T, T>(getTarget().execute(FnList.ofObject().couple()));
    }

    public Level0MapOperator<I,T,List<T>> coupleAndGroup() {
        return new Level0MapOperator<I,T,List<T>>(getTarget().execute(FnList.ofObject().coupleAndGroup()));
    }

    
    
    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K,T> zipKeysBy(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K,T>(getTarget().execute(FnList.ofObject().zipKeysBy((IFunction)keyEval)));
    }

    @SuppressWarnings("unchecked")
    public <V> Level0MapOperator<I,T,V> zipValuesBy(final IFunction<? super T,V> valueEval) {
        return new Level0MapOperator<I,T,V>(getTarget().execute(FnList.ofObject().zipValuesBy((IFunction)valueEval)));
    }

    public <K> Level0MapOperator<I,K,T> zipKeys(final K... keys) {
        return new Level0MapOperator<I,K,T>(getTarget().execute(FnList.ofObject().zipKeys(keys)));
    }

    public <V> Level0MapOperator<I,T,V> zipValues(final V... values) {
        return new Level0MapOperator<I,T,V>(getTarget().execute(FnList.ofObject().zipValues(values)));
    }


    
    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K,List<T>> zipAndGroupKeysBy(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K,List<T>>(getTarget().execute(FnList.ofObject().zipAndGroupKeysBy((IFunction)keyEval)));
    }

    @SuppressWarnings("unchecked")
    public <V> Level0MapOperator<I,T,List<V>> zipAndGroupValuesBy(final IFunction<? super T,V> valueEval) {
        return new Level0MapOperator<I,T,List<V>>(getTarget().execute(FnList.ofObject().zipAndGroupValuesBy((IFunction)valueEval)));
    }
    
    public <K> Level0MapOperator<I,K,List<T>> zipAndGroupKeys(final K... keys) {
        return new Level0MapOperator<I,K,List<T>>(getTarget().execute(FnList.ofObject().zipAndGroupKeys(keys)));
    }

    public <V> Level0MapOperator<I,T,List<V>> zipAndGroupValues(final V... values) {
        return new Level0MapOperator<I,T,List<V>>(getTarget().execute(FnList.ofObject().zipAndGroupValues(values)));
    }

    
    
    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K,V> toMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K,V>(getTarget().execute(FnList.ofObject().toMap((IFunction)mapBuilder)));
    }

    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K,List<V>> toGroupMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K,List<V>>(getTarget().execute(FnList.ofObject().toGroupMap((IFunction)mapBuilder)));
    }


    public Level0SetOperator<I,T> toSet() {
        return new Level0SetOperator<I,T>(getTarget().execute(FnList.ofObject().toSet()));
    }


    public Function<I,List<T>> get() {
        return new ExpressionFunction<I, List<T>>(getTarget());
    }


    public Level0GenericUniqOperator<I,List<T>> generic() {
        return new Level0GenericUniqOperator<I,List<T>>(getTarget());
    }
    
    
    
    
    
	public <X> Level0ListOperator<I,X> of(final Type<X> type) {
        return generic().castToListOf(type);
    }
    
    public <X> Level0ListOperator<I,X> castToListOf(final Type<X> type) {
        return generic().castToListOf(type);
    }


    


    public Level0ListSelectedOperator<I,T> ifTrue(final IFunction<? super List<T>,Boolean> eval) {
        return new Level0ListSelectedOperator<I,T>(getTarget().selectMatching(eval));
    }


    public Level0ListSelectedOperator<I,T> ifFalse(final IFunction<? super List<T>,Boolean> eval) {
        return new Level0ListSelectedOperator<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level0ListSelectedOperator<I,T> ifNotNull() {
        return new Level0ListSelectedOperator<I,T>(getTarget().selectNotNull());
    }


    


    


    public Level0ListSelectedOperator<I,T> ifNull() {
        return new Level0ListSelectedOperator<I,T>(getTarget().selectNull());
    }


    


    




    public <X> Level0ListOperator<I,X> execAsList(final IFunction<? super List<T>,? extends List<X>> function) {
        return new Level0ListOperator<I,X>(getTarget().execute(function, Normalisation.LIST));
    }


    


    public <X> Level0GenericUniqOperator<I,X> exec(final IFunction<? super List<T>,X> function) {
        return new Level0GenericUniqOperator<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0ListOperator<I,T> replaceWith(final List<T> replacement) {
        return new Level0ListOperator<I,T>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public Level0ListOperator<I,T> replaceIfNullWith(final List<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    public <X> Level0ListOperator<I,X> map(final IFunction<? super T,X> function) {
        return new Level0ListOperator<I,X>(getTarget().map(Structure.LIST, function, null));
    }
    

    

    
    


    
    

    @SuppressWarnings("unchecked")
    public Level0GenericUniqOperator<I, Boolean> all(final IFunction<? super T, Boolean> eval) {
        return new Level0GenericUniqOperator<I, Boolean>(getTarget().execute(FnList.of((Type<T>)Types.OBJECT).all(eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericUniqOperator<I, Boolean> any(final IFunction<? super T, Boolean> eval) {
        return new Level0GenericUniqOperator<I, Boolean>(getTarget().execute(FnList.of((Type<T>)Types.OBJECT).any(eval)));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOperator<I, T> sortBy(IFunction<? super T, ?> by) {
        return new Level0ListOperator<I, T>(getTarget().execute(FnList.of((Type<T>)Types.OBJECT).sortBy(by)));
    }

    
    
    
    
    
    
    
    
    
    public <K> Level0MapOperator<I, K, List<T>> zipAndGroupKeysFrom(final Collection<K> keys) {
        return new Level0MapOperator<I,K,List<T>>(getTarget().execute(FnList.ofObject().zipAndGroupKeysFrom(keys)));
    }

    public <K> Level0MapOperator<I, K, List<T>> zipAndGroupKeysFrom(final K[] keys) {
        return new Level0MapOperator<I,K,List<T>>(getTarget().execute(FnList.ofObject().zipAndGroupKeysFrom(keys)));
    }

    public <V> Level0MapOperator<I, T, List<V>> zipAndGroupValuesFrom(final Collection<V> values) {
        return new Level0MapOperator<I,T,List<V>>(getTarget().execute(FnList.ofObject().zipAndGroupValuesFrom(values)));
    }

    public <V> Level0MapOperator<I, T, List<V>> zipAndGroupValuesFrom(final V[] values) {
        return new Level0MapOperator<I,T,List<V>>(getTarget().execute(FnList.ofObject().zipAndGroupValuesFrom(values)));
    }

    public <K> Level0MapOperator<I, K, T> zipKeysFrom(final Collection<K> keys) {
        return new Level0MapOperator<I,K,T>(getTarget().execute(FnList.ofObject().zipKeysFrom(keys)));
    }

    public <K> Level0MapOperator<I, K, T> zipKeysFrom(final K[] keys) {
        return new Level0MapOperator<I,K,T>(getTarget().execute(FnList.ofObject().zipKeysFrom(keys)));
    }

    public <V> Level0MapOperator<I, T, V> zipValuesFrom(final Collection<V> values) {
        return new Level0MapOperator<I,T,V>(getTarget().execute(FnList.ofObject().zipValuesFrom(values)));
    }

    public <V> Level0MapOperator<I, T, V> zipValuesFrom(final V[] values) {
        return new Level0MapOperator<I,T,V>(getTarget().execute(FnList.ofObject().zipValuesFrom(values)));
    }
    

    public Level0ListOperator<I, T> reverse() {
        return new Level0ListOperator<I, T>(getTarget().execute(FnList.ofObject().reverse()));
    }
    
    


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I, K, List<V>> toGroupMap(final IFunction<? super T, K> keyFunction, final IFunction<? super T, V> valueFunction) {
        return new Level0MapOperator<I, K, List<V>>(getTarget().execute(FnList.ofObject().toGroupMap((IFunction)keyFunction,(IFunction)valueFunction)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I, K, V> toMap(final IFunction<? super T, K> keyFunction, final IFunction<? super T, V> valueFunction) {
        return new Level0MapOperator<I, K, V>(getTarget().execute(FnList.ofObject().toMap((IFunction)keyFunction,(IFunction)valueFunction)));
    }
    
    
    
    
    
    public Level0ListOperator<I, T> execIfFalseAsList(final IFunction<? super List<T>, Boolean> eval, final IFunction<? super List<T>, ? extends List<? extends T>> function) {
        return new Level0ListOperator<I,T>(getTarget().executeIfFalse(eval, function, null, Normalisation.LIST));
    }

    public <X> Level0ListOperator<I, X> execIfFalseAsList(final IFunction<? super List<T>, Boolean> eval, final IFunction<? super List<T>, ? extends List<X>> function, final IFunction<? super List<T>, ? extends List<X>> elseFunction) {
        return new Level0ListOperator<I,X>(getTarget().executeIfFalse(eval, function, elseFunction, Normalisation.LIST));
    }

    public Level0ListOperator<I, T> execIfNotNullAsList(final IFunction<? super List<T>, ? extends List<? extends T>> function) {
        return new Level0ListOperator<I,T>(getTarget().executeIfNotNull(function, null, Normalisation.LIST));
    }

    public <X> Level0ListOperator<I, X> execIfNotNullAsList(final IFunction<? super List<T>, ? extends List<X>> function, final IFunction<? super List<T>, ? extends List<X>> elseFunction) {
        return new Level0ListOperator<I,X>(getTarget().executeIfNotNull(function, elseFunction, Normalisation.LIST));
    }

    public Level0ListOperator<I, T> execIfNullAsList(final IFunction<? super List<T>, ? extends List<? extends T>> function) {
        return new Level0ListOperator<I,T>(getTarget().executeIfNull(function, null, Normalisation.LIST));
    }

    public <X> Level0ListOperator<I, X> execIfNullAsList(final IFunction<? super List<T>, ? extends List<X>> function, final IFunction<? super List<T>, ? extends List<X>> elseFunction) {
        return new Level0ListOperator<I,X>(getTarget().executeIfNull(function, elseFunction, Normalisation.LIST));
    }

    public Level0ListOperator<I, T> execIfTrueAsList(final IFunction<? super List<T>, Boolean> eval, final IFunction<? super List<T>, ? extends List<? extends T>> function) {
        return new Level0ListOperator<I,T>(getTarget().executeIfTrue(eval, function, null, Normalisation.LIST));
    }

    public <X> Level0ListOperator<I, X> execIfTrueAsList(final IFunction<? super List<T>, Boolean> eval, final IFunction<? super List<T>, ? extends List<X>> function, final IFunction<? super List<T>, ? extends List<X>> elseFunction) {
        return new Level0ListOperator<I,X>(getTarget().executeIfTrue(eval, function, elseFunction, Normalisation.LIST));
    }
    
    

    public Level0ListOperator<I, T> mapIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T, ? extends T> function) {
        return new Level0ListOperator<I,T>(getTarget().mapIfFalse(Structure.LIST, eval, function, null, null));
    }

    public <X> Level0ListOperator<I, X> mapIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level0ListOperator<I,X>(getTarget().mapIfFalse(Structure.LIST, eval, function, elseFunction, null));
    }

    public Level0ListOperator<I, T> mapIfNotNull(final IFunction<? super T, ? extends T> function) {
        return new Level0ListOperator<I,T>(getTarget().mapIfNotNull(Structure.LIST, function, null, null));
    }

    public <X> Level0ListOperator<I, X> mapIfNotNull(final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level0ListOperator<I,X>(getTarget().mapIfNotNull(Structure.LIST, function, elseFunction, null));
    }

    public Level0ListOperator<I, T> mapIfNull(final IFunction<? super T, ? extends T> function) {
        return new Level0ListOperator<I,T>(getTarget().mapIfNull(Structure.LIST, function, null, null));
    }

    public <X> Level0ListOperator<I, X> mapIfNull(final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level0ListOperator<I,X>(getTarget().mapIfNull(Structure.LIST, function, elseFunction, null));
    }

    public Level0ListOperator<I, T> mapIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T, ? extends T> function) {
        return new Level0ListOperator<I,T>(getTarget().mapIfTrue(Structure.LIST, eval, function, null, null));
    }

    public <X> Level0ListOperator<I, X> mapIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level0ListOperator<I,X>(getTarget().mapIfTrue(Structure.LIST, eval, function, elseFunction, null));
    }
    
}

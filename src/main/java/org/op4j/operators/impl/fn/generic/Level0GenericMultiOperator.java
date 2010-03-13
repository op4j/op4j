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

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.Call;
import org.op4j.functions.FnList;
import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.impl.fn.array.Level0ArrayOperator;
import org.op4j.operators.impl.fn.list.Level0ListOperator;
import org.op4j.operators.impl.fn.map.Level0MapOperator;
import org.op4j.operators.impl.fn.set.Level0SetOperator;
import org.op4j.operators.impl.fn.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.generic.ILevel0GenericMultiOperator;
import org.op4j.operators.qualities.MultiFnOperator;
import org.op4j.target.Target;
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
public final class Level0GenericMultiOperator<I,T> extends AbstractOperator
        implements MultiFnOperator<I,T>, ILevel0GenericMultiOperator<I,T>  {

    
    public Level0GenericMultiOperator(final Target target) {
        super(target);
        if (((List<?>)target.endIterate(null).get()).size() <= 0) {
            throw new IllegalStateException("Empty targets: cannot create an operator on no target objects at all.");
        }
    }


    public Level0GenericMultiOperator<I,T> add(final T newElement) {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().add(newElement)).iterate(Structure.LIST));
    }

    public Level0GenericMultiOperator<I,T> addAll(final T... newElements) {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().add(newElements)).iterate(Structure.LIST));
    }

    public Level0GenericMultiOperator<I,T> insert(final int position, final T newElement) {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().insert(position, newElement)).iterate(Structure.LIST));
    }

    public Level0GenericMultiOperator<I,T> insertAll(final int position, final T... newElements) {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().insert(position, newElements)).iterate(Structure.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<I,T> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().addAll((Collection)collection)).iterate(Structure.LIST));
    }


    public Level0ArrayOperator<I,T> buildArrayOf(final Type<T> type) {
        return new Level0ArrayOperator<I,T>(type, getTarget().endIterate(null).execute(FnList.of(type).toArray()));
    }


    public Level0ListOperator<I,T> buildList() {
        return new Level0ListOperator<I,T>(getTarget().endIterate(null));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K, T> buildMapByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K, T>(getTarget().endIterate(null).execute(FnList.ofObject().toMapByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K, V> buildMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K, V>(getTarget().endIterate(null).execute(FnList.ofObject().toMap((IFunction)mapBuilder)));
    }


    public Level0MapOperator<I,T, T> buildMapByAlternateElements() {
        return new Level0MapOperator<I,T, T>(getTarget().endIterate(null).execute(FnList.ofObject().toMapByAlternateElements()));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K, T[]> buildMapOfArrayByKeyEvalOf(final Type<T> valueType, final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K, T[]>(getTarget().endIterate(null).execute(FnList.of(valueType).toMapOfArrayByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K, V[]> buildMapOfArrayOf(final Type<V> valueType, final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K, V[]>(getTarget().endIterate(null).execute(FnList.ofObject().toMapOfArrayOf(valueType, (IFunction)mapBuilder)));
    }


    public Level0MapOperator<I,T, T[]> buildMapOfArrayByAlternateElementsOf(final Type<T> type) {
        return new Level0MapOperator<I,T, T[]>(getTarget().endIterate(null).execute(FnList.of(type).toMapOfArrayByAlternateElements()));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K, List<T>> buildMapOfListByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K, List<T>>(getTarget().endIterate(null).execute(FnList.ofObject().toMapOfListByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K, List<V>> buildMapOfList(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K, List<V>>(getTarget().endIterate(null).execute(FnList.ofObject().toMapOfList((IFunction)mapBuilder)));
    }


    public Level0MapOperator<I,T, List<T>> buildMapOfListByAlternateElements() {
        return new Level0MapOperator<I,T, List<T>>(getTarget().endIterate(null).execute(FnList.ofObject().toMapOfListByAlternateElements()));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K, Set<T>> buildMapOfSetByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K, Set<T>>(getTarget().endIterate(null).execute(FnList.ofObject().toMapOfSetByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K, Set<V>> buildMapOfSet(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K, Set<V>>(getTarget().endIterate(null).execute(FnList.ofObject().toMapOfSet((IFunction)mapBuilder)));
    }


    public Level0MapOperator<I,T, Set<T>> buildMapOfSetByAlternateElements() {
        return new Level0MapOperator<I,T, Set<T>>(getTarget().endIterate(null).execute(FnList.ofObject().toMapOfSetByAlternateElements()));
    }


    public Level0SetOperator<I,T> buildSet() {
        return new Level0SetOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().toSet()));
    }


    public <X> Level0GenericMultiOperator<I,X> asType(final Type<X> type) {
        return new Level0GenericMultiOperator<I,X>(getTarget());
    }

    


    public Level0GenericMultiOperator<I,T> removeAllIndexes(final int... indexes) {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllIndexes(indexes)).iterate(Structure.LIST));
    }


    public Level0GenericMultiOperator<I,T> removeAllEqual(final T... values) {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllEqual(values)).iterate(Structure.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllTrue((IFunction)eval)).iterate(Structure.LIST));
    }

    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllFalse((IFunction)eval)).iterate(Structure.LIST));
    }

    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllNullOrFalse((IFunction)eval)).iterate(Structure.LIST));
    }

    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllNotNullAndFalse((IFunction)eval)).iterate(Structure.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllNullOrTrue((IFunction)eval)).iterate(Structure.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllNotNullAndTrue((IFunction)eval)).iterate(Structure.LIST));
    }


    public Level0GenericMultiOperator<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllIndexesNot(indexes)).iterate(Structure.LIST));
    }


    public Level0GenericMultiOperator<I,T> removeAllNull() {
        return new Level0GenericMultiOperator<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllNull()).iterate(Structure.LIST));
    }

    


    public Level0GenericMultiSelectedOperator<I,T> ifIndex(final int... indexes) {
        return new Level0GenericMultiSelectedOperator<I,T>(getTarget().selectIndex(indexes));
    }


    public Level0GenericMultiSelectedOperator<I,T> ifIndexNot(final int... indexes) {
        return new Level0GenericMultiSelectedOperator<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level0GenericMultiSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiSelectedOperator<I,T>(getTarget().selectMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiSelectedOperator<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<I,T> ifNotNull() {
        return new Level0GenericMultiSelectedOperator<I,T>(getTarget().selectNotNull());
    }


    public Level0GenericMultiSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiSelectedOperator<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiSelectedOperator<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<I,T> ifNull() {
        return new Level0GenericMultiSelectedOperator<I,T>(getTarget().selectNull());
    }


    public Level0GenericMultiSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiSelectedOperator<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiSelectedOperator<I,T>(getTarget().selectNullOrNotMatching(eval));
    }





    public Level0GenericUniqOperator<I,T> uniq() {
        if (size() > 1) {
            throw new IllegalStateException("Cannot call uniq(): more than one target exist (size: " + size() + ")");
        }
        return new Level0GenericUniqOperator<I,T>(getTarget().endIterate(null).execute(Call.asObject("get", Integer.valueOf(0)), Normalisation.NONE));
    }


    public int size() {
        return ((List<?>) getTarget().endIterate(null).get()).size();
    }


    public Function<I,T[]> getAsArrayOf(final Type<T> type) {
        return buildArrayOf(type).get();
    }


    public Function<I,List<T>> getAsList() {
        return buildList().get();
    }


    public <X> Level0GenericMultiOperator<I,X> execIfNotNull(final IFunction<? super T,X> function) {
        return new Level0GenericMultiOperator<I,X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level0GenericMultiOperator<I,X> exec(final IFunction<? super T,X> function) {
        return new Level0GenericMultiOperator<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericMultiOperator<I,T> replaceWith(final T replacement) {
        return new Level0GenericMultiOperator<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level0GenericMultiOperator<I,T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }

    
    
    
    @SuppressWarnings("unchecked")
    public Level0GenericUniqOperator<I, T> reduce(final IFunction<? extends ValuePair<? super T,? super T>, ? extends T> reductor) {
        return new Level0GenericUniqOperator<I, T>(getTarget().endIterate(null).execute(FnList.of((Type<T>)Types.OBJECT).reduce(reductor)));
    }



    @SuppressWarnings("unchecked")
    public <X> Level0GenericUniqOperator<I, X> reduce(final IFunction<? extends ValuePair<? super X,? super T>,X> reductor, final X initialValue) {
        return new Level0GenericUniqOperator<I, X>(getTarget().endIterate(null).execute(FnList.of((Type<T>)Types.OBJECT).reduce(reductor, initialValue)));
    }
    
    
    
    

    @SuppressWarnings("unchecked")
    public Level0GenericUniqOperator<I, Boolean> all(final IFunction<? super T, Boolean> eval) {
        return new Level0GenericUniqOperator<I, Boolean>(getTarget().endIterate(null).execute(FnList.of((Type<T>)Types.OBJECT).all(eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericUniqOperator<I, Boolean> any(final IFunction<? super T, Boolean> eval) {
        return new Level0GenericUniqOperator<I, Boolean>(getTarget().endIterate(null).execute(FnList.of((Type<T>)Types.OBJECT).any(eval)));
    }
    
}

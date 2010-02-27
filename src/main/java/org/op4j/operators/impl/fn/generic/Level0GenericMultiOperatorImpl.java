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
import org.op4j.functions.Call;
import org.op4j.functions.FnList;
import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.fn.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.fn.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.fn.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.fn.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericMultiOperator;
import org.op4j.operators.qualities.MultiFnOperator;
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
public final class Level0GenericMultiOperatorImpl<I,T> extends AbstractOperatorImpl
        implements MultiFnOperator<I,T>, Level0GenericMultiOperator<I,T>  {

    
    public Level0GenericMultiOperatorImpl(final Target target) {
        super(target);
        if (((List<?>)target.endIterate(null).get()).size() <= 0) {
            throw new IllegalStateException("Empty targets: cannot create an operator on no target objects at all.");
        }
    }


    public Level0GenericMultiOperatorImpl<I,T> add(final T newElement) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().add(newElement)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperatorImpl<I,T> addAll(final T... newElements) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().add(newElements)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperatorImpl<I,T> insert(final int position, final T newElement) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().insert(position, newElement)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperatorImpl<I,T> insertAll(final int position, final T... newElements) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().insert(position, newElements)).iterate(Structure.LIST, true));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperatorImpl<I,T> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().addAll((Collection)collection)).iterate(Structure.LIST, true));
    }


    public Level0ArrayOperatorImpl<I,T> buildArrayOf(final Type<T> type) {
        return new Level0ArrayOperatorImpl<I,T>(type, getTarget().endIterate(null).execute(FnList.of(type).toArray()));
    }


    public Level0ListOperatorImpl<I,T> buildList() {
        return new Level0ListOperatorImpl<I,T>(getTarget().endIterate(null));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperatorImpl<I,K, T> buildMapByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperatorImpl<I,K, T>(getTarget().endIterate(null).execute(FnList.ofObject().toMapByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperatorImpl<I,K, V> buildMap(final IMapBuilder<? super T,K,V> mapBuilder) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().endIterate(null).execute(FnList.ofObject().toMap((IMapBuilder)mapBuilder)));
    }


    public Level0MapOperatorImpl<I,T, T> buildMapByAlternateElements() {
        return new Level0MapOperatorImpl<I,T, T>(getTarget().endIterate(null).execute(FnList.ofObject().toMapByAlternateElements()));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperatorImpl<I,K, T[]> buildMapOfArrayByKeyEvalOf(final Type<T> valueType, final IFunction<? super T,K> keyEval) {
        return new Level0MapOperatorImpl<I,K, T[]>(getTarget().endIterate(null).execute(FnList.of(valueType).toMapOfArrayByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperatorImpl<I,K, V[]> buildMapOfArrayOf(final Type<V> valueType, final IMapBuilder<? super T,K,V> mapBuilder) {
        return new Level0MapOperatorImpl<I,K, V[]>(getTarget().endIterate(null).execute(FnList.ofObject().toMapOfArrayOf(valueType, (IMapBuilder)mapBuilder)));
    }


    public Level0MapOperatorImpl<I,T, T[]> buildMapOfArrayByAlternateElementsOf(final Type<T> type) {
        return new Level0MapOperatorImpl<I,T, T[]>(getTarget().endIterate(null).execute(FnList.of(type).toMapOfArrayByAlternateElements()));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperatorImpl<I,K, List<T>> buildMapOfListByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperatorImpl<I,K, List<T>>(getTarget().endIterate(null).execute(FnList.ofObject().toMapOfListByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperatorImpl<I,K, List<V>> buildMapOfList(final IMapBuilder<? super T,K,V> mapBuilder) {
        return new Level0MapOperatorImpl<I,K, List<V>>(getTarget().endIterate(null).execute(FnList.ofObject().toMapOfList((IMapBuilder)mapBuilder)));
    }


    public Level0MapOperatorImpl<I,T, List<T>> buildMapOfListByAlternateElements() {
        return new Level0MapOperatorImpl<I,T, List<T>>(getTarget().endIterate(null).execute(FnList.ofObject().toMapOfListByAlternateElements()));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperatorImpl<I,K, Set<T>> buildMapOfSetByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperatorImpl<I,K, Set<T>>(getTarget().endIterate(null).execute(FnList.ofObject().toMapOfSetByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperatorImpl<I,K, Set<V>> buildMapOfSet(final IMapBuilder<? super T,K,V> mapBuilder) {
        return new Level0MapOperatorImpl<I,K, Set<V>>(getTarget().endIterate(null).execute(FnList.ofObject().toMapOfSet((IMapBuilder)mapBuilder)));
    }


    public Level0MapOperatorImpl<I,T, Set<T>> buildMapOfSetByAlternateElements() {
        return new Level0MapOperatorImpl<I,T, Set<T>>(getTarget().endIterate(null).execute(FnList.ofObject().toMapOfSetByAlternateElements()));
    }


    public Level0SetOperatorImpl<I,T> buildSet() {
        return new Level0SetOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().toSet()));
    }


    public <X> Level0GenericMultiOperatorImpl<I,X> asType(final Type<X> type) {
        return new Level0GenericMultiOperatorImpl<I,X>(getTarget());
    }

    


    public Level0GenericMultiOperatorImpl<I,T> removeAllIndexes(final int... indexes) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllIndexes(indexes)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperatorImpl<I,T> removeAllEqual(final T... values) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllEqual(values)).iterate(Structure.LIST, true));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperatorImpl<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllTrue((IFunction)eval)).iterate(Structure.LIST, true));
    }

    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperatorImpl<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllFalse((IFunction)eval)).iterate(Structure.LIST, true));
    }

    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperatorImpl<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllNullOrFalse((IFunction)eval)).iterate(Structure.LIST, true));
    }

    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperatorImpl<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllNotNullAndFalse((IFunction)eval)).iterate(Structure.LIST, true));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperatorImpl<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllNullOrTrue((IFunction)eval)).iterate(Structure.LIST, true));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperatorImpl<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllNotNullAndTrue((IFunction)eval)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperatorImpl<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllIndexesNot(indexes)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperatorImpl<I,T> removeAllNull() {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(FnList.ofObject().removeAllNull()).iterate(Structure.LIST, true));
    }

    


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifIndex(final int... indexes) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectIndex(indexes));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifIndexNot(final int... indexes) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectMatching(eval));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifNotNull() {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectNotNull());
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifNull() {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectNull());
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectNullOrNotMatching(eval));
    }





    public Level0GenericUniqOperatorImpl<I,T> uniq() {
        if (size() > 1) {
            throw new IllegalStateException("Cannot call uniq(): more than one target exist (size: " + size() + ")");
        }
        return new Level0GenericUniqOperatorImpl<I,T>(getTarget().endIterate(null).execute(Call.asObject("get", Integer.valueOf(0)), Normalisation.NONE));
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


    public <X> Level0GenericMultiOperatorImpl<I,X> execIfNotNull(final IFunction<? super T,X> function) {
        return new Level0GenericMultiOperatorImpl<I,X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level0GenericMultiOperatorImpl<I,X> exec(final IFunction<? super T,X> function) {
        return new Level0GenericMultiOperatorImpl<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericMultiOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level0GenericMultiOperatorImpl<I,T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }
    
}

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
package org.op4j.operators.impl.op.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.FnList;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.op.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.op.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.op.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.op.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.qualities.UniqOpOperator;
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
public final class Level0ListOperatorImpl<I,T> extends AbstractOperatorImpl
        implements UniqOpOperator<I,List<T>>, Level0ListOperator<I,T>  {

    
    public Level0ListOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ListOperatorImpl<I,T> add(final T newElement) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().add(newElement)));
    }

    public Level0ListOperatorImpl<I,T> addAll(final T... newElements) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().add(newElements)));
    }


    public Level0ListOperatorImpl<I,T> insert(final int position, final T newElement) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().insert(position, newElement)));
    }

    public Level0ListOperatorImpl<I,T> insertAll(final int position, final T... newElements) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().insert(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperatorImpl<I,T> addAll(final Collection<T> collection) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().addAll((Collection)collection)));
    }


    public Level0ListOperatorImpl<I,T> distinct() {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().distinct()));
    }


    public Level1ListElementsOperatorImpl<I,T> forEach() {
        return new Level1ListElementsOperatorImpl<I,T>(getTarget().iterate(Structure.LIST));
    }


    public Level0ListOperatorImpl<I,T> removeAllIndexes(final int... indexes) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllIndexes(indexes)));
    }


    public Level0ListOperatorImpl<I,T> removeAllEqual(final T... values) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllEqual(values)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperatorImpl<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllTrue((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0ListOperatorImpl<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllFalse((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0ListOperatorImpl<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllNullOrFalse((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0ListOperatorImpl<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllNotNullAndFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperatorImpl<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllNullOrTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperatorImpl<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllNotNullAndTrue((IFunction)eval)));
    }


    public Level0ListOperatorImpl<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllIndexesNot(indexes)));
    }


    public Level0ListOperatorImpl<I,T> removeAllNull() {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllNull()));
    }

    


    public Level0ListOperatorImpl<I,T> sort() {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().sort()));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperatorImpl<I,T> sort(final Comparator<? super T> comparator) {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().sort((Comparator)comparator)));
    }


    public Level0ArrayOperatorImpl<I,T> toArrayOf(final Type<T> type) {
        return new Level0ArrayOperatorImpl<I,T>(type, getTarget().execute(FnList.of(type).toArray()));
    }


    public Level0MapOperatorImpl<I,T, T> toMapByAlternateElements() {
        return new Level0MapOperatorImpl<I,T, T>(getTarget().execute(FnList.ofObject().toMapByAlternateElements()));
    }

    @SuppressWarnings("unchecked")
    public <K> Level0MapOperatorImpl<I,K, T> toMapByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperatorImpl<I,K, T>(getTarget().execute(FnList.ofObject().toMapByKeyEval((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperatorImpl<I,K, V> toMap(final IMapBuilder<? super T,K,V> mapBuilder) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(FnList.ofObject().toMap((IMapBuilder)mapBuilder)));
    }


    public Level0SetOperatorImpl<I,T> toSet() {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().toSet()));
    }


    @SuppressWarnings("unchecked")
    public List<T> get() {
        return (List<T>) getTarget().get();
    }


    public Level0GenericUniqOperatorImpl<I,List<T>> generic() {
        return new Level0GenericUniqOperatorImpl<I,List<T>>(getTarget());
    }
    
    
    
    
    
	public <X> Level0ListOperatorImpl<I,X> asListOf(final Type<X> type) {
        return generic().asListOf(type);
    }


    


    public Level0ListSelectedOperatorImpl<I,T> ifIndex(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().selectIndex(indexes));
    }


    public Level0ListSelectedOperatorImpl<I,T> ifIndexNot(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level0ListSelectedOperatorImpl<I,T> ifTrue(final IFunction<? super List<T>,Boolean> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().selectMatching(eval));
    }


    public Level0ListSelectedOperatorImpl<I,T> ifFalse(final IFunction<? super List<T>,Boolean> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level0ListSelectedOperatorImpl<I,T> ifNotNull() {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().selectNotNull());
    }


    public Level0ListSelectedOperatorImpl<I,T> ifNotNullAndTrue(final IFunction<? super List<T>,Boolean> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListSelectedOperatorImpl<I,T> ifNotNullAndFalse(final IFunction<? super List<T>,Boolean> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListSelectedOperatorImpl<I,T> ifNull() {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().selectNull());
    }


    public Level0ListSelectedOperatorImpl<I,T> ifNullOrTrue(final IFunction<? super List<T>,Boolean> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListSelectedOperatorImpl<I,T> ifNullOrFalse(final IFunction<? super List<T>,Boolean> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level0ListOperatorImpl<I,T> execIfNotNullAsList(final IFunction<? super List<T>,? extends List<? extends T>> function) {
        return new Level0ListOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.LIST));
    }


    public <X> Level0ListOperatorImpl<I,X> execAsList(final IFunction<? super List<T>,? extends List<X>> function) {
        return new Level0ListOperatorImpl<I,X>(getTarget().execute(function, Normalisation.LIST));
    }


    


    public <X> Level0GenericUniqOperatorImpl<I,X> exec(final IFunction<? super List<T>,X> function) {
        return new Level0GenericUniqOperatorImpl<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0ListOperatorImpl<I,T> replaceWith(final List<T> replacement) {
        return new Level0ListOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public Level0ListOperatorImpl<I,T> replaceIfNullWith(final List<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    public <X> Level0ListOperatorImpl<I,X> map(final IFunction<? super T,X> function) {
        return new Level0ListOperatorImpl<I,X>(getTarget().map(Structure.LIST, function, null));
    }
    

    public Level0ListOperatorImpl<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level0ListOperatorImpl<I,T>(getTarget().mapIfNotNull(Structure.LIST, function, null));
    }
    

    
    
    

}

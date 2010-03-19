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
package org.op4j.operators.impl.op.array;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.FnArray;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.impl.op.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.op.list.Level0ListOperator;
import org.op4j.operators.impl.op.map.Level0MapOperator;
import org.op4j.operators.impl.op.set.Level0SetOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.qualities.UniqOpOperator;
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
public final class Level0ArrayOperator<I,T> 
        extends AbstractOperator 
        implements UniqOpOperator<I,T[]>, ILevel0ArrayOperator<I,T> {


    private final Type<T> type;
    
    
    public Level0ArrayOperator(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }

    
    public Level0ArrayOperator<I,T> add(final T newElement) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().add(newElement)));
    }

    public Level0ArrayOperator<I,T> addAll(final T... newElements) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().add(newElements)));
    }


    public Level0ArrayOperator<I,T> insert(final int position, final T newElement) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().insert(position, newElement)));
    }

    public Level0ArrayOperator<I,T> insertAll(final int position, final T... newElements) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().insert(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<I,T> addAll(final Collection<T> collection) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().addAll((Collection)collection)));
    }

    public Level0ArrayOperator<I,T> distinct() {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().distinct()));
    }

    public Level1ArrayElementsOperator<I,T> forEach() {
        return new Level1ArrayElementsOperator<I,T>(this.type, getTarget().iterate(Structure.ARRAY));
    }

    
    public Level0ArrayOperator<I,T> removeAllIndexes(final int... indexes) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllIndexes(indexes)));
    }


    public Level0ArrayOperator<I,T> removeAllEqual(final T... values) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllEqual(values)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllTrue((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllFalse((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNullOrFalse((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNotNullAndFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNullOrTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNotNullAndTrue((IFunction)eval)));
    }


    public Level0ArrayOperator<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllIndexesNot(indexes)));
    }



    public Level0ArrayOperator<I,T> removeAllNull() {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNull()));
    }

    

    public Level0ArrayOperator<I,T> sort() {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().sort()));
    }

    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<I,T> sort(final Comparator<? super T> comparator) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().sort((Comparator)comparator)));
    }

    public Level0ListOperator<I,T> toList() {
        return new Level0ListOperator<I,T>(getTarget().execute(FnArray.of(this.type).toList()));
    }


    public Level0MapOperator<I,T, T> toMapByAlternateElements() {
        return new Level0MapOperator<I,T, T>(getTarget().execute(FnArray.of(this.type).toMapByAlternateElements()));
    }

    public <K> Level0MapOperator<I,K, T> toMapByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K, T>(getTarget().execute(FnArray.of(this.type).toMapByKeyEval(keyEval)));
    }

    public <K, V> Level0MapOperator<I,K, V> toMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnArray.of(this.type).toMap(mapBuilder)));
    }

    public Level0SetOperator<I,T> toSet() {
        return new Level0SetOperator<I,T>(getTarget().execute(FnArray.of(this.type).toSet()));
    }

    @SuppressWarnings("unchecked")
	public T[] get() {
        return (T[]) getTarget().get();
    }

    public Level0GenericUniqOperator<I,T[]> generic() {
        return new Level0GenericUniqOperator<I,T[]>(getTarget());
    }


    
    

    public <X> Level0ArrayOperator<I,X> of(final Type<X> newType) {
        return generic().castToArrayOf(newType);
    }

    public <X> Level0ArrayOperator<I,X> castToArrayOf(final Type<X> newType) {
        return generic().castToArrayOf(newType);
    }


    



    
    public Level0ArraySelectedOperator<I,T> ifTrue(final IFunction<? super T[],Boolean> eval) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().selectMatching(eval));
    }


    public Level0ArraySelectedOperator<I,T> ifFalse(final IFunction<? super T[],Boolean> eval) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level0ArraySelectedOperator<I,T> ifNotNull() {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().selectNotNull());
    }


    public Level0ArraySelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super T[],Boolean> eval) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArraySelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super T[],Boolean> eval) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ArraySelectedOperator<I,T> ifNull() {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().selectNull());
    }


    public Level0ArraySelectedOperator<I,T> ifNullOrTrue(final IFunction<? super T[],Boolean> eval) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level0ArraySelectedOperator<I,T> ifNullOrFalse(final IFunction<? super T[],Boolean> eval) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


	public Level0ArrayOperator<I,T> execIfNotNullAsArray(final IFunction<? super T[],? extends T[]> function) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().executeIfNotNull(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


	public Level0ArrayOperator<I,T> execAsArray(final IFunction<? super T[],? extends T[]> function) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    


    public <X> Level0ArrayOperator<I,X> execAsArrayOf(final Type<X> newType, final IFunction<? super T[],X[]> function) {
        return new Level0ArrayOperator<I,X>(newType, getTarget().execute(function, Normalisation.ARRAY(newType.getRawClass())));
    }


    


    public <X> Level0GenericUniqOperator<I,X> exec(final IFunction<? super T[],X> function) {
        return new Level0GenericUniqOperator<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0ArrayOperator<I,T> replaceWith(final T[] replacement) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ArrayOperator<I,T> replaceIfNullWith(final T[] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public <X> Level0ArrayOperator<I,X> map(final Type<X> newType, final IFunction<? super T,X> function) {
        return new Level0ArrayOperator<I,X>(newType, getTarget().map(Structure.ARRAY, function, newType.getRawClass()));
    }


    public Level0ArrayOperator<I,T> map(final IFunction<? super T,? extends T> function) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }


    


    public Level0ArrayOperator<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().mapIfNotNull(Structure.ARRAY, function, this.type.getRawClass()));
    }




    public Level0GenericUniqOperator<I, T> reduce(final IFunction<? extends ValuePair<? super T,? super T>, ? extends T> reductor) {
        return new Level0GenericUniqOperator<I, T>(getTarget().execute(FnArray.of(this.type).reduce(reductor)));
    }



    public <X> Level0GenericUniqOperator<I, X> reduce(final IFunction<? extends ValuePair<? super X,? super T>,X> reductor, final X initialValue) {
        return new Level0GenericUniqOperator<I, X>(getTarget().execute(FnArray.of(this.type).reduce(reductor, initialValue)));
    }


    
    
    

    public Level0GenericUniqOperator<I, Boolean> all(final IFunction<? super T, Boolean> eval) {
        return new Level0GenericUniqOperator<I, Boolean>(getTarget().execute(FnArray.of(this.type).all(eval)));
    }


    public Level0GenericUniqOperator<I, Boolean> any(final IFunction<? super T, Boolean> eval) {
        return new Level0GenericUniqOperator<I, Boolean>(getTarget().execute(FnArray.of(this.type).any(eval)));
    }




    
    public Level0ArrayOperator<I, T> sortBy(final IFunction<? super T, ?> by) {
        return new Level0ArrayOperator<I, T>(this.type, getTarget().execute(FnArray.of(this.type).sortBy(by)));
    }

    


}

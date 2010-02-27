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
package org.op4j.operators.impl.fn.array;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.FnArray;
import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.fn.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.fn.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.fn.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.fn.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
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
public final class Level0ArrayOperatorImpl<I,T> 
        extends AbstractOperatorImpl 
        implements UniqFnOperator<I,T[]>, Level0ArrayOperator<I,T> {


    private final Type<T> type;
    
    
    public Level0ArrayOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }

    
    public Level0ArrayOperatorImpl<I,T> add(final T newElement) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().add(newElement)));
    }

    public Level0ArrayOperatorImpl<I,T> addAll(final T... newElements) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().add(newElements)));
    }


    public Level0ArrayOperatorImpl<I,T> insert(final int position, final T newElement) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().insert(position, newElement)));
    }

    public Level0ArrayOperatorImpl<I,T> insertAll(final int position, final T... newElements) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().insert(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOperatorImpl<I,T> addAll(final Collection<T> collection) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().addAll((Collection)collection)));
    }

    public Level0ArrayOperatorImpl<I,T> distinct() {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().distinct()));
    }

    public Level1ArrayElementsOperatorImpl<I,T> forEach() {
        return new Level1ArrayElementsOperatorImpl<I,T>(this.type, getTarget().iterate(Structure.ARRAY));
    }

    
    public Level0ArrayOperatorImpl<I,T> removeAllIndexes(final int... indexes) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllIndexes(indexes)));
    }


    public Level0ArrayOperatorImpl<I,T> removeAllEqual(final T... values) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllEqual(values)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOperatorImpl<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllTrue((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0ArrayOperatorImpl<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllFalse((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0ArrayOperatorImpl<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNullOrFalse((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0ArrayOperatorImpl<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNotNullAndFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOperatorImpl<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNullOrTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOperatorImpl<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNotNullAndTrue((IFunction)eval)));
    }


    public Level0ArrayOperatorImpl<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllIndexesNot(indexes)));
    }



    public Level0ArrayOperatorImpl<I,T> removeAllNull() {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNull()));
    }

    

    public Level0ArrayOperatorImpl<I,T> sort() {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().sort()));
    }

    @SuppressWarnings("unchecked")
    public Level0ArrayOperatorImpl<I,T> sort(final Comparator<? super T> comparator) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(FnArray.ofObject().sort((Comparator)comparator)));
    }

    public Level0ListOperatorImpl<I,T> toList() {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(FnArray.of(this.type).toList()));
    }


    public Level0MapOperatorImpl<I,T, T> toMapByAlternateElements() {
        return new Level0MapOperatorImpl<I,T, T>(getTarget().execute(FnArray.of(this.type).toMapByAlternateElements()));
    }

    public <K> Level0MapOperatorImpl<I,K, T> toMapByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperatorImpl<I,K, T>(getTarget().execute(FnArray.of(this.type).toMapByKeyEval(keyEval)));
    }

    public <K, V> Level0MapOperatorImpl<I,K, V> toMap(final IMapBuilder<? super T,K,V> mapBuilder) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(FnArray.of(this.type).toMap(mapBuilder)));
    }

    public Level0SetOperatorImpl<I,T> toSet() {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnArray.of(this.type).toSet()));
    }


	public Function<I,T[]> get() {
        return new Function<I, T[]>(getTarget());
    }

    public Level0GenericUniqOperatorImpl<I,T[]> generic() {
        return new Level0GenericUniqOperatorImpl<I,T[]>(getTarget());
    }


    
    

    public <X> Level0ArrayOperatorImpl<I,X> asArrayOf(final Type<X> newType) {
        return generic().asArrayOf(newType);
    }


    

    
    public Level0ArraySelectedOperatorImpl<I,T> ifTrue(final IFunction<? super T[],Boolean> eval) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().selectMatching(eval));
    }


    public Level0ArraySelectedOperatorImpl<I,T> ifFalse(final IFunction<? super T[],Boolean> eval) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level0ArraySelectedOperatorImpl<I,T> ifNotNull() {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().selectNotNull());
    }


    public Level0ArraySelectedOperatorImpl<I,T> ifNotNullAndTrue(final IFunction<? super T[],Boolean> eval) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArraySelectedOperatorImpl<I,T> ifNotNullAndFalse(final IFunction<? super T[],Boolean> eval) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ArraySelectedOperatorImpl<I,T> ifNull() {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().selectNull());
    }


    public Level0ArraySelectedOperatorImpl<I,T> ifNullOrTrue(final IFunction<? super T[],Boolean> eval) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level0ArraySelectedOperatorImpl<I,T> ifNullOrFalse(final IFunction<? super T[],Boolean> eval) {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


	public Level0ArrayOperatorImpl<I,T> execIfNotNullAsArray(final IFunction<? super T[],? extends T[]> function) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().executeIfNotNull(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


	public Level0ArrayOperatorImpl<I,T> execAsArray(final IFunction<? super T[],? extends T[]> function) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    


    public <X> Level0ArrayOperatorImpl<I,X> execAsArrayOf(final Type<X> newType, final IFunction<? super T[],X[]> function) {
        return new Level0ArrayOperatorImpl<I,X>(newType, getTarget().execute(function, Normalisation.ARRAY(newType.getRawClass())));
    }


    


    public <X> Level0GenericUniqOperatorImpl<I,X> exec(final IFunction<? super T[],X> function) {
        return new Level0GenericUniqOperatorImpl<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0ArrayOperatorImpl<I,T> replaceWith(final T[] replacement) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ArrayOperatorImpl<I,T> replaceIfNullWith(final T[] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public <X> Level0ArrayOperatorImpl<I,X> map(final Type<X> newType, final IFunction<? super T,X> function) {
        return new Level0ArrayOperatorImpl<I,X>(newType, getTarget().map(Structure.ARRAY, function, newType.getRawClass()));
    }


    public Level0ArrayOperatorImpl<I,T> map(final IFunction<? super T,? extends T> function) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }


    


    public Level0ArrayOperatorImpl<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level0ArrayOperatorImpl<I,T>(this.type, getTarget().mapIfNotNull(Structure.ARRAY, function, this.type.getRawClass()));
    }


    


}

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
package org.op4j.operators.op.impl.array;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.structures.FArray;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.op.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.op.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.op.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.op.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.op.intf.array.Level0ArrayOperator;
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
public final class Level0ArrayOperatorImpl<T,I> 
        extends AbstractOperatorImpl 
        implements UniqOpOperator<T[]>, Level0ArrayOperator<T,I> {


    private final Type<T> type;
    
    
    public Level0ArrayOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }

    
    @SuppressWarnings("unchecked")
    public Level0ArrayOperatorImpl<T,I> add(final T newElement) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.Add<T>(newElement)));
    }

    public Level0ArrayOperatorImpl<T,I> addAll(final T... newElements) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOperatorImpl<T,I> insert(final int position, final T newElement) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.Insert<T>(position, newElement)));
    }

    public Level0ArrayOperatorImpl<T,I> insertAll(final int position, final T... newElements) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.Insert<T>(position, newElements)));
    }


    public Level0ArrayOperatorImpl<T,I> addAll(final Collection<T> collection) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.AddAll<T>(collection)));
    }

    public Level0ArrayOperatorImpl<T,I> distinct() {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.Distinct<T>()));
    }

    public Level1ArrayElementsOperatorImpl<T,I> forEach() {
        return new Level1ArrayElementsOperatorImpl<T,I>(this.type, getTarget().iterate(Structure.ARRAY));
    }

    
    public Level0ArrayOperatorImpl<T,I> removeAllIndexes(final int... indexes) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllIndexes<T>(indexes)));
    }


    public Level0ArrayOperatorImpl<T,I> removeAllEqual(final T... values) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllEqual<T>(values)));
    }


    public Level0ArrayOperatorImpl<T,I> removeAllTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllTrue<T>(eval)));
    }

    public Level0ArrayOperatorImpl<T,I> removeAllFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllFalse<T>(eval)));
    }

    public Level0ArrayOperatorImpl<T,I> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level0ArrayOperatorImpl<T,I> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ArrayOperatorImpl<T,I> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ArrayOperatorImpl<T,I> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ArrayOperatorImpl<T,I> removeAllIndexesNot(final int... indexes) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllIndexesNot<T>(indexes)));
    }



    public Level0ArrayOperatorImpl<T,I> removeAllNull() {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllNull<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public Level0ArrayOperatorImpl<T,I> sort() {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.Sort()));
    }

    public Level0ArrayOperatorImpl<T,I> sort(final Comparator<? super T> comparator) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.SortByComparator<T>(comparator)));
    }

    public Level0ListOperatorImpl<T,I> toList() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public Level0MapOperatorImpl<T, T,I> toMap() {
        return new Level0MapOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> Level0MapOperatorImpl<K, T,I> toMap(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }

    public <K, V> Level0MapOperatorImpl<K, V,I> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }

    public Level0SetOperatorImpl<T,I> toSet() {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new ToSet.FromArray<T>()));
    }

    @SuppressWarnings("unchecked")
	public T[] get() {
        return (T[]) getTarget().get();
    }

    public Level0GenericUniqOperatorImpl<T[],I> generic() {
        return new Level0GenericUniqOperatorImpl<T[],I>(getTarget());
    }


    
    

    public <X> Level0ArrayOperatorImpl<X,I> asArrayOf(final Type<X> newType) {
        return generic().asArrayOf(newType);
    }


    


    public Level0ArraySelectedOperatorImpl<T,I> ifIndex(final int... indexes) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().selectIndex(indexes));
    }


    public Level0ArraySelectedOperatorImpl<T,I> ifIndexNot(final int... indexes) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().selectIndexNot(indexes));
    }

    
    public Level0ArraySelectedOperatorImpl<T,I> ifTrue(final IFunction<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().selectMatching(eval));
    }


    public Level0ArraySelectedOperatorImpl<T,I> ifFalse(final IFunction<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level0ArraySelectedOperatorImpl<T,I> ifNotNull() {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNull());
    }


    public Level0ArraySelectedOperatorImpl<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArraySelectedOperatorImpl<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ArraySelectedOperatorImpl<T,I> ifNull() {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().selectNull());
    }


    public Level0ArraySelectedOperatorImpl<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level0ArraySelectedOperatorImpl<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


	public Level0ArrayOperatorImpl<T,I> execIfNotNullAsArray(final IFunction<? extends T[], ? super T[]> function) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().executeIfNotNull(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


	public Level0ArrayOperatorImpl<T,I> execAsArray(final IFunction<? extends T[], ? super T[]> function) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    


    public <X> Level0ArrayOperatorImpl<X,I> execAsArrayOf(final Type<X> newType, final IFunction<X[], ? super T[]> function) {
        return new Level0ArrayOperatorImpl<X,I>(newType, getTarget().execute(function, Normalisation.ARRAY(newType.getRawClass())));
    }


    


    public <X> Level0GenericUniqOperatorImpl<X,I> exec(final IFunction<X, ? super T[]> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0ArrayOperatorImpl<T,I> replaceWith(final T[] replacement) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ArrayOperatorImpl<T,I> replaceIfNullWith(final T[] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public <X> Level0ArrayOperatorImpl<X,I> map(final Type<X> newType, final IFunction<X, ? super T> function) {
        return new Level0ArrayOperatorImpl<X,I>(newType, getTarget().map(Structure.ARRAY, function, newType.getRawClass()));
    }


    public Level0ArrayOperatorImpl<T,I> map(final IFunction<? extends T, ? super T> function) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }


    


    public Level0ArrayOperatorImpl<T,I> mapIfNotNull(final IFunction<? extends T, ? super T> function) {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().mapIfNotNull(Structure.ARRAY, function, this.type.getRawClass()));
    }


    


}

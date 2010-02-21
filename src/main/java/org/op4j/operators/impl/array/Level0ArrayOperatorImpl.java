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
package org.op4j.operators.impl.array;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.structures.FArray;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.array.Level0ArraySelectedOperator;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
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
public final class Level0ArrayOperatorImpl<T> 
        extends AbstractOperatorImpl 
        implements Level0ArrayOperator<T> {


    private final Type<T> type;
    
    
    public Level0ArrayOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }

    
    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<T> add(final T newElement) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.Add<T>(newElement)));
    }

    public Level0ArrayOperator<T> addAll(final T... newElements) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<T> insert(final int position, final T newElement) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.Insert<T>(position, newElement)));
    }

    public Level0ArrayOperator<T> insertAll(final int position, final T... newElements) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.Insert<T>(position, newElements)));
    }


    public Level0ArrayOperator<T> addAll(final Collection<T> collection) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.AddAll<T>(collection)));
    }

    public Level0ArrayOperator<T> distinct() {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.Distinct<T>()));
    }

    public Level1ArrayElementsOperator<T> forEach() {
        return new Level1ArrayElementsOperatorImpl<T>(this.type, getTarget().iterate(Structure.ARRAY));
    }

    
    public Level0ArrayOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.RemoveAllIndexes<T>(indexes)));
    }


    public Level0ArrayOperator<T> removeAllEqual(final T... values) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.RemoveAllEqual<T>(values)));
    }


    public Level0ArrayOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.RemoveAllTrue<T>(eval)));
    }

    public Level0ArrayOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.RemoveAllFalse<T>(eval)));
    }

    public Level0ArrayOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level0ArrayOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ArrayOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ArrayOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ArrayOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.RemoveAllIndexesNot<T>(indexes)));
    }



    public Level0ArrayOperator<T> removeAllNull() {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.RemoveAllNull<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<T> sort() {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.Sort()));
    }

    public Level0ArrayOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(new FArray.SortByComparator<T>(comparator)));
    }

    public Level0ListOperator<T> toList() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public Level0MapOperator<T, T> toMap() {
        return new Level0MapOperatorImpl<T, T>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> Level0MapOperator<K, T> toMap(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }

    public <K, V> Level0MapOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }

    public Level0SetOperator<T> toSet() {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new ToSet.FromArray<T>()));
    }

    @SuppressWarnings("unchecked")
	public T[] get() {
        return (T[]) getTarget().get();
    }

    public Level0GenericUniqOperator<T[]> generic() {
        return new Level0GenericUniqOperatorImpl<T[]>(getTarget());
    }


    
    

    public <X> Level0ArrayOperator<X> asArrayOf(final Type<X> newType) {
        return generic().asArrayOf(newType);
    }


    


    public Level0ArraySelectedOperator<T> ifIndex(final int... indexes) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level0ArraySelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }

    
    public Level0ArraySelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level0ArraySelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level0ArraySelectedOperator<T> ifNotNull() {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level0ArraySelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArraySelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ArraySelectedOperator<T> ifNull() {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level0ArraySelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level0ArraySelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


	public Level0ArrayOperator<T> execIfNotNullAsArray(final IFunction<? extends T[], ? super T[]> function) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().executeIfNotNull(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


	public Level0ArrayOperator<T> execAsArray(final IFunction<? extends T[], ? super T[]> function) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    


    public <X> Level0ArrayOperator<X> execAsArrayOf(final Type<X> newType, final IFunction<X[], ? super T[]> function) {
        return new Level0ArrayOperatorImpl<X>(newType, getTarget().execute(function, Normalisation.ARRAY(newType.getRawClass())));
    }


    


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super T[]> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0ArrayOperator<T> replaceWith(final T[] replacement) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ArrayOperator<T> replaceIfNullWith(final T[] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public <X> Level0ArrayOperator<X> map(final Type<X> newType, final IFunction<X, ? super T> function) {
        return new Level0ArrayOperatorImpl<X>(newType, getTarget().map(Structure.ARRAY, function, newType.getRawClass()));
    }


    public Level0ArrayOperator<T> map(final IFunction<? extends T, ? super T> function) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }


    


    public Level0ArrayOperator<T> mapIfNotNull(final IFunction<? extends T, ? super T> function) {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().mapIfNotNull(Structure.ARRAY, function, this.type.getRawClass()));
    }


    


}

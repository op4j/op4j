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
package org.op4j.operators.impl.fn.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.structures.FList;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.impl.fn.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.fn.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.fn.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.fn.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.list.Level0ListOperator;
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
public final class Level0ListOperatorImpl<T,I> extends AbstractOperatorImpl
        implements UniqFnOperator<List<T>,I>, Level0ListOperator<T,I>  {

    
    public Level0ListOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperatorImpl<T,I> add(final T newElement) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.Add<T>(newElement)));
    }

    public Level0ListOperatorImpl<T,I> addAll(final T... newElements) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperatorImpl<T,I> insert(final int position, final T newElement) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.Insert<T>(position, newElement)));
    }

    public Level0ListOperatorImpl<T,I> insertAll(final int position, final T... newElements) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.Insert<T>(position, newElements)));
    }


    public Level0ListOperatorImpl<T,I> addAll(final Collection<T> collection) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.AddAll<T>(collection)));
    }


    public Level0ListOperatorImpl<T,I> distinct() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.Distinct<T>()));
    }


    public Level1ListElementsOperatorImpl<T,I> forEach() {
        return new Level1ListElementsOperatorImpl<T,I>(getTarget().iterate(Structure.LIST));
    }


    public Level0ListOperatorImpl<T,I> removeAllIndexes(final int... indexes) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllIndexes<T>(indexes)));
    }


    public Level0ListOperatorImpl<T,I> removeAllEqual(final T... values) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllEqual<T>(values)));
    }


    public Level0ListOperatorImpl<T,I> removeAllTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllTrue<T>(eval)));
    }

    public Level0ListOperatorImpl<T,I> removeAllFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllFalse<T>(eval)));
    }

    public Level0ListOperatorImpl<T,I> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level0ListOperatorImpl<T,I> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ListOperatorImpl<T,I> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ListOperatorImpl<T,I> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ListOperatorImpl<T,I> removeAllIndexesNot(final int... indexes) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level0ListOperatorImpl<T,I> removeAllNull() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOperatorImpl<T,I> sort() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.Sort()));
    }


    public Level0ListOperatorImpl<T,I> sort(final Comparator<? super T> comparator) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new FList.SortByComparator<T>(comparator)));
    }


    public Level0ArrayOperatorImpl<T,I> toArrayOf(final Type<T> type) {
        return new Level0ArrayOperatorImpl<T,I>(type, getTarget().execute(new ToArray.FromCollection<T>(type)));
    }


    public Level0MapOperatorImpl<T, T,I> toMap() {
        return new Level0MapOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }

    public <K> Level0MapOperatorImpl<K, T,I> toMap(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperatorImpl<K, V,I> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0SetOperatorImpl<T,I> toSet() {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    @SuppressWarnings("unchecked")
    public List<T> get() {
        return (List<T>) getTarget().get();
    }


    public Level0GenericUniqOperatorImpl<List<T>,I> generic() {
        return new Level0GenericUniqOperatorImpl<List<T>,I>(getTarget());
    }
    
    
    
    
    
	public <X> Level0ListOperatorImpl<X,I> asListOf(final Type<X> type) {
        return generic().asListOf(type);
    }


    


    public Level0ListSelectedOperatorImpl<T,I> ifIndex(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectIndex(indexes));
    }


    public Level0ListSelectedOperatorImpl<T,I> ifIndexNot(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indexes));
    }


    public Level0ListSelectedOperatorImpl<T,I> ifTrue(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level0ListSelectedOperatorImpl<T,I> ifFalse(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level0ListSelectedOperatorImpl<T,I> ifNotNull() {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level0ListSelectedOperatorImpl<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListSelectedOperatorImpl<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListSelectedOperatorImpl<T,I> ifNull() {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level0ListSelectedOperatorImpl<T,I> ifNullOrTrue(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListSelectedOperatorImpl<T,I> ifNullOrFalse(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level0ListOperatorImpl<T,I> execIfNotNullAsList(final IFunction<? extends List<? extends T>, ? super List<T>> function) {
        return new Level0ListOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.LIST));
    }


    public <X> Level0ListOperatorImpl<X,I> execAsList(final IFunction<? extends List<X>, ? super List<T>> function) {
        return new Level0ListOperatorImpl<X,I>(getTarget().execute(function, Normalisation.LIST));
    }


    


    public <X> Level0GenericUniqOperatorImpl<X,I> exec(final IFunction<X, ? super List<T>> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0ListOperatorImpl<T,I> replaceWith(final List<T> replacement) {
        return new Level0ListOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public Level0ListOperatorImpl<T,I> replaceIfNullWith(final List<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    public <X> Level0ListOperatorImpl<X,I> map(final IFunction<X, ? super T> function) {
        return new Level0ListOperatorImpl<X,I>(getTarget().map(Structure.LIST, function, null));
    }
    

    public Level0ListOperatorImpl<T,I> mapIfNotNull(final IFunction<? extends T, ? super T> function) {
        return new Level0ListOperatorImpl<T,I>(getTarget().mapIfNotNull(Structure.LIST, function, null));
    }
    

    
    
    

}

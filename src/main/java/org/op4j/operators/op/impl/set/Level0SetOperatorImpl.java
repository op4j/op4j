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
package org.op4j.operators.op.impl.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.structures.FSet;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.op.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.op.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.op.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.op.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.op.intf.set.Level0SetOperator;
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
public final class Level0SetOperatorImpl<T,I> extends AbstractOperatorImpl
        implements UniqOpOperator<Set<T>>, Level0SetOperator<T,I>  {

    
    public Level0SetOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperatorImpl<T,I> add(final T newElement) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.Add<T>(newElement)));
    }

    public Level0SetOperatorImpl<T,I> addAll(final T... newElements) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperatorImpl<T,I> insert(final int position, final T newElement) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.Insert<T>(position, newElement)));
    }

    public Level0SetOperatorImpl<T,I> insertAll(final int position, final T... newElements) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.Insert<T>(position, newElements)));
    }


    public Level0SetOperatorImpl<T,I> addAll(final Collection<T> collection) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.AddAll<T>(collection)));
    }


    public Level1SetElementsOperatorImpl<T,I> forEach() {
        return new Level1SetElementsOperatorImpl<T,I>(getTarget().iterate(Structure.SET));
    }


    public Level0SetOperatorImpl<T,I> removeAllIndexes(final int... indexes) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllIndexes<T>(indexes)));
    }


    public Level0SetOperatorImpl<T,I> removeAllEqual(final T... values) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllEqual<T>(values)));
    }


    public Level0SetOperatorImpl<T,I> removeAllTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllTrue<T>(eval)));
    }

    public Level0SetOperatorImpl<T,I> removeAllFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllFalse<T>(eval)));
    }

    public Level0SetOperatorImpl<T,I> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level0SetOperatorImpl<T,I> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0SetOperatorImpl<T,I> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0SetOperatorImpl<T,I> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0SetOperatorImpl<T,I> removeAllIndexesNot(final int... indexes) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level0SetOperatorImpl<T,I> removeAllNull() {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0SetOperatorImpl<T,I> sort() {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.Sort()));
    }


    public Level0SetOperatorImpl<T,I> sort(final Comparator<? super T> comparator) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new FSet.SortByComparator<T>(comparator)));
    }


    public Level0ArrayOperatorImpl<T,I> toArrayOf(final Type<T> type) {
        return new Level0ArrayOperatorImpl<T,I>(type, getTarget().execute(new ToArray.FromCollection<T>(type)));
    }


    public Level0ListOperatorImpl<T,I> toList() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public Level0MapOperatorImpl<T, T,I> toMap() {
        return new Level0MapOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }


    public <K> Level0MapOperatorImpl<K, T,I> toMap(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperatorImpl<K, V,I> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    @SuppressWarnings("unchecked")
    public Set<T> get() {
        return (Set<T>) getTarget().get();
    }


    public Level0GenericUniqOperatorImpl<Set<T>,I> generic() {
        return new Level0GenericUniqOperatorImpl<Set<T>,I>(getTarget());
    }

    
    
    
    
    


    public <X> Level0SetOperatorImpl<X,I> asSetOf(final Type<X> type) {
        return generic().asSetOf(type);
    }


    


    public Level0SetSelectedOperatorImpl<T,I> ifIndex(final int... indexes) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectIndex(indexes));
    }


    public Level0SetSelectedOperatorImpl<T,I> ifIndexNot(final int... indexes) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indexes));
    }


    public Level0SetSelectedOperatorImpl<T,I> ifTrue(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level0SetSelectedOperatorImpl<T,I> ifFalse(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level0SetSelectedOperatorImpl<T,I> ifNotNull() {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level0SetSelectedOperatorImpl<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetSelectedOperatorImpl<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0SetSelectedOperatorImpl<T,I> ifNull() {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level0SetSelectedOperatorImpl<T,I> ifNullOrTrue(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0SetSelectedOperatorImpl<T,I> ifNullOrFalse(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level0SetOperatorImpl<T,I> execIfNotNullAsSet(final IFunction<? extends Set<? extends T>, ? super Set<T>> function) {
        return new Level0SetOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.SET));
    }


    public <X> Level0SetOperatorImpl<X,I> execAsSet(final IFunction<? extends Set<X>, ? super Set<T>> function) {
        return new Level0SetOperatorImpl<X,I>(getTarget().execute(function, Normalisation.SET));
    }


    


    public <X> Level0GenericUniqOperatorImpl<X,I> exec(final IFunction<X, ? super Set<T>> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0SetOperatorImpl<T,I> replaceWith(final Set<T> replacement) {
        return new Level0SetOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Level0SetOperatorImpl<T,I> replaceIfNullWith(final Set<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    public <X> Level0SetOperatorImpl<X,I> map(final IFunction<X, ? super T> function) {
        return new Level0SetOperatorImpl<X,I>(getTarget().map(Structure.SET, function, null));
    }
    

    public Level0SetOperatorImpl<T,I> mapIfNotNull(final IFunction<? extends T, ? super T> function) {
        return new Level0SetOperatorImpl<T,I>(getTarget().mapIfNotNull(Structure.SET, function, null));
    }

    
    
    
}

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
package org.op4j.operators.impl.op.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.FnSet;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.op.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.op.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.op.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.op.map.Level0MapOperatorImpl;
import org.op4j.operators.intf.set.Level0SetOperator;
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
public final class Level0SetOperatorImpl<I,T> extends AbstractOperatorImpl
        implements UniqOpOperator<I,Set<T>>, Level0SetOperator<I,T>  {

    
    public Level0SetOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOperatorImpl<I,T> add(final T newElement) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().add(newElement)));
    }

    public Level0SetOperatorImpl<I,T> addAll(final T... newElements) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().add(newElements)));
    }


    public Level0SetOperatorImpl<I,T> insert(final int position, final T newElement) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().insert(position, newElement)));
    }

    public Level0SetOperatorImpl<I,T> insertAll(final int position, final T... newElements) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().insert(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperatorImpl<I,T> addAll(final Collection<T> collection) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().addAll((Collection)collection)));
    }


    public Level1SetElementsOperatorImpl<I,T> forEach() {
        return new Level1SetElementsOperatorImpl<I,T>(getTarget().iterate(Structure.SET));
    }


    public Level0SetOperatorImpl<I,T> removeAllIndexes(final int... indexes) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllIndexes(indexes)));
    }


    public Level0SetOperatorImpl<I,T> removeAllEqual(final T... values) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllEqual(values)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperatorImpl<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllTrue((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0SetOperatorImpl<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllFalse((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0SetOperatorImpl<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllNullOrFalse((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0SetOperatorImpl<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllNotNullAndFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperatorImpl<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllNullOrTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperatorImpl<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllNotNullAndTrue((IFunction)eval)));
    }


    public Level0SetOperatorImpl<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllIndexesNot(indexes)));
    }


    public Level0SetOperatorImpl<I,T> removeAllNull() {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllNull()));
    }

    


    public Level0SetOperatorImpl<I,T> sort() {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().sort()));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperatorImpl<I,T> sort(final Comparator<? super T> comparator) {
        return new Level0SetOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().sort((Comparator)comparator)));
    }


    public Level0ArrayOperatorImpl<I,T> toArrayOf(final Type<T> type) {
        return new Level0ArrayOperatorImpl<I,T>(type, getTarget().execute(new ToArray.FromCollection<T>(type)));
    }


    public Level0ListOperatorImpl<I,T> toList() {
        return new Level0ListOperatorImpl<I,T>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public Level0MapOperatorImpl<I,T, T> toMap() {
        return new Level0MapOperatorImpl<I,T, T>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }


    public <K> Level0MapOperatorImpl<I,K, T> toMap(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperatorImpl<I,K, T>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperatorImpl<I,K, V> toMap(final IMapBuilder<? super T,K,V> mapBuild) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    @SuppressWarnings("unchecked")
    public Set<T> get() {
        return (Set<T>) getTarget().get();
    }


    public Level0GenericUniqOperatorImpl<I,Set<T>> generic() {
        return new Level0GenericUniqOperatorImpl<I,Set<T>>(getTarget());
    }

    
    
    
    
    


    public <X> Level0SetOperatorImpl<I,X> asSetOf(final Type<X> type) {
        return generic().asSetOf(type);
    }


    


    public Level0SetSelectedOperatorImpl<I,T> ifIndex(final int... indexes) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().selectIndex(indexes));
    }


    public Level0SetSelectedOperatorImpl<I,T> ifIndexNot(final int... indexes) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level0SetSelectedOperatorImpl<I,T> ifTrue(final IFunction<? super Set<T>,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().selectMatching(eval));
    }


    public Level0SetSelectedOperatorImpl<I,T> ifFalse(final IFunction<? super Set<T>,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level0SetSelectedOperatorImpl<I,T> ifNotNull() {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().selectNotNull());
    }


    public Level0SetSelectedOperatorImpl<I,T> ifNotNullAndTrue(final IFunction<? super Set<T>,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetSelectedOperatorImpl<I,T> ifNotNullAndFalse(final IFunction<? super Set<T>,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0SetSelectedOperatorImpl<I,T> ifNull() {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().selectNull());
    }


    public Level0SetSelectedOperatorImpl<I,T> ifNullOrTrue(final IFunction<? super Set<T>,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0SetSelectedOperatorImpl<I,T> ifNullOrFalse(final IFunction<? super Set<T>,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level0SetOperatorImpl<I,T> execIfNotNullAsSet(final IFunction<? super Set<T>,? extends Set<? extends T>> function) {
        return new Level0SetOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.SET));
    }


    public <X> Level0SetOperatorImpl<I,X> execAsSet(final IFunction<? super Set<T>,? extends Set<X>> function) {
        return new Level0SetOperatorImpl<I,X>(getTarget().execute(function, Normalisation.SET));
    }


    


    public <X> Level0GenericUniqOperatorImpl<I,X> exec(final IFunction<? super Set<T>,X> function) {
        return new Level0GenericUniqOperatorImpl<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0SetOperatorImpl<I,T> replaceWith(final Set<T> replacement) {
        return new Level0SetOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Level0SetOperatorImpl<I,T> replaceIfNullWith(final Set<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    public <X> Level0SetOperatorImpl<I,X> map(final IFunction<? super T,X> function) {
        return new Level0SetOperatorImpl<I,X>(getTarget().map(Structure.SET, function, null));
    }
    

    public Level0SetOperatorImpl<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level0SetOperatorImpl<I,T>(getTarget().mapIfNotNull(Structure.SET, function, null));
    }

    
    
    
}

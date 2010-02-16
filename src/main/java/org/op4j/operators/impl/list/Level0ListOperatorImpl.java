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
package org.op4j.operators.impl.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.structures.ListFuncs;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.list.Level0ListSelectedOperator;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
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
public final class Level0ListOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0ListOperator<T>  {

    
    public Level0ListOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperator<T> add(final T newElement) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }

    public Level0ListOperator<T> addAll(final T... newElements) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperator<T> insert(final int position, final T newElement) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }

    public Level0ListOperator<T> insertAll(final int position, final T... newElements) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level0ListOperator<T> addAll(final Collection<T> collection) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level0ListOperator<T> distinct() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1ListElementsOperator<T> forEach() {
        return new Level1ListElementsOperatorImpl<T>(getTarget().iterate(Structure.LIST));
    }


    public Level0ListOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level0ListOperator<T> removeAllEqual(final T... values) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level0ListOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level0ListOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level0ListOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level0ListOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ListOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ListOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ListOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level0ListOperator<T> removeAllNull() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOperator<T> sort() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level0ArrayOperator<T> toArrayOf(final Type<T> type) {
        return new Level0ArrayOperatorImpl<T>(type, getTarget().execute(new ToArray.FromCollection<T>(type)));
    }


    public Level0MapOperator<T, T> toMap() {
        return new Level0MapOperatorImpl<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }

    public <K> Level0MapOperator<K, T> toMap(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0SetOperator<T> toSet() {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    @SuppressWarnings("unchecked")
    public List<T> get() {
        return (List<T>) getTarget().get();
    }


    public Level0GenericUniqOperator<List<T>> generic() {
        return new Level0GenericUniqOperatorImpl<List<T>>(getTarget());
    }
    
    
    
    
    
	public <X> Level0ListOperator<X> asListOf(final Type<X> type) {
        return generic().asListOf(type);
    }


    public Level0ListOperator<?> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level0ListSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level0ListSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level0ListSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0ListSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0ListSelectedOperator<T> ifNotNull() {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0ListSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListSelectedOperator<T> ifNull() {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0ListSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0ListOperator<X> execIfNotNullAsList(final IFunction<? extends List<X>, ? super List<T>> function) {
        return new Level0ListOperatorImpl<X>(getTarget().executeIfNotNull(function, Normalisation.LIST));
    }


    public <X> Level0ListOperator<X> execAsList(final IFunction<? extends List<X>, ? super List<T>> function) {
        return new Level0ListOperatorImpl<X>(getTarget().execute(function, Normalisation.LIST));
    }


    public <X> Level0GenericUniqOperator<X> execIfNotNull(final IFunction<X, ? super List<T>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super List<T>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0ListOperator<T> replaceWith(final List<T> replacement) {
        return new Level0ListOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public Level0ListOperator<T> replaceIfNullWith(final List<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    public <X> Level0ListOperator<X> map(final IFunction<X, ? super T> function) {
        return new Level0ListOperatorImpl<X>(getTarget().map(Structure.LIST, function, null));
    }
    

    public <X> Level0ListOperator<X> mapIfNotNull(final IFunction<X, ? super T> function) {
        return new Level0ListOperatorImpl<X>(getTarget().mapIfNotNull(Structure.LIST, function, null));
    }
    

    
    
    

}

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
package org.op4j.operators.impl.op.generic;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToMapOfArray;
import org.op4j.functions.converters.ToMapOfList;
import org.op4j.functions.converters.ToMapOfSet;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.structures.FList;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.impl.op.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.op.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.op.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.op.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericMultiOperator;
import org.op4j.operators.qualities.MultiOpOperator;
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
        implements MultiOpOperator<I,T>, Level0GenericMultiOperator<I,T>  {

    
    public Level0GenericMultiOperatorImpl(final Target target) {
        super(target);
        if (((List<?>)target.endIterate(null).get()).size() <= 0) {
            throw new IllegalStateException("Empty targets: cannot create an operator on no target objects at all.");
        }
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperatorImpl<I,T> add(final T newElement) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.Add<T>(newElement)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperatorImpl<I,T> addAll(final T... newElements) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.Add<T>(newElements)).iterate(Structure.LIST, true));
    }

    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperatorImpl<I,T> insert(final int position, final T newElement) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.Insert<T>(position, newElement)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperatorImpl<I,T> insertAll(final int position, final T... newElements) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.Insert<T>(position, newElements)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperatorImpl<I,T> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.AddAll<T>(collection)).iterate(Structure.LIST, true));
    }


    public Level0ArrayOperatorImpl<I,T> buildArrayOf(final Type<T> type) {
        return new Level0ArrayOperatorImpl<I,T>(type, getTarget().endIterate(null).execute(new ToArray.FromCollection<T>(type)));
    }


    public Level0ListOperatorImpl<I,T> buildList() {
        return new Level0ListOperatorImpl<I,T>(getTarget().endIterate(null).execute(new ToList.FromCollection<T>()));
    }


    public <K> Level0MapOperatorImpl<I,K, T> buildMap(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<I,K, T>(getTarget().endIterate(null).execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperatorImpl<I,K, V> buildMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().endIterate(null).execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0MapOperatorImpl<I,T, T> buildMap() {
        return new Level0MapOperatorImpl<I,T, T>(getTarget().endIterate(null).execute(new ToMap.FromListByAlternateElements<T>()));
    }


    public <K> Level0MapOperatorImpl<I,K, T[]> buildMapOfArrayOf(final Type<T> valueType, final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<I,K, T[]>(getTarget().endIterate(null).execute(new ToMapOfArray.FromListByKeyEval<K, T>(valueType, keyEval)));
    }


    public <K, V> Level0MapOperatorImpl<I,K, V[]> buildMapOfArrayOf(final Type<V> valueType, final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<I,K, V[]>(getTarget().endIterate(null).execute(new ToMapOfArray.FromListByMapBuilder<K, V, T>(valueType, mapBuild)));
    }


    public Level0MapOperatorImpl<I,T, T[]> buildMapOfArrayOf(final Type<T> type) {
        return new Level0MapOperatorImpl<I,T, T[]>(getTarget().endIterate(null).execute(new ToMapOfArray.FromListByAlternateElements<T>(type)));
    }


    public <K> Level0MapOperatorImpl<I,K, List<T>> buildMapOfList(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<I,K, List<T>>(getTarget().endIterate(null).execute(new ToMapOfList.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperatorImpl<I,K, List<V>> buildMapOfList(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<I,K, List<V>>(getTarget().endIterate(null).execute(new ToMapOfList.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0MapOperatorImpl<I,T, List<T>> buildMapOfList() {
        return new Level0MapOperatorImpl<I,T, List<T>>(getTarget().endIterate(null).execute(new ToMapOfList.FromListByAlternateElements<T>()));
    }


    public <K> Level0MapOperatorImpl<I,K, Set<T>> buildMapOfSet(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<I,K, Set<T>>(getTarget().endIterate(null).execute(new ToMapOfSet.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperatorImpl<I,K, Set<V>> buildMapOfSet(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<I,K, Set<V>>(getTarget().endIterate(null).execute(new ToMapOfSet.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0MapOperatorImpl<I,T, Set<T>> buildMapOfSet() {
        return new Level0MapOperatorImpl<I,T, Set<T>>(getTarget().endIterate(null).execute(new ToMapOfSet.FromListByAlternateElements<T>()));
    }


    public Level0SetOperatorImpl<I,T> buildSet() {
        return new Level0SetOperatorImpl<I,T>(getTarget().endIterate(null).execute(new ToSet.FromCollection<T>()));
    }


    public <X> Level0GenericMultiOperatorImpl<I,X> asType(final Type<X> type) {
        return new Level0GenericMultiOperatorImpl<I,X>(getTarget());
    }

    public Level0GenericMultiOperatorImpl<I,?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Level0GenericMultiOperatorImpl<I,T> removeAllIndexes(final int... indexes) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.RemoveAllIndexes<T>(indexes)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperatorImpl<I,T> removeAllEqual(final T... values) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.RemoveAllEqual<T>(values)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperatorImpl<I,T> removeAllTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.RemoveAllTrue<T>(eval)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperatorImpl<I,T> removeAllFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.RemoveAllFalse<T>(eval)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperatorImpl<I,T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.RemoveAllNullOrFalse<T>(eval)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperatorImpl<I,T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.RemoveAllNotNullAndFalse<T>(eval)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperatorImpl<I,T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.RemoveAllNullOrTrue<T>(eval)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperatorImpl<I,T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.RemoveAllNotNullAndTrue<T>(eval)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperatorImpl<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.RemoveAllIndexesNot<T>(indexes)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperatorImpl<I,T> removeAllNull() {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endIterate(null).execute(new FList.RemoveAllNull<T>()).iterate(Structure.LIST, true));
    }

    


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifIndex(final int... indexes) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectIndex(indexes));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifIndexNot(final int... indexes) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectMatching(eval));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifNotNull() {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectNotNull());
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifNull() {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectNull());
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().selectNullOrNotMatching(eval));
    }





    public Level0GenericUniqOperatorImpl<I,T> uniq() {
        if (size() > 1) {
            throw new IllegalStateException("Cannot call uniq(): more than one target exist (size: " + size() + ")");
        }
        return new Level0GenericUniqOperatorImpl<I,T>(getTarget().endIterate(null).replaceWith(getAsList().get(0), Normalisation.NONE));
    }


    public int size() {
        return ((List<?>) getTarget().endIterate(null).get()).size();
    }


    public T[] getAsArray(final Type<T> type) {
        return buildArrayOf(type).get();
    }


    public List<T> getAsList() {
        return buildList().get();
    }


    public <X> Level0GenericMultiOperatorImpl<I,X> execIfNotNull(final IFunction<X, ? super T> function) {
        return new Level0GenericMultiOperatorImpl<I,X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level0GenericMultiOperatorImpl<I,X> exec(final IFunction<X, ? super T> function) {
        return new Level0GenericMultiOperatorImpl<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericMultiOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level0GenericMultiOperatorImpl<I,T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }
    
}

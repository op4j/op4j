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
package org.op4j.operators.impl.generic;

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
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.generic.Level0GenericMultiOperator;
import org.op4j.operators.intf.generic.Level0GenericMultiSelectedOperator;
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
public final class Level0GenericMultiOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0GenericMultiOperator<T>  {

    
    public Level0GenericMultiOperatorImpl(final Target target) {
        super(target);
        if (((List<?>)target.endIterate(null).get()).size() <= 0) {
            throw new IllegalStateException("Empty targets: cannot create an operator on no target objects at all.");
        }
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<T> add(final T newElement) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.Add<T>(newElement)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperator<T> addAll(final T... newElements) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.Add<T>(newElements)).iterate(Structure.LIST, true));
    }

    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<T> insert(final int position, final T newElement) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.Insert<T>(position, newElement)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperator<T> insertAll(final int position, final T... newElements) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.Insert<T>(position, newElements)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperator<T> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.AddAll<T>(collection)).iterate(Structure.LIST, true));
    }


    public Level0ArrayOperator<T> buildArrayOf(final Type<T> type) {
        return new Level0ArrayOperatorImpl<T>(type, getTarget().endIterate(null).execute(new ToArray.FromCollection<T>(type)));
    }


    public Level0ListOperator<T> buildList() {
        return new Level0ListOperatorImpl<T>(getTarget().endIterate(null).execute(new ToList.FromCollection<T>()));
    }


    public <K> Level0MapOperator<K, T> buildMap(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T>(getTarget().endIterate(null).execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, V> buildMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V>(getTarget().endIterate(null).execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0MapOperator<T, T> buildMap() {
        return new Level0MapOperatorImpl<T, T>(getTarget().endIterate(null).execute(new ToMap.FromListByAlternateElements<T>()));
    }


    public <K> Level0MapOperator<K, T[]> buildMapOfArrayOf(final Type<T> valueType, final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T[]>(getTarget().endIterate(null).execute(new ToMapOfArray.FromListByKeyEval<K, T>(valueType, keyEval)));
    }


    public <K, V> Level0MapOperator<K, V[]> buildMapOfArrayOf(final Type<V> valueType, final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V[]>(getTarget().endIterate(null).execute(new ToMapOfArray.FromListByMapBuilder<K, V, T>(valueType, mapBuild)));
    }


    public Level0MapOperator<T, T[]> buildMapOfArrayOf(final Type<T> type) {
        return new Level0MapOperatorImpl<T, T[]>(getTarget().endIterate(null).execute(new ToMapOfArray.FromListByAlternateElements<T>(type)));
    }


    public <K> Level0MapOperator<K, List<T>> buildMapOfList(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, List<T>>(getTarget().endIterate(null).execute(new ToMapOfList.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, List<V>> buildMapOfList(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, List<V>>(getTarget().endIterate(null).execute(new ToMapOfList.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0MapOperator<T, List<T>> buildMapOfList() {
        return new Level0MapOperatorImpl<T, List<T>>(getTarget().endIterate(null).execute(new ToMapOfList.FromListByAlternateElements<T>()));
    }


    public <K> Level0MapOperator<K, Set<T>> buildMapOfSet(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, Set<T>>(getTarget().endIterate(null).execute(new ToMapOfSet.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, Set<V>> buildMapOfSet(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, Set<V>>(getTarget().endIterate(null).execute(new ToMapOfSet.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0MapOperator<T, Set<T>> buildMapOfSet() {
        return new Level0MapOperatorImpl<T, Set<T>>(getTarget().endIterate(null).execute(new ToMapOfSet.FromListByAlternateElements<T>()));
    }


    public Level0SetOperator<T> buildSet() {
        return new Level0SetOperatorImpl<T>(getTarget().endIterate(null).execute(new ToSet.FromCollection<T>()));
    }


    public <X> Level0GenericMultiOperator<X> asType(final Type<X> type) {
        return new Level0GenericMultiOperatorImpl<X>(getTarget());
    }

    public Level0GenericMultiOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Level0GenericMultiOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.RemoveAllIndexes<T>(indexes)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperator<T> removeAllEqual(final T... values) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.RemoveAllEqual<T>(values)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.RemoveAllTrue<T>(eval)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.RemoveAllFalse<T>(eval)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.RemoveAllNullOrFalse<T>(eval)).iterate(Structure.LIST, true));
    }

    public Level0GenericMultiOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.RemoveAllNotNullAndFalse<T>(eval)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.RemoveAllNullOrTrue<T>(eval)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.RemoveAllNotNullAndTrue<T>(eval)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.RemoveAllIndexesNot<T>(indexes)).iterate(Structure.LIST, true));
    }


    public Level0GenericMultiOperator<T> removeAllNull() {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endIterate(null).execute(new FList.RemoveAllNull<T>()).iterate(Structure.LIST, true));
    }

    


    public Level0GenericMultiSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level0GenericMultiSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level0GenericMultiSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T> ifNotNull() {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0GenericMultiSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T> ifNull() {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0GenericMultiSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }





    public Level0GenericUniqOperator<T> uniq() {
        if (size() > 1) {
            throw new IllegalStateException("Cannot call uniq(): more than one target exist (size: " + size() + ")");
        }
        return new Level0GenericUniqOperatorImpl<T>(getTarget().endIterate(null).replaceWith(getAsList().get(0), Normalisation.NONE));
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


    public <X> Level0GenericMultiOperator<X> execIfNotNull(final IFunction<X, ? super T> function) {
        return new Level0GenericMultiOperatorImpl<X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level0GenericMultiOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level0GenericMultiOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericMultiOperator<T> replaceWith(final T replacement) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level0GenericMultiOperator<T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }
    
}

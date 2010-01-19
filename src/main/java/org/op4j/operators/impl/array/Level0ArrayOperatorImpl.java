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
import org.javaruntype.type.Types;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.array.Level0ArraySelectedOperator;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class Level0ArrayOperatorImpl<T> 
        extends AbstractOperatorImpl 
        implements Level0ArrayOperator<T> {

    
    
    public Level0ArrayOperatorImpl(final Target target) {
        super(target);
    }

    
    public Level0ArrayOperator<T> add(final T... newElements) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level0ArrayOperator<T> insert(final int position, final T... newElements) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level0ArrayOperator<T> addAll(final Collection<T> collection) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }

    public Level0ArrayOperator<T> distinct() {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }

    public Level1ArrayElementsOperator<T> forEach(final Type<T> elementType) {
        return new Level1ArrayElementsOperatorImpl<T>(elementType, getTarget().iterate());
    }

    
    public Level0ArrayOperator<T> removeAllIndexes(final int... indices) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level0ArrayOperator<T> removeAllEqual(final T... values) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level0ArrayOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level0ArrayOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level0ArrayOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level0ArrayOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ArrayOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ArrayOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ArrayOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indices)));
    }



    public Level0ArrayOperator<T> removeAllNull() {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<T> sort() {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level0ArrayOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }

    public Level0ListOperator<T> toList() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public Level0MapOperator<T, T> toMap() {
        return new Level0MapOperatorImpl<T, T>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> Level0MapOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
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


    
    

    public <X> Level0ArrayOperator<X> asArrayOf(final Type<X> type) {
        return generic().asArrayOf(type);
    }


    public <X> Level0ArrayOfArrayOperator<X> asArrayOfArrayOf(final Type<X> type) {
        return generic().asArrayOfArrayOf(type);
    }


    public Level0ArrayOfArrayOperator<?> asArrayOfArrayOfUnknown() {
        return asArrayOfArrayOf(Types.OBJECT);
    }


    public <X> Level0ArrayOfListOperator<X> asArrayOfListOf(final Type<X> type) {
        return generic().asArrayOfListOf(type);
    }


    public Level0ArrayOfListOperator<?> asArrayOfListOfUnknown() {
        return asArrayOfListOf(Types.OBJECT);
    }


    public <K, V> Level0ArrayOfMapOperator<K, V> asArrayOfMapOf(final Type<K> keyType, final Type<V> valueType) {
        return generic().asArrayOfMapOf(keyType, valueType);
    }


    public Level0ArrayOfMapOperator<?, ?> asArrayOfMapOfUnknown() {
        return asArrayOfMapOf(Types.OBJECT, Types.OBJECT);
    }


    public <X> Level0ArrayOfSetOperator<X> asArrayOfSetOf(final Type<X> type) {
        return generic().asArrayOfSetOf(type);
    }


    public Level0ArrayOfSetOperator<?> asArrayOfSetOfUnknown() {
        return asArrayOfSetOf(Types.OBJECT);
    }


    public Level0ArrayOperator<?> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level0ArraySelectedOperator<T> ifIndex(final int... indices) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level0ArraySelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }

    
    public Level0ArraySelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0ArraySelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0ArraySelectedOperator<T> ifNotNull() {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0ArraySelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArraySelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ArraySelectedOperator<T> ifNull() {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0ArraySelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ArraySelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


	public <X> Level0ArrayOperator<X> convert(final IConverter<X[], ? super T[]> converter) {
        return new Level0ArrayOperatorImpl<X>(getTarget().execute(converter, Normalization.ARRAY));
    }


	public <X> Level0ArrayOperator<X> eval(final IEvaluator<X[], ? super T[]> eval) {
        return new Level0ArrayOperatorImpl<X>(getTarget().execute(eval, Normalization.ARRAY));
    }


	public <X> Level0ArrayOperator<X> exec(final IFunction<X[], ? super T[]> function) {
        return new Level0ArrayOperatorImpl<X>(getTarget().execute(function, Normalization.ARRAY));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super T[]> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super T[]> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super T[]> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0ArrayOperator<T> replaceBy(final T[] replacement) {
        return new Level0ArrayOperatorImpl<T>(getTarget().replaceBy(replacement));
    }


    public Level0ArrayOperator<T> replaceIfNullBy(final T[] replacement) {
        return ifNull().replaceBy(replacement).endIf();
    }


}

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
import org.op4j.exceptions.NonEmptyTargetException;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operations.Operation;
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
import org.op4j.target.OperationChainingTarget;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class Level0ArrayOperatorImpl<T,I> 
        extends AbstractOperatorImpl 
        implements Level0ArrayOperator<T,I> {

    
    
    public Level0ArrayOperatorImpl(final Target target) {
        super(target);
    }

    
    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<T,I> add(final T newElement) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }

    public Level0ArrayOperator<T,I> addAll(final T... newElements) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<T,I> insert(final int position, final T newElement) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }

    public Level0ArrayOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level0ArrayOperator<T,I> addAll(final Collection<T> collection) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }

    public Level0ArrayOperator<T,I> distinct() {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }

    public Level1ArrayElementsOperator<T,I> forEach(final Type<T> elementType) {
        return new Level1ArrayElementsOperatorImpl<T,I>(elementType, getTarget().iterate());
    }

    
    public Level0ArrayOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level0ArrayOperator<T,I> removeAllEqual(final T... values) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level0ArrayOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level0ArrayOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level0ArrayOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level0ArrayOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ArrayOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ArrayOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ArrayOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indices)));
    }



    public Level0ArrayOperator<T,I> removeAllNull() {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public Level0ArrayOperator<T,I> sort() {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level0ArrayOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }

    public Level0ListOperator<T,I> toList() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public Level0MapOperator<T, T,I> toMap() {
        return new Level0MapOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> Level0MapOperator<K, T,I> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }

    public <K, V> Level0MapOperator<K, V,I> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }

    public Level0SetOperator<T,I> toSet() {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new ToSet.FromArray<T>()));
    }

    @SuppressWarnings("unchecked")
	public T[] get() {
        return (T[]) getTarget().get();
    }

    public Level0GenericUniqOperator<T[],I> generic() {
        return new Level0GenericUniqOperatorImpl<T[],I>(getTarget());
    }


    
    

    public <X> Level0ArrayOperator<X,I> asArrayOf(final Type<X> type) {
        return generic().asArrayOf(type);
    }


    public <X> Level0ArrayOfArrayOperator<X,I> asArrayOfArrayOf(final Type<X> type) {
        return generic().asArrayOfArrayOf(type);
    }


    public Level0ArrayOfArrayOperator<?,I> asArrayOfArrayOfUnknown() {
        return asArrayOfArrayOf(Types.OBJECT);
    }


    public <X> Level0ArrayOfListOperator<X,I> asArrayOfListOf(final Type<X> type) {
        return generic().asArrayOfListOf(type);
    }


    public Level0ArrayOfListOperator<?,I> asArrayOfListOfUnknown() {
        return asArrayOfListOf(Types.OBJECT);
    }


    public <K, V> Level0ArrayOfMapOperator<K, V,I> asArrayOfMapOf(final Type<K> keyType, final Type<V> valueType) {
        return generic().asArrayOfMapOf(keyType, valueType);
    }


    public Level0ArrayOfMapOperator<?, ?,I> asArrayOfMapOfUnknown() {
        return asArrayOfMapOf(Types.OBJECT, Types.OBJECT);
    }


    public <X> Level0ArrayOfSetOperator<X,I> asArrayOfSetOf(final Type<X> type) {
        return generic().asArrayOfSetOf(type);
    }


    public Level0ArrayOfSetOperator<?,I> asArrayOfSetOfUnknown() {
        return asArrayOfSetOf(Types.OBJECT);
    }


    public Level0ArrayOperator<?,I> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level0ArraySelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level0ArraySelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }

    
    public Level0ArraySelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level0ArraySelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level0ArraySelectedOperator<T,I> ifNotNull() {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level0ArraySelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArraySelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ArraySelectedOperator<T,I> ifNull() {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level0ArraySelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ArraySelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


	public <X> Level0ArrayOperator<X,I> convert(final IConverter<X[], ? super T[]> converter) {
        return new Level0ArrayOperatorImpl<X,I>(getTarget().execute(converter, Normalization.ARRAY));
    }


	public <X> Level0ArrayOperator<X,I> eval(final IEvaluator<X[], ? super T[]> eval) {
        return new Level0ArrayOperatorImpl<X,I>(getTarget().execute(eval, Normalization.ARRAY));
    }


	public <X> Level0ArrayOperator<X,I> exec(final IFunction<X[], ? super T[]> function) {
        return new Level0ArrayOperatorImpl<X,I>(getTarget().execute(function, Normalization.ARRAY));
    }


    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super T[]> converter) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super T[]> eval) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super T[]> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0ArrayOperator<T,I> replaceWith(final T[] replacement) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0ArrayOperator<T,I> replaceIfNullWith(final T[] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<T[], I> createOperation() {
        final Target target = getTarget();
        if (!(target instanceof OperationChainingTarget)) {
            throw new NonEmptyTargetException();
        }
        return new Operation<T[],I>((OperationChainingTarget) target);
    }


}

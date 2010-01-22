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

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.NonUniqueTargetException;
import org.op4j.exceptions.ZeroSizeTargetException;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToMapOfArray;
import org.op4j.functions.converters.ToMapOfList;
import org.op4j.functions.converters.ToMapOfSet;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.mapofarray.Level0MapOfArrayOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level0MapOfListOperatorImpl;
import org.op4j.operators.impl.mapofset.Level0MapOfSetOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.generic.Level0GenericMultiOperator;
import org.op4j.operators.intf.generic.Level0GenericMultiSelectedOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0GenericMultiOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level0GenericMultiOperator<T,I>  {

    
    public Level0GenericMultiOperatorImpl(final Target target) {
        super(target);
        if (((List<?>)target.get()).size() <= 0) {
            throw new ZeroSizeTargetException();
        }
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<T,I> add(final T newElement) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }

    public Level0GenericMultiOperator<T,I> addAll(final T... newElements) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }

    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<T,I> insert(final int position, final T newElement) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }

    public Level0GenericMultiOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level0GenericMultiOperator<T,I> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level0ArrayOperator<T,I> buildArray(final Type<T> arrayOf) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ToArray.FromCollection<T>(arrayOf)));
    }


    public Level0ListOperator<T,I> buildList() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public <K> Level0MapOperator<K, T,I> buildMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, V,I> buildMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0MapOperator<T, T,I> buildMap() {
        return new Level0MapOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }


    public <K> Level0MapOfArrayOperator<K, T,I> buildMapOfArray(final Type<T> valueArrayOf, final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfArrayOperatorImpl<K, T,I>(getTarget().execute(new ToMapOfArray.FromListByKeyEval<K, T>(valueArrayOf, keyEval)));
    }


    public <K, V> Level0MapOfArrayOperator<K, V,I> buildMapOfArray(final Type<V> valueArrayOf, final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfArrayOperatorImpl<K, V,I>(getTarget().execute(new ToMapOfArray.FromListByMapBuilder<K, V, T>(valueArrayOf, mapBuild)));
    }


    public Level0MapOfArrayOperator<T, T,I> buildMapOfArray(final Type<T> valueArrayOf) {
        return new Level0MapOfArrayOperatorImpl<T, T,I>(getTarget().execute(new ToMapOfArray.FromListByAlternateElements<T>(valueArrayOf)));
    }


    public <K> Level0MapOfListOperator<K, T,I> buildMapOfList(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfListOperatorImpl<K, T,I>(getTarget().execute(new ToMapOfList.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOfListOperator<K, V,I> buildMapOfList(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfListOperatorImpl<K, V,I>(getTarget().execute(new ToMapOfList.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0MapOfListOperator<T, T,I> buildMapOfList() {
        return new Level0MapOfListOperatorImpl<T, T,I>(getTarget().execute(new ToMapOfList.FromListByAlternateElements<T>()));
    }


    public <K> Level0MapOfSetOperator<K, T,I> buildMapOfSet(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfSetOperatorImpl<K, T,I>(getTarget().execute(new ToMapOfSet.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOfSetOperator<K, V,I> buildMapOfSet(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfSetOperatorImpl<K, V,I>(getTarget().execute(new ToMapOfSet.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0MapOfSetOperator<T, T,I> buildMapOfSet() {
        return new Level0MapOfSetOperatorImpl<T, T,I>(getTarget().execute(new ToMapOfSet.FromListByAlternateElements<T>()));
    }


    public Level0SetOperator<T,I> buildSet() {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    public <X> Level0GenericMultiOperator<X,I> asType(final Type<X> type) {
        return new Level0GenericMultiOperatorImpl<X,I>(getTarget());
    }

    public Level0GenericMultiOperator<?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Level0GenericMultiOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level0GenericMultiOperator<T,I> removeAllEqual(final T... values) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level0GenericMultiOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level0GenericMultiOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level0GenericMultiOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level0GenericMultiOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0GenericMultiOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0GenericMultiOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0GenericMultiOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level0GenericMultiOperator<T,I> removeAllNull() {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }

    


    public Level0GenericMultiSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level0GenericMultiSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level0GenericMultiSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T,I> ifNotNull() {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level0GenericMultiSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T,I> ifNull() {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level0GenericMultiSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }





    public Level0GenericUniqOperator<T,I> uniq() {
        if (size() > 1) {
            throw new NonUniqueTargetException();
        }
        return new Level0GenericUniqOperatorImpl<T, I>(getTarget().replaceWith(getAsList().get(0)));
    }


    public int size() {
        return ((List<?>) getTarget().get()).size();
    }


    public T[] getAsArray(final Type<T> type) {
        return buildArray(type).get();
    }


    public List<T> getAsList() {
        return buildList().get();
    }


    public <X> Level0GenericMultiOperator<X,I> convert(final IConverter<X, ? super T> converter) {
        return new Level0GenericMultiOperatorImpl<X,I>(getTarget().iterate().execute(converter, Normalization.NONE).endIterate(Structure.LIST, null));
    }


    public <X> Level0GenericMultiOperator<X,I> eval(final IEvaluator<X, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<X,I>(getTarget().iterate().execute(eval, Normalization.NONE).endIterate(Structure.LIST, null));
    }


    public <X> Level0GenericMultiOperator<X,I> exec(final IFunction<X, ? super T> function) {
        return new Level0GenericMultiOperatorImpl<X,I>(getTarget().iterate().execute(function, Normalization.NONE).endIterate(Structure.LIST, null));
    }


    public Level0GenericMultiOperator<T,I> replaceWith(final T replacement) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0GenericMultiOperator<T,I> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<T[], I> createArrayOperation(Type<T> type) {
        return buildArray(type).createOperation();
    }


    public Operation<List<T>, I> createListOperation() {
        return buildList().createOperation();
    }
    
}

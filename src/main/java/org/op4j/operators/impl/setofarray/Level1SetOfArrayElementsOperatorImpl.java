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
package org.op4j.operators.impl.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

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
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.set.Level1SetElementsOperatorImpl;
import org.op4j.operators.impl.setoflist.Level1SetOfListElementsOperatorImpl;
import org.op4j.operators.impl.setofmap.Level1SetOfMapElementsOperatorImpl;
import org.op4j.operators.impl.setofset.Level1SetOfSetElementsOperatorImpl;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArrayElementsElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
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
public class Level1SetOfArrayElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level1SetOfArrayElementsOperator<T,I>  {

    
    public Level1SetOfArrayElementsOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArrayElementsOperator<T,I> add(final T newElement) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }

    public Level1SetOfArrayElementsOperator<T,I> addAll(final T... newElements) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArrayElementsOperator<T,I> insert(final int position, final T newElement) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }

    public Level1SetOfArrayElementsOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfArrayElementsOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1SetOfArrayElementsOperator<T,I> distinct() {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level0SetOfArrayOperator<T,I> endFor() {
        return new Level0SetOfArrayOperatorImpl<T,I>(getTarget().endIterate(Structure.SET, null));
    }


    public Level2SetOfArrayElementsElementsOperator<T,I> forEach(final Type<T> elementType) {
        return new Level2SetOfArrayElementsElementsOperatorImpl<T,I>(elementType, getTarget().iterate());
    }


    public Level1SetOfArrayElementsOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1SetOfArrayElementsOperator<T,I> removeAllEqual(final T... values) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfArrayElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level1SetOfArrayElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level1SetOfArrayElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level1SetOfArrayElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfArrayElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfArrayElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfArrayElementsOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indices)));
    }



    public Level1SetOfArrayElementsOperator<T,I> removeAllNull() {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public Level1SetOfArrayElementsOperator<T,I> sort() {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level1SetOfArrayElementsOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }



    public Level1SetOfListElementsOperator<T,I> toList() {
        return new Level1SetOfListElementsOperatorImpl<T,I>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public Level1SetOfMapElementsOperator<T, T,I> toMap() {
        return new Level1SetOfMapElementsOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }


    public <K> Level1SetOfMapElementsOperator<K, T,I> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1SetOfMapElementsOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1SetOfMapElementsOperator<K, V,I> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1SetOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level1SetOfSetElementsOperator<T,I> toSet() {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new ToSet.FromArray<T>()));
    }


    public Set<T[]> get() {
        return endFor().get();
    }

    
    
    
    
	public <X> Level1SetOfArrayElementsOperator<X,I> asArrayOf(final Type<X> type) {
    	return endFor().generic().asSetOfArrayOf(type).forEach();
    }


    public Level1SetOfArrayElementsOperator<?,I> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level1SetOfArrayElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level1SetOfArrayElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level1SetOfArrayElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1SetOfArrayElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T,I> ifNull() {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1SetOfArrayElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


	public <X> Level1SetOfArrayElementsOperator<X,I> convert(final IConverter<X[], ? super T[]> converter) {
        return new Level1SetOfArrayElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.ARRAY));
    }


	public <X> Level1SetOfArrayElementsOperator<X,I> eval(final IEvaluator<X[], ? super T[]> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.ARRAY));
    }


	public <X> Level1SetOfArrayElementsOperator<X,I> exec(final IFunction<X[], ? super T[]> function) {
        return new Level1SetOfArrayElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.ARRAY));
    }


    public <X> Level1SetElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super T[]> converter) {
        return new Level1SetElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level1SetElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super T[]> eval) {
        return new Level1SetElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level1SetElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super T[]> function) {
        return new Level1SetElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1SetOfArrayElementsOperator<T,I> replaceWith(final T[] replacement) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1SetOfArrayElementsOperator<T,I> replaceIfNullWith(final T[] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Set<T[]>, I> createOperation() {
        return endFor().createOperation();
    }



    
    
    
}

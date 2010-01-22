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
package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

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
import org.op4j.operators.impl.list.Level1ListElementsOperatorImpl;
import org.op4j.operators.impl.listoflist.Level1ListOfListElementsOperatorImpl;
import org.op4j.operators.impl.listofmap.Level1ListOfMapElementsOperatorImpl;
import org.op4j.operators.impl.listofset.Level1ListOfSetElementsOperatorImpl;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
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
public class Level1ListOfArrayElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level1ListOfArrayElementsOperator<T,I>  {

    
    public Level1ListOfArrayElementsOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArrayElementsOperator<T,I> add(final T newElement) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }

    public Level1ListOfArrayElementsOperator<T,I> addAll(final T... newElements) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArrayElementsOperator<T,I> insert(final int position, final T newElement) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }

    public Level1ListOfArrayElementsOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfArrayElementsOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1ListOfArrayElementsOperator<T,I> distinct() {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level0ListOfArrayOperator<T,I> endFor() {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level2ListOfArrayElementsElementsOperator<T,I> forEach(final Type<T> elementType) {
        return new Level2ListOfArrayElementsElementsOperatorImpl<T,I>(elementType, getTarget().iterate());
    }


    public Level1ListOfArrayElementsOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ListOfArrayElementsOperator<T,I> removeAllEqual(final T... values) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfArrayElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level1ListOfArrayElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level1ListOfArrayElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level1ListOfArrayElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfArrayElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfArrayElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfArrayElementsOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indices)));
    }



    public Level1ListOfArrayElementsOperator<T,I> removeAllNull() {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public Level1ListOfArrayElementsOperator<T,I> sort() {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level1ListOfArrayElementsOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfListElementsOperator<T,I> toList() {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public Level1ListOfMapElementsOperator<T, T,I> toMap() {
        return new Level1ListOfMapElementsOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> Level1ListOfMapElementsOperator<K, T,I> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1ListOfMapElementsOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1ListOfMapElementsOperator<K, V,I> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ListOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level1ListOfSetElementsOperator<T,I> toSet() {
        return new Level1ListOfSetElementsOperatorImpl<T,I>(getTarget().execute(new ToSet.FromArray<T>()));
    }


    public List<T[]> get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
    
	public <X> Level1ListOfArrayElementsOperator<X,I> asArrayOf(final Type<X> type) {
    	return endFor().generic().asListOfArrayOf(type).forEach();
    }


    public Level1ListOfArrayElementsOperator<?,I> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level1ListOfArrayElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level1ListOfArrayElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfArrayElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1ListOfArrayElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T,I> ifNull() {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1ListOfArrayElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


	public <X> Level1ListOfArrayElementsOperator<X,I> convert(final IConverter<X[], ? super T[]> converter) {
        return new Level1ListOfArrayElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.ARRAY));
    }


	public <X> Level1ListOfArrayElementsOperator<X,I> eval(final IEvaluator<X[], ? super T[]> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.ARRAY));
    }


	public <X> Level1ListOfArrayElementsOperator<X,I> exec(final IFunction<X[], ? super T[]> function) {
        return new Level1ListOfArrayElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.ARRAY));
    }


    public <X> Level1ListElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super T[]> converter) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level1ListElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super T[]> eval) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level1ListElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super T[]> function) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1ListOfArrayElementsOperator<T,I> replaceWith(final T[] replacement) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1ListOfArrayElementsOperator<T,I> replaceIfNullWith(final T[] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<List<T[]>, I> createOperation() {
        return endFor().createOperation();
    }



}

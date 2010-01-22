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
package org.op4j.operators.impl.arrayofarray;

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
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level1ArrayElementsOperatorImpl;
import org.op4j.operators.impl.arrayoflist.Level1ArrayOfListElementsOperatorImpl;
import org.op4j.operators.impl.arrayofmap.Level1ArrayOfMapElementsOperatorImpl;
import org.op4j.operators.impl.arrayofset.Level1ArrayOfSetElementsOperatorImpl;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
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
public class Level1ArrayOfArrayElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level1ArrayOfArrayElementsOperator<T,I> {
    
    private final Type<? extends T[]> type; 

    
    public Level1ArrayOfArrayElementsOperatorImpl(final Type<? extends T[]> type, final Target target) {
        super(target);
        this.type = type;
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArrayElementsOperator<T,I> add(final T newElement) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }

    public Level1ArrayOfArrayElementsOperator<T,I> addAll(final T... newElements) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArrayElementsOperator<T,I> insert(final int position, final T newElement) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }

    public Level1ArrayOfArrayElementsOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfArrayElementsOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1ArrayOfArrayElementsOperator<T,I> distinct() {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


	public Level0ArrayOfArrayOperator<T,I> endFor() {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public Level2ArrayOfArrayElementsElementsOperator<T,I> forEach(final Type<T> elementType) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<T,I>(elementType, getTarget().iterate());
    }


    public Level1ArrayOfArrayElementsOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ArrayOfArrayElementsOperator<T,I> removeAllEqual(final T... values) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ArrayOfArrayElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level1ArrayOfArrayElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level1ArrayOfArrayElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level1ArrayOfArrayElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ArrayOfArrayElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ArrayOfArrayElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ArrayOfArrayElementsOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indices)));
    }



    public Level1ArrayOfArrayElementsOperator<T,I> removeAllNull() {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArrayElementsOperator<T,I> sort() {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ArrayOfArrayElementsOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfListElementsOperator<T,I> toList() {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public Level1ArrayOfMapElementsOperator<T, T,I> toMap() {
        return new Level1ArrayOfMapElementsOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> Level1ArrayOfMapElementsOperator<K, T,I> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1ArrayOfMapElementsOperator<K, V,I> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level1ArrayOfSetElementsOperator<T,I> toSet() {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new ToSet.FromArray<T>()));
    }


    public T[][] get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> Level1ArrayOfArrayElementsOperator<X,I> asArrayOf(final Type<X> elementType) {
        return endFor().asArrayOfArrayOf(elementType).forEach(Types.arrayOf(elementType));
    }


    public Level1ArrayOfArrayElementsOperator<?,I> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndex(indices));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectMatching(eval));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNull());
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> ifNull() {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNull());
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


	public <X> Level1ArrayOfArrayElementsOperator<X,I> convert(final IConverter<X[], ? super T[]> converter) {
        return new Level1ArrayOfArrayElementsOperatorImpl<X,I>(converter.getResultType(this.type), getTarget().execute(converter, Normalization.ARRAY));
    }


	public <X> Level1ArrayOfArrayElementsOperator<X,I> eval(final IEvaluator<X[], ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<X,I>(eval.getResultType(this.type), getTarget().execute(eval, Normalization.ARRAY));
    }


	public <X> Level1ArrayOfArrayElementsOperator<X,I> exec(final IFunction<X[], ? super T[]> function) {
        return new Level1ArrayOfArrayElementsOperatorImpl<X,I>(function.getResultType(this.type), getTarget().execute(function, Normalization.ARRAY));
    }


    public <X> Level1ArrayElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super T[]> converter) {
        return new Level1ArrayElementsOperatorImpl<X,I>(resultType, getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level1ArrayElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super T[]> eval) {
        return new Level1ArrayElementsOperatorImpl<X,I>(resultType, getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level1ArrayElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super T[]> function) {
        return new Level1ArrayElementsOperatorImpl<X,I>(resultType, getTarget().execute(function, Normalization.NONE));
    }


    public Level1ArrayOfArrayElementsOperator<T,I> replaceWith(final T[] replacement) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level1ArrayOfArrayElementsOperator<T,I> replaceIfNullWith(final T[] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<T[][], I> createOperation() {
        return endFor().createOperation();
    }



    
    
}

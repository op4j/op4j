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
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayOfArrayElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1ArrayOfArrayElementsOperator<T> {
    
    private final Type<T> type; 

    
    public Level1ArrayOfArrayElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArrayElementsOperator<T> add(final T newElement) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }

    public Level1ArrayOfArrayElementsOperator<T> addAll(final T... newElements) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArrayElementsOperator<T> insert(final int position, final T newElement) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }

    public Level1ArrayOfArrayElementsOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfArrayElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1ArrayOfArrayElementsOperator<T> distinct() {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


	public Level0ArrayOfArrayOperator<T> endFor() {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().endIterate(Types.arrayOf(this.type).getRawClass()));
    }


    public Level2ArrayOfArrayElementsElementsOperator<T> forEach() {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<T>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level1ArrayOfArrayElementsOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1ArrayOfArrayElementsOperator<T> removeAllEqual(final T... values) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ArrayOfArrayElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level1ArrayOfArrayElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level1ArrayOfArrayElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level1ArrayOfArrayElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ArrayOfArrayElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ArrayOfArrayElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ArrayOfArrayElementsOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indexes)));
    }



    public Level1ArrayOfArrayElementsOperator<T> removeAllNull() {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArrayElementsOperator<T> sort() {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ArrayOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfListElementsOperator<T> toList() {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public Level1ArrayOfMapElementsOperator<T, T> toMap() {
        return new Level1ArrayOfMapElementsOperatorImpl<T, T>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> Level1ArrayOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, T>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1ArrayOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level1ArrayOfSetElementsOperator<T> toSet() {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new ToSet.FromArray<T>()));
    }


    public T[][] get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> Level1ArrayOfArrayElementsOperator<X> asArrayOf(final Type<X> elementType) {
        return endFor().asArrayOfArrayOf(elementType).forEach();
    }


    public Level1ArrayOfArrayElementsOperator<?> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> ifNotNull() {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> ifNull() {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


	public Level1ArrayOfArrayElementsOperator<T> convertAsArray(final IConverter<? extends T[], ? super T[]> converter) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.ARRAY(this.type.getRawClass())));
    }


	public Level1ArrayOfArrayElementsOperator<T> evalAsArray(final IEvaluator<? extends T[], ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.ARRAY(this.type.getRawClass())));
    }


	public Level1ArrayOfArrayElementsOperator<T> execAsArray(final IFunction<? extends T[], ? super T[]> function) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public <X> Level1ArrayOfArrayElementsOperator<X> convertAsArrayOf(final Type<X> newType, final IConverter<X[], ? super T[]> converter) {
        return new Level1ArrayOfArrayElementsOperatorImpl<X>(newType, getTarget().execute(converter, Normalisation.ARRAY(newType.getRawClass())));
    }


    public <X> Level1ArrayOfArrayElementsOperator<X> evalAsArrayOf(final Type<X> newType, final IEvaluator<X[], ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsOperatorImpl<X>(newType, getTarget().execute(eval, Normalisation.ARRAY(newType.getRawClass())));
    }


    public <X> Level1ArrayOfArrayElementsOperator<X> execAsArrayOf(final Type<X> newType, final IFunction<X[], ? super T[]> function) {
        return new Level1ArrayOfArrayElementsOperatorImpl<X>(newType, getTarget().execute(function, Normalisation.ARRAY(newType.getRawClass())));
    }


    public <X> Level1ArrayElementsOperator<X> convert(final Type<X> resultType, final IConverter<X, ? super T[]> converter) {
        return new Level1ArrayElementsOperatorImpl<X>(resultType, getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level1ArrayElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<X, ? super T[]> eval) {
        return new Level1ArrayElementsOperatorImpl<X>(resultType, getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level1ArrayElementsOperator<X> exec(final Type<X> resultType, final IFunction<X, ? super T[]> function) {
        return new Level1ArrayElementsOperatorImpl<X>(resultType, getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ArrayOfArrayElementsOperator<T> replaceWith(final T[] replacement) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().replaceWith(replacement));
    }


    public Level1ArrayOfArrayElementsOperator<T> replaceIfNullWith(final T[] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    



    
    
}

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
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level1SetOfArrayElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1SetOfArrayElementsOperator<T>  {

    private final Type<T> type;

    
    public Level1SetOfArrayElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArrayElementsOperator<T> add(final T newElement) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }

    public Level1SetOfArrayElementsOperator<T> addAll(final T... newElements) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArrayElementsOperator<T> insert(final int position, final T newElement) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }

    public Level1SetOfArrayElementsOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfArrayElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1SetOfArrayElementsOperator<T> distinct() {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level0SetOfArrayOperator<T> endFor() {
        return new Level0SetOfArrayOperatorImpl<T>(this.type, getTarget().endIterate(null));
    }


    public Level2SetOfArrayElementsElementsOperator<T> forEach() {
        return new Level2SetOfArrayElementsElementsOperatorImpl<T>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level1SetOfArrayElementsOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1SetOfArrayElementsOperator<T> removeAllEqual(final T... values) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfArrayElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level1SetOfArrayElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level1SetOfArrayElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level1SetOfArrayElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfArrayElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfArrayElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfArrayElementsOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indexes)));
    }



    public Level1SetOfArrayElementsOperator<T> removeAllNull() {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public Level1SetOfArrayElementsOperator<T> sort() {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level1SetOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }



    public Level1SetOfListElementsOperator<T> toList() {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public Level1SetOfMapElementsOperator<T, T> toMap() {
        return new Level1SetOfMapElementsOperatorImpl<T, T>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }


    public <K> Level1SetOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1SetOfMapElementsOperatorImpl<K, T>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1SetOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level1SetOfSetElementsOperator<T> toSet() {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new ToSet.FromArray<T>()));
    }


    public Set<T[]> get() {
        return endFor().get();
    }

    
    
    
    
	public <X> Level1SetOfArrayElementsOperator<X> asArrayOf(final Type<X> newType) {
    	return endFor().generic().asSetOfArrayOf(newType).forEach();
    }


    public Level1SetOfArrayElementsOperator<?> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifNotNull() {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifNull() {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


	public Level1SetOfArrayElementsOperator<T> convertAsArray(final IConverter<? extends T[], ? super T[]> converter) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.ARRAY(this.type.getRawClass())));
    }


	public Level1SetOfArrayElementsOperator<T> evalAsArray(final IEvaluator<? extends T[], ? super T[]> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.ARRAY(this.type.getRawClass())));
    }


	public Level1SetOfArrayElementsOperator<T> execAsArray(final IFunction<? extends T[], ? super T[]> function) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public <X> Level1SetOfArrayElementsOperator<X> convertAsArrayOf(final Type<X> newType, final IConverter<X[], ? super T[]> converter) {
        return new Level1SetOfArrayElementsOperatorImpl<X>(newType, getTarget().execute(converter, Normalisation.ARRAY(newType.getRawClass())));
    }


    public <X> Level1SetOfArrayElementsOperator<X> evalAsArrayOf(final Type<X> newType, final IEvaluator<X[], ? super T[]> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<X>(newType, getTarget().execute(eval, Normalisation.ARRAY(newType.getRawClass())));
    }


    public <X> Level1SetOfArrayElementsOperator<X> execAsArrayOf(final Type<X> newType, final IFunction<X[], ? super T[]> function) {
        return new Level1SetOfArrayElementsOperatorImpl<X>(newType, getTarget().execute(function, Normalisation.ARRAY(newType.getRawClass())));
    }


    public <X> Level1SetElementsOperator<X> convert(final IConverter<X, ? super T[]> converter) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level1SetElementsOperator<X> eval(final IEvaluator<X, ? super T[]> eval) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level1SetElementsOperator<X> exec(final IFunction<X, ? super T[]> function) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetOfArrayElementsOperator<T> replaceWith(final T[] replacement) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level1SetOfArrayElementsOperator<T> replaceIfNullWith(final T[] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }



    
    public <X> Level1SetOfArrayElementsOperator<X> map(final Type<X> newType, final IFunction<X, ? super T> function) {
        return new Level1SetOfArrayElementsOperatorImpl<X>(newType, getTarget().map(Structure.ARRAY, function, newType.getRawClass()));
    }


    public Level1SetOfArrayElementsOperator<T> map(final IFunction<? extends T, ? super T> function) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }
    



    
    
    
}

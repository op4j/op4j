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
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.mapbuild.IMapBuilder;
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
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level1ListOfArrayElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1ListOfArrayElementsOperator<T>  {

    private final Type<T> type;

    
    public Level1ListOfArrayElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArrayElementsOperator<T> add(final T newElement) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }

    public Level1ListOfArrayElementsOperator<T> addAll(final T... newElements) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArrayElementsOperator<T> insert(final int position, final T newElement) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }

    public Level1ListOfArrayElementsOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfArrayElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1ListOfArrayElementsOperator<T> distinct() {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level0ListOfArrayOperator<T> endFor() {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().endIterate(null));
    }


    public Level2ListOfArrayElementsElementsOperator<T> forEach() {
        return new Level2ListOfArrayElementsElementsOperatorImpl<T>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level1ListOfArrayElementsOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1ListOfArrayElementsOperator<T> removeAllEqual(final T... values) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfArrayElementsOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level1ListOfArrayElementsOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level1ListOfArrayElementsOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level1ListOfArrayElementsOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfArrayElementsOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfArrayElementsOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfArrayElementsOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indexes)));
    }



    public Level1ListOfArrayElementsOperator<T> removeAllNull() {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public Level1ListOfArrayElementsOperator<T> sort() {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level1ListOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfListElementsOperator<T> toList() {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public Level1ListOfMapElementsOperator<T, T> toMap() {
        return new Level1ListOfMapElementsOperatorImpl<T, T>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> Level1ListOfMapElementsOperator<K, T> toMap(final IFunction<K, ? super T> keyEval) {
        return new Level1ListOfMapElementsOperatorImpl<K, T>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1ListOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level1ListOfSetElementsOperator<T> toSet() {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new ToSet.FromArray<T>()));
    }


    public List<T[]> get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
    
	public <X> Level1ListOfArrayElementsOperator<X> asArrayOf(final Type<X> newType) {
    	return endFor().generic().asListOfArrayOf(newType).forEach();
    }


    public Level1ListOfArrayElementsOperator<?> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifNotNull() {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifNull() {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


	public Level1ListOfArrayElementsOperator<T> execIfNotNullAsArray(final IFunction<? extends T[], ? super T[]> function) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().executeIfNotNull(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


	public Level1ListOfArrayElementsOperator<T> execAsArray(final IFunction<? extends T[], ? super T[]> function) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public <X> Level1ListOfArrayElementsOperator<X> execIfNotNullAsArrayOf(final Type<X> newType, final IFunction<X[], ? super T[]> function) {
        return new Level1ListOfArrayElementsOperatorImpl<X>(newType, getTarget().executeIfNotNull(function, Normalisation.ARRAY(newType.getRawClass())));
    }


    public <X> Level1ListOfArrayElementsOperator<X> execAsArrayOf(final Type<X> newType, final IFunction<X[], ? super T[]> function) {
        return new Level1ListOfArrayElementsOperatorImpl<X>(newType, getTarget().execute(function, Normalisation.ARRAY(newType.getRawClass())));
    }


    public <X> Level1ListElementsOperator<X> execIfNotNull(final IFunction<X, ? super T[]> function) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level1ListElementsOperator<X> exec(final IFunction<X, ? super T[]> function) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ListOfArrayElementsOperator<T> replaceWith(final T[] replacement) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level1ListOfArrayElementsOperator<T> replaceIfNullWith(final T[] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }




    
    public <X> Level1ListOfArrayElementsOperator<X> map(final Type<X> newType, final IFunction<X, ? super T> function) {
        return new Level1ListOfArrayElementsOperatorImpl<X>(newType, getTarget().map(Structure.ARRAY, function, newType.getRawClass()));
    }


    public Level1ListOfArrayElementsOperator<T> map(final IFunction<? extends T, ? super T> function) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }

    



}

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
import org.op4j.operators.impl.setoflist.Level1SetOfListElementsOperatorImpl;
import org.op4j.operators.impl.setofmap.Level1SetOfMapElementsOperatorImpl;
import org.op4j.operators.impl.setofset.Level1SetOfSetElementsOperatorImpl;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArrayElementsElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1SetOfArrayElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1SetOfArrayElementsOperator<T>  {

    
    public Level1SetOfArrayElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfArrayElementsOperator<T> add(final T... newElements) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1SetOfArrayElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfArrayElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1SetOfArrayElementsOperator<T> distinct() {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level0SetOfArrayOperator<T> endFor() {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().endIterate(Structure.SET, null));
    }


    public Level2SetOfArrayElementsElementsOperator<T> forEach(final Type<T> elementType) {
        return new Level2SetOfArrayElementsElementsOperatorImpl<T>(elementType, getTarget().iterate());
    }


    public Level1SetOfArrayElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1SetOfArrayElementsOperator<T> removeEquals(final T... values) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public Level1SetOfArrayElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }

    public Level1SetOfArrayElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<T>(eval)));
    }

    public Level1SetOfArrayElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<T>(eval)));
    }

    public Level1SetOfArrayElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1SetOfArrayElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1SetOfArrayElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1SetOfArrayElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }



    public Level1SetOfArrayElementsOperator<T> removeNulls() {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public Level1SetOfArrayElementsOperator<T> sort() {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level1SetOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
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

    
    
    
    
	public <X> Level1SetOfArrayElementsOperator<X> asArrayOf(final Type<X> type) {
    	return endFor().generic().asSetOfArrayOf(type).forEach();
    }


    public Level1SetOfArrayElementsOperator<?> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifNotNull() {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifNull() {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


	public <X> Level1SetOfArrayElementsOperator<X> convert(final IConverter<X[], ? super T[]> converter) {
        return new Level1SetOfArrayElementsOperatorImpl<X>(getTarget().execute(converter));
    }


	public <X> Level1SetOfArrayElementsOperator<X> eval(final IEvaluator<X[], ? super T[]> eval) {
        return new Level1SetOfArrayElementsOperatorImpl<X>(getTarget().execute(eval));
    }


	public <X> Level1SetOfArrayElementsOperator<X> exec(final IFunction<X[], ? super T[]> function) {
        return new Level1SetOfArrayElementsOperatorImpl<X>(getTarget().execute(function));
    }



    
    
    
}

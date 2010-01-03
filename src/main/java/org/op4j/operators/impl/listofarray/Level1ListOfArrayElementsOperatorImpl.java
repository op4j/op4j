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
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListOfArrayElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1ListOfArrayElementsOperator<T>  {
    
    private final Type<? super T> arrayOf; 

    
    public Level1ListOfArrayElementsOperatorImpl(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public Level1ListOfArrayElementsOperator<T> add(final T... newElements) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1ListOfArrayElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfArrayElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1ListOfArrayElementsOperator<T> distinct() {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level0ListOfArrayOperator<T> endFor() {
        return new Level0ListOfArrayOperatorImpl<T>(this.arrayOf, getTarget().endIterate(Structure.LIST, null));
    }


    public Level2ListOfArrayElementsElementsOperator<T> forEach() {
        return new Level2ListOfArrayElementsElementsOperatorImpl<T>(this.arrayOf, getTarget().iterate());
    }


    public Level1ListOfArrayElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ListOfArrayElementsOperator<T> removeEquals(final T... values) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public Level1ListOfArrayElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }

    public Level1ListOfArrayElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotMatching<T>(eval)));
    }

    public Level1ListOfArrayElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<T>(eval)));
    }

    public Level1ListOfArrayElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ListOfArrayElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ListOfArrayElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ListOfArrayElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }



    public Level1ListOfArrayElementsOperator<T> removeNulls() {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public Level1ListOfArrayElementsOperator<T> sort() {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level1ListOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfListElementsOperator<T> toList() {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public Level1ListOfMapElementsOperator<T, T> toMap() {
        return new Level1ListOfMapElementsOperatorImpl<T, T>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> Level1ListOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
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

    
    
    
    
    
    
    
    
    
    
    
	public <X> Level1ListElementsOperator<X> convert(final IConverter<X, ? super T[]> converter) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(converter));
	}


    public <X> Level1ListElementsOperator<X> eval(final IEvaluator<X, ? super T[]> eval) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level1ListElementsOperator<X> exec(final IFunction<X, ? super T[]> function) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(function));
	}

    

    public <X> Level1ListOfArrayElementsOperator<X> asArrayOf(final Type<X> type) {
    	return endFor().generic().asListOfArrayOf(type).forEach();
    }


    public Level1ListOfArrayElementsOperator<?> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifNotNull() {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifNull() {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNull());
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }
    
    

}

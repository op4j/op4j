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
package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.set.Level1SetElementsOperatorImpl;
import org.op4j.operators.impl.setofarray.Level1SetOfArrayElementsOperatorImpl;
import org.op4j.operators.impl.setofmap.Level1SetOfMapElementsOperatorImpl;
import org.op4j.operators.impl.setofset.Level1SetOfSetElementsOperatorImpl;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsSelectedOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsElementsOperator;
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
public class Level1SetOfListElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1SetOfListElementsOperator<T>  {

    
    public Level1SetOfListElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfListElementsOperator<T> add(final T... newElements) {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1SetOfListElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfListElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level1SetOfListElementsOperator<T> distinct() {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level0SetOfListOperator<T> endFor() {
        return new Level0SetOfListOperatorImpl<T>(getTarget().endIterate(Structure.SET, null));
    }


    public Level2SetOfListElementsElementsOperator<T> forEach() {
        return new Level2SetOfListElementsElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1SetOfListElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1SetOfListElementsOperator<T> removeEquals(final T... values) {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public Level1SetOfListElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }

    public Level1SetOfListElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<T>(eval)));
    }

    public Level1SetOfListElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<T>(eval)));
    }

    public Level1SetOfListElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1SetOfListElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1SetOfListElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1SetOfListElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1SetOfListElementsOperator<T> removeNulls() {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level1SetOfListElementsOperator<T> sort() {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1SetOfListElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfArrayElementsOperator<T> toArray(final Type<T> of) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public Level1SetOfMapElementsOperator<T, T> toMap() {
        return new Level1SetOfMapElementsOperatorImpl<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }


    public <K> Level1SetOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1SetOfMapElementsOperatorImpl<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1SetOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level1SetOfSetElementsOperator<T> toSet() {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    public Set<List<T>> get() {
        return endFor().get();
    }

    
    
    
    
    
	public <X> Level1SetElementsOperator<X> convert(final IConverter<X, ? super List<T>> converter) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(converter));
	}


    public <X> Level1SetElementsOperator<X> eval(final IEvaluator<X, ? super List<T>> eval) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level1SetElementsOperator<X> exec(final IFunction<X, ? super List<T>> function) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(function));
	}

    

    public <X> Level1SetOfListElementsOperator<X> asListOf(final Type<X> type) {
    	return endFor().generic().asSetOfListOf(type).forEach();
    }


    public Level1SetOfListElementsOperator<?> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level1SetOfListElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1SetOfListElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1SetOfListElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1SetOfListElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfListElementsSelectedOperator<T> ifNotNull() {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1SetOfListElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetOfListElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfListElementsSelectedOperator<T> ifNull() {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1SetOfListElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfListElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }
    
    
    
}
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
package org.op4j.operators.impl.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

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
import org.op4j.operators.impl.array.Level1ArrayElementsOperatorImpl;
import org.op4j.operators.impl.arrayofarray.Level1ArrayOfArrayElementsOperatorImpl;
import org.op4j.operators.impl.arrayofmap.Level1ArrayOfMapElementsOperatorImpl;
import org.op4j.operators.impl.arrayofset.Level1ArrayOfSetElementsOperatorImpl;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayOfListElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1ArrayOfListElementsOperator<T>  {

    
    public Level1ArrayOfListElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfListElementsOperator<T> add(final T... newElements) {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1ArrayOfListElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfListElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level1ArrayOfListElementsOperator<T> distinct() {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level0ArrayOfListOperator<T> endFor() {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().endIterate(Structure.ARRAY, List.class));
    }


    public Level2ArrayOfListElementsElementsOperator<T> forEach() {
        return new Level2ArrayOfListElementsElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1ArrayOfListElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ArrayOfListElementsOperator<T> removeEquals(final T... values) {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public Level1ArrayOfListElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }

    public Level1ArrayOfListElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<T>(eval)));
    }

    public Level1ArrayOfListElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<T>(eval)));
    }

    public Level1ArrayOfListElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ArrayOfListElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ArrayOfListElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ArrayOfListElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1ArrayOfListElementsOperator<T> removeNulls() {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level1ArrayOfListElementsOperator<T> sort() {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1ArrayOfListElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfArrayElementsOperator<T> toArray(final Type<T> of) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(Types.arrayOf(of), getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public Level1ArrayOfMapElementsOperator<T, T> toMap() {
        return new Level1ArrayOfMapElementsOperatorImpl<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }

    
    public <K> Level1ArrayOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1ArrayOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level1ArrayOfSetElementsOperator<T> toSet() {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    public List<T>[] get() {
        return endFor().get();
    }


    
    
    
    
    
    
	public <X> Level1ArrayOfListElementsOperator<X> asListOf(final Type<X> type) {
        return endFor().asArrayOfListOf(type).forEach();
    }


    public Level1ArrayOfListElementsOperator<?> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level1ArrayOfListElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> ifNotNull() {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ArrayOfListElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> ifNull() {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ArrayOfListElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1ArrayOfListElementsOperator<X> convert(final IConverter<? extends List<X>, ? super List<T>> converter) {
        return new Level1ArrayOfListElementsOperatorImpl<X>(getTarget().execute(converter));
    }


    public <X> Level1ArrayOfListElementsOperator<X> eval(final IEvaluator<? extends List<X>, ? super List<T>> eval) {
        return new Level1ArrayOfListElementsOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level1ArrayOfListElementsOperator<X> exec(final IFunction<? extends List<X>, ? super List<T>> function) {
        return new Level1ArrayOfListElementsOperatorImpl<X>(getTarget().execute(function));
    }


    public <X> Level1ArrayElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super List<T>> converter) {
        return new Level1ArrayElementsOperatorImpl<X>(resultType, getTarget().execute(converter));
    }


    public <X> Level1ArrayElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super List<T>> eval) {
        return new Level1ArrayElementsOperatorImpl<X>(resultType, getTarget().execute(eval));
    }


    public <X> Level1ArrayElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<T>> function) {
        return new Level1ArrayElementsOperatorImpl<X>(resultType, getTarget().execute(function));
    }
    
    
    
    
}

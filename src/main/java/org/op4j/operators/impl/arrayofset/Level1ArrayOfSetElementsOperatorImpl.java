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
package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.arrayofarray.Level1ArrayOfArrayElementsOperatorImpl;
import org.op4j.operators.impl.arrayoflist.Level1ArrayOfListElementsOperatorImpl;
import org.op4j.operators.impl.arrayofmap.Level1ArrayOfMapElementsOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayOfSetElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1ArrayOfSetElementsOperator<T>  {

    
    public Level1ArrayOfSetElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfSetElementsOperator<T> add(final T... newElements) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1ArrayOfSetElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfSetElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public Level0ArrayOfSetOperator<T> endFor() {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().endIterate(Structure.ARRAY, Set.class));
    }


    public Level2ArrayOfSetElementsElementsOperator<T> forEach() {
        return new Level2ArrayOfSetElementsElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1ArrayOfSetElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ArrayOfSetElementsOperator<T> removeEquals(final T... values) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveEquals<T>(values)));
    }


    public Level1ArrayOfSetElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveMatching<T>(eval)));
    }

    public Level1ArrayOfSetElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotMatching<T>(eval)));
    }

    public Level1ArrayOfSetElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<T>(eval)));
    }

    public Level1ArrayOfSetElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ArrayOfSetElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ArrayOfSetElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ArrayOfSetElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1ArrayOfSetElementsOperator<T> removeNulls() {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetElementsOperator<T> sort() {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ArrayOfSetElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfArrayElementsOperator<T> toArray(final Type<T> of) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(Types.arrayOf(of), getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public Level1ArrayOfListElementsOperator<T> toList() {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public Level1ArrayOfMapElementsOperator<T, T> toMap() {
        return new Level1ArrayOfMapElementsOperatorImpl<T, T>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }

    
    public <K> Level1ArrayOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, T>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1ArrayOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    public Set<T>[] get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
	public <X> Level1ArrayOfSetElementsOperator<X> asSetOf(final Type<X> type) {
        return endFor().generic().asArrayOfSetOf(type).forEach();
    }


    public Level1ArrayOfSetElementsOperator<?> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifNotNull() {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifNull() {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1ArrayOfSetElementsOperator<X> convert(final IConverter<? extends Set<X>, ? super Set<T>> converter) {
        return new Level1ArrayOfSetElementsOperatorImpl<X>(getTarget().execute(converter));
    }


    public <X> Level1ArrayOfSetElementsOperator<X> eval(final IEvaluator<? extends Set<X>, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level1ArrayOfSetElementsOperator<X> exec(final IFunction<? extends Set<X>, ? super Set<T>> function) {
        return new Level1ArrayOfSetElementsOperatorImpl<X>(getTarget().execute(function));
    }
    
    
    

}

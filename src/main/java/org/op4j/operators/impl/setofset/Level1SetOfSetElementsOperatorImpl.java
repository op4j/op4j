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
package org.op4j.operators.impl.setofset;

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
import org.op4j.operators.impl.set.Level1SetElementsOperatorImpl;
import org.op4j.operators.impl.setofarray.Level1SetOfArrayElementsOperatorImpl;
import org.op4j.operators.impl.setoflist.Level1SetOfListElementsOperatorImpl;
import org.op4j.operators.impl.setofmap.Level1SetOfMapElementsOperatorImpl;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsElementsOperator;
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
public class Level1SetOfSetElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1SetOfSetElementsOperator<T>  {

    
    public Level1SetOfSetElementsOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetElementsOperator<T> add(final T newElement) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }

    public Level1SetOfSetElementsOperator<T> addAll(final T... newElements) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetElementsOperator<T> insert(final int position, final T newElement) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }

    public Level1SetOfSetElementsOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfSetElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public Level0SetOfSetOperator<T> endFor() {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().endIterate(null));
    }


    public Level2SetOfSetElementsElementsOperator<T> forEach() {
        return new Level2SetOfSetElementsElementsOperatorImpl<T>(getTarget().iterate(Structure.SET));
    }


    public Level1SetOfSetElementsOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1SetOfSetElementsOperator<T> removeAllEqual(final T... values) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfSetElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level1SetOfSetElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level1SetOfSetElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level1SetOfSetElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfSetElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfSetElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfSetElementsOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1SetOfSetElementsOperator<T> removeAllNull() {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level1SetOfSetElementsOperator<T> sort() {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1SetOfSetElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfArrayElementsOperator<T> toArrayOf(final Type<T> type) {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().execute(new ToArray.FromCollection<T>(type)));
    }


    public Level1SetOfListElementsOperator<T> toList() {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public Level1SetOfMapElementsOperator<T, T> toMap() {
        return new Level1SetOfMapElementsOperatorImpl<T, T>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }


    public <K> Level1SetOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1SetOfMapElementsOperatorImpl<K, T>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1SetOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    public Set<Set<T>> get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
	public <X> Level1SetOfSetElementsOperator<X> asSetOf(final Type<X> type) {
    	return endFor().generic().asSetOfSetOf(type).forEach();
    }


    public Level1SetOfSetElementsOperator<?> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }


    public Level1SetOfSetElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level1SetOfSetElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level1SetOfSetElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1SetOfSetElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfSetElementsSelectedOperator<T> ifNotNull() {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1SetOfSetElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetOfSetElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfSetElementsSelectedOperator<T> ifNull() {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1SetOfSetElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfSetElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1SetOfSetElementsOperator<X> convertAsSet(final IConverter<? extends Set<X>, ? super Set<T>> converter) {
        return new Level1SetOfSetElementsOperatorImpl<X>(getTarget().execute(converter, Normalisation.SET));
    }


    public <X> Level1SetOfSetElementsOperator<X> evalAsSet(final IEvaluator<? extends Set<X>, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsOperatorImpl<X>(getTarget().execute(eval, Normalisation.SET));
    }


    public <X> Level1SetOfSetElementsOperator<X> execAsSet(final IFunction<? extends Set<X>, ? super Set<T>> function) {
        return new Level1SetOfSetElementsOperatorImpl<X>(getTarget().execute(function, Normalisation.SET));
    }


    public <X> Level1SetElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Set<T>> converter) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level1SetElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Set<T>> eval) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level1SetElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T>> function) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetOfSetElementsOperator<T> replaceWith(final Set<T> replacement) {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level1SetOfSetElementsOperator<T> replaceIfNullWith(final Set<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
    
}

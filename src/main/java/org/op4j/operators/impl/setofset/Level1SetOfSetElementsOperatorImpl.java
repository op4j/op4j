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
import org.op4j.operations.Operation;
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
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1SetOfSetElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level1SetOfSetElementsOperator<T,I>  {

    
    public Level1SetOfSetElementsOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetElementsOperator<T,I> add(final T newElement) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }

    public Level1SetOfSetElementsOperator<T,I> addAll(final T... newElements) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetElementsOperator<T,I> insert(final int position, final T newElement) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }

    public Level1SetOfSetElementsOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfSetElementsOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public Level0SetOfSetOperator<T,I> endFor() {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().endIterate(Structure.SET, null));
    }


    public Level2SetOfSetElementsElementsOperator<T,I> forEach() {
        return new Level2SetOfSetElementsElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level1SetOfSetElementsOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1SetOfSetElementsOperator<T,I> removeAllEqual(final T... values) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfSetElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level1SetOfSetElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level1SetOfSetElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level1SetOfSetElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfSetElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfSetElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfSetElementsOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1SetOfSetElementsOperator<T,I> removeAllNull() {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level1SetOfSetElementsOperator<T,I> sort() {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1SetOfSetElementsOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfArrayElementsOperator<T,I> toArray(final Type<T> of) {
        return new Level1SetOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public Level1SetOfListElementsOperator<T,I> toList() {
        return new Level1SetOfListElementsOperatorImpl<T,I>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public Level1SetOfMapElementsOperator<T, T,I> toMap() {
        return new Level1SetOfMapElementsOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }


    public <K> Level1SetOfMapElementsOperator<K, T,I> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1SetOfMapElementsOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1SetOfMapElementsOperator<K, V,I> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1SetOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    public Set<Set<T>> get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
	public <X> Level1SetOfSetElementsOperator<X,I> asSetOf(final Type<X> type) {
    	return endFor().generic().asSetOfSetOf(type).forEach();
    }


    public Level1SetOfSetElementsOperator<?,I> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }


    public Level1SetOfSetElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level1SetOfSetElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level1SetOfSetElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1SetOfSetElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfSetElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1SetOfSetElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetOfSetElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfSetElementsSelectedOperator<T,I> ifNull() {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1SetOfSetElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfSetElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1SetOfSetElementsOperator<X,I> convert(final IConverter<? extends Set<X>, ? super Set<T>> converter) {
        return new Level1SetOfSetElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.SET));
    }


    public <X> Level1SetOfSetElementsOperator<X,I> eval(final IEvaluator<? extends Set<X>, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.SET));
    }


    public <X> Level1SetOfSetElementsOperator<X,I> exec(final IFunction<? extends Set<X>, ? super Set<T>> function) {
        return new Level1SetOfSetElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.SET));
    }


    public <X> Level1SetElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Set<T>> converter) {
        return new Level1SetElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level1SetElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Set<T>> eval) {
        return new Level1SetElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level1SetElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T>> function) {
        return new Level1SetElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1SetOfSetElementsOperator<T,I> replaceWith(final Set<T> replacement) {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1SetOfSetElementsOperator<T,I> replaceIfNullWith(final Set<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Set<Set<T>>, I> createOperation() {
        return endFor().createOperation();
    }
    
    
    
}

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
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level1ArrayElementsOperatorImpl;
import org.op4j.operators.impl.arrayofarray.Level1ArrayOfArrayElementsOperatorImpl;
import org.op4j.operators.impl.arrayoflist.Level1ArrayOfListElementsOperatorImpl;
import org.op4j.operators.impl.arrayofmap.Level1ArrayOfMapElementsOperatorImpl;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsElementsOperator;
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
public class Level1ArrayOfSetElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level1ArrayOfSetElementsOperator<T,I>  {

    
    public Level1ArrayOfSetElementsOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetElementsOperator<T,I> add(final T newElement) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }

    public Level1ArrayOfSetElementsOperator<T,I> addAll(final T... newElements) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetElementsOperator<T,I> insert(final int position, final T newElement) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }

    public Level1ArrayOfSetElementsOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfSetElementsOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public Level0ArrayOfSetOperator<T,I> endFor() {
        return new Level0ArrayOfSetOperatorImpl<T,I>(getTarget().endIterate(Structure.ARRAY, Set.class));
    }


    public Level2ArrayOfSetElementsElementsOperator<T,I> forEach() {
        return new Level2ArrayOfSetElementsElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level1ArrayOfSetElementsOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ArrayOfSetElementsOperator<T,I> removeAllEqual(final T... values) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ArrayOfSetElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level1ArrayOfSetElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level1ArrayOfSetElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level1ArrayOfSetElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ArrayOfSetElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ArrayOfSetElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ArrayOfSetElementsOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1ArrayOfSetElementsOperator<T,I> removeAllNull() {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetElementsOperator<T,I> sort() {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ArrayOfSetElementsOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfArrayElementsOperator<T,I> toArray(final Type<T> of) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(Types.arrayOf(of), getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public Level1ArrayOfListElementsOperator<T,I> toList() {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public Level1ArrayOfMapElementsOperator<T, T,I> toMap() {
        return new Level1ArrayOfMapElementsOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }

    
    public <K> Level1ArrayOfMapElementsOperator<K, T,I> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1ArrayOfMapElementsOperator<K, V,I> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    public Set<T>[] get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
	public <X> Level1ArrayOfSetElementsOperator<X,I> asSetOf(final Type<X> type) {
        return endFor().generic().asArrayOfSetOf(type).forEach();
    }


    public Level1ArrayOfSetElementsOperator<?,I> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }


    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifNull() {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1ArrayOfSetElementsOperator<X,I> convert(final IConverter<? extends Set<X>, ? super Set<T>> converter) {
        return new Level1ArrayOfSetElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.SET));
    }


    public <X> Level1ArrayOfSetElementsOperator<X,I> eval(final IEvaluator<? extends Set<X>, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.SET));
    }


    public <X> Level1ArrayOfSetElementsOperator<X,I> exec(final IFunction<? extends Set<X>, ? super Set<T>> function) {
        return new Level1ArrayOfSetElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.SET));
    }


    public <X> Level1ArrayElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Set<T>> converter) {
        return new Level1ArrayElementsOperatorImpl<X,I>(resultType, getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level1ArrayElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Set<T>> eval) {
        return new Level1ArrayElementsOperatorImpl<X,I>(resultType, getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level1ArrayElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T>> function) {
        return new Level1ArrayElementsOperatorImpl<X,I>(resultType, getTarget().execute(function, Normalization.NONE));
    }


    public Level1ArrayOfSetElementsOperator<T,I> replaceWith(final Set<T> replacement) {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1ArrayOfSetElementsOperator<T,I> replaceIfNullWith(final Set<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Set<T>[], I> createOperation() {
        return endFor().createOperation();
    }
    
    
    

}

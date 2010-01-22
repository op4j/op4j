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
import org.op4j.operations.Operation;
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
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayOfListElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level1ArrayOfListElementsOperator<T,I>  {

    
    public Level1ArrayOfListElementsOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfListElementsOperator<T,I> add(final T newElement) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }

    public Level1ArrayOfListElementsOperator<T,I> addAll(final T... newElements) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfListElementsOperator<T,I> insert(final int position, final T newElement) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }

    public Level1ArrayOfListElementsOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfListElementsOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level1ArrayOfListElementsOperator<T,I> distinct() {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level0ArrayOfListOperator<T,I> endFor() {
        return new Level0ArrayOfListOperatorImpl<T,I>(getTarget().endIterate(Structure.ARRAY, List.class));
    }


    public Level2ArrayOfListElementsElementsOperator<T,I> forEach() {
        return new Level2ArrayOfListElementsElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level1ArrayOfListElementsOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ArrayOfListElementsOperator<T,I> removeAllEqual(final T... values) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ArrayOfListElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level1ArrayOfListElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level1ArrayOfListElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level1ArrayOfListElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ArrayOfListElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ArrayOfListElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ArrayOfListElementsOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1ArrayOfListElementsOperator<T,I> removeAllNull() {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level1ArrayOfListElementsOperator<T,I> sort() {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1ArrayOfListElementsOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfArrayElementsOperator<T,I> toArray(final Type<T> of) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(Types.arrayOf(of), getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public Level1ArrayOfMapElementsOperator<T, T,I> toMap() {
        return new Level1ArrayOfMapElementsOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }

    
    public <K> Level1ArrayOfMapElementsOperator<K, T,I> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1ArrayOfMapElementsOperator<K, V,I> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level1ArrayOfSetElementsOperator<T,I> toSet() {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    public List<T>[] get() {
        return endFor().get();
    }


    
    
    
    
    
    
	public <X> Level1ArrayOfListElementsOperator<X,I> asListOf(final Type<X> type) {
        return endFor().asArrayOfListOf(type).forEach();
    }


    public Level1ArrayOfListElementsOperator<?,I> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level1ArrayOfListElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level1ArrayOfListElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level1ArrayOfListElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1ArrayOfListElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfListElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1ArrayOfListElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArrayOfListElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfListElementsSelectedOperator<T,I> ifNull() {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1ArrayOfListElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfListElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1ArrayOfListElementsOperator<X,I> convert(final IConverter<? extends List<X>, ? super List<T>> converter) {
        return new Level1ArrayOfListElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.LIST));
    }


    public <X> Level1ArrayOfListElementsOperator<X,I> eval(final IEvaluator<? extends List<X>, ? super List<T>> eval) {
        return new Level1ArrayOfListElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.LIST));
    }


    public <X> Level1ArrayOfListElementsOperator<X,I> exec(final IFunction<? extends List<X>, ? super List<T>> function) {
        return new Level1ArrayOfListElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.LIST));
    }


    public <X> Level1ArrayElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super List<T>> converter) {
        return new Level1ArrayElementsOperatorImpl<X,I>(resultType, getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level1ArrayElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super List<T>> eval) {
        return new Level1ArrayElementsOperatorImpl<X,I>(resultType, getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level1ArrayElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<T>> function) {
        return new Level1ArrayElementsOperatorImpl<X,I>(resultType, getTarget().execute(function, Normalization.NONE));
    }


    public Level1ArrayOfListElementsOperator<T,I> replaceWith(final List<T> replacement) {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1ArrayOfListElementsOperator<T,I> replaceIfNullWith(final List<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<List<T>[], I> createOperation() {
        return endFor().createOperation();
    }
    
    
    
    
}

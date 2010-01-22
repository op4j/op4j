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
package org.op4j.operators.impl.listoflist;

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
import org.op4j.operators.impl.list.Level1ListElementsOperatorImpl;
import org.op4j.operators.impl.listofarray.Level1ListOfArrayElementsOperatorImpl;
import org.op4j.operators.impl.listofmap.Level1ListOfMapElementsOperatorImpl;
import org.op4j.operators.impl.listofset.Level1ListOfSetElementsOperatorImpl;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsSelectedOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
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
public class Level1ListOfListElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level1ListOfListElementsOperator<T,I>  {

    
    public Level1ListOfListElementsOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfListElementsOperator<T,I> add(final T newElement) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }

    public Level1ListOfListElementsOperator<T,I> addAll(final T... newElements) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfListElementsOperator<T,I> insert(final int position, final T newElement) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }

    public Level1ListOfListElementsOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfListElementsOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level1ListOfListElementsOperator<T,I> distinct() {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level0ListOfListOperator<T,I> endFor() {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level2ListOfListElementsElementsOperator<T,I> forEach() {
        return new Level2ListOfListElementsElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level1ListOfListElementsOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ListOfListElementsOperator<T,I> removeAllEqual(final T... values) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfListElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level1ListOfListElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level1ListOfListElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level1ListOfListElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfListElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfListElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfListElementsOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1ListOfListElementsOperator<T,I> removeAllNull() {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level1ListOfListElementsOperator<T,I> sort() {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1ListOfListElementsOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfArrayElementsOperator<T,I> toArray(final Type<T> of) {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public Level1ListOfMapElementsOperator<T, T,I> toMap() {
        return new Level1ListOfMapElementsOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }

    
    public <K> Level1ListOfMapElementsOperator<K, T,I> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1ListOfMapElementsOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1ListOfMapElementsOperator<K, V,I> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ListOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level1ListOfSetElementsOperator<T,I> toSet() {
        return new Level1ListOfSetElementsOperatorImpl<T,I>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    public List<List<T>> get() {
        return endFor().get();
    }


    
    
    
    
    
    
    
	public <X> Level1ListOfListElementsOperator<X,I> asListOf(final Type<X> type) {
    	return endFor().generic().asListOfListOf(type).forEach();
    }


    public Level1ListOfListElementsOperator<?,I> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level1ListOfListElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level1ListOfListElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfListElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1ListOfListElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfListElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1ListOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1ListOfListElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListOfListElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfListElementsSelectedOperator<T,I> ifNull() {
        return new Level1ListOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1ListOfListElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfListElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1ListOfListElementsOperator<X,I> convert(final IConverter<? extends List<X>, ? super List<T>> converter) {
        return new Level1ListOfListElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.LIST));
    }


    public <X> Level1ListOfListElementsOperator<X,I> eval(final IEvaluator<? extends List<X>, ? super List<T>> eval) {
        return new Level1ListOfListElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.LIST));
    }


    public <X> Level1ListOfListElementsOperator<X,I> exec(final IFunction<? extends List<X>, ? super List<T>> function) {
        return new Level1ListOfListElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.LIST));
    }


    public <X> Level1ListElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super List<T>> converter) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level1ListElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super List<T>> eval) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level1ListElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<T>> function) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1ListOfListElementsOperator<T,I> replaceWith(final List<T> replacement) {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1ListOfListElementsOperator<T,I> replaceIfNullWith(final List<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<List<List<T>>, I> createOperation() {
        return endFor().createOperation();
    }
    
    
    
}

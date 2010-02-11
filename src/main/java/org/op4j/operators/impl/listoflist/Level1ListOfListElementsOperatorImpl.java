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
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListOfListElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1ListOfListElementsOperator<T>  {

    
    public Level1ListOfListElementsOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfListElementsOperator<T> add(final T newElement) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }

    public Level1ListOfListElementsOperator<T> addAll(final T... newElements) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfListElementsOperator<T> insert(final int position, final T newElement) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }

    public Level1ListOfListElementsOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfListElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level1ListOfListElementsOperator<T> distinct() {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level0ListOfListOperator<T> endFor() {
        return new Level0ListOfListOperatorImpl<T>(getTarget().endIterate(null));
    }


    public Level2ListOfListElementsElementsOperator<T> forEach() {
        return new Level2ListOfListElementsElementsOperatorImpl<T>(getTarget().iterate(Structure.LIST));
    }


    public Level1ListOfListElementsOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1ListOfListElementsOperator<T> removeAllEqual(final T... values) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfListElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level1ListOfListElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level1ListOfListElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level1ListOfListElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfListElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfListElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfListElementsOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1ListOfListElementsOperator<T> removeAllNull() {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level1ListOfListElementsOperator<T> sort() {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1ListOfListElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfArrayElementsOperator<T> toArrayOf(final Type<T> type) {
        return new Level1ListOfArrayElementsOperatorImpl<T>(type, getTarget().execute(new ToArray.FromCollection<T>(type)));
    }


    public Level1ListOfMapElementsOperator<T, T> toMap() {
        return new Level1ListOfMapElementsOperatorImpl<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }

    
    public <K> Level1ListOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1ListOfMapElementsOperatorImpl<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1ListOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level1ListOfSetElementsOperator<T> toSet() {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    public List<List<T>> get() {
        return endFor().get();
    }


    
    
    
    
    
    
    
	public <X> Level1ListOfListElementsOperator<X> asListOf(final Type<X> type) {
    	return endFor().generic().asListOfListOf(type).forEach();
    }


    public Level1ListOfListElementsOperator<?> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level1ListOfListElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level1ListOfListElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level1ListOfListElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ListOfListElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfListElementsSelectedOperator<T> ifNotNull() {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ListOfListElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListOfListElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfListElementsSelectedOperator<T> ifNull() {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ListOfListElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfListElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1ListOfListElementsOperator<X> convertAsList(final IConverter<? extends List<X>, ? super List<T>> converter) {
        return new Level1ListOfListElementsOperatorImpl<X>(getTarget().execute(converter, Normalisation.LIST));
    }


    public <X> Level1ListOfListElementsOperator<X> evalAsList(final IEvaluator<? extends List<X>, ? super List<T>> eval) {
        return new Level1ListOfListElementsOperatorImpl<X>(getTarget().execute(eval, Normalisation.LIST));
    }


    public <X> Level1ListOfListElementsOperator<X> execAsList(final IFunction<? extends List<X>, ? super List<T>> function) {
        return new Level1ListOfListElementsOperatorImpl<X>(getTarget().execute(function, Normalisation.LIST));
    }


    public <X> Level1ListElementsOperator<X> convert(final IConverter<X, ? super List<T>> converter) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level1ListElementsOperator<X> eval(final IEvaluator<X, ? super List<T>> eval) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level1ListElementsOperator<X> exec(final IFunction<X, ? super List<T>> function) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ListOfListElementsOperator<T> replaceWith(final List<T> replacement) {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public Level1ListOfListElementsOperator<T> replaceIfNullWith(final List<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
    
}

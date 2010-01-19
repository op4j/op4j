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
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListSelectedOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ListOfListOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0ListOfListOperator<T>  {

    
    public Level0ListOfListOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ListOfListOperator<T> add(final List<T>... newElements) {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<List<T>>(NormalizationUtils.normalizeLists(newElements))));
    }


    public Level0ListOfListOperator<T> insert(final int position, final List<T>... newElements) {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<List<T>>(position, NormalizationUtils.normalizeLists(newElements))));
    }


    public Level0ListOfListOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<List<T>>(NormalizationUtils.normalizeLists(collection))));
    }


    public Level0ListOfListOperator<T> distinct() {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<List<T>>()));
    }


    public Level0ListOperator<T> flatten() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.FlattenListOfLists<T>()));
    }


    public Level1ListOfListElementsOperator<T> forEach() {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0ListOfListOperator<T> removeAllIndexes(final int... indices) {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<List<T>>(indices)));
    }


    public Level0ListOfListOperator<T> removeAllEqual(final List<T>... values) {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<List<T>>(values)));
    }


    public Level0ListOfListOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<List<T>>(eval)));
    }

    public Level0ListOfListOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<List<T>>(eval)));
    }

    public Level0ListOfListOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<List<T>>(eval)));
    }

    public Level0ListOfListOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<List<T>>(eval)));
    }


    public Level0ListOfListOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<List<T>>(eval)));
    }


    public Level0ListOfListOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<List<T>>(eval)));
    }


    public Level0ListOfListOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<List<T>>(indices)));
    }


    public Level0ListOfListOperator<T> removeAllNull() {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<List<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOfListOperator<T> sort() {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfListOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<List<T>>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return Op.onArrayOfArray(Op.onList(forEach().toArray(of).get()).toArray(Types.arrayOf(of)).get());
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfListOperator<T> toArrayOfList() {
        return Op.onArrayOfList(Op.onList(get()).toArray((Type<List<T>>)((Type<?>)Types.LIST_OF_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K> Level0ArrayOfMapOperator<K, T> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onArrayOfMap(Op.onList(forEach().toMap(keyEval).get()).toArray((Type<Map<K, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onArrayOfMap(Op.onList(forEach().toMap(mapBuild).get()).toArray((Type<Map<K, V>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetOperator<T> toArrayOfSet() {
        return Op.onArrayOfSet(Op.onList(forEach().toSet().get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get());
    }


    public Level0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return forEach().toArray(of).endFor();
    }


    public <K> Level0ListOfMapOperator<K, T> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> Level0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public Level0ListOfSetOperator<T> toListOfSet() {
        return forEach().toSet().endFor();
    }


    public Level0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(Op.onList(forEach().toArray(of).get()).toSet().get());
    }


    public Level0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(Op.onList(get()).toSet().get());
    }


    public <K> Level0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onSetOfMap(Op.onList(forEach().toMap(keyEval).get()).toSet().get());
    }


    public <K, V> Level0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onSetOfMap(Op.onList(forEach().toMap(mapBuild).get()).toSet().get());
    }


    public Level0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(Op.onList(forEach().toSet().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return Op.onArrayOfMap(Op.onList(forEach().toMap().get()).toArray((Type<Map<T, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    public Level0ListOfMapOperator<T, T> toListOfMap() {
        return forEach().toMap().endFor();
    }


    public Level0SetOfMapOperator<T, T> toSetOfMap() {
        return Op.onSetOfMap(Op.onList(forEach().toMap().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
    public List<List<T>> get() {
        return (List<List<T>>) getTarget().get();
    }


    public Level0GenericUniqOperator<List<List<T>>> generic() {
        return new Level0GenericUniqOperatorImpl<List<List<T>>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
	public <X> Level0ListOfListOperator<X> asListOfListOf(final Type<X> type) {
        return generic().asListOfListOf(type);
    }


    public Level0ListOfListOperator<?> asListOfListOfUnknown() {
        return asListOfListOf(Types.OBJECT);
    }


    public Level0ListOfListSelectedOperator<T> ifIndex(final int... indices) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level0ListOfListSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level0ListOfListSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super List<List<T>>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0ListOfListSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super List<List<T>>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0ListOfListSelectedOperator<T> ifNotNull() {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0ListOfListSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<List<T>>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListOfListSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<List<T>>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListOfListSelectedOperator<T> ifNull() {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0ListOfListSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super List<List<T>>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListOfListSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super List<List<T>>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0ListOfListOperator<X> convert(final IConverter<? extends List<? extends List<X>>, ? super List<List<T>>> converter) {
        return new Level0ListOfListOperatorImpl<X>(getTarget().execute(converter, Normalization.LIST_OF_LIST));
    }


    public <X> Level0ListOfListOperator<X> eval(final IEvaluator<? extends List<? extends List<X>>, ? super List<List<T>>> eval) {
        return new Level0ListOfListOperatorImpl<X>(getTarget().execute(eval, Normalization.LIST_OF_LIST));
    }


    public <X> Level0ListOfListOperator<X> exec(final IFunction<? extends List<? extends List<X>>, ? super List<List<T>>> function) {
        return new Level0ListOfListOperatorImpl<X>(getTarget().execute(function, Normalization.LIST_OF_LIST));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super List<List<T>>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super List<List<T>>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<List<T>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0ListOfListOperator<T> replaceBy(final List<List<T>> replacement) {
        return new Level0ListOfListOperatorImpl<T>(getTarget().replaceBy(replacement));
    }


    public Level0ListOfListOperator<T> replaceIfNullBy(final List<List<T>> replacement) {
        return ifNull().replaceBy(replacement).endIf();
    }
    
    
    
    
}

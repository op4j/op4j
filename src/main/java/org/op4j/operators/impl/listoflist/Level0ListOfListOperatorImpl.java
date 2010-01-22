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
import org.op4j.exceptions.NonEmptyTargetException;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.arrayofarray.Level0ArrayOfArrayOperatorImpl;
import org.op4j.operators.impl.arrayoflist.Level0ArrayOfListOperatorImpl;
import org.op4j.operators.impl.arrayofmap.Level0ArrayOfMapOperatorImpl;
import org.op4j.operators.impl.arrayofset.Level0ArrayOfSetOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.listofarray.Level0ListOfArrayOperatorImpl;
import org.op4j.operators.impl.listofmap.Level0ListOfMapOperatorImpl;
import org.op4j.operators.impl.listofset.Level0ListOfSetOperatorImpl;
import org.op4j.operators.impl.setofarray.Level0SetOfArrayOperatorImpl;
import org.op4j.operators.impl.setoflist.Level0SetOfListOperatorImpl;
import org.op4j.operators.impl.setofmap.Level0SetOfMapOperatorImpl;
import org.op4j.operators.impl.setofset.Level0SetOfSetOperatorImpl;
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
import org.op4j.target.OperationChainingTarget;
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
public class Level0ListOfListOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level0ListOfListOperator<T,I>  {

    
    public Level0ListOfListOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfListOperator<T,I> add(final List<T> newElement) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<List<T>>(NormalizationUtils.normalizeList(newElement))));
    }

    public Level0ListOfListOperator<T,I> addAll(final List<T>... newElements) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<List<T>>(NormalizationUtils.normalizeLists(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfListOperator<T,I> insert(final int position, final List<T> newElement) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<List<T>>(position, NormalizationUtils.normalizeList(newElement))));
    }

    public Level0ListOfListOperator<T,I> insertAll(final int position, final List<T>... newElements) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<List<T>>(position, NormalizationUtils.normalizeLists(newElements))));
    }


    public Level0ListOfListOperator<T,I> addAll(final Collection<List<T>> collection) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.AddAll<List<T>>(NormalizationUtils.normalizeLists(collection))));
    }


    public Level0ListOfListOperator<T,I> distinct() {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Distinct<List<T>>()));
    }


    public Level0ListOperator<T,I> flatten() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.FlattenListOfLists<T>()));
    }


    public Level1ListOfListElementsOperator<T,I> forEach() {
        return new Level1ListOfListElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level0ListOfListOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<List<T>>(indices)));
    }


    public Level0ListOfListOperator<T,I> removeAllEqual(final List<T>... values) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<List<T>>(values)));
    }


    public Level0ListOfListOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<List<T>>(eval)));
    }

    public Level0ListOfListOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<List<T>>(eval)));
    }

    public Level0ListOfListOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<List<T>>(eval)));
    }

    public Level0ListOfListOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<List<T>>(eval)));
    }


    public Level0ListOfListOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<List<T>>(eval)));
    }


    public Level0ListOfListOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<List<T>>(eval)));
    }


    public Level0ListOfListOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<List<T>>(indices)));
    }


    public Level0ListOfListOperator<T,I> removeAllNull() {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNull<List<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOfListOperator<T,I> sort() {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfListOperator<T,I> sort(final Comparator<? super List<T>> comparator) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.SortByComparator<List<T>>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T,I> toArrayOfArray(final Type<T> of) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().replaceWith(Op.onArrayOfArray(Op.onList(forEach().toArray(of).get()).toArray(Types.arrayOf(of)).get()).get()));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfListOperator<T,I> toArrayOfList() {
        return new Level0ArrayOfListOperatorImpl<T,I>(getTarget().replaceWith(Op.onArrayOfList(Op.onList(get()).toArray((Type<List<T>>)((Type<?>)Types.LIST_OF_UNKNOWN)).get()).get()));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0ArrayOfMapOperator<K, T,I> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0ArrayOfMapOperatorImpl<K, T,I>(getTarget().replaceWith(Op.onArrayOfMap(Op.onList(forEach().toMap(keyEval).get()).toArray((Type<Map<K, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get()).get()));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0ArrayOfMapOperator<K, V,I> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0ArrayOfMapOperatorImpl<K, V,I>(getTarget().replaceWith(Op.onArrayOfMap(Op.onList(forEach().toMap(mapBuild).get()).toArray((Type<Map<K, V>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get()).get()));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetOperator<T,I> toArrayOfSet() {
        return new Level0ArrayOfSetOperatorImpl<T,I>(getTarget().replaceWith(Op.onArrayOfSet(Op.onList(forEach().toSet().get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get()).get()));
    }


    public Level0ListOfArrayOperator<T,I> toListOfArray(final Type<T> of) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().replaceWith(forEach().toArray(of).endFor().get()));
    }


    public <K> Level0ListOfMapOperator<K, T,I> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0ListOfMapOperatorImpl<K, T,I>(getTarget().replaceWith(forEach().toMap(keyEval).endFor().get()));
    }


    public <K, V> Level0ListOfMapOperator<K, V,I> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().replaceWith(forEach().toMap(mapBuild).endFor().get()));
    }


    public Level0ListOfSetOperator<T,I> toListOfSet() {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().replaceWith(forEach().toSet().endFor().get()));
    }


    public Level0SetOfArrayOperator<T,I> toSetOfArray(final Type<T> of) {
        return new Level0SetOfArrayOperatorImpl<T,I>(getTarget().replaceWith(Op.onSetOfArray(Op.onList(forEach().toArray(of).get()).toSet().get()).get()));
    }


    public Level0SetOfListOperator<T,I> toSetOfList() {
        return new Level0SetOfListOperatorImpl<T,I>(getTarget().replaceWith(Op.onSetOfList(Op.onList(get()).toSet().get()).get()));
    }


    public <K> Level0SetOfMapOperator<K, T,I> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0SetOfMapOperatorImpl<K, T,I>(getTarget().replaceWith(Op.onSetOfMap(Op.onList(forEach().toMap(keyEval).get()).toSet().get()).get()));
    }


    public <K, V> Level0SetOfMapOperator<K, V,I> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().replaceWith(Op.onSetOfMap(Op.onList(forEach().toMap(mapBuild).get()).toSet().get()).get()));
    }


    public Level0SetOfSetOperator<T,I> toSetOfSet() {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().replaceWith(Op.onSetOfSet(Op.onList(forEach().toSet().get()).toSet().get()).get()));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfMapOperator<T, T,I> toArrayOfMap() {
        return new Level0ArrayOfMapOperatorImpl<T, T,I>(getTarget().replaceWith(Op.onArrayOfMap(Op.onList(forEach().toMap().get()).toArray((Type<Map<T, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get()).get()));
    }


    public Level0ListOfMapOperator<T, T,I> toListOfMap() {
        return new Level0ListOfMapOperatorImpl<T, T,I>(getTarget().replaceWith(forEach().toMap().endFor().get()));
    }


    public Level0SetOfMapOperator<T, T,I> toSetOfMap() {
        return new Level0SetOfMapOperatorImpl<T, T,I>(getTarget().replaceWith(Op.onSetOfMap(Op.onList(forEach().toMap().get()).toSet().get()).get()));
    }


    @SuppressWarnings("unchecked")
    public List<List<T>> get() {
        return (List<List<T>>) getTarget().get();
    }


    public Level0GenericUniqOperator<List<List<T>>,I> generic() {
        return new Level0GenericUniqOperatorImpl<List<List<T>>,I>(getTarget());
    }

    
    
    
    
    
    
    
    
    
	public <X> Level0ListOfListOperator<X,I> asListOfListOf(final Type<X> type) {
        return generic().asListOfListOf(type);
    }


    public Level0ListOfListOperator<?,I> asListOfListOfUnknown() {
        return asListOfListOf(Types.OBJECT);
    }


    public Level0ListOfListSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level0ListOfListSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level0ListOfListSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level0ListOfListSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level0ListOfListSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super List<List<T>>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level0ListOfListSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super List<List<T>>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level0ListOfListSelectedOperator<T,I> ifNotNull() {
        return new Level0ListOfListSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level0ListOfListSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<List<T>>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListOfListSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<List<T>>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListOfListSelectedOperator<T,I> ifNull() {
        return new Level0ListOfListSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level0ListOfListSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super List<List<T>>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListOfListSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super List<List<T>>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0ListOfListOperator<X,I> convert(final IConverter<? extends List<? extends List<X>>, ? super List<List<T>>> converter) {
        return new Level0ListOfListOperatorImpl<X,I>(getTarget().execute(converter, Normalization.LIST_OF_LIST));
    }


    public <X> Level0ListOfListOperator<X,I> eval(final IEvaluator<? extends List<? extends List<X>>, ? super List<List<T>>> eval) {
        return new Level0ListOfListOperatorImpl<X,I>(getTarget().execute(eval, Normalization.LIST_OF_LIST));
    }


    public <X> Level0ListOfListOperator<X,I> exec(final IFunction<? extends List<? extends List<X>>, ? super List<List<T>>> function) {
        return new Level0ListOfListOperatorImpl<X,I>(getTarget().execute(function, Normalization.LIST_OF_LIST));
    }


    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super List<List<T>>> converter) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super List<List<T>>> eval) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<List<T>>> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0ListOfListOperator<T,I> replaceWith(final List<List<T>> replacement) {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0ListOfListOperator<T,I> replaceIfNullWith(final List<List<T>> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<List<List<T>>, I> createOperation() {
        final Target target = getTarget();
        if (!(target instanceof OperationChainingTarget)) {
            throw new NonEmptyTargetException();
        }
        return new Operation<List<List<T>>, I>((OperationChainingTarget) target);
    }
    
    
    
    
}

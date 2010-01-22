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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.exceptions.NonEmptyTargetException;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
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
import org.op4j.operators.impl.listofarray.Level0ListOfArrayOperatorImpl;
import org.op4j.operators.impl.listoflist.Level0ListOfListOperatorImpl;
import org.op4j.operators.impl.listofmap.Level0ListOfMapOperatorImpl;
import org.op4j.operators.impl.listofset.Level0ListOfSetOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.impl.setofarray.Level0SetOfArrayOperatorImpl;
import org.op4j.operators.impl.setoflist.Level0SetOfListOperatorImpl;
import org.op4j.operators.impl.setofmap.Level0SetOfMapOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetSelectedOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
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
public class Level0SetOfSetOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level0SetOfSetOperator<T,I>  {

    
    public Level0SetOfSetOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfSetOperator<T,I> add(final Set<T> newElement) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<Set<T>>(NormalizationUtils.normalizeSet(newElement))));
    }

    public Level0SetOfSetOperator<T,I> addAll(final Set<T>... newElements) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<Set<T>>(NormalizationUtils.normalizeSets(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfSetOperator<T,I> insert(final int position, final Set<T> newElement) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<Set<T>>(position, NormalizationUtils.normalizeSet(newElement))));
    }

    public Level0SetOfSetOperator<T,I> insertAll(final int position, final Set<T>... newElements) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<Set<T>>(position, NormalizationUtils.normalizeSets(newElements))));
    }


    public Level0SetOfSetOperator<T,I> addAll(final Collection<Set<T>> collection) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.AddAll<Set<T>>(NormalizationUtils.normalizeSets(collection))));
    }


    public Level0SetOperator<T,I> flatten() {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.FlattenSetOfSets<T>()));
    }


    public Level1SetOfSetElementsOperator<T,I> forEach() {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level0SetOfSetOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<Set<T>>(indices)));
    }


    public Level0SetOfSetOperator<T,I> removeAllEqual(final Set<T>... values) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<Set<T>>(values)));
    }


    public Level0SetOfSetOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<Set<T>>(eval)));
    }

    public Level0SetOfSetOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<Set<T>>(eval)));
    }

    public Level0SetOfSetOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<Set<T>>(eval)));
    }

    public Level0SetOfSetOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<Set<T>>(eval)));
    }


    public Level0SetOfSetOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<Set<T>>(eval)));
    }


    public Level0SetOfSetOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<Set<T>>(eval)));
    }


    public Level0SetOfSetOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<Set<T>>(indices)));
    }


    public Level0SetOfSetOperator<T,I> removeAllNull() {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNull<Set<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0SetOfSetOperator<T,I> sort() {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfSetOperator<T,I> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T,I> toArrayOfArray(final Type<T> of) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().replaceWith(Op.onArrayOfArray(Op.onSet(forEach().toArray(of).get()).toArray(Types.arrayOf(of)).get()).get()));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfListOperator<T,I> toArrayOfList() {
        return new Level0ArrayOfListOperatorImpl<T,I>(getTarget().replaceWith(Op.onArrayOfList(Op.onSet(forEach().toList().get()).toArray((Type<List<T>>)((Type<?>)Types.LIST_OF_UNKNOWN)).get()).get()));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0ArrayOfMapOperator<K, T,I> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0ArrayOfMapOperatorImpl<K, T,I>(getTarget().replaceWith(Op.onArrayOfMap(Op.onSet(forEach().toMap(keyEval).get()).toArray((Type<Map<K, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get()).get()));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0ArrayOfMapOperator<K, V,I> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0ArrayOfMapOperatorImpl<K, V,I>(getTarget().replaceWith(Op.onArrayOfMap(Op.onSet(forEach().toMap(mapBuild).get()).toArray((Type<Map<K, V>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get()).get()));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetOperator<T,I> toArrayOfSet() {
        return new Level0ArrayOfSetOperatorImpl<T,I>(getTarget().replaceWith(Op.onArrayOfSet(Op.onSet(get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get()).get()));
    }


    public Level0ListOfArrayOperator<T,I> toListOfArray(final Type<T> of) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().replaceWith(Op.onListOfArray(Op.onSet(forEach().toArray(of).get()).toList().get()).get()));
    }


    public Level0ListOfListOperator<T,I> toListOfList() {
        return new Level0ListOfListOperatorImpl<T,I>(getTarget().replaceWith(Op.onListOfList(Op.onSet(forEach().toList().get()).toList().get()).get()));
    }


    public <K> Level0ListOfMapOperator<K, T,I> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0ListOfMapOperatorImpl<K, T,I>(getTarget().replaceWith(Op.onListOfMap(Op.onSet(forEach().toMap(keyEval).get()).toList().get()).get()));
    }


    public <K, V> Level0ListOfMapOperator<K, V,I> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().replaceWith(Op.onListOfMap(Op.onSet(forEach().toMap(mapBuild).get()).toList().get()).get()));
    }


    public Level0ListOfSetOperator<T,I> toListOfSet() {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().replaceWith(Op.onListOfSet(Op.onSet(get()).toList().get()).get()));
    }


    public Level0SetOfArrayOperator<T,I> toSetOfArray(final Type<T> of) {
        return new Level0SetOfArrayOperatorImpl<T,I>(getTarget().replaceWith(Op.onSetOfArray(forEach().toArray(of).get()).get()));
    }


    public Level0SetOfListOperator<T,I> toSetOfList() {
        return new Level0SetOfListOperatorImpl<T,I>(getTarget().replaceWith(Op.onSetOfList(forEach().toList().get()).get()));
    }


    public <K> Level0SetOfMapOperator<K, T,I> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0SetOfMapOperatorImpl<K, T,I>(getTarget().replaceWith(forEach().toMap(keyEval).endFor().get()));
    }


    public <K, V> Level0SetOfMapOperator<K, V,I> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().replaceWith(forEach().toMap(mapBuild).endFor().get()));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfMapOperator<T, T,I> toArrayOfMap() {
        return new Level0ArrayOfMapOperatorImpl<T, T,I>(getTarget().replaceWith(Op.onArrayOfMap(Op.onSet(forEach().toMap().get()).toArray((Type<Map<T, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get()).get()));
    }


    public Level0ListOfMapOperator<T, T,I> toListOfMap() {
        return new Level0ListOfMapOperatorImpl<T, T,I>(getTarget().replaceWith(Op.onListOfMap(Op.onSet(forEach().toMap().get()).toList().get()).get()));
    }


    public Level0SetOfMapOperator<T, T,I> toSetOfMap() {
        return new Level0SetOfMapOperatorImpl<T, T,I>(getTarget().replaceWith(forEach().toMap().endFor().get()));
    }


    @SuppressWarnings("unchecked")
    public Set<Set<T>> get() {
        return (Set<Set<T>>) getTarget().get();
    }


    public Level0GenericUniqOperator<Set<Set<T>>,I> generic() {
        return new Level0GenericUniqOperatorImpl<Set<Set<T>>,I>(getTarget());
    }

    
    
    
    
    
    
    
    
	public <X> Level0SetOfSetOperator<X,I> asSetOfSetOf(final Type<X> type) {
        return generic().asSetOfSetOf(type);
    }


    public Level0SetOfSetOperator<?,I> asSetOfSetOfUnknown() {
        return asSetOfSetOf(Types.OBJECT);
    }


    public Level0SetOfSetSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level0SetOfSetSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level0SetOfSetSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T,I> ifNotNull() {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level0SetOfSetSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T,I> ifNull() {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level0SetOfSetSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0SetOfSetOperator<X,I> convert(final IConverter<? extends Set<? extends Set<X>>, ? super Set<Set<T>>> converter) {
        return new Level0SetOfSetOperatorImpl<X,I>(getTarget().execute(converter, Normalization.SET_OF_SET));
    }


    public <X> Level0SetOfSetOperator<X,I> eval(final IEvaluator<? extends Set<? extends Set<X>>, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetOperatorImpl<X,I>(getTarget().execute(eval, Normalization.SET_OF_SET));
    }


    public <X> Level0SetOfSetOperator<X,I> exec(final IFunction<? extends Set<? extends Set<X>>, ? super Set<Set<T>>> function) {
        return new Level0SetOfSetOperatorImpl<X,I>(getTarget().execute(function, Normalization.SET_OF_SET));
    }


    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Set<Set<T>>> converter) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Set<Set<T>>> eval) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<Set<T>>> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0SetOfSetOperator<T,I> replaceWith(final Set<Set<T>> replacement) {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0SetOfSetOperator<T,I> replaceIfNullWith(final Set<Set<T>> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Set<Set<T>>, I> createOperation() {
        final Target target = getTarget();
        if (!(target instanceof OperationChainingTarget)) {
            throw new NonEmptyTargetException();
        }
        return new Operation<Set<Set<T>>, I>((OperationChainingTarget) target);
    }
    
    
    
}

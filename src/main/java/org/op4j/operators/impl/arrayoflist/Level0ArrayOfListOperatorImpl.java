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
import org.op4j.Op;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
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
public class Level0ArrayOfListOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0ArrayOfListOperator<T>  {

    
    public Level0ArrayOfListOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ArrayOfListOperator<T> add(final List<T>... newElements) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<List<T>>(NormalizationUtils.normalizeLists(newElements))));
    }


    public Level0ArrayOfListOperator<T> insert(final int position, final List<T>... newElements) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<List<T>>(position, NormalizationUtils.normalizeLists(newElements))));
    }


    public Level0ArrayOfListOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<List<T>>(NormalizationUtils.normalizeLists(collection))));
    }


    public Level0ArrayOfListOperator<T> distinct() {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<List<T>>()));
    }


    public Level0ArrayOperator<T> flatten(final Type<T> type) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.FlattenArrayOfLists<T>(type)));
    }


    public Level1ArrayOfListElementsOperator<T> forEach() {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0ArrayOfListOperator<T> removeAllIndexes(final int... indices) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<List<T>>(indices)));
    }


    public Level0ArrayOfListOperator<T> removeAllEqual(final List<T>... values) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<List<T>>(values)));
    }


    public Level0ArrayOfListOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<List<T>>(eval)));
    }

    public Level0ArrayOfListOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<List<T>>(eval)));
    }

    public Level0ArrayOfListOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<List<T>>(eval)));
    }

    public Level0ArrayOfListOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<List<T>>(eval)));
    }


    public Level0ArrayOfListOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<List<T>>(eval)));
    }


    public Level0ArrayOfListOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<List<T>>(eval)));
    }


    public Level0ArrayOfListOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<List<T>>(indices)));
    }



    public Level0ArrayOfListOperator<T> removeAllNull() {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNull<List<T>>()));
    }

    

    @SuppressWarnings("unchecked")
    public Level0ArrayOfListOperator<T> sort() {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level0ArrayOfListOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<List<T>>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return forEach().toArray(of).endFor();
    }


    public <K> Level0ArrayOfMapOperator<K, T> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> Level0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public Level0ArrayOfSetOperator<T> toArrayOfSet() {
        return forEach().toSet().endFor();
    }


    public Level0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(Op.onArray(forEach().toArray(of).get()).toList().get());
    }


    public Level0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onArray(get()).toList().get());
    }


    public <K> Level0ListOfMapOperator<K, T> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onListOfMap(Op.onArray(forEach().toMap(keyEval).get()).toList().get());
    }


    public <K, V> Level0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onListOfMap(Op.onArray(forEach().toMap(mapBuild).get()).toList().get());
    }


    public Level0ListOfSetOperator<T> toListOfSet() {
        return Op.onListOfSet(Op.onArray(forEach().toSet().get()).toList().get());
    }


    public Level0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(Op.onArray(forEach().toArray(of).get()).toSet().get());
    }


    public Level0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(Op.onArray(get()).toSet().get());
    }


    public <K> Level0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onSetOfMap(Op.onArray(forEach().toMap(keyEval).get()).toSet().get());
    }


    public <K, V> Level0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onSetOfMap(Op.onArray(forEach().toMap(mapBuild).get()).toSet().get());
    }


    public Level0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(Op.onArray(forEach().toSet().get()).toSet().get());
    }


    public Level0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return forEach().toMap().endFor();
    }


    public Level0ListOfMapOperator<T, T> toListOfMap() {
        return Op.onListOfMap(Op.onArray(forEach().toMap().get()).toList().get());
    }


    public Level0SetOfMapOperator<T, T> toSetOfMap() {
        return Op.onSetOfMap(Op.onArray(forEach().toMap().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
	public List<T>[] get() {
        return (List<T>[]) getTarget().get();
    }


    public Level0GenericUniqOperator<List<T>[]> generic() {
        return new Level0GenericUniqOperatorImpl<List<T>[]>(getTarget());
    }

    
    
    
    
    
	public <X> Level0ArrayOfListOperator<X> asArrayOfListOf(final Type<X> type) {
        return generic().asArrayOfListOf(type);
    }


    public Level0ArrayOfListOperator<?> asArrayOfListOfUnknown() {
        return asArrayOfListOf(Types.OBJECT);
    }


    public Level0ArrayOfListSelectedOperator<T> ifIndex(final int... indices) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level0ArrayOfListSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level0ArrayOfListSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super List<T>[]> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0ArrayOfListSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super List<T>[]> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0ArrayOfListSelectedOperator<T> ifNotNull() {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0ArrayOfListSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>[]> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArrayOfListSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>[]> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ArrayOfListSelectedOperator<T> ifNull() {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0ArrayOfListSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>[]> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ArrayOfListSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>[]> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0ArrayOfListOperator<X> convert(final IConverter<? extends List<X>[], ? super List<T>[]> converter) {
        return new Level0ArrayOfListOperatorImpl<X>(getTarget().execute(converter, Normalization.ARRAY_OF_LIST));
    }


    public <X> Level0ArrayOfListOperator<X> eval(final IEvaluator<? extends List<X>[], ? super List<T>[]> eval) {
        return new Level0ArrayOfListOperatorImpl<X>(getTarget().execute(eval, Normalization.ARRAY_OF_LIST));
    }


    public <X> Level0ArrayOfListOperator<X> exec(final IFunction<? extends List<X>[], ? super List<T>[]> function) {
        return new Level0ArrayOfListOperatorImpl<X>(getTarget().execute(function, Normalization.ARRAY_OF_LIST));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super List<T>[]> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super List<T>[]> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<T>[]> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalization.NONE));
    }
    
    
    
}

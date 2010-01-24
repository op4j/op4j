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
package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.NonEmptyTargetException;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.arrayofarray.Level0ArrayOfArrayOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.setofarray.Level0SetOfArrayOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArraySelectedOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
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
public class Level0ListOfArrayOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level0ListOfArrayOperator<T,I>  {

    
    public Level0ListOfArrayOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfArrayOperator<T,I> add(final T[] newElement) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T[]>(NormalizationUtils.normalizeArray(newElement))));
    }

    public Level0ListOfArrayOperator<T,I> addAll(final T[]... newElements) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T[]>(NormalizationUtils.normalizeArrays(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfArrayOperator<T,I> insert(final int position, final T[] newElement) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T[]>(position, NormalizationUtils.normalizeArray(newElement))));
    }

    public Level0ListOfArrayOperator<T,I> insertAll(final int position, final T[]... newElements) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T[]>(position, NormalizationUtils.normalizeArrays(newElements))));
    }


    public Level0ListOfArrayOperator<T,I> addAll(final Collection<T[]> collection) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.AddAll<T[]>(NormalizationUtils.normalizeArrays(collection))));
    }


    public Level0ListOfArrayOperator<T,I> distinct() {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Distinct<T[]>()));
    }


    public Level0ListOperator<T,I> flatten() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.FlattenListOfArrays<T>()));
    }


    public Level1ListOfArrayElementsOperator<T,I> forEach() {
        return new Level1ListOfArrayElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level0ListOfArrayOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T[]>(indices)));
    }


    public Level0ListOfArrayOperator<T,I> removeAllEqual(final T[]... values) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<T[]>(values)));
    }


    public Level0ListOfArrayOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<T[]>(eval)));
    }

    public Level0ListOfArrayOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<T[]>(eval)));
    }

    public Level0ListOfArrayOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T[]>(eval)));
    }

    public Level0ListOfArrayOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T[]>(eval)));
    }


    public Level0ListOfArrayOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T[]>(eval)));
    }


    public Level0ListOfArrayOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T[]>(eval)));
    }


    public Level0ListOfArrayOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T[]>(indices)));
    }


    public Level0ListOfArrayOperator<T,I> removeAllNull() {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNull<T[]>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOfArrayOperator<T,I> sort() {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfArrayOperator<T,I> sort(final Comparator<? super T[]> comparator) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ListFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T,I> toArrayOfArray(final Type<T> of) {
        return new Level0ArrayOfArrayOperatorImpl<T, I>(getTarget().execute(new ToArray.FromCollection<T[]>(Types.arrayOf(of))));
    }


    public Level0ArrayOfListOperator<T,I> toArrayOfList() {
        return toListOfList().toArrayOfList();
    }


    public <K> Level0ArrayOfMapOperator<K, T,I> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return toListOfMap(keyEval).toArrayOfMap();
    }


    public <K, V> Level0ArrayOfMapOperator<K, V,I> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return toListOfMap(mapBuild).toArrayOfMap();
    }


    public Level0ArrayOfSetOperator<T,I> toArrayOfSet() {
        return toListOfSet().toArrayOfSet();
    }


    public Level0ListOfListOperator<T,I> toListOfList() {
        return forEach().toList().endFor();
    }


    public <K> Level0ListOfMapOperator<K, T,I> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor(); 
    }


    public <K, V> Level0ListOfMapOperator<K, V,I> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public Level0ListOfSetOperator<T,I> toListOfSet() {
        return forEach().toSet().endFor();
    }


    public Level0SetOfArrayOperator<T,I> toSetOfArray(final Type<T> of) {
        return new Level0SetOfArrayOperatorImpl<T, I>(getTarget().execute(new ToSet.FromCollection<T[]>()));
    }


    public Level0SetOfListOperator<T,I> toSetOfList() {
        return toListOfList().toSetOfList();
    }


    public <K> Level0SetOfMapOperator<K, T,I> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return toListOfMap(keyEval).toSetOfMap();
    }


    public <K, V> Level0SetOfMapOperator<K, V,I> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return toListOfMap(mapBuild).toSetOfMap();
    }


    public Level0SetOfSetOperator<T,I> toSetOfSet() {
        return toListOfSet().toSetOfSet();
    }


    public Level0ArrayOfMapOperator<T, T,I> toArrayOfMap() {
        return toListOfMap().toArrayOfMap();
    }


    public Level0ListOfMapOperator<T, T,I> toListOfMap() {
        return forEach().toMap().endFor();
    }


    public Level0SetOfMapOperator<T, T,I> toSetOfMap() {
        return toListOfMap().toSetOfMap();
    }


    @SuppressWarnings("unchecked")
    public List<T[]> get() {
        return (List<T[]>) getTarget().get();
    }


    public Level0GenericUniqOperator<List<T[]>,I> generic() {
        return new Level0GenericUniqOperatorImpl<List<T[]>,I>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
	public <X> Level0ListOfArrayOperator<X,I> asListOfArrayOf(final Type<X> type) {
        return generic().asListOfArrayOf(type);
    }


    public Level0ListOfArrayOperator<?,I> asListOfArrayOfUnknown() {
        return asListOfArrayOf(Types.OBJECT);
    }


    public Level0ListOfArraySelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level0ListOfArraySelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level0ListOfArraySelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T,I> ifNotNull() {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level0ListOfArraySelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T,I> ifNull() {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level0ListOfArraySelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0ListOfArrayOperator<X,I> convert(final IConverter<? extends List<X[]>, ? super List<T[]>> converter) {
        return new Level0ListOfArrayOperatorImpl<X,I>(getTarget().execute(converter, Normalization.LIST_OF_ARRAY));
    }


    public <X> Level0ListOfArrayOperator<X,I> eval(final IEvaluator<? extends List<X[]>, ? super List<T[]>> eval) {
        return new Level0ListOfArrayOperatorImpl<X,I>(getTarget().execute(eval, Normalization.LIST_OF_ARRAY));
    }


    public <X> Level0ListOfArrayOperator<X,I> exec(final IFunction<? extends List<X[]>, ? super List<T[]>> function) {
        return new Level0ListOfArrayOperatorImpl<X,I>(getTarget().execute(function, Normalization.LIST_OF_ARRAY));
    }


    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super List<T[]>> converter) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super List<T[]>> eval) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<T[]>> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0ListOfArrayOperator<T,I> replaceWith(final List<T[]> replacement) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0ListOfArrayOperator<T,I> replaceIfNullWith(final List<T[]> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<List<T[]>, I> createOperation() {
        final Target target = getTarget();
        if (!(target instanceof OperationChainingTarget)) {
            throw new NonEmptyTargetException();
        }
        final OperationChainingTarget ocTarget = (OperationChainingTarget) target;
        if (!ocTarget.isEmpty()) {
            throw new NonEmptyTargetException();
        }
        return new Operation<List<T[]>, I>(ocTarget);
    }
    
    
    
}

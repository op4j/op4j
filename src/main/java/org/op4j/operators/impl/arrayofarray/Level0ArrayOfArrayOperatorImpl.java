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
package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.NonEmptyTargetException;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.listofarray.Level0ListOfArrayOperatorImpl;
import org.op4j.operators.impl.setofarray.Level0SetOfArrayOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArraySelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
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
public class Level0ArrayOfArrayOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level0ArrayOfArrayOperator<T,I> {

    
    
    public Level0ArrayOfArrayOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfArrayOperator<T,I> add(final T[] newElement) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<T[]>(NormalizationUtils.normalizeArray(newElement))));
    }

    public Level0ArrayOfArrayOperator<T,I> addAll(final T[]... newElements) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<T[]>(NormalizationUtils.normalizeArrays(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfArrayOperator<T,I> insert(final int position, final T[] newElement) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<T[]>(position, NormalizationUtils.normalizeArray(newElement))));
    }

    public Level0ArrayOfArrayOperator<T,I> insertAll(final int position, final T[]... newElements) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<T[]>(position, NormalizationUtils.normalizeArrays(newElements))));
    }


    public Level0ArrayOfArrayOperator<T,I> addAll(final Collection<T[]> collection) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.AddAll<T[]>(NormalizationUtils.normalizeArrays(collection))));
    }


    public Level0ArrayOfArrayOperator<T,I> distinct() {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Distinct<T[]>()));
    }


    public Level0ArrayOperator<T,I> flatten(final Type<T> type) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.FlattenArrayOfArrays<T>(type)));
    }


    public Level1ArrayOfArrayElementsOperator<T,I> forEach(final Type<T[]> elementType) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(elementType, getTarget().iterate());
    }


    public Level0ArrayOfArrayOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T[]>(indices)));
    }


    public Level0ArrayOfArrayOperator<T,I> removeAllEqual(final T[]... values) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<T[]>(values)));
    }


    public Level0ArrayOfArrayOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<T[]>(eval)));
    }

    public Level0ArrayOfArrayOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<T[]>(eval)));
    }

    public Level0ArrayOfArrayOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T[]>(eval)));
    }

    public Level0ArrayOfArrayOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T[]>(eval)));
    }


    public Level0ArrayOfArrayOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T[]>(eval)));
    }


    public Level0ArrayOfArrayOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T[]>(eval)));
    }


    public Level0ArrayOfArrayOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T[]>(indices)));
    }



    public Level0ArrayOfArrayOperator<T,I> removeAllNull() {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNull<T[]>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ArrayOfArrayOperator<T,I> sort() {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfArrayOperator<T,I> sort(final Comparator<? super T[]> comparator) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.SortByComparator<T[]>(comparator)));
    }


    @SuppressWarnings({ "cast", "unchecked" })
    public Level0ArrayOfListOperator<T,I> toArrayOfList() {
        final Type<?> auxType = (Type<?>) Types.ARRAY_OF_OBJECT; 
        return forEach((Type<T[]>)auxType).toList().endFor();
    }


    @SuppressWarnings({ "cast", "unchecked" })
    public <K> Level0ArrayOfMapOperator<K, T,I> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        final Type<?> auxType = (Type<?>) Types.ARRAY_OF_OBJECT; 
        return forEach((Type<T[]>)auxType).toMap(keyEval).endFor();
    }


    @SuppressWarnings({ "cast", "unchecked" })
    public <K, V> Level0ArrayOfMapOperator<K, V,I> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        final Type<?> auxType = (Type<?>) Types.ARRAY_OF_OBJECT; 
        return forEach((Type<T[]>)auxType).toMap(mapBuild).endFor();
    }


    @SuppressWarnings({ "cast", "unchecked" })
    public Level0ArrayOfSetOperator<T,I> toArrayOfSet() {
        final Type<?> auxType = (Type<?>) Types.ARRAY_OF_OBJECT; 
        return forEach((Type<T[]>)auxType).toSet().endFor();
    }


    public Level0ListOfArrayOperator<T,I> toListOfArray(final Type<T> of) {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().execute(new ToList.FromArray<T[]>()));
    }


    public Level0ListOfListOperator<T,I> toListOfList() {
        return toArrayOfList().toListOfList();
    }


    public <K> Level0ListOfMapOperator<K, T,I> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return toArrayOfMap(keyEval).toListOfMap();
    }


    public <K, V> Level0ListOfMapOperator<K, V,I> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return toArrayOfMap(mapBuild).toListOfMap();
    }


    public Level0ListOfSetOperator<T,I> toListOfSet() {
        return toArrayOfSet().toListOfSet();
    }


    public Level0SetOfArrayOperator<T,I> toSetOfArray(final Type<T> of) {
        return new Level0SetOfArrayOperatorImpl<T,I>(getTarget().execute(new ToSet.FromArray<T[]>()));
    }


    public Level0SetOfListOperator<T,I> toSetOfList() {
        return toArrayOfList().toSetOfList();
    }


    public <K> Level0SetOfMapOperator<K, T,I> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return toArrayOfMap(keyEval).toSetOfMap();
   }


    public <K, V> Level0SetOfMapOperator<K, V,I> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return toArrayOfMap(mapBuild).toSetOfMap();
    }


    public Level0SetOfSetOperator<T,I> toSetOfSet() {
        return toArrayOfSet().toSetOfSet();
    }


    @SuppressWarnings({ "cast", "unchecked" })
    public Level0ArrayOfMapOperator<T, T,I> toArrayOfMap() {
        final Type<?> auxType = (Type<?>) Types.ARRAY_OF_OBJECT; 
        return forEach((Type<T[]>)auxType).toMap().endFor();
    }


    public Level0ListOfMapOperator<T, T,I> toListOfMap() {
        return toArrayOfMap().toListOfMap();
    }


    public Level0SetOfMapOperator<T, T,I> toSetOfMap() {
        return toArrayOfMap().toSetOfMap();
    }


    @SuppressWarnings("unchecked")
	public T[][] get() {
        return (T[][]) getTarget().get();
    }


    public Level0GenericUniqOperator<T[][],I> generic() {
        return new Level0GenericUniqOperatorImpl<T[][],I>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
	public <X> Level0ArrayOfArrayOperator<X,I> asArrayOfArrayOf(final Type<X> type) {
        return generic().asArrayOfArrayOf(type);
    }


    public Level0ArrayOfArrayOperator<?,I> asArrayOfArrayOfUnknown() {
        return asArrayOfArrayOf(Types.OBJECT);
    }


    public Level0ArrayOfArraySelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level0ArrayOfArraySelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level0ArrayOfArraySelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T,I> ifNotNull() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level0ArrayOfArraySelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T,I> ifNull() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level0ArrayOfArraySelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


	public <X> Level0ArrayOfArrayOperator<X,I> convert(final IConverter<X[][], ? super T[][]> converter) {
        return new Level0ArrayOfArrayOperatorImpl<X,I>(getTarget().execute(converter, Normalization.ARRAY_OF_ARRAY));
    }


	public <X> Level0ArrayOfArrayOperator<X,I> eval(final IEvaluator<X[][], ? super T[][]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<X,I>(getTarget().execute(eval, Normalization.ARRAY_OF_ARRAY));
    }


	public <X> Level0ArrayOfArrayOperator<X,I> exec(final IFunction<X[][], ? super T[][]> function) {
        return new Level0ArrayOfArrayOperatorImpl<X,I>(getTarget().execute(function, Normalization.ARRAY_OF_ARRAY));
    }


    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super T[][]> converter) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super T[][]> eval) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super T[][]> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0ArrayOfArrayOperator<T,I> replaceWith(final T[][] replacement) {
        return new Level0ArrayOfArrayOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0ArrayOfArrayOperator<T,I> replaceIfNullWith(final T[][] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<T[][], I> createOperation() {
        final Target target = getTarget();
        if (!(target instanceof OperationChainingTarget)) {
            throw new NonEmptyTargetException();
        }
        final OperationChainingTarget ocTarget = (OperationChainingTarget) target;
        if (!ocTarget.isEmpty()) {
            throw new NonEmptyTargetException();
        }
        return new Operation<T[][],I>(ocTarget);
    }


    
    
    
    
    
    
}

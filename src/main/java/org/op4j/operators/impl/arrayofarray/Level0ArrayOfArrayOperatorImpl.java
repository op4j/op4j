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
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
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
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ArrayOfArrayOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0ArrayOfArrayOperator<T> {


    private final Type<T> type;
    
    
    public Level0ArrayOfArrayOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfArrayOperator<T> add(final T[] newElement) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T[]>(NormalisationUtils.normaliseArray(newElement, this.type.getRawClass()))));
    }

    public Level0ArrayOfArrayOperator<T> addAll(final T[]... newElements) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T[]>(NormalisationUtils.normaliseArrays(newElements, this.type.getRawClass()))));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfArrayOperator<T> insert(final int position, final T[] newElement) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T[]>(position, NormalisationUtils.normaliseArray(newElement, this.type.getRawClass()))));
    }

    public Level0ArrayOfArrayOperator<T> insertAll(final int position, final T[]... newElements) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T[]>(position, NormalisationUtils.normaliseArrays(newElements, this.type.getRawClass()))));
    }


    public Level0ArrayOfArrayOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T[]>(NormalisationUtils.normaliseArrays(collection, this.type.getRawClass()))));
    }


    public Level0ArrayOfArrayOperator<T> distinct() {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T[]>()));
    }


    public Level0ArrayOperator<T> flatten(final Type<T> newType) {
        return new Level0ArrayOperatorImpl<T>(newType, getTarget().execute(new ArrayFuncs.FlattenArrayOfArrays<T>(newType)));
    }


    public Level1ArrayOfArrayElementsOperator<T> forEach() {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level0ArrayOfArrayOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T[]>(indexes)));
    }


    public Level0ArrayOfArrayOperator<T> removeAllEqual(final T[]... values) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<T[]>(values)));
    }


    public Level0ArrayOfArrayOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<T[]>(eval)));
    }

    public Level0ArrayOfArrayOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<T[]>(eval)));
    }

    public Level0ArrayOfArrayOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T[]>(eval)));
    }

    public Level0ArrayOfArrayOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T[]>(eval)));
    }


    public Level0ArrayOfArrayOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T[]>(eval)));
    }


    public Level0ArrayOfArrayOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T[]>(eval)));
    }


    public Level0ArrayOfArrayOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T[]>(indexes)));
    }



    public Level0ArrayOfArrayOperator<T> removeAllNull() {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<T[]>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ArrayOfArrayOperator<T> sort() {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfArrayOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0ArrayOfListOperator<T> toArrayOfList() {
        return forEach().toList().endFor();
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


    public Level0ListOfArrayOperator<T> toListOfArrayOf(final Type<T> newType) {
        return new Level0ListOfArrayOperatorImpl<T>(newType, getTarget().execute(new ToList.FromArray<T[]>()));
    }


    public Level0ListOfListOperator<T> toListOfList() {
        return toArrayOfList().toListOfList();
    }


    public <K> Level0ListOfMapOperator<K, T> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return toArrayOfMap(keyEval).toListOfMap();
    }


    public <K, V> Level0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return toArrayOfMap(mapBuild).toListOfMap();
    }


    public Level0ListOfSetOperator<T> toListOfSet() {
        return toArrayOfSet().toListOfSet();
    }


    public Level0SetOfArrayOperator<T> toSetOfArrayOf(final Type<T> newType) {
        return new Level0SetOfArrayOperatorImpl<T>(newType, getTarget().execute(new ToSet.FromArray<T[]>()));
    }


    public Level0SetOfListOperator<T> toSetOfList() {
        return toArrayOfList().toSetOfList();
    }


    public <K> Level0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return toArrayOfMap(keyEval).toSetOfMap();
   }


    public <K, V> Level0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return toArrayOfMap(mapBuild).toSetOfMap();
    }


    public Level0SetOfSetOperator<T> toSetOfSet() {
        return toArrayOfSet().toSetOfSet();
    }


    public Level0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return forEach().toMap().endFor();
    }


    public Level0ListOfMapOperator<T, T> toListOfMap() {
        return toArrayOfMap().toListOfMap();
    }


    public Level0SetOfMapOperator<T, T> toSetOfMap() {
        return toArrayOfMap().toSetOfMap();
    }


    @SuppressWarnings("unchecked")
	public T[][] get() {
        return (T[][]) getTarget().get();
    }


    public Level0GenericUniqOperator<T[][]> generic() {
        return new Level0GenericUniqOperatorImpl<T[][]>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
	public <X> Level0ArrayOfArrayOperator<X> asArrayOfArrayOf(final Type<X> newType) {
        return generic().asArrayOfArrayOf(newType);
    }


    public Level0ArrayOfArrayOperator<?> asArrayOfArrayOfUnknown() {
        return asArrayOfArrayOf(Types.OBJECT);
    }


    public Level0ArrayOfArraySelectedOperator<T> ifIndex(final int... indexes) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level0ArrayOfArraySelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level0ArrayOfArraySelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T> ifNotNull() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level0ArrayOfArraySelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T> ifNull() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level0ArrayOfArraySelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


	public Level0ArrayOfArrayOperator<T> convertAsArrayOfArray(final IConverter<? extends T[][], ? super T[][]> converter) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.ARRAY_OF_ARRAY(this.type.getRawClass())));
    }


	public Level0ArrayOfArrayOperator<T> evalAsArrayOfArray(final IEvaluator<? extends T[][], ? super T[][]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.ARRAY_OF_ARRAY(this.type.getRawClass())));
    }


	public Level0ArrayOfArrayOperator<T> execAsArrayOfArray(final IFunction<? extends T[][], ? super T[][]> function) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.ARRAY_OF_ARRAY(this.type.getRawClass())));
    }


    public <X> Level0ArrayOfArrayOperator<X> convertAsArrayOfArrayOf(final Type<X> newType, final IConverter<X[][], ? super T[][]> converter) {
        return new Level0ArrayOfArrayOperatorImpl<X>(newType, getTarget().execute(converter, Normalisation.ARRAY_OF_ARRAY(newType.getRawClass())));
    }


    public <X> Level0ArrayOfArrayOperator<X> evalAsArrayOfArrayOf(final Type<X> newType, final IEvaluator<X[][], ? super T[][]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<X>(newType, getTarget().execute(eval, Normalisation.ARRAY_OF_ARRAY(newType.getRawClass())));
    }


    public <X> Level0ArrayOfArrayOperator<X> execAsArrayOfArrayOf(final Type<X> newType, final IFunction<X[][], ? super T[][]> function) {
        return new Level0ArrayOfArrayOperatorImpl<X>(newType, getTarget().execute(function, Normalisation.ARRAY_OF_ARRAY(newType.getRawClass())));
    }


    public <X> Level0GenericUniqOperator<X> convert(final IConverter<X, ? super T[][]> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X, ? super T[][]> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super T[][]> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0ArrayOfArrayOperator<T> replaceWith(final T[][] replacement) {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().replaceWith(replacement));
    }


    public Level0ArrayOfArrayOperator<T> replaceIfNullWith(final T[][] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    


    
    
    
    
    
    
}

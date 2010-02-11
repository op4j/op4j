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
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
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
public class Level0ListOfArrayOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0ListOfArrayOperator<T>  {


    private final Type<T> type;

    
    public Level0ListOfArrayOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfArrayOperator<T> add(final T[] newElement) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.Add<T[]>(NormalisationUtils.normaliseArray(newElement, this.type.getRawClass()))));
    }

    public Level0ListOfArrayOperator<T> addAll(final T[]... newElements) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.Add<T[]>(NormalisationUtils.normaliseArrays(newElements, this.type.getRawClass()))));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfArrayOperator<T> insert(final int position, final T[] newElement) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.Insert<T[]>(position, NormalisationUtils.normaliseArray(newElement, this.type.getRawClass()))));
    }

    public Level0ListOfArrayOperator<T> insertAll(final int position, final T[]... newElements) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.Insert<T[]>(position, NormalisationUtils.normaliseArrays(newElements, this.type.getRawClass()))));
    }


    public Level0ListOfArrayOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.AddAll<T[]>(NormalisationUtils.normaliseArrays(collection, this.type.getRawClass()))));
    }


    public Level0ListOfArrayOperator<T> distinct() {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.Distinct<T[]>()));
    }


    public Level0ListOperator<T> flatten() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.FlattenListOfArrays<T>()));
    }


    public Level1ListOfArrayElementsOperator<T> forEach() {
        return new Level1ListOfArrayElementsOperatorImpl<T>(this.type, getTarget().iterate(Structure.LIST));
    }


    public Level0ListOfArrayOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.RemoveAllIndexes<T[]>(indexes)));
    }


    public Level0ListOfArrayOperator<T> removeAllEqual(final T[]... values) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.RemoveAllEqual<T[]>(values)));
    }


    public Level0ListOfArrayOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.RemoveAllTrue<T[]>(eval)));
    }

    public Level0ListOfArrayOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.RemoveAllFalse<T[]>(eval)));
    }

    public Level0ListOfArrayOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T[]>(eval)));
    }

    public Level0ListOfArrayOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T[]>(eval)));
    }


    public Level0ListOfArrayOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T[]>(eval)));
    }


    public Level0ListOfArrayOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T[]>(eval)));
    }


    public Level0ListOfArrayOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T[]>(indexes)));
    }


    public Level0ListOfArrayOperator<T> removeAllNull() {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.RemoveAllNull<T[]>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOfArrayOperator<T> sort() {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfArrayOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(new ListFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArrayOf(final Type<T> newType) {
        return new Level0ArrayOfArrayOperatorImpl<T>(newType, getTarget().execute(new ToArray.FromCollection<T[]>(Types.arrayOf(newType))));
    }


    public Level0ArrayOfListOperator<T> toArrayOfList() {
        return toListOfList().toArrayOfList();
    }


    public <K> Level0ArrayOfMapOperator<K, T> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return toListOfMap(keyEval).toArrayOfMap();
    }


    public <K, V> Level0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return toListOfMap(mapBuild).toArrayOfMap();
    }


    public Level0ArrayOfSetOperator<T> toArrayOfSet() {
        return toListOfSet().toArrayOfSet();
    }


    public Level0ListOfListOperator<T> toListOfList() {
        return forEach().toList().endFor();
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


    public Level0SetOfArrayOperator<T> toSetOfArrayOf(final Type<T> newType) {
        return new Level0SetOfArrayOperatorImpl<T>(newType, getTarget().execute(new ToSet.FromCollection<T[]>()));
    }


    public Level0SetOfListOperator<T> toSetOfList() {
        return toListOfList().toSetOfList();
    }


    public <K> Level0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return toListOfMap(keyEval).toSetOfMap();
    }


    public <K, V> Level0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return toListOfMap(mapBuild).toSetOfMap();
    }


    public Level0SetOfSetOperator<T> toSetOfSet() {
        return toListOfSet().toSetOfSet();
    }


    public Level0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return toListOfMap().toArrayOfMap();
    }


    public Level0ListOfMapOperator<T, T> toListOfMap() {
        return forEach().toMap().endFor();
    }


    public Level0SetOfMapOperator<T, T> toSetOfMap() {
        return toListOfMap().toSetOfMap();
    }


    @SuppressWarnings("unchecked")
    public List<T[]> get() {
        return (List<T[]>) getTarget().get();
    }


    public Level0GenericUniqOperator<List<T[]>> generic() {
        return new Level0GenericUniqOperatorImpl<List<T[]>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
	public <X> Level0ListOfArrayOperator<X> asListOfArrayOf(final Type<X> newType) {
        return generic().asListOfArrayOf(newType);
    }


    public Level0ListOfArrayOperator<?> asListOfArrayOfUnknown() {
        return asListOfArrayOf(Types.OBJECT);
    }


    public Level0ListOfArraySelectedOperator<T> ifIndex(final int... indexes) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level0ListOfArraySelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level0ListOfArraySelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T> ifNotNull() {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level0ListOfArraySelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T> ifNull() {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level0ListOfArraySelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level0ListOfArrayOperator<T> convertAsListOfArray(final IConverter<? extends List<? extends T[]>, ? super List<T[]>> converter) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.LIST_OF_ARRAY(this.type.getRawClass())));
    }


    public Level0ListOfArrayOperator<T> evalAsListOfArray(final IEvaluator<? extends List<? extends T[]>, ? super List<T[]>> eval) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.LIST_OF_ARRAY(this.type.getRawClass())));
    }


    public Level0ListOfArrayOperator<T> execAsListOfArray(final IFunction<? extends List<? extends T[]>, ? super List<T[]>> function) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.LIST_OF_ARRAY(this.type.getRawClass())));
    }


    public <X> Level0ListOfArrayOperator<X> convertAsListOfArrayOf(final Type<X> newType, final IConverter<? extends List<X[]>, ? super List<T[]>> converter) {
        return new Level0ListOfArrayOperatorImpl<X>(newType, getTarget().execute(converter, Normalisation.LIST_OF_ARRAY(newType.getRawClass())));
    }


    public <X> Level0ListOfArrayOperator<X> evalAsListOfArrayOf(final Type<X> newType, final IEvaluator<? extends List<X[]>, ? super List<T[]>> eval) {
        return new Level0ListOfArrayOperatorImpl<X>(newType, getTarget().execute(eval, Normalisation.LIST_OF_ARRAY(newType.getRawClass())));
    }


    public <X> Level0ListOfArrayOperator<X> execAsListOfArrayOf(final Type<X> newType, final IFunction<? extends List<X[]>, ? super List<T[]>> function) {
        return new Level0ListOfArrayOperatorImpl<X>(newType, getTarget().execute(function, Normalisation.LIST_OF_ARRAY(newType.getRawClass())));
    }


    public <X> Level0GenericUniqOperator<X> convert(final IConverter<X, ? super List<T[]>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X, ? super List<T[]>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super List<T[]>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0ListOfArrayOperator<T> replaceWith(final List<T[]> replacement) {
        return new Level0ListOfArrayOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.LIST_OF_ARRAY(this.type.getRawClass())));
    }


    public Level0ListOfArrayOperator<T> replaceIfNullWith(final List<T[]> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
    
}

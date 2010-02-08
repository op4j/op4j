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
package org.op4j.operators.impl.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.arrayofarray.Level0ArrayOfArrayOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.listofarray.Level0ListOfArrayOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
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
import org.op4j.operators.intf.setofarray.Level0SetOfArraySelectedOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsOperator;
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
public class Level0SetOfArrayOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0SetOfArrayOperator<T>  {

    
    public Level0SetOfArrayOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfArrayOperator<T> add(final T[] newElement) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T[]>(NormalisationUtils.normaliseArray(newElement))));
    }

    public Level0SetOfArrayOperator<T> addAll(final T[]... newElements) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T[]>(NormalisationUtils.normaliseArrays(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfArrayOperator<T> insert(final int position, final T[] newElement) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T[]>(position, NormalisationUtils.normaliseArray(newElement))));
    }

    public Level0SetOfArrayOperator<T> insertAll(final int position, final T[]... newElements) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T[]>(position, NormalisationUtils.normaliseArrays(newElements))));
    }


    public Level0SetOfArrayOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T[]>(NormalisationUtils.normaliseArrays(collection))));
    }


    public Level0SetOperator<T> flatten() {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.FlattenSetOfArrays<T>()));
    }


    public Level1SetOfArrayElementsOperator<T> forEach() {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().iterate(Structure.SET));
    }


    public Level0SetOfArrayOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T[]>(indexes)));
    }


    public Level0SetOfArrayOperator<T> removeAllEqual(final T[]... values) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<T[]>(values)));
    }


    public Level0SetOfArrayOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<T[]>(eval)));
    }

    public Level0SetOfArrayOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<T[]>(eval)));
    }

    public Level0SetOfArrayOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T[]>(eval)));
    }

    public Level0SetOfArrayOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T[]>(eval)));
    }


    public Level0SetOfArrayOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T[]>(eval)));
    }


    public Level0SetOfArrayOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T[]>(eval)));
    }


    public Level0SetOfArrayOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T[]>(indexes)));
    }


    public Level0SetOfArrayOperator<T> removeAllNull() {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<T[]>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0SetOfArrayOperator<T> sort() {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfArrayOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArrayOf(final Type<T> type) {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ToArray.FromCollection<T[]>(Types.arrayOf(type))));
    }


    public Level0ArrayOfListOperator<T> toArrayOfList() {
        return toSetOfList().toArrayOfList();
    }


    public <K> Level0ArrayOfMapOperator<K, T> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return toSetOfMap(keyEval).toArrayOfMap();
    }


    public <K, V> Level0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return toSetOfMap(mapBuild).toArrayOfMap();
    }


    public Level0ArrayOfSetOperator<T> toArrayOfSet() {
        return toSetOfSet().toArrayOfSet();
    }


    public Level0ListOfArrayOperator<T> toListOfArrayOf(final Type<T> type) {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ToList.FromCollection<T[]>()));
    }


    public Level0ListOfListOperator<T> toListOfList() {
        return toSetOfList().toListOfList();
    }


    public <K> Level0ListOfMapOperator<K, T> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return toSetOfMap(keyEval).toListOfMap();
    }


    public <K, V> Level0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return toSetOfMap(mapBuild).toListOfMap();
    }


    public Level0ListOfSetOperator<T> toListOfSet() {
        return toSetOfSet().toListOfSet();
    }


    public Level0SetOfListOperator<T> toSetOfList() {
        return forEach().toList().endFor();
    }


    public <K> Level0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> Level0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public Level0SetOfSetOperator<T> toSetOfSet() {
        return forEach().toSet().endFor();
    }


    public Level0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return toSetOfMap().toArrayOfMap();
    }


    public Level0ListOfMapOperator<T, T> toListOfMap() {
        return toSetOfMap().toListOfMap();
    }


    public Level0SetOfMapOperator<T, T> toSetOfMap() {
        return forEach().toMap().endFor();
    }


    @SuppressWarnings("unchecked")
    public Set<T[]> get() {
        return (Set<T[]>) getTarget().get();
    }


    public Level0GenericUniqOperator<Set<T[]>> generic() {
        return new Level0GenericUniqOperatorImpl<Set<T[]>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> Level0SetOfArrayOperator<X> asSetOfArrayOf(final Type<X> type) {
        return generic().asSetOfArrayOf(type);
    }


    public Level0SetOfArrayOperator<?> asSetOfArrayOfUnknown() {
        return asSetOfArrayOf(Types.OBJECT);
    }


    public Level0SetOfArraySelectedOperator<T> ifIndex(final int... indexes) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level0SetOfArraySelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level0SetOfArraySelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0SetOfArraySelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0SetOfArraySelectedOperator<T> ifNotNull() {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0SetOfArraySelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetOfArraySelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0SetOfArraySelectedOperator<T> ifNull() {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0SetOfArraySelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0SetOfArraySelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0SetOfArrayOperator<X> convertAsSetOfArray(final IConverter<? extends Set<X[]>, ? super Set<T[]>> converter) {
        return new Level0SetOfArrayOperatorImpl<X>(getTarget().execute(converter, Normalisation.SET_OF_ARRAY));
    }


    public <X> Level0SetOfArrayOperator<X> evalAsSetOfArray(final IEvaluator<? extends Set<X[]>, ? super Set<T[]>> eval) {
        return new Level0SetOfArrayOperatorImpl<X>(getTarget().execute(eval, Normalisation.SET_OF_ARRAY));
    }


    public <X> Level0SetOfArrayOperator<X> execAsSetOfArray(final IFunction<? extends Set<X[]>, ? super Set<T[]>> function) {
        return new Level0SetOfArrayOperatorImpl<X>(getTarget().execute(function, Normalisation.SET_OF_ARRAY));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Set<T[]>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Set<T[]>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T[]>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0SetOfArrayOperator<T> replaceWith(final Set<T[]> replacement) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level0SetOfArrayOperator<T> replaceIfNullWith(final Set<T[]> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
    
    
    
    
}

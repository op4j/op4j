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
package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

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
import org.op4j.operators.impl.listofset.Level0ListOfSetOperatorImpl;
import org.op4j.operators.impl.setofset.Level0SetOfSetOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
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
public class Level0ArrayOfSetOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0ArrayOfSetOperator<T>  {

    
    public Level0ArrayOfSetOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetOperator<T> add(final Set<T> newElement) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<Set<T>>(NormalisationUtils.normaliseSet(newElement))));
    }

    public Level0ArrayOfSetOperator<T> addAll(final Set<T>... newElements) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<Set<T>>(NormalisationUtils.normaliseSets(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetOperator<T> insert(final int position, final Set<T> newElement) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<Set<T>>(position, NormalisationUtils.normaliseSet(newElement))));
    }

    public Level0ArrayOfSetOperator<T> insertAll(final int position, final Set<T>... newElements) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<Set<T>>(position, NormalisationUtils.normaliseSets(newElements))));
    }


    public Level0ArrayOfSetOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<Set<T>>(NormalisationUtils.normaliseSets(collection))));
    }


    public Level0ArrayOfSetOperator<T> distinct() {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<Set<T>>()));
    }


    public Level0ArrayOperator<T> flatten(final Type<T> type) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.FlattenArrayOfSets<T>(type)));
    }


    public Level1ArrayOfSetElementsOperator<T> forEach() {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().iterate(Structure.ARRAY));
    }


    public Level0ArrayOfSetOperator<T> removeAllIndexes(final int... indices) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<Set<T>>(indices)));
    }


    public Level0ArrayOfSetOperator<T> removeAllEqual(final Set<T>... values) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<Set<T>>(values)));
    }


    public Level0ArrayOfSetOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<Set<T>>(eval)));
    }

    public Level0ArrayOfSetOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<Set<T>>(eval)));
    }

    public Level0ArrayOfSetOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<Set<T>>(eval)));
    }

    public Level0ArrayOfSetOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<Set<T>>(eval)));
    }


    public Level0ArrayOfSetOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<Set<T>>(eval)));
    }


    public Level0ArrayOfSetOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<Set<T>>(eval)));
    }


    public Level0ArrayOfSetOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<Set<T>>(indices)));
    }



    public Level0ArrayOfSetOperator<T> removeAllNull() {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNull<Set<T>>()));
    }

    
    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetOperator<T> sort() {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level0ArrayOfSetOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArrayOf(final Type<T> type) {
        return forEach().toArrayOf(type).endFor();
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


    public Level0ListOfArrayOperator<T> toListOfArrayOf(final Type<T> type) {
        return toArrayOfArrayOf(type).toListOfArrayOf(type);
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
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ToList.FromArray<Set<T>>()));
    }


    public Level0SetOfArrayOperator<T> toSetOfArrayOf(final Type<T> type) {
        return toArrayOfArrayOf(type).toSetOfArrayOf(type);
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
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new ToSet.FromArray<Set<T>>()));
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
    public Set<T>[] get() {
        return (Set<T>[]) getTarget().get();
    }


    public Level0GenericUniqOperator<Set<T>[]> generic() {
        return new Level0GenericUniqOperatorImpl<Set<T>[]>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
	public <X> Level0ArrayOfSetOperator<X> asArrayOfSetOf(final Type<X> type) {
        return generic().asArrayOfSetOf(type);
    }


    public Level0ArrayOfSetOperator<?> asArrayOfSetOfUnknown() {
        return asArrayOfSetOf(Types.OBJECT);
    }


    public Level0ArrayOfSetSelectedOperator<T> ifIndex(final int... indices) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level0ArrayOfSetSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level0ArrayOfSetSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0ArrayOfSetSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0ArrayOfSetSelectedOperator<T> ifNotNull() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0ArrayOfSetSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArrayOfSetSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ArrayOfSetSelectedOperator<T> ifNull() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0ArrayOfSetSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ArrayOfSetSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0ArrayOfSetOperator<X> convert(final IConverter<? extends Set<X>[], ? super Set<T>[]> converter) {
        return new Level0ArrayOfSetOperatorImpl<X>(getTarget().execute(converter, Normalisation.ARRAY_OF_SET));
    }


    public <X> Level0ArrayOfSetOperator<X> eval(final IEvaluator<? extends Set<X>[], ? super Set<T>[]> eval) {
        return new Level0ArrayOfSetOperatorImpl<X>(getTarget().execute(eval, Normalisation.ARRAY_OF_SET));
    }


    public <X> Level0ArrayOfSetOperator<X> exec(final IFunction<? extends Set<X>[], ? super Set<T>[]> function) {
        return new Level0ArrayOfSetOperatorImpl<X>(getTarget().execute(function, Normalisation.ARRAY_OF_SET));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Set<T>[]> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Set<T>[]> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T>[]> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0ArrayOfSetOperator<T> replaceWith(final Set<T>[] replacement) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level0ArrayOfSetOperator<T> replaceIfNullWith(final Set<T>[] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
    
    
}

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
package org.op4j.operators.impl.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
import org.op4j.operators.impl.arrayofset.Level0ArrayOfSetOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.setofset.Level0SetOfSetOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetSelectedOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
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
public class Level0ListOfSetOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0ListOfSetOperator<T>  {

    
    public Level0ListOfSetOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfSetOperator<T> add(final Set<T> newElement) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<Set<T>>(NormalisationUtils.normaliseSet(newElement))));
    }

    public Level0ListOfSetOperator<T> addAll(final Set<T>... newElements) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<Set<T>>(NormalisationUtils.normaliseSets(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfSetOperator<T> insert(final int position, final Set<T> newElement) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<Set<T>>(position, NormalisationUtils.normaliseSet(newElement))));
    }

    public Level0ListOfSetOperator<T> insertAll(final int position, final Set<T>... newElements) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<Set<T>>(position, NormalisationUtils.normaliseSets(newElements))));
    }


    public Level0ListOfSetOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<Set<T>>(NormalisationUtils.normaliseSets(collection))));
    }


    public Level0ListOfSetOperator<T> distinct() {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<Set<T>>()));
    }


    public Level0ListOperator<T> flatten() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.FlattenListOfSets<T>()));
    }


    public Level1ListOfSetElementsOperator<T> forEach() {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().iterate(Structure.LIST));
    }


    public Level0ListOfSetOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<Set<T>>(indexes)));
    }


    public Level0ListOfSetOperator<T> removeAllEqual(final Set<T>... values) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<Set<T>>(values)));
    }


    public Level0ListOfSetOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<Set<T>>(eval)));
    }

    public Level0ListOfSetOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<Set<T>>(eval)));
    }

    public Level0ListOfSetOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<Set<T>>(eval)));
    }

    public Level0ListOfSetOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<Set<T>>(eval)));
    }


    public Level0ListOfSetOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<Set<T>>(eval)));
    }


    public Level0ListOfSetOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<Set<T>>(eval)));
    }


    public Level0ListOfSetOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<Set<T>>(indexes)));
    }


    public Level0ListOfSetOperator<T> removeAllNull() {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<Set<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOfSetOperator<T> sort() {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfSetOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArrayOf(final Type<T> type) {
        return toListOfArrayOf(type).toArrayOfArrayOf(type);
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


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetOperator<T> toArrayOfSet() {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ToArray.FromCollection<Set<T>>((Type<Set<T>>)(Type<?>)Types.SET_OF_UNKNOWN)));
    }


    public Level0ListOfArrayOperator<T> toListOfArrayOf(final Type<T> type) {
        return forEach().toArrayOf(type).endFor();
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


    public Level0SetOfArrayOperator<T> toSetOfArrayOf(final Type<T> type) {
        return toListOfArrayOf(type).toSetOfArrayOf(type);
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
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new ToSet.FromCollection<Set<T>>()));
    }


    public Level0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return toListOfMap().toArrayOfMap();
    }


    public Level0ListOfMapOperator<T, T> toListOfMap() {
        return forEach().toMap().endFor();
    }


    public Level0SetOfMapOperator<T, T> toSetOfMap() {
        return toArrayOfMap().toSetOfMap();
    }


    @SuppressWarnings("unchecked")
    public List<Set<T>> get() {
        return (List<Set<T>>) getTarget().get();
    }


    public Level0GenericUniqOperator<List<Set<T>>> generic() {
        return new Level0GenericUniqOperatorImpl<List<Set<T>>>(getTarget());
    }

    
    
    
    
    
    
	public <X> Level0ListOfSetOperator<X> asListOfSetOf(final Type<X> type) {
        return generic().asListOfSetOf(type);
    }


    public Level0ListOfSetOperator<?> asListOfSetOfUnknown() {
        return asListOfSetOf(Types.OBJECT);
    }


    public Level0ListOfSetSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level0ListOfSetSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level0ListOfSetSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T> ifNotNull() {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0ListOfSetSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T> ifNull() {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0ListOfSetSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0ListOfSetOperator<X> convertAsListOfSet(final IConverter<? extends List<? extends Set<X>>, ? super List<Set<T>>> converter) {
        return new Level0ListOfSetOperatorImpl<X>(getTarget().execute(converter, Normalisation.LIST_OF_SET));
    }


    public <X> Level0ListOfSetOperator<X> evalAsListOfSet(final IEvaluator<? extends List<? extends Set<X>>, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetOperatorImpl<X>(getTarget().execute(eval, Normalisation.LIST_OF_SET));
    }


    public <X> Level0ListOfSetOperator<X> execAsListOfSet(final IFunction<? extends List<? extends Set<X>>, ? super List<Set<T>>> function) {
        return new Level0ListOfSetOperatorImpl<X>(getTarget().execute(function, Normalisation.LIST_OF_SET));
    }


    public <X> Level0GenericUniqOperator<X> convert(final IConverter<X, ? super List<Set<T>>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X, ? super List<Set<T>>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super List<Set<T>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0ListOfSetOperator<T> replaceWith(final List<Set<T>> replacement) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.LIST_OF_SET));
    }


    public Level0ListOfSetOperator<T> replaceIfNullWith(final List<Set<T>> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    public <X> Level0ListOfSetOperator<X> mapMap(final IFunction<X, ? super T> function) {
        return forEach().map(function).endFor();
    }
    
    
    
    
}

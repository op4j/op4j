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
import org.op4j.operators.impl.arrayofset.Level0ArrayOfSetOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.listofset.Level0ListOfSetOperatorImpl;
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
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetSelectedOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
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
public class Level0SetOfSetOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0SetOfSetOperator<T>  {

    
    public Level0SetOfSetOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfSetOperator<T> add(final Set<T> newElement) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<Set<T>>(NormalisationUtils.normaliseSet(newElement))));
    }

    public Level0SetOfSetOperator<T> addAll(final Set<T>... newElements) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<Set<T>>(NormalisationUtils.normaliseSets(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfSetOperator<T> insert(final int position, final Set<T> newElement) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<Set<T>>(position, NormalisationUtils.normaliseSet(newElement))));
    }

    public Level0SetOfSetOperator<T> insertAll(final int position, final Set<T>... newElements) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<Set<T>>(position, NormalisationUtils.normaliseSets(newElements))));
    }


    public Level0SetOfSetOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<Set<T>>(NormalisationUtils.normaliseSets(collection))));
    }


    public Level0SetOperator<T> flatten() {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.FlattenSetOfSets<T>()));
    }


    public Level1SetOfSetElementsOperator<T> forEach() {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().iterate(Structure.SET));
    }


    public Level0SetOfSetOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<Set<T>>(indexes)));
    }


    public Level0SetOfSetOperator<T> removeAllEqual(final Set<T>... values) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<Set<T>>(values)));
    }


    public Level0SetOfSetOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<Set<T>>(eval)));
    }

    public Level0SetOfSetOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<Set<T>>(eval)));
    }

    public Level0SetOfSetOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<Set<T>>(eval)));
    }

    public Level0SetOfSetOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<Set<T>>(eval)));
    }


    public Level0SetOfSetOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<Set<T>>(eval)));
    }


    public Level0SetOfSetOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<Set<T>>(eval)));
    }


    public Level0SetOfSetOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<Set<T>>(indexes)));
    }


    public Level0SetOfSetOperator<T> removeAllNull() {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<Set<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0SetOfSetOperator<T> sort() {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfSetOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArrayOf(final Type<T> type) {
        return toSetOfArrayOf(type).toArrayOfArrayOf(type);
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


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetOperator<T> toArrayOfSet() {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ToArray.FromCollection<Set<T>>((Type<Set<T>>)(Type<?>)Types.SET_OF_UNKNOWN)));
    }


    public Level0ListOfArrayOperator<T> toListOfArrayOf(final Type<T> type) {
        return toSetOfArrayOf(type).toListOfArrayOf(type);
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
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ToList.FromCollection<Set<T>>()));
    }


    public Level0SetOfArrayOperator<T> toSetOfArrayOf(final Type<T> type) {
        return forEach().toArrayOf(type).endFor();
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
    public Set<Set<T>> get() {
        return (Set<Set<T>>) getTarget().get();
    }


    public Level0GenericUniqOperator<Set<Set<T>>> generic() {
        return new Level0GenericUniqOperatorImpl<Set<Set<T>>>(getTarget());
    }

    
    
    
    
    
    
    
    
	public <X> Level0SetOfSetOperator<X> asSetOfSetOf(final Type<X> type) {
        return generic().asSetOfSetOf(type);
    }


    public Level0SetOfSetOperator<?> asSetOfSetOfUnknown() {
        return asSetOfSetOf(Types.OBJECT);
    }


    public Level0SetOfSetSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level0SetOfSetSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level0SetOfSetSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T> ifNotNull() {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0SetOfSetSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T> ifNull() {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0SetOfSetSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0SetOfSetOperator<X> convert(final IConverter<? extends Set<? extends Set<X>>, ? super Set<Set<T>>> converter) {
        return new Level0SetOfSetOperatorImpl<X>(getTarget().execute(converter, Normalisation.SET_OF_SET));
    }


    public <X> Level0SetOfSetOperator<X> eval(final IEvaluator<? extends Set<? extends Set<X>>, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetOperatorImpl<X>(getTarget().execute(eval, Normalisation.SET_OF_SET));
    }


    public <X> Level0SetOfSetOperator<X> exec(final IFunction<? extends Set<? extends Set<X>>, ? super Set<Set<T>>> function) {
        return new Level0SetOfSetOperatorImpl<X>(getTarget().execute(function, Normalisation.SET_OF_SET));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Set<Set<T>>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Set<Set<T>>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<Set<T>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0SetOfSetOperator<T> replaceWith(final Set<Set<T>> replacement) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level0SetOfSetOperator<T> replaceIfNullWith(final Set<Set<T>> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
    
}

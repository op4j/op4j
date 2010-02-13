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
package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
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
import org.op4j.operators.impl.arrayoflist.Level0ArrayOfListOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.listoflist.Level0ListOfListOperatorImpl;
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
import org.op4j.operators.intf.setoflist.Level0SetOfListSelectedOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
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
public class Level0SetOfListOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0SetOfListOperator<T>  {

    
    public Level0SetOfListOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfListOperator<T> add(final List<T> newElement) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<List<T>>(NormalisationUtils.normaliseList(newElement))));
    }

    public Level0SetOfListOperator<T> addAll(final List<T>... newElements) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<List<T>>(NormalisationUtils.normaliseLists(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfListOperator<T> insert(final int position, final List<T> newElement) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<List<T>>(position, NormalisationUtils.normaliseList(newElement))));
    }

    public Level0SetOfListOperator<T> insertAll(final int position, final List<T>... newElements) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<List<T>>(position, NormalisationUtils.normaliseLists(newElements))));
    }


    public Level0SetOfListOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<List<T>>(NormalisationUtils.normaliseLists(collection))));
    }


    public Level0SetOperator<T> flatten() {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.FlattenSetOfLists<T>()));
    }


    public Level1SetOfListElementsOperator<T> forEach() {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().iterate(Structure.SET));
    }


    public Level0SetOfListOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<List<T>>(indexes)));
    }


    public Level0SetOfListOperator<T> removeAllEqual(final List<T>... values) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<List<T>>(values)));
    }


    public Level0SetOfListOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<List<T>>(eval)));
    }

    public Level0SetOfListOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<List<T>>(eval)));
    }

    public Level0SetOfListOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<List<T>>(eval)));
    }

    public Level0SetOfListOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<List<T>>(eval)));
    }


    public Level0SetOfListOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<List<T>>(eval)));
    }


    public Level0SetOfListOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<List<T>>(eval)));
    }


    public Level0SetOfListOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<List<T>>(indexes)));
    }


    public Level0SetOfListOperator<T> removeAllNull() {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<List<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0SetOfListOperator<T> sort() {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfListOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<List<T>>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArrayOf(final Type<T> type) {
        return toSetOfArrayOf(type).toArrayOfArrayOf(type);
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfListOperator<T> toArrayOfList() {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ToArray.FromCollection<List<T>>((Type<List<T>>)(Type<?>)Types.LIST_OF_UNKNOWN)));
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
        return toSetOfArrayOf(type).toListOfArrayOf(type);
    }


    public Level0ListOfListOperator<T> toListOfList() {
        return new Level0ListOfListOperatorImpl<T>(getTarget().execute(new ToList.FromCollection<List<T>>()));
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


    public Level0SetOfArrayOperator<T> toSetOfArrayOf(final Type<T> type) {
        return forEach().toArrayOf(type).endFor();
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
    public Set<List<T>> get() {
        return (Set<List<T>>) getTarget().get();
    }


    public Level0GenericUniqOperator<Set<List<T>>> generic() {
        return new Level0GenericUniqOperatorImpl<Set<List<T>>>(getTarget());
    }

    
    
    
    
    
    
    
    
	public <X> Level0SetOfListOperator<X> asSetOfListOf(final Type<X> type) {
        return generic().asSetOfListOf(type);
    }


    public Level0SetOfListOperator<?> asSetOfListOfUnknown() {
        return asSetOfListOf(Types.OBJECT);
    }


    public Level0SetOfListSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level0SetOfListSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level0SetOfListSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super Set<List<T>>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0SetOfListSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super Set<List<T>>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0SetOfListSelectedOperator<T> ifNotNull() {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0SetOfListSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<List<T>>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetOfListSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<List<T>>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0SetOfListSelectedOperator<T> ifNull() {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0SetOfListSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<List<T>>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0SetOfListSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<List<T>>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0SetOfListOperator<X> convertAsSetOfList(final IConverter<? extends Set<? extends List<X>>, ? super Set<List<T>>> converter) {
        return new Level0SetOfListOperatorImpl<X>(getTarget().execute(converter, Normalisation.SET_OF_LIST));
    }


    public <X> Level0SetOfListOperator<X> evalAsSetOfList(final IEvaluator<? extends Set<? extends List<X>>, ? super Set<List<T>>> eval) {
        return new Level0SetOfListOperatorImpl<X>(getTarget().execute(eval, Normalisation.SET_OF_LIST));
    }


    public <X> Level0SetOfListOperator<X> execAsSetOfList(final IFunction<? extends Set<? extends List<X>>, ? super Set<List<T>>> function) {
        return new Level0SetOfListOperatorImpl<X>(getTarget().execute(function, Normalisation.SET_OF_LIST));
    }


    public <X> Level0GenericUniqOperator<X> convert(final IConverter<X, ? super Set<List<T>>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Set<List<T>>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<List<T>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0SetOfListOperator<T> replaceWith(final Set<List<T>> replacement) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.SET_OF_LIST));
    }


    public Level0SetOfListOperator<T> replaceIfNullWith(final Set<List<T>> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }

    
    public <X> Level0SetOfListOperator<X> mapMap(final IFunction<X, ? super T> function) {
        return forEach().map(function).endFor();
    }

    
    
    
    
    
}

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
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.list.Level0ListOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.select.ISelector;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ListOfSetOperator<T> extends Operator
        implements ILevel0ListOfSetOperator<T>  {

    
    public Level0ListOfSetOperator(final Target target) {
        super(target);
    }


    public ILevel0ListOfSetOperator<T> add(final Set<T>... newElements) {
        return new Level0ListOfSetOperator<T>(getTarget().execute(new ListFuncs.Add<Set<T>>(newElements)));
    }


    public ILevel0ListOfSetOperator<T> insert(final int position, final Set<T>... newElements) {
        return new Level0ListOfSetOperator<T>(getTarget().execute(new ListFuncs.Insert<Set<T>>(position, newElements)));
    }


    public ILevel0ListOfSetOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0ListOfSetOperator<T>(getTarget().execute(new ListFuncs.AddAll<Set<T>>(collection)));
    }


    public ILevel0ListOfSetOperator<T> distinct() {
        return new Level0ListOfSetOperator<T>(getTarget().execute(new ListFuncs.Distinct<Set<T>>()));
    }


    public ILevel0ListOperator<T> flatten() {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.FlattenListOfSets<T>()));
    }


    public ILevel1ListOfSetElementsOperator<T> forEach() {
        return new Level1ListOfSetElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1ListOfSetElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel1ListOfSetElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().iterate(eval));
    }


    public ILevel1ListOfSetElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1ListOfSetElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel1ListOfSetElementsOperator<T> forEachSelected(final ISelector<Set<T>> selector) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel1ListOfSetElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel1ListOfSetElementsOperator<T> forEachNotNull() {
        return new Level1ListOfSetElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1ListOfSetElementsOperator<T> forEachNull() {
        return new Level1ListOfSetElementsOperator<T>(getTarget().iterateNull());
    }


    public <X> ILevel0ListOfSetOperator<X> of(final Type<X> of) {
        return new Level0ListOfSetOperator<X>(getTarget());
    }


    public ILevel0ListOfSetOperator<?> raw() {
        return new Level0ListOfSetOperator<T>(getTarget());
    }


    public ILevel0ListOfSetOperator<T> removeIndexes(final int... indices) {
        return new Level0ListOfSetOperator<T>(getTarget().execute(new ListFuncs.RemoveIndexes<Set<T>>(indices)));
    }


    public ILevel0ListOfSetOperator<T> removeEquals(final Set<T>... values) {
        return new Level0ListOfSetOperator<T>(getTarget().execute(new ListFuncs.RemoveEquals<Set<T>>(values)));
    }


    public ILevel0ListOfSetOperator<T> removeMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperator<T>(getTarget().execute(new ListFuncs.RemoveMatching<Set<T>>(eval)));
    }


    public ILevel0ListOfSetOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperator<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<Set<T>>(eval)));
    }


    public ILevel0ListOfSetOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperator<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<Set<T>>(eval)));
    }


    public ILevel0ListOfSetOperator<T> removeSelected(final ISelector<Set<T>> selector) {
        return new Level0ListOfSetOperator<T>(getTarget().execute(new ListFuncs.RemoveSelected<Set<T>>(selector)));
    }


    public ILevel0ListOfSetOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ListOfSetOperator<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<Set<T>>(indices)));
    }


    public ILevel0ListOfSetOperator<T> removeNulls() {
        return new Level0ListOfSetOperator<T>(getTarget().execute(new ListFuncs.RemoveNulls<Set<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0ListOfSetOperator<T> sort() {
        return new Level0ListOfSetOperator<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public ILevel0ListOfSetOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0ListOfSetOperator<T>(getTarget().execute(new ListFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return Op.onArrayOfArray(Op.onList(forEach().toArray(of).get()).toArray(Types.arrayOf(of)).get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfListOperator<T> toArrayOfList() {
        return Op.onArrayOfList(Op.onList(forEach().toList().get()).toArray((Type<List<T>>)((Type<?>)Types.LIST_OF_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K> ILevel0ArrayOfMapOperator<K, T> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onArrayOfMap(Op.onList(forEach().toMap(keyEval).get()).toArray((Type<Map<K, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K, V> ILevel0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onArrayOfMap(Op.onList(forEach().toMap(mapBuild).get()).toArray((Type<Map<K, V>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfSetOperator<T> toArrayOfSet() {
        return Op.onArrayOfSet(Op.onList(get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get());
    }


    public ILevel0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return forEach().toArray(of).endFor();
    }


    public ILevel0ListOfListOperator<T> toListOfList() {
        return forEach().toList().endFor();
    }


    public <K> ILevel0ListOfMapOperator<K, T> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public ILevel0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(of, Op.onList(forEach().toArray(of).get()).toSet().get());
    }


    public ILevel0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(Op.onList(forEach().toList().get()).toSet().get());
    }


    public <K> ILevel0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onSetOfMap(Op.onList(forEach().toMap(keyEval).get()).toSet().get());
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onSetOfMap(Op.onList(forEach().toMap(mapBuild).get()).toSet().get());
    }


    public ILevel0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(Op.onList(get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return Op.onArrayOfMap(Op.onList(forEach().toMap().get()).toArray((Type<Map<T, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    public ILevel0ListOfMapOperator<T, T> toListOfMap() {
        return forEach().toMap().endFor();
    }


    public ILevel0SetOfMapOperator<T, T> toSetOfMap() {
        return Op.onSetOfMap(Op.onList(forEach().toMap().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
    public List<Set<T>> get() {
        return (List<Set<T>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<List<Set<T>>> generic() {
        return new Level0GenericUniqOperator<List<Set<T>>>(getTarget());
    }

    
    
    
    
    
    
	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super List<Set<T>>> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super List<Set<T>>> eval) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super List<Set<T>>> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}

    
    
}

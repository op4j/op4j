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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.SetFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.util.VarArgsUtil;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0SetOfSetOperator<T> extends Operator
        implements ILevel0SetOfSetOperator<T>  {

    
    public Level0SetOfSetOperator(final Target target) {
        super(target);
    }


    public ILevel0SetOfSetOperator<T> add(final Set<T>... newElements) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.Add<Set<T>>(newElements)));
    }


    public ILevel0SetOfSetOperator<T> insert(final int position, final Set<T>... newElements) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.Insert<Set<T>>(position, newElements)));
    }


    public ILevel0SetOfSetOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.AddAll<Set<T>>(collection)));
    }


    public ILevel0SetOperator<T> flatten() {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.FlattenSets<T>()));
    }


    public ILevel1SetOfSetElementsOperator<T> forEach() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1SetOfSetElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel1SetOfSetElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1SetOfSetElementsOperator<T> forEachMatching(final IEval<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterate(eval));
    }


    public ILevel1SetOfSetElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1SetOfSetElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel1SetOfSetElementsOperator<T> forEachSelected(final ISelect<Set<T>> selector) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel1SetOfSetElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel1SetOfSetElementsOperator<T> forEachNotNull() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1SetOfSetElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNotNullAnd(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel1SetOfSetElementsOperator<T> forEachNull() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1SetOfSetElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNullOr(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel0SetOfSetOperator<X> of(final Type<X> of) {
        return new Level0SetOfSetOperator<X>(getTarget());
    }


    public ILevel0SetOfSetOperator<?> raw() {
        return new Level0SetOfSetOperator<T>(getTarget());
    }


    public ILevel0SetOfSetOperator<T> removeIndexes(final int... indices) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.RemoveIndexes<Set<T>>(indices)));
    }


    public ILevel0SetOfSetOperator<T> removeEquals(final Set<T>... values) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.RemoveEquals<Set<T>>(values)));
    }


    public ILevel0SetOfSetOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.RemoveMatching<Set<T>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0SetOfSetOperator<T> removeMatching(final IEval<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.RemoveMatching<Set<T>>(eval)));
    }


    public ILevel0SetOfSetOperator<T> removeNullOrMatching(final IEval<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.RemoveNullOrMatching<Set<T>>(eval)));
    }


    public ILevel0SetOfSetOperator<T> removeNotNullMatching(final IEval<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.RemoveNotNullMatching<Set<T>>(eval)));
    }


    public ILevel0SetOfSetOperator<T> removeSelected(final ISelect<Set<T>> selector) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.RemoveSelected<Set<T>>(selector)));
    }


    public ILevel0SetOfSetOperator<T> removeIndexesNot(final int... indices) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.RemoveIndexesNot<Set<T>>(indices)));
    }


    public ILevel0SetOfSetOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.RemoveNotNullMatching<Set<T>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0SetOfSetOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.RemoveNullOrMatching<Set<T>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0SetOfSetOperator<T> removeNulls() {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.RemoveNulls<Set<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0SetOfSetOperator<T> sort() {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.Sort()));
    }


    public ILevel0SetOfSetOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(new SetFunc.SortByComparator<Set<T>>(comparator)));
    }


    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return Op.onArrayOfArray(Op.onSet(forEach().toArray(of).get()).toArray(Types.arrayOf(of)).get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfListOperator<T> toArrayOfList() {
        return Op.onArrayOfList(Op.onSet(forEach().toList().get()).toArray((Type<List<T>>)((Type<?>)Types.LIST_OF_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K> ILevel0ArrayOfMapOperator<K, T> toArrayOfMap(final IEval<K, ? super T> keyEval) {
        return Op.onArrayOfMap(Op.onSet(forEach().toMap(keyEval).get()).toArray((Type<Map<K, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K, V> ILevel0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return Op.onArrayOfMap(Op.onSet(forEach().toMap(mapBuild).get()).toArray((Type<Map<K, V>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfSetOperator<T> toArrayOfSet() {
        return Op.onArrayOfSet(Op.onSet(get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get());
    }


    public ILevel0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(of, Op.onSet(forEach().toArray(of).get()).toList().get());
    }


    public ILevel0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onSet(forEach().toList().get()).toList().get());
    }


    public <K> ILevel0ListOfMapOperator<K, T> toListOfMap(final IEval<K, ? super T> keyEval) {
        return Op.onListOfMap(Op.onSet(forEach().toMap(keyEval).get()).toList().get());
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> toListOfMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return Op.onListOfMap(Op.onSet(forEach().toMap(mapBuild).get()).toList().get());
    }


    public ILevel0ListOfSetOperator<T> toListOfSet() {
        return Op.onListOfSet(Op.onSet(get()).toList().get());
    }


    public ILevel0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(of, forEach().toArray(of).get());
    }


    public ILevel0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(forEach().toList().get());
    }


    public <K> ILevel0SetOfMapOperator<K, T> toSetOfMap(final IEval<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> toSetOfMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return Op.onArrayOfMap(Op.onSet(forEach().toMap().get()).toArray((Type<Map<T, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    public ILevel0ListOfMapOperator<T, T> toListOfMap() {
        return Op.onListOfMap(Op.onSet(forEach().toMap().get()).toList().get());
    }


    public ILevel0SetOfMapOperator<T, T> toSetOfMap() {
        return forEach().toMap().endFor();
    }


    @SuppressWarnings("unchecked")
    public Set<Set<T>> get() {
        return (Set<Set<T>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<Set<T>>> generic() {
        return new Level0GenericUniqOperator<Set<Set<T>>>(getTarget());
    }

}

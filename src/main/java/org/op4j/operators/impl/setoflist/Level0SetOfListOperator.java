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
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.SetFunc;
import org.op4j.operators.impl.Operator;
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
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0SetOfListOperator<T> extends Operator
        implements ILevel0SetOfListOperator<T>  {

    
    public Level0SetOfListOperator(final Target target) {
        super(target);
    }


    public ILevel0SetOfListOperator<T> add(final List<T>... newElements) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFunc.Add<List<T>>(newElements)));
    }


    public ILevel0SetOfListOperator<T> insert(final int position, final List<T>... newElements) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFunc.Insert<List<T>>(position, newElements)));
    }


    public ILevel0SetOfListOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFunc.AddAll<List<T>>(collection)));
    }


    public ILevel0SetOfListOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<T> extract(List<T> value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<T> extractAll(List<T>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<T> extractAll(ISelect<List<T>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<T> extractAllBut(List<T>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<T> extractAllBut(ISelect<List<T>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> flatten() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> forEach() {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1SetOfListElementsOperator<T> forEach(final int... positions) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterate(positions));
    }


    


    public ILevel1SetOfListElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1SetOfListElementsOperator<T> forEach(final ISelect<List<T>> selector) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel1SetOfListElementsOperator<T> forEachNot(final int... positions) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterateNot(positions));
    }


    








    public ILevel1SetOfListElementsOperator<T> forEachNotNull() {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1SetOfListElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel1SetOfListElementsOperator<T> forEachNull() {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1SetOfListElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel0SetOfListOperator<X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOfListOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<T> removePositions(final int... positions) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFunc.RemovePositions<List<T>>(positions)));
    }


    public ILevel0SetOfListOperator<T> removeValues(final List<T>... values) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFunc.RemoveValues<List<T>>(values)));
    }


    public ILevel0SetOfListOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFunc.RemoveMatching<List<T>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0SetOfListOperator<T> removeSelected(final ISelect<List<T>> selector) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFunc.RemoveSelected<List<T>>(selector)));
    }


    public ILevel0SetOfListOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFunc.RemoveAllExceptPositions<List<T>>(positions)));
    }


    public ILevel0SetOfListOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFunc.RemoveNotNullsMatching<List<T>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0SetOfListOperator<T> removeNulls() {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFunc.RemoveNulls<List<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0SetOfListOperator<T> sort() {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFunc.Sort()));
    }


    @SuppressWarnings("unchecked")
    public ILevel0SetOfListOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFunc.Sort(comparator)));
    }


    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return Op.onArrayOfArray(Op.onSet(forEach().toArray(of).get()).toArray(Types.arrayOf(of)).get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfListOperator<T> toArrayOfList() {
        return Op.onArrayOfList(Op.onSet(get()).toArray((Type<List<T>>)((Type<?>)Types.LIST_OF_UNKNOWN)).get());
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
        return Op.onArrayOfSet(Op.onSet(forEach().toSet().get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get());
    }


    public ILevel0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(of, Op.onSet(forEach().toArray(of).get()).toList().get());
    }


    public ILevel0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onSet(get()).toList().get());
    }


    public <K> ILevel0ListOfMapOperator<K, T> toListOfMap(final IEval<K, ? super T> keyEval) {
        return Op.onListOfMap(Op.onSet(forEach().toMap(keyEval).get()).toList().get());
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> toListOfMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return Op.onListOfMap(Op.onSet(forEach().toMap(mapBuild).get()).toList().get());
    }


    public ILevel0ListOfSetOperator<T> toListOfSet() {
        return Op.onListOfSet(Op.onSet(forEach().toSet().get()).toList().get());
    }


    public ILevel0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(of, forEach().toArray(of).get());
    }


    public <K> ILevel0SetOfMapOperator<K, T> toSetOfMap(final IEval<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> toSetOfMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public ILevel0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(forEach().toSet().get());
    }


    @SuppressWarnings("unchecked")
    public Set<List<T>> get() {
        return (Set<List<T>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<List<T>>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

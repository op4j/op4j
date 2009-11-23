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
import java.util.List;
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
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
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
public class Level0SetOfArrayOperator<T> extends Operator
        implements ILevel0SetOfArrayOperator<T>  {
    
    private final Type<? super T> arrayOf; 

    
    public Level0SetOfArrayOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel0SetOfArrayOperator<T> add(final T[]... newElements) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFunc.Add<T[]>(newElements)));
    }


    public ILevel0SetOfArrayOperator<T> insert(final int position, final T[]... newElements) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFunc.Insert<T[]>(position, newElements)));
    }


    public ILevel0SetOfArrayOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFunc.AddAll<T[]>(collection)));
    }


    public ILevel0SetOfArrayOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> extract(T[] value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> extractAll(T[]... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> extractAll(ISelect<T[]> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> extractAllBut(T[]... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> extractAllBut(ISelect<T[]> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> flatten() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfArrayElementsOperator<T> forEach() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }


    public ILevel1SetOfArrayElementsOperator<T> forEach(final int... positions) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(positions));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEach(final ISelect<T[]> selector) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachNot(final int... positions) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNot(positions));
    }








    public ILevel1SetOfArrayElementsOperator<T> forEachNotNull() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel1SetOfArrayElementsOperator<T> forEachNull() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel0SetOfArrayOperator<X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOfArrayOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> removePositions(final int... positions) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFunc.RemovePositions<T[]>(positions)));
    }


    public ILevel0SetOfArrayOperator<T> removeValues(final T[]... values) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFunc.RemoveValues<T[]>(values)));
    }


    public ILevel0SetOfArrayOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFunc.RemoveMatching<T[]>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0SetOfArrayOperator<T> removeSelected(final ISelect<T[]> selector) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFunc.RemoveSelected<T[]>(selector)));
    }


    public ILevel0SetOfArrayOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFunc.RemoveAllExceptPositions<T[]>(positions)));
    }


    public ILevel0SetOfArrayOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFunc.RemoveNotNullsMatching<T[]>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0SetOfArrayOperator<T> removeNulls() {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFunc.RemoveNulls<T[]>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0SetOfArrayOperator<T> sort() {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFunc.Sort()));
    }


    @SuppressWarnings("unchecked")
    public ILevel0SetOfArrayOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFunc.Sort(comparator)));
    }


    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return Op.onArrayOfArray(Op.onSet(get()).toArray(Types.arrayOf(of)).get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfListOperator<T> toArrayOfList() {
        return Op.onArrayOfList(Op.onSet(forEach().toList().get()).toArray((Type<List<T>>)((Type<?>)Types.LIST_OF_UNKNOWN)).get());
    }


    public <K> ILevel0ArrayOfMapOperator<K, T> toArrayOfMap(
            IEval<K, ? super T> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0ArrayOfMapOperator<K, V> toArrayOfMap(
            IMapBuild<K, V, ? super T> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfSetOperator<T> toArrayOfSet() {
        return Op.onArrayOfSet(Op.onSet(forEach().toSet().get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get());
    }


    public ILevel0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(of, Op.onSet(get()).toList().get());
    }


    public ILevel0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onSet(forEach().toList().get()).toList().get());
    }


    public <K> ILevel0ListOfMapOperator<K, T> toListOfMap(
            IEval<K, ? super T> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> toListOfMap(
            IMapBuild<K, V, ? super T> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfSetOperator<T> toListOfSet() {
        return Op.onListOfSet(Op.onSet(forEach().toSet().get()).toList().get());
    }


    public ILevel0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(forEach().toList().get());
    }


    public <K> ILevel0SetOfMapOperator<K, T> toSetOfMap(
            IEval<K, ? super T> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> toSetOfMap(
            IMapBuild<K, V, ? super T> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(forEach().toSet().get());
    }


    @SuppressWarnings("unchecked")
    public Set<T[]> get() {
        return (Set<T[]>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<T[]>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

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
package org.op4j.operators.impl.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.Op;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ArrayFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
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
public class Level0ArrayOfListOperator<T> extends Operator
        implements ILevel0ArrayOfListOperator<T>  {

    
    public Level0ArrayOfListOperator(final Target target) {
        super(target);
    }


    public ILevel0ArrayOfListOperator<T> add(final List<T>... newElements) {
        return new Level0ArrayOfListOperator<T>(getTarget().execute(new ArrayFunc.Add<List<T>>(newElements)));
    }


    public ILevel0ArrayOfListOperator<T> insert(final int position, final List<T>... newElements) {
        return new Level0ArrayOfListOperator<T>(getTarget().execute(new ArrayFunc.Insert<List<T>>(position, newElements)));
    }


    public ILevel0ArrayOfListOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0ArrayOfListOperator<T>(getTarget().execute(new ArrayFunc.AddAll<List<T>>(collection)));
    }


    public ILevel0ArrayOfListOperator<T> distinct() {
        return new Level0ArrayOfListOperator<T>(getTarget().execute(new ArrayFunc.Distinct<List<T>>()));
    }


    public ILevel0ArrayOfListOperator<T> extract(final int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfListOperator<T> extract(final List<T> value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfListOperator<T> extractAll(final int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfListOperator<T> extractAll(final List<T>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfListOperator<T> extractAll(final String expression, final Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfListOperator<T> extractAll(final ISelect<List<T>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfListOperator<T> extractAllBut(final int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfListOperator<T> extractAllBut(final List<T>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfListOperator<T> extractAllBut(final String expression, final Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfListOperator<T> extractAllBut(final ISelect<List<T>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOperator<T> flatten() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<T> forEach() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1ArrayOfListElementsOperator<T> forEach(int... positions) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().iterate(positions));
    }


    public ILevel1ArrayOfListElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1ArrayOfListElementsOperator<T> forEach(final ISelect<List<T>> selector) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel1ArrayOfListElementsOperator<T> forEachNot(final int... positions) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().iterateNot(positions));
    }








    public ILevel1ArrayOfListElementsOperator<T> forEachNotNull() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1ArrayOfListElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel1ArrayOfListElementsOperator<T> forEachNull() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1ArrayOfListElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel0ArrayOfListOperator<X> of(final Type<X> of) {
        return new Level0ArrayOfListOperator<X>(getTarget());
    }


    public ILevel0ArrayOfListOperator<?> raw() {
        return new Level0ArrayOfListOperator<T>(getTarget());
    }


    public ILevel0ArrayOfListOperator<T> removePositions(final int... positions) {
        return new Level0ArrayOfListOperator<T>(getTarget().execute(new ArrayFunc.RemovePositions<List<T>>(positions)));
    }


    public ILevel0ArrayOfListOperator<T> removeValues(final List<T>... values) {
        return new Level0ArrayOfListOperator<T>(getTarget().execute(new ArrayFunc.RemoveValues<List<T>>(values)));
    }


    public ILevel0ArrayOfListOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOfListOperator<T>(getTarget().execute(new ArrayFunc.RemoveMatching<List<T>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ArrayOfListOperator<T> removeSelected(final ISelect<List<T>> selector) {
        return new Level0ArrayOfListOperator<T>(getTarget().execute(new ArrayFunc.RemoveSelected<List<T>>(selector)));
    }


    public ILevel0ArrayOfListOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level0ArrayOfListOperator<T>(getTarget().execute(new ArrayFunc.RemoveAllExceptPositions<List<T>>(positions)));
    }



    public ILevel0ArrayOfListOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOfListOperator<T>(getTarget().execute(new ArrayFunc.RemoveNotNullsMatching<List<T>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ArrayOfListOperator<T> removeNulls() {
        return new Level0ArrayOfListOperator<T>(getTarget().execute(new ArrayFunc.RemoveNulls<List<T>>()));
    }

    

    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfListOperator<T> sort() {
        return new Level0ArrayOfListOperator<T>(getTarget().execute(new ArrayFunc.Sort()));
    }

    public ILevel0ArrayOfListOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0ArrayOfListOperator<T>(getTarget().execute(new ArrayFunc.SortByComparator<List<T>>(comparator)));
    }


    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return forEach().toArray(of).endFor();
    }


    public <K> ILevel0ArrayOfMapOperator<K, T> toArrayOfMap(final IEval<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> ILevel0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public ILevel0ArrayOfSetOperator<T> toArrayOfSet() {
        return forEach().toSet().endFor();
    }


    public ILevel0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(of, Op.onArray(forEach().toArray(of).get()).toList().get());
    }


    public ILevel0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onArray(get()).toList().get());
    }


    public <K> ILevel0ListOfMapOperator<K, T> toListOfMap(final IEval<K, ? super T> keyEval) {
        return Op.onListOfMap(Op.onArray(forEach().toMap(keyEval).get()).toList().get());
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> toListOfMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return Op.onListOfMap(Op.onArray(forEach().toMap(mapBuild).get()).toList().get());
    }


    public ILevel0ListOfSetOperator<T> toListOfSet() {
        return Op.onListOfSet(Op.onArray(forEach().toSet().get()).toList().get());
    }


    public ILevel0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(of, Op.onArray(forEach().toArray(of).get()).toSet().get());
    }


    public ILevel0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(Op.onArray(get()).toSet().get());
    }


    public <K> ILevel0SetOfMapOperator<K, T> toSetOfMap(final IEval<K, ? super T> keyEval) {
        return Op.onSetOfMap(Op.onArray(forEach().toMap(keyEval).get()).toSet().get());
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> toSetOfMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return Op.onSetOfMap(Op.onArray(forEach().toMap(mapBuild).get()).toSet().get());
    }


    public ILevel0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(Op.onArray(forEach().toSet().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
	public List<T>[] get() {
        return (List<T>[]) getTarget().get();
    }


    public ILevel0GenericUniqOperator<List<T>[]> generic() {
        return new Level0GenericUniqOperator<List<T>[]>(getTarget());
    }

}

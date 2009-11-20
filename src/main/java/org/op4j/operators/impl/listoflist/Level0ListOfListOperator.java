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
package org.op4j.operators.impl.listoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ListFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
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
public class Level0ListOfListOperator<T> extends Operator
        implements ILevel0ListOfListOperator<T>  {

    
    public Level0ListOfListOperator(final Target target) {
        super(target);
    }


    public ILevel0ListOfListOperator<T> add(final List<T>... newElements) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFunc.Add<List<T>>(newElements)));
    }


    public ILevel0ListOfListOperator<T> insert(final int position, final List<T>... newElements) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFunc.Insert<List<T>>(position, newElements)));
    }


    public ILevel0ListOfListOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFunc.AddAll<List<T>>(collection)));
    }


    public ILevel0ListOfListOperator<T> distinct() {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFunc.Distinct<List<T>>()));
    }


    public ILevel0ListOfListOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfListOperator<T> extract(List<T> value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfListOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfListOperator<T> extractAll(List<T>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfListOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfListOperator<T> extractAll(ISelect<List<T>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfListOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfListOperator<T> extractAllBut(List<T>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfListOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfListOperator<T> extractAllBut(ISelect<List<T>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<T> flatten() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<T> forEach() {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1ListOfListElementsOperator<T> forEach(final int... positions) {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterate(positions));
    }


    


    public ILevel1ListOfListElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1ListOfListElementsOperator<T> forEach(final ISelect<List<T>> selector) {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel1ListOfListElementsOperator<T> forEachNot(final int... positions) {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterateNot(positions));
    }


    








    public ILevel1ListOfListElementsOperator<T> forEachNotNull() {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1ListOfListElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel1ListOfListElementsOperator<T> forEachNull() {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1ListOfListElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel0ListOfListOperator<X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ListOfListOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfListOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfListOperator<T> removePositions(final int... positions) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFunc.RemovePositions<List<T>>(positions)));
    }


    public ILevel0ListOfListOperator<T> removeValues(final List<T>... values) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFunc.RemoveValues<List<T>>(values)));
    }


    public ILevel0ListOfListOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFunc.RemoveMatching<List<T>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ListOfListOperator<T> removeSelected(final ISelect<List<T>> selector) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFunc.RemoveSelected<List<T>>(selector)));
    }


    public ILevel0ListOfListOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFunc.RemoveAllExceptPositions<List<T>>(positions)));
    }


    public ILevel0ListOfListOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFunc.RemoveNotNullsMatching<List<T>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ListOfListOperator<T> removeNulls() {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFunc.RemoveNulls<List<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0ListOfListOperator<T> sort() {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFunc.Sort()));
    }


    @SuppressWarnings("unchecked")
    public ILevel0ListOfListOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFunc.Sort(comparator)));
    }


    public <X> ILevel0ArrayOfArrayOperator<X> toArrayOfArray(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfArrayOperator<X> toArrayOfArray(
            Class<X> arrayOfClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfListOperator<T> toArrayOfList() {
        // TODO Auto-generated method stub
        return null;
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


    public ILevel0ArrayOfSetOperator<T> toArrayOfSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ListOfArrayOperator<X> toListOfArray(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ListOfArrayOperator<X> toListOfArray(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOfArrayOperator<X> toSetOfArray(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOfArrayOperator<X> toSetOfArray(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<T> toSetOfList() {
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub
        return null;
    }


    @SuppressWarnings("unchecked")
    public List<List<T>> get() {
        return (List<List<T>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<List<List<T>>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

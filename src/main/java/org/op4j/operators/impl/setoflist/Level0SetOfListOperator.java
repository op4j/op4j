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

import org.op4j.Of;
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
        return new Level0SetOfListOperator<T>(getTarget().execute(SetFunc.addAllValues(newElements)));
    }


    public ILevel0SetOfListOperator<T> insert(final int position, final List<T>... newElements) {
        return new Level0SetOfListOperator<T>(getTarget().execute(SetFunc.addAllValues(position, newElements)));
    }


    public ILevel0SetOfListOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0SetOfListOperator<T>(getTarget().execute(SetFunc.addAll(collection)));
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





    public <X> ILevel0SetOfListOperator<X> of(Of<X> of) {
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
        return new Level0SetOfListOperator<T>(getTarget().execute(SetFunc.removeAll(positions)));
    }


    public ILevel0SetOfListOperator<T> removeValues(final List<T>... values) {
        return new Level0SetOfListOperator<T>(getTarget().execute(SetFunc.removeAllValues(values)));
    }


    public ILevel0SetOfListOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfListOperator<T>(getTarget().execute(SetFunc.removeAll(expression, optionalExpParams)));
    }


    public ILevel0SetOfListOperator<T> removeSelected(final ISelect<List<T>> selector) {
        return new Level0SetOfListOperator<T>(getTarget().execute(SetFunc.removeAll(selector)));
    }


    public ILevel0SetOfListOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level0SetOfListOperator<T>(getTarget().execute(SetFunc.removeAllNot(positions)));
    }



    public ILevel0SetOfListOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfListOperator<T>(getTarget().execute(SetFunc.removeAllNotNullAnd(expression, optionalExpParams)));
    }


    public ILevel0SetOfListOperator<T> removeNulls() {
        return new Level0SetOfListOperator<T>(getTarget().execute(SetFunc.removeAllNull()));
    }

    


    public ILevel0SetOfListOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<T> sort(
            Comparator<? super List<T>> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfArrayOperator<X> toArrayOfArray(Of<X> arrayOf) {
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


    public <X> ILevel0ListOfArrayOperator<X> toListOfArray(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ListOfArrayOperator<X> toListOfArray(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfListOperator<T> toListOfList() {
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


    public <X> ILevel0SetOfArrayOperator<X> toSetOfArray(Of<X> arrayOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOfArrayOperator<X> toSetOfArray(Class<X> ofClass) {
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
    public Set<List<T>> get() {
        return (Set<List<T>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<List<T>>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

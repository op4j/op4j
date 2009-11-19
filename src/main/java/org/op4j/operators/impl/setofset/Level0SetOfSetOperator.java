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
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.SetFuncOLD;
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
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.target.Target;


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
        return new Level0SetOfSetOperator<T>(getTarget().execute(SetFuncOLD.add(newElements)));
    }


    public ILevel0SetOfSetOperator<T> insert(final int position, final Set<T>... newElements) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(SetFuncOLD.insert(position, newElements)));
    }


    public ILevel0SetOfSetOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(SetFuncOLD.addAll(collection)));
    }


    public ILevel0SetOfSetOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> extract(Set<T> value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> extractAll(Set<T>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> extractAll(ISelect<Set<T>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> extractAllBut(Set<T>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> extractAllBut(ISelect<Set<T>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> flatten() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> forEach() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1SetOfSetElementsOperator<T> forEach(final int... positions) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterate(positions));
    }


    


    public ILevel1SetOfSetElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1SetOfSetElementsOperator<T> forEach(final ISelect<Set<T>> selector) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel1SetOfSetElementsOperator<T> forEachNot(final int... positions) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNot(positions));
    }


    








    public ILevel1SetOfSetElementsOperator<T> forEachNotNull() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1SetOfSetElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel1SetOfSetElementsOperator<T> forEachNull() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1SetOfSetElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel0SetOfSetOperator<X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOfSetOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> removePositions(final int... positions) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(SetFuncOLD.removePositions(positions)));
    }


    public ILevel0SetOfSetOperator<T> removeValues(final Set<T>... values) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(SetFuncOLD.removeValues(values)));
    }


    public ILevel0SetOfSetOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(SetFuncOLD.removeMatching(expression, optionalExpParams)));
    }


    public ILevel0SetOfSetOperator<T> removeSelected(final ISelect<Set<T>> selector) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(SetFuncOLD.removeSelected(selector)));
    }


    public ILevel0SetOfSetOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(SetFuncOLD.removeAllExceptPositions(positions)));
    }



    public ILevel0SetOfSetOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfSetOperator<T>(getTarget().execute(SetFuncOLD.removeNotNullsMatching(expression, optionalExpParams)));
    }


    public ILevel0SetOfSetOperator<T> removeNulls() {
        return new Level0SetOfSetOperator<T>(getTarget().execute(SetFuncOLD.removeNulls()));
    }

    


    public ILevel0SetOfSetOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> sort(Comparator<? super Set<T>> comparator) {
        // TODO Auto-generated method stub
        return null;
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


    @SuppressWarnings("unchecked")
    public Set<Set<T>> get() {
        return (Set<Set<T>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<Set<T>>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

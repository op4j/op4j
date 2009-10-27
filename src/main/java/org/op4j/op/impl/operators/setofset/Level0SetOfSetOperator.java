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
package org.op4j.op.impl.operators.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.op.commands.IEval;
import org.op4j.op.impl.operators.Operator;
import org.op4j.op.intf.operators.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.op.intf.operators.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.op.intf.operators.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.op.intf.operators.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.op.intf.operators.generic.ILevel0GenericUniqOperator;
import org.op4j.op.intf.operators.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.op.intf.operators.listoflist.ILevel0ListOfListOperator;
import org.op4j.op.intf.operators.listofmap.ILevel0ListOfMapOperator;
import org.op4j.op.intf.operators.listofset.ILevel0ListOfSetOperator;
import org.op4j.op.intf.operators.set.ILevel0SetOperator;
import org.op4j.op.intf.operators.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.op.intf.operators.setoflist.ILevel0SetOfListOperator;
import org.op4j.op.intf.operators.setofmap.ILevel0SetOfMapOperator;
import org.op4j.op.intf.operators.setofset.ILevel0SetOfSetOperator;
import org.op4j.op.intf.operators.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.op.intf.parameters.IMapBuild;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.parameters.ISelect;
import org.op4j.op.target.Target;


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


    public ILevel0SetOfSetOperator<T> add(Set<T> newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> add(int position, Set<T> newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> addAll(Set<T>... newElements) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> addAll(Collection<Set<T>> collection) {
        // TODO Auto-generated method stub
        return null;
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


    


    public ILevel1SetOfSetElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNot(expression, optionalExpParams));
    }


    public ILevel1SetOfSetElementsOperator<T> forEachNot(final ISelect<Set<T>> selector) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNot(selector));
    }


    public ILevel1SetOfSetElementsOperator<T> forEachNotNull() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1SetOfSetElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }


    public ILevel1SetOfSetElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNotNullAndNot(expression, optionalExpParams));
    }


    public ILevel1SetOfSetElementsOperator<T> forEachNull() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1SetOfSetElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }


    public ILevel1SetOfSetElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().iterateNullOrNot(expression, optionalExpParams));
    }


    public <X> ILevel0SetOfSetOperator<X> of(IOf<X> of) {
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


    public ILevel0SetOfSetOperator<T> remove(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> remove(Set<T> value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> removeAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> removeAll(Set<T>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> removeAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> removeAll(ISelect<Set<T>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> removeAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> removeAllBut(Set<T>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> removeAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> removeAllBut(ISelect<Set<T>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> sort(Comparator<? super Set<T>> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfArrayOperator<X> toArrayOfArray(IOf<X> arrayOf) {
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


    public <X> ILevel0ListOfArrayOperator<X> toListOfArray(IOf<X> of) {
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


    public <X> ILevel0SetOfArrayOperator<X> toSetOfArray(IOf<X> arrayOf) {
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

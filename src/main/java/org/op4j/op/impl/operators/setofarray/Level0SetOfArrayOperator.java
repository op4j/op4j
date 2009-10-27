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
package org.op4j.op.impl.operators.setofarray;

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
import org.op4j.op.intf.operators.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.op.intf.operators.setoflist.ILevel0SetOfListOperator;
import org.op4j.op.intf.operators.setofmap.ILevel0SetOfMapOperator;
import org.op4j.op.intf.operators.setofset.ILevel0SetOfSetOperator;
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
public class Level0SetOfArrayOperator<T> extends Operator
        implements ILevel0SetOfArrayOperator<T>  {
    
    private final IOf<T> arrayOf; 

    
    public Level0SetOfArrayOperator(final IOf<T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel0SetOfArrayOperator<T> add(T[] newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> add(int position, T[] newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> addAll(T[]... newElements) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> addAll(Collection<T[]> collection) {
        // TODO Auto-generated method stub
        return null;
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


    public ILevel1SetOfArrayElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNot(expression, optionalExpParams));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachNot(final ISelect<T[]> selector) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNot(selector));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachNotNull() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAndNot(expression, optionalExpParams));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachNull() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(expression, optionalExpParams));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOrNot(expression, optionalExpParams));
    }


    public <X> ILevel0SetOfArrayOperator<X> of(IOf<X> of) {
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


    public ILevel0SetOfArrayOperator<T> remove(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> remove(T[] value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> removeAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> removeAll(T[]... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> removeAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> removeAll(ISelect<T[]> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> removeAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> removeAllBut(T[]... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> removeAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> removeAllBut(ISelect<T[]> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<T> sort(Comparator<? super T[]> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfArrayOperator<X> toArrayOfArray(IOf<X> of) {
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
    public Set<T[]> get() {
        return (Set<T[]>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<T[]>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

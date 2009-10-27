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
package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.op4j.IOf;
import org.op4j.commands.IEval;
import org.op4j.commands.IMapBuild;
import org.op4j.commands.ISelect;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
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
public class Level0ArrayOfArrayOperator<T> extends Operator
        implements ILevel0ArrayOfArrayOperator<T> {
    
    private final IOf<T> arrayOf; 

    
    
    public Level0ArrayOfArrayOperator(final IOf<T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel0ArrayOfArrayOperator<T> add(T[] newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> add(int position, T[] newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> addAll(T[]... newElements) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> addAll(Collection<T[]> collection) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> distinct() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> extract(T[] value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> extractAll(T[]... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> extractAll(ISelect<T[]> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> extractAllBut(T[]... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> extractAllBut(ISelect<T[]> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOperator<T> flatten() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEach() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEach(final int... positions) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(positions));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEach(final ISelect<T[]> selector) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachNot(final int... positions) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNot(positions));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNot(expression, optionalExpParams));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachNot(final ISelect<T[]> selector) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNot(selector));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachNotNull() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAndNot(expression, optionalExpParams));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachNull() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(expression, optionalExpParams));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOrNot(expression, optionalExpParams));
    }


    public <X> ILevel0ArrayOfArrayOperator<X> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfArrayOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> remove(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> remove(T[] value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> removeAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> removeAll(T[]... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> removeAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> removeAll(ISelect<T[]> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> removeAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> removeAllBut(T[]... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> removeAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> removeAllBut(ISelect<T[]> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<T> sort(
            Comparator<? super T[]> comparator) {
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


    public <X> ILevel0SetOfArrayOperator<X> toSetOfArray(IOf<X> of) {
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
	public T[][] get() {
        return (T[][]) getTarget().get();
    }


    public ILevel0GenericUniqOperator<T[][]> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

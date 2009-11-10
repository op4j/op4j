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
package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.structuremanagement.ListFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
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
public class Level0ListOfArrayOperator<T> extends Operator
        implements ILevel0ListOfArrayOperator<T>  {
    
    private final Of<T> arrayOf; 

    
    public Level0ListOfArrayOperator(final Of<T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel0ListOfArrayOperator<T> add(final T[] newElement) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.addAllValues(newElement)));
    }


    public ILevel0ListOfArrayOperator<T> add(final int position, final T[] newElement) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.add(position, newElement)));
    }


    public ILevel0ListOfArrayOperator<T> addAllValues(final T[]... newElements) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.addAllValues(newElements)));
    }


    public ILevel0ListOfArrayOperator<T> addAllValues(final int position, final T[]... newElements) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.addAllValues(position, newElements)));
    }


    public ILevel0ListOfArrayOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.addAll(collection)));
    }


    public ILevel0ListOfArrayOperator<T> distinct() {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.distinct()));
    }


    public ILevel0ListOfArrayOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<T> extract(T[] value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<T> extractAll(T[]... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<T> extractAll(ISelect<T[]> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<T> extractAllBut(T[]... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<T> extractAllBut(ISelect<T[]> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<T> flatten() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> forEach() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }


    public ILevel1ListOfArrayElementsOperator<T> forEach(final int... positions) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(positions));
    }


    public ILevel1ListOfArrayElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1ListOfArrayElementsOperator<T> forEach(final ISelect<T[]> selector) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel1ListOfArrayElementsOperator<T> forEachNot(final int... positions) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNot(positions));
    }








    public ILevel1ListOfArrayElementsOperator<T> forEachNotNull() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel1ListOfArrayElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel1ListOfArrayElementsOperator<T> forEachNull() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel1ListOfArrayElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel0ListOfArrayOperator<X> of(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ListOfArrayOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<T> remove(final int position) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.remove(position)));
    }


    public ILevel0ListOfArrayOperator<T> removeValue(final T[] value) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.removeValue(value)));
    }


    public ILevel0ListOfArrayOperator<T> removeAll(final int... positions) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.removeAll(positions)));
    }


    public ILevel0ListOfArrayOperator<T> removeAllValues(final T[]... values) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.removeAllValues(values)));
    }


    public ILevel0ListOfArrayOperator<T> removeAll(final String expression, final Object... optionalExpParams) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.removeAll(expression, optionalExpParams)));
    }


    public ILevel0ListOfArrayOperator<T> removeAll(final ISelect<T[]> selector) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.removeAll(selector)));
    }


    public ILevel0ListOfArrayOperator<T> removeAllNot(final int... positions) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.removeAllNot(positions)));
    }


    public ILevel0ListOfArrayOperator<T> removeAllValuesNot(final T[]... values) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.removeAllValuesNot(values)));
    }

    

    public ILevel0ListOfArrayOperator<T> removeAllNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.removeAllNotNullAnd(expression, optionalExpParams)));
    }


    public ILevel0ListOfArrayOperator<T> removeAllNull() {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.removeAllNull()));
    }

    
    public ILevel0ListOfArrayOperator<T> removeAllNullOr(final String expression, final Object... optionalExpParams) {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().execute(ListFunc.removeAllNullOr(expression, optionalExpParams)));
    }




    public ILevel0ListOfArrayOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<T> sort(Comparator<? super T[]> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfArrayOperator<X> toArrayOfArray(Of<X> of) {
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


    public <X> ILevel0SetOfArrayOperator<X> toSetOfArray(Of<X> of) {
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
    public List<T[]> get() {
        return (List<T[]>) getTarget().getObject();
    }


    public ILevel0GenericUniqOperator<List<T[]>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

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
package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ArrayFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
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
public class Level0ArrayOfSetOperator<T> extends Operator
        implements ILevel0ArrayOfSetOperator<T>  {

    
    public Level0ArrayOfSetOperator(final Target target) {
        super(target);
    }


    public ILevel0ArrayOfSetOperator<T> deleteAAA(final Set<T> newElement) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.add(newElement)));
    }


    public ILevel0ArrayOfSetOperator<T> deleteAAB(final int position, final Set<T> newElement) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.add(position, newElement)));
    }


    public ILevel0ArrayOfSetOperator<T> add(final Set<T>... newElements) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.addAllValues(newElements)));
    }


    public ILevel0ArrayOfSetOperator<T> insert(final int position, final Set<T>... newElements) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.addAllValues(position, newElements)));
    }


    public ILevel0ArrayOfSetOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.addAll(collection)));
    }


    public ILevel0ArrayOfSetOperator<T> distinct() {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.distinct()));
    }


    public ILevel0ArrayOfSetOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfSetOperator<T> extract(Set<T> value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfSetOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfSetOperator<T> extractAll(Set<T>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfSetOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfSetOperator<T> extractAll(ISelect<Set<T>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfSetOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfSetOperator<T> extractAllBut(Set<T>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfSetOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfSetOperator<T> extractAllBut(ISelect<Set<T>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOperator<T> flatten() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEach() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEach(final int... positions) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterate(positions));
    }


    


    public ILevel1ArrayOfSetElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEach(final ISelect<Set<T>> selector) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachNot(final int... positions) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNot(positions));
    }


    








    public ILevel1ArrayOfSetElementsOperator<T> forEachNotNull() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel1ArrayOfSetElementsOperator<T> forEachNull() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1ArrayOfSetElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel0ArrayOfSetOperator<X> of(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfSetOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfSetOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfSetOperator<T> deleteCCC(final int position) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.remove(position)));
    }


    public ILevel0ArrayOfSetOperator<T> deleteCCD(final Set<T> value) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.removeValue(value)));
    }


    public ILevel0ArrayOfSetOperator<T> removeAll(final int... positions) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.removeAll(positions)));
    }


    public ILevel0ArrayOfSetOperator<T> removeAllValues(final Set<T>... values) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.removeAllValues(values)));
    }


    public ILevel0ArrayOfSetOperator<T> removeAll(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.removeAll(expression, optionalExpParams)));
    }


    public ILevel0ArrayOfSetOperator<T> removeAll(final ISelect<Set<T>> selector) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.removeAll(selector)));
    }


    public ILevel0ArrayOfSetOperator<T> removeAllNot(final int... positions) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.removeAllNot(positions)));
    }


    public ILevel0ArrayOfSetOperator<T> removeAllValuesNot(final Set<T>... values) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.removeAllValuesNot(values)));
    }

    

    public ILevel0ArrayOfSetOperator<T> removeAllNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.removeAllNotNullAnd(expression, optionalExpParams)));
    }


    public ILevel0ArrayOfSetOperator<T> removeAllNull() {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.removeAllNull()));
    }

    
    public ILevel0ArrayOfSetOperator<T> removeAllNullOr(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOfSetOperator<T>(getTarget().execute(ArrayFunc.removeAllNullOr(expression, optionalExpParams)));
    }




    public ILevel0ArrayOfSetOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfSetOperator<T> sort(
            Comparator<? super Set<T>> comparator) {
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
    public Set<T>[] get() {
        return (Set<T>[]) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<T>[]> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

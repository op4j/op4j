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

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.operators.intf.setofset.ILevel2SetOfSetElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1SetOfSetElementsOperator<T> extends Operator
        implements ILevel1SetOfSetElementsOperator<T>  {

    
    public Level1SetOfSetElementsOperator(final Target target) {
        super(target);
    }


    public ILevel1SetOfSetElementsOperator<T> add(T newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> add(int position, T newElement) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel1SetOfSetElementsOperator<T> addAllValues(T... newElements) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel1SetOfSetElementsOperator<T> addAllValues(int position, T... newElements) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> addAll(Collection<T> collection) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<T> endFor() {
        return new Level0SetOfSetOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public ILevel1SetOfSetElementsOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> extract(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> extractAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> extractAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> extractAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> extractAllBut(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEach() {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEach(final int... positions) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterate(positions));
    }


    


    public ILevel2SetOfSetElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachNot(final int... positions) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNot(positions));
    }


    








    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotNull() {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel2SetOfSetElementsElementsOperator<T> forEachNull() {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel1SetOfSetElementsOperator<X> of(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1SetOfSetElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> remove(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> removeValue(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> removeAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> removeAllValues(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> removeAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> removeAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> removeAllNot(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> removeAllValuesNot(T... values) {
        // TODO Auto-generated method stub
        return null;
    }







    public ILevel1SetOfSetElementsOperator<T> removeAllNotNullAnd(String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }



    public ILevel1SetOfSetElementsOperator<T> removeAllNull() {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel1SetOfSetElementsOperator<T> removeAllNullOr(String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }




    public ILevel1SetOfSetElementsOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<T> sort(
            Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1SetOfArrayElementsOperator<X> toArray(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1SetOfArrayElementsOperator<X> toArray(Class<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<T> toList() {
        // TODO Auto-generated method stub
        return null;
    }


    public <K> ILevel1SetOfMapElementsOperator<K, T> toMap(
            IEval<K, ? super T> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel1SetOfMapElementsOperator<K, V> toMap(
            IMapBuild<K, V, ? super T> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    public Set<Set<T>> get() {
        return endFor().get();
    }

}

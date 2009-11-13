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
import org.op4j.executables.functions.builtin.SetFunc;
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


    public ILevel1SetOfSetElementsOperator<T> deleteAAA(final T newElement) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.add(newElement)));
    }


    public ILevel1SetOfSetElementsOperator<T> deleteAAB(final int position, final T newElement) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.add(position, newElement)));
    }


    public ILevel1SetOfSetElementsOperator<T> add(final T... newElements) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.addAllValues(newElements)));
    }


    public ILevel1SetOfSetElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.addAllValues(position, newElements)));
    }


    public ILevel1SetOfSetElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.addAll(collection)));
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


    public ILevel1SetOfSetElementsOperator<T> deleteCCC(final int position) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.remove(position)));
    }


    public ILevel1SetOfSetElementsOperator<T> deleteCCD(final T value) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeValue(value)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeAll(final int... positions) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeAll(positions)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeAllValues(final T... values) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeAllValues(values)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeAll(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeAll(expression, optionalExpParams)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeAll(final ISelect<T> selector) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeAll(selector)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeAllNot(final int... positions) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeAllNot(positions)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeAllValuesNot(final T... values) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeAllValuesNot(values)));
    }

    

    public ILevel1SetOfSetElementsOperator<T> removeAllNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeAllNotNullAnd(expression, optionalExpParams)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeAllNull() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeAllNull()));
    }

    
    public ILevel1SetOfSetElementsOperator<T> removeAllNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeAllNullOr(expression, optionalExpParams)));
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

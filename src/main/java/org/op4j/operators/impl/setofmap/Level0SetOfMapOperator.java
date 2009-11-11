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
package org.op4j.operators.impl.setofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.op4j.Of;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.SetFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0SetOfMapOperator<K,V> extends Operator
        implements ILevel0SetOfMapOperator<K,V>  {

    
    public Level0SetOfMapOperator(final Target target) {
        super(target);
    }


    public ILevel0SetOfMapOperator<K, V> add(final Map<K, V> newElement) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.add(newElement)));
    }


    public ILevel0SetOfMapOperator<K, V> add(final int position, final Map<K, V> newElement) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.add(position, newElement)));
    }


    public ILevel0SetOfMapOperator<K, V> addAllValues(final Map<K, V>... newElements) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.addAllValues(newElements)));
    }


    public ILevel0SetOfMapOperator<K, V> addAllValues(final int position, final Map<K, V>... newElements) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.addAllValues(position, newElements)));
    }


    public ILevel0SetOfMapOperator<K, V> addAll(final Collection<Map<K, V>> collection) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.addAll(collection)));
    }


    public ILevel0SetOfMapOperator<K, V> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfMapOperator<K, V> extract(Map<K, V> value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfMapOperator<K, V> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfMapOperator<K, V> extractAll(Map<K, V>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfMapOperator<K, V> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfMapOperator<K, V> extractAll(ISelect<Map<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfMapOperator<K, V> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfMapOperator<K, V> extractAllBut(Map<K, V>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfMapOperator<K, V> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfMapOperator<K, V> extractAllBut(
            ISelect<Map<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfMapElementsOperator<K, V> forEach() {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterate());
    }


    public ILevel1SetOfMapElementsOperator<K, V> forEach(final int... positions) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterate(positions));
    }


    


    public ILevel1SetOfMapElementsOperator<K, V> forEach(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1SetOfMapElementsOperator<K, V> forEach(final ISelect<Map<K, V>> selector) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel1SetOfMapElementsOperator<K, V> forEachNot(final int... positions) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterateNot(positions));
    }


    








    public ILevel1SetOfMapElementsOperator<K, V> forEachNotNull() {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterateNotNull());
    }


    public ILevel1SetOfMapElementsOperator<K, V> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel1SetOfMapElementsOperator<K, V> forEachNull() {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterateNull());
    }


    public ILevel1SetOfMapElementsOperator<K, V> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X, Y> ILevel0SetOfMapOperator<X, Y> of(Of<X> ofX, Of<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel0SetOfMapOperator<X, Y> of(Class<X> ofXClass,
            Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfMapOperator<?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfMapOperator<K, V> remove(final int position) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.remove(position)));
    }


    public ILevel0SetOfMapOperator<K, V> removeValue(final Map<K, V> value) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.removeValue(value)));
    }


    public ILevel0SetOfMapOperator<K, V> removeAll(final int... positions) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.removeAll(positions)));
    }


    public ILevel0SetOfMapOperator<K, V> removeAllValues(final Map<K, V>... values) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.removeAllValues(values)));
    }


    public ILevel0SetOfMapOperator<K, V> removeAll(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.removeAll(expression, optionalExpParams)));
    }


    public ILevel0SetOfMapOperator<K, V> removeAll(final ISelect<Map<K, V>> selector) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.removeAll(selector)));
    }


    public ILevel0SetOfMapOperator<K, V> removeAllNot(final int... positions) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.removeAllNot(positions)));
    }


    public ILevel0SetOfMapOperator<K, V> removeAllValuesNot(final Map<K, V>... values) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.removeAllValuesNot(values)));
    }

    

    public ILevel0SetOfMapOperator<K, V> removeAllNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.removeAllNotNullAnd(expression, optionalExpParams)));
    }


    public ILevel0SetOfMapOperator<K, V> removeAllNull() {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.removeAllNull()));
    }

    
    public ILevel0SetOfMapOperator<K, V> removeAllNullOr(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(SetFunc.removeAllNullOr(expression, optionalExpParams)));
    }




    public ILevel0SetOfMapOperator<K, V> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfMapOperator<K, V> sort(
            Comparator<? super Map<K, V>> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    @SuppressWarnings("unchecked")
    public Set<Map<K, V>> get() {
        return (Set<Map<K,V>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<Map<K, V>>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

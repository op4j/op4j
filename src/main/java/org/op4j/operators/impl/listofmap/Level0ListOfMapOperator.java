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
package org.op4j.operators.impl.listofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.op4j.Of;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ListFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ListOfMapOperator<K,V> extends Operator
        implements ILevel0ListOfMapOperator<K,V>  {

    
    public Level0ListOfMapOperator(final Target target) {
        super(target);
    }


    public ILevel0ListOfMapOperator<K, V> add(final Map<K, V> newElement) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.add(newElement)));
    }


    public ILevel0ListOfMapOperator<K, V> add(final int position, final Map<K, V> newElement) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.add(position, newElement)));
    }


    public ILevel0ListOfMapOperator<K, V> addAllValues(final Map<K, V>... newElements) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.addAllValues(newElements)));
    }


    public ILevel0ListOfMapOperator<K, V> addAllValues(final int position, final Map<K, V>... newElements) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.addAllValues(position, newElements)));
    }


    public ILevel0ListOfMapOperator<K, V> addAll(final Collection<Map<K, V>> collection) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.addAll(collection)));
    }


    public ILevel0ListOfMapOperator<K, V> distinct() {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.distinct()));
    }


    public ILevel0ListOfMapOperator<K, V> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfMapOperator<K, V> extract(Map<K, V> value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfMapOperator<K, V> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfMapOperator<K, V> extractAll(Map<K, V>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfMapOperator<K, V> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfMapOperator<K, V> extractAll(ISelect<Map<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfMapOperator<K, V> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfMapOperator<K, V> extractAllBut(Map<K, V>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfMapOperator<K, V> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfMapOperator<K, V> extractAllBut(
            ISelect<Map<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEach() {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterate());
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEach(final int... positions) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterate(positions));
    }


    


    public ILevel1ListOfMapElementsOperator<K, V> forEach(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEach(final ISelect<Map<K, V>> selector) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachNot(final int... positions) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNot(positions));
    }


    








    public ILevel1ListOfMapElementsOperator<K, V> forEachNotNull() {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNotNull());
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel1ListOfMapElementsOperator<K, V> forEachNull() {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNull());
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X, Y> ILevel0ListOfMapOperator<X, Y> of(Of<X> ofX, Of<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel0ListOfMapOperator<X, Y> of(Class<X> ofXClass,
            Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfMapOperator<?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfMapOperator<K, V> remove(final int position) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.remove(position)));
    }


    public ILevel0ListOfMapOperator<K, V> removeValue(final Map<K, V> value) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.removeValue(value)));
    }


    public ILevel0ListOfMapOperator<K, V> removeAll(final int... positions) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.removeAll(positions)));
    }


    public ILevel0ListOfMapOperator<K, V> removeAllValues(final Map<K, V>... values) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.removeAllValues(values)));
    }


    public ILevel0ListOfMapOperator<K, V> removeAll(final String expression, final Object... optionalExpParams) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.removeAll(expression, optionalExpParams)));
    }


    public ILevel0ListOfMapOperator<K, V> removeAll(final ISelect<Map<K, V>> selector) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.removeAll(selector)));
    }


    public ILevel0ListOfMapOperator<K, V> removeAllNot(final int... positions) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.removeAllNot(positions)));
    }


    public ILevel0ListOfMapOperator<K, V> removeAllValuesNot(final Map<K, V>... values) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.removeAllValuesNot(values)));
    }

    

    public ILevel0ListOfMapOperator<K, V> removeAllNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.removeAllNotNullAnd(expression, optionalExpParams)));
    }


    public ILevel0ListOfMapOperator<K, V> removeAllNull() {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.removeAllNull()));
    }

    
    public ILevel0ListOfMapOperator<K, V> removeAllNullOr(final String expression, final Object... optionalExpParams) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(ListFunc.removeAllNullOr(expression, optionalExpParams)));
    }




    public ILevel0ListOfMapOperator<K, V> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfMapOperator<K, V> sort(
            Comparator<? super Map<K, V>> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    @SuppressWarnings("unchecked")
    public List<Map<K, V>> get() {
        return (List<Map<K,V>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<List<Map<K, V>>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

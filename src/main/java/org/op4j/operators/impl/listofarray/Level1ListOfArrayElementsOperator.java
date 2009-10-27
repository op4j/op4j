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

import org.op4j.commands.IEval;
import org.op4j.op.intf.parameters.IMapBuild;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.parameters.ISelect;
import org.op4j.op.target.Target;
import org.op4j.op.target.Target.Structure;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listofarray.ILevel2ListOfArrayElementsElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListOfArrayElementsOperator<T> extends Operator
        implements ILevel1ListOfArrayElementsOperator<T>  {
    
    private final IOf<T> arrayOf; 

    
    public Level1ListOfArrayElementsOperator(final IOf<T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel1ListOfArrayElementsOperator<T> add(T newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> add(int position, T newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> addAll(T... newElements) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> addAll(Collection<T> collection) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> distinct() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<T> endFor() {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().endIterate(Structure.LIST, null));
    }


    public ILevel1ListOfArrayElementsOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extract(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAllBut(
            ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEach() {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEach(final int... positions) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(positions));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEach(
            String expression, Object... optionalExpParams) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNot(final int... positions) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNot(positions));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNot(expression, optionalExpParams));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNot(final ISelect<T> selector) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNot(selector));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNull() {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAndNot(expression, optionalExpParams));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNull() {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(expression, optionalExpParams));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNullOrNot(expression, optionalExpParams));
    }


    public <X> ILevel1ListOfArrayElementsOperator<X> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ListOfArrayElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> remove(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> remove(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> removeAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> removeAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> removeAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> removeAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> removeAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> removeAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> removeAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> removeAllBut(
            ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> sort(
            Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<T> toList() {
        // TODO Auto-generated method stub
        return null;
    }


    public <K> ILevel1ListOfMapElementsOperator<K, T> toMap(
            IEval<K, ? super T> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel1ListOfMapElementsOperator<K, V> toMap(
            IMapBuild<K, V, ? super T> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> toSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public List<T[]> get() {
        return endFor().get();
    }

}

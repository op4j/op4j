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
package org.op4j.operators.impl.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.IOf;
import org.op4j.commands.IEval;
import org.op4j.commands.IMapBuild;
import org.op4j.commands.ISelect;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
import org.op4j.operators.intf.listofset.ILevel2ListOfSetElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListOfSetElementsOperator<T> extends Operator
        implements ILevel1ListOfSetElementsOperator<T>  {

    
    public Level1ListOfSetElementsOperator(final Target target) {
        super(target);
    }


    public ILevel1ListOfSetElementsOperator<T> add(T newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> add(int position, T newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> addAll(T... newElements) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> addAll(Collection<T> collection) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfSetOperator<T> endFor() {
        return new Level0ListOfSetOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public ILevel1ListOfSetElementsOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extract(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAllBut(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEach() {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEach(final int... positions) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterate(positions));
    }


    


    public ILevel2ListOfSetElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNot(final int... positions) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNot(positions));
    }


    


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNot(expression, optionalExpParams));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNot(final ISelect<T> selector) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNot(selector));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotNull() {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNotNullAndNot(expression, optionalExpParams));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNull() {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNullOrNot(expression, optionalExpParams));
    }


    public <X> ILevel1ListOfSetElementsOperator<X> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ListOfSetElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> remove(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> remove(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> removeAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> removeAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> removeAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> removeAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> removeAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> removeAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> removeAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> removeAllBut(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> sort(
            Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ListOfArrayElementsOperator<X> toArray(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ListOfArrayElementsOperator<X> toArray(Class<X> of) {
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


    public List<Set<T>> get() {
        // TODO Auto-generated method stub
        return null;
    }

}
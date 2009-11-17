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
package org.op4j.operators.impl.listoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ListFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel2ListOfListElementsElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListOfListElementsOperator<T> extends Operator
        implements ILevel1ListOfListElementsOperator<T>  {

    
    public Level1ListOfListElementsOperator(final Target target) {
        super(target);
    }


    public ILevel1ListOfListElementsOperator<T> add(final T... newElements) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(ListFunc.add(newElements)));
    }


    public ILevel1ListOfListElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(ListFunc.insert(position, newElements)));
    }


    public ILevel1ListOfListElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(ListFunc.addAll(collection)));
    }


    public ILevel1ListOfListElementsOperator<T> distinct() {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(ListFunc.distinct()));
    }


    public ILevel0ListOfListOperator<T> endFor() {
        return new Level0ListOfListOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public ILevel1ListOfListElementsOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<T> extract(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<T> extractAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<T> extractAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<T> extractAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<T> extractAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<T> extractAllBut(
            ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEach() {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEach(final int... positions) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterate(positions));
    }


    


    public ILevel2ListOfListElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEachNot(final int... positions) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNot(positions));
    }


    








    public ILevel2ListOfListElementsElementsOperator<T> forEachNotNull() {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel2ListOfListElementsElementsOperator<T> forEachNull() {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel1ListOfListElementsOperator<X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ListOfListElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<T> removePositions(final int... positions) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(ListFunc.removePositions(positions)));
    }


    public ILevel1ListOfListElementsOperator<T> removeValues(final T... values) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(ListFunc.removeValues(values)));
    }


    public ILevel1ListOfListElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(ListFunc.removeMatching(expression, optionalExpParams)));
    }


    public ILevel1ListOfListElementsOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(ListFunc.removeSelected(selector)));
    }


    public ILevel1ListOfListElementsOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(ListFunc.removeAllExceptPositions(positions)));
    }



    public ILevel1ListOfListElementsOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(ListFunc.removeNotNullsMatching(expression, optionalExpParams)));
    }


    public ILevel1ListOfListElementsOperator<T> removeNulls() {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(ListFunc.removeNulls()));
    }

    


    public ILevel1ListOfListElementsOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<T> sort(
            Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ListOfArrayElementsOperator<X> toArray(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ListOfArrayElementsOperator<X> toArray(Class<X> of) {
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


    public List<List<T>> get() {
        return endFor().get();
    }

}

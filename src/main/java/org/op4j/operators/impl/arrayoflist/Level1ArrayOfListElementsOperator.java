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
package org.op4j.operators.impl.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Types;
import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ListFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel2ArrayOfListElementsElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayOfListElementsOperator<T> extends Operator
        implements ILevel1ArrayOfListElementsOperator<T>  {

    
    public Level1ArrayOfListElementsOperator(final Target target) {
        super(target);
    }


    public ILevel1ArrayOfListElementsOperator<T> add(final T newElement) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.add(newElement)));
    }


    public ILevel1ArrayOfListElementsOperator<T> add(final int position, final T newElement) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.add(position, newElement)));
    }


    public ILevel1ArrayOfListElementsOperator<T> addAllValues(final T... newElements) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.addAllValues(newElements)));
    }


    public ILevel1ArrayOfListElementsOperator<T> addAllValues(final int position, final T... newElements) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.addAllValues(position, newElements)));
    }


    public ILevel1ArrayOfListElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.addAll(collection)));
    }


    public ILevel1ArrayOfListElementsOperator<T> distinct() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.distinct()));
    }


    public ILevel0ArrayOfListOperator<T> endFor() {
        return new Level0ArrayOfListOperator<T>(getTarget().endIterate(Structure.ARRAY, Of.type(Types.LIST_OF_UNKNOWN)));
    }


    public ILevel1ArrayOfListElementsOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<T> extract(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<T> extractAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<T> extractAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<T> extractAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<T> extractAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<T> extractAllBut(
            ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEach() {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEach(final int... positions) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterate(positions));
    }


    


    public ILevel2ArrayOfListElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNot(final int... positions) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterateNot(positions));
    }


    








    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNull() {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNotNull() {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public <X> ILevel1ArrayOfListElementsOperator<X> of(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ArrayOfListElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<T> remove(final int position) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.remove(position)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeValue(final T value) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.removeValue(value)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeAll(final int... positions) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.removeAll(positions)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeAllValues(final T... values) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.removeAllValues(values)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeAll(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.removeAll(expression, optionalExpParams)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeAll(final ISelect<T> selector) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.removeAll(selector)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeAllNot(final int... positions) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.removeAllNot(positions)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeAllValuesNot(final T... values) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.removeAllValuesNot(values)));
    }

    

    public ILevel1ArrayOfListElementsOperator<T> removeAllNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.removeAllNotNullAnd(expression, optionalExpParams)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeAllNull() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.removeAllNull()));
    }

    
    public ILevel1ArrayOfListElementsOperator<T> removeAllNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(ListFunc.removeAllNullOr(expression, optionalExpParams)));
    }




    public ILevel1ArrayOfListElementsOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<T> sort(
            Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ArrayOfArrayElementsOperator<X> toArray(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ArrayOfArrayElementsOperator<X> toArray(Class<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K> ILevel1ArrayOfMapElementsOperator<K, T> toMap(
            IEval<K, ? super T> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel1ArrayOfMapElementsOperator<K, V> toMap(
            IMapBuild<K, V, ? super T> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> toSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public List<T>[] get() {
        return endFor().get();
    }

}

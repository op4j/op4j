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
package org.op4j.operators.impl.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ListFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.generic.ILevel0GenericMultiOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ListOperator<T> extends Operator
        implements ILevel0ListOperator<T>  {

    
    public Level0ListOperator(final Target target) {
        super(target);
    }


    public ILevel0ListOperator<T> add(final T... newElements) {
        return new Level0ListOperator<T>(getTarget().execute(ListFunc.addAllValues(newElements)));
    }


    public ILevel0ListOperator<T> insert(final int position, final T... newElements) {
        return new Level0ListOperator<T>(getTarget().execute(ListFunc.addAllValues(position, newElements)));
    }


    public ILevel0ListOperator<T> addAll(final Collection<T> collection) {
        return new Level0ListOperator<T>(getTarget().execute(ListFunc.addAll(collection)));
    }


    public ILevel0ListOperator<T> distinct() {
        return new Level0ListOperator<T>(getTarget().execute(ListFunc.distinct()));
    }


    public ILevel0ListOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<T> extract(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<T> extractAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<T> extractAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<T> extractAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<T> extractAllBut(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> flatten() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListElementsOperator<T> forEach() {
        return new Level1ListElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1ListElementsOperator<T> forEach(final int... positions) {
        return new Level1ListElementsOperator<T>(getTarget().iterate(positions));
    }


    


    public ILevel1ListElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level1ListElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1ListElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level1ListElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel1ListElementsOperator<T> forEachNot(final int... positions) {
        return new Level1ListElementsOperator<T>(getTarget().iterateNot(positions));
    }


    








    public ILevel1ListElementsOperator<T> forEachNotNull() {
        return new Level1ListElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1ListElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1ListElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel1ListElementsOperator<T> forEachNull() {
        return new Level1ListElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1ListElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1ListElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel0ListOperator<X> of(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ListOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<T> removePositions(final int... positions) {
        return new Level0ListOperator<T>(getTarget().execute(ListFunc.removeAll(positions)));
    }


    public ILevel0ListOperator<T> removeValues(final T... values) {
        return new Level0ListOperator<T>(getTarget().execute(ListFunc.removeAllValues(values)));
    }


    public ILevel0ListOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ListOperator<T>(getTarget().execute(ListFunc.removeAll(expression, optionalExpParams)));
    }


    public ILevel0ListOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level0ListOperator<T>(getTarget().execute(ListFunc.removeAll(selector)));
    }


    public ILevel0ListOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level0ListOperator<T>(getTarget().execute(ListFunc.removeAllNot(positions)));
    }



    public ILevel0ListOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ListOperator<T>(getTarget().execute(ListFunc.removeAllNotNullAnd(expression, optionalExpParams)));
    }


    public ILevel0ListOperator<T> removeNulls() {
        return new Level0ListOperator<T>(getTarget().execute(ListFunc.removeAllNull()));
    }

    


    public ILevel0ListOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<T> sort(Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOperator<X> toArray(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOperator<X> toArray(Class<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K> ILevel0MapOperator<K, T> toMap(IEval<K, ? super T> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOperator<K, V> toMap(
            IMapBuild<K, V, ? super T> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> toSet() {
        // TODO Auto-generated method stub
        return null;
    }


    @SuppressWarnings("unchecked")
    public List<T> get() {
        return (List<T>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<List<T>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

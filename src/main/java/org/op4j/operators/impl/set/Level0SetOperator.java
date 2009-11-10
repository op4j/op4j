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
package org.op4j.operators.impl.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.generic.ILevel0GenericMultiOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.set.ILevel1SetElementsOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0SetOperator<T> extends Operator
        implements ILevel0SetOperator<T>  {

    
    public Level0SetOperator(final Target target) {
        super(target);
    }


    public ILevel0SetOperator<T> add(T newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> add(int position, T newElement) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0SetOperator<T> addAllValues(T... newElements) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0SetOperator<T> addAllValues(int position, T... newElements) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> addAll(Collection<T> collection) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> extract(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> extractAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> extractAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> extractAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> extractAllBut(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> flatten() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetElementsOperator<T> forEach() {
        return new Level1SetElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1SetElementsOperator<T> forEach(final int... positions) {
        return new Level1SetElementsOperator<T>(getTarget().iterate(positions));
    }


    


    public ILevel1SetElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level1SetElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1SetElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level1SetElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel1SetElementsOperator<T> forEachNot(final int... positions) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNot(positions));
    }


    


    public ILevel1SetElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNot(expression, optionalExpParams));
    }


    public ILevel1SetElementsOperator<T> forEachNot(final ISelect<T> selector) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNot(selector));
    }


    public ILevel1SetElementsOperator<T> forEachNotNull() {
        return new Level1SetElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1SetElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }


    public ILevel1SetElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNotNullAndNot(expression, optionalExpParams));
    }


    public ILevel1SetElementsOperator<T> forEachNull() {
        return new Level1SetElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1SetElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }


    public ILevel1SetElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNullOrNot(expression, optionalExpParams));
    }


    public <X> ILevel0SetOperator<X> of(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> remove(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> removeValue(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> removeAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> removeAllValues(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> removeAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> removeAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> removeAllNot(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> removeAllValuesNot(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> removeAllNot(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> removeAllNot(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0SetOperator<T> removeAllNotNullsAnd(String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0SetOperator<T> removeAllNotNullsAndNot(String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0SetOperator<T> removeAllNulls() {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0SetOperator<T> removeAllNullsOr(String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0SetOperator<T> removeAllNullsOrNot(String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> sort(Comparator<? super T> comparator) {
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


    public ILevel0ListOperator<T> toList() {
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


    @SuppressWarnings("unchecked")
    public Set<T> get() {
        return (Set<T>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<T>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

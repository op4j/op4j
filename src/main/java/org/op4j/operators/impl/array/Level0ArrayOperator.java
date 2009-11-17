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
package org.op4j.operators.impl.array;

import java.util.Collection;
import java.util.Comparator;

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ArrayFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.array.ILevel1ArrayElementsOperator;
import org.op4j.operators.intf.generic.ILevel0GenericMultiOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
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
public class Level0ArrayOperator<T> extends Operator implements
        ILevel0ArrayOperator<T> {

    
    private final Of<? super T> arrayOf; 
    
    
    public Level0ArrayOperator(final Of<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }

    
    public ILevel0ArrayOperator<T> add(final T... newElements) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.add(newElements)));
    }


    public ILevel0ArrayOperator<T> insert(final int position, final T... newElements) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.insert(position, newElements)));
    }


    public ILevel0ArrayOperator<T> addAll(final Collection<T> collection) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.addAll(collection)));
    }

    public ILevel0ArrayOperator<T> distinct() {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.distinct()));
    }

    public ILevel0ArrayOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0ArrayOperator<T> extract(T value) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0ArrayOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0ArrayOperator<T> extractAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0ArrayOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0ArrayOperator<T> extractAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0ArrayOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0ArrayOperator<T> extractAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0ArrayOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0ArrayOperator<T> extractAllBut(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0GenericMultiOperator<T> flatten() {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel1ArrayElementsOperator<T> forEach() {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }

    public ILevel1ArrayElementsOperator<T> forEach(final int... positions) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(positions));
    }

    public ILevel1ArrayElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(expression, optionalExpParams));
    }

    public ILevel1ArrayElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }

    public ILevel1ArrayElementsOperator<T> forEachNot(final int... positions) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNot(positions));
    }





    public ILevel1ArrayElementsOperator<T> forEachNotNull() {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }

    public ILevel1ArrayElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }



    public ILevel1ArrayElementsOperator<T> forEachNull() {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }

    public ILevel1ArrayElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(expression, optionalExpParams));
    }



    public <X> ILevel0ArrayOperator<X> of(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }

    public <X> ILevel0ArrayOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0ArrayOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0ArrayOperator<T> removePositions(final int... positions) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.removePositions(positions)));
    }


    public ILevel0ArrayOperator<T> removeValues(final T... values) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.removeValues(values)));
    }


    public ILevel0ArrayOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.removeMatching(expression, optionalExpParams)));
    }


    public ILevel0ArrayOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.removeSelected(selector)));
    }


    public ILevel0ArrayOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.removeAllExceptPositions(positions)));
    }



    public ILevel0ArrayOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.removeNotNullsMatching(expression, optionalExpParams)));
    }


    public ILevel0ArrayOperator<T> removeNulls() {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.removeNulls()));
    }

    

    public ILevel0ArrayOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0ArrayOperator<T> sort(Comparator<? super T> comparator) {
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

    public ILevel0SetOperator<T> toSet() {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings("unchecked")
	public T[] get() {
        return (T[]) getTarget().get();
    }

    public ILevel0GenericUniqOperator<T[]> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

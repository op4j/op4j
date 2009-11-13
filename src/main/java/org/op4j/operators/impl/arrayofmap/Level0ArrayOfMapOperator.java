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
package org.op4j.operators.impl.arrayofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.op4j.Of;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ArrayFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ArrayOfMapOperator<K,V> extends Operator
        implements ILevel0ArrayOfMapOperator<K,V>  {

    
    public Level0ArrayOfMapOperator(final Target target) {
        super(target);
    }


    public ILevel0ArrayOfMapOperator<K, V> add(final Map<K, V>... newElements) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(ArrayFunc.add(newElements)));
    }


    public ILevel0ArrayOfMapOperator<K, V> insert(final int position, final Map<K, V>... newElements) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(ArrayFunc.insert(position, newElements)));
    }


    public ILevel0ArrayOfMapOperator<K, V> addAll(final Collection<Map<K, V>> collection) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(ArrayFunc.addAll(collection)));
    }


    public ILevel0ArrayOfMapOperator<K, V> distinct() {
        return new Level0ArrayOfMapOperator<K,V>(getTarget().execute(ArrayFunc.distinct()));
    }


    public ILevel0ArrayOfMapOperator<K, V> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfMapOperator<K, V> extract(Map<K, V> value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfMapOperator<K, V> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfMapOperator<K, V> extractAll(Map<K, V>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfMapOperator<K, V> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfMapOperator<K, V> extractAll(
            ISelect<Map<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfMapOperator<K, V> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfMapOperator<K, V> extractAllBut(Map<K, V>... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfMapOperator<K, V> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfMapOperator<K, V> extractAllBut(
            ISelect<Map<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEach() {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterate());
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEach(final int... positions) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterate(positions));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEach(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEach(final ISelect<Map<K, V>> selector) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEachNot(final int... positions) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterateNot(positions));
    }


    








    public ILevel1ArrayOfMapElementsOperator<K, V> forEachNotNull() {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterateNotNull());
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel1ArrayOfMapElementsOperator<K, V> forEachNull() {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterateNull());
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X, Y> ILevel0ArrayOfMapOperator<X, Y> of(Of<X> ofX, Of<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel0ArrayOfMapOperator<X, Y> of(Class<X> ofXClass,
            Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfMapOperator<?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfMapOperator<K, V> removePositions(final int... positions) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(ArrayFunc.removePositions(positions)));
    }


    public ILevel0ArrayOfMapOperator<K, V> removeValues(final Map<K, V>... values) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(ArrayFunc.removeValues(values)));
    }


    public ILevel0ArrayOfMapOperator<K, V> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(ArrayFunc.removeMatching(expression, optionalExpParams)));
    }


    public ILevel0ArrayOfMapOperator<K, V> removeSelected(final ISelect<Map<K, V>> selector) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(ArrayFunc.removeSelected(selector)));
    }


    public ILevel0ArrayOfMapOperator<K, V> removeAllExceptPositions(final int... positions) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(ArrayFunc.removeAllExceptPositions(positions)));
    }



    public ILevel0ArrayOfMapOperator<K, V> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(ArrayFunc.removeNotNullsMatching(expression, optionalExpParams)));
    }


    public ILevel0ArrayOfMapOperator<K, V> removeNulls() {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(ArrayFunc.removeNulls()));
    }

    


    public ILevel0ArrayOfMapOperator<K, V> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfMapOperator<K, V> sort(
            Comparator<? super Map<K, V>> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    @SuppressWarnings("unchecked")
	public Map<K, V>[] get() {
        return (Map<K, V>[]) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Map<K, V>[]> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

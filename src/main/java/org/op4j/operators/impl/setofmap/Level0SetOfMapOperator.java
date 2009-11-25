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

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.SetFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
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


    public ILevel0SetOfMapOperator<K, V> add(final Map<K, V>... newElements) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFunc.Add<Map<K, V>>(newElements)));
    }


    public ILevel0SetOfMapOperator<K, V> insert(final int position, final Map<K, V>... newElements) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFunc.Insert<Map<K, V>>(position, newElements)));
    }


    public ILevel0SetOfMapOperator<K, V> addAll(final Collection<Map<K, V>> collection) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFunc.AddAll<Map<K, V>>(collection)));
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





    public <X, Y> ILevel0SetOfMapOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        return new Level0SetOfMapOperator<X, Y>(getTarget());
    }


    public ILevel0SetOfMapOperator<?, ?> raw() {
        return new Level0SetOfMapOperator<K, V>(getTarget());
    }


    public ILevel0SetOfMapOperator<K, V> removePositions(final int... positions) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFunc.RemovePositions<Map<K, V>>(positions)));
    }


    public ILevel0SetOfMapOperator<K, V> removeValues(final Map<K, V>... values) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFunc.RemoveValues<Map<K, V>>(values)));
    }


    public ILevel0SetOfMapOperator<K, V> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFunc.RemoveMatching<Map<K, V>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0SetOfMapOperator<K, V> removeSelected(final ISelect<Map<K, V>> selector) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFunc.RemoveSelected<Map<K, V>>(selector)));
    }


    public ILevel0SetOfMapOperator<K, V> removeAllExceptPositions(final int... positions) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFunc.RemoveAllExceptPositions<Map<K, V>>(positions)));
    }


    public ILevel0SetOfMapOperator<K, V> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFunc.RemoveNotNullsMatching<Map<K, V>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0SetOfMapOperator<K, V> removeNulls() {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFunc.RemoveNulls<Map<K, V>>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0SetOfMapOperator<K, V> sort() {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFunc.Sort()));
    }


    public ILevel0SetOfMapOperator<K, V> sort(final Comparator<? super Map<K, V>> comparator) {
        return new Level0SetOfMapOperator<K, V>(getTarget().execute(new SetFunc.SortByComparator<Map<K, V>>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Set<Map<K, V>> get() {
        return (Set<Map<K,V>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<Map<K, V>>> generic() {
        return new Level0GenericUniqOperator<Set<Map<K, V>>>(getTarget());
    }

}

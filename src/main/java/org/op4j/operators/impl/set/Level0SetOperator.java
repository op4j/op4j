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

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.SetFunc;
import org.op4j.executables.functions.conversion.ToArray;
import org.op4j.executables.functions.conversion.ToList;
import org.op4j.executables.functions.conversion.ToMap;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.array.Level0ArrayOperator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.list.Level0ListOperator;
import org.op4j.operators.impl.map.Level0MapOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.set.ILevel1SetElementsOperator;
import org.op4j.target.Target;
import org.op4j.util.VarArgsUtil;


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


    public ILevel0SetOperator<T> add(final T... newElements) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.Add<T>(newElements)));
    }


    public ILevel0SetOperator<T> insert(final int position, final T... newElements) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.Insert<T>(position, newElements)));
    }


    public ILevel0SetOperator<T> addAll(final Collection<T> collection) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.AddAll<T>(collection)));
    }


    public ILevel1SetElementsOperator<T> forEach() {
        return new Level1SetElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1SetElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1SetElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel1SetElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetElementsOperator<T>(getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1SetElementsOperator<T> forEachMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1SetElementsOperator<T>(getTarget().iterate(eval));
    }


    public ILevel1SetElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1SetElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel1SetElementsOperator<T> forEachSelected(final ISelect<T> selector) {
        return new Level1SetElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel1SetElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel1SetElementsOperator<T> forEachNotNull() {
        return new Level1SetElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1SetElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNotNullAnd(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel1SetElementsOperator<T> forEachNull() {
        return new Level1SetElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1SetElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNullOr(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel0SetOperator<X> of(final Type<X> of) {
        return new Level0SetOperator<X>(getTarget());
    }


    public ILevel0SetOperator<?> raw() {
        return new Level0SetOperator<T>(getTarget());
    }


    public ILevel0SetOperator<T> removeIndexes(final int... indices) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.RemoveIndexes<T>(indices)));
    }


    public ILevel0SetOperator<T> removeEquals(final T... values) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.RemoveEquals<T>(values)));
    }


    public ILevel0SetOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.RemoveMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0SetOperator<T> removeMatching(final IEval<Boolean, ? super T> eval) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.RemoveMatching<T>(eval)));
    }


    public ILevel0SetOperator<T> removeNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel0SetOperator<T> removeNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel0SetOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.RemoveSelected<T>(selector)));
    }


    public ILevel0SetOperator<T> removeIndexesNot(final int... indices) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.RemoveIndexesNot<T>(indices)));
    }


    public ILevel0SetOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.RemoveNotNullMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0SetOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.RemoveNullOrMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0SetOperator<T> removeNulls() {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0SetOperator<T> sort() {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.Sort()));
    }


    public ILevel0SetOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFunc.SortByComparator<T>(comparator)));
    }


    public ILevel0ArrayOperator<T> toArray(final Type<T> of) {
        return new Level0ArrayOperator<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public ILevel0ListOperator<T> toList() {
        return new Level0ListOperator<T>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public ILevel0MapOperator<T, T> toMap() {
        return new Level0MapOperator<T, T>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }


    public <K> ILevel0MapOperator<K, T> toMap(final IEval<K, ? super T> keyEval) {
        return new Level0MapOperator<K, T>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOperator<K, V> toMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level0MapOperator<K, V>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    @SuppressWarnings("unchecked")
    public Set<T> get() {
        return (Set<T>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<T>> generic() {
        return new Level0GenericUniqOperator<Set<T>>(getTarget());
    }

}

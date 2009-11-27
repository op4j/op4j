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

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.ListFunc;
import org.op4j.executables.functions.conversion.ToArray;
import org.op4j.executables.functions.conversion.ToMap;
import org.op4j.executables.functions.conversion.ToSet;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.array.Level0ArrayOperator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.map.Level0MapOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.target.Target;
import org.op4j.util.VarArgsUtil;


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
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.Add<T>(newElements)));
    }


    public ILevel0ListOperator<T> insert(final int position, final T... newElements) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.Insert<T>(position, newElements)));
    }


    public ILevel0ListOperator<T> addAll(final Collection<T> collection) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.AddAll<T>(collection)));
    }


    public ILevel0ListOperator<T> distinct() {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.Distinct<T>()));
    }


    public ILevel1ListElementsOperator<T> forEach() {
        return new Level1ListElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1ListElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1ListElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel1ListElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListElementsOperator<T>(getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1ListElementsOperator<T> forEachMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ListElementsOperator<T>(getTarget().iterate(eval));
    }


    public ILevel1ListElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ListElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1ListElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ListElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel1ListElementsOperator<T> forEachSelected(final ISelect<T> selector) {
        return new Level1ListElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel1ListElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1ListElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel1ListElementsOperator<T> forEachNotNull() {
        return new Level1ListElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1ListElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListElementsOperator<T>(getTarget().iterateNotNullAnd(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel1ListElementsOperator<T> forEachNull() {
        return new Level1ListElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1ListElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListElementsOperator<T>(getTarget().iterateNullOr(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel0ListOperator<X> of(final Type<X> of) {
        return new Level0ListOperator<X>(getTarget());
    }


    public ILevel0ListOperator<?> raw() {
        return new Level0ListOperator<T>(getTarget());
    }


    public ILevel0ListOperator<T> removeIndexes(final int... indices) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.RemoveIndexes<T>(indices)));
    }


    public ILevel0ListOperator<T> removeEquals(final T... values) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.RemoveEquals<T>(values)));
    }


    public ILevel0ListOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.RemoveMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ListOperator<T> removeMatching(final IEval<Boolean, ? super T> eval) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.RemoveMatching<T>(eval)));
    }


    public ILevel0ListOperator<T> removeNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel0ListOperator<T> removeNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel0ListOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.RemoveSelected<T>(selector)));
    }


    public ILevel0ListOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.RemoveIndexesNot<T>(indices)));
    }


    public ILevel0ListOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.RemoveNotNullMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ListOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.RemoveNullOrMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ListOperator<T> removeNulls() {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0ListOperator<T> sort() {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.Sort()));
    }


    public ILevel0ListOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFunc.SortByComparator<T>(comparator)));
    }


    public ILevel0ArrayOperator<T> toArray(final Type<T> of) {
        return new Level0ArrayOperator<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public ILevel0MapOperator<T, T> toMap() {
        return new Level0MapOperator<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }

    public <K> ILevel0MapOperator<K, T> toMap(final IEval<K, ? super T> keyEval) {
        return new Level0MapOperator<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOperator<K, V> toMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level0MapOperator<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel0SetOperator<T> toSet() {
        return new Level0SetOperator<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    @SuppressWarnings("unchecked")
    public List<T> get() {
        return (List<T>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<List<T>> generic() {
        return new Level0GenericUniqOperator<List<T>>(getTarget());
    }


}

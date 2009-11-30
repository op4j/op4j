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

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuilder;
import org.op4j.executables.ISelector;
import org.op4j.executables.functions.ArrayFuncs;
import org.op4j.executables.functions.conversion.ToList;
import org.op4j.executables.functions.conversion.ToMap;
import org.op4j.executables.functions.conversion.ToSet;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.list.Level0ListOperator;
import org.op4j.operators.impl.map.Level0MapOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.array.ILevel1ArrayElementsOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
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
public class Level0ArrayOperator<T> extends Operator implements
        ILevel0ArrayOperator<T> {

    
    private final Type<? super T> arrayOf; 
    
    
    public Level0ArrayOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }

    
    public ILevel0ArrayOperator<T> add(final T... newElements) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public ILevel0ArrayOperator<T> insert(final int position, final T... newElements) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public ILevel0ArrayOperator<T> addAll(final Collection<T> collection) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }

    public ILevel0ArrayOperator<T> distinct() {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }

    public ILevel1ArrayElementsOperator<T> forEach() {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }

    public ILevel1ArrayElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(indices));
    }

    public ILevel1ArrayElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1ArrayElementsOperator<T> forEachMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(eval));
    }


    public ILevel1ArrayElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1ArrayElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(eval));
    }


    public ILevel1ArrayElementsOperator<T> forEachSelected(final ISelector<T> selector) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }

    public ILevel1ArrayElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNot(indices));
    }





    public ILevel1ArrayElementsOperator<T> forEachNotNull() {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }

    public ILevel1ArrayElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }



    public ILevel1ArrayElementsOperator<T> forEachNull() {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }

    public ILevel1ArrayElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public <X> ILevel0ArrayOperator<X> of(final Type<X> of) {
        return new Level0ArrayOperator<X>(of, getTarget());
    }

    public ILevel0ArrayOperator<?> raw() {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget());
    }

    public ILevel0ArrayOperator<T> removeIndexes(final int... indices) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public ILevel0ArrayOperator<T> removeEquals(final T... values) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public ILevel0ArrayOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ArrayOperator<T> removeMatching(final IEval<Boolean, ? super T> eval) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }


    public ILevel0ArrayOperator<T> removeNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel0ArrayOperator<T> removeNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel0ArrayOperator<T> removeSelected(final ISelector<T> selector) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveSelected<T>(selector)));
    }


    public ILevel0ArrayOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }



    public ILevel0ArrayOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }

    public ILevel0ArrayOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ArrayOperator<T> removeNulls() {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public ILevel0ArrayOperator<T> sort() {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }

    public ILevel0ArrayOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }

    public ILevel0ListOperator<T> toList() {
        return new Level0ListOperator<T>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public ILevel0MapOperator<T, T> toMap() {
        return new Level0MapOperator<T, T>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> ILevel0MapOperator<K, T> toMap(final IEval<K, ? super T> keyEval) {
        return new Level0MapOperator<K, T>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }

    public <K, V> ILevel0MapOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperator<K, V>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }

    public ILevel0SetOperator<T> toSet() {
        return new Level0SetOperator<T>(getTarget().execute(new ToSet.FromArray<T>()));
    }

    @SuppressWarnings("unchecked")
	public T[] get() {
        return (T[]) getTarget().get();
    }

    public ILevel0GenericUniqOperator<T[]> generic() {
        return new Level0GenericUniqOperator<T[]>(getTarget());
    }


}

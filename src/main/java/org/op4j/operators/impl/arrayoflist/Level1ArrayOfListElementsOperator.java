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

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ListFunc;
import org.op4j.executables.functions.conversion.ToArray;
import org.op4j.executables.functions.conversion.ToMap;
import org.op4j.executables.functions.conversion.ToSet;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.impl.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.impl.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel2ArrayOfListElementsElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;
import org.op4j.util.VarArgsUtil;


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


    public ILevel1ArrayOfListElementsOperator<T> add(final T... newElements) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.Add<T>(newElements)));
    }


    public ILevel1ArrayOfListElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.Insert<T>(position, newElements)));
    }


    public ILevel1ArrayOfListElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.AddAll<T>(collection)));
    }


    public ILevel1ArrayOfListElementsOperator<T> distinct() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.Distinct<T>()));
    }


    public ILevel0ArrayOfListOperator<T> endFor() {
        return new Level0ArrayOfListOperator<T>(getTarget().endIterate(Structure.ARRAY, List.class));
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEach() {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEachIndex(final int... indices) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel2ArrayOfListElementsElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEachMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterate(eval));
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEachSelected(final ISelect<T> selector) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNull() {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNotNull() {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterateNullOr(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget().iterateNotNullAnd(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel1ArrayOfListElementsOperator<X> of(final Type<X> of) {
        return new Level1ArrayOfListElementsOperator<X>(getTarget());
    }


    public ILevel1ArrayOfListElementsOperator<?> raw() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget());
    }


    public ILevel1ArrayOfListElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveIndexes<T>(indices)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeEquals(final T... values) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveEquals<T>(values)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveMatching<T>(eval)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveSelected<T>(selector)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveIndexesNot<T>(indices)));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveNotNullMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveNullOrMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ArrayOfListElementsOperator<T> removeNulls() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel1ArrayOfListElementsOperator<T> sort() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.Sort()));
    }


    public ILevel1ArrayOfListElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ListFunc.SortByComparator<T>(comparator)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> toArray(final Type<T> of) {
        return new Level1ArrayOfArrayElementsOperator<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public ILevel1ArrayOfMapElementsOperator<T, T> toMap() {
        return new Level1ArrayOfMapElementsOperator<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }

    
    public <K> ILevel1ArrayOfMapElementsOperator<K, T> toMap(final IEval<K, ? super T> keyEval) {
        return new Level1ArrayOfMapElementsOperator<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel1ArrayOfMapElementsOperator<K, V> toMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> toSet() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    public List<T>[] get() {
        return endFor().get();
    }


}

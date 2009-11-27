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
package org.op4j.operators.impl.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.SetFunc;
import org.op4j.executables.functions.conversion.ToArray;
import org.op4j.executables.functions.conversion.ToList;
import org.op4j.executables.functions.conversion.ToMap;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.impl.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.impl.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.operators.intf.setofset.ILevel2SetOfSetElementsElementsOperator;
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
public class Level1SetOfSetElementsOperator<T> extends Operator
        implements ILevel1SetOfSetElementsOperator<T>  {

    
    public Level1SetOfSetElementsOperator(final Target target) {
        super(target);
    }


    public ILevel1SetOfSetElementsOperator<T> add(final T... newElements) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.Add<T>(newElements)));
    }


    public ILevel1SetOfSetElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.Insert<T>(position, newElements)));
    }


    public ILevel1SetOfSetElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.AddAll<T>(collection)));
    }


    public ILevel0SetOfSetOperator<T> endFor() {
        return new Level0SetOfSetOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEach() {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachIndex(final int... indices) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel2SetOfSetElementsElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterate(eval));
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachSelected(final ISelect<T> selector) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotNull() {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNotNullAnd(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel2SetOfSetElementsElementsOperator<T> forEachNull() {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNullOr(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel1SetOfSetElementsOperator<X> of(final Type<X> of) {
        return new Level1SetOfSetElementsOperator<X>(getTarget());
    }


    public ILevel1SetOfSetElementsOperator<?> raw() {
        return new Level1SetOfSetElementsOperator<T>(getTarget());
    }


    public ILevel1SetOfSetElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveIndexes<T>(indices)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeEquals(final T... values) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveEquals<T>(values)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1SetOfSetElementsOperator<T> removeMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveMatching<T>(eval)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveSelected<T>(selector)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveIndexesNot<T>(indices)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveNotNullMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1SetOfSetElementsOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveNullOrMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1SetOfSetElementsOperator<T> removeNulls() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel1SetOfSetElementsOperator<T> sort() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.Sort()));
    }


    public ILevel1SetOfSetElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFunc.SortByComparator<T>(comparator)));
    }


    public ILevel1SetOfArrayElementsOperator<T> toArray(final Type<T> of) {
        return new Level1SetOfArrayElementsOperator<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public ILevel1SetOfListElementsOperator<T> toList() {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public ILevel1SetOfMapElementsOperator<T, T> toMap() {
        return new Level1SetOfMapElementsOperator<T, T>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }


    public <K> ILevel1SetOfMapElementsOperator<K, T> toMap(final IEval<K, ? super T> keyEval) {
        return new Level1SetOfMapElementsOperator<K, T>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel1SetOfMapElementsOperator<K, V> toMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    public Set<Set<T>> get() {
        return endFor().get();
    }

}

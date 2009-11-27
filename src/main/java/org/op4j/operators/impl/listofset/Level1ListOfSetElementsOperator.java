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
package org.op4j.operators.impl.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
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
import org.op4j.operators.impl.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.impl.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.impl.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
import org.op4j.operators.intf.listofset.ILevel2ListOfSetElementsElementsOperator;
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
public class Level1ListOfSetElementsOperator<T> extends Operator
        implements ILevel1ListOfSetElementsOperator<T>  {

    
    public Level1ListOfSetElementsOperator(final Target target) {
        super(target);
    }


    public ILevel1ListOfSetElementsOperator<T> add(final T... newElements) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.Add<T>(newElements)));
    }


    public ILevel1ListOfSetElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.Insert<T>(position, newElements)));
    }


    public ILevel1ListOfSetElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.AddAll<T>(collection)));
    }


    public ILevel0ListOfSetOperator<T> endFor() {
        return new Level0ListOfSetOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEach() {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachIndex(final int... indices) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel2ListOfSetElementsElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterate(eval));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachSelected(final ISelect<T> selector) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotNull() {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNotNullAnd(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel2ListOfSetElementsElementsOperator<T> forEachNull() {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNullOr(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel1ListOfSetElementsOperator<X> of(final Type<X> of) {
        return new Level1ListOfSetElementsOperator<X>(getTarget());
    }


    public ILevel1ListOfSetElementsOperator<?> raw() {
        return new Level1ListOfSetElementsOperator<T>(getTarget());
    }


    public ILevel1ListOfSetElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveIndexes<T>(indices)));
    }


    public ILevel1ListOfSetElementsOperator<T> removeEquals(final T... values) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveEquals<T>(values)));
    }


    public ILevel1ListOfSetElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ListOfSetElementsOperator<T> removeMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveMatching<T>(eval)));
    }


    public ILevel1ListOfSetElementsOperator<T> removeNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel1ListOfSetElementsOperator<T> removeNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel1ListOfSetElementsOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveSelected<T>(selector)));
    }


    public ILevel1ListOfSetElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveIndexesNot<T>(indices)));
    }


    public ILevel1ListOfSetElementsOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveNotNullMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ListOfSetElementsOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveNullOrMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ListOfSetElementsOperator<T> removeNulls() {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel1ListOfSetElementsOperator<T> sort() {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.Sort()));
    }


    public ILevel1ListOfSetElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new SetFunc.SortByComparator<T>(comparator)));
    }


    public ILevel1ListOfArrayElementsOperator<T> toArray(final Type<T> of) {
        return new Level1ListOfArrayElementsOperator<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public ILevel1ListOfListElementsOperator<T> toList() {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public ILevel1ListOfMapElementsOperator<T, T> toMap() {
        return new Level1ListOfMapElementsOperator<T, T>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }

    
    public <K> ILevel1ListOfMapElementsOperator<K, T> toMap(final IEval<K, ? super T> keyEval) {
        return new Level1ListOfMapElementsOperator<K, T>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel1ListOfMapElementsOperator<K, V> toMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    public List<Set<T>> get() {
        return endFor().get();
    }


}

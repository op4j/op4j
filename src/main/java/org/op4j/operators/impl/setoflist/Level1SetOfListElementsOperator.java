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
package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.ListFuncs;
import org.op4j.executables.functions.conversion.ToArray;
import org.op4j.executables.functions.conversion.ToMap;
import org.op4j.executables.functions.conversion.ToSet;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.impl.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.impl.setofset.Level1SetOfSetElementsOperator;
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel2SetOfListElementsElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
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
public class Level1SetOfListElementsOperator<T> extends Operator
        implements ILevel1SetOfListElementsOperator<T>  {

    
    public Level1SetOfListElementsOperator(final Target target) {
        super(target);
    }


    public ILevel1SetOfListElementsOperator<T> add(final T... newElements) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public ILevel1SetOfListElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public ILevel1SetOfListElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public ILevel1SetOfListElementsOperator<T> distinct() {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public ILevel0SetOfListOperator<T> endFor() {
        return new Level0SetOfListOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEach() {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachIndex(final int... indices) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel2SetOfListElementsElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterate(eval));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachSelected(final ISelect<T> selector) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNull() {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNotNullAnd(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel2SetOfListElementsElementsOperator<T> forEachNull() {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNullOr(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel1SetOfListElementsOperator<X> of(final Type<X> of) {
        return new Level1SetOfListElementsOperator<X>(getTarget());
    }


    public ILevel1SetOfListElementsOperator<?> raw() {
        return new Level1SetOfListElementsOperator<T>(getTarget());
    }


    public ILevel1SetOfListElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public ILevel1SetOfListElementsOperator<T> removeEquals(final T... values) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public ILevel1SetOfListElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1SetOfListElementsOperator<T> removeMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }


    public ILevel1SetOfListElementsOperator<T> removeNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel1SetOfListElementsOperator<T> removeNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel1SetOfListElementsOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveSelected<T>(selector)));
    }


    public ILevel1SetOfListElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public ILevel1SetOfListElementsOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1SetOfListElementsOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1SetOfListElementsOperator<T> removeNulls() {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel1SetOfListElementsOperator<T> sort() {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public ILevel1SetOfListElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public ILevel1SetOfArrayElementsOperator<T> toArray(final Type<T> of) {
        return new Level1SetOfArrayElementsOperator<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public ILevel1SetOfMapElementsOperator<T, T> toMap() {
        return new Level1SetOfMapElementsOperator<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }


    public <K> ILevel1SetOfMapElementsOperator<K, T> toMap(final IEval<K, ? super T> keyEval) {
        return new Level1SetOfMapElementsOperator<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel1SetOfMapElementsOperator<K, V> toMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel1SetOfSetElementsOperator<T> toSet() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    public Set<List<T>> get() {
        return endFor().get();
    }

}

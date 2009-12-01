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
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
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
import org.op4j.select.ISelector;
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
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public ILevel1SetOfSetElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public ILevel1SetOfSetElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
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
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterate(Eval.forBoolean(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterate(eval));
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachSelected(final ISelector<T> selector) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotNull() {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNotNullAnd(Eval.forBoolean(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel2SetOfSetElementsElementsOperator<T> forEachNull() {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel2SetOfSetElementsElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget().iterateNullOr(Eval.forBoolean(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel1SetOfSetElementsOperator<X> of(final Type<X> of) {
        return new Level1SetOfSetElementsOperator<X>(getTarget());
    }


    public ILevel1SetOfSetElementsOperator<?> raw() {
        return new Level1SetOfSetElementsOperator<T>(getTarget());
    }


    public ILevel1SetOfSetElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveIndexes<T>(indices)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeEquals(final T... values) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveEquals<T>(values)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveMatching<T>(Eval.forBoolean(expression, optionalExpParams))));
    }


    public ILevel1SetOfSetElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveMatching<T>(eval)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeSelected(final ISelector<T> selector) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveSelected<T>(selector)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<T>(indices)));
    }


    public ILevel1SetOfSetElementsOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<T>(Eval.forBoolean(expression, optionalExpParams))));
    }


    public ILevel1SetOfSetElementsOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<T>(Eval.forBoolean(expression, optionalExpParams))));
    }


    public ILevel1SetOfSetElementsOperator<T> removeNulls() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel1SetOfSetElementsOperator<T> sort() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public ILevel1SetOfSetElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
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


    public <K> ILevel1SetOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1SetOfMapElementsOperator<K, T>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel1SetOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    public Set<Set<T>> get() {
        return endFor().get();
    }

}

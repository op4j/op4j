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
package org.op4j.operators.impl.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.select.ISelector;
import org.op4j.target.Target;
import org.op4j.util.VarArgsUtil;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0SetOfArrayOperator<T> extends Operator
        implements ILevel0SetOfArrayOperator<T>  {
    
    private final Type<? super T> arrayOf; 

    
    public Level0SetOfArrayOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel0SetOfArrayOperator<T> add(final T[]... newElements) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.Add<T[]>(newElements)));
    }


    public ILevel0SetOfArrayOperator<T> insert(final int position, final T[]... newElements) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.Insert<T[]>(position, newElements)));
    }


    public ILevel0SetOfArrayOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.AddAll<T[]>(collection)));
    }


    public ILevel0SetOperator<T> flatten() {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.FlattenSetOfArrays<T>()));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEach() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(indices));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(eval));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(eval));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachSelected(final ISelector<T[]> selector) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNot(indices));
    }








    public ILevel1SetOfArrayElementsOperator<T> forEachNotNull() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel1SetOfArrayElementsOperator<T> forEachNull() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel1SetOfArrayElementsOperator<T> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel0SetOfArrayOperator<X> of(final Type<X> of) {
        return new Level0SetOfArrayOperator<X>(of, getTarget());
    }


    public ILevel0SetOfArrayOperator<?> raw() {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget());
    }


    public ILevel0SetOfArrayOperator<T> removeIndexes(final int... indices) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveIndexes<T[]>(indices)));
    }


    public ILevel0SetOfArrayOperator<T> removeEquals(final T[]... values) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveEquals<T[]>(values)));
    }


    public ILevel0SetOfArrayOperator<T> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveMatching<T[]>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0SetOfArrayOperator<T> removeMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveMatching<T[]>(eval)));
    }


    public ILevel0SetOfArrayOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveNullOrMatching<T[]>(eval)));
    }


    public ILevel0SetOfArrayOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveNotNullMatching<T[]>(eval)));
    }


    public ILevel0SetOfArrayOperator<T> removeSelected(final ISelector<T[]> selector) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveSelected<T[]>(selector)));
    }


    public ILevel0SetOfArrayOperator<T> removeIndexesNot(final int... indices) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveIndexesNot<T[]>(indices)));
    }


    public ILevel0SetOfArrayOperator<T> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveNotNullMatching<T[]>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }

    public ILevel0SetOfArrayOperator<T> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveNullOrMatching<T[]>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0SetOfArrayOperator<T> removeNulls() {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveNulls<T[]>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0SetOfArrayOperator<T> sort() {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.Sort()));
    }


    public ILevel0SetOfArrayOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().execute(new SetFuncs.SortByComparator<T[]>(comparator)));
    }


    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return Op.onArrayOfArray(Op.onSet(get()).toArray(Types.arrayOf(of)).get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfListOperator<T> toArrayOfList() {
        return Op.onArrayOfList(Op.onSet(forEach().toList().get()).toArray((Type<List<T>>)((Type<?>)Types.LIST_OF_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K> ILevel0ArrayOfMapOperator<K, T> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onArrayOfMap(Op.onSet(forEach().toMap(keyEval).get()).toArray((Type<Map<K, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K, V> ILevel0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onArrayOfMap(Op.onSet(forEach().toMap(mapBuild).get()).toArray((Type<Map<K, V>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfSetOperator<T> toArrayOfSet() {
        return Op.onArrayOfSet(Op.onSet(forEach().toSet().get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get());
    }


    public ILevel0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(of, Op.onSet(get()).toList().get());
    }


    public ILevel0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onSet(forEach().toList().get()).toList().get());
    }


    public <K> ILevel0ListOfMapOperator<K, T> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onListOfMap(Op.onSet(forEach().toMap(keyEval).get()).toList().get());
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onListOfMap(Op.onSet(forEach().toMap(mapBuild).get()).toList().get());
    }


    public ILevel0ListOfSetOperator<T> toListOfSet() {
        return Op.onListOfSet(Op.onSet(forEach().toSet().get()).toList().get());
    }


    public ILevel0SetOfListOperator<T> toSetOfList() {
        return forEach().toList().endFor();
    }


    public <K> ILevel0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public ILevel0SetOfSetOperator<T> toSetOfSet() {
        return forEach().toSet().endFor();
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return Op.onArrayOfMap(Op.onSet(forEach().toMap().get()).toArray((Type<Map<T, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    public ILevel0ListOfMapOperator<T, T> toListOfMap() {
        return Op.onListOfMap(Op.onSet(forEach().toMap().get()).toList().get());
    }


    public ILevel0SetOfMapOperator<T, T> toSetOfMap() {
        return forEach().toMap().endFor();
    }


    @SuppressWarnings("unchecked")
    public Set<T[]> get() {
        return (Set<T[]>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<T[]>> generic() {
        return new Level0GenericUniqOperator<Set<T[]>>(getTarget());
    }

}

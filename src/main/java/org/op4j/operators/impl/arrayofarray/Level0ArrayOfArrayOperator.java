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
package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.Op;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuilder;
import org.op4j.executables.ISelector;
import org.op4j.executables.functions.ArrayFuncs;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.array.Level0ArrayOperator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.target.Target;
import org.op4j.util.VarArgsUtil;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ArrayOfArrayOperator<T> extends Operator
        implements ILevel0ArrayOfArrayOperator<T> {
    
    private final Type<? super T> arrayOf; 

    
    
    public Level0ArrayOfArrayOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel0ArrayOfArrayOperator<T> add(final T[]... newElements) {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Add<T[]>(newElements)));
    }


    public ILevel0ArrayOfArrayOperator<T> insert(final int position, final T[]... newElements) {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Insert<T[]>(position, newElements)));
    }


    public ILevel0ArrayOfArrayOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.AddAll<T[]>(collection)));
    }


    public ILevel0ArrayOfArrayOperator<T> distinct() {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Distinct<T[]>()));
    }


    public ILevel0ArrayOperator<T> flatten(final Type<? super T> type) {
        return new Level0ArrayOperator<T>(type, getTarget().execute(new ArrayFuncs.FlattenArrayOfArrays<T>(type)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEach() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(indices));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachMatching(final IEval<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(eval));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(eval));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachSelected(final ISelector<T[]> selector) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNot(indices));
    }








    public ILevel1ArrayOfArrayElementsOperator<T> forEachNotNull() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel1ArrayOfArrayElementsOperator<T> forEachNull() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel1ArrayOfArrayElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel0ArrayOfArrayOperator<X> of(final Type<X> of) {
        return new Level0ArrayOfArrayOperator<X>(of, getTarget());
    }


    public ILevel0ArrayOfArrayOperator<?> raw() {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget());
    }


    public ILevel0ArrayOfArrayOperator<T> removeIndexes(final int... indices) {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexes<T[]>(indices)));
    }


    public ILevel0ArrayOfArrayOperator<T> removeEquals(final T[]... values) {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveEquals<T[]>(values)));
    }


    public ILevel0ArrayOfArrayOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<T[]>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ArrayOfArrayOperator<T> removeMatching(final IEval<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<T[]>(eval)));
    }


    public ILevel0ArrayOfArrayOperator<T> removeNullOrMatching(final IEval<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T[]>(eval)));
    }


    public ILevel0ArrayOfArrayOperator<T> removeNotNullMatching(final IEval<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T[]>(eval)));
    }


    public ILevel0ArrayOfArrayOperator<T> removeSelected(final ISelector<T[]> selector) {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveSelected<T[]>(selector)));
    }


    public ILevel0ArrayOfArrayOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T[]>(indices)));
    }



    public ILevel0ArrayOfArrayOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T[]>(Eval.booleanExp(expression, optionalExpParams))));
    }

    public ILevel0ArrayOfArrayOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T[]>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0ArrayOfArrayOperator<T> removeNulls() {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNulls<T[]>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfArrayOperator<T> sort() {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public ILevel0ArrayOfArrayOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<T[]>(comparator)));
    }


    public ILevel0ArrayOfListOperator<T> toArrayOfList() {
        return forEach().toList().endFor();
    }


    public <K> ILevel0ArrayOfMapOperator<K, T> toArrayOfMap(final IEval<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> ILevel0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public ILevel0ArrayOfSetOperator<T> toArrayOfSet() {
        return forEach().toSet().endFor();
    }


    public ILevel0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(of, Op.onArray(get()).toList().get());
    }


    public ILevel0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onArray(forEach().toList().get()).toList().get());
    }


    public <K> ILevel0ListOfMapOperator<K, T> toListOfMap(final IEval<K, ? super T> keyEval) {
        return Op.onListOfMap(Op.onArray(forEach().toMap(keyEval).get()).toList().get());
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onListOfMap(Op.onArray(forEach().toMap(mapBuild).get()).toList().get());
    }


    public ILevel0ListOfSetOperator<T> toListOfSet() {
        return Op.onListOfSet(Op.onArray(forEach().toSet().get()).toList().get());
    }


    public ILevel0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(of, Op.onArray(get()).toSet().get());
    }


    public ILevel0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(Op.onArray(forEach().toList().get()).toSet().get());
    }


    public <K> ILevel0SetOfMapOperator<K, T> toSetOfMap(final IEval<K, ? super T> keyEval) {
        return Op.onSetOfMap(Op.onArray(forEach().toMap(keyEval).get()).toSet().get());
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onSetOfMap(Op.onArray(forEach().toMap(mapBuild).get()).toSet().get());
    }


    public ILevel0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(Op.onArray(forEach().toSet().get()).toSet().get());
    }


    public ILevel0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return forEach().toMap().endFor();
    }


    public ILevel0ListOfMapOperator<T, T> toListOfMap() {
        return Op.onListOfMap(Op.onArray(forEach().toMap().get()).toList().get());
    }


    public ILevel0SetOfMapOperator<T, T> toSetOfMap() {
        return Op.onSetOfMap(Op.onArray(forEach().toMap().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
	public T[][] get() {
        return (T[][]) getTarget().get();
    }


    public ILevel0GenericUniqOperator<T[][]> generic() {
        return new Level0GenericUniqOperator<T[][]>(getTarget());
    }

}

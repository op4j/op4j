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
package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

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
import org.op4j.operators.impl.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.impl.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.impl.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listofarray.ILevel2ListOfArrayElementsElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
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
public class Level1ListOfArrayElementsOperator<T> extends Operator
        implements ILevel1ListOfArrayElementsOperator<T>  {
    
    private final Type<? super T> arrayOf; 

    
    public Level1ListOfArrayElementsOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel1ListOfArrayElementsOperator<T> add(final T... newElements) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public ILevel1ListOfArrayElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public ILevel1ListOfArrayElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public ILevel1ListOfArrayElementsOperator<T> distinct() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public ILevel0ListOfArrayOperator<T> endFor() {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().endIterate(Structure.LIST, null));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEach() {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachIndex(final int... indices) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(indices));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(eval));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(eval));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(eval));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachSelected(final ISelector<T> selector) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNot(indices));
    }








    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNull() {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNull() {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel1ListOfArrayElementsOperator<X> of(final Type<X> of) {
        return new Level1ListOfArrayElementsOperator<X>(of, getTarget());
    }


    public ILevel1ListOfArrayElementsOperator<?> raw() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget());
    }


    public ILevel1ListOfArrayElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeEquals(final T... values) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeNullOrMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeNotNullMatching(final IEval<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeSelected(final ISelector<T> selector) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveSelected<T>(selector)));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }



    public ILevel1ListOfArrayElementsOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }

    public ILevel1ListOfArrayElementsOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeNulls() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public ILevel1ListOfArrayElementsOperator<T> sort() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }

    public ILevel1ListOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public ILevel1ListOfListElementsOperator<T> toList() {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public ILevel1ListOfMapElementsOperator<T, T> toMap() {
        return new Level1ListOfMapElementsOperator<T, T>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> ILevel1ListOfMapElementsOperator<K, T> toMap(final IEval<K, ? super T> keyEval) {
        return new Level1ListOfMapElementsOperator<K, T>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel1ListOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel1ListOfSetElementsOperator<T> toSet() {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new ToSet.FromArray<T>()));
    }


    public List<T[]> get() {
        return endFor().get();
    }


}

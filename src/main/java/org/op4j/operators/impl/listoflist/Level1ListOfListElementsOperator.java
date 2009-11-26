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
package org.op4j.operators.impl.listoflist;

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
import org.op4j.operators.impl.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.impl.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.impl.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel2ListOfListElementsElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListOfListElementsOperator<T> extends Operator
        implements ILevel1ListOfListElementsOperator<T>  {

    
    public Level1ListOfListElementsOperator(final Target target) {
        super(target);
    }


    public ILevel1ListOfListElementsOperator<T> add(final T... newElements) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFunc.Add<T>(newElements)));
    }


    public ILevel1ListOfListElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFunc.Insert<T>(position, newElements)));
    }


    public ILevel1ListOfListElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFunc.AddAll<T>(collection)));
    }


    public ILevel1ListOfListElementsOperator<T> distinct() {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFunc.Distinct<T>()));
    }


    public ILevel0ListOfListOperator<T> endFor() {
        return new Level0ListOfListOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEach() {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEach(final int... indices) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel2ListOfListElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEachNot(final int... indices) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel2ListOfListElementsElementsOperator<T> forEachNotNull() {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel2ListOfListElementsElementsOperator<T> forEachNull() {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel1ListOfListElementsOperator<X> of(final Type<X> of) {
        return new Level1ListOfListElementsOperator<X>(getTarget());
    }


    public ILevel1ListOfListElementsOperator<?> raw() {
        return new Level1ListOfListElementsOperator<T>(getTarget());
    }


    public ILevel1ListOfListElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveIndexes<T>(indices)));
    }


    public ILevel1ListOfListElementsOperator<T> removeEquals(final T... values) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveEquals<T>(values)));
    }


    public ILevel1ListOfListElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ListOfListElementsOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveSelected<T>(selector)));
    }


    public ILevel1ListOfListElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveIndexesNot<T>(indices)));
    }


    public ILevel1ListOfListElementsOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveNotNullMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ListOfListElementsOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveNullOrMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ListOfListElementsOperator<T> removeNulls() {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFunc.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel1ListOfListElementsOperator<T> sort() {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFunc.Sort()));
    }


    public ILevel1ListOfListElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFunc.SortByComparator<T>(comparator)));
    }


    public ILevel1ListOfArrayElementsOperator<T> toArray(final Type<T> of) {
        return new Level1ListOfArrayElementsOperator<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public ILevel1ListOfMapElementsOperator<T, T> toMap() {
        return new Level1ListOfMapElementsOperator<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }

    
    public <K> ILevel1ListOfMapElementsOperator<K, T> toMap(final IEval<K, ? super T> keyEval) {
        return new Level1ListOfMapElementsOperator<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel1ListOfMapElementsOperator<K, V> toMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel1ListOfSetElementsOperator<T> toSet() {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    public List<List<T>> get() {
        return endFor().get();
    }


}

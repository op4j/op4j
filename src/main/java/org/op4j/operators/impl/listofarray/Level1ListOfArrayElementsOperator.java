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
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ArrayFunc;
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
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.Add<T>(newElements)));
    }


    public ILevel1ListOfArrayElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.Insert<T>(position, newElements)));
    }


    public ILevel1ListOfArrayElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.AddAll<T>(collection)));
    }


    public ILevel1ListOfArrayElementsOperator<T> distinct() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.Distinct<T>()));
    }


    public ILevel0ListOfArrayOperator<T> endFor() {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().endIterate(Structure.LIST, null));
    }


    public ILevel1ListOfArrayElementsOperator<T> extract(final int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extract(final T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAll(final int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAll(final T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAll(final String expression, final Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAll(final ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAllBut(final int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAllBut(final T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAllBut(final String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> extractAllBut(final ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEach() {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEach(final int... positions) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(positions));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEach(
            String expression, Object... optionalExpParams) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNot(final int... positions) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNot(positions));
    }








    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNull() {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNull() {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel1ListOfArrayElementsOperator<X> of(final Type<X> of) {
        return new Level1ListOfArrayElementsOperator<X>(of, getTarget());
    }


    public ILevel1ListOfArrayElementsOperator<?> raw() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget());
    }


    public ILevel1ListOfArrayElementsOperator<T> removePositions(final int... positions) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.RemovePositions<T>(positions)));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeValues(final T... values) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.RemoveValues<T>(values)));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.RemoveMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.RemoveSelected<T>(selector)));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.RemoveAllExceptPositions<T>(positions)));
    }



    public ILevel1ListOfArrayElementsOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.RemoveNotNullsMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeNulls() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.RemoveNulls<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public ILevel1ListOfArrayElementsOperator<T> sort() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.Sort()));
    }

    public ILevel1ListOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.SortByComparator<T>(comparator)));
    }


    public ILevel1ListOfListElementsOperator<T> toList() {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public <K> ILevel1ListOfMapElementsOperator<K, T> toMap(final IEval<K, ? super T> keyEval) {
        return new Level1ListOfMapElementsOperator<K, T>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel1ListOfMapElementsOperator<K, V> toMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel1ListOfSetElementsOperator<T> toSet() {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new ToSet.FromArray<T>()));
    }


    public List<T[]> get() {
        return endFor().get();
    }

}

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

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ArrayFunc;
import org.op4j.executables.functions.conversion.ToList;
import org.op4j.executables.functions.conversion.ToSet;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.impl.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.ILevel2ArrayOfArrayElementsElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayOfArrayElementsOperator<T> extends Operator
        implements ILevel1ArrayOfArrayElementsOperator<T> {
    
    private final Type<? super T> arrayOf; 

    
    public Level1ArrayOfArrayElementsOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> add(final T... newElements) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.Add<T>(newElements)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.Insert<T>(position, newElements)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.AddAll<T>(collection)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> distinct() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.Distinct<T>()));
    }


	public ILevel0ArrayOfArrayOperator<T> endFor() {
    	final Class<?> ofComponentClass = this.arrayOf.getRawClass();
    	final Class<?> ofOfComponentClass = Array.newInstance(ofComponentClass,0).getClass();
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, ofOfComponentClass));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> extract(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> extractAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> extractAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> extractAllBut(
            int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> extractAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> extractAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> extractAllBut(
            ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEach() {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEach(final int... positions) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(positions));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNot(final int... positions) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNot(positions));
    }








    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNotNull() {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNull() {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel1ArrayOfArrayElementsOperator<X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ArrayOfArrayElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfArrayElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removePositions(final int... positions) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.RemovePositions<T>(positions)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeValues(final T... values) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.RemoveValues<T>(values)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.RemoveMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.RemoveSelected<T>(selector)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.RemoveAllExceptPositions<T>(positions)));
    }



    public ILevel1ArrayOfArrayElementsOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.RemoveNotNullsMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeNulls() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel1ArrayOfArrayElementsOperator<T> sort() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.Sort()));
    }


    @SuppressWarnings("unchecked")
    public ILevel1ArrayOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFunc.Sort(comparator)));
    }


    public ILevel1ArrayOfListElementsOperator<T> toList() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public <K> ILevel1ArrayOfMapElementsOperator<K, T> toMap(final IEval<K, ? super T> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel1ArrayOfMapElementsOperator<K, V> toMap(final IMapBuild<K, V, ? super T> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> toSet() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new ToSet.FromArray<T>()));
    }


    public T[][] get() {
        return endFor().get();
    }

}

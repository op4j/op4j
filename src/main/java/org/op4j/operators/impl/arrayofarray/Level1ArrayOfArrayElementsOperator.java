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

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ArrayFunc;
import org.op4j.operators.impl.Operator;
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
    
    private final Of<T> arrayOf; 

    
    public Level1ArrayOfArrayElementsOperator(final Of<T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> add(final T... newElements) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.add(newElements)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.insert(position, newElements)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.addAll(collection)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> distinct() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.distinct()));
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





    public <X> ILevel1ArrayOfArrayElementsOperator<X> of(Of<X> of) {
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
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.removePositions(positions)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeValues(final T... values) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.removeValues(values)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.removeMatching(expression, optionalExpParams)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.removeSelected(selector)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.removeAllExceptPositions(positions)));
    }



    public ILevel1ArrayOfArrayElementsOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.removeNotNullsMatching(expression, optionalExpParams)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeNulls() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(ArrayFunc.removeNulls()));
    }

    


    public ILevel1ArrayOfArrayElementsOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> sort(
            Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<T> toList() {
        // TODO Auto-generated method stub
        return null;
    }


    public <K> ILevel1ArrayOfMapElementsOperator<K, T> toMap(
            IEval<K, ? super T> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel1ArrayOfMapElementsOperator<K, V> toMap(
            IMapBuild<K, V, ? super T> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> toSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public T[][] get() {
        return endFor().get();
    }

}

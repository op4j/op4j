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
package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Types;
import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.SetFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel2ArrayOfSetElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayOfSetElementsOperator<T> extends Operator
        implements ILevel1ArrayOfSetElementsOperator<T>  {

    
    public Level1ArrayOfSetElementsOperator(final Target target) {
        super(target);
    }


    public ILevel1ArrayOfSetElementsOperator<T> add(final T... newElements) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(SetFunc.add(newElements)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(SetFunc.insert(position, newElements)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(SetFunc.addAll(collection)));
    }


    public ILevel0ArrayOfSetOperator<T> endFor() {
        return new Level0ArrayOfSetOperator<T>(getTarget().endIterate(Structure.ARRAY, Of.type(Types.SET_OF_UNKNOWN)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> extract(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> extractAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> extractAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> extractAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> extractAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> extractAllBut(
            ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfSetElementsElementsOperator<T> forEach() {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2ArrayOfSetElementsElementsOperator<T> forEach(final int... positions) {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterate(positions));
    }


    


    public ILevel2ArrayOfSetElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNot(final int... positions) {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateNot(positions));
    }


    








    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNotNull() {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNull() {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel1ArrayOfSetElementsOperator<X> of(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ArrayOfSetElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> removePositions(final int... positions) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(SetFunc.removePositions(positions)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> removeValues(final T... values) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeValues(values)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeMatching(expression, optionalExpParams)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeSelected(selector)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeAllExceptPositions(positions)));
    }



    public ILevel1ArrayOfSetElementsOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeNotNullsMatching(expression, optionalExpParams)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> removeNulls() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeNulls()));
    }

    


    public ILevel1ArrayOfSetElementsOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<T> sort(
            Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ArrayOfArrayElementsOperator<X> toArray(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ArrayOfArrayElementsOperator<X> toArray(Class<X> of) {
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


    public Set<T>[] get() {
        return endFor().get();
    }

}

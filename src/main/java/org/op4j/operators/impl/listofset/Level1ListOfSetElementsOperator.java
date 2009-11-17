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
package org.op4j.operators.impl.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.SetFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
import org.op4j.operators.intf.listofset.ILevel2ListOfSetElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListOfSetElementsOperator<T> extends Operator
        implements ILevel1ListOfSetElementsOperator<T>  {

    
    public Level1ListOfSetElementsOperator(final Target target) {
        super(target);
    }


    public ILevel1ListOfSetElementsOperator<T> add(final T... newElements) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(SetFunc.add(newElements)));
    }


    public ILevel1ListOfSetElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(SetFunc.insert(position, newElements)));
    }


    public ILevel1ListOfSetElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(SetFunc.addAll(collection)));
    }


    public ILevel0ListOfSetOperator<T> endFor() {
        return new Level0ListOfSetOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public ILevel1ListOfSetElementsOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extract(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> extractAllBut(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEach() {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEach(final int... positions) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterate(positions));
    }


    


    public ILevel2ListOfSetElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEach(final ISelect<T> selector) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNot(final int... positions) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNot(positions));
    }


    








    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotNull() {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel2ListOfSetElementsElementsOperator<T> forEachNull() {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel2ListOfSetElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel1ListOfSetElementsOperator<X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ListOfSetElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> removePositions(final int... positions) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(SetFunc.removePositions(positions)));
    }


    public ILevel1ListOfSetElementsOperator<T> removeValues(final T... values) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeValues(values)));
    }


    public ILevel1ListOfSetElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeMatching(expression, optionalExpParams)));
    }


    public ILevel1ListOfSetElementsOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeSelected(selector)));
    }


    public ILevel1ListOfSetElementsOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeAllExceptPositions(positions)));
    }



    public ILevel1ListOfSetElementsOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeNotNullsMatching(expression, optionalExpParams)));
    }


    public ILevel1ListOfSetElementsOperator<T> removeNulls() {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(SetFunc.removeNulls()));
    }

    


    public ILevel1ListOfSetElementsOperator<T> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfSetElementsOperator<T> sort(
            Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ListOfArrayElementsOperator<X> toArray(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ListOfArrayElementsOperator<X> toArray(Class<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfListElementsOperator<T> toList() {
        // TODO Auto-generated method stub
        return null;
    }


    public <K> ILevel1ListOfMapElementsOperator<K, T> toMap(
            IEval<K, ? super T> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel1ListOfMapElementsOperator<K, V> toMap(
            IMapBuild<K, V, ? super T> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    public List<Set<T>> get() {
        // TODO Auto-generated method stub
        return null;
    }

}

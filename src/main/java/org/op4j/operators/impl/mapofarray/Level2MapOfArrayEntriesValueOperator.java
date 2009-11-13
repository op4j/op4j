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
package org.op4j.operators.impl.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ArrayFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.mapofarray.ILevel1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapofarray.ILevel2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.ILevel3MapOfArrayEntriesValueElementsOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapOfArrayEntriesValueOperator<K,V> extends Operator
        implements ILevel2MapOfArrayEntriesValueOperator<K,V> {
    
    private final Of<V> arrayOf; 

    
    public Level2MapOfArrayEntriesValueOperator(final Of<V> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> deleteAAA(final V newElement) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.add(newElement)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> deleteAAB(final int position, final V newElement) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.add(position, newElement)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> add(final V... newElements) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.addAllValues(newElements)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> insert(final int position, final V... newElements) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.addAllValues(position, newElements)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> addAll(final Collection<V> collection) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.addAll(collection)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> distinct() {
        return new Level2MapOfArrayEntriesValueOperator<K,V>(this.arrayOf, getTarget().execute(ArrayFunc.distinct()));
    }


    public ILevel1MapOfArrayEntriesOperator<K, V> endOn() {
        return new Level1MapOfArrayEntriesOperator<K, V>(this.arrayOf, getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> extract(V value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> extractAll(
            int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> extractAll(V... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> extractAll(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> extractAll(
            ISelect<V> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> extractAllBut(
            int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> extractAllBut(
            V... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> extractAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> extractAllBut(
            ISelect<V> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEach() {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterate());
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEach(final int... positions) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterate(positions));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEach(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEach(final ISelect<V> selector) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachNot(final int... positions) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterateNot(positions));
    }








    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachNotNull() {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachNull() {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel2MapOfArrayEntriesValueOperator<K, X> of(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2MapOfArrayEntriesValueOperator<K, X> of(Class<X> classOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> deleteCCC(final int position) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.remove(position)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> deleteCCD(final V value) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.removeValue(value)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeAll(final int... positions) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.removeAll(positions)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeAllValues(final V... values) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.removeAllValues(values)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeAll(final String expression, final Object... optionalExpParams) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.removeAll(expression, optionalExpParams)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeAll(final ISelect<V> selector) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.removeAll(selector)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeAllNot(final int... positions) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.removeAllNot(positions)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeAllValuesNot(final V... values) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.removeAllValuesNot(values)));
    }

    

    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeAllNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.removeAllNotNullAnd(expression, optionalExpParams)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeAllNull() {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.removeAllNull()));
    }

    
    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeAllNullOr(final String expression, final Object... optionalExpParams) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(ArrayFunc.removeAllNullOr(expression, optionalExpParams)));
    }




    public ILevel2MapOfArrayEntriesValueOperator<K, V> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> sort(
            Comparator<? super V> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> toList() {
        // TODO Auto-generated method stub
        return null;
    }


    public <K2> ILevel2MapOfMapEntriesValueOperator<K, K2, V> toMap(
            IEval<K2, ? super V> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K2, V2> ILevel2MapOfMapEntriesValueOperator<K, K2, V2> toMap(
            IMapBuild<K2, V2, ? super V> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> toSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public Map<K, V[]> get() {
        return endOn().endFor().get();
    }

}

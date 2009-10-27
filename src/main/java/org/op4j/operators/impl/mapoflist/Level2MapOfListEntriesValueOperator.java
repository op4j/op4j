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
package org.op4j.operators.impl.mapoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.op4j.commands.IEval;
import org.op4j.op.intf.parameters.IMapBuild;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.parameters.ISelect;
import org.op4j.op.target.Target;
import org.op4j.op.target.Target.Structure;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.mapofarray.ILevel2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel1MapOfListEntriesOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel3MapOfListEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapOfListEntriesValueOperator<K,V> extends Operator
        implements ILevel2MapOfListEntriesValueOperator<K,V> {

    
    public Level2MapOfListEntriesValueOperator(final Target target) {
        super(target);
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> add(V newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> add(int position,
            V newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> addAll(V... newElements) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> addAll(
            Collection<V> collection) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> distinct() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1MapOfListEntriesOperator<K, V> endOn() {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extract(V value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAll(
            int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAll(V... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAll(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAll(
            ISelect<V> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAllBut(
            int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAllBut(V... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAllBut(
            ISelect<V> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEach() {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate());
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEach(final int... positions) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate(positions));
    }


    


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEach(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEach(final ISelect<V> selector) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNot(final int... positions) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNot(positions));
    }


    


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNot(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNot(expression, optionalExpParams));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNot(final ISelect<V> selector) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNot(selector));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNotNull() {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNotNull());
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNotNullAndNot(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNotNullAndNot(expression, optionalExpParams));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNull() {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNull());
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNullOr(expression, optionalExpParams));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNullOrNot(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNullOrNot(expression, optionalExpParams));
    }


    public <X> ILevel2MapOfListEntriesValueOperator<K, X> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2MapOfListEntriesValueOperator<K, X> of(Class<X> classOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> remove(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> remove(V value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeAll(
            int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeAll(V... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeAll(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeAll(
            ISelect<V> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeAllBut(
            int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeAllBut(V... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeAllBut(
            ISelect<V> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> sort(
            Comparator<? super V> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2MapOfArrayEntriesValueOperator<K, X> toArray(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2MapOfArrayEntriesValueOperator<K, X> toArray(Class<X> of) {
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


    public Map<K, List<V>> get() {
        return endOn().endFor().get();
    }

}

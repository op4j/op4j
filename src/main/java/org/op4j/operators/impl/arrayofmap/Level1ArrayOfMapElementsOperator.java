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
package org.op4j.operators.impl.arrayofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.op.impl.parameters.Of;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.parameters.ISelect;
import org.op4j.op.target.Target;
import org.op4j.op.target.Target.Structure;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel2ArrayOfMapElementsEntriesOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayOfMapElementsOperator<K,V> extends Operator
        implements ILevel1ArrayOfMapElementsOperator<K,V>  {

    
    public Level1ArrayOfMapElementsOperator(final Target target) {
        super(target);
    }


    public ILevel0ArrayOfMapOperator<K, V> endFor() {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().endIterate(Structure.ARRAY, Of.MAP));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> extract(K key) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> extractAll(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> extractAll(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> extractAll(
            ISelect<Entry<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> extractAllBut(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> extractAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> extractAllBut(
            ISelect<Entry<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfSetElementsOperator<K> extractKeys() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfListElementsOperator<V> extractValues() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntry() {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterate());
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntry(final String expression, final Object... optionalExpParams) {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntry(final ISelect<Entry<K, V>> selector) {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterateNot(keys));
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntryNot(final String expression, final Object... optionalExpParams) {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterateNot(expression, optionalExpParams));
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntryNot(final ISelect<Entry<K, V>> selector) {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterateNot(selector));
    }


    public <X, Y> ILevel1ArrayOfMapElementsOperator<X, Y> of(IOf<X> ofX,
            IOf<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel1ArrayOfMapElementsOperator<X, Y> of(Class<X> ofXClass,
            Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> put(K newKey, V newValue) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> put(int position, K newKey,
            V newValue) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> putAll(Map<K, V> map) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> remove(K key) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeAll(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeAll(
            ISelect<Entry<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeAllBut(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeAllBut(
            ISelect<Entry<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> sort(
            Comparator<? super Entry<K, V>> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public Map<K, V>[] get() {
        return endFor().get();
    }

}

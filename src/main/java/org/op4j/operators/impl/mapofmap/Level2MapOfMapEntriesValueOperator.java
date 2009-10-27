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
package org.op4j.operators.impl.mapofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.IOf;
import org.op4j.commands.ISelect;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.ILevel1MapOfMapEntriesOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.ILevel3MapOfMapEntriesValueEntriesOperator;
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
public class Level2MapOfMapEntriesValueOperator<K1,K2,V> extends Operator
        implements ILevel2MapOfMapEntriesValueOperator<K1,K2,V> {

    
    public Level2MapOfMapEntriesValueOperator(final Target target) {
        super(target);
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> endOn() {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> extract(K2 key) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> extractAll(K2... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> extractAll(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> extractAll(
            ISelect<Entry<K2, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> extractAllBut(
            K2... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> extractAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> extractAllBut(
            ISelect<Entry<K2, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesValueOperator<K1, K2> extractKeys() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K1, V> extractValues() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfMapEntriesValueEntriesOperator<K1, K2, V> forEachEntry() {
        return new Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V>(getTarget().iterate());
    }


    public ILevel3MapOfMapEntriesValueEntriesOperator<K1, K2, V> forEachEntryWithKeys(final K2... keys) {
        return new Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel3MapOfMapEntriesValueEntriesOperator<K1, K2, V> forEachEntry(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel3MapOfMapEntriesValueEntriesOperator<K1, K2, V> forEachEntry(final ISelect<Entry<K2, V>> selector) {
        return new Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V>(getTarget().iterate(selector));
    }


    public ILevel3MapOfMapEntriesValueEntriesOperator<K1, K2, V> forEachEntryWithKeysNot(final K2... keys) {
        return new Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V>(getTarget().iterateNot(keys));
    }


    public ILevel3MapOfMapEntriesValueEntriesOperator<K1, K2, V> forEachEntryNot(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V>(getTarget().iterateNot(expression, optionalExpParams));
    }


    public ILevel3MapOfMapEntriesValueEntriesOperator<K1, K2, V> forEachEntryNot(final ISelect<Entry<K2, V>> selector) {
        return new Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V>(getTarget().iterateNot(selector));
    }


    public <X, Y> ILevel2MapOfMapEntriesValueOperator<K1, X, Y> of(IOf<X> ofX,
            IOf<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel2MapOfMapEntriesValueOperator<K1, X, Y> of(
            Class<X> classOfX, Class<Y> classOfY) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> put(K2 newKey,
            V newValue) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> put(int position,
            K2 newKey, V newValue) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> putAll(Map<K2, V> map) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, ?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> remove(K2 key) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> removeAll(K2... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> removeAll(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> removeAll(
            ISelect<Entry<K2, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> removeAllBut(
            K2... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> removeAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> removeAllBut(
            ISelect<Entry<K2, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> sort(
            Comparator<? super Entry<K2, V>> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public Map<K1, Map<K2, V>> get() {
        return endOn().endFor().get();
    }

}

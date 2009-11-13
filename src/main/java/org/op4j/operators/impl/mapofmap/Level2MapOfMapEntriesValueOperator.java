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

import org.op4j.Of;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.MapFunc;
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








    public <X, Y> ILevel2MapOfMapEntriesValueOperator<K1, X, Y> of(Of<X> ofX,
            Of<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel2MapOfMapEntriesValueOperator<K1, X, Y> of(
            Class<X> classOfX, Class<Y> classOfY) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> put(final K2 newKey, final V newValue) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(MapFunc.put(newKey, newValue)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> insert(final int position, final K2 newKey, final V newValue) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(MapFunc.put(position, newKey, newValue)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> putAll(final Map<K2,V> map) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(MapFunc.putAll(map)));
    }

    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> insertAll(final int position, final Map<K2,V> map) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(MapFunc.putAll(position, map)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, ?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> deleteDDD(final K2 key) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(MapFunc.remove(key)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> removeAllWithKeys(final K2... keys) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(MapFunc.removeAllWithKeys(keys)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> removeAll(final String expression, final Object... optionalExpParams) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(MapFunc.removeAll(expression, optionalExpParams)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> removeAll(final ISelect<Entry<K2,V>> selector) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(MapFunc.removeAll(selector)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> removeAllWithKeysNot(final K2... keys) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(MapFunc.removeAllWithKeysNot(keys)));
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

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
package org.op4j.operators.impl.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.Of;
import org.op4j.executables.ISelect;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.map.ILevel1MapEntriesOperator;
import org.op4j.operators.qualities.IOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0MapOperator<K,V> extends Operator
        implements ILevel0MapOperator<K,V> {

    
    public Level0MapOperator(final Target target) {
        super(target);
    }


    public ILevel0MapOperator<K, V> extract(K key) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> extractAll(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> extractAll(ISelect<Entry<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> extractAllBut(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> extractAllBut(ISelect<Entry<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public IOperator extractKeys() {
        // TODO Auto-generated method stub
        return null;
    }


    public IOperator extractValues() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntry() {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterate());
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntry(final String expression, final Object... optionalExpParams) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntry(final ISelect<Entry<K, V>> selector) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterateNot(keys));
    }








    public <X, Y> ILevel0MapOperator<X, Y> of(Of<X> ofX, Of<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel0MapOperator<X, Y> of(Class<X> ofXClass,
            Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> put(K newKey, V newValue) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> put(int position, K newKey, V newValue) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> putAll(Map<K, V> map) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0MapOperator<K, V> putAll(int position, Map<K, V> map) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> remove(K key) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> removeAllWithKeys(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> removeAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> removeAll(ISelect<Entry<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> removeAllWithKeysNot(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }








    public ILevel0MapOperator<K, V> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOperator<K, V> sort(
            Comparator<? super Entry<K, V>> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    @SuppressWarnings("unchecked")
    public Map<K, V> get() {
        return (Map<K, V>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Map<K, V>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

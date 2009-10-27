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

import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.parameters.ISelect;
import org.op4j.op.target.Target;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofmap.ILevel1MapOfMapEntriesOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0MapOfMapOperator<K1,K2,V> extends Operator
        implements ILevel0MapOfMapOperator<K1,K2,V> {

    
    public Level0MapOfMapOperator(final Target target) {
        super(target);
    }


    public ILevel0MapOfMapOperator<K1, K2, V> extract(K1 key) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> extractAll(K1... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> extractAll(
            ISelect<Entry<K1, Map<K2, V>>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> extractAllBut(K1... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> extractAllBut(
            ISelect<Entry<K1, Map<K2, V>>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<K1> extractKeys() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfMapOperator<K2, V> extractValues() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntry() {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterate());
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryWithKeys(final K1... keys) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntry(final String expression, final Object... optionalExpParams) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntry(final ISelect<Entry<K1, Map<K2, V>>> selector) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterate(selector));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryWithKeysNot(final K1... keys) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterateNot(keys));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryNot(final String expression, final Object... optionalExpParams) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterateNot(expression, optionalExpParams));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryNot(final ISelect<Entry<K1, Map<K2, V>>> selector) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterateNot(selector));
    }


    public <X, Y, Z> ILevel0MapOfMapOperator<X, Y, Z> of(IOf<X> ofX,
            IOf<Y> ofY, IOf<Z> ofZ) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y, Z> ILevel0MapOfMapOperator<X, Y, Z> of(Class<X> ofXClass,
            Class<Y> ofYClass, Class<Z> ofZClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> put(K1 newKey, Map<K2, V> newValue) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> put(int position, K1 newKey,
            Map<K2, V> newValue) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> putAll(Map<K1, Map<K2, V>> map) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<?, ?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> remove(K1 key) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeAll(K1... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeAll(
            ISelect<Entry<K1, Map<K2, V>>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeAllBut(K1... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeAllBut(
            ISelect<Entry<K1, Map<K2, V>>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<K1, K2, V> sort(
            Comparator<? super Entry<K1, Map<K2, V>>> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    @SuppressWarnings("unchecked")
    public Map<K1, Map<K2, V>> get() {
        return (Map<K1,Map<K2,V>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Map<K1, Map<K2, V>>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}

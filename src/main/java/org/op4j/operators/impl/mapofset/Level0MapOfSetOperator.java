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
package org.op4j.operators.impl.mapofset;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.IOf;
import org.op4j.commands.IEval;
import org.op4j.commands.IMapBuild;
import org.op4j.commands.ISelect;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.mapofset.ILevel1MapOfSetEntriesOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0MapOfSetOperator<K,V> extends Operator
        implements ILevel0MapOfSetOperator<K,V> {

    
    public Level0MapOfSetOperator(final Target target) {
        super(target);
    }


    public ILevel0MapOfSetOperator<K, V> extract(K key) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> extractAll(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> extractAll(
            ISelect<Entry<K, Set<V>>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> extractAllBut(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> extractAllBut(
            ISelect<Entry<K, Set<V>>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<K> extractKeys() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfSetOperator<V> extractValues() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1MapOfSetEntriesOperator<K, V> forEachEntry() {
        return new Level1MapOfSetEntriesOperator<K, V>(getTarget().iterate());
    }


    public ILevel1MapOfSetEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level1MapOfSetEntriesOperator<K, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel1MapOfSetEntriesOperator<K, V> forEachEntry(final String expression, final Object... optionalExpParams) {
        return new Level1MapOfSetEntriesOperator<K, V>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1MapOfSetEntriesOperator<K, V> forEachEntry(final ISelect<Entry<K, Set<V>>> selector) {
        return new Level1MapOfSetEntriesOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel1MapOfSetEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level1MapOfSetEntriesOperator<K, V>(getTarget().iterateNot(keys));
    }


    public ILevel1MapOfSetEntriesOperator<K, V> forEachEntryNot(final String expression, final Object... optionalExpParams) {
        return new Level1MapOfSetEntriesOperator<K, V>(getTarget().iterateNot(expression, optionalExpParams));
    }


    public ILevel1MapOfSetEntriesOperator<K, V> forEachEntryNot(final ISelect<Entry<K, Set<V>>> selector) {
        return new Level1MapOfSetEntriesOperator<K, V>(getTarget().iterateNot(selector));
    }


    public <X, Y> ILevel0MapOfSetOperator<X, Y> of(IOf<X> ofX, IOf<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel0MapOfSetOperator<X, Y> of(Class<X> ofXClass,
            Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> put(K newKey, Set<V> newValue) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> put(int position, K newKey,
            Set<V> newValue) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> putAll(Map<K, Set<V>> map) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> remove(K key) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> removeAll(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> removeAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> removeAll(
            ISelect<Entry<K, Set<V>>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> removeAllBut(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> removeAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> removeAllBut(
            ISelect<Entry<K, Set<V>>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<K, V> sort(
            Comparator<? super Entry<K, Set<V>>> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0MapOfArrayOperator<K, X> toMapOfArray(IOf<X> arrayOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0MapOfArrayOperator<K, X> toMapOfArray(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfListOperator<K, V> toMapOfList() {
        // TODO Auto-generated method stub
        return null;
    }


    public <K2> ILevel0MapOfMapOperator<K, K2, V> toMapOfMap(
            IEval<K2, ? super V> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K2, V2> ILevel0MapOfMapOperator<K, K2, V2> toMapOfMap(
            IMapBuild<K2, V2, ? super V> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    @SuppressWarnings("unchecked")
    public Map<K, Set<V>> get() {
        return (Map<K,Set<V>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Map<K, Set<V>>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}
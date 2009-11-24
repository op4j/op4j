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
package org.op4j.operators.impl.setofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.MapFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel2SetOfMapElementsEntriesOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1SetOfMapElementsOperator<K,V> extends Operator
        implements ILevel1SetOfMapElementsOperator<K,V>  {

    
    public Level1SetOfMapElementsOperator(final Target target) {
        super(target);
    }


    public ILevel0SetOfMapOperator<K, V> endFor() {
        return new Level0SetOfMapOperator<K, V>(getTarget().endIterate(Structure.SET, null));
    }


    public ILevel1SetOfMapElementsOperator<K, V> extract(K key) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfMapElementsOperator<K, V> extractAll(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfMapElementsOperator<K, V> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfMapElementsOperator<K, V> extractAll(
            ISelect<Entry<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfMapElementsOperator<K, V> extractAllBut(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfMapElementsOperator<K, V> extractAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfMapElementsOperator<K, V> extractAllBut(
            ISelect<Entry<K, V>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfSetElementsOperator<K> extractKeys() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfListElementsOperator<V> extractValues() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2SetOfMapElementsEntriesOperator<K, V> forEachEntry() {
        return new Level2SetOfMapElementsEntriesOperator<K, V>(getTarget().iterate());
    }


    public ILevel2SetOfMapElementsEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level2SetOfMapElementsEntriesOperator<K, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel2SetOfMapElementsEntriesOperator<K, V> forEachEntry(final String expression, final Object... optionalExpParams) {
        return new Level2SetOfMapElementsEntriesOperator<K, V>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel2SetOfMapElementsEntriesOperator<K, V> forEachEntry(final ISelect<Entry<K, V>> selector) {
        return new Level2SetOfMapElementsEntriesOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel2SetOfMapElementsEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level2SetOfMapElementsEntriesOperator<K, V>(getTarget().iterateNot(keys));
    }








    public <X, Y> ILevel1SetOfMapElementsOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel1SetOfMapElementsOperator<X, Y> of(Class<X> ofXClass, Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1SetOfMapElementsOperator<K, V> put(final K newKey, final V newValue) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFunc.Put<K, V>(newKey, newValue)));
    }


    public ILevel1SetOfMapElementsOperator<K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFunc.Insert<K, V>(position, newKey, newValue)));
    }


    public ILevel1SetOfMapElementsOperator<K, V> putAll(final Map<K, V> map) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFunc.PutAll<K, V>(map)));
    }


    public ILevel1SetOfMapElementsOperator<K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFunc.InsertAll<K, V>(position, map)));
    }


    public ILevel1SetOfMapElementsOperator<?, ?> raw() {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget());
    }


    public ILevel1SetOfMapElementsOperator<K, V> removeKeys(final K... keys) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFunc.RemoveKeys<K, V>(keys)));
    }


    public ILevel1SetOfMapElementsOperator<K, V> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFunc.RemoveMatching<K, V>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel1SetOfMapElementsOperator<K, V> removeSelected(final ISelect<Entry<K, V>> selector) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFunc.RemoveSelected<K, V>(selector)));
    }


    public ILevel1SetOfMapElementsOperator<K, V> removeAllExceptKeys(final K... keys) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFunc.RemoveAllExceptKeys<K, V>(keys)));
    }








    @SuppressWarnings("unchecked")
    public ILevel1SetOfMapElementsOperator<K, V> sort() {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFunc.SortByKey()));
    }


    public ILevel1SetOfMapElementsOperator<K, V> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFunc.SortEntries<K, V>(comparator)));
    }


    public Set<Map<K, V>> get() {
        return endFor().get();
    }

}

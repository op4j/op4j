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

import org.javaruntype.type.Type;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.MapFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel2ArrayOfMapElementsEntriesOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


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
        return new Level0ArrayOfMapOperator<K, V>(getTarget().endIterate(Structure.ARRAY, Map.class));
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








    public <X, Y> ILevel1ArrayOfMapElementsOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel1ArrayOfMapElementsOperator<X, Y> of(Class<X> ofXClass, Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> put(final K newKey, final V newValue) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.put(newKey, newValue)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.insert(position, newKey, newValue)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> putAll(final Map<K, V> map) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.putAll(map)));
    }

    public ILevel1ArrayOfMapElementsOperator<K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.insertAll(position, map)));
    }


    public ILevel1ArrayOfMapElementsOperator<?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeKeys(final K... keys) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.removeKeys(keys)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.removeMatching(expression, optionalExpParams)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeSelected(final ISelect<Entry<K, V>> selector) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.removeoSelected(selector)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeAllExceptKeys(final K... keys) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(MapFunc.removeAllExceptKeys(keys)));
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

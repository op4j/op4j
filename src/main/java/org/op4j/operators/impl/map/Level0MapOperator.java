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

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.MapFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.map.ILevel1MapEntriesOperator;
import org.op4j.operators.qualities.IOperator;
import org.op4j.target.Target;
import org.op4j.util.VarArgsUtil;


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
        return new Level1MapEntriesOperator<K, V>(getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntry(final ISelect<Entry<K, V>> selector) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterateNot(keys));
    }








    public <X, Y> ILevel0MapOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        return new Level0MapOperator<X, Y>(getTarget());
    }


    public ILevel0MapOperator<K, V> put(final K newKey, final V newValue) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFunc.Put<K, V>(newKey, newValue)));
    }


    public ILevel0MapOperator<K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFunc.Insert<K, V>(position, newKey, newValue)));
    }


    public ILevel0MapOperator<K, V> putAll(final Map<K, V> map) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFunc.PutAll<K, V>(map)));
    }


    public ILevel0MapOperator<K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFunc.InsertAll<K, V>(position, map)));
    }


    public ILevel0MapOperator<?, ?> raw() {
        return new Level0MapOperator<K, V>(getTarget());
    }


    public ILevel0MapOperator<K, V> removeKeys(final K... keys) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFunc.RemoveKeys<K, V>(keys)));
    }


    public ILevel0MapOperator<K, V> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFunc.RemoveMatching<K, V>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0MapOperator<K, V> removeSelected(final ISelect<Entry<K, V>> selector) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFunc.RemoveSelected<K, V>(selector)));
    }


    public ILevel0MapOperator<K, V> removeKeysNot(final K... keys) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFunc.RemoveKeysNot<K, V>(keys)));
    }











    @SuppressWarnings("unchecked")
    public ILevel0MapOperator<K, V> sort() {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFunc.SortByKey()));
    }


    public ILevel0MapOperator<K, V> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFunc.SortEntries<K, V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Map<K, V> get() {
        return (Map<K, V>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Map<K, V>> generic() {
        return new Level0GenericUniqOperator<Map<K, V>>(getTarget());
    }

}

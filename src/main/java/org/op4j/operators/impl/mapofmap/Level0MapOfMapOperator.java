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

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.MapFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofmap.ILevel1MapOfMapEntriesOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.target.Target;
import org.op4j.util.VarArgsUtil;


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


    public ILevel0SetOperator<K1> extractKeys() {
        return new Level0SetOperator<K1>(getTarget().execute(new MapFunc.ExtractKeys<K1, Map<K2, V>>()));
    }


    public ILevel0ListOfMapOperator<K2, V> extractValues() {
        return new Level0ListOfMapOperator<K2, V>(getTarget().execute(new MapFunc.ExtractValues<K1, Map<K2, V>>()));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntry() {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterate());
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryWithKeys(final K1... keys) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryMatching(final String expression, final Object... optionalExpParams) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryMatching(final IEval<Boolean, ? super Entry<K1, Map<K2, V>>> eval) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterate(eval));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntrySelected(final ISelect<Entry<K1, Map<K2, V>>> selector) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterate(selector));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryWithKeysNot(final K1... keys) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterateNot(keys));
    }








    public <X, Y, Z> ILevel0MapOfMapOperator<X, Y, Z> of(final Type<X> ofX, final Type<Y> ofY, final Type<Z> ofZ) {
        return new Level0MapOfMapOperator<X, Y, Z>(getTarget());
    }


    public ILevel0MapOfMapOperator<K1, K2, V> put(final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFunc.Put<K1, Map<K2,V>>(newKey, newValue)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> insert(final int position, final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFunc.Insert<K1, Map<K2,V>>(position, newKey, newValue)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> putAll(final Map<K1, Map<K2,V>> map) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFunc.PutAll<K1, Map<K2,V>>(map)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> insertAll(final int position, final Map<K1, Map<K2,V>> map) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFunc.InsertAll<K1, Map<K2,V>>(position, map)));
    }


    public ILevel0MapOfMapOperator<?, ?, ?> raw() {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget());
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeKeys(final K1... keys) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFunc.RemoveKeys<K1, Map<K2,V>>(keys)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFunc.RemoveMatching<K1, Map<K2,V>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeMatching(final IEval<Boolean, ? super Entry<K1, Map<K2,V>>> eval) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFunc.RemoveMatching<K1, Map<K2,V>>(eval)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeSelected(final ISelect<Entry<K1, Map<K2,V>>> selector) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFunc.RemoveSelected<K1, Map<K2,V>>(selector)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeKeysNot(final K1... keys) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFunc.RemoveKeysNot<K1, Map<K2,V>>(keys)));
    }











    @SuppressWarnings("unchecked")
    public ILevel0MapOfMapOperator<K1, K2, V> sort() {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFunc.SortByKey()));
    }


    @SuppressWarnings("unchecked")
    public ILevel0MapOfMapOperator<K1, K2, V> sort(final Comparator<? super Entry<K1, Map<K2, V>>> comparator) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFunc.SortEntries(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Map<K1, Map<K2, V>> get() {
        return (Map<K1,Map<K2,V>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Map<K1, Map<K2, V>>> generic() {
        return new Level0GenericUniqOperator<Map<K1, Map<K2, V>>>(getTarget());
    }

}

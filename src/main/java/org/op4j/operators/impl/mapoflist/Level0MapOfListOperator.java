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
package org.op4j.operators.impl.mapoflist;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.MapFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapoflist.ILevel1MapOfListEntriesOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
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
public class Level0MapOfListOperator<K,V> extends Operator
        implements ILevel0MapOfListOperator<K,V> {

    
    public Level0MapOfListOperator(final Target target) {
        super(target);
    }


    public ILevel0SetOperator<K> extractKeys() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfListOperator<V> extractValues() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1MapOfListEntriesOperator<K, V> forEachEntry() {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().iterate());
    }


    public ILevel1MapOfListEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel1MapOfListEntriesOperator<K, V> forEachEntry(final String expression, final Object... optionalExpParams) {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1MapOfListEntriesOperator<K, V> forEachEntry(final ISelect<Entry<K, List<V>>> selector) {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel1MapOfListEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().iterateNot(keys));
    }








    public <X, Y> ILevel0MapOfListOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        return new Level0MapOfListOperator<X, Y>(getTarget());
    }


    public ILevel0MapOfListOperator<K, V> put(final K newKey, final List<V> newValue) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFunc.Put<K, List<V>>(newKey, newValue)));
    }


    public ILevel0MapOfListOperator<K, V> insert(final int position, final K newKey, final List<V> newValue) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFunc.Insert<K, List<V>>(position, newKey, newValue)));
    }


    public ILevel0MapOfListOperator<K, V> putAll(final Map<K, List<V>> map) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFunc.PutAll<K, List<V>>(map)));
    }


    public ILevel0MapOfListOperator<K, V> insertAll(final int position, final Map<K, List<V>> map) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFunc.InsertAll<K, List<V>>(position, map)));
    }


    public ILevel0MapOfListOperator<?, ?> raw() {
        return new Level0MapOfListOperator<K, V>(getTarget());
    }


    public ILevel0MapOfListOperator<K, V> removeKeys(final K... keys) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFunc.RemoveKeys<K, List<V>>(keys)));
    }


    public ILevel0MapOfListOperator<K, V> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFunc.RemoveMatching<K, List<V>>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0MapOfListOperator<K, V> removeSelected(final ISelect<Entry<K, List<V>>> selector) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFunc.RemoveSelected<K, List<V>>(selector)));
    }


    public ILevel0MapOfListOperator<K, V> removeKeysNot(final K... keys) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFunc.RemoveKeysNot<K, List<V>>(keys)));
    }











    @SuppressWarnings("unchecked")
    public ILevel0MapOfListOperator<K, V> sort() {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFunc.SortByKey()));
    }


    public ILevel0MapOfListOperator<K, V> sort(final Comparator<? super Entry<K, List<V>>> comparator) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFunc.SortEntries<K, List<V>>(comparator)));
    }


    public ILevel0MapOfArrayOperator<K, V> toMapOfArray(final Type<V> of) {
        return forEachEntry().onValue().toArray(of).endOn().endFor();
    }


    public <K2> ILevel0MapOfMapOperator<K, K2, V> toMapOfMap(final IEval<K2, ? super V> keyEval) {
        return forEachEntry().onValue().toMap(keyEval).endOn().endFor();
    }


    public <K2, V2> ILevel0MapOfMapOperator<K, K2, V2> toMapOfMap(final IMapBuild<K2, V2, ? super V> mapBuild) {
        return forEachEntry().onValue().toMap(mapBuild).endOn().endFor();
    }


    public ILevel0MapOfSetOperator<K, V> toMapOfSet() {
        return forEachEntry().onValue().toSet().endOn().endFor();
    }


    @SuppressWarnings("unchecked")
    public Map<K, List<V>> get() {
        return (Map<K,List<V>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Map<K, List<V>>> generic() {
        return new Level0GenericUniqOperator<Map<K, List<V>>>(getTarget());
    }

}

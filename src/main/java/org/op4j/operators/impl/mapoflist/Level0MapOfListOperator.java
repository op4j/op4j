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
import org.op4j.functions.MapFuncs;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.listoflist.Level0ListOfListOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapoflist.ILevel1MapOfListEntriesOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.select.ISelector;
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
        return new Level0SetOperator<K>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public ILevel0ListOfListOperator<V> extractValues() {
        return new Level0ListOfListOperator<V>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public ILevel1MapOfListEntriesOperator<K, V> forEachEntry() {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().iterate());
    }


    public ILevel1MapOfListEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel1MapOfListEntriesOperator<K, V> forEachEntryMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1MapOfListEntriesOperator<K, V> forEachEntryMatching(final IEvaluator<Boolean, ? super Entry<K, List<V>>> eval) {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().iterate(eval));
    }


    public ILevel1MapOfListEntriesOperator<K, V> forEachEntrySelected(final ISelector<Entry<K, List<V>>> selector) {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel1MapOfListEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().iterateNot(keys));
    }








    public <X, Y> ILevel0MapOfListOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        return new Level0MapOfListOperator<X, Y>(getTarget());
    }


    public ILevel0MapOfListOperator<K, V> put(final K newKey, final List<V> newValue) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFuncs.Put<K, List<V>>(newKey, newValue)));
    }


    public ILevel0MapOfListOperator<K, V> insert(final int position, final K newKey, final List<V> newValue) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFuncs.Insert<K, List<V>>(position, newKey, newValue)));
    }


    public ILevel0MapOfListOperator<K, V> putAll(final Map<K, List<V>> map) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFuncs.PutAll<K, List<V>>(map)));
    }


    public ILevel0MapOfListOperator<K, V> insertAll(final int position, final Map<K, List<V>> map) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFuncs.InsertAll<K, List<V>>(position, map)));
    }


    public ILevel0MapOfListOperator<?, ?> raw() {
        return new Level0MapOfListOperator<K, V>(getTarget());
    }


    public ILevel0MapOfListOperator<K, V> removeKeys(final K... keys) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFuncs.RemoveKeys<K, List<V>>(keys)));
    }


    public ILevel0MapOfListOperator<K, V> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFuncs.RemoveMatching<K, List<V>>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0MapOfListOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K, List<V>>> eval) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFuncs.RemoveMatching<K, List<V>>(eval)));
    }


    public ILevel0MapOfListOperator<K, V> removeSelected(final ISelector<Entry<K, List<V>>> selector) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFuncs.RemoveSelected<K, List<V>>(selector)));
    }


    public ILevel0MapOfListOperator<K, V> removeKeysNot(final K... keys) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K, List<V>>(keys)));
    }











    @SuppressWarnings("unchecked")
    public ILevel0MapOfListOperator<K, V> sort() {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public ILevel0MapOfListOperator<K, V> sort(final Comparator<? super Entry<K, List<V>>> comparator) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new MapFuncs.SortEntries<K, List<V>>(comparator)));
    }


    public ILevel0MapOfArrayOperator<K, V> toMapOfArray(final Type<V> of) {
        return forEachEntry().onValue().toArray(of).endOn().endFor();
    }


    public <K2> ILevel0MapOfMapOperator<K, K2, V> toMapOfMap(final IEvaluator<K2, ? super V> keyEval) {
        return forEachEntry().onValue().toMap(keyEval).endOn().endFor();
    }


    public <K2, V2> ILevel0MapOfMapOperator<K, K2, V2> toMapOfMap(final IMapBuilder<K2, V2, ? super V> mapBuild) {
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

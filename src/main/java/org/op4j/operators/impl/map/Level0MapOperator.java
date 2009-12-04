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
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.list.Level0ListOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.map.ILevel1MapEntriesOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.select.ISelector;
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


    public ILevel0SetOperator<K> extractKeys() {
        return new Level0SetOperator<K>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public ILevel0ListOperator<V> extractValues() {
        return new Level0ListOperator<V>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntry() {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterate());
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntryMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterate(eval));
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntrySelected(final ISelector<Entry<K, V>> selector) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel1MapEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level1MapEntriesOperator<K, V>(getTarget().iterateNot(keys));
    }








    public <X, Y> ILevel0MapOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        return new Level0MapOperator<X, Y>(getTarget());
    }


    public ILevel0MapOperator<K, V> put(final K newKey, final V newValue) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.Put<K, V>(newKey, newValue)));
    }


    public ILevel0MapOperator<K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.Insert<K, V>(position, newKey, newValue)));
    }


    public ILevel0MapOperator<K, V> putAll(final Map<K, V> map) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.PutAll<K, V>(map)));
    }


    public ILevel0MapOperator<K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.InsertAll<K, V>(position, map)));
    }


    public ILevel0MapOperator<?, ?> raw() {
        return new Level0MapOperator<K, V>(getTarget());
    }


    public ILevel0MapOperator<K, V> removeKeys(final K... keys) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.RemoveKeys<K, V>(keys)));
    }


    public ILevel0MapOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.RemoveMatching<K, V>(eval)));
    }

    public ILevel0MapOperator<K, V> removeNotMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K, V>(eval)));
    }


    public ILevel0MapOperator<K, V> removeSelected(final ISelector<Entry<K, V>> selector) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.RemoveSelected<K, V>(selector)));
    }


    public ILevel0MapOperator<K, V> removeKeysNot(final K... keys) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K, V>(keys)));
    }











    @SuppressWarnings("unchecked")
    public ILevel0MapOperator<K, V> sort() {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public ILevel0MapOperator<K, V> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level0MapOperator<K, V>(getTarget().execute(new MapFuncs.SortEntries<K, V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Map<K, V> get() {
        return (Map<K, V>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Map<K, V>> generic() {
        return new Level0GenericUniqOperator<Map<K, V>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super Map<K,V>> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Map<K,V>> eval) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K,V>> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}

    
    
}

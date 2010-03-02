/*  
 * ============================================================================= 
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org) 
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
package org.op4j.operators.impl.op.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.FnMap;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.intf.map.ILevel0MapSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0MapSelectedOperator<I,K,V> extends AbstractOperator implements UniqOpOperator<I,Map<K,V>>, ILevel0MapSelectedOperator<I,K,V> {


    public Level0MapSelectedOperator(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0MapSelectedOperator<I,K,V> insertAll(final int position, final Map<K,V> map) {
        return new Level0MapSelectedOperator<I,K,V>(getTarget().execute(FnMap.ofObjectObject().insertAll(position, (Map)map)));
    }


    @SuppressWarnings("unchecked")
    public Level0MapSelectedOperator<I,K,V> removeAllTrue(final IFunction<? super Entry<K,V>,Boolean> eval) {
        return new Level0MapSelectedOperator<I,K,V>(getTarget().execute(FnMap.ofObjectObject().removeAllTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0MapSelectedOperator<I,K,V> removeAllFalse(final IFunction<? super Entry<K,V>,Boolean> eval) {
        return new Level0MapSelectedOperator<I,K,V>(getTarget().execute(FnMap.ofObjectObject().removeAllFalse((IFunction)eval)));
    }


    public Level0MapOperator<I,K,V> endIf() {
        return new Level0MapOperator<I,K,V>(getTarget().endSelect());
    }


    public Level1MapSelectedEntriesOperator<I,K,V> forEachEntry() {
        return new Level1MapSelectedEntriesOperator<I,K,V>(getTarget().iterate(Structure.MAP));
    }


    public Level0MapSelectedOperator<I,K,V> removeAllKeys(final K... keys) {
        return new Level0MapSelectedOperator<I,K,V>(getTarget().execute(FnMap.ofObjectObject().removeAllKeys(keys)));
    }


    public Level0MapSelectedOperator<I,K,V> removeAllKeysNot(final K... keys) {
        return new Level0MapSelectedOperator<I,K,V>(getTarget().execute(FnMap.ofObjectObject().removeAllKeysNot(keys)));
    }


    public Level0MapSelectedOperator<I,K,V> execIfNotNullAsMap(final IFunction<? super Map<K,V>,? extends Map<? extends K,? extends V>> function) {
        return new Level0MapSelectedOperator<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP));
    }


    public Level0MapSelectedOperator<I,K,V> execAsMap(final IFunction<? super Map<K,V>,? extends Map<? extends K,? extends V>> function) {
        return new Level0MapSelectedOperator<I,K,V>(getTarget().execute(function, Normalisation.MAP));
    }


    public Level0MapSelectedOperator<I,K,V> put(final K newKey, final V newValue) {
        return new Level0MapSelectedOperator<I,K,V>(getTarget().execute(FnMap.ofObjectObject().put(newKey, newValue)));
    }


    @SuppressWarnings("unchecked")
    public Level0MapSelectedOperator<I,K,V> putAll(final Map<K,V> map) {
        return new Level0MapSelectedOperator<I,K,V>(getTarget().execute(FnMap.ofObjectObject().putAll((Map)map)));
    }


    public Level0MapSelectedOperator<I,K,V> insert(final int position, final K newKey, final V newValue) {
        return new Level0MapSelectedOperator<I,K,V>(getTarget().execute(FnMap.ofObjectObject().insert(position, newKey, newValue)));
    }


    public Level0MapSelectedOperator<I,K,V> sort() {
        return new Level0MapSelectedOperator<I,K,V>(getTarget().execute(FnMap.ofObjectObject().sortByKey()));
    }


    @SuppressWarnings("unchecked")
    public Level0MapSelectedOperator<I,K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level0MapSelectedOperator<I,K,V>(getTarget().execute(FnMap.ofObjectObject().sortEntries((Comparator)comparator)));
    }


    public Level0MapSelectedOperator<I,K,V> replaceWith(final Map<K,V> replacement) {
        return new Level0MapSelectedOperator<I,K,V>(getTarget().replaceWith(replacement, Normalisation.MAP));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}

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

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapSelectedEntriesOperatorImpl<I,K,V> extends AbstractOperatorImpl implements UniqOpOperator<I,Map<K,V>>, Level1MapSelectedEntriesOperator<I,K,V> {


    public Level1MapSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> ifTrue(final IFunction<? super Entry<K,V>,Boolean> eval) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().selectMatching(eval));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> ifFalse(final IFunction<? super Entry<K,V>,Boolean> eval) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().selectNotMatching(eval));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> ifIndex(final int... indexes) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().selectIndex(indexes));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> ifIndexNot(final int... indexes) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level0MapSelectedOperatorImpl<I,K,V> endFor() {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().endIterate(null));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> ifKeyEquals(final K... keys) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> ifKeyNotEquals(final K... keys) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapSelectedEntriesKeyOperatorImpl<I,K,V> onKey() {
        return new Level2MapSelectedEntriesKeyOperatorImpl<I,K,V>(getTarget().onKey());
    }


    public Level2MapSelectedEntriesValueOperatorImpl<I,K,V> onValue() {
        return new Level2MapSelectedEntriesValueOperatorImpl<I,K,V>(getTarget().onValue());
    }


    public Level1MapSelectedEntriesOperatorImpl<I,K,V> execAsMapEntry(final IFunction<? super Entry<K,V>,? extends Entry<? extends K,? extends V>> function) {
        return new Level1MapSelectedEntriesOperatorImpl<I,K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapSelectedEntriesOperatorImpl<I,K,V> execIfNotNullAsMapEntry(final IFunction<? super Entry<K,V>,? extends Entry<? extends K,? extends V>> function) {
        return new Level1MapSelectedEntriesOperatorImpl<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapSelectedEntriesOperatorImpl<I,K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level1MapSelectedEntriesOperatorImpl<I,K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Map<K,V> get() {
        return endFor().get();
    }



}

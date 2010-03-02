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
package org.op4j.operators.impl.fn.map;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.intf.map.ILevel1MapSelectedEntriesOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapSelectedEntriesOperator<I,K,V> extends AbstractOperator implements UniqFnOperator<I,Map<K,V>>, ILevel1MapSelectedEntriesOperator<I,K,V> {


    public Level1MapSelectedEntriesOperator(final Target target) {
        super(target);
    }


    public Level1MapSelectedEntriesSelectedOperator<I,K,V> ifTrue(final IFunction<? super Entry<K,V>,Boolean> eval) {
        return new Level1MapSelectedEntriesSelectedOperator<I,K,V>(getTarget().selectMatching(eval));
    }


    public Level1MapSelectedEntriesSelectedOperator<I,K,V> ifFalse(final IFunction<? super Entry<K,V>,Boolean> eval) {
        return new Level1MapSelectedEntriesSelectedOperator<I,K,V>(getTarget().selectNotMatching(eval));
    }


    public Level1MapSelectedEntriesSelectedOperator<I,K,V> ifIndex(final int... indexes) {
        return new Level1MapSelectedEntriesSelectedOperator<I,K,V>(getTarget().selectIndex(indexes));
    }


    public Level1MapSelectedEntriesSelectedOperator<I,K,V> ifIndexNot(final int... indexes) {
        return new Level1MapSelectedEntriesSelectedOperator<I,K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level0MapSelectedOperator<I,K,V> endFor() {
        return new Level0MapSelectedOperator<I,K,V>(getTarget().endIterate(null));
    }


    public Level1MapSelectedEntriesSelectedOperator<I,K,V> ifKeyEquals(final K... keys) {
        return new Level1MapSelectedEntriesSelectedOperator<I,K,V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapSelectedEntriesSelectedOperator<I,K,V> ifKeyNotEquals(final K... keys) {
        return new Level1MapSelectedEntriesSelectedOperator<I,K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapSelectedEntriesKeyOperator<I,K,V> onKey() {
        return new Level2MapSelectedEntriesKeyOperator<I,K,V>(getTarget().onKey());
    }


    public Level2MapSelectedEntriesValueOperator<I,K,V> onValue() {
        return new Level2MapSelectedEntriesValueOperator<I,K,V>(getTarget().onValue());
    }


    public Level1MapSelectedEntriesOperator<I,K,V> execAsMapEntry(final IFunction<? super Entry<K,V>,? extends Entry<? extends K,? extends V>> function) {
        return new Level1MapSelectedEntriesOperator<I,K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapSelectedEntriesOperator<I,K,V> execIfNotNullAsMapEntry(final IFunction<? super Entry<K,V>,? extends Entry<? extends K,? extends V>> function) {
        return new Level1MapSelectedEntriesOperator<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapSelectedEntriesOperator<I,K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level1MapSelectedEntriesOperator<I,K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Function<I,Map<K,V>> get() {
        return endFor().get();
    }



}

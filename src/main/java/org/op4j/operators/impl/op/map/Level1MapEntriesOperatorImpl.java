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
package org.op4j.operators.impl.op.map;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.impl.op.list.Level1ListElementsOperatorImpl;
import org.op4j.operators.intf.map.Level1MapEntriesOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level1MapEntriesOperatorImpl<I,K,V> extends AbstractOperatorImpl
        implements UniqOpOperator<I,Map<K,V>>, Level1MapEntriesOperator<I,K,V> {

    
    public Level1MapEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOperatorImpl<I,K, V> endFor() {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().endIterate(null));
    }


    public Level2MapEntriesKeyOperatorImpl<I,K, V> onKey() {
        return new Level2MapEntriesKeyOperatorImpl<I,K, V>(getTarget().onKey());
    }


    public Level2MapEntriesValueOperatorImpl<I,K, V> onValue() {
        return new Level2MapEntriesValueOperatorImpl<I,K, V>(getTarget().onValue());
    }


    public Map<K, V> get() {
        return endFor().get();
    }



    
    public Level1MapEntriesSelectedOperatorImpl<I,K, V> ifIndex(final int... indexes) {
        return new Level1MapEntriesSelectedOperatorImpl<I,K, V>(getTarget().selectIndex(indexes));
    }


    public Level1MapEntriesSelectedOperatorImpl<I,K, V> ifIndexNot(final int... indexes) {
        return new Level1MapEntriesSelectedOperatorImpl<I,K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level1MapEntriesSelectedOperatorImpl<I,K, V> ifKeyEquals(final K... keys) {
        return new Level1MapEntriesSelectedOperatorImpl<I,K, V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapEntriesSelectedOperatorImpl<I,K, V> ifKeyNotEquals(final K... keys) {
        return new Level1MapEntriesSelectedOperatorImpl<I,K, V>(getTarget().selectMapKeysNot(keys));
    }


    public Level1MapEntriesSelectedOperatorImpl<I,K, V> ifTrue(final IFunction<? super Entry<K, V>,Boolean> eval) {
        return new Level1MapEntriesSelectedOperatorImpl<I,K, V>(getTarget().selectMatching(eval));
    }


    public Level1MapEntriesSelectedOperatorImpl<I,K, V> ifFalse(final IFunction<? super Entry<K, V>,Boolean> eval) {
        return new Level1MapEntriesSelectedOperatorImpl<I,K, V>(getTarget().selectNotMatching(eval));
    }


    


    public <X, Y> Level1MapEntriesOperatorImpl<I,X, Y> execAsMapEntry(final IFunction<? super Entry<K, V>,? extends Entry<X, Y>> function) {
        return new Level1MapEntriesOperatorImpl<I,X, Y>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    


    public <X> Level1ListElementsOperatorImpl<I,X> exec(final IFunction<? super Entry<K, V>,X> function) {
        return new Level1ListElementsOperatorImpl<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1MapEntriesOperatorImpl<I,K, V> replaceWith(final Entry<K, V> replacement) {
        return new Level1MapEntriesOperatorImpl<I,K, V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    

}

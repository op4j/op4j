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
package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesSelectedOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level1MapOfSetEntriesOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level1MapOfSetEntriesOperator<K,V> {

    
    public Level1MapOfSetEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfSetOperator<K, V> endFor() {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().endIterate(null));
    }


    public Level2MapOfSetEntriesKeyOperator<K, V> onKey() {
        return new Level2MapOfSetEntriesKeyOperatorImpl<K, V>(getTarget().onKey());
    }


    public Level2MapOfSetEntriesValueOperator<K, V> onValue() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().onValue());
    }


    public Map<K, Set<V>> get() {
        return endFor().get();
    }

    
    
    public Level1MapOfSetEntriesSelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level1MapOfSetEntriesSelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level1MapOfSetEntriesSelectedOperator<K, V> ifKeyEquals(final K... keys) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K, V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfSetEntriesSelectedOperator<K, V> ifKeyNotEquals(final K... keys) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K, V>(getTarget().selectMapKeysNot(keys));
    }


    public Level1MapOfSetEntriesSelectedOperator<K, V> ifTrue(final IFunction<Boolean, ? super Entry<K, Set<V>>> eval) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level1MapOfSetEntriesSelectedOperator<K, V> ifFalse(final IFunction<Boolean, ? super Entry<K, Set<V>>> eval) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public <X, Y> Level1MapOfSetEntriesOperator<X, Y> execIfNotNullAsMapOfSetEntry(final IFunction<? extends Entry<X, ? extends Set<Y>>, ? super Entry<K, Set<V>>> function) {
        return new Level1MapOfSetEntriesOperatorImpl<X, Y>(getTarget().executeIfNotNull(function, Normalisation.MAP_OF_SET_ENTRY));
    }


    public <X, Y> Level1MapOfSetEntriesOperator<X, Y> execAsMapOfSetEntry(final IFunction<? extends Entry<X, ? extends Set<Y>>, ? super Entry<K, Set<V>>> function) {
        return new Level1MapOfSetEntriesOperatorImpl<X, Y>(getTarget().execute(function, Normalisation.MAP_OF_SET_ENTRY));
    }


    public <X> Level0GenericUniqOperator<X> execIfNotNull(final IFunction<X, ? super Entry<K, Set<V>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Entry<K, Set<V>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1MapOfSetEntriesOperator<K, V> replaceWith(final Entry<K, Set<V>> replacement) {
        return new Level1MapOfSetEntriesOperatorImpl<K, V>(getTarget().replaceWith(replacement, Normalisation.MAP_OF_SET_ENTRY));
    }


    
    
}

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

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level3MapOfListEntriesValueElementsOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level3MapOfMapEntriesValueEntriesOperatorImpl<K1,K2,V> extends AbstractOperatorImpl
        implements Level3MapOfMapEntriesValueEntriesOperator<K1,K2,V> {

    
    public Level3MapOfMapEntriesValueEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V> endFor() {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V>(getTarget().endIterate(null));
    }


    public Level4MapOfMapEntriesValueEntriesKeyOperator<K1, K2, V> onKey() {
        return new Level4MapOfMapEntriesValueEntriesKeyOperatorImpl<K1, K2, V>(getTarget().onKey());
    }


    public Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, V> onValue() {
        return new Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1, K2, V>(getTarget().onValue());
    }


    public Map<K1, Map<K2, V>> get() {
        return endFor().endOn().endFor().get();
    }

    
    
    
    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1, K2, V> ifIndex(final int... indexes) {
        return new Level3MapOfMapEntriesValueEntriesSelectedOperatorImpl<K1, K2, V>(getTarget().selectIndex(indexes));
    }


    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1, K2, V> ifIndexNot(final int... indexes) {
        return new Level3MapOfMapEntriesValueEntriesSelectedOperatorImpl<K1, K2, V>(getTarget().selectIndexNot(indexes));
    }


    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1, K2, V> ifKeyEquals(final K2... keys) {
        return new Level3MapOfMapEntriesValueEntriesSelectedOperatorImpl<K1, K2, V>(getTarget().selectMapKeys(keys));
    }


    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1, K2, V> ifKeyNotEquals(final K2... keys) {
        return new Level3MapOfMapEntriesValueEntriesSelectedOperatorImpl<K1, K2, V>(getTarget().selectMapKeysNot(keys));
    }


    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1, K2, V> ifTrue(final IFunction<Boolean, ? super Entry<K2, V>> eval) {
        return new Level3MapOfMapEntriesValueEntriesSelectedOperatorImpl<K1, K2, V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1, K2, V> ifFalse(final IFunction<Boolean, ? super Entry<K2, V>> eval) {
        return new Level3MapOfMapEntriesValueEntriesSelectedOperatorImpl<K1, K2, V>(getTarget().selectNotMatching(eval));
    }


    public <X2, Y> Level3MapOfMapEntriesValueEntriesOperator<K1, X2, Y> execIfNotNullAsMapEntry(final IFunction<? extends Entry<X2, Y>, ? super Entry<K2, V>> function) {
        return new Level3MapOfMapEntriesValueEntriesOperatorImpl<K1, X2, Y>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public <X2, Y> Level3MapOfMapEntriesValueEntriesOperator<K1, X2, Y> execAsMapEntry(final IFunction<? extends Entry<X2, Y>, ? super Entry<K2, V>> function) {
        return new Level3MapOfMapEntriesValueEntriesOperatorImpl<K1, X2, Y>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public <X> Level3MapOfListEntriesValueElementsOperator<K1, X> execIfNotNull(final IFunction<X, ? super Entry<K2, V>> function) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K1, X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level3MapOfListEntriesValueElementsOperator<K1, X> exec(final IFunction<X, ? super Entry<K2, V>> function) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K1, X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V> replaceWith(final Entry<K2, V> replacement) {
        return new Level3MapOfMapEntriesValueEntriesOperatorImpl<K1, K2, V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    
    
    
    
}

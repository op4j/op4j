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
package org.op4j.operators.op.impl.map;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.op.impl.list.Level1ListElementsOperatorImpl;
import org.op4j.operators.op.intf.list.Level1ListElementsOperator;
import org.op4j.operators.op.intf.map.Level0MapOperator;
import org.op4j.operators.op.intf.map.Level1MapEntriesOperator;
import org.op4j.operators.op.intf.map.Level1MapEntriesSelectedOperator;
import org.op4j.operators.op.intf.map.Level2MapEntriesKeyOperator;
import org.op4j.operators.op.intf.map.Level2MapEntriesValueOperator;
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
public final class Level1MapEntriesOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements UniqOpOperator<Map<K,V>>, Level1MapEntriesOperator<K,V,I> {

    
    public Level1MapEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOperator<K, V,I> endFor() {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().endIterate(null));
    }


    public Level2MapEntriesKeyOperator<K, V,I> onKey() {
        return new Level2MapEntriesKeyOperatorImpl<K, V,I>(getTarget().onKey());
    }


    public Level2MapEntriesValueOperator<K, V,I> onValue() {
        return new Level2MapEntriesValueOperatorImpl<K, V,I>(getTarget().onValue());
    }


    public Map<K, V> get() {
        return endFor().get();
    }



    
    public Level1MapEntriesSelectedOperator<K, V,I> ifIndex(final int... indexes) {
        return new Level1MapEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indexes));
    }


    public Level1MapEntriesSelectedOperator<K, V,I> ifIndexNot(final int... indexes) {
        return new Level1MapEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indexes));
    }


    public Level1MapEntriesSelectedOperator<K, V,I> ifKeyEquals(final K... keys) {
        return new Level1MapEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectMapKeys(keys));
    }


    public Level1MapEntriesSelectedOperator<K, V,I> ifKeyNotEquals(final K... keys) {
        return new Level1MapEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level1MapEntriesSelectedOperator<K, V,I> ifTrue(final IFunction<Boolean, ? super Entry<K, V>> eval) {
        return new Level1MapEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level1MapEntriesSelectedOperator<K, V,I> ifFalse(final IFunction<Boolean, ? super Entry<K, V>> eval) {
        return new Level1MapEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    


    public <X, Y> Level1MapEntriesOperator<X, Y,I> execAsMapEntry(final IFunction<? extends Entry<X, Y>, ? super Entry<K, V>> function) {
        return new Level1MapEntriesOperatorImpl<X, Y,I>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    


    public <X> Level1ListElementsOperator<X,I> exec(final IFunction<X, ? super Entry<K, V>> function) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1MapEntriesOperator<K, V,I> replaceWith(final Entry<K, V> replacement) {
        return new Level1MapEntriesOperatorImpl<K, V,I>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    

}

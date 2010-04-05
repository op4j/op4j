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
import org.op4j.operators.impl.fn.list.Level1ListElementsOperator;
import org.op4j.operators.intf.map.ILevel1MapEntriesOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level1MapEntriesOperator<I,K,V> extends AbstractOperator
        implements UniqFnOperator<I,Map<K,V>>, ILevel1MapEntriesOperator<I,K,V> {

    
    public Level1MapEntriesOperator(final Target target) {
        super(target);
    }


    public Level0MapOperator<I,K, V> endFor() {
        return new Level0MapOperator<I,K, V>(getTarget().endIterate(null));
    }


    public Level2MapEntriesKeyOperator<I,K, V> onKey() {
        return new Level2MapEntriesKeyOperator<I,K, V>(getTarget().onKey());
    }


    public Level2MapEntriesValueOperator<I,K, V> onValue() {
        return new Level2MapEntriesValueOperator<I,K, V>(getTarget().onValue());
    }


    public Function<I,Map<K, V>> get() {
        return endFor().get();
    }



    
    public Level1MapEntriesSelectedOperator<I,K, V> ifIndex(final int... indexes) {
        return new Level1MapEntriesSelectedOperator<I,K, V>(getTarget().selectIndex(indexes));
    }


    public Level1MapEntriesSelectedOperator<I,K, V> ifIndexNot(final int... indexes) {
        return new Level1MapEntriesSelectedOperator<I,K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level1MapEntriesSelectedOperator<I,K, V> ifKeyEquals(final K... keys) {
        return new Level1MapEntriesSelectedOperator<I,K, V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapEntriesSelectedOperator<I,K, V> ifKeyNotEquals(final K... keys) {
        return new Level1MapEntriesSelectedOperator<I,K, V>(getTarget().selectMapKeysNot(keys));
    }


    public Level1MapEntriesSelectedOperator<I,K, V> ifTrue(final IFunction<? super Entry<K, V>,Boolean> eval) {
        return new Level1MapEntriesSelectedOperator<I,K, V>(getTarget().selectMatching(eval));
    }


    public Level1MapEntriesSelectedOperator<I,K, V> ifFalse(final IFunction<? super Entry<K, V>,Boolean> eval) {
        return new Level1MapEntriesSelectedOperator<I,K, V>(getTarget().selectNotMatching(eval));
    }


    


    public <X, Y> Level1MapEntriesOperator<I,X, Y> execAsMapEntry(final IFunction<? super Entry<K, V>,? extends Entry<X, Y>> function) {
        return new Level1MapEntriesOperator<I,X, Y>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    


    public <X> Level1ListElementsOperator<I,X> exec(final IFunction<? super Entry<K, V>,X> function) {
        return new Level1ListElementsOperator<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1MapEntriesOperator<I,K, V> replaceWith(final Entry<K, V> replacement) {
        return new Level1MapEntriesOperator<I,K, V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }

    
    
    
    public Level1MapEntriesOperator<I, K, V> execIfFalseAsMapEntry(final IFunction<? super Entry<K, V>, Boolean> eval, final IFunction<? super Entry<K, V>, ? extends Entry<? extends K, ? extends V>> function) {
        return new Level1MapEntriesOperator<I,K,V>(getTarget().executeIfFalse(eval, function, null, Normalisation.MAP_ENTRY));
    }


    public <X, Y> Level1MapEntriesOperator<I, X, Y> execIfFalseAsMapEntry(final IFunction<? super Entry<K, V>, Boolean> eval, final IFunction<? super Entry<K, V>, ? extends Entry<X, Y>> function, final IFunction<? super Entry<K, V>, ? extends Entry<X, Y>> elseFunction) {
        return new Level1MapEntriesOperator<I,X,Y>(getTarget().executeIfFalse(eval, function, elseFunction, Normalisation.MAP_ENTRY));
    }


    public Level1MapEntriesOperator<I, K, V> execIfTrueAsMapEntry(final IFunction<? super Entry<K, V>, Boolean> eval, final IFunction<? super Entry<K, V>, ? extends Entry<? extends K, ? extends V>> function) {
        return new Level1MapEntriesOperator<I,K,V>(getTarget().executeIfTrue(eval, function, null, Normalisation.MAP_ENTRY));
    }


    public <X, Y> Level1MapEntriesOperator<I, X, Y> execIfTrueAsMapEntry(final IFunction<? super Entry<K, V>, Boolean> eval, final IFunction<? super Entry<K, V>, ? extends Entry<X, Y>> function, final IFunction<? super Entry<K, V>, ? extends Entry<X, Y>> elseFunction) {
        return new Level1MapEntriesOperator<I,X,Y>(getTarget().executeIfTrue(eval, function, elseFunction, Normalisation.MAP_ENTRY));
    }

    

    

}

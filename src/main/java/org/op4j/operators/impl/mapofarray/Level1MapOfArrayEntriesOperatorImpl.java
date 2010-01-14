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
package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1MapOfArrayEntriesOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level1MapOfArrayEntriesOperator<K,V> {

    
    public Level1MapOfArrayEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfArrayOperator<K, V> endFor() {
        return new Level0MapOfArrayOperatorImpl<K, V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level2MapOfArrayEntriesKeyOperator<K, V> onKey() {
        return new Level2MapOfArrayEntriesKeyOperatorImpl<K, V>(getTarget().iterateIndex(0));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> onValue() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().iterateIndex(1));
    }


    public Map<K, V[]> get() {
        return endFor().get();
    }

    

    
    public Level1MapOfArrayEntriesSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V> ifKeyEquals(final K... keys) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V> ifKeyNotEquals(final K... keys) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V>(getTarget().selectMapKeysNot(keys));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V> ifMatching(final IEvaluator<Boolean, ? super Entry<K, V[]>> eval) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K, V[]>> eval) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public <X, Y> Level1MapOfArrayEntriesOperator<X, Y> convert(final IConverter<? extends Entry<X, Y[]>, ? super Entry<K, V[]>> converter) {
        return new Level1MapOfArrayEntriesOperatorImpl<X, Y>(getTarget().execute(converter));
    }


    public <X, Y> Level1MapOfArrayEntriesOperator<X, Y> eval(final IEvaluator<? extends Entry<X, Y[]>, ? super Entry<K, V[]>> eval) {
        return new Level1MapOfArrayEntriesOperatorImpl<X, Y>(getTarget().execute(eval));
    }


    public <X, Y> Level1MapOfArrayEntriesOperator<X, Y> exec(final IFunction<? extends Entry<X, Y[]>, ? super Entry<K, V[]>> function) {
        return new Level1MapOfArrayEntriesOperatorImpl<X, Y>(getTarget().execute(function));
    }
    
    
}

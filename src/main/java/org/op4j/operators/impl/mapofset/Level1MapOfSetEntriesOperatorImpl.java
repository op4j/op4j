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
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.list.Level1ListElementsOperatorImpl;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesSelectedOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1MapOfSetEntriesOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level1MapOfSetEntriesOperator<K,V> {

    
    public Level1MapOfSetEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfSetOperator<K, V> endFor() {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level2MapOfSetEntriesKeyOperator<K, V> onKey() {
        return new Level2MapOfSetEntriesKeyOperatorImpl<K, V>(getTarget().iterateIndex(0));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> onValue() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().iterateIndex(1));
    }


    public Map<K, Set<V>> get() {
        return endFor().get();
    }

    
    
    public <X> Level1ListElementsOperator<X> convert(final IConverter<X, ? super Entry<K, Set<V>>> converter) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(converter));
	}


	public <X> Level1ListElementsOperator<X> eval(final IEvaluator<X, ? super Entry<K, Set<V>>> eval) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(eval));
	}


	public <X> Level1ListElementsOperator<X> exec(final IFunction<X, ? super Entry<K, Set<V>>> function) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(function));
	}


    public Level1MapOfSetEntriesSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level1MapOfSetEntriesSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level1MapOfSetEntriesSelectedOperator<K, V> ifKeyEquals(final K... keys) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K, V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfSetEntriesSelectedOperator<K, V> ifKeyNotEquals(final K... keys) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K, V>(getTarget().selectMapKeysNot(keys));
    }


    public Level1MapOfSetEntriesSelectedOperator<K, V> ifMatching(final IEvaluator<Boolean, ? super Entry<K, Set<V>>> eval) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level1MapOfSetEntriesSelectedOperator<K, V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K, Set<V>>> eval) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }
    
}

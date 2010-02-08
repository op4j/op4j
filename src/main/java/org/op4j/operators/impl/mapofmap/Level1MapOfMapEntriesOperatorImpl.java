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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.list.Level1ListElementsOperatorImpl;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1MapOfMapEntriesOperatorImpl<K1,K2,V> extends AbstractOperatorImpl
        implements Level1MapOfMapEntriesOperator<K1,K2,V> {

    
    public Level1MapOfMapEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfMapOperator<K1, K2, V> endFor() {
        return new Level0MapOfMapOperatorImpl<K1, K2, V>(getTarget().endIterate(null));
    }


    public Level2MapOfMapEntriesKeyOperator<K1, K2, V> onKey() {
        return new Level2MapOfMapEntriesKeyOperatorImpl<K1, K2, V>(getTarget().onKey());
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V> onValue() {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V>(getTarget().onValue());
    }


    public Map<K1, Map<K2, V>> get() {
        return endFor().get();
    }

    
    
    
    
    public Level1MapOfMapEntriesSelectedOperator<K1, K2, V> ifIndex(final int... indexes) {
        return new Level1MapOfMapEntriesSelectedOperatorImpl<K1, K2, V>(getTarget().selectIndex(indexes));
    }


    public Level1MapOfMapEntriesSelectedOperator<K1, K2, V> ifIndexNot(final int... indexes) {
        return new Level1MapOfMapEntriesSelectedOperatorImpl<K1, K2, V>(getTarget().selectIndexNot(indexes));
    }


    public Level1MapOfMapEntriesSelectedOperator<K1, K2, V> ifKeyEquals(final K1... keys) {
        return new Level1MapOfMapEntriesSelectedOperatorImpl<K1, K2, V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfMapEntriesSelectedOperator<K1, K2, V> ifKeyNotEquals(final K1... keys) {
        return new Level1MapOfMapEntriesSelectedOperatorImpl<K1, K2, V>(getTarget().selectMapKeysNot(keys));
    }


    public Level1MapOfMapEntriesSelectedOperator<K1, K2, V> ifTrue(final IEvaluator<Boolean, ? super Entry<K1, Map<K2, V>>> eval) {
        return new Level1MapOfMapEntriesSelectedOperatorImpl<K1, K2, V>(getTarget().selectMatching(eval));
    }


    public Level1MapOfMapEntriesSelectedOperator<K1, K2, V> ifFalse(final IEvaluator<Boolean, ? super Entry<K1, Map<K2, V>>> eval) {
        return new Level1MapOfMapEntriesSelectedOperatorImpl<K1, K2, V>(getTarget().selectNotMatching(eval));
    }


    public <X1, X2, Y> Level1MapOfMapEntriesOperator<X1, X2, Y> convertAsMapOfMapEntry(final IConverter<? extends Entry<X1, ? extends Map<X2, Y>>, ? super Entry<K1, Map<K2, V>>> converter) {
        return new Level1MapOfMapEntriesOperatorImpl<X1, X2, Y>(getTarget().execute(converter, Normalisation.MAPENTRY_OF_MAP));
    }


    public <X1, X2, Y> Level1MapOfMapEntriesOperator<X1, X2, Y> evalAsMapOfMapEntry(final IEvaluator<? extends Entry<X1, ? extends Map<X2, Y>>, ? super Entry<K1, Map<K2, V>>> eval) {
        return new Level1MapOfMapEntriesOperatorImpl<X1, X2, Y>(getTarget().execute(eval, Normalisation.MAPENTRY_OF_MAP));
    }


    public <X1, X2, Y> Level1MapOfMapEntriesOperator<X1, X2, Y> execAsMapOfMapEntry(final IFunction<? extends Entry<X1, ? extends Map<X2, Y>>, ? super Entry<K1, Map<K2, V>>> function) {
        return new Level1MapOfMapEntriesOperatorImpl<X1, X2, Y>(getTarget().execute(function, Normalisation.MAPENTRY_OF_MAP));
    }


    public <X> Level1ListElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Entry<K1, Map<K2, V>>> converter) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level1ListElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Entry<K1, Map<K2, V>>> eval) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level1ListElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Entry<K1, Map<K2, V>>> function) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1MapOfMapEntriesOperator<K1, K2, V> replaceWith(final Entry<K1, Map<K2, V>> replacement) {
        return new Level1MapOfMapEntriesOperatorImpl<K1, K2, V>(getTarget().replaceWith(replacement));
    }


    
    
    
}

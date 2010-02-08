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
package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListEntriesOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListEntriesSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1MapOfListEntriesOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level1MapOfListEntriesOperator<K,V> {

    
    public Level1MapOfListEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfListOperator<K, V> endFor() {
        return new Level0MapOfListOperatorImpl<K, V>(getTarget().endIterate(null));
    }


    public Level2MapOfListEntriesKeyOperator<K, V> onKey() {
        return new Level2MapOfListEntriesKeyOperatorImpl<K, V>(getTarget().onKey());
    }


    public Level2MapOfListEntriesValueOperator<K, V> onValue() {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().onValue());
    }


    public Map<K, List<V>> get() {
        return endFor().get();
    }

    

    
    public Level1MapOfListEntriesSelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level1MapOfListEntriesSelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level1MapOfListEntriesSelectedOperator<K, V> ifKeyEquals(final K... keys) {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K, V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfListEntriesSelectedOperator<K, V> ifKeyNotEquals(final K... keys) {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K, V>(getTarget().selectMapKeysNot(keys));
    }


    public Level1MapOfListEntriesSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super Entry<K, List<V>>> eval) {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level1MapOfListEntriesSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super Entry<K, List<V>>> eval) {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public <X, Y> Level1MapOfListEntriesOperator<X, Y> convert(final IConverter<? extends Entry<X, ? extends List<Y>>, ? super Entry<K, List<V>>> converter) {
        return new Level1MapOfListEntriesOperatorImpl<X, Y>(getTarget().execute(converter, Normalisation.MAPENTRY_OF_LIST));
    }


    public <X, Y> Level1MapOfListEntriesOperator<X, Y> eval(final IEvaluator<? extends Entry<X, ? extends List<Y>>, ? super Entry<K, List<V>>> eval) {
        return new Level1MapOfListEntriesOperatorImpl<X, Y>(getTarget().execute(eval, Normalisation.MAPENTRY_OF_LIST));
    }


    public <X, Y> Level1MapOfListEntriesOperator<X, Y> exec(final IFunction<? extends Entry<X, ? extends List<Y>>, ? super Entry<K, List<V>>> function) {
        return new Level1MapOfListEntriesOperatorImpl<X, Y>(getTarget().execute(function, Normalisation.MAPENTRY_OF_LIST));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Entry<K, List<V>>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Entry<K, List<V>>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Entry<K, List<V>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1MapOfListEntriesOperator<K, V> replaceWith(final Entry<K, List<V>> replacement) {
        return new Level1MapOfListEntriesOperatorImpl<K, V>(getTarget().replaceWith(replacement));
    }


    
    
    
    
}

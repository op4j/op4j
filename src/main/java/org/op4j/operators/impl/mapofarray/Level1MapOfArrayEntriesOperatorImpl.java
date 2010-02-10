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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1MapOfArrayEntriesOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level1MapOfArrayEntriesOperator<K,V> {


    private final Type<V> type; 

    
    public Level1MapOfArrayEntriesOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level0MapOfArrayOperator<K, V> endFor() {
        return new Level0MapOfArrayOperatorImpl<K, V>(this.type, getTarget().endIterate(null));
    }


    public Level2MapOfArrayEntriesKeyOperator<K, V> onKey() {
        return new Level2MapOfArrayEntriesKeyOperatorImpl<K, V>(this.type, getTarget().onKey());
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> onValue() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().onValue());
    }


    public Map<K, V[]> get() {
        return endFor().get();
    }

    

    
    public Level1MapOfArrayEntriesSelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V>(this.type, getTarget().selectIndex(indexes));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V> ifKeyEquals(final K... keys) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V>(this.type, getTarget().selectMapKeys(keys));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V> ifKeyNotEquals(final K... keys) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V>(this.type, getTarget().selectMapKeysNot(keys));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super Entry<K, V[]>> eval) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V>(this.type, getTarget().selectMatching(eval));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super Entry<K, V[]>> eval) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1MapOfArrayEntriesOperator<K,V> convertAsMapOfArrayEntry(final IConverter<? extends Entry<? extends K, ? extends V[]>, ? super Entry<K, V[]>> converter) {
        return new Level1MapOfArrayEntriesOperatorImpl<K,V>(this.type, getTarget().execute(converter, Normalisation.MAPENTRY_OF_ARRAY));
    }


    public Level1MapOfArrayEntriesOperator<K,V> evalAsMapOfArrayEntry(final IEvaluator<? extends Entry<? extends K, ? extends V[]>, ? super Entry<K, V[]>> eval) {
        return new Level1MapOfArrayEntriesOperatorImpl<K,V>(this.type, getTarget().execute(eval, Normalisation.MAPENTRY_OF_ARRAY));
    }


    public Level1MapOfArrayEntriesOperator<K,V> execAsMapOfArrayEntry(final IFunction<? extends Entry<? extends K, ? extends V[]>, ? super Entry<K, V[]>> function) {
        return new Level1MapOfArrayEntriesOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.MAPENTRY_OF_ARRAY));
    }


    public <X, Y> Level1MapOfArrayEntriesOperator<X, Y> convertAsMapOfArrayEntryOf(final Type<Y> valueType, final IConverter<? extends Entry<X, Y[]>, ? super Entry<K, V[]>> converter) {
        return new Level1MapOfArrayEntriesOperatorImpl<X, Y>(valueType, getTarget().execute(converter, Normalisation.MAPENTRY_OF_ARRAY));
    }


    public <X, Y> Level1MapOfArrayEntriesOperator<X, Y> evalAsMapOfArrayEntryOf(final Type<Y> valueType, final IEvaluator<? extends Entry<X, Y[]>, ? super Entry<K, V[]>> eval) {
        return new Level1MapOfArrayEntriesOperatorImpl<X, Y>(valueType, getTarget().execute(eval, Normalisation.MAPENTRY_OF_ARRAY));
    }


    public <X, Y> Level1MapOfArrayEntriesOperator<X, Y> execAsMapOfArrayEntryOf(final Type<Y> valueType, final IFunction<? extends Entry<X, Y[]>, ? super Entry<K, V[]>> function) {
        return new Level1MapOfArrayEntriesOperatorImpl<X, Y>(valueType, getTarget().execute(function, Normalisation.MAPENTRY_OF_ARRAY));
    }


    public <X> Level0GenericUniqOperator<X> convert(final IConverter<X, ? super Entry<K, V[]>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Entry<K, V[]>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Entry<K, V[]>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1MapOfArrayEntriesOperator<K, V> replaceWith(final Entry<K, V[]> replacement) {
        return new Level1MapOfArrayEntriesOperatorImpl<K, V>(this.type, getTarget().replaceWith(replacement));
    }


    
    
    
}

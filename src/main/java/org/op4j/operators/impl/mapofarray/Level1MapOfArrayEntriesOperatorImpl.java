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
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1MapOfArrayEntriesOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level1MapOfArrayEntriesOperator<K,V,I> {

    
    public Level1MapOfArrayEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfArrayOperator<K, V,I> endFor() {
        return new Level0MapOfArrayOperatorImpl<K, V,I>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level2MapOfArrayEntriesKeyOperator<K, V,I> onKey() {
        return new Level2MapOfArrayEntriesKeyOperatorImpl<K, V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V,I> onValue() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().iterate().selectIndex(1));
    }


    public Map<K, V[]> get() {
        return endFor().get();
    }

    

    
    public Level1MapOfArrayEntriesSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V,I> ifKeyEquals(final K... keys) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V,I> ifKeyNotEquals(final K... keys) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super Entry<K, V[]>> eval) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super Entry<K, V[]>> eval) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public <X, Y> Level1MapOfArrayEntriesOperator<X, Y,I> convert(final IConverter<? extends Entry<X, Y[]>, ? super Entry<K, V[]>> converter) {
        return new Level1MapOfArrayEntriesOperatorImpl<X, Y,I>(getTarget().execute(converter, Normalization.MAPENTRY_OF_ARRAY));
    }


    public <X, Y> Level1MapOfArrayEntriesOperator<X, Y,I> eval(final IEvaluator<? extends Entry<X, Y[]>, ? super Entry<K, V[]>> eval) {
        return new Level1MapOfArrayEntriesOperatorImpl<X, Y,I>(getTarget().execute(eval, Normalization.MAPENTRY_OF_ARRAY));
    }


    public <X, Y> Level1MapOfArrayEntriesOperator<X, Y,I> exec(final IFunction<? extends Entry<X, Y[]>, ? super Entry<K, V[]>> function) {
        return new Level1MapOfArrayEntriesOperatorImpl<X, Y,I>(getTarget().execute(function, Normalization.MAPENTRY_OF_ARRAY));
    }


    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Entry<K, V[]>> converter) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Entry<K, V[]>> eval) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Entry<K, V[]>> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1MapOfArrayEntriesOperator<K, V,I> replaceWith(final Entry<K, V[]> replacement) {
        return new Level1MapOfArrayEntriesOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Operation<Map<K, V[]>, I> createOperation() {
        return endFor().createOperation();
    }
    
    
}

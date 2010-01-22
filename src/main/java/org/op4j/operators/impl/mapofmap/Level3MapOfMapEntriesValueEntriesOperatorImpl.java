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
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level3MapOfListEntriesValueElementsOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesValueOperator;
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
public class Level3MapOfMapEntriesValueEntriesOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl
        implements Level3MapOfMapEntriesValueEntriesOperator<K1,K2,V,I> {

    
    public Level3MapOfMapEntriesValueEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V,I> endFor() {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V,I>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level4MapOfMapEntriesValueEntriesKeyOperator<K1, K2, V,I> onKey() {
        return new Level4MapOfMapEntriesValueEntriesKeyOperatorImpl<K1, K2, V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, V,I> onValue() {
        return new Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1, K2, V,I>(getTarget().iterate().selectIndex(1));
    }


    public Map<K1, Map<K2, V>> get() {
        return endFor().endOn().endFor().get();
    }

    
    
    
    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1, K2, V,I> ifIndex(final int... indices) {
        return new Level3MapOfMapEntriesValueEntriesSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectIndex(indices));
    }


    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1, K2, V,I> ifIndexNot(final int... indices) {
        return new Level3MapOfMapEntriesValueEntriesSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1, K2, V,I> ifKeyEquals(final K2... keys) {
        return new Level3MapOfMapEntriesValueEntriesSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectMapKeys(keys));
    }


    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1, K2, V,I> ifKeyNotEquals(final K2... keys) {
        return new Level3MapOfMapEntriesValueEntriesSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1, K2, V,I> ifTrue(final IEvaluator<Boolean, ? super Entry<K2, V>> eval) {
        return new Level3MapOfMapEntriesValueEntriesSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectMatching(eval));
    }


    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1, K2, V,I> ifFalse(final IEvaluator<Boolean, ? super Entry<K2, V>> eval) {
        return new Level3MapOfMapEntriesValueEntriesSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotMatching(eval));
    }


    public <X2, Y> Level3MapOfMapEntriesValueEntriesOperator<K1, X2, Y,I> convert(final IConverter<? extends Entry<X2, Y>, ? super Entry<K2, V>> converter) {
        return new Level3MapOfMapEntriesValueEntriesOperatorImpl<K1, X2, Y,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public <X2, Y> Level3MapOfMapEntriesValueEntriesOperator<K1, X2, Y,I> eval(final IEvaluator<? extends Entry<X2, Y>, ? super Entry<K2, V>> eval) {
        return new Level3MapOfMapEntriesValueEntriesOperatorImpl<K1, X2, Y,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public <X2, Y> Level3MapOfMapEntriesValueEntriesOperator<K1, X2, Y,I> exec(final IFunction<? extends Entry<X2, Y>, ? super Entry<K2, V>> function) {
        return new Level3MapOfMapEntriesValueEntriesOperatorImpl<K1, X2, Y,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public <X> Level3MapOfListEntriesValueElementsOperator<K1, X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Entry<K2, V>> converter) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K1, X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level3MapOfListEntriesValueElementsOperator<K1, X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Entry<K2, V>> eval) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K1, X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level3MapOfListEntriesValueElementsOperator<K1, X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Entry<K2, V>> function) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K1, X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V,I> replaceWith(final Entry<K2, V> replacement) {
        return new Level3MapOfMapEntriesValueEntriesOperatorImpl<K1, K2, V,I>(getTarget().replaceWith(replacement));
    }


    public Operation<Map<K1, Map<K2, V>>, I> createOperation() {
        return endFor().createOperation();
    }
    
    
    
}

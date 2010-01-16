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

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesValueElementsOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalizationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level3MapOfListEntriesValueElementsOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level3MapOfListEntriesValueElementsOperator<K,V> {

    
    public Level3MapOfListEntriesValueElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListEntriesValueOperator<K, V> endFor() {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> Level3MapOfListEntriesValueElementsOperator<K, X> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfListOfValue(type, get());
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K, X>(getTarget());
    }

    public Level3MapOfListEntriesValueElementsOperator<K, ?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K, List<V>> get() {
        return endFor().endOn().endFor().get();
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifNotNull() {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifNull() {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level3MapOfListEntriesValueElementsOperator<K, X> convert(final IConverter<X, ? super V> converter) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K, X>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level3MapOfListEntriesValueElementsOperator<K, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K, X>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level3MapOfListEntriesValueElementsOperator<K, X> exec(final IFunction<X, ? super V> function) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K, X>(getTarget().execute(function, Normalization.NONE));
    }

}

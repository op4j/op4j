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

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level4MapOfMapEntriesValueEntriesKeyOperatorImpl<K1,K2,V> extends AbstractOperatorImpl
        implements Level4MapOfMapEntriesValueEntriesKeyOperator<K1,K2,V> {

    
    public Level4MapOfMapEntriesValueEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V> endOn() {
        return new Level3MapOfMapEntriesValueEntriesOperatorImpl<K1, K2, V>(getTarget().endOn());
    }


    public <X> Level4MapOfMapEntriesValueEntriesKeyOperator<K1, X, V> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfMapOfValueOfKey(type, get());
        return new Level4MapOfMapEntriesValueEntriesKeyOperatorImpl<K1, X, V>(getTarget());
    }

    public Level4MapOfMapEntriesValueEntriesKeyOperator<K1, ?, V> asUnknown() {
        return asType(Types.OBJECT);
    }

    




    public Map<K1, Map<K2, V>> get() {
        return endOn().endFor().endOn().endFor().get();
    }


    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1, K2, V> ifIndex(final int... indices) {
        return new Level4MapOfMapEntriesValueEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectIndex(indices));
    }


    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1, K2, V> ifIndexNot(final int... indices) {
        return new Level4MapOfMapEntriesValueEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectIndexNot(indices));
    }


    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1, K2, V> ifTrue(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesValueEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1, K2, V> ifFalse(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesValueEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectNotMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1, K2, V> ifNotNull() {
        return new Level4MapOfMapEntriesValueEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNull());
    }


    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1, K2, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesValueEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1, K2, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesValueEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1, K2, V> ifNull() {
        return new Level4MapOfMapEntriesValueEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectNull());
    }


    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1, K2, V> ifNullOrTrue(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesValueEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1, K2, V> ifNullOrFalse(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesValueEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level4MapOfMapEntriesValueEntriesKeyOperator<K1, X, V> convert(final IConverter<X, ? super K2> converter) {
        return new Level4MapOfMapEntriesValueEntriesKeyOperatorImpl<K1, X, V>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level4MapOfMapEntriesValueEntriesKeyOperator<K1, X, V> eval(final IEvaluator<X, ? super K2> eval) {
        return new Level4MapOfMapEntriesValueEntriesKeyOperatorImpl<K1, X, V>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level4MapOfMapEntriesValueEntriesKeyOperator<K1, X, V> exec(final IFunction<X, ? super K2> function) {
        return new Level4MapOfMapEntriesValueEntriesKeyOperatorImpl<K1, X, V>(getTarget().execute(function, Normalization.NONE));
    }


    public Level4MapOfMapEntriesValueEntriesKeyOperator<K1, K2, V> replaceWith(final K2 replacement) {
        return new Level4MapOfMapEntriesValueEntriesKeyOperatorImpl<K1, K2, V>(getTarget().replaceWith(replacement));
    }


    public Level4MapOfMapEntriesValueEntriesKeyOperator<K1, K2, V> replaceIfNullWith(final K2 replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    


}

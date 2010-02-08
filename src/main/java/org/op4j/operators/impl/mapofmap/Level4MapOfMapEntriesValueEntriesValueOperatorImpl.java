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
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.util.NormalisationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1,K2,V> extends AbstractOperatorImpl
        implements Level4MapOfMapEntriesValueEntriesValueOperator<K1,K2,V> {

    
    public Level4MapOfMapEntriesValueEntriesValueOperatorImpl(final Target target) {
        super(target);
    }

    
    
    public Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V> endOn() {
        return new Level3MapOfMapEntriesValueEntriesOperatorImpl<K1, K2, V>(getTarget().endOn());
    }


    public <X> Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalisationUtils.checkIsMapOfMapOfValueOfValue(type, get());
        return new Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1, K2, X>(getTarget());
    }

    public Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, ?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K1, Map<K2, V>> get() {
        return endOn().endFor().endOn().endFor().get();
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V> ifIndex(final int... indexes) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectIndex(indexes));
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V> ifIndexNot(final int... indexes) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectIndexNot(indexes));
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectNotMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V> ifNotNull() {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNull());
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V> ifNull() {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectNull());
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectNullOrNotMatching(eval));
    }



    public <X> Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> convert(final IConverter<X, ? super V> converter) {
        return new Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1, K2, X>(getTarget().execute(converter, Normalisation.NONE));
    }



    public <X> Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1, K2, X>(getTarget().execute(eval, Normalisation.NONE));
    }



    public <X> Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> exec(final IFunction<X, ? super V> function) {
        return new Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1, K2, X>(getTarget().execute(function, Normalisation.NONE));
    }



    public Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, V> replaceWith(final V replacement) {
        return new Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1, K2, V>(getTarget().replaceWith(replacement));
    }



    public Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, V> replaceIfNullWith(final V replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }



    



}

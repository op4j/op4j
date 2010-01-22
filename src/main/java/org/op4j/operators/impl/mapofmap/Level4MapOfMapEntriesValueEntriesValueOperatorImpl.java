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
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesValueSelectedOperator;
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
public class Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl
        implements Level4MapOfMapEntriesValueEntriesValueOperator<K1,K2,V,I> {

    
    public Level4MapOfMapEntriesValueEntriesValueOperatorImpl(final Target target) {
        super(target);
    }

    
    
    public Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V,I> endOn() {
        return new Level3MapOfMapEntriesValueEntriesOperatorImpl<K1, K2, V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X,I> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfMapOfValueOfValue(type, get());
        return new Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1, K2, X,I>(getTarget());
    }

    public Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, ?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K1, Map<K2, V>> get() {
        return endOn().endFor().endOn().endFor().get();
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V,I> ifIndex(final int... indices) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectIndex(indices));
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V,I> ifIndexNot(final int... indices) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V,I> ifNotNull() {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotNull());
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V,I> ifNull() {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNull());
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level4MapOfMapEntriesValueEntriesValueSelectedOperator<K1, K2, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNullOrNotMatching(eval));
    }



    public <X> Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X,I> convert(final IConverter<X, ? super V> converter) {
        return new Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1, K2, X,I>(getTarget().execute(converter, Normalization.NONE));
    }



    public <X> Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X,I> eval(final IEvaluator<X, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1, K2, X,I>(getTarget().execute(eval, Normalization.NONE));
    }



    public <X> Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X,I> exec(final IFunction<X, ? super V> function) {
        return new Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1, K2, X,I>(getTarget().execute(function, Normalization.NONE));
    }



    public Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, V,I> replaceWith(final V replacement) {
        return new Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1, K2, V,I>(getTarget().replaceWith(replacement));
    }



    public Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, V,I> replaceIfNullWith(final V replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }



    public Operation<Map<K1, Map<K2, V>>, I> createOperation() {
        return endOn().createOperation();
    }



}

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

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesValueElementsSelectedOperator;
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
public class Level3MapOfSetEntriesValueElementsOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level3MapOfSetEntriesValueElementsOperator<K,V> {

    
    public Level3MapOfSetEntriesValueElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetEntriesValueOperator<K, V> endFor() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> Level3MapOfSetEntriesValueElementsOperator<K, X> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfSetOfValue(type, get());
        return new Level3MapOfSetEntriesValueElementsOperatorImpl<K, X>(getTarget());
    }

    public Level3MapOfSetEntriesValueElementsOperator<K, ?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K, Set<V>> get() {
        return endFor().endOn().endFor().get();
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V> ifNotNull() {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V> ifNull() {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level3MapOfSetEntriesValueElementsOperator<K, X> convert(final IConverter<X, ? super V> converter) {
        return new Level3MapOfSetEntriesValueElementsOperatorImpl<K, X>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level3MapOfSetEntriesValueElementsOperator<K, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsOperatorImpl<K, X>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level3MapOfSetEntriesValueElementsOperator<K, X> exec(final IFunction<X, ? super V> function) {
        return new Level3MapOfSetEntriesValueElementsOperatorImpl<K, X>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3MapOfSetEntriesValueElementsOperator<K, V> replaceBy(final V replacement) {
        return new Level3MapOfSetEntriesValueElementsOperatorImpl<K, V>(getTarget().replaceBy(replacement));
    }


    public Level3MapOfSetEntriesValueElementsOperator<K, V> replaceIfNullBy(final V replacement) {
        return ifNull().replaceBy(replacement).endIf();
    }


}

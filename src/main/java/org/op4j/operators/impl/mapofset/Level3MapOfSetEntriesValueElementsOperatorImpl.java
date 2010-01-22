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
import org.op4j.operations.Operation;
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
public class Level3MapOfSetEntriesValueElementsOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level3MapOfSetEntriesValueElementsOperator<K,V,I> {

    
    public Level3MapOfSetEntriesValueElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetEntriesValueOperator<K, V,I> endFor() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> Level3MapOfSetEntriesValueElementsOperator<K, X,I> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfSetOfValue(type, get());
        return new Level3MapOfSetEntriesValueElementsOperatorImpl<K, X,I>(getTarget());
    }

    public Level3MapOfSetEntriesValueElementsOperator<K, ?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K, Set<V>> get() {
        return endFor().endOn().endFor().get();
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V,I> ifNotNull() {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotNull());
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V,I> ifNull() {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNull());
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level3MapOfSetEntriesValueElementsOperator<K, X,I> convert(final IConverter<X, ? super V> converter) {
        return new Level3MapOfSetEntriesValueElementsOperatorImpl<K, X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level3MapOfSetEntriesValueElementsOperator<K, X,I> eval(final IEvaluator<X, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsOperatorImpl<K, X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level3MapOfSetEntriesValueElementsOperator<K, X,I> exec(final IFunction<X, ? super V> function) {
        return new Level3MapOfSetEntriesValueElementsOperatorImpl<K, X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3MapOfSetEntriesValueElementsOperator<K, V,I> replaceWith(final V replacement) {
        return new Level3MapOfSetEntriesValueElementsOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfSetEntriesValueElementsOperator<K, V,I> replaceIfNullWith(final V replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Map<K, Set<V>>, I> createOperation() {
        return endFor().createOperation();
    }


}

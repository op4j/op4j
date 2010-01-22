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

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueElementsSelectedOperator;
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
public class Level3MapOfArrayEntriesValueElementsOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level3MapOfArrayEntriesValueElementsOperator<K,V,I> {
    
    private final Type<? extends V> type; 

    
    public Level3MapOfArrayEntriesValueElementsOperatorImpl(final Type<? extends V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2MapOfArrayEntriesValueOperator<K, V,I> endFor() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public <X> Level3MapOfArrayEntriesValueElementsOperator<K, X,I> asType(final Type<X> elementType) {
        Validate.notNull(elementType, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfArrayOfValue(elementType, get());
        return new Level3MapOfArrayEntriesValueElementsOperatorImpl<K, X,I>(elementType, getTarget());
    }

    public Level3MapOfArrayEntriesValueElementsOperator<K, ?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K, V[]> get() {
        return endFor().endOn().endFor().get();
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K, V,I>(this.type, getTarget().selectIndex(indices));
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K, V,I>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K, V,I>(this.type, getTarget().selectMatching(eval));
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K, V,I>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K, V,I> ifNotNull() {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K, V,I>(this.type, getTarget().selectNotNull());
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K, V,I>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K, V,I>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K, V,I> ifNull() {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K, V,I>(this.type, getTarget().selectNull());
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K, V,I>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K, V,I>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level3MapOfArrayEntriesValueElementsOperator<K, X,I> convert(final IConverter<X, ? super V> converter) {
        return new Level3MapOfArrayEntriesValueElementsOperatorImpl<K, X,I>(converter.getResultType(this.type), getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level3MapOfArrayEntriesValueElementsOperator<K, X,I> eval(final IEvaluator<X, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsOperatorImpl<K, X,I>(eval.getResultType(this.type), getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level3MapOfArrayEntriesValueElementsOperator<K, X,I> exec(final IFunction<X, ? super V> function) {
        return new Level3MapOfArrayEntriesValueElementsOperatorImpl<K, X,I>(function.getResultType(this.type), getTarget().execute(function, Normalization.NONE));
    }


    public Level3MapOfArrayEntriesValueElementsOperator<K, V,I> replaceWith(final V replacement) {
        return new Level3MapOfArrayEntriesValueElementsOperatorImpl<K, V,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level3MapOfArrayEntriesValueElementsOperator<K, V,I> replaceIfNullWith(final V replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Map<K, V[]>, I> createOperation() {
        return endFor().createOperation();
    }

}

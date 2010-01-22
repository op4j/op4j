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
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesKeySelectedOperator;
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
public class Level2MapOfMapEntriesKeyOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl
        implements Level2MapOfMapEntriesKeyOperator<K1,K2,V,I> {

    
    public Level2MapOfMapEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfMapEntriesOperator<K1, K2, V,I> endOn() {
        return new Level1MapOfMapEntriesOperatorImpl<K1, K2, V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> Level2MapOfMapEntriesKeyOperator<X, K2, V,I> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfKey(type, get());
        return new Level2MapOfMapEntriesKeyOperatorImpl<X, K2, V,I>(getTarget());
    }

    public Level2MapOfMapEntriesKeyOperator<?, K2, V,I> asUnknown() {
        return asType(Types.OBJECT);
    }





    public Map<K1, Map<K2, V>> get() {
        return endOn().endFor().get();
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V,I> ifIndex(final int... indices) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V,I>(getTarget().selectIndex(indices));
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V,I> ifIndexNot(final int... indices) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V,I> ifTrue(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V,I> ifFalse(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V,I> ifNotNull() {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotNull());
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V,I> ifNull() {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNull());
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2MapOfMapEntriesKeyOperator<X, K2, V,I> convert(final IConverter<X, ? super K1> converter) {
        return new Level2MapOfMapEntriesKeyOperatorImpl<X, K2, V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2MapOfMapEntriesKeyOperator<X, K2, V,I> eval(final IEvaluator<X, ? super K1> eval) {
        return new Level2MapOfMapEntriesKeyOperatorImpl<X, K2, V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2MapOfMapEntriesKeyOperator<X, K2, V,I> exec(final IFunction<X, ? super K1> function) {
        return new Level2MapOfMapEntriesKeyOperatorImpl<X, K2, V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapOfMapEntriesKeyOperator<K1, K2, V,I> replaceWith(final K1 replacement) {
        return new Level2MapOfMapEntriesKeyOperatorImpl<K1, K2, V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfMapEntriesKeyOperator<K1, K2, V,I> replaceIfNullWith(final K1 replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Map<K1, Map<K2, V>>, I> createOperation() {
        return endOn().createOperation();
    }


}

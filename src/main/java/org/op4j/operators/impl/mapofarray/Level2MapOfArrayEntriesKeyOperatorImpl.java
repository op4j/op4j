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
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesKeySelectedOperator;
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
public class Level2MapOfArrayEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level2MapOfArrayEntriesKeyOperator<K,V> {

    
    public Level2MapOfArrayEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfArrayEntriesOperator<K, V> endOn() {
        return new Level1MapOfArrayEntriesOperatorImpl<K, V>(getTarget().endOn());
    }


    public <X> Level2MapOfArrayEntriesKeyOperator<X, V> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalisationUtils.checkIsMapOfKey(type, get());
        return new Level2MapOfArrayEntriesKeyOperatorImpl<X, V>(getTarget());
    }

    public Level2MapOfArrayEntriesKeyOperator<?, V> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K, V[]> get() {
        return endOn().endFor().get();
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K, V> ifNotNull() {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K, V> ifNull() {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2MapOfArrayEntriesKeyOperator<X, V> convert(final IConverter<X, ? super K> converter) {
        return new Level2MapOfArrayEntriesKeyOperatorImpl<X, V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level2MapOfArrayEntriesKeyOperator<X, V> eval(final IEvaluator<X, ? super K> eval) {
        return new Level2MapOfArrayEntriesKeyOperatorImpl<X, V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level2MapOfArrayEntriesKeyOperator<X, V> exec(final IFunction<X, ? super K> function) {
        return new Level2MapOfArrayEntriesKeyOperatorImpl<X, V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfArrayEntriesKeyOperator<K, V> replaceWith(final K replacement) {
        return new Level2MapOfArrayEntriesKeyOperatorImpl<K, V>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfArrayEntriesKeyOperator<K, V> replaceIfNullWith(final K replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}

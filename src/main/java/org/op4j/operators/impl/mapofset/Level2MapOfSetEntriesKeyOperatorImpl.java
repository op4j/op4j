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
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesKeySelectedOperator;
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
public class Level2MapOfSetEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level2MapOfSetEntriesKeyOperator<K,V> {

    
    public Level2MapOfSetEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfSetEntriesOperator<K, V> endOn() {
        return new Level1MapOfSetEntriesOperatorImpl<K, V>(getTarget().endOn());
    }


    public <X> Level2MapOfSetEntriesKeyOperator<X, V> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalisationUtils.checkIsMapOfKey(type, get());
        return new Level2MapOfSetEntriesKeyOperatorImpl<X, V>(getTarget());
    }

    public Level2MapOfSetEntriesKeyOperator<?, V> asUnknown() {
        return asType(Types.OBJECT);
    }



    public Map<K, Set<V>> get() {
        return endOn().endFor().get();
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K, V> ifNotNull() {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K, V> ifNull() {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2MapOfSetEntriesKeyOperator<X, V> convert(final IConverter<X, ? super K> converter) {
        return new Level2MapOfSetEntriesKeyOperatorImpl<X, V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level2MapOfSetEntriesKeyOperator<X, V> eval(final IEvaluator<X, ? super K> eval) {
        return new Level2MapOfSetEntriesKeyOperatorImpl<X, V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level2MapOfSetEntriesKeyOperator<X, V> exec(final IFunction<X, ? super K> function) {
        return new Level2MapOfSetEntriesKeyOperatorImpl<X, V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfSetEntriesKeyOperator<K, V> replaceWith(final K replacement) {
        return new Level2MapOfSetEntriesKeyOperatorImpl<K, V>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfSetEntriesKeyOperator<K, V> replaceIfNullWith(final K replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}

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
package org.op4j.operators.impl.map;

import java.util.Map;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level1MapEntriesOperator;
import org.op4j.operators.intf.map.Level2MapEntriesKeyOperator;
import org.op4j.operators.intf.map.Level2MapEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.CastType;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level2MapEntriesKeyOperator<K,V> {

    
    public Level2MapEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapEntriesOperator<K, V> endOn() {
        return new Level1MapEntriesOperatorImpl<K, V>(getTarget().endOn());
    }


    public <X> Level2MapEntriesKeyOperator<X, V> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        return new Level2MapEntriesKeyOperatorImpl<X, V>(getTarget().cast(CastType.OBJECT, type));
    }

    public Level2MapEntriesKeyOperator<?, V> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K, V> get() {
        return endOn().endFor().get();
    }


    public Level2MapEntriesKeySelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level2MapEntriesKeySelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapEntriesKeySelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level2MapEntriesKeySelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapEntriesKeySelectedOperator<K, V> ifNotNull() {
        return new Level2MapEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level2MapEntriesKeySelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapEntriesKeySelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapEntriesKeySelectedOperator<K, V> ifNull() {
        return new Level2MapEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level2MapEntriesKeySelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapEntriesKeySelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2MapEntriesKeyOperator<X, V> convert(final IConverter<X, ? super K> converter) {
        return new Level2MapEntriesKeyOperatorImpl<X, V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level2MapEntriesKeyOperator<X, V> eval(final IEvaluator<X, ? super K> eval) {
        return new Level2MapEntriesKeyOperatorImpl<X, V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level2MapEntriesKeyOperator<X, V> exec(final IFunction<X, ? super K> function) {
        return new Level2MapEntriesKeyOperatorImpl<X, V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapEntriesKeyOperator<K, V> replaceWith(final K replacement) {
        return new Level2MapEntriesKeyOperatorImpl<K, V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapEntriesKeyOperator<K, V> replaceIfNullWith(final K replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    


}

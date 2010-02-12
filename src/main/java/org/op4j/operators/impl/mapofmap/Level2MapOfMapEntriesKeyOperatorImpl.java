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
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesKeySelectedOperator;
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
public class Level2MapOfMapEntriesKeyOperatorImpl<K1,K2,V> extends AbstractOperatorImpl
        implements Level2MapOfMapEntriesKeyOperator<K1,K2,V> {

    
    public Level2MapOfMapEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfMapEntriesOperator<K1, K2, V> endOn() {
        return new Level1MapOfMapEntriesOperatorImpl<K1, K2, V>(getTarget().endOn());
    }


    public <X> Level2MapOfMapEntriesKeyOperator<X, K2, V> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        return new Level2MapOfMapEntriesKeyOperatorImpl<X, K2, V>(getTarget().cast(CastType.OBJECT, type));
    }

    public Level2MapOfMapEntriesKeyOperator<?, K2, V> asUnknown() {
        return asType(Types.OBJECT);
    }





    public Map<K1, Map<K2, V>> get() {
        return endOn().endFor().get();
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V> ifIndex(final int... indexes) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectIndex(indexes));
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V> ifIndexNot(final int... indexes) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V> ifTrue(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V> ifFalse(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V> ifNotNull() {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNull());
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V> ifNull() {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectNull());
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V> ifNullOrTrue(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfMapEntriesKeySelectedOperator<K1, K2, V> ifNullOrFalse(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesKeySelectedOperatorImpl<K1, K2, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2MapOfMapEntriesKeyOperator<X, K2, V> convert(final IConverter<X, ? super K1> converter) {
        return new Level2MapOfMapEntriesKeyOperatorImpl<X, K2, V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level2MapOfMapEntriesKeyOperator<X, K2, V> eval(final IEvaluator<X, ? super K1> eval) {
        return new Level2MapOfMapEntriesKeyOperatorImpl<X, K2, V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level2MapOfMapEntriesKeyOperator<X, K2, V> exec(final IFunction<X, ? super K1> function) {
        return new Level2MapOfMapEntriesKeyOperatorImpl<X, K2, V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfMapEntriesKeyOperator<K1, K2, V> replaceWith(final K1 replacement) {
        return new Level2MapOfMapEntriesKeyOperatorImpl<K1, K2, V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapOfMapEntriesKeyOperator<K1, K2, V> replaceIfNullWith(final K1 replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    


}

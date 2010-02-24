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
package org.op4j.operators.impl.fn.map;

import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesKeyOperator;
import org.op4j.operators.qualities.UniqFnOperator;
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
public final class Level2MapEntriesKeyOperatorImpl<I,K,V> extends AbstractOperatorImpl
        implements UniqFnOperator<I,Map<K,V>>, Level2MapEntriesKeyOperator<I,K,V> {

    
    public Level2MapEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapEntriesOperatorImpl<I,K, V> endOn() {
        return new Level1MapEntriesOperatorImpl<I,K, V>(getTarget().endOn());
    }


    public <X> Level2MapEntriesKeyOperatorImpl<I,X, V> asType(final Type<X> type) {
        return new Level2MapEntriesKeyOperatorImpl<I,X, V>(getTarget().cast(CastType.OBJECT, type));
    }

    public Level2MapEntriesKeyOperatorImpl<I,?, V> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K, V> get() {
        return endOn().endFor().get();
    }


    public Level2MapEntriesKeySelectedOperatorImpl<I,K, V> ifIndex(final int... indexes) {
        return new Level2MapEntriesKeySelectedOperatorImpl<I,K, V>(getTarget().selectIndex(indexes));
    }


    public Level2MapEntriesKeySelectedOperatorImpl<I,K, V> ifIndexNot(final int... indexes) {
        return new Level2MapEntriesKeySelectedOperatorImpl<I,K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapEntriesKeySelectedOperatorImpl<I,K, V> ifTrue(final IFunction<? super K,Boolean> eval) {
        return new Level2MapEntriesKeySelectedOperatorImpl<I,K, V>(getTarget().selectMatching(eval));
    }


    public Level2MapEntriesKeySelectedOperatorImpl<I,K, V> ifFalse(final IFunction<? super K,Boolean> eval) {
        return new Level2MapEntriesKeySelectedOperatorImpl<I,K, V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapEntriesKeySelectedOperatorImpl<I,K, V> ifNotNull() {
        return new Level2MapEntriesKeySelectedOperatorImpl<I,K, V>(getTarget().selectNotNull());
    }


    public Level2MapEntriesKeySelectedOperatorImpl<I,K, V> ifNotNullAndTrue(final IFunction<? super K,Boolean> eval) {
        return new Level2MapEntriesKeySelectedOperatorImpl<I,K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapEntriesKeySelectedOperatorImpl<I,K, V> ifNotNullAndFalse(final IFunction<? super K,Boolean> eval) {
        return new Level2MapEntriesKeySelectedOperatorImpl<I,K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapEntriesKeySelectedOperatorImpl<I,K, V> ifNull() {
        return new Level2MapEntriesKeySelectedOperatorImpl<I,K, V>(getTarget().selectNull());
    }


    public Level2MapEntriesKeySelectedOperatorImpl<I,K, V> ifNullOrTrue(final IFunction<? super K,Boolean> eval) {
        return new Level2MapEntriesKeySelectedOperatorImpl<I,K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapEntriesKeySelectedOperatorImpl<I,K, V> ifNullOrFalse(final IFunction<? super K,Boolean> eval) {
        return new Level2MapEntriesKeySelectedOperatorImpl<I,K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2MapEntriesKeyOperatorImpl<I,X, V> execIfNotNull(final IFunction<? super K,X> function) {
        return new Level2MapEntriesKeyOperatorImpl<I,X, V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level2MapEntriesKeyOperatorImpl<I,X, V> exec(final IFunction<? super K,X> function) {
        return new Level2MapEntriesKeyOperatorImpl<I,X, V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapEntriesKeyOperatorImpl<I,K, V> replaceWith(final K replacement) {
        return new Level2MapEntriesKeyOperatorImpl<I,K, V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapEntriesKeyOperatorImpl<I,K, V> replaceIfNullWith(final K replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    


}

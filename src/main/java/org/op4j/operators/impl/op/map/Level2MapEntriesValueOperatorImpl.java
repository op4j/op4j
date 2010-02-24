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
package org.op4j.operators.impl.op.map;

import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.qualities.UniqOpOperator;
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
public final class Level2MapEntriesValueOperatorImpl<I,K,V> extends AbstractOperatorImpl
        implements UniqOpOperator<I,Map<K,V>>, Level2MapEntriesValueOperator<I,K,V> {

    
    public Level2MapEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapEntriesOperatorImpl<I,K, V> endOn() {
        return new Level1MapEntriesOperatorImpl<I,K, V>(getTarget().endOn());
    }


    public <X> Level2MapEntriesValueOperatorImpl<I,K, X> asType(final Type<X> type) {
        return new Level2MapEntriesValueOperatorImpl<I,K, X>(getTarget().cast(CastType.OBJECT, type));
    }

    public Level2MapEntriesValueOperatorImpl<I,K, ?> asUnknown() {
        return asType(Types.OBJECT);
    }
    
    
    
    
    

    public Map<K, V> get() {
        return endOn().endFor().get();
    }


    public Level2MapEntriesValueSelectedOperatorImpl<I,K, V> ifIndex(final int... indexes) {
        return new Level2MapEntriesValueSelectedOperatorImpl<I,K, V>(getTarget().selectIndex(indexes));
    }


    public Level2MapEntriesValueSelectedOperatorImpl<I,K, V> ifIndexNot(final int... indexes) {
        return new Level2MapEntriesValueSelectedOperatorImpl<I,K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapEntriesValueSelectedOperatorImpl<I,K, V> ifTrue(final IFunction<? super V,Boolean> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<I,K, V>(getTarget().selectMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperatorImpl<I,K, V> ifFalse(final IFunction<? super V,Boolean> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<I,K, V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperatorImpl<I,K, V> ifNotNull() {
        return new Level2MapEntriesValueSelectedOperatorImpl<I,K, V>(getTarget().selectNotNull());
    }


    public Level2MapEntriesValueSelectedOperatorImpl<I,K, V> ifNotNullAndTrue(final IFunction<? super V,Boolean> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<I,K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperatorImpl<I,K, V> ifNotNullAndFalse(final IFunction<? super V,Boolean> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<I,K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperatorImpl<I,K, V> ifNull() {
        return new Level2MapEntriesValueSelectedOperatorImpl<I,K, V>(getTarget().selectNull());
    }


    public Level2MapEntriesValueSelectedOperatorImpl<I,K, V> ifNullOrTrue(final IFunction<? super V,Boolean> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<I,K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperatorImpl<I,K, V> ifNullOrFalse(final IFunction<? super V,Boolean> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<I,K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2MapEntriesValueOperatorImpl<I,K, X> execIfNotNull(final IFunction<? super V,X> function) {
        return new Level2MapEntriesValueOperatorImpl<I,K, X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperatorImpl<I,K, X> exec(final IFunction<? super V,X> function) {
        return new Level2MapEntriesValueOperatorImpl<I,K, X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperatorImpl<I,K, V> replaceWith(final V replacement) {
        return new Level2MapEntriesValueOperatorImpl<I,K, V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperatorImpl<I,K, V> replaceIfNullWith(final V replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}

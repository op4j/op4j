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
package org.op4j.operators.f.impl.map;

import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.operators.f.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.map.Level1MapEntriesOperator;
import org.op4j.operators.op.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.op.intf.map.Level2MapEntriesValueSelectedOperator;
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
public final class Level2MapEntriesValueOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level2MapEntriesValueOperator<K,V,I> {

    
    public Level2MapEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapEntriesOperator<K, V,I> endOn() {
        return new Level1MapEntriesOperatorImpl<K, V,I>(getTarget().endOn());
    }


    public <X> Level2MapEntriesValueOperator<K, X,I> asType(final Type<X> type) {
        return new Level2MapEntriesValueOperatorImpl<K, X,I>(getTarget().cast(CastType.OBJECT, type));
    }

    public Level2MapEntriesValueOperator<K, ?,I> asUnknown() {
        return asType(Types.OBJECT);
    }
    
    
    
    
    

    public Map<K, V> get() {
        return endOn().endFor().get();
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifIndex(final int... indexes) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indexes));
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifIndexNot(final int... indexes) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifNotNull() {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNull());
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifNotNullAndTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifNotNullAndFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifNull() {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNull());
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifNullOrTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifNullOrFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2MapEntriesValueOperator<K, X,I> execIfNotNull(final IFunction<X, ? super V> function) {
        return new Level2MapEntriesValueOperatorImpl<K, X,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X,I> exec(final IFunction<X, ? super V> function) {
        return new Level2MapEntriesValueOperatorImpl<K, X,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<K, V,I> replaceWith(final V replacement) {
        return new Level2MapEntriesValueOperatorImpl<K, V,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<K, V,I> replaceIfNullWith(final V replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}

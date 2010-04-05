/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.intf.map.ILevel2MapEntriesValueOperator;
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
public final class Level2MapEntriesValueOperator<I,K,V> extends AbstractOperator
        implements UniqFnOperator<I,Map<K,V>>, ILevel2MapEntriesValueOperator<I,K,V> {

    
    public Level2MapEntriesValueOperator(final Target target) {
        super(target);
    }


    public Level1MapEntriesOperator<I,K, V> endOn() {
        return new Level1MapEntriesOperator<I,K, V>(getTarget().endOn());
    }


    public <X> Level2MapEntriesValueOperator<I,K, X> castTo(final Type<X> type) {
        return new Level2MapEntriesValueOperator<I,K, X>(getTarget().cast(CastType.OBJECT, type));
    }

    
    
    
    
    
    

    public Function<I,Map<K, V>> get() {
        return endOn().endFor().get();
    }


    public Level2MapEntriesValueSelectedOperator<I,K, V> ifTrue(final IFunction<? super V,Boolean> eval) {
        return new Level2MapEntriesValueSelectedOperator<I,K, V>(getTarget().selectMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<I,K, V> ifFalse(final IFunction<? super V,Boolean> eval) {
        return new Level2MapEntriesValueSelectedOperator<I,K, V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<I,K, V> ifNotNull() {
        return new Level2MapEntriesValueSelectedOperator<I,K, V>(getTarget().selectNotNull());
    }


    


    


    public Level2MapEntriesValueSelectedOperator<I,K, V> ifNull() {
        return new Level2MapEntriesValueSelectedOperator<I,K, V>(getTarget().selectNull());
    }


    


    




    public <X> Level2MapEntriesValueOperator<I,K, X> exec(final IFunction<? super V,X> function) {
        return new Level2MapEntriesValueOperator<I,K, X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<I,K, V> replaceWith(final V replacement) {
        return new Level2MapEntriesValueOperator<I,K, V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<I,K, V> replaceIfNullWith(final V replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }

    
    
    
    
    
    
    public Level2MapEntriesValueOperator<I, K, V> execIfFalse(final IFunction<? super V, Boolean> eval, final IFunction<? super V, ? extends V> function) {
        return new Level2MapEntriesValueOperator<I, K, V>(getTarget().executeIfFalse(eval, function, null, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<I, K, X> execIfFalse(final IFunction<? super V, Boolean> eval, final IFunction<? super V, X> function, final IFunction<? super V, X> elseFunction) {
        return new Level2MapEntriesValueOperator<I, K, X>(getTarget().executeIfFalse(eval, function, elseFunction, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<I, K, V> execIfNotNull(final IFunction<? super V, ? extends V> function) {
        return new Level2MapEntriesValueOperator<I, K, V>(getTarget().executeIfNotNull(function, null, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<I, K, X> execIfNotNull(final IFunction<? super V, X> function, final IFunction<? super V, X> elseFunction) {
        return new Level2MapEntriesValueOperator<I, K, X>(getTarget().executeIfNotNull(function, elseFunction, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<I, K, V> execIfNull(final IFunction<? super V, ? extends V> function) {
        return new Level2MapEntriesValueOperator<I, K, V>(getTarget().executeIfNull(function, null, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<I, K, X> execIfNull(final IFunction<? super V, X> function, final IFunction<? super V, X> elseFunction) {
        return new Level2MapEntriesValueOperator<I, K, X>(getTarget().executeIfNull(function, elseFunction, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<I, K, V> execIfTrue(final IFunction<? super V, Boolean> eval, final IFunction<? super V, ? extends V> function) {
        return new Level2MapEntriesValueOperator<I, K, V>(getTarget().executeIfTrue(eval, function, null, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<I, K, X> execIfTrue(final IFunction<? super V, Boolean> eval, final IFunction<? super V, X> function, final IFunction<? super V, X> elseFunction) {
        return new Level2MapEntriesValueOperator<I, K, X>(getTarget().executeIfTrue(eval, function, elseFunction, Normalisation.NONE));
    }



    

}

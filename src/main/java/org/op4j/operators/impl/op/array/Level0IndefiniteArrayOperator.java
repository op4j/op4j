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
package org.op4j.operators.impl.op.array;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.FnArray;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.impl.op.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.op.list.Level0ListOperator;
import org.op4j.operators.impl.op.map.Level0MapOperator;
import org.op4j.operators.impl.op.set.Level0SetOperator;
import org.op4j.operators.intf.array.ILevel0IndefiniteArrayOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public final class Level0IndefiniteArrayOperator<I,T> 
        extends AbstractOperator 
        implements UniqOpOperator<I,T[]>, ILevel0IndefiniteArrayOperator<I,T> {


    
    public Level0IndefiniteArrayOperator(final Target target) {
        super(target);
    }


    public Level0ListOperator<I,T> toList() {
        return new Level0ListOperator<I,T>(getTarget().execute(FnArray.ofObject().toList()));
    }


    public Level0MapOperator<I,T, T> toMapByAlternateElements() {
        return new Level0MapOperator<I,T, T>(getTarget().execute(FnArray.ofObject().toMapByAlternateElements()));
    }

    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K, T> toMapByKeyEval(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K, T>(getTarget().execute(FnArray.ofObject().toMapByKeyEval((IFunction)keyEval)));
    }

    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K, V> toMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnArray.ofObject().toMap((IFunction)mapBuilder)));
    }

    public Level0SetOperator<I,T> toSet() {
        return new Level0SetOperator<I,T>(getTarget().execute(FnArray.ofObject().toSet()));
    }

    
    
    public Level0GenericUniqOperator<I,T[]> generic() {
        return new Level0GenericUniqOperator<I,T[]>(getTarget());
    }



    public <X> Level0GenericUniqOperator<I,X> exec(final IFunction<? super T[],X> function) {
        return new Level0GenericUniqOperator<I,X>(getTarget().execute(function, Normalisation.NONE));
    }
    
    

    public <X> Level0ArrayOperator<I,X> asArrayOf(final Type<X> newType) {
        return generic().asArrayOf(newType);
    }


    

    
    
    @SuppressWarnings("unchecked")
    public T[] get() {
        return (T[]) getTarget().get();
    }


}

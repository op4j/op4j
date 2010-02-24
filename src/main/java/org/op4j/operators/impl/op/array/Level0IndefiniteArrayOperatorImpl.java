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
package org.op4j.operators.impl.op.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.impl.op.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.op.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.op.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.op.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.array.Level0IndefiniteArrayOperator;
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
public final class Level0IndefiniteArrayOperatorImpl<T,I> 
        extends AbstractOperatorImpl 
        implements UniqOpOperator<T[],I>, Level0IndefiniteArrayOperator<T,I> {


    
    public Level0IndefiniteArrayOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ListOperatorImpl<T,I> toList() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public Level0MapOperatorImpl<T, T,I> toMap() {
        return new Level0MapOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> Level0MapOperatorImpl<K, T,I> toMap(final IFunction<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }

    public <K, V> Level0MapOperatorImpl<K, V,I> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }

    public Level0SetOperatorImpl<T,I> toSet() {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new ToSet.FromArray<T>()));
    }

    
    
    public Level0GenericUniqOperatorImpl<T[],I> generic() {
        return new Level0GenericUniqOperatorImpl<T[],I>(getTarget());
    }



    public <X> Level0GenericUniqOperatorImpl<X,I> exec(final IFunction<X, ? super T[]> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalisation.NONE));
    }
    
    

    public <X> Level0ArrayOperatorImpl<X,I> asArrayOf(final Type<X> newType) {
        return generic().asArrayOf(newType);
    }


    

    
    
    @SuppressWarnings("unchecked")
    public T[] get() {
        return (T[]) getTarget().get();
    }


}

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
package org.op4j.operators.intf.array;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.ExecutableIndefiniteArrayOperator;
import org.op4j.operators.qualities.GenerizableOperator;
import org.op4j.operators.qualities.ReversibleOperator;
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0IndefiniteArrayOperator<I,T>
        extends UniqOperator<T[]>,
		        CastableToArrayOperator,
                GenerizableOperator<I,T[]>,
		        ConvertibleToListOperator,
		        ConvertibleToSetOperator,
		        ConvertibleToMapOperator<T>,
		        ExecutableIndefiniteArrayOperator<I,T>,
		        ReversibleOperator<T> {


    public ILevel0ListOperator<I,T> toList();
    public ILevel0SetOperator<I,T> toSet();
    
    public <K,V> ILevel0MapOperator<I,K,V> toMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder);
    public <K,V> ILevel0MapOperator<I,K,V> toMap(final IFunction<? super T,K> keyFunction, final IFunction<? super T,V> valueFunction);
    public <K,V> ILevel0MapOperator<I,K,V[]> toGroupMapOf(final Type<V> valueType, final IFunction<? super T,Map.Entry<K,V>> mapBuilder);
    public <K,V> ILevel0MapOperator<I,K,V[]> toGroupMapOf(final Type<V> valueType, final IFunction<? super T,K> keyFunction, final IFunction<? super T,V> valueFunction);

    
    public ILevel0MapOperator<I,T,T> couple();

    public <K> ILevel0MapOperator<I,K,T> zipKeys(final K... keys);
    public <V> ILevel0MapOperator<I,T,V> zipValues(final V... values);
    public <K> ILevel0MapOperator<I,K,T> zipKeysBy(final IFunction<? super T,K> keyEval);
    public <V> ILevel0MapOperator<I,T,V> zipValuesBy(final IFunction<? super T,V> valueEval);
    
    
    public ILevel0GenericUniqOperator<I,T[]> generic();

    public <X> ILevel0ArrayOperator<I,X> of(final Type<X> type);
    public <X> ILevel0GenericUniqOperator<I,X> exec(final IFunction<? super T[],X> function);


    public ILevel0IndefiniteArrayOperator<I,T> reverse();
    
}

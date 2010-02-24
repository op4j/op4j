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
package org.op4j.operators.f.intf.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.op.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.op.intf.list.Level0ListOperator;
import org.op4j.operators.op.intf.map.Level0MapOperator;
import org.op4j.operators.op.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.ExecutableIndefiniteArrayOperator;
import org.op4j.operators.qualities.GenerizableOperator;
import org.op4j.operators.qualities.UniqOpOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level0IndefiniteArrayOperator<T,I>
        extends UniqOpOperator<T[]>,
		        CastableToArrayOperator,
                GenerizableOperator<T[],I>,
		        ConvertibleToListOperator,
		        ConvertibleToSetOperator,
		        ConvertibleToMapOperator<T>,
		        ExecutableIndefiniteArrayOperator<T,I> {



    
    public Level0ListOperator<T,I> toList();
    
    public Level0SetOperator<T,I> toSet();
    
    public Level0MapOperator<T,T,I> toMap();
    public <K> Level0MapOperator<K,T,I> toMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V,I> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public Level0GenericUniqOperator<T[],I> generic();

    public <X> Level0ArrayOperator<X,I> asArrayOf(final Type<X> type);
    public <X> Level0GenericUniqOperator<X,I> exec(final IFunction<X, ? super T[]> function);

    
}

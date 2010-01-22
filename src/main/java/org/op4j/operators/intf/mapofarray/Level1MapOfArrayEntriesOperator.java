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
package org.op4j.operators.intf.mapofarray;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.qualities.ExecutableMapOfArrayEntryOperator;
import org.op4j.operators.qualities.NavigableMapEntryOperator;
import org.op4j.operators.qualities.NavigatingMapOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableMapEntryOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1MapOfArrayEntriesOperator<K,V,I>
		extends UniqOperator<Map<K,V[]>,I>,
		        NavigableMapEntryOperator<I>,
		        NavigatingMapOperator<K,V[],I>,
                ExecutableMapOfArrayEntryOperator<K,V,I>,
                ReplaceableOperator<Map.Entry<K,V[]>,I>,
                SelectableMapEntryOperator<K, V[],I> {


    public Level1MapOfArrayEntriesSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level1MapOfArrayEntriesSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Map.Entry<K, V[]>> eval);
    public Level1MapOfArrayEntriesSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Map.Entry<K, V[]>> eval);
    public Level1MapOfArrayEntriesSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level1MapOfArrayEntriesSelectedOperator<K,V,I> ifKeyEquals(final K... keys);
    public Level1MapOfArrayEntriesSelectedOperator<K,V,I> ifKeyNotEquals(final K... keys);
    
    
    public Level2MapOfArrayEntriesKeyOperator<K,V,I> onKey();
    public Level2MapOfArrayEntriesValueOperator<K,V,I> onValue();
    
    public Level0MapOfArrayOperator<K,V,I> endFor();
    
    public <X,Y> Level1MapOfArrayEntriesOperator<X,Y,I> exec(final IFunction<? extends Map.Entry<X,Y[]>, ? super Map.Entry<K,V[]>> function);
    
    public <X,Y> Level1MapOfArrayEntriesOperator<X,Y,I> eval(final IEvaluator<? extends Map.Entry<X,Y[]>,? super Map.Entry<K,V[]>> eval);
    
    public Level1MapOfArrayEntriesOperator<K,V,I> replaceWith(final Map.Entry<K,V[]> replacement);


    public <X,Y> Level1MapOfArrayEntriesOperator<X,Y,I> convert(final IConverter<? extends Map.Entry<X,Y[]>,? super Map.Entry<K,V[]>> converter);

    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map.Entry<K,V[]>> function);
    
    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map.Entry<K,V[]>> eval);
    
    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super Map.Entry<K,V[]>> converter);    

    
}

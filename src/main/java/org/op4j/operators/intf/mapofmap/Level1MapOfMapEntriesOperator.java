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
package org.op4j.operators.intf.mapofmap;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.qualities.ExecutableMapOfMapEntryOperator;
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
public interface Level1MapOfMapEntriesOperator<K1,K2,V,I>
		extends UniqOperator<Map<K1,Map<K2,V>>,I>,
		        NavigableMapEntryOperator<I>,
                ExecutableMapOfMapEntryOperator<K1,K2,V,I>,
                SelectableMapEntryOperator<K1, Map<K2,V>,I>,
                ReplaceableOperator<Map.Entry<K1,Map<K2,V>>,I>,
		        NavigatingMapOperator<K1,Map<K2,V>,I> {


    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V,I> ifIndex(final int... indices);
    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V,I> ifTrue(final IEvaluator<Boolean, ? super Map.Entry<K1, Map<K2, V>>> eval);
    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V,I> ifFalse(final IEvaluator<Boolean, ? super Map.Entry<K1, Map<K2, V>>> eval);
    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V,I> ifIndexNot(final int... indices);
    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V,I> ifKeyEquals(final K1... keys);
    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V,I> ifKeyNotEquals(final K1... keys);
    
    
    public Level2MapOfMapEntriesKeyOperator<K1,K2,V,I> onKey();
    public Level2MapOfMapEntriesValueOperator<K1,K2,V,I> onValue();
    
    public Level0MapOfMapOperator<K1,K2,V,I> endFor();


    public <X1,X2,Y> Level1MapOfMapEntriesOperator<X1,X2,Y,I> exec(final IFunction<? extends Map.Entry<X1,? extends Map<X2,Y>>, ? super Map.Entry<K1,Map<K2,V>>> function);
    
    public <X1,X2,Y> Level1MapOfMapEntriesOperator<X1,X2,Y,I> eval(final IEvaluator<? extends Map.Entry<X1,? extends Map<X2,Y>>,? super Map.Entry<K1,Map<K2,V>>> eval);
    
    public Level1MapOfMapEntriesOperator<K1,K2,V,I> replaceWith(final Map.Entry<K1,Map<K2,V>> replacement);


    public <X1,X2,Y> Level1MapOfMapEntriesOperator<X1,X2,Y,I> convert(final IConverter<? extends Map.Entry<X1,? extends Map<X2,Y>>,? super Map.Entry<K1,Map<K2,V>>> converter);

    public <X> Level1ListElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map.Entry<K1,Map<K2,V>>> function);
    
    public <X> Level1ListElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map.Entry<K1,Map<K2,V>>> eval);
    
    public <X> Level1ListElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super Map.Entry<K1,Map<K2,V>>> converter);    

    
}

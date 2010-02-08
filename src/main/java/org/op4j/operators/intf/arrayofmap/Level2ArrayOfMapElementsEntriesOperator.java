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
package org.op4j.operators.intf.arrayofmap;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsElementsOperator;
import org.op4j.operators.qualities.ExecutableMapEntryOperator;
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
public interface Level2ArrayOfMapElementsEntriesOperator<K,V> 
		extends UniqOperator<Map<K,V>[]>,
		        NavigableMapEntryOperator,
                ExecutableMapEntryOperator<K,V>,
                SelectableMapEntryOperator<K, V>,
                ReplaceableOperator<Map.Entry<K,V>>,
                NavigatingMapOperator<K,V> {


    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> ifIndex(final int... indexes);
    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Map.Entry<K, V>> eval);
    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Map.Entry<K, V>> eval);
    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys);
    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys);
		    
    
    public Level3ArrayOfMapElementsEntriesKeyOperator<K,V> onKey();
    public Level3ArrayOfMapElementsEntriesValueOperator<K,V> onValue();
    
    public Level1ArrayOfMapElementsOperator<K,V> endFor();
    
    public <X,Y> Level2ArrayOfMapElementsEntriesOperator<X,Y> execAsMapEntry(final IFunction<? extends Map.Entry<X,Y>, ? super Map.Entry<K,V>> function);
    
    public <X,Y> Level2ArrayOfMapElementsEntriesOperator<X,Y> evalAsMapEntry(final IEvaluator<? extends Map.Entry<X,Y>,? super Map.Entry<K,V>> eval);
    
    public Level2ArrayOfMapElementsEntriesOperator<K,V> replaceWith(final Map.Entry<K,V> replacement);


    public <X,Y> Level2ArrayOfMapElementsEntriesOperator<X,Y> convertAsMapEntry(final IConverter<? extends Map.Entry<X,Y>,? super Map.Entry<K,V>> converter);

    public <X> Level2ArrayOfListElementsElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map.Entry<K,V>> function);
    
    public <X> Level2ArrayOfListElementsElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map.Entry<K,V>> eval);
    
    public <X> Level2ArrayOfListElementsElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super Map.Entry<K,V>> converter);    

    
}

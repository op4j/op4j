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
package org.op4j.operators.intf.listofmap;

import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsElementsOperator;
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
public interface Level2ListOfMapElementsEntriesOperator<K,V> 
		extends UniqOperator<List<Map<K,V>>>,
		        NavigableMapEntryOperator,
                NavigatingMapOperator<K,V>,
                ExecutableMapEntryOperator<K,V>,
                ReplaceableOperator<Map.Entry<K, V>>,
                SelectableMapEntryOperator<K, V> {


    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> ifIndex(final int... indexes);
    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Map.Entry<K, V>> eval);
    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Map.Entry<K, V>> eval);
    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys);
    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys);
    
    
    public Level3ListOfMapElementsEntriesKeyOperator<K,V> onKey();
    public Level3ListOfMapElementsEntriesValueOperator<K,V> onValue();
    
    public Level1ListOfMapElementsOperator<K,V> endFor();
    
    public <X,Y> Level2ListOfMapElementsEntriesOperator<X,Y> exec(final IFunction<? extends Map.Entry<X,Y>, ? super Map.Entry<K,V>> function);
    
    public <X,Y> Level2ListOfMapElementsEntriesOperator<X,Y> eval(final IEvaluator<? extends Map.Entry<X,Y>,? super Map.Entry<K,V>> eval);
    
    public Level2ListOfMapElementsEntriesOperator<K,V> replaceWith(final Map.Entry<K,V> replacement);


    public <X,Y> Level2ListOfMapElementsEntriesOperator<X,Y> convert(final IConverter<? extends Map.Entry<X,Y>,? super Map.Entry<K,V>> converter);

    public <X> Level2ListOfListElementsElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map.Entry<K,V>> function);
    
    public <X> Level2ListOfListElementsElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map.Entry<K,V>> eval);
    
    public <X> Level2ListOfListElementsElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super Map.Entry<K,V>> converter);    

    
}

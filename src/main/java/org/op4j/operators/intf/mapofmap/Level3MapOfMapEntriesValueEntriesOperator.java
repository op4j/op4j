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
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesValueElementsOperator;
import org.op4j.operators.qualities.ExecutableMapEntryOperator;
import org.op4j.operators.qualities.NavigableMapEntryOperator;
import org.op4j.operators.qualities.NavigatingMapOperator;
import org.op4j.operators.qualities.SelectableMapEntryOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level3MapOfMapEntriesValueEntriesOperator<K1,K2,V>
		extends UniqOperator<Map<K1,Map<K2,V>>>,
		        NavigableMapEntryOperator,
                ExecutableMapEntryOperator<K2,V>,
                SelectableMapEntryOperator<K2, V>,
		        NavigatingMapOperator<K2,V> {


    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1,K2,V> ifIndex(final int... indices);
    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1,K2,V> ifTrue(final IEvaluator<Boolean, ? super Map.Entry<K2, V>> eval);
    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1,K2,V> ifFalse(final IEvaluator<Boolean, ? super Map.Entry<K2, V>> eval);
    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1,K2,V> ifIndexNot(final int... indices);
    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1,K2,V> ifKeyEquals(final K2... keys);
    public Level3MapOfMapEntriesValueEntriesSelectedOperator<K1,K2,V> ifKeyNotEquals(final K2... keys);
    
    
    public Level4MapOfMapEntriesValueEntriesKeyOperator<K1,K2,V> onKey();
    public Level4MapOfMapEntriesValueEntriesValueOperator<K1,K2,V> onValue();
    
    public Level2MapOfMapEntriesValueOperator<K1,K2,V> endFor();
    
    public <X2,Y> Level3MapOfMapEntriesValueEntriesOperator<K1,X2,Y> exec(final IFunction<? extends Map.Entry<X2,Y>,? super Map.Entry<K2,V>> function);
    
    public <X2,Y> Level3MapOfMapEntriesValueEntriesOperator<K1,X2,Y> eval(final IEvaluator<? extends Map.Entry<X2,Y>,? super Map.Entry<K2,V>> eval);
    
    public <X2,Y> Level3MapOfMapEntriesValueEntriesOperator<K1,X2,Y> convert(final IConverter<? extends Map.Entry<X2,Y>,? super Map.Entry<K2,V>> converter);

    public <X> Level3MapOfListEntriesValueElementsOperator<K1,X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map.Entry<K2,V>> function);
    
    public <X> Level3MapOfListEntriesValueElementsOperator<K1,X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map.Entry<K2,V>> eval);
    
    public <X> Level3MapOfListEntriesValueElementsOperator<K1,X> convert(final Type<X> resultType, final IConverter<? extends X,? super Map.Entry<K2,V>> converter);    

    
}

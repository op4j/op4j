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

import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.qualities.CastableToMapOperator;
import org.op4j.operators.qualities.ConvertibleOperator;
import org.op4j.operators.qualities.EvaluableOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.ExtractableMapOperator;
import org.op4j.operators.qualities.ModifiableMapOperator;
import org.op4j.operators.qualities.NavigableMapOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2MapOfMapEntriesValueOperator<K1,K2,V>
        extends UniqOperator<Map<K1,Map<K2,V>>>,
                NavigableMapOperator<K2,V>,
		        NavigatingMapEntryOperator,
		        CastableToMapOperator,
		        SortableOperator<Map.Entry<K2,V>>,
                ExecutableOperator<Map<K2,V>>,
                ConvertibleOperator<Map<K2,V>>,
                EvaluableOperator<Map<K2,V>>,
                ModifiableMapOperator<K2,V>,
                SelectableOperator<Map<K2,V>>,
                ExtractableMapOperator<K2,V> {



    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> ifIndex(final int... indices);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> ifNull();
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> ifNullOrMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> ifIndexNot(final int... indices);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> ifNotNull();
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> ifNotNullMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval);

    
    public Level3MapOfMapEntriesValueEntriesOperator<K1,K2,V> forEachEntry();
    
    public Level1MapOfMapEntriesOperator<K1,K2,V> endOn();
    
    public Level2MapOfMapEntriesValueOperator<K1,K2,V> sort();
    public Level2MapOfMapEntriesValueOperator<K1,K2,V> sort(final Comparator<? super Map.Entry<K2,V>> comparator);
    
    public Level2MapOfMapEntriesValueOperator<K1,K2,V> put(final K2 newKey, final V newValue);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V> insert(final int position, final K2 newKey, final V newValue);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V> putAll(final Map<K2,V> map);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V> insertAll(final int position, final Map<K2,V> map);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V> removeKeys(final K2... keys);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K2,V>> eval);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V> removeNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K2,V>> eval);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V> removeKeysNot(final K2... keys);
    
    
    public Level2MapOfSetEntriesValueOperator<K1,K2> extractKeys();
    public Level2MapOfListEntriesValueOperator<K1,V> extractValues();
    

    
    
    
    public <X> Level2MapEntriesValueOperator<K1,X> convert(final IConverter<X,? super Map<K2,V>> converter);
    
    public <X> Level2MapEntriesValueOperator<K1,X> eval(final IEvaluator<X,? super Map<K2,V>> eval);

    public <X> Level2MapEntriesValueOperator<K1,X> exec(final IFunction<X, ? super Map<K2,V>> function);
    
    
    public <X,Y> Level2MapOfMapEntriesValueOperator<K1,X,Y> asMapOf(final Type<X> keyType, final Type<Y> valueType);
    public Level2MapOfMapEntriesValueOperator<K1,?,?> asMapOfUnknown();
    
    
}

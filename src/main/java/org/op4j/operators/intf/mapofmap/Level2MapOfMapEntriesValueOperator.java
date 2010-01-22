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
import org.op4j.operators.qualities.ExecutableMapOperator;
import org.op4j.operators.qualities.ExtractableMapOperator;
import org.op4j.operators.qualities.ModifiableMapOperator;
import org.op4j.operators.qualities.NavigableMapOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
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
public interface Level2MapOfMapEntriesValueOperator<K1,K2,V,I>
        extends UniqOperator<Map<K1,Map<K2,V>>,I>,
                NavigableMapOperator<K2,V,I>,
		        NavigatingMapEntryOperator<I>,
		        CastableToMapOperator<I>,
		        SortableOperator<Map.Entry<K2,V>,I>,
                ExecutableMapOperator<K2,V,I>,
                ModifiableMapOperator<K2,V,I>,
                SelectableOperator<Map<K2,V>,I>,
                ReplaceableOperator<Map<K2,V>,I>,
                ReplaceableIfNullOperator<Map<K2,V>,I>,
                ExtractableMapOperator<K2,V,I> {



    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> ifIndex(final int... indices);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> ifTrue(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> ifFalse(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> ifNull();
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K2,V>> eval);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> ifIndexNot(final int... indices);
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> ifNotNull();
    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K2,V>> eval);

    
    public Level3MapOfMapEntriesValueEntriesOperator<K1,K2,V,I> forEachEntry();
    
    public Level1MapOfMapEntriesOperator<K1,K2,V,I> endOn();
    
    public Level2MapOfMapEntriesValueOperator<K1,K2,V,I> sort();
    public Level2MapOfMapEntriesValueOperator<K1,K2,V,I> sort(final Comparator<? super Map.Entry<K2,V>> comparator);
    
    public Level2MapOfMapEntriesValueOperator<K1,K2,V,I> put(final K2 newKey, final V newValue);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V,I> insert(final int position, final K2 newKey, final V newValue);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V,I> putAll(final Map<K2,V> map);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V,I> insertAll(final int position, final Map<K2,V> map);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V,I> removeAllKeys(final K2... keys);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V,I> removeAllTrue(final IEvaluator<Boolean, ? super Map.Entry<K2,V>> eval);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V,I> removeAllFalse(final IEvaluator<Boolean, ? super Map.Entry<K2,V>> eval);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V,I> removeAllKeysNot(final K2... keys);
    
    
    public Level2MapOfSetEntriesValueOperator<K1,K2,I> extractKeys();
    public Level2MapOfListEntriesValueOperator<K1,V,I> extractValues();
    

    
    
    
    public Level2MapOfMapEntriesValueOperator<K1,K2,V,I> replaceWith(final Map<K2,V> replacement);
    public Level2MapOfMapEntriesValueOperator<K1,K2,V,I> replaceIfNullWith(final Map<K2,V> replacement);


    public <X2,Y> Level2MapOfMapEntriesValueOperator<K1,X2,Y,I> convert(final IConverter<? extends Map<X2,Y>,? super Map<K2,V>> converter);
    
    public <X2,Y> Level2MapOfMapEntriesValueOperator<K1,X2,Y,I> eval(final IEvaluator<? extends Map<X2,Y>,? super Map<K2,V>> eval);


    public <X2,Y> Level2MapOfMapEntriesValueOperator<K1,X2,Y,I> exec(final IFunction<? extends Map<X2,Y>, ? super Map<K2,V>> function);

    public <X> Level2MapEntriesValueOperator<K1,X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K2,V>> function);
    
    public <X> Level2MapEntriesValueOperator<K1,X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map<K2,V>> eval);
    
    public <X> Level2MapEntriesValueOperator<K1,X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super Map<K2,V>> converter);    

    
    
    public <X,Y> Level2MapOfMapEntriesValueOperator<K1,X,Y,I> asMapOf(final Type<X> keyType, final Type<Y> valueType);
    public Level2MapOfMapEntriesValueOperator<K1,?,?,I> asMapOfUnknown();
    
    
}

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

import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.qualities.CastableToMapOperator;
import org.op4j.operators.qualities.ExecutableMapOperator;
import org.op4j.operators.qualities.ExtractableMapOperator;
import org.op4j.operators.qualities.ModifiableMapOperator;
import org.op4j.operators.qualities.NavigableMapOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
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
public interface Level1ArrayOfMapElementsOperator<K,V>
        extends UniqOperator<Map<K,V>[]>,
                NavigableMapOperator<K,V>,
                NavigatingCollectionOperator<Map<K,V>>,
		        SortableOperator<Map.Entry<K,V>>,
		        CastableToMapOperator,
                ExecutableMapOperator<K,V>,
                SelectableOperator<Map<K,V>>,
                ReplaceableOperator<Map<K,V>>,
                ReplaceableIfNullOperator<Map<K,V>>,
                ModifiableMapOperator<K,V>,
                ExtractableMapOperator<K,V> {



    public Level1ArrayOfMapElementsSelectedOperator<K,V> ifIndex(final int... indexes);
    public Level1ArrayOfMapElementsSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ArrayOfMapElementsSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ArrayOfMapElementsSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ArrayOfMapElementsSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ArrayOfMapElementsSelectedOperator<K,V> ifNull();
    public Level1ArrayOfMapElementsSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ArrayOfMapElementsSelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level1ArrayOfMapElementsSelectedOperator<K,V> ifNotNull();
    public Level1ArrayOfMapElementsSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);


    
    public Level2ArrayOfMapElementsEntriesOperator<K,V> forEachEntry();
    
    public Level0ArrayOfMapOperator<K,V> endFor();
    
    public Level1ArrayOfMapElementsOperator<K,V> sort();
    public Level1ArrayOfMapElementsOperator<K,V> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public Level1ArrayOfMapElementsOperator<K,V> put(final K newKey, final V newValue);
    public Level1ArrayOfMapElementsOperator<K,V> insert(final int position, final K newKey, final V newValue);
    public Level1ArrayOfMapElementsOperator<K,V> putAll(final Map<K,V> map);
    public Level1ArrayOfMapElementsOperator<K,V> insertAll(final int position, final Map<K,V> map);
    public Level1ArrayOfMapElementsOperator<K,V> removeAllKeys(final K... keys);
    public Level1ArrayOfMapElementsOperator<K,V> removeAllTrue(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1ArrayOfMapElementsOperator<K,V> removeAllFalse(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1ArrayOfMapElementsOperator<K,V> removeAllKeysNot(final K... keys);
    
    
    public Level1ArrayOfSetElementsOperator<K> extractKeys();
    public Level1ArrayOfListElementsOperator<V> extractValues();
    
    
    
    
    
    public Level1ArrayOfMapElementsOperator<K,V> replaceWith(final Map<K,V> replacement);
    public Level1ArrayOfMapElementsOperator<K,V> replaceIfNullWith(final Map<K,V> replacement);


    public <X,Y> Level1ArrayOfMapElementsOperator<X,Y> convertAsMap(final IConverter<? extends Map<X,Y>,? super Map<K,V>> converter);
    
    public <X,Y> Level1ArrayOfMapElementsOperator<X,Y> evalAsMap(final IEvaluator<? extends Map<X,Y>,? super Map<K,V>> eval);

    public <X,Y> Level1ArrayOfMapElementsOperator<X,Y> execAsMap(final IFunction<? extends Map<X,Y>, ? super Map<K,V>> function);

    public <X> Level1ArrayElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K,V>> function);
    
    public <X> Level1ArrayElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map<K,V>> eval);
    
    public <X> Level1ArrayElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super Map<K,V>> converter);    
    
    
    public <X,Y> Level1ArrayOfMapElementsOperator<X,Y> asMapOf(final Type<X> keyType, final Type<Y> valueType);
    public Level1ArrayOfMapElementsOperator<?,?> asMapOfUnknown();
    
    
}

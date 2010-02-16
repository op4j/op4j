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
package org.op4j.operators.intf.map;

import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.CastableToMapOfArrayOperator;
import org.op4j.operators.qualities.CastableToMapOfListOperator;
import org.op4j.operators.qualities.CastableToMapOfSetOperator;
import org.op4j.operators.qualities.CastableToMapOperator;
import org.op4j.operators.qualities.ExecutableMapOperator;
import org.op4j.operators.qualities.ExtractableMapOperator;
import org.op4j.operators.qualities.GenerizableOperator;
import org.op4j.operators.qualities.ModifiableMapOperator;
import org.op4j.operators.qualities.NavigableMapOperator;
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
public interface Level0MapOperator<K,V>
        extends UniqOperator<Map<K,V>>,
                NavigableMapOperator<K,V>,
                CastableToMapOperator,
                CastableToMapOfArrayOperator,
                CastableToMapOfListOperator,
                CastableToMapOfSetOperator,
		        SortableOperator<Map.Entry<K,V>>,
                ExecutableMapOperator<K,V>,
                ModifiableMapOperator<K,V>,
                ExtractableMapOperator<K,V>,
                SelectableOperator<Map<K,V>>,
                ReplaceableOperator<Map<K,V>>,
                ReplaceableIfNullOperator<Map<K,V>>,
                GenerizableOperator<Map<K,V>> {



    public Level0MapSelectedOperator<K,V> ifIndex(final int... indexes);
    public Level0MapSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V> ifNull();
    public Level0MapSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level0MapSelectedOperator<K,V> ifNotNull();
    public Level0MapSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super Map<K,V>> eval);


    
    public Level1MapEntriesOperator<K,V> forEachEntry();
    
    public Level0MapOperator<K,V> sort();
    public Level0MapOperator<K,V> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public Level0MapOperator<K,V> put(final K newKey, final V newValue);
    public Level0MapOperator<K,V> insert(final int position, final K newKey, final V newValue);
    public Level0MapOperator<K,V> putAll(final Map<K,V> map);
    public Level0MapOperator<K,V> insertAll(final int position, final Map<K,V> map);
    public Level0MapOperator<K,V> removeAllKeys(final K... keys);
    public Level0MapOperator<K,V> removeAllTrue(final IFunction<Boolean, ? super Map.Entry<K,V>> eval);
    public Level0MapOperator<K,V> removeAllFalse(final IFunction<Boolean, ? super Map.Entry<K,V>> eval);
    public Level0MapOperator<K,V> removeAllKeysNot(final K... keys);
    
    
    public Level0SetOperator<K> extractKeys();
    public Level0ListOperator<V> extractValues();
    
    
    
    public Level0GenericUniqOperator<Map<K,V>> generic();

    
    
    
    public Level0MapOperator<K,V> replaceWith(final Map<K,V> replacement);
    public Level0MapOperator<K,V> replaceIfNullWith(final Map<K,V> replacement);


    public <X,Y> Level0MapOperator<X,Y> execIfNotNullAsMap(final IFunction<? extends Map<X,Y>,? super Map<K,V>> function);

    public <X,Y> Level0MapOperator<X,Y> execAsMap(final IFunction<? extends Map<X,Y>, ? super Map<K,V>> function);

    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K,V>> function);
    
    public <X> Level0GenericUniqOperator<X> execIfNotNull(final IFunction<X,? super Map<K,V>> function);
    
    public <X,Y> Level0MapOfArrayOperator<X,Y> asMapOfArrayOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0MapOfArrayOperator<?,?> asMapOfArrayOfUnknown();

    
    public <X,Y> Level0MapOfListOperator<X,Y> asMapOfListOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0MapOfListOperator<?,?> asMapOfListOfUnknown();

    
    public <X,Y> Level0MapOfSetOperator<X,Y> asMapOfSetOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0MapOfSetOperator<?,?> asMapOfSetOfUnknown();

    
    public <X,Y> Level0MapOperator<X,Y> asMapOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0MapOperator<?,?> asMapOfUnknown();
    
    
}

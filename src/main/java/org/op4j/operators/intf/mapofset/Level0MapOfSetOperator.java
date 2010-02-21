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
package org.op4j.operators.intf.mapofset;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.CastableToMapOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToMapOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToMapOfListOperator;
import org.op4j.operators.qualities.ExecutableMapOfSetOperator;
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
public interface Level0MapOfSetOperator<K,V>
        extends UniqOperator<Map<K,Set<V>>>,
                NavigableMapOperator<K,Set<V>>,
		        SortableOperator<Map.Entry<K,Set<V>>>,
                CastableToMapOfSetOperator,
		        ModifiableMapOperator<K,Set<V>>,
                ExtractableMapOperator<K,Set<V>>,
		        GenerizableOperator<Map<K,Set<V>>>,
                ExecutableMapOfSetOperator<K,V>,
                SelectableOperator<Map<K,Set<V>>>,
                ReplaceableOperator<Map<K,Set<V>>>,
                ReplaceableIfNullOperator<Map<K,Set<V>>>,
                ConvertibleToMapOfArrayOperator<K,V>,
                ConvertibleToMapOfListOperator<K,V> {



    public Level0MapOfSetSelectedOperator<K,V> ifIndex(final int... indexes);
    public Level0MapOfSetSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super Map<K,Set<V>>> eval);
    public Level0MapOfSetSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super Map<K,Set<V>>> eval);
    public Level0MapOfSetSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super Map<K,Set<V>>> eval);
    public Level0MapOfSetSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super Map<K,Set<V>>> eval);
    public Level0MapOfSetSelectedOperator<K,V> ifNull();
    public Level0MapOfSetSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super Map<K,Set<V>>> eval);
    public Level0MapOfSetSelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level0MapOfSetSelectedOperator<K,V> ifNotNull();
    public Level0MapOfSetSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super Map<K,Set<V>>> eval);


    
    public Level1MapOfSetEntriesOperator<K,V> forEachEntry();
    
    public Level0MapOfSetOperator<K,V> sort();
    public Level0MapOfSetOperator<K,V> sort(final Comparator<? super Map.Entry<K,Set<V>>> comparator);
    
    public Level0MapOfSetOperator<K,V> put(final K newKey, final Set<V> newValue);
    public Level0MapOfSetOperator<K,V> insert(final int position, final K newKey, final Set<V> newValue);
    public Level0MapOfSetOperator<K,V> putAll(final Map<K,Set<V>> map);
    public Level0MapOfSetOperator<K,V> insertAll(final int position, final Map<K,Set<V>> map);
    public Level0MapOfSetOperator<K,V> removeAllKeys(final K... keys);
    public Level0MapOfSetOperator<K,V> removeAllTrue(final IFunction<Boolean, ? super Map.Entry<K,Set<V>>> eval);
    public Level0MapOfSetOperator<K,V> removeAllFalse(final IFunction<Boolean, ? super Map.Entry<K,Set<V>>> eval);
    public Level0MapOfSetOperator<K,V> removeAllKeysNot(final K... keys);
    
    public Level0MapOfArrayOperator<K,V> toMapOfArrayOf(final Type<V> type);
    
    
    public Level0MapOfListOperator<K,V> toMapOfList();
    
    
    public Level0SetOperator<K> extractKeys();
    public Level0ListOperator<Set<V>> extractValues();
    


    
    public Level0GenericUniqOperator<Map<K,Set<V>>> generic();

    
    
    public Level0MapOfSetOperator<K,V> replaceWith(final Map<K,Set<V>> replacement);
    public Level0MapOfSetOperator<K,V> replaceIfNullWith(final Map<K,Set<V>> replacement);


    public Level0MapOfSetOperator<K,V> execIfNotNullAsMapOfSet(final IFunction<? extends Map<? extends K,? extends Set<? extends V>>,? super Map<K,Set<V>>> function);

    public <X,Y> Level0MapOfSetOperator<X,Y> execAsMapOfSet(final IFunction<? extends Map<X,? extends Set<Y>>, ? super Map<K,Set<V>>> function);

    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K,Set<V>>> function);
    
    public <X,Y> Level0MapOfSetOperator<X,Y> asMapOfSetOf(final Type<X> keyType, final Type<Y> valueType);
    }

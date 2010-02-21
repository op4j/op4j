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

import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.CastableToMapOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToMapOfListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOfSetOperator;
import org.op4j.operators.qualities.ExecutableMapOfArrayOperator;
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
public interface Level0MapOfArrayOperator<K,V>
        extends UniqOperator<Map<K,V[]>>,
                NavigableMapOperator<K,V[]>,
		        SortableOperator<Map.Entry<K,V[]>>,
                CastableToMapOfArrayOperator,
		        ModifiableMapOperator<K,V[]>,
		        ExtractableMapOperator<K,V[]>,
		        GenerizableOperator<Map<K,V[]>>,
                ExecutableMapOfArrayOperator<K,V>,
                SelectableOperator<Map<K,V[]>>,
                ReplaceableOperator<Map<K,V[]>>,
                ReplaceableIfNullOperator<Map<K,V[]>>,
                ConvertibleToMapOfListOperator<K,V>,
		        ConvertibleToMapOfSetOperator<K,V> {



    public Level0MapOfArraySelectedOperator<K,V> ifIndex(final int... indexes);
    public Level0MapOfArraySelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super Map<K,V[]>> eval);
    public Level0MapOfArraySelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super Map<K,V[]>> eval);
    public Level0MapOfArraySelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super Map<K,V[]>> eval);
    public Level0MapOfArraySelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super Map<K,V[]>> eval);
    public Level0MapOfArraySelectedOperator<K,V> ifNull();
    public Level0MapOfArraySelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super Map<K,V[]>> eval);
    public Level0MapOfArraySelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level0MapOfArraySelectedOperator<K,V> ifNotNull();
    public Level0MapOfArraySelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super Map<K,V[]>> eval);


    
    public Level1MapOfArrayEntriesOperator<K,V> forEachEntry();
    
    public Level0MapOfArrayOperator<K,V> sort();
    public Level0MapOfArrayOperator<K,V> sort(final Comparator<? super Map.Entry<K,V[]>> comparator);
    
    public Level0MapOfArrayOperator<K,V> put(final K newKey, final V[] newValue);
    public Level0MapOfArrayOperator<K,V> insert(final int position, final K newKey, final V[] newValue);
    public Level0MapOfArrayOperator<K,V> putAll(final Map<K,V[]> map);
    public Level0MapOfArrayOperator<K,V> insertAll(final int position, final Map<K,V[]> map);
    public Level0MapOfArrayOperator<K,V> removeAllKeys(final K... keys);
    public Level0MapOfArrayOperator<K,V> removeAllTrue(final IFunction<Boolean, ? super Map.Entry<K,V[]>> eval);
    public Level0MapOfArrayOperator<K,V> removeAllFalse(final IFunction<Boolean, ? super Map.Entry<K,V[]>> eval);
    public Level0MapOfArrayOperator<K,V> removeAllKeysNot(final K... keys);
    
    public Level0MapOfListOperator<K,V> toMapOfList();
    
    public Level0MapOfSetOperator<K,V> toMapOfSet();
    

    
    public Level0SetOperator<K> extractKeys();
    public Level0ListOperator<V[]> extractValues();
    

    
    
    public Level0GenericUniqOperator<Map<K,V[]>> generic();
    

    
    
    public Level0MapOfArrayOperator<K,V> replaceWith(final Map<K,V[]> replacement);
    public Level0MapOfArrayOperator<K,V> replaceIfNullWith(final Map<K,V[]> replacement);


    public Level0MapOfArrayOperator<K,V> execIfNotNullAsMapOfArray(final IFunction<? extends Map<? extends K,? extends V[]>,? super Map<K,V[]>> function);

    public Level0MapOfArrayOperator<K,V> execAsMapOfArray(final IFunction<? extends Map<? extends K,? extends V[]>,? super Map<K,V[]>> function);

    public <X,Y> Level0MapOfArrayOperator<X,Y> execAsMapOfArrayOf(final Type<Y> valueType, final IFunction<? extends Map<X,Y[]>,? super Map<K,V[]>> function);

    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K,V[]>> function);
    
    public <X,Y> Level0MapOfArrayOperator<X,Y> asMapOfArrayOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0MapOfArrayOperator<?,?> asMapOfArrayOfUnknown();

    
}

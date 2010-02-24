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
package org.op4j.operators.op.intf.map;

import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.op.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.op.intf.list.Level0ListOperator;
import org.op4j.operators.op.intf.set.Level0SetOperator;
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
import org.op4j.operators.qualities.UniqOpOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level0MapOperator<K,V,I>
        extends UniqOpOperator<Map<K,V>>,
                NavigableMapOperator<K,V>,
                CastableToMapOperator,
		        SortableOperator<Map.Entry<K,V>>,
                ExecutableMapOperator<K,V>,
                ModifiableMapOperator<K,V>,
                ExtractableMapOperator<K,V>,
                SelectableOperator<Map<K,V>>,
                ReplaceableOperator<Map<K,V>>,
                ReplaceableIfNullOperator<Map<K,V>>,
                GenerizableOperator<Map<K,V>,I> {



    public Level0MapSelectedOperator<K,V,I> ifIndex(final int... indexes);
    public Level0MapSelectedOperator<K,V,I> ifTrue(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V,I> ifFalse(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V,I> ifNullOrFalse(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V,I> ifNotNullAndFalse(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V,I> ifNull();
    public Level0MapSelectedOperator<K,V,I> ifNullOrTrue(final IFunction<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V,I> ifIndexNot(final int... indexes);
    public Level0MapSelectedOperator<K,V,I> ifNotNull();
    public Level0MapSelectedOperator<K,V,I> ifNotNullAndTrue(final IFunction<Boolean, ? super Map<K,V>> eval);


    
    public Level1MapEntriesOperator<K,V,I> forEachEntry();
    
    public Level0MapOperator<K,V,I> sort();
    public Level0MapOperator<K,V,I> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public Level0MapOperator<K,V,I> put(final K newKey, final V newValue);
    public Level0MapOperator<K,V,I> insert(final int position, final K newKey, final V newValue);
    public Level0MapOperator<K,V,I> putAll(final Map<K,V> map);
    public Level0MapOperator<K,V,I> insertAll(final int position, final Map<K,V> map);
    public Level0MapOperator<K,V,I> removeAllKeys(final K... keys);
    public Level0MapOperator<K,V,I> removeAllTrue(final IFunction<Boolean, ? super Map.Entry<K,V>> eval);
    public Level0MapOperator<K,V,I> removeAllFalse(final IFunction<Boolean, ? super Map.Entry<K,V>> eval);
    public Level0MapOperator<K,V,I> removeAllKeysNot(final K... keys);
    
    
    public Level0SetOperator<K,I> extractKeys();
    public Level0ListOperator<V,I> extractValues();
    
    
    
    public Level0GenericUniqOperator<Map<K,V>,I> generic();

    
    
    
    public Level0MapOperator<K,V,I> replaceWith(final Map<K,V> replacement);
    public Level0MapOperator<K,V,I> replaceIfNullWith(final Map<K,V> replacement);


    public Level0MapOperator<K,V,I> execIfNotNullAsMap(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function);

    public <X,Y> Level0MapOperator<X,Y,I> execAsMap(final IFunction<? extends Map<X,Y>, ? super Map<K,V>> function);

    public <X> Level0GenericUniqOperator<X,I> exec(final IFunction<X, ? super Map<K,V>> function);
    
    public <X,Y> Level0MapOperator<X,Y,I> asMapOf(final Type<X> keyType, final Type<Y> valueType);
    }

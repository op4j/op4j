/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
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
import org.op4j.operators.qualities.TotalizableOperator;
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0MapOperator<I,K,V>
        extends UniqOperator<Map<K,V>>,
                NavigableMapOperator<K,V>,
                CastableToMapOperator,
		        SortableOperator<Map.Entry<K,V>>,
                ExecutableMapOperator<K,V>,
                ModifiableMapOperator<K,V>,
                ExtractableMapOperator<K,V>,
                SelectableOperator<Map<K,V>>,
                ReplaceableOperator<Map<K,V>>,
                ReplaceableIfNullOperator<Map<K,V>>,
                GenerizableOperator<I,Map<K,V>>,
                TotalizableOperator<I,Map.Entry<K,V>> {



    public ILevel0MapSelectedOperator<I,K,V> ifTrue(final IFunction<? super Map<K,V>,Boolean> eval);
    public ILevel0MapSelectedOperator<I,K,V> ifFalse(final IFunction<? super Map<K,V>,Boolean> eval);
    public ILevel0MapSelectedOperator<I,K,V> ifNullOrFalse(final IFunction<? super Map<K,V>,Boolean> eval);
    public ILevel0MapSelectedOperator<I,K,V> ifNotNullAndFalse(final IFunction<? super Map<K,V>,Boolean> eval);
    public ILevel0MapSelectedOperator<I,K,V> ifNull();
    public ILevel0MapSelectedOperator<I,K,V> ifNullOrTrue(final IFunction<? super Map<K,V>,Boolean> eval);
    public ILevel0MapSelectedOperator<I,K,V> ifNotNull();
    public ILevel0MapSelectedOperator<I,K,V> ifNotNullAndTrue(final IFunction<? super Map<K,V>,Boolean> eval);


    
    public ILevel1MapEntriesOperator<I,K,V> forEachEntry();
    
    public ILevel0MapOperator<I,K,V> sort();
    public ILevel0MapOperator<I,K,V> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    public ILevel0MapOperator<I,K,V> sortBy(final IFunction<? super Map.Entry<K,V>,?> by);
    
    public ILevel0MapOperator<I,K,V> put(final K newKey, final V newValue);
    public ILevel0MapOperator<I,K,V> insert(final int position, final K newKey, final V newValue);
    public ILevel0MapOperator<I,K,V> putAll(final Map<K,V> map);
    public ILevel0MapOperator<I,K,V> insertAll(final int position, final Map<K,V> map);
    public ILevel0MapOperator<I,K,V> removeAllKeys(final K... keys);
    public ILevel0MapOperator<I,K,V> removeAllTrue(final IFunction<? super Map.Entry<K,V>,Boolean> eval);
    public ILevel0MapOperator<I,K,V> removeAllFalse(final IFunction<? super Map.Entry<K,V>,Boolean> eval);
    public ILevel0MapOperator<I,K,V> removeAllKeysNot(final K... keys);
    
    
    public ILevel0SetOperator<I,K> extractKeys();
    public ILevel0ListOperator<I,V> extractValues();
    
    
    
    public ILevel0GenericUniqOperator<I,Map<K,V>> generic();

    
    
    
    public ILevel0MapOperator<I,K,V> replaceWith(final Map<K,V> replacement);
    public ILevel0MapOperator<I,K,V> replaceIfNullWith(final Map<K,V> replacement);


    public ILevel0MapOperator<I,K,V> execIfNotNullAsMap(final IFunction<? super Map<K,V>,? extends Map<? extends K,? extends V>> function);

    public <X,Y> ILevel0MapOperator<I,X,Y> execAsMap(final IFunction<? super Map<K,V>,? extends Map<X,Y>> function);

    public <X> ILevel0GenericUniqOperator<I,X> exec(final IFunction<? super Map<K,V>,X> function);
    
    
    public <X,Y> ILevel0MapOperator<I,X,Y> of(final Type<X> keyType, final Type<Y> valueType);
    public <X,Y> ILevel0MapOperator<I,X,Y> castToMapOf(final Type<X> keyType, final Type<Y> valueType);
    
    
    public ILevel0GenericUniqOperator<I,Boolean> any(final IFunction<? super Map.Entry<K,V>,Boolean> eval);
    public ILevel0GenericUniqOperator<I,Boolean> all(final IFunction<? super Map.Entry<K,V>,Boolean> eval);
    
}

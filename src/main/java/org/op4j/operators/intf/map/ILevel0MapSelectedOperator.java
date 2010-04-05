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

import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.ExecutableMapSelectedOperator;
import org.op4j.operators.qualities.ModifiableMapOperator;
import org.op4j.operators.qualities.NavigableMapOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectedOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0MapSelectedOperator<I,K,V>
        extends UniqOperator<Map<K,V>>,
                NavigableMapOperator<K,V>,
		        SortableOperator<Map.Entry<K,V>>,
                ExecutableMapSelectedOperator<K,V>,
                ReplaceableOperator<Map<K,V>>,
                ModifiableMapOperator<K,V>,
                SelectedOperator<Map<K,V>> {



    public ILevel0MapOperator<I,K,V> endIf();


    
    public ILevel1MapSelectedEntriesOperator<I,K,V> forEachEntry();
    
    public ILevel0MapSelectedOperator<I,K,V> sort();
    public ILevel0MapSelectedOperator<I,K,V> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    public ILevel0MapSelectedOperator<I,K,V> sortBy(final IFunction<? super Map.Entry<K,V>,?> by);
    
    public ILevel0MapSelectedOperator<I,K,V> put(final K newKey, final V newValue);
    public ILevel0MapSelectedOperator<I,K,V> insert(final int position, final K newKey, final V newValue);
    public ILevel0MapSelectedOperator<I,K,V> putAll(final Map<K,V> map);
    public ILevel0MapSelectedOperator<I,K,V> insertAll(final int position, final Map<K,V> map);
    public ILevel0MapSelectedOperator<I,K,V> removeAllKeys(final K... keys);
    public ILevel0MapSelectedOperator<I,K,V> removeAllTrue(final IFunction<? super Map.Entry<K,V>,Boolean> eval);
    public ILevel0MapSelectedOperator<I,K,V> removeAllFalse(final IFunction<? super Map.Entry<K,V>,Boolean> eval);
    public ILevel0MapSelectedOperator<I,K,V> removeAllKeysNot(final K... keys);
    
    
    
    public ILevel0MapSelectedOperator<I,K,V> replaceWith(final Map<K,V> replacement);

    public ILevel0MapSelectedOperator<I,K,V> execAsMap(final IFunction<? super Map<K,V>,? extends Map<? extends K,? extends V>> function);
    
    
}

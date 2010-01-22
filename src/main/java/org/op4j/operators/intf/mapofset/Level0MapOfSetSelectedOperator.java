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

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableMapOfSetSelectedOperator;
import org.op4j.operators.qualities.ModifiableMapOperator;
import org.op4j.operators.qualities.NavigableMapOperator;
import org.op4j.operators.qualities.SelectedOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level0MapOfSetSelectedOperator<K,V,I>
        extends UniqOperator<Map<K,Set<V>>,I>,
                NavigableMapOperator<K,Set<V>,I>,
		        SortableOperator<Map.Entry<K,Set<V>>,I>,
		        ModifiableMapOperator<K,Set<V>,I>,
                ExecutableMapOfSetSelectedOperator<K,V,I>,
                ReplaceableOperator<Map<K,Set<V>>,I>,
                SelectedOperator<Map<K,Set<V>>,I> {



    public Level0MapOfSetOperator<K,V,I> endIf();


    
    public Level1MapOfSetSelectedEntriesOperator<K,V,I> forEachEntry();
    
    public Level0MapOfSetSelectedOperator<K,V,I> sort();
    public Level0MapOfSetSelectedOperator<K,V,I> sort(final Comparator<? super Map.Entry<K,Set<V>>> comparator);
    
    public Level0MapOfSetSelectedOperator<K,V,I> put(final K newKey, final Set<V> newValue);
    public Level0MapOfSetSelectedOperator<K,V,I> insert(final int position, final K newKey, final Set<V> newValue);
    public Level0MapOfSetSelectedOperator<K,V,I> putAll(final Map<K,Set<V>> map);
    public Level0MapOfSetSelectedOperator<K,V,I> insertAll(final int position, final Map<K,Set<V>> map);
    public Level0MapOfSetSelectedOperator<K,V,I> removeAllKeys(final K... keys);
    public Level0MapOfSetSelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super Map.Entry<K,Set<V>>> eval);
    public Level0MapOfSetSelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super Map.Entry<K,Set<V>>> eval);
    public Level0MapOfSetSelectedOperator<K,V,I> removeAllKeysNot(final K... keys);
    
    
    public Level0MapOfSetSelectedOperator<K,V,I> convert(final IConverter<? extends Map<? extends K,? extends Set<? extends V>>, ? super Map<K,Set<V>>> converter);
    
    public Level0MapOfSetSelectedOperator<K,V,I> eval(final IEvaluator<? extends Map<? extends K,? extends Set<? extends V>>, ? super Map<K,Set<V>>> eval);

    public Level0MapOfSetSelectedOperator<K,V,I> replaceWith(final Map<K,Set<V>> replacement);

    public Level0MapOfSetSelectedOperator<K,V,I> exec(final IFunction<? extends Map<? extends K,? extends Set<? extends V>>, ? super Map<K,Set<V>>> function);
    
    
    
    
}

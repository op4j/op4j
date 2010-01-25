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
package org.op4j.operators.intf.mapoflist;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableMapOfListSelectedOperator;
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
public interface Level0MapOfListSelectedOperator<K,V>
        extends UniqOperator<Map<K,List<V>>>,
                NavigableMapOperator<K,List<V>>,
		        SortableOperator<Map.Entry<K,List<V>>>,
		        ModifiableMapOperator<K,List<V>>,
                ExecutableMapOfListSelectedOperator<K,V>,
                ReplaceableOperator<Map<K,List<V>>>,
                SelectedOperator<Map<K,List<V>>> {



    public Level0MapOfListOperator<K,V> endIf();


    
    public Level1MapOfListSelectedEntriesOperator<K,V> forEachEntry();
    
    public Level0MapOfListSelectedOperator<K,V> sort();
    public Level0MapOfListSelectedOperator<K,V> sort(final Comparator<? super Map.Entry<K,List<V>>> comparator);
    
    public Level0MapOfListSelectedOperator<K,V> put(final K newKey, final List<V> newValue);
    public Level0MapOfListSelectedOperator<K,V> insert(final int position, final K newKey, final List<V> newValue);
    public Level0MapOfListSelectedOperator<K,V> putAll(final Map<K,List<V>> map);
    public Level0MapOfListSelectedOperator<K,V> insertAll(final int position, final Map<K,List<V>> map);
    public Level0MapOfListSelectedOperator<K,V> removeAllKeys(final K... keys);
    public Level0MapOfListSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean, ? super Map.Entry<K,List<V>>> eval);
    public Level0MapOfListSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean, ? super Map.Entry<K,List<V>>> eval);
    public Level0MapOfListSelectedOperator<K,V> removeAllKeysNot(final K... keys);
    
    
    public Level0MapOfListSelectedOperator<K,V> convert(final IConverter<? extends Map<? extends K,? extends List<? extends V>>, ? super Map<K,List<V>>> converter);
    
    public Level0MapOfListSelectedOperator<K,V> eval(final IEvaluator<? extends Map<? extends K,? extends List<? extends V>>, ? super Map<K,List<V>>> eval);

    public Level0MapOfListSelectedOperator<K,V> replaceWith(final Map<K,List<V>> replacement);

    public Level0MapOfListSelectedOperator<K,V> exec(final IFunction<? extends Map<? extends K,? extends List<? extends V>>, ? super Map<K,List<V>>> function);
    
    
    
    
}

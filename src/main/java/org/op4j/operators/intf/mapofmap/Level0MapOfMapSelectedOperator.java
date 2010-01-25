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

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableMapOfMapSelectedOperator;
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
public interface Level0MapOfMapSelectedOperator<K1,K2,V>
        extends UniqOperator<Map<K1,Map<K2,V>>>,
                NavigableMapOperator<K1,Map<K2,V>>,
		        SortableOperator<Map.Entry<K1,Map<K2,V>>>,
                ExecutableMapOfMapSelectedOperator<K1,K2,V>,
		        ModifiableMapOperator<K1,Map<K2,V>>,
                ReplaceableOperator<Map<K1,Map<K2,V>>>,
                SelectedOperator<Map<K1,Map<K2,V>>> {



    public Level0MapOfMapOperator<K1,K2,V> endIf();


    
    public Level1MapOfMapEntriesOperator<K1,K2,V> forEachEntry();
    
    public Level0MapOfMapSelectedOperator<K1,K2,V> sort();
    public Level0MapOfMapSelectedOperator<K1,K2,V> sort(final Comparator<? super Map.Entry<K1,Map<K2,V>>> comparator);
        
    public Level0MapOfMapSelectedOperator<K1,K2,V> put(final K1 newKey, final Map<K2,V> newValue);
    public Level0MapOfMapSelectedOperator<K1,K2,V> insert(final int position, final K1 newKey, final Map<K2,V> newValue);
    public Level0MapOfMapSelectedOperator<K1,K2,V> putAll(final Map<K1,Map<K2,V>> map);
    public Level0MapOfMapSelectedOperator<K1,K2,V> insertAll(final int position, final Map<K1,Map<K2,V>> map);
    public Level0MapOfMapSelectedOperator<K1,K2,V> removeAllKeys(final K1... keys);
    public Level0MapOfMapSelectedOperator<K1,K2,V> removeAllTrue(final IEvaluator<Boolean, ? super Map.Entry<K1,Map<K2,V>>> eval);
    public Level0MapOfMapSelectedOperator<K1,K2,V> removeAllFalse(final IEvaluator<Boolean, ? super Map.Entry<K1,Map<K2,V>>> eval);
    public Level0MapOfMapSelectedOperator<K1,K2,V> removeAllKeysNot(final K1... keys);
    
    
    
    public Level0MapOfMapSelectedOperator<K1,K2,V> replaceWith(final Map<K1,Map<K2,V>> replacement);
    
    
    public Level0MapOfMapSelectedOperator<K1,K2,V> convert(final IConverter<? extends Map<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map<K1,Map<K2,V>>> converter);
    
    public Level0MapOfMapSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends Map<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map<K1,Map<K2,V>>> eval);


    public Level0MapOfMapSelectedOperator<K1,K2,V> exec(final IFunction<? extends Map<? extends K1,? extends Map<? extends K2,? extends V>>, ? super Map<K1,Map<K2,V>>> function);

    
}

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

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableMapOfArraySelectedOperator;
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
public interface Level0MapOfArraySelectedOperator<K,V,I>
        extends UniqOperator<Map<K,V[]>,I>,
                NavigableMapOperator<K,V[],I>,
		        SortableOperator<Map.Entry<K,V[]>,I>,
		        ModifiableMapOperator<K,V[],I>,
                ExecutableMapOfArraySelectedOperator<K,V,I>,
                ReplaceableOperator<Map<K,V[]>,I>,
                SelectedOperator<Map<K,V[]>,I> {



    public Level0MapOfArrayOperator<K,V,I> endIf();


    
    public Level1MapOfArraySelectedEntriesOperator<K,V,I> forEachEntry();
    
    public Level0MapOfArraySelectedOperator<K,V,I> sort();
    public Level0MapOfArraySelectedOperator<K,V,I> sort(final Comparator<? super Map.Entry<K,V[]>> comparator);
    
    public Level0MapOfArraySelectedOperator<K,V,I> put(final K newKey, final V[] newValue);
    public Level0MapOfArraySelectedOperator<K,V,I> insert(final int position, final K newKey, final V[] newValue);
    public Level0MapOfArraySelectedOperator<K,V,I> putAll(final Map<K,V[]> map);
    public Level0MapOfArraySelectedOperator<K,V,I> insertAll(final int position, final Map<K,V[]> map);
    public Level0MapOfArraySelectedOperator<K,V,I> removeAllKeys(final K... keys);
    public Level0MapOfArraySelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super Map.Entry<K,V[]>> eval);
    public Level0MapOfArraySelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super Map.Entry<K,V[]>> eval);
    public Level0MapOfArraySelectedOperator<K,V,I> removeAllKeysNot(final K... keys);
    
    
    public Level0MapOfArraySelectedOperator<K,V,I> convert(final IConverter<? extends Map<? extends K,? extends V[]>, ? super Map<K,V[]>> converter);
    
    public Level0MapOfArraySelectedOperator<K,V,I> eval(final IEvaluator<? extends Map<? extends K,? extends V[]>, ? super Map<K,V[]>> eval);

    public Level0MapOfArraySelectedOperator<K,V,I> replaceWith(final Map<K,V[]> replacement);

    public Level0MapOfArraySelectedOperator<K,V,I> exec(final IFunction<? extends Map<? extends K,? extends V[]>, ? super Map<K,V[]>> function);
    
    
    
    
}

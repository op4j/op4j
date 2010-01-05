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
package org.op4j.operators.intf.setofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ConvertibleSelectedOperator;
import org.op4j.operators.qualities.EvaluableSelectedOperator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.ModifiableMapOperator;
import org.op4j.operators.qualities.NavigableMapOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
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
public interface Level1SetOfMapSelectedElementsOperator<K,V>
        extends UniqOperator<Set<Map<K,V>>>,
                NavigableMapOperator<K,V>,
                NavigatingCollectionOperator<Map<K,V>>,
		        SortableOperator<Map.Entry<K,V>>,
                ExecutableSelectedOperator<Map<K,V>>,
                ConvertibleSelectedOperator<Map<K,V>>,
                EvaluableSelectedOperator<Map<K,V>>,
                SelectableOperator<Map<K,V>>,
                ModifiableMapOperator<K,V> {



    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices);
    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNull();
    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNotNull();
    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);


    
    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> forEachEntry();
    
    public Level0SetOfMapSelectedOperator<K,V> endFor();
    
    public Level1SetOfMapSelectedElementsOperator<K,V> sort();
    public Level1SetOfMapSelectedElementsOperator<K,V> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public Level1SetOfMapSelectedElementsOperator<K,V> put(final K newKey, final V newValue);
    public Level1SetOfMapSelectedElementsOperator<K,V> insert(final int position, final K newKey, final V newValue);
    public Level1SetOfMapSelectedElementsOperator<K,V> putAll(final Map<K,V> map);
    public Level1SetOfMapSelectedElementsOperator<K,V> insertAll(final int position, final Map<K,V> map);
    public Level1SetOfMapSelectedElementsOperator<K,V> removeKeys(final K... keys);
    public Level1SetOfMapSelectedElementsOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1SetOfMapSelectedElementsOperator<K,V> removeNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1SetOfMapSelectedElementsOperator<K,V> removeKeysNot(final K... keys);
    
    
    
    
    
    
    public Level1SetOfMapSelectedElementsOperator<K,V> convert(final IConverter<? extends Map<K,V>, ? super Map<K,V>> converter);
    
    public Level1SetOfMapSelectedElementsOperator<K,V> eval(final IEvaluator<? extends Map<K,V>, ? super Map<K,V>> eval);

    public Level1SetOfMapSelectedElementsOperator<K,V> exec(final IFunction<? extends Map<K,V>, ? super Map<K,V>> function);
    
    
}
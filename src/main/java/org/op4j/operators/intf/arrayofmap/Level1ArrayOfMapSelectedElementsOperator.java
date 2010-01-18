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
package org.op4j.operators.intf.arrayofmap;

import java.util.Comparator;
import java.util.Map;


import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableMapSelectedOperator;
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
public interface Level1ArrayOfMapSelectedElementsOperator<K,V>
        extends UniqOperator<Map<K,V>[]>,
                NavigableMapOperator<K,V>,
                NavigatingCollectionOperator<Map<K,V>>,
		        SortableOperator<Map.Entry<K,V>>,
                ExecutableMapSelectedOperator<K,V>,
                SelectableOperator<Map<K,V>>,
                ModifiableMapOperator<K,V> {



    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices);
    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNull();
    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNotNull();
    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);


    
    public Level2ArrayOfMapSelectedElementsEntriesOperator<K,V> forEachEntry();
    
    public Level0ArrayOfMapSelectedOperator<K,V> endFor();
    
    public Level1ArrayOfMapSelectedElementsOperator<K,V> sort();
    public Level1ArrayOfMapSelectedElementsOperator<K,V> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public Level1ArrayOfMapSelectedElementsOperator<K,V> put(final K newKey, final V newValue);
    public Level1ArrayOfMapSelectedElementsOperator<K,V> insert(final int position, final K newKey, final V newValue);
    public Level1ArrayOfMapSelectedElementsOperator<K,V> putAll(final Map<K,V> map);
    public Level1ArrayOfMapSelectedElementsOperator<K,V> insertAll(final int position, final Map<K,V> map);
    public Level1ArrayOfMapSelectedElementsOperator<K,V> removeAllKeys(final K... keys);
    public Level1ArrayOfMapSelectedElementsOperator<K,V> removeAllTrue(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1ArrayOfMapSelectedElementsOperator<K,V> removeAllFalse(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1ArrayOfMapSelectedElementsOperator<K,V> removeAllKeysNot(final K... keys);
    
    
    
    
    
    
    public Level1ArrayOfMapSelectedElementsOperator<K,V> convert(final IConverter<? extends Map<? extends K,? extends V>, ? super Map<K,V>> converter);
    
    public Level1ArrayOfMapSelectedElementsOperator<K,V> eval(final IEvaluator<? extends Map<? extends K,? extends V>, ? super Map<K,V>> eval);

    public Level1ArrayOfMapSelectedElementsOperator<K,V> exec(final IFunction<? extends Map<? extends K,? extends V>, ? super Map<K,V>> function);
    
    
}

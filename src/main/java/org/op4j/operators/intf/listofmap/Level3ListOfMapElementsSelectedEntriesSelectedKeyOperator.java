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
package org.op4j.operators.intf.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level3ListOfMapElementsSelectedEntriesSelectedKeyOperator<K,V>
        extends UniqOperator<List<Map<K,V>>>,
                NavigatingMapEntryOperator,
                ExecutableSelectedOperator<K>,
                ReplaceableOperator<K>,
                SelectableOperator<K> {



    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indexes);
    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super K> eval);
    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super K> eval);
    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval);
    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval);
    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNull();
    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval);
    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNull();
    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval);

		    
    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> endOn();

    public Level3ListOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> replaceWith(final K replacement);

    public Level3ListOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K, ? super K> function);
    
    public Level3ListOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K, ? super K> eval);
    
    public Level3ListOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K, ? super K> converter);
    
        
}

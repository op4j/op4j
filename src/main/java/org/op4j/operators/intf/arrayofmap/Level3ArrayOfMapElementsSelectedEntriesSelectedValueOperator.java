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

import java.util.Map;


import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOperator;
import org.op4j.operators.qualities.ReplaceableOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V,I>
        extends UniqOperator<Map<K,V>[],I>,
                NavigatingMapEntryOperator<I>,
        		ExecutableSelectedOperator<V,I>,
                ReplaceableOperator<V,I>,
                SelectableOperator<V,I> {



    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifNull();
    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifNotNull();
    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);

            
    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V,I> endOn();
    
    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V,I> convert(final IConverter<? extends V, ? super V> converter);
    
    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V,I> eval(final IEvaluator<? extends V, ? super V> eval);

    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V,I> replaceWith(final V replacement);

    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V,I> exec(final IFunction<? extends V, ? super V> function);
        
}

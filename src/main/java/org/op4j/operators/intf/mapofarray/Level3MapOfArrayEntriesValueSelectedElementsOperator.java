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

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.NavigatingArrayOperator;
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
public interface Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V>
        extends UniqOperator<Map<K,V[]>>,
                NavigatingArrayOperator<V>,
        		ExecutableSelectedOperator<V>,
                ReplaceableOperator<V>,
                SelectableOperator<V> {



    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices);
    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifNull();
    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNull();
    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);

    
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> endFor();
    
    public Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V> convert(final IConverter<? extends V, ? super V> converter);
    
    public Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V> eval(final IEvaluator<? extends V, ? super V> eval);

    public Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V> replaceWith(final V replacement);

    public Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V, ? super V> function);
    
        
}

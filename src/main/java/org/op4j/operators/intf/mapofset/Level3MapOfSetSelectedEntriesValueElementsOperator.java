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

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
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
public interface Level3MapOfSetSelectedEntriesValueElementsOperator<K,V,I>
        extends UniqOperator<Map<K,Set<V>>,I>,
                NavigatingCollectionOperator<V,I>,
        		ExecutableSelectedOperator<V,I>,
                ReplaceableOperator<V,I>,
                SelectableOperator<V,I> {



    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifNull();
    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifNotNull();
    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);

    
    public Level2MapOfSetSelectedEntriesValueOperator<K,V,I> endFor();
    
    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V,I> convert(final IConverter<? extends V, ? super V> converter);
    
    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V,I> eval(final IEvaluator<? extends V, ? super V> eval);

    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V,I> replaceWith(final V replacement);

    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V,I> exec(final IFunction<? extends V, ? super V> function);
    
        
}

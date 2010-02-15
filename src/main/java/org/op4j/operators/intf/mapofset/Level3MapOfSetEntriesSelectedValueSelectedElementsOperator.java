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
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
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
public interface Level3MapOfSetEntriesSelectedValueSelectedElementsOperator<K,V>
        extends UniqOperator<Map<K,Set<V>>>,
                NavigatingCollectionOperator<V>,
        		ExecutableSelectedOperator<V>,
                ReplaceableOperator<V>,
                SelectableOperator<V> {



    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indexes);
    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super V> eval);
    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super V> eval);
    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super V> eval);
    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super V> eval);
    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNull();
    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super V> eval);
    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNull();
    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super V> eval);

    
    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> endFor();
    
    public Level3MapOfSetEntriesSelectedValueSelectedElementsOperator<K,V> execIfNotNull(final IFunction<? extends V, ? super V> function);

    public Level3MapOfSetEntriesSelectedValueSelectedElementsOperator<K,V> replaceWith(final V replacement);

    public Level3MapOfSetEntriesSelectedValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V, ? super V> function);
    
        
}

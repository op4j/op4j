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

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
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
public interface Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V>
        extends UniqOperator<Set<Map<K,V>>>,
                NavigatingMapEntryOperator,
                ExecutableSelectedOperator<K>,
                ReplaceableOperator<K>,
                SelectableOperator<K> {



    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indexes);
    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super K> eval);
    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super K> eval);
    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super K> eval);
    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super K> eval);
    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNull();
    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super K> eval);
    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNull();
    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super K> eval);

		    
    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> endOn();

    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> replaceWith(final K replacement);

    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K, ? super K> function);
    
    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> execIfNotNull(final IFunction<? extends K, ? super K> function);
    
    }

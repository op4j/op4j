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
package org.op4j.operators.intf.map;

import java.util.Map;

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
public interface Level2MapSelectedEntriesSelectedKeyOperator<I,K,V>
        extends UniqOperator<Map<K,V>>,
                NavigatingMapEntryOperator,
                ExecutableSelectedOperator<K>,
                ReplaceableOperator<K>,
                SelectableOperator<K> {



    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifIndex(final int... indexes);
    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifTrue(final IFunction<? super K,Boolean> eval);
    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifFalse(final IFunction<? super K,Boolean> eval);
    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifNullOrFalse(final IFunction<? super K,Boolean> eval);
    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifNotNullAndFalse(final IFunction<? super K,Boolean> eval);
    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifNull();
    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifNullOrTrue(final IFunction<? super K,Boolean> eval);
    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifIndexNot(final int... indexes);
    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifNotNull();
    public Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> ifNotNullAndTrue(final IFunction<? super K,Boolean> eval);

    
    public Level1MapSelectedEntriesSelectedOperator<I,K,V> endOn();

    public Level2MapSelectedEntriesSelectedKeyOperator<I,K,V> replaceWith(final K replacement);

    public Level2MapSelectedEntriesSelectedKeyOperator<I,K,V> exec(final IFunction<? super K,? extends K> function);
    
    public Level2MapSelectedEntriesSelectedKeyOperator<I,K,V> execIfNotNull(final IFunction<? super K,? extends K> function);
    
    }

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
package org.op4j.operators.intf.mapofmap;

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
public interface Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V>
        extends UniqOperator<Map<K1,Map<K2,V>>>,
                NavigatingMapEntryOperator,
                ExecutableSelectedOperator<K1>, 
                ReplaceableOperator<K1>,
                SelectableOperator<K1> {



    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifIndex(final int... indices);
    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifTrue(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifFalse(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNullOrFalse(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNull();
    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNullOrTrue(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifIndexNot(final int... indices);
    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNull();
    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K1> eval);

    
    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V> endOn();

    public Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V> replaceBy(final K1 replacement);


    public Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V> exec(final IFunction<? extends K1, ? super K1> function);
    
    public Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V> eval(final IEvaluator<? extends K1,? super K1> eval);
    
    public Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V> convert(final IConverter<? extends K1,? super K1> converter);
    
        
}

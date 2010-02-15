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
public interface Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueOperator<K1,K2,V>
        extends UniqOperator<Map<K1,Map<K2,V>>>,
                NavigatingMapEntryOperator,
        		ExecutableSelectedOperator<V>,
                ReplaceableOperator<V>,
                SelectableOperator<V> {



    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifIndex(final int... indexes);
    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifTrue(final IFunction<Boolean, ? super V> eval);
    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifFalse(final IFunction<Boolean, ? super V> eval);
    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNullOrFalse(final IFunction<Boolean, ? super V> eval);
    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNullAndFalse(final IFunction<Boolean, ? super V> eval);
    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNull();
    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNullOrTrue(final IFunction<Boolean, ? super V> eval);
    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifIndexNot(final int... indexes);
    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNull();
    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNullAndTrue(final IFunction<Boolean, ? super V> eval);

    
    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> endOn();
    
    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueOperator<K1,K2,V> execIfNotNull(final IFunction<? extends V,? super V> function);

    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueOperator<K1,K2,V> replaceWith(final V replacement);


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueOperator<K1,K2,V> exec(final IFunction<? extends V, ? super V> function);
    
        
}

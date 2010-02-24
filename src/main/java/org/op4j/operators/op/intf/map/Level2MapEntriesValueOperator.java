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
package org.op4j.operators.op.intf.map;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOpOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2MapEntriesValueOperator<K,V,I>
        extends UniqOpOperator<Map<K,V>>,
				NavigatingMapEntryOperator,
        		ExecutableOperator<V>,
                SelectableOperator<V>,
                ReplaceableOperator<V>,
                ReplaceableIfNullOperator<V>,
                CastableToTypeOperator<V> {



    public Level2MapEntriesValueSelectedOperator<K,V,I> ifIndex(final int... indexes);
    public Level2MapEntriesValueSelectedOperator<K,V,I> ifTrue(final IFunction<Boolean, ? super V> eval);
    public Level2MapEntriesValueSelectedOperator<K,V,I> ifFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapEntriesValueSelectedOperator<K,V,I> ifNullOrFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapEntriesValueSelectedOperator<K,V,I> ifNotNullAndFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapEntriesValueSelectedOperator<K,V,I> ifNull();
    public Level2MapEntriesValueSelectedOperator<K,V,I> ifNullOrTrue(final IFunction<Boolean, ? super V> eval);
    public Level2MapEntriesValueSelectedOperator<K,V,I> ifIndexNot(final int... indexes);
    public Level2MapEntriesValueSelectedOperator<K,V,I> ifNotNull();
    public Level2MapEntriesValueSelectedOperator<K,V,I> ifNotNullAndTrue(final IFunction<Boolean, ? super V> eval);

    
    public Level1MapEntriesOperator<K,V,I> endOn();
    
    public Level2MapEntriesValueOperator<K,V,I> replaceWith(final V replacement);
    public Level2MapEntriesValueOperator<K,V,I> replaceIfNullWith(final V replacement);


    public <X> Level2MapEntriesValueOperator<K,X,I> execIfNotNull(final IFunction<X,? super V> function);

    public <X> Level2MapEntriesValueOperator<K,X,I> exec(final IFunction<X, ? super V> function);
    
    public <X> Level2MapEntriesValueOperator<K,X,I> asType(final Type<X> type);
    public Level2MapEntriesValueOperator<K,?,I> asUnknown();
    
        
}

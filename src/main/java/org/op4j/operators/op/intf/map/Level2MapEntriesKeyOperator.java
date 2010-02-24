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
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOpOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2MapEntriesKeyOperator<K,V,I>
        extends UniqOpOperator<Map<K,V>>,
                NavigatingMapEntryOperator,
                CastableToTypeOperator<K>,
                ExecutableOperator<K>, 
                SelectableOperator<K> {



    public Level2MapEntriesKeySelectedOperator<K,V,I> ifIndex(final int... indexes);
    public Level2MapEntriesKeySelectedOperator<K,V,I> ifTrue(final IFunction<Boolean, ? super K> eval);
    public Level2MapEntriesKeySelectedOperator<K,V,I> ifFalse(final IFunction<Boolean, ? super K> eval);
    public Level2MapEntriesKeySelectedOperator<K,V,I> ifNullOrFalse(final IFunction<Boolean, ? super K> eval);
    public Level2MapEntriesKeySelectedOperator<K,V,I> ifNotNullAndFalse(final IFunction<Boolean, ? super K> eval);
    public Level2MapEntriesKeySelectedOperator<K,V,I> ifNull();
    public Level2MapEntriesKeySelectedOperator<K,V,I> ifNullOrTrue(final IFunction<Boolean, ? super K> eval);
    public Level2MapEntriesKeySelectedOperator<K,V,I> ifIndexNot(final int... indexes);
    public Level2MapEntriesKeySelectedOperator<K,V,I> ifNotNull();
    public Level2MapEntriesKeySelectedOperator<K,V,I> ifNotNullAndTrue(final IFunction<Boolean, ? super K> eval);

    
    public Level1MapEntriesOperator<K,V,I> endOn();
    
    public <X> Level2MapEntriesKeyOperator<X,V,I> asType(final Type<X> type);
    public Level2MapEntriesKeyOperator<?,V,I> asUnknown();

    public <X> Level2MapEntriesKeyOperator<X,V,I> exec(final IFunction<X, ? super K> function);
    
    public <X> Level2MapEntriesKeyOperator<X,V,I> execIfNotNull(final IFunction<X,? super K> function);
    
    public Level2MapEntriesKeyOperator<K,V,I> replaceWith(final K replacement);
    public Level2MapEntriesKeyOperator<K,V,I> replaceIfNullWith(final K replacement);


    }

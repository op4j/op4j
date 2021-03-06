/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
import org.op4j.operators.qualities.SelectableMapEntryComponentOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel2MapEntriesKeyOperator<I,K,V>
        extends UniqOperator<Map<K,V>>,
                NavigatingMapEntryOperator,
                CastableToTypeOperator<K>,
                ExecutableOperator<K>, 
                SelectableMapEntryComponentOperator<K> {



    public ILevel2MapEntriesKeySelectedOperator<I,K,V> ifTrue(final IFunction<? super K,Boolean> eval);
    public ILevel2MapEntriesKeySelectedOperator<I,K,V> ifFalse(final IFunction<? super K,Boolean> eval);
    public ILevel2MapEntriesKeySelectedOperator<I,K,V> ifNull();
    public ILevel2MapEntriesKeySelectedOperator<I,K,V> ifNotNull();

    
    public ILevel1MapEntriesOperator<I,K,V> endOn();
    
    public <X> ILevel2MapEntriesKeyOperator<I,X,V> castTo(final Type<X> type);
    

    public <X> ILevel2MapEntriesKeyOperator<I,X,V> exec(final IFunction<? super K,X> function);
    
    
    public ILevel2MapEntriesKeyOperator<I,K,V> execIfNotNull(final IFunction<? super K,? extends K> function);
    public ILevel2MapEntriesKeyOperator<I,K,V> execIfNull(final IFunction<? super K,? extends K> function);
    public ILevel2MapEntriesKeyOperator<I,K,V> execIfTrue(final IFunction<? super K, Boolean> eval, final IFunction<? super K,? extends K> function);
    public ILevel2MapEntriesKeyOperator<I,K,V> execIfFalse(final IFunction<? super K, Boolean> eval, final IFunction<? super K,? extends K> function);
    public <X> ILevel2MapEntriesKeyOperator<I,X,V> execIfNotNull(final IFunction<? super K,X> function, final IFunction<? super K,X> elseFunction);
    public <X> ILevel2MapEntriesKeyOperator<I,X,V> execIfNull(final IFunction<? super K,X> function, final IFunction<? super K,X> elseFunction);
    public <X> ILevel2MapEntriesKeyOperator<I,X,V> execIfTrue(final IFunction<? super K, Boolean> eval, final IFunction<? super K,X> function, final IFunction<? super K,X> elseFunction);
    public <X> ILevel2MapEntriesKeyOperator<I,X,V> execIfFalse(final IFunction<? super K, Boolean> eval, final IFunction<? super K,X> function, final IFunction<? super K,X> elseFunction);
    
    
    
    
    public ILevel2MapEntriesKeyOperator<I,K,V> replaceWith(final K replacement);
    public ILevel2MapEntriesKeyOperator<I,K,V> replaceIfNullWith(final K replacement);


    }

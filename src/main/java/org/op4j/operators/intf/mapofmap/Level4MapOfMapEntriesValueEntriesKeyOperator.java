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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
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
public interface Level4MapOfMapEntriesValueEntriesKeyOperator<K1,K2,V>
        extends UniqOperator<Map<K1,Map<K2,V>>>,
                NavigatingMapEntryOperator,
                CastableToTypeOperator<K2>,
                ExecutableOperator<K2>, 
                ReplaceableOperator<K2>,
                ReplaceableIfNullOperator<K2>,
                SelectableOperator<K2> {



    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1,K2,V> ifIndex(final int... indexes);
    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1,K2,V> ifTrue(final IFunction<Boolean, ? super K2> eval);
    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1,K2,V> ifFalse(final IFunction<Boolean, ? super K2> eval);
    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1,K2,V> ifNullOrFalse(final IFunction<Boolean, ? super K2> eval);
    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1,K2,V> ifNotNullAndFalse(final IFunction<Boolean, ? super K2> eval);
    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1,K2,V> ifNull();
    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1,K2,V> ifNullOrTrue(final IFunction<Boolean, ? super K2> eval);
    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1,K2,V> ifIndexNot(final int... indexes);
    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1,K2,V> ifNotNull();
    public Level4MapOfMapEntriesValueEntriesKeySelectedOperator<K1,K2,V> ifNotNullAndTrue(final IFunction<Boolean, ? super K2> eval);

    
    public Level3MapOfMapEntriesValueEntriesOperator<K1,K2,V> endOn();
    
    public <X> Level4MapOfMapEntriesValueEntriesKeyOperator<K1,X,V> asType(final Type<X> type);
    public Level4MapOfMapEntriesValueEntriesKeyOperator<K1,?,V> asUnknown();


    public <X> Level4MapOfMapEntriesValueEntriesKeyOperator<K1,X,V> exec(final IFunction<X, ? super K2> function);
    
    public <X> Level4MapOfMapEntriesValueEntriesKeyOperator<K1,X,V> execIfNotNull(final IFunction<X,? super K2> function);
    
    public Level4MapOfMapEntriesValueEntriesKeyOperator<K1,K2,V> replaceWith(final K2 replacement);
    public Level4MapOfMapEntriesValueEntriesKeyOperator<K1,K2,V> replaceIfNullWith(final K2 replacement);


    }

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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2MapOfSetEntriesKeyOperator<K,V>
        extends UniqOperator<Map<K,Set<V>>>,
                NavigatingMapEntryOperator,
                CastableToTypeOperator<K>,
                ExecutableOperator<K>, 
                SelectableOperator<K> {



    public Level2MapOfSetEntriesKeySelectedOperator<K,V> ifIndex(final int... indices);
    public Level2MapOfSetEntriesKeySelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super K> eval);
    public Level2MapOfSetEntriesKeySelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super K> eval);
    public Level2MapOfSetEntriesKeySelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval);
    public Level2MapOfSetEntriesKeySelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval);
    public Level2MapOfSetEntriesKeySelectedOperator<K,V> ifNull();
    public Level2MapOfSetEntriesKeySelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval);
    public Level2MapOfSetEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level2MapOfSetEntriesKeySelectedOperator<K,V> ifNotNull();
    public Level2MapOfSetEntriesKeySelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval);

    
    public Level1MapOfSetEntriesOperator<K,V> endOn();
    
    public <X> Level2MapOfSetEntriesKeyOperator<X,V> asType(final Type<X> type);
    public Level2MapOfSetEntriesKeyOperator<?,V> asUnknown();

    public <X> Level2MapOfSetEntriesKeyOperator<X,V> exec(final IFunction<X, ? super K> function);
    
    public <X> Level2MapOfSetEntriesKeyOperator<X,V> eval(final IEvaluator<X,? super K> eval);
    
    public Level2MapOfSetEntriesKeyOperator<K,V> replaceWith(final K replacement);
    public Level2MapOfSetEntriesKeyOperator<K,V> replaceIfNullWith(final K replacement);


    public <X> Level2MapOfSetEntriesKeyOperator<X,V> convert(final IConverter<X,? super K> converter);
    
        
}

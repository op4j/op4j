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
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ConvertibleOperator;
import org.op4j.operators.qualities.EvaluableOperator;
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
public interface Level2MapOfMapEntriesKeyOperator<K1,K2,V>
        extends UniqOperator<Map<K1,Map<K2,V>>>,
                NavigatingMapEntryOperator,
                CastableToTypeOperator<K1>,
                ExecutableOperator<K1>, 
                EvaluableOperator<K1>, 
                SelectableOperator<K1>,
                ConvertibleOperator<K1> {



    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V> ifIndex(final int... indices);
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V> ifNull();
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V> ifIndexNot(final int... indices);
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V> ifNotNull();
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K1> eval);

    
    public Level1MapOfMapEntriesOperator<K1,K2,V> endOn();
    
    public <X> Level2MapOfMapEntriesKeyOperator<X,K2,V> asType(final Type<X> type);
    public Level2MapOfMapEntriesKeyOperator<?,K2,V> asUnknown();

    public <X> Level2MapOfMapEntriesKeyOperator<X,K2,V> exec(final IFunction<X, ? super K1> function);
    
    public <X> Level2MapOfMapEntriesKeyOperator<X,K2,V> eval(final IEvaluator<X,? super K1> eval);
    
    public <X> Level2MapOfMapEntriesKeyOperator<X,K2,V> convert(final IConverter<X,? super K1> converter);
    
        
}
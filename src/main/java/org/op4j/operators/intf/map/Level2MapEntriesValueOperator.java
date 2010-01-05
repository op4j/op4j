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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.CastableToMapOperator;
import org.op4j.operators.qualities.CastableToSetOperator;
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
public interface Level2MapEntriesValueOperator<K,V>
        extends UniqOperator<Map<K,V>>,
                CastableToArrayOperator,
                CastableToListOperator,
                CastableToMapOperator,
                CastableToSetOperator,
				NavigatingMapEntryOperator,
                ConvertibleOperator<V>,
        		EvaluableOperator<V>,
        		ExecutableOperator<V>,
                SelectableOperator<V>,
                CastableToTypeOperator<V> {



    public Level2MapEntriesValueSelectedOperator<K,V> ifIndex(final int... indices);
    public Level2MapEntriesValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapEntriesValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapEntriesValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapEntriesValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapEntriesValueSelectedOperator<K,V> ifNull();
    public Level2MapEntriesValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level2MapEntriesValueSelectedOperator<K,V> ifNotNull();
    public Level2MapEntriesValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval);

    
    public Level1MapEntriesOperator<K,V> endOn();
    
    public <X> Level2MapEntriesValueOperator<K,X> convert(final IConverter<X,? super V> converter);
    
    public <X> Level2MapEntriesValueOperator<K,X> eval(final IEvaluator<X,? super V> eval);

    public <X> Level2MapEntriesValueOperator<K,X> exec(final IFunction<X, ? super V> function);
    
    public <X> Level2MapEntriesValueOperator<K,X> asType(final Type<X> type);
    public Level2MapEntriesValueOperator<K,?> asUnknown();
    
        
    public <X> Level2MapOfArrayEntriesValueOperator<K,X> asArrayOf(final Type<X> type);
    public <X> Level2MapOfListEntriesValueOperator<K,X> asListOf(final Type<X> type);
    public <K2,V2> Level2MapOfMapEntriesValueOperator<K,K2,V2> asMapOf(final Type<K2> keyType, final Type<V2> valueType);
    public <X> Level2MapOfSetEntriesValueOperator<K,X> asSetOf(final Type<X> type);
    public Level2MapOfArrayEntriesValueOperator<K,?> asArrayOfUnknown();
    public Level2MapOfListEntriesValueOperator<K,?> asListOfUnknown();
    public Level2MapOfMapEntriesValueOperator<K,?,?> asMapOfUnknown();
    public Level2MapOfSetEntriesValueOperator<K,?> asSetOfUnknown();
    

    
}
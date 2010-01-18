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
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level3MapOfSetEntriesValueElementsOperator<K,V>
        extends UniqOperator<Map<K,Set<V>>>,
                NavigatingCollectionOperator<V>,
        		ExecutableOperator<V>,
                SelectableOperator<V>,
                CastableToTypeOperator<V> {



    public Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> ifIndex(final int... indices);
    public Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> ifNull();
    public Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> ifNotNull();
    public Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);

    
    public Level2MapOfSetEntriesValueOperator<K,V> endFor();
    
    public <X> Level3MapOfSetEntriesValueElementsOperator<K,X> convert(final IConverter<X,? super V> converter);
    
    public <X> Level3MapOfSetEntriesValueElementsOperator<K,X> eval(final IEvaluator<X,? super V> eval);

    public <X> Level3MapOfSetEntriesValueElementsOperator<K,X> exec(final IFunction<X, ? super V> function);
    
    public <X> Level3MapOfSetEntriesValueElementsOperator<K,X> asType(final Type<X> type);
    public Level3MapOfSetEntriesValueElementsOperator<K,?> asUnknown();
    
        
    }

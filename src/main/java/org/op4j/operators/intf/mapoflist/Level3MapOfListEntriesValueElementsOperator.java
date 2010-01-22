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
package org.op4j.operators.intf.mapoflist;

import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
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
public interface Level3MapOfListEntriesValueElementsOperator<K,V,I>
        extends UniqOperator<Map<K,List<V>>,I>,
                NavigatingCollectionOperator<V,I>,
        		ExecutableOperator<V,I>,
                SelectableOperator<V,I>,
                ReplaceableOperator<V,I>,
                ReplaceableIfNullOperator<V,I>,
                CastableToTypeOperator<V,I> {



    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V,I> ifNull();
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V,I> ifNotNull();
    public Level3MapOfListEntriesValueElementsSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);

    
    public Level2MapOfListEntriesValueOperator<K,V,I> endFor();
    
    public Level3MapOfListEntriesValueElementsOperator<K,V,I> replaceWith(final V replacement);
    public Level3MapOfListEntriesValueElementsOperator<K,V,I> replaceIfNullWith(final V replacement);


    public <X> Level3MapOfListEntriesValueElementsOperator<K,X,I> convert(final IConverter<X,? super V> converter);
    
    public <X> Level3MapOfListEntriesValueElementsOperator<K,X,I> eval(final IEvaluator<X,? super V> eval);

    public <X> Level3MapOfListEntriesValueElementsOperator<K,X,I> exec(final IFunction<X, ? super V> function);
    
    public <X> Level3MapOfListEntriesValueElementsOperator<K,X,I> asType(final Type<X> type);
    public Level3MapOfListEntriesValueElementsOperator<K,?,I> asUnknown();
    
        
    }

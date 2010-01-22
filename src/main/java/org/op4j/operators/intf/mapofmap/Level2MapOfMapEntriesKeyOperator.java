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
public interface Level2MapOfMapEntriesKeyOperator<K1,K2,V,I>
        extends UniqOperator<Map<K1,Map<K2,V>>,I>,
                NavigatingMapEntryOperator<I>,
                CastableToTypeOperator<K1,I>,
                ExecutableOperator<K1,I>, 
                ReplaceableOperator<K1,I>,
                ReplaceableIfNullOperator<K1,I>,
                SelectableOperator<K1,I> {



    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V,I> ifIndex(final int... indices);
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V,I> ifTrue(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V,I> ifFalse(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V,I> ifNull();
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super K1> eval);
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V,I> ifIndexNot(final int... indices);
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V,I> ifNotNull();
    public Level2MapOfMapEntriesKeySelectedOperator<K1,K2,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K1> eval);

    
    public Level1MapOfMapEntriesOperator<K1,K2,V,I> endOn();
    
    public <X> Level2MapOfMapEntriesKeyOperator<X,K2,V,I> asType(final Type<X> type);
    public Level2MapOfMapEntriesKeyOperator<?,K2,V,I> asUnknown();


    public <X> Level2MapOfMapEntriesKeyOperator<X,K2,V,I> exec(final IFunction<X, ? super K1> function);
    
    public <X> Level2MapOfMapEntriesKeyOperator<X,K2,V,I> eval(final IEvaluator<X,? super K1> eval);
    
    public Level2MapOfMapEntriesKeyOperator<K1,K2,V,I> replaceWith(final K1 replacement);
    public Level2MapOfMapEntriesKeyOperator<K1,K2,V,I> replaceIfNullWith(final K1 replacement);


    public <X> Level2MapOfMapEntriesKeyOperator<X,K2,V,I> convert(final IConverter<X,? super K1> converter);
    
        
}

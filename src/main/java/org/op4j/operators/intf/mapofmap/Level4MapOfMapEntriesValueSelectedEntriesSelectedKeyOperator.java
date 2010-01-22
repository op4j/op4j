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

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
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
public interface Level4MapOfMapEntriesValueSelectedEntriesSelectedKeyOperator<K1,K2,V,I>
        extends UniqOperator<Map<K1,Map<K2,V>>,I>,
                NavigatingMapEntryOperator<I>,
                ExecutableSelectedOperator<K2,I>,
                ReplaceableOperator<K2,I>,
                SelectableOperator<K2,I> {



    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifIndex(final int... indices);
    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifTrue(final IEvaluator<Boolean, ? super K2> eval);
    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifFalse(final IEvaluator<Boolean, ? super K2> eval);
    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super K2> eval);
    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K2> eval);
    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifNull();
    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super K2> eval);
    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifIndexNot(final int... indices);
    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifNotNull();
    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K2> eval);

    
    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V,I> endOn();

    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeyOperator<K1,K2,V,I> replaceWith(final K2 replacement);


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeyOperator<K1,K2,V,I> exec(final IFunction<? extends K2, ? super K2> function);
    
    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeyOperator<K1,K2,V,I> eval(final IEvaluator<? extends K2,? super K2> eval);
    
    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeyOperator<K1,K2,V,I> convert(final IConverter<? extends K2,? super K2> converter);

        
}

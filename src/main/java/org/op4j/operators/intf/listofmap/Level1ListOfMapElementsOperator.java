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
package org.op4j.operators.intf.listofmap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.qualities.CastableToMapOperator;
import org.op4j.operators.qualities.ExecutableMapOperator;
import org.op4j.operators.qualities.ExtractableMapOperator;
import org.op4j.operators.qualities.ModifiableMapOperator;
import org.op4j.operators.qualities.NavigableMapOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.Operator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1ListOfMapElementsOperator<K,V,I>
        extends UniqOperator<List<Map<K,V>>,I>,
                NavigableMapOperator<K,V,I>,
		        CastableToMapOperator<I>,
                NavigatingCollectionOperator<Map<K,V>,I>,
		        SortableOperator<Map.Entry<K,V>,I>,
                ExecutableMapOperator<K,V,I>,
                ModifiableMapOperator<K,V,I>,
                SelectableOperator<Map<K,V>,I>,
                ReplaceableOperator<Map<K,V>,I>,
                ReplaceableIfNullOperator<Map<K,V>,I>,
                ExtractableMapOperator<K,V,I> {



    public Level1ListOfMapElementsSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level1ListOfMapElementsSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ListOfMapElementsSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ListOfMapElementsSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ListOfMapElementsSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ListOfMapElementsSelectedOperator<K,V,I> ifNull();
    public Level1ListOfMapElementsSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ListOfMapElementsSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level1ListOfMapElementsSelectedOperator<K,V,I> ifNotNull();
    public Level1ListOfMapElementsSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);


    
    public Level2ListOfMapElementsEntriesOperator<K,V,I> forEachEntry();
    
    public Level0ListOfMapOperator<K,V,I> endFor();
    
    public Level1ListOfMapElementsOperator<K,V,I> sort();
    public Level1ListOfMapElementsOperator<K,V,I> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public Level1ListOfMapElementsOperator<K,V,I> put(final K newKey, final V newValue);
    public Level1ListOfMapElementsOperator<K,V,I> insert(final int position, final K newKey, final V newValue);
    public Level1ListOfMapElementsOperator<K,V,I> putAll(final Map<K,V> map);
    public Level1ListOfMapElementsOperator<K,V,I> insertAll(final int position, final Map<K,V> map);
    public Level1ListOfMapElementsOperator<K,V,I> removeAllKeys(final K... keys);
    public Level1ListOfMapElementsOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1ListOfMapElementsOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1ListOfMapElementsOperator<K,V,I> removeAllKeysNot(final K... keys);
    
    
    public Level1ListOfSetElementsOperator<K,I> extractKeys();
    public Level1ListOfListElementsOperator<V,I> extractValues();
    
    
    
    
    
    public Level1ListOfMapElementsOperator<K,V,I> replaceWith(final Map<K,V> replacement);
    public Level1ListOfMapElementsOperator<K,V,I> replaceIfNullWith(final Map<K,V> replacement);


    public <X,Y> Level1ListOfMapElementsOperator<X,Y,I> convert(final IConverter<? extends Map<X,Y>,? super Map<K,V>> converter);
    
    public <X,Y> Level1ListOfMapElementsOperator<X,Y,I> eval(final IEvaluator<? extends Map<X,Y>,? super Map<K,V>> eval);

    public <X,Y> Level1ListOfMapElementsOperator<X,Y,I> exec(final IFunction<? extends Map<X,Y>,? super Map<K,V>> function);

    public <X> Level1ListElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K,V>> function);
    
    public <X> Level1ListElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map<K,V>> eval);
    
    public <X> Level1ListElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super Map<K,V>> converter);    
    
    
    public <X,Y> Level1ListOfMapElementsOperator<X,Y,I> asMapOf(final Type<X> keyType, final Type<Y> valueType);
    public Operator asMapOfUnknown();
    
    
}

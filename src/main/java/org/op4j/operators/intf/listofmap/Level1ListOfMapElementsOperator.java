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
public interface Level1ListOfMapElementsOperator<K,V>
        extends UniqOperator<List<Map<K,V>>>,
                NavigableMapOperator<K,V>,
		        CastableToMapOperator,
                NavigatingCollectionOperator<Map<K,V>>,
		        SortableOperator<Map.Entry<K,V>>,
                ExecutableMapOperator<K,V>,
                ModifiableMapOperator<K,V>,
                SelectableOperator<Map<K,V>>,
                ReplaceableOperator<Map<K,V>>,
                ReplaceableIfNullOperator<Map<K,V>>,
                ExtractableMapOperator<K,V> {



    public Level1ListOfMapElementsSelectedOperator<K,V> ifIndex(final int... indexes);
    public Level1ListOfMapElementsSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ListOfMapElementsSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ListOfMapElementsSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ListOfMapElementsSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ListOfMapElementsSelectedOperator<K,V> ifNull();
    public Level1ListOfMapElementsSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1ListOfMapElementsSelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level1ListOfMapElementsSelectedOperator<K,V> ifNotNull();
    public Level1ListOfMapElementsSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);


    
    public Level2ListOfMapElementsEntriesOperator<K,V> forEachEntry();
    
    public Level0ListOfMapOperator<K,V> endFor();
    
    public Level1ListOfMapElementsOperator<K,V> sort();
    public Level1ListOfMapElementsOperator<K,V> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public Level1ListOfMapElementsOperator<K,V> put(final K newKey, final V newValue);
    public Level1ListOfMapElementsOperator<K,V> insert(final int position, final K newKey, final V newValue);
    public Level1ListOfMapElementsOperator<K,V> putAll(final Map<K,V> map);
    public Level1ListOfMapElementsOperator<K,V> insertAll(final int position, final Map<K,V> map);
    public Level1ListOfMapElementsOperator<K,V> removeAllKeys(final K... keys);
    public Level1ListOfMapElementsOperator<K,V> removeAllTrue(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1ListOfMapElementsOperator<K,V> removeAllFalse(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1ListOfMapElementsOperator<K,V> removeAllKeysNot(final K... keys);
    
    
    public Level1ListOfSetElementsOperator<K> extractKeys();
    public Level1ListOfListElementsOperator<V> extractValues();
    
    
    
    
    
    public Level1ListOfMapElementsOperator<K,V> replaceWith(final Map<K,V> replacement);
    public Level1ListOfMapElementsOperator<K,V> replaceIfNullWith(final Map<K,V> replacement);


    public <X,Y> Level1ListOfMapElementsOperator<X,Y> convert(final IConverter<? extends Map<X,Y>,? super Map<K,V>> converter);
    
    public <X,Y> Level1ListOfMapElementsOperator<X,Y> eval(final IEvaluator<? extends Map<X,Y>,? super Map<K,V>> eval);

    public <X,Y> Level1ListOfMapElementsOperator<X,Y> exec(final IFunction<? extends Map<X,Y>,? super Map<K,V>> function);

    public <X> Level1ListElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K,V>> function);
    
    public <X> Level1ListElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map<K,V>> eval);
    
    public <X> Level1ListElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super Map<K,V>> converter);    
    
    
    public <X,Y> Level1ListOfMapElementsOperator<X,Y> asMapOf(final Type<X> keyType, final Type<Y> valueType);
    public Operator asMapOfUnknown();
    
    
}

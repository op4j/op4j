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
package org.op4j.operators.intf.setofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
import org.op4j.operators.qualities.CastableToMapOperator;
import org.op4j.operators.qualities.ExecutableMapOperator;
import org.op4j.operators.qualities.ExtractableMapOperator;
import org.op4j.operators.qualities.ModifiableMapOperator;
import org.op4j.operators.qualities.NavigableMapOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
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
public interface Level1SetOfMapElementsOperator<K,V>
        extends UniqOperator<Set<Map<K,V>>>,
                NavigableMapOperator<K,V>,
                NavigatingCollectionOperator<Map<K,V>>,
		        SortableOperator<Map.Entry<K,V>>,
		        CastableToMapOperator,
                ExecutableMapOperator<K,V>,
                ModifiableMapOperator<K,V>,
                SelectableOperator<Map<K,V>>,
                ExtractableMapOperator<K,V> {



    public Level1SetOfMapElementsSelectedOperator<K,V> ifIndex(final int... indices);
    public Level1SetOfMapElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1SetOfMapElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1SetOfMapElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1SetOfMapElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1SetOfMapElementsSelectedOperator<K,V> ifNull();
    public Level1SetOfMapElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level1SetOfMapElementsSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level1SetOfMapElementsSelectedOperator<K,V> ifNotNull();
    public Level1SetOfMapElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);


    
    public Level2SetOfMapElementsEntriesOperator<K,V> forEachEntry();
    
    public Level0SetOfMapOperator<K,V> endFor();
    
    public Level1SetOfMapElementsOperator<K,V> sort();
    public Level1SetOfMapElementsOperator<K,V> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public Level1SetOfMapElementsOperator<K,V> put(final K newKey, final V newValue);
    public Level1SetOfMapElementsOperator<K,V> insert(final int position, final K newKey, final V newValue);
    public Level1SetOfMapElementsOperator<K,V> putAll(final Map<K,V> map);
    public Level1SetOfMapElementsOperator<K,V> insertAll(final int position, final Map<K,V> map);
    public Level1SetOfMapElementsOperator<K,V> removeKeys(final K... keys);
    public Level1SetOfMapElementsOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1SetOfMapElementsOperator<K,V> removeNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level1SetOfMapElementsOperator<K,V> removeKeysNot(final K... keys);
    
    
    public Level1SetOfSetElementsOperator<K> extractKeys();
    public Level1SetOfListElementsOperator<V> extractValues();
    
    

    
    
    
    public <X,Y> Level1SetOfMapElementsOperator<X,Y> convert(final IConverter<? extends Map<X,Y>,? super Map<K,V>> converter);
    
    public <X,Y> Level1SetOfMapElementsOperator<X,Y> eval(final IEvaluator<? extends Map<X,Y>,? super Map<K,V>> eval);

    public <X,Y> Level1SetOfMapElementsOperator<X,Y> exec(final IFunction<? extends Map<X,Y>,? super Map<K,V>> function);

    public <X> Level1SetElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K,V>> function);
    
    public <X> Level1SetElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map<K,V>> eval);
    
    public <X> Level1SetElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super Map<K,V>> converter);    

    
    
    
    public <X,Y> Level1SetOfMapElementsOperator<X,Y> asMapOf(final Type<X> keyType, final Type<Y> valueType);
    public Level1SetOfMapElementsOperator<?,?> asMapOfUnknown();
    
    
}

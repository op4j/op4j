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

import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.CastableToMapOfArrayOperator;
import org.op4j.operators.qualities.CastableToMapOfListOperator;
import org.op4j.operators.qualities.CastableToMapOfMapOperator;
import org.op4j.operators.qualities.CastableToMapOfSetOperator;
import org.op4j.operators.qualities.CastableToMapOperator;
import org.op4j.operators.qualities.ExecutableMapOperator;
import org.op4j.operators.qualities.ExtractableMapOperator;
import org.op4j.operators.qualities.GenerizableOperator;
import org.op4j.operators.qualities.ModifiableMapOperator;
import org.op4j.operators.qualities.NavigableMapOperator;
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
public interface Level0MapOperator<K,V,I>
        extends UniqOperator<Map<K,V>,I>,
                NavigableMapOperator<K,V,I>,
                CastableToMapOperator<I>,
                CastableToMapOfArrayOperator<I>,
                CastableToMapOfListOperator<I>,
                CastableToMapOfMapOperator<I>,
                CastableToMapOfSetOperator<I>,
		        SortableOperator<Map.Entry<K,V>,I>,
                ExecutableMapOperator<K,V,I>,
                ModifiableMapOperator<K,V,I>,
                ExtractableMapOperator<K,V,I>,
                SelectableOperator<Map<K,V>,I>,
                ReplaceableOperator<Map<K,V>,I>,
                ReplaceableIfNullOperator<Map<K,V>,I>,
                GenerizableOperator<Map<K,V>,I> {



    public Level0MapSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level0MapSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V,I> ifNull();
    public Level0MapSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0MapSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level0MapSelectedOperator<K,V,I> ifNotNull();
    public Level0MapSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);


    
    public Level1MapEntriesOperator<K,V,I> forEachEntry();
    
    public Level0MapOperator<K,V,I> sort();
    public Level0MapOperator<K,V,I> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public Level0MapOperator<K,V,I> put(final K newKey, final V newValue);
    public Level0MapOperator<K,V,I> insert(final int position, final K newKey, final V newValue);
    public Level0MapOperator<K,V,I> putAll(final Map<K,V> map);
    public Level0MapOperator<K,V,I> insertAll(final int position, final Map<K,V> map);
    public Level0MapOperator<K,V,I> removeAllKeys(final K... keys);
    public Level0MapOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level0MapOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public Level0MapOperator<K,V,I> removeAllKeysNot(final K... keys);
    
    
    public Level0SetOperator<K,I> extractKeys();
    public Level0ListOperator<V,I> extractValues();
    
    
    
    public Level0GenericUniqOperator<Map<K,V>,I> generic();

    
    
    
    public Level0MapOperator<K,V,I> replaceWith(final Map<K,V> replacement);
    public Level0MapOperator<K,V,I> replaceIfNullWith(final Map<K,V> replacement);


    public <X,Y> Level0MapOperator<X,Y,I> convert(final IConverter<? extends Map<X,Y>,? super Map<K,V>> converter);
    
    public <X,Y> Level0MapOperator<X,Y,I> eval(final IEvaluator<? extends Map<X,Y>,? super Map<K,V>> eval);

    public <X,Y> Level0MapOperator<X,Y,I> exec(final IFunction<? extends Map<X,Y>, ? super Map<K,V>> function);

    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K,V>> function);
    
    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map<K,V>> eval);
    
    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super Map<K,V>> converter);    

    
    
    public <X,Y> Level0MapOfArrayOperator<X,Y,I> asMapOfArrayOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0MapOfArrayOperator<?,?,I> asMapOfArrayOfUnknown();

    
    public <X,Y> Level0MapOfListOperator<X,Y,I> asMapOfListOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0MapOfListOperator<?,?,I> asMapOfListOfUnknown();
    
    
    public <X1,X2,Y> Level0MapOfMapOperator<X1,X2,Y,I> asMapOfMapOf(final Type<X1> key1Type, final Type<X2> key2Type, final Type<Y> valueType);
    public Level0MapOfMapOperator<?,?,?,I> asMapOfMapOfUnknown();

    
    public <X,Y> Level0MapOfSetOperator<X,Y,I> asMapOfSetOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0MapOfSetOperator<?,?,I> asMapOfSetOfUnknown();

    
    public <X,Y> Level0MapOperator<X,Y,I> asMapOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0MapOperator<?,?,I> asMapOfUnknown();
    
    
}

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

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.CastableToMapOfListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToMapOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToMapOfSetOperator;
import org.op4j.operators.qualities.ExecutableMapOfListOperator;
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
public interface Level0MapOfListOperator<K,V,I>
        extends UniqOperator<Map<K,List<V>>,I>,
                NavigableMapOperator<K,List<V>,I>,
		        SortableOperator<Map.Entry<K,List<V>>,I>,
                CastableToMapOfListOperator<I>,
		        ModifiableMapOperator<K,List<V>,I>,
                ExtractableMapOperator<K,List<V>,I>,
		        GenerizableOperator<Map<K,List<V>>,I>,
                ExecutableMapOfListOperator<K,V,I>,
                SelectableOperator<Map<K,List<V>>,I>,
                ReplaceableOperator<Map<K,List<V>>,I>,
                ReplaceableIfNullOperator<Map<K,List<V>>,I>,
                ConvertibleToMapOfArrayOperator<K,V,I>,
                ConvertibleToMapOfSetOperator<K,V,I>,
                ConvertibleToMapOfMapOperator<K,V,I> {



    public Level0MapOfListSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level0MapOfListSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Map<K,List<V>>> eval);
    public Level0MapOfListSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Map<K,List<V>>> eval);
    public Level0MapOfListSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K,List<V>>> eval);
    public Level0MapOfListSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,List<V>>> eval);
    public Level0MapOfListSelectedOperator<K,V,I> ifNull();
    public Level0MapOfListSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K,List<V>>> eval);
    public Level0MapOfListSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level0MapOfListSelectedOperator<K,V,I> ifNotNull();
    public Level0MapOfListSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,List<V>>> eval);


    
    public Level1MapOfListEntriesOperator<K,V,I> forEachEntry();
    
    public Level0MapOfListOperator<K,V,I> sort();
    public Level0MapOfListOperator<K,V,I> sort(final Comparator<? super Map.Entry<K,List<V>>> comparator);
    
    public Level0MapOfListOperator<K,V,I> put(final K newKey, final List<V> newValue);
    public Level0MapOfListOperator<K,V,I> insert(final int position, final K newKey, final List<V> newValue);
    public Level0MapOfListOperator<K,V,I> putAll(final Map<K,List<V>> map);
    public Level0MapOfListOperator<K,V,I> insertAll(final int position, final Map<K,List<V>> map);
    public Level0MapOfListOperator<K,V,I> removeAllKeys(final K... keys);
    public Level0MapOfListOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super Map.Entry<K,List<V>>> eval);
    public Level0MapOfListOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super Map.Entry<K,List<V>>> eval);
    public Level0MapOfListOperator<K,V,I> removeAllKeysNot(final K... keys);
    
    public Level0MapOfArrayOperator<K,V,I> toMapOfArray(final Type<V> of);
    
    
    public Level0MapOfSetOperator<K,V,I> toMapOfSet();
    
    public <K2> Level0MapOfMapOperator<K,K2,V,I> toMapOfMap(final IEvaluator<K2,? super V> keyEval);
    public <K2,V2> Level0MapOfMapOperator<K,K2,V2,I> toMapOfMap(final IMapBuilder<K2,V2,? super V> mapBuild);
    

    
    public Level0SetOperator<K,I> extractKeys();
    public Level0ListOfListOperator<V,I> extractValues();
    

    
    public Level0GenericUniqOperator<Map<K,List<V>>,I> generic();
    
    
    public Level0MapOfListOperator<K,V,I> replaceWith(final Map<K,List<V>> replacement);
    public Level0MapOfListOperator<K,V,I> replaceIfNullWith(final Map<K,List<V>> replacement);


    public <X,Y> Level0MapOfListOperator<X,Y,I> convert(final IConverter<? extends Map<X,? extends List<Y>>,? super Map<K,List<V>>> converter);
    
    public <X,Y> Level0MapOfListOperator<X,Y,I> eval(final IEvaluator<? extends Map<X,? extends List<Y>>,? super Map<K,List<V>>> eval);

    public <X,Y> Level0MapOfListOperator<X,Y,I> exec(final IFunction<? extends Map<X,? extends List<Y>>, ? super Map<K,List<V>>> function);

    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K,List<V>>> function);
    
    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map<K,List<V>>> eval);
    
    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super Map<K,List<V>>> converter);    
    
    
    public <X,Y> Level0MapOfListOperator<X,Y,I> asMapOfListOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0MapOfListOperator<?,?,I> asMapOfListOfUnknown();
    
    
}

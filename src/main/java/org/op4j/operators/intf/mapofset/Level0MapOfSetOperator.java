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

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.CastableToMapOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToMapOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToMapOfListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOfMapOperator;
import org.op4j.operators.qualities.ExecutableMapOfSetOperator;
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
public interface Level0MapOfSetOperator<K,V>
        extends UniqOperator<Map<K,Set<V>>>,
                NavigableMapOperator<K,Set<V>>,
		        SortableOperator<Map.Entry<K,Set<V>>>,
                CastableToMapOfSetOperator,
		        ModifiableMapOperator<K,Set<V>>,
                ExtractableMapOperator<K,Set<V>>,
		        GenerizableOperator<Map<K,Set<V>>>,
                ExecutableMapOfSetOperator<K,V>,
                SelectableOperator<Map<K,Set<V>>>,
                ReplaceableOperator<Map<K,Set<V>>>,
                ReplaceableIfNullOperator<Map<K,Set<V>>>,
                ConvertibleToMapOfArrayOperator<K,V>,
                ConvertibleToMapOfListOperator<K,V>,
                ConvertibleToMapOfMapOperator<K,V> {



    public Level0MapOfSetSelectedOperator<K,V> ifIndex(final int... indices);
    public Level0MapOfSetSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Map<K,Set<V>>> eval);
    public Level0MapOfSetSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Map<K,Set<V>>> eval);
    public Level0MapOfSetSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K,Set<V>>> eval);
    public Level0MapOfSetSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,Set<V>>> eval);
    public Level0MapOfSetSelectedOperator<K,V> ifNull();
    public Level0MapOfSetSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K,Set<V>>> eval);
    public Level0MapOfSetSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level0MapOfSetSelectedOperator<K,V> ifNotNull();
    public Level0MapOfSetSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,Set<V>>> eval);


    
    public Level1MapOfSetEntriesOperator<K,V> forEachEntry();
    
    public Level0MapOfSetOperator<K,V> sort();
    public Level0MapOfSetOperator<K,V> sort(final Comparator<? super Map.Entry<K,Set<V>>> comparator);
    
    public Level0MapOfSetOperator<K,V> put(final K newKey, final Set<V> newValue);
    public Level0MapOfSetOperator<K,V> insert(final int position, final K newKey, final Set<V> newValue);
    public Level0MapOfSetOperator<K,V> putAll(final Map<K,Set<V>> map);
    public Level0MapOfSetOperator<K,V> insertAll(final int position, final Map<K,Set<V>> map);
    public Level0MapOfSetOperator<K,V> removeAllKeys(final K... keys);
    public Level0MapOfSetOperator<K,V> removeAllTrue(final IEvaluator<Boolean, ? super Map.Entry<K,Set<V>>> eval);
    public Level0MapOfSetOperator<K,V> removeAllFalse(final IEvaluator<Boolean, ? super Map.Entry<K,Set<V>>> eval);
    public Level0MapOfSetOperator<K,V> removeAllKeysNot(final K... keys);
    
    public Level0MapOfArrayOperator<K,V> toMapOfArray(final Type<V> of);
    
    
    public Level0MapOfListOperator<K,V> toMapOfList();
    
    public <K2> Level0MapOfMapOperator<K,K2,V> toMapOfMap(final IEvaluator<K2,? super V> keyEval);
    public <K2,V2> Level0MapOfMapOperator<K,K2,V2> toMapOfMap(final IMapBuilder<K2,V2,? super V> mapBuild);
    
    
    public Level0SetOperator<K> extractKeys();
    public Level0ListOfSetOperator<V> extractValues();
    


    
    public Level0GenericUniqOperator<Map<K,Set<V>>> generic();

    
    
    public Level0MapOfSetOperator<K,V> replaceBy(final Map<K,Set<V>> replacement);
    public Level0MapOfSetOperator<K,V> replaceIfNullBy(final Map<K,Set<V>> replacement);


    public <X,Y> Level0MapOfSetOperator<X,Y> convert(final IConverter<? extends Map<X,? extends Set<Y>>,? super Map<K,Set<V>>> converter);
    
    public <X,Y> Level0MapOfSetOperator<X,Y> eval(final IEvaluator<? extends Map<X,? extends Set<Y>>,? super Map<K,Set<V>>> eval);

    public <X,Y> Level0MapOfSetOperator<X,Y> exec(final IFunction<? extends Map<X,? extends Set<Y>>, ? super Map<K,Set<V>>> function);

    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K,Set<V>>> function);
    
    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map<K,Set<V>>> eval);
    
    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super Map<K,Set<V>>> converter);    
    
    
    public <X,Y> Level0MapOfSetOperator<X,Y> asMapOfSetOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0MapOfSetOperator<?,?> asMapOfSetOfUnknown();

    
}

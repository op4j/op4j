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

import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.CastableToMapOfMapOperator;
import org.op4j.operators.qualities.ExecutableMapOfMapOperator;
import org.op4j.operators.qualities.ExtractableMapOperator;
import org.op4j.operators.qualities.GenerizableOperator;
import org.op4j.operators.qualities.ModifiableMapOperator;
import org.op4j.operators.qualities.NavigableMapOperator;
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
public interface Level0MapOfMapOperator<K1,K2,V>
        extends UniqOperator<Map<K1,Map<K2,V>>>,
                NavigableMapOperator<K1,Map<K2,V>>,
		        SortableOperator<Map.Entry<K1,Map<K2,V>>>,
                CastableToMapOfMapOperator,
                ExecutableMapOfMapOperator<K1,K2,V>,
		        ModifiableMapOperator<K1,Map<K2,V>>,
                ExtractableMapOperator<K1,Map<K2,V>>,
                SelectableOperator<Map<K1,Map<K2,V>>>,
                GenerizableOperator<Map<K1,Map<K2,V>>> {



    public Level0MapOfMapSelectedOperator<K1,K2,V> ifIndex(final int... indices);
    public Level0MapOfMapSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super Map<K1,Map<K2,V>>> eval);
    public Level0MapOfMapSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super Map<K1,Map<K2,V>>> eval);
    public Level0MapOfMapSelectedOperator<K1,K2,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K1,Map<K2,V>>> eval);
    public Level0MapOfMapSelectedOperator<K1,K2,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K1,Map<K2,V>>> eval);
    public Level0MapOfMapSelectedOperator<K1,K2,V> ifNull();
    public Level0MapOfMapSelectedOperator<K1,K2,V> ifNullOrMatching(final IEvaluator<Boolean, ? super Map<K1,Map<K2,V>>> eval);
    public Level0MapOfMapSelectedOperator<K1,K2,V> ifIndexNot(final int... indices);
    public Level0MapOfMapSelectedOperator<K1,K2,V> ifNotNull();
    public Level0MapOfMapSelectedOperator<K1,K2,V> ifNotNullMatching(final IEvaluator<Boolean, ? super Map<K1,Map<K2,V>>> eval);


    
    public Level1MapOfMapEntriesOperator<K1,K2,V> forEachEntry();
    
    public Level0MapOfMapOperator<K1,K2,V> sort();
    public Level0MapOfMapOperator<K1,K2,V> sort(final Comparator<? super Map.Entry<K1,Map<K2,V>>> comparator);
        
    public Level0MapOfMapOperator<K1,K2,V> put(final K1 newKey, final Map<K2,V> newValue);
    public Level0MapOfMapOperator<K1,K2,V> insert(final int position, final K1 newKey, final Map<K2,V> newValue);
    public Level0MapOfMapOperator<K1,K2,V> putAll(final Map<K1,Map<K2,V>> map);
    public Level0MapOfMapOperator<K1,K2,V> insertAll(final int position, final Map<K1,Map<K2,V>> map);
    public Level0MapOfMapOperator<K1,K2,V> removeKeys(final K1... keys);
    public Level0MapOfMapOperator<K1,K2,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K1,Map<K2,V>>> eval);
    public Level0MapOfMapOperator<K1,K2,V> removeNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K1,Map<K2,V>>> eval);
    public Level0MapOfMapOperator<K1,K2,V> removeKeysNot(final K1... keys);
    
    
    public Level0SetOperator<K1> extractKeys();
    public Level0ListOfMapOperator<K2,V> extractValues();
    
    
    
    
    public Level0GenericUniqOperator<Map<K1,Map<K2,V>>> generic();
    

    
    
    public <X1,X2,Y> Level0MapOfMapOperator<X1,X2,Y> convert(final IConverter<? extends Map<X1,? extends Map<X2,Y>>,? super Map<K1,Map<K2,V>>> converter);
    
    public <X1,X2,Y> Level0MapOfMapOperator<X1,X2,Y> eval(final IEvaluator<? extends Map<X1,? extends Map<X2,Y>>,? super Map<K1,Map<K2,V>>> eval);

    public <X1,X2,Y> Level0MapOfMapOperator<X1,X2,Y> exec(final IFunction<? extends Map<X1,? extends Map<X2,Y>>, ? super Map<K1,Map<K2,V>>> function);

    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K1,Map<K2,V>>> function);
    
    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map<K1,Map<K2,V>>> eval);
    
    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super Map<K1,Map<K2,V>>> converter);    
    
    
    public <X1,X2,Y> Level0MapOfMapOperator<X1,X2,Y> asMapOfMapOf(final Type<X1> key1Type, final Type<X2> key2Type, final Type<Y> valueType);
    public Level0MapOfMapOperator<?,?,?> asMapOfMapOfUnknown();

    
}

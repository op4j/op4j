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
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.ICastableToMapOfSetOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfArrayOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfListOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfMapOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IExtractableMapOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableMapOperator;
import org.op4j.operators.qualities.INavigableMapOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.ITypeParameterizableXYOperator;
import org.op4j.operators.qualities.IUniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0MapOfSetOperator<K,V>
		extends IUniqOperator<Map<K,Set<V>>>,
		        INavigableMapOperator<K,Set<V>>,
		        ISortableOperator<Map.Entry<K,Set<V>>>,
                ITypeParameterizableXYOperator<K,V>,
                ICastableToMapOfSetOperator,
		        IModifiableMapOperator<K,Set<V>>,
                IExtractableMapOperator<K,Set<V>>,
		        IGenerizableOperator<Map<K,Set<V>>>,
                IExecutableOperator<Map<K,Set<V>>>,
                IConvertibleOperator<Map<K,Set<V>>>,
                IEvaluableOperator<Map<K,Set<V>>>,
                IConvertibleToMapOfArrayOperator<K,V>,
                IConvertibleToMapOfListOperator<K,V>,
                IConvertibleToMapOfMapOperator<K,V> {

    
    public ILevel1MapOfSetEntriesOperator<K,V> forEachEntry();
    
    public ILevel0MapOfSetOperator<K,V> sort();
    public ILevel0MapOfSetOperator<K,V> sort(final Comparator<? super Map.Entry<K,Set<V>>> comparator);
    
    public <X,Y> ILevel0MapOfSetOperator<X,Y> of(final Type<X> ofX, final Type<Y> ofY);
        
    public ILevel0MapOfSetOperator<?,?> raw();
    
    public ILevel0MapOfSetOperator<K,V> put(final K newKey, final Set<V> newValue);
    public ILevel0MapOfSetOperator<K,V> insert(final int position, final K newKey, final Set<V> newValue);
    public ILevel0MapOfSetOperator<K,V> putAll(final Map<K,Set<V>> map);
    public ILevel0MapOfSetOperator<K,V> insertAll(final int position, final Map<K,Set<V>> map);
    public ILevel0MapOfSetOperator<K,V> removeKeys(final K... keys);
    public ILevel0MapOfSetOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K,Set<V>>> eval);
    public ILevel0MapOfSetOperator<K,V> removeNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K,Set<V>>> eval);
    public ILevel0MapOfSetOperator<K,V> removeKeysNot(final K... keys);
    
    public ILevel0MapOfArrayOperator<K,V> toMapOfArray(final Type<V> of);
    
    
    public ILevel0MapOfListOperator<K,V> toMapOfList();
    
    public <K2> ILevel0MapOfMapOperator<K,K2,V> toMapOfMap(final IEvaluator<K2,? super V> keyEval);
    public <K2,V2> ILevel0MapOfMapOperator<K,K2,V2> toMapOfMap(final IMapBuilder<K2,V2,? super V> mapBuild);
    
    
    public ILevel0SetOperator<K> extractKeys();
    public ILevel0ListOfSetOperator<V> extractValues();
    
    
    public ILevel1MapOfSetEntriesOperator<K,V> forEachEntryWithKeys(final K... keys);
    public ILevel1MapOfSetEntriesOperator<K,V> forEachEntryMatching(final IEvaluator<Boolean, ? super Map.Entry<K,Set<V>>> eval);
    public ILevel1MapOfSetEntriesOperator<K,V> forEachEntryWithKeysNot(final K... keys);
    


    
    public ILevel0GenericUniqOperator<Map<K,Set<V>>> generic();

    
    
    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X,? super Map<K,Set<V>>> converter);
    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X,? super Map<K,Set<V>>> eval);

    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K,Set<V>>> function);
    
    
    public <X,Y> ILevel0MapOfSetOperator<X,Y> asMapOfSet(final Type<X> keyOf, final Type<Y> valueOf);
    public ILevel0MapOfSetOperator<?,?> asMapOfSetOfUnknown();

    
}

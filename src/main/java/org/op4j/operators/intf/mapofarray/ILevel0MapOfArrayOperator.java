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
package org.op4j.operators.intf.mapofarray;

import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.ICastableToMapOfArrayOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfListOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfMapOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfSetOperator;
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
public interface ILevel0MapOfArrayOperator<K,V>
		extends IUniqOperator<Map<K,V[]>>,
		        INavigableMapOperator<K,V[]>,
		        ISortableOperator<Map.Entry<K,V[]>>,
                ITypeParameterizableXYOperator<K,V>,
                ICastableToMapOfArrayOperator,
		        IModifiableMapOperator<K,V[]>,
		        IExtractableMapOperator<K,V[]>,
		        IGenerizableOperator<Map<K,V[]>>,
                IExecutableOperator<Map<K,V[]>>,
                IConvertibleOperator<Map<K,V[]>>,
                IEvaluableOperator<Map<K,V[]>>,
		        IConvertibleToMapOfListOperator<K,V>,
		        IConvertibleToMapOfSetOperator<K,V>,
		        IConvertibleToMapOfMapOperator<K,V> {

    
    public ILevel1MapOfArrayEntriesOperator<K,V> forEachEntry();
    
    public ILevel0MapOfArrayOperator<K,V> sort();
    public ILevel0MapOfArrayOperator<K,V> sort(final Comparator<? super Map.Entry<K,V[]>> comparator);
    
    public <X,Y> ILevel0MapOfArrayOperator<X,Y> of(final Type<X> ofX, final Type<Y> ofY);
        
    public ILevel0MapOfArrayOperator<?,?> raw();
    
    public ILevel0MapOfArrayOperator<K,V> put(final K newKey, final V[] newValue);
    public ILevel0MapOfArrayOperator<K,V> insert(final int position, final K newKey, final V[] newValue);
    public ILevel0MapOfArrayOperator<K,V> putAll(final Map<K,V[]> map);
    public ILevel0MapOfArrayOperator<K,V> insertAll(final int position, final Map<K,V[]> map);
    public ILevel0MapOfArrayOperator<K,V> removeKeys(final K... keys);
    public ILevel0MapOfArrayOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V[]>> eval);
    public ILevel0MapOfArrayOperator<K,V> removeNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V[]>> eval);
    public ILevel0MapOfArrayOperator<K,V> removeKeysNot(final K... keys);
    
    public ILevel0MapOfListOperator<K,V> toMapOfList();
    
    public ILevel0MapOfSetOperator<K,V> toMapOfSet();
    
    public <K2> ILevel0MapOfMapOperator<K,K2,V> toMapOfMap(final IEvaluator<K2,? super V> keyEval);
    public <K2,V2> ILevel0MapOfMapOperator<K,K2,V2> toMapOfMap(final IMapBuilder<K2,V2,? super V> mapBuild);
    

    
    public ILevel0SetOperator<K> extractKeys();
    public ILevel0ListOfArrayOperator<V> extractValues();
    

    
    public ILevel1MapOfArrayEntriesOperator<K,V> forEachEntryWithKeys(final K... keys);
    public ILevel1MapOfArrayEntriesOperator<K,V> forEachEntryMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V[]>> eval);
    public ILevel1MapOfArrayEntriesOperator<K,V> forEachEntryWithKeysNot(final K... keys);
    
    
    public ILevel0GenericUniqOperator<Map<K,V[]>> generic();
    

    
    
    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X,? super Map<K,V[]>> converter);
    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X,? super Map<K,V[]>> eval);

    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K,V[]>> function);
    
    
    
    public <X,Y> ILevel0MapOfArrayOperator<X,Y> asMapOfArray(final Type<X> keyOf, final Type<Y> valueOf);
    public ILevel0MapOfArrayOperator<?,?> asMapOfArrayOfUnknown();

    
}

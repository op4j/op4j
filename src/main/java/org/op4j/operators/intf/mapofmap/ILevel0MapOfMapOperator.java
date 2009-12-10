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
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.ICastableToMapOfMapOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IExtractableMapOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableMapOperator;
import org.op4j.operators.qualities.INavigableMapOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.IUniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0MapOfMapOperator<K1,K2,V>
		extends IUniqOperator<Map<K1,Map<K2,V>>>,
		        INavigableMapOperator<K1,Map<K2,V>>,
		        ISortableOperator<Map.Entry<K1,Map<K2,V>>>,
                ICastableToMapOfMapOperator,
                IExecutableOperator<Map<K1,Map<K2,V>>>,
                IConvertibleOperator<Map<K1,Map<K2,V>>>,
                IEvaluableOperator<Map<K1,Map<K2,V>>>,
		        IModifiableMapOperator<K1,Map<K2,V>>,
                IExtractableMapOperator<K1,Map<K2,V>>,
		        IGenerizableOperator<Map<K1,Map<K2,V>>> {

    
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntry();
    
    public ILevel0MapOfMapOperator<K1,K2,V> sort();
    public ILevel0MapOfMapOperator<K1,K2,V> sort(final Comparator<? super Map.Entry<K1,Map<K2,V>>> comparator);
        
    public ILevel0MapOfMapOperator<K1,K2,V> put(final K1 newKey, final Map<K2,V> newValue);
    public ILevel0MapOfMapOperator<K1,K2,V> insert(final int position, final K1 newKey, final Map<K2,V> newValue);
    public ILevel0MapOfMapOperator<K1,K2,V> putAll(final Map<K1,Map<K2,V>> map);
    public ILevel0MapOfMapOperator<K1,K2,V> insertAll(final int position, final Map<K1,Map<K2,V>> map);
    public ILevel0MapOfMapOperator<K1,K2,V> removeKeys(final K1... keys);
    public ILevel0MapOfMapOperator<K1,K2,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K1,Map<K2,V>>> eval);
    public ILevel0MapOfMapOperator<K1,K2,V> removeNotMatching(final IEvaluator<Boolean, ? super Map.Entry<K1,Map<K2,V>>> eval);
    public ILevel0MapOfMapOperator<K1,K2,V> removeKeysNot(final K1... keys);
    
    
    public ILevel0SetOperator<K1> extractKeys();
    public ILevel0ListOfMapOperator<K2,V> extractValues();
    
    
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntryWithKeys(final K1... keys);
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntryMatching(final IEvaluator<Boolean, ? super Map.Entry<K1,Map<K2,V>>> eval);
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntryWithKeysNot(final K1... keys);
    

    
    
    public ILevel0GenericUniqOperator<Map<K1,Map<K2,V>>> generic();
    

    
    
    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X,? super Map<K1,Map<K2,V>>> converter);
    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X,? super Map<K1,Map<K2,V>>> eval);

    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K1,Map<K2,V>>> function);
    
    
    public <X1,X2,Y> ILevel0MapOfMapOperator<X1,X2,Y> asMapOfMapOf(final Type<X1> key1Type, final Type<X2> key2Type, final Type<Y> valueType);
    public ILevel0MapOfMapOperator<?,?,?> asMapOfMapOfUnknown();

    
}

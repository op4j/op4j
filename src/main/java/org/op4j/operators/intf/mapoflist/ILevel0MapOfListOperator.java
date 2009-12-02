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
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfArrayOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfMapOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfSetOperator;
import org.op4j.operators.qualities.IExtractableMapOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableMapOperator;
import org.op4j.operators.qualities.INavigableMapOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.ITypeParameterizableXYOperator;
import org.op4j.operators.qualities.IUniqOperator;
import org.op4j.select.ISelector;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0MapOfListOperator<K,V>
		extends IUniqOperator<Map<K,List<V>>>,
		        INavigableMapOperator<K,List<V>>,
		        ISortableOperator<Map.Entry<K,List<V>>>,
                ITypeParameterizableXYOperator<K,V>,
		        IModifiableMapOperator<K,List<V>>,
                IExtractableMapOperator<K,List<V>>,
		        IGenerizableOperator<Map<K,List<V>>>,
                IConvertibleToMapOfArrayOperator<K,V>,
                IConvertibleToMapOfSetOperator<K,V>,
                IConvertibleToMapOfMapOperator<K,V> {

    
    public ILevel1MapOfListEntriesOperator<K,V> forEachEntry();
    
    public ILevel0MapOfListOperator<K,V> sort();
    public ILevel0MapOfListOperator<K,V> sort(final Comparator<? super Map.Entry<K,List<V>>> comparator);
    
    public <X,Y> ILevel0MapOfListOperator<X,Y> of(final Type<X> ofX, final Type<Y> ofY);
        
    public ILevel0MapOfListOperator<?,?> raw();
    
    public ILevel0MapOfListOperator<K,V> put(final K newKey, final List<V> newValue);
    public ILevel0MapOfListOperator<K,V> insert(final int position, final K newKey, final List<V> newValue);
    public ILevel0MapOfListOperator<K,V> putAll(final Map<K,List<V>> map);
    public ILevel0MapOfListOperator<K,V> insertAll(final int position, final Map<K,List<V>> map);
    public ILevel0MapOfListOperator<K,V> removeKeys(final K... keys);
    public ILevel0MapOfListOperator<K,V> removeMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0MapOfListOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K,List<V>>> eval);
    public ILevel0MapOfListOperator<K,V> removeSelected(final ISelector<Map.Entry<K,List<V>>> selector);
    public ILevel0MapOfListOperator<K,V> removeKeysNot(final K... keys);
    
    public ILevel0MapOfArrayOperator<K,V> toMapOfArray(final Type<V> of);
    
    
    public ILevel0MapOfSetOperator<K,V> toMapOfSet();
    
    public <K2> ILevel0MapOfMapOperator<K,K2,V> toMapOfMap(final IEvaluator<K2,? super V> keyEval);
    public <K2,V2> ILevel0MapOfMapOperator<K,K2,V2> toMapOfMap(final IMapBuilder<K2,V2,? super V> mapBuild);
    

    
    public ILevel0SetOperator<K> extractKeys();
    public ILevel0ListOfListOperator<V> extractValues();
    
    
    public ILevel1MapOfListEntriesOperator<K,V> forEachEntryWithKeys(final K... keys);
    public ILevel1MapOfListEntriesOperator<K,V> forEachEntryMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1MapOfListEntriesOperator<K,V> forEachEntryMatching(final IEvaluator<Boolean, ? super Map.Entry<K,List<V>>> eval);
    public ILevel1MapOfListEntriesOperator<K,V> forEachEntrySelected(final ISelector<Map.Entry<K,List<V>>> selector);
    public ILevel1MapOfListEntriesOperator<K,V> forEachEntryWithKeysNot(final K... keys);
    

    
    public ILevel0GenericUniqOperator<Map<K,List<V>>> generic();
    
    
}

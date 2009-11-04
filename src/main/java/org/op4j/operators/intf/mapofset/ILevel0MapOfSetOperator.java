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

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfArrayOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfListOperator;
import org.op4j.operators.qualities.IConvertibleToMapOfMapOperator;
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
		        IModifiableMapOperator<K,Set<V>>,
                IExtractableMapOperator<K,Set<V>>,
		        IGenerizableOperator<Map<K,Set<V>>>,
                IConvertibleToMapOfArrayOperator<K,V>,
                IConvertibleToMapOfListOperator<K,V>,
                IConvertibleToMapOfMapOperator<K,V> {

    
    public ILevel1MapOfSetEntriesOperator<K,V> forEachEntry();
    
    public ILevel0MapOfSetOperator<K,V> sort();
    public ILevel0MapOfSetOperator<K,V> sort(final Comparator<? super Map.Entry<K,Set<V>>> comparator);
    
    public <X,Y> ILevel0MapOfSetOperator<X,Y> of(final Of<X> ofX, final Of<Y> ofY);
    public <X,Y> ILevel0MapOfSetOperator<X,Y> of(final Class<X> ofXClass, final Class<Y> ofYClass);
    
    public ILevel0MapOfSetOperator<?,?> raw();
    
    public ILevel0MapOfSetOperator<K,V> put(final K newKey, final Set<V> newValue);
    public ILevel0MapOfSetOperator<K,V> put(final int position, final K newKey, final Set<V> newValue);
    public ILevel0MapOfSetOperator<K,V> putAll(final Map<K,Set<V>> map);
    public ILevel0MapOfSetOperator<K,V> remove(final K key);
    public ILevel0MapOfSetOperator<K,V> removeAll(final K... keys);
    public ILevel0MapOfSetOperator<K,V> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel0MapOfSetOperator<K,V> removeAll(final ISelect<Map.Entry<K,Set<V>>> selector);
    public ILevel0MapOfSetOperator<K,V> removeAllBut(final K... keys);
    public ILevel0MapOfSetOperator<K,V> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0MapOfSetOperator<K,V> removeAllBut(final ISelect<Map.Entry<K,Set<V>>> selector);
    
    public <X> ILevel0MapOfArrayOperator<K,X> toMapOfArray(final Of<X> of);
    public <X> ILevel0MapOfArrayOperator<K,X> toMapOfArray(final Class<X> ofClass);
    
    public ILevel0MapOfListOperator<K,V> toMapOfList();
    
    public <K2> ILevel0MapOfMapOperator<K,K2,V> toMapOfMap(final IEval<K2,? super V> keyEval);
    public <K2,V2> ILevel0MapOfMapOperator<K,K2,V2> toMapOfMap(final IMapBuild<K2,V2,? super V> mapBuild);
    
    
    public ILevel0MapOfSetOperator<K,V> extract(final K key);
    public ILevel0MapOfSetOperator<K,V> extractAll(final K... keys);
    public ILevel0MapOfSetOperator<K,V> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel0MapOfSetOperator<K,V> extractAll(final ISelect<Map.Entry<K,Set<V>>> selector);
    public ILevel0MapOfSetOperator<K,V> extractAllBut(final K... keys);
    public ILevel0MapOfSetOperator<K,V> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0MapOfSetOperator<K,V> extractAllBut(final ISelect<Map.Entry<K,Set<V>>> selector);
    
    public ILevel0SetOperator<K> extractKeys();
    public ILevel0ListOfSetOperator<V> extractValues();
    
    
    public ILevel1MapOfSetEntriesOperator<K,V> forEachEntryWithKeys(final K... keys);
    public ILevel1MapOfSetEntriesOperator<K,V> forEachEntry(final String expression, final Object... optionalExpParams);
    public ILevel1MapOfSetEntriesOperator<K,V> forEachEntry(final ISelect<Map.Entry<K,Set<V>>> selector);
    public ILevel1MapOfSetEntriesOperator<K,V> forEachEntryWithKeysNot(final K... keys);
    public ILevel1MapOfSetEntriesOperator<K,V> forEachEntryNot(final String expression, final Object... optionalExpParams);
    public ILevel1MapOfSetEntriesOperator<K,V> forEachEntryNot(final ISelect<Map.Entry<K,Set<V>>> selector);
    


    
    
}

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

import org.op4j.Of;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.IExtractableMapOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableMapOperator;
import org.op4j.operators.qualities.INavigableMapOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.ITypeParameterizableXYZOperator;
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
                ITypeParameterizableXYZOperator<K1,K2,V>,
		        IModifiableMapOperator<K1,Map<K2,V>>,
                IExtractableMapOperator<K1,Map<K2,V>>,
		        IGenerizableOperator<Map<K1,Map<K2,V>>> {

    
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntry();
    
    public ILevel0MapOfMapOperator<K1,K2,V> sort();
    public ILevel0MapOfMapOperator<K1,K2,V> sort(final Comparator<? super Map.Entry<K1,Map<K2,V>>> comparator);
    
    public <X,Y,Z> ILevel0MapOfMapOperator<X,Y,Z> of(final Of<X> ofX, final Of<Y> ofY, final Of<Z> ofZ);
    public <X,Y,Z> ILevel0MapOfMapOperator<X,Y,Z> of(final Class<X> ofXClass, final Class<Y> ofYClass, final Class<Z> ofZClass);
    
    public ILevel0MapOfMapOperator<?,?,?> raw();
    
    public ILevel0MapOfMapOperator<K1,K2,V> put(final K1 newKey, final Map<K2,V> newValue);
    public ILevel0MapOfMapOperator<K1,K2,V> put(final int position, final K1 newKey, final Map<K2,V> newValue);
    public ILevel0MapOfMapOperator<K1,K2,V> putAll(final Map<K1,Map<K2,V>> map);
    public ILevel0MapOfMapOperator<K1,K2,V> putAll(final int position, final Map<K1,Map<K2,V>> map);
    public ILevel0MapOfMapOperator<K1,K2,V> remove(final K1 key);
    public ILevel0MapOfMapOperator<K1,K2,V> removeAllWithKeys(final K1... keys);
    public ILevel0MapOfMapOperator<K1,K2,V> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel0MapOfMapOperator<K1,K2,V> removeAll(final ISelect<Map.Entry<K1,Map<K2,V>>> selector);
    public ILevel0MapOfMapOperator<K1,K2,V> removeAllWithKeysNot(final K1... keys);
    public ILevel0MapOfMapOperator<K1,K2,V> removeAllNot(final String expression, final Object... optionalExpParams);
    public ILevel0MapOfMapOperator<K1,K2,V> removeAllNot(final ISelect<Map.Entry<K1,Map<K2,V>>> selector);
    
    
    public ILevel0MapOfMapOperator<K1,K2,V> extract(final K1 key);
    public ILevel0MapOfMapOperator<K1,K2,V> extractAll(final K1... keys);
    public ILevel0MapOfMapOperator<K1,K2,V> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel0MapOfMapOperator<K1,K2,V> extractAll(final ISelect<Map.Entry<K1,Map<K2,V>>> selector);
    public ILevel0MapOfMapOperator<K1,K2,V> extractAllBut(final K1... keys);
    public ILevel0MapOfMapOperator<K1,K2,V> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0MapOfMapOperator<K1,K2,V> extractAllBut(final ISelect<Map.Entry<K1,Map<K2,V>>> selector);
    
    public ILevel0SetOperator<K1> extractKeys();
    public ILevel0ListOfMapOperator<K2,V> extractValues();
    
    
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntryWithKeys(final K1... keys);
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntry(final String expression, final Object... optionalExpParams);
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntry(final ISelect<Map.Entry<K1,Map<K2,V>>> selector);
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntryWithKeysNot(final K1... keys);
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntryNot(final String expression, final Object... optionalExpParams);
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntryNot(final ISelect<Map.Entry<K1,Map<K2,V>>> selector);
    
    
}

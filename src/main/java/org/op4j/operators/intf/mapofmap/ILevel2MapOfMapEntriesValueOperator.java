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
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.operators.qualities.IExtractableMapOperator;
import org.op4j.operators.qualities.IModifiableMapOperator;
import org.op4j.operators.qualities.INavigableMapOperator;
import org.op4j.operators.qualities.INavigatingMapEntryOperator;
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
public interface ILevel2MapOfMapEntriesValueOperator<K1,K2,V>
		extends IUniqOperator<Map<K1,Map<K2,V>>>,
		        INavigableMapOperator<K2,V>,
		        INavigatingMapEntryOperator,
		        ISortableOperator<Map.Entry<K2,V>>,
                ITypeParameterizableXYOperator<K2,V>,
                IModifiableMapOperator<K2,V>,
                IExtractableMapOperator<K2,V> {
    
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> forEachEntry();
    
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> endOn();
    
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> sort();
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> sort(final Comparator<? super Map.Entry<K2,V>> comparator);
    
    public <X,Y> ILevel2MapOfMapEntriesValueOperator<K1,X,Y> of(final Of<X> ofX, final Of<Y> ofY);
    
    public <X,Y> ILevel2MapOfMapEntriesValueOperator<K1,X,Y> of(final Class<X> classOfX, final Class<Y> classOfY);
    
    public ILevel2MapOfMapEntriesValueOperator<K1,?,?> raw();
    
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> put(final K2 newKey, final V newValue);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> put(final int position, final K2 newKey, final V newValue);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> putAll(final Map<K2,V> map);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> remove(final K2 key);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> removeAll(final K2... keys);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> removeAll(final ISelect<Map.Entry<K2,V>> selector);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> removeAllBut(final K2... keys);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> removeAllBut(final ISelect<Map.Entry<K2,V>> selector);
    
    
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> extract(final K2 key);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> extractAll(final K2... keys);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> extractAll(final ISelect<Map.Entry<K2,V>> selector);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> extractAllBut(final K2... keys);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> extractAllBut(final ISelect<Map.Entry<K2,V>> selector);
    
    public ILevel2MapOfSetEntriesValueOperator<K1,K2> extractKeys();
    public ILevel2MapOfListEntriesValueOperator<K1,V> extractValues();
    
    
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> forEachEntryWithKeys(final K2... keys);
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> forEachEntry(final String expression, final Object... optionalExpParams);
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> forEachEntry(final ISelect<Map.Entry<K2,V>> selector);
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> forEachEntryWithKeysNot(final K2... keys);
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> forEachEntryNot(final String expression, final Object... optionalExpParams);
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> forEachEntryNot(final ISelect<Map.Entry<K2,V>> selector);
    
                                    
}

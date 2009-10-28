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
package org.op4j.operators.intf.arrayofmap;

import java.util.Comparator;
import java.util.Map;

import org.op4j.IOf;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.operators.qualities.IExtractableMapOperator;
import org.op4j.operators.qualities.IModifiableMapOperator;
import org.op4j.operators.qualities.INavigableMapOperator;
import org.op4j.operators.qualities.INavigatingCollectionOperator;
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
public interface ILevel1ArrayOfMapElementsOperator<K,V> 
		extends IUniqOperator<Map<K,V>[]>,
		        INavigableMapOperator<K,V>,
                INavigatingCollectionOperator<Map<K,V>>,
		        ISortableOperator<Map.Entry<K,V>>,
                ITypeParameterizableXYOperator<K,V>,
                IModifiableMapOperator<K,V>,
                IExtractableMapOperator<K,V> {

    
    public ILevel2ArrayOfMapElementsEntriesOperator<K,V> forEachEntry();
    
    public ILevel0ArrayOfMapOperator<K,V> endFor();
    
    public ILevel1ArrayOfMapElementsOperator<K,V> sort();
    public ILevel1ArrayOfMapElementsOperator<K,V> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public <X,Y> ILevel1ArrayOfMapElementsOperator<X,Y> of(final IOf<X> ofX, final IOf<Y> ofY);
    public <X,Y> ILevel1ArrayOfMapElementsOperator<X,Y> of(final Class<X> ofXClass, final Class<Y> ofYClass);
    
    public ILevel1ArrayOfMapElementsOperator<?,?> raw();
    
    public ILevel1ArrayOfMapElementsOperator<K,V> put(final K newKey, final V newValue);
    public ILevel1ArrayOfMapElementsOperator<K,V> put(final int position, final K newKey, final V newValue);
    public ILevel1ArrayOfMapElementsOperator<K,V> putAll(final Map<K,V> map);
    public ILevel1ArrayOfMapElementsOperator<K,V> remove(final K key);
    public ILevel1ArrayOfMapElementsOperator<K,V> removeAll(final K... keys);
    public ILevel1ArrayOfMapElementsOperator<K,V> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfMapElementsOperator<K,V> removeAll(final ISelect<Map.Entry<K,V>> selector);
    public ILevel1ArrayOfMapElementsOperator<K,V> removeAllBut(final K... keys);
    public ILevel1ArrayOfMapElementsOperator<K,V> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfMapElementsOperator<K,V> removeAllBut(final ISelect<Map.Entry<K,V>> selector);
    
    
    public ILevel1ArrayOfMapElementsOperator<K,V> extract(final K key);
    public ILevel1ArrayOfMapElementsOperator<K,V> extractAll(final K... keys);
    public ILevel1ArrayOfMapElementsOperator<K,V> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfMapElementsOperator<K,V> extractAll(final ISelect<Map.Entry<K,V>> selector);
    public ILevel1ArrayOfMapElementsOperator<K,V> extractAllBut(final K... keys);
    public ILevel1ArrayOfMapElementsOperator<K,V> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfMapElementsOperator<K,V> extractAllBut(final ISelect<Map.Entry<K,V>> selector);
    
    public ILevel1ArrayOfSetElementsOperator<K> extractKeys();
    public ILevel1ArrayOfListElementsOperator<V> extractValues();
    
    
    public ILevel2ArrayOfMapElementsEntriesOperator<K,V> forEachEntryWithKeys(final K... keys);
    public ILevel2ArrayOfMapElementsEntriesOperator<K,V> forEachEntry(final String expression, final Object... optionalExpParams);
    public ILevel2ArrayOfMapElementsEntriesOperator<K,V> forEachEntry(final ISelect<Map.Entry<K,V>> selector);
    public ILevel2ArrayOfMapElementsEntriesOperator<K,V> forEachEntryWithKeysNot(final K... keys);
    public ILevel2ArrayOfMapElementsEntriesOperator<K,V> forEachEntryNot(final String expression, final Object... optionalExpParams);
    public ILevel2ArrayOfMapElementsEntriesOperator<K,V> forEachEntryNot(final ISelect<Map.Entry<K,V>> selector);
    
                            
}

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
package org.op4j.op.intf.operators.listofmap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.op4j.op.intf.operators.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.op.intf.operators.listofset.ILevel1ListOfSetElementsOperator;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.parameters.ISelect;
import org.op4j.op.intf.qualities.IExtractableMapOperator;
import org.op4j.op.intf.qualities.IModifiableMapOperator;
import org.op4j.op.intf.qualities.INavigableMapOperator;
import org.op4j.op.intf.qualities.INavigatingCollectionOperator;
import org.op4j.op.intf.qualities.ISortableOperator;
import org.op4j.op.intf.qualities.ITypeParameterizableXYOperator;
import org.op4j.op.intf.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel1ListOfMapElementsOperator<K,V> 
		extends IUniqOperator<List<Map<K,V>>>,
		        INavigableMapOperator<K,V>,
                INavigatingCollectionOperator<Map<K,V>>,
		        ISortableOperator<Map.Entry<K,V>>,
                ITypeParameterizableXYOperator<K,V>,
                IModifiableMapOperator<K,V>,
                IExtractableMapOperator<K,V> {

    
    public ILevel2ListOfMapElementsEntriesOperator<K,V> forEachEntry();
    
    public ILevel0ListOfMapOperator<K,V> endFor();
    
    public ILevel1ListOfMapElementsOperator<K,V> sort();
    public ILevel1ListOfMapElementsOperator<K,V> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public <X,Y> ILevel1ListOfMapElementsOperator<X,Y> of(final IOf<X> ofX, final IOf<Y> ofY);
    public <X,Y> ILevel1ListOfMapElementsOperator<X,Y> of(final Class<X> ofXClass, final Class<Y> ofYClass);
    
    public ILevel1ListOfMapElementsOperator<?,?> raw();
    
    public ILevel1ListOfMapElementsOperator<K,V> put(final K newKey, final V newValue);
    public ILevel1ListOfMapElementsOperator<K,V> put(final int position, final K newKey, final V newValue);
    public ILevel1ListOfMapElementsOperator<K,V> putAll(final Map<K,V> map);
    public ILevel1ListOfMapElementsOperator<K,V> remove(final K key);
    public ILevel1ListOfMapElementsOperator<K,V> removeAll(final K... keys);
    public ILevel1ListOfMapElementsOperator<K,V> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfMapElementsOperator<K,V> removeAll(final ISelect<Map.Entry<K,V>> selector);
    public ILevel1ListOfMapElementsOperator<K,V> removeAllBut(final K... keys);
    public ILevel1ListOfMapElementsOperator<K,V> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfMapElementsOperator<K,V> removeAllBut(final ISelect<Map.Entry<K,V>> selector);
    
    
    public ILevel1ListOfMapElementsOperator<K,V> extract(final K key);
    public ILevel1ListOfMapElementsOperator<K,V> extractAll(final K... keys);
    public ILevel1ListOfMapElementsOperator<K,V> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfMapElementsOperator<K,V> extractAll(final ISelect<Map.Entry<K,V>> selector);
    public ILevel1ListOfMapElementsOperator<K,V> extractAllBut(final K... keys);
    public ILevel1ListOfMapElementsOperator<K,V> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfMapElementsOperator<K,V> extractAllBut(final ISelect<Map.Entry<K,V>> selector);
    
    public ILevel1ListOfSetElementsOperator<K> extractKeys();
    public ILevel1ListOfListElementsOperator<V> extractValues();
    
    
    public ILevel2ListOfMapElementsEntriesOperator<K,V> forEachEntryWithKeys(final K... keys);
    public ILevel2ListOfMapElementsEntriesOperator<K,V> forEachEntry(final String expression, final Object... optionalExpParams);
    public ILevel2ListOfMapElementsEntriesOperator<K,V> forEachEntry(final ISelect<Map.Entry<K,V>> selector);
    public ILevel2ListOfMapElementsEntriesOperator<K,V> forEachEntryWithKeysNot(final K... keys);
    public ILevel2ListOfMapElementsEntriesOperator<K,V> forEachEntryNot(final String expression, final Object... optionalExpParams);
    public ILevel2ListOfMapElementsEntriesOperator<K,V> forEachEntryNot(final ISelect<Map.Entry<K,V>> selector);
    
                                    
}

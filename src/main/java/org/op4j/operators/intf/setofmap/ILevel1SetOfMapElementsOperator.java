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
package org.op4j.operators.intf.setofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.executables.IEval;
import org.op4j.executables.ISelector;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
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
public interface ILevel1SetOfMapElementsOperator<K,V> 
		extends IUniqOperator<Set<Map<K,V>>>,
		        INavigableMapOperator<K,V>,
                INavigatingCollectionOperator<Map<K,V>>,
		        ISortableOperator<Map.Entry<K,V>>,
                ITypeParameterizableXYOperator<K,V>,
                IModifiableMapOperator<K,V>,
                IExtractableMapOperator<K,V> {

    
    public ILevel2SetOfMapElementsEntriesOperator<K,V> forEachEntry();
    
    public ILevel0SetOfMapOperator<K,V> endFor();
    
    public ILevel1SetOfMapElementsOperator<K,V> sort();
    public ILevel1SetOfMapElementsOperator<K,V> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public <X,Y> ILevel1SetOfMapElementsOperator<X,Y> of(final Type<X> ofX, final Type<Y> ofY);
        
    public ILevel1SetOfMapElementsOperator<?,?> raw();
    
    public ILevel1SetOfMapElementsOperator<K,V> put(final K newKey, final V newValue);
    public ILevel1SetOfMapElementsOperator<K,V> insert(final int position, final K newKey, final V newValue);
    public ILevel1SetOfMapElementsOperator<K,V> putAll(final Map<K,V> map);
    public ILevel1SetOfMapElementsOperator<K,V> insertAll(final int position, final Map<K,V> map);
    public ILevel1SetOfMapElementsOperator<K,V> removeKeys(final K... keys);
    public ILevel1SetOfMapElementsOperator<K,V> removeMatching(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfMapElementsOperator<K,V> removeMatching(final IEval<Boolean, ? super Map.Entry<K,V>> eval);
    public ILevel1SetOfMapElementsOperator<K,V> removeSelected(final ISelector<Map.Entry<K,V>> selector);
    public ILevel1SetOfMapElementsOperator<K,V> removeKeysNot(final K... keys);
    
    
    public ILevel1SetOfSetElementsOperator<K> extractKeys();
    public ILevel1SetOfListElementsOperator<V> extractValues();
    
    
    public ILevel2SetOfMapElementsEntriesOperator<K,V> forEachEntryWithKeys(final K... keys);
    public ILevel2SetOfMapElementsEntriesOperator<K,V> forEachEntryMatching(final String expression, final Object... optionalExpParams);
    public ILevel2SetOfMapElementsEntriesOperator<K,V> forEachEntryMatching(final IEval<Boolean, ? super Map.Entry<K,V>> eval);
    public ILevel2SetOfMapElementsEntriesOperator<K,V> forEachEntrySelected(final ISelector<Map.Entry<K,V>> selector);
    public ILevel2SetOfMapElementsEntriesOperator<K,V> forEachEntryWithKeysNot(final K... keys);
    
                                    
}

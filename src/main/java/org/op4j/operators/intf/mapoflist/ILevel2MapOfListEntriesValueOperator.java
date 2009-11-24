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

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.mapofarray.ILevel2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOperator;
import org.op4j.operators.qualities.IDistinguishableOperator;
import org.op4j.operators.qualities.IExtractableCollectionOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
import org.op4j.operators.qualities.INavigatingMapEntryOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel2MapOfListEntriesValueOperator<K,V>
		extends IUniqOperator<Map<K,List<V>>>,
		        INavigableCollectionOperator<V>,
		        INavigatingMapEntryOperator,
		        IDistinguishableOperator,
		        ISortableOperator<V>,
                ITypeParameterizableXOperator<V>,
                IModifiableCollectionOperator<V>,
                IExtractableCollectionOperator<V>,
                IConvertibleToArrayOperator<V>,
                IConvertibleToSetOperator,
                IConvertibleToMapOperator<V> {
    
    public ILevel3MapOfListEntriesValueElementsOperator<K,V> forEach();
    
    public ILevel1MapOfListEntriesOperator<K,V> endOn();

    public ILevel2MapOfListEntriesValueOperator<K,V> distinct();
    
    public ILevel2MapOfListEntriesValueOperator<K,V> sort();
    public ILevel2MapOfListEntriesValueOperator<K,V> sort(final Comparator<? super V> comparator);
    
    public <X> ILevel2MapOfListEntriesValueOperator<K,X> of(final Type<X> of);
    
        
    public ILevel2MapOfListEntriesValueOperator<K,?> raw();
    public ILevel2MapOfListEntriesValueOperator<K,V> add(final V... newElements);
    public ILevel2MapOfListEntriesValueOperator<K,V> insert(final int position, final V... newElements);
    public ILevel2MapOfListEntriesValueOperator<K,V> addAll(final Collection<V> collection);
    public ILevel2MapOfListEntriesValueOperator<K,V> removePositions(final int... positions);
    public ILevel2MapOfListEntriesValueOperator<K,V> removeValues(final V... values);
    public ILevel2MapOfListEntriesValueOperator<K,V> removeMatching(final String expression, final Object... optionalExpParams);
    public ILevel2MapOfListEntriesValueOperator<K,V> removeSelected(final ISelect<V> selector);
    public ILevel2MapOfListEntriesValueOperator<K,V> removeAllExceptPositions(final int... positions);
    public ILevel2MapOfListEntriesValueOperator<K,V> removeNulls();
    public ILevel2MapOfListEntriesValueOperator<K,V> removeNotNullsMatching(final String expression, final Object... optionalExpParams);
    
    public ILevel2MapOfArrayEntriesValueOperator<K,V> toArray(final Type<V> of);
    
    
    public ILevel2MapOfSetEntriesValueOperator<K,V> toSet();
    
    public ILevel2MapOfMapEntriesValueOperator<K,V,V> toMap();
    public <K2> ILevel2MapOfMapEntriesValueOperator<K,K2,V> toMap(final IEval<K2,? super V> keyEval);
    public <K2,V2> ILevel2MapOfMapEntriesValueOperator<K,K2,V2> toMap(final IMapBuild<K2,V2,? super V> mapBuild);

    
    public ILevel2MapOfListEntriesValueOperator<K,V> extract(final int position);
    public ILevel2MapOfListEntriesValueOperator<K,V> extract(final V value);
    public ILevel2MapOfListEntriesValueOperator<K,V> extractAll(final int... positions);
    public ILevel2MapOfListEntriesValueOperator<K,V> extractAll(final V... values);
    public ILevel2MapOfListEntriesValueOperator<K,V> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel2MapOfListEntriesValueOperator<K,V> extractAll(final ISelect<V> selector);
    public ILevel2MapOfListEntriesValueOperator<K,V> extractAllBut(final int... positions);
    public ILevel2MapOfListEntriesValueOperator<K,V> extractAllBut(final V... values);
    public ILevel2MapOfListEntriesValueOperator<K,V> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel2MapOfListEntriesValueOperator<K,V> extractAllBut(final ISelect<V> selector);
    

    
    public ILevel3MapOfListEntriesValueElementsOperator<K,V> forEach(final int... positions);
    public ILevel3MapOfListEntriesValueElementsOperator<K,V> forEach(final String expression, final Object... optionalExpParams);
    public ILevel3MapOfListEntriesValueElementsOperator<K,V> forEach(final ISelect<V> selector);
    public ILevel3MapOfListEntriesValueElementsOperator<K,V> forEachNull();
    public ILevel3MapOfListEntriesValueElementsOperator<K,V> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel3MapOfListEntriesValueElementsOperator<K,V> forEachNot(final int... positions);
    public ILevel3MapOfListEntriesValueElementsOperator<K,V> forEachNotNull();
    public ILevel3MapOfListEntriesValueElementsOperator<K,V> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    
    
    
                                    
}

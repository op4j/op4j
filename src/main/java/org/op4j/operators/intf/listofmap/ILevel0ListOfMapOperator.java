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
package org.op4j.operators.intf.listofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.op4j.IOf;
import org.op4j.commands.ISelect;
import org.op4j.operators.qualities.IDistinguishableOperator;
import org.op4j.operators.qualities.IExtractableCollectionOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
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
public interface ILevel0ListOfMapOperator<K,V> 
		extends IUniqOperator<List<Map<K,V>>>,
		        INavigableCollectionOperator<Map<K,V>>,
		        IDistinguishableOperator,
		        ISortableOperator<Map<K,V>>,
                ITypeParameterizableXYOperator<K,V>,
		        IModifiableCollectionOperator<Map<K,V>>,
		        IExtractableCollectionOperator<Map<K,V>>,
		        IGenerizableOperator<List<Map<K,V>>> {


    public ILevel1ListOfMapElementsOperator<K,V> forEach();

    public ILevel0ListOfMapOperator<K,V> distinct();
    
    public ILevel0ListOfMapOperator<K,V> sort();
    public ILevel0ListOfMapOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator);
    
    public <X,Y> ILevel0ListOfMapOperator<X,Y> of(final IOf<X> ofX, final IOf<Y> ofY);
    public <X,Y> ILevel0ListOfMapOperator<X,Y> of(final Class<X> ofXClass, final Class<Y> ofYClass);
    
    public ILevel0ListOfMapOperator<?,?> raw();
    
    public ILevel0ListOfMapOperator<K,V> add(final Map<K,V> newElement);
    public ILevel0ListOfMapOperator<K,V> add(final int position, final Map<K,V> newElement);
    public ILevel0ListOfMapOperator<K,V> addAll(final Map<K,V>... newElements);
    public ILevel0ListOfMapOperator<K,V> addAll(final Collection<Map<K,V>> collection);
    public ILevel0ListOfMapOperator<K,V> remove(final int position);
    public ILevel0ListOfMapOperator<K,V> remove(final Map<K,V> value);
    public ILevel0ListOfMapOperator<K,V> removeAll(final int... positions);
    public ILevel0ListOfMapOperator<K,V> removeAll(final Map<K,V>... values);
    public ILevel0ListOfMapOperator<K,V> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel0ListOfMapOperator<K,V> removeAll(final ISelect<Map<K,V>> selector);
    public ILevel0ListOfMapOperator<K,V> removeAllBut(final int... positions);
    public ILevel0ListOfMapOperator<K,V> removeAllBut(final Map<K,V>... values);
    public ILevel0ListOfMapOperator<K,V> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0ListOfMapOperator<K,V> removeAllBut(final ISelect<Map<K,V>> selector);
    
    
    public ILevel0ListOfMapOperator<K,V> extract(final int position);
    public ILevel0ListOfMapOperator<K,V> extract(final Map<K,V> value);
    public ILevel0ListOfMapOperator<K,V> extractAll(final int... positions);
    public ILevel0ListOfMapOperator<K,V> extractAll(final Map<K,V>... values);
    public ILevel0ListOfMapOperator<K,V> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel0ListOfMapOperator<K,V> extractAll(final ISelect<Map<K,V>> selector);
    public ILevel0ListOfMapOperator<K,V> extractAllBut(final int... positions);
    public ILevel0ListOfMapOperator<K,V> extractAllBut(final Map<K,V>... values);
    public ILevel0ListOfMapOperator<K,V> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0ListOfMapOperator<K,V> extractAllBut(final ISelect<Map<K,V>> selector);

    
    public ILevel1ListOfMapElementsOperator<K,V> forEach(final int... positions);
    public ILevel1ListOfMapElementsOperator<K,V> forEach(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfMapElementsOperator<K,V> forEach(final ISelect<Map<K,V>> selector);
    public ILevel1ListOfMapElementsOperator<K,V> forEachNull();
    public ILevel1ListOfMapElementsOperator<K,V> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfMapElementsOperator<K,V> forEachNullOrNot(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfMapElementsOperator<K,V> forEachNot(final int... positions);
    public ILevel1ListOfMapElementsOperator<K,V> forEachNot(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfMapElementsOperator<K,V> forEachNot(final ISelect<Map<K,V>> selector);
    public ILevel1ListOfMapElementsOperator<K,V> forEachNotNull();
    public ILevel1ListOfMapElementsOperator<K,V> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfMapElementsOperator<K,V> forEachNotNullAndNot(final String expression, final Object... optionalExpParams);
    
    
}
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
package org.op4j.operators.intf.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.commands.IEval;
import org.op4j.op.intf.parameters.IMapBuild;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.parameters.ISelect;
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOperator;
import org.op4j.operators.qualities.IConvertibleToListOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
import org.op4j.operators.qualities.IExtractableCollectionOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
import org.op4j.operators.qualities.INavigatingCollectionOperator;
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
public interface ILevel1SetOfSetElementsOperator<T> 
		extends IUniqOperator<Set<Set<T>>>,
		        INavigableCollectionOperator<T>,
		        INavigatingCollectionOperator<Set<T>>,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IModifiableCollectionOperator<T>,
                IExtractableCollectionOperator<T>,
                IConvertibleToArrayOperator,
                IConvertibleToListOperator,
                IConvertibleToMapOperator<T> {

    
    public ILevel2SetOfSetElementsElementsOperator<T> forEach();
    
    public ILevel0SetOfSetOperator<T> endFor();
    
    public ILevel1SetOfSetElementsOperator<T> sort();
    public ILevel1SetOfSetElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel1SetOfSetElementsOperator<X> of(final IOf<X> of);
    public <X> ILevel1SetOfSetElementsOperator<X> of(final Class<X> ofClass);
    
    public ILevel1SetOfSetElementsOperator<?> raw();
    
    public ILevel1SetOfSetElementsOperator<T> add(final T newElement);
    public ILevel1SetOfSetElementsOperator<T> add(final int position, final T newElement);
    public ILevel1SetOfSetElementsOperator<T> addAll(final T... newElements);
    public ILevel1SetOfSetElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1SetOfSetElementsOperator<T> remove(final int position);
    public ILevel1SetOfSetElementsOperator<T> remove(final T value);
    public ILevel1SetOfSetElementsOperator<T> removeAll(final int... positions);
    public ILevel1SetOfSetElementsOperator<T> removeAll(final T... values);
    public ILevel1SetOfSetElementsOperator<T> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfSetElementsOperator<T> removeAll(final ISelect<T> selector);
    public ILevel1SetOfSetElementsOperator<T> removeAllBut(final int... positions);
    public ILevel1SetOfSetElementsOperator<T> removeAllBut(final T... values);
    public ILevel1SetOfSetElementsOperator<T> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfSetElementsOperator<T> removeAllBut(final ISelect<T> selector);
    
    public <X> ILevel1SetOfArrayElementsOperator<X> toArray(final IOf<X> of);
    public <X> ILevel1SetOfArrayElementsOperator<X> toArray(final Class<X> of);
    
    public ILevel1SetOfListElementsOperator<T> toList();
    
    public <K> ILevel1SetOfMapElementsOperator<K,T> toMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel1SetOfMapElementsOperator<K,V> toMap(final IMapBuild<K,V,? super T> mapBuild);

    
    public ILevel1SetOfSetElementsOperator<T> extract(final int position);
    public ILevel1SetOfSetElementsOperator<T> extract(final T value);
    public ILevel1SetOfSetElementsOperator<T> extractAll(final int... positions);
    public ILevel1SetOfSetElementsOperator<T> extractAll(final T... values);
    public ILevel1SetOfSetElementsOperator<T> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfSetElementsOperator<T> extractAll(final ISelect<T> selector);
    public ILevel1SetOfSetElementsOperator<T> extractAllBut(final int... positions);
    public ILevel1SetOfSetElementsOperator<T> extractAllBut(final T... values);
    public ILevel1SetOfSetElementsOperator<T> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfSetElementsOperator<T> extractAllBut(final ISelect<T> selector);
    
    
    public ILevel2SetOfSetElementsElementsOperator<T> forEach(final int... positions);
    public ILevel2SetOfSetElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams);
    public ILevel2SetOfSetElementsElementsOperator<T> forEach(final ISelect<T> selector);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNull();
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNot(final int... positions);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNot(final ISelect<T> selector);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotNull();
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams);
    

    
    
                                    
}

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
package org.op4j.op.intf.operators.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.op.commands.IEval;
import org.op4j.op.intf.operators.array.ILevel0ArrayOperator;
import org.op4j.op.intf.operators.generic.ILevel0GenericMultiOperator;
import org.op4j.op.intf.operators.list.ILevel0ListOperator;
import org.op4j.op.intf.operators.map.ILevel0MapOperator;
import org.op4j.op.intf.parameters.IMapBuild;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.parameters.ISelect;
import org.op4j.op.intf.qualities.IConvertibleToArrayOperator;
import org.op4j.op.intf.qualities.IConvertibleToListOperator;
import org.op4j.op.intf.qualities.IConvertibleToMapOperator;
import org.op4j.op.intf.qualities.IExtractableCollectionOperator;
import org.op4j.op.intf.qualities.IFlattenableOperator;
import org.op4j.op.intf.qualities.IGenerizableOperator;
import org.op4j.op.intf.qualities.IModifiableCollectionOperator;
import org.op4j.op.intf.qualities.INavigableCollectionOperator;
import org.op4j.op.intf.qualities.ISortableOperator;
import org.op4j.op.intf.qualities.ITypeParameterizableXOperator;
import org.op4j.op.intf.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0SetOperator<T> 
		extends IUniqOperator<Set<T>>,
		        INavigableCollectionOperator<T>,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IFlattenableOperator,
		        IModifiableCollectionOperator<T>,
		        IExtractableCollectionOperator<T>,
		        IGenerizableOperator<Set<T>>,
		        IConvertibleToArrayOperator,
		        IConvertibleToListOperator,
                IConvertibleToMapOperator<T> {

    
    public ILevel1SetElementsOperator<T> forEach();
    
    public ILevel0SetOperator<T> sort();
    public ILevel0SetOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel0SetOperator<X> of(final IOf<X> of);
    public <X> ILevel0SetOperator<X> of(final Class<X> ofClass);
    
    public ILevel0SetOperator<?> raw();
    
    public ILevel0GenericMultiOperator<T> flatten();
    
    public ILevel0SetOperator<T> add(final T newElement);
    public ILevel0SetOperator<T> add(final int position, final T newElement);
    public ILevel0SetOperator<T> addAll(final T... newElements);
    public ILevel0SetOperator<T> addAll(final Collection<T> collection);
    public ILevel0SetOperator<T> remove(final int position);
    public ILevel0SetOperator<T> remove(final T value);
    public ILevel0SetOperator<T> removeAll(final int... positions);
    public ILevel0SetOperator<T> removeAll(final T... values);
    public ILevel0SetOperator<T> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel0SetOperator<T> removeAll(final ISelect<T> selector);
    public ILevel0SetOperator<T> removeAllBut(final int... positions);
    public ILevel0SetOperator<T> removeAllBut(final T... values);
    public ILevel0SetOperator<T> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0SetOperator<T> removeAllBut(final ISelect<T> selector);
    
    public <X> ILevel0ArrayOperator<X> toArray(final IOf<X> of);
    public <X> ILevel0ArrayOperator<X> toArray(final Class<X> of);
    
    public ILevel0ListOperator<T> toList();
    
    public <K> ILevel0MapOperator<K,T> toMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOperator<K,V> toMap(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public ILevel0SetOperator<T> extract(final int position);
    public ILevel0SetOperator<T> extract(final T value);
    public ILevel0SetOperator<T> extractAll(final int... positions);
    public ILevel0SetOperator<T> extractAll(final T... values);
    public ILevel0SetOperator<T> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel0SetOperator<T> extractAll(final ISelect<T> selector);
    public ILevel0SetOperator<T> extractAllBut(final int... positions);
    public ILevel0SetOperator<T> extractAllBut(final T... values);
    public ILevel0SetOperator<T> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0SetOperator<T> extractAllBut(final ISelect<T> selector);
    

    
    public ILevel1SetElementsOperator<T> forEach(final int... positions);
    public ILevel1SetElementsOperator<T> forEach(final String expression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<T> forEach(final ISelect<T> selector);
    public ILevel1SetElementsOperator<T> forEachNull();
    public ILevel1SetElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<T> forEachNot(final int... positions);
    public ILevel1SetElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<T> forEachNot(final ISelect<T> selector);
    public ILevel1SetElementsOperator<T> forEachNotNull();
    public ILevel1SetElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams);
    
    
    
    
    
}

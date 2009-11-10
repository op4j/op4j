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
package org.op4j.operators.intf.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.generic.ILevel0GenericMultiOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOperator;
import org.op4j.operators.qualities.IDistinguishableOperator;
import org.op4j.operators.qualities.IExtractableCollectionOperator;
import org.op4j.operators.qualities.IFlattenableOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
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
public interface ILevel0ListOperator<T> 
		extends IUniqOperator<List<T>>,
		        INavigableCollectionOperator<T>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IFlattenableOperator,
		        IModifiableCollectionOperator<T>,
		        IExtractableCollectionOperator<T>,
		        IGenerizableOperator<List<T>>,
		        IConvertibleToArrayOperator,
		        IConvertibleToSetOperator,
                IConvertibleToMapOperator<T> {


    public ILevel1ListElementsOperator<T> forEach();

    public ILevel0ListOperator<T> distinct();
    
    public ILevel0ListOperator<T> sort();
    public ILevel0ListOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel0ListOperator<X> of(final Of<X> of);
    public <X> ILevel0ListOperator<X> of(final Class<X> ofClass);
    
    public ILevel0ListOperator<?> raw();
    
    public ILevel0GenericMultiOperator<T> flatten();
    
    public ILevel0ListOperator<T> add(final T newElement);
    public ILevel0ListOperator<T> add(final int position, final T newElement);
    public ILevel0ListOperator<T> addAllValues(final T... newElements);
    public ILevel0ListOperator<T> addAllValues(final int position, final T... newElements);
    public ILevel0ListOperator<T> addAll(final Collection<T> collection);
    public ILevel0ListOperator<T> remove(final int position);
    public ILevel0ListOperator<T> removeValue(final T value);
    public ILevel0ListOperator<T> removeAll(final int... positions);
    public ILevel0ListOperator<T> removeAllValues(final T... values);
    public ILevel0ListOperator<T> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel0ListOperator<T> removeAll(final ISelect<T> selector);
    public ILevel0ListOperator<T> removeAllNot(final int... positions);
    public ILevel0ListOperator<T> removeAllValuesNot(final T... values);
    public ILevel0ListOperator<T> removeAllNot(final String expression, final Object... optionalExpParams);
    public ILevel0ListOperator<T> removeAllNot(final ISelect<T> selector);
    public ILevel0ListOperator<T> removeAllNulls();
    public ILevel0ListOperator<T> removeAllNullsOr(final String expression, final Object... optionalExpParams);
    public ILevel0ListOperator<T> removeAllNullsOrNot(final String expression, final Object... optionalExpParams);
    public ILevel0ListOperator<T> removeAllNotNullsAnd(final String expression, final Object... optionalExpParams);
    public ILevel0ListOperator<T> removeAllNotNullsAndNot(final String expression, final Object... optionalExpParams);
    
    public <X> ILevel0ArrayOperator<X> toArray(final Of<X> of);
    public <X> ILevel0ArrayOperator<X> toArray(final Class<X> of);
    
    public ILevel0SetOperator<T> toSet();
    
    public <K> ILevel0MapOperator<K,T> toMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOperator<K,V> toMap(final IMapBuild<K,V,? super T> mapBuild);

    
    public ILevel0ListOperator<T> extract(final int position);
    public ILevel0ListOperator<T> extract(final T value);
    public ILevel0ListOperator<T> extractAll(final int... positions);
    public ILevel0ListOperator<T> extractAll(final T... values);
    public ILevel0ListOperator<T> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel0ListOperator<T> extractAll(final ISelect<T> selector);
    public ILevel0ListOperator<T> extractAllBut(final int... positions);
    public ILevel0ListOperator<T> extractAllBut(final T... values);
    public ILevel0ListOperator<T> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0ListOperator<T> extractAllBut(final ISelect<T> selector);
    
    
    public ILevel1ListElementsOperator<T> forEach(final int... positions);
    public ILevel1ListElementsOperator<T> forEach(final String expression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<T> forEach(final ISelect<T> selector);
    public ILevel1ListElementsOperator<T> forEachNull();
    public ILevel1ListElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<T> forEachNot(final int... positions);
    public ILevel1ListElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<T> forEachNot(final ISelect<T> selector);
    public ILevel1ListElementsOperator<T> forEachNotNull();
    public ILevel1ListElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams);
    

    
    
    
    
}

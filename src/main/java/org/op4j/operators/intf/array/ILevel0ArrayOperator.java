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
package org.op4j.operators.intf.array;

import java.util.Collection;
import java.util.Comparator;

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.generic.ILevel0GenericMultiOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.IConvertibleToListOperator;
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
public interface ILevel0ArrayOperator<T> 
		extends IUniqOperator<T[]>,
		        INavigableCollectionOperator<T>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IFlattenableOperator,
		        IModifiableCollectionOperator<T>,
		        IExtractableCollectionOperator<T>,
		        IGenerizableOperator<T[]>,
		        IConvertibleToListOperator,
		        IConvertibleToSetOperator,
		        IConvertibleToMapOperator<T> {


    public ILevel1ArrayElementsOperator<T> forEach();

    public ILevel0ArrayOperator<T> distinct();
    
    public ILevel0ArrayOperator<T> sort();
    public ILevel0ArrayOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel0ArrayOperator<X> of(final Of<X> of);
    public <X> ILevel0ArrayOperator<X> of(final Class<X> ofClass);
    
    public ILevel0ArrayOperator<?> raw();
    
    public ILevel0GenericMultiOperator<T> flatten();
    
    public ILevel0ArrayOperator<T> deleteAAA(final T newElement);
    public ILevel0ArrayOperator<T> deleteAAB(final int position, final T newElement);
    public ILevel0ArrayOperator<T> add(final T... newElements);
    public ILevel0ArrayOperator<T> insert(final int position, final T... newElements);
    public ILevel0ArrayOperator<T> addAll(final Collection<T> collection);
    public ILevel0ArrayOperator<T> deleteCCC(final int position);
    public ILevel0ArrayOperator<T> deleteCCD(final T value);
    public ILevel0ArrayOperator<T> removeAll(final int... positions);
    public ILevel0ArrayOperator<T> removeAllValues(final T... values);
    public ILevel0ArrayOperator<T> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOperator<T> removeAll(final ISelect<T> selector);
    public ILevel0ArrayOperator<T> removeAllNot(final int... positions);
    public ILevel0ArrayOperator<T> removeAllValuesNot(final T... values);
    public ILevel0ArrayOperator<T> removeAllNull();
    public ILevel0ArrayOperator<T> removeAllNullOr(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOperator<T> removeAllNotNullAnd(final String expression, final Object... optionalExpParams);
    
    public ILevel0ListOperator<T> toList();
    
    public ILevel0SetOperator<T> toSet();
    
    public <K> ILevel0MapOperator<K,T> toMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOperator<K,V> toMap(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public ILevel0ArrayOperator<T> extract(final int position);
    public ILevel0ArrayOperator<T> extract(final T value);
    public ILevel0ArrayOperator<T> extractAll(final int... positions);
    public ILevel0ArrayOperator<T> extractAll(final T... values);
    public ILevel0ArrayOperator<T> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOperator<T> extractAll(final ISelect<T> selector);
    public ILevel0ArrayOperator<T> extractAllBut(final int... positions);
    public ILevel0ArrayOperator<T> extractAllBut(final T... values);
    public ILevel0ArrayOperator<T> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOperator<T> extractAllBut(final ISelect<T> selector);
    
    
    public ILevel1ArrayElementsOperator<T> forEach(final int... positions);
    public ILevel1ArrayElementsOperator<T> forEach(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<T> forEach(final ISelect<T> selector);
    public ILevel1ArrayElementsOperator<T> forEachNull();
    public ILevel1ArrayElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<T> forEachNot(final int... positions);
    public ILevel1ArrayElementsOperator<T> forEachNotNull();
    public ILevel1ArrayElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    



    
    
        
}

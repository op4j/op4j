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
package org.op4j.operators.intf.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.operators.qualities.IConvertibleToListOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOperator;
import org.op4j.operators.qualities.IDistinguishableOperator;
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
public interface ILevel1SetOfArrayElementsOperator<T> 
		extends IUniqOperator<Set<T[]>>,
		        INavigableCollectionOperator<T>,
                INavigatingCollectionOperator<T[]>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IModifiableCollectionOperator<T>,
                IExtractableCollectionOperator<T>,
                IConvertibleToListOperator,
                IConvertibleToSetOperator,
                IConvertibleToMapOperator<T> {

    
    public ILevel2SetOfArrayElementsElementsOperator<T> forEach();
    
    public ILevel0SetOfArrayOperator<T> endFor();

    public ILevel1SetOfArrayElementsOperator<T> distinct();
    
    public ILevel1SetOfArrayElementsOperator<T> sort();
    public ILevel1SetOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel1SetOfArrayElementsOperator<X> of(final Of<X> of);
    public <X> ILevel1SetOfArrayElementsOperator<X> of(final Class<X> ofClass);
    
    public ILevel1SetOfArrayElementsOperator<?> raw();
    public ILevel1SetOfArrayElementsOperator<T> add(final T... newElements);
    public ILevel1SetOfArrayElementsOperator<T> insert(final int position, final T... newElements);
    public ILevel1SetOfArrayElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1SetOfArrayElementsOperator<T> removePositions(final int... positions);
    public ILevel1SetOfArrayElementsOperator<T> removeValues(final T... values);
    public ILevel1SetOfArrayElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfArrayElementsOperator<T> removeSelected(final ISelect<T> selector);
    public ILevel1SetOfArrayElementsOperator<T> removeAllExceptPositions(final int... positions);
    public ILevel1SetOfArrayElementsOperator<T> removeNulls();
    public ILevel1SetOfArrayElementsOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams);
    
    public ILevel1SetOfListElementsOperator<T> toList();
    
    public ILevel1SetOfSetElementsOperator<T> toSet();
    
    public <K> ILevel1SetOfMapElementsOperator<K,T> toMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel1SetOfMapElementsOperator<K,V> toMap(final IMapBuild<K,V,? super T> mapBuild);

    
    public ILevel1SetOfArrayElementsOperator<T> extract(final int position);
    public ILevel1SetOfArrayElementsOperator<T> extract(final T value);
    public ILevel1SetOfArrayElementsOperator<T> extractAll(final int... positions);
    public ILevel1SetOfArrayElementsOperator<T> extractAll(final T... values);
    public ILevel1SetOfArrayElementsOperator<T> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfArrayElementsOperator<T> extractAll(final ISelect<T> selector);
    public ILevel1SetOfArrayElementsOperator<T> extractAllBut(final int... positions);
    public ILevel1SetOfArrayElementsOperator<T> extractAllBut(final T... values);
    public ILevel1SetOfArrayElementsOperator<T> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfArrayElementsOperator<T> extractAllBut(final ISelect<T> selector);
    
    
    public ILevel2SetOfArrayElementsElementsOperator<T> forEach(final int... positions);
    public ILevel2SetOfArrayElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams);
    public ILevel2SetOfArrayElementsElementsOperator<T> forEach(final ISelect<T> selector);
    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNull();
    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNot(final int... positions);
    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNotNull();
    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    


    
                                    
}

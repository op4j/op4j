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
package org.op4j.operators.intf.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
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
public interface ILevel1ListOfSetElementsOperator<T> 
		extends IUniqOperator<List<Set<T>>>,
		        INavigableCollectionOperator<T>,
                INavigatingCollectionOperator<Set<T>>,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IModifiableCollectionOperator<T>,
                IExtractableCollectionOperator<T>,
                IConvertibleToArrayOperator,
                IConvertibleToListOperator,
                IConvertibleToMapOperator<T> {

    
    public ILevel2ListOfSetElementsElementsOperator<T> forEach();
    
    public ILevel0ListOfSetOperator<T> endFor();
    
    public ILevel1ListOfSetElementsOperator<T> sort();
    public ILevel1ListOfSetElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel1ListOfSetElementsOperator<X> of(final Of<X> of);
    public <X> ILevel1ListOfSetElementsOperator<X> of(final Class<X> ofClass);
    
    public ILevel1ListOfSetElementsOperator<?> raw();
    
    public ILevel1ListOfSetElementsOperator<T> add(final T newElement);
    public ILevel1ListOfSetElementsOperator<T> add(final int position, final T newElement);
    public ILevel1ListOfSetElementsOperator<T> addAll(final T... newElements);
    public ILevel1ListOfSetElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1ListOfSetElementsOperator<T> remove(final int position);
    public ILevel1ListOfSetElementsOperator<T> remove(final T value);
    public ILevel1ListOfSetElementsOperator<T> removeAll(final int... positions);
    public ILevel1ListOfSetElementsOperator<T> removeAll(final T... values);
    public ILevel1ListOfSetElementsOperator<T> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfSetElementsOperator<T> removeAll(final ISelect<T> selector);
    public ILevel1ListOfSetElementsOperator<T> removeAllBut(final int... positions);
    public ILevel1ListOfSetElementsOperator<T> removeAllBut(final T... values);
    public ILevel1ListOfSetElementsOperator<T> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfSetElementsOperator<T> removeAllBut(final ISelect<T> selector);
    
    public <X> ILevel1ListOfArrayElementsOperator<X> toArray(final Of<X> of);
    public <X> ILevel1ListOfArrayElementsOperator<X> toArray(final Class<X> of);
    
    public ILevel1ListOfListElementsOperator<T> toList();
    
    public <K> ILevel1ListOfMapElementsOperator<K,T> toMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel1ListOfMapElementsOperator<K,V> toMap(final IMapBuild<K,V,? super T> mapBuild);

    
    public ILevel1ListOfSetElementsOperator<T> extract(final int position);
    public ILevel1ListOfSetElementsOperator<T> extract(final T value);
    public ILevel1ListOfSetElementsOperator<T> extractAll(final int... positions);
    public ILevel1ListOfSetElementsOperator<T> extractAll(final T... values);
    public ILevel1ListOfSetElementsOperator<T> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfSetElementsOperator<T> extractAll(final ISelect<T> selector);
    public ILevel1ListOfSetElementsOperator<T> extractAllBut(final int... positions);
    public ILevel1ListOfSetElementsOperator<T> extractAllBut(final T... values);
    public ILevel1ListOfSetElementsOperator<T> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfSetElementsOperator<T> extractAllBut(final ISelect<T> selector);
    
    
    public ILevel2ListOfSetElementsElementsOperator<T> forEach(final int... positions);
    public ILevel2ListOfSetElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams);
    public ILevel2ListOfSetElementsElementsOperator<T> forEach(final ISelect<T> selector);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNull();
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNot(final int... positions);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNot(final ISelect<T> selector);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotNull();
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams);
    

    
    
                                    
}

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
package org.op4j.operators.intf.listoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOperator;
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
public interface ILevel1ListOfListElementsOperator<T> 
		extends IUniqOperator<List<List<T>>>,
		        INavigableCollectionOperator<T>,
                INavigatingCollectionOperator<List<T>>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IModifiableCollectionOperator<T>,
                IExtractableCollectionOperator<T>,
                IConvertibleToArrayOperator<T>,
                IConvertibleToSetOperator,
                IConvertibleToMapOperator<T> {

    
    public ILevel2ListOfListElementsElementsOperator<T> forEach();
    
    public ILevel0ListOfListOperator<T> endFor();

    public ILevel1ListOfListElementsOperator<T> distinct();
    
    public ILevel1ListOfListElementsOperator<T> sort();
    public ILevel1ListOfListElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel1ListOfListElementsOperator<X> of(final Type<X> of);
    public <X> ILevel1ListOfListElementsOperator<X> of(final Class<X> ofClass);
    
    public ILevel1ListOfListElementsOperator<?> raw();
    public ILevel1ListOfListElementsOperator<T> add(final T... newElements);
    public ILevel1ListOfListElementsOperator<T> insert(final int position, final T... newElements);
    public ILevel1ListOfListElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1ListOfListElementsOperator<T> removePositions(final int... positions);
    public ILevel1ListOfListElementsOperator<T> removeValues(final T... values);
    public ILevel1ListOfListElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfListElementsOperator<T> removeSelected(final ISelect<T> selector);
    public ILevel1ListOfListElementsOperator<T> removeAllExceptPositions(final int... positions);
    public ILevel1ListOfListElementsOperator<T> removeNulls();
    public ILevel1ListOfListElementsOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams);
    
    public ILevel1ListOfArrayElementsOperator<T> toArray(final Type<T> of);
    
    
    public ILevel1ListOfSetElementsOperator<T> toSet();
    
    public <K> ILevel1ListOfMapElementsOperator<K,T> toMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel1ListOfMapElementsOperator<K,V> toMap(final IMapBuild<K,V,? super T> mapBuild);

    
    public ILevel1ListOfListElementsOperator<T> extract(final int position);
    public ILevel1ListOfListElementsOperator<T> extract(final T value);
    public ILevel1ListOfListElementsOperator<T> extractAll(final int... positions);
    public ILevel1ListOfListElementsOperator<T> extractAll(final T... values);
    public ILevel1ListOfListElementsOperator<T> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfListElementsOperator<T> extractAll(final ISelect<T> selector);
    public ILevel1ListOfListElementsOperator<T> extractAllBut(final int... positions);
    public ILevel1ListOfListElementsOperator<T> extractAllBut(final T... values);
    public ILevel1ListOfListElementsOperator<T> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfListElementsOperator<T> extractAllBut(final ISelect<T> selector);
    
    
    public ILevel2ListOfListElementsElementsOperator<T> forEach(final int... positions);
    public ILevel2ListOfListElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams);
    public ILevel2ListOfListElementsElementsOperator<T> forEach(final ISelect<T> selector);
    public ILevel2ListOfListElementsElementsOperator<T> forEachNull();
    public ILevel2ListOfListElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel2ListOfListElementsElementsOperator<T> forEachNot(final int... positions);
    public ILevel2ListOfListElementsElementsOperator<T> forEachNotNull();
    public ILevel2ListOfListElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    

    
    
                                    
}

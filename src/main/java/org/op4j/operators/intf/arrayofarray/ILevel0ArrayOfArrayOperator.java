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
package org.op4j.op.intf.operators.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.op4j.op.commands.IEval;
import org.op4j.op.intf.operators.array.ILevel0ArrayOperator;
import org.op4j.op.intf.operators.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.op.intf.operators.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.op.intf.operators.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.op.intf.operators.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.op.intf.operators.listoflist.ILevel0ListOfListOperator;
import org.op4j.op.intf.operators.listofmap.ILevel0ListOfMapOperator;
import org.op4j.op.intf.operators.listofset.ILevel0ListOfSetOperator;
import org.op4j.op.intf.operators.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.op.intf.operators.setoflist.ILevel0SetOfListOperator;
import org.op4j.op.intf.operators.setofmap.ILevel0SetOfMapOperator;
import org.op4j.op.intf.operators.setofset.ILevel0SetOfSetOperator;
import org.op4j.op.intf.parameters.IMapBuild;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.parameters.ISelect;
import org.op4j.op.intf.qualities.IConvertibleToArrayOfListOperator;
import org.op4j.op.intf.qualities.IConvertibleToArrayOfMapOperator;
import org.op4j.op.intf.qualities.IConvertibleToArrayOfSetOperator;
import org.op4j.op.intf.qualities.IConvertibleToListOfArrayOperator;
import org.op4j.op.intf.qualities.IConvertibleToListOfListOperator;
import org.op4j.op.intf.qualities.IConvertibleToListOfMapOperator;
import org.op4j.op.intf.qualities.IConvertibleToListOfSetOperator;
import org.op4j.op.intf.qualities.IConvertibleToSetOfArrayOperator;
import org.op4j.op.intf.qualities.IConvertibleToSetOfListOperator;
import org.op4j.op.intf.qualities.IConvertibleToSetOfMapOperator;
import org.op4j.op.intf.qualities.IConvertibleToSetOfSetOperator;
import org.op4j.op.intf.qualities.IDistinguishableOperator;
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
public interface ILevel0ArrayOfArrayOperator<T> 
		extends IUniqOperator<T[][]>,
		        INavigableCollectionOperator<T[]>,
		        IDistinguishableOperator,
		        ISortableOperator<T[]>,
		        ITypeParameterizableXOperator<T>,
		        IFlattenableOperator,
		        IModifiableCollectionOperator<T[]>,
		        IExtractableCollectionOperator<T[]>,
		        IGenerizableOperator<T[][]>,
		        IConvertibleToArrayOfListOperator<T>,
                IConvertibleToArrayOfSetOperator<T>,
                IConvertibleToListOfArrayOperator<T>,
                IConvertibleToListOfListOperator<T>,
                IConvertibleToListOfSetOperator<T>,
                IConvertibleToSetOfArrayOperator<T>,
                IConvertibleToSetOfListOperator<T>,
                IConvertibleToSetOfSetOperator<T>,
                IConvertibleToArrayOfMapOperator<T>,
                IConvertibleToListOfMapOperator<T>,
                IConvertibleToSetOfMapOperator<T> {


    public ILevel1ArrayOfArrayElementsOperator<T> forEach();

    public ILevel0ArrayOfArrayOperator<T> distinct();
    
    public ILevel0ArrayOfArrayOperator<T> sort();
    public ILevel0ArrayOfArrayOperator<T> sort(final Comparator<? super T[]> comparator);

    
    public <X> ILevel0ArrayOfArrayOperator<X> of(final IOf<X> of);
    public <X> ILevel0ArrayOfArrayOperator<X> of(final Class<X> ofClass);
    
    public ILevel0ArrayOfArrayOperator<?> raw();
    
    public ILevel0ArrayOperator<T> flatten();
    
    public ILevel0ArrayOfArrayOperator<T> add(final T[] newElement);
    public ILevel0ArrayOfArrayOperator<T> add(final int position, final T[] newElement);
    public ILevel0ArrayOfArrayOperator<T> addAll(final T[]... newElements);
    public ILevel0ArrayOfArrayOperator<T> addAll(final Collection<T[]> collection);
    public ILevel0ArrayOfArrayOperator<T> remove(final int position);
    public ILevel0ArrayOfArrayOperator<T> remove(final T[] value);
    public ILevel0ArrayOfArrayOperator<T> removeAll(final int... positions);
    public ILevel0ArrayOfArrayOperator<T> removeAll(final T[]... values);
    public ILevel0ArrayOfArrayOperator<T> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOfArrayOperator<T> removeAll(final ISelect<T[]> selector);
    public ILevel0ArrayOfArrayOperator<T> removeAllBut(final int... positions);
    public ILevel0ArrayOfArrayOperator<T> removeAllBut(final T[]... values);
    public ILevel0ArrayOfArrayOperator<T> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOfArrayOperator<T> removeAllBut(final ISelect<T[]> selector);
    
    public ILevel0ArrayOfListOperator<T> toArrayOfList();
    
    public ILevel0ArrayOfSetOperator<T> toArrayOfSet();
    
    public <X> ILevel0ListOfArrayOperator<X> toListOfArray(final IOf<X> of);
    public <X> ILevel0ListOfArrayOperator<X> toListOfArray(final Class<X> ofClass);
    
    public ILevel0ListOfListOperator<T> toListOfList();
    
    public ILevel0ListOfSetOperator<T> toListOfSet();
    
    public <X> ILevel0SetOfArrayOperator<X> toSetOfArray(final IOf<X> of);
    public <X> ILevel0SetOfArrayOperator<X> toSetOfArray(final Class<X> ofClass);
    
    public ILevel0SetOfListOperator<T> toSetOfList();
    
    public ILevel0SetOfSetOperator<T> toSetOfSet();
    
    public <K> ILevel0ArrayOfMapOperator<K,T> toArrayOfMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0ArrayOfMapOperator<K,V> toArrayOfMap(final IMapBuild<K,V,? super T> mapBuild);
    
    public <K> ILevel0ListOfMapOperator<K,T> toListOfMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0ListOfMapOperator<K,V> toListOfMap(final IMapBuild<K,V,? super T> mapBuild);
    
    public <K> ILevel0SetOfMapOperator<K,T> toSetOfMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0SetOfMapOperator<K,V> toSetOfMap(final IMapBuild<K,V,? super T> mapBuild);

    
    public ILevel0ArrayOfArrayOperator<T> extract(final int position);
    public ILevel0ArrayOfArrayOperator<T> extract(final T[] value);
    public ILevel0ArrayOfArrayOperator<T> extractAll(final int... positions);
    public ILevel0ArrayOfArrayOperator<T> extractAll(final T[]... values);
    public ILevel0ArrayOfArrayOperator<T> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOfArrayOperator<T> extractAll(final ISelect<T[]> selector);
    public ILevel0ArrayOfArrayOperator<T> extractAllBut(final int... positions);
    public ILevel0ArrayOfArrayOperator<T> extractAllBut(final T[]... values);
    public ILevel0ArrayOfArrayOperator<T> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOfArrayOperator<T> extractAllBut(final ISelect<T[]> selector);
    
    
    public ILevel1ArrayOfArrayElementsOperator<T> forEach(final int... positions);
    public ILevel1ArrayOfArrayElementsOperator<T> forEach(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfArrayElementsOperator<T> forEach(final ISelect<T[]> selector);
    public ILevel1ArrayOfArrayElementsOperator<T> forEachNull();
    public ILevel1ArrayOfArrayElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfArrayElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfArrayElementsOperator<T> forEachNot(final int... positions);
    public ILevel1ArrayOfArrayElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfArrayElementsOperator<T> forEachNot(final ISelect<T[]> selector);
    public ILevel1ArrayOfArrayElementsOperator<T> forEachNotNull();
    public ILevel1ArrayOfArrayElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfArrayElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams);
    


    







    
    
}

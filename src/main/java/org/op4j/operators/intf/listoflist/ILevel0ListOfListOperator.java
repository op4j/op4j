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
package org.op4j.op.intf.operators.listoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.op.commands.IEval;
import org.op4j.op.intf.operators.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.op.intf.operators.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.op.intf.operators.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.op.intf.operators.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.op.intf.operators.list.ILevel0ListOperator;
import org.op4j.op.intf.operators.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.op.intf.operators.listofmap.ILevel0ListOfMapOperator;
import org.op4j.op.intf.operators.listofset.ILevel0ListOfSetOperator;
import org.op4j.op.intf.operators.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.op.intf.operators.setoflist.ILevel0SetOfListOperator;
import org.op4j.op.intf.operators.setofmap.ILevel0SetOfMapOperator;
import org.op4j.op.intf.operators.setofset.ILevel0SetOfSetOperator;
import org.op4j.op.intf.parameters.IMapBuild;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.parameters.ISelect;
import org.op4j.op.intf.qualities.IConvertibleToArrayOfArrayOperator;
import org.op4j.op.intf.qualities.IConvertibleToArrayOfListOperator;
import org.op4j.op.intf.qualities.IConvertibleToArrayOfMapOperator;
import org.op4j.op.intf.qualities.IConvertibleToArrayOfSetOperator;
import org.op4j.op.intf.qualities.IConvertibleToListOfArrayOperator;
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
public interface ILevel0ListOfListOperator<T> 
		extends IUniqOperator<List<List<T>>>,
		        INavigableCollectionOperator<List<T>>,
		        IDistinguishableOperator,
		        ISortableOperator<List<T>>,
                ITypeParameterizableXOperator<T>,
                IFlattenableOperator,
		        IModifiableCollectionOperator<List<T>>,
		        IExtractableCollectionOperator<List<T>>,
		        IGenerizableOperator<List<List<T>>>,
                IConvertibleToArrayOfArrayOperator<T>,
                IConvertibleToArrayOfListOperator<T>,
                IConvertibleToArrayOfSetOperator<T>,
                IConvertibleToListOfArrayOperator<T>,
                IConvertibleToListOfSetOperator<T>,
                IConvertibleToSetOfArrayOperator<T>,
                IConvertibleToSetOfListOperator<T>,
                IConvertibleToSetOfSetOperator<T>,
                IConvertibleToArrayOfMapOperator<T>,
                IConvertibleToListOfMapOperator<T>,
                IConvertibleToSetOfMapOperator<T> {


    public ILevel1ListOfListElementsOperator<T> forEach();

    public ILevel0ListOfListOperator<T> distinct();
    
    public ILevel0ListOfListOperator<T> sort();
    public ILevel0ListOfListOperator<T> sort(final Comparator<? super List<T>> comparator);
    
    public <X> ILevel0ListOfListOperator<X> of(final IOf<X> of);
    public <X> ILevel0ListOfListOperator<X> of(final Class<X> ofClass);
    
    public ILevel0ListOfListOperator<?> raw();
    
    public ILevel0ListOperator<T> flatten();
    
    public ILevel0ListOfListOperator<T> add(final List<T> newElement);
    public ILevel0ListOfListOperator<T> add(final int position, final List<T> newElement);
    public ILevel0ListOfListOperator<T> addAll(final List<T>... newElements);
    public ILevel0ListOfListOperator<T> addAll(final Collection<List<T>> collection);
    public ILevel0ListOfListOperator<T> remove(final int position);
    public ILevel0ListOfListOperator<T> remove(final List<T> value);
    public ILevel0ListOfListOperator<T> removeAll(final int... positions);
    public ILevel0ListOfListOperator<T> removeAll(final List<T>... values);
    public ILevel0ListOfListOperator<T> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel0ListOfListOperator<T> removeAll(final ISelect<List<T>> selector);
    public ILevel0ListOfListOperator<T> removeAllBut(final int... positions);
    public ILevel0ListOfListOperator<T> removeAllBut(final List<T>... values);
    public ILevel0ListOfListOperator<T> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0ListOfListOperator<T> removeAllBut(final ISelect<List<T>> selector);
    
    public <X> ILevel0ArrayOfArrayOperator<X> toArrayOfArray(final IOf<X> of);
    public <X> ILevel0ArrayOfArrayOperator<X> toArrayOfArray(final Class<X> arrayOfClass);
    
    public ILevel0ArrayOfListOperator<T> toArrayOfList();
    
    public ILevel0ArrayOfSetOperator<T> toArrayOfSet();
    
    public <X> ILevel0ListOfArrayOperator<X> toListOfArray(final IOf<X> of);
    public <X> ILevel0ListOfArrayOperator<X> toListOfArray(final Class<X> ofClass);
    
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

    
    public ILevel0ListOfListOperator<T> extract(final int position);
    public ILevel0ListOfListOperator<T> extract(final List<T> value);
    public ILevel0ListOfListOperator<T> extractAll(final int... positions);
    public ILevel0ListOfListOperator<T> extractAll(final List<T>... values);
    public ILevel0ListOfListOperator<T> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel0ListOfListOperator<T> extractAll(final ISelect<List<T>> selector);
    public ILevel0ListOfListOperator<T> extractAllBut(final int... positions);
    public ILevel0ListOfListOperator<T> extractAllBut(final List<T>... values);
    public ILevel0ListOfListOperator<T> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0ListOfListOperator<T> extractAllBut(final ISelect<List<T>> selector);
    

    
    public ILevel1ListOfListElementsOperator<T> forEach(final int... positions);
    public ILevel1ListOfListElementsOperator<T> forEach(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfListElementsOperator<T> forEach(final ISelect<List<T>> selector);
    public ILevel1ListOfListElementsOperator<T> forEachNull();
    public ILevel1ListOfListElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfListElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfListElementsOperator<T> forEachNot(final int... positions);
    public ILevel1ListOfListElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfListElementsOperator<T> forEachNot(final ISelect<List<T>> selector);
    public ILevel1ListOfListElementsOperator<T> forEachNotNull();
    public ILevel1ListOfListElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfListElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams);
    

    







    
    
    
}

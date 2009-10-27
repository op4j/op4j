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
package org.op4j.operators.intf.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.IOf;
import org.op4j.commands.IEval;
import org.op4j.commands.IMapBuild;
import org.op4j.commands.ISelect;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfArrayOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfMapOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfSetOperator;
import org.op4j.operators.qualities.IConvertibleToListOfArrayOperator;
import org.op4j.operators.qualities.IConvertibleToListOfListOperator;
import org.op4j.operators.qualities.IConvertibleToListOfMapOperator;
import org.op4j.operators.qualities.IConvertibleToListOfSetOperator;
import org.op4j.operators.qualities.IConvertibleToSetOfArrayOperator;
import org.op4j.operators.qualities.IConvertibleToSetOfListOperator;
import org.op4j.operators.qualities.IConvertibleToSetOfMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOfSetOperator;
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
public interface ILevel0ArrayOfListOperator<T> 
		extends IUniqOperator<List<T>[]>,
		        INavigableCollectionOperator<List<T>>,
		        IDistinguishableOperator,
		        ISortableOperator<List<T>>,
                ITypeParameterizableXOperator<T>,
                IFlattenableOperator,
		        IModifiableCollectionOperator<List<T>>,
		        IExtractableCollectionOperator<List<T>>,
		        IGenerizableOperator<List<T>[]>,
		        IConvertibleToArrayOfArrayOperator<T>,
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


    public ILevel1ArrayOfListElementsOperator<T> forEach();

    public ILevel0ArrayOfListOperator<T> distinct();
    
    public ILevel0ArrayOfListOperator<T> sort();
    public ILevel0ArrayOfListOperator<T> sort(final Comparator<? super List<T>> comparator);
    
    public <X> ILevel0ArrayOfListOperator<X> of(final IOf<X> of);
    public <X> ILevel0ArrayOfListOperator<X> of(final Class<X> ofClass);
    
    public ILevel0ArrayOfListOperator<?> raw();
    
    public ILevel0ArrayOperator<T> flatten();
    
    public ILevel0ArrayOfListOperator<T> add(final List<T> newElement);
    public ILevel0ArrayOfListOperator<T> add(final int position, final List<T> newElement);
    public ILevel0ArrayOfListOperator<T> addAll(final List<T>... newElements);
    public ILevel0ArrayOfListOperator<T> addAll(final Collection<List<T>> collection);
    public ILevel0ArrayOfListOperator<T> remove(final int position);
    public ILevel0ArrayOfListOperator<T> remove(final List<T> value);
    public ILevel0ArrayOfListOperator<T> removeAll(final int... positions);
    public ILevel0ArrayOfListOperator<T> removeAll(final List<T>... values);
    public ILevel0ArrayOfListOperator<T> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOfListOperator<T> removeAll(final ISelect<List<T>> selector);
    public ILevel0ArrayOfListOperator<T> removeAllBut(final int... positions);
    public ILevel0ArrayOfListOperator<T> removeAllBut(final List<T>... values);
    public ILevel0ArrayOfListOperator<T> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOfListOperator<T> removeAllBut(final ISelect<List<T>> selector);
    
    public <X> ILevel0ArrayOfArrayOperator<X> toArrayOfArray(final IOf<X> of);
    public <X> ILevel0ArrayOfArrayOperator<X> toArrayOfArray(final Class<X> arrayOfClass);
    
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


    
    public ILevel0ArrayOfListOperator<T> extract(final int position);
    public ILevel0ArrayOfListOperator<T> extract(final List<T> value);
    public ILevel0ArrayOfListOperator<T> extractAll(final int... positions);
    public ILevel0ArrayOfListOperator<T> extractAll(final List<T>... values);
    public ILevel0ArrayOfListOperator<T> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOfListOperator<T> extractAll(final ISelect<List<T>> selector);
    public ILevel0ArrayOfListOperator<T> extractAllBut(final int... positions);
    public ILevel0ArrayOfListOperator<T> extractAllBut(final List<T>... values);
    public ILevel0ArrayOfListOperator<T> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOfListOperator<T> extractAllBut(final ISelect<List<T>> selector);
    

    
    public ILevel1ArrayOfListElementsOperator<T> forEach(final int... positions);
    public ILevel1ArrayOfListElementsOperator<T> forEach(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfListElementsOperator<T> forEach(final ISelect<List<T>> selector);
    public ILevel1ArrayOfListElementsOperator<T> forEachNull();
    public ILevel1ArrayOfListElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfListElementsOperator<T> forEachNullOrNot(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfListElementsOperator<T> forEachNot(final int... positions);
    public ILevel1ArrayOfListElementsOperator<T> forEachNot(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfListElementsOperator<T> forEachNot(final ISelect<List<T>> selector);
    public ILevel1ArrayOfListElementsOperator<T> forEachNotNull();
    public ILevel1ArrayOfListElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfListElementsOperator<T> forEachNotNullAndNot(final String expression, final Object... optionalExpParams);
    
    







    
    
	    
}
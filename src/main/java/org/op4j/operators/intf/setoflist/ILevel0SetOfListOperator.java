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
package org.op4j.operators.intf.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfArrayOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfListOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfMapOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfSetOperator;
import org.op4j.operators.qualities.IConvertibleToListOfArrayOperator;
import org.op4j.operators.qualities.IConvertibleToListOfListOperator;
import org.op4j.operators.qualities.IConvertibleToListOfMapOperator;
import org.op4j.operators.qualities.IConvertibleToListOfSetOperator;
import org.op4j.operators.qualities.IConvertibleToSetOfArrayOperator;
import org.op4j.operators.qualities.IConvertibleToSetOfMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOfSetOperator;
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
public interface ILevel0SetOfListOperator<T> 
		extends IUniqOperator<Set<List<T>>>,
		        INavigableCollectionOperator<List<T>>,
		        ISortableOperator<List<T>>,
                ITypeParameterizableXOperator<T>,
                IFlattenableOperator,
		        IModifiableCollectionOperator<List<T>>,
		        IExtractableCollectionOperator<List<T>>,
		        IGenerizableOperator<Set<List<T>>>,
                IConvertibleToArrayOfArrayOperator<T>,
                IConvertibleToArrayOfListOperator<T>,
                IConvertibleToArrayOfSetOperator<T>,
                IConvertibleToListOfArrayOperator<T>,
                IConvertibleToListOfListOperator<T>,
                IConvertibleToListOfSetOperator<T>,
                IConvertibleToSetOfArrayOperator<T>,
                IConvertibleToSetOfSetOperator<T>,
                IConvertibleToArrayOfMapOperator<T>,
                IConvertibleToListOfMapOperator<T>,
                IConvertibleToSetOfMapOperator<T> {

    
    public ILevel1SetOfListElementsOperator<T> forEach();
    
    public ILevel0SetOfListOperator<T> sort();
    public ILevel0SetOfListOperator<T> sort(final Comparator<? super List<T>> comparator);
    
    public <X> ILevel0SetOfListOperator<X> of(final Of<X> of);
    public <X> ILevel0SetOfListOperator<X> of(final Class<X> ofClass);
    
    public ILevel0SetOfListOperator<?> raw();
    
    public ILevel0SetOperator<T> flatten();
    public ILevel0SetOfListOperator<T> add(final List<T>... newElements);
    public ILevel0SetOfListOperator<T> insert(final int position, final List<T>... newElements);
    public ILevel0SetOfListOperator<T> addAll(final Collection<List<T>> collection);
    public ILevel0SetOfListOperator<T> removePositions(final int... positions);
    public ILevel0SetOfListOperator<T> removeValues(final List<T>... values);
    public ILevel0SetOfListOperator<T> removeMatching(final String expression, final Object... optionalExpParams);
    public ILevel0SetOfListOperator<T> removeSelected(final ISelect<List<T>> selector);
    public ILevel0SetOfListOperator<T> removeAllExceptPositions(final int... positions);
    public ILevel0SetOfListOperator<T> removeNulls();
    public ILevel0SetOfListOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams);
    
    public <X> ILevel0ArrayOfArrayOperator<X> toArrayOfArray(final Of<X> of);
    public <X> ILevel0ArrayOfArrayOperator<X> toArrayOfArray(final Class<X> arrayOfClass);
    
    public ILevel0ArrayOfListOperator<T> toArrayOfList();
    
    public ILevel0ArrayOfSetOperator<T> toArrayOfSet();
    
    public <X> ILevel0ListOfArrayOperator<X> toListOfArray(final Of<X> of);
    public <X> ILevel0ListOfArrayOperator<X> toListOfArray(final Class<X> ofClass);
    
    public ILevel0ListOfListOperator<T> toListOfList();
    
    public ILevel0ListOfSetOperator<T> toListOfSet();
    
    public <X> ILevel0SetOfArrayOperator<X> toSetOfArray(final Of<X> of);
    public <X> ILevel0SetOfArrayOperator<X> toSetOfArray(final Class<X> ofClass);
    
    public ILevel0SetOfSetOperator<T> toSetOfSet();
    
    public <K> ILevel0ArrayOfMapOperator<K,T> toArrayOfMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0ArrayOfMapOperator<K,V> toArrayOfMap(final IMapBuild<K,V,? super T> mapBuild);
    
    public <K> ILevel0ListOfMapOperator<K,T> toListOfMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0ListOfMapOperator<K,V> toListOfMap(final IMapBuild<K,V,? super T> mapBuild);
    
    public <K> ILevel0SetOfMapOperator<K,T> toSetOfMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0SetOfMapOperator<K,V> toSetOfMap(final IMapBuild<K,V,? super T> mapBuild);


    
    public ILevel0SetOfListOperator<T> extract(final int position);
    public ILevel0SetOfListOperator<T> extract(final List<T> value);
    public ILevel0SetOfListOperator<T> extractAll(final int... positions);
    public ILevel0SetOfListOperator<T> extractAll(final List<T>... values);
    public ILevel0SetOfListOperator<T> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel0SetOfListOperator<T> extractAll(final ISelect<List<T>> selector);
    public ILevel0SetOfListOperator<T> extractAllBut(final int... positions);
    public ILevel0SetOfListOperator<T> extractAllBut(final List<T>... values);
    public ILevel0SetOfListOperator<T> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0SetOfListOperator<T> extractAllBut(final ISelect<List<T>> selector);
    

    
    public ILevel1SetOfListElementsOperator<T> forEach(final int... positions);
    public ILevel1SetOfListElementsOperator<T> forEach(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfListElementsOperator<T> forEach(final ISelect<List<T>> selector);
    public ILevel1SetOfListElementsOperator<T> forEachNull();
    public ILevel1SetOfListElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfListElementsOperator<T> forEachNot(final int... positions);
    public ILevel1SetOfListElementsOperator<T> forEachNotNull();
    public ILevel1SetOfListElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    
    







    
    
    
}

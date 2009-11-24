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
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfArrayOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfListOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfMapOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfSetOperator;
import org.op4j.operators.qualities.IConvertibleToListOfArrayOperator;
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
    
    public <X> ILevel0ListOfListOperator<X> of(final Type<X> of);
        
    public ILevel0ListOfListOperator<?> raw();
    
    public ILevel0ListOperator<T> flatten();
    public ILevel0ListOfListOperator<T> add(final List<T>... newElements);
    public ILevel0ListOfListOperator<T> insert(final int position, final List<T>... newElements);
    public ILevel0ListOfListOperator<T> addAll(final Collection<List<T>> collection);
    public ILevel0ListOfListOperator<T> removePositions(final int... positions);
    public ILevel0ListOfListOperator<T> removeValues(final List<T>... values);
    public ILevel0ListOfListOperator<T> removeMatching(final String expression, final Object... optionalExpParams);
    public ILevel0ListOfListOperator<T> removeSelected(final ISelect<List<T>> selector);
    public ILevel0ListOfListOperator<T> removeAllExceptPositions(final int... positions);
    public ILevel0ListOfListOperator<T> removeNulls();
    public ILevel0ListOfListOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams);
    
    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of);
    
    public ILevel0ArrayOfListOperator<T> toArrayOfList();
    
    public ILevel0ArrayOfSetOperator<T> toArrayOfSet();
    
    public ILevel0ListOfArrayOperator<T> toListOfArray(final Type<T> of);
    
    
    public ILevel0ListOfSetOperator<T> toListOfSet();
    
    public ILevel0SetOfArrayOperator<T> toSetOfArray(final Type<T> of);
    
    
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
    public ILevel1ListOfListElementsOperator<T> forEachNot(final int... positions);
    public ILevel1ListOfListElementsOperator<T> forEachNotNull();
    public ILevel1ListOfListElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    

    







    
    
    
}

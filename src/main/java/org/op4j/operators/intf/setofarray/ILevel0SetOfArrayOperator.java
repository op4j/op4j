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

import org.javaruntype.type.Type;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuilder;
import org.op4j.executables.ISelector;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
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
import org.op4j.operators.qualities.IConvertibleToSetOfListOperator;
import org.op4j.operators.qualities.IConvertibleToSetOfMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOfSetOperator;
import org.op4j.operators.qualities.IFlattenableAsSetOperator;
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
public interface ILevel0SetOfArrayOperator<T> 
		extends IUniqOperator<Set<T[]>>,
		        INavigableCollectionOperator<T[]>,
		        ISortableOperator<T[]>,
                ITypeParameterizableXOperator<T>,
                IFlattenableAsSetOperator<T>,
		        IModifiableCollectionOperator<T[]>,
		        IGenerizableOperator<Set<T[]>>,
                IConvertibleToArrayOfArrayOperator<T>,
                IConvertibleToArrayOfListOperator<T>,
                IConvertibleToArrayOfSetOperator<T>,
                IConvertibleToListOfArrayOperator<T>,
                IConvertibleToListOfListOperator<T>,
                IConvertibleToListOfSetOperator<T>,
                IConvertibleToSetOfListOperator<T>,
                IConvertibleToSetOfSetOperator<T>,
                IConvertibleToArrayOfMapOperator<T>,
                IConvertibleToListOfMapOperator<T>,
                IConvertibleToSetOfMapOperator<T> {

    
    public ILevel1SetOfArrayElementsOperator<T> forEach();
    
    public ILevel0SetOfArrayOperator<T> sort();
    public ILevel0SetOfArrayOperator<T> sort(final Comparator<? super T[]> comparator);
    
    public <X> ILevel0SetOfArrayOperator<X> of(final Type<X> of);
        
    public ILevel0SetOfArrayOperator<?> raw();
    
    public ILevel0SetOperator<T> flatten();
    public ILevel0SetOfArrayOperator<T> add(final T[]... newElements);
    public ILevel0SetOfArrayOperator<T> insert(final int position, final T[]... newElements);
    public ILevel0SetOfArrayOperator<T> addAll(final Collection<T[]> collection);
    public ILevel0SetOfArrayOperator<T> removeIndexes(final int... indices);
    public ILevel0SetOfArrayOperator<T> removeEquals(final T[]... values);
    public ILevel0SetOfArrayOperator<T> removeMatching(final String expression, final Object... optionalExpParams);
    public ILevel0SetOfArrayOperator<T> removeMatching(final IEval<Boolean, ? super T[]> eval);
    public ILevel0SetOfArrayOperator<T> removeNotNullMatching(final IEval<Boolean, ? super T[]> eval);
    public ILevel0SetOfArrayOperator<T> removeNullOrMatching(final IEval<Boolean, ? super T[]> eval);
    public ILevel0SetOfArrayOperator<T> removeSelected(final ISelector<T[]> selector);
    public ILevel0SetOfArrayOperator<T> removeIndexesNot(final int... indices);
    public ILevel0SetOfArrayOperator<T> removeNulls();
    public ILevel0SetOfArrayOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams);
    public ILevel0SetOfArrayOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams);
    
    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of);
    
    public ILevel0ArrayOfListOperator<T> toArrayOfList();
    
    public ILevel0ArrayOfSetOperator<T> toArrayOfSet();
    
    public ILevel0ListOfArrayOperator<T> toListOfArray(final Type<T> of);
    
    
    public ILevel0ListOfListOperator<T> toListOfList();
    
    public ILevel0ListOfSetOperator<T> toListOfSet();
    
    public ILevel0SetOfListOperator<T> toSetOfList();
    
    public ILevel0SetOfSetOperator<T> toSetOfSet();
    
    public ILevel0ArrayOfMapOperator<T,T> toArrayOfMap();
    public <K> ILevel0ArrayOfMapOperator<K,T> toArrayOfMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0ArrayOfMapOperator<K,V> toArrayOfMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    public ILevel0ListOfMapOperator<T,T> toListOfMap();
    public <K> ILevel0ListOfMapOperator<K,T> toListOfMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0ListOfMapOperator<K,V> toListOfMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    public ILevel0SetOfMapOperator<T,T> toSetOfMap();
    public <K> ILevel0SetOfMapOperator<K,T> toSetOfMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0SetOfMapOperator<K,V> toSetOfMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public ILevel1SetOfArrayElementsOperator<T> forEachIndex(final int... indices);
    public ILevel1SetOfArrayElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfArrayElementsOperator<T> forEachMatching(final IEval<Boolean, ? super T[]> eval);
    public ILevel1SetOfArrayElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super T[]> eval);
    public ILevel1SetOfArrayElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super T[]> eval);
    public ILevel1SetOfArrayElementsOperator<T> forEachSelected(final ISelector<T[]> selector);
    public ILevel1SetOfArrayElementsOperator<T> forEachNull();
    public ILevel1SetOfArrayElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams);
    public ILevel1SetOfArrayElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel1SetOfArrayElementsOperator<T> forEachNotNull();
    public ILevel1SetOfArrayElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams);
    


    







    
    
    
}

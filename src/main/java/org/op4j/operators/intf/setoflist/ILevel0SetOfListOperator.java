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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.operators.qualities.ICastableToSetOfListOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
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
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IFlattenableAsSetOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
import org.op4j.operators.qualities.ISortableOperator;
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
                ICastableToSetOfListOperator,
                IFlattenableAsSetOperator<T>,
		        IModifiableCollectionOperator<List<T>>,
		        IGenerizableOperator<Set<List<T>>>,
                IExecutableOperator<Set<List<T>>>,
                IConvertibleOperator<Set<List<T>>>,
                IEvaluableOperator<Set<List<T>>>,
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
        
    public ILevel0SetOperator<T> flatten();
    public ILevel0SetOfListOperator<T> add(final List<T>... newElements);
    public ILevel0SetOfListOperator<T> insert(final int position, final List<T>... newElements);
    public ILevel0SetOfListOperator<T> addAll(final Collection<List<T>> collection);
    public ILevel0SetOfListOperator<T> removeIndexes(final int... indices);
    public ILevel0SetOfListOperator<T> removeEquals(final List<T>... values);
    public ILevel0SetOfListOperator<T> removeMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public ILevel0SetOfListOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public ILevel0SetOfListOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public ILevel0SetOfListOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public ILevel0SetOfListOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public ILevel0SetOfListOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public ILevel0SetOfListOperator<T> removeIndexesNot(final int... indices);
    public ILevel0SetOfListOperator<T> removeNulls();
    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of);
    
    public ILevel0ArrayOfListOperator<T> toArrayOfList();
    
    public ILevel0ArrayOfSetOperator<T> toArrayOfSet();
    
    public ILevel0ListOfArrayOperator<T> toListOfArray(final Type<T> of);
    
    
    public ILevel0ListOfListOperator<T> toListOfList();
    
    public ILevel0ListOfSetOperator<T> toListOfSet();
    
    public ILevel0SetOfArrayOperator<T> toSetOfArray(final Type<T> of);
    
    
    public ILevel0SetOfSetOperator<T> toSetOfSet();
    
    public ILevel0ArrayOfMapOperator<T,T> toArrayOfMap();
    public <K> ILevel0ArrayOfMapOperator<K,T> toArrayOfMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0ArrayOfMapOperator<K,V> toArrayOfMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    public ILevel0ListOfMapOperator<T,T> toListOfMap();
    public <K> ILevel0ListOfMapOperator<K,T> toListOfMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0ListOfMapOperator<K,V> toListOfMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    public ILevel0SetOfMapOperator<T,T> toSetOfMap();
    public <K> ILevel0SetOfMapOperator<K,T> toSetOfMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0SetOfMapOperator<K,V> toSetOfMap(final IMapBuilder<K,V,? super T> mapBuild);


    
    public ILevel1SetOfListElementsOperator<T> forEachIndex(final int... indices);
    public ILevel1SetOfListElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public ILevel1SetOfListElementsOperator<T> forEachNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public ILevel1SetOfListElementsOperator<T> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public ILevel1SetOfListElementsOperator<T> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public ILevel1SetOfListElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public ILevel1SetOfListElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public ILevel1SetOfListElementsOperator<T> forEachNull();
    public ILevel1SetOfListElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel1SetOfListElementsOperator<T> forEachNotNull();
    public ILevel0GenericUniqOperator<Set<List<T>>> generic();



    
    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X,? super Set<List<T>>> converter);
    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X,? super Set<List<T>>> eval);

    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<List<T>>> function);
    
    
    
    public <X> ILevel0SetOfListOperator<X> asSetOfList(final Type<X> of);
    public ILevel0SetOfListOperator<?> asSetOfListOfUnknown();

    
    
}

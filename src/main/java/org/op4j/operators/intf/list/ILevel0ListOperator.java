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
package org.op4j.operators.intf.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.ICastableToListOfArrayOperator;
import org.op4j.operators.qualities.ICastableToListOfListOperator;
import org.op4j.operators.qualities.ICastableToListOfMapOperator;
import org.op4j.operators.qualities.ICastableToListOfSetOperator;
import org.op4j.operators.qualities.ICastableToListOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOperator;
import org.op4j.operators.qualities.IDistinguishableOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
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
public interface ILevel0ListOperator<T> 
		extends IUniqOperator<List<T>>,
		        INavigableCollectionOperator<T>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                ICastableToListOperator,
                ICastableToListOfArrayOperator,
                ICastableToListOfListOperator,
                ICastableToListOfMapOperator,
                ICastableToListOfSetOperator,
		        IModifiableCollectionOperator<T>,
		        IGenerizableOperator<List<T>>,
                IExecutableOperator<List<T>>,
                IConvertibleOperator<List<T>>,
                IEvaluableOperator<List<T>>,
		        IConvertibleToArrayOperator<T>,
		        IConvertibleToSetOperator,
                IConvertibleToMapOperator<T> {


    public ILevel1ListElementsOperator<T> forEach();

    public ILevel0ListOperator<T> distinct();
    
    public ILevel0ListOperator<T> sort();
    public ILevel0ListOperator<T> sort(final Comparator<? super T> comparator);
        
    public ILevel0ListOperator<T> add(final T... newElements);
    public ILevel0ListOperator<T> insert(final int position, final T... newElements);
    public ILevel0ListOperator<T> addAll(final Collection<T> collection);
    public ILevel0ListOperator<T> removeIndexes(final int... indices);
    public ILevel0ListOperator<T> removeEquals(final T... values);
    public ILevel0ListOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ListOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ListOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ListOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ListOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ListOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ListOperator<T> removeIndexesNot(final int... indices);
    public ILevel0ListOperator<T> removeNulls();
    public ILevel0ArrayOperator<T> toArray(final Type<T> of);
    
    
    public ILevel0SetOperator<T> toSet();
    
    public ILevel0MapOperator<T,T> toMap();
    public <K> ILevel0MapOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0MapOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public ILevel1ListElementsOperator<T> forEachIndex(final int... indices);
    public ILevel1ListElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListElementsOperator<T> forEachNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListElementsOperator<T> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListElementsOperator<T> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListElementsOperator<T> forEachNull();
    public ILevel1ListElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel1ListElementsOperator<T> forEachNotNull();
    public ILevel0GenericUniqOperator<List<T>> generic();
    
    
    
    
    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X,? super List<T>> converter);
    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X,? super List<T>> eval);

    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super List<T>> function);
    
    
    public <X> ILevel0ListOfArrayOperator<X> asListOfArray(final Type<X> of);
    public ILevel0ListOfArrayOperator<?> asListOfArrayOfUnknown();
    
    public <X> ILevel0ListOfListOperator<X> asListOfList(final Type<X> of);
    public ILevel0ListOfListOperator<?> asListOfListOfUnknown();
    
    public <K,V> ILevel0ListOfMapOperator<K,V> asListOfMap(final Type<K> keyOf, final Type<V> valueOf);
    public ILevel0ListOfMapOperator<?,?> asListOfMapOfUnknown();
    
    public <X> ILevel0ListOfSetOperator<X> asListOfSet(final Type<X> of);
    public ILevel0ListOfSetOperator<?> asListOfSetOfUnknown();

    
    public <X> ILevel0ListOperator<X> asList(final Type<X> of);
    public ILevel0ListOperator<?> asListOfUnknown();
    



    
}

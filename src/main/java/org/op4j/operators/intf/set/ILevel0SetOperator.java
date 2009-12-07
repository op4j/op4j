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
package org.op4j.operators.intf.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.operators.qualities.ICastableToSetOfArrayOperator;
import org.op4j.operators.qualities.ICastableToSetOfListOperator;
import org.op4j.operators.qualities.ICastableToSetOfMapOperator;
import org.op4j.operators.qualities.ICastableToSetOfSetOperator;
import org.op4j.operators.qualities.ICastableToSetOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOperator;
import org.op4j.operators.qualities.IConvertibleToListOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
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
public interface ILevel0SetOperator<T> 
		extends IUniqOperator<Set<T>>,
		        INavigableCollectionOperator<T>,
		        ISortableOperator<T>,
                ICastableToSetOperator,
                ICastableToSetOfArrayOperator,
                ICastableToSetOfListOperator,
                ICastableToSetOfMapOperator,
                ICastableToSetOfSetOperator,
                ITypeParameterizableXOperator<T>,
		        IModifiableCollectionOperator<T>,
		        IGenerizableOperator<Set<T>>,
                IExecutableOperator<Set<T>>,
                IConvertibleOperator<Set<T>>,
                IEvaluableOperator<Set<T>>,
		        IConvertibleToArrayOperator<T>,
		        IConvertibleToListOperator,
                IConvertibleToMapOperator<T> {

    
    public ILevel1SetElementsOperator<T> forEach();
    
    public ILevel0SetOperator<T> sort();
    public ILevel0SetOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel0SetOperator<X> of(final Type<X> of);
        
    public ILevel0SetOperator<?> raw();
    
    public ILevel0SetOperator<T> add(final T... newElements);
    public ILevel0SetOperator<T> insert(final int position, final T... newElements);
    public ILevel0SetOperator<T> addAll(final Collection<T> collection);
    public ILevel0SetOperator<T> removeIndexes(final int... indices);
    public ILevel0SetOperator<T> removeEquals(final T... values);
    public ILevel0SetOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0SetOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0SetOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0SetOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0SetOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0SetOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0SetOperator<T> removeIndexesNot(final int... indices);
    public ILevel0SetOperator<T> removeNulls();
    public ILevel0ArrayOperator<T> toArray(final Type<T> of);
    
    
    public ILevel0ListOperator<T> toList();
    
    public ILevel0MapOperator<T,T> toMap();
    public <K> ILevel0MapOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0MapOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public ILevel1SetElementsOperator<T> forEachIndex(final int... indices);
    public ILevel1SetElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetElementsOperator<T> forEachNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetElementsOperator<T> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetElementsOperator<T> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetElementsOperator<T> forEachNull();
    public ILevel1SetElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel1SetElementsOperator<T> forEachNotNull();
    public ILevel0GenericUniqOperator<Set<T>> generic();
    
    
    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X,? super Set<T>> converter);
    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X,? super Set<T>> eval);

    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<T>> function);
    
    
    public <X> ILevel0SetOfArrayOperator<X> asSetOfArray(final Type<X> of);
    public ILevel0SetOfArrayOperator<?> asSetOfArrayOfUnknown();

    
    public <X> ILevel0SetOfListOperator<X> asSetOfList(final Type<X> of);
    public ILevel0SetOfListOperator<?> asSetOfListOfUnknown();

    
    public <K,V> ILevel0SetOfMapOperator<K,V> asSetOfMap(final Type<K> keyOf, final Type<V> valueOf);
    public ILevel0SetOfMapOperator<?,?> asSetOfMapOfUnknown();

    
    public <X> ILevel0SetOfSetOperator<X> asSetOfSet(final Type<X> of);
    public ILevel0SetOfSetOperator<?> asSetOfSetOfUnknown();

    
    public <X> ILevel0SetOperator<X> asSet(final Type<X> of);
    public ILevel0SetOperator<?> asSetOfUnknown();
    
    
}

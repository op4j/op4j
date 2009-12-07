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
package org.op4j.operators.intf.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.set.ILevel1SetElementsOperator;
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.qualities.ICastableToSetOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOperator;
import org.op4j.operators.qualities.IConvertibleToListOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
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
public interface ILevel1SetOfSetElementsOperator<T> 
		extends IUniqOperator<Set<Set<T>>>,
		        INavigableCollectionOperator<T>,
		        INavigatingCollectionOperator<Set<T>>,
		        ISortableOperator<T>,
		        ICastableToSetOperator,
                ITypeParameterizableXOperator<T>,
                IModifiableCollectionOperator<T>,
                IExecutableOperator<Set<T>>,
                IConvertibleOperator<Set<T>>,
                IEvaluableOperator<Set<T>>,
                IConvertibleToArrayOperator<T>,
                IConvertibleToListOperator,
                IConvertibleToMapOperator<T> {

    
    public ILevel2SetOfSetElementsElementsOperator<T> forEach();
    
    public ILevel0SetOfSetOperator<T> endFor();
    
    public ILevel1SetOfSetElementsOperator<T> sort();
    public ILevel1SetOfSetElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel1SetOfSetElementsOperator<X> of(final Type<X> of);
        
    public ILevel1SetOfSetElementsOperator<?> raw();
    public ILevel1SetOfSetElementsOperator<T> add(final T... newElements);
    public ILevel1SetOfSetElementsOperator<T> insert(final int position, final T... newElements);
    public ILevel1SetOfSetElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1SetOfSetElementsOperator<T> removeIndexes(final int... indices);
    public ILevel1SetOfSetElementsOperator<T> removeEquals(final T... values);
    public ILevel1SetOfSetElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfSetElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfSetElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfSetElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfSetElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfSetElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfSetElementsOperator<T> removeIndexesNot(final int... indices);
    public ILevel1SetOfSetElementsOperator<T> removeNulls();
    public ILevel1SetOfArrayElementsOperator<T> toArray(final Type<T> of);
    
    
    public ILevel1SetOfListElementsOperator<T> toList();
    
    public ILevel1SetOfMapElementsOperator<T,T> toMap();
    public <K> ILevel1SetOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel1SetOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public ILevel2SetOfSetElementsElementsOperator<T> forEachIndex(final int... indices);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNull();
    public ILevel2SetOfSetElementsElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel2SetOfSetElementsElementsOperator<T> forEachNotNull();
    public <X> ILevel1SetElementsOperator<X> convert(final IConverter<X,? super Set<T>> converter);
    
    public <X> ILevel1SetElementsOperator<X> eval(final IEvaluator<X,? super Set<T>> eval);

    public <X> ILevel1SetElementsOperator<X> exec(final IFunction<X, ? super Set<T>> function);
    

    
    public <X> ILevel1SetOfSetElementsOperator<X> asSet(final Type<X> of);
    public ILevel1SetOfSetElementsOperator<?> asSetOfUnknown();
    
    
    
}

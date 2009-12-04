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
import org.op4j.operators.intf.set.ILevel1SetElementsOperator;
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOperator;
import org.op4j.operators.qualities.IDistinguishableOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
import org.op4j.operators.qualities.INavigatingCollectionOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqOperator;
import org.op4j.select.ISelector;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel1SetOfListElementsOperator<T> 
		extends IUniqOperator<Set<List<T>>>,
		        INavigableCollectionOperator<T>,
                INavigatingCollectionOperator<List<T>>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                IExecutableOperator<List<T>>,
                IConvertibleOperator<List<T>>,
                IEvaluableOperator<List<T>>,
                ITypeParameterizableXOperator<T>,
                IModifiableCollectionOperator<T>,
                IConvertibleToArrayOperator<T>,
                IConvertibleToSetOperator,
                IConvertibleToMapOperator<T> {

    
    public ILevel2SetOfListElementsElementsOperator<T> forEach();
    
    public ILevel0SetOfListOperator<T> endFor();

    public ILevel1SetOfListElementsOperator<T> distinct();
    
    public ILevel1SetOfListElementsOperator<T> sort();
    public ILevel1SetOfListElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel1SetOfListElementsOperator<X> of(final Type<X> of);
        
    public ILevel1SetOfListElementsOperator<?> raw();
    public ILevel1SetOfListElementsOperator<T> add(final T... newElements);
    public ILevel1SetOfListElementsOperator<T> insert(final int position, final T... newElements);
    public ILevel1SetOfListElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1SetOfListElementsOperator<T> removeIndexes(final int... indices);
    public ILevel1SetOfListElementsOperator<T> removeEquals(final T... values);
    public ILevel1SetOfListElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfListElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfListElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfListElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfListElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfListElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfListElementsOperator<T> removeSelected(final ISelector<T> selector);
    public ILevel1SetOfListElementsOperator<T> removeIndexesNot(final int... indices);
    public ILevel1SetOfListElementsOperator<T> removeNulls();
    public ILevel1SetOfArrayElementsOperator<T> toArray(final Type<T> of);
    
    
    public ILevel1SetOfSetElementsOperator<T> toSet();
    
    public ILevel1SetOfMapElementsOperator<T,T> toMap();
    public <K> ILevel1SetOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel1SetOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public ILevel2SetOfListElementsElementsOperator<T> forEachIndex(final int... indices);
    public ILevel2SetOfListElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfListElementsElementsOperator<T> forEachNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfListElementsElementsOperator<T> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfListElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfListElementsElementsOperator<T> forEachSelected(final ISelector<T> selector);
    public ILevel2SetOfListElementsElementsOperator<T> forEachNull();
    public ILevel2SetOfListElementsElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNull();
    public <X> ILevel1SetElementsOperator<X> convert(final IConverter<X,? super List<T>> converter);
    
    public <X> ILevel1SetElementsOperator<X> eval(final IEvaluator<X,? super List<T>> eval);

    public <X> ILevel1SetElementsOperator<X> exec(final IFunction<X, ? super List<T>> function);
    
    
                                    
}

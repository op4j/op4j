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
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.set.ILevel1SetElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IConvertibleToListOperator;
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
public interface ILevel1SetOfArrayElementsOperator<T> 
		extends IUniqOperator<Set<T[]>>,
		        INavigableCollectionOperator<T>,
                INavigatingCollectionOperator<T[]>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                IExecutableOperator<T[]>,
                IConvertibleOperator<T[]>,
                IEvaluableOperator<T[]>,
                ITypeParameterizableXOperator<T>,
                IModifiableCollectionOperator<T>,
                IConvertibleToListOperator,
                IConvertibleToSetOperator,
                IConvertibleToMapOperator<T> {

    
    public ILevel2SetOfArrayElementsElementsOperator<T> forEach();
    
    public ILevel0SetOfArrayOperator<T> endFor();

    public ILevel1SetOfArrayElementsOperator<T> distinct();
    
    public ILevel1SetOfArrayElementsOperator<T> sort();
    public ILevel1SetOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel1SetOfArrayElementsOperator<X> of(final Type<X> of);
        
    public ILevel1SetOfArrayElementsOperator<?> raw();
    public ILevel1SetOfArrayElementsOperator<T> add(final T... newElements);
    public ILevel1SetOfArrayElementsOperator<T> insert(final int position, final T... newElements);
    public ILevel1SetOfArrayElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1SetOfArrayElementsOperator<T> removeIndexes(final int... indices);
    public ILevel1SetOfArrayElementsOperator<T> removeEquals(final T... values);
    public ILevel1SetOfArrayElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfArrayElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfArrayElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1SetOfArrayElementsOperator<T> removeSelected(final ISelector<T> selector);
    public ILevel1SetOfArrayElementsOperator<T> removeIndexesNot(final int... indices);
    public ILevel1SetOfArrayElementsOperator<T> removeNulls();
    public ILevel1SetOfListElementsOperator<T> toList();
    
    public ILevel1SetOfSetElementsOperator<T> toSet();
    
    public ILevel1SetOfMapElementsOperator<T,T> toMap();
    public <K> ILevel1SetOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel1SetOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public ILevel2SetOfArrayElementsElementsOperator<T> forEachIndex(final int... indices);
    public ILevel2SetOfArrayElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2SetOfArrayElementsElementsOperator<T> forEachSelected(final ISelector<T> selector);
    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNull();
    public ILevel2SetOfArrayElementsElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNotNull();
    public <X> ILevel1SetElementsOperator<X> convert(final IConverter<X,? super T[]> converter);
    
    public <X> ILevel1SetElementsOperator<X> eval(final IEvaluator<X,? super T[]> eval);

    public <X> ILevel1SetElementsOperator<X> exec(final IFunction<X, ? super T[]> function);
    
                                    
}

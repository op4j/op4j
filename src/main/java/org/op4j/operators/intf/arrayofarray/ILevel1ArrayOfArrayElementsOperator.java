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
package org.op4j.operators.intf.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.ILevel1ArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.operators.qualities.ICastableToArrayOperator;
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
import org.op4j.operators.qualities.IUniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel1ArrayOfArrayElementsOperator<T> 
		extends IUniqOperator<T[][]>,
		        INavigableCollectionOperator<T>,
                INavigatingCollectionOperator<T[]>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                ICastableToArrayOperator,
                IExecutableOperator<T[]>,
                IConvertibleOperator<T[]>,
                IEvaluableOperator<T[]>,
                IModifiableCollectionOperator<T>,
                IConvertibleToListOperator,
                IConvertibleToSetOperator,
                IConvertibleToMapOperator<T> {

            
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEach();
    
    public ILevel0ArrayOfArrayOperator<T> endFor();

    public ILevel1ArrayOfArrayElementsOperator<T> distinct();
    
    public ILevel1ArrayOfArrayElementsOperator<T> sort();
    public ILevel1ArrayOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public ILevel1ArrayOfArrayElementsOperator<T> add(final T... newElements);
    public ILevel1ArrayOfArrayElementsOperator<T> insert(final int position, final T... newElements);
    public ILevel1ArrayOfArrayElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1ArrayOfArrayElementsOperator<T> removeIndexes(final int... indices);
    public ILevel1ArrayOfArrayElementsOperator<T> removeEquals(final T... values);
    public ILevel1ArrayOfArrayElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayOfArrayElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayOfArrayElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayOfArrayElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayOfArrayElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayOfArrayElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayOfArrayElementsOperator<T> removeIndexesNot(final int... indices);
    public ILevel1ArrayOfArrayElementsOperator<T> removeNulls();
    public ILevel1ArrayOfListElementsOperator<T> toList();
    
    public ILevel1ArrayOfSetElementsOperator<T> toSet();
    
    public ILevel1ArrayOfMapElementsOperator<T,T> toMap();
    public <K> ILevel1ArrayOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel1ArrayOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachIndex(final int... indices);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNull();
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNotNull();
    public <X> ILevel1ArrayElementsOperator<X> convert(final IConverter<X,? super T[]> converter);
    
    public <X> ILevel1ArrayElementsOperator<X> eval(final IEvaluator<X,? super T[]> eval);

    public <X> ILevel1ArrayElementsOperator<X> exec(final IFunction<X, ? super T[]> function);
    
    
    public <X> ILevel1ArrayOfArrayElementsOperator<X> asArray(final Type<X> of);
    public ILevel1ArrayOfArrayElementsOperator<?> asArrayOfUnknown();
    
		            
}

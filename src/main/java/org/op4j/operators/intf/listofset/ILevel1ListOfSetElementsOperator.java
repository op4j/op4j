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
package org.op4j.operators.intf.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
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
import org.op4j.operators.qualities.IUniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel1ListOfSetElementsOperator<T> 
		extends IUniqOperator<List<Set<T>>>,
		        INavigableCollectionOperator<T>,
                INavigatingCollectionOperator<Set<T>>,
		        ISortableOperator<T>,
		        ICastableToSetOperator,
                IExecutableOperator<Set<T>>,
                IConvertibleOperator<Set<T>>,
                IEvaluableOperator<Set<T>>,
                IModifiableCollectionOperator<T>,
                IConvertibleToArrayOperator<T>,
                IConvertibleToListOperator,
                IConvertibleToMapOperator<T> {

    
    public ILevel2ListOfSetElementsElementsOperator<T> forEach();
    
    public ILevel0ListOfSetOperator<T> endFor();
    
    public ILevel1ListOfSetElementsOperator<T> sort();
    public ILevel1ListOfSetElementsOperator<T> sort(final Comparator<? super T> comparator);
        
    public ILevel1ListOfSetElementsOperator<T> add(final T... newElements);
    public ILevel1ListOfSetElementsOperator<T> insert(final int position, final T... newElements);
    public ILevel1ListOfSetElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1ListOfSetElementsOperator<T> removeIndexes(final int... indices);
    public ILevel1ListOfSetElementsOperator<T> removeEquals(final T... values);
    public ILevel1ListOfSetElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListOfSetElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListOfSetElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListOfSetElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListOfSetElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListOfSetElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListOfSetElementsOperator<T> removeIndexesNot(final int... indices);
    public ILevel1ListOfSetElementsOperator<T> removeNulls();
    public ILevel1ListOfArrayElementsOperator<T> toArray(final Type<T> of);
    
    
    public ILevel1ListOfListElementsOperator<T> toList();
    
    public ILevel1ListOfMapElementsOperator<T,T> toMap();
    public <K> ILevel1ListOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel1ListOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public ILevel2ListOfSetElementsElementsOperator<T> forEachIndex(final int... indices);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNull();
    public ILevel2ListOfSetElementsElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel2ListOfSetElementsElementsOperator<T> forEachNotNull();
    public <X> ILevel1ListElementsOperator<X> convert(final IConverter<X,? super Set<T>> converter);
    
    public <X> ILevel1ListElementsOperator<X> eval(final IEvaluator<X,? super Set<T>> eval);

    public <X> ILevel1ListElementsOperator<X> exec(final IFunction<X, ? super Set<T>> function);
    
    
    
    public <X> ILevel1ListOfSetElementsOperator<X> asSetOf(final Type<X> type);
    public ILevel1ListOfSetElementsOperator<?> asSetOfUnknown();
    
                                    
}

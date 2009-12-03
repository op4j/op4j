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
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
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
public interface ILevel1ListOfListElementsOperator<T> 
		extends IUniqOperator<List<List<T>>>,
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

    
    public ILevel2ListOfListElementsElementsOperator<T> forEach();
    
    public ILevel0ListOfListOperator<T> endFor();

    public ILevel1ListOfListElementsOperator<T> distinct();
    
    public ILevel1ListOfListElementsOperator<T> sort();
    public ILevel1ListOfListElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel1ListOfListElementsOperator<X> of(final Type<X> of);
        
    public ILevel1ListOfListElementsOperator<?> raw();
    public ILevel1ListOfListElementsOperator<T> add(final T... newElements);
    public ILevel1ListOfListElementsOperator<T> insert(final int position, final T... newElements);
    public ILevel1ListOfListElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1ListOfListElementsOperator<T> removeIndexes(final int... indices);
    public ILevel1ListOfListElementsOperator<T> removeEquals(final T... values);
    public ILevel1ListOfListElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListOfListElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListOfListElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListOfListElementsOperator<T> removeSelected(final ISelector<T> selector);
    public ILevel1ListOfListElementsOperator<T> removeIndexesNot(final int... indices);
    public ILevel1ListOfListElementsOperator<T> removeNulls();
    public ILevel1ListOfArrayElementsOperator<T> toArray(final Type<T> of);
    
    
    public ILevel1ListOfSetElementsOperator<T> toSet();
    
    public ILevel1ListOfMapElementsOperator<T,T> toMap();
    public <K> ILevel1ListOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel1ListOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public ILevel2ListOfListElementsElementsOperator<T> forEachIndex(final int... indices);
    public ILevel2ListOfListElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ListOfListElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ListOfListElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ListOfListElementsElementsOperator<T> forEachSelected(final ISelector<T> selector);
    public ILevel2ListOfListElementsElementsOperator<T> forEachNull();
    public ILevel2ListOfListElementsElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel2ListOfListElementsElementsOperator<T> forEachNotNull();
    public <X> ILevel1ListElementsOperator<X> convert(final IConverter<X,? super List<T>> converter);
    
    public <X> ILevel1ListElementsOperator<X> eval(final IEvaluator<X,? super List<T>> eval);

    public <X> ILevel1ListElementsOperator<X> exec(final IFunction<X, ? super List<T>> function);
    
    
                                    
}

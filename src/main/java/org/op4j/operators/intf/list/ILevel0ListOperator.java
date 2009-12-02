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
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOperator;
import org.op4j.operators.qualities.IDistinguishableOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
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
public interface ILevel0ListOperator<T> 
		extends IUniqOperator<List<T>>,
		        INavigableCollectionOperator<T>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
		        IModifiableCollectionOperator<T>,
		        IGenerizableOperator<List<T>>,
		        IConvertibleToArrayOperator<T>,
		        IConvertibleToSetOperator,
                IConvertibleToMapOperator<T> {


    public ILevel1ListElementsOperator<T> forEach();

    public ILevel0ListOperator<T> distinct();
    
    public ILevel0ListOperator<T> sort();
    public ILevel0ListOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel0ListOperator<X> of(final Type<X> of);
        
    public ILevel0ListOperator<?> raw();
    
    public ILevel0ListOperator<T> add(final T... newElements);
    public ILevel0ListOperator<T> insert(final int position, final T... newElements);
    public ILevel0ListOperator<T> addAll(final Collection<T> collection);
    public ILevel0ListOperator<T> removeIndexes(final int... indices);
    public ILevel0ListOperator<T> removeEquals(final T... values);
    public ILevel0ListOperator<T> removeMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0ListOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ListOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ListOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ListOperator<T> removeSelected(final ISelector<T> selector);
    public ILevel0ListOperator<T> removeIndexesNot(final int... indices);
    public ILevel0ListOperator<T> removeNulls();
    public ILevel0ListOperator<T> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0ListOperator<T> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams);
    
    public ILevel0ArrayOperator<T> toArray(final Type<T> of);
    
    
    public ILevel0SetOperator<T> toSet();
    
    public ILevel0MapOperator<T,T> toMap();
    public <K> ILevel0MapOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0MapOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public ILevel1ListElementsOperator<T> forEachIndex(final int... indices);
    public ILevel1ListElementsOperator<T> forEachMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListElementsOperator<T> forEachSelected(final ISelector<T> selector);
    public ILevel1ListElementsOperator<T> forEachNull();
    public ILevel1ListElementsOperator<T> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel1ListElementsOperator<T> forEachNotNull();
    public ILevel1ListElementsOperator<T> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams);
    

    
    public ILevel0GenericUniqOperator<List<T>> generic();
    
    
    
    
}

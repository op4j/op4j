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
package org.op4j.operators.intf.array;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.IConvertibleToListOperator;
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
public interface ILevel0ArrayOperator<T> 
		extends IUniqOperator<T[]>,
		        INavigableCollectionOperator<T>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
		        IModifiableCollectionOperator<T>,
		        IGenerizableOperator<T[]>,
		        IConvertibleToListOperator,
		        IConvertibleToSetOperator,
		        IConvertibleToMapOperator<T> {


    public ILevel1ArrayElementsOperator<T> forEach();

    public ILevel0ArrayOperator<T> distinct();
    
    public ILevel0ArrayOperator<T> sort();
    public ILevel0ArrayOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel0ArrayOperator<X> of(final Type<X> of);
        
    public ILevel0ArrayOperator<?> raw();
    
    public ILevel0ArrayOperator<T> add(final T... newElements);
    public ILevel0ArrayOperator<T> insert(final int position, final T... newElements);
    public ILevel0ArrayOperator<T> addAll(final Collection<T> collection);
    public ILevel0ArrayOperator<T> removeIndexes(final int... indices);
    public ILevel0ArrayOperator<T> removeEquals(final T... values);
    public ILevel0ArrayOperator<T> removeMatching(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ArrayOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ArrayOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ArrayOperator<T> removeSelected(final ISelector<T> selector);
    public ILevel0ArrayOperator<T> removeIndexesNot(final int... indices);
    public ILevel0ArrayOperator<T> removeNulls();
    public ILevel0ArrayOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams);
    
    public ILevel0ListOperator<T> toList();
    
    public ILevel0SetOperator<T> toSet();
    
    public ILevel0MapOperator<T,T> toMap();
    public <K> ILevel0MapOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0MapOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public ILevel1ArrayElementsOperator<T> forEachIndex(final int... indices);
    public ILevel1ArrayElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayElementsOperator<T> forEachSelected(final ISelector<T> selector);
    public ILevel1ArrayElementsOperator<T> forEachNull();
    public ILevel1ArrayElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel1ArrayElementsOperator<T> forEachNotNull();
    public ILevel1ArrayElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams);
    


    
    public ILevel0GenericUniqOperator<T[]> generic();

    
    
        
}

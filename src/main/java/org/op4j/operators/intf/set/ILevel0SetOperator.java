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
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuilder;
import org.op4j.executables.ISelector;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOperator;
import org.op4j.operators.qualities.IConvertibleToListOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
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
                ITypeParameterizableXOperator<T>,
		        IModifiableCollectionOperator<T>,
		        IGenerizableOperator<Set<T>>,
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
    public ILevel0SetOperator<T> removeMatching(final String expression, final Object... optionalExpParams);
    public ILevel0SetOperator<T> removeMatching(final IEval<Boolean, ? super T> eval);
    public ILevel0SetOperator<T> removeNotNullMatching(final IEval<Boolean, ? super T> eval);
    public ILevel0SetOperator<T> removeNullOrMatching(final IEval<Boolean, ? super T> eval);
    public ILevel0SetOperator<T> removeSelected(final ISelector<T> selector);
    public ILevel0SetOperator<T> removeIndexesNot(final int... indices);
    public ILevel0SetOperator<T> removeNulls();
    public ILevel0SetOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams);
    public ILevel0SetOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams);
    
    public ILevel0ArrayOperator<T> toArray(final Type<T> of);
    
    
    public ILevel0ListOperator<T> toList();
    
    public ILevel0MapOperator<T,T> toMap();
    public <K> ILevel0MapOperator<K,T> toMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public ILevel1SetElementsOperator<T> forEachIndex(final int... indices);
    public ILevel1SetElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<T> forEachMatching(final IEval<Boolean, ? super T> eval);
    public ILevel1SetElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super T> eval);
    public ILevel1SetElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super T> eval);
    public ILevel1SetElementsOperator<T> forEachSelected(final ISelector<T> selector);
    public ILevel1SetElementsOperator<T> forEachNull();
    public ILevel1SetElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel1SetElementsOperator<T> forEachNotNull();
    public ILevel1SetElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams);
    
    
    
    
    
}

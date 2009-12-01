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
package org.op4j.operators.intf.arrayofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.IDistinguishableOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.ITypeParameterizableXYOperator;
import org.op4j.operators.qualities.IUniqOperator;
import org.op4j.select.ISelector;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0ArrayOfMapOperator<K,V> 
		extends IUniqOperator<Map<K,V>[]>,
		        INavigableCollectionOperator<Map<K,V>>,
		        IDistinguishableOperator,
		        ISortableOperator<Map<K,V>>,
                ITypeParameterizableXYOperator<K,V>,
		        IModifiableCollectionOperator<Map<K,V>>,
		        IGenerizableOperator<Map<K,V>[]> {


    public ILevel1ArrayOfMapElementsOperator<K,V> forEach();

    public ILevel0ArrayOfMapOperator<K,V> distinct();
    
    public ILevel0ArrayOfMapOperator<K,V> sort();
    public ILevel0ArrayOfMapOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator);
    
    public <X,Y> ILevel0ArrayOfMapOperator<X,Y> of(final Type<X> ofX, final Type<Y> ofY);
        
    public ILevel0ArrayOfMapOperator<?,?> raw();
    public ILevel0ArrayOfMapOperator<K,V> add(final Map<K,V>... newElements);
    public ILevel0ArrayOfMapOperator<K,V> insert(final int position, final Map<K,V>... newElements);
    public ILevel0ArrayOfMapOperator<K,V> addAll(final Collection<Map<K,V>> collection);
    public ILevel0ArrayOfMapOperator<K,V> removeIndexes(final int... indices);
    public ILevel0ArrayOfMapOperator<K,V> removeEquals(final Map<K,V>... values);
    public ILevel0ArrayOfMapOperator<K,V> removeMatching(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOfMapOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel0ArrayOfMapOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel0ArrayOfMapOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel0ArrayOfMapOperator<K,V> removeSelected(final ISelector<Map<K,V>> selector);
    public ILevel0ArrayOfMapOperator<K,V> removeIndexesNot(final int... indices);
    public ILevel0ArrayOfMapOperator<K,V> removeNulls();
    public ILevel0ArrayOfMapOperator<K,V> removeNotNullMatching(final String expression, final Object... optionalExpParams);
    public ILevel0ArrayOfMapOperator<K,V> removeNullOrMatching(final String expression, final Object... optionalExpParams);
    
    
    public ILevel1ArrayOfMapElementsOperator<K,V> forEachIndex(final int... indices);
    public ILevel1ArrayOfMapElementsOperator<K,V> forEachMatching(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfMapElementsOperator<K,V> forEachMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel1ArrayOfMapElementsOperator<K,V> forEachNullOrMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel1ArrayOfMapElementsOperator<K,V> forEachNotNullMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel1ArrayOfMapElementsOperator<K,V> forEachSelected(final ISelector<Map<K,V>> selector);
    public ILevel1ArrayOfMapElementsOperator<K,V> forEachNull();
    public ILevel1ArrayOfMapElementsOperator<K,V> forEachNullOrMatching(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfMapElementsOperator<K,V> forEachIndexNot(final int... indices);
    public ILevel1ArrayOfMapElementsOperator<K,V> forEachNotNull();
    public ILevel1ArrayOfMapElementsOperator<K,V> forEachNotNullMatching(final String expression, final Object... optionalExpParams);
    

}

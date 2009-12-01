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
package org.op4j.operators.intf.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOperator;
import org.op4j.operators.qualities.IDistinguishableOperator;
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
public interface ILevel1ArrayOfListElementsOperator<T> 
		extends IUniqOperator<List<T>[]>,
		        INavigableCollectionOperator<T>,
                INavigatingCollectionOperator<List<T>>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IModifiableCollectionOperator<T>,
                IConvertibleToArrayOperator<T>,
                IConvertibleToSetOperator,
                IConvertibleToMapOperator<T> {

            
    public ILevel2ArrayOfListElementsElementsOperator<T> forEach();
    
    public ILevel0ArrayOfListOperator<T> endFor();

    public ILevel1ArrayOfListElementsOperator<T> distinct();
    
    public ILevel1ArrayOfListElementsOperator<T> sort();
    public ILevel1ArrayOfListElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel1ArrayOfListElementsOperator<X> of(final Type<X> of);
        
    public ILevel1ArrayOfListElementsOperator<?> raw();
    public ILevel1ArrayOfListElementsOperator<T> add(final T... newElements);
    public ILevel1ArrayOfListElementsOperator<T> insert(final int position, final T... newElements);
    public ILevel1ArrayOfListElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1ArrayOfListElementsOperator<T> removeIndexes(final int... indices);
    public ILevel1ArrayOfListElementsOperator<T> removeEquals(final T... values);
    public ILevel1ArrayOfListElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfListElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayOfListElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayOfListElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayOfListElementsOperator<T> removeSelected(final ISelector<T> selector);
    public ILevel1ArrayOfListElementsOperator<T> removeIndexesNot(final int... indices);
    public ILevel1ArrayOfListElementsOperator<T> removeNulls();
    public ILevel1ArrayOfListElementsOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfListElementsOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams);
    
    public ILevel1ArrayOfArrayElementsOperator<T> toArray(final Type<T> of);
    
    
    public ILevel1ArrayOfSetElementsOperator<T> toSet();
    
    public ILevel1ArrayOfMapElementsOperator<T,T> toMap();
    public <K> ILevel1ArrayOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel1ArrayOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public ILevel2ArrayOfListElementsElementsOperator<T> forEachIndex(final int... indices);
    public ILevel2ArrayOfListElementsElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ArrayOfListElementsElementsOperator<T> forEachSelected(final ISelector<T> selector);
    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNull();
    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNotNull();
    public ILevel2ArrayOfListElementsElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams);
    

    
    
		                    
}

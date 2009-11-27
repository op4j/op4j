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
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.operators.qualities.IConvertibleToListOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOperator;
import org.op4j.operators.qualities.IDistinguishableOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
import org.op4j.operators.qualities.INavigatingCollectionOperator;
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
public interface ILevel1ArrayOfArrayElementsOperator<T> 
		extends IUniqOperator<T[][]>,
		        INavigableCollectionOperator<T>,
                INavigatingCollectionOperator<T[]>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IModifiableCollectionOperator<T>,
                IConvertibleToListOperator,
                IConvertibleToSetOperator,
                IConvertibleToMapOperator<T> {

            
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEach();
    
    public ILevel0ArrayOfArrayOperator<T> endFor();

    public ILevel1ArrayOfArrayElementsOperator<T> distinct();
    
    public ILevel1ArrayOfArrayElementsOperator<T> sort();
    public ILevel1ArrayOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel1ArrayOfArrayElementsOperator<X> of(final Type<X> of);
        
    public ILevel1ArrayOfArrayElementsOperator<?> raw();
    public ILevel1ArrayOfArrayElementsOperator<T> add(final T... newElements);
    public ILevel1ArrayOfArrayElementsOperator<T> insert(final int position, final T... newElements);
    public ILevel1ArrayOfArrayElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1ArrayOfArrayElementsOperator<T> removeIndexes(final int... indices);
    public ILevel1ArrayOfArrayElementsOperator<T> removeEquals(final T... values);
    public ILevel1ArrayOfArrayElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfArrayElementsOperator<T> removeMatching(final IEval<Boolean, ? super T> eval);
    public ILevel1ArrayOfArrayElementsOperator<T> removeNotNullMatching(final IEval<Boolean, ? super T> eval);
    public ILevel1ArrayOfArrayElementsOperator<T> removeNullOrMatching(final IEval<Boolean, ? super T> eval);
    public ILevel1ArrayOfArrayElementsOperator<T> removeSelected(final ISelect<T> selector);
    public ILevel1ArrayOfArrayElementsOperator<T> removeIndexesNot(final int... indices);
    public ILevel1ArrayOfArrayElementsOperator<T> removeNulls();
    public ILevel1ArrayOfArrayElementsOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams);
    public ILevel1ArrayOfArrayElementsOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams);
    
    public ILevel1ArrayOfListElementsOperator<T> toList();
    
    public ILevel1ArrayOfSetElementsOperator<T> toSet();
    
    public ILevel1ArrayOfMapElementsOperator<T,T> toMap();
    public <K> ILevel1ArrayOfMapElementsOperator<K,T> toMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel1ArrayOfMapElementsOperator<K,V> toMap(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachIndex(final int... indices);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachMatching(final String expression, final Object... optionalExpParams);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachMatching(final IEval<Boolean, ? super T> eval);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super T> eval);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super T> eval);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachSelected(final ISelect<T> selector);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNull();
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNotNull();
    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams);
    

    
		            
}

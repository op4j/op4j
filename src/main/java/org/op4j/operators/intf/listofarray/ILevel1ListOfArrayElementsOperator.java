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
package org.op4j.operators.intf.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
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
public interface ILevel1ListOfArrayElementsOperator<T> 
		extends IUniqOperator<List<T[]>>,
		        INavigableCollectionOperator<T>,
                INavigatingCollectionOperator<T[]>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IModifiableCollectionOperator<T>,
                IConvertibleToListOperator,
                IConvertibleToSetOperator,
                IConvertibleToMapOperator<T> {

    
    public ILevel2ListOfArrayElementsElementsOperator<T> forEach();
    
    public ILevel0ListOfArrayOperator<T> endFor();

    public ILevel1ListOfArrayElementsOperator<T> distinct();
    
    public ILevel1ListOfArrayElementsOperator<T> sort();
    public ILevel1ListOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel1ListOfArrayElementsOperator<X> of(final Type<X> of);
        
    public ILevel1ListOfArrayElementsOperator<?> raw();
    public ILevel1ListOfArrayElementsOperator<T> add(final T... newElements);
    public ILevel1ListOfArrayElementsOperator<T> insert(final int position, final T... newElements);
    public ILevel1ListOfArrayElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1ListOfArrayElementsOperator<T> removePositions(final int... positions);
    public ILevel1ListOfArrayElementsOperator<T> removeValues(final T... values);
    public ILevel1ListOfArrayElementsOperator<T> removeMatching(final String expression, final Object... optionalExpParams);
    public ILevel1ListOfArrayElementsOperator<T> removeSelected(final ISelect<T> selector);
    public ILevel1ListOfArrayElementsOperator<T> removeAllExceptPositions(final int... positions);
    public ILevel1ListOfArrayElementsOperator<T> removeNulls();
    public ILevel1ListOfArrayElementsOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams);
    
    public ILevel1ListOfListElementsOperator<T> toList();
    
    public ILevel1ListOfSetElementsOperator<T> toSet();
    
    public ILevel1ListOfMapElementsOperator<T,T> toMap();
    public <K> ILevel1ListOfMapElementsOperator<K,T> toMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel1ListOfMapElementsOperator<K,V> toMap(final IMapBuild<K,V,? super T> mapBuild);

    
    public ILevel2ListOfArrayElementsElementsOperator<T> forEach(final int... positions);
    public ILevel2ListOfArrayElementsElementsOperator<T> forEach(final String expression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<T> forEach(final ISelect<T> selector);
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNull();
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNullOr(final String expression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNot(final int... positions);
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNull();
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNullAnd(final String expression, final Object... optionalExpParams);
    


    
                                    
}

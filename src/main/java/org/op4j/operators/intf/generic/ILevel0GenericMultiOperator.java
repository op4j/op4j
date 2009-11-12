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
package org.op4j.operators.intf.generic;

import java.util.Collection;

import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.IBuilderMultiOperator;
import org.op4j.operators.qualities.IBuilderOperator;
import org.op4j.operators.qualities.IModifiableGrowableOperator;
import org.op4j.operators.qualities.IModifiableShrinkableOperator;
import org.op4j.operators.qualities.IMultiOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqableOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0GenericMultiOperator<T> 
        extends IMultiOperator<T>,
                IUniqableOperator<T>,
        		IBuilderOperator<T>,
        		IBuilderMultiOperator<T>,
                ITypeParameterizableXOperator<T>,
                IModifiableGrowableOperator<T>,
                IModifiableShrinkableOperator<T> {

    
    public ILevel0GenericUniqOperator<T> uniq();

    
    
    public <X> ILevel0GenericMultiOperator<X> of(final Of<X> of);
    public <X> ILevel0GenericMultiOperator<X> of(final Class<X> ofClass);
    
    public ILevel0GenericMultiOperator<?> raw();
    

    public ILevel0GenericMultiOperator<T> add(final T newElement);
    public ILevel0GenericMultiOperator<T> add(final int position, final T newElement);
    public ILevel0GenericMultiOperator<T> addAllValues(final T... newElements);
    public ILevel0GenericMultiOperator<T> addAllValues(final int position, final T... newElements);
    public ILevel0GenericMultiOperator<T> addAll(final Collection<T> collection);
    public ILevel0GenericMultiOperator<T> remove(final int position);
    public ILevel0GenericMultiOperator<T> removeValue(final T value);
    public ILevel0GenericMultiOperator<T> removeAll(final int... positions);
    public ILevel0GenericMultiOperator<T> removeAllValues(final T... values);
    public ILevel0GenericMultiOperator<T> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel0GenericMultiOperator<T> removeAll(final ISelect<T> selector);
    public ILevel0GenericMultiOperator<T> removeAllNot(final int... positions);
    public ILevel0GenericMultiOperator<T> removeAllValuesNot(final T... values);
    public ILevel0GenericMultiOperator<T> removeAllNull();
    public ILevel0GenericMultiOperator<T> removeAllNullOr(final String expression, final Object... optionalExpParams);
    public ILevel0GenericMultiOperator<T> removeAllNotNullAnd(final String expression, final Object... optionalExpParams);
    
    
    public ILevel0ListOperator<T> buildList();
    
    
    public ILevel0SetOperator<T> buildSet();
    
    
    public <X> ILevel0ArrayOperator<X> buildArray(final Of<X> of);
    public <X> ILevel0ArrayOperator<X> buildArray(final Class<X> classOf);
    
    
    public <K> ILevel0MapOperator<K,T> buildMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOperator<K,V> buildMap(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public <K> ILevel0MapOfListOperator<K,T> buildMapOfList(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOfListOperator<K,V> buildMapOfList(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public <K> ILevel0MapOfSetOperator<K,T> buildMapOfSet(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOfSetOperator<K,V> buildMapOfSet(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public <K,X> ILevel0MapOfArrayOperator<K,X> buildMapOfArray(final IEval<K,? super T> keyEval, final Of<X> valueArrayOf);
    public <K,V> ILevel0MapOfArrayOperator<K,V> buildMapOfArray(final IMapBuild<K,V,? super T> mapBuild, final Of<V> valueArrayOf);
    public <K,X> ILevel0MapOfArrayOperator<K,X> buildMapOfArray(final IEval<K,? super T> keyEval, final Class<X> valueArrayOfClass);
    public <K,V> ILevel0MapOfArrayOperator<K,V> buildMapOfArray(final IMapBuild<K,V,? super T> mapBuild, final Class<V> valueArrayOfClass);

    
    public ILevel0MapOperator<T,T> buildMap();
    
    public ILevel0MapOfListOperator<T,T> buildMapOfList();
    
    public ILevel0MapOfSetOperator<T,T> buildMapOfSet();
    
    public <X> ILevel0MapOfArrayOperator<X,X> buildMapOfArray(final Of<X> of);
    public <X> ILevel0MapOfArrayOperator<X,X> buildMapOfArray(final Class<X> arrayOfClass);
    

}

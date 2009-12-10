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
package org.op4j.operators.intf.setofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.qualities.ICastableToSetOfMapOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.IUniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0SetOfMapOperator<K,V> 
		extends IUniqOperator<Set<Map<K,V>>>,
		        INavigableCollectionOperator<Map<K,V>>,
		        ISortableOperator<Map<K,V>>,
		        ICastableToSetOfMapOperator,
                IExecutableOperator<Set<Map<K,V>>>,
                IConvertibleOperator<Set<Map<K,V>>>,
                IEvaluableOperator<Set<Map<K,V>>>,
                IModifiableCollectionOperator<Map<K,V>>,
		        IGenerizableOperator<Set<Map<K,V>>> {

    
    public ILevel1SetOfMapElementsOperator<K,V> forEach();
    
    public ILevel0SetOfMapOperator<K,V> sort();
    public ILevel0SetOfMapOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator);
    
    public ILevel0SetOfMapOperator<K,V> add(final Map<K,V>... newElements);
    public ILevel0SetOfMapOperator<K,V> insert(final int position, final Map<K,V>... newElements);
    public ILevel0SetOfMapOperator<K,V> addAll(final Collection<Map<K,V>> collection);
    public ILevel0SetOfMapOperator<K,V> removeIndexes(final int... indices);
    public ILevel0SetOfMapOperator<K,V> removeEquals(final Map<K,V>... values);
    public ILevel0SetOfMapOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel0SetOfMapOperator<K,V> removeNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel0SetOfMapOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel0SetOfMapOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel0SetOfMapOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel0SetOfMapOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel0SetOfMapOperator<K,V> removeIndexesNot(final int... indices);
    public ILevel0SetOfMapOperator<K,V> removeNulls();
    public ILevel1SetOfMapElementsOperator<K,V> forEachIndex(final int... indices);
    public ILevel1SetOfMapElementsOperator<K,V> forEachMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNullOrMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNotNullMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNull();
    public ILevel1SetOfMapElementsOperator<K,V> forEachIndexNot(final int... indices);
    public ILevel1SetOfMapElementsOperator<K,V> forEachNotNull();
    public ILevel0GenericUniqOperator<Set<Map<K,V>>> generic();
    
    
    
    
    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X,? super Set<Map<K,V>>> converter);
    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X,? super Set<Map<K,V>>> eval);

    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<Map<K,V>>> function);
    
    
    public <X,Y> ILevel0SetOfMapOperator<X,Y> asSetOfMapOf(final Type<X> keyType, final Type<Y> valueType);
    public ILevel0SetOfMapOperator<?,?> asSetOfMapOfUnknown();

    
}

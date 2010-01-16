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
package org.op4j.operators.intf.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.qualities.CastableToSetOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ExecutableSetOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.SortableOperator;
import org.op4j.operators.qualities.UniqOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1SetOfSetElementsOperator<T>
        extends UniqOperator<Set<Set<T>>>,
                NavigableCollectionOperator<T>,
		        NavigatingCollectionOperator<Set<T>>,
		        SortableOperator<T>,
		        CastableToSetOperator,
                ModifiableCollectionOperator<T>,
                ExecutableSetOperator<T>,
                SelectableOperator<Set<T>>,
                ConvertibleToArrayOperator<T>,
                ConvertibleToListOperator,
                ConvertibleToMapOperator<T> {



    public Level1SetOfSetElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1SetOfSetElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetElementsSelectedOperator<T> ifNull();
    public Level1SetOfSetElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1SetOfSetElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1SetOfSetElementsSelectedOperator<T> ifNotNull();
    public Level1SetOfSetElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval);


    
    public Level2SetOfSetElementsElementsOperator<T> forEach();
    
    public Level0SetOfSetOperator<T> endFor();
    
    public Level1SetOfSetElementsOperator<T> sort();
    public Level1SetOfSetElementsOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level1SetOfSetElementsOperator<T> add(final T... newElements);
    public Level1SetOfSetElementsOperator<T> insert(final int position, final T... newElements);
    public Level1SetOfSetElementsOperator<T> addAll(final Collection<T> collection);
    public Level1SetOfSetElementsOperator<T> removeIndexes(final int... indices);
    public Level1SetOfSetElementsOperator<T> removeEquals(final T... values);
    public Level1SetOfSetElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfSetElementsOperator<T> removeIndexesNot(final int... indices);
    public Level1SetOfSetElementsOperator<T> removeNulls();
    public Level1SetOfArrayElementsOperator<T> toArray(final Type<T> of);
    
    
    public Level1SetOfListElementsOperator<T> toList();
    
    public Level1SetOfMapElementsOperator<T,T> toMap();
    public <K> Level1SetOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level1SetOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public <X> Level1SetOfSetElementsOperator<X> convert(final IConverter<? extends Set<X>,? super Set<T>> converter);
    
    public <X> Level1SetOfSetElementsOperator<X> eval(final IEvaluator<? extends Set<X>,? super Set<T>> eval);

    public <X> Level1SetOfSetElementsOperator<X> exec(final IFunction<? extends Set<X>, ? super Set<T>> function);

    public <X> Level1SetElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T>> function);
    
    public <X> Level1SetElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Set<T>> eval);
    
    public <X> Level1SetElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super Set<T>> converter);    
    

    
    public <X> Level1SetOfSetElementsOperator<X> asSetOf(final Type<X> type);
    public Level1SetOfSetElementsOperator<?> asSetOfUnknown();
    
    
    
}

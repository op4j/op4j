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
package org.op4j.operators.intf.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableArrayOperator;
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
public interface Level1SetOfArrayElementsOperator<T>
        extends UniqOperator<Set<T[]>>,
                NavigableArrayOperator<T>,
                NavigatingCollectionOperator<T[]>,
		        DistinguishableOperator,
		        SortableOperator<T>,
		        CastableToArrayOperator,
                ExecutableArrayOperator<T>,
                SelectableOperator<T[]>,
                ModifiableCollectionOperator<T>,
                ConvertibleToListOperator,
                ConvertibleToSetOperator,
                ConvertibleToMapOperator<T> {



    public Level1SetOfArrayElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1SetOfArrayElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> ifNull();
    public Level1SetOfArrayElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1SetOfArrayElementsSelectedOperator<T> ifNotNull();
    public Level1SetOfArrayElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval);


    
    public Level2SetOfArrayElementsElementsOperator<T> forEach(final Type<T> elementType);
    
    public Level0SetOfArrayOperator<T> endFor();

    public Level1SetOfArrayElementsOperator<T> distinct();
    
    public Level1SetOfArrayElementsOperator<T> sort();
    public Level1SetOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level1SetOfArrayElementsOperator<T> add(final T... newElements);
    public Level1SetOfArrayElementsOperator<T> insert(final int position, final T... newElements);
    public Level1SetOfArrayElementsOperator<T> addAll(final Collection<T> collection);
    public Level1SetOfArrayElementsOperator<T> removeIndexes(final int... indices);
    public Level1SetOfArrayElementsOperator<T> removeEquals(final T... values);
    public Level1SetOfArrayElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsOperator<T> removeIndexesNot(final int... indices);
    public Level1SetOfArrayElementsOperator<T> removeNulls();
    public Level1SetOfListElementsOperator<T> toList();
    
    public Level1SetOfSetElementsOperator<T> toSet();
    
    public Level1SetOfMapElementsOperator<T,T> toMap();
    public <K> Level1SetOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level1SetOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public <X> Level1SetOfArrayElementsOperator<X> convert(final IConverter<X[],? super T[]> converter);
    
    public <X> Level1SetOfArrayElementsOperator<X> eval(final IEvaluator<X[],? super T[]> eval);

    public <X> Level1SetOfArrayElementsOperator<X> exec(final IFunction<X[], ? super T[]> function);
    
    
    public <X> Level1SetOfArrayElementsOperator<X> asArrayOf(final Type<X> type);
    public Level1SetOfArrayElementsOperator<?> asArrayOfUnknown();
    
                                    
}

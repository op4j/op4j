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
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableArrayOperator;
import org.op4j.operators.qualities.NavigatingArrayOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
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
public interface Level1ArrayOfArrayElementsOperator<T>
        extends UniqOperator<T[][]>,
                NavigableArrayOperator<T>,
                NavigatingArrayOperator<T[]>,
		        DistinguishableOperator,
		        SortableOperator<T>,
                CastableToArrayOperator,
                ExecutableArrayOperator<T>,
                SelectableOperator<T[]>,
                ReplaceableOperator<T[]>,
                ReplaceableIfNullOperator<T[]>,
                ModifiableCollectionOperator<T>,
                ConvertibleToListOperator,
                ConvertibleToSetOperator,
                ConvertibleToMapOperator<T> {



    public Level1ArrayOfArrayElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1ArrayOfArrayElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ArrayOfArrayElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ArrayOfArrayElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ArrayOfArrayElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ArrayOfArrayElementsSelectedOperator<T> ifNull();
    public Level1ArrayOfArrayElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ArrayOfArrayElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1ArrayOfArrayElementsSelectedOperator<T> ifNotNull();
    public Level1ArrayOfArrayElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval);


            
    public Level2ArrayOfArrayElementsElementsOperator<T> forEach(final Type<T> elementType);
    
    public Level0ArrayOfArrayOperator<T> endFor();

    public Level1ArrayOfArrayElementsOperator<T> distinct();
    
    public Level1ArrayOfArrayElementsOperator<T> sort();
    public Level1ArrayOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public Level1ArrayOfArrayElementsOperator<T> add(final T newElement);
    public Level1ArrayOfArrayElementsOperator<T> addAll(final T... newElements);
    public Level1ArrayOfArrayElementsOperator<T> insert(final int position, final T newElement);
    public Level1ArrayOfArrayElementsOperator<T> insertAll(final int position, final T... newElements);
    public Level1ArrayOfArrayElementsOperator<T> addAll(final Collection<T> collection);
    public Level1ArrayOfArrayElementsOperator<T> removeAllIndexes(final int... indices);
    public Level1ArrayOfArrayElementsOperator<T> removeAllEqual(final T... values);
    public Level1ArrayOfArrayElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArrayElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArrayElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArrayElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArrayElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArrayElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfArrayElementsOperator<T> removeAllIndexesNot(final int... indices);
    public Level1ArrayOfArrayElementsOperator<T> removeAllNull();
    public Level1ArrayOfListElementsOperator<T> toList();
    
    public Level1ArrayOfSetElementsOperator<T> toSet();
    
    public Level1ArrayOfMapElementsOperator<T,T> toMap();
    public <K> Level1ArrayOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level1ArrayOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public Level1ArrayOfArrayElementsOperator<T> replaceWith(final T[] replacement);
    public Level1ArrayOfArrayElementsOperator<T> replaceIfNullWith(final T[] replacement);


    public <X> Level1ArrayOfArrayElementsOperator<X> convert(final IConverter<X[],? super T[]> converter);
    
    public <X> Level1ArrayOfArrayElementsOperator<X> eval(final IEvaluator<X[],? super T[]> eval);

    public <X> Level1ArrayOfArrayElementsOperator<X> exec(final IFunction<X[], ? super T[]> function);

    public <X> Level1ArrayElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super T[]> function);
    
    public <X> Level1ArrayElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super T[]> eval);
    
    public <X> Level1ArrayElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super T[]> converter);    
    
    
    public <X> Level1ArrayOfArrayElementsOperator<X> asArrayOf(final Type<X> type);
    public Level1ArrayOfArrayElementsOperator<?> asArrayOfUnknown();
    
		            
}

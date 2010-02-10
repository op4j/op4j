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
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
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
public interface Level1ListOfArrayElementsOperator<T>
        extends UniqOperator<List<T[]>>,
                NavigableCollectionOperator<T>,
                NavigatingCollectionOperator<T[]>,
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



    public Level1ListOfArrayElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level1ListOfArrayElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArrayElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArrayElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArrayElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArrayElementsSelectedOperator<T> ifNull();
    public Level1ListOfArrayElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArrayElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level1ListOfArrayElementsSelectedOperator<T> ifNotNull();
    public Level1ListOfArrayElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval);


    
    public Level2ListOfArrayElementsElementsOperator<T> forEach();
    
    public Level0ListOfArrayOperator<T> endFor();

    public Level1ListOfArrayElementsOperator<T> distinct();
    
    public Level1ListOfArrayElementsOperator<T> sort();
    public Level1ListOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level1ListOfArrayElementsOperator<T> add(final T newElement);
    public Level1ListOfArrayElementsOperator<T> addAll(final T... newElements);
    public Level1ListOfArrayElementsOperator<T> insert(final int position, final T newElement);
    public Level1ListOfArrayElementsOperator<T> insertAll(final int position, final T... newElements);
    public Level1ListOfArrayElementsOperator<T> addAll(final Collection<T> collection);
    public Level1ListOfArrayElementsOperator<T> removeAllIndexes(final int... indexes);
    public Level1ListOfArrayElementsOperator<T> removeAllEqual(final T... values);
    public Level1ListOfArrayElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsOperator<T> removeAllIndexesNot(final int... indexes);
    public Level1ListOfArrayElementsOperator<T> removeAllNull();
    public Level1ListOfListElementsOperator<T> toList();
    
    public Level1ListOfSetElementsOperator<T> toSet();
    
    public Level1ListOfMapElementsOperator<T,T> toMap();
    public <K> Level1ListOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level1ListOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level1ListOfArrayElementsOperator<T> replaceWith(final T[] replacement);
    public Level1ListOfArrayElementsOperator<T> replaceIfNullWith(final T[] replacement);


    public Level1ListOfArrayElementsOperator<T> convertAsArray(final IConverter<? extends T[],? super T[]> converter);
    
    public Level1ListOfArrayElementsOperator<T> evalAsArray(final IEvaluator<? extends T[],? super T[]> eval);

    public Level1ListOfArrayElementsOperator<T> execAsArray(final IFunction<? extends T[], ? super T[]> function);

    public <X> Level1ListOfArrayElementsOperator<X> convertAsArrayOf(final Type<X> type, final IConverter<X[],? super T[]> converter);
    
    public <X> Level1ListOfArrayElementsOperator<X> evalAsArrayOf(final Type<X> type, final IEvaluator<X[],? super T[]> eval);

    public <X> Level1ListOfArrayElementsOperator<X> execAsArrayOf(final Type<X> type, final IFunction<X[], ? super T[]> function);

    public <X> Level1ListElementsOperator<X> exec(final IFunction<X, ? super T[]> function);
    
    public <X> Level1ListElementsOperator<X> eval(final IEvaluator<X,? super T[]> eval);
    
    public <X> Level1ListElementsOperator<X> convert(final IConverter<X,? super T[]> converter);    
    
    
    public <X> Level1ListOfArrayElementsOperator<X> asArrayOf(final Type<X> type);
    public Level1ListOfArrayElementsOperator<?> asArrayOfUnknown();
    
                                    
}

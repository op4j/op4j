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
import org.op4j.operators.qualities.NavigableArrayOperator;
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
public interface Level1ListOfArrayElementsOperator<T,I>
        extends UniqOperator<List<T[]>,I>,
                NavigableArrayOperator<T,I>,
                NavigatingCollectionOperator<T[],I>,
		        DistinguishableOperator<I>,
		        SortableOperator<T,I>,
		        CastableToArrayOperator<I>,
                ExecutableArrayOperator<T,I>,
                SelectableOperator<T[],I>,
                ReplaceableOperator<T[],I>,
                ReplaceableIfNullOperator<T[],I>,
                ModifiableCollectionOperator<T,I>,
                ConvertibleToListOperator<I>,
                ConvertibleToSetOperator<I>,
                ConvertibleToMapOperator<T,I> {



    public Level1ListOfArrayElementsSelectedOperator<T,I> ifIndex(final int... indices);
    public Level1ListOfArrayElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArrayElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArrayElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArrayElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArrayElementsSelectedOperator<T,I> ifNull();
    public Level1ListOfArrayElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level1ListOfArrayElementsSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level1ListOfArrayElementsSelectedOperator<T,I> ifNotNull();
    public Level1ListOfArrayElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval);


    
    public Level2ListOfArrayElementsElementsOperator<T,I> forEach(final Type<T> elementType);
    
    public Level0ListOfArrayOperator<T,I> endFor();

    public Level1ListOfArrayElementsOperator<T,I> distinct();
    
    public Level1ListOfArrayElementsOperator<T,I> sort();
    public Level1ListOfArrayElementsOperator<T,I> sort(final Comparator<? super T> comparator);
        
    public Level1ListOfArrayElementsOperator<T,I> add(final T newElement);
    public Level1ListOfArrayElementsOperator<T,I> addAll(final T... newElements);
    public Level1ListOfArrayElementsOperator<T,I> insert(final int position, final T newElement);
    public Level1ListOfArrayElementsOperator<T,I> insertAll(final int position, final T... newElements);
    public Level1ListOfArrayElementsOperator<T,I> addAll(final Collection<T> collection);
    public Level1ListOfArrayElementsOperator<T,I> removeAllIndexes(final int... indices);
    public Level1ListOfArrayElementsOperator<T,I> removeAllEqual(final T... values);
    public Level1ListOfArrayElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfArrayElementsOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level1ListOfArrayElementsOperator<T,I> removeAllNull();
    public Level1ListOfListElementsOperator<T,I> toList();
    
    public Level1ListOfSetElementsOperator<T,I> toSet();
    
    public Level1ListOfMapElementsOperator<T,T,I> toMap();
    public <K> Level1ListOfMapElementsOperator<K,T,I> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level1ListOfMapElementsOperator<K,V,I> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level1ListOfArrayElementsOperator<T,I> replaceWith(final T[] replacement);
    public Level1ListOfArrayElementsOperator<T,I> replaceIfNullWith(final T[] replacement);


    public <X> Level1ListOfArrayElementsOperator<X,I> convert(final IConverter<X[],? super T[]> converter);
    
    public <X> Level1ListOfArrayElementsOperator<X,I> eval(final IEvaluator<X[],? super T[]> eval);

    public <X> Level1ListOfArrayElementsOperator<X,I> exec(final IFunction<X[], ? super T[]> function);

    public <X> Level1ListElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super T[]> function);
    
    public <X> Level1ListElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super T[]> eval);
    
    public <X> Level1ListElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super T[]> converter);    
    
    
    public <X> Level1ListOfArrayElementsOperator<X,I> asArrayOf(final Type<X> type);
    public Level1ListOfArrayElementsOperator<?,I> asArrayOfUnknown();
    
                                    
}

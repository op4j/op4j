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
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListOperator;
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
public interface Level1ArrayOfListElementsOperator<T,I>
        extends UniqOperator<List<T>[],I>,
                NavigableCollectionOperator<T,I>,
                NavigatingCollectionOperator<List<T>,I>,
		        DistinguishableOperator<I>,
                CastableToListOperator<I>,
		        SortableOperator<T,I>,
                ExecutableListOperator<T,I>,
                SelectableOperator<List<T>,I>,
                ReplaceableOperator<List<T>,I>,
                ReplaceableIfNullOperator<List<T>,I>,
                ModifiableCollectionOperator<T,I>,
                ConvertibleToArrayOperator<T,I>,
                ConvertibleToSetOperator<I>,
                ConvertibleToMapOperator<T,I> {



    public Level1ArrayOfListElementsSelectedOperator<T,I> ifIndex(final int... indices);
    public Level1ArrayOfListElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListElementsSelectedOperator<T,I> ifNull();
    public Level1ArrayOfListElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListElementsSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level1ArrayOfListElementsSelectedOperator<T,I> ifNotNull();
    public Level1ArrayOfListElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval);


            
    public Level2ArrayOfListElementsElementsOperator<T,I> forEach();
    
    public Level0ArrayOfListOperator<T,I> endFor();

    public Level1ArrayOfListElementsOperator<T,I> distinct();
    
    public Level1ArrayOfListElementsOperator<T,I> sort();
    public Level1ArrayOfListElementsOperator<T,I> sort(final Comparator<? super T> comparator);
        
    public Level1ArrayOfListElementsOperator<T,I> add(final T newElement);
    public Level1ArrayOfListElementsOperator<T,I> addAll(final T... newElements);
    public Level1ArrayOfListElementsOperator<T,I> insert(final int position, final T newElement);
    public Level1ArrayOfListElementsOperator<T,I> insertAll(final int position, final T... newElements);
    public Level1ArrayOfListElementsOperator<T,I> addAll(final Collection<T> collection);
    public Level1ArrayOfListElementsOperator<T,I> removeAllIndexes(final int... indices);
    public Level1ArrayOfListElementsOperator<T,I> removeAllEqual(final T... values);
    public Level1ArrayOfListElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfListElementsOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level1ArrayOfListElementsOperator<T,I> removeAllNull();
    
    public Level1ArrayOfArrayElementsOperator<T,I> toArray(final Type<T> of);
    
    
    public Level1ArrayOfSetElementsOperator<T,I> toSet();
    
    public Level1ArrayOfMapElementsOperator<T,T,I> toMap();
    public <K> Level1ArrayOfMapElementsOperator<K,T,I> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level1ArrayOfMapElementsOperator<K,V,I> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level1ArrayOfListElementsOperator<T,I> replaceWith(final List<T> replacement);
    public Level1ArrayOfListElementsOperator<T,I> replaceIfNullWith(final List<T> replacement);


    public <X> Level1ArrayOfListElementsOperator<X,I> convert(final IConverter<? extends List<X>,? super List<T>> converter);
    
    public <X> Level1ArrayOfListElementsOperator<X,I> eval(final IEvaluator<? extends List<X>,? super List<T>> eval);

    public <X> Level1ArrayOfListElementsOperator<X,I> exec(final IFunction<? extends List<X>, ? super List<T>> function);

    public <X> Level1ArrayElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<T>> function);
    
    public <X> Level1ArrayElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super List<T>> eval);
    
    public <X> Level1ArrayElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super List<T>> converter);    
    
    
    
    public <X> Level1ArrayOfListElementsOperator<X,I> asListOf(final Type<X> type);
    public Level1ArrayOfListElementsOperator<?,I> asListOfUnknown();
    
		                    
}

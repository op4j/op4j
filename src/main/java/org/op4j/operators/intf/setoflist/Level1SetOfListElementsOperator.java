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
package org.op4j.operators.intf.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
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
public interface Level1SetOfListElementsOperator<T,I>
        extends UniqOperator<Set<List<T>>,I>,
                NavigableCollectionOperator<T,I>,
                NavigatingCollectionOperator<List<T>,I>,
		        DistinguishableOperator<I>,
		        SortableOperator<T,I>,
		        CastableToListOperator<I>,
                ExecutableListOperator<T,I>,
                ModifiableCollectionOperator<T,I>,
                SelectableOperator<List<T>,I>,
                ReplaceableOperator<List<T>,I>,
                ReplaceableIfNullOperator<List<T>,I>,
                ConvertibleToArrayOperator<T,I>,
                ConvertibleToSetOperator<I>,
                ConvertibleToMapOperator<T,I> {



    public Level1SetOfListElementsSelectedOperator<T,I> ifIndex(final int... indices);
    public Level1SetOfListElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListElementsSelectedOperator<T,I> ifNull();
    public Level1SetOfListElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListElementsSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level1SetOfListElementsSelectedOperator<T,I> ifNotNull();
    public Level1SetOfListElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval);


    
    public Level2SetOfListElementsElementsOperator<T,I> forEach();
    
    public Level0SetOfListOperator<T,I> endFor();

    public Level1SetOfListElementsOperator<T,I> distinct();
    
    public Level1SetOfListElementsOperator<T,I> sort();
    public Level1SetOfListElementsOperator<T,I> sort(final Comparator<? super T> comparator);
        
    public Level1SetOfListElementsOperator<T,I> add(final T newElement);
    public Level1SetOfListElementsOperator<T,I> addAll(final T... newElements);
    public Level1SetOfListElementsOperator<T,I> insert(final int position, final T newElement);
    public Level1SetOfListElementsOperator<T,I> insertAll(final int position, final T... newElements);
    public Level1SetOfListElementsOperator<T,I> addAll(final Collection<T> collection);
    public Level1SetOfListElementsOperator<T,I> removeAllIndexes(final int... indices);
    public Level1SetOfListElementsOperator<T,I> removeAllEqual(final T... values);
    public Level1SetOfListElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListElementsOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level1SetOfListElementsOperator<T,I> removeAllNull();
    public Level1SetOfArrayElementsOperator<T,I> toArray(final Type<T> of);
    
    
    public Level1SetOfSetElementsOperator<T,I> toSet();
    
    public Level1SetOfMapElementsOperator<T,T,I> toMap();
    public <K> Level1SetOfMapElementsOperator<K,T,I> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level1SetOfMapElementsOperator<K,V,I> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level1SetOfListElementsOperator<T,I> replaceWith(final List<T> replacement);
    public Level1SetOfListElementsOperator<T,I> replaceIfNullWith(final List<T> replacement);


    public <X> Level1SetOfListElementsOperator<X,I> convert(final IConverter<? extends List<X>,? super List<T>> converter);
    
    public <X> Level1SetOfListElementsOperator<X,I> eval(final IEvaluator<? extends List<X>,? super List<T>> eval);

    public <X> Level1SetOfListElementsOperator<X,I> exec(final IFunction<? extends List<X>, ? super List<T>> function);

    public <X> Level1SetElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<T>> function);
    
    public <X> Level1SetElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super List<T>> eval);
    
    public <X> Level1SetElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super List<T>> converter);    
    
    
    
    public <X> Level1SetOfListElementsOperator<X,I> asListOf(final Type<X> type);
    public Level1SetOfListElementsOperator<?,I> asListOfUnknown();
    
                                    
}

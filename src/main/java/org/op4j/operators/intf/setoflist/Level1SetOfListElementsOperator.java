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
public interface Level1SetOfListElementsOperator<T>
        extends UniqOperator<Set<List<T>>>,
                NavigableCollectionOperator<T>,
                NavigatingCollectionOperator<List<T>>,
		        DistinguishableOperator,
		        SortableOperator<T>,
		        CastableToListOperator,
                ExecutableListOperator<T>,
                ModifiableCollectionOperator<T>,
                SelectableOperator<List<T>>,
                ReplaceableOperator<List<T>>,
                ReplaceableIfNullOperator<List<T>>,
                ConvertibleToArrayOperator<T>,
                ConvertibleToSetOperator,
                ConvertibleToMapOperator<T> {



    public Level1SetOfListElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1SetOfListElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListElementsSelectedOperator<T> ifNull();
    public Level1SetOfListElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1SetOfListElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1SetOfListElementsSelectedOperator<T> ifNotNull();
    public Level1SetOfListElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval);


    
    public Level2SetOfListElementsElementsOperator<T> forEach();
    
    public Level0SetOfListOperator<T> endFor();

    public Level1SetOfListElementsOperator<T> distinct();
    
    public Level1SetOfListElementsOperator<T> sort();
    public Level1SetOfListElementsOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level1SetOfListElementsOperator<T> add(final T newElement);
    public Level1SetOfListElementsOperator<T> addAll(final T... newElements);
    public Level1SetOfListElementsOperator<T> insert(final int position, final T newElement);
    public Level1SetOfListElementsOperator<T> insertAll(final int position, final T... newElements);
    public Level1SetOfListElementsOperator<T> addAll(final Collection<T> collection);
    public Level1SetOfListElementsOperator<T> removeAllIndexes(final int... indices);
    public Level1SetOfListElementsOperator<T> removeAllEqual(final T... values);
    public Level1SetOfListElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetOfListElementsOperator<T> removeAllIndexesNot(final int... indices);
    public Level1SetOfListElementsOperator<T> removeAllNull();
    public Level1SetOfArrayElementsOperator<T> toArrayOf(final Type<T> type);
    
    
    public Level1SetOfSetElementsOperator<T> toSet();
    
    public Level1SetOfMapElementsOperator<T,T> toMap();
    public <K> Level1SetOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level1SetOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level1SetOfListElementsOperator<T> replaceWith(final List<T> replacement);
    public Level1SetOfListElementsOperator<T> replaceIfNullWith(final List<T> replacement);


    public <X> Level1SetOfListElementsOperator<X> convert(final IConverter<? extends List<X>,? super List<T>> converter);
    
    public <X> Level1SetOfListElementsOperator<X> eval(final IEvaluator<? extends List<X>,? super List<T>> eval);

    public <X> Level1SetOfListElementsOperator<X> exec(final IFunction<? extends List<X>, ? super List<T>> function);

    public <X> Level1SetElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<T>> function);
    
    public <X> Level1SetElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super List<T>> eval);
    
    public <X> Level1SetElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super List<T>> converter);    
    
    
    
    public <X> Level1SetOfListElementsOperator<X> asListOf(final Type<X> type);
    public Level1SetOfListElementsOperator<?> asListOfUnknown();
    
                                    
}

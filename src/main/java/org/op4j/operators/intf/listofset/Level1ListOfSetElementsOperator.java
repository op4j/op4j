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
package org.op4j.operators.intf.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.qualities.CastableToSetOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ExecutableSetOperator;
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
public interface Level1ListOfSetElementsOperator<T,I>
        extends UniqOperator<List<Set<T>>,I>,
                NavigableCollectionOperator<T,I>,
                NavigatingCollectionOperator<Set<T>,I>,
		        SortableOperator<T,I>,
		        CastableToSetOperator<I>,
                ExecutableSetOperator<T,I>,
                ModifiableCollectionOperator<T,I>,
                ConvertibleToArrayOperator<T,I>,
                ConvertibleToListOperator<I>,
                SelectableOperator<Set<T>,I>,
                ReplaceableOperator<Set<T>,I>,
                ReplaceableIfNullOperator<Set<T>,I>,
                ConvertibleToMapOperator<T,I> {



    public Level1ListOfSetElementsSelectedOperator<T,I> ifIndex(final int... indices);
    public Level1ListOfSetElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetElementsSelectedOperator<T,I> ifNull();
    public Level1ListOfSetElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetElementsSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level1ListOfSetElementsSelectedOperator<T,I> ifNotNull();
    public Level1ListOfSetElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval);


    
    public Level2ListOfSetElementsElementsOperator<T,I> forEach();
    
    public Level0ListOfSetOperator<T,I> endFor();
    
    public Level1ListOfSetElementsOperator<T,I> sort();
    public Level1ListOfSetElementsOperator<T,I> sort(final Comparator<? super T> comparator);
        
    public Level1ListOfSetElementsOperator<T,I> add(final T newElement);
    public Level1ListOfSetElementsOperator<T,I> addAll(final T... newElements);
    public Level1ListOfSetElementsOperator<T,I> insert(final int position, final T newElement);
    public Level1ListOfSetElementsOperator<T,I> insertAll(final int position, final T... newElements);
    public Level1ListOfSetElementsOperator<T,I> addAll(final Collection<T> collection);
    public Level1ListOfSetElementsOperator<T,I> removeAllIndexes(final int... indices);
    public Level1ListOfSetElementsOperator<T,I> removeAllEqual(final T... values);
    public Level1ListOfSetElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level1ListOfSetElementsOperator<T,I> removeAllNull();
    public Level1ListOfArrayElementsOperator<T,I> toArray(final Type<T> of);
    
    
    public Level1ListOfListElementsOperator<T,I> toList();
    
    public Level1ListOfMapElementsOperator<T,T,I> toMap();
    public <K> Level1ListOfMapElementsOperator<K,T,I> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level1ListOfMapElementsOperator<K,V,I> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level1ListOfSetElementsOperator<T,I> replaceWith(final Set<T> replacement);
    public Level1ListOfSetElementsOperator<T,I> replaceIfNullWith(final Set<T> replacement);


    public <X> Level1ListOfSetElementsOperator<X,I> convert(final IConverter<? extends Set<X>,? super Set<T>> converter);
    
    public <X> Level1ListOfSetElementsOperator<X,I> eval(final IEvaluator<? extends Set<X>,? super Set<T>> eval);

    public <X> Level1ListOfSetElementsOperator<X,I> exec(final IFunction<? extends Set<X>,? super Set<T>> function);

    public <X> Level1ListElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T>> function);
    
    public <X> Level1ListElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Set<T>> eval);
    
    public <X> Level1ListElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super Set<T>> converter);    
    
    
    
    public <X> Level1ListOfSetElementsOperator<X,I> asSetOf(final Type<X> type);
    public Level1ListOfSetElementsOperator<?,I> asSetOfUnknown();
    
                                    
}

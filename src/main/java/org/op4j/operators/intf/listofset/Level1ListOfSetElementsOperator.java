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
public interface Level1ListOfSetElementsOperator<T>
        extends UniqOperator<List<Set<T>>>,
                NavigableCollectionOperator<T>,
                NavigatingCollectionOperator<Set<T>>,
		        SortableOperator<T>,
		        CastableToSetOperator,
                ExecutableSetOperator<T>,
                ModifiableCollectionOperator<T>,
                ConvertibleToArrayOperator<T>,
                ConvertibleToListOperator,
                SelectableOperator<Set<T>>,
                ReplaceableOperator<Set<T>>,
                ReplaceableIfNullOperator<Set<T>>,
                ConvertibleToMapOperator<T> {



    public Level1ListOfSetElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level1ListOfSetElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetElementsSelectedOperator<T> ifNull();
    public Level1ListOfSetElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ListOfSetElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level1ListOfSetElementsSelectedOperator<T> ifNotNull();
    public Level1ListOfSetElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval);


    
    public Level2ListOfSetElementsElementsOperator<T> forEach();
    
    public Level0ListOfSetOperator<T> endFor();
    
    public Level1ListOfSetElementsOperator<T> sort();
    public Level1ListOfSetElementsOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level1ListOfSetElementsOperator<T> add(final T newElement);
    public Level1ListOfSetElementsOperator<T> addAll(final T... newElements);
    public Level1ListOfSetElementsOperator<T> insert(final int position, final T newElement);
    public Level1ListOfSetElementsOperator<T> insertAll(final int position, final T... newElements);
    public Level1ListOfSetElementsOperator<T> addAll(final Collection<T> collection);
    public Level1ListOfSetElementsOperator<T> removeAllIndexes(final int... indexes);
    public Level1ListOfSetElementsOperator<T> removeAllEqual(final T... values);
    public Level1ListOfSetElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfSetElementsOperator<T> removeAllIndexesNot(final int... indexes);
    public Level1ListOfSetElementsOperator<T> removeAllNull();
    public Level1ListOfArrayElementsOperator<T> toArrayOf(final Type<T> type);
    
    
    public Level1ListOfListElementsOperator<T> toList();
    
    public Level1ListOfMapElementsOperator<T,T> toMap();
    public <K> Level1ListOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level1ListOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level1ListOfSetElementsOperator<T> replaceWith(final Set<T> replacement);
    public Level1ListOfSetElementsOperator<T> replaceIfNullWith(final Set<T> replacement);


    public <X> Level1ListOfSetElementsOperator<X> convertAsSet(final IConverter<? extends Set<X>,? super Set<T>> converter);
    
    public <X> Level1ListOfSetElementsOperator<X> evalAsSet(final IEvaluator<? extends Set<X>,? super Set<T>> eval);

    public <X> Level1ListOfSetElementsOperator<X> execAsSet(final IFunction<? extends Set<X>,? super Set<T>> function);

    public <X> Level1ListElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T>> function);
    
    public <X> Level1ListElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Set<T>> eval);
    
    public <X> Level1ListElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super Set<T>> converter);    
    
    
    
    public <X> Level1ListOfSetElementsOperator<X> asSetOf(final Type<X> type);
    public Level1ListOfSetElementsOperator<?> asSetOfUnknown();
    
                                    
}

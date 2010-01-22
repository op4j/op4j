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
package org.op4j.operators.intf.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
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
public interface Level1ArrayOfSetElementsOperator<T,I>
        extends UniqOperator<Set<T>[],I>,
                NavigableCollectionOperator<T,I>,
                NavigatingCollectionOperator<Set<T>,I>,
		        SortableOperator<T,I>,
		        CastableToSetOperator<I>,
                ModifiableCollectionOperator<T,I>,
                ExecutableSetOperator<T,I>,
                SelectableOperator<Set<T>,I>,
                ReplaceableOperator<Set<T>,I>,
                ReplaceableIfNullOperator<Set<T>,I>,
                ConvertibleToArrayOperator<T,I>,
                ConvertibleToListOperator<I>,
                ConvertibleToMapOperator<T,I> {



    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifIndex(final int... indices);
    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifNull();
    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifNotNull();
    public Level1ArrayOfSetElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval);


    
    public Level2ArrayOfSetElementsElementsOperator<T,I> forEach();
    
    public Level0ArrayOfSetOperator<T,I> endFor();
    
    public Level1ArrayOfSetElementsOperator<T,I> sort();
    public Level1ArrayOfSetElementsOperator<T,I> sort(final Comparator<? super T> comparator);
        
    public Level1ArrayOfSetElementsOperator<T,I> add(final T newElement);
    public Level1ArrayOfSetElementsOperator<T,I> addAll(final T... newElements);
    public Level1ArrayOfSetElementsOperator<T,I> insert(final int position, final T newElement);
    public Level1ArrayOfSetElementsOperator<T,I> insertAll(final int position, final T... newElements);
    public Level1ArrayOfSetElementsOperator<T,I> addAll(final Collection<T> collection);
    public Level1ArrayOfSetElementsOperator<T,I> removeAllIndexes(final int... indices);
    public Level1ArrayOfSetElementsOperator<T,I> removeAllEqual(final T... values);
    public Level1ArrayOfSetElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level1ArrayOfSetElementsOperator<T,I> removeAllNull();
    public Level1ArrayOfArrayElementsOperator<T,I> toArray(final Type<T> of);
    
    
    public Level1ArrayOfListElementsOperator<T,I> toList();
    
    public Level1ArrayOfMapElementsOperator<T,T,I> toMap();
    public <K> Level1ArrayOfMapElementsOperator<K,T,I> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level1ArrayOfMapElementsOperator<K,V,I> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level1ArrayOfSetElementsOperator<T,I> replaceWith(final Set<T> replacement);
    public Level1ArrayOfSetElementsOperator<T,I> replaceIfNullWith(final Set<T> replacement);


    public <X> Level1ArrayOfSetElementsOperator<X,I> convert(final IConverter<? extends Set<X>,? super Set<T>> converter);
    
    public <X> Level1ArrayOfSetElementsOperator<X,I> eval(final IEvaluator<? extends Set<X>,? super Set<T>> eval);

    public <X> Level1ArrayOfSetElementsOperator<X,I> exec(final IFunction<? extends Set<X>, ? super Set<T>> function);

    public <X> Level1ArrayElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T>> function);
    
    public <X> Level1ArrayElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Set<T>> eval);
    
    public <X> Level1ArrayElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super Set<T>> converter);    
    
    
    
    public <X> Level1ArrayOfSetElementsOperator<X,I> asSetOf(final Type<X> type);
    public Level1ArrayOfSetElementsOperator<?,I> asSetOfUnknown();
    
		                            
}

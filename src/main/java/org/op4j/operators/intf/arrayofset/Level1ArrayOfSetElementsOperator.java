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
public interface Level1ArrayOfSetElementsOperator<T>
        extends UniqOperator<Set<T>[]>,
                NavigableCollectionOperator<T>,
                NavigatingCollectionOperator<Set<T>>,
		        SortableOperator<T>,
		        CastableToSetOperator,
                ModifiableCollectionOperator<T>,
                ExecutableSetOperator<T>,
                SelectableOperator<Set<T>>,
                ConvertibleToArrayOperator<T>,
                ConvertibleToListOperator,
                ConvertibleToMapOperator<T> {



    public Level1ArrayOfSetElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1ArrayOfSetElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> ifNull();
    public Level1ArrayOfSetElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1ArrayOfSetElementsSelectedOperator<T> ifNotNull();
    public Level1ArrayOfSetElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval);


    
    public Level2ArrayOfSetElementsElementsOperator<T> forEach();
    
    public Level0ArrayOfSetOperator<T> endFor();
    
    public Level1ArrayOfSetElementsOperator<T> sort();
    public Level1ArrayOfSetElementsOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level1ArrayOfSetElementsOperator<T> add(final T... newElements);
    public Level1ArrayOfSetElementsOperator<T> insert(final int position, final T... newElements);
    public Level1ArrayOfSetElementsOperator<T> addAll(final Collection<T> collection);
    public Level1ArrayOfSetElementsOperator<T> removeAllIndexes(final int... indices);
    public Level1ArrayOfSetElementsOperator<T> removeAllEqual(final T... values);
    public Level1ArrayOfSetElementsOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T> removeAllIndexesNot(final int... indices);
    public Level1ArrayOfSetElementsOperator<T> removeAllNull();
    public Level1ArrayOfArrayElementsOperator<T> toArray(final Type<T> of);
    
    
    public Level1ArrayOfListElementsOperator<T> toList();
    
    public Level1ArrayOfMapElementsOperator<T,T> toMap();
    public <K> Level1ArrayOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level1ArrayOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public <X> Level1ArrayOfSetElementsOperator<X> convert(final IConverter<? extends Set<X>,? super Set<T>> converter);
    
    public <X> Level1ArrayOfSetElementsOperator<X> eval(final IEvaluator<? extends Set<X>,? super Set<T>> eval);

    public <X> Level1ArrayOfSetElementsOperator<X> exec(final IFunction<? extends Set<X>, ? super Set<T>> function);

    public <X> Level1ArrayElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T>> function);
    
    public <X> Level1ArrayElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Set<T>> eval);
    
    public <X> Level1ArrayElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super Set<T>> converter);    
    
    
    
    public <X> Level1ArrayOfSetElementsOperator<X> asSetOf(final Type<X> type);
    public Level1ArrayOfSetElementsOperator<?> asSetOfUnknown();
    
		                            
}

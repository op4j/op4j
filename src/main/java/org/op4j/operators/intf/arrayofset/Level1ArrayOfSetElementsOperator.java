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
import org.op4j.operators.qualities.ConvertibleOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.EvaluableOperator;
import org.op4j.operators.qualities.ExecutableOperator;
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
                ExecutableOperator<Set<T>>,
                ConvertibleOperator<Set<T>>,
                SelectableOperator<Set<T>>,
                EvaluableOperator<Set<T>>,
                ConvertibleToArrayOperator<T>,
                ConvertibleToListOperator,
                ConvertibleToMapOperator<T> {



    public Level1ArrayOfSetElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1ArrayOfSetElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> ifNull();
    public Level1ArrayOfSetElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level1ArrayOfSetElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1ArrayOfSetElementsSelectedOperator<T> ifNotNull();
    public Level1ArrayOfSetElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval);


    
    public Level2ArrayOfSetElementsElementsOperator<T> forEach();
    
    public Level0ArrayOfSetOperator<T> endFor();
    
    public Level1ArrayOfSetElementsOperator<T> sort();
    public Level1ArrayOfSetElementsOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level1ArrayOfSetElementsOperator<T> add(final T... newElements);
    public Level1ArrayOfSetElementsOperator<T> insert(final int position, final T... newElements);
    public Level1ArrayOfSetElementsOperator<T> addAll(final Collection<T> collection);
    public Level1ArrayOfSetElementsOperator<T> removeIndexes(final int... indices);
    public Level1ArrayOfSetElementsOperator<T> removeEquals(final T... values);
    public Level1ArrayOfSetElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayOfSetElementsOperator<T> removeIndexesNot(final int... indices);
    public Level1ArrayOfSetElementsOperator<T> removeNulls();
    public Level1ArrayOfArrayElementsOperator<T> toArray(final Type<T> of);
    
    
    public Level1ArrayOfListElementsOperator<T> toList();
    
    public Level1ArrayOfMapElementsOperator<T,T> toMap();
    public <K> Level1ArrayOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level1ArrayOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public <X> Level1ArrayElementsOperator<X> convert(final IConverter<X,? super Set<T>> converter);
    
    public <X> Level1ArrayElementsOperator<X> eval(final IEvaluator<X,? super Set<T>> eval);

    public <X> Level1ArrayElementsOperator<X> exec(final IFunction<X, ? super Set<T>> function);
    
    
    
    public <X> Level1ArrayOfSetElementsOperator<X> asSetOf(final Type<X> type);
    public Level1ArrayOfSetElementsOperator<?> asSetOfUnknown();
    
		                            
}

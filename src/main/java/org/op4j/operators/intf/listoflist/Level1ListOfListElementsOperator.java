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
package org.op4j.operators.intf.listoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.ConvertibleOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
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
public interface Level1ListOfListElementsOperator<T>
        extends UniqOperator<List<List<T>>>,
                NavigableCollectionOperator<T>,
                NavigatingCollectionOperator<List<T>>,
		        DistinguishableOperator,
		        CastableToListOperator,
		        SortableOperator<T>,
                SelectableOperator<List<T>>,
                ExecutableOperator<List<T>>,
                ConvertibleOperator<List<T>>,
                EvaluableOperator<List<T>>,
                ModifiableCollectionOperator<T>,
                ConvertibleToArrayOperator<T>,
                ConvertibleToSetOperator,
                ConvertibleToMapOperator<T> {



    public Level1ListOfListElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1ListOfListElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ListOfListElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ListOfListElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ListOfListElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ListOfListElementsSelectedOperator<T> ifNull();
    public Level1ListOfListElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level1ListOfListElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1ListOfListElementsSelectedOperator<T> ifNotNull();
    public Level1ListOfListElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval);


    
    public Level2ListOfListElementsElementsOperator<T> forEach();
    
    public Level0ListOfListOperator<T> endFor();

    public Level1ListOfListElementsOperator<T> distinct();
    
    public Level1ListOfListElementsOperator<T> sort();
    public Level1ListOfListElementsOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level1ListOfListElementsOperator<T> add(final T... newElements);
    public Level1ListOfListElementsOperator<T> insert(final int position, final T... newElements);
    public Level1ListOfListElementsOperator<T> addAll(final Collection<T> collection);
    public Level1ListOfListElementsOperator<T> removeIndexes(final int... indices);
    public Level1ListOfListElementsOperator<T> removeEquals(final T... values);
    public Level1ListOfListElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfListElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfListElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfListElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfListElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfListElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListOfListElementsOperator<T> removeIndexesNot(final int... indices);
    public Level1ListOfListElementsOperator<T> removeNulls();
    public Level1ListOfArrayElementsOperator<T> toArray(final Type<T> of);
    
    
    public Level1ListOfSetElementsOperator<T> toSet();
    
    public Level1ListOfMapElementsOperator<T,T> toMap();
    public <K> Level1ListOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level1ListOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public <X> Level1ListElementsOperator<X> convert(final IConverter<X,? super List<T>> converter);
    
    public <X> Level1ListElementsOperator<X> eval(final IEvaluator<X,? super List<T>> eval);

    public <X> Level1ListElementsOperator<X> exec(final IFunction<X, ? super List<T>> function);
    
    
    
    public <X> Level1ListOfListElementsOperator<X> asListOf(final Type<X> type);
    public Level1ListOfListElementsOperator<?> asListOfUnknown();
    
                                    
}

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
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.qualities.CastableToSetOfListOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfListOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToListOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOfListOperator;
import org.op4j.operators.qualities.ConvertibleToListOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToListOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfSetOperator;
import org.op4j.operators.qualities.ExecutableSetOfListOperator;
import org.op4j.operators.qualities.FlattenableAsSetOperator;
import org.op4j.operators.qualities.GenerizableOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
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
public interface Level0SetOfListOperator<T>
        extends UniqOperator<Set<List<T>>>,
                NavigableCollectionOperator<List<T>>,
		        SortableOperator<List<T>>,
                CastableToSetOfListOperator,
                FlattenableAsSetOperator<T>,
		        ModifiableCollectionOperator<List<T>>,
		        GenerizableOperator<Set<List<T>>>,
                ExecutableSetOfListOperator<T>,
                SelectableOperator<Set<List<T>>>,
                ReplaceableOperator<Set<List<T>>>,
                ReplaceableIfNullOperator<Set<List<T>>>,
                ConvertibleToArrayOfArrayOperator<T>,
                ConvertibleToArrayOfListOperator<T>,
                ConvertibleToArrayOfSetOperator<T>,
                ConvertibleToListOfArrayOperator<T>,
                ConvertibleToListOfListOperator<T>,
                ConvertibleToListOfSetOperator<T>,
                ConvertibleToSetOfArrayOperator<T>,
                ConvertibleToSetOfSetOperator<T>,
                ConvertibleToArrayOfMapOperator<T>,
                ConvertibleToListOfMapOperator<T>,
                ConvertibleToSetOfMapOperator<T> {



    public Level0SetOfListSelectedOperator<T> ifIndex(final int... indexes);
    public Level0SetOfListSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super Set<List<T>>> eval);
    public Level0SetOfListSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super Set<List<T>>> eval);
    public Level0SetOfListSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<List<T>>> eval);
    public Level0SetOfListSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<List<T>>> eval);
    public Level0SetOfListSelectedOperator<T> ifNull();
    public Level0SetOfListSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<List<T>>> eval);
    public Level0SetOfListSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level0SetOfListSelectedOperator<T> ifNotNull();
    public Level0SetOfListSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<List<T>>> eval);


    
    public Level1SetOfListElementsOperator<T> forEach();
    
    public Level0SetOfListOperator<T> sort();
    public Level0SetOfListOperator<T> sort(final Comparator<? super List<T>> comparator);
        
    public Level0SetOperator<T> flatten();
    public Level0SetOfListOperator<T> add(final List<T> newElement);
    public Level0SetOfListOperator<T> addAll(final List<T>... newElements);
    public Level0SetOfListOperator<T> insert(final int position, final List<T> newElement);
    public Level0SetOfListOperator<T> insertAll(final int position, final List<T>... newElements);
    public Level0SetOfListOperator<T> addAll(final Collection<List<T>> collection);
    public Level0SetOfListOperator<T> removeAllIndexes(final int... indexes);
    public Level0SetOfListOperator<T> removeAllEqual(final List<T>... values);
    public Level0SetOfListOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0SetOfListOperator<T> removeAllIndexesNot(final int... indexes);
    public Level0SetOfListOperator<T> removeAllNull();
    
    public Level0ArrayOfArrayOperator<T> toArrayOfArrayOf(final Type<T> type);
    
    public Level0ArrayOfListOperator<T> toArrayOfList();
    
    public Level0ArrayOfSetOperator<T> toArrayOfSet();
    
    public Level0ListOfArrayOperator<T> toListOfArrayOf(final Type<T> type);
    
    
    public Level0ListOfListOperator<T> toListOfList();
    
    public Level0ListOfSetOperator<T> toListOfSet();
    
    public Level0SetOfArrayOperator<T> toSetOfArrayOf(final Type<T> type);
    
    
    public Level0SetOfSetOperator<T> toSetOfSet();
    
    public Level0ArrayOfMapOperator<T,T> toArrayOfMap();
    public <K> Level0ArrayOfMapOperator<K,T> toArrayOfMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0ArrayOfMapOperator<K,V> toArrayOfMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    public Level0ListOfMapOperator<T,T> toListOfMap();
    public <K> Level0ListOfMapOperator<K,T> toListOfMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0ListOfMapOperator<K,V> toListOfMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    public Level0SetOfMapOperator<T,T> toSetOfMap();
    public <K> Level0SetOfMapOperator<K,T> toSetOfMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0SetOfMapOperator<K,V> toSetOfMap(final IMapBuilder<K,V,? super T> mapBuild);


    
    public Level0GenericUniqOperator<Set<List<T>>> generic();



    
    public Level0SetOfListOperator<T> replaceWith(final Set<List<T>> replacement);
    public Level0SetOfListOperator<T> replaceIfNullWith(final Set<List<T>> replacement);


    public <X> Level0SetOfListOperator<X> convert(final IConverter<? extends Set<? extends List<X>>,? super Set<List<T>>> converter);
    
    public <X> Level0SetOfListOperator<X> eval(final IEvaluator<? extends Set<? extends List<X>>,? super Set<List<T>>> eval);

    public <X> Level0SetOfListOperator<X> exec(final IFunction<? extends Set<? extends List<X>>, ? super Set<List<T>>> function);

    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<List<T>>> function);
    
    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Set<List<T>>> eval);
    
    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super Set<List<T>>> converter);    
    
    
    
    public <X> Level0SetOfListOperator<X> asSetOfListOf(final Type<X> type);
    public Level0SetOfListOperator<?> asSetOfListOfUnknown();

    
    
}

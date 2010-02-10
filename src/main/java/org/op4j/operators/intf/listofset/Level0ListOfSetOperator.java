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
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.qualities.CastableToListOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfListOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToListOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOfListOperator;
import org.op4j.operators.qualities.ConvertibleToListOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfListOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListOfSetOperator;
import org.op4j.operators.qualities.FlattenableAsListOperator;
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
public interface Level0ListOfSetOperator<T>
        extends UniqOperator<List<Set<T>>>,
                NavigableCollectionOperator<Set<T>>,
		        DistinguishableOperator,
		        SortableOperator<Set<T>>,
		        CastableToListOfSetOperator,
                FlattenableAsListOperator<T>,
		        ModifiableCollectionOperator<Set<T>>,
		        GenerizableOperator<List<Set<T>>>,
                ExecutableListOfSetOperator<T>,
                SelectableOperator<List<Set<T>>>,
                ReplaceableOperator<List<Set<T>>>,
                ReplaceableIfNullOperator<List<Set<T>>>,
                ConvertibleToArrayOfArrayOperator<T>,
                ConvertibleToArrayOfListOperator<T>,
                ConvertibleToArrayOfSetOperator<T>,
                ConvertibleToListOfArrayOperator<T>,
                ConvertibleToListOfListOperator<T>,
                ConvertibleToSetOfArrayOperator<T>,
                ConvertibleToSetOfListOperator<T>,
                ConvertibleToSetOfSetOperator<T>,
                ConvertibleToArrayOfMapOperator<T>,
                ConvertibleToListOfMapOperator<T>,
                ConvertibleToSetOfMapOperator<T> {



    public Level0ListOfSetSelectedOperator<T> ifIndex(final int... indexes);
    public Level0ListOfSetSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super List<Set<T>>> eval);
    public Level0ListOfSetSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super List<Set<T>>> eval);
    public Level0ListOfSetSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super List<Set<T>>> eval);
    public Level0ListOfSetSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<Set<T>>> eval);
    public Level0ListOfSetSelectedOperator<T> ifNull();
    public Level0ListOfSetSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super List<Set<T>>> eval);
    public Level0ListOfSetSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level0ListOfSetSelectedOperator<T> ifNotNull();
    public Level0ListOfSetSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<Set<T>>> eval);



    public Level1ListOfSetElementsOperator<T> forEach();

    public Level0ListOfSetOperator<T> distinct();
    
    public Level0ListOfSetOperator<T> sort();
    public Level0ListOfSetOperator<T> sort(final Comparator<? super Set<T>> comparator);
        
    public Level0ListOperator<T> flatten();
    public Level0ListOfSetOperator<T> add(final Set<T> newElement);
    public Level0ListOfSetOperator<T> addAll(final Set<T>... newElements);
    public Level0ListOfSetOperator<T> insert(final int position, final Set<T> newElement);
    public Level0ListOfSetOperator<T> insertAll(final int position, final Set<T>... newElements);
    public Level0ListOfSetOperator<T> addAll(final Collection<Set<T>> collection);
    public Level0ListOfSetOperator<T> removeAllIndexes(final int... indexes);
    public Level0ListOfSetOperator<T> removeAllEqual(final Set<T>... values);
    public Level0ListOfSetOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ListOfSetOperator<T> removeAllIndexesNot(final int... indexes);
    public Level0ListOfSetOperator<T> removeAllNull();
    
    
    public Level0ArrayOfArrayOperator<T> toArrayOfArrayOf(final Type<T> type);
    
    public Level0ArrayOfListOperator<T> toArrayOfList();
    
    public Level0ArrayOfSetOperator<T> toArrayOfSet();
    
    public Level0ListOfArrayOperator<T> toListOfArrayOf(final Type<T> type);
    
    
    public Level0ListOfListOperator<T> toListOfList();
    
    public Level0SetOfArrayOperator<T> toSetOfArrayOf(final Type<T> type);
    
    
    public Level0SetOfListOperator<T> toSetOfList();
    
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


    
    public Level0GenericUniqOperator<List<Set<T>>> generic();

    
    
    
    public Level0ListOfSetOperator<T> replaceWith(final List<Set<T>> replacement);
    public Level0ListOfSetOperator<T> replaceIfNullWith(final List<Set<T>> replacement);


    public <X> Level0ListOfSetOperator<X> convertAsListOfSet(final IConverter<? extends List<? extends Set<X>>,? super List<Set<T>>> converter);
    
    public <X> Level0ListOfSetOperator<X> evalAsListOfSet(final IEvaluator<? extends List<? extends Set<X>>,? super List<Set<T>>> eval);

    public <X> Level0ListOfSetOperator<X> execAsListOfSet(final IFunction<? extends List<? extends Set<X>>,? super List<Set<T>>> function);

    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super List<Set<T>>> function);
    
    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X,? super List<Set<T>>> eval);
    
    public <X> Level0GenericUniqOperator<X> convert(final IConverter<X,? super List<Set<T>>> converter);    
    
    
    public <X> Level0ListOfSetOperator<X> asListOfSetOf(final Type<X> type);
    public Level0ListOfSetOperator<?> asListOfSetOfUnknown();

    
}

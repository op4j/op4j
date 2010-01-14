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
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.qualities.CastableToListOfListOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfListOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToListOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToListOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfListOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListOfListOperator;
import org.op4j.operators.qualities.FlattenableAsListOperator;
import org.op4j.operators.qualities.GenerizableOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
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
public interface Level0ListOfListOperator<T>
        extends UniqOperator<List<List<T>>>,
                NavigableCollectionOperator<List<T>>,
		        DistinguishableOperator,
		        SortableOperator<List<T>>,
		        CastableToListOfListOperator,
                FlattenableAsListOperator<T>,
		        ModifiableCollectionOperator<List<T>>,
		        GenerizableOperator<List<List<T>>>,
                ExecutableListOfListOperator<T>,
                SelectableOperator<List<List<T>>>,
                ConvertibleToArrayOfArrayOperator<T>,
                ConvertibleToArrayOfListOperator<T>,
                ConvertibleToArrayOfSetOperator<T>,
                ConvertibleToListOfArrayOperator<T>,
                ConvertibleToListOfSetOperator<T>,
                ConvertibleToSetOfArrayOperator<T>,
                ConvertibleToSetOfListOperator<T>,
                ConvertibleToSetOfSetOperator<T>,
                ConvertibleToArrayOfMapOperator<T>,
                ConvertibleToListOfMapOperator<T>,
                ConvertibleToSetOfMapOperator<T> {



    public Level0ListOfListSelectedOperator<T> ifIndex(final int... indices);
    public Level0ListOfListSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super List<List<T>>> eval);
    public Level0ListOfListSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super List<List<T>>> eval);
    public Level0ListOfListSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<List<T>>> eval);
    public Level0ListOfListSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<List<T>>> eval);
    public Level0ListOfListSelectedOperator<T> ifNull();
    public Level0ListOfListSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super List<List<T>>> eval);
    public Level0ListOfListSelectedOperator<T> ifIndexNot(final int... indices);
    public Level0ListOfListSelectedOperator<T> ifNotNull();
    public Level0ListOfListSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super List<List<T>>> eval);



    public Level1ListOfListElementsOperator<T> forEach();

    public Level0ListOfListOperator<T> distinct();
    
    public Level0ListOfListOperator<T> sort();
    public Level0ListOfListOperator<T> sort(final Comparator<? super List<T>> comparator);
        
    public Level0ListOperator<T> flatten();
    public Level0ListOfListOperator<T> add(final List<T>... newElements);
    public Level0ListOfListOperator<T> insert(final int position, final List<T>... newElements);
    public Level0ListOfListOperator<T> addAll(final Collection<List<T>> collection);
    public Level0ListOfListOperator<T> removeIndexes(final int... indices);
    public Level0ListOfListOperator<T> removeEquals(final List<T>... values);
    public Level0ListOfListOperator<T> removeMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval);
    public Level0ListOfListOperator<T> removeIndexesNot(final int... indices);
    public Level0ListOfListOperator<T> removeNulls();
    public Level0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of);
    
    public Level0ArrayOfListOperator<T> toArrayOfList();
    
    public Level0ArrayOfSetOperator<T> toArrayOfSet();
    
    public Level0ListOfArrayOperator<T> toListOfArray(final Type<T> of);
    
    
    public Level0ListOfSetOperator<T> toListOfSet();
    
    public Level0SetOfArrayOperator<T> toSetOfArray(final Type<T> of);
    
    
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

    
    public Level0GenericUniqOperator<List<List<T>>> generic();

    
    
    
    public <X> Level0ListOfListOperator<X> convert(final IConverter<? extends List<? extends List<X>>,? super List<List<T>>> converter);
    
    public <X> Level0ListOfListOperator<X> eval(final IEvaluator<? extends List<? extends List<X>>,? super List<List<T>>> eval);

    public <X> Level0ListOfListOperator<X> exec(final IFunction<? extends List<? extends List<X>>, ? super List<List<T>>> function);
    
    
    public <X> Level0ListOfListOperator<X> asListOfListOf(final Type<X> type);
    public Level0ListOfListOperator<?> asListOfListOfUnknown();

    
}

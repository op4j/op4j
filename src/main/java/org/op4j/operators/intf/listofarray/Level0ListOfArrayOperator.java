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
package org.op4j.operators.intf.listofarray;

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
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.qualities.CastableToListOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfListOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToListOfListOperator;
import org.op4j.operators.qualities.ConvertibleToListOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToListOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfListOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListOfArrayOperator;
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
public interface Level0ListOfArrayOperator<T>
        extends UniqOperator<List<T[]>>,
                NavigableCollectionOperator<T[]>,
		        DistinguishableOperator,
		        SortableOperator<T[]>,
		        CastableToListOfArrayOperator,
                FlattenableAsListOperator<T>,
		        ModifiableCollectionOperator<T[]>,
		        GenerizableOperator<List<T[]>>,
                ExecutableListOfArrayOperator<T>,
                SelectableOperator<List<T[]>>,
                ConvertibleToArrayOfArrayOperator<T>,
                ConvertibleToArrayOfListOperator<T>,
                ConvertibleToArrayOfSetOperator<T>,
                ConvertibleToListOfListOperator<T>,
                ConvertibleToListOfSetOperator<T>,
                ConvertibleToSetOfArrayOperator<T>,
                ConvertibleToSetOfListOperator<T>,
                ConvertibleToSetOfSetOperator<T>,
                ConvertibleToArrayOfMapOperator<T>,
                ConvertibleToListOfMapOperator<T>,
                ConvertibleToSetOfMapOperator<T> {



    public Level0ListOfArraySelectedOperator<T> ifIndex(final int... indices);
    public Level0ListOfArraySelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super List<T[]>> eval);
    public Level0ListOfArraySelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super List<T[]>> eval);
    public Level0ListOfArraySelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<T[]>> eval);
    public Level0ListOfArraySelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<T[]>> eval);
    public Level0ListOfArraySelectedOperator<T> ifNull();
    public Level0ListOfArraySelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super List<T[]>> eval);
    public Level0ListOfArraySelectedOperator<T> ifIndexNot(final int... indices);
    public Level0ListOfArraySelectedOperator<T> ifNotNull();
    public Level0ListOfArraySelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super List<T[]>> eval);



    public Level1ListOfArrayElementsOperator<T> forEach();

    public Level0ListOfArrayOperator<T> distinct();
    
    public Level0ListOfArrayOperator<T> sort();
    public Level0ListOfArrayOperator<T> sort(final Comparator<? super T[]> comparator);
        
    public Level0ListOperator<T> flatten();
    public Level0ListOfArrayOperator<T> add(final T[]... newElements);
    public Level0ListOfArrayOperator<T> insert(final int position, final T[]... newElements);
    public Level0ListOfArrayOperator<T> addAll(final Collection<T[]> collection);
    public Level0ListOfArrayOperator<T> removeIndexes(final int... indices);
    public Level0ListOfArrayOperator<T> removeEquals(final T[]... values);
    public Level0ListOfArrayOperator<T> removeMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArrayOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArrayOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArrayOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArrayOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArrayOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ListOfArrayOperator<T> removeIndexesNot(final int... indices);
    public Level0ListOfArrayOperator<T> removeNulls();
    public Level0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of);
    
    public Level0ArrayOfListOperator<T> toArrayOfList();
    
    public Level0ArrayOfSetOperator<T> toArrayOfSet();
    
    public Level0ListOfListOperator<T> toListOfList();
    
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

    
    public Level0GenericUniqOperator<List<T[]>> generic();
    
    
    
    
    
    public <X> Level0ListOfArrayOperator<X> convert(final IConverter<? extends List<X[]>,? super List<T[]>> converter);
    
    public <X> Level0ListOfArrayOperator<X> eval(final IEvaluator<? extends List<X[]>,? super List<T[]>> eval);

    public <X> Level0ListOfArrayOperator<X> exec(final IFunction<? extends List<X[]>, ? super List<T[]>> function);

    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<T[]>> function);
    
    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super List<T[]>> eval);
    
    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super List<T[]>> converter);    
    
    
    
    public <X> Level0ListOfArrayOperator<X> asListOfArrayOf(final Type<X> type);
    public Level0ListOfArrayOperator<?> asListOfArrayOfUnknown();

    
}

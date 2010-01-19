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
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.qualities.CastableToArrayOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfListOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToListOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOfListOperator;
import org.op4j.operators.qualities.ConvertibleToListOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToListOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfListOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOfSetOperator;
import org.op4j.operators.qualities.FlattenableAsArrayOperator;
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
public interface Level0ArrayOfSetOperator<T>
        extends UniqOperator<Set<T>[]>,
                NavigableCollectionOperator<Set<T>>,
		        DistinguishableOperator,
		        CastableToArrayOfSetOperator,
		        SortableOperator<Set<T>>,
                FlattenableAsArrayOperator<T>,
		        ModifiableCollectionOperator<Set<T>>,
		        GenerizableOperator<Set<T>[]>,
                ExecutableArrayOfSetOperator<T>,
                SelectableOperator<Set<T>[]>,
                ReplaceableOperator<Set<T>[]>,
                ReplaceableIfNullOperator<Set<T>[]>,
                ConvertibleToArrayOfArrayOperator<T>,
                ConvertibleToArrayOfListOperator<T>,
                ConvertibleToListOfArrayOperator<T>,
                ConvertibleToListOfListOperator<T>,
                ConvertibleToListOfSetOperator<T>,
                ConvertibleToSetOfArrayOperator<T>,
                ConvertibleToSetOfListOperator<T>,
                ConvertibleToSetOfSetOperator<T>,
                ConvertibleToArrayOfMapOperator<T>,
                ConvertibleToListOfMapOperator<T>,
                ConvertibleToSetOfMapOperator<T> {



    public Level0ArrayOfSetSelectedOperator<T> ifIndex(final int... indices);
    public Level0ArrayOfSetSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super Set<T>[]> eval);
    public Level0ArrayOfSetSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super Set<T>[]> eval);
    public Level0ArrayOfSetSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>[]> eval);
    public Level0ArrayOfSetSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>[]> eval);
    public Level0ArrayOfSetSelectedOperator<T> ifNull();
    public Level0ArrayOfSetSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>[]> eval);
    public Level0ArrayOfSetSelectedOperator<T> ifIndexNot(final int... indices);
    public Level0ArrayOfSetSelectedOperator<T> ifNotNull();
    public Level0ArrayOfSetSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>[]> eval);



    public Level1ArrayOfSetElementsOperator<T> forEach();

    public Level0ArrayOfSetOperator<T> distinct();
    
    public Level0ArrayOfSetOperator<T> sort();
    public Level0ArrayOfSetOperator<T> sort(final Comparator<? super Set<T>> comparator);
        
    public Level0ArrayOperator<T> flatten(final Type<T> type);
    public Level0ArrayOfSetOperator<T> add(final Set<T>... newElements);
    public Level0ArrayOfSetOperator<T> insert(final int position, final Set<T>... newElements);
    public Level0ArrayOfSetOperator<T> addAll(final Collection<Set<T>> collection);
    public Level0ArrayOfSetOperator<T> removeAllIndexes(final int... indices);
    public Level0ArrayOfSetOperator<T> removeAllEqual(final Set<T>... values);
    public Level0ArrayOfSetOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval);
    public Level0ArrayOfSetOperator<T> removeAllIndexesNot(final int... indices);
    public Level0ArrayOfSetOperator<T> removeAllNull();
    public Level0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of);
    
    public Level0ArrayOfListOperator<T> toArrayOfList();
    
    public Level0ListOfArrayOperator<T> toListOfArray(final Type<T> of);
    
    
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

    
    public Level0GenericUniqOperator<Set<T>[]> generic();



    
    public Level0ArrayOfSetOperator<T> replaceBy(final Set<T>[] replacement);
    public Level0ArrayOfSetOperator<T> replaceIfNullBy(final Set<T>[] replacement);


    public <X> Level0ArrayOfSetOperator<X> convert(final IConverter<? extends Set<X>[],? super Set<T>[]> converter);
    
    public <X> Level0ArrayOfSetOperator<X> eval(final IEvaluator<? extends Set<X>[],? super Set<T>[]> eval);

    public <X> Level0ArrayOfSetOperator<X> exec(final IFunction<? extends Set<X>[], ? super Set<T>[]> function);

    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T>[]> function);
    
    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Set<T>[]> eval);
    
    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super Set<T>[]> converter);    
    
    
    
    public <X> Level0ArrayOfSetOperator<X> asArrayOfSetOf(final Type<X> type);
    public Level0ArrayOfSetOperator<?> asArrayOfSetOfUnknown();

    
        
}

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
package org.op4j.operators.intf.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
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
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.qualities.CastableToSetOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfListOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToListOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOfListOperator;
import org.op4j.operators.qualities.ConvertibleToListOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToListOfSetOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfArrayOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfListOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfMapOperator;
import org.op4j.operators.qualities.ExecutableSetOfSetOperator;
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
public interface Level0SetOfSetOperator<T>
        extends UniqOperator<Set<Set<T>>>,
                NavigableCollectionOperator<Set<T>>,
		        SortableOperator<Set<T>>,
                CastableToSetOfSetOperator,
                FlattenableAsSetOperator<T>,
		        ModifiableCollectionOperator<Set<T>>,
		        GenerizableOperator<Set<Set<T>>>,
                ExecutableSetOfSetOperator<T>,
                SelectableOperator<Set<Set<T>>>,
                ReplaceableOperator<Set<Set<T>>>,
                ReplaceableIfNullOperator<Set<Set<T>>>,
                ConvertibleToArrayOfArrayOperator<T>,
                ConvertibleToArrayOfListOperator<T>,
                ConvertibleToArrayOfSetOperator<T>,
                ConvertibleToListOfArrayOperator<T>,
                ConvertibleToListOfListOperator<T>,
                ConvertibleToListOfSetOperator<T>,
                ConvertibleToSetOfArrayOperator<T>,
                ConvertibleToSetOfListOperator<T>,
                ConvertibleToArrayOfMapOperator<T>,
                ConvertibleToListOfMapOperator<T>,
                ConvertibleToSetOfMapOperator<T> {



    public Level0SetOfSetSelectedOperator<T> ifIndex(final int... indexes);
    public Level0SetOfSetSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super Set<Set<T>>> eval);
    public Level0SetOfSetSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super Set<Set<T>>> eval);
    public Level0SetOfSetSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super Set<Set<T>>> eval);
    public Level0SetOfSetSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super Set<Set<T>>> eval);
    public Level0SetOfSetSelectedOperator<T> ifNull();
    public Level0SetOfSetSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super Set<Set<T>>> eval);
    public Level0SetOfSetSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level0SetOfSetSelectedOperator<T> ifNotNull();
    public Level0SetOfSetSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super Set<Set<T>>> eval);


    
    public Level1SetOfSetElementsOperator<T> forEach();
    
    public Level0SetOfSetOperator<T> sort();
    public Level0SetOfSetOperator<T> sort(final Comparator<? super Set<T>> comparator);
        
    public Level0SetOperator<T> flatten();
    public Level0SetOfSetOperator<T> add(final Set<T> newElement);
    public Level0SetOfSetOperator<T> addAll(final Set<T>... newElements);
    public Level0SetOfSetOperator<T> insert(final int position, final Set<T> newElement);
    public Level0SetOfSetOperator<T> insertAll(final int position, final Set<T>... newElements);
    public Level0SetOfSetOperator<T> addAll(final Collection<Set<T>> collection);
    public Level0SetOfSetOperator<T> removeAllIndexes(final int... indexes);
    public Level0SetOfSetOperator<T> removeAllEqual(final Set<T>... values);
    public Level0SetOfSetOperator<T> removeAllTrue(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetOfSetOperator<T> removeAllFalse(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetOfSetOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetOfSetOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetOfSetOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetOfSetOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super Set<T>> eval);
    public Level0SetOfSetOperator<T> removeAllIndexesNot(final int... indexes);
    public Level0SetOfSetOperator<T> removeAllNull();
    public Level0ArrayOfArrayOperator<T> toArrayOfArrayOf(final Type<T> type);
    
    public Level0ArrayOfListOperator<T> toArrayOfList();
    
    public Level0ArrayOfSetOperator<T> toArrayOfSet();
    
    public Level0ListOfArrayOperator<T> toListOfArrayOf(final Type<T> type);
    
    
    public Level0ListOfListOperator<T> toListOfList();
    
    public Level0ListOfSetOperator<T> toListOfSet();
    
    public Level0SetOfArrayOperator<T> toSetOfArrayOf(final Type<T> type);
    
    
    public Level0SetOfListOperator<T> toSetOfList();
    
    public Level0ArrayOfMapOperator<T,T> toArrayOfMap();
    public <K> Level0ArrayOfMapOperator<K,T> toArrayOfMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level0ArrayOfMapOperator<K,V> toArrayOfMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    public Level0ListOfMapOperator<T,T> toListOfMap();
    public <K> Level0ListOfMapOperator<K,T> toListOfMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level0ListOfMapOperator<K,V> toListOfMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    public Level0SetOfMapOperator<T,T> toSetOfMap();
    public <K> Level0SetOfMapOperator<K,T> toSetOfMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level0SetOfMapOperator<K,V> toSetOfMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level0GenericUniqOperator<Set<Set<T>>> generic();


    
    
    public Level0SetOfSetOperator<T> replaceWith(final Set<Set<T>> replacement);
    public Level0SetOfSetOperator<T> replaceIfNullWith(final Set<Set<T>> replacement);


    public <X> Level0SetOfSetOperator<X> execIfNotNullAsSetOfSet(final IFunction<? extends Set<? extends Set<X>>,? super Set<Set<T>>> function);

    public <X> Level0SetOfSetOperator<X> execAsSetOfSet(final IFunction<? extends Set<? extends Set<X>>, ? super Set<Set<T>>> function);

    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<Set<T>>> function);
    
    public <X> Level0GenericUniqOperator<X> execIfNotNull(final IFunction<X,? super Set<Set<T>>> function);
    
    public <X> Level0SetOfSetOperator<X> mapMap(final IFunction<X,? super T> function);
    
    
    
    public <X> Level0SetOfSetOperator<X> asSetOfSetOf(final Type<X> type);
    public Level0SetOfSetOperator<?> asSetOfSetOfUnknown();

    
}

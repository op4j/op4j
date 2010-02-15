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
package org.op4j.operators.intf.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOperator;
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
public interface Level1SetOfArrayElementsOperator<T>
        extends UniqOperator<Set<T[]>>,
                NavigableCollectionOperator<T>,
                NavigatingCollectionOperator<T[]>,
		        DistinguishableOperator,
		        SortableOperator<T>,
		        CastableToArrayOperator,
                ExecutableArrayOperator<T>,
                SelectableOperator<T[]>,
                ReplaceableOperator<T[]>,
                ReplaceableIfNullOperator<T[]>,
                ModifiableCollectionOperator<T>,
                ConvertibleToListOperator,
                ConvertibleToSetOperator,
                ConvertibleToMapOperator<T> {



    public Level1SetOfArrayElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level1SetOfArrayElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T[]> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T[]> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T[]> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T[]> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> ifNull();
    public Level1SetOfArrayElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T[]> eval);
    public Level1SetOfArrayElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level1SetOfArrayElementsSelectedOperator<T> ifNotNull();
    public Level1SetOfArrayElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T[]> eval);


    
    public Level2SetOfArrayElementsElementsOperator<T> forEach();
    
    public Level0SetOfArrayOperator<T> endFor();

    public Level1SetOfArrayElementsOperator<T> distinct();
    
    public Level1SetOfArrayElementsOperator<T> sort();
    public Level1SetOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level1SetOfArrayElementsOperator<T> add(final T newElement);
    public Level1SetOfArrayElementsOperator<T> addAll(final T... newElements);
    public Level1SetOfArrayElementsOperator<T> insert(final int position, final T newElement);
    public Level1SetOfArrayElementsOperator<T> insertAll(final int position, final T... newElements);
    public Level1SetOfArrayElementsOperator<T> addAll(final Collection<T> collection);
    public Level1SetOfArrayElementsOperator<T> removeAllIndexes(final int... indexes);
    public Level1SetOfArrayElementsOperator<T> removeAllEqual(final T... values);
    public Level1SetOfArrayElementsOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level1SetOfArrayElementsOperator<T> removeAllIndexesNot(final int... indexes);
    public Level1SetOfArrayElementsOperator<T> removeAllNull();
    public Level1SetOfListElementsOperator<T> toList();
    
    public Level1SetOfSetElementsOperator<T> toSet();
    
    public Level1SetOfMapElementsOperator<T,T> toMap();
    public <K> Level1SetOfMapElementsOperator<K,T> toMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level1SetOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level1SetOfArrayElementsOperator<T> replaceWith(final T[] replacement);
    public Level1SetOfArrayElementsOperator<T> replaceIfNullWith(final T[] replacement);


    public Level1SetOfArrayElementsOperator<T> execIfNotNullAsArray(final IFunction<? extends T[],? super T[]> function);

    public Level1SetOfArrayElementsOperator<T> execAsArray(final IFunction<? extends T[], ? super T[]> function);

    public <X> Level1SetOfArrayElementsOperator<X> execIfNotNullAsArrayOf(final Type<X> type, final IFunction<X[],? super T[]> function);

    public <X> Level1SetOfArrayElementsOperator<X> execAsArrayOf(final Type<X> type, final IFunction<X[], ? super T[]> function);

    public <X> Level1SetElementsOperator<X> exec(final IFunction<X, ? super T[]> function);
    
    public <X> Level1SetElementsOperator<X> execIfNotNull(final IFunction<X,? super T[]> function);
    
    public <X> Level1SetOfArrayElementsOperator<X> map(final Type<X> type, final IFunction<X,? super T> function);
    
    public Level1SetOfArrayElementsOperator<T> map(final IFunction<? extends T,? super T> function);
    
    
    public <X> Level1SetOfArrayElementsOperator<X> asArrayOf(final Type<X> type);
    public Level1SetOfArrayElementsOperator<?> asArrayOfUnknown();
    
                                    
}

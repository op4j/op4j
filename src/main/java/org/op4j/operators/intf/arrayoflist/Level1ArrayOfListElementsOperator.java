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
package org.op4j.operators.intf.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOfListElementsOperator;
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
public interface Level1ArrayOfListElementsOperator<T>
        extends UniqOperator<List<T>[]>,
                NavigableCollectionOperator<T>,
                NavigatingCollectionOperator<List<T>>,
		        DistinguishableOperator,
                CastableToListOperator,
		        SortableOperator<T>,
                ExecutableArrayOfListElementsOperator<T>,
                SelectableOperator<List<T>>,
                ReplaceableOperator<List<T>>,
                ReplaceableIfNullOperator<List<T>>,
                ModifiableCollectionOperator<T>,
                ConvertibleToArrayOperator<T>,
                ConvertibleToSetOperator,
                ConvertibleToMapOperator<T> {



    public Level1ArrayOfListElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level1ArrayOfListElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListElementsSelectedOperator<T> ifNull();
    public Level1ArrayOfListElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super List<T>> eval);
    public Level1ArrayOfListElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level1ArrayOfListElementsSelectedOperator<T> ifNotNull();
    public Level1ArrayOfListElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super List<T>> eval);


            
    public Level2ArrayOfListElementsElementsOperator<T> forEach();
    
    public Level0ArrayOfListOperator<T> endFor();

    public Level1ArrayOfListElementsOperator<T> distinct();
    
    public Level1ArrayOfListElementsOperator<T> sort();
    public Level1ArrayOfListElementsOperator<T> sort(final Comparator<? super T> comparator);
        
    public Level1ArrayOfListElementsOperator<T> add(final T newElement);
    public Level1ArrayOfListElementsOperator<T> addAll(final T... newElements);
    public Level1ArrayOfListElementsOperator<T> insert(final int position, final T newElement);
    public Level1ArrayOfListElementsOperator<T> insertAll(final int position, final T... newElements);
    public Level1ArrayOfListElementsOperator<T> addAll(final Collection<T> collection);
    public Level1ArrayOfListElementsOperator<T> removeAllIndexes(final int... indexes);
    public Level1ArrayOfListElementsOperator<T> removeAllEqual(final T... values);
    public Level1ArrayOfListElementsOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayOfListElementsOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayOfListElementsOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayOfListElementsOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayOfListElementsOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayOfListElementsOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayOfListElementsOperator<T> removeAllIndexesNot(final int... indexes);
    public Level1ArrayOfListElementsOperator<T> removeAllNull();
    
    public Level1ArrayOfArrayElementsOperator<T> toArrayOf(final Type<T> type);
    
    
    public Level1ArrayOfSetElementsOperator<T> toSet();
    
    public Level1ArrayOfMapElementsOperator<T,T> toMap();
    public <K> Level1ArrayOfMapElementsOperator<K,T> toMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level1ArrayOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level1ArrayOfListElementsOperator<T> replaceWith(final List<T> replacement);
    public Level1ArrayOfListElementsOperator<T> replaceIfNullWith(final List<T> replacement);


    public <X> Level1ArrayOfListElementsOperator<X> execIfNotNullAsList(final IFunction<? extends List<X>,? super List<T>> function);

    public <X> Level1ArrayOfListElementsOperator<X> execAsList(final IFunction<? extends List<X>, ? super List<T>> function);

    public <X> Level1ArrayElementsOperator<X> exec(final Type<X> resultType, final IFunction<X, ? super List<T>> function);
    
    public <X> Level1ArrayElementsOperator<X> execIfNotNull(final Type<X> resultType, final IFunction<X,? super List<T>> function);
    
    public <X> Level1ArrayOfListElementsOperator<X> map(final IFunction<X,? super T> function);

    
    public <X> Level1ArrayOfListElementsOperator<X> asListOf(final Type<X> type);
    public Level1ArrayOfListElementsOperator<?> asListOfUnknown();
    
		                    
}

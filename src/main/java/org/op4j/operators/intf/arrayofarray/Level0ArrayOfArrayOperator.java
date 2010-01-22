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
package org.op4j.operators.intf.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.qualities.CastableToArrayOfArrayOperator;
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
import org.op4j.operators.qualities.ConvertibleToSetOfSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOfArrayOperator;
import org.op4j.operators.qualities.FlattenableAsArrayOperator;
import org.op4j.operators.qualities.GenerizableOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableArrayOperator;
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
public interface Level0ArrayOfArrayOperator<T,I>
        extends UniqOperator<T[][],I>,
                NavigableArrayOperator<T[],I>,
		        DistinguishableOperator<I>,
		        SortableOperator<T[],I>,
                CastableToArrayOfArrayOperator<I>,
		        FlattenableAsArrayOperator<T,I>,
		        ModifiableCollectionOperator<T[],I>,
		        GenerizableOperator<T[][],I>,
                ExecutableArrayOfArrayOperator<T,I>,
                SelectableOperator<T[][],I>,
                ReplaceableOperator<T[][],I>,
                ReplaceableIfNullOperator<T[][],I>,
                ConvertibleToArrayOfListOperator<T,I>,
                ConvertibleToArrayOfSetOperator<T,I>,
                ConvertibleToListOfArrayOperator<T,I>,
                ConvertibleToListOfListOperator<T,I>,
                ConvertibleToListOfSetOperator<T,I>,
                ConvertibleToSetOfArrayOperator<T,I>,
                ConvertibleToSetOfListOperator<T,I>,
                ConvertibleToSetOfSetOperator<T,I>,
                ConvertibleToArrayOfMapOperator<T,I>,
                ConvertibleToListOfMapOperator<T,I>,
                ConvertibleToSetOfMapOperator<T,I> {



    public Level0ArrayOfArraySelectedOperator<T,I> ifIndex(final int... indices);
    public Level0ArrayOfArraySelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T[][]> eval);
    public Level0ArrayOfArraySelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T[][]> eval);
    public Level0ArrayOfArraySelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T[][]> eval);
    public Level0ArrayOfArraySelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[][]> eval);
    public Level0ArrayOfArraySelectedOperator<T,I> ifNull();
    public Level0ArrayOfArraySelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T[][]> eval);
    public Level0ArrayOfArraySelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level0ArrayOfArraySelectedOperator<T,I> ifNotNull();
    public Level0ArrayOfArraySelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[][]> eval);



    public Level1ArrayOfArrayElementsOperator<T,I> forEach(final Type<T[]> elementType);

    public Level0ArrayOfArrayOperator<T,I> distinct();
    
    public Level0ArrayOfArrayOperator<T,I> sort();
    public Level0ArrayOfArrayOperator<T,I> sort(final Comparator<? super T[]> comparator);


    public Level0ArrayOperator<T,I> flatten(final Type<T> type);
    public Level0ArrayOfArrayOperator<T,I> add(final T[] newElement);
    public Level0ArrayOfArrayOperator<T,I> addAll(final T[]... newElements);
    public Level0ArrayOfArrayOperator<T,I> insert(final int position, final T[] newElement);
    public Level0ArrayOfArrayOperator<T,I> insertAll(final int position, final T[]... newElements);
    public Level0ArrayOfArrayOperator<T,I> addAll(final Collection<T[]> collection);
    public Level0ArrayOfArrayOperator<T,I> removeAllIndexes(final int... indices);
    public Level0ArrayOfArrayOperator<T,I> removeAllEqual(final T[]... values);
    public Level0ArrayOfArrayOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArrayOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArrayOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArrayOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArrayOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArrayOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval);
    public Level0ArrayOfArrayOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level0ArrayOfArrayOperator<T,I> removeAllNull();
    public Level0ArrayOfListOperator<T,I> toArrayOfList();
    
    public Level0ArrayOfSetOperator<T,I> toArrayOfSet();
    
    public Level0ListOfArrayOperator<T,I> toListOfArray(final Type<T> of);
    
    
    public Level0ListOfListOperator<T,I> toListOfList();
    
    public Level0ListOfSetOperator<T,I> toListOfSet();
    
    public Level0SetOfArrayOperator<T,I> toSetOfArray(final Type<T> of);
    
    
    public Level0SetOfListOperator<T,I> toSetOfList();
    
    public Level0SetOfSetOperator<T,I> toSetOfSet();
    
    public Level0ArrayOfMapOperator<T,T,I> toArrayOfMap();
    public <K> Level0ArrayOfMapOperator<K,T,I> toArrayOfMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0ArrayOfMapOperator<K,V,I> toArrayOfMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    public Level0ListOfMapOperator<T,T,I> toListOfMap();
    public <K> Level0ListOfMapOperator<K,T,I> toListOfMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0ListOfMapOperator<K,V,I> toListOfMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    public Level0SetOfMapOperator<T,T,I> toSetOfMap();
    public <K> Level0SetOfMapOperator<K,T,I> toSetOfMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0SetOfMapOperator<K,V,I> toSetOfMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level0GenericUniqOperator<T[][],I> generic();




    
    public Level0ArrayOfArrayOperator<T,I> replaceWith(final T[][] replacement);
    public Level0ArrayOfArrayOperator<T,I> replaceIfNullWith(final T[][] replacement);


    public <X> Level0ArrayOfArrayOperator<X,I> convert(final IConverter<X[][],? super T[][]> converter);
    
    public <X> Level0ArrayOfArrayOperator<X,I> eval(final IEvaluator<X[][],? super T[][]> eval);

    public <X> Level0ArrayOfArrayOperator<X,I> exec(final IFunction<X[][], ? super T[][]> function);

    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super T[][]> function);
    
    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super T[][]> eval);
    
    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super T[][]> converter);    
    
    
    
    public <X> Level0ArrayOfArrayOperator<X,I> asArrayOfArrayOf(final Type<X> type);
    public Level0ArrayOfArrayOperator<?,I> asArrayOfArrayOfUnknown();

    
}

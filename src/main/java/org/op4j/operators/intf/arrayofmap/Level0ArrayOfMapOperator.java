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
package org.op4j.operators.intf.arrayofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.qualities.CastableToArrayOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToListOfMapFromStructureOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToMapOfMapFromStructureOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfMapFromStructureOfMapOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOfMapOperator;
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
public interface Level0ArrayOfMapOperator<K,V,I>
        extends UniqOperator<Map<K,V>[],I>,
                NavigableCollectionOperator<Map<K,V>,I>,
		        CastableToArrayOfMapOperator<I>,
		        DistinguishableOperator<I>,
		        SortableOperator<Map<K,V>,I>,
                ExecutableArrayOfMapOperator<K,V,I>,
                SelectableOperator<Map<K,V>[],I>,
                ReplaceableOperator<Map<K,V>[],I>,
                ReplaceableIfNullOperator<Map<K,V>[],I>,
                ConvertibleToListOfMapFromStructureOfMapOperator<K, V,I>,
                ConvertibleToMapOfMapFromStructureOfMapOperator<K, V,I>,
                ConvertibleToSetOfMapFromStructureOfMapOperator<K, V,I>,
                ModifiableCollectionOperator<Map<K,V>,I>,
		        GenerizableOperator<Map<K,V>[],I> {



    public Level0ArrayOfMapSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level0ArrayOfMapSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Map<K,V>[]> eval);
    public Level0ArrayOfMapSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Map<K,V>[]> eval);
    public Level0ArrayOfMapSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>[]> eval);
    public Level0ArrayOfMapSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>[]> eval);
    public Level0ArrayOfMapSelectedOperator<K,V,I> ifNull();
    public Level0ArrayOfMapSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>[]> eval);
    public Level0ArrayOfMapSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level0ArrayOfMapSelectedOperator<K,V,I> ifNotNull();
    public Level0ArrayOfMapSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>[]> eval);



    public Level1ArrayOfMapElementsOperator<K,V,I> forEach();

    public Level0ArrayOfMapOperator<K,V,I> distinct();
    
    public Level0ArrayOfMapOperator<K,V,I> sort();
    public Level0ArrayOfMapOperator<K,V,I> sort(final Comparator<? super Map<K,V>> comparator);
    
    public Level0ArrayOfMapOperator<K,V,I> add(final Map<K,V> newElement);
    public Level0ArrayOfMapOperator<K,V,I> addAll(final Map<K,V>... newElements);
    public Level0ArrayOfMapOperator<K,V,I> insert(final int position, final Map<K,V> newElement);
    public Level0ArrayOfMapOperator<K,V,I> insertAll(final int position, final Map<K,V>... newElements);
    public Level0ArrayOfMapOperator<K,V,I> addAll(final Collection<Map<K,V>> collection);
    public Level0ArrayOfMapOperator<K,V,I> removeAllIndexes(final int... indices);
    public Level0ArrayOfMapOperator<K,V,I> removeAllEqual(final Map<K,V>... values);
    public Level0ArrayOfMapOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapOperator<K,V,I> removeAllIndexesNot(final int... indices);
    public Level0ArrayOfMapOperator<K,V,I> removeAllNull();

    public Level0GenericUniqOperator<Map<K,V>[],I> generic();

    
    
    
    public Level0ArrayOfMapOperator<K,V,I> replaceWith(final Map<K,V>[] replacement);
    public Level0ArrayOfMapOperator<K,V,I> replaceIfNullWith(final Map<K,V>[] replacement);


    public <X,Y> Level0ArrayOfMapOperator<X,Y,I> convert(final IConverter<? extends Map<X,Y>[],? super Map<K,V>[]> converter);
    
    public <X,Y> Level0ArrayOfMapOperator<X,Y,I> eval(final IEvaluator<? extends Map<X,Y>[],? super Map<K,V>[]> eval);

    public <X,Y> Level0ArrayOfMapOperator<X,Y,I> exec(final IFunction<? extends Map<X,Y>[], ? super Map<K,V>[]> function);

    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K,V>[]> function);
    
    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map<K,V>[]> eval);
    
    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super Map<K,V>[]> converter);    
    
    
    public <X,Y> Level0ArrayOfMapOperator<X,Y,I> asArrayOfMapOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0ArrayOfMapOperator<?,?,I> asArrayOfMapOfUnknown();

    
    public Level0ListOfMapOperator<K,V,I> toListOfMap();
    
    public <K1> Level0MapOfMapOperator<K1,K,V,I> toMapOfMap(final IEvaluator<K1,? super Map<K, V>> keyEval);
    public <K1,K2,V2> Level0MapOfMapOperator<K1,K2,V2,I> toMapOfMap(final IMapBuilder<K1, Map<K2,V2>, ? super Map<K,V>> mapBuild);
    
    public Level0SetOfMapOperator<K,V,I> toSetOfMap();
    
}

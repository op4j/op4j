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
public interface Level0ArrayOfMapOperator<K,V>
        extends UniqOperator<Map<K,V>[]>,
                NavigableCollectionOperator<Map<K,V>>,
		        CastableToArrayOfMapOperator,
		        DistinguishableOperator,
		        SortableOperator<Map<K,V>>,
                ExecutableArrayOfMapOperator<K,V>,
                SelectableOperator<Map<K,V>[]>,
                ReplaceableOperator<Map<K,V>[]>,
                ReplaceableIfNullOperator<Map<K,V>[]>,
                ConvertibleToListOfMapFromStructureOfMapOperator<K, V>,
                ConvertibleToMapOfMapFromStructureOfMapOperator<K, V>,
                ConvertibleToSetOfMapFromStructureOfMapOperator<K, V>,
                ModifiableCollectionOperator<Map<K,V>>,
		        GenerizableOperator<Map<K,V>[]> {



    public Level0ArrayOfMapSelectedOperator<K,V> ifIndex(final int... indices);
    public Level0ArrayOfMapSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Map<K,V>[]> eval);
    public Level0ArrayOfMapSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Map<K,V>[]> eval);
    public Level0ArrayOfMapSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>[]> eval);
    public Level0ArrayOfMapSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>[]> eval);
    public Level0ArrayOfMapSelectedOperator<K,V> ifNull();
    public Level0ArrayOfMapSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>[]> eval);
    public Level0ArrayOfMapSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level0ArrayOfMapSelectedOperator<K,V> ifNotNull();
    public Level0ArrayOfMapSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>[]> eval);



    public Level1ArrayOfMapElementsOperator<K,V> forEach();

    public Level0ArrayOfMapOperator<K,V> distinct();
    
    public Level0ArrayOfMapOperator<K,V> sort();
    public Level0ArrayOfMapOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator);
    
    public Level0ArrayOfMapOperator<K,V> add(final Map<K,V> newElement);
    public Level0ArrayOfMapOperator<K,V> addAll(final Map<K,V>... newElements);
    public Level0ArrayOfMapOperator<K,V> insert(final int position, final Map<K,V> newElement);
    public Level0ArrayOfMapOperator<K,V> insertAll(final int position, final Map<K,V>... newElements);
    public Level0ArrayOfMapOperator<K,V> addAll(final Collection<Map<K,V>> collection);
    public Level0ArrayOfMapOperator<K,V> removeAllIndexes(final int... indices);
    public Level0ArrayOfMapOperator<K,V> removeAllEqual(final Map<K,V>... values);
    public Level0ArrayOfMapOperator<K,V> removeAllTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapOperator<K,V> removeAllFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ArrayOfMapOperator<K,V> removeAllIndexesNot(final int... indices);
    public Level0ArrayOfMapOperator<K,V> removeAllNull();

    public Level0GenericUniqOperator<Map<K,V>[]> generic();

    
    
    
    public Level0ArrayOfMapOperator<K,V> replaceWith(final Map<K,V>[] replacement);
    public Level0ArrayOfMapOperator<K,V> replaceIfNullWith(final Map<K,V>[] replacement);


    public <X,Y> Level0ArrayOfMapOperator<X,Y> convert(final IConverter<? extends Map<X,Y>[],? super Map<K,V>[]> converter);
    
    public <X,Y> Level0ArrayOfMapOperator<X,Y> eval(final IEvaluator<? extends Map<X,Y>[],? super Map<K,V>[]> eval);

    public <X,Y> Level0ArrayOfMapOperator<X,Y> exec(final IFunction<? extends Map<X,Y>[], ? super Map<K,V>[]> function);

    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K,V>[]> function);
    
    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Map<K,V>[]> eval);
    
    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super Map<K,V>[]> converter);    
    
    
    public <X,Y> Level0ArrayOfMapOperator<X,Y> asArrayOfMapOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0ArrayOfMapOperator<?,?> asArrayOfMapOfUnknown();

    
    public Level0ListOfMapOperator<K,V> toListOfMap();
    
    public <K1> Level0MapOfMapOperator<K1,K,V> toMapOfMap(final IEvaluator<K1,? super Map<K, V>> keyEval);
    public <K1,K2,V2> Level0MapOfMapOperator<K1,K2,V2> toMapOfMap(final IMapBuilder<K1, Map<K2,V2>, ? super Map<K,V>> mapBuild);
    
    public Level0SetOfMapOperator<K,V> toSetOfMap();
    
}

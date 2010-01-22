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
package org.op4j.operators.intf.setofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.qualities.CastableToSetOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfMapFromStructureOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToListOfMapFromStructureOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToMapOfMapFromStructureOfMapOperator;
import org.op4j.operators.qualities.ExecutableSetOfMapOperator;
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
public interface Level0SetOfMapOperator<K,V,I>
        extends UniqOperator<Set<Map<K,V>>,I>,
                NavigableCollectionOperator<Map<K,V>,I>,
		        SortableOperator<Map<K,V>,I>,
		        CastableToSetOfMapOperator<I>,
                ExecutableSetOfMapOperator<K,V,I>,
                ConvertibleToArrayOfMapFromStructureOfMapOperator<K, V,I>,
                ConvertibleToListOfMapFromStructureOfMapOperator<K, V,I>,
                ConvertibleToMapOfMapFromStructureOfMapOperator<K, V,I>,
                ModifiableCollectionOperator<Map<K,V>,I>,
                SelectableOperator<Set<Map<K,V>>,I>,
                ReplaceableOperator<Set<Map<K,V>>,I>,
                ReplaceableIfNullOperator<Set<Map<K,V>>,I>,
                GenerizableOperator<Set<Map<K,V>>,I> {



    public Level0SetOfMapSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level0SetOfMapSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Set<Map<K,V>>> eval);
    public Level0SetOfMapSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Set<Map<K,V>>> eval);
    public Level0SetOfMapSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<Map<K,V>>> eval);
    public Level0SetOfMapSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<Map<K,V>>> eval);
    public Level0SetOfMapSelectedOperator<K,V,I> ifNull();
    public Level0SetOfMapSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<Map<K,V>>> eval);
    public Level0SetOfMapSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level0SetOfMapSelectedOperator<K,V,I> ifNotNull();
    public Level0SetOfMapSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<Map<K,V>>> eval);


    
    public Level1SetOfMapElementsOperator<K,V,I> forEach();
    
    public Level0SetOfMapOperator<K,V,I> sort();
    public Level0SetOfMapOperator<K,V,I> sort(final Comparator<? super Map<K,V>> comparator);
    
    public Level0SetOfMapOperator<K,V,I> add(final Map<K,V> newElement);
    public Level0SetOfMapOperator<K,V,I> addAll(final Map<K,V>... newElements);
    public Level0SetOfMapOperator<K,V,I> insert(final int position, final Map<K,V> newElement);
    public Level0SetOfMapOperator<K,V,I> insertAll(final int position, final Map<K,V>... newElements);
    public Level0SetOfMapOperator<K,V,I> addAll(final Collection<Map<K,V>> collection);
    public Level0SetOfMapOperator<K,V,I> removeAllIndexes(final int... indices);
    public Level0SetOfMapOperator<K,V,I> removeAllEqual(final Map<K,V>... values);
    public Level0SetOfMapOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapOperator<K,V,I> removeAllIndexesNot(final int... indices);
    public Level0SetOfMapOperator<K,V,I> removeAllNull();

    public Level0GenericUniqOperator<Set<Map<K,V>>,I> generic();
    
    
    
    
    public Level0SetOfMapOperator<K,V,I> replaceWith(final Set<Map<K,V>> replacement);
    public Level0SetOfMapOperator<K,V,I> replaceIfNullWith(final Set<Map<K,V>> replacement);


    public <X,Y> Level0SetOfMapOperator<X,Y,I> convert(final IConverter<? extends Set<? extends Map<X,Y>>,? super Set<Map<K,V>>> converter);
    
    public <X,Y> Level0SetOfMapOperator<X,Y,I> eval(final IEvaluator<? extends Set<? extends Map<X,Y>>,? super Set<Map<K,V>>> eval);

    public <X,Y> Level0SetOfMapOperator<X,Y,I> exec(final IFunction<? extends Set<? extends Map<X,Y>>, ? super Set<Map<K,V>>> function);

    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<Map<K,V>>> function);
    
    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Set<Map<K,V>>> eval);
    
    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super Set<Map<K,V>>> converter);    
    
    
    public <X,Y> Level0SetOfMapOperator<X,Y,I> asSetOfMapOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0SetOfMapOperator<?,?,I> asSetOfMapOfUnknown();

    
    public Level0ArrayOfMapOperator<K,V,I> toArrayOfMap();
    
    public Level0ListOfMapOperator<K,V,I> toListOfMap();
    
    public <K1> Level0MapOfMapOperator<K1,K,V,I> toMapOfMap(final IEvaluator<K1,? super Map<K, V>> keyEval);
    public <K1,K2,V2> Level0MapOfMapOperator<K1,K2,V2,I> toMapOfMap(final IMapBuilder<K1, Map<K2,V2>, ? super Map<K,V>> mapBuild);
    
}

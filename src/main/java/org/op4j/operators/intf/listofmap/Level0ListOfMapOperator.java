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
package org.op4j.operators.intf.listofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.qualities.CastableToListOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOfMapFromStructureOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToMapOfMapFromStructureOfMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOfMapFromStructureOfMapOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListOfMapOperator;
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
public interface Level0ListOfMapOperator<K,V,I>
        extends UniqOperator<List<Map<K,V>>,I>,
                NavigableCollectionOperator<Map<K,V>,I>,
		        DistinguishableOperator<I>,
		        CastableToListOfMapOperator<I>,
		        SortableOperator<Map<K,V>,I>,
                ExecutableListOfMapOperator<K,V,I>,
                ConvertibleToArrayOfMapFromStructureOfMapOperator<K, V,I>,
                ConvertibleToMapOfMapFromStructureOfMapOperator<K, V,I>,
                ConvertibleToSetOfMapFromStructureOfMapOperator<K, V,I>,
                SelectableOperator<List<Map<K,V>>,I>,
                ReplaceableOperator<List<Map<K,V>>,I>,
                ReplaceableIfNullOperator<List<Map<K,V>>,I>,
                ModifiableCollectionOperator<Map<K,V>,I>,
		        GenerizableOperator<List<Map<K,V>>,I> {



    public Level0ListOfMapSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level0ListOfMapSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super List<Map<K,V>>> eval);
    public Level0ListOfMapSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super List<Map<K,V>>> eval);
    public Level0ListOfMapSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super List<Map<K,V>>> eval);
    public Level0ListOfMapSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<Map<K,V>>> eval);
    public Level0ListOfMapSelectedOperator<K,V,I> ifNull();
    public Level0ListOfMapSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super List<Map<K,V>>> eval);
    public Level0ListOfMapSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level0ListOfMapSelectedOperator<K,V,I> ifNotNull();
    public Level0ListOfMapSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<Map<K,V>>> eval);



    public Level1ListOfMapElementsOperator<K,V,I> forEach();

    public Level0ListOfMapOperator<K,V,I> distinct();
    
    public Level0ListOfMapOperator<K,V,I> sort();
    public Level0ListOfMapOperator<K,V,I> sort(final Comparator<? super Map<K,V>> comparator);
    
    public Level0ListOfMapOperator<K,V,I> add(final Map<K,V> newElement);
    public Level0ListOfMapOperator<K,V,I> addAll(final Map<K,V>... newElements);
    public Level0ListOfMapOperator<K,V,I> insert(final int position, final Map<K,V> newElement);
    public Level0ListOfMapOperator<K,V,I> insertAll(final int position, final Map<K,V>... newElements);
    public Level0ListOfMapOperator<K,V,I> addAll(final Collection<Map<K,V>> collection);
    public Level0ListOfMapOperator<K,V,I> removeAllIndexes(final int... indices);
    public Level0ListOfMapOperator<K,V,I> removeAllEqual(final Map<K,V>... values);
    public Level0ListOfMapOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0ListOfMapOperator<K,V,I> removeAllIndexesNot(final int... indices);
    public Level0ListOfMapOperator<K,V,I> removeAllNull();


    public Level0GenericUniqOperator<List<Map<K,V>>,I> generic();

    
    
    public Level0ListOfMapOperator<K,V,I> replaceWith(final List<Map<K,V>> replacement);
    public Level0ListOfMapOperator<K,V,I> replaceIfNullWith(final List<Map<K,V>> replacement);


    public <X,Y> Level0ListOfMapOperator<X,Y,I> convert(final IConverter<? extends List<? extends Map<X,Y>>,? super List<Map<K,V>>> converter);
    
    public <X,Y> Level0ListOfMapOperator<X,Y,I> eval(final IEvaluator<? extends List<? extends Map<X,Y>>,? super List<Map<K,V>>> eval);

    public <X,Y> Level0ListOfMapOperator<X,Y,I> exec(final IFunction<? extends List<? extends Map<X,Y>>,? super List<Map<K,V>>> function);

    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<Map<K,V>>> function);
    
    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super List<Map<K,V>>> eval);
    
    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super List<Map<K,V>>> converter);    

    
    
    public <X,Y> Level0ListOfMapOperator<X,Y,I> asListOfMapOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0ListOfMapOperator<?,?,I> asListOfMapOfUnknown();

    
    public Level0ArrayOfMapOperator<K,V,I> toArrayOfMap();
    
    public <K1> Level0MapOfMapOperator<K1,K,V,I> toMapOfMap(final IEvaluator<K1,? super Map<K, V>> keyEval);
    public <K1,K2,V2> Level0MapOfMapOperator<K1,K2,V2,I> toMapOfMap(final IMapBuilder<K1, Map<K2,V2>, ? super Map<K,V>> mapBuild);
    
    public Level0SetOfMapOperator<K,V,I> toSetOfMap();
    
}

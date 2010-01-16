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
public interface Level0SetOfMapOperator<K,V>
        extends UniqOperator<Set<Map<K,V>>>,
                NavigableCollectionOperator<Map<K,V>>,
		        SortableOperator<Map<K,V>>,
		        CastableToSetOfMapOperator,
                ExecutableSetOfMapOperator<K,V>,
                ConvertibleToArrayOfMapFromStructureOfMapOperator<K, V>,
                ConvertibleToListOfMapFromStructureOfMapOperator<K, V>,
                ConvertibleToMapOfMapFromStructureOfMapOperator<K, V>,
                ModifiableCollectionOperator<Map<K,V>>,
                SelectableOperator<Set<Map<K,V>>>,
                GenerizableOperator<Set<Map<K,V>>> {



    public Level0SetOfMapSelectedOperator<K,V> ifIndex(final int... indices);
    public Level0SetOfMapSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Set<Map<K,V>>> eval);
    public Level0SetOfMapSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Set<Map<K,V>>> eval);
    public Level0SetOfMapSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<Map<K,V>>> eval);
    public Level0SetOfMapSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<Map<K,V>>> eval);
    public Level0SetOfMapSelectedOperator<K,V> ifNull();
    public Level0SetOfMapSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<Map<K,V>>> eval);
    public Level0SetOfMapSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level0SetOfMapSelectedOperator<K,V> ifNotNull();
    public Level0SetOfMapSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<Map<K,V>>> eval);


    
    public Level1SetOfMapElementsOperator<K,V> forEach();
    
    public Level0SetOfMapOperator<K,V> sort();
    public Level0SetOfMapOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator);
    
    public Level0SetOfMapOperator<K,V> add(final Map<K,V>... newElements);
    public Level0SetOfMapOperator<K,V> insert(final int position, final Map<K,V>... newElements);
    public Level0SetOfMapOperator<K,V> addAll(final Collection<Map<K,V>> collection);
    public Level0SetOfMapOperator<K,V> removeIndexes(final int... indices);
    public Level0SetOfMapOperator<K,V> removeEquals(final Map<K,V>... values);
    public Level0SetOfMapOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapOperator<K,V> removeNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval);
    public Level0SetOfMapOperator<K,V> removeIndexesNot(final int... indices);
    public Level0SetOfMapOperator<K,V> removeNulls();

    public Level0GenericUniqOperator<Set<Map<K,V>>> generic();
    
    
    
    
    public <X,Y> Level0SetOfMapOperator<X,Y> convert(final IConverter<? extends Set<? extends Map<X,Y>>,? super Set<Map<K,V>>> converter);
    
    public <X,Y> Level0SetOfMapOperator<X,Y> eval(final IEvaluator<? extends Set<? extends Map<X,Y>>,? super Set<Map<K,V>>> eval);

    public <X,Y> Level0SetOfMapOperator<X,Y> exec(final IFunction<? extends Set<? extends Map<X,Y>>, ? super Set<Map<K,V>>> function);

    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<Map<K,V>>> function);
    
    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Set<Map<K,V>>> eval);
    
    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super Set<Map<K,V>>> converter);    
    
    
    public <X,Y> Level0SetOfMapOperator<X,Y> asSetOfMapOf(final Type<X> keyType, final Type<Y> valueType);
    public Level0SetOfMapOperator<?,?> asSetOfMapOfUnknown();

    
    public Level0ArrayOfMapOperator<K,V> toArrayOfMap();
    
    public Level0ListOfMapOperator<K,V> toListOfMap();
    
    public <K1> Level0MapOfMapOperator<K1,K,V> toMapOfMap(final IEvaluator<K1,? super Map<K, V>> keyEval);
    public <K1,K2,V2> Level0MapOfMapOperator<K1,K2,V2> toMapOfMap(final IMapBuilder<K1, Map<K2,V2>, ? super Map<K,V>> mapBuild);
    
}

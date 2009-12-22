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
package org.op4j.operators.intf.mapoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.ConvertibleOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.EvaluableOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableCollectionOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
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
public interface Level2MapOfListEntriesValueOperator<K,V>
        extends UniqOperator<Map<K,List<V>>>,
                NavigableCollectionOperator<V>,
		        NavigatingMapEntryOperator,
		        DistinguishableOperator,
		        SortableOperator<V>,
		        CastableToListOperator,
                ExecutableOperator<List<V>>,
                ConvertibleOperator<List<V>>,
                EvaluableOperator<List<V>>,
                ModifiableCollectionOperator<V>,
                SelectableOperator<List<V>>,
                ConvertibleToArrayOperator<V>,
                ConvertibleToSetOperator,
                ConvertibleToMapOperator<V> {



    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifIndex(final int... indices);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super List<V>> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super List<V>> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<V>> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<V>> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifNull();
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super List<V>> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifNotNull();
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super List<V>> eval);

    
    public Level3MapOfListEntriesValueElementsOperator<K,V> forEach();
    
    public Level1MapOfListEntriesOperator<K,V> endOn();

    public Level2MapOfListEntriesValueOperator<K,V> distinct();
    
    public Level2MapOfListEntriesValueOperator<K,V> sort();
    public Level2MapOfListEntriesValueOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfListEntriesValueOperator<K,V> add(final V... newElements);
    public Level2MapOfListEntriesValueOperator<K,V> insert(final int position, final V... newElements);
    public Level2MapOfListEntriesValueOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfListEntriesValueOperator<K,V> removeIndexes(final int... indices);
    public Level2MapOfListEntriesValueOperator<K,V> removeEquals(final V... values);
    public Level2MapOfListEntriesValueOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueOperator<K,V> removeNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueOperator<K,V> removeIndexesNot(final int... indices);
    public Level2MapOfListEntriesValueOperator<K,V> removeNulls();
    public Level2MapOfArrayEntriesValueOperator<K,V> toArray(final Type<V> of);
    
    
    public Level2MapOfSetEntriesValueOperator<K,V> toSet();
    
    public Level2MapOfMapEntriesValueOperator<K,V,V> toMap();
    public <K2> Level2MapOfMapEntriesValueOperator<K,K2,V> toMap(final IEvaluator<K2,? super V> keyEval);
    public <K2,V2> Level2MapOfMapEntriesValueOperator<K,K2,V2> toMap(final IMapBuilder<K2,V2,? super V> mapBuild);

    
    public <X> Level2MapEntriesValueOperator<K,X> convert(final IConverter<X,? super List<V>> converter);
    
    public <X> Level2MapEntriesValueOperator<K,X> eval(final IEvaluator<X,? super List<V>> eval);

    public <X> Level2MapEntriesValueOperator<K,X> exec(final IFunction<X, ? super List<V>> function);
    
    
    public <X> Level2MapOfListEntriesValueOperator<K,X> asListOf(final Type<X> type);
    public Level2MapOfListEntriesValueOperator<K,?> asListOfUnknown();
    
    
                                    
}

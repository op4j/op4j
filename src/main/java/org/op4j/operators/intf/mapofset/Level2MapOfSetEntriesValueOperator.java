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
package org.op4j.operators.intf.mapofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.qualities.CastableToSetOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ExecutableSetOperator;
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
public interface Level2MapOfSetEntriesValueOperator<K,V>
        extends UniqOperator<Map<K,Set<V>>>,
                NavigableCollectionOperator<V>,
		        NavigatingMapEntryOperator,
		        SortableOperator<V>,
		        CastableToSetOperator,
                ModifiableCollectionOperator<V>,
                ExecutableSetOperator<V>,
                SelectableOperator<Set<V>>,
                ConvertibleToArrayOperator<V>,
                ConvertibleToListOperator,
                ConvertibleToMapOperator<V> {



    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifIndex(final int... indices);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifNull();
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indices);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifNotNull();
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<V>> eval);

    
    public Level3MapOfSetEntriesValueElementsOperator<K,V> forEach();
    
    public Level1MapOfSetEntriesOperator<K,V> endOn();
    
    public Level2MapOfSetEntriesValueOperator<K,V> sort();
    public Level2MapOfSetEntriesValueOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfSetEntriesValueOperator<K,V> add(final V... newElements);
    public Level2MapOfSetEntriesValueOperator<K,V> insert(final int position, final V... newElements);
    public Level2MapOfSetEntriesValueOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfSetEntriesValueOperator<K,V> removeIndexes(final int... indices);
    public Level2MapOfSetEntriesValueOperator<K,V> removeEquals(final V... values);
    public Level2MapOfSetEntriesValueOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V> removeNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V> removeIndexesNot(final int... indices);
    public Level2MapOfSetEntriesValueOperator<K,V> removeNulls();
    public Level2MapOfArrayEntriesValueOperator<K,V> toArray(final Type<V> of);
    
    
    public Level2MapOfListEntriesValueOperator<K,V> toList();
    
    public Level2MapOfMapEntriesValueOperator<K,V,V> toMap();
    public <K2> Level2MapOfMapEntriesValueOperator<K,K2,V> toMap(final IEvaluator<K2,? super V> keyEval);
    public <K2,V2> Level2MapOfMapEntriesValueOperator<K,K2,V2> toMap(final IMapBuilder<K2,V2,? super V> mapBuild);

    
    public <X> Level2MapOfSetEntriesValueOperator<K,X> convert(final IConverter<? extends Set<X>,? super Set<V>> converter);
    
    public <X> Level2MapOfSetEntriesValueOperator<K,X> eval(final IEvaluator<? extends Set<X>,? super Set<V>> eval);

    public <X> Level2MapOfSetEntriesValueOperator<K,X> exec(final IFunction<? extends Set<X>, ? super Set<V>> function);

    public <X> Level2MapEntriesValueOperator<K,X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<V>> function);
    
    public <X> Level2MapEntriesValueOperator<K,X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Set<V>> eval);
    
    public <X> Level2MapEntriesValueOperator<K,X> convert(final Type<X> resultType, final IConverter<? extends X,? super Set<V>> converter);    
    
    
    
    public <X> Level2MapOfSetEntriesValueOperator<K,X> asSetOf(final Type<X> type);
    public Level2MapOfSetEntriesValueOperator<K,?> asSetOfUnknown();
    
                                    
}

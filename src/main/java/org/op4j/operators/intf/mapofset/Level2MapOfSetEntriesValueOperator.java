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
public interface Level2MapOfSetEntriesValueOperator<K,V,I>
        extends UniqOperator<Map<K,Set<V>>,I>,
                NavigableCollectionOperator<V,I>,
		        NavigatingMapEntryOperator<I>,
		        SortableOperator<V,I>,
		        CastableToSetOperator<I>,
                ModifiableCollectionOperator<V,I>,
                ExecutableSetOperator<V,I>,
                SelectableOperator<Set<V>,I>,
                ReplaceableOperator<Set<V>,I>,
                ReplaceableIfNullOperator<Set<V>,I>,
                ConvertibleToArrayOperator<V,I>,
                ConvertibleToListOperator<I>,
                ConvertibleToMapOperator<V,I> {



    public Level2MapOfSetEntriesValueSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V,I> ifNull();
    public Level2MapOfSetEntriesValueSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V,I> ifNotNull();
    public Level2MapOfSetEntriesValueSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<V>> eval);

    
    public Level3MapOfSetEntriesValueElementsOperator<K,V,I> forEach();
    
    public Level1MapOfSetEntriesOperator<K,V,I> endOn();
    
    public Level2MapOfSetEntriesValueOperator<K,V,I> sort();
    public Level2MapOfSetEntriesValueOperator<K,V,I> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfSetEntriesValueOperator<K,V,I> add(final V newElement);
    public Level2MapOfSetEntriesValueOperator<K,V,I> addAll(final V... newElements);
    public Level2MapOfSetEntriesValueOperator<K,V,I> insert(final int position, final V newElement);
    public Level2MapOfSetEntriesValueOperator<K,V,I> insertAll(final int position, final V... newElements);
    public Level2MapOfSetEntriesValueOperator<K,V,I> addAll(final Collection<V> collection);
    public Level2MapOfSetEntriesValueOperator<K,V,I> removeAllIndexes(final int... indices);
    public Level2MapOfSetEntriesValueOperator<K,V,I> removeAllEqual(final V... values);
    public Level2MapOfSetEntriesValueOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V,I> removeAllIndexesNot(final int... indices);
    public Level2MapOfSetEntriesValueOperator<K,V,I> removeAllNull();
    public Level2MapOfArrayEntriesValueOperator<K,V,I> toArray(final Type<V> of);
    
    
    public Level2MapOfListEntriesValueOperator<K,V,I> toList();
    
    public Level2MapOfMapEntriesValueOperator<K,V,V,I> toMap();
    public <K2> Level2MapOfMapEntriesValueOperator<K,K2,V,I> toMap(final IEvaluator<K2,? super V> keyEval);
    public <K2,V2> Level2MapOfMapEntriesValueOperator<K,K2,V2,I> toMap(final IMapBuilder<K2,V2,? super V> mapBuild);

    
    public Level2MapOfSetEntriesValueOperator<K,V,I> replaceWith(final Set<V> replacement);
    public Level2MapOfSetEntriesValueOperator<K,V,I> replaceIfNullWith(final Set<V> replacement);


    public <X> Level2MapOfSetEntriesValueOperator<K,X,I> convert(final IConverter<? extends Set<X>,? super Set<V>> converter);
    
    public <X> Level2MapOfSetEntriesValueOperator<K,X,I> eval(final IEvaluator<? extends Set<X>,? super Set<V>> eval);

    public <X> Level2MapOfSetEntriesValueOperator<K,X,I> exec(final IFunction<? extends Set<X>, ? super Set<V>> function);

    public <X> Level2MapEntriesValueOperator<K,X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<V>> function);
    
    public <X> Level2MapEntriesValueOperator<K,X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super Set<V>> eval);
    
    public <X> Level2MapEntriesValueOperator<K,X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super Set<V>> converter);    
    
    
    
    public <X> Level2MapOfSetEntriesValueOperator<K,X,I> asSetOf(final Type<X> type);
    public Level2MapOfSetEntriesValueOperator<K,?,I> asSetOfUnknown();
    
                                    
}

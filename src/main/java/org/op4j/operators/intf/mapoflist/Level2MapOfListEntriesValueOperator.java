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
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableListOperator;
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
public interface Level2MapOfListEntriesValueOperator<K,V>
        extends UniqOperator<Map<K,List<V>>>,
                NavigableCollectionOperator<V>,
		        NavigatingMapEntryOperator,
		        DistinguishableOperator,
		        SortableOperator<V>,
		        CastableToListOperator,
                ExecutableListOperator<V>,
                ModifiableCollectionOperator<V>,
                SelectableOperator<List<V>>,
                ReplaceableOperator<List<V>>,
                ReplaceableIfNullOperator<List<V>>,
                ConvertibleToArrayOperator<V>,
                ConvertibleToSetOperator {



    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifIndex(final int... indexes);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super List<V>> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super List<V>> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super List<V>> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super List<V>> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifNull();
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super List<V>> eval);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifNotNull();
    public Level2MapOfListEntriesValueSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super List<V>> eval);

    
    public Level3MapOfListEntriesValueElementsOperator<K,V> forEach();
    
    public Level1MapOfListEntriesOperator<K,V> endOn();

    public Level2MapOfListEntriesValueOperator<K,V> distinct();
    
    public Level2MapOfListEntriesValueOperator<K,V> sort();
    public Level2MapOfListEntriesValueOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfListEntriesValueOperator<K,V> add(final V newElement);
    public Level2MapOfListEntriesValueOperator<K,V> addAll(final V... newElements);
    public Level2MapOfListEntriesValueOperator<K,V> insert(final int position, final V newElement);
    public Level2MapOfListEntriesValueOperator<K,V> insertAll(final int position, final V... newElements);
    public Level2MapOfListEntriesValueOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfListEntriesValueOperator<K,V> removeAllIndexes(final int... indexes);
    public Level2MapOfListEntriesValueOperator<K,V> removeAllEqual(final V... values);
    public Level2MapOfListEntriesValueOperator<K,V> removeAllTrue(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueOperator<K,V> removeAllFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueOperator<K,V> removeAllNullOrFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueOperator<K,V> removeAllNotNullAndFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueOperator<K,V> removeAllNotNullAndTrue(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueOperator<K,V> removeAllNullOrTrue(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfListEntriesValueOperator<K,V> removeAllIndexesNot(final int... indexes);
    public Level2MapOfListEntriesValueOperator<K,V> removeAllNull();
    public Level2MapOfArrayEntriesValueOperator<K,V> toArrayOf(final Type<V> type);
    
    
    public Level2MapOfSetEntriesValueOperator<K,V> toSet();

    
    public Level2MapOfListEntriesValueOperator<K,V> replaceWith(final List<V> replacement);
    public Level2MapOfListEntriesValueOperator<K,V> replaceIfNullWith(final List<V> replacement);


    public <X> Level2MapOfListEntriesValueOperator<K,X> execIfNotNullAsList(final IFunction<? extends List<X>,? super List<V>> function);

    public <X> Level2MapOfListEntriesValueOperator<K,X> execAsList(final IFunction<? extends List<X>, ? super List<V>> function);

    public <X> Level2MapEntriesValueOperator<K,X> exec(final IFunction<X, ? super List<V>> function);
    
    public <X> Level2MapEntriesValueOperator<K,X> execIfNotNull(final IFunction<X,? super List<V>> function);
    
    public <X> Level2MapOfListEntriesValueOperator<K,X> map(final IFunction<X,? super V> function);
    
    
    public <X> Level2MapOfListEntriesValueOperator<K,X> asListOf(final Type<X> type);
    public Level2MapOfListEntriesValueOperator<K,?> asListOfUnknown();
    
    
                                    
}

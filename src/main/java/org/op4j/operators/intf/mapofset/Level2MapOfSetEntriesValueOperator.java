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
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.qualities.CastableToSetOperator;
import org.op4j.operators.qualities.ConvertibleToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
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
public interface Level2MapOfSetEntriesValueOperator<K,V>
        extends UniqOperator<Map<K,Set<V>>>,
                NavigableCollectionOperator<V>,
		        NavigatingMapEntryOperator,
		        SortableOperator<V>,
		        CastableToSetOperator,
                ModifiableCollectionOperator<V>,
                ExecutableSetOperator<V>,
                SelectableOperator<Set<V>>,
                ReplaceableOperator<Set<V>>,
                ReplaceableIfNullOperator<Set<V>>,
                ConvertibleToArrayOperator<V>,
                ConvertibleToListOperator {



    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifIndex(final int... indexes);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifNull();
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super Set<V>> eval);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifNotNull();
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super Set<V>> eval);

    
    public Level3MapOfSetEntriesValueElementsOperator<K,V> forEach();
    
    public Level1MapOfSetEntriesOperator<K,V> endOn();
    
    public Level2MapOfSetEntriesValueOperator<K,V> sort();
    public Level2MapOfSetEntriesValueOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfSetEntriesValueOperator<K,V> add(final V newElement);
    public Level2MapOfSetEntriesValueOperator<K,V> addAll(final V... newElements);
    public Level2MapOfSetEntriesValueOperator<K,V> insert(final int position, final V newElement);
    public Level2MapOfSetEntriesValueOperator<K,V> insertAll(final int position, final V... newElements);
    public Level2MapOfSetEntriesValueOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfSetEntriesValueOperator<K,V> removeAllIndexes(final int... indexes);
    public Level2MapOfSetEntriesValueOperator<K,V> removeAllEqual(final V... values);
    public Level2MapOfSetEntriesValueOperator<K,V> removeAllTrue(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V> removeAllFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V> removeAllNullOrFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V> removeAllNotNullAndFalse(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V> removeAllNotNullAndTrue(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V> removeAllNullOrTrue(final IFunction<Boolean, ? super V> eval);
    public Level2MapOfSetEntriesValueOperator<K,V> removeAllIndexesNot(final int... indexes);
    public Level2MapOfSetEntriesValueOperator<K,V> removeAllNull();
    public Level2MapOfArrayEntriesValueOperator<K,V> toArrayOf(final Type<V> type);
    
    
    public Level2MapOfListEntriesValueOperator<K,V> toList();

    
    public Level2MapOfSetEntriesValueOperator<K,V> replaceWith(final Set<V> replacement);
    public Level2MapOfSetEntriesValueOperator<K,V> replaceIfNullWith(final Set<V> replacement);


    public <X> Level2MapOfSetEntriesValueOperator<K,X> execIfNotNullAsSet(final IFunction<? extends Set<X>,? super Set<V>> function);

    public <X> Level2MapOfSetEntriesValueOperator<K,X> execAsSet(final IFunction<? extends Set<X>, ? super Set<V>> function);

    public <X> Level2MapEntriesValueOperator<K,X> exec(final IFunction<X, ? super Set<V>> function);
    
    public <X> Level2MapEntriesValueOperator<K,X> execIfNotNull(final IFunction<X,? super Set<V>> function);
    
    public <X> Level2MapOfSetEntriesValueOperator<K,X> map(final IFunction<X,? super V> function);
    
    
    
    public <X> Level2MapOfSetEntriesValueOperator<K,X> asSetOf(final Type<X> type);
    public Level2MapOfSetEntriesValueOperator<K,?> asSetOfUnknown();
    
                                    
}

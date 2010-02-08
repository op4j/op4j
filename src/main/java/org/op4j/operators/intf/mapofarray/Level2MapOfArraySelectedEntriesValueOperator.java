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
package org.op4j.operators.intf.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArraySelectedOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableArrayOperator;
import org.op4j.operators.qualities.NavigatingMapEntryOperator;
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
public interface Level2MapOfArraySelectedEntriesValueOperator<K,V>
        extends UniqOperator<Map<K,V[]>>,
                NavigableArrayOperator<V>,
	        	NavigatingMapEntryOperator,
		        DistinguishableOperator,
		        SortableOperator<V>,
                ExecutableArraySelectedOperator<V>,
                ReplaceableOperator<V[]>,
                ModifiableCollectionOperator<V>,
                SelectableOperator<V[]> {



    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifIndex(final int... indexes);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNull();
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNotNull();
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V[]> eval);

    
    public Level3MapOfArraySelectedEntriesValueElementsOperator<K,V> forEach(final Type<V> elementType);
    
    public Level1MapOfArraySelectedEntriesOperator<K,V> endOn();

    public Level2MapOfArraySelectedEntriesValueOperator<K,V> distinct();
    
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> sort();
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> add(final V newElement);
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> addAll(final V... newElements);
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> insert(final int position, final V newElement);
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> insertAll(final int position, final V... newElements);
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeAllIndexes(final int... indexes);
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeAllEqual(final V... values);
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeAllTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeAllFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeAllIndexesNot(final int... indexes);
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeAllNull();

    
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> convertAsArray(final IConverter<? extends V[], ? super V[]> converter);
    
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> evalAsArray(final IEvaluator<? extends V[], ? super V[]> eval);

    public Level2MapOfArraySelectedEntriesValueOperator<K,V> replaceWith(final V[] replacement);

    public Level2MapOfArraySelectedEntriesValueOperator<K,V> execAsArray(final IFunction<? extends V[], ? super V[]> function);
    
    
    
}

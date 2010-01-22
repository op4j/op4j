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
public interface Level2MapOfArrayEntriesSelectedValueOperator<K,V,I>
        extends UniqOperator<Map<K,V[]>,I>,
                NavigableArrayOperator<V,I>,
	        	NavigatingMapEntryOperator<I>,
		        DistinguishableOperator<I>,
		        SortableOperator<V,I>,
                ExecutableArraySelectedOperator<V,I>,
                ReplaceableOperator<V[],I>,
                ModifiableCollectionOperator<V,I>,
                SelectableOperator<V[],I> {



    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifNull();
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifNotNull();
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V[]> eval);

    
    public Level3MapOfArrayEntriesSelectedValueElementsOperator<K,V,I> forEach(final Type<V> elementType);
    
    public Level1MapOfArrayEntriesSelectedOperator<K,V,I> endOn();

    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> distinct();
    
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> sort();
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> add(final V newElement);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> addAll(final V... newElements);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> insert(final int position, final V newElement);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> insertAll(final int position, final V... newElements);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> addAll(final Collection<V> collection);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllIndexes(final int... indices);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllEqual(final V... values);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllIndexesNot(final int... indices);
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllNull();

    
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> convert(final IConverter<? extends V[], ? super V[]> converter);
    
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> eval(final IEvaluator<? extends V[], ? super V[]> eval);

    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> replaceWith(final V[] replacement);

    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> exec(final IFunction<? extends V[], ? super V[]> function);
    
    
    
}

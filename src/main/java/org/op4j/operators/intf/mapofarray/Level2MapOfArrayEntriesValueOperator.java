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
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.ConvertibleToListOperator;
import org.op4j.operators.qualities.ConvertibleToMapOperator;
import org.op4j.operators.qualities.ConvertibleToSetOperator;
import org.op4j.operators.qualities.DistinguishableOperator;
import org.op4j.operators.qualities.ExecutableArrayOperator;
import org.op4j.operators.qualities.ModifiableCollectionOperator;
import org.op4j.operators.qualities.NavigableArrayOperator;
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
public interface Level2MapOfArrayEntriesValueOperator<K,V>
        extends UniqOperator<Map<K,V[]>>,
                NavigableArrayOperator<V>,
	        	NavigatingMapEntryOperator,
		        DistinguishableOperator,
		        CastableToArrayOperator,
		        SortableOperator<V>,
                ExecutableArrayOperator<V>,
                ModifiableCollectionOperator<V>,
                SelectableOperator<V[]>,
                ReplaceableOperator<V[]>,
                ReplaceableIfNullOperator<V[]>,
                ConvertibleToListOperator,
                ConvertibleToSetOperator,
                ConvertibleToMapOperator<V> {



    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> ifIndex(final int... indexes);
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> ifNull();
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indexes);
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> ifNotNull();
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V[]> eval);

    
    public Level3MapOfArrayEntriesValueElementsOperator<K,V> forEach(final Type<V> elementType);
    
    public Level1MapOfArrayEntriesOperator<K,V> endOn();

    public Level2MapOfArrayEntriesValueOperator<K,V> distinct();
    
    public Level2MapOfArrayEntriesValueOperator<K,V> sort();
    public Level2MapOfArrayEntriesValueOperator<K,V> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfArrayEntriesValueOperator<K,V> add(final V newElement);
    public Level2MapOfArrayEntriesValueOperator<K,V> addAll(final V... newElements);
    public Level2MapOfArrayEntriesValueOperator<K,V> insert(final int position, final V newElement);
    public Level2MapOfArrayEntriesValueOperator<K,V> insertAll(final int position, final V... newElements);
    public Level2MapOfArrayEntriesValueOperator<K,V> addAll(final Collection<V> collection);
    public Level2MapOfArrayEntriesValueOperator<K,V> removeAllIndexes(final int... indexes);
    public Level2MapOfArrayEntriesValueOperator<K,V> removeAllEqual(final V... values);
    public Level2MapOfArrayEntriesValueOperator<K,V> removeAllTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesValueOperator<K,V> removeAllFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesValueOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesValueOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesValueOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesValueOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesValueOperator<K,V> removeAllIndexesNot(final int... indexes);
    public Level2MapOfArrayEntriesValueOperator<K,V> removeAllNull();
    public Level2MapOfListEntriesValueOperator<K,V> toList();
    
    public Level2MapOfSetEntriesValueOperator<K,V> toSet();
    
    public Level2MapOfMapEntriesValueOperator<K,V,V> toMap();
    public <K2> Level2MapOfMapEntriesValueOperator<K,K2,V> toMap(final IEvaluator<K2,? super V> keyEval);
    public <K2,V2> Level2MapOfMapEntriesValueOperator<K,K2,V2> toMap(final IMapBuilder<K2,V2,? super V> mapBuild);

    
    public Level2MapOfArrayEntriesValueOperator<K,V> replaceWith(final V[] replacement);
    public Level2MapOfArrayEntriesValueOperator<K,V> replaceIfNullWith(final V[] replacement);


    public <X> Level2MapOfArrayEntriesValueOperator<K,X> convert(final IConverter<X[],? super V[]> converter);
    
    public <X> Level2MapOfArrayEntriesValueOperator<K,X> eval(final IEvaluator<X[],? super V[]> eval);

    public <X> Level2MapOfArrayEntriesValueOperator<K,X> exec(final IFunction<X[], ? super V[]> function);

    public <X> Level2MapEntriesValueOperator<K,X> exec(final Type<X> resultType, final IFunction<? extends X, ? super V[]> function);
    
    public <X> Level2MapEntriesValueOperator<K,X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super V[]> eval);
    
    public <X> Level2MapEntriesValueOperator<K,X> convert(final Type<X> resultType, final IConverter<? extends X,? super V[]> converter);    
    
    
    
    public <X> Level2MapOfArrayEntriesValueOperator<K,X> asArrayOf(final Type<X> type);
    public Level2MapOfArrayEntriesValueOperator<K,?> asArrayOfUnknown();
    
    
}

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
public interface Level2MapOfArrayEntriesValueOperator<K,V,I>
        extends UniqOperator<Map<K,V[]>,I>,
                NavigableArrayOperator<V,I>,
	        	NavigatingMapEntryOperator<I>,
		        DistinguishableOperator<I>,
		        CastableToArrayOperator<I>,
		        SortableOperator<V,I>,
                ExecutableArrayOperator<V,I>,
                ModifiableCollectionOperator<V,I>,
                SelectableOperator<V[],I>,
                ReplaceableOperator<V[],I>,
                ReplaceableIfNullOperator<V[],I>,
                ConvertibleToListOperator<I>,
                ConvertibleToSetOperator<I>,
                ConvertibleToMapOperator<V,I> {



    public Level2MapOfArrayEntriesValueSelectedOperator<K,V,I> ifIndex(final int... indices);
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V,I> ifNull();
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V[]> eval);
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V,I> ifIndexNot(final int... indices);
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V,I> ifNotNull();
    public Level2MapOfArrayEntriesValueSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V[]> eval);

    
    public Level3MapOfArrayEntriesValueElementsOperator<K,V,I> forEach(final Type<V> elementType);
    
    public Level1MapOfArrayEntriesOperator<K,V,I> endOn();

    public Level2MapOfArrayEntriesValueOperator<K,V,I> distinct();
    
    public Level2MapOfArrayEntriesValueOperator<K,V,I> sort();
    public Level2MapOfArrayEntriesValueOperator<K,V,I> sort(final Comparator<? super V> comparator);
    
        
    public Level2MapOfArrayEntriesValueOperator<K,V,I> add(final V newElement);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> addAll(final V... newElements);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> insert(final int position, final V newElement);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> insertAll(final int position, final V... newElements);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> addAll(final Collection<V> collection);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> removeAllIndexes(final int... indices);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> removeAllEqual(final V... values);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> removeAllIndexesNot(final int... indices);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> removeAllNull();
    public Level2MapOfListEntriesValueOperator<K,V,I> toList();
    
    public Level2MapOfSetEntriesValueOperator<K,V,I> toSet();
    
    public Level2MapOfMapEntriesValueOperator<K,V,V,I> toMap();
    public <K2> Level2MapOfMapEntriesValueOperator<K,K2,V,I> toMap(final IEvaluator<K2,? super V> keyEval);
    public <K2,V2> Level2MapOfMapEntriesValueOperator<K,K2,V2,I> toMap(final IMapBuilder<K2,V2,? super V> mapBuild);

    
    public Level2MapOfArrayEntriesValueOperator<K,V,I> replaceWith(final V[] replacement);
    public Level2MapOfArrayEntriesValueOperator<K,V,I> replaceIfNullWith(final V[] replacement);


    public <X> Level2MapOfArrayEntriesValueOperator<K,X,I> convert(final IConverter<X[],? super V[]> converter);
    
    public <X> Level2MapOfArrayEntriesValueOperator<K,X,I> eval(final IEvaluator<X[],? super V[]> eval);

    public <X> Level2MapOfArrayEntriesValueOperator<K,X,I> exec(final IFunction<X[], ? super V[]> function);

    public <X> Level2MapEntriesValueOperator<K,X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super V[]> function);
    
    public <X> Level2MapEntriesValueOperator<K,X,I> eval(final Type<X> resultType, final IEvaluator<? extends X,? super V[]> eval);
    
    public <X> Level2MapEntriesValueOperator<K,X,I> convert(final Type<X> resultType, final IConverter<? extends X,? super V[]> converter);    
    
    
    
    public <X> Level2MapOfArrayEntriesValueOperator<K,X,I> asArrayOf(final Type<X> type);
    public Level2MapOfArrayEntriesValueOperator<K,?,I> asArrayOfUnknown();
    
    
}

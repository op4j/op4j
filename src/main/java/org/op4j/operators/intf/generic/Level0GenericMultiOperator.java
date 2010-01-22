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
package org.op4j.operators.intf.generic;

import java.util.Collection;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.qualities.BuilderMultiOperator;
import org.op4j.operators.qualities.BuilderOperator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.ModifiableGrowableOperator;
import org.op4j.operators.qualities.ModifiableShrinkableOperator;
import org.op4j.operators.qualities.MultiOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqableOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level0GenericMultiOperator<T,I>
        extends MultiOperator<T,I>,
                UniqableOperator<T,I>,
        		BuilderOperator<T,I>,
        		BuilderMultiOperator<T,I>,
        		ExecutableOperator<T,I>,
                CastableToTypeOperator<T,I>,
                SelectableOperator<T,I>,
                ReplaceableOperator<T,I>,
                ReplaceableIfNullOperator<T,I>,
                ModifiableGrowableOperator<T,I>,
                ModifiableShrinkableOperator<T,I> {



    public Level0GenericMultiSelectedOperator<T,I> ifIndex(final int... indices);
    public Level0GenericMultiSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T,I> ifNull();
    public Level0GenericMultiSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level0GenericMultiSelectedOperator<T,I> ifNotNull();
    public Level0GenericMultiSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);


    
    public Level0GenericUniqOperator<T,I> uniq();

    
    
    public Level0GenericMultiOperator<T,I> replaceWith(final T replacement);
    public Level0GenericMultiOperator<T,I> replaceIfNullWith(final T replacement);


    public <X> Level0GenericMultiOperator<X,I> convert(final IConverter<X,? super T> converter);
    
    public <X> Level0GenericMultiOperator<X,I> eval(final IEvaluator<X,? super T> eval);

    public <X> Level0GenericMultiOperator<X,I> exec(final IFunction<X, ? super T> function);
    
    
    
    public <X> Level0GenericMultiOperator<X,I> asType(final Type<X> type);
    public Level0GenericMultiOperator<?,I> asUnknown();
        
    public Level0GenericMultiOperator<T,I> add(final T newElement);
    public Level0GenericMultiOperator<T,I> addAll(final T... newElements);
    public Level0GenericMultiOperator<T,I> insert(final int position, final T newElement);
    public Level0GenericMultiOperator<T,I> insertAll(final int position, final T... newElements);
    public Level0GenericMultiOperator<T,I> addAll(final Collection<T> collection);
    public Level0GenericMultiOperator<T,I> removeAllIndexes(final int... indices);
    public Level0GenericMultiOperator<T,I> removeAllEqual(final T... values);
    public Level0GenericMultiOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T,I> removeAllIndexesNot(final int... indices);
    public Level0GenericMultiOperator<T,I> removeAllNull();
    public Level0ListOperator<T,I> buildList();
    
    
    public Level0SetOperator<T,I> buildSet();
    
    
    public Level0ArrayOperator<T,I> buildArray(final Type<T> of);
    
    
    public <K> Level0MapOperator<K,T,I> buildMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V,I> buildMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfListOperator<K,T,I> buildMapOfList(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOfListOperator<K,V,I> buildMapOfList(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfSetOperator<K,T,I> buildMapOfSet(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOfSetOperator<K,V,I> buildMapOfSet(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfArrayOperator<K,T,I> buildMapOfArray(final Type<T> valueArrayOf, final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOfArrayOperator<K,V,I> buildMapOfArray(final Type<V> valueArrayOf, final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level0MapOperator<T,T,I> buildMap();
    
    public Level0MapOfListOperator<T,T,I> buildMapOfList();
    
    public Level0MapOfSetOperator<T,T,I> buildMapOfSet();
    
    public Level0MapOfArrayOperator<T,T,I> buildMapOfArray(final Type<T> of);
    
    
    public T[] getAsArray(final Type<T> type); 
    public List<T> getAsList(); 
    

}

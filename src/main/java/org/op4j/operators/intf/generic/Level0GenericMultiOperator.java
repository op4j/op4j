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
public interface Level0GenericMultiOperator<T>
        extends MultiOperator<T>,
                UniqableOperator<T>,
        		BuilderOperator<T>,
        		BuilderMultiOperator<T>,
        		ExecutableOperator<T>,
                CastableToTypeOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                ModifiableGrowableOperator<T>,
                ModifiableShrinkableOperator<T> {



    public Level0GenericMultiSelectedOperator<T> ifIndex(final int... indices);
    public Level0GenericMultiSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T> ifNull();
    public Level0GenericMultiSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T> ifIndexNot(final int... indices);
    public Level0GenericMultiSelectedOperator<T> ifNotNull();
    public Level0GenericMultiSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);


    
    public Level0GenericUniqOperator<T> uniq();

    
    
    public Level0GenericMultiOperator<T> replaceWith(final T replacement);
    public Level0GenericMultiOperator<T> replaceIfNullWith(final T replacement);


    public <X> Level0GenericMultiOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> Level0GenericMultiOperator<X> eval(final IEvaluator<X,? super T> eval);

    public <X> Level0GenericMultiOperator<X> exec(final IFunction<X, ? super T> function);
    
    
    
    public <X> Level0GenericMultiOperator<X> asType(final Type<X> type);
    public Level0GenericMultiOperator<?> asUnknown();
        
    public Level0GenericMultiOperator<T> add(final T newElement);
    public Level0GenericMultiOperator<T> addAll(final T... newElements);
    public Level0GenericMultiOperator<T> insert(final int position, final T newElement);
    public Level0GenericMultiOperator<T> insertAll(final int position, final T... newElements);
    public Level0GenericMultiOperator<T> addAll(final Collection<T> collection);
    public Level0GenericMultiOperator<T> removeAllIndexes(final int... indices);
    public Level0GenericMultiOperator<T> removeAllEqual(final T... values);
    public Level0GenericMultiOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T> removeAllIndexesNot(final int... indices);
    public Level0GenericMultiOperator<T> removeAllNull();
    public Level0ListOperator<T> buildList();
    
    
    public Level0SetOperator<T> buildSet();
    
    
    public Level0ArrayOperator<T> buildArray(final Type<T> of);
    
    
    public <K> Level0MapOperator<K,T> buildMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V> buildMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfListOperator<K,T> buildMapOfList(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOfListOperator<K,V> buildMapOfList(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfSetOperator<K,T> buildMapOfSet(final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOfSetOperator<K,V> buildMapOfSet(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOfArrayOperator<K,T> buildMapOfArray(final Type<T> valueArrayOf, final IEvaluator<K,? super T> keyEval);
    public <K,V> Level0MapOfArrayOperator<K,V> buildMapOfArray(final Type<V> valueArrayOf, final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level0MapOperator<T,T> buildMap();
    
    public Level0MapOfListOperator<T,T> buildMapOfList();
    
    public Level0MapOfSetOperator<T,T> buildMapOfSet();
    
    public Level0MapOfArrayOperator<T,T> buildMapOfArray(final Type<T> of);
    
    
    public T[] getAsArray(final Type<T> type); 
    public List<T> getAsList(); 
    

}

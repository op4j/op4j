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
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
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
public interface Level0GenericMultiOperator<I,T>
        extends MultiOperator<T>,
                UniqableOperator<T>,
        		BuilderOperator<I,T>,
        		BuilderMultiOperator<I,T>,
        		ExecutableOperator<T>,
                CastableToTypeOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                ModifiableGrowableOperator<T>,
                ModifiableShrinkableOperator<T> {



    public Level0GenericMultiSelectedOperator<I,T> ifIndex(final int... indexes);
    public Level0GenericMultiSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval);
    public Level0GenericMultiSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval);
    public Level0GenericMultiSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval);
    public Level0GenericMultiSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public Level0GenericMultiSelectedOperator<I,T> ifNull();
    public Level0GenericMultiSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval);
    public Level0GenericMultiSelectedOperator<I,T> ifIndexNot(final int... indexes);
    public Level0GenericMultiSelectedOperator<I,T> ifNotNull();
    public Level0GenericMultiSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval);


    
    public Level0GenericUniqOperator<I,T> uniq();

    
    
    public Level0GenericMultiOperator<I,T> replaceWith(final T replacement);
    public Level0GenericMultiOperator<I,T> replaceIfNullWith(final T replacement);


    public <X> Level0GenericMultiOperator<I,X> execIfNotNull(final IFunction<? super T,X> function);

    public <X> Level0GenericMultiOperator<I,X> exec(final IFunction<? super T,X> function);
    
    
    
    public <X> Level0GenericMultiOperator<I,X> asType(final Type<X> type);
    public Level0GenericMultiOperator<I,?> asUnknown();
        
    public Level0GenericMultiOperator<I,T> add(final T newElement);
    public Level0GenericMultiOperator<I,T> addAll(final T... newElements);
    public Level0GenericMultiOperator<I,T> insert(final int position, final T newElement);
    public Level0GenericMultiOperator<I,T> insertAll(final int position, final T... newElements);
    public Level0GenericMultiOperator<I,T> addAll(final Collection<T> collection);
    public Level0GenericMultiOperator<I,T> removeAllIndexes(final int... indexes);
    public Level0GenericMultiOperator<I,T> removeAllEqual(final T... values);
    public Level0GenericMultiOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval);
    public Level0GenericMultiOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval);
    public Level0GenericMultiOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval);
    public Level0GenericMultiOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public Level0GenericMultiOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval);
    public Level0GenericMultiOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval);
    public Level0GenericMultiOperator<I,T> removeAllIndexesNot(final int... indexes);
    public Level0GenericMultiOperator<I,T> removeAllNull();
    public Level0ListOperator<I,T> buildList();
    
    
    public Level0SetOperator<I,T> buildSet();
    
    
    public Level0ArrayOperator<I,T> buildArrayOf(final Type<T> type);
    
    
    public <K> Level0MapOperator<I,K,T> buildMap(final IFunction<? super T,K> keyEval);
    public <K,V> Level0MapOperator<I,K,V> buildMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOperator<I,K,List<T>> buildMapOfList(final IFunction<? super T,K> keyEval);
    public <K,V> Level0MapOperator<I,K,List<V>> buildMapOfList(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOperator<I,K,Set<T>> buildMapOfSet(final IFunction<? super T,K> keyEval);
    public <K,V> Level0MapOperator<I,K,Set<V>> buildMapOfSet(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOperator<I,K,T[]> buildMapOfArrayOf(final Type<T> valueType, final IFunction<? super T,K> keyEval);
    public <K,V> Level0MapOperator<I,K,V[]> buildMapOfArrayOf(final Type<V> valueType, final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level0MapOperator<I,T,T> buildMap();
    
    public Level0MapOperator<I,T,List<T>> buildMapOfList();
    
    public Level0MapOperator<I,T,Set<T>> buildMapOfSet();
    
    public Level0MapOperator<I,T,T[]> buildMapOfArrayOf(final Type<T> type);
    

}

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
import org.op4j.operators.qualities.MultiOpOperator;
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
        extends MultiOpOperator<T>,
                UniqableOperator<T>,
        		BuilderOperator<T,I>,
        		BuilderMultiOperator<T,I>,
        		ExecutableOperator<T>,
                CastableToTypeOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                ModifiableGrowableOperator<T>,
                ModifiableShrinkableOperator<T> {



    public Level0GenericMultiSelectedOperator<T,I> ifIndex(final int... indexes);
    public Level0GenericMultiSelectedOperator<T,I> ifTrue(final IFunction<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T,I> ifFalse(final IFunction<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T,I> ifNull();
    public Level0GenericMultiSelectedOperator<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level0GenericMultiSelectedOperator<T,I> ifIndexNot(final int... indexes);
    public Level0GenericMultiSelectedOperator<T,I> ifNotNull();
    public Level0GenericMultiSelectedOperator<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval);


    
    public Level0GenericUniqOperator<T,I> uniq();

    
    
    public Level0GenericMultiOperator<T,I> replaceWith(final T replacement);
    public Level0GenericMultiOperator<T,I> replaceIfNullWith(final T replacement);


    public <X> Level0GenericMultiOperator<X,I> execIfNotNull(final IFunction<X,? super T> function);

    public <X> Level0GenericMultiOperator<X,I> exec(final IFunction<X, ? super T> function);
    
    
    
    public <X> Level0GenericMultiOperator<X,I> asType(final Type<X> type);
    public Level0GenericMultiOperator<?,I> asUnknown();
        
    public Level0GenericMultiOperator<T,I> add(final T newElement);
    public Level0GenericMultiOperator<T,I> addAll(final T... newElements);
    public Level0GenericMultiOperator<T,I> insert(final int position, final T newElement);
    public Level0GenericMultiOperator<T,I> insertAll(final int position, final T... newElements);
    public Level0GenericMultiOperator<T,I> addAll(final Collection<T> collection);
    public Level0GenericMultiOperator<T,I> removeAllIndexes(final int... indexes);
    public Level0GenericMultiOperator<T,I> removeAllEqual(final T... values);
    public Level0GenericMultiOperator<T,I> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T,I> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T,I> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T,I> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T,I> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T,I> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level0GenericMultiOperator<T,I> removeAllIndexesNot(final int... indexes);
    public Level0GenericMultiOperator<T,I> removeAllNull();
    public Level0ListOperator<T,I> buildList();
    
    
    public Level0SetOperator<T,I> buildSet();
    
    
    public Level0ArrayOperator<T,I> buildArrayOf(final Type<T> type);
    
    
    public <K> Level0MapOperator<K,T,I> buildMap(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V,I> buildMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOperator<K,List<T>,I> buildMapOfList(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,List<V>,I> buildMapOfList(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOperator<K,Set<T>,I> buildMapOfSet(final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,Set<V>,I> buildMapOfSet(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> Level0MapOperator<K,T[],I> buildMapOfArrayOf(final Type<T> valueType, final IFunction<K,? super T> keyEval);
    public <K,V> Level0MapOperator<K,V[],I> buildMapOfArrayOf(final Type<V> valueType, final IMapBuilder<K,V,? super T> mapBuild);

    
    public Level0MapOperator<T,T,I> buildMap();
    
    public Level0MapOperator<T,List<T>,I> buildMapOfList();
    
    public Level0MapOperator<T,Set<T>,I> buildMapOfSet();
    
    public Level0MapOperator<T,T[],I> buildMapOfArrayOf(final Type<T> type);
    
    
    public T[] getAsArray(final Type<T> type); 
    public List<T> getAsList(); 
    

}

/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.BuilderMultiOperator;
import org.op4j.operators.qualities.BuilderOperator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.ModifiableGrowableOperator;
import org.op4j.operators.qualities.ModifiableShrinkableOperator;
import org.op4j.operators.qualities.MultiOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableElementsOperator;
import org.op4j.operators.qualities.UniqableOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0GenericMultiOperator<I,T>
        extends MultiOperator<T>,
                UniqableOperator<T>,
        		BuilderOperator<I,T>,
        		BuilderMultiOperator<I,T>,
        		ExecutableOperator<T>,
                CastableToTypeOperator<T>,
                SelectableElementsOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                ModifiableGrowableOperator<T>,
                ModifiableShrinkableOperator<T> {



    public ILevel0GenericMultiSelectedOperator<I,T> ifIndex(final int... indexes);
    public ILevel0GenericMultiSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericMultiSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericMultiSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericMultiSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericMultiSelectedOperator<I,T> ifNull();
    public ILevel0GenericMultiSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericMultiSelectedOperator<I,T> ifIndexNot(final int... indexes);
    public ILevel0GenericMultiSelectedOperator<I,T> ifNotNull();
    public ILevel0GenericMultiSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval);


    
    public ILevel0GenericUniqOperator<I,T> uniq();

    
    
    public ILevel0GenericMultiOperator<I,T> replaceWith(final T replacement);
    public ILevel0GenericMultiOperator<I,T> replaceIfNullWith(final T replacement);


    public <X> ILevel0GenericMultiOperator<I,X> execIfNotNull(final IFunction<? super T,X> function);

    public <X> ILevel0GenericMultiOperator<I,X> exec(final IFunction<? super T,X> function);
    
    
    
    public <X> ILevel0GenericMultiOperator<I,X> asType(final Type<X> type);
    
        
    public ILevel0GenericMultiOperator<I,T> add(final T newElement);
    public ILevel0GenericMultiOperator<I,T> addAll(final T... newElements);
    public ILevel0GenericMultiOperator<I,T> insert(final int position, final T newElement);
    public ILevel0GenericMultiOperator<I,T> insertAll(final int position, final T... newElements);
    public ILevel0GenericMultiOperator<I,T> addAll(final Collection<T> collection);
    public ILevel0GenericMultiOperator<I,T> removeAllIndexes(final int... indexes);
    public ILevel0GenericMultiOperator<I,T> removeAllEqual(final T... values);
    public ILevel0GenericMultiOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericMultiOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericMultiOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericMultiOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericMultiOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericMultiOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericMultiOperator<I,T> removeAllIndexesNot(final int... indexes);
    public ILevel0GenericMultiOperator<I,T> removeAllNull();
    public ILevel0ListOperator<I,T> buildList();
    
    
    public ILevel0SetOperator<I,T> buildSet();
    
    
    public ILevel0ArrayOperator<I,T> buildArrayOf(final Type<T> type);
    
    
    public <K> ILevel0MapOperator<I,K,T> buildMapByKeyEval(final IFunction<? super T,K> keyEval);
    public <K,V> ILevel0MapOperator<I,K,V> buildMap(final IMapBuilder<? super T,K,V> mapBuilder);
    
    
    public <K> ILevel0MapOperator<I,K,List<T>> buildMapOfListByKeyEval(final IFunction<? super T,K> keyEval);
    public <K,V> ILevel0MapOperator<I,K,List<V>> buildMapOfList(final IMapBuilder<? super T,K,V> mapBuilder);
    
    
    public <K> ILevel0MapOperator<I,K,Set<T>> buildMapOfSetByKeyEval(final IFunction<? super T,K> keyEval);
    public <K,V> ILevel0MapOperator<I,K,Set<V>> buildMapOfSet(final IMapBuilder<? super T,K,V> mapBuilder);
    
    
    public <K> ILevel0MapOperator<I,K,T[]> buildMapOfArrayByKeyEvalOf(final Type<T> valueType, final IFunction<? super T,K> keyEval);
    public <K,V> ILevel0MapOperator<I,K,V[]> buildMapOfArrayOf(final Type<V> valueType, final IMapBuilder<? super T,K,V> mapBuilder);

    
    public ILevel0MapOperator<I,T,T> buildMapByAlternateElements();
    
    public ILevel0MapOperator<I,T,List<T>> buildMapOfListByAlternateElements();
    
    public ILevel0MapOperator<I,T,Set<T>> buildMapOfSetByAlternateElements();
    
    public ILevel0MapOperator<I,T,T[]> buildMapOfArrayByAlternateElementsOf(final Type<T> type);
    

}

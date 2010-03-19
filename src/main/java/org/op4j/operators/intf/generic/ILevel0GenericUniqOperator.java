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

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.BuilderOperator;
import org.op4j.operators.qualities.CastableToStructuresOperator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOperator;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0GenericUniqOperator<I,T>
        extends UniqOperator<T>,
                CastableToStructuresOperator,
        		BuilderOperator<I,T>,
        		ExecutableOperator<T>,
                CastableToTypeOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T> {



    public ILevel0GenericUniqSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericUniqSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericUniqSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericUniqSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericUniqSelectedOperator<I,T> ifNull();
    public ILevel0GenericUniqSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericUniqSelectedOperator<I,T> ifNotNull();
    public ILevel0GenericUniqSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval);

    
    public ILevel0GenericUniqOperator<I,T> replaceWith(final T replacement);
    public ILevel0GenericUniqOperator<I,T> replaceIfNullWith(final T replacement);


    public <X> ILevel0GenericUniqOperator<I,X> execIfNotNull(final IFunction<? super T,X> function);

    public <X> ILevel0GenericUniqOperator<I,X> exec(final IFunction<? super T,X> function);

    
    
    public <X> ILevel0GenericUniqOperator<I,X> castTo(final Type<X> type);
    public <X> ILevel0ArrayOperator<I,X> castToArrayOf(final Type<X> type);
    public <X> ILevel0ListOperator<I,X> castToListOf(final Type<X> type);
    public <K,V> ILevel0MapOperator<I,K,V> castToMapOf(final Type<K> keyType, final Type<V> valueType);
    public <X> ILevel0SetOperator<I,X> castToSetOf(final Type<X> type);
    

    
    public ILevel0ListOperator<I,T> buildList();
    
    
    public ILevel0SetOperator<I,T> buildSet();
    
    
    public ILevel0ArrayOperator<I,T> buildArrayOf(final Type<T> type);
    
    
    public <K> ILevel0MapOperator<I,K,T> buildMapByKeyEval(final IFunction<? super T,K> keyEval);
    public <K,V> ILevel0MapOperator<I,K,V> buildMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder);
    
    
    public <K> ILevel0MapOperator<I,K,List<T>> buildMapOfListByKeyEval(final IFunction<? super T,K> keyEval);
    public <K,V> ILevel0MapOperator<I,K,List<V>> buildMapOfList(final IFunction<? super T,Map.Entry<K,V>> mapBuilder);
    
    
    public <K> ILevel0MapOperator<I,K,Set<T>> buildMapOfSetByKeyEval(final IFunction<? super T,K> keyEval);
    public <K,V> ILevel0MapOperator<I,K,Set<V>> buildMapOfSet(final IFunction<? super T,Map.Entry<K,V>> mapBuilder);
    
    
    public <K> ILevel0MapOperator<I,K,T[]> buildMapOfArrayByKeyEvalOf(final Type<T> valueType, final IFunction<? super T,K> keyEval);
    public <K,V> ILevel0MapOperator<I,K,V[]> buildMapOfArrayOf(final Type<V> valueType, final IFunction<? super T,Map.Entry<K,V>> mapBuilder);

    
    
    
    public ILevel0ArrayOperator<I,T> unfoldArrayOf(final Type<T> type, final IFunction<? super T,? extends T> function);
    public ILevel0ArrayOperator<I,T> unfoldArrayOf(final Type<T> type, final IFunction<? super T,? extends T> function, final IFunction<? super T,Boolean> whileCondition);
    public ILevel0ListOperator<I,T> unfoldList(final IFunction<? super T,? extends T> function);
    public ILevel0ListOperator<I,T> unfoldList(final IFunction<? super T,? extends T> function, final IFunction<? super T,Boolean> whileCondition);
    public ILevel0SetOperator<I,T> unfoldSet(final IFunction<? super T,? extends T> function);
    public ILevel0SetOperator<I,T> unfoldSet(final IFunction<? super T,? extends T> function, final IFunction<? super T,Boolean> whileCondition);
    
    
}

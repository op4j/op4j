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
package org.op4j.operators.qualities;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;



/**
 * <p>
 * This interface defines methods for the building of structures from generic non-multi operators.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface BuilderOperator<I,T> {
    
    
    /**
     * <p>
     * Builds a list containing the operator's targets.
     * </p>
     * 
     * @return an operator on the resulting list
     */
    public ILevel0ListOperator<I,T> intoSingletonList();
    
    
    /**
     * <p>
     * Builds a set containing the operator's targets.
     * </p>
     * 
     * @return an operator on the resulting set
     */
    public ILevel0SetOperator<I,T> intoSingletonSet();
    
    
    /**
     * <p>
     * Builds an array of the specified type containing the operator's targets.
     * </p>
     * 
     * @param type the type if which the array will be instantiated
     * @return an operator on the resulting array
     */
    public ILevel0ArrayOperator<I,T> intoSingletonArrayOf(final Type<T> type);
    
    
    /**
     * <p>
     * Builds a one-entry map using the operator's target as a value, and the result of executing
     * the keyEval evaluator on the target as a key.
     * </p>
     * 
     * @param <K> the type of the new key, resulting from evaluating keyEval
     * @param keyEval the evaluator to be used for obtaining the key
     * @return an operator on the resulting map
     */
    public <K> ILevel0MapOperator<I,K,T> zipKeyBy(final IFunction<? super T,K> keyEval);
    
    
    /**
     * <p>
     * Builds a one-entry map using the operator's target as a key, and the result of executing
     * the valueEval evaluator on the target as a value.
     * </p>
     * 
     * @param <V> the type of the new value, resulting from evaluating valueEval
     * @param valueEval the evaluator to be used for obtaining the value
     * @return an operator on the resulting map
     */
    public <V> ILevel0MapOperator<I,T,V> zipValueBy(final IFunction<? super T,V> valueEval);
    
    
    /**
     * <p>
     * Builds a one-entry map using the operator's target as a value, and the specified
     * object as a key.
     * </p>
     * 
     * @param <K> the type of the new key, resulting from evaluating keyEval
     * @param keyEval the evaluator to be used for obtaining the key
     * @return an operator on the resulting map
     */
    public <K> ILevel0MapOperator<I,K,T> zipKey(final K key);
    
    
    /**
     * <p>
     * Builds a one-entry map using the operator's target as a key, and the specified
     * object as a value.
     * </p>
     * 
     * @param <V> the type of the new value, resulting from evaluating valueEval
     * @param valueEval the evaluator to be used for obtaining the value
     * @return an operator on the resulting map
     */
    public <V> ILevel0MapOperator<I,T,V> zipValue(final V value);
    
    
    /**
     * <p>
     * Builds a map by inputting the operator's targets into a map builder object
     * (a function returning map entries), which is in charge of creating the 
     * corresponding key and value for each original target.
     * If two values have the same key, all of them but the last to be evaluated will be 
     * overwritten.
     * </p>
     * 
     * @param <K> the type of the keys returned by the map builder
     * @param <V> the type of the values returned by the map builder
     * @param mapBuilder the map builder function
     * @return an operator on the resulting map
     */
    public <K,V> ILevel0MapOperator<I,K,V> intoSingletonMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder);
    
    
}

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

import java.util.Collection;
import java.util.Map;

import org.op4j.functions.IFunction;


/**
 * <p>
 * This interface contains methods for conversions to map.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ConvertibleToMapOperator<T> {
    
    
    /**
     * <p>
     * Converts the target object to a map, by using the even elements 
     * (starting at 0) as keys, and the odd elements as values.
     * </p>
     * 
     * @return an operator holding the converted object as target.
     */
    public Operator couple();
 
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as values and applying an evaluator (keyEval) to them
     * in order to obtain their corresponding keys.
     * </p>
     * <p>
     * Note that if more than one value get the same key, only the last one
     * will be in the resulting map (the other ones will be overwritten).
     * </p>
     * 
     * @param <K> the type of the keys that will be created
     * @param keyEval the evaluator used for obtaining the keys
     * @return an operator holding the converted object as target.
     */
    public <K> Operator zipKeysBy(final IFunction<? super T,K> keyEval);
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as keys and applying an evaluator (valueEval) to them
     * in order to obtain their corresponding value.
     * </p>
     * <p>
     * Note that if more than one value get the same key, only the last one
     * will be in the resulting map (the other ones will be overwritten).
     * </p>
     * 
     * @param <V> the type of the values that will be created
     * @param valueEval the evaluator used for obtaining the values
     * @return an operator holding the converted object as target.
     */
    public <V> Operator zipValuesBy(final IFunction<? super T,V> valueEval);
 
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as values and setting the specified objects as keys.
     * </p>
     * <p>
     * Note that if more than one value get the same key, only the last one
     * will be in the resulting map (the other ones will be overwritten).
     * </p>
     * 
     * @param <K> the type of the keys
     * @param keys the new keys
     * @return an operator holding the converted object as target.
     */
    public <K> Operator zipKeys(final K... keys);
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as keys and applying an evaluator (valueEval) to them
     * in order to obtain their corresponding value.
     * </p>
     * 
     * @param <V> the type of the values
     * @param values the new values
     * @return an operator holding the converted object as target.
     */
    public <V> Operator zipValues(final V... values);
 
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as values and setting the specified objects as keys.
     * </p>
     * <p>
     * Note that if more than one value get the same key, only the last one
     * will be in the resulting map (the other ones will be overwritten).
     * </p>
     * 
     * @param <K> the type of the keys
     * @param keys the new keys
     * @return an operator holding the converted object as target.
     */
    public <K> Operator zipKeysFrom(final Collection<K> keys);
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as keys and applying an evaluator (valueEval) to them
     * in order to obtain their corresponding value.
     * </p>
     * 
     * @param <V> the type of the values
     * @param values the new values
     * @return an operator holding the converted object as target.
     */
    public <V> Operator zipValuesFrom(final Collection<V> values);
 
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as values and setting the specified objects as keys.
     * </p>
     * <p>
     * Note that if more than one value get the same key, only the last one
     * will be in the resulting map (the other ones will be overwritten).
     * </p>
     * 
     * @param <K> the type of the keys
     * @param keys the new keys
     * @return an operator holding the converted object as target.
     */
    public <K> Operator zipKeysFrom(final K[] keys);
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as keys and applying an evaluator (valueEval) to them
     * in order to obtain their corresponding value.
     * </p>
     * 
     * @param <V> the type of the values
     * @param values the new values
     * @return an operator holding the converted object as target.
     */
    public <V> Operator zipValuesFrom(final V[] values);

    
    /**
     * <p>
     * Converts the target object to a map by inputting the original target's
     * elements into the specified map builder (a function returning map entries)
     * which will create the resulting keys and values.
     * </p>
     * <p>
     * Note that if more than one value get the same key, only the last one
     * will be in the resulting map (the other ones will be overwritten).
     * </p>
     * 
     * @param <K> the type of the keys that will be created
     * @param <V> the type of the values that will be created
     * @param mapBuilder the map builder function to be used
     * @return an operator holding the converted object as target.
     */
    public <K,V> Operator toMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder);
    
}

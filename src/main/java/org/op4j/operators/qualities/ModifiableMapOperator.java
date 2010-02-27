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

import org.op4j.functions.IFunction;

/**
 * <p>
 * This interface contains methods for modifying maps (adding/removing elements).
 * </p> 
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ModifiableMapOperator<K,V> {
    

    /**
     * <p>
     * Adds a new entry with the specified key and value at the end of the target map.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param newKey the key for the new entry to be added
     * @param newValue the value for the new entry to be added
     * @return an operator holding the modified map
     */
    public ModifiableMapOperator<K,V> put(final K newKey, final V newValue);
    

    /**
     * <p>
     * Inserts a new entry with the specified key and value into the specified position 
     * (starting in 0) of the target map.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param position the position into which the new entry will be inserted
     * @param newKey the key for the new entry to be insert
     * @param newValue the value for the new entry to be insert
     * @return an operator holding the modified map
     */
    public ModifiableMapOperator<K,V> insert(final int position, final K newKey, final V newValue);
    

    /**
     * <p>
     * Adds all the entries in the specified map to the target map.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param map the map containing the entries to be added.
     * @return an operator holding the modified map
     */
    public ModifiableMapOperator<K,V> putAll(final Map<K,V> map);
    
    
    /**
     * <p>
     * Inserts all the entries in the specified map to the target map, in the specified position.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param position the position into which the entries will be added.
     * @param map the map containing the entries to be inserted.
     * @return an operator holding the modified map
     */
    public ModifiableMapOperator<K,V> insertAll(final int position, final Map<K,V> map);
    
    
    /**
     * <p>
     * Removes from the target map all entries which keys match the ones specified.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param keys the keys which have to be removed.
     * @return an operator holding the modified map
     */
    public ModifiableMapOperator<K,V> removeAllKeys(final K... keys);
    
    
    /**
     * <p>
     * Removes from the target map all the entries which evaluate as true
     * using the specified evaluator.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param eval the evaluator to be used, which must return Boolean 
     * @return an operator holding the modified map
     */
    public ModifiableMapOperator<K,V> removeAllTrue(final IFunction<? super Map.Entry<K,V>,Boolean> eval);
    
    
    /**
     * <p>
     * Removes from the target map all the entries which evaluate as false
     * using the specified evaluator.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param eval the evaluator to be used, which must return Boolean 
     * @return an operator holding the modified map
     */
    public ModifiableMapOperator<K,V> removeAllFalse(final IFunction<? super Map.Entry<K,V>,Boolean> eval);
    
    
    /**
     * <p>
     * Removes from the target map all entries except those which keys match the ones specified.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param keys the keys which have to be kept.
     * @return an operator holding the modified map
     */
    public ModifiableMapOperator<K,V> removeAllKeysNot(final K... keys);
    
}

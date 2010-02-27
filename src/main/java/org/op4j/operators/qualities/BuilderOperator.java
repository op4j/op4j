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

import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.set.Level0SetOperator;



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
    public Level0ListOperator<I,T> buildList();
    
    
    /**
     * <p>
     * Builds a set containing the operator's targets.
     * </p>
     * 
     * @return an operator on the resulting set
     */
    public Level0SetOperator<I,T> buildSet();
    
    
    /**
     * <p>
     * Builds an array of the specified type containing the operator's targets.
     * </p>
     * 
     * @param type the type if which the array will be instantiated
     * @return an operator on the resulting array
     */
    public Level0ArrayOperator<I,T> buildArrayOf(final Type<T> type);
    
    
    /**
     * <p>
     * Builds a map using the operator's targets as values, and the results of executing
     * the keyEval evaluator on each targets as it key. If two values have the same key,
     * all of them but the last to be evaluated will be overwritten.
     * </p>
     * 
     * @param <K> the type of the new keys, resulting from evaluating keyEval
     * @param keyEval the evaluator to be used for obtaining keys
     * @return an operator on the resulting map
     */
    public <K> Level0MapOperator<I,K,T> buildMapByKeyEval(final IFunction<? super T,K> keyEval);
    
    
    /**
     * <p>
     * Builds a map by inputting the operator's targets into a map builder object, which
     * is in charge of creating the corresponding key and value for each original target.
     * If two values have the same key, all of them but the last to be evaluated will be 
     * overwritten.
     * </p>
     * 
     * @param <K> the type of the keys returned by the map builder
     * @param <V> the type of the values returned by the map builder
     * @param mapBuilder the map builder
     * @return an operator on the resulting map
     */
    public <K,V> Level0MapOperator<I,K,V> buildMap(final IMapBuilder<? super T,K,V> mapBuilder);
    
    
    /**
     * <p>
     * Builds a map of list (Map&lt;K,List&lt;V&gt;&gt;) using the operator's targets as values, 
     * and the results of executing the keyEval evaluator on each targets as it key. Values 
     * which share the same key will be added to that key's value list. 
     * </p>
     * 
     * @param <K> the type of the new keys, resulting from evaluating keyEval
     * @param keyEval the evaluator to be used for obtaining keys
     * @return an operator on the resulting map of list
     */
    public <K> Level0MapOperator<I,K,List<T>> buildMapOfListByKeyEval(final IFunction<? super T,K> keyEval);
    
    
    /**
     * <p>
     * Builds a map of list (Map&lt;K,List&lt;V&gt;&gt;) by inputting the operator's targets into 
     * a map builder object, which is in charge of creating the corresponding key and value for 
     * each original target. Values which share the same key will be added to that key's value list. 
     * </p>
     * 
     * @param <K> the type of the keys returned by the map builder
     * @param <V> the type of the values returned by the map builder
     * @param mapBuilder the map builder
     * @return an operator on the resulting map of list
     */
    public <K,V> Level0MapOperator<I,K,List<V>> buildMapOfList(final IMapBuilder<? super T,K,V> mapBuilder);
    

    /**
     * <p>
     * Builds a map of set (Map&lt;K,Set&lt;V&gt;&gt;) using the operator's targets as values, 
     * and the results of executing the keyEval evaluator on each targets as it key. Values 
     * which share the same key will be added to that key's value set. 
     * </p>
     * 
     * @param <K> the type of the new keys, resulting from evaluating keyEval
     * @param keyEval the evaluator to be used for obtaining keys
     * @return an operator on the resulting map of list
     */
    public <K> Level0MapOperator<I,K,Set<T>> buildMapOfSetByKeyEval(final IFunction<? super T,K> keyEval);
    
    
    /**
     * <p>
     * Builds a map of set (Map&lt;K,Set&lt;V&gt;&gt;) by inputting the operator's targets into 
     * a map builder object, which is in charge of creating the corresponding key and value for 
     * each original target. Values which share the same key will be added to that key's value set. 
     * </p>
     * 
     * @param <K> the type of the keys returned by the map builder
     * @param <V> the type of the values returned by the map builder
     * @param mapBuilder the map builder
     * @return an operator on the resulting map of list
     */
    public <K,V> Level0MapOperator<I,K,Set<V>> buildMapOfSet(final IMapBuilder<? super T,K,V> mapBuilder);
    
    
    /**
     * <p>
     * Builds a map of array (Map&lt;K,V[]&gt;) using the operator's targets as values, 
     * and the results of executing the keyEval evaluator on each targets as it key. Values 
     * which share the same key will be added to that key's value array. This array will be 
     * instantiated using the type passed as a parameter. 
     * </p>
     * 
     * @param <K> the type of the new keys, resulting from evaluating keyEval
     * @param valueType the type to be used to create the arrays of values
     * @param keyEval the evaluator to be used for obtaining keys
     * @return an operator on the resulting map of list
     */
    public <K> Level0MapOperator<I,K,T[]> buildMapOfArrayByKeyEvalOf(final Type<T> valueType, final IFunction<? super T,K> keyEval);

    
    /**
     * <p>
     * Builds a map of array (Map&lt;K,V[]&gt;) by inputting the operator's targets into 
     * a map builder object, which is in charge of creating the corresponding key and value for 
     * each original target. Values which share the same key will be added to that key's value 
     * array. This array will be instantiated using the type passed as a parameter.
     * </p>
     * 
     * @param <K> the type of the keys returned by the map builder
     * @param <V> the type of the values returned by the map builder
     * @param valueType the type to be used to create the arrays of values
     * @param mapBuilder the map builder
     * @return an operator on the resulting map of list
     */
    public <K,V> Level0MapOperator<I,K,V[]> buildMapOfArrayOf(final Type<V> valueType, final IMapBuilder<? super T,K,V> mapBuilder);
    
}

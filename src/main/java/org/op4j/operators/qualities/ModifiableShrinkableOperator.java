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
package org.op4j.operators.qualities;

import org.op4j.functions.IFunction;

/**
 * <p>
 * This interface contains methods for removing elements from a generic operator.
 * </p> 
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ModifiableShrinkableOperator<T> {

    
    /**
     * <p>
     * Removes all the elements in the operator which position (index) in it
     * matches one the specified indexes.
     * </p>
     * 
     * @param indexes the positions of the elements to be removed
     * @return an operator holding the new target objects
     */
    public ModifiableGrowableOperator<T> removeAllIndexes(final int... indexes);
    
    
    /**
     * <p>
     * Removes the specified values from the operator.
     * </p>
     * 
     * @param values the values to be removed from the target.
     * @return an operator holding the new target objects
     */
    public ModifiableGrowableOperator<T> removeAllEqual(final T... values);
    

    /**
     * <p>
     * Removes from the operator all the elements which evaluate as true
     * using the specified evaluator.
     * </p>
     * 
     * @param eval the evaluator to be used, which must return Boolean 
     * @return an operator holding the new target objects
     */
    public ModifiableGrowableOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval);
    
    
    /**
     * <p>
     * Removes from the operator all the elements which evaluate as false
     * using the specified evaluator.
     * </p>
     * 
     * @param eval the evaluator to be used, which must return Boolean 
     * @return an operator holding the new target objects
     */
    public ModifiableGrowableOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval);
    
    
    /**
     * <p>
     * Removes from the operator all the elements which either are null or evaluate as false
     * using the specified evaluator.
     * </p>
     * 
     * @param eval the evaluator to be used, which must return Boolean 
     * @return an operator holding the new target objects
     */
    public ModifiableGrowableOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval);
   
    
    /**
     * <p>
     * Removes from the operator all the elements which are not null and evaluate as false
     * using the specified evaluator.
     * </p>
     * 
     * @param eval the evaluator to be used, which must return Boolean 
     * @return an operator holding the new target objects
     */
    public ModifiableGrowableOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    
    
    /**
     * <p>
     * Removes from the operator all the elements which are not null and evaluate as true
     * using the specified evaluator.
     * </p>
     * 
     * @param eval the evaluator to be used, which must return Boolean 
     * @return an operator holding the new target objects
     */
    public ModifiableGrowableOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval);

    
    /**
     * <p>
     * Removes from the operator all the elements which either are null or evaluate as true
     * using the specified evaluator.
     * </p>
     * 
     * @param eval the evaluator to be used, which must return Boolean 
     * @return an operator holding the new target objects
     */
    public ModifiableGrowableOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval);
    
    
    /**
     * <p>
     * Removes all the elements in the operator except those which position (index) in it
     * matches one of the specified indexes.
     * </p>
     * 
     * @param indexes the positions of the elements to be kept
     * @return an operator holding the new target objects
     */
    public ModifiableGrowableOperator<T> removeAllIndexesNot(final int... indexes);
    
    
    /**
     * <p>
     * Remove all the null elements in the operator.
     * </p>
     * 
     * @return an operator holding the new target objects
     */
    public ModifiableGrowableOperator<T> removeAllNull();
    
}

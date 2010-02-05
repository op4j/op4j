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

import java.util.Collection;



/**
 * <p>
 * This interface contains methods for adding elements from a generic operator.
 * </p> 
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ModifiableGrowableOperator<T> {

    
    /**
     * <p>
     * Adds the specified element to the operator.
     * </p>
     * 
     * @param newElement the element to be added
     * @return an operator holding the new target objects
     */
    public ModifiableShrinkableOperator<T> add(final T newElement);
    
    
    /**
     * <p>
     * Adds all the specified elements to the operator.
     * </p>
     * 
     * @param newElement the elements to be added
     * @return an operator holding the new target objects
     */
    public ModifiableShrinkableOperator<T> addAll(final T... newElements);
    
    
    /**
     * <p>
     * Inserts a new element into the specified position (starting in 0) of the operator.
     * </p>
     * 
     * @param position the position in which the new element will be inserted (starting in 0)
     * @param newElement the element to be inserted
     * @return an operator holding the new target objects
     */
    public ModifiableShrinkableOperator<T> insert(final int position, final T newElement);
    
    
    /**
     * <p>
     * Inserts new elements into the specified position (starting in 0) of the operator.
     * </p>
     * 
     * @param position the position in which the new element will be inserted (starting in 0)
     * @param newElements the elements to be inserted
     * @return an operator holding the new target objects
     */
    public ModifiableShrinkableOperator<T> insertAll(final int position, final T... newElements);
    
    
    /**
     * <p>
     * Adds all the elements in the specified collection to the operator.
     * </p>
     * 
     * @param collection the collection containing the elements to be added
     * @return an operator holding the new target objects
     */
    public ModifiableShrinkableOperator<T> addAll(final Collection<T> collection);
    
    
}

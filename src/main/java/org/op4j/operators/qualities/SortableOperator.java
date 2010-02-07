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

import java.util.Comparator;



/**
 * <p>
 * This interface contains methods for sorting the elements of a structure.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface SortableOperator<T> {

    
    /**
     * <p>
     * Sorts the elements of the structure according to their <i>natural ordering</i>.
     * </p>
     * 
     * @return an operator containing the sorted structure as target object.
     */
    public SortableOperator<T> sort();
    
    
    /**
     * <p>
     * Sorts the elements of the structure according to the order induced by the specified comparator.
     * </p>
     * 
     * @param comparator the comparator to be used.
     * @return an operator containing the sorted structure as target object.
     */
    public SortableOperator<T> sort(final Comparator<? super T> comparator);

    
}

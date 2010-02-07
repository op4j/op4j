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

import org.javaruntype.type.Type;

/**
 * <p>
 * This interface contains methods for iterating arrays.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface NavigableArrayOperator<T>  {


    /**
     * <p>
     * Iterates the target array. After executing this method, any further operations
     * will be applied on each of the array elements until an "endFor()" method is called.
     * </p>
     * <p>
     * This method requires the type of the array elements to be specified.
     * </p>
     * 
     * @param elementType the type of the array elements.
     * @return an operator which will execute all operations on each element of the array.
     */
    public NavigatingArrayOperator<T> forEach(final Type<T> elementType);
	
}

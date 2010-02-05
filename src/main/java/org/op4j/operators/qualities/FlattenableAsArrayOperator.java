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
import org.op4j.operators.intf.array.Level0ArrayOperator;






/**
 * <p>
 * This interface defines methods for flattening "array of *" two-level structures into
 * simple array structures.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface FlattenableAsArrayOperator<T> {

    
    /**
     * <p>
     * Flattens an "array of *" two-level structure into a simple array, by creating
     * an array containing all the elements of the original second-level structures. 
     * </p>
     * 
     * @param type the type of the new array elements
     * @return an operator on the modified target object
     */
    public Level0ArrayOperator<T> flatten(final Type<T> type);
	
}

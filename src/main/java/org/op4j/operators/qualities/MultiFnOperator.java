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

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.Function;





/**
 * <p>
 * Base interface for operators holding more than one target at a time.
 * </p>
 * <p>
 * Multioperators will execute all operations on each of their target objects,
 * in the same way as an iterating list operator would.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface MultiFnOperator<I,T> extends MultiOperator<T> {
    
    /**
     * <p>
     * Returns the target objects as an array of the specified type. 
     * </p>
     * 
     * 
     * @param type the type of which the array of target objects will be created.
     * @return the array of target objects.
     */
    public Function<I,T[]> getAsArrayOf(final Type<T> type);
    
    /**
     * <p>
     * Returns the target objects as a list.
     * </p>
     * 
     * @return the list of target objects.
     */
    public Function<I,List<T>> getAsList(); 

    
}

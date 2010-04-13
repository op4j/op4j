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

package org.op4j.functions;


/**
 * <p>
 * Function execution context, contaning execution metadata.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecCtx {


    /**
     * <p>
     * If the execution of a function is performed during the iteration of an array,
     * list, map or set, this method will return the iteration index each time the
     * function is executed (the position of the element in the array, list... on which
     * the function is being executed). 
     * </p>
     * <p>
     * If execution is performed without iteration involved, this method will return null.
     * </p>
     * 
     * @return the iteration index during an iteration, null elsewhere.
     */
    public Integer getIndex();
    
    
}

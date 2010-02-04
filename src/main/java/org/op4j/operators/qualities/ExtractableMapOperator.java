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




/**
 * <p>
 * This interface defines methods for extracting keys (discarding values) or
 * values (discarding keys) in operators holding map target objects.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExtractableMapOperator<K,V> {

    
    /**
     * <p>
     * Extracts only the keys of the map (discarding values) and creates an operator
     * which will hold these keys as a target object of type Set.
     * </p>
     * 
     * @return an operator with the set of keys as a target object
     */
    public Operator extractKeys();
    
    
    /**
     * <p>
     * Extracts only the values of the map (discarding keys) and creates an operator
     * which will hold these values as a target object of type List.
     * </p>
     * 
     * @return an operator with the list of values as a target object
     */
    public Operator extractValues();
    
}

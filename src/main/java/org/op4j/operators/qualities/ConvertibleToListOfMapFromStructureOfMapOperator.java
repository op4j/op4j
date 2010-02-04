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

import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;


/**
 * <p>
 * This interface contains methods for conversions to list of array from
 * operators which already hold a "* of map" structure as target.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ConvertibleToListOfMapFromStructureOfMapOperator<K,V> {
    
    
    /**
     * <p>
     * Converts the current target into a list of map.
     * </p>
     * 
     * @return an operator holding the converted object as target.
     */
    public Level0ListOfMapOperator<K,V> toListOfMap();

}

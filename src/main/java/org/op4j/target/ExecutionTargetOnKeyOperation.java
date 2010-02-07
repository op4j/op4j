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

package org.op4j.target;

import java.util.Map;

import org.op4j.util.MapEntry;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ExecutionTargetOnKeyOperation implements ExecutionTargetOperation {

    private final int internalBlock;

    
    
    public ExecutionTargetOnKeyOperation(final int internalBlock) {
        super();
        this.internalBlock = internalBlock;
    }

    
    public Object execute(final Object target, final ExecutionTargetOperation[][] operations, final int[] indices) {
        
        if (target == null) {
            
            throw new IllegalStateException("Cannot perform onKey on null");
            
        } else if (target instanceof Map.Entry<?,?>){

            final Map.Entry<?,?> mapEntryTarget = (Map.Entry<?,?>)target;
            Object key = mapEntryTarget.getKey();
            Object value = mapEntryTarget.getValue();
            
            for (int j = 0, y = operations[this.internalBlock].length; j < y; j++) {
                key = operations[this.internalBlock][j].execute(key, operations, indices);
            }
            
            return new MapEntry<Object,Object>(key, value);
            
        } else {
            throw new IllegalStateException("Cannot perform onKey: object is not a map entry: " + target.getClass().getName());
        }
        
    }
    
}

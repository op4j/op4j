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


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ExecutionTargetSelectNullOperation implements ExecutionTargetOperation {

    private final int internalBlock;
    private final boolean desiredResult;

    
    
    public ExecutionTargetSelectNullOperation(final int internalBlock, final boolean desiredResult) {
        super();
        this.internalBlock = internalBlock;
        this.desiredResult = desiredResult;
    }
    
    
    
    public Object execute(final Object target, final ExecutionTargetOperation[][] operations, final int[] indexes) {

        if ((target == null) == this.desiredResult) {
            Object result = target;
            for (int j = 0, y = operations[this.internalBlock].length; j < y; j++) {
                result = operations[this.internalBlock][j].execute(result, operations, indexes);
            }
            return result;
        }
        return target;
        
    }
    
}

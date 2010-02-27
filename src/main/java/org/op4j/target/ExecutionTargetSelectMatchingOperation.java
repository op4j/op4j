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

package org.op4j.target;

import org.op4j.exceptions.ExecutionException;
import org.op4j.functions.IFunction;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ExecutionTargetSelectMatchingOperation implements ExecutionTargetOperation {

    private final int internalBlock;
    private final boolean desiredResult;
    private final IFunction<Object,Boolean> eval; 

    
    
    public ExecutionTargetSelectMatchingOperation(final int internalBlock, final boolean desiredResult, final IFunction<Object,Boolean> eval) {
        super();
        this.internalBlock = internalBlock;
        this.desiredResult = desiredResult;
        this.eval = eval;
    }
    
    
    
    public Object execute(final Object target, final ExecutionTargetOperation[][] operations, final int[] indexes) {

        Boolean evalResult = null;
        try {
            evalResult = this.eval.execute(target, new ExecCtxImpl(indexes)); 
        } catch (Exception e) {
            throw new ExecutionException(e);
        }
        
        if ((evalResult != null && evalResult.booleanValue()) == this.desiredResult) {
            
            Object result = target;
            for (int j = 0, y = operations[this.internalBlock].length; j < y; j++) {
                result = operations[this.internalBlock][j].execute(result, operations, indexes);
            }
            return result;
            
        }
            
        return target;
        
    }
    
}

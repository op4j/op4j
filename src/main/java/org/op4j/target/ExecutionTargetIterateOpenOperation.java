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

import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ExecutionTargetIterateOpenOperation implements ExecutionTargetOperation {

    private final int internalBlock;
    private final Structure structure;
    private final boolean excludeFirstIndex;

    
    
    public ExecutionTargetIterateOpenOperation(final int internalBlock, final Structure structure, final boolean excludeFirstIndex) {
        super();
        this.internalBlock = internalBlock;
        this.structure = structure;
        this.excludeFirstIndex = excludeFirstIndex;
    }

    
    public ExecutionTargetIterateClosedOperation close(final Class<?> arrayComponentClass) {
        return new ExecutionTargetIterateClosedOperation(this.internalBlock, this.structure, arrayComponentClass, this.excludeFirstIndex);
    }
    
    
    
    public Object execute(final Object target, final ExecutionTargetOperation[][] operations, final int[] indexes) {
        throw new IllegalStateException("Cannot execute while open");
    }
    
    
}

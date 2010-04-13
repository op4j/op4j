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

package org.op4j.functions;

import org.op4j.util.ValuePair;

/**
 * <p>
 * Base abstract implementation of {@link IFunction} aimed at reduction (folding) of arrays,
 * lists, maps or sets.
 * </p>
 * <p>
 * This function operates on a {@link ValuePair} so that it models a binary operator, with
 * both a <i>left</i> and a <i>right</i> sides, and produces a result.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class Reductor<A,B,R extends A> extends AbstractNotNullFunction<ValuePair<A,B>,R>{

    
    public Reductor() {
        super();
    }
    

    @Override
    public final R notNullExecute(final ValuePair<A,B> input, final ExecCtx ctx) throws Exception {
        return reduce(input.getLeft(), input.getRight(), ctx);
    }

    
    /**
     * <p>
     * Executes the reduction operation.
     * </p>
     * 
     * @param left the left side of the binary operation
     * @param right the right side of the binary operation
     * @param ctx the execution context
     * @return the function result
     * @throws Exception
     */
    protected abstract R reduce(final A left, final B right, final ExecCtx ctx) throws Exception;

}

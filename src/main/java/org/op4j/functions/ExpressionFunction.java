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

import org.op4j.target.Target;

/**
 * <p>
 * Base class for all functions returned by <tt>Fn.on(...)</tt> expressions. Should
 * never be used directly.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class ExpressionFunction<T,R> extends Function<T,R> {

    
    private final Target target;
    
    public ExpressionFunction(final Target target) {
        super();
        this.target = target;
    }
    
    @SuppressWarnings("unchecked")
    public R execute(final T input, final ExecCtx ctx) throws Exception {
        return (R) this.target.execute(input);
    }
    
}

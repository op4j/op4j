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

import org.op4j.exceptions.ExecutionException;
import org.op4j.target.Target;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Function<T,R> implements IFunction<T,R> {

    
    private final Target target;
    
    public Function(final Target target) {
        super();
        this.target = target;
    }
    
    public R execute(final T input, final ExecCtx ctx) throws Exception {
        return execute(input);
    }

    @SuppressWarnings("unchecked")
    public R execute(final T object) {
        try {
            return (R) this.target.execute(object);
        } catch (final ExecutionException e) {
            throw e;
        } catch (final Exception e) {
            throw new ExecutionException(e);
        }
    }
    
}

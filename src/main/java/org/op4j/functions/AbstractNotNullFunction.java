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
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class AbstractNotNullFunction<T, R> implements IFunction<T, R> {
    
    
    protected AbstractNotNullFunction() {
        super();
    }


    public final R execute(final T input, final ExecCtx ctx) throws Exception {
        if (input == null) {
            throw new IllegalArgumentException(
                    "Cannot execute function " + this.getClass().getName() + 
                    " on a null target.");
        }
        return notNullExecute(input, ctx);
    }


    protected abstract R notNullExecute(final T object, final ExecCtx ctx) throws Exception;
    
    
    
}

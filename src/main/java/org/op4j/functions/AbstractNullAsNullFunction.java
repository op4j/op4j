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
 * <p>
 * Base abstract class for functions returning null if the target object is null. 
 * </p>
 * <p>
 * This class can be extended by the user when creating his/her own
 * functions, if desired.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class AbstractNullAsNullFunction<T,R> extends Function<T,R> {
    
    
    protected AbstractNullAsNullFunction() {
        super();
    }


    public final R execute(final T input, final ExecCtx ctx) throws Exception {
        if (input == null) {
            return null;
        }
        return nullAsNullExecute(input, ctx);
    }


    /**
     * <p>
     * Executes the function knowing that the <tt>input</tt> parameter (the target
     * object) is not null. If the target object is null, the function will 
     * return null instead of calling this method.
     * </p>
     * 
     * @param input the target object
     * @param ctx the execution context
     * @return the result of the function executionO
     * @throws Exception
     */
    protected abstract R nullAsNullExecute(final T input, final ExecCtx ctx) throws Exception;
    
    
    
}

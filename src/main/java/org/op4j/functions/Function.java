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
import org.op4j.util.ExecCtxImpl;

/**
 * <p>
 * Base abstract implementation for the {@link IFunction} interface, 
 * providing a useful {@link #execute(Object)} method, easier to use 
 * than {@link IFunction#execute(Object, ExecCtx)}. 
 * </p>
 * <p>
 * You should consider extending this class for every function 
 * class you write (except for anonymous ones). This will allow you 
 * to execute the function without passing a context to the 
 * execution method and without having to enclose your call
 * inside a <tt>try...catch</tt> statement.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class Function<T,R> implements IFunction<T,R> {

    
    protected Function() {
        super();
    }


    /**
     * <p>
     * Executes the current function on the target object. The target
     * object is passed as the <tt>input</tt> parameter.
     * </p>
     * <p>
     * Should any exceptions raise during execution, they will be
     * encapsulated in an unchecked {@link ExecutionException} 
     * exception.
     * </p>
     * 
     * @param input the target object.
     * @return the result of executing the function
     */
    public R execute(final T input) {
        try {
            return execute(input, new ExecCtxImpl(null));
        } catch (final ExecutionException e) {
            throw e;
        } catch (final Exception e) {
            throw new ExecutionException(e);
        }
    }
    
}

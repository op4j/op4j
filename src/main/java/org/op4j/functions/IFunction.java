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
 * The interface that every <i>function</i> in op4j must implement. 
 * <tt>IFunction&lt;T,R&gt;</tt> means that the function receives an object of type
 * <tt>T</tt> (called <i>target</i>) and returns an object of type <tt>R</tt>.
 * </p>
 * <p>
 * This interface only defines one method: {@link #execute(Object, ExecCtx)},
 * which receives the target object on which the function will be executed
 * and an {@link ExecCtx} object containing some metadata about the
 * execution (for example, the index in an iteration).
 * </p>
 * <p>
 * When creating an implementation class, any function parameters should be 
 * arguments to the implementation's constructor.
 * </p>
 * <p>
 * Functions can be created anonymously:
 * </p>
 * <pre>
 * String result = 
 *   Op.on(value).exec(new IFunction<Integer,String>() {
 *       public String execute(Integer input, ExecCtx ctx) throws Exception {
 *          return "The input number is: " + input;
 *       }
 *   }).get();
 * </pre>
 * <p>
 * If you are creating a <i>function class</i> (instead of an anonymous implementation),
 * you should consider extending the {@link Function} abstract class, which
 * includes an easier-to-use {@link Function#execute(Object)} method for executing
 * the function outside an op4j expression (if needed).
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IFunction<T,R> {
    
    
    /**
     * <p>
     * Executes the function on the current target object, which is passed
     * as the <tt>input</tt> parameter. The {@link ExecCtx} parameter 
     * provides some metadata related to the execution, like the index in
     * an iteration.
     * </p>
     * <p>
     * The execution of a function can throw any exception.
     * </p>
     * <p> 
     * If you intend to call the <tt>execute</tt> method directly on any of 
     * your functions (outside an op4j expression), you might prefer using 
     * {@link Function#execute(Object)} instead.
     * </p>
     * 
     * @param input the target object on which the function is to be executed
     * @param ctx the context (metadata) for the function execution
     * @return the result of executing the function
     * @throws Exception 
     */
    public R execute(final T input, final ExecCtx ctx) throws Exception;

}

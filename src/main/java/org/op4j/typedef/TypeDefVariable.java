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
package org.op4j.typedef;

import java.io.Serializable;


/**
 * <p>
 * This interface represents type definition variables. These can be of one of two types (each
 * of them represented by one of this interface's implementing classes):
 * </p>
 * <ul>
 *   <li>Named (<tt>NamedTypeDefVariable</tt>): <tt>E</tt></li>
 *   <li>Bounded (<tt>BoundedTypeDefVariable</tt>): <tt>E extends T</tt></li>
 * </ul>
 * <p>
 * Some examples:
 * </p>
 * <ul>
 *   <li><tt>app.pack.ClassOne</tt> contains no <tt>TypeDefVariable</tt>s.</li>
 *   <li><tt>app.pack.ClassThree&lt;E, T&gt;</tt> contains two <tt>TypeDefVariable</tt>s:
 *       <ul>
 *         <li><tt>E</tt> (named)</li>
 *         <li><tt>T</tt> (named)</li>
 *       </ul> 
 *   </li>
 *   <li><tt>app.pack.ClassEight&lt;E, T, X extends E & java.util.Collection&lt;? extends T&gt;&gt;</tt> contains three <tt>TypeDefVariable</tt>s:
 *       <ul>
 *         <li><tt>E</tt> (named)</li>
 *         <li><tt>T</tt> (named)</li>
 *         <li><tt>X extends E & java.util.Collection&lt;? extends T&gt;</tt> (bounded)</li>
 *       </ul> 
 *   </li>
 * </ul>
 * 
 * <p>
 * As can be seen above, <i>every</i> type definition variable has, at least, a <b>name</b>: <tt>E</tt> ,<tt>T</tt> and <tt>X</tt>
 * in the above examples. Also, it can be noted that bounded variables can create relations among variables, like in 
 * <tt>X extends E</tt>.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface TypeDefVariable extends Serializable {
    
    /**
     * Returns the variable name.
     * 
     * @return the variable name.
     */
    public String getVariableName();
    
}

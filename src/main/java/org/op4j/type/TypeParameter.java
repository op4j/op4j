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
package org.op4j.type;

import java.io.Serializable;

/**
 * <p>
 * Abstract class that represents a type parameter in a {@link Type} object.
 * </p>
 * <p>
 * <tt>TypeParameter</tt> objects, depending on its specific subclass, can represent:
 * </p>
 * <ul>
 *   <li>List&lt;<b>?</b>&gt; ({@link WildcardTypeParameter})
 *   <li>List&lt;<b>String</b>&gt; or List&lt;<b>List&lt;String&gt;</b>&gt; ({@link StandardTypeParameter})
 *   <li>List&lt;<b>? extends Number</b>&gt; ({@link ExtendsTypeParameter})
 *   <li>List&lt;<b>? super Integer</b>&gt; ({@link SuperTypeParameter})
 * </ul>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class TypeParameter implements Serializable {

    
	private static final long serialVersionUID = 1666015437003002214L;


	/**
	 * <p>
	 * Returns the type contained in the parameter. It will raise an exception
	 * for wildcard type parameters (<tt>?</tt>).
	 * </p>
	 * 
	 * @return the type contained in the parameter.
	 */
	public abstract Type getType();
    
    abstract boolean isAssignableFrom(final TypeParameter typeParameter);  
    
    
    TypeParameter() {
        super();
    }
    
}

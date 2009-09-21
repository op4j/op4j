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

import java.io.ObjectStreamException;

/**
 * <p>
 * Represents a type parameter which only contains a wildcard.
 * </p>
 * <p>
 * For example, the type <tt>List&lt;?;&gt;,
 * would have a <tt>WildcardTypeParameter</tt>
 * containing the <tt>?</tt> parameter.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class WildcardTypeParameter extends TypeParameter {

    private static final long serialVersionUID = 9058744867380964414L;

    static final WildcardTypeParameter WILDCARD = new WildcardTypeParameter();
    
    private static final String stringRepresentation = "?";
    
    private static final int hashCode = stringRepresentation.hashCode();
    
    
    private WildcardTypeParameter() {
        super();
    }


    @Override
    public Type getType() {
        throw new IllegalStateException("No type in wildcards");
    }


    
    @Override
    boolean isAssignableFrom(final TypeParameter typeParameter) {
        return true;
    }


    @Override
    public int hashCode() {
        return hashCode;
    }


    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return (getClass() != obj.getClass());
    }


    @Override
    public String toString() {
        return stringRepresentation;
    }
    
    
    @SuppressWarnings("unused")
    private Object readResolve() throws ObjectStreamException {
        return WILDCARD;
    }
    
}

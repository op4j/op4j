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
package org.op4j.typescheme;

import java.io.Serializable;

import org.op4j.type.Type;

/**
 * <p>
 * A <tt>TypeSchemeComponent</tt> is each of the components in a
 * {@link TypeScheme}. It can be of one of two types (exclusively):
 * </p>
 * <ul>
 *  <li>A type (an object of {@link Type}</li>
 *  <li>A literal (a String like <tt>'COMMAND'</tt>, surrounded by
 *      single inverted commas)</li>
 * </ul>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class TypeSchemeComponent implements Serializable {

    private static final long serialVersionUID = 8194019859263856470L;
    
    private final Type type;
    private final String literal;

    private final String stringRepresentation;
    private final int hashCode; 

    
    TypeSchemeComponent(final Type type) {
        super();
        this.type = type;
        this.literal = null;
        this.stringRepresentation = 
            TypeSchemeUtil.createTypeComponentStringRepresentation(type);
        this.hashCode = this.stringRepresentation.hashCode();
    }
    
    TypeSchemeComponent(final String literal) {
        super();
        this.type = null;
        this.literal = literal;
        this.stringRepresentation = 
            TypeSchemeUtil.createLiteralComponentStringRepresentation(literal);
        this.hashCode = this.stringRepresentation.hashCode();
    }

    
    
    /**
     * <p>
     * Returns the {@link Type} associated to this component, or null
     * if the component contains a literal.
     * </p>
     * 
     * @return the type
     */
    public Type getType() {
        return this.type;
    }
    

    /**
     * <p>
     * Returns the literal (a <tt>String</tt>) associated to this component,
     * or null if the component contains a type.
     * </p>
     * 
     * @return the literal
     */
    public String getLiteral() {
        return this.literal;
    }
    
    
    /**
     * <p>
     * Returns whether the component is contains a literal (<tt>true</tt>)
     * or a type (<tt>false</tt>).
     * </p>
     * 
     * @return <tt>true</tt> for literal, <tt>false</tt> for type
     */
    public boolean isLiteral() {
        return (this.literal != null);
    }


    @Override
    public String toString() {
        return this.stringRepresentation;
    }

    
    @Override
    public int hashCode() {
        return this.hashCode;
    }

    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TypeSchemeComponent other = (TypeSchemeComponent) obj;
        return this.stringRepresentation.equals(other.stringRepresentation);
    }
    
}


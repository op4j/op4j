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

/**
 * <p>
 * Represents an inner type definition variable containing a variable name.
 * </p>
 * <p>
 * For example: <tt>X extends <b>T</b></tt>.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class InnerNamedTypeDefVariable implements InnerTypeDefVariable {
    
    private static final long serialVersionUID = -1687200742438119530L;
    
    private final String variableName;
    private final int arrayDimensions;
    
    private final String stringRepresentation;
    
    private final int hashCode;
    

    private static String createStringRepresentation(
            final String variableName, final int arrayDimensions) {
        final StringBuilder str = new StringBuilder();
        str.append(variableName);
        for (int i = 0; i < arrayDimensions; i++) {
            str.append("[]");
        }
        return str.toString();
    }

    
    InnerNamedTypeDefVariable(final String variableName, final int arrayDimensions) {
        this.variableName = variableName;
        this.arrayDimensions = arrayDimensions;
        this.stringRepresentation = 
            createStringRepresentation(variableName, arrayDimensions);
        this.hashCode = this.stringRepresentation.hashCode();
    }


    /**
     * <p>
     * Returns the component class
     * </p>
     * 
     * @return the component class
     */
    public String getVariableName() {
        return this.variableName;
    }
    
    
    /**
     * <p>
     * Returns the number of array dimensions applied to the component class.
     * </p>
     * 
     * @return the array dimensions.
     */
    public int getArrayDimensions() {
        return this.arrayDimensions;
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
        final InnerNamedTypeDefVariable other = (InnerNamedTypeDefVariable) obj;
        return this.stringRepresentation.equals(other.stringRepresentation);
    }


    @Override
    public String toString() {
        return this.stringRepresentation;
    }

    
}

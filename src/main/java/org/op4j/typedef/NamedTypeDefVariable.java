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
 * Represents a type definition variable that only specifies a variable name (without bounds).
 * </p>
 * 
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class NamedTypeDefVariable implements TypeDefVariable {
    
    private static final long serialVersionUID = 2342239160968747663L;
    
    private final String variableName;

    
    NamedTypeDefVariable(final String name) {
        this.variableName = name;
    }


    public String getVariableName() {
        return this.variableName;
    }


    @Override
    public int hashCode() {
        return this.variableName.hashCode();
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
        final NamedTypeDefVariable other = (NamedTypeDefVariable) obj;
        return this.variableName.equals(other.variableName);
    }


    @Override
    public String toString() {
        return this.variableName;
    }

    
}

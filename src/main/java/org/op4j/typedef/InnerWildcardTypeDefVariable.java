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

import org.apache.commons.lang.Validate;

/**
 * <p>
 * Represents an inner type definition variable containing a wildcard or bounded wildcard type.
 * </p>
 * <p>
 * For example: <tt>X extends List&lt;<b>? extends Integer</b>&gt;</tt>.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class InnerWildcardTypeDefVariable implements InnerTypeDefVariable {

    private static final long serialVersionUID = -8238722236323950838L;
    
    private final InnerTypeDefVariable upperBound;
    private final InnerTypeDefVariable lowerBound;
    
    private final String stringRepresentation;
    
    private final int hashCode;
    

    private static String createStringRepresentation(
            final InnerTypeDefVariable upperBound, final InnerTypeDefVariable lowerBound) {
        final StringBuilder str = new StringBuilder();
        str.append("?");
        if (upperBound != null) {
            str.append(" extends ");
            str.append(upperBound.toString());
        } else if (lowerBound != null) {
            str.append(" super ");
            str.append(lowerBound.toString());
        } else {
            return str.toString();
        }
        return str.toString();
    }

    
    InnerWildcardTypeDefVariable(final InnerTypeDefVariable upperBound, 
            final InnerTypeDefVariable lowerBound) {
        super();
        // Cannot have lower and upper bound at a time
        Validate.isTrue(!(upperBound != null) && (lowerBound != null));
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.stringRepresentation = 
            createStringRepresentation(upperBound, lowerBound);
        this.hashCode = this.stringRepresentation.hashCode();
    }


    /**
     * <p>
     * Returns whether the variable establishes an upper bound (with an <tt>extends</tt> clause).
     * </p>
     * 
     * @return whether the variable establishes an upper bound
     */
    public boolean hasUpperBound() {
        return (this.upperBound != null);
    }

    
    /**
     * <p>
     * Returns the variable upper bound (defined with an <tt>extends</tt> clause), if any.
     * </p>
     * 
     * @return the upper bound
     */
    public InnerTypeDefVariable getUpperBound() {
        return this.upperBound;
    }

    
    /**
     * <p>
     * Returns whether the variable establishes a lower bound (with a <tt>super</tt> clause).
     * </p>
     * 
     * @return whether the variable establishes a lower bound
     */
    public boolean hasLowerBound() {
        return (this.lowerBound != null);
    }

    
    /**
     * <p>
     * Returns the variable upper bound (defined with an <tt>extends</tt> clause), if any.
     * </p>
     * 
     * @return the upper bound
     */
    public InnerTypeDefVariable getLowerBound() {
        return this.lowerBound;
    }

    
    /**
     * <p>
     * Returns true only if there is neither an upper nor a lower bound, false otherwise.
     * </p>
     * 
     * @return whether there are bounds
     */
    public boolean isUnbound() {
        return ((this.upperBound == null) && (this.lowerBound == null));
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
        final InnerWildcardTypeDefVariable other = (InnerWildcardTypeDefVariable) obj;
        return this.stringRepresentation.equals(other.stringRepresentation);
    }


    @Override
    public String toString() {
        return this.stringRepresentation;
    }

    
    
}

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

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.Validate;
import org.op4j.objectscheme.ObjectScheme;
import org.op4j.type.Type;


/**
 * <p>
 * A <tt>TypeScheme</tt> represents a sequence of components each of which can 
 * be either a <tt>Type</tt> (<tt>java.lang.String</tt>, <tt>java.util.List&lt;java.lang.Integer&gt;</tt>...) or 
 * a literal (<tt>'DECIMAL_POINT_IS_COMMA'</tt>, <tt>'ACTIVE'</tt>...). 
 * </p>
 * <p>
 * A TypeScheme is represented by its components, separated by commas. Some examples:
 * </p>
 * <ul>
 *   <li><tt>java.lang.String</tt></li>
 *   <li><tt>java.lang.Boolean,java.util.List&lt;java.lang.Integer&gt;</tt></li>
 *   <li><tt>java.lang.Byte,'ACTIVE',java.util.Map&lt;java.lang.String,java.util.Set&lt;java.lang.Long&gt;&gt;</tt></li>
 * </ul>
 * <p>
 * Objects of this class are never created directly. To obtain a <tt>TypeScheme</tt> object,
 * the diverse methods in the {@link TypeSchemes} class should be used.
 * </p>
 * <p>
 * Objects of this class are <b>immutable</b>, and thus <b>thread-safe</b>. Also, in order
 * to avoid excessive memory usage, an internal synchronized cache exists which 
 * prevents the same <tt>TypeScheme</tt> from being instantiated more than once (so, if two 
 * TypeScheme objects are equal, this will mean that they are the same object).
 * </p>
 * 
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class TypeScheme implements Serializable {

    private static final long serialVersionUID = 7052101410008221541L;
    
    private final String name;
    private final TypeSchemeComponent[] typeSchemeComponents;

    // Class is immutable, so hashCode and hasLiterals can be precomputed
    private final boolean hasLiterals;
    private final int hashCode;
    
    
    
    
    TypeScheme(final TypeSchemeComponent[] typeSchemeComponents) {
        
        super();
        
        this.typeSchemeComponents = 
            (TypeSchemeComponent[]) ArrayUtils.clone(typeSchemeComponents);
        this.name = TypeSchemeUtil.createName(this.typeSchemeComponents);
        this.hashCode = this.name.hashCode();
        boolean hasLiteralsComputation = false;
        for (TypeSchemeComponent typeSchemeComponent : this.typeSchemeComponents) {
            hasLiteralsComputation |= typeSchemeComponent.isLiteral();
        }
        this.hasLiterals = hasLiteralsComputation;
        
    }

    
    TypeSchemeComponent[] getTypeSchemeComponentsArray() {
        return this.typeSchemeComponents;
    }

    
    /**
     * <p>
     * Returns the components of the TypeScheme.
     * </p>
     * 
     * @return the type scheme components
     */
    public List<TypeSchemeComponent> getTypeSchemeComponents() {
        return Collections.unmodifiableList(Arrays.asList(this.typeSchemeComponents));
    }

    
    /**
     * <p>
     * Returns the name of the TypeScheme. For example: "java.lang.Integer,'ACTION'".
     * </p>
     * 
     * @return the type scheme name.b
     */
    public String getName() {
        return this.name;
    }
    
    
    /**
     * <p>
     * Returns whether the type scheme includes literals (like <tt>'ACTION'</tt>).
     * </p>
     * 
     * @return whether the type scheme includes literals
     */
    public boolean hasLiterals() {
        return this.hasLiterals;
    }
    
    
    /**
     * <p>
     * Returns the number of components of this type scheme (both types and literals).
     * </p>
     * 
     * @return the number of components
     */
    public int getComponentCount() {
        return this.typeSchemeComponents.length;
    }
    
    
    /**
     * <p>
     * Returns the type contained by the component in the selected position (if it exists).
     * It will return <tt>null</tt> if the position contains a literal instead of a type,
     * and it will raise an exception if an invalid position is asked.
     * </p>
     * 
     * @param index the position which type is desired
     * @return the type, or null if position is a literal
     */
    public Type getType(final int index) {
        Validate.isTrue(index < this.typeSchemeComponents.length, 
                "Asked for type in position " + index + " of type scheme " + 
                this.name + ", which does not exist");
        return this.typeSchemeComponents[index].getType();
    }
    
    
    /**
     * <p>
     * Returns true if the type scheme is empty (no components).
     * </p>
     * 
     * @return true if the type scheme is empty, false if not.
     */
    public boolean isEmpty() {
        return getComponentCount() <= 0;
    }
    
    
    /**
     * <p>
     * Returns <tt>true</tt> if the type scheme is assignable from the
     * type scheme passed as a parameter.
     * </p>
     * <p>
     * Assignability is computed in the following terms: a type scheme A is considered
     * to be <i>assignable</i> from another type scheme B if a method receiving
     * a set of parameters conforming to type scheme A can be called with a set of objects 
     * conforming to type scheme B as a parameter.
     * </p>
     * 
     * @param typeScheme the type schema against which assignability will be checked
     * @return whether the type is assignable or not
     */
    public boolean isAssignableFrom(final TypeScheme typeScheme) {
        Validate.notNull(typeScheme, "Type scheme cannot be null");
        return TypeSchemeUtil.isAssignableFrom(this, typeScheme);
    }
    
    
    /**
     * <p>
     * Returns <tt>true</tt> if the type scheme is assignable from the
     * object scheme passed as a parameter.
     * </p>
     * <p>
     * Assignability is computed in the following terms: a type scheme A is considered
     * to be <i>assignable</i> from another type scheme B if a method receiving
     * a set of parameters conforming to type scheme A can be called with a set of objects 
     * conforming to object scheme B as a parameter.
     * </p>
     * 
     * @param objectScheme
     * @return whether the type scheme is assignable or not
     */
    public boolean isAssignableFrom(final ObjectScheme objectScheme) {
        Validate.notNull(objectScheme, "Object scheme cannot be null");
        return TypeSchemeUtil.isAssignableFrom(this, objectScheme);
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
        final TypeScheme other = (TypeScheme) obj;
        // Comparing name will be enough and quicker than other comparisons
        return this.name.equals(other.name);
    }


    @Override
    public String toString() {
        return this.name;
    }
    
    
    
    @SuppressWarnings("unused")
    private Object readResolve() throws ObjectStreamException {
        TypeSchemeRegistry typeSchemeRegistry = TypeSchemeRegistry.getInstance();
        return typeSchemeRegistry.forComponents(this.typeSchemeComponents);
    }
    
    
}

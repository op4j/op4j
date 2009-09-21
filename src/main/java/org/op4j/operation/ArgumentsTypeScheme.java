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
package org.op4j.operation;

import org.apache.commons.lang.Validate;
import org.op4j.typescheme.TypeScheme;

/**
 * <p>
 * This class represents a complete input for an operation. This includes:
 * </p>
 * <ul>
 *   <li>A name</li>
 *   <li>A description</li>
 *   <li>A type scheme for the operation's targets</li>
 *   <li>A type scheme for the operation's parameters</li>
 * </ul>
 * <p>
 * Every operation implementation {@link OperationImpl} defines a set of
 * <tt>ArgumentTypeScheme</tt>s which correspond to the different signatures
 * with which the operation implementation can be executed.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class ArgumentsTypeScheme {

    private final TypeScheme targetTypeScheme;
    private final TypeScheme parameterTypeScheme;
    private final String description;
    private final String name;
    

    /**
     * <p>
     * Creates a new instance of <tt>ArgumentsTypeScheme</tt>. This should only be
     * used from within custom developed operation implementations 
     * ({@link OperationImpl} subclasses), in order to register the type schemes
     * available to call that operation implementation. 
     * </p>
     * 
     * @param targetTypeScheme the target type scheme
     * @param parameterTypeScheme the parameter type scheme
     * @param description a description for the argument type scheme
     */
    public ArgumentsTypeScheme(final TypeScheme targetTypeScheme, 
            final TypeScheme parameterTypeScheme, final String description) {
        
        super();
        
        Validate.notNull(targetTypeScheme, "Target type Scheme cannot be null");
        Validate.isTrue(targetTypeScheme.getComponentCount() > 0, "Target type Scheme cannot be empty");
        Validate.notNull(parameterTypeScheme, "Parameter type Scheme cannot be null");
        Validate.notEmpty(description, "Description cannot be empty");
        
        ArgumentsTypeSchemeUtil.checkTargetComponents(targetTypeScheme);
        
        this.targetTypeScheme = targetTypeScheme;
        this.parameterTypeScheme = parameterTypeScheme;
        this.description = description;
        this.name = ArgumentsTypeSchemeUtil.createName(this.targetTypeScheme, this.parameterTypeScheme);
        
    }
    

    /**
     * <p>
     * Returns the target type scheme.
     * </p>
     * 
     * @return the target type scheme.
     */
    public TypeScheme getTargetTypeScheme() {
        return this.targetTypeScheme;
    }

    
    /**
     * <p>
     * Returns the parameter type scheme.
     * </p>
     * 
     * @return the parameter type scheme.
     */
    public TypeScheme getParameterTypeScheme() {
        return this.parameterTypeScheme;
    }


    /**
     * <p>
     * Returns the description of the arguments type scheme.
     * </p>
     * 
     * @return the description.
     */
    public String getDescription() {
        return this.description;
    }
    
    
    /**
     * <p>
     * Checks whether an {@link Arguments} object passed as a parameter
     * matches the arguments type scheme.
     * </p>
     * 
     * @param arguments the arguments object which will be checked.
     * @return <tt>true</tt> if it matches, <tt>false</tt> if not.
     */
    public boolean matches(final Arguments arguments) {
        Validate.notNull(arguments, "Arguments cannot be null");
        return (this.targetTypeScheme.isAssignableFrom(arguments.getTargetScheme())) &&
            (this.parameterTypeScheme.isAssignableFrom(arguments.getParameterScheme()));
    }
    


    @Override
    public int hashCode() {
        return this.name.hashCode();
    }


    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ArgumentsTypeScheme other = (ArgumentsTypeScheme) obj;
        return this.name.equals(other.name); 
    }


    @Override
    public String toString() {
        return this.name;
    }
    
    
}

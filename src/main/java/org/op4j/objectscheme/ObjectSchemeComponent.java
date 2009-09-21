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
package org.op4j.objectscheme;

import org.op4j.operation.CastParam;
import org.op4j.type.Type;

/**
 * <p>
 * This class represents a component in an object scheme. It contains both
 * the object itself and the inferred (or specified via {@link CastParam}) type. 
 * </p>
 * <p>
 * <b><tt>ObjectSchemeComponent</tt> objects should never be instantiated or used directly.</b> 
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class ObjectSchemeComponent {

    private final Type type;
    private final Object object;
    
    
    ObjectSchemeComponent(final Type type, final Object object) {
        this.type = type;
        this.object = object;
    }

    
    /**
     * <p>
     * Returns the type of the component.
     * </p>
     * 
     * @return the type
     */
    public Type getType() {
        return this.type;
    }


    /**
     * <p>
     * Returns the object of the component.
     * </p>
     * 
     * @return the object
     */
    public Object getObject() {
        return this.object;
    }
    
    
    /**
     * <p>
     * Returns the string representation of the component. This will be
     * equivalent to the name of the associated type.
     * </p>
     * 
     * @return the string representation of the component
     */
    public String getStringRepresentation() {
        /*
         * This is not cached in a "name" attribute as it is not as used as TypeScheme's
         * (which works as an index for the registry)
         */
        return ObjectSchemeUtil.createComponentStringRepresentation(this);
    }
    

    @Override
    public String toString() {
        return getStringRepresentation();
    }
    
}

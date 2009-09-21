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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.op4j.operation.CastParam;


/**
 * <p>
 * An <tt>ObjectScheme</tt> represents a list of objects with its intended types.
 * These types are either inferred from the objects themselves (retrieving its classes
 * in runtime) or got from their enclosing {@link CastParam} object if such 
 * enclosing objects are specified instead of the objects themselves.
 * </p>
 * <p>
 * <b><tt>ObjectScheme</tt> objects should never be instantiated or used directly.</b> 
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class ObjectScheme {

    
    private final ObjectSchemeComponent[] objectSchemeComponents;

    
    ObjectScheme(final ObjectSchemeComponent[] typeSchemeComponents) {
        super();
        this.objectSchemeComponents = typeSchemeComponents;
    }

    
    /**
     * <p>
     * Returns the components as an array.
     * </p>
     * 
     * @return the components
     */
    public ObjectSchemeComponent[] getObjectSchemeComponentsArray() {
        return (ObjectSchemeComponent[]) ArrayUtils.clone(this.objectSchemeComponents);
    }
    
    /**
     * <p>
     * Returns the components as a list.
     * </p>
     * 
     * @return the components
     */
    public List<ObjectSchemeComponent> getObjectSchemeComponents() {
        return Collections.unmodifiableList(Arrays.asList(this.objectSchemeComponents));
    }
    
    
    /**
     * <p>
     * Returns this object scheme's string representation.
     * </p>
     * 
     * @return the object scheme's string representation.
     */
    public String getStringRepresentation() {
        /*
         * This is not cached in a "name" attribute as it is not as used as TypeScheme's
         * (which works as an index for the registry)
         */
        return ObjectSchemeUtil.createStringRepresentation(this.objectSchemeComponents);
    }

    @Override
    public String toString() {
        return getStringRepresentation();
    }
    
}
